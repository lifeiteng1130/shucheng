package io.legado.app.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.c.e;
import e.a.a.h.m;
import e.a.a.h.t;
import f.c0.c.j;
import f.c0.c.k;
import g.b.a0;
import io.legado.app.App;
import io.legado.app.help.ThemeConfig;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B9\u0012\b\b\u0002\u0010C\u001a\u00020\u001c\u0012\b\b\u0002\u0010K\u001a\u00020H\u0012\b\b\u0002\u0010Q\u001a\u00020H\u0012\b\b\u0002\u0010R\u001a\u00020\u001c\u0012\b\b\u0002\u0010O\u001a\u00020\u001c¢\u0006\u0004\bS\u0010TJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00028\u0000H$¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0014¢\u0006\u0004\b'\u0010\u001aJ\u0019\u0010(\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b(\u0010\u0018J\u0017\u0010+\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b1\u0010,J\u0015\u00104\u001a\u00020\u001c2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u001c2\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b6\u00105J\u000f\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u0010\u001aJ\u000f\u00108\u001a\u00020\u0007H\u0016¢\u0006\u0004\b8\u0010\u001aJ\u000f\u00109\u001a\u00020\u0007H\u0016¢\u0006\u0004\b9\u0010\u001aJ\u000f\u0010:\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010\u001aR\u001d\u0010>\u001a\u00028\u00008D@\u0004X\u0084\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u000bR\u0019\u0010C\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0013\u0010M\u001a\u00020\u001c8F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010BR\u0016\u0010O\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010@R\u0016\u0010Q\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010J¨\u0006U"}, d2 = {"Lio/legado/app/base/BaseActivity;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/appcompat/app/AppCompatActivity;", "Lg/b/a0;", "Landroid/content/Context;", "newBase", "Lf/v;", "attachBaseContext", "(Landroid/content/Context;)V", "L0", "()Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "parent", "", "name", c.R, "Landroid/util/AttributeSet;", "attrs", "onCreateView", "(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "", "hasFocus", "onWindowFocusChanged", "(Z)V", "isInMultiWindowMode", "Landroid/content/res/Configuration;", "newConfig", "onMultiWindowModeChanged", "(ZLandroid/content/res/Configuration;)V", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroy", "O0", "Landroid/view/Menu;", "menu", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "", "featureId", "onMenuOpened", "(ILandroid/view/Menu;)Z", "P0", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Q0", "S0", "N0", "finish", "R0", "f", "Lf/e;", "K0", "binding", ai.at, "Z", "getFullScreen", "()Z", "fullScreen", "Lf/z/f;", "getCoroutineContext", "()Lf/z/f;", "coroutineContext", "Le/a/a/c/e;", "b", "Le/a/a/c/e;", "theme", "M0", "isInMultiWindow", "d", "imageBg", ai.aD, "toolBarTheme", "transparent", "<init>", "(ZLe/a/a/c/e;Le/a/a/c/e;ZZ)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity implements a0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final boolean fullScreen;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e theme;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e toolBarTheme;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean imageBg;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a0 f6428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e binding;

    /* JADX INFO: compiled from: BaseActivity.kt */
    public static final class a extends k implements f.c0.b.a<VB> {
        public final /* synthetic */ BaseActivity<VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseActivity<VB> baseActivity) {
            super(0);
            this.this$0 = baseActivity;
        }

        @Override // f.c0.b.a
        @NotNull
        public final VB invoke() {
            return (VB) this.this$0.L0();
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T>, j$.util.Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator, j$.util.Comparator
        public final int compare(T t, T t2) {
            return f.V0(Float.valueOf(((Display.Mode) t).getRefreshRate()), Float.valueOf(((Display.Mode) t2).getRefreshRate()));
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public BaseActivity() {
        this(false, null, null, false, false, 31);
    }

    public /* synthetic */ BaseActivity(boolean z, e eVar, e eVar2, boolean z2, boolean z3, int i2) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? e.Auto : eVar, (i2 & 4) != 0 ? e.Auto : null, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? true : z3);
    }

    @NotNull
    public final VB K0() {
        return (VB) this.binding.getValue();
    }

    @NotNull
    public abstract VB L0();

    public final boolean M0() {
        if (Build.VERSION.SDK_INT >= 24) {
            return isInMultiWindowMode();
        }
        return false;
    }

    public void N0() {
    }

    public abstract void O0(@Nullable Bundle savedInstanceState);

    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        return super.onOptionsItemSelected(item);
    }

    public final void R0() {
        if (this.fullScreen && !M0()) {
            ATH ath = ATH.a;
            j.e(this, "activity");
            if (Build.VERSION.SDK_INT >= 30) {
                getWindow().setDecorFitsSystemWindows(true);
            }
            getWindow().getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
            getWindow().clearFlags(201326592);
            getWindow().addFlags(Integer.MIN_VALUE);
        }
        ATH ath2 = ATH.a;
        boolean z = this.fullScreen;
        j.e(this, "activity");
        e.a.a.d.e eVar = e.a.a.d.e.a;
        boolean zJ2 = f.J2(h.g(), "transparentStatusBar", true);
        int iF = e.a.a.e.d.b.a.f(this, zJ2);
        j.e(this, "activity");
        if (!z) {
            getWindow().setStatusBarColor(iF);
        } else if (zJ2) {
            getWindow().setStatusBarColor(0);
        } else {
            getWindow().setStatusBarColor(f.c2(this, R.color.status_bar_bag));
        }
        ath2.f(this, iF);
        e eVar2 = this.toolBarTheme;
        if (eVar2 == e.Dark) {
            ath2.e(this, false);
        } else if (eVar2 == e.Light) {
            ath2.e(this, true);
        }
        S0();
    }

    public void S0() {
        e.a.a.d.e eVar = e.a.a.d.e.a;
        if (f.J2(h.g(), "immNavigationBar", true)) {
            ATH.a.g(this, e.a.a.e.d.b.a.c(this));
            return;
        }
        int iC = e.a.a.e.d.b.a.c(this);
        int iAlpha = Color.alpha(iC);
        float[] fArr = new float[3];
        Color.colorToHSV(iC, fArr);
        fArr[2] = fArr[2] * 0.9f;
        ATH.a.g(this, (iAlpha << 24) + (16777215 & Color.HSVToColor(fArr)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(@NotNull Context newBase) {
        j.e(newBase, "newBase");
        super.attachBaseContext(t.b(newBase));
    }

    @Override // android.app.Activity
    public void finish() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            f.h3(currentFocus);
        }
        super.finish();
    }

    @Override // g.b.a0
    @NotNull
    public f.z.f getCoroutineContext() {
        return this.f6428e.getCoroutineContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        j.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        if (titleBar != null) {
            titleBar.h(M0(), this.fullScreen);
        }
        R0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TitleBar titleBar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && f.K2(this, "highBrush", false, 2)) {
            Display.Mode[] supportedModes = getWindow().getWindowManager().getDefaultDisplay().getSupportedModes();
            j.d(supportedModes, "modes");
            if (supportedModes.length > 1) {
                f.x.e.A(supportedModes, new b());
            }
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            j.e(supportedModes, "$this$last");
            if (supportedModes.length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            attributes.preferredDisplayModeId = supportedModes[f.z2(supportedModes)].getModeId();
            window.setAttributes(attributes);
        }
        View decorView = getWindow().getDecorView();
        j.d(decorView, "window.decorView");
        j.e(decorView, "<this>");
        if (i2 >= 26) {
            decorView.setImportantForAutofill(8);
        }
        int iOrdinal = this.theme.ordinal();
        if (iOrdinal == 0) {
            setTheme(2131886094);
            ATH.a.a(getWindow().getDecorView());
        } else if (iOrdinal == 1) {
            setTheme(2131886095);
            ATH.a.a(getWindow().getDecorView());
        } else if (iOrdinal != 3) {
            int iP2 = f.P2(this);
            if (((double) 1) - (((((double) Color.blue(iP2)) * 0.114d) + ((((double) Color.green(iP2)) * 0.587d) + (((double) Color.red(iP2)) * 0.299d))) / ((double) 255)) < 0.4d) {
                setTheme(2131886095);
            } else {
                setTheme(2131886094);
            }
            ATH.a.a(getWindow().getDecorView());
        } else {
            setTheme(2131886097);
        }
        if (this.imageBg) {
            ThemeConfig themeConfig = ThemeConfig.a;
            j.e(this, c.R);
            Objects.requireNonNull(e.Companion);
            int iOrdinal2 = (e.a.a.d.e.f5519d ? e.EInk : e.a.a.d.e.a.m() ? e.Dark : e.Light).ordinal();
            String strO2 = iOrdinal2 != 0 ? iOrdinal2 != 1 ? null : f.O2(this, "backgroundImage", null, 2) : f.O2(this, "backgroundImageNight", null, 2);
            Drawable drawableCreateFromPath = strO2 == null || f.h0.k.s(strO2) ? null : BitmapDrawable.createFromPath(strO2);
            if (drawableCreateFromPath != null) {
                try {
                    getWindow().getDecorView().setBackground(drawableCreateFromPath);
                } catch (OutOfMemoryError unused) {
                    f.R5(this, "Image Bg Out Of Memory");
                }
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(K0().getRoot());
        R0();
        if (Build.VERSION.SDK_INT >= 24 && (titleBar = (TitleBar) findViewById(R.id.title_bar)) != null) {
            titleBar.h(isInMultiWindowMode(), this.fullScreen);
        }
        O0(savedInstanceState);
        N0();
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(@Nullable Menu menu) {
        Boolean boolValueOf;
        if (menu == null) {
            boolValueOf = null;
        } else {
            boolean zP0 = P0(menu);
            m.a(menu, this, this.toolBarTheme);
            boolValueOf = Boolean.valueOf(zP0);
        }
        return boolValueOf == null ? super.onCreateOptionsMenu(menu) : boolValueOf.booleanValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View parent, @NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
        j.e(name, "name");
        j.e(context, c.R);
        j.e(attrs, "attrs");
        e.a.a.c.c cVar = e.a.a.c.c.a;
        if (f.b1(e.a.a.c.c.f5502h, name)) {
            if ((parent == null ? null : parent.getParent()) instanceof FrameLayout) {
                Object parent2 = parent.getParent();
                Objects.requireNonNull(parent2, "null cannot be cast to non-null type android.view.View");
                ((View) parent2).setBackgroundColor(f.R1(this));
            }
        }
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f.I0(this, null, 1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int featureId, @NotNull Menu menu) {
        j.e(menu, "menu");
        j.e(menu, "<this>");
        j.e(this, c.R);
        if (f.h0.k.i(menu.getClass().getSimpleName(), "MenuBuilder", true)) {
            int iC2 = f.c2(this, R.color.primaryText);
            try {
                Method declaredMethod = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                j.d(declaredMethod, "this.javaClass.getDeclaredMethod(\"setOptionalIconsVisible\", java.lang.Boolean.TYPE)");
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(menu, Boolean.TRUE);
                Method declaredMethod2 = menu.getClass().getDeclaredMethod("getNonActionItems", new Class[0]);
                j.d(declaredMethod2, "this.javaClass.getDeclaredMethod(\"getNonActionItems\")");
                Object objInvoke = declaredMethod2.invoke(menu, new Object[0]);
                if (objInvoke instanceof ArrayList) {
                    for (Object obj : (ArrayList) objInvoke) {
                        if (obj instanceof MenuItem) {
                            Drawable icon = ((MenuItem) obj).getIcon();
                            PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
                            j.e(mode, "tintMode");
                            if (icon != null) {
                                Drawable drawableWrap = DrawableCompat.wrap(icon);
                                drawableWrap.mutate();
                                DrawableCompat.setTintMode(drawableWrap, mode);
                                DrawableCompat.setTint(drawableWrap, iC2);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, @Nullable Configuration newConfig) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        if (titleBar != null) {
            titleBar.h(isInMultiWindowMode, this.fullScreen);
        }
        R0();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() != 16908332) {
            return Q0(item);
        }
        supportFinishAfterTransition();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        // AD REMOVED: MobclickAgent.onPageEnd(getClass().getName());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        // AD REMOVED: MobclickAgent.onPageStart(getClass().getName());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            App.a = f.D2(this);
        }
    }

    public BaseActivity(boolean z, @NotNull e eVar, @NotNull e eVar2, boolean z2, boolean z3) {
        j.e(eVar, "theme");
        j.e(eVar2, "toolBarTheme");
        this.fullScreen = z;
        this.theme = eVar;
        this.toolBarTheme = eVar2;
        this.imageBg = z3;
        this.f6428e = f.a();
        this.binding = f.N3(new a(this));
    }
}
