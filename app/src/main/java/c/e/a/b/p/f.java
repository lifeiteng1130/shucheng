package c.e.a.b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.e.a.b.p.h;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends AnimatorListenerAdapter {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h.f f1071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f1072d;

    public f(h hVar, boolean z, h.f fVar) {
        this.f1072d = hVar;
        this.f1070b = z;
        this.f1071c = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        h hVar = this.f1072d;
        hVar.B = 0;
        hVar.v = null;
        if (this.a) {
            return;
        }
        FloatingActionButton floatingActionButton = hVar.F;
        boolean z = this.f1070b;
        floatingActionButton.b(z ? 8 : 4, z);
        h.f fVar = this.f1071c;
        if (fVar != null) {
            e eVar = (e) fVar;
            eVar.a.a(eVar.f1069b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1072d.F.b(0, this.f1070b);
        h hVar = this.f1072d;
        hVar.B = 1;
        hVar.v = animator;
        this.a = false;
    }
}
