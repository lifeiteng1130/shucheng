package com.ss.android.downloadlib.g;

import java.io.File;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return a(file, file.lastModified(), 0);
    }

    private static long a(File file, long j2, int i2) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j2 = Math.max(j2, file.lastModified());
            int i3 = i2 + 1;
            if (i3 >= 50) {
                return j2;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j2 = Math.max(j2, a(file2, j2, i3));
                }
            }
        }
        return j2;
    }
}
