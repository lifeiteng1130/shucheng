package io.legado.app.ui.widget.prefs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceViewHolder;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.legado.app.ui.widget.prefs.Preference;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NameListPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lio/legado/app/ui/widget/prefs/NameListPreference;", "Landroidx/preference/ListPreference;", "Landroidx/preference/PreferenceViewHolder;", "holder", "Lf/v;", "onBindViewHolder", "(Landroidx/preference/PreferenceViewHolder;)V", "", ai.at, "Z", "isBottomBackground", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class NameListPreference extends ListPreference {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final boolean isBottomBackground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NameListPreference(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        setLayoutResource(R.layout.view_preference);
        setWidgetLayoutResource(R.layout.item_fillet_text);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Preference);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.Preference)");
        this.isBottomBackground = typedArrayObtainStyledAttributes.getBoolean(25, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@Nullable PreferenceViewHolder holder) {
        Preference.Companion companion = Preference.INSTANCE;
        Context context = getContext();
        j.d(context, c.R);
        TextView textView = (TextView) Preference.Companion.a(companion, context, holder, getIcon(), getTitle(), getSummary(), Integer.valueOf(getWidgetLayoutResource()), Integer.valueOf(R.id.text_view), 0, 0, this.isBottomBackground, 384);
        if (textView != null) {
            textView.setText(getEntry());
            if (this.isBottomBackground) {
                Context context2 = getContext();
                j.d(context2, c.R);
                int iT1 = f.T1(context2);
                Context context3 = getContext();
                j.d(context3, c.R);
                textView.setTextColor(f.S2(context3, ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d));
            }
        }
        super.onBindViewHolder(holder);
    }
}
