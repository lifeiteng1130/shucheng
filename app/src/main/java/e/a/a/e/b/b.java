package e.a.a.e.b;

import java.util.Objects;

/* JADX INFO: compiled from: CharsetMatch.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Comparable<b> {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5608b;

    public b(a aVar, h hVar, int i2) {
        this.a = i2;
        Objects.requireNonNull(aVar);
        this.f5608b = hVar.b();
        hVar.a();
    }

    @Override // java.lang.Comparable
    public int compareTo(b bVar) {
        int i2 = this.a;
        int i3 = bVar.a;
        if (i2 > i3) {
            return 1;
        }
        return i2 < i3 ? -1 : 0;
    }

    public b(a aVar, int i2, String str, String str2) {
        this.a = i2;
        this.f5608b = str;
    }
}
