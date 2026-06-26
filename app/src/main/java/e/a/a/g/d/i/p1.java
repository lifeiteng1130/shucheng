package e.a.a.g.d.i;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import io.legado.app.ui.book.read.ReadMenu;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 implements Animation.AnimationListener {
    public final /* synthetic */ ReadMenu a;

    public p1(ReadMenu readMenu) {
        this.a = readMenu;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(@NotNull Animation animation) {
        f.c0.c.j.e(animation, "animation");
        final ReadMenu readMenu = this.a;
        readMenu.binding.Q.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadMenu readMenu2 = readMenu;
                f.c0.c.j.e(readMenu2, "this$0");
                int i2 = ReadMenu.a;
                readMenu2.h(null);
            }
        });
        View view = this.a.binding.R;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        AppCompatActivity appCompatActivityO1 = c.b.a.m.f.O1(this.a);
        f.c0.c.j.c(appCompatActivityO1);
        layoutParams.height = c.b.a.m.f.D2(appCompatActivityO1);
        view.setLayoutParams(layoutParams);
        if (e.a.a.d.q.a.b(1, "readMenuHelpVersion", "firstReadMenu")) {
            return;
        }
        this.a.getCallBack().J();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(@NotNull Animation animation) {
        f.c0.c.j.e(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(@NotNull Animation animation) {
        f.c0.c.j.e(animation, "animation");
        this.a.getCallBack().l0();
        LinearLayout linearLayout = this.a.binding.r;
        f.c0.c.j.d(linearLayout, "binding.llBrightness");
        c.b.a.m.f.d6(linearLayout, this.a.getShowBrightnessView());
    }
}
