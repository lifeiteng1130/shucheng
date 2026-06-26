package c.e.a.b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.e.a.b.p.h;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.f f1073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f1074c;

    public g(h hVar, boolean z, h.f fVar) {
        this.f1074c = hVar;
        this.a = z;
        this.f1073b = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        h hVar = this.f1074c;
        hVar.B = 0;
        hVar.v = null;
        h.f fVar = this.f1073b;
        if (fVar != null) {
            e eVar = (e) fVar;
            eVar.a.b(eVar.f1069b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1074c.F.b(0, this.a);
        h hVar = this.f1074c;
        hVar.B = 2;
        hVar.v = animator;
    }
}
