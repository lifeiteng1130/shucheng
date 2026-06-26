package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: StoreHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static d a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f5265b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f5266c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5267e = "mobclick_agent_user_";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5268f = "mobclick_agent_header_";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5269g = "mobclick_agent_cached_";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f5270d;

    /* JADX INFO: compiled from: StoreHelper.java */
    public static class a {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private File f5271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private FilenameFilter f5272c;

        public a(Context context) {
            this(context, ".um");
        }

        public boolean a() {
            File[] fileArrListFiles = this.f5271b.listFiles();
            return fileArrListFiles != null && fileArrListFiles.length > 0;
        }

        public void b() {
            File[] fileArrListFiles = this.f5271b.listFiles(this.f5272c);
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }

        public int c() {
            File[] fileArrListFiles = this.f5271b.listFiles(this.f5272c);
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return 0;
            }
            return fileArrListFiles.length;
        }

        public a(Context context, String str) {
            this.a = 10;
            this.f5272c = new FilenameFilter() { // from class: com.umeng.commonsdk.statistics.common.d.a.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("um");
                }
            };
            File file = new File(context.getFilesDir(), str);
            this.f5271b = file;
            if (file.exists() && this.f5271b.isDirectory()) {
                return;
            }
            this.f5271b.mkdir();
        }

        public void a(b bVar) {
            File file;
            File[] fileArrListFiles = this.f5271b.listFiles(this.f5272c);
            if (fileArrListFiles != null && fileArrListFiles.length >= 10) {
                Arrays.sort(fileArrListFiles);
                int length = fileArrListFiles.length - 10;
                for (int i2 = 0; i2 < length; i2++) {
                    fileArrListFiles[i2].delete();
                }
            }
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            bVar.a(this.f5271b);
            int length2 = fileArrListFiles.length;
            for (int i3 = 0; i3 < length2; i3++) {
                try {
                } catch (Throwable unused) {
                    file = fileArrListFiles[i3];
                }
                if (bVar.b(fileArrListFiles[i3])) {
                    file = fileArrListFiles[i3];
                    file.delete();
                }
            }
            bVar.c(this.f5271b);
        }

        public void a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                HelperUtils.writeFile(new File(this.f5271b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: StoreHelper.java */
    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    public d(Context context) {
        this.f5270d = new a(context);
    }

    public static synchronized d a(Context context) {
        f5265b = context.getApplicationContext();
        f5266c = context.getPackageName();
        if (a == null) {
            a = new d(context);
        }
        return a;
    }

    private SharedPreferences f() {
        Context context = f5265b;
        StringBuilder sbR = c.a.a.a.a.r(f5267e);
        sbR.append(f5266c);
        return context.getSharedPreferences(sbR.toString(), 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f5265b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f5265b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences sharedPreferencesF = f();
            String string = sharedPreferencesF.getString("au_p", null);
            String string2 = sharedPreferencesF.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f5265b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i2).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f5265b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f5265b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = f().edit();
        editorEdit.putString("au_p", str);
        editorEdit.putString("au_u", str2);
        editorEdit.commit();
    }
}
