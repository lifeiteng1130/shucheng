package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class ca {
    private static Map<String, String> a;

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (Throwable th) {
            if (X.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static Parcel d(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        return parcelObtain;
    }

    public static String a(long j2) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j2));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static byte[] b(byte[] bArr, int i2) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i2 == 2 ? "Gzip" : "zip";
        X.a("[Util] Zip %d bytes data with type %s", objArr);
        try {
            ha haVarA = ga.a(i2);
            if (haVarA == null) {
                return null;
            }
            return haVarA.a(bArr);
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static void c(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.io.File r6, java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ca.a(java.io.File, java.lang.String, java.lang.String):byte[]");
    }

    public static boolean c(String str) {
        if (b(str)) {
            return false;
        }
        if (str.length() > 255) {
            X.c("URL(%s)'s length is larger than 255.", str);
            return false;
        }
        if (str.toLowerCase().startsWith("http")) {
            return true;
        }
        X.c("URL(%s) is not start with \"http\".", str);
        return false;
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (X.b(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static void c(String str, String str2) {
        if (com.tencent.bugly.crashreport.common.info.a.m() == null || com.tencent.bugly.crashreport.common.info.a.m().qa == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.m().qa.edit().putString(str, str2).apply();
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static byte[] b(long j2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j2);
            return sb.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long b(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("keys", arrayList);
            bundle.putStringArrayList("values", arrayList2);
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        HashMap map = null;
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("values");
        if (stringArrayList != null && stringArrayList2 != null && stringArrayList.size() == stringArrayList2.size()) {
            map = new HashMap(stringArrayList.size());
            for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                map.put(stringArrayList.get(i2), stringArrayList2.get(i2));
            }
        } else {
            X.b("map parcel error!", new Object[0]);
        }
        return map;
    }

    public static boolean b(Context context) {
        try {
            return com.tencent.bugly.crashreport.common.info.a.m().C();
        } catch (SecurityException unused) {
            X.b("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return true;
        } catch (Exception e2) {
            if (X.a(e2)) {
                return true;
            }
            e2.printStackTrace();
            return true;
        }
    }

    public static boolean b(Context context, String str) {
        X.a("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            X.a("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            X.b(th);
            return false;
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i2 == 2 ? "Gzip" : "zip";
        X.a("[Util] Unzip %d bytes data with type %s", objArr);
        try {
            ha haVarA = ga.a(i2);
            if (haVarA == null) {
                return null;
            }
            return haVarA.b(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                X.e(th.getMessage(), new Object[0]);
            } else if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & ExifInterface.MARKER);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static String b(String str, String str2) {
        return (com.tencent.bugly.crashreport.common.info.a.m() == null || com.tencent.bugly.crashreport.common.info.a.m().qa == null) ? "" : com.tencent.bugly.crashreport.common.info.a.m().qa.getString(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    public static String a(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        ?? r0 = 0;
        if (file != null && file.exists()) {
            ?? CanRead = file.canRead();
            try {
                try {
                    if (CanRead != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (IOException e2) {
                            e = e2;
                            fileInputStream = null;
                        } catch (NoSuchAlgorithmException e3) {
                            e = e3;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (r0 != 0) {
                                try {
                                    r0.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            MessageDigest messageDigest = MessageDigest.getInstance(str);
                            byte[] bArr = new byte[102400];
                            while (true) {
                                int i2 = fileInputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                messageDigest.update(bArr, 0, i2);
                            }
                            String strA = a(messageDigest.digest());
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                            return strA;
                        } catch (IOException e6) {
                            e = e6;
                            if (!X.b(e)) {
                                e.printStackTrace();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        } catch (NoSuchAlgorithmException e7) {
                            e = e7;
                            if (!X.b(e)) {
                                e.printStackTrace();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        }
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                r0 = CanRead;
            }
        }
        return null;
    }

    public static boolean a(File file, File file2, int i2) {
        ZipOutputStream zipOutputStream;
        X.a("rqdp{  ZF start}", new Object[0]);
        if (file != null && file2 != null && !file.equals(file2)) {
            if (file.exists() && file.canRead()) {
                try {
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (Throwable th) {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                }
                if (!file2.exists() || !file2.canRead()) {
                    return false;
                }
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                        try {
                            zipOutputStream.setMethod(8);
                            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                            if (i2 <= 1000) {
                                i2 = 1000;
                            }
                            byte[] bArr = new byte[i2];
                            while (true) {
                                int i3 = fileInputStream2.read(bArr);
                                if (i3 <= 0) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, i3);
                            }
                            zipOutputStream.flush();
                            zipOutputStream.closeEntry();
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                zipOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            X.a("rqdp{  ZF end}", new Object[0]);
                            return true;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            try {
                                if (!X.b(th)) {
                                    th.printStackTrace();
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (zipOutputStream != null) {
                                    try {
                                        zipOutputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                X.a("rqdp{  ZF end}", new Object[0]);
                                return false;
                            } catch (Throwable th3) {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (zipOutputStream != null) {
                                    try {
                                        zipOutputStream.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                X.a("rqdp{  ZF end}", new Object[0]);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        zipOutputStream = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    zipOutputStream = null;
                }
            } else {
                X.e("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
                return false;
            }
        } else {
            X.e("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        }
    }

    public static ArrayList<String> a(Context context, String[] strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Process processExec;
        if (AppInfo.e(context)) {
            return new ArrayList<>(Arrays.asList("unknown(low memory)"));
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
            bufferedReader2 = null;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                arrayList.add(line);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = null;
            }
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } finally {
            }
        }
        bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getErrorStream()));
        while (true) {
            try {
                String line2 = bufferedReader2.readLine();
                if (line2 != null) {
                    arrayList.add(line2);
                } else {
                    try {
                        break;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        bufferedReader.close();
        try {
            bufferedReader2.close();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return arrayList;
    }

    public static String a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (a == null) {
            a = new HashMap();
            ArrayList<String> arrayListA = a(context, new String[]{(new File("/system/bin/sh").exists() && new File("/system/bin/sh").canExecute()) ? "/system/bin/sh" : "sh", "-c", "getprop"});
            if (arrayListA != null && arrayListA.size() > 0) {
                X.a(ca.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern patternCompile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                Iterator<String> it = arrayListA.iterator();
                while (it.hasNext()) {
                    Matcher matcher = patternCompile.matcher(it.next());
                    if (matcher.find()) {
                        a.put(matcher.group(1), matcher.group(2));
                    }
                }
                X.a(ca.class, "Systems properties number: %d.", Integer.valueOf(a.size()));
            }
        }
        return a.containsKey(str) ? a.get(str) : "fail";
    }

    /* JADX WARN: Finally extract failed */
    public static void a(Context context, String str, String str2, int i2) {
        X.a("rqdp{  sv sd start} %s", str);
        if (str2 == null || str2.trim().length() <= 0) {
            return;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = null;
            try {
                if (file.length() >= i2) {
                    fileOutputStream = new FileOutputStream(file, false);
                } else {
                    fileOutputStream = new FileOutputStream(file, true);
                }
                fileOutputStream.write(str2.getBytes(DataUtil.defaultCharset));
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            if (!X.b(th3)) {
                th3.printStackTrace();
            }
        }
        X.a("rqdp{  sv sd end}", new Object[0]);
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.isFile() && file.exists() && file.canWrite()) {
            file.delete();
        }
    }

    public static Context a(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj2, obj);
        } catch (Exception unused) {
        }
    }

    public static Object a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putInt("pluginNum", arrayList.size());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                bundle.putString(c.a.a.a.a.G("pluginKey", i2), (String) arrayList.get(i2));
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                bundle.putString(c.a.a.a.a.d("pluginVal", i3, "plugInId"), ((PlugInBean) arrayList2.get(i3)).a);
                bundle.putString("pluginVal" + i3 + "plugInUUID", ((PlugInBean) arrayList2.get(i3)).f4092c);
                bundle.putString("pluginVal" + i3 + "plugInVersion", ((PlugInBean) arrayList2.get(i3)).f4091b);
            }
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        HashMap map = null;
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iIntValue = ((Integer) bundle.get("pluginNum")).intValue();
        for (int i2 = 0; i2 < iIntValue; i2++) {
            arrayList.add(bundle.getString("pluginKey" + i2));
        }
        for (int i3 = 0; i3 < iIntValue; i3++) {
            arrayList2.add(new PlugInBean(bundle.getString("pluginVal" + i3 + "plugInId"), bundle.getString("pluginVal" + i3 + "plugInVersion"), bundle.getString("pluginVal" + i3 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            map = new HashMap(arrayList.size());
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                map.put(arrayList.get(i4), PlugInBean.class.cast(arrayList2.get(i4)));
            }
        } else {
            X.b("map plugin parcel error!", new Object[0]);
        }
        return map;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel parcelD = d(bArr);
        try {
            return creator.createFromParcel(parcelD);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (parcelD != null) {
                    parcelD.recycle();
                }
                return null;
            } finally {
                if (parcelD != null) {
                    parcelD.recycle();
                }
            }
        }
    }

    public static String a(Context context, int i2, String str) {
        Process processExec = null;
        if (!AppInfo.a(context, "android.permission.READ_LOGS")) {
            X.e("no read_log permission!", new Object[0]);
            return null;
        }
        String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        StringBuilder sb = new StringBuilder();
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
                if (i2 > 0 && sb.length() > i2) {
                    sb.delete(0, sb.length() - i2);
                }
            }
            String string = sb.toString();
            try {
                processExec.getOutputStream().close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                processExec.getInputStream().close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
                processExec.getErrorStream().close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return string;
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\n[error:");
                sb2.append(th.toString());
                sb2.append("]");
                sb.append(sb2.toString());
                return sb.toString();
            } finally {
                if (processExec != null) {
                    try {
                        processExec.getOutputStream().close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        processExec.getInputStream().close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    try {
                        processExec.getErrorStream().close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
    }

    public static Map<String, String> a(int i2, boolean z) {
        HashMap map = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (!z || id != entry.getKey().getId()) {
                int i3 = 0;
                sb.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = value[i3];
                        if (i2 > 0 && sb.length() >= i2) {
                            sb.append("\n[Stack over limit size :" + i2 + " , has been cut!]");
                            break;
                        }
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i3++;
                    }
                    map.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                }
            }
        }
        return map;
    }

    public static boolean a(Context context, String str, long j2) {
        X.a("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j2) {
                    return false;
                }
                X.a("[Util] Lock file (%s) is expired, unlock it.", str);
                b(context, str);
            }
            if (file.createNewFile()) {
                X.a("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            X.a("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            X.b(th);
            return false;
        }
    }

    public static String a(File file, int i2, boolean z) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                    if (i2 > 0 && sb.length() > i2) {
                        if (z) {
                            sb.delete(i2, sb.length());
                            break;
                        }
                        sb.delete(0, sb.length() - i2);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        X.b(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                X.b(e2);
                            }
                        }
                    }
                }
            }
            String string = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e3) {
                X.b(e3);
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static BufferedReader a(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                X.b(th);
            }
        }
        return null;
    }

    public static BufferedReader a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return a(file);
            }
            return null;
        } catch (NullPointerException e2) {
            X.b(e2);
            return null;
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            X.b("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        W wC = W.c();
        if (wC != null) {
            return wC.a(runnable);
        }
        String[] strArrSplit = runnable.getClass().getName().split("\\.");
        return a(runnable, strArrSplit[strArrSplit.length - 1]) != null;
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
