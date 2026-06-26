package e.a.a.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import f.v;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CrashHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements Thread.UncaughtExceptionHandler {

    @NotNull
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f5542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final HashMap<String, String> f5543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"SimpleDateFormat"})
    @NotNull
    public final SimpleDateFormat f5544e;

    public l(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        this.a = context;
        this.f5541b = l.class.getSimpleName();
        this.f5542c = Thread.getDefaultUncaughtExceptionHandler();
        this.f5543d = new HashMap<>();
        this.f5544e = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NotNull Thread thread, @NotNull Throwable th) {
        String string;
        f.c0.c.j.e(thread, "thread");
        f.c0.c.j.e(th, "ex");
        e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
        e.a.a.f.s.j.f(this.a);
        Context context = this.a;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                if (str == null) {
                    str = "null";
                }
                String str2 = packageInfo.versionCode + "";
                HashMap<String, String> map = this.f5543d;
                f.c0.c.j.d(str, "versionName");
                map.put("versionName", str);
                this.f5543d.put("versionCode", str2);
            }
            f.h.m11constructorimpl(v.a);
        } catch (Throwable th2) {
            f.h.m11constructorimpl(c.b.a.m.f.m1(th2));
        }
        Field[] declaredFields = Build.class.getDeclaredFields();
        try {
            f.c0.c.j.d(declaredFields, "fields");
            int length = declaredFields.length;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                i2++;
                field.setAccessible(true);
                Object obj = field.get(null);
                if (obj != null && (string = obj.toString()) != null) {
                    HashMap<String, String> map2 = this.f5543d;
                    String name = field.getName();
                    f.c0.c.j.d(name, "field.name");
                    map2.put(name, string);
                }
            }
            f.h.m11constructorimpl(v.a);
        } catch (Throwable th3) {
            f.h.m11constructorimpl(c.b.a.m.f.m1(th3));
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f5543d.entrySet()) {
            c.a.a.a.a.z(sb, entry.getKey(), "=", entry.getValue(), "\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String string2 = stringWriter.toString();
        f.c0.c.j.d(string2, "writer.toString()");
        sb.append(string2);
        String str3 = "crash-" + ((Object) this.f5544e.format(new Date())) + '-' + System.currentTimeMillis() + ".log";
        File externalCacheDir = this.a.getExternalCacheDir();
        if (externalCacheDir != null) {
            String[] strArr = {"crash"};
            f.c0.c.j.e(externalCacheDir, "root");
            f.c0.c.j.e(strArr, "subDirFiles");
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            f.c0.c.j.e(externalCacheDir, "root");
            f.c0.c.j.e(strArr2, "subDirFiles");
            StringBuilder sb2 = new StringBuilder(externalCacheDir.getAbsolutePath());
            for (String str4 : strArr2) {
                if (str4.length() > 0) {
                    sb2.append(File.separator);
                    sb2.append(str4);
                }
            }
            String string3 = sb2.toString();
            f.c0.c.j.d(string3, "path.toString()");
            File[] fileArrListFiles = new File(string3).listFiles();
            if (fileArrListFiles != null) {
                int length2 = fileArrListFiles.length;
                int i3 = 0;
                while (i3 < length2) {
                    File file = fileArrListFiles[i3];
                    File[] fileArr = fileArrListFiles;
                    int i4 = length2;
                    if (file.lastModified() < System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7L)) {
                        file.delete();
                    }
                    i3++;
                    fileArrListFiles = fileArr;
                    length2 = i4;
                }
            }
            File fileA = FileUtils.a.a(externalCacheDir, "crash", str3);
            String string4 = sb.toString();
            f.c0.c.j.d(string4, "sb.toString()");
            f.b0.d.f(fileA, string4, null, 2);
        }
        c.b.a.m.f.S3(this.a, c.b.a.m.f.C2(th));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f5542c;
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
