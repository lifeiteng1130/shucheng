package androidx.media2.session;

import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaLibraryServiceLegacyStub extends MediaSessionServiceLegacyStub {
    private static final boolean DEBUG = false;
    private static final String TAG = "MLS2LegacyStub";
    private final MediaSession.ControllerCb mBrowserLegacyCbForBroadcast;
    public final MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl mLibrarySessionImpl;

    public static abstract class BaseBrowserLegacyCb extends MediaSession.ControllerCb {
        private BaseBrowserLegacyCb() {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onAllowedCommandsChanged(int i2, @NonNull SessionCommandGroup sessionCommandGroup) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onBufferingStateChanged(int i2, @NonNull MediaItem mediaItem, int i3, long j2, long j3, long j4) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onCurrentMediaItemChanged(int i2, MediaItem mediaItem, int i3, int i4, int i5) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onDisconnected(int i2) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i2, LibraryResult libraryResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackCompleted(int i2) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackInfoChanged(int i2, @NonNull MediaController.PlaybackInfo playbackInfo) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackSpeedChanged(int i2, long j2, long j3, float f2) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i2, SessionPlayer.PlayerResult playerResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlayerStateChanged(int i2, long j2, long j3, int i3) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaylistChanged(int i2, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i3, int i4, int i5) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaylistMetadataChanged(int i2, MediaMetadata mediaMetadata) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onRepeatModeChanged(int i2, int i3, int i4, int i5, int i6) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onSeekCompleted(int i2, long j2, long j3, long j4) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i2, SessionResult sessionResult) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onShuffleModeChanged(int i2, int i3, int i4, int i5, int i6) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onSubtitleData(int i2, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onTrackDeselected(int i2, SessionPlayer.TrackInfo trackInfo) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onTrackSelected(int i2, SessionPlayer.TrackInfo trackInfo) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i2, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i2, @NonNull VideoSize videoSize) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void sendCustomCommand(int i2, @NonNull SessionCommand sessionCommand, Bundle bundle) {
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void setCustomLayout(int i2, @NonNull List<MediaSession.CommandButton> list) {
        }
    }

    public final class BrowserLegacyCb extends BaseBrowserLegacyCb {
        private final Object mLock;
        private final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        @GuardedBy("mLock")
        private final List<SearchRequest> mSearchRequests;

        public BrowserLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            super();
            this.mLock = new Object();
            this.mSearchRequests = new ArrayList();
            this.mRemoteUserInfo = remoteUserInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BrowserLegacyCb) {
                return ObjectsCompat.equals(this.mRemoteUserInfo, ((BrowserLegacyCb) obj).mRemoteUserInfo);
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mRemoteUserInfo);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
            MediaLibraryServiceLegacyStub.this.notifyChildrenChanged(this.mRemoteUserInfo, str, libraryParams != null ? libraryParams.getExtras() : null);
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
            final ArrayList arrayList = new ArrayList();
            synchronized (this.mLock) {
                for (int size = this.mSearchRequests.size() - 1; size >= 0; size--) {
                    SearchRequest searchRequest = this.mSearchRequests.get(size);
                    if (ObjectsCompat.equals(this.mRemoteUserInfo, searchRequest.mRemoteUserInfo) && searchRequest.mQuery.equals(str)) {
                        arrayList.add(searchRequest);
                        this.mSearchRequests.remove(size);
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
                MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.BrowserLegacyCb.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i4;
                        int i5;
                        int i6;
                        int i7;
                        for (int i8 = 0; i8 < arrayList.size(); i8++) {
                            SearchRequest searchRequest2 = (SearchRequest) arrayList.get(i8);
                            Bundle bundle = searchRequest2.mExtras;
                            if (bundle != null) {
                                try {
                                    bundle.setClassLoader(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext().getClassLoader());
                                    i4 = searchRequest2.mExtras.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                                    i5 = searchRequest2.mExtras.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                                } catch (BadParcelableException unused) {
                                    searchRequest2.mResult.sendResult(null);
                                    return;
                                }
                            } else {
                                i4 = 0;
                                i5 = Integer.MAX_VALUE;
                            }
                            if (i4 < 0 || i5 < 1) {
                                i6 = 0;
                                i7 = Integer.MAX_VALUE;
                            } else {
                                i6 = i4;
                                i7 = i5;
                            }
                            LibraryResult libraryResultOnGetSearchResult = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onGetSearchResult(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), searchRequest2.mController, searchRequest2.mQuery, i6, i7, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext(), searchRequest2.mExtras));
                            if (libraryResultOnGetSearchResult == null || libraryResultOnGetSearchResult.getResultCode() != 0) {
                                searchRequest2.mResult.sendResult(null);
                            } else {
                                searchRequest2.mResult.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(libraryResultOnGetSearchResult.getMediaItems()), 262144));
                            }
                        }
                    }
                });
            }
        }

        public void registerSearchRequest(MediaSession.ControllerInfo controllerInfo, String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            synchronized (this.mLock) {
                this.mSearchRequests.add(new SearchRequest(controllerInfo, controllerInfo.getRemoteUserInfo(), str, bundle, result));
            }
        }
    }

    public static class BrowserLegacyCbForBroadcast extends BaseBrowserLegacyCb {
        private final MediaBrowserServiceCompat mService;

        public BrowserLegacyCbForBroadcast(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super();
            this.mService = mediaBrowserServiceCompat;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
            if (libraryParams == null || libraryParams.getExtras() == null) {
                this.mService.notifyChildrenChanged(str);
            } else {
                this.mService.notifyChildrenChanged(str, libraryParams.getExtras());
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i2, @NonNull String str, int i3, MediaLibraryService.LibraryParams libraryParams) {
        }
    }

    public static class SearchRequest {
        public final MediaSession.ControllerInfo mController;
        public final Bundle mExtras;
        public final String mQuery;
        public final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        public final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> mResult;

        public SearchRequest(MediaSession.ControllerInfo controllerInfo, MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            this.mController = controllerInfo;
            this.mRemoteUserInfo = remoteUserInfo;
            this.mQuery = str;
            this.mExtras = bundle;
            this.mResult = result;
        }
    }

    public MediaLibraryServiceLegacyStub(Context context, MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSessionCompat.Token token) {
        super(context, mediaLibrarySessionImpl, token);
        this.mLibrarySessionImpl = mediaLibrarySessionImpl;
        this.mBrowserLegacyCbForBroadcast = new BrowserLegacyCbForBroadcast(this);
    }

    private MediaSession.ControllerInfo getCurrentController() {
        return getConnectedControllersManager().getController(getCurrentBrowserInfo());
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub
    public MediaSession.ControllerInfo createControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return new MediaSession.ControllerInfo(remoteUserInfo, -1, this.mManager.isTrustedForMediaControl(remoteUserInfo), new BrowserLegacyCb(remoteUserInfo), null);
    }

    public MediaSession.ControllerCb getBrowserLegacyCbForBroadcast() {
        return this.mBrowserLegacyCbForBroadcast;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onCustomAction(final String str, final Bundle bundle, final MediaBrowserServiceCompat.Result<Bundle> result) {
        if (result != null) {
            result.detach();
        }
        final MediaSession.ControllerInfo currentController = getCurrentController();
        this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.6
            @Override // java.lang.Runnable
            public void run() {
                SessionCommand sessionCommand = new SessionCommand(str, null);
                if (MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, sessionCommand)) {
                    SessionResult sessionResultOnCustomCommand = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onCustomCommand(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, sessionCommand, bundle);
                    if (sessionResultOnCustomCommand != null) {
                        result.sendResult(sessionResultOnCustomCommand.getCustomCommandResult());
                        return;
                    }
                    return;
                }
                MediaBrowserServiceCompat.Result result2 = result;
                if (result2 != null) {
                    result2.sendError(null);
                }
            }
        });
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub, androidx.media.MediaBrowserServiceCompat
    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(String str, int i2, Bundle bundle) {
        MediaSession.ControllerInfo currentController;
        if (super.onGetRoot(str, i2, bundle) == null || (currentController = getCurrentController()) == null) {
            return null;
        }
        if (getConnectedControllersManager().isAllowedCommand(currentController, SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT)) {
            LibraryResult libraryResultOnGetLibraryRoot = this.mLibrarySessionImpl.getCallback().onGetLibraryRoot(this.mLibrarySessionImpl.getInstance(), currentController, MediaUtils.convertToLibraryParams(this.mLibrarySessionImpl.getContext(), bundle));
            if (libraryResultOnGetLibraryRoot != null && libraryResultOnGetLibraryRoot.getResultCode() == 0 && libraryResultOnGetLibraryRoot.getMediaItem() != null) {
                MediaMetadata metadata = libraryResultOnGetLibraryRoot.getMediaItem().getMetadata();
                return new MediaBrowserServiceCompat.BrowserRoot(metadata != null ? metadata.getString("android.media.metadata.MEDIA_ID") : "", MediaUtils.convertToRootHints(libraryResultOnGetLibraryRoot.getLibraryParams()));
            }
        }
        return MediaUtils.sDefaultBrowserRoot;
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub, androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        onLoadChildren(str, result, null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadItem(final String str, final MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> result) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (!TextUtils.isEmpty(str)) {
            result.detach();
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM)) {
                        result.sendError(null);
                        return;
                    }
                    LibraryResult libraryResultOnGetItem = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onGetItem(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str);
                    if (libraryResultOnGetItem == null || libraryResultOnGetItem.getResultCode() != 0) {
                        result.sendResult(null);
                    } else {
                        result.sendResult(MediaUtils.convertToMediaItem(libraryResultOnGetItem.getMediaItem()));
                    }
                }
            });
            return;
        }
        String str2 = "Ignoring empty itemId from " + currentController;
        result.sendError(null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onSearch(final String str, final Bundle bundle, final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (!TextUtils.isEmpty(str)) {
            if (currentController.getControllerCb() instanceof BrowserLegacyCb) {
                result.detach();
                this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, SessionCommand.COMMAND_CODE_LIBRARY_SEARCH)) {
                            result.sendError(null);
                            return;
                        }
                        ((BrowserLegacyCb) currentController.getControllerCb()).registerSearchRequest(currentController, str, bundle, result);
                        MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onSearch(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext(), bundle));
                    }
                });
                return;
            }
            return;
        }
        String str2 = "Ignoring empty query from " + currentController;
        result.sendError(null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onSubscribe(final String str, final Bundle bundle) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (!TextUtils.isEmpty(str)) {
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE)) {
                        MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onSubscribe(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext(), bundle));
                    }
                }
            });
            return;
        }
        String str2 = "onSubscribe(): Ignoring empty id from " + currentController;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onUnsubscribe(final String str) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (!TextUtils.isEmpty(str)) {
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE)) {
                        MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onUnsubscribe(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str);
                    }
                }
            });
            return;
        }
        String str2 = "onUnsubscribe(): Ignoring empty id from " + currentController;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(final String str, final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result, final Bundle bundle) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (!TextUtils.isEmpty(str)) {
            result.detach();
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaLibraryServiceLegacyStub.this.getConnectedControllersManager().isAllowedCommand(currentController, SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN)) {
                        result.sendError(null);
                        return;
                    }
                    Bundle bundle2 = bundle;
                    if (bundle2 != null) {
                        bundle2.setClassLoader(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext().getClassLoader());
                        try {
                            int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE);
                            int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE);
                            if (i2 > 0 && i3 > 0) {
                                LibraryResult libraryResultOnGetChildren = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onGetChildren(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str, i2, i3, MediaUtils.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getContext(), bundle));
                                if (libraryResultOnGetChildren != null && libraryResultOnGetChildren.getResultCode() == 0) {
                                    result.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(libraryResultOnGetChildren.getMediaItems()), 262144));
                                    return;
                                }
                                result.sendResult(null);
                                return;
                            }
                        } catch (BadParcelableException unused) {
                        }
                    }
                    LibraryResult libraryResultOnGetChildren2 = MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getCallback().onGetChildren(MediaLibraryServiceLegacyStub.this.mLibrarySessionImpl.getInstance(), currentController, str, 0, Integer.MAX_VALUE, null);
                    if (libraryResultOnGetChildren2 == null || libraryResultOnGetChildren2.getResultCode() != 0) {
                        result.sendResult(null);
                    } else {
                        result.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(libraryResultOnGetChildren2.getMediaItems()), 262144));
                    }
                }
            });
            return;
        }
        String str2 = "onLoadChildren(): Ignoring empty parentId from " + currentController;
        result.sendError(null);
    }
}
