package io.legado.app.ui.widget.prefs;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreferenceCompat;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.widget.prefs.Preference;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SwitchPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lio/legado/app/ui/widget/prefs/SwitchPreference;", "Landroidx/preference/SwitchPreferenceCompat;", "Landroidx/preference/PreferenceViewHolder;", "holder", "Lf/v;", "onBindViewHolder", "(Landroidx/preference/PreferenceViewHolder;)V", "", ai.at, "Z", "isBottomBackground", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SwitchPreference extends SwitchPreferenceCompat {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final boolean isBottomBackground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchPreference(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        setLayoutResource(R.layout.view_preference);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Preference);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.Preference)");
        this.isBottomBackground = typedArrayObtainStyledAttributes.getBoolean(25, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(@Nullable PreferenceViewHolder holder) {
        Preference.Companion companion = Preference.INSTANCE;
        Context context = getContext();
        j.d(context, c.R);
        SwitchCompat switchCompat = (SwitchCompat) Preference.Companion.a(companion, context, holder, getIcon(), getTitle(), getSummary(), Integer.valueOf(getWidgetLayoutResource()), Integer.valueOf(R.id.switchWidget), 0, 0, this.isBottomBackground, 384);
        if (switchCompat != null && !switchCompat.isInEditMode()) {
            ATH ath = ATH.a;
            Context context2 = getContext();
            j.d(context2, c.R);
            ATH.h(ath, switchCompat, f.M1(context2), false, 4);
        }
        super.onBindViewHolder(holder);
    }
}
