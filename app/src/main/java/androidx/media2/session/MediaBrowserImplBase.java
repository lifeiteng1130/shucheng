package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.session.MediaBrowser;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.SequencedFutureManager;
import c.e.b.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserImplBase extends MediaControllerImplBase implements MediaBrowser.MediaBrowserImpl {
    private static final LibraryResult RESULT_WHEN_CLOSED = new LibraryResult(1);

    @FunctionalInterface
    public interface RemoteLibrarySessionTask {
        void run(IMediaSession iMediaSession, int i2);
    }

    public MediaBrowserImplBase(Context context, MediaController mediaController, SessionToken sessionToken, @Nullable Bundle bundle) {
        super(context, mediaController, sessionToken, bundle);
    }

    private a<LibraryResult> dispatchRemoteLibrarySessionTask(int i2, RemoteLibrarySessionTask remoteLibrarySessionTask) {
        IMediaSession sessionInterfaceIfAble = getSessionInterfaceIfAble(i2);
        if (sessionInterfaceIfAble == null) {
            return LibraryResult.createFutureWithResult(-4);
        }
        SequencedFutureManager.SequencedFuture sequencedFutureCreateSequencedFuture = this.mSequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
        try {
            remoteLibrarySessionTask.run(sessionInterfaceIfAble, sequencedFutureCreateSequencedFuture.getSequenceNumber());
        } catch (RemoteException unused) {
            sequencedFutureCreateSequencedFuture.set(new LibraryResult(-100));
        }
        return sequencedFutureCreateSequencedFuture;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public a<LibraryResult> getChildren(final String str, final int i2, final int i3, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.4
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i4) {
                iMediaSession.getChildren(MediaBrowserImplBase.this.mControllerStub, i4, str, i2, i3, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public a<LibraryResult> getItem(final String str) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.5
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.getItem(MediaBrowserImplBase.this.mControllerStub, i2, str);
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public a<LibraryResult> getLibraryRoot(final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.1
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.getLibraryRoot(MediaBrowserImplBase.this.mControllerStub, i2, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @NonNull
    public MediaBrowser getMediaBrowser() {
        return (MediaBrowser) this.mInstance;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public a<LibraryResult> getSearchResult(final String str, final int i2, final int i3, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.7
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i4) {
                iMediaSession.getSearchResult(MediaBrowserImplBase.this.mControllerStub, i4, str, i2, i3, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    public void notifyChildrenChanged(final String str, final int i2, final MediaLibraryService.LibraryParams libraryParams) {
        getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() { // from class: androidx.media2.session.MediaBrowserImplBase.9
            @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
            public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                browserCallback.onChildrenChanged(MediaBrowserImplBase.this.getMediaBrowser(), str, i2, libraryParams);
            }
        });
    }

    public void notifySearchResultChanged(final String str, final int i2, final MediaLibraryService.LibraryParams libraryParams) {
        getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() { // from class: androidx.media2.session.MediaBrowserImplBase.8
            @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
            public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                browserCallback.onSearchResultChanged(MediaBrowserImplBase.this.getMediaBrowser(), str, i2, libraryParams);
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public a<LibraryResult> search(final String str, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.6
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.search(MediaBrowserImplBase.this.mControllerStub, i2, str, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public a<LibraryResult> subscribe(final String str, final MediaLibraryService.LibraryParams libraryParams) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.2
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.subscribe(MediaBrowserImplBase.this.mControllerStub, i2, str, MediaParcelUtils.toParcelable(libraryParams));
            }
        });
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public a<LibraryResult> unsubscribe(final String str) {
        return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, new RemoteLibrarySessionTask() { // from class: androidx.media2.session.MediaBrowserImplBase.3
            @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
            public void run(IMediaSession iMediaSession, int i2) {
                iMediaSession.unsubscribe(MediaBrowserImplBase.this.mControllerStub, i2, str);
            }
        });
    }
}
