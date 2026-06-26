package com.ss.android.downloadlib.a.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: DigestUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static byte[] a(CharSequence charSequence, String str) {
        return a(charSequence.toString().getBytes(), str);
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(new ByteArrayInputStream(bArr), str);
    }

    public static byte[] a(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= 0) {
                return messageDigest.digest();
            }
            messageDigest.update(bArr, 0, i2);
        }
    }
}
