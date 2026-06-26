package c.b.a.k;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f251g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Writer f253i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f255k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f252h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<String, d> f254j = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f256l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    public final Callable<Void> n = new CallableC0012a();

    /* JADX INFO: renamed from: c.b.a.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.java */
    public class CallableC0012a implements Callable<Void> {
        public CallableC0012a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (a.this) {
                a aVar = a.this;
                if (aVar.f253i == null) {
                    return null;
                }
                aVar.o();
                if (a.this.h()) {
                    a.this.m();
                    a.this.f255k = 0;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public static final class b implements ThreadFactory {
        public b(CallableC0012a callableC0012a) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class c {
        public final d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f258c;

        public c(d dVar, CallableC0012a callableC0012a) {
            this.a = dVar;
            this.f257b = dVar.f263e ? null : new boolean[a.this.f251g];
        }

        public void a() {
            a.a(a.this, this, false);
        }

        public File b(int i2) {
            File file;
            synchronized (a.this) {
                d dVar = this.a;
                if (dVar.f264f != this) {
                    throw new IllegalStateException();
                }
                if (!dVar.f263e) {
                    this.f257b[i2] = true;
                }
                file = dVar.f262d[i2];
                a.this.a.mkdirs();
            }
            return file;
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class d {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public File[] f261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public File[] f262d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f263e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f264f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f265g;

        public d(String str, CallableC0012a callableC0012a) {
            this.a = str;
            int i2 = a.this.f251g;
            this.f260b = new long[i2];
            this.f261c = new File[i2];
            this.f262d = new File[i2];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i3 = 0; i3 < a.this.f251g; i3++) {
                sb.append(i3);
                this.f261c[i3] = new File(a.this.a, sb.toString());
                sb.append(".tmp");
                this.f262d[i3] = new File(a.this.a, sb.toString());
                sb.setLength(length);
            }
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f260b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public final IOException b(String[] strArr) throws IOException {
            StringBuilder sbR = c.a.a.a.a.r("unexpected journal line: ");
            sbR.append(Arrays.toString(strArr));
            throw new IOException(sbR.toString());
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class e {
        public final File[] a;

        public e(a aVar, String str, long j2, File[] fileArr, long[] jArr, CallableC0012a callableC0012a) {
            this.a = fileArr;
        }
    }

    public a(File file, int i2, int i3, long j2) {
        this.a = file;
        this.f249e = i2;
        this.f246b = new File(file, "journal");
        this.f247c = new File(file, "journal.tmp");
        this.f248d = new File(file, "journal.bkp");
        this.f251g = i3;
        this.f250f = j2;
    }

    public static void a(a aVar, c cVar, boolean z) {
        synchronized (aVar) {
            d dVar = cVar.a;
            if (dVar.f264f != cVar) {
                throw new IllegalStateException();
            }
            if (z && !dVar.f263e) {
                for (int i2 = 0; i2 < aVar.f251g; i2++) {
                    if (!cVar.f257b[i2]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                    if (!dVar.f262d[i2].exists()) {
                        cVar.a();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < aVar.f251g; i3++) {
                File file = dVar.f262d[i3];
                if (!z) {
                    d(file);
                } else if (file.exists()) {
                    File file2 = dVar.f261c[i3];
                    file.renameTo(file2);
                    long j2 = dVar.f260b[i3];
                    long length = file2.length();
                    dVar.f260b[i3] = length;
                    aVar.f252h = (aVar.f252h - j2) + length;
                }
            }
            aVar.f255k++;
            dVar.f264f = null;
            if (dVar.f263e || z) {
                dVar.f263e = true;
                aVar.f253i.append((CharSequence) "CLEAN");
                aVar.f253i.append(' ');
                aVar.f253i.append((CharSequence) dVar.a);
                aVar.f253i.append((CharSequence) dVar.a());
                aVar.f253i.append('\n');
                if (z) {
                    long j3 = aVar.f256l;
                    aVar.f256l = 1 + j3;
                    dVar.f265g = j3;
                }
            } else {
                aVar.f254j.remove(dVar.a);
                aVar.f253i.append((CharSequence) "REMOVE");
                aVar.f253i.append(' ');
                aVar.f253i.append((CharSequence) dVar.a);
                aVar.f253i.append('\n');
            }
            f(aVar.f253i);
            if (aVar.f252h > aVar.f250f || aVar.h()) {
                aVar.m.submit(aVar.n);
            }
        }
    }

    @TargetApi(26)
    public static void c(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void d(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void f(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static a i(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                n(file2, file3, false);
            }
        }
        a aVar = new a(file, i2, i3, j2);
        if (aVar.f246b.exists()) {
            try {
                aVar.k();
                aVar.j();
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.close();
                c.b.a.k.c.a(aVar.a);
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i2, i3, j2);
        aVar2.m();
        return aVar2;
    }

    public static void n(File file, File file2, boolean z) throws IOException {
        if (z) {
            d(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final void b() {
        if (this.f253i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f253i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f254j.values()).iterator();
        while (it.hasNext()) {
            c cVar = ((d) it.next()).f264f;
            if (cVar != null) {
                cVar.a();
            }
        }
        o();
        c(this.f253i);
        this.f253i = null;
    }

    public c e(String str) {
        synchronized (this) {
            b();
            d dVar = this.f254j.get(str);
            if (dVar == null) {
                dVar = new d(str, null);
                this.f254j.put(str, dVar);
            } else if (dVar.f264f != null) {
                return null;
            }
            c cVar = new c(dVar, null);
            dVar.f264f = cVar;
            this.f253i.append((CharSequence) "DIRTY");
            this.f253i.append(' ');
            this.f253i.append((CharSequence) str);
            this.f253i.append('\n');
            f(this.f253i);
            return cVar;
        }
    }

    public synchronized e g(String str) {
        b();
        d dVar = this.f254j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f263e) {
            return null;
        }
        for (File file : dVar.f261c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f255k++;
        this.f253i.append((CharSequence) "READ");
        this.f253i.append(' ');
        this.f253i.append((CharSequence) str);
        this.f253i.append('\n');
        if (h()) {
            this.m.submit(this.n);
        }
        return new e(this, str, dVar.f265g, dVar.f261c, dVar.f260b, null);
    }

    public final boolean h() {
        int i2 = this.f255k;
        return i2 >= 2000 && i2 >= this.f254j.size();
    }

    public final void j() throws IOException {
        d(this.f247c);
        Iterator<d> it = this.f254j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f264f == null) {
                while (i2 < this.f251g) {
                    this.f252h += next.f260b[i2];
                    i2++;
                }
            } else {
                next.f264f = null;
                while (i2 < this.f251g) {
                    d(next.f261c[i2]);
                    d(next.f262d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final void k() {
        c.b.a.k.b bVar = new c.b.a.k.b(new FileInputStream(this.f246b), c.b.a.k.c.a);
        try {
            String strB = bVar.b();
            String strB2 = bVar.b();
            String strB3 = bVar.b();
            String strB4 = bVar.b();
            String strB5 = bVar.b();
            if (!"libcore.io.DiskLruCache".equals(strB) || !SdkVersion.MINI_VERSION.equals(strB2) || !Integer.toString(this.f249e).equals(strB3) || !Integer.toString(this.f251g).equals(strB4) || !"".equals(strB5)) {
                throw new IOException("unexpected journal header: [" + strB + ", " + strB2 + ", " + strB4 + ", " + strB5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    l(bVar.b());
                    i2++;
                } catch (EOFException unused) {
                    this.f255k = i2 - this.f254j.size();
                    if (bVar.f270e == -1) {
                        m();
                    } else {
                        this.f253i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f246b, true), c.b.a.k.c.a));
                    }
                    try {
                        bVar.close();
                        return;
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                bVar.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void l(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException(c.a.a.a.a.i("unexpected journal line: ", str));
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f254j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        d dVar = this.f254j.get(strSubstring);
        if (dVar == null) {
            dVar = new d(strSubstring, null);
            this.f254j.put(strSubstring, dVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f264f = new c(dVar, null);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException(c.a.a.a.a.i("unexpected journal line: ", str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        dVar.f263e = true;
        dVar.f264f = null;
        if (strArrSplit.length != a.this.f251g) {
            dVar.b(strArrSplit);
            throw null;
        }
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            try {
                dVar.f260b[i3] = Long.parseLong(strArrSplit[i3]);
            } catch (NumberFormatException unused) {
                dVar.b(strArrSplit);
                throw null;
            }
        }
    }

    public final synchronized void m() {
        Writer writer = this.f253i;
        if (writer != null) {
            c(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f247c), c.b.a.k.c.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(SdkVersion.MINI_VERSION);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f249e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f251g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f254j.values()) {
                if (dVar.f264f != null) {
                    bufferedWriter.write("DIRTY " + dVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.a + dVar.a() + '\n');
                }
            }
            c(bufferedWriter);
            if (this.f246b.exists()) {
                n(this.f246b, this.f248d, true);
            }
            n(this.f247c, this.f246b, false);
            this.f248d.delete();
            this.f253i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f246b, true), c.b.a.k.c.a));
        } catch (Throwable th) {
            c(bufferedWriter);
            throw th;
        }
    }

    public final void o() {
        while (this.f252h > this.f250f) {
            String key = this.f254j.entrySet().iterator().next().getKey();
            synchronized (this) {
                b();
                d dVar = this.f254j.get(key);
                if (dVar != null && dVar.f264f == null) {
                    for (int i2 = 0; i2 < this.f251g; i2++) {
                        File file = dVar.f261c[i2];
                        if (file.exists() && !file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                        long j2 = this.f252h;
                        long[] jArr = dVar.f260b;
                        this.f252h = j2 - jArr[i2];
                        jArr[i2] = 0;
                    }
                    this.f255k++;
                    this.f253i.append((CharSequence) "REMOVE");
                    this.f253i.append(' ');
                    this.f253i.append((CharSequence) key);
                    this.f253i.append('\n');
                    this.f254j.remove(key);
                    if (h()) {
                        this.m.submit(this.n);
                    }
                }
            }
        }
    }
}
