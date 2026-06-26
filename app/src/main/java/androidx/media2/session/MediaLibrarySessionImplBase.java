package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionImplBase;
import c.a.a.a.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class MediaLibrarySessionImplBase extends MediaSessionImplBase implements MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl {

    @GuardedBy("mLock")
    private final ArrayMap<MediaSession.ControllerCb, Set<String>> mSubscriptions;

    public MediaLibrarySessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        super(mediaSession, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
        this.mSubscriptions = new ArrayMap<>();
    }

    private LibraryResult ensureNonNullResult(LibraryResult libraryResult) {
        if (libraryResult != null) {
            return libraryResult;
        }
        throw new RuntimeException("LibraryResult shouldn't be null");
    }

    private LibraryResult ensureNonNullResultWithValidItem(LibraryResult libraryResult) {
        LibraryResult libraryResultEnsureNonNullResult = ensureNonNullResult(libraryResult);
        return (libraryResultEnsureNonNullResult.getResultCode() != 0 || isValidItem(libraryResultEnsureNonNullResult.getMediaItem())) ? libraryResultEnsureNonNullResult : new LibraryResult(-1);
    }

    private LibraryResult ensureNonNullResultWithValidList(LibraryResult libraryResult, int i2) {
        LibraryResult libraryResultEnsureNonNullResult = ensureNonNullResult(libraryResult);
        if (libraryResultEnsureNonNullResult.getResultCode() == 0) {
            List<MediaItem> mediaItems = libraryResultEnsureNonNullResult.getMediaItems();
            if (mediaItems == null) {
                throw new RuntimeException("List shouldn't be null for the success");
            }
            if (mediaItems.size() > i2) {
                StringBuilder sbR = a.r("List shouldn't contain items more than pageSize, size=");
                sbR.append(libraryResultEnsureNonNullResult.getMediaItems().size());
                sbR.append(", pageSize");
                sbR.append(i2);
                throw new RuntimeException(sbR.toString());
            }
            Iterator<MediaItem> it = mediaItems.iterator();
            while (it.hasNext()) {
                if (!isValidItem(it.next())) {
                    return new LibraryResult(-1);
                }
            }
        }
        return libraryResultEnsureNonNullResult;
    }

    private boolean isValidItem(MediaItem mediaItem) {
        if (mediaItem == null) {
            throw new RuntimeException("Item shouldn't be null for the success");
        }
        if (TextUtils.isEmpty(mediaItem.getMediaId())) {
            throw new RuntimeException("Media ID of an item shouldn't be empty for the success");
        }
        MediaMetadata metadata = mediaItem.getMetadata();
        if (metadata == null) {
            throw new RuntimeException("Metadata of an item shouldn't be null for the success");
        }
        if (!metadata.containsKey(MediaMetadata.METADATA_KEY_BROWSABLE)) {
            throw new RuntimeException("METADATA_KEY_BROWSABLE should be specified in metadata of an item");
        }
        if (metadata.containsKey(MediaMetadata.METADATA_KEY_PLAYABLE)) {
            return true;
        }
        throw new RuntimeException("METADATA_KEY_PLAYABLE should be specified in metadata of an item");
    }

    @Override // androidx.media2.session.MediaSessionImplBase
    public MediaBrowserServiceCompat createLegacyBrowserServiceLocked(Context context, SessionToken sessionToken, MediaSessionCompat.Token token) {
        return new MediaLibraryServiceLegacyStub(context, this, token);
    }

    @Override // androidx.media2.session.MediaSessionImplBase
    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull MediaSessionImplBase.RemoteControllerTask remoteControllerTask) {
        super.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            try {
                remoteControllerTask.run(legacyBrowserService.getBrowserLegacyCbForBroadcast(), 0);
            } catch (RemoteException unused) {
            }
        }
    }

    public void dumpSubscription() {
        if (MediaSessionImplBase.DEBUG) {
            synchronized (this.mLock) {
                this.mSubscriptions.size();
                for (int i2 = 0; i2 < this.mSubscriptions.size(); i2++) {
                    String str = "  controller " + this.mSubscriptions.valueAt(i2);
                    for (String str2 : this.mSubscriptions.valueAt(i2)) {
                    }
                }
            }
        }
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        List<MediaSession.ControllerInfo> connectedControllers = super.getConnectedControllers();
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            connectedControllers.addAll(legacyBrowserService.getConnectedControllersManager().getConnectedControllers());
        }
        return connectedControllers;
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isConnected(@NonNull MediaSession.ControllerInfo controllerInfo) {
        if (super.isConnected(controllerInfo)) {
            return true;
        }
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            return legacyBrowserService.getConnectedControllersManager().isConnected(controllerInfo);
        }
        return false;
    }

    public boolean isSubscribed(MediaSession.ControllerCb controllerCb, String str) {
        synchronized (this.mLock) {
            Set<String> set = this.mSubscriptions.get(controllerCb);
            if (set != null && set.contains(str)) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifyChildrenChanged(@NonNull final String str, final int i2, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(new MediaSessionImplBase.RemoteControllerTask() { // from class: androidx.media2.session.MediaLibrarySessionImplBase.1
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i3) {
                if (MediaLibrarySessionImplBase.this.isSubscribed(controllerCb, str)) {
                    controllerCb.onChildrenChanged(i3, str, i2, libraryParams);
                }
            }
        });
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifySearchResultChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull final String str, final int i2, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImplBase.RemoteControllerTask() { // from class: androidx.media2.session.MediaLibrarySessionImplBase.3
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i3) {
                controllerCb.onSearchResultChanged(i3, str, i2, libraryParams);
            }
        });
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetChildrenOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i2, int i3, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidList(getCallback().onGetChildren(getInstance(), controllerInfo, str, i2, i3, libraryParams), i3);
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetItemOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
        return ensureNonNullResultWithValidItem(getCallback().onGetItem(getInstance(), controllerInfo, str));
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetLibraryRootOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidItem(getCallback().onGetLibraryRoot(getInstance(), controllerInfo, libraryParams));
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetSearchResultOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i2, int i3, MediaLibraryService.LibraryParams libraryParams) {
        return ensureNonNullResultWithValidList(getCallback().onGetSearchResult(getInstance(), controllerInfo, str, i2, i3, libraryParams), i3);
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onSearchOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, MediaLibraryService.LibraryParams libraryParams) {
        return getCallback().onSearch(getInstance(), controllerInfo, str, libraryParams);
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onSubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, MediaLibraryService.LibraryParams libraryParams) {
        synchronized (this.mLock) {
            Set<String> hashSet = this.mSubscriptions.get(controllerInfo.getControllerCb());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mSubscriptions.put(controllerInfo.getControllerCb(), hashSet);
            }
            hashSet.add(str);
        }
        int iOnSubscribe = getCallback().onSubscribe(getInstance(), controllerInfo, str, libraryParams);
        if (iOnSubscribe != 0) {
            synchronized (this.mLock) {
                this.mSubscriptions.remove(controllerInfo.getControllerCb());
            }
        }
        return iOnSubscribe;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onUnsubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
        int iOnUnsubscribe = getCallback().onUnsubscribe(getInstance(), controllerInfo, str);
        synchronized (this.mLock) {
            this.mSubscriptions.remove(controllerInfo.getControllerCb());
        }
        return iOnUnsubscribe;
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback getCallback() {
        return (MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback) super.getCallback();
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public MediaLibraryService.MediaLibrarySession getInstance() {
        return (MediaLibraryService.MediaLibrarySession) super.getInstance();
    }

    @Override // androidx.media2.session.MediaSessionImplBase
    public MediaLibraryServiceLegacyStub getLegacyBrowserService() {
        return (MediaLibraryServiceLegacyStub) super.getLegacyBrowserService();
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifyChildrenChanged(@NonNull final MediaSession.ControllerInfo controllerInfo, @NonNull final String str, final int i2, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImplBase.RemoteControllerTask() { // from class: androidx.media2.session.MediaLibrarySessionImplBase.2
            @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
            public void run(MediaSession.ControllerCb controllerCb, int i3) {
                if (MediaLibrarySessionImplBase.this.isSubscribed(controllerCb, str)) {
                    controllerCb.onChildrenChanged(i3, str, i2, libraryParams);
                    return;
                }
                if (MediaSessionImplBase.DEBUG) {
                    StringBuilder sbR = a.r("Skipping notifyChildrenChanged() to ");
                    sbR.append(controllerInfo);
                    sbR.append(" because it hasn't subscribed");
                    sbR.toString();
                    MediaLibrarySessionImplBase.this.dumpSubscription();
                }
            }
        });
    }
}
