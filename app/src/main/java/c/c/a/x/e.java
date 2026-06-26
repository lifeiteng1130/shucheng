package c.c.a.x;

import android.content.SharedPreferences;
import c.c.a.q;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static volatile e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f812b = Zeus.getAppApplication().getSharedPreferences(ZeusConstants.BASE_LIB_NAME + "_meta_data_sp", 0);

    public static e b() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    public final int a(String str) {
        int i2 = this.f812b.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i2);
        return i2;
    }

    public final void c(String str, int i2, boolean z) {
        SharedPreferences.Editor editorEdit = this.f812b.edit();
        String str2 = "INSTALLED_" + str + "-" + i2;
        if (z) {
            editorEdit.putBoolean(str2, true);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
    }

    public final boolean d(String str, int i2) {
        return this.f812b.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i2)), false);
    }

    public final void e(String str) {
        SharedPreferences.Editor editorEdit = this.f812b.edit();
        editorEdit.putBoolean("OFFLINE__" + q.a().f779c.getHostVersionCode() + "_" + str, true);
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markOfflineFlag packageName=" + str + " hostUpdateVerCode= " + q.a().f779c.getHostVersionCode());
    }

    public final void f(String str) {
        SharedPreferences.Editor editorEdit = this.f812b.edit();
        editorEdit.remove("OFFLINE__" + q.a().f779c.getHostVersionCode() + "_" + str);
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils clearOfflineFlag packageName=" + str + " hostUpdateVerCode= " + q.a().f779c.getHostVersionCode());
    }

    public final boolean g(String str) {
        return this.f812b.getBoolean("OFFLINE__" + q.a().f779c.getHostVersionCode() + "_" + str, false);
    }

    public final void h(String str) {
        SharedPreferences.Editor editorEdit = this.f812b.edit();
        editorEdit.putBoolean("DELETED__".concat(String.valueOf(str)), true);
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markDeletedFlag packageName=".concat(String.valueOf(str)));
    }
}
