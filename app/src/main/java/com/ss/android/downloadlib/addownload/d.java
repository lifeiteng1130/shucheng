package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CleanSpaceHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.b.e f3103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f3104c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f3105d = new AtomicBoolean(false);

    public d(Handler handler) {
        this.a = handler;
    }

    public static long b() {
        if (j.l() != null) {
            return j.l().a();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long d() {
        return com.ss.android.downloadlib.g.l.a(0L);
    }

    private void b(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j2, long j3) {
        bVar.l(SdkVersion.MINI_VERSION);
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j3 - j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, bVar);
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar) {
        this.f3103b = eVar;
    }

    public boolean a() {
        return this.f3105d.get();
    }

    public void a(boolean z) {
        this.f3105d.set(z);
    }

    public void a(final int i2, final long j2, long j3, final e.a aVar) {
        this.f3105d.set(false);
        if (aVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.g.e.f(i2) && com.ss.android.downloadlib.g.e.e(i2)) {
            long jC = com.ss.android.downloadlib.g.e.c(i2);
            this.f3104c.set(false);
            final String downloadUrl = this.f3103b.f3052b.getDownloadUrl();
            com.ss.android.downloadad.api.a.b bVarB = com.ss.android.downloadlib.addownload.b.f.a().b(downloadUrl);
            if (bVarB == null) {
                com.ss.android.downloadlib.addownload.b.e eVar = this.f3103b;
                bVarB = new com.ss.android.downloadad.api.a.b(eVar.f3052b, eVar.f3053c, eVar.f3054d, 0);
                com.ss.android.downloadlib.addownload.b.f.a().a(bVarB);
            }
            final com.ss.android.downloadad.api.a.b bVar = bVarB;
            bVar.e(false);
            if (j.l() != null) {
                j.l().a(bVar.b());
            }
            com.ss.android.downloadlib.addownload.c.d.a().a(bVar.a());
            boolean zD = com.ss.android.downloadlib.g.e.d(i2);
            if (j3 > 0) {
                a(i2, downloadUrl, j3, bVar, j2, aVar);
            } else if (zD) {
                a(downloadUrl, bVar, new e.b() { // from class: com.ss.android.downloadlib.addownload.d.1
                    @Override // com.ss.android.downloadlib.addownload.e.b
                    public void a(long j4) {
                        d.this.a(i2, downloadUrl, j4, bVar, j2, aVar);
                    }
                });
            } else {
                jC = 0;
            }
            this.a.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f3104c.get()) {
                        return;
                    }
                    d.this.f3104c.set(true);
                    aVar.a();
                }
            }, jC);
            return;
        }
        aVar.a();
    }

    private void a(String str, com.ss.android.downloadad.api.a.b bVar, final e.b bVar2) {
        if (bVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.b.a(str, new com.ss.android.socialbase.downloader.network.j() { // from class: com.ss.android.downloadlib.addownload.d.3
            @Override // com.ss.android.socialbase.downloader.network.j
            public void a(Map<String, String> map) {
                if (d.this.f3104c.get()) {
                    return;
                }
                d.this.f3104c.set(true);
                long jA = d.this.a(map);
                if (jA > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(jA));
                        jSONObject.putOpt("available_space", Long.valueOf(d.d()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                bVar2.a(jA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, long j2, final com.ss.android.downloadad.api.a.b bVar, long j3, final e.a aVar) {
        this.f3104c.set(true);
        boolean zA = false;
        if (j2 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            long jB = (com.ss.android.downloadlib.g.e.b(i2) + Double.valueOf((com.ss.android.downloadlib.g.e.a(i2) + 1.0d) * j2).longValue()) - j3;
            long jD = d();
            if (jD < jB) {
                a(bVar, jSONObject, jB, jD);
                a(bVar);
                long jD2 = d();
                if (jD2 < jB) {
                    bVar.d(true);
                    final String strA = bVar.a();
                    com.ss.android.downloadlib.addownload.c.d.a().a(strA, new com.ss.android.downloadlib.addownload.c.e() { // from class: com.ss.android.downloadlib.addownload.d.4
                    });
                    zA = a(i2, bVar, str, jB);
                    if (zA) {
                        bVar.e(true);
                    }
                } else {
                    b(bVar, jSONObject, jD, jD2);
                }
            }
        }
        if (zA) {
            return;
        }
        this.a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.5
            @Override // java.lang.Runnable
            public void run() {
                aVar.a();
            }
        });
    }

    private boolean a(int i2, @NonNull com.ss.android.downloadad.api.a.b bVar, String str, long j2) {
        if (!com.ss.android.downloadlib.g.e.f(i2)) {
            return false;
        }
        if (j.l() != null) {
            return j.l().a(i2, str, true, j2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject, bVar);
        return false;
    }

    public static boolean a(final DownloadInfo downloadInfo, long j2) {
        int id = downloadInfo.getId();
        boolean zA = false;
        if (!com.ss.android.downloadlib.g.e.f(id)) {
            return false;
        }
        if (j.l() != null && (zA = j.l().a(id, downloadInfo.getUrl(), false, j2))) {
            com.ss.android.downloadlib.addownload.c.d.a().a(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.c.e() { // from class: com.ss.android.downloadlib.addownload.d.6
            });
        }
        return zA;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(int i2) {
        if (com.ss.android.downloadlib.g.e.f(i2) && j.l() != null && j.l().b()) {
            j.l().c();
        }
    }

    private static void a(com.ss.android.downloadad.api.a.b bVar) {
        long jD = d();
        if (j.l() != null) {
            j.l().e();
        }
        com.ss.android.downloadlib.addownload.c.c.a();
        com.ss.android.downloadlib.addownload.c.c.b();
        if (com.ss.android.downloadlib.g.e.g(bVar.s())) {
            com.ss.android.downloadlib.addownload.c.c.a(j.getContext());
        }
        long jD2 = d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(jD2 - jD));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_quite_finish", jSONObject, bVar);
    }

    private void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j2, long j3) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j3));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_space_no_enough_for_download", jSONObject, bVar);
    }
}
