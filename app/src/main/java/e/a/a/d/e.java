package e.a.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.commonsdk.statistics.SdkVersion;
import io.legado.app.help.ReadBookConfig;
import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: AppConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    @NotNull
    public static final e a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f5517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static String f5518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f5519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f5520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f5521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f5522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f5523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f5524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f5525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f5526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f5527l;
    public static int m;

    static {
        Context contextG = k.d.a.h.g();
        String str = "";
        f.c0.c.j.e(contextG, "<this>");
        try {
            ApplicationInfo applicationInfo = contextG.getPackageManager().getApplicationInfo(contextG.getPackageName(), 128);
            f.c0.c.j.d(applicationInfo, "pm.getApplicationInfo(packageName, PackageManager.GET_META_DATA)");
            String string = applicationInfo.metaData.getString("channel");
            if (string != null) {
                str = string;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        f5517b = f.c0.c.j.a(str, "google");
        f5518c = a.i();
        f5519d = f.c0.c.j.a(c.b.a.m.f.O2(k.d.a.h.g(), "themeMode", null, 2), ExifInterface.GPS_MEASUREMENT_3D);
        f5520e = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionTopLeft", 2);
        f5521f = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionTopCenter", 2);
        f5522g = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionTopRight", 1);
        f5523h = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionMiddleLeft", 2);
        f5524i = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionMiddleCenter", 0);
        f5525j = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionMiddleRight", 1);
        f5526k = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionBottomLeft", 2);
        f5527l = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionBottomCenter", 1);
        m = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionBottomRight", 1);
    }

    public final boolean a() {
        return c.b.a.m.f.K2(k.d.a.h.g(), "changeSourceCheckAuthor", false, 2);
    }

    public final int b() {
        return c.b.a.m.f.M2(k.d.a.h.g(), "chineseConverterType", 0, 2);
    }

    public final int c() throws IllegalAccessException, InvocationTargetException {
        Context contextG = k.d.a.h.g();
        e.a.a.c.c cVar = e.a.a.c.c.a;
        return c.b.a.m.f.L2(contextG, "barElevation", e.a.a.c.c.f5503i);
    }

    @NotNull
    public final String d() {
        String strO2 = c.b.a.m.f.O2(k.d.a.h.g(), "exportCharset", null, 2);
        return strO2 == null || f.h0.k.s(strO2) ? DataUtil.defaultCharset : strO2;
    }

    public final boolean e() {
        return c.b.a.m.f.K2(k.d.a.h.g(), "webDavCacheBackup", false, 2);
    }

    public final boolean f() {
        return c.b.a.m.f.J2(k.d.a.h.g(), "exportUseReplace", true);
    }

    public final boolean g() {
        return c.b.a.m.f.K2(k.d.a.h.g(), "importKeepName", false, 2);
    }

    public final int h() {
        return c.b.a.m.f.L2(k.d.a.h.g(), "preDownloadNum", 10);
    }

    public final String i() {
        String strO2 = c.b.a.m.f.O2(k.d.a.h.g(), TTDownloadField.TT_USERAGENT, null, 2);
        return strO2 == null || f.h0.k.s(strO2) ? "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36" : strO2;
    }

    public final boolean j() {
        return c.b.a.m.f.J2(k.d.a.h.g(), "showUnread", true);
    }

    public final int k() {
        return c.b.a.m.f.L2(k.d.a.h.g(), "threadCount", 16);
    }

    public final int l() {
        return c.b.a.m.f.L2(k.d.a.h.g(), "ttsSpeechRate", 5);
    }

    public final boolean m() {
        return n(k.d.a.h.g());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean n(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e("themeMode", "key");
        String string = c.b.a.m.f.i2(context).getString("themeMode", "0");
        if (string != null) {
            switch (string.hashCode()) {
                case 49:
                    if (!string.equals(SdkVersion.MINI_VERSION)) {
                    }
                case 50:
                    if (!string.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    }
                case 51:
                    if (!string.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    }
            }
        }
        f.c0.c.j.e(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public final void o(@Nullable String str) {
        if (str == null || str.length() == 0) {
            c.b.a.m.f.H4(k.d.a.h.g(), "backupUri");
        } else {
            c.b.a.m.f.r4(k.d.a.h.g(), "backupUri", str);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1593856184:
                    if (str.equals("clickActionMiddleCenter")) {
                        f5524i = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionMiddleCenter", 2);
                        break;
                    }
                    break;
                case -1437805108:
                    if (str.equals("clickActionTopCenter")) {
                        f5521f = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionTopCenter", 2);
                        break;
                    }
                    break;
                case -764080481:
                    if (str.equals("useZhLayout")) {
                        ReadBookConfig.INSTANCE.setUseZhLayout(c.b.a.m.f.K2(k.d.a.h.g(), "useZhLayout", false, 2));
                        break;
                    }
                    break;
                case -448057915:
                    if (str.equals("clickActionTopRight")) {
                        f5522g = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionTopRight", 2);
                        break;
                    }
                    break;
                case -153183426:
                    if (str.equals("clickActionTopLeft")) {
                        f5520e = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionTopLeft", 2);
                        break;
                    }
                    break;
                case 17176332:
                    if (str.equals("themeMode")) {
                        f5519d = f.c0.c.j.a(c.b.a.m.f.O2(k.d.a.h.g(), "themeMode", null, 2), ExifInterface.GPS_MEASUREMENT_3D);
                        break;
                    }
                    break;
                case 255605199:
                    if (str.equals("readBodyToLh")) {
                        ReadBookConfig.INSTANCE.setReadBodyToLh(c.b.a.m.f.J2(k.d.a.h.g(), "readBodyToLh", true));
                        break;
                    }
                    break;
                case 311430650:
                    if (str.equals(TTDownloadField.TT_USERAGENT)) {
                        f5518c = i();
                        break;
                    }
                    break;
                case 317809139:
                    if (str.equals("clickActionBottomRight")) {
                        m = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionBottomRight", 2);
                        break;
                    }
                    break;
                case 829237086:
                    if (str.equals("clickActionBottomCenter")) {
                        f5527l = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionBottomCenter", 2);
                        break;
                    }
                    break;
                case 1118447952:
                    if (str.equals("clickActionBottomLeft")) {
                        f5526k = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionBottomLeft", 2);
                        break;
                    }
                    break;
                case 1348023497:
                    if (str.equals("clickActionMiddleRight")) {
                        f5525j = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionMiddleRight", 2);
                        break;
                    }
                    break;
                case 1982964666:
                    if (str.equals("clickActionMiddleLeft")) {
                        f5523h = c.b.a.m.f.L2(k.d.a.h.g(), "clickActionMiddleLeft", 2);
                        break;
                    }
                    break;
            }
        }
    }

    public final void p(boolean z) {
        if (m() != z) {
            if (z) {
                c.b.a.m.f.r4(k.d.a.h.g(), "themeMode", ExifInterface.GPS_MEASUREMENT_2D);
            } else {
                c.b.a.m.f.r4(k.d.a.h.g(), "themeMode", SdkVersion.MINI_VERSION);
            }
        }
    }
}
