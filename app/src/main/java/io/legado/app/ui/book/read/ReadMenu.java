package io.legado.app.ui.book.read;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.KeyEventDispatcher;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.v;
import io.legado.app.databinding.ViewReadMenuBinding;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ReadMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001@B\u001d\b\u0007\u0012\u0006\u0010;\u001a\u00020:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00042\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0006J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010$R\u0016\u0010&\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010 R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u0019R\u0013\u0010-\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\tR\u0016\u0010/\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010 R\u0016\u00101\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u0010 R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00103R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010$R\u0016\u00109\u001a\u0002068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006A"}, d2 = {"Lio/legado/app/ui/book/read/ReadMenu;", "Landroid/widget/FrameLayout;", "", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "setScreenBrightness", "(I)V", "", ai.aD, "()Z", ai.aA, "()V", "g", "Lkotlin/Function0;", "onMenuOutEnd", "h", "(Lf/c0/b/a;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "seek", "setSeekPage", "autoPage", "setAutoPage", "(Z)V", "Landroid/content/res/ColorStateList;", "j", "Landroid/content/res/ColorStateList;", "bottomBackgroundList", "Landroid/view/animation/Animation;", "d", "Landroid/view/animation/Animation;", "menuTopIn", "k", "Lf/c0/b/a;", OptRuntime.GeneratorState.resumptionPoint_TYPE, "textColor", "menuBottomOut", "b", "Z", "getCnaShowMenu", "setCnaShowMenu", "cnaShowMenu", "getShowBrightnessView", "showBrightnessView", "e", "menuTopOut", "f", "menuBottomIn", "Lio/legado/app/databinding/ViewReadMenuBinding;", "Lio/legado/app/databinding/ViewReadMenuBinding;", "binding", "bgColor", "Lio/legado/app/ui/book/read/ReadMenu$a;", "getCallBack", "()Lio/legado/app/ui/book/read/ReadMenu$a;", "callBack", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadMenu extends FrameLayout {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean cnaShowMenu;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewReadMenuBinding binding;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Animation menuTopIn;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Animation menuTopOut;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Animation menuBottomIn;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public Animation menuBottomOut;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int bgColor;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final int textColor;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ColorStateList bottomBackgroundList;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public f.c0.b.a<v> onMenuOutEnd;

    /* JADX INFO: compiled from: ReadMenu.kt */
    public interface a {
        void J();

        void N();

        void S();

        void W();

        void c();

        void f();

        void h0();

        void k0(@Nullable String str);

        void l0();

        void refresh();

        void v();

        void x();

        void y();

        void z0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadMenu(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public static void d(ReadMenu readMenu, View view) {
        j.e(readMenu, "this$0");
        readMenu.getCallBack().h0();
    }

    public static void e(ReadMenu readMenu, View view) {
        j.e(readMenu, "this$0");
        readMenu.getCallBack().W();
    }

    public static void f(ReadMenu readMenu, View view) {
        j.e(readMenu, "this$0");
        readMenu.getCallBack().y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a getCallBack() {
        KeyEventDispatcher.Component componentO1 = f.O1(this);
        Objects.requireNonNull(componentO1, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadMenu.CallBack");
        return (a) componentO1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setScreenBrightness(int value) {
        float f2;
        Window window;
        if (c()) {
            f2 = -1.0f;
        } else {
            float f3 = value;
            if (f3 < 1.0f) {
                f3 = 1.0f;
            }
            f2 = f3 / 255.0f;
        }
        AppCompatActivity appCompatActivityO1 = f.O1(this);
        WindowManager.LayoutParams attributes = (appCompatActivityO1 == null || (window = appCompatActivityO1.getWindow()) == null) ? null : window.getAttributes();
        if (attributes != null) {
            attributes.screenBrightness = f2;
        }
        AppCompatActivity appCompatActivityO12 = f.O1(this);
        Window window2 = appCompatActivityO12 != null ? appCompatActivityO12.getWindow() : null;
        if (window2 == null) {
            return;
        }
        window2.setAttributes(attributes);
    }

    public final boolean c() {
        Context context = getContext();
        j.d(context, c.R);
        return f.J2(context, "brightnessAuto", true) || !getShowBrightnessView();
    }

    public final void g() {
        f.c6(this);
        TitleBar titleBar = this.binding.B;
        j.d(titleBar, "binding.titleBar");
        f.c6(titleBar);
        LinearLayout linearLayout = this.binding.f6884b;
        j.d(linearLayout, "binding.bottomMenu");
        f.c6(linearLayout);
        TitleBar titleBar2 = this.binding.B;
        Animation animation = this.menuTopIn;
        if (animation == null) {
            j.m("menuTopIn");
            throw null;
        }
        titleBar2.startAnimation(animation);
        LinearLayout linearLayout2 = this.binding.f6884b;
        Animation animation2 = this.menuBottomIn;
        if (animation2 != null) {
            linearLayout2.startAnimation(animation2);
        } else {
            j.m("menuBottomIn");
            throw null;
        }
    }

    public final boolean getCnaShowMenu() {
        return this.cnaShowMenu;
    }

    public final boolean getShowBrightnessView() {
        Context context = getContext();
        j.d(context, c.R);
        return f.J2(context, "showBrightnessView", true);
    }

    public final void h(@Nullable f.c0.b.a<v> onMenuOutEnd) {
        this.onMenuOutEnd = onMenuOutEnd;
        if (getVisibility() == 0) {
            TitleBar titleBar = this.binding.B;
            Animation animation = this.menuTopOut;
            if (animation == null) {
                j.m("menuTopOut");
                throw null;
            }
            titleBar.startAnimation(animation);
            LinearLayout linearLayout = this.binding.f6884b;
            Animation animation2 = this.menuBottomOut;
            if (animation2 != null) {
                linearLayout.startAnimation(animation2);
            } else {
                j.m("menuBottomOut");
                throw null;
            }
        }
    }

    public final void i() {
        if (c()) {
            ImageView imageView = this.binding.f6890h;
            Context context = getContext();
            j.d(context, c.R);
            imageView.setColorFilter(f.M1(context));
            this.binding.z.setEnabled(false);
        } else {
            ImageView imageView2 = this.binding.f6890h;
            Context context2 = getContext();
            j.d(context2, c.R);
            j.e(context2, "<this>");
            imageView2.setColorFilter(f.u3(context2) ? ContextCompat.getColor(context2, R.color.md_dark_disabled) : ContextCompat.getColor(context2, R.color.md_light_disabled));
            this.binding.z.setEnabled(true);
        }
        Context context3 = getContext();
        j.d(context3, c.R);
        setScreenBrightness(f.L2(context3, "brightness", 100));
    }

    public final void setAutoPage(boolean autoPage) {
        ViewReadMenuBinding viewReadMenuBinding = this.binding;
        if (autoPage) {
            viewReadMenuBinding.f6885c.setImageResource(R.drawable.ic_auto_page_stop);
            viewReadMenuBinding.f6885c.setContentDescription(getContext().getString(R.string.auto_next_page_stop));
        } else {
            viewReadMenuBinding.f6885c.setImageResource(R.drawable.ic_auto_page);
            viewReadMenuBinding.f6885c.setContentDescription(getContext().getString(R.string.auto_next_page));
        }
        viewReadMenuBinding.f6885c.setColorFilter(this.textColor);
    }

    public final void setCnaShowMenu(boolean z) {
        this.cnaShowMenu = z;
    }

    public final void setSeekPage(int seek) {
        this.binding.A.setProgress(seek);
    }

    public final void setTitle(@NotNull String title) {
        j.e(title, "title");
        this.binding.B.setTitle(title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0601 A[PHI: r4
  0x0601: PHI (r4v2 int) = 
  (r4v1 int)
  (r4v3 int)
  (r4v4 int)
  (r4v5 int)
  (r4v6 int)
  (r4v7 int)
  (r4v8 int)
  (r4v9 int)
  (r4v10 int)
  (r4v11 int)
  (r4v12 int)
  (r4v13 int)
 binds: [B:3:0x0025, B:5:0x0031, B:7:0x003c, B:9:0x0048, B:11:0x0054, B:13:0x0060, B:15:0x006d, B:17:0x0079, B:19:0x0085, B:21:0x0091, B:23:0x009d, B:25:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    @kotlin.jvm.JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ReadMenu(@org.jetbrains.annotations.NotNull android.content.Context r82, @org.jetbrains.annotations.Nullable android.util.AttributeSet r83) {
        /*
            Method dump skipped, instruction units count: 1558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.ReadMenu.<init>(android.content.Context, android.util.AttributeSet):void");
    }
}
