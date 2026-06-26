package com.bytedance.sdk.openadsdk.api.plugin;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: compiled from: PluginChecker.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private PublicKey a;

    public c() {
        try {
            this.a = a(new String(Base64.decode("TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUF5ZXRudE1CRzJuU1JRb1lpT1NLegpCdkZ5cmdwQ1dlT1lnRVZxbG5rNWhLMGlydnNKdVhrZ2paVnFDc0VBRFVQQ0w5K2NlZng1NHoyRGw5dmpEemlwCjVYSGluRUdnZkR1ZzBkcmZyOHRKTElySHlnQlY5M2FTWFg5endBVGlnRnY0dzNrN1RuMStxS01CdUxhbkptSFMKQUttRGMrRCtZSmpYSGF0dWY3YlVhbXlEdDBOZ2pYM0F5d1JUSkErcldPR3RjMHRTWDdaNmlKd3o2bXdzTmZQYQpka3NwVEpmcjVja2dRdVlvWDQybGxteGhRTCtLK2F3NHE1SDgxZTFZUjN4TGhQaVdBTFNXVWlhYk5OQ3dyTGQvCk5uRVNaa0gzQVJqazVtYnhzU1lKcU8yUTRTL2lmNXl3WXYycG51ZW50d2ZQa3p3b0NkcFA3VVZ0MHhNNFgvZEcKYXdJREFRQUI=", 0)));
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public boolean a(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, empty sign: ");
            return false;
        }
        if (file == null || !file.exists()) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, no file");
            return false;
        }
        if (this.a == null) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, no key ");
            return false;
        }
        try {
            return a(str, new FileInputStream(file));
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, sign: " + str + ", error:" + e2);
            return false;
        }
    }

    private boolean a(String str, InputStream inputStream) {
        return a(str, a(inputStream));
    }

    private boolean a(String str, byte[] bArr) throws Exception {
        if (this.a == null) {
            return false;
        }
        byte[] bArrDecode = Base64.decode(str, 0);
        try {
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(this.a);
            signature.update(bArr);
            return signature.verify(bArrDecode);
        } catch (Throwable th) {
            throw new Exception("Verify sign failed", th);
        }
    }

    private static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Exception e2) {
            throw new Exception("Init public key failed", e2);
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception unused) {
                inputStream.close();
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
