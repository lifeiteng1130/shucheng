package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import c.e.b.a.a.a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowser extends MediaController {
    public static final String TAG = "MediaBrowser";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);

    public static class BrowserCallback extends MediaController.ControllerCallback {
        public void onChildrenChanged(@NonNull MediaBrowser mediaBrowser, @NonNull String str, @IntRange(from = 0) int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        }

        public void onSearchResultChanged(@NonNull MediaBrowser mediaBrowser, @NonNull String str, @IntRange(from = 0) int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        }
    }

    public interface BrowserCallbackRunnable {
        void run(@NonNull BrowserCallback browserCallback);
    }

    public static final class Builder extends MediaController.BuilderBase<MediaBrowser, Builder, BrowserCallback> {
        public Builder(@NonNull Context context) {
            super(context);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public MediaBrowser build() {
            SessionToken sessionToken = this.mToken;
            if (sessionToken == null && this.mCompatToken == null) {
                throw new IllegalArgumentException("token and compat token shouldn't be both null");
            }
            return sessionToken != null ? new MediaBrowser(this.mContext, this.mToken, this.mConnectionHints, this.mCallbackExecutor, (BrowserCallback) this.mCallback) : new MediaBrowser(this.mContext, this.mCompatToken, this.mConnectionHints, this.mCallbackExecutor, (BrowserCallback) this.mCallback);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setConnectionHints(@NonNull Bundle bundle) {
            return (Builder) super.setConnectionHints(bundle);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setControllerCallback(@NonNull Executor executor, @NonNull BrowserCallback browserCallback) {
            return (Builder) super.setControllerCallback(executor, browserCallback);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setSessionCompatToken(@NonNull MediaSessionCompat.Token token) {
            return (Builder) super.setSessionCompatToken(token);
        }

        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setSessionToken(@NonNull SessionToken sessionToken) {
            return (Builder) super.setSessionToken(sessionToken);
        }
    }

    public interface MediaBrowserImpl extends MediaController.MediaControllerImpl {
        a<LibraryResult> getChildren(@NonNull String str, int i2, int i3, @Nullable MediaLibraryService.LibraryParams libraryParams);

        a<LibraryResult> getItem(@NonNull String str);

        a<LibraryResult> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams);

        a<LibraryResult> getSearchResult(@NonNull String str, int i2, int i3, @Nullable MediaLibraryService.LibraryParams libraryParams);

        a<LibraryResult> search(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams);

        a<LibraryResult> subscribe(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams);

        a<LibraryResult> unsubscribe(@NonNull String str);
    }

    public MediaBrowser(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle, @Nullable Executor executor, @Nullable BrowserCallback browserCallback) {
        super(context, sessionToken, bundle, executor, browserCallback);
    }

    private static a<LibraryResult> createDisconnectedFuture() {
        return LibraryResult.createFutureWithResult(-100);
    }

    @NonNull
    public a<LibraryResult> getChildren(@NonNull String str, @IntRange(from = 0) int i2, @IntRange(from = 1) int i3, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId shouldn't be empty");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("page shouldn't be negative");
        }
        if (i3 >= 1) {
            return isConnected() ? getImpl().getChildren(str, i2, i3, libraryParams) : createDisconnectedFuture();
        }
        throw new IllegalArgumentException("pageSize shouldn't be less than 1");
    }

    @NonNull
    public a<LibraryResult> getItem(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        }
        return isConnected() ? getImpl().getItem(str) : createDisconnectedFuture();
    }

    @NonNull
    public a<LibraryResult> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        return isConnected() ? getImpl().getLibraryRoot(libraryParams) : createDisconnectedFuture();
    }

    @NonNull
    public a<LibraryResult> getSearchResult(@NonNull String str, @IntRange(from = 0) int i2, @IntRange(from = 1) int i3, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query shouldn't be empty");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("page shouldn't be negative");
        }
        if (i3 >= 1) {
            return isConnected() ? getImpl().getSearchResult(str, i2, i3, libraryParams) : createDisconnectedFuture();
        }
        throw new IllegalArgumentException("pageSize shouldn't be less than 1");
    }

    public void notifyBrowserCallback(final BrowserCallbackRunnable browserCallbackRunnable) {
        Executor executor;
        if (this.mPrimaryCallback == null || (executor = this.mPrimaryCallbackExecutor) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.media2.session.MediaBrowser.1
            @Override // java.lang.Runnable
            public void run() {
                browserCallbackRunnable.run((BrowserCallback) MediaBrowser.this.mPrimaryCallback);
            }
        });
    }

    @NonNull
    public a<LibraryResult> search(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query shouldn't be empty");
        }
        return isConnected() ? getImpl().search(str, libraryParams) : createDisconnectedFuture();
    }

    @NonNull
    public a<LibraryResult> subscribe(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId shouldn't be empty");
        }
        return isConnected() ? getImpl().subscribe(str, libraryParams) : createDisconnectedFuture();
    }

    @NonNull
    public a<LibraryResult> unsubscribe(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId shouldn't be empty");
        }
        return isConnected() ? getImpl().unsubscribe(str) : createDisconnectedFuture();
    }

    public MediaBrowser(@NonNull Context context, @NonNull MediaSessionCompat.Token token, @Nullable Bundle bundle, @Nullable Executor executor, @Nullable BrowserCallback browserCallback) {
        super(context, token, bundle, executor, browserCallback);
    }

    @Override // androidx.media2.session.MediaController
    public MediaBrowserImpl createImpl(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle) {
        return sessionToken.isLegacySession() ? new MediaBrowserImplLegacy(context, this, sessionToken) : new MediaBrowserImplBase(context, this, sessionToken, bundle);
    }

    @Override // androidx.media2.session.MediaController
    public MediaBrowserImpl getImpl() {
        return (MediaBrowserImpl) super.getImpl();
    }
}
