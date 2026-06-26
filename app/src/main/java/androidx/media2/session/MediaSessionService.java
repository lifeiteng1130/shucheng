package androidx.media2.session;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.session.MediaSession;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaSessionService extends Service {
    public static final String SERVICE_INTERFACE = "androidx.media2.session.MediaSessionService";
    private final MediaSessionServiceImpl mImpl = createImpl();

    public static class MediaNotification {
        private final Notification mNotification;
        private final int mNotificationId;

        public MediaNotification(int i2, @NonNull Notification notification) {
            Objects.requireNonNull(notification, "notification shouldn't be null");
            this.mNotificationId = i2;
            this.mNotification = notification;
        }

        @NonNull
        public Notification getNotification() {
            return this.mNotification;
        }

        public int getNotificationId() {
            return this.mNotificationId;
        }
    }

    public interface MediaSessionServiceImpl {
        void addSession(MediaSession mediaSession);

        List<MediaSession> getSessions();

        IBinder onBind(Intent intent);

        void onCreate(MediaSessionService mediaSessionService);

        void onDestroy();

        int onStartCommand(Intent intent, int i2, int i3);

        MediaNotification onUpdateNotification(MediaSession mediaSession);

        void removeSession(MediaSession mediaSession);
    }

    public final void addSession(@NonNull MediaSession mediaSession) {
        Objects.requireNonNull(mediaSession, "session shouldn't be null");
        if (mediaSession.isClosed()) {
            throw new IllegalArgumentException("session is already closed");
        }
        this.mImpl.addSession(mediaSession);
    }

    public MediaSessionServiceImpl createImpl() {
        return new MediaSessionServiceImplBase();
    }

    @NonNull
    public final List<MediaSession> getSessions() {
        return this.mImpl.getSessions();
    }

    @Override // android.app.Service
    @Nullable
    @CallSuper
    public IBinder onBind(@NonNull Intent intent) {
        return this.mImpl.onBind(intent);
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        super.onCreate();
        this.mImpl.onCreate(this);
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        this.mImpl.onDestroy();
    }

    @Nullable
    public abstract MediaSession onGetSession(@NonNull MediaSession.ControllerInfo controllerInfo);

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(Intent intent, int i2, int i3) {
        return this.mImpl.onStartCommand(intent, i2, i3);
    }

    @Nullable
    public MediaNotification onUpdateNotification(@NonNull MediaSession mediaSession) {
        Objects.requireNonNull(mediaSession, "session shouldn't be null");
        return this.mImpl.onUpdateNotification(mediaSession);
    }

    public final void removeSession(@NonNull MediaSession mediaSession) {
        Objects.requireNonNull(mediaSession, "session shouldn't be null");
        this.mImpl.removeSession(mediaSession);
    }
}
