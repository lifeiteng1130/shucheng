package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: SegmentUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    public static long a(@NonNull List<i> list) {
        int size = list.size();
        long jE = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = list.get(i2);
            if (iVar.c() > jE) {
                break;
            }
            if (iVar.e() > jE) {
                jE = iVar.e();
            }
        }
        return jE;
    }

    public static long b(@NonNull List<i> list) {
        long jC;
        long jD;
        long j2 = 0;
        loop0: while (true) {
            jC = -1;
            jD = -1;
            for (i iVar : list) {
                if (jC == -1) {
                    if (iVar.a() > 0) {
                        jC = iVar.c();
                        jD = iVar.d();
                    }
                } else if (iVar.c() > jD) {
                    j2 += jD - jC;
                    if (iVar.a() > 0) {
                        jC = iVar.c();
                        jD = iVar.d();
                    }
                } else if (iVar.d() > jD) {
                    jD = iVar.d();
                }
            }
        }
        return (jC < 0 || jD <= jC) ? j2 : j2 + (jD - jC);
    }
}
