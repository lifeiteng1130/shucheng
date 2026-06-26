package com.uc.crashsdk.a;

import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f4506b = "";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static boolean b(File file, String str, String str2) throws Throwable {
        try {
            byte[] bArrA = a(file);
            if (bArrA != null && bArrA.length != 0) {
                return a(bArrA, str, str2);
            }
            return false;
        } catch (Exception e2) {
            g.a(e2);
            return false;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (!z) {
            return cipher.doFinal(bArr);
        }
        if (!z2) {
            bArr = a(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i2 = 4; i2 < 16; i2++) {
            bArr2[i2] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a() {
        return new byte[]{48, 25, 6, 55};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    public static byte[] a(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ?? outputStream;
        ?? byteArrayOutputStream;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty(HttpConnection.CONTENT_TYPE, HttpConnection.FORM_URL_ENCODED);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bArr);
                    if (httpURLConnection.getResponseCode() != 200) {
                        g.a((Closeable) outputStream);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int i2 = inputStream.read(bArr2);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i2);
                            } catch (Throwable unused2) {
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        g.a((Closeable) outputStream);
                        g.a(inputStream);
                        g.a((Closeable) byteArrayOutputStream);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused3) {
                        }
                        return byteArray;
                    } catch (Throwable unused4) {
                        byteArrayOutputStream = 0;
                    }
                } catch (Throwable unused5) {
                    inputStream = null;
                    byteArrayOutputStream = 0;
                }
            } catch (Throwable unused6) {
                inputStream = null;
                outputStream = inputStream;
                byteArrayOutputStream = outputStream;
            }
        } catch (Throwable unused7) {
            httpURLConnection = null;
            inputStream = null;
        }
        g.a((Closeable) outputStream);
        g.a(inputStream);
        g.a((Closeable) byteArrayOutputStream);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused8) {
            }
        }
        return null;
    }

    public static void a(byte[] bArr, int i2, byte[] bArr2) {
        if (!a && bArr2.length != 4) {
            throw new AssertionError();
        }
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3 + i2] = bArr2[i3];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static byte[] a(File file) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr;
        int length;
        BufferedInputStream bufferedInputStream;
        ?? r1 = 0;
        byte[] bArr2 = null;
        bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2 = null;
        r1 = 0;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
            } catch (Exception e3) {
                e = e3;
                bArr = null;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                bArr2 = new byte[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = bufferedInputStream.read(bArr2, i2, length - i2);
                    if (-1 == i3) {
                        break;
                    }
                    i2 += i3;
                }
                g.a(bufferedInputStream);
                g.a(fileInputStream);
                r1 = bArr2;
            } catch (Exception e4) {
                e = e4;
                byte[] bArr3 = bArr2;
                bufferedInputStream2 = bufferedInputStream;
                bArr = bArr3;
                g.b(e);
                g.a(bufferedInputStream2);
                g.a(fileInputStream);
                r1 = bArr;
            } catch (Throwable th2) {
                th = th2;
                r1 = bufferedInputStream;
            }
            return r1;
        } catch (Throwable th3) {
            th = th3;
        }
        g.a((Closeable) r1);
        g.a(fileInputStream);
        throw th;
    }

    public static boolean a(File file, String str, String str2) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (b(file, str, str2)) {
                return true;
            }
            a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    private static boolean a(byte[] bArr, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        a.a("Uploading to " + str2);
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(BaseConstants.Time.MINUTE);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append("\r\n");
                int length = sb.length() + 40 + bArr.length;
                httpURLConnection.setRequestProperty(HttpConnection.CONTENT_TYPE, "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length));
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    a.a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        g.a(outputStream2);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int i2 = inputStream.read(bArr2);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i2);
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray != null) {
                            a.a("crashsdk", "Log upload response: " + new String(byteArray));
                            g.a(outputStream2);
                            g.a(inputStream);
                            g.a(byteArrayOutputStream);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused2) {
                            }
                            return true;
                        }
                        g.a(outputStream2);
                        g.a(inputStream);
                        g.a(byteArrayOutputStream);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused3) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
                outputStream = outputStream2;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
        try {
            g.b(th);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused4) {
                }
            }
            return false;
        } finally {
            g.a(outputStream);
            g.a(inputStream);
            g.a(byteArrayOutputStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused5) {
                }
            }
        }
    }
}
