package com.ss.android.downloadlib.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.a.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLinkOptimiseHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull final com.ss.android.downloadad.api.a.b bVar, final int i2) {
        if (i2 <= 0) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.f.2
            @Override // java.lang.Runnable
            public void run() {
                int i3 = 1;
                if (!l.c(bVar.e())) {
                    f.b(bVar, i2 - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!bVar.aa()) {
                        i3 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i3));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("deeplink_success_2", jSONObject, bVar);
            }
        }, i(bVar) * 1000);
    }

    public static boolean c(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a(bVar).b("app_link_opt_invoke_switch") == 1;
    }

    public static boolean d(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a(bVar).b("app_link_opt_dialog_switch") == 1;
    }

    public static long e(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.g.e.a(bVar).a("app_link_opt_back_time_limit", 3) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long h(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a(bVar).a("app_link_check_timeout", 300000L);
    }

    private static int i(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a(bVar).a("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a(bVar).a("app_link_check_count", 10);
    }

    public static void a(final com.ss.android.downloadad.api.a.b bVar, @NonNull final h hVar) {
        boolean zB = com.ss.android.socialbase.downloader.a.a.a().b();
        if (!zB && Build.VERSION.SDK_INT >= 29) {
            l.b();
        }
        boolean zB2 = com.ss.android.socialbase.downloader.a.a.a().b();
        boolean z = !zB && zB2;
        if (bVar != null) {
            bVar.l(z);
        }
        hVar.a(z);
        if (bVar == null) {
            return;
        }
        b(bVar, j(bVar));
        if (zB2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0092a() { // from class: com.ss.android.downloadlib.b.f.1
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
            public void b() {
                com.ss.android.socialbase.downloader.a.a.a().b(this);
                com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.f.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zC = l.c(bVar.e());
                        long jE = f.e(bVar);
                        if (!zC || jE >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            long jH = f.h(bVar);
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > jH) {
                                com.ss.android.downloadlib.d.a.a().a("deeplink_delay_timeout", bVar);
                                return;
                            }
                            bVar.l(true);
                            com.ss.android.downloadlib.d.a.a().a("deeplink_delay_invoke", bVar);
                            hVar.a(true);
                            com.ss.android.downloadad.api.a.b bVar2 = bVar;
                            f.b(bVar2, f.j(bVar2));
                        }
                    }
                });
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
            public void c() {
            }
        });
    }

    public static boolean b(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a(bVar).b("app_link_opt_install_switch") == 1;
    }

    public static boolean a(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a(bVar).b("app_link_opt_switch") == 1;
    }
}
