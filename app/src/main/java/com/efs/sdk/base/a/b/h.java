package com.efs.sdk.base.a.b;

import com.efs.sdk.base.a.b.a;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class h implements f {
    @Override // com.efs.sdk.base.a.b.f
    public final boolean a(File file) {
        com.efs.sdk.base.a.f.b bVarB = com.efs.sdk.base.a.h.b.b(file.getName());
        if (bVarB != null) {
            return ("wa".equals(bVarB.a.a) || com.efs.sdk.base.a.e.b.a().a(bVarB.a.a, file.length())) ? false : true;
        }
        a unused = a.b.a;
        a.b(file);
        return true;
    }
}
