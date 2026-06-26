package io.legado.app.ui.widget.seekbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.legado.app.lib.theme.ATH;
import io.wenyuange.app.release.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: VerticalSeekBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u001d\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\tH\u0000¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010)\u001a\u00020\tH\u0002¢\u0006\u0004\b*\u0010+R$\u00100\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\u0013R\u0018\u00104\u001a\u0004\u0018\u0001018B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00108R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010:¨\u0006B"}, d2 = {"Lio/legado/app/ui/widget/seekbar/VerticalSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/graphics/drawable/Drawable;", "thumb", "Lf/v;", "setThumb", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "progress", "setProgress", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "d", "()Z", ai.aD, "(Landroid/view/MotionEvent;)V", "active", ai.at, "(Z)V", "fromUser", "b", "(IZ)V", "angle", "getRotationAngle", "()I", "setRotationAngle", "rotationAngle", "Lio/legado/app/ui/widget/seekbar/VerticalSeekBarWrapper;", "getWrapper", "()Lio/legado/app/ui/widget/seekbar/VerticalSeekBarWrapper;", "wrapper", "Z", "mIsDragging", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "mMethodSetProgressFromUser", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mRotationAngle", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class VerticalSeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean mIsDragging;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Method mMethodSetProgressFromUser;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int mRotationAngle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalSeekBar(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    private final VerticalSeekBarWrapper getWrapper() {
        ViewParent parent = getParent();
        if (parent instanceof VerticalSeekBarWrapper) {
            return (VerticalSeekBarWrapper) parent;
        }
        return null;
    }

    public final void a(boolean active) {
        ViewParent parent = getParent();
        if (parent == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(active);
    }

    public final synchronized void b(int progress, boolean fromUser) {
        if (this.mMethodSetProgressFromUser == null) {
            try {
                Method declaredMethod = ProgressBar.class.getDeclaredMethod("setProgress", Integer.TYPE, Boolean.TYPE);
                j.d(declaredMethod, "ProgressBar::class.java.getDeclaredMethod(\n                    \"setProgress\",\n                    Int::class.javaPrimitiveType,\n                    Boolean::class.javaPrimitiveType\n                )");
                declaredMethod.setAccessible(true);
                this.mMethodSetProgressFromUser = declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        Method method = this.mMethodSetProgressFromUser;
        if (method != null) {
            try {
                j.c(method);
                method.invoke(this, Integer.valueOf(progress), Boolean.valueOf(fromUser));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        } else {
            super.setProgress(progress);
        }
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }

    public final void c(MotionEvent event) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int height = (getHeight() - paddingLeft) - paddingRight;
        int y = (int) event.getY();
        int i2 = this.mRotationAngle;
        float f2 = 0.0f;
        float f3 = i2 != 90 ? i2 != 270 ? 0.0f : r2 - y : y - paddingLeft;
        if (f3 >= 0.0f && height != 0) {
            float f4 = height;
            f2 = f3 > f4 ? 1.0f : f3 / f4;
        }
        b((int) (f2 * getMax()), true);
    }

    public final boolean d() {
        return !isInEditMode();
    }

    /* JADX INFO: renamed from: getRotationAngle, reason: from getter */
    public final int getMRotationAngle() {
        return this.mRotationAngle;
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        if (!d()) {
            int i2 = this.mRotationAngle;
            if (i2 == 90) {
                canvas.rotate(90.0f);
                canvas.translate(0.0f, -getWidth());
            } else if (i2 == 270) {
                canvas.rotate(-90.0f);
                canvas.translate(-getHeight(), 0.0f);
            }
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    @Override // android.widget.AbsSeekBar, android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r6, @org.jetbrains.annotations.NotNull android.view.KeyEvent r7) {
        /*
            r5 = this;
            java.lang.String r0 = "event"
            f.c0.c.j.e(r7, r0)
            boolean r0 = r5.isEnabled()
            if (r0 == 0) goto L40
            r0 = -1
            r1 = 0
            r2 = 1
            switch(r6) {
                case 19: goto L1c;
                case 20: goto L15;
                case 21: goto L14;
                case 22: goto L14;
                default: goto L11;
            }
        L11:
            r0 = 0
            r3 = 0
            goto L24
        L14:
            return r1
        L15:
            int r3 = r5.mRotationAngle
            r4 = 90
            if (r3 != r4) goto L23
            goto L22
        L1c:
            int r3 = r5.mRotationAngle
            r4 = 270(0x10e, float:3.78E-43)
            if (r3 != r4) goto L23
        L22:
            r0 = 1
        L23:
            r3 = 1
        L24:
            if (r3 == 0) goto L40
            int r6 = r5.getKeyProgressIncrement()
            int r7 = r5.getProgress()
            int r0 = r0 * r6
            int r0 = r0 + r7
            if (r0 < 0) goto L3a
            int r6 = r5.getMax()
            if (r0 > r6) goto L3a
            r1 = 1
        L3a:
            if (r1 == 0) goto L3f
            r5.b(r0, r2)
        L3f:
            return r2
        L40:
            boolean r6 = super.onKeyDown(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.widget.seekbar.VerticalSeekBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (d()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(heightMeasureSpec, widthMeasureSpec);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (!isInEditMode() || layoutParams == null || layoutParams.height < 0) {
                setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            } else {
                setMeasuredDimension(getMeasuredHeight(), layoutParams.height);
            }
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        if (d()) {
            super.onSizeChanged(w, h2, oldw, oldh);
        } else {
            super.onSizeChanged(h2, w, oldh, oldw);
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        j.e(event, NotificationCompat.CATEGORY_EVENT);
        boolean z = true;
        if (d()) {
            boolean zOnTouchEvent = super.onTouchEvent(event);
            if (!zOnTouchEvent) {
                return zOnTouchEvent;
            }
            int action = event.getAction();
            if (action == 0) {
                a(true);
                return zOnTouchEvent;
            }
            if (action != 1 && action != 3) {
                return zOnTouchEvent;
            }
            a(false);
            return zOnTouchEvent;
        }
        if (isEnabled()) {
            int action2 = event.getAction();
            if (action2 == 0) {
                setPressed(true);
                this.mIsDragging = true;
                c(event);
                a(true);
                invalidate();
            } else if (action2 == 1) {
                if (this.mIsDragging) {
                    c(event);
                    this.mIsDragging = false;
                    setPressed(false);
                } else {
                    this.mIsDragging = true;
                    c(event);
                    this.mIsDragging = false;
                    a(false);
                }
                invalidate();
            } else if (action2 != 2) {
                if (action2 == 3) {
                    if (this.mIsDragging) {
                        this.mIsDragging = false;
                        setPressed(false);
                    }
                    invalidate();
                }
            } else if (this.mIsDragging) {
                c(event);
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        if (!d()) {
            onSizeChanged(getWidth(), getHeight(), 0, 0);
        }
    }

    public final void setRotationAngle(int i2) {
        if (!(i2 == 90 || i2 == 270)) {
            throw new IllegalArgumentException(j.k("Invalid angle specified :", Integer.valueOf(i2)).toString());
        }
        if (this.mRotationAngle == i2) {
            return;
        }
        this.mRotationAngle = i2;
        if (!d()) {
            requestLayout();
            return;
        }
        VerticalSeekBarWrapper wrapper = getWrapper();
        if (wrapper == null) {
            return;
        }
        wrapper.a(wrapper.getWidth(), wrapper.getHeight());
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(@NotNull Drawable thumb) {
        j.e(thumb, "thumb");
        super.setThumb(thumb);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.mRotationAngle = 90;
        ATH ath = ATH.a;
        j.e(context, c.R);
        j.e(context, c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#263238");
        j.e(context, c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        ATH.h(ath, this, sharedPreferences.getInt("accent_color", color), false, 4);
        ViewCompat.setLayoutDirection(this, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.VerticalSeekBar);
            j.d(typedArrayObtainStyledAttributes2, "context.obtainStyledAttributes(attrs, R.styleable.VerticalSeekBar)");
            int integer = typedArrayObtainStyledAttributes2.getInteger(0, 0);
            if (integer == 90 || integer == 270) {
                this.mRotationAngle = integer;
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
    }
}
