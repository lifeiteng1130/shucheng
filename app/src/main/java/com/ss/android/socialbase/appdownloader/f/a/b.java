package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;

/* JADX INFO: compiled from: ChunkUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final void a(d dVar, int i2) throws IOException {
        int iB = dVar.b();
        if (iB == i2) {
            return;
        }
        StringBuilder sbR = c.a.a.a.a.r("Expected chunk of type 0x");
        sbR.append(Integer.toHexString(i2));
        sbR.append(", read 0x");
        sbR.append(Integer.toHexString(iB));
        sbR.append(".");
        throw new IOException(sbR.toString());
    }
}
