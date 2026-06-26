package com.tencent.bugly.beta.global;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.bugly.proguard.C0323p;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int a(Context context) {
        TelephonyManager telephonyManager;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        return 0;
                }
            }
        } catch (Exception e2) {
            if (!X.b(e2)) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public static String b(String str) {
        return new com.tencent.bugly.beta.utils.c(str).a();
    }

    public static void b(String str, String str2) {
        SharedPreferences sharedPreferences = e.f3983b.D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static void b(String str, boolean z) {
        SharedPreferences sharedPreferences = e.f3983b.D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static BitmapDrawable a(Bitmap bitmap, int i2, int i3, float f2) {
        DisplayMetrics displayMetrics = e.f3983b.E;
        int i4 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.8f);
        if (bitmap == null || i2 * i3 > i4) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i2, i3);
        RectF rectF = new RectF(rect);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        canvas.drawRect(0.0f, f2, i2, i3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
        return new BitmapDrawable(bitmapCreateBitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050 A[Catch: Exception -> 0x00f0, TryCatch #0 {Exception -> 0x00f0, blocks: (B:12:0x0014, B:15:0x001f, B:17:0x002e, B:24:0x0048, B:26:0x0050, B:28:0x0059, B:31:0x006a, B:48:0x00c3, B:50:0x00cb, B:53:0x00db, B:57:0x00e7, B:49:0x00c6, B:37:0x00a0, B:34:0x0086, B:30:0x0063, B:21:0x003c), top: B:65:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db A[Catch: Exception -> 0x00f0, TryCatch #0 {Exception -> 0x00f0, blocks: (B:12:0x0014, B:15:0x001f, B:17:0x002e, B:24:0x0048, B:26:0x0050, B:28:0x0059, B:31:0x006a, B:48:0x00c3, B:50:0x00cb, B:53:0x00db, B:57:0x00e7, B:49:0x00c6, B:37:0x00a0, B:34:0x0086, B:30:0x0063, B:21:0x003c), top: B:65:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap a(android.content.Context r18, int r19, java.lang.Object... r20) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(android.content.Context, int, java.lang.Object[]):android.graphics.Bitmap");
    }

    public static boolean a(Context context, File file, String str) throws Throwable {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(".apk")) {
                    String strA = ca.a(file, "MD5");
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str.toUpperCase(), strA)) {
                        X.c("md5 error [file md5: %s] [target md5: %s]", strA, str);
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("chmod 777 ");
                    sb.append(file.getAbsolutePath());
                    Runtime.getRuntime().exec(sb.toString());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                        Class.forName("androidx.core.content.FileProvider");
                        Class[] clsArr = {Context.class, String.class, File.class};
                        Object[] objArr = new Object[3];
                        objArr[0] = context;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(com.tencent.bugly.crashreport.common.info.a.a(context).f4098g);
                        sb2.append(".fileProvider");
                        objArr[1] = sb2.toString();
                        objArr[2] = file;
                        Uri uri = (Uri) ca.a("androidx.core.content.FileProvider", "getUriForFile", null, clsArr, objArr);
                        if (uri == null) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("file location is ");
                            sb3.append(file.toString());
                            X.b(sb3.toString(), new Object[0]);
                            X.b("install failed, contentUri is null!", new Object[0]);
                            return false;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("contentUri is ");
                        sb4.append(uri);
                        X.a(sb4.toString(), new Object[0]);
                        intent.setDataAndType(uri, AdBaseConstants.MIME_APK);
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
                    }
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    return true;
                }
            } catch (Exception e2) {
                if (!X.a(e2)) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean a(File file, String str, String str2) throws Throwable {
        if (file != null) {
            try {
                if (file.exists()) {
                    String strA = ca.a(file, str2);
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str.toUpperCase(), strA)) {
                        return true;
                    }
                    X.c("checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]", strA, str);
                    return false;
                }
            } catch (Exception unused) {
                X.b("checkFileUniqueId exception", new Object[0]);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x006d A[Catch: IOException -> 0x0069, TRY_LEAVE, TryCatch #0 {IOException -> 0x0069, blocks: (B:51:0x0065, B:55:0x006d), top: B:60:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.io.File r3, java.io.File r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 == 0) goto L75
            r1 = 0
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r2 == 0) goto L75
            boolean r2 = r3.isDirectory()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r2 == 0) goto L12
            goto L75
        L12:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r4 = 1048576(0x100000, float:1.469368E-39)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
        L20:
            int r1 = r2.read(r4)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            if (r1 <= 0) goto L2a
            r3.write(r4, r0, r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            goto L20
        L2a:
            r0 = 1
            r2.close()     // Catch: java.io.IOException -> L32
            r3.close()     // Catch: java.io.IOException -> L32
            goto L5c
        L32:
            r3 = move-exception
            r3.printStackTrace()
            goto L5c
        L37:
            r4 = move-exception
            goto L5f
        L39:
            r4 = move-exception
            goto L40
        L3b:
            r3 = move-exception
            goto L61
        L3d:
            r3 = move-exception
            r4 = r3
            r3 = r1
        L40:
            r1 = r2
            goto L48
        L42:
            r3 = move-exception
            r4 = r1
            goto L63
        L45:
            r3 = move-exception
            r4 = r3
            r3 = r1
        L48:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.io.IOException -> L51
            goto L53
        L51:
            r3 = move-exception
            goto L59
        L53:
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.io.IOException -> L51
            goto L5c
        L59:
            r3.printStackTrace()
        L5c:
            return r0
        L5d:
            r4 = move-exception
            r2 = r1
        L5f:
            r1 = r3
            r3 = r4
        L61:
            r4 = r1
            r1 = r2
        L63:
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.io.IOException -> L69
            goto L6b
        L69:
            r4 = move-exception
            goto L71
        L6b:
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.io.IOException -> L69
            goto L74
        L71:
            r4.printStackTrace()
        L74:
            throw r3
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(java.io.File, java.io.File):boolean");
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.delete()) {
                X.b("cannot delete file:%s", file2.getAbsolutePath());
            }
        }
    }

    public static synchronized <T extends Parcelable> boolean a(String str, T t) {
        boolean z = false;
        if (t == null) {
            return false;
        }
        byte[] bArrA = ca.a(t);
        if (bArrA != null) {
            if (C0323p.a.a(PointerIconCompat.TYPE_HAND, str, bArrA)) {
                z = true;
            }
        }
        return z;
    }

    public static synchronized <T extends Parcelable> T a(String str, Parcelable.Creator<T> creator) {
        Map<String, byte[]> mapC = C0323p.a.c();
        if (mapC == null) {
            return null;
        }
        byte[] bArr = mapC.get(str);
        if (bArr != null && bArr.length > 0) {
            return (T) ca.a(bArr, creator);
        }
        return null;
    }

    public static synchronized boolean a(String str) {
        return C0323p.a.a(str);
    }

    public static String a(String str, String str2) {
        SharedPreferences sharedPreferences = e.f3983b.D;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public static boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences = e.f3983b.D;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
    }

    public static String a(Context context, String str) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return String.valueOf(obj);
        } catch (Exception e2) {
            StringBuilder sbR = c.a.a.a.a.r("getManifestMetaDataValue exception:");
            sbR.append(e2.getMessage());
            X.b(a.class, sbR.toString(), new Object[0]);
            return null;
        }
    }
}
