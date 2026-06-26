package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: DownloadChunk.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Parcelable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicLong f3840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f3844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f3845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<b> f3846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f3847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3848l;
    private boolean m;
    private AtomicBoolean n;
    private com.ss.android.socialbase.downloader.h.b o;
    private static final String a = b.class.getSimpleName();
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.socialbase.downloader.model.b.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };

    /* JADX INFO: compiled from: DownloadChunk.java */
    public static class a {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f3849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f3850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f3851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f3852e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3853f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f3854g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private b f3855h;

        public a(int i2) {
            this.a = i2;
        }

        public a a(long j2) {
            this.f3849b = j2;
            return this;
        }

        public a b(long j2) {
            this.f3850c = j2;
            return this;
        }

        public a c(long j2) {
            this.f3851d = j2;
            return this;
        }

        public a d(long j2) {
            this.f3852e = j2;
            return this;
        }

        public a e(long j2) {
            this.f3854g = j2;
            return this;
        }

        public a a(int i2) {
            this.f3853f = i2;
            return this;
        }

        public a a(b bVar) {
            this.f3855h = bVar;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f3838b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f3843g));
        contentValues.put("startOffset", Long.valueOf(this.f3839c));
        contentValues.put("curOffset", Long.valueOf(n()));
        contentValues.put("endOffset", Long.valueOf(this.f3841e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f3842f));
        contentValues.put("hostChunkIndex", Integer.valueOf(b()));
        return contentValues;
    }

    public int b() {
        AtomicInteger atomicInteger = this.f3844h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public boolean c() {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean d() {
        return b() == -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b e() {
        b bVar = !d() ? this.f3847k : this;
        if (bVar == null || !bVar.f()) {
            return null;
        }
        return bVar.g().get(0);
    }

    public boolean f() {
        List<b> list = this.f3846j;
        return list != null && list.size() > 0;
    }

    public List<b> g() {
        return this.f3846j;
    }

    public boolean h() {
        b bVar = this.f3847k;
        if (bVar == null) {
            return true;
        }
        if (!bVar.f()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f3847k.g().size(); i2++) {
            b bVar2 = this.f3847k.g().get(i2);
            if (bVar2 != null) {
                int iIndexOf = this.f3847k.g().indexOf(this);
                if (iIndexOf > i2 && !bVar2.i()) {
                    return false;
                }
                if (iIndexOf == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean i() {
        long j2 = this.f3839c;
        if (d()) {
            long j3 = this.f3845i;
            if (j3 > this.f3839c) {
                j2 = j3;
            }
        }
        return n() - j2 >= this.f3842f;
    }

    public long j() {
        b bVar = this.f3847k;
        if (bVar != null && bVar.g() != null) {
            int iIndexOf = this.f3847k.g().indexOf(this);
            boolean z = false;
            for (int i2 = 0; i2 < this.f3847k.g().size(); i2++) {
                b bVar2 = this.f3847k.g().get(i2);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.n();
                    }
                    if (iIndexOf == i2) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public int k() {
        return this.f3838b;
    }

    public long l() {
        return this.f3839c;
    }

    public long m() {
        AtomicLong atomicLong = this.f3840d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long n() {
        if (!d() || !f()) {
            return m();
        }
        long jM = 0;
        for (int i2 = 0; i2 < this.f3846j.size(); i2++) {
            b bVar = this.f3846j.get(i2);
            if (bVar != null) {
                if (!bVar.i()) {
                    return bVar.m();
                }
                if (jM < bVar.m()) {
                    jM = bVar.m();
                }
            }
        }
        return jM;
    }

    public long o() {
        long jN = n() - this.f3839c;
        if (f()) {
            jN = 0;
            for (int i2 = 0; i2 < this.f3846j.size(); i2++) {
                b bVar = this.f3846j.get(i2);
                if (bVar != null) {
                    jN += bVar.n() - bVar.l();
                }
            }
        }
        return jN;
    }

    public long p() {
        return this.f3841e;
    }

    public long q() {
        return this.f3842f;
    }

    public void r() {
        this.f3845i = n();
    }

    public int s() {
        return this.f3843g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3838b);
        parcel.writeLong(this.f3839c);
        AtomicLong atomicLong = this.f3840d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f3841e);
        parcel.writeLong(this.f3842f);
        parcel.writeInt(this.f3843g);
        AtomicInteger atomicInteger = this.f3844h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    private b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f3838b = aVar.a;
        this.f3839c = aVar.f3849b;
        this.f3840d = new AtomicLong(aVar.f3850c);
        this.f3841e = aVar.f3851d;
        this.f3842f = aVar.f3852e;
        this.f3843g = aVar.f3853f;
        this.f3845i = aVar.f3854g;
        this.f3844h = new AtomicInteger(-1);
        a(aVar.f3855h);
        this.n = new AtomicBoolean(false);
    }

    public void b(boolean z) {
        this.m = z;
    }

    public void c(int i2) {
        this.f3843g = i2;
    }

    public void b(int i2) {
        this.f3838b = i2;
    }

    public long c(boolean z) {
        long jN = n();
        long j2 = this.f3842f;
        long j3 = this.f3845i;
        long j4 = j2 - (jN - j3);
        if (!z && jN == j3) {
            j4 = j2 - (jN - this.f3839c);
        }
        StringBuilder sbR = c.a.a.a.a.r("contentLength:");
        sbR.append(this.f3842f);
        sbR.append(" curOffset:");
        sbR.append(n());
        sbR.append(" oldOffset:");
        sbR.append(this.f3845i);
        sbR.append(" retainLen:");
        sbR.append(j4);
        com.ss.android.socialbase.downloader.c.a.b("DownloadChunk", sbR.toString());
        if (j4 < 0) {
            return 0L;
        }
        return j4;
    }

    public void b(long j2) {
        AtomicLong atomicLong = this.f3840d;
        if (atomicLong != null) {
            atomicLong.set(j2);
        } else {
            this.f3840d = new AtomicLong(j2);
        }
    }

    public void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.f3848l = 0;
        sQLiteStatement.clearBindings();
        int i2 = this.f3848l + 1;
        this.f3848l = i2;
        sQLiteStatement.bindLong(i2, this.f3838b);
        int i3 = this.f3848l + 1;
        this.f3848l = i3;
        sQLiteStatement.bindLong(i3, this.f3843g);
        int i4 = this.f3848l + 1;
        this.f3848l = i4;
        sQLiteStatement.bindLong(i4, this.f3839c);
        int i5 = this.f3848l + 1;
        this.f3848l = i5;
        sQLiteStatement.bindLong(i5, n());
        int i6 = this.f3848l + 1;
        this.f3848l = i6;
        sQLiteStatement.bindLong(i6, this.f3841e);
        int i7 = this.f3848l + 1;
        this.f3848l = i7;
        sQLiteStatement.bindLong(i7, this.f3842f);
        int i8 = this.f3848l + 1;
        this.f3848l = i8;
        sQLiteStatement.bindLong(i8, b());
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f3838b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f3843g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f3839c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f3840d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f3840d = new AtomicLong(0L);
        }
        this.f3841e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f3844h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f3844h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f3842f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public void a(int i2) {
        AtomicInteger atomicInteger = this.f3844h;
        if (atomicInteger == null) {
            this.f3844h = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public void a(com.ss.android.socialbase.downloader.h.b bVar) {
        this.o = bVar;
        r();
    }

    public void a(boolean z) {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            this.n = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.o = null;
    }

    public b(Parcel parcel) {
        this.f3838b = parcel.readInt();
        this.f3839c = parcel.readLong();
        this.f3840d = new AtomicLong(parcel.readLong());
        this.f3841e = parcel.readLong();
        this.f3842f = parcel.readLong();
        this.f3843g = parcel.readInt();
        this.f3844h = new AtomicInteger(parcel.readInt());
    }

    public void a(b bVar) {
        this.f3847k = bVar;
        if (bVar != null) {
            a(bVar.s());
        }
    }

    public void a(List<b> list) {
        this.f3846j = list;
    }

    public void a(long j2) {
        this.f3842f = j2;
    }

    public List<b> a(int i2, long j2) {
        b bVar;
        long jP;
        long j3;
        long jL;
        long j4;
        long j5;
        b bVar2 = this;
        int i3 = i2;
        if (!d() || f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jM = m();
        long jC = bVar2.c(true);
        long j6 = jC / ((long) i3);
        com.ss.android.socialbase.downloader.c.a.b(a, "retainLen:" + jC + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + bVar2.f3843g);
        int i4 = 0;
        while (i4 < i3) {
            if (i4 == 0) {
                jL = l();
                j3 = (jM + j6) - 1;
            } else {
                int i5 = i3 - 1;
                if (i4 == i5) {
                    long jP2 = p();
                    j4 = jP2 > jM ? (jP2 - jM) + 1 : jC - (((long) i5) * j6);
                    j5 = jP2;
                    jL = jM;
                    long j7 = jC;
                    long j8 = j5;
                    b bVarA = new a(bVar2.f3838b).a((-i4) - 1).a(jL).b(jM).e(jM).c(j8).d(j4).a(bVar2).a();
                    com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i4 + " startOffset:" + jL + " curOffset:" + jM + " endOffset:" + j8 + " contentLen:" + j4);
                    arrayList.add(bVarA);
                    jM += j6;
                    i4++;
                    bVar2 = this;
                    i3 = i2;
                    jC = j7;
                } else {
                    j3 = (jM + j6) - 1;
                    jL = jM;
                }
            }
            j4 = j6;
            j5 = j3;
            long j72 = jC;
            long j82 = j5;
            b bVarA2 = new a(bVar2.f3838b).a((-i4) - 1).a(jL).b(jM).e(jM).c(j82).d(j4).a(bVar2).a();
            com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i4 + " startOffset:" + jL + " curOffset:" + jM + " endOffset:" + j82 + " contentLen:" + j4);
            arrayList.add(bVarA2);
            jM += j6;
            i4++;
            bVar2 = this;
            i3 = i2;
            jC = j72;
        }
        long jQ = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            b bVar3 = (b) arrayList.get(size);
            if (bVar3 != null) {
                jQ += bVar3.q();
            }
        }
        com.ss.android.socialbase.downloader.c.a.b(a, "reuseChunkContentLen:" + jQ);
        b bVar4 = (b) arrayList.get(0);
        if (bVar4 != null) {
            if (p() == 0) {
                jP = j2 - l();
            } else {
                jP = (p() - l()) + 1;
            }
            bVar4.a(jP - jQ);
            bVar = this;
            bVar4.c(bVar.f3843g);
            com.ss.android.socialbase.downloader.h.b bVar5 = bVar.o;
            if (bVar5 != null) {
                bVar5.a(bVar4.p(), q() - jQ);
            }
        } else {
            bVar = this;
        }
        bVar.a(arrayList);
        return arrayList;
    }
}
