package com.efs.sdk.base.a.g;

import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ILogEncryptAction {
    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] decrypt(String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.a.h.c.a.a(bArr, str);
        } catch (Exception e2) {
            com.efs.sdk.base.a.h.d.b("efs.base", "aes decrypt error", e2);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] encrypt(String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.a.h.c.a.b(bArr, str);
        } catch (Exception e2) {
            com.efs.sdk.base.a.h.d.b("efs.base", "aes encrypt error", e2);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final int getDeVal() {
        return 2;
    }
}
