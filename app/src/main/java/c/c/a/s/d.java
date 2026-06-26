package c.c.a.s;

import android.text.TextUtils;
import c.b.a.m.f;
import c.c.a.q;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.plugin.PluginProvider;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {
    public File a = null;

    public class a implements FileFilter {
        public a(d dVar) {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            if (file != null && (file.getName().endsWith(".apk") || file.getName().endsWith(".jar"))) {
                PluginManager.getInstance().asyncInstall(file);
                return true;
            }
            if (file.getAbsolutePath().endsWith(".temp") && System.currentTimeMillis() - file.lastModified() < 259200000) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file)));
                return false;
            }
            f.F(file);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file)));
            return false;
        }
    }

    public final void a(File file) {
        PluginProvider pluginProvider;
        File fileProvideBuiltInPlugin;
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
        file.listFiles(new a(this));
        if (file.equals(this.a) || (pluginProvider = q.a().f779c.getPluginProvider()) == null || (fileProvideBuiltInPlugin = pluginProvider.provideBuiltInPlugin()) == null) {
            return;
        }
        PluginManager.getInstance().asyncInstall(fileProvideBuiltInPlugin);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            String downloadDir = PluginDirHelper.getDownloadDir();
            for (String str : Zeus.getAppApplication().getAssets().list("plugins/")) {
                if (str.endsWith(".apk")) {
                    String strConcat = "plugins/".concat(str);
                    File file = new File(downloadDir, str);
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable releaseCopyFile " + strConcat + " --> " + file.getAbsolutePath());
                    f.G(Zeus.getAppApplication().getAssets().open(strConcat), new FileOutputStream(file), 0L);
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        a(new File(PluginDirHelper.getDownloadDir()));
        String pushDir = PluginDirHelper.getPushDir();
        if (TextUtils.isEmpty(pushDir)) {
            return;
        }
        File file2 = new File(pushDir);
        this.a = file2;
        a(file2);
    }
}
