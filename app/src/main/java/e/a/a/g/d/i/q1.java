package e.a.a.g.d.i;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import io.legado.app.ui.book.read.ReadMenu;
import io.legado.app.ui.widget.TitleBar;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q1 implements Animation.AnimationListener {
    public final /* synthetic */ ReadMenu a;

    public q1(ReadMenu readMenu) {
        this.a = readMenu;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(@NotNull Animation animation) {
        f.c0.c.j.e(animation, "animation");
        c.b.a.m.f.l3(this.a);
        TitleBar titleBar = this.a.binding.B;
        f.c0.c.j.d(titleBar, "binding.titleBar");
        c.b.a.m.f.l3(titleBar);
        LinearLayout linearLayout = this.a.binding.f6884b;
        f.c0.c.j.d(linearLayout, "binding.bottomMenu");
        c.b.a.m.f.l3(linearLayout);
        this.a.setCnaShowMenu(false);
        f.c0.b.a<f.v> aVar = this.a.onMenuOutEnd;
        if (aVar != null) {
            aVar.invoke();
        }
        this.a.getCallBack().l0();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(@NotNull Animation animation) {
        f.c0.c.j.e(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(@NotNull Animation animation) {
        f.c0.c.j.e(animation, "animation");
        this.a.binding.Q.setOnClickListener(null);
    }
}
