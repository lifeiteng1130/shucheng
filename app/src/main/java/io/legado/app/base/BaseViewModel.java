package io.legado.app.base;

import android.app.Application;
import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.view.AndroidViewModel;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.b.d;
import e.a.a.d.u.b;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import g.b.a0;
import g.b.k0;
import io.legado.app.App;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0015¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\u00020\r8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lio/legado/app/base/BaseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lg/b/a0;", "Lf/v;", "onCleared", "()V", "", "message", ai.aD, "(I)V", "", "d", "(Ljava/lang/CharSequence;)V", "Landroid/content/Context;", "b", "Lf/e;", "()Landroid/content/Context;", c.R, "Lf/z/f;", "getCoroutineContext", "()Lf/z/f;", "coroutineContext", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public class BaseViewModel extends AndroidViewModel implements a0 {
    public final /* synthetic */ a0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e context;

    /* JADX INFO: compiled from: BaseViewModel.kt */
    public static final class a extends k implements f.c0.b.a<App> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final App invoke() {
            return (App) BaseViewModel.this.getApplication();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.a = f.a();
        this.context = f.N3(new a());
    }

    public static b a(BaseViewModel baseViewModel, a0 a0Var, f.z.f fVar, p pVar, int i2, Object obj) {
        BaseViewModel baseViewModel2 = (i2 & 1) != 0 ? baseViewModel : null;
        if ((i2 & 2) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        Objects.requireNonNull(baseViewModel);
        j.e(baseViewModel2, "scope");
        j.e(fVar, c.R);
        j.e(pVar, "block");
        return b.a.a(baseViewModel2, fVar, new d(pVar, null));
    }

    @NotNull
    public final Context b() {
        Object value = this.context.getValue();
        j.d(value, "<get-context>(...)");
        return (Context) value;
    }

    public void c(int message) {
        f.Q5(b(), message);
    }

    public void d(@Nullable CharSequence message) {
        Context contextB = b();
        if (message == null) {
            message = toString();
        }
        f.R5(contextB, message);
    }

    @Override // g.b.a0
    @NotNull
    public f.z.f getCoroutineContext() {
        return this.a.getCoroutineContext();
    }

    @Override // androidx.view.ViewModel
    @CallSuper
    public void onCleared() {
        super.onCleared();
        f.I0(this, null, 1);
    }
}
