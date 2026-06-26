package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.m;
import com.ss.android.download.api.config.n;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: GlobalInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    public static final JSONObject a = new JSONObject();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f3147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.ss.android.download.api.config.f f3148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.ss.android.download.api.config.c f3149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static com.ss.android.download.api.config.k f3150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static com.ss.android.download.api.config.g f3151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static com.ss.android.download.api.config.h f3152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static com.ss.android.download.api.config.i f3153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static com.ss.android.download.api.model.a f3154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static com.ss.android.download.api.config.b f3155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static com.ss.android.socialbase.appdownloader.c.h f3156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static com.ss.android.download.api.config.d f3157l;
    private static com.ss.android.download.api.config.e m;
    private static n n;
    private static com.ss.android.download.api.config.j o;
    private static t p;
    private static m q;
    private static com.ss.android.download.api.config.l r;
    private static o s;
    private static com.ss.android.download.api.b.a t;
    private static p u;
    private static r v;

    public static void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f3147b = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (f3147b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f3147b = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.k c() {
        if (f3150e == null) {
            f3150e = new com.ss.android.download.api.a.a();
        }
        return f3150e;
    }

    public static com.ss.android.download.api.config.g d() {
        return f3151f;
    }

    @NonNull
    public static com.ss.android.download.api.config.h e() {
        if (f3152g == null) {
            f3152g = new com.ss.android.download.api.a.b();
        }
        return f3152g;
    }

    public static com.ss.android.socialbase.appdownloader.c.h f() {
        if (f3156k == null) {
            f3156k = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.addownload.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                }
            };
        }
        return f3156k;
    }

    public static n g() {
        return n;
    }

    public static Context getContext() {
        Context context = f3147b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    @NonNull
    public static o h() {
        if (s == null) {
            s = new o() { // from class: com.ss.android.downloadlib.addownload.j.3
                @Override // com.ss.android.download.api.config.o
                public void a(String str, int i2, JSONObject jSONObject) {
                }
            };
        }
        return s;
    }

    @NonNull
    public static JSONObject i() {
        com.ss.android.download.api.config.i iVar = f3153h;
        return (iVar == null || iVar.a() == null) ? a : f3153h.a();
    }

    public static com.ss.android.download.api.config.l j() {
        return r;
    }

    @Nullable
    public static com.ss.android.download.api.config.b k() {
        return f3155j;
    }

    @Nullable
    public static m l() {
        return q;
    }

    public static String m() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.d n() {
        return f3157l;
    }

    public static com.ss.android.download.api.config.e o() {
        return m;
    }

    public static com.ss.android.download.api.config.j p() {
        return o;
    }

    @NonNull
    public static p q() {
        return u;
    }

    public static t r() {
        return p;
    }

    @NonNull
    public static com.ss.android.download.api.b.a s() {
        if (t == null) {
            t = new com.ss.android.download.api.b.a() { // from class: com.ss.android.downloadlib.addownload.j.4
                @Override // com.ss.android.download.api.b.a
                public void a(Throwable th, String str) {
                }
            };
        }
        return t;
    }

    @NonNull
    public static r t() {
        if (v == null) {
            v = new r() { // from class: com.ss.android.downloadlib.addownload.j.5
                @Override // com.ss.android.download.api.config.r
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
                }
            };
        }
        return v;
    }

    public static String u() {
        try {
            int i2 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + i().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean v() {
        return (f3148c == null || f3151f == null || f3153h == null || f3155j == null || u == null) ? false : true;
    }

    @NonNull
    public static com.ss.android.download.api.config.c b() {
        if (f3149d == null) {
            f3149d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.j.1
                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f3149d;
    }

    public static void a(@NonNull com.ss.android.download.api.config.f fVar) {
        f3148c = fVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.k kVar) {
        f3150e = kVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.g gVar) {
        f3151f = gVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.h hVar) {
        f3152g = hVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.i iVar) {
        f3153h = iVar;
    }

    public static void a(@NonNull com.ss.android.download.api.model.a aVar) {
        f3154i = aVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.b bVar) {
        f3155j = bVar;
    }

    public static com.ss.android.download.api.config.f a() {
        return f3148c;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.j().a(str);
    }

    public static void a(p pVar) {
        u = pVar;
    }

    public static void a(com.ss.android.download.api.b.a aVar) {
        t = aVar;
    }
}
