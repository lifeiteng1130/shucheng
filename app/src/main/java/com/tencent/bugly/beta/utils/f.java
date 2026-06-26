package com.tencent.bugly.beta.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static Toast a;

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = a;
        if (toast == null) {
            a = Toast.makeText(context, str, 0);
        } else {
            toast.setText(str);
        }
        a.show();
    }
}
