package io.legado.app.ui.widget.anima.explosion_field;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.g.m.i.d.d;
import e.a.a.g.m.i.d.e;
import f.c0.c.j;
import f.c0.c.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExplosionView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0015\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u00061"}, d2 = {"Lio/legado/app/ui/widget/anima/explosion_field/ExplosionView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "Lf/v;", "onDraw", "(Landroid/graphics/Canvas;)V", "", "customDuration", "setCustomDuration", "(J)V", "Le/a/a/g/m/i/d/d;", "iEvents", "addActionEvent", "(Le/a/a/g/m/i/d/d;)V", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/graphics/Rect;", "bound", "startDelay", "view", ai.at, "(Landroid/graphics/Bitmap;Landroid/graphics/Rect;JLandroid/view/View;)V", "Landroid/view/View$OnClickListener;", "mOnClickListener", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "d", "Landroid/view/View$OnClickListener;", "", "f", "[I", "mExpandInset", ai.aD, "Le/a/a/g/m/i/d/d;", "mZAnimatorListener", "b", "J", "Ljava/util/ArrayList;", "Le/a/a/g/m/i/d/a;", "e", "Ljava/util/ArrayList;", "mExplosions", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ExplosionView extends View {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long customDuration;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public d mZAnimatorListener;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View.OnClickListener mOnClickListener;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<e.a.a.g.m.i.d.a> mExplosions;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final int[] mExpandInset;

    /* JADX INFO: compiled from: ExplosionView.kt */
    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f7634b;

        public a(View view) {
            this.f7634b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            j.e(animator, "animation");
            ArrayList<e.a.a.g.m.i.d.a> arrayList = ExplosionView.this.mExplosions;
            Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            y.a(arrayList).remove(animator);
            View view = this.f7634b;
            if (view != null) {
                view.setScaleX(1.0f);
                this.f7634b.setScaleY(1.0f);
                this.f7634b.setAlpha(1.0f);
                this.f7634b.setOnClickListener(ExplosionView.this.mOnClickListener);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExplosionView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    @JvmOverloads
    public final void a(@Nullable Bitmap bitmap, @NotNull Rect bound, long startDelay, @Nullable View view) {
        j.e(bound, "bound");
        long j2 = this.customDuration;
        j.c(bitmap);
        e.a.a.g.m.i.d.a aVar = new e.a.a.g.m.i.d.a(this, bitmap, bound);
        aVar.addListener(new a(view));
        aVar.setStartDelay(startDelay);
        aVar.setDuration(j2);
        this.mExplosions.add(aVar);
        aVar.start();
    }

    public final void addActionEvent(@NotNull d iEvents) {
        j.e(iEvents, "iEvents");
        this.mZAnimatorListener = iEvents;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ae  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(@org.jetbrains.annotations.NotNull android.graphics.Canvas r19) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.widget.anima.explosion_field.ExplosionView.onDraw(android.graphics.Canvas):void");
    }

    public final void setCustomDuration(long customDuration) {
        this.customDuration = customDuration;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExplosionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        e.a.a.g.m.i.d.a aVar = e.a.a.g.m.i.d.a.a;
        e.a.a.g.m.i.d.a aVar2 = e.a.a.g.m.i.d.a.a;
        this.customDuration = 1024L;
        this.mExplosions = new ArrayList<>();
        int[] iArr = new int[2];
        this.mExpandInset = iArr;
        e eVar = e.a;
        Arrays.fill(iArr, e.c(32));
    }
}
