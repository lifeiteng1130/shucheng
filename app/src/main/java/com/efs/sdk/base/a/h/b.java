package com.efs.sdk.base.a.h;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final Random a = new Random();

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                a(fileOutputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    d.b("efs.util.file", "write file error, filename is " + file.getName(), th);
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    a(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                b(file2);
            }
        }
        file.delete();
    }

    public static long c(File file) {
        long jC = 0;
        if (!file.isDirectory()) {
            return 0 + file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            jC += c(file2);
        }
        return jC;
    }

    public static List<File> d(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(d(file2));
            }
        }
        return arrayList;
    }

    private static String e(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        StringBuilder sb;
        String string = "";
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bArr = new byte[1024];
                sb = new StringBuilder();
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                try {
                    d.b("efs.util.file", "read file error", th);
                } finally {
                    a(fileInputStream2);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        while (true) {
            int i2 = fileInputStream.read(bArr);
            if (i2 <= 0) {
                break;
            }
            sb.append(new String(bArr, 0, i2));
            return string;
        }
        string = sb.toString();
        a(fileInputStream);
        return string;
    }

    public static boolean a(File file, String str) {
        return a(file, str.getBytes());
    }

    public static String a(File file) {
        return e(file);
    }

    public static com.efs.sdk.base.a.f.b b(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length != 7) {
            d.a("efs.util.file", "File name error, name is ".concat(str), null);
            return null;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        byte bByteValue = Byte.valueOf(strArrSplit[2]).byteValue();
        com.efs.sdk.base.a.f.b bVar = new com.efs.sdk.base.a.f.b(str2, Byte.valueOf(strArrSplit[3]).byteValue());
        bVar.a(str3);
        bVar.a(bByteValue);
        return bVar;
    }

    public static byte[] a(String str) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            a(fileInputStream);
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            d.b("efs.util.file", "read data error", e);
            a(fileInputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            a(fileInputStream2);
            throw th;
        }
        return bArr;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                d.b("efs.util.file", "safe close error", th);
            }
        }
    }

    public static String a(com.efs.sdk.base.a.f.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.a.a);
        sb.append("_");
        sb.append(bVar.a.f1825d);
        sb.append("_");
        sb.append(bVar.a.f1826e);
        sb.append("_");
        sb.append((int) bVar.a.f1823b);
        sb.append("_");
        sb.append(g.a());
        sb.append("_");
        sb.append(a.nextInt(10000));
        sb.append("_");
        com.efs.sdk.base.a.a.a.a();
        sb.append(com.efs.sdk.base.a.a.a.b());
        return sb.toString();
    }

    public static void a(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int i2 = fileInputStream2.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i2);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            d.b("efs.util.file", "error when copy", e);
                            a(fileInputStream);
                        } catch (Throwable th) {
                            th = th;
                            a(fileInputStream);
                            a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
                a(fileInputStream2);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        a(fileOutputStream);
        b(file);
    }
}
