package io.legado.app.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import c.b.a.m.f;
import com.google.android.material.appbar.AppBarLayout;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.e;
import f.c0.b.l;
import f.c0.c.j;
import f.h0.k;
import f.v;
import io.legado.app.R$styleable;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TitleBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b6\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\rJ\u001d\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010 \u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0013\u0010*\u001a\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R(\u0010.\u001a\u0004\u0018\u00010!2\b\u0010.\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010$\"\u0004\b\f\u0010&R\u0016\u00101\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010,¨\u00068"}, d2 = {"Lio/legado/app/ui/widget/TitleBar;", "Lcom/google/android/material/appbar/AppBarLayout;", "Lf/v;", "onAttachedToWindow", "()V", "Lkotlin/Function1;", "Landroid/view/View;", "clickListener", "setNavigationOnClickListener", "(Lf/c0/b/l;)V", "", "titleId", "setTitle", "(I)V", "subtitleId", "setSubTitle", "color", "setTitleTextColor", "resId", "setTitleTextAppearance", "setSubTitleTextColor", "setSubTitleTextAppearance", "", "isInMultiWindowMode", "fullScreen", "h", "(ZZ)V", "Landroidx/appcompat/widget/Toolbar;", ai.az, "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar", "", "subtitle", "getSubtitle", "()Ljava/lang/CharSequence;", "setSubtitle", "(Ljava/lang/CharSequence;)V", "Landroid/view/Menu;", "getMenu", "()Landroid/view/Menu;", "menu", ai.aF, "Z", "displayHomeAsUp", "title", "getTitle", ai.aE, "attachToActivity", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TitleBar extends AppBarLayout {
    public static final /* synthetic */ int r = 0;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final Toolbar toolbar;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final boolean displayHomeAsUp;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final boolean attachToActivity;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TitleBar(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    @NotNull
    public final Menu getMenu() {
        Menu menu = this.toolbar.getMenu();
        j.d(menu, "toolbar.menu");
        return menu;
    }

    @Nullable
    public final CharSequence getSubtitle() {
        return this.toolbar.getSubtitle();
    }

    @Nullable
    public final CharSequence getTitle() {
        return this.toolbar.getTitle();
    }

    @NotNull
    public final Toolbar getToolbar() {
        return this.toolbar;
    }

    public final void h(boolean isInMultiWindowMode, boolean fullScreen) {
        int iX2;
        if (isInMultiWindowMode || !fullScreen) {
            iX2 = 0;
        } else {
            Context context = getContext();
            j.d(context, c.R);
            iX2 = f.X2(context);
        }
        setPadding(getPaddingLeft(), iX2, getPaddingRight(), getPaddingBottom());
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        AppCompatActivity appCompatActivityO1;
        super.onAttachedToWindow();
        if (!this.attachToActivity || (appCompatActivityO1 = f.O1(this)) == null) {
            return;
        }
        appCompatActivityO1.setSupportActionBar(getToolbar());
        ActionBar supportActionBar = appCompatActivityO1.getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.setDisplayHomeAsUpEnabled(this.displayHomeAsUp);
    }

    public final void setNavigationOnClickListener(@NotNull final l<? super View, v> clickListener) {
        j.e(clickListener, "clickListener");
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l lVar = clickListener;
                int i2 = TitleBar.r;
                j.e(lVar, "$tmp0");
                lVar.invoke(view);
            }
        });
    }

    public final void setSubTitle(int subtitleId) {
        this.toolbar.setSubtitle(subtitleId);
    }

    public final void setSubTitleTextAppearance(@StyleRes int resId) {
        this.toolbar.setSubtitleTextAppearance(getContext(), resId);
    }

    public final void setSubTitleTextColor(@ColorInt int color) {
        this.toolbar.setSubtitleTextColor(color);
    }

    public final void setSubtitle(@Nullable CharSequence charSequence) {
        this.toolbar.setSubtitle(charSequence);
    }

    public final void setTitle(@Nullable CharSequence charSequence) {
        this.toolbar.setTitle(charSequence);
    }

    public final void setTitleTextAppearance(@StyleRes int resId) {
        this.toolbar.setTitleTextAppearance(getContext(), resId);
    }

    public final void setTitleTextColor(@ColorInt int color) {
        this.toolbar.setTitleTextColor(color);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TitleBar, R.attr.titleBarStyle, 0);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(\n            attrs, R.styleable.TitleBar,\n            R.attr.titleBarStyle, 0\n        )");
        typedArrayObtainStyledAttributes.getColorStateList(13);
        typedArrayObtainStyledAttributes.getInt(14, 9);
        this.attachToActivity = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.displayHomeAsUp = typedArrayObtainStyledAttributes.getBoolean(8, true);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(12);
        CharSequence text = typedArrayObtainStyledAttributes.getText(11);
        String string = typedArrayObtainStyledAttributes.getString(19);
        String string2 = typedArrayObtainStyledAttributes.getString(15);
        if (typedArrayObtainStyledAttributes.getInt(18, 0) == 1) {
            LinearLayout.inflate(context, R.layout.view_title_bar_dark, this);
        } else {
            LinearLayout.inflate(context, R.layout.view_title_bar, this);
        }
        View viewFindViewById = findViewById(R.id.toolbar);
        j.d(viewFindViewById, "findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) viewFindViewById;
        this.toolbar = toolbar;
        if (drawable != null) {
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(text);
        }
        if (typedArrayObtainStyledAttributes.hasValue(20)) {
            toolbar.setTitleTextAppearance(context, typedArrayObtainStyledAttributes.getResourceId(20, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            toolbar.setTitleTextColor(typedArrayObtainStyledAttributes.getColor(21, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(16)) {
            toolbar.setSubtitleTextAppearance(context, typedArrayObtainStyledAttributes.getResourceId(16, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(17)) {
            toolbar.setSubtitleTextColor(typedArrayObtainStyledAttributes.getColor(17, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(3) || typedArrayObtainStyledAttributes.hasValue(4)) {
            toolbar.setContentInsetsAbsolute(typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(5) || typedArrayObtainStyledAttributes.hasValue(1)) {
            toolbar.setContentInsetsRelative(typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            toolbar.setContentInsetStartWithNavigation(typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            toolbar.setContentInsetEndWithActions(typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0));
        }
        if (!(string == null || k.s(string))) {
            toolbar.setTitle(string);
        }
        if (!(string2 == null || k.s(string2))) {
            toolbar.setSubtitle(string2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            LinearLayout.inflate(context, typedArrayObtainStyledAttributes.getResourceId(7, 0), toolbar);
        }
        if (!isInEditMode()) {
            if (typedArrayObtainStyledAttributes.getBoolean(10, true)) {
                setPadding(getPaddingLeft(), f.X2(context), getPaddingRight(), getPaddingBottom());
            }
            if (typedArrayObtainStyledAttributes.getBoolean(9, false)) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int paddingRight = getPaddingRight();
                j.e(context, "<this>");
                setPadding(paddingLeft, paddingTop, paddingRight, context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")));
            }
            setBackgroundColor(f.P2(context));
            setStateListAnimator(null);
            setElevation(e.a.c() < 0 ? f.q2(context) : r0.c());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void setTitle(int titleId) {
        this.toolbar.setTitle(titleId);
    }
}
