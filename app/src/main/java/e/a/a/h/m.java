package e.a.a.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: FragmentExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    @SuppressLint({"RestrictedApi"})
    @NotNull
    public static final Menu a(@NotNull Menu menu, @NotNull Context context, @NotNull e.a.a.c.e eVar) {
        f.c0.c.j.e(menu, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(eVar, "theme");
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        int iC2 = c.b.a.m.f.c2(context, R.color.primaryText);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(eVar, "theme");
        c.b.a.m.f.c2(context, R.color.primaryText);
        int iR2 = c.b.a.m.f.R2(context);
        int iOrdinal = eVar.ordinal();
        if (iOrdinal == 0) {
            iR2 = c.b.a.m.f.c2(context, R.color.md_white_1000);
        } else if (iOrdinal == 1) {
            iR2 = c.b.a.m.f.c2(context, R.color.md_black_1000);
        }
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menu.getItem(i2);
            f.c0.c.j.b(item, "getItem(index)");
            MenuItemImpl menuItemImpl = (MenuItemImpl) item;
            Drawable icon = menuItemImpl.getIcon();
            int i3 = menuItemImpl.requiresOverflow() ? iC2 : iR2;
            PorterDuff.Mode mode = (4 & 4) != 0 ? PorterDuff.Mode.SRC_ATOP : null;
            f.c0.c.j.e(mode, "tintMode");
            if (icon != null) {
                Drawable drawableWrap = DrawableCompat.wrap(icon);
                drawableWrap.mutate();
                DrawableCompat.setTintMode(drawableWrap, mode);
                DrawableCompat.setTint(drawableWrap, i3);
            }
        }
        return menu;
    }

    public static /* synthetic */ Menu b(Menu menu, Context context, e.a.a.c.e eVar, int i2) {
        a(menu, context, (i2 & 2) != 0 ? e.a.a.c.e.Auto : null);
        return menu;
    }

    public static boolean c(Fragment fragment, String str, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(str, "key");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        return c.b.a.m.f.i2(contextRequireContext).getBoolean(str, z);
    }

    public static final int d(@NotNull Fragment fragment, @NotNull String str, int i2) {
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(str, "key");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        return c.b.a.m.f.i2(contextRequireContext).getInt(str, i2);
    }

    public static /* synthetic */ int e(Fragment fragment, String str, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return d(fragment, str, i2);
    }

    public static String f(Fragment fragment, String str, String str2, int i2) {
        int i3 = i2 & 2;
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(str, "key");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        return c.b.a.m.f.i2(contextRequireContext).getString(str, null);
    }

    public static final void g(@NotNull Fragment fragment, @NotNull CharSequence charSequence) {
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(charSequence, "message");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        c.b.a.m.f.S3(contextRequireContext, charSequence);
    }

    public static final void h(@NotNull Fragment fragment, @NotNull String str, boolean z) {
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(str, "key");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        SharedPreferences.Editor editorEdit = c.b.a.m.f.i2(contextRequireContext).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public static final void i(@NotNull Fragment fragment, @NotNull String str, int i2) {
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(str, "key");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        SharedPreferences.Editor editorEdit = c.b.a.m.f.i2(contextRequireContext).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putInt(str, i2);
        editorEdit.apply();
    }

    public static final void j(@NotNull Fragment fragment, @NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(str, "key");
        f.c0.c.j.e(str2, ES6Iterator.VALUE_PROPERTY);
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        SharedPreferences.Editor editorEdit = c.b.a.m.f.i2(contextRequireContext).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static final void k(@NotNull Fragment fragment, @NotNull String str) {
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(str, "key");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        SharedPreferences.Editor editorEdit = c.b.a.m.f.i2(contextRequireContext).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public static final void l(@NotNull Fragment fragment, int i2) {
        f.c0.c.j.e(fragment, "<this>");
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
        c.b.a.m.f.Q5(fragmentActivityRequireActivity, i2);
    }

    public static final void m(@NotNull Fragment fragment, @NotNull CharSequence charSequence) {
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(charSequence, "message");
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
        c.b.a.m.f.R5(fragmentActivityRequireActivity, charSequence);
    }
}
