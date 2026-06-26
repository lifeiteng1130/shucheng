package io.legado.app.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import e.a.a.d.u.b;
import e.a.a.g.l.i;
import e.a.a.g.l.k;
import e.a.a.g.l.l;
import e.a.a.g.l.m;
import e.a.a.h.u;
import f.c0.c.j;
import io.legado.app.base.BaseActivity;
import io.legado.app.data.entities.AppUpgrade;
import io.legado.app.databinding.ActivityWelcomeBinding;
import io.legado.app.model.AdsConfig;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.main.MainActivity;
import io.legado.app.ui.welcome.WelcomeActivity;
import io.legado.app.ui.widget.dialog.TipsDialog;
import io.legado.app.ui.widget.text.AccentTextView;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WelcomeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0019\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/legado/app/ui/welcome/WelcomeActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityWelcomeBinding;", "Le/a/a/g/l/i;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "", "code", "", "message", "K", "(ILjava/lang/String;)V", "Lio/legado/app/data/entities/AppUpgrade;", "appUpgrade", "p", "(Lio/legado/app/data/entities/AppUpgrade;)V", "success", "()V", "U0", "h", "Ljava/lang/String;", "TAG", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public class WelcomeActivity extends BaseActivity<ActivityWelcomeBinding> implements i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7572g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String TAG;

    /* JADX INFO: compiled from: WelcomeActivity.kt */
    public static final class a implements TipsDialog.b {
        public a() {
        }

        @Override // io.legado.app.ui.widget.dialog.TipsDialog.b
        public void a() {
            ConstraintLayout constraintLayout = WelcomeActivity.T0(WelcomeActivity.this).a;
            final WelcomeActivity welcomeActivity = WelcomeActivity.this;
            constraintLayout.postDelayed(new Runnable() { // from class: e.a.a.g.l.c
                @Override // java.lang.Runnable
                public final void run() {
                    WelcomeActivity welcomeActivity2 = welcomeActivity;
                    f.c0.c.j.e(welcomeActivity2, "this$0");
                    welcomeActivity2.finish();
                }
            }, 500L);
        }

        @Override // io.legado.app.ui.widget.dialog.TipsDialog.b
        public void b() {
            ConstraintLayout constraintLayout = WelcomeActivity.T0(WelcomeActivity.this).a;
            final WelcomeActivity welcomeActivity = WelcomeActivity.this;
            constraintLayout.postDelayed(new Runnable() { // from class: e.a.a.g.l.d
                @Override // java.lang.Runnable
                public final void run() {
                    WelcomeActivity welcomeActivity2 = welcomeActivity;
                    f.c0.c.j.e(welcomeActivity2, "this$0");
                    welcomeActivity2.finish();
                }
            }, 500L);
        }
    }

    /* JADX INFO: compiled from: WelcomeActivity.kt */
    public static final class b implements TipsDialog.b {
        public final /* synthetic */ AppUpgrade a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WelcomeActivity f7574b;

        public b(AppUpgrade appUpgrade, WelcomeActivity welcomeActivity) {
            this.a = appUpgrade;
            this.f7574b = welcomeActivity;
        }

        @Override // io.legado.app.ui.widget.dialog.TipsDialog.b
        public void a() {
            if (this.a.getUpgradeUrl() == null) {
                ConstraintLayout constraintLayout = WelcomeActivity.T0(this.f7574b).a;
                final WelcomeActivity welcomeActivity = this.f7574b;
                constraintLayout.postDelayed(new Runnable() { // from class: e.a.a.g.l.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        WelcomeActivity welcomeActivity2 = welcomeActivity;
                        f.c0.c.j.e(welcomeActivity2, "this$0");
                        int i2 = WelcomeActivity.f7572g;
                        welcomeActivity2.U0();
                    }
                }, 0L);
            } else {
                String upgradeUrl = this.a.getUpgradeUrl();
                j.c(upgradeUrl);
                f.i4(this.f7574b, upgradeUrl);
                ConstraintLayout constraintLayout2 = WelcomeActivity.T0(this.f7574b).a;
                final WelcomeActivity welcomeActivity2 = this.f7574b;
                constraintLayout2.postDelayed(new Runnable() { // from class: e.a.a.g.l.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        WelcomeActivity welcomeActivity3 = welcomeActivity2;
                        f.c0.c.j.e(welcomeActivity3, "this$0");
                        welcomeActivity3.finish();
                    }
                }, 0L);
            }
        }

        @Override // io.legado.app.ui.widget.dialog.TipsDialog.b
        public void b() {
        }
    }

    /* JADX INFO: compiled from: WelcomeActivity.kt */
    public static final class c implements TipsDialog.b {
        public final /* synthetic */ AppUpgrade a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WelcomeActivity f7575b;

        public c(AppUpgrade appUpgrade, WelcomeActivity welcomeActivity) {
            this.a = appUpgrade;
            this.f7575b = welcomeActivity;
        }

        @Override // io.legado.app.ui.widget.dialog.TipsDialog.b
        public void a() {
            if (this.a.getUpgradeUrl() == null) {
                u uVar = u.a;
                u.b(this.f7575b.TAG, "下载路径不存在");
                f.S3(this.f7575b, "下载路径不存在，请联系管理员");
            } else {
                String upgradeUrl = this.a.getUpgradeUrl();
                j.c(upgradeUrl);
                f.i4(this.f7575b, upgradeUrl);
            }
            ConstraintLayout constraintLayout = WelcomeActivity.T0(this.f7575b).a;
            final WelcomeActivity welcomeActivity = this.f7575b;
            constraintLayout.postDelayed(new Runnable() { // from class: e.a.a.g.l.h
                @Override // java.lang.Runnable
                public final void run() {
                    WelcomeActivity welcomeActivity2 = welcomeActivity;
                    f.c0.c.j.e(welcomeActivity2, "this$0");
                    welcomeActivity2.finish();
                }
            }, 0L);
        }

        @Override // io.legado.app.ui.widget.dialog.TipsDialog.b
        public void b() {
            ConstraintLayout constraintLayout = WelcomeActivity.T0(this.f7575b).a;
            final WelcomeActivity welcomeActivity = this.f7575b;
            constraintLayout.postDelayed(new Runnable() { // from class: e.a.a.g.l.g
                @Override // java.lang.Runnable
                public final void run() {
                    WelcomeActivity welcomeActivity2 = welcomeActivity;
                    f.c0.c.j.e(welcomeActivity2, "this$0");
                    int i2 = WelcomeActivity.f7572g;
                    welcomeActivity2.U0();
                }
            }, 0L);
        }
    }

    public WelcomeActivity() {
        super(false, null, null, false, false, 31);
        this.TAG = "WelcomeActivity";
    }

    public static final /* synthetic */ ActivityWelcomeBinding T0(WelcomeActivity welcomeActivity) {
        return welcomeActivity.K0();
    }

    @Override // e.a.a.g.l.i
    public void K(int code, @NotNull String message) {
        j.e(message, "message");
        TipsDialog.Companion aVar = TipsDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        aVar.a(supportFragmentManager, null, message, "确定", "取消", new a(), false);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_welcome, (ViewGroup) null, false);
        int i2 = R.id.iv_book;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_book);
        if (imageView != null) {
            i2 = R.id.tv_gzh;
            AccentTextView accentTextView = (AccentTextView) viewInflate.findViewById(R.id.tv_gzh);
            if (accentTextView != null) {
                i2 = R.id.tv_sub_title;
                AccentTextView accentTextView2 = (AccentTextView) viewInflate.findViewById(R.id.tv_sub_title);
                if (accentTextView2 != null) {
                    i2 = R.id.tv_title;
                    AccentTextView accentTextView3 = (AccentTextView) viewInflate.findViewById(R.id.tv_title);
                    if (accentTextView3 != null) {
                        i2 = R.id.vw_title_line;
                        View viewFindViewById = viewInflate.findViewById(R.id.vw_title_line);
                        if (viewFindViewById != null) {
                            ActivityWelcomeBinding activityWelcomeBinding = new ActivityWelcomeBinding((ConstraintLayout) viewInflate, imageView, accentTextView, accentTextView2, accentTextView3, viewFindViewById);
                            j.d(activityWelcomeBinding, "inflate(layoutInflater)");
                            return activityWelcomeBinding;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        K0().f6570b.setColorFilter(f.M1(this));
        K0().f6571c.setBackgroundColor(f.M1(this));
        if ((getIntent().getFlags() & 4194304) == 0) {
            b.C0148b c0148b = e.a.a.d.u.b.a;
            b.C0148b.b(c0148b, null, null, new k(this, null), 3);
            b.C0148b.b(c0148b, null, null, new l(null), 3);
            b.C0148b.b(c0148b, null, null, new m(this, null), 3);
            return;
        }
        AdsConfig adsConfigC = e.a.a.d.w.c.c(this);
        if (!adsConfigC.getEnableAds() || !e.a.a.d.w.c.b(adsConfigC) || !adsConfigC.getEnableSplash()) {
            finish();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SplashActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
        finish();
    }

    public final void U0() {
        AdsConfig adsConfigC = e.a.a.d.w.c.c(this);
        if (adsConfigC.getEnableAds() && e.a.a.d.w.c.b(adsConfigC) && adsConfigC.getEnableSplash()) {
            Intent intent = new Intent(this, (Class<?>) SplashActivity.class);
            intent.addFlags(268435456);
            startActivity(intent);
            finish();
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
        intent2.addFlags(268435456);
        startActivity(intent2);
        if (f.K2(this, "defaultToRead", false, 2)) {
            Intent intent3 = new Intent(this, (Class<?>) ReadBookActivity.class);
            intent3.addFlags(268435456);
            startActivity(intent3);
        }
        finish();
    }

    @Override // e.a.a.g.l.i
    public void p(@NotNull AppUpgrade appUpgrade) {
        j.e(appUpgrade, "appUpgrade");
        if (appUpgrade.getForceUpgrade()) {
            TipsDialog.Companion aVar = TipsDialog.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            j.d(supportFragmentManager, "supportFragmentManager");
            aVar.a(supportFragmentManager, appUpgrade.getUpgradeTitle(), appUpgrade.getUpgradeContent(), "立即升级", "稍后升级", new b(appUpgrade, this), false);
            return;
        }
        TipsDialog.Companion aVar2 = TipsDialog.INSTANCE;
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        j.d(supportFragmentManager2, "supportFragmentManager");
        aVar2.a(supportFragmentManager2, appUpgrade.getUpgradeTitle(), appUpgrade.getUpgradeContent(), "立即升级", "稍后升级", new c(appUpgrade, this), true);
    }

    @Override // e.a.a.g.l.i
    public void success() {
        K0().a.postDelayed(new Runnable() { // from class: e.a.a.g.l.b
            @Override // java.lang.Runnable
            public final void run() {
                WelcomeActivity welcomeActivity = this.a;
                int i2 = WelcomeActivity.f7572g;
                f.c0.c.j.e(welcomeActivity, "this$0");
                welcomeActivity.U0();
            }
        }, 0L);
    }
}
