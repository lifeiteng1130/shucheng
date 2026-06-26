package c.b.a.q.j;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.q.k.d;

/* JADX INFO: compiled from: ImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e<Z> extends i<ImageView, Z> implements d.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Animatable f657d;

    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // c.b.a.q.j.h
    public void b(@NonNull Z z, @Nullable c.b.a.q.k.d<? super Z> dVar) {
        if (dVar == null || !dVar.a(z, this)) {
            j(z);
        } else {
            if (!(z instanceof Animatable)) {
                this.f657d = null;
                return;
            }
            Animatable animatable = (Animatable) z;
            this.f657d = animatable;
            animatable.start();
        }
    }

    @Override // c.b.a.q.j.h
    public void d(@Nullable Drawable drawable) {
        j(null);
        ((ImageView) this.f658b).setImageDrawable(drawable);
    }

    @Override // c.b.a.q.j.h
    public void e(@Nullable Drawable drawable) {
        j(null);
        ((ImageView) this.f658b).setImageDrawable(drawable);
    }

    @Override // c.b.a.q.j.h
    public void g(@Nullable Drawable drawable) {
        this.f659c.a();
        Animatable animatable = this.f657d;
        if (animatable != null) {
            animatable.stop();
        }
        j(null);
        ((ImageView) this.f658b).setImageDrawable(drawable);
    }

    public abstract void i(@Nullable Z z);

    public final void j(@Nullable Z z) {
        i(z);
        if (!(z instanceof Animatable)) {
            this.f657d = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.f657d = animatable;
        animatable.start();
    }

    @Override // c.b.a.n.m
    public void onStart() {
        Animatable animatable = this.f657d;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // c.b.a.n.m
    public void onStop() {
        Animatable animatable = this.f657d;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
