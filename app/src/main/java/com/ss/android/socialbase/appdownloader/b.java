package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.FontsContractCompat;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AhUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f3303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f3304c;

    /* JADX INFO: compiled from: AhUtils.java */
    public static class a implements a.InterfaceC0092a {
        private final e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private JSONObject f3306c;

        public a(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0089b interfaceC0089b) {
            this.f3306c = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.f3305b = iOptInt;
            this.a = new e(context, intent, i2, interfaceC0089b, iOptInt);
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
        public void b() {
            if (!this.a.f3317i) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.a.f3314f.sendMessage(messageObtain);
            }
            com.ss.android.socialbase.downloader.a.a.a().b(this);
            a unused = b.f3304c = null;
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
        public void c() {
            int iOptInt = this.f3306c.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.a.f3314f.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.a.f3314f.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AhUtils.java */
    public interface InterfaceC0089b {
        boolean a(@NonNull Context context);
    }

    /* JADX INFO: compiled from: AhUtils.java */
    public interface c {
        void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar);
    }

    /* JADX INFO: compiled from: AhUtils.java */
    public static class d implements Callable<Boolean> {
        private final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0089b f3307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f3308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f3309d;

        public d(Handler handler, Context context, InterfaceC0089b interfaceC0089b, long j2) {
            this.a = context;
            this.f3307b = interfaceC0089b;
            this.f3308c = handler;
            this.f3309d = j2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            InterfaceC0089b interfaceC0089b;
            try {
                interfaceC0089b = this.f3307b;
            } catch (Throwable unused) {
            }
            if (interfaceC0089b != null) {
                long j2 = this.f3309d;
                if (j2 > 0 && j2 <= 10000) {
                    Context context = this.a;
                    boolean zA = context != null ? interfaceC0089b.a(context) : false;
                    Message messageObtain = Message.obtain();
                    if (zA) {
                        messageObtain.what = 2;
                        this.f3308c.sendMessage(messageObtain);
                    } else {
                        messageObtain.what = 1;
                        this.f3308c.sendMessageDelayed(messageObtain, this.f3309d);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: compiled from: AhUtils.java */
    public static class e implements h.a {
        public static int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static int f3310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f3311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Intent f3312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final InterfaceC0089b f3313e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Handler f3314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f3315g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Future<Boolean> f3316h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f3317i = false;

        public e(Context context, Intent intent, int i2, InterfaceC0089b interfaceC0089b, long j2) {
            this.f3311c = context;
            this.f3312d = intent;
            f3310b = i2;
            this.f3313e = interfaceC0089b;
            this.f3314f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);
            this.f3315g = j2;
        }

        @Override // com.ss.android.socialbase.downloader.h.h.a
        public void a(Message message) {
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1) {
                    long j2 = this.f3315g;
                    if (j2 <= 0 || j2 > 10000) {
                        return;
                    }
                    a = 1;
                    this.f3316h = com.ss.android.socialbase.downloader.downloader.c.l().submit(new d(this.f3314f, this.f3311c, this.f3313e, this.f3315g));
                    return;
                }
                if (i2 == 2) {
                    a = 2;
                    this.f3314f.removeMessages(2);
                    this.f3314f.removeMessages(1);
                    Future<Boolean> future = this.f3316h;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f3317i && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b())) {
                        Intent intent = this.f3312d;
                        if (intent != null) {
                            b.b(this.f3311c, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.f3311c).getDownloadInfo(f3310b);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.c.b(this.f3311c, f3310b, false);
                            }
                        }
                        this.f3317i = true;
                    }
                    b.b(f3310b, this.f3312d == null, b.a(this.f3311c));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean e(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean b(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            aVar.f3296d = "custom";
            com.ss.android.socialbase.appdownloader.a.a aVarA = com.ss.android.socialbase.appdownloader.a.d.a(context, "custom", jSONObject, downloadInfo);
            if (aVarA != null && aVarA.a()) {
                Intent intentB = aVarA.b();
                if (intentB == null) {
                    return false;
                }
                if (!a(new File(savePath), downloadInfo, jSONObject)) {
                    aVar.f3294b = 6;
                } else {
                    if (b(context, intentB)) {
                        aVar.f3294b = 0;
                        return true;
                    }
                    aVar.f3294b = 1;
                }
                return false;
            }
            aVar.f3294b = 3;
        }
        return false;
    }

    public static void c(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_open_setting", jSONObject2);
    }

    private static void d(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_show", jSONObject2);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray jSONArrayE = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_plans");
        if (jSONArrayE == null) {
            return false;
        }
        int length = jSONArrayE.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayE.optJSONObject(i2);
            if (com.ss.android.socialbase.appdownloader.f.a.a(jSONObjectOptJSONObject) && a(context, downloadInfo, intent, jSONObjectOptJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0171 A[PHI: r15
  0x0171: PHI (r15v13 com.ss.android.socialbase.appdownloader.a) = 
  (r15v2 com.ss.android.socialbase.appdownloader.a)
  (r15v8 com.ss.android.socialbase.appdownloader.a)
  (r15v14 com.ss.android.socialbase.appdownloader.a)
 binds: [B:98:0x016f, B:88:0x0147, B:60:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.a(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.a b(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar2;
        }
        aVar2.a = jSONObject.optString("type");
        aVar2.f3297e = "vbi";
        if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), "vbi", jSONObject, aVar)) {
            aVar2.f3294b = 0;
        } else {
            a(aVar2, 3);
        }
        return aVar2;
    }

    public static void b(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i3 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, Intent intent) {
        return a(context, intent, true);
    }

    private static boolean a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar, com.ss.android.socialbase.downloader.g.a aVar2) {
        boolean zB;
        String strOptString = jSONObject.optString("type");
        aVar.a = strOptString;
        Intent intentB = com.ss.android.socialbase.appdownloader.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
        StringBuilder sb = new StringBuilder();
        try {
            zB = b(context, intentB);
        } catch (Throwable th) {
            sb.append(strOptString);
            sb.append(" startActivity failed : ");
            sb.append(a(th));
            a(aVar, 1);
            zB = false;
        }
        if (!zB) {
            aVar.f3295c = sb.toString();
        } else {
            aVar.f3294b = 0;
        }
        return true;
    }

    private static boolean a(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.a aVar) {
        boolean z;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("device_plans");
            aVar.f3297e = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                String[] strArrSplit = strOptString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    String str2 = strArrSplit[i2];
                    com.ss.android.socialbase.appdownloader.a.a aVarA = com.ss.android.socialbase.appdownloader.a.d.a(context, str2, jSONObject, downloadInfo);
                    if (aVarA != null) {
                        Intent intentB = aVarA.b();
                        if (intentB != null) {
                            if (a(file, downloadInfo, jSONObject)) {
                                try {
                                    a(context, intentB, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(a(th));
                                    a(aVar, 1);
                                }
                            } else {
                                a(aVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            a(aVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i2++;
                }
                if (!z) {
                    aVar.f3295c = sb.toString();
                } else {
                    aVar.f3296d = str;
                    aVar.f3294b = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int a(@NonNull com.ss.android.socialbase.downloader.g.a aVar) {
        if (!(aVar.d("download_dir") != null ? !TextUtils.isEmpty(r0.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayE = aVar.e("ah_plans");
        int i2 = -1;
        if (jSONArrayE != null) {
            int length = jSONArrayE.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayE.optJSONObject(i3);
                if (com.ss.android.socialbase.appdownloader.f.a.a(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if (!"plan_a".equals(strOptString) && !"plan_b".equals(strOptString) && !"plan_e".equals(strOptString) && !"plan_f".equals(strOptString)) {
                        if ("plan_d".equalsIgnoreCase(strOptString) || "plan_h".equalsIgnoreCase(strOptString) || ("plan_g".equalsIgnoreCase(strOptString) && (i2 = b(jSONObjectOptJSONObject, aVar).f3294b) == 0)) {
                            return 0;
                        }
                    } else {
                        i2 = a(jSONObjectOptJSONObject, aVar).f3294b;
                        if (i2 == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i2;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar2;
        }
        String strOptString = jSONObject.optString("type");
        aVar2.a = strOptString;
        if ("plan_b".equals(strOptString)) {
            aVar2.f3297e = "custom";
            if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), "custom", jSONObject, aVar)) {
                aVar2.f3294b = 0;
                return aVar2;
            }
            a(aVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            aVar2.f3297e = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), str, jSONObject, aVar)) {
                        aVar2.f3294b = 0;
                        return aVar2;
                    }
                    a(aVar2, 3);
                }
            }
        }
        return aVar2;
    }

    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.f.d.b()) {
            aVar2.a = jSONObject.optString("type");
            if (aVar.a("bi", 0) == 1) {
                aVar2.f3294b = 0;
                return aVar2;
            }
            if (a(context)) {
                aVar2.f3294b = 2;
            } else if (com.ss.android.socialbase.appdownloader.f.a.a(str) != null) {
                aVar2.f3294b = 0;
            } else {
                aVar2.f3294b = 9;
            }
        }
        return aVar2;
    }

    private static void a(com.ss.android.socialbase.appdownloader.a aVar, int i2) {
        int i3 = aVar.f3294b;
        if (i3 != -1) {
            aVar.f3294b = (i3 * 10) + i2;
        } else {
            aVar.f3294b = i2;
        }
    }

    private static boolean a(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectD = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).d("download_dir");
        File file2 = null;
        String strOptString = jSONObjectD != null ? jSONObjectD.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
            file2 = new File(c.a.a.a.a.p(c.a.a.a.a.r(path), File.separator, strOptString));
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong("jump_interval", 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= jOptLong && !a(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i2);
                    try {
                        if (a(context, intent2, false)) {
                            d(i2, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (aVar != null) {
                            aVar.f3294b = 1;
                            StringBuilder sbR = c.a.a.a.a.r("tryShowUnknownSourceDialog");
                            sbR.append(a(th));
                            aVar.f3295c = sbR.toString();
                        }
                        return false;
                    }
                }
                if (a(context, intent, i2, jSONObject)) {
                    c(i2, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.f.d.b() && Build.VERSION.SDK_INT < 26 && !d(context)) {
                com.ss.android.socialbase.appdownloader.a.f fVar = new com.ss.android.socialbase.appdownloader.a.f(context);
                if (fVar.a()) {
                    a(context, intent, i2, jSONObject, new InterfaceC0089b() { // from class: com.ss.android.socialbase.appdownloader.b.1
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0089b
                        public boolean a(@NonNull Context context2) {
                            return b.d(context2);
                        }
                    });
                    return b(context, fVar.b());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !e(context)) {
                com.ss.android.socialbase.appdownloader.a.b bVar = new com.ss.android.socialbase.appdownloader.a.b(context);
                if (bVar.a()) {
                    a(context, intent, i2, jSONObject, new InterfaceC0089b() { // from class: com.ss.android.socialbase.appdownloader.b.2
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0089b
                        public boolean a(@NonNull Context context2) {
                            return b.e(context2);
                        }
                    });
                    return b(context, bVar.b());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.f.d.b() && Build.VERSION.SDK_INT < 26) {
            return d(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return e(context);
        }
        return true;
    }

    public static boolean a() {
        return e.a == 1;
    }

    public static void a(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void a(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0089b interfaceC0089b) {
        if (f3304c != null) {
            com.ss.android.socialbase.downloader.a.a.a().b(f3304c);
            f3304c = null;
        }
        f3304c = new a(context, intent, i2, jSONObject, interfaceC0089b);
        com.ss.android.socialbase.downloader.a.a.a().a(f3304c);
    }

    public static boolean a(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String a(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    public static void a(c cVar) {
        f3303b = cVar;
    }
}
