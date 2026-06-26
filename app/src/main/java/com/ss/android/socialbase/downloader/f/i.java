package com.ss.android.socialbase.downloader.f;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: Segment.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public volatile m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f3635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f3636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f3637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private JSONObject f3640h;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.f.i$1, reason: invalid class name */
    /* JADX INFO: compiled from: Segment.java */
    public static class AnonymousClass1 implements Comparator<i>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return (int) (iVar.c() - iVar2.c());
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

    public i(long j2, long j3) {
        AtomicLong atomicLong = new AtomicLong();
        this.f3636d = atomicLong;
        this.f3634b = 0;
        this.f3635c = j2;
        atomicLong.set(j2);
        this.f3637e = j2;
        if (j3 >= j2) {
            this.f3638f = j3;
        } else {
            this.f3638f = -1L;
        }
    }

    public long a() {
        return this.f3636d.get() - this.f3635c;
    }

    public long b() {
        long j2 = this.f3638f;
        if (j2 >= this.f3635c) {
            return (j2 - e()) + 1;
        }
        return -1L;
    }

    public long c() {
        return this.f3635c;
    }

    public long d() {
        long j2 = this.f3636d.get();
        long j3 = this.f3638f;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j2 > j4) {
                return j4;
            }
        }
        return j2;
    }

    public long e() {
        m mVar = this.a;
        if (mVar != null) {
            long jD = mVar.d();
            if (jD > this.f3637e) {
                return jD;
            }
        }
        return this.f3637e;
    }

    public long f() {
        return this.f3638f;
    }

    public int g() {
        return this.f3639g;
    }

    public void h() {
        this.f3634b++;
    }

    public void i() {
        this.f3634b--;
    }

    public int j() {
        return this.f3634b;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = this.f3640h;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.f3640h = jSONObject;
        }
        jSONObject.put("st", c());
        jSONObject.put("cu", d());
        jSONObject.put(h.a.a.a.n.DEFAULT_LANGUAGE, f());
        return jSONObject;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Segment{startOffset=");
        sbR.append(this.f3635c);
        sbR.append(",\t currentOffset=");
        sbR.append(this.f3636d);
        sbR.append(",\t currentOffsetRead=");
        sbR.append(e());
        sbR.append(",\t endOffset=");
        sbR.append(this.f3638f);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    public void a(long j2) {
        long j3 = this.f3635c;
        if (j2 < j3) {
            j2 = j3;
        }
        long j4 = this.f3638f;
        if (j4 > 0) {
            long j5 = j4 + 1;
            if (j2 > j5) {
                j2 = j5;
            }
        }
        this.f3636d.set(j2);
    }

    public void c(long j2) {
        if (j2 >= this.f3635c) {
            this.f3638f = j2;
            return;
        }
        String str = "setEndOffset: endOffset = " + j2 + ", segment = " + this;
        if (j2 == -1) {
            this.f3638f = j2;
        }
    }

    public void b(long j2) {
        this.f3636d.addAndGet(j2);
    }

    public void d(long j2) {
        if (j2 >= this.f3636d.get()) {
            this.f3637e = j2;
        }
    }

    public void b(int i2) {
        this.f3634b = i2;
    }

    public void a(int i2) {
        this.f3639g = i2;
    }

    public static String a(List<i> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new AnonymousClass1());
        StringBuilder sb = new StringBuilder();
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f3636d = atomicLong;
        this.f3634b = 0;
        this.f3635c = iVar.f3635c;
        this.f3638f = iVar.f3638f;
        atomicLong.set(iVar.f3636d.get());
        this.f3637e = atomicLong.get();
        this.f3639g = iVar.f3639g;
    }

    public i(JSONObject jSONObject) {
        this.f3636d = new AtomicLong();
        this.f3634b = 0;
        this.f3635c = jSONObject.optLong("st");
        c(jSONObject.optLong(h.a.a.a.n.DEFAULT_LANGUAGE));
        a(jSONObject.optLong("cu"));
        d(d());
    }
}
