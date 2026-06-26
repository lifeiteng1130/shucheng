package c.b.a.q.j;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: CustomTarget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> implements h<T> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public c.b.a.q.c f656c;

    public c() {
        if (!c.b.a.s.i.j(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException(c.a.a.a.a.e("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ", Integer.MIN_VALUE, " and height: ", Integer.MIN_VALUE));
        }
        this.a = Integer.MIN_VALUE;
        this.f655b = Integer.MIN_VALUE;
    }

    @Override // c.b.a.q.j.h
    public final void a(@NonNull g gVar) {
    }

    @Override // c.b.a.q.j.h
    public final void c(@Nullable c.b.a.q.c cVar) {
        this.f656c = cVar;
    }

    @Override // c.b.a.q.j.h
    public void d(@Nullable Drawable drawable) {
    }

    @Override // c.b.a.q.j.h
    public void e(@Nullable Drawable drawable) {
    }

    @Override // c.b.a.q.j.h
    @Nullable
    public final c.b.a.q.c f() {
        return this.f656c;
    }

    @Override // c.b.a.q.j.h
    public final void h(@NonNull g gVar) {
        ((c.b.a.q.h) gVar).b(this.a, this.f655b);
    }

    @Override // c.b.a.n.m
    public void onDestroy() {
    }

    @Override // c.b.a.n.m
    public void onStart() {
    }

    @Override // c.b.a.n.m
    public void onStop() {
    }
}
