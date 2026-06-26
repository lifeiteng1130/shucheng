package com.bytedance.frameworks.encryptor;

/* JADX INFO: loaded from: classes.dex */
public class EncryptorUtil {
    static {
        try {
            System.loadLibrary("Encryptor");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public static byte[] encrypt(byte[] bArr, int i2) {
        if (bArr != null && i2 > 0) {
            try {
                if (bArr.length == i2) {
                    return ttEncrypt(bArr, i2);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static native byte[] ttEncrypt(byte[] bArr, int i2);
}
