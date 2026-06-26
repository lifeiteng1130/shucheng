package io.legado.app.ui.widget.text;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.umeng.analytics.pro.c;
import e.a.a.e.d.a;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextInputLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/widget/text/TextInputLayout;", "Lcom/google/android/material/textfield/TextInputLayout;", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TextInputLayout extends com.google.android.material.textfield.TextInputLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        if (isInEditMode()) {
            return;
        }
        a aVar = new a();
        j.e(context, c.R);
        j.e(context, c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#263238");
        j.e(context, c.R);
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
        aVar.b(sharedPreferences.getInt("accent_color", color));
        setDefaultHintTextColor(aVar.a());
    }
}
