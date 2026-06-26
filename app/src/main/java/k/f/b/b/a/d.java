package k.f.b.b.a;

import android.database.ContentObserver;

/* JADX INFO: compiled from: IdentifierIdObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends ContentObserver {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f8937c;

    public d(c cVar, int i2, String str) {
        super(null);
        this.f8937c = cVar;
        this.f8936b = i2;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        c cVar = this.f8937c;
        if (cVar != null) {
            cVar.b(this.f8936b, this.a);
        }
    }
}
