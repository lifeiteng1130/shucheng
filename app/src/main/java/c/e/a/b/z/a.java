package c.e.a.b.z;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: ElasticTabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    public static float c(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (float) (1.0d - Math.cos((((double) f2) * 3.141592653589793d) / 2.0d));
    }

    @Override // c.e.a.b.z.b
    public void b(TabLayout tabLayout, View view, View view2, float f2, @NonNull Drawable drawable) {
        float fSin;
        float fC;
        RectF rectFA = b.a(tabLayout, view);
        RectF rectFA2 = b.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            fSin = c(f2);
            fC = (float) Math.sin((((double) f2) * 3.141592653589793d) / 2.0d);
        } else {
            fSin = (float) Math.sin((((double) f2) * 3.141592653589793d) / 2.0d);
            fC = c(f2);
        }
        drawable.setBounds(c.e.a.b.a.a.b((int) rectFA.left, (int) rectFA2.left, fSin), drawable.getBounds().top, c.e.a.b.a.a.b((int) rectFA.right, (int) rectFA2.right, fC), drawable.getBounds().bottom);
    }
}
