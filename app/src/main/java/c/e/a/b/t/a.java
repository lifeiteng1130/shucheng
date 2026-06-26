package c.e.a.b.t;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: CancelableFontCallback.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a extends d {
    public final Typeface a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0047a f1188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1189c;

    /* JADX INFO: renamed from: c.e.a.b.t.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CancelableFontCallback.java */
    public interface InterfaceC0047a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0047a interfaceC0047a, Typeface typeface) {
        this.a = typeface;
        this.f1188b = interfaceC0047a;
    }

    @Override // c.e.a.b.t.d
    public void a(int i2) {
        Typeface typeface = this.a;
        if (this.f1189c) {
            return;
        }
        this.f1188b.a(typeface);
    }

    @Override // c.e.a.b.t.d
    public void b(Typeface typeface, boolean z) {
        if (this.f1189c) {
            return;
        }
        this.f1188b.a(typeface);
    }
}
