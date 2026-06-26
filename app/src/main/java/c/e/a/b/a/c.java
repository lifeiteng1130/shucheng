package c.e.a.b.a;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R$id;

/* JADX INFO: compiled from: ChildrenAlphaProperty.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> a = new c("childrenAlpha");

    public c(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @NonNull
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f2 = (Float) viewGroup.getTag(R$id.mtrl_internal_children_alpha_tag);
        return f2 != null ? f2 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f2) {
        ViewGroup viewGroup2 = viewGroup;
        float fFloatValue = f2.floatValue();
        viewGroup2.setTag(R$id.mtrl_internal_children_alpha_tag, Float.valueOf(fFloatValue));
        int childCount = viewGroup2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup2.getChildAt(i2).setAlpha(fFloatValue);
        }
    }
}
