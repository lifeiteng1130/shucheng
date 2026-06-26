package e.a.a.f.s;

import android.content.Context;
import android.content.Intent;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.HttpTTS;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.service.HttpReadAloudService;
import io.legado.app.service.TTSReadAloudService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadAloud.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    @NotNull
    public static final j a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static Class<?> f5674b = a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static HttpTTS f5675c;

    public static final Class<?> a() {
        HttpTTS httpTTS = AppDatabaseKt.getAppDb().getHttpTTSDao().get(c.b.a.m.f.N2(k.d.a.h.g(), "speakEngine", 0L, 2));
        f5675c = httpTTS;
        return httpTTS != null ? HttpReadAloudService.class : TTSReadAloudService.class;
    }

    public static final void b(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (BaseReadAloudService.f6927b) {
            Intent intent = new Intent(context, f5674b);
            intent.setAction("nextParagraph");
            context.startService(intent);
        }
    }

    public static final void c(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (BaseReadAloudService.f6927b) {
            Intent intent = new Intent(context, f5674b);
            intent.setAction("pause");
            context.startService(intent);
        }
    }

    public static final void d(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (BaseReadAloudService.f6927b) {
            Intent intent = new Intent(context, f5674b);
            intent.setAction("prevParagraph");
            context.startService(intent);
        }
    }

    public static final void e(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (BaseReadAloudService.f6927b) {
            Intent intent = new Intent(context, f5674b);
            intent.setAction("resume");
            context.startService(intent);
        }
    }

    public static final void f(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (BaseReadAloudService.f6927b) {
            Intent intent = new Intent(context, f5674b);
            intent.setAction("stop");
            context.startService(intent);
        }
    }

    public static final void g(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (BaseReadAloudService.f6927b) {
            Intent intent = new Intent(context, f5674b);
            intent.setAction("upTtsSpeechRate");
            context.startService(intent);
        }
    }
}
