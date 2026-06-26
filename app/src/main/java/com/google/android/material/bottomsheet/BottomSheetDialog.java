package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDialog extends AppCompatDialog {
    public BottomSheetBehavior<FrameLayout> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f2101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public BottomSheetBehavior.c f2105f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
            if (bottomSheetDialog.f2102c && bottomSheetDialog.isShowing()) {
                BottomSheetDialog bottomSheetDialog2 = BottomSheetDialog.this;
                if (!bottomSheetDialog2.f2104e) {
                    TypedArray typedArrayObtainStyledAttributes = bottomSheetDialog2.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
                    bottomSheetDialog2.f2103d = typedArrayObtainStyledAttributes.getBoolean(0, true);
                    typedArrayObtainStyledAttributes.recycle();
                    bottomSheetDialog2.f2104e = true;
                }
                if (bottomSheetDialog2.f2103d) {
                    BottomSheetDialog.this.cancel();
                }
            }
        }
    }

    public class b extends AccessibilityDelegateCompat {
        public b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!BottomSheetDialog.this.f2102c) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f2102c) {
                    bottomSheetDialog.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i2, bundle);
        }
    }

    public class c implements View.OnTouchListener {
        public c(BottomSheetDialog bottomSheetDialog) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class d extends BottomSheetBehavior.c {
        public d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void a(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void b(@NonNull View view, int i2) {
            if (i2 == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int i2) {
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            i2 = context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
        }
        super(context, i2);
        this.f2102c = true;
        this.f2103d = true;
        this.f2105f = new d();
        supportRequestWindowFeature(1);
    }

    public final FrameLayout a() {
        if (this.f2101b == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.f2101b = frameLayout;
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(R$id.design_bottom_sheet);
            int i2 = BottomSheetBehavior.a;
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
                throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
            }
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (!(behavior instanceof BottomSheetBehavior)) {
                throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
            }
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = (BottomSheetBehavior) behavior;
            this.a = bottomSheetBehavior;
            BottomSheetBehavior.c cVar = this.f2105f;
            if (!bottomSheetBehavior.J.contains(cVar)) {
                bottomSheetBehavior.J.add(cVar);
            }
            this.a.h(this.f2102c);
        }
        return this.f2101b;
    }

    public final View b(int i2, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        a();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f2101b.findViewById(R$id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.f2101b.findViewById(R$id.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new a());
        ViewCompat.setAccessibilityDelegate(frameLayout, new b());
        frameLayout.setOnTouchListener(new c(this));
        return this.f2101b;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.a == null) {
            a();
        }
        super.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.a;
        if (bottomSheetBehavior == null || bottomSheetBehavior.z != 5) {
            return;
        }
        bottomSheetBehavior.j(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f2102c != z) {
            this.f2102c = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.h(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f2102c) {
            this.f2102c = true;
        }
        this.f2103d = z;
        this.f2104e = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i2) {
        super.setContentView(b(i2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(b(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(b(0, view, layoutParams));
    }
}
