package com.qq.e.ads;

import com.umeng.analytics.pro.ai;

/* JADX INFO: loaded from: classes.dex */
public enum ContentAdType {
    AD,
    INFORMATION;

    public static ContentAdType fromString(String str) {
        if (ai.au.equals(str)) {
            return AD;
        }
        if ("information".equals(str)) {
            return INFORMATION;
        }
        return null;
    }
}
