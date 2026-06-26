package androidx.media2.session;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.session.IMediaSessionService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import androidx.versionedparcelable.ParcelImpl;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionServiceImplBase implements MediaSessionService.MediaSessionServiceImpl {
    private static final boolean DEBUG = true;
    private static final String TAG = "MSS2ImplBase";

    @GuardedBy("mLock")
    public MediaSessionService mInstance;

    @GuardedBy("mLock")
    private MediaNotificationHandler mNotificationHandler;

    @GuardedBy("mLock")
    public MediaSessionServiceStub mStub;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private Map<String, MediaSession> mSessions = new ArrayMap();

    public static final class MediaSessionServiceStub extends IMediaSessionService.Stub implements Closeable {
        public final Handler mHandler;
        public final androidx.media.MediaSessionManager mMediaSessionManager;
        public final WeakReference<MediaSessionServiceImplBase> mServiceImpl;

        public MediaSessionServiceStub(MediaSessionServiceImplBase mediaSessionServiceImplBase) {
            this.mServiceImpl = new WeakReference<>(mediaSessionServiceImplBase);
            this.mHandler = new Handler(mediaSessionServiceImplBase.getInstance().getMainLooper());
            this.mMediaSessionManager = androidx.media.MediaSessionManager.getSessionManager(mediaSessionServiceImplBase.getInstance());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mServiceImpl.clear();
            this.mHandler.removeCallbacksAndMessages(null);
        }

        @Override // androidx.media2.session.IMediaSessionService
        public void connect(final IMediaController iMediaController, ParcelImpl parcelImpl) {
            if (this.mServiceImpl.get() == null) {
                return;
            }
            int callingPid = Binder.getCallingPid();
            final int callingUid = Binder.getCallingUid();
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            final ConnectionRequest connectionRequest = (ConnectionRequest) MediaParcelUtils.fromParcelable(parcelImpl);
            if (callingPid == 0) {
                callingPid = connectionRequest.getPid();
            }
            final int i2 = callingPid;
            final String packageName = parcelImpl == null ? null : connectionRequest.getPackageName();
            final Bundle connectionHints = parcelImpl == null ? null : connectionRequest.getConnectionHints();
            try {
                this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        MediaSession mediaSessionOnGetSession;
                        boolean z = true;
                        try {
                            MediaSessionServiceImplBase mediaSessionServiceImplBase = MediaSessionServiceStub.this.mServiceImpl.get();
                            if (mediaSessionServiceImplBase == null) {
                                try {
                                    iMediaController.onDisconnected(0);
                                    return;
                                } catch (RemoteException unused) {
                                    return;
                                }
                            }
                            MediaSessionService mediaSessionServiceImplBase2 = mediaSessionServiceImplBase.getInstance();
                            if (mediaSessionServiceImplBase2 == null) {
                                try {
                                    iMediaController.onDisconnected(0);
                                    return;
                                } catch (RemoteException unused2) {
                                    return;
                                }
                            }
                            MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(packageName, i2, callingUid);
                            MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, connectionRequest.getVersion(), MediaSessionServiceStub.this.mMediaSessionManager.isTrustedForMediaControl(remoteUserInfo), null, connectionHints);
                            String str = "Handling incoming connection request from the controller=" + controllerInfo;
                            try {
                                mediaSessionOnGetSession = mediaSessionServiceImplBase2.onGetSession(controllerInfo);
                            } catch (Exception unused3) {
                            }
                            if (mediaSessionOnGetSession == null) {
                                String str2 = "Rejecting incoming connection request from the controller=" + controllerInfo;
                                try {
                                    iMediaController.onDisconnected(0);
                                    return;
                                } catch (RemoteException unused4) {
                                    return;
                                }
                            }
                            mediaSessionServiceImplBase2.addSession(mediaSessionOnGetSession);
                            try {
                                mediaSessionOnGetSession.handleControllerConnectionFromService(iMediaController, connectionRequest.getVersion(), packageName, i2, callingUid, connectionHints);
                            } catch (Exception unused5) {
                            } catch (Throwable th) {
                                th = th;
                                z = false;
                                if (z) {
                                    try {
                                        iMediaController.onDisconnected(0);
                                    } catch (RemoteException unused6) {
                                    }
                                }
                                throw th;
                            }
                            z = false;
                            if (z) {
                                try {
                                    iMediaController.onDisconnected(0);
                                } catch (RemoteException unused7) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                });
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void addSession(MediaSession mediaSession) {
        MediaSession mediaSession2;
        MediaNotificationHandler mediaNotificationHandler;
        synchronized (this.mLock) {
            mediaSession2 = this.mSessions.get(mediaSession.getId());
            if (mediaSession2 != null && mediaSession2 != mediaSession) {
                throw new IllegalArgumentException("Session ID should be unique");
            }
            this.mSessions.put(mediaSession.getId(), mediaSession);
        }
        if (mediaSession2 == null) {
            synchronized (this.mLock) {
                mediaNotificationHandler = this.mNotificationHandler;
            }
            mediaNotificationHandler.onPlayerStateChanged(mediaSession, mediaSession.getPlayer().getPlayerState());
            mediaSession.getCallback().setForegroundServiceEventCallback(mediaNotificationHandler);
        }
    }

    public MediaSessionService getInstance() {
        MediaSessionService mediaSessionService;
        synchronized (this.mLock) {
            mediaSessionService = this.mInstance;
        }
        return mediaSessionService;
    }

    public IBinder getServiceBinder() {
        IBinder iBinderAsBinder;
        synchronized (this.mLock) {
            MediaSessionServiceStub mediaSessionServiceStub = this.mStub;
            iBinderAsBinder = mediaSessionServiceStub != null ? mediaSessionServiceStub.asBinder() : null;
        }
        return iBinderAsBinder;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public List<MediaSession> getSessions() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            arrayList.addAll(this.mSessions.values());
        }
        return arrayList;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public IBinder onBind(Intent intent) {
        MediaSession mediaSessionOnGetSession;
        MediaSessionService mediaSessionServiceImplBase = getInstance();
        if (mediaSessionServiceImplBase == null) {
            return null;
        }
        String action = intent.getAction();
        action.hashCode();
        if (action.equals(MediaSessionService.SERVICE_INTERFACE)) {
            return getServiceBinder();
        }
        if (!action.equals(MediaBrowserServiceCompat.SERVICE_INTERFACE) || (mediaSessionOnGetSession = mediaSessionServiceImplBase.onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo())) == null) {
            return null;
        }
        addSession(mediaSessionOnGetSession);
        return mediaSessionOnGetSession.getLegacyBrowerServiceBinder();
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void onCreate(MediaSessionService mediaSessionService) {
        synchronized (this.mLock) {
            this.mInstance = mediaSessionService;
            this.mStub = new MediaSessionServiceStub(this);
            this.mNotificationHandler = new MediaNotificationHandler(mediaSessionService);
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void onDestroy() {
        synchronized (this.mLock) {
            this.mInstance = null;
            MediaSessionServiceStub mediaSessionServiceStub = this.mStub;
            if (mediaSessionServiceStub != null) {
                mediaSessionServiceStub.close();
                this.mStub = null;
            }
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public int onStartCommand(Intent intent, int i2, int i3) {
        KeyEvent keyEvent;
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.MEDIA_BUTTON")) {
                MediaSessionService mediaSessionServiceImplBase = getInstance();
                if (mediaSessionServiceImplBase == null) {
                    Log.wtf(TAG, "Service hasn't created");
                }
                MediaSession session = MediaSession.getSession(intent.getData());
                if (session == null) {
                    session = mediaSessionServiceImplBase.onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                }
                if (session != null && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                    session.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
                }
            }
        }
        return 1;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public MediaSessionService.MediaNotification onUpdateNotification(MediaSession mediaSession) {
        MediaNotificationHandler mediaNotificationHandler;
        synchronized (this.mLock) {
            mediaNotificationHandler = this.mNotificationHandler;
        }
        if (mediaNotificationHandler != null) {
            return mediaNotificationHandler.onUpdateNotification(mediaSession);
        }
        throw new IllegalStateException("Service hasn't created");
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void removeSession(MediaSession mediaSession) {
        synchronized (this.mLock) {
            this.mSessions.remove(mediaSession.getId());
        }
    }
}
