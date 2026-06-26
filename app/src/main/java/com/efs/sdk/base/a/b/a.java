package com.efs.sdk.base.a.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.a.i.f;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.efs.sdk.base.a.b.b f1770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0063a f1771d;

    /* JADX INFO: renamed from: com.efs.sdk.base.a.b.a$a, reason: collision with other inner class name */
    public static class C0063a implements Comparator<File>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            long jLastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
            if (jLastModified > 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public static class b {
        private static final a a = new a(0);
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static void b(@NonNull File file) {
        if (!file.getName().startsWith("wa_")) {
            f.a.a.f1858c.e();
        }
        com.efs.sdk.base.a.h.b.b(file);
    }

    public static void c(File file) {
        StringBuilder sb = new StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        com.efs.sdk.base.a.a.a.a();
        sb.append(com.efs.sdk.base.a.a.a.b());
        com.efs.sdk.base.a.h.d.a("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            f.a.a.f1858c.d();
        }
        com.efs.sdk.base.a.h.b.b(file);
    }

    public final void a() {
        String[] list;
        File fileD = com.efs.sdk.base.a.h.a.d(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a);
        if (!fileD.exists() || !fileD.isDirectory() || (list = fileD.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!com.efs.sdk.base.a.h.g.a(com.efs.sdk.base.a.d.a.a().f1776c, str)) {
                File file = new File(fileD, str);
                List<File> listD = com.efs.sdk.base.a.h.b.d(file);
                if (!listD.isEmpty()) {
                    for (File file2 : listD) {
                        if (a(file2.getName())) {
                            c(file2);
                        } else {
                            com.efs.sdk.base.a.f.b bVarB = com.efs.sdk.base.a.h.b.b(file2.getName());
                            if (bVarB == null) {
                                b(file2);
                            } else {
                                e eVarA = this.f1770c.a(bVarB.a.f1823b);
                                if (eVarA == null) {
                                    b(file2);
                                } else {
                                    eVarA.a(file2);
                                }
                            }
                        }
                    }
                }
                com.efs.sdk.base.a.h.b.b(file);
            }
        }
    }

    private a() {
        this.a = false;
        this.f1769b = true;
        this.f1770c = new com.efs.sdk.base.a.b.b();
        this.f1771d = new C0063a();
    }

    public static boolean a(String str) {
        try {
            long j2 = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            com.efs.sdk.base.a.a.a.a();
            return Math.abs(com.efs.sdk.base.a.a.a.b() - j2) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    @Nullable
    public final com.efs.sdk.base.a.f.b a(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            if (a(file.getName())) {
                c(file);
                return null;
            }
            com.efs.sdk.base.a.f.b bVarB = com.efs.sdk.base.a.h.b.b(file.getName());
            if (bVarB == null) {
                b(file);
                return null;
            }
            e eVarA = this.f1770c.a(bVarB.a.f1823b);
            if (eVarA == null) {
                b(file);
                return null;
            }
            if (eVarA.a(file, bVarB)) {
                return bVarB;
            }
            b(file);
            return null;
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.a("efs.base", "efs.cache", th);
            b(file);
            return null;
        }
    }
}
