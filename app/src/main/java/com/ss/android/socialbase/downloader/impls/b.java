package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: compiled from: DefaultChunkAdjustCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.ss.android.socialbase.downloader.downloader.g {
    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int a(int i2, com.ss.android.socialbase.downloader.network.l lVar) {
        if (lVar.ordinal() <= com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()) {
            return 1;
        }
        return lVar == com.ss.android.socialbase.downloader.network.l.GOOD ? i2 - 1 : i2;
    }
}
