package c.e.a.b.e0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import c.e.a.b.e0.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MaterialVisibility.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j<P extends o> extends Visibility {
    public final P a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public o f976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<o> f977c = new ArrayList();

    public j(P p, @Nullable o oVar) {
        this.a = p;
        this.f976b = oVar;
        setInterpolator(c.e.a.b.a.a.f839b);
    }

    public static void a(List<Animator> list, @Nullable o oVar, ViewGroup viewGroup, View view, boolean z) {
        if (oVar == null) {
            return;
        }
        Animator animatorA = z ? oVar.a(viewGroup, view) : oVar.b(viewGroup, view);
        if (animatorA != null) {
            list.add(animatorA);
        }
    }

    public final Animator b(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        a(arrayList, this.a, viewGroup, view, z);
        a(arrayList, this.f976b, viewGroup, view, z);
        Iterator<o> it = this.f977c.iterator();
        while (it.hasNext()) {
            a(arrayList, it.next(), viewGroup, view, z);
        }
        c.b.a.m.f.k4(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, false);
    }
}
