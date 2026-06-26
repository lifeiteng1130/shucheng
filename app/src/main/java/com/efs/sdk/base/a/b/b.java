package com.efs.sdk.base.a.b;

import androidx.annotation.Nullable;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private ConcurrentHashMap<Byte, e> a = new ConcurrentHashMap<>();

    @Nullable
    public final e a(byte b2) {
        if (!this.a.containsKey(Byte.valueOf(b2))) {
            if (b2 == 1) {
                this.a.putIfAbsent(Byte.valueOf(b2), new g());
            } else if (b2 != 2) {
                com.efs.sdk.base.a.h.d.a("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b2)), null);
            } else {
                this.a.putIfAbsent(Byte.valueOf(b2), new d());
            }
        }
        return (e) this.a.get(Byte.valueOf(b2));
    }
}
