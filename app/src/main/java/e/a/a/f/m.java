package e.a.a.f;

import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import io.legado.app.receiver.MediaButtonReceiver;
import io.legado.app.service.BaseReadAloudService;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BaseReadAloudService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends MediaSessionCompat.Callback {
    public final /* synthetic */ BaseReadAloudService a;

    public m(BaseReadAloudService baseReadAloudService) {
        this.a = baseReadAloudService;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public boolean onMediaButtonEvent(@NotNull Intent intent) {
        f.c0.c.j.e(intent, "mediaButtonEvent");
        return MediaButtonReceiver.INSTANCE.a(this.a, intent);
    }
}
