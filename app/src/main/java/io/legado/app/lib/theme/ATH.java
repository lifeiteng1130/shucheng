package io.legado.app.lib.theme;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.EdgeEffect;
import android.widget.ScrollView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import e.a.a.d.e;
import e.a.a.e.d.a;
import e.a.a.e.d.b;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import java.lang.reflect.Field;
import k.d.a.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ATH.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ATH {

    @NotNull
    public static final ATH a = new ATH();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ATH$DEFAULT_EFFECT_FACTORY$1 f6904b = new RecyclerView.EdgeEffectFactory() { // from class: io.legado.app.lib.theme.ATH$DEFAULT_EFFECT_FACTORY$1
        @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
        @NotNull
        public EdgeEffect createEdgeEffect(@NotNull RecyclerView view, int direction) {
            j.e(view, "view");
            EdgeEffect edgeEffectCreateEdgeEffect = super.createEdgeEffect(view, direction);
            j.d(edgeEffectCreateEdgeEffect, "super.createEdgeEffect(view, direction)");
            Context context = view.getContext();
            j.d(context, "view.context");
            j.e(context, c.R);
            j.e(context, c.R);
            SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
            j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
            int color = Color.parseColor("#455A64");
            j.e(context, c.R);
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimary});
            j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
            try {
                color = typedArrayObtainStyledAttributes.getColor(0, color);
            } catch (Exception unused) {
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
            typedArrayObtainStyledAttributes.recycle();
            edgeEffectCreateEdgeEffect.setColor(sharedPreferences.getInt("primary_color", color));
            return edgeEffectCreateEdgeEffect;
        }
    };

    public static void h(ATH ath, View view, int i2, boolean z, int i3) {
        if ((i3 & 4) != 0) {
            e eVar = e.a;
            Context context = view.getContext();
            j.d(context, "fun setTint(\n        view: View,\n        @ColorInt color: Int,\n        isDark: Boolean = AppConfig.isNightTheme(view.context)\n    ) {\n        TintHelper.setTintAuto(view, color, false, isDark)\n    }");
            z = eVar.n(context);
        }
        j.e(view, "view");
        e.a.a.e.d.c.a.f(view, i2, false, z);
    }

    public final void a(@Nullable View view) {
        if (view == null) {
            return;
        }
        if (view.getBackground() == null) {
            Context context = view.getContext();
            j.d(context, c.R);
            view.setBackgroundColor(f.R1(context));
        } else {
            Context context2 = view.getContext();
            j.d(context2, c.R);
            int iR1 = f.R1(context2);
            boolean zM = e.a.m();
            j.e(view, "view");
            e.a.a.e.d.c.a.f(view, iR1, true, zM);
        }
    }

    public final void b(@Nullable View view) {
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).setEdgeEffectFactory(f6904b);
            return;
        }
        int i2 = 0;
        try {
            if (view instanceof ViewPager2) {
                ViewPager2 viewPager2 = (ViewPager2) view;
                Context context = viewPager2.getContext();
                j.d(context, "view.context");
                j.e(context, c.R);
                j.e(context, c.R);
                SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
                j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
                int color = Color.parseColor("#455A64");
                j.e(context, c.R);
                TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimary});
                j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
                try {
                    color = typedArrayObtainStyledAttributes.getColor(0, color);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
                typedArrayObtainStyledAttributes.recycle();
                int i3 = sharedPreferences.getInt("primary_color", color);
                String[] strArr = {"mLeftEdge", "mRightEdge"};
                while (i2 < 2) {
                    String str = strArr[i2];
                    i2++;
                    Field declaredField = ViewPager2.class.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(viewPager2);
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.EdgeEffect");
                    }
                    ((EdgeEffect) obj).setColor(i3);
                }
                return;
            }
            if (view instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) view;
                Context context2 = scrollView.getContext();
                j.d(context2, "view.context");
                j.e(context2, c.R);
                j.e(context2, c.R);
                SharedPreferences sharedPreferences2 = context2.getSharedPreferences("app_themes", 0);
                j.d(sharedPreferences2, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
                int color2 = Color.parseColor("#455A64");
                j.e(context2, c.R);
                TypedArray typedArrayObtainStyledAttributes2 = context2.getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimary});
                j.d(typedArrayObtainStyledAttributes2, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
                try {
                    color2 = typedArrayObtainStyledAttributes2.getColor(0, color2);
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    typedArrayObtainStyledAttributes2.recycle();
                    throw th2;
                }
                typedArrayObtainStyledAttributes2.recycle();
                int i4 = sharedPreferences2.getInt("primary_color", color2);
                String[] strArr2 = {"mEdgeGlowTop", "mEdgeGlowBottom"};
                while (i2 < 2) {
                    String str2 = strArr2[i2];
                    i2++;
                    Field declaredField2 = ScrollView.class.getDeclaredField(str2);
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(scrollView);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.EdgeEffect");
                    }
                    ((EdgeEffect) obj2).setColor(i4);
                }
            }
        } catch (Exception unused3) {
        }
    }

    @NotNull
    public final GradientDrawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics()));
        gradientDrawable.setColor(f.R1(h.g()));
        return gradientDrawable;
    }

    @NotNull
    public final AlertDialog d(@NotNull AlertDialog alertDialog) {
        j.e(alertDialog, "dialog");
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(c());
        }
        a aVar = new a();
        b.a aVar2 = b.a;
        Context context = alertDialog.getContext();
        j.d(context, "dialog.context");
        aVar.b(aVar2.a(context));
        Context context2 = alertDialog.getContext();
        j.d(context2, "dialog.context");
        int iA = aVar2.a(context2);
        int iAlpha = Color.alpha(iA);
        float[] fArr = new float[3];
        Color.colorToHSV(iA, fArr);
        fArr[2] = fArr[2] * 0.9f;
        aVar.d((iAlpha << 24) + (16777215 & Color.HSVToColor(fArr)));
        ColorStateList colorStateListA = aVar.a();
        if (alertDialog.getButton(-2) != null) {
            alertDialog.getButton(-2).setTextColor(colorStateListA);
        }
        if (alertDialog.getButton(-1) != null) {
            alertDialog.getButton(-1).setTextColor(colorStateListA);
        }
        if (alertDialog.getButton(-3) != null) {
            alertDialog.getButton(-3).setTextColor(colorStateListA);
        }
        return alertDialog;
    }

    public final void e(@NotNull Activity activity, boolean z) {
        WindowInsetsController insetsController;
        j.e(activity, "activity");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30 && (insetsController = activity.getWindow().getInsetsController()) != null) {
            if (z) {
                insetsController.setSystemBarsAppearance(8, 8);
            } else {
                insetsController.setSystemBarsAppearance(0, 8);
            }
        }
        if (i2 >= 23) {
            View decorView = activity.getWindow().getDecorView();
            j.d(decorView, "activity.window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                decorView.setSystemUiVisibility(systemUiVisibility | 8192);
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
            }
        }
    }

    public final void f(@NotNull Activity activity, int i2) {
        j.e(activity, "activity");
        e(activity, ((double) 1) - (((((double) Color.blue(i2)) * 0.114d) + ((((double) Color.green(i2)) * 0.587d) + (((double) Color.red(i2)) * 0.299d))) / ((double) 255)) < 0.4d);
    }

    public final void g(@NotNull Activity activity, int i2) {
        WindowInsetsController insetsController;
        j.e(activity, "activity");
        activity.getWindow().setNavigationBarColor(i2);
        boolean z = ((double) 1) - (((((double) Color.blue(i2)) * 0.114d) + ((((double) Color.green(i2)) * 0.587d) + (((double) Color.red(i2)) * 0.299d))) / ((double) 255)) < 0.4d;
        j.e(activity, "activity");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30 && (insetsController = activity.getWindow().getInsetsController()) != null) {
            if (z) {
                insetsController.setSystemBarsAppearance(16, 16);
            } else {
                insetsController.setSystemBarsAppearance(0, 16);
            }
        }
        if (i3 >= 26) {
            View decorView = activity.getWindow().getDecorView();
            j.d(decorView, "activity.window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        }
    }
}
