package e.a.a.h;

import android.content.Context;
import android.os.Process;
import e.a.a.h.f;
import j$.util.DesugarCollections;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: ACache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    @NotNull
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final HashMap<String, f> f5947b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public a f5948c;

    /* JADX INFO: compiled from: ACache.kt */
    public class a {

        @NotNull
        public File a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f5949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final AtomicLong f5951d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public final AtomicInteger f5952e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<File, Long> f5953f;

        public a(@NotNull f fVar, File file, long j2, int i2) {
            f.c0.c.j.e(fVar, "this$0");
            f.c0.c.j.e(file, "cacheDir");
            this.a = file;
            this.f5949b = j2;
            this.f5950c = i2;
            this.f5951d = new AtomicLong();
            this.f5952e = new AtomicInteger();
            this.f5953f = DesugarCollections.synchronizedMap(new HashMap());
            new Thread(new Runnable() { // from class: e.a.a.h.a
                @Override // java.lang.Runnable
                public final void run() {
                    f.a aVar = this.a;
                    f.c0.c.j.e(aVar, "this$0");
                    try {
                        File[] fileArrListFiles = aVar.a.listFiles();
                        if (fileArrListFiles != null) {
                            int length = fileArrListFiles.length;
                            int i3 = 0;
                            int length2 = 0;
                            int i4 = 0;
                            while (i3 < length) {
                                File file2 = fileArrListFiles[i3];
                                i3++;
                                f.c0.c.j.d(file2, "cachedFile");
                                length2 += (int) file2.length();
                                i4++;
                                Map<File, Long> map = aVar.f5953f;
                                f.c0.c.j.d(map, "lastUsageDates");
                                map.put(file2, Long.valueOf(file2.lastModified()));
                            }
                            aVar.f5951d.set(length2);
                            aVar.f5952e.set(i4);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }).start();
        }

        @NotNull
        public final File a(@NotNull String str) {
            f.c0.c.j.e(str, "key");
            File fileB = b(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            fileB.setLastModified(jCurrentTimeMillis);
            Map<File, Long> map = this.f5953f;
            f.c0.c.j.d(map, "lastUsageDates");
            map.put(fileB, Long.valueOf(jCurrentTimeMillis));
            return fileB;
        }

        @NotNull
        public final File b(@NotNull String str) {
            f.c0.c.j.e(str, "key");
            return new File(this.a, str.hashCode() + "");
        }

        public final void c(@NotNull File file) {
            f.c0.c.j.e(file, "file");
            try {
                int iAddAndGet = this.f5952e.get();
                while (iAddAndGet + 1 > this.f5950c) {
                    this.f5951d.addAndGet(-d());
                    iAddAndGet = this.f5952e.addAndGet(-1);
                }
                this.f5952e.addAndGet(1);
                long length = file.length();
                long jAddAndGet = this.f5951d.get();
                while (jAddAndGet + length > this.f5949b) {
                    jAddAndGet = this.f5951d.addAndGet(-d());
                }
                this.f5951d.addAndGet(length);
                long jCurrentTimeMillis = System.currentTimeMillis();
                file.setLastModified(jCurrentTimeMillis);
                Map<File, Long> map = this.f5953f;
                f.c0.c.j.d(map, "lastUsageDates");
                map.put(file, Long.valueOf(jCurrentTimeMillis));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final long d() {
            File file;
            try {
                if (this.f5953f.isEmpty()) {
                    return 0L;
                }
                Set<Map.Entry<File, Long>> setEntrySet = this.f5953f.entrySet();
                Map<File, Long> map = this.f5953f;
                f.c0.c.j.d(map, "lastUsageDates");
                synchronized (map) {
                    file = null;
                    Long l2 = null;
                    for (Map.Entry<File, Long> entry : setEntrySet) {
                        File key = entry.getKey();
                        Long value = entry.getValue();
                        if (file != null) {
                            f.c0.c.j.d(value, "lastValueUsage");
                            long jLongValue = value.longValue();
                            f.c0.c.j.c(l2);
                            if (jLongValue < l2.longValue()) {
                            }
                        }
                        l2 = value;
                        file = key;
                    }
                }
                if (file == null) {
                    return 0L;
                }
                long length = file.length();
                if (file.delete()) {
                    this.f5953f.remove(file);
                }
                return length;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
    }

    /* JADX INFO: compiled from: ACache.kt */
    public static final class b {
        public b(f.c0.c.f fVar) {
        }

        public static f a(b bVar, Context context, String str, long j2, int i2, boolean z, int i3) {
            f fVar;
            if ((i3 & 2) != 0) {
                str = "ACache";
            }
            if ((i3 & 4) != 0) {
                j2 = 50000000;
            }
            long j3 = j2;
            int i4 = (i3 & 8) != 0 ? Integer.MAX_VALUE : i2;
            if ((i3 & 16) != 0) {
                z = true;
            }
            f.c0.c.j.e(context, "ctx");
            f.c0.c.j.e(str, "cacheName");
            File file = z ? new File(context.getCacheDir(), str) : new File(context.getFilesDir(), str);
            f.c0.c.j.e(file, "cacheDir");
            synchronized (bVar) {
                HashMap<String, f> map = f.f5947b;
                String string = file.getAbsoluteFile().toString();
                b bVar2 = f.a;
                fVar = map.get(f.c0.c.j.k(string, f.c0.c.j.k("_", Integer.valueOf(Process.myPid()))));
                if (fVar == null) {
                    fVar = new f(file, j3, i4, null);
                    map.put(f.c0.c.j.k(file.getAbsolutePath(), f.c0.c.j.k("_", Integer.valueOf(Process.myPid()))), fVar);
                }
            }
            return fVar;
        }
    }

    /* JADX INFO: compiled from: ACache.kt */
    public static final class c {
        /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.String a(@org.jetbrains.annotations.Nullable java.lang.String r9) {
            /*
                java.nio.charset.Charset r0 = f.h0.a.a
                byte[] r0 = r9.getBytes(r0)
                java.lang.String r1 = "(this as java.lang.String).getBytes(charset)"
                f.c0.c.j.d(r0, r1)
                int r1 = r0.length
                r2 = 15
                r3 = 32
                r4 = 0
                if (r1 <= r2) goto L36
                r1 = 13
                r1 = r0[r1]
                r2 = 45
                byte r2 = (byte) r2
                if (r1 != r2) goto L36
                int r1 = r0.length
                r2 = -1
                int r1 = r1 + r2
                if (r1 < 0) goto L30
                r5 = 0
            L22:
                int r6 = r5 + 1
                r7 = r0[r5]
                byte r8 = (byte) r3
                if (r7 != r8) goto L2b
                r2 = r5
                goto L30
            L2b:
                if (r6 <= r1) goto L2e
                goto L30
            L2e:
                r5 = r6
                goto L22
            L30:
                r0 = 14
                if (r2 <= r0) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                if (r0 == 0) goto L49
                r0 = 6
                int r0 = f.h0.k.p(r9, r3, r4, r4, r0)
                int r0 = r0 + 1
                java.lang.String r9 = r9.substring(r0)
                java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
                f.c0.c.j.d(r9, r0)
            L49:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: e.a.a.h.f.c.a(java.lang.String):java.lang.String");
        }

        public static final byte[] b(byte[] bArr, int i2, int i3) {
            int i4 = i3 - i2;
            if (i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
                return bArr2;
            }
            throw new IllegalArgumentException((i2 + " > " + i3).toString());
        }

        public static final boolean c(@Nullable byte[] bArr) {
            return bArr.length > 15 && bArr[13] == ((byte) 45) && d(bArr, ' ') > 14;
        }

        public static final int d(byte[] bArr, char c2) {
            int length = bArr.length - 1;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (bArr[i2] == ((byte) c2)) {
                        return i2;
                    }
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return -1;
        }

        public static final boolean e(@NotNull byte[] bArr) {
            String[] strArr;
            f.c0.c.j.e(bArr, "data");
            try {
                f.c0.c.j.e(bArr, "data");
                if (c(bArr)) {
                    byte[] bArrB = b(bArr, 0, 13);
                    Charset charset = f.h0.a.a;
                    strArr = new String[]{new String(bArrB, charset), new String(b(bArr, 14, d(bArr, ' ')), charset)};
                } else {
                    strArr = null;
                }
                if (strArr != null && strArr.length == 2) {
                    String strSubstring = strArr[0];
                    while (f.h0.k.K(strSubstring, "0", false, 2)) {
                        if (strSubstring == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        strSubstring = strSubstring.substring(1);
                        f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    }
                    Long lValueOf = Long.valueOf(strSubstring);
                    if (System.currentTimeMillis() > (Long.valueOf(strArr[1]).longValue() * ((long) 1000)) + lValueOf.longValue()) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public f(File file, long j2, int i2, f.c0.c.f fVar) {
        try {
            if (!file.exists() && !file.mkdirs()) {
                f.c0.c.j.k("can't make dirs in %s", file.getAbsolutePath());
            }
            this.f5948c = new a(this, file, j2, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void e(f fVar, String str, Serializable serializable, int i2, int i3) {
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        f.c0.c.j.e(str, "key");
        f.c0.c.j.e(serializable, ES6Iterator.VALUE_PROPERTY);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(serializable);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (i2 != -1) {
                    f.c0.c.j.d(byteArray, "data");
                    fVar.d(str, byteArray, i2);
                } else {
                    f.c0.c.j.d(byteArray, "data");
                    fVar.c(str, byteArray);
                }
                c.b.a.m.f.P0(objectOutputStream, null);
            } finally {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Nullable
    public final String a(@NotNull String str) {
        f.c0.c.j.e(str, "key");
        a aVar = this.f5948c;
        if (aVar != null) {
            File fileA = aVar.a(str);
            if (!fileA.exists()) {
                return null;
            }
            try {
                String strD = f.b0.d.d(fileA, null, 1);
                f.c0.c.j.e(strD, "str");
                byte[] bytes = strD.getBytes(f.h0.a.a);
                f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
                if (!c.e(bytes)) {
                    return c.a(strD);
                }
                f(str);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public final void b(@NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(str, "key");
        f.c0.c.j.e(str2, ES6Iterator.VALUE_PROPERTY);
        a aVar = this.f5948c;
        if (aVar == null) {
            return;
        }
        try {
            File fileB = aVar.b(str);
            f.b0.d.f(fileB, str2, null, 2);
            aVar.c(fileB);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(@NotNull String str, @NotNull byte[] bArr) {
        f.c0.c.j.e(str, "key");
        f.c0.c.j.e(bArr, ES6Iterator.VALUE_PROPERTY);
        a aVar = this.f5948c;
        if (aVar == null) {
            return;
        }
        File fileB = aVar.b(str);
        f.b0.d.e(fileB, bArr);
        aVar.c(fileB);
    }

    public final void d(@NotNull String str, @NotNull byte[] bArr, int i2) {
        f.c0.c.j.e(str, "key");
        f.c0.c.j.e(bArr, ES6Iterator.VALUE_PROPERTY);
        f.c0.c.j.e(bArr, "data2");
        StringBuilder sb = new StringBuilder(System.currentTimeMillis() + "");
        while (sb.length() < 13) {
            sb.insert(0, "0");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) sb);
        sb2.append('-');
        sb2.append(i2);
        sb2.append(' ');
        String string = sb2.toString();
        Charset charset = f.h0.a.a;
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = string.getBytes(charset);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArr2 = new byte[bytes.length + bArr.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        c(str, bArr2);
    }

    public final boolean f(@NotNull String str) {
        Boolean boolValueOf;
        f.c0.c.j.e(str, "key");
        a aVar = this.f5948c;
        if (aVar == null) {
            boolValueOf = null;
        } else {
            f.c0.c.j.e(str, "key");
            boolValueOf = Boolean.valueOf(aVar.a(str).delete());
        }
        return f.c0.c.j.a(boolValueOf, Boolean.TRUE);
    }
}
