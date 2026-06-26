package io.legado.app.lib.theme;

import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ATH.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/legado/app/lib/theme/ATH$setEdgeEffectColor$1", "Landroidx/recyclerview/widget/RecyclerView$EdgeEffectFactory;", "Landroidx/recyclerview/widget/RecyclerView;", "view", "", "direction", "Landroid/widget/EdgeEffect;", "createEdgeEffect", "(Landroidx/recyclerview/widget/RecyclerView;I)Landroid/widget/EdgeEffect;", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ATH$setEdgeEffectColor$1 extends RecyclerView.EdgeEffectFactory {
    @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
    @NotNull
    public EdgeEffect createEdgeEffect(@NotNull RecyclerView view, int direction) {
        j.e(view, "view");
        EdgeEffect edgeEffectCreateEdgeEffect = super.createEdgeEffect(view, direction);
        j.d(edgeEffectCreateEdgeEffect, "super.createEdgeEffect(view, direction)");
        edgeEffectCreateEdgeEffect.setColor(0);
        return edgeEffectCreateEdgeEffect;
    }
}
