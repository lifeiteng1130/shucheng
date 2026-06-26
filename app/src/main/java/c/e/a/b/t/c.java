package c.e.a.b.t;

import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends d {
    public final /* synthetic */ TextPaint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f1203c;

    public c(b bVar, TextPaint textPaint, d dVar) {
        this.f1203c = bVar;
        this.a = textPaint;
        this.f1202b = dVar;
    }

    @Override // c.e.a.b.t.d
    public void a(int i2) {
        this.f1202b.a(i2);
    }

    @Override // c.e.a.b.t.d
    public void b(@NonNull Typeface typeface, boolean z) {
        this.f1203c.d(this.a, typeface);
        this.f1202b.b(typeface, z);
    }
}
