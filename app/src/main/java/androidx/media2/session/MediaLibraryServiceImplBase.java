package androidx.media2.session;

import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class MediaLibraryServiceImplBase extends MediaSessionServiceImplBase {
    @Override // androidx.media2.session.MediaSessionServiceImplBase, androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public IBinder onBind(Intent intent) {
        return MediaLibraryService.SERVICE_INTERFACE.equals(intent.getAction()) ? getServiceBinder() : super.onBind(intent);
    }
}
