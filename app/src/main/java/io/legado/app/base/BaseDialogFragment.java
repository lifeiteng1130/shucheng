package io.legado.app.base;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.u.b;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.f;
import g.b.a0;
import g.b.f1;
import g.b.g2.m;
import g.b.i1;
import g.b.k0;
import g.b.y;
import java.lang.reflect.InvocationTargetException;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lio/legado/app/base/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lg/b/a0;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "P", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "onDestroy", "()V", "O", "Lg/b/f1;", ai.at, "Lg/b/f1;", "job", "Lf/z/f;", "getCoroutineContext", "()Lf/z/f;", "coroutineContext", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseDialogFragment extends DialogFragment implements a0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public f1 job;

    public static b N(BaseDialogFragment baseDialogFragment, a0 a0Var, f fVar, p pVar, int i2, Object obj) {
        y yVar;
        if ((i2 & 1) == 0) {
            baseDialogFragment = null;
        }
        if ((i2 & 2) != 0) {
            k0 k0Var = k0.f6264c;
            yVar = k0.f6263b;
        } else {
            yVar = null;
        }
        j.e(baseDialogFragment, "scope");
        j.e(yVar, c.R);
        j.e(pVar, "block");
        return b.a.a(baseDialogFragment, yVar, new e.a.a.b.b(pVar, null));
    }

    public void O() {
    }

    public abstract void P(@NotNull View view, @Nullable Bundle savedInstanceState);

    @Override // g.b.a0
    @NotNull
    public f getCoroutineContext() {
        f1 f1Var = this.job;
        if (f1Var != null) {
            k0 k0Var = k0.f6264c;
            return f1Var.plus(m.f6207b);
        }
        j.m("job");
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.job = new i1(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f1 f1Var = this.job;
        if (f1Var != null) {
            c.b.a.m.f.J0(f1Var, null, 1, null);
        } else {
            j.m("job");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) throws IllegalAccessException, InvocationTargetException {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextG = h.g();
        j.e(contextG, c.R);
        j.e(contextG, c.R);
        int color = 0;
        SharedPreferences sharedPreferences = contextG.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        j.e(contextG, c.R);
        TypedArray typedArrayObtainStyledAttributes = contextG.getTheme().obtainStyledAttributes(new int[]{R.attr.colorBackground});
        j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        view.setBackgroundColor(sharedPreferences.getInt("backgroundColor", color));
        P(view, savedInstanceState);
        O();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String tag) {
        j.e(manager, "manager");
        try {
            manager.beginTransaction().remove(this).commit();
            super.show(manager, tag);
            f.h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
    }
}
