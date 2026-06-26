package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.jsoup.helper.DataUtil;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a(Context context, File file, File file2) {
        AssetManager assets = context.getAssets();
        try {
            if (Arrays.binarySearch(assets.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) < 0) {
                return false;
            }
            String str = CustomPkgConstants.getAssetPluginDir() + File.separator + CustomPkgConstants.getAssetPluginName();
            String str2 = Sig.ASSET_PLUGIN_SIG;
            if (str2 == null) {
                str2 = "";
            }
            StringUtil.writeTo("1292#####" + str2, file2);
            if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                return FileUtil.copyTo(assets.open(str), file);
            }
            InputStream inputStreamOpen = assets.open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName(DataUtil.defaultCharset));
            byte[] bArr = new byte[1024];
            int length = bytes.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = inputStreamOpen.read(bArr);
                if (i4 <= 0) {
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return true;
                }
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = i3 + 1;
                    if (i3 >= 64) {
                        bArr[i5] = (byte) (bytes[i2 % length] ^ bArr[i5]);
                        i2++;
                    }
                    i5++;
                    i3 = i6;
                }
                fileOutputStream.write(bArr, 0, i4);
            }
        } catch (Throwable th) {
            GDTLogger.e("插件加载失败", th);
            a.a(th, th.getMessage());
            return false;
        }
    }
}
