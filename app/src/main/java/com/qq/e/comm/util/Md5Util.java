package com.qq.e.comm.util;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.ai;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import org.jsoup.helper.DataUtil;

/* JADX INFO: loaded from: classes.dex */
public class Md5Util {
    private static final String[] a = {"0", SdkVersion.MINI_VERSION, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ai.at, "b", ai.aD, "d", "e", "f"};

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 : bArr) {
            if (i2 < 0) {
                i2 += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = a;
            sb.append(strArr[i2 / 16]);
            sb.append(strArr[i2 % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    public static String encode(File file) throws Throwable {
        if (file != null && file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int i2 = fileInputStream2.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                    }
                    String strByteArrayToHexString = byteArrayToHexString(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return strByteArrayToHexString;
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    public static String encode(String str) {
        try {
            String str2 = new String(str);
            try {
                return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str2.getBytes(DataUtil.defaultCharset)));
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String encodeBase64String(String str) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(Base64.decode(str, 0)));
        } catch (Exception unused) {
            GDTLogger.d("Exception while md5 base64String");
            return null;
        }
    }

    public static byte[] hexStringtoByteArray(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length() - 1; i2 += 2) {
            char cCharAt = str.charAt(i2);
            char cCharAt2 = str.charAt(i2 + 1);
            char lowerCase = Character.toLowerCase(cCharAt);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            int i3 = (lowerCase2 <= '9' ? lowerCase2 - '0' : (lowerCase2 - 'a') + 10) + ((lowerCase <= '9' ? lowerCase - '0' : (lowerCase - 'a') + 10) << 4);
            if (i3 > 127) {
                i3 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i2 / 2] = (byte) i3;
        }
        return bArr;
    }
}
