package e.a.a.h;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ZipUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    @NotNull
    public static final e0 a = new e0();

    public final boolean a(File file) {
        if (file != null) {
            if (file.exists() ? file.isDirectory() : file.mkdirs()) {
                return true;
            }
        }
        return false;
    }

    public final File b(String str) {
        if (c(str)) {
            return null;
        }
        return new File(str);
    }

    public final boolean c(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        boolean zCreateNewFile;
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return a(file2);
        }
        if (file2.exists()) {
            zCreateNewFile = file2.isFile();
        } else if (a(file2.getParentFile())) {
            try {
                zCreateNewFile = file2.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                zCreateNewFile = false;
            }
        } else {
            zCreateNewFile = false;
        }
        if (!zCreateNewFile) {
            return false;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            try {
                bufferedOutputStream.write(c.b.a.m.f.w4(bufferedInputStream));
                c.b.a.m.f.P0(bufferedOutputStream, null);
                c.b.a.m.f.P0(bufferedInputStream, null);
                return true;
            } finally {
            }
        } finally {
        }
    }

    @Nullable
    public final List<File> e(@Nullable File file, @Nullable File file2, @Nullable String str) {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        boolean z = true;
        if (str != null) {
            try {
                int length = str.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (!Character.isWhitespace(str.charAt(i2))) {
                        z = false;
                        break;
                    }
                    i2++;
                }
            } finally {
            }
        }
        if (z) {
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (zipEntryNextElement == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.zip.ZipEntry");
                }
                ZipEntry zipEntry = zipEntryNextElement;
                String name = zipEntry.getName();
                f.c0.c.j.d(name, "entryName");
                if (!f.h0.k.d(name, "../", false, 2) && !a.d(file2, arrayList, zipFile, zipEntry, name)) {
                    c.b.a.m.f.P0(zipFile, null);
                    return arrayList;
                }
            }
        } else {
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement2 = enumerationEntries.nextElement();
                if (zipEntryNextElement2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.zip.ZipEntry");
                }
                ZipEntry zipEntry2 = zipEntryNextElement2;
                String name2 = zipEntry2.getName();
                f.c0.c.j.d(name2, "entryName");
                if (!f.h0.k.d(name2, "../", false, 2)) {
                    f.c0.c.j.c(str);
                    if (f.h0.k.d(name2, str, false, 2) && !a.d(file2, arrayList, zipFile, zipEntry2, name2)) {
                        c.b.a.m.f.P0(zipFile, null);
                        return arrayList;
                    }
                }
            }
        }
        c.b.a.m.f.P0(zipFile, null);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.io.File r7, java.lang.String r8, java.util.zip.ZipOutputStream r9, java.lang.String r10) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r7.exists()
            r1 = 1
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.StringBuilder r0 = c.a.a.a.a.r(r8)
            boolean r8 = r6.c(r8)
            if (r8 == 0) goto L15
            java.lang.String r8 = ""
            goto L17
        L15:
            java.lang.String r8 = java.io.File.separator
        L17:
            r0.append(r8)
            java.lang.String r8 = r7.getName()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            boolean r0 = r7.isDirectory()
            if (r0 == 0) goto L64
            java.io.File[] r7 = r7.listFiles()
            if (r7 == 0) goto L4f
            int r0 = r7.length
            r2 = 0
            if (r0 != 0) goto L37
            r0 = 1
            goto L38
        L37:
            r0 = 0
        L38:
            if (r0 == 0) goto L3b
            goto L4f
        L3b:
            int r0 = r7.length
            r3 = 0
        L3d:
            if (r3 >= r0) goto L87
            r4 = r7[r3]
            int r3 = r3 + 1
            java.lang.String r5 = "file"
            f.c0.c.j.d(r4, r5)
            boolean r4 = r6.f(r4, r8, r9, r10)
            if (r4 != 0) goto L3d
            return r2
        L4f:
            java.util.zip.ZipEntry r7 = new java.util.zip.ZipEntry
            java.lang.String r0 = "/"
            java.lang.String r8 = f.c0.c.j.k(r8, r0)
            r7.<init>(r8)
            r7.setComment(r10)
            r9.putNextEntry(r7)
            r9.closeEntry()
            goto L87
        L64:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r7)
            r0.<init>(r2)
            r7 = 0
            java.util.zip.ZipEntry r2 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> L88
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L88
            r2.setComment(r10)     // Catch: java.lang.Throwable -> L88
            r9.putNextEntry(r2)     // Catch: java.lang.Throwable -> L88
            byte[] r8 = c.b.a.m.f.w4(r0)     // Catch: java.lang.Throwable -> L88
            r9.write(r8)     // Catch: java.lang.Throwable -> L88
            r9.closeEntry()     // Catch: java.lang.Throwable -> L88
            c.b.a.m.f.P0(r0, r7)
        L87:
            return r1
        L88:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L8a
        L8a:
            r8 = move-exception
            c.b.a.m.f.P0(r0, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.h.e0.f(java.io.File, java.lang.String, java.util.zip.ZipOutputStream, java.lang.String):boolean");
    }
}
