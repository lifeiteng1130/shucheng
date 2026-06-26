package com.efs.sdk.base.a.h;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static volatile String a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            synchronized (h.class) {
                if (TextUtils.isEmpty(a)) {
                    String strB = b(context);
                    a = strB;
                    if (TextUtils.isEmpty(strB)) {
                        a = c(context);
                    }
                }
            }
        }
        return a;
    }

    private static String b(Context context) {
        try {
            File file = new File(a.a(context), "efsid");
            if (file.exists()) {
                return b.a(file);
            }
            return null;
        } catch (Exception e2) {
            d.b("efs.base", "get uuid error", e2);
            return null;
        }
    }

    private static String c(Context context) {
        String string = "";
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                string = UUID.randomUUID().toString();
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(string)) {
            }
        }
        try {
            File fileA = a.a(context);
            File file = new File(fileA, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            b.a(file, string);
            if (file.renameTo(new File(fileA, "efsid"))) {
                file.delete();
            }
        } catch (Exception e2) {
            d.b("efs.base", "save uuid '" + string + "' error", e2);
        }
        return string;
    }
}
