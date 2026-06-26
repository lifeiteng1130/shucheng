package io.legado.app.ui.widget.prefs;

import android.content.Context;
import android.util.AttributeSet;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PreferenceCategory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lio/legado/app/ui/widget/prefs/PreferenceCategory;", "Landroidx/preference/PreferenceCategory;", "Landroidx/preference/PreferenceViewHolder;", "holder", "Lf/v;", "onBindViewHolder", "(Landroidx/preference/PreferenceViewHolder;)V", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PreferenceCategory extends androidx.preference.PreferenceCategory {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceCategory(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        setPersistent(true);
        setLayoutResource(R.layout.view_preference_category);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(@org.jetbrains.annotations.Nullable androidx.preference.PreferenceViewHolder r13) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.widget.prefs.PreferenceCategory.onBindViewHolder(androidx.preference.PreferenceViewHolder):void");
    }
}
