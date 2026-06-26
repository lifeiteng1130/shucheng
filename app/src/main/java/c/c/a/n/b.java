package c.c.a.n;

import android.os.Build;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static String a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, Integer> f777c = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f776b = Build.SUPPORTED_ABIS[0];

    static {
        f777c.put("arm64-v8a", 64);
        f777c.put("armeabi-v7a", 32);
        f777c.put("armeabi", 32);
        f777c.put("x86_64", 64);
        f777c.put("x86", 32);
        f777c.put("mips64", 64);
        f777c.put("mips", 32);
        a = h();
    }

    public static String a() {
        String str = a;
        if (str != null) {
            return str;
        }
        String strH = h();
        a = strH;
        return strH;
    }

    public static Map<String, List<ZipEntry>> b(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (f777c.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + map.toString());
        return map;
    }

    public static void c(File file, File file2, String str) throws Throwable {
        HashSet hashSet;
        ZipFile zipFile = null;
        LinkedList linkedList = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                Map<String, List<ZipEntry>> mapB = b(zipFile2);
                HashMap map = (HashMap) mapB;
                boolean zContainsKey = map.containsKey(a);
                ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + zContainsKey + "], pkg=" + str);
                if (zContainsKey) {
                    if (!map.isEmpty()) {
                        linkedList = new LinkedList();
                        hashSet = new HashSet();
                        String str2 = a;
                        if (str2 == null) {
                            str2 = f776b;
                        }
                        switch (str2) {
                            case "arm64-v8a":
                                d(mapB, "arm64-v8a", linkedList, hashSet);
                                break;
                            case "armeabi-v7a":
                                d(mapB, "armeabi-v7a", linkedList, hashSet);
                                d(mapB, "armeabi", linkedList, hashSet);
                                break;
                            case "armeabi":
                                d(mapB, "armeabi", linkedList, hashSet);
                                break;
                            case "x86_64":
                                d(mapB, "x86_64", linkedList, hashSet);
                                if (linkedList.size() == 0) {
                                    d(mapB, "arm64-v8a", linkedList, hashSet);
                                    break;
                                }
                                break;
                            case "x86":
                                d(mapB, "x86", linkedList, hashSet);
                                if (linkedList.size() == 0) {
                                    d(mapB, "armeabi-v7a", linkedList, hashSet);
                                    d(mapB, "armeabi", linkedList, hashSet);
                                    break;
                                }
                                break;
                            case "mips64":
                                d(mapB, "mips64", linkedList, hashSet);
                                break;
                            case "mips":
                                d(mapB, "mips", linkedList, hashSet);
                                break;
                        }
                    }
                    if (linkedList != null && !linkedList.isEmpty()) {
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            e(zipFile2, (ZipEntry) it.next(), file2);
                        }
                    }
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=".concat(String.valueOf(str)));
                    zipFile2.close();
                    return;
                }
                zipFile2.close();
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void d(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String strSubstring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(strSubstring)) {
                list.add(zipEntry);
                set.add(strSubstring);
            }
        }
    }

    public static void e(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        File file2 = new File(file, zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1));
        int i2 = 0;
        boolean z = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte[] bArr = new byte[8192];
                while (true) {
                    int i3 = bufferedInputStream.read(bArr, 0, 8192);
                    if (-1 == i3) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i3);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                bufferedInputStream.close();
                z = true;
            } catch (IOException e2) {
                if (i2 >= 3) {
                    throw e2;
                }
                i2++;
            }
        } while (!z);
    }

    public static void f(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean g(File file) throws Throwable {
        ZipFile zipFile;
        boolean zContainsKey;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            HashMap map = (HashMap) b(zipFile);
            if (map.isEmpty()) {
                zContainsKey = true;
                ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
            } else {
                zContainsKey = map.containsKey(a);
                if (zContainsKey) {
                    ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + zContainsKey + "], " + file);
                } else {
                    ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + zContainsKey + "], " + file);
                }
            }
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
            }
            return zContainsKey;
        } catch (IOException e3) {
            e = e3;
            zipFile2 = zipFile;
            ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
            if (zipFile2 == null) {
                return false;
            }
            try {
                zipFile2.close();
                return false;
            } catch (IOException unused2) {
                ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused3) {
                    ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String h() {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.n.b.h():java.lang.String");
    }
}
