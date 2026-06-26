package e.a.a.e.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import f.c0.c.f;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ThemeStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    @NotNull
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Context f5656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final SharedPreferences.Editor f5657c;

    /* JADX INFO: compiled from: ThemeStore.kt */
    public static final class a {
        public a(f fVar) {
        }

        @CheckResult
        @ColorInt
        public final int a(@NotNull Context context) {
            j.e(context, com.umeng.analytics.pro.c.R);
            SharedPreferences sharedPreferencesD = d(context);
            int color = Color.parseColor("#263238");
            j.e(context, com.umeng.analytics.pro.c.R);
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorAccent});
            j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
            try {
                color = typedArrayObtainStyledAttributes.getColor(0, color);
            } catch (Exception unused) {
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
            typedArrayObtainStyledAttributes.recycle();
            return sharedPreferencesD.getInt("accent_color", color);
        }

        @CheckResult
        @ColorInt
        public final int b(@NotNull Context context) {
            j.e(context, com.umeng.analytics.pro.c.R);
            SharedPreferences sharedPreferencesD = d(context);
            j.e(context, com.umeng.analytics.pro.c.R);
            int color = 0;
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorBackground});
            j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
            try {
                color = typedArrayObtainStyledAttributes.getColor(0, 0);
            } catch (Exception unused) {
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
            typedArrayObtainStyledAttributes.recycle();
            return sharedPreferencesD.getInt("bottomBackground", color);
        }

        @CheckResult
        @ColorInt
        public final int c(@NotNull Context context) {
            j.e(context, com.umeng.analytics.pro.c.R);
            j.e(context, com.umeng.analytics.pro.c.R);
            return !d(context).getBoolean("apply_primary_navbar", false) ? ViewCompat.MEASURED_STATE_MASK : d(context).getInt("navigation_bar_color", b(context));
        }

        @CheckResult
        @NotNull
        public final SharedPreferences d(@NotNull Context context) {
            j.e(context, com.umeng.analytics.pro.c.R);
            SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
            j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
            return sharedPreferences;
        }

        @CheckResult
        @ColorInt
        public final int e(@NotNull Context context) {
            j.e(context, com.umeng.analytics.pro.c.R);
            SharedPreferences sharedPreferencesD = d(context);
            int color = Color.parseColor("#455A64");
            j.e(context, com.umeng.analytics.pro.c.R);
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
            return sharedPreferencesD.getInt("primary_color", color);
        }

        @CheckResult
        @ColorInt
        public final int f(@NotNull Context context, boolean z) {
            j.e(context, com.umeng.analytics.pro.c.R);
            j.e(context, com.umeng.analytics.pro.c.R);
            if (!d(context).getBoolean("apply_primarydark_statusbar", true)) {
                return ViewCompat.MEASURED_STATE_MASK;
            }
            if (z) {
                return d(context).getInt("status_bar_color", e(context));
            }
            SharedPreferences sharedPreferencesD = d(context);
            j.e(context, com.umeng.analytics.pro.c.R);
            SharedPreferences sharedPreferencesD2 = d(context);
            int color = Color.parseColor("#37474F");
            j.e(context, com.umeng.analytics.pro.c.R);
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimaryDark});
            j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
            try {
                color = typedArrayObtainStyledAttributes.getColor(0, color);
            } catch (Exception unused) {
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
            typedArrayObtainStyledAttributes.recycle();
            return sharedPreferencesD.getInt("status_bar_color", sharedPreferencesD2.getInt("primary_color_dark", color));
        }

        @CheckResult
        @ColorInt
        public final int g(@NotNull Context context) {
            j.e(context, com.umeng.analytics.pro.c.R);
            SharedPreferences sharedPreferencesD = d(context);
            j.e(context, com.umeng.analytics.pro.c.R);
            int color = 0;
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.textColorSecondary});
            j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
            try {
                color = typedArrayObtainStyledAttributes.getColor(0, 0);
            } catch (Exception unused) {
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
            typedArrayObtainStyledAttributes.recycle();
            return sharedPreferencesD.getInt("text_color_secondary", color);
        }
    }

    public b(Context context, f fVar) {
        this.f5656b = context;
        j.e(context, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        j.d(editorEdit, "prefs(mContext).edit()");
        this.f5657c = editorEdit;
    }

    @NotNull
    public b a(@ColorInt int i2) {
        this.f5657c.putInt("accent_color", i2);
        return this;
    }

    public void b() {
        this.f5657c.putLong("values_changed", System.currentTimeMillis()).putBoolean("is_configured", true).apply();
    }

    @NotNull
    public b c(int i2) {
        this.f5657c.putInt("backgroundColor", i2);
        return this;
    }

    @NotNull
    public b d(int i2) {
        this.f5657c.putInt("bottomBackground", i2);
        return this;
    }

    @NotNull
    public b e(boolean z) {
        this.f5657c.putBoolean("apply_primary_navbar", z);
        return this;
    }

    @NotNull
    public b f(@ColorInt int i2) {
        this.f5657c.putInt("primary_color", i2);
        Context context = this.f5656b;
        j.e(context, com.umeng.analytics.pro.c.R);
        j.e(context, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        if (sharedPreferences.getBoolean("auto_generate_primarydark", true)) {
            if (!(0.9f == 1.0f)) {
                int iAlpha = Color.alpha(i2);
                float[] fArr = new float[3];
                Color.colorToHSV(i2, fArr);
                fArr[2] = fArr[2] * 0.9f;
                i2 = (iAlpha << 24) + (16777215 & Color.HSVToColor(fArr));
            }
            this.f5657c.putInt("primary_color_dark", i2);
        }
        return this;
    }
}
