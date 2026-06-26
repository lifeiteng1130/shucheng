package j$.util.concurrent;

import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes2.dex */
class d implements PrivilegedAction<Boolean> {
    d() {
    }

    @Override // java.security.PrivilegedAction
    public Boolean run() {
        return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
    }
}
