package e.a.a.d;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Build;
import io.legado.app.ui.welcome.Launcher1;
import io.legado.app.ui.welcome.Launcher2;
import io.legado.app.ui.welcome.Launcher3;
import io.legado.app.ui.welcome.Launcher4;
import io.legado.app.ui.welcome.Launcher5;
import io.legado.app.ui.welcome.Launcher6;
import io.legado.app.ui.welcome.WelcomeActivity;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LauncherIconHelp.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    @NotNull
    public static final p a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final PackageManager f5552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final ArrayList<ComponentName> f5553c;

    static {
        PackageManager packageManager = k.d.a.h.g().getPackageManager();
        f.c0.c.j.d(packageManager, "appCtx.packageManager");
        f5552b = packageManager;
        f5553c = f.x.e.a(new ComponentName(k.d.a.h.g(), Launcher1.class.getName()), new ComponentName(k.d.a.h.g(), Launcher2.class.getName()), new ComponentName(k.d.a.h.g(), Launcher3.class.getName()), new ComponentName(k.d.a.h.g(), Launcher4.class.getName()), new ComponentName(k.d.a.h.g(), Launcher5.class.getName()), new ComponentName(k.d.a.h.g(), Launcher6.class.getName()));
    }

    public static final void a(@Nullable String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26) {
            c.b.a.m.f.Q5(k.d.a.h.g(), R.string.change_icon_error);
            return;
        }
        for (ComponentName componentName : f5553c) {
            String className = componentName.getClassName();
            f.c0.c.j.d(className, "it.className");
            if (f.h0.k.i(str, f.h0.k.O(className, ".", null, 2), true)) {
                f5552b.setComponentEnabledSetting(componentName, 1, 1);
                z = true;
            } else {
                f5552b.setComponentEnabledSetting(componentName, 2, 1);
            }
        }
        if (z) {
            f5552b.setComponentEnabledSetting(new ComponentName(k.d.a.h.g(), WelcomeActivity.class.getName()), 2, 1);
        } else {
            f5552b.setComponentEnabledSetting(new ComponentName(k.d.a.h.g(), WelcomeActivity.class.getName()), 1, 1);
        }
    }
}
