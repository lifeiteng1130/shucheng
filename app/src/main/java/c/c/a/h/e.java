package c.c.a.h;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.download.ZeusPluginListener;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static volatile e a;

    public class a extends AbsDownloadListener {
        public final /* synthetic */ ZeusPluginListener a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f726d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f727e;

        public a(e eVar, ZeusPluginListener zeusPluginListener, String str, int i2, int i3, String str2) {
            this.a = zeusPluginListener;
            this.f724b = str;
            this.f725c = i2;
            this.f726d = i3;
            this.f727e = str2;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "download onFailed : " + this.f724b + " : " + this.f725c, baseException);
            e.a("download_finish", baseException != null ? baseException.getErrorCode() + 21100 : 22000, this.f724b, this.f725c, -1L, baseException);
            ZeusPluginListener zeusPluginListener = this.a;
            if (zeusPluginListener != null) {
                zeusPluginListener.onEvent(13, "download failed," + baseException.getErrorMessage());
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onProgress(DownloadInfo downloadInfo) {
            ZeusPluginListener zeusPluginListener = this.a;
            if (zeusPluginListener != null) {
                zeusPluginListener.onEvent(11, ((downloadInfo.getCurBytes() * 1.0f) / downloadInfo.getTotalBytes()) + "%");
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onStart(DownloadInfo downloadInfo) {
            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "download start : " + this.f724b + " : " + this.f725c);
            e.a("download_start", 20000, this.f724b, this.f725c, -1L, null);
            ZeusPluginListener zeusPluginListener = this.a;
            if (zeusPluginListener != null) {
                zeusPluginListener.onEvent(10, "start download " + this.f724b);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo downloadInfo) throws Throwable {
            String str;
            int i2;
            if (downloadInfo != null) {
                ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "download onSuccessed : " + this.f724b + " : " + this.f725c);
                int i3 = this.f726d;
                String str2 = this.f727e;
                String str3 = this.f724b;
                int i4 = this.f725c;
                ZeusPluginListener zeusPluginListener = this.a;
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                String strA = null;
                boolean z = false;
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    if (messageDigest != null) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i5 = fileInputStream.read(bArr, 0, 8192);
                            if (i5 <= 0) {
                                break;
                            } else {
                                messageDigest.update(bArr, 0, i5);
                            }
                        }
                        fileInputStream.close();
                        strA = c.c.a.x.a.a(messageDigest.digest());
                    }
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(strA) && strA.equals(str2)) {
                    z = true;
                }
                boolean zG = c.c.a.n.b.g(file);
                if (z && zG) {
                    e.a("download_finish", 21000, str3, i4, downloadInfo.getDownloadTime(), null);
                    if (i3 == 0 || i3 == 1) {
                        if (zeusPluginListener != null) {
                            zeusPluginListener.onEvent(12, "download success, ".concat(String.valueOf(str3)));
                        }
                        if (zeusPluginListener != null) {
                            zeusPluginListener.onEvent(20, "start install ".concat(String.valueOf(str3)));
                        }
                        PluginManager.getInstance().asyncInstall(file, zeusPluginListener);
                        return;
                    }
                    return;
                }
                if (zG) {
                    str = "Check md5 failed. " + strA + " != " + str2;
                    i2 = 22001;
                } else {
                    str = "PluginAbi not match hostAbi[" + c.c.a.n.b.a() + "] md5[" + str2 + "]";
                    i2 = 22002;
                }
                e.a("download_finish", i2, str3, i4, downloadInfo.getDownloadTime(), new RuntimeException(str));
                file.delete();
                if (zeusPluginListener != null) {
                    zeusPluginListener.onEvent(13, str);
                }
            }
        }
    }

    public class b implements IDownloadInterceptor {
        public final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ZeusPluginListener f729c;

        public b(e eVar, String str, int i2, ZeusPluginListener zeusPluginListener) {
            this.a = str;
            this.f728b = i2;
            this.f729c = zeusPluginListener;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
        public final boolean intercepte() {
            boolean z;
            Plugin plugin = Zeus.getPlugin(this.a);
            int version = plugin != null ? plugin.getVersion() : 0;
            int i2 = this.f728b;
            if (i2 > version) {
                String str = this.a;
                try {
                    for (File file : new File(PluginDirHelper.getDownloadDir()).listFiles()) {
                        if (file.getName().contains(str)) {
                            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0);
                            if (TextUtils.equals(packageInfo.packageName, str) && packageInfo.versionCode == i2) {
                                z = true;
                                break;
                            }
                        }
                    }
                } catch (Exception e2) {
                    ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "isPluginDownloaded failed.", e2);
                }
                z = false;
                if (!z) {
                    return false;
                }
            }
            ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "download intercept : " + this.a + " : " + this.f728b);
            ZeusPluginListener zeusPluginListener = this.f729c;
            if (zeusPluginListener != null) {
                zeusPluginListener.onEvent(13, this.f728b <= version ? "EVENT_INTERCEPT_ALREADY_INSTALL" : "EVENT_INTERCEPT_DOWNLOAD_FILE_EXISTS");
            }
            return true;
        }
    }

    public static void a(String str, int i2, String str2, int i3, long j2, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", c.b.a.m.f.t(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", c.b.a.m.f.t(str2));
            jSONObject.putOpt("version_code", c.b.a.m.f.t(Integer.valueOf(i3)));
            jSONObject2.putOpt("duration", c.b.a.m.f.t(Long.valueOf(j2)));
            jSONObject3.putOpt("throwable", c.b.a.m.f.u(th));
            jSONObject3.putOpt("timestamp", c.b.a.m.f.t(Long.valueOf(System.currentTimeMillis())));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c.c.a.d.b.a().b(str, jSONObject, jSONObject2, jSONObject3);
    }

    public final void b(@NonNull String str, @NonNull String str2, int i2, @NonNull String str3, boolean z, @NonNull List<String> list, int i3, @Nullable ZeusPluginListener zeusPluginListener) {
        com.ss.android.socialbase.downloader.downloader.b.with(Zeus.getAppApplication()).url(str).name(String.format("%s_%s_%s.jar", i3 == 1 ? "sc" : i3 == 0 ? "auto" : "", str2, str3)).onlyWifi(z).savePath(PluginDirHelper.getDownloadDir()).retryCount(5).mimeType("mime_type_plugin").backUpUrls(list).subThreadListener(new a(this, zeusPluginListener, str2, i2, i3, str3)).interceptor(new b(this, str2, i2, zeusPluginListener)).download();
    }
}
