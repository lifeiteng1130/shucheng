package i.a.b.k;

import i.a.b.i;
import i.a.b.m.j;
import i.a.b.m.k;
import java.io.Reader;
import java.util.Objects;

/* JADX INFO: compiled from: JSONParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f6367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f6368d;

    static {
        a = System.getProperty("JSON_SMART_SIMPLE") != null ? 1984 : -1;
    }

    public a(int i2) {
        this.f6366b = i2;
    }

    public <T> T a(Reader reader, k<T> kVar) {
        if (this.f6367c == null) {
            this.f6367c = new d(this.f6366b);
        }
        d dVar = this.f6367c;
        Objects.requireNonNull(dVar);
        j jVar = kVar.base;
        dVar.w = reader;
        return (T) dVar.c(kVar);
    }

    public Object b(String str) {
        if (this.f6368d == null) {
            this.f6368d = new f(this.f6366b);
        }
        f fVar = this.f6368d;
        Objects.requireNonNull(fVar);
        k<i.a.b.c> kVar = i.f6361c.f6422b;
        j jVar = kVar.base;
        fVar.x = str;
        fVar.w = str.length();
        return fVar.c(kVar);
    }

    public <T> T c(String str, k<T> kVar) {
        if (this.f6368d == null) {
            this.f6368d = new f(this.f6366b);
        }
        f fVar = this.f6368d;
        Objects.requireNonNull(fVar);
        j jVar = kVar.base;
        fVar.x = str;
        fVar.w = str.length();
        return (T) fVar.c(kVar);
    }
}
