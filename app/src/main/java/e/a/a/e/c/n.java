package e.a.a.e.c;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import io.legado.app.lib.permission.PermissionActivity;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RequestManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements h {

    @NotNull
    public static final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static Stack<l> f5642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static l f5643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Handler f5644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Runnable f5645e;

    static {
        n nVar = new n();
        a = nVar;
        f5644d = new Handler(Looper.getMainLooper());
        f5645e = new Runnable() { // from class: e.a.a.e.c.d
            @Override // java.lang.Runnable
            public final void run() {
                Context context;
                p pVar;
                Context context2;
                l lVar = n.f5643c;
                if (lVar == null) {
                    return;
                }
                f.c0.c.j.e(lVar, "callback");
                o.a = lVar;
                String[] strArrC = lVar.c();
                if (Build.VERSION.SDK_INT < 23) {
                    if (strArrC == null) {
                        lVar.f();
                        return;
                    }
                    CharSequence text = null;
                    if (lVar.f5640f != 0 && (pVar = lVar.f5637c) != null && (context2 = pVar.getContext()) != null) {
                        text = context2.getText(lVar.f5640f);
                    }
                    if (text != null) {
                        lVar.g(text, new m(lVar, strArrC));
                        return;
                    } else {
                        lVar.e(strArrC);
                        return;
                    }
                }
                if (strArrC == null) {
                    lVar.f();
                    return;
                }
                p pVar2 = lVar.f5637c;
                if (pVar2 == null || (context = pVar2.getContext()) == null) {
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("KEY_INPUT_REQUEST_TYPE", 1);
                intent.putExtra("KEY_INPUT_PERMISSIONS_CODE", lVar.f5636b);
                intent.putExtra("KEY_INPUT_PERMISSIONS", strArrC);
                context.startActivity(intent);
            }
        };
        f.c0.c.j.e(nVar, "callback");
        o.f5646b = nVar;
    }

    @Override // e.a.a.e.c.h
    public void a() {
        c();
    }

    @Override // e.a.a.e.c.h
    public void b(@NotNull String[] strArr) {
        f.c0.c.j.e(strArr, "deniedPermissions");
        c();
    }

    public final void c() {
        l lVar = f5643c;
        if (lVar != null) {
            lVar.f5639e = null;
        }
        f5643c = null;
        Stack<l> stack = f5642b;
        if (stack == null) {
            return;
        }
        l lVarPop = stack.empty() ? null : stack.pop();
        f5643c = lVarPop;
        if (lVarPop == null) {
            return;
        }
        f5644d.post(f5645e);
    }
}
