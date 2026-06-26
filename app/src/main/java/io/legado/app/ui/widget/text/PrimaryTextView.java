package io.legado.app.ui.widget.text;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimaryTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/widget/text/PrimaryTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PrimaryTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimaryTextView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        j.e(context, c.R);
        j.e(context, c.R);
        int color = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        j.e(context, c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.textColorPrimary});
        j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        setTextColor(sharedPreferences.getInt("text_color_primary", color));
    }
}
