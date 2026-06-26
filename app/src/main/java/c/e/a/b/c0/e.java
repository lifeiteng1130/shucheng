package c.e.a.b.c0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import c.e.a.b.w.l;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Objects;

/* JADX INFO: compiled from: RadialViewGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends ConstraintLayout {
    public final Runnable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MaterialShapeDrawable f919c;

    /* JADX INFO: compiled from: RadialViewGroup.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b();
        }
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.a);
            handler.post(this.a);
        }
    }

    public void b() {
        int childCount = getChildCount();
        int i2 = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            if ("skip".equals(getChildAt(i3).getTag())) {
                i2++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f2 = 0.0f;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            int i5 = R$id.circle_center;
            if (id != i5 && !"skip".equals(childAt.getTag())) {
                constraintSet.constrainCircle(childAt.getId(), i5, this.f918b, f2);
                f2 = (360.0f / (childCount - i2)) + f2;
            }
        }
        constraintSet.applyTo(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.a);
            handler.post(this.a);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        this.f919c.q(ColorStateList.valueOf(i2));
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f919c = materialShapeDrawable;
        c.e.a.b.w.j jVar = new c.e.a.b.w.j(0.5f);
        c.e.a.b.w.l lVar = materialShapeDrawable.f2333c.a;
        Objects.requireNonNull(lVar);
        l.b bVar = new l.b(lVar);
        bVar.f1241e = jVar;
        bVar.f1242f = jVar;
        bVar.f1243g = jVar;
        bVar.f1244h = jVar;
        materialShapeDrawable.f2333c.a = bVar.a();
        materialShapeDrawable.invalidateSelf();
        this.f919c.q(ColorStateList.valueOf(-1));
        ViewCompat.setBackground(this, this.f919c);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i2, 0);
        this.f918b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.a = new a();
        typedArrayObtainStyledAttributes.recycle();
    }
}
