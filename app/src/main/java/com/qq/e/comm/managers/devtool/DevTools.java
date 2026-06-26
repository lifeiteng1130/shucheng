package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class DevTools {
    private String a;

    public String getDemoGameUrl() {
        String str = this.a;
        this.a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.a = str;
        }
    }
}
