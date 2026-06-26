package c.e.a.b.j;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;

/* JADX INFO: compiled from: Chip.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends ViewOutlineProvider {
    public final /* synthetic */ Chip a;

    public a(Chip chip) {
        this.a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public void getOutline(View view, @NonNull Outline outline) {
        ChipDrawable chipDrawable = this.a.f2146e;
        if (chipDrawable != null) {
            chipDrawable.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
