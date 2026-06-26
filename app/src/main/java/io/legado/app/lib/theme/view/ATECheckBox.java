package io.legado.app.lib.theme.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.lib.theme.ATH;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ATECheckBox.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/lib/theme/view/ATECheckBox;", "Landroidx/appcompat/widget/AppCompatCheckBox;", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ATECheckBox extends AppCompatCheckBox {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ATECheckBox(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        if (isInEditMode()) {
            return;
        }
        ATH.h(ATH.a, this, f.M1(context), false, 4);
    }
}
