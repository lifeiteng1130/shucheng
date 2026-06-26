package io.legado.app.ui.widget.recycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VerticalDivider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/legado/app/ui/widget/recycler/VerticalDivider;", "Landroidx/recyclerview/widget/DividerItemDecoration;", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class VerticalDivider extends DividerItemDecoration {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalDivider(@NotNull Context context) {
        super(context, 1);
        j.e(context, c.R);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_divider);
        if (drawable == null) {
            return;
        }
        setDrawable(drawable);
    }
}
