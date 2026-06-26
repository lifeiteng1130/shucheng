package e.a.a.e.a;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.StringRes;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.v;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AlertBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"SupportAnnotationUsage"})
public interface h<D extends DialogInterface> {
    void a(@StringRes int i2, @Nullable l<? super DialogInterface, v> lVar);

    void b(@NotNull List<? extends CharSequence> list, @NotNull p<? super DialogInterface, ? super Integer, v> pVar);

    void c(@StringRes int i2, @Nullable l<? super DialogInterface, v> lVar);

    void d(@NotNull f.c0.b.a<? extends View> aVar);

    void e(@StringRes int i2, @Nullable l<? super DialogInterface, v> lVar);

    void f(@Nullable l<? super DialogInterface, v> lVar);

    void g(int i2);

    void h(@NotNull CharSequence charSequence);

    void i(@Nullable l<? super DialogInterface, v> lVar);

    void j(@NotNull l<? super DialogInterface, v> lVar);

    void k(@Nullable l<? super DialogInterface, v> lVar);

    void l(@NotNull l<? super DialogInterface, v> lVar);

    void m(@Nullable l<? super DialogInterface, v> lVar);

    void n(@NotNull String[] strArr, @NotNull boolean[] zArr, @NotNull q<? super DialogInterface, ? super Integer, ? super Boolean, v> qVar);
}
