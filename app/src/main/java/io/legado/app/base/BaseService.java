package io.legado.app.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import e.a.a.d.u.b;
import f.c0.b.p;
import f.c0.c.j;
import g.b.a0;
import g.b.k0;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\nJ\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lio/legado/app/base/BaseService;", "Landroid/app/Service;", "Lg/b/a0;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "Lf/v;", "onDestroy", "()V", "Lf/z/f;", "getCoroutineContext", "()Lf/z/f;", "coroutineContext", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseService extends Service implements a0 {
    public final /* synthetic */ a0 a = f.a();

    public static b a(BaseService baseService, a0 a0Var, f.z.f fVar, p pVar, int i2, Object obj) {
        if ((i2 & 1) == 0) {
            baseService = null;
        }
        if ((i2 & 2) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        j.e(baseService, "scope");
        j.e(fVar, c.R);
        j.e(pVar, "block");
        return b.a.a(baseService, fVar, new e.a.a.b.c(pVar, null));
    }

    @Override // g.b.a0
    @NotNull
    public f.z.f getCoroutineContext() {
        return this.a.getCoroutineContext();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f.I0(this, null, 1);
    }
}
