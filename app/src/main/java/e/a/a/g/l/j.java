package e.a.a.g.l;

import com.ifmvo.togetherad.core.listener.SplashListener;
import com.umeng.analytics.MobclickAgent;
import io.legado.app.ui.welcome.SplashActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: SplashActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements SplashListener {
    public final /* synthetic */ SplashActivity a;

    public j(SplashActivity splashActivity) {
        this.a = splashActivity;
    }

    @Override // com.ifmvo.togetherad.core.listener.SplashListener
    public void onAdClicked(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
        MobclickAgent.onEvent(this.a, "SplashAdsClick");
    }

    @Override // com.ifmvo.togetherad.core.listener.SplashListener
    public void onAdDismissed(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
        SplashActivity splashActivity = this.a;
        int i2 = SplashActivity.f7570g;
        splashActivity.K0().a.postDelayed(new a(splashActivity), 0L);
    }

    @Override // com.ifmvo.togetherad.core.listener.SplashListener
    public void onAdExposure(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
        MobclickAgent.onEvent(this.a, "SplashAdsExposure");
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdFailed(@NotNull String str, @Nullable String str2) {
        f.c0.c.j.e(str, "providerType");
        MobclickAgent.onEvent(this.a, "SplashAdsFailed");
        MobclickAgent.onEvent(this.a, "SplashAdsFailedMsg", str + Attributes.InternalPrefix + ((Object) str2));
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdFailedAll(@Nullable String str) {
        MobclickAgent.onEvent(this.a, "SplashAdsFailedMsg", String.valueOf(str));
        MobclickAgent.onEvent(this.a, "SplashAdsFailedAll");
        SplashActivity splashActivity = this.a;
        int i2 = SplashActivity.f7570g;
        splashActivity.K0().a.postDelayed(new a(splashActivity), 1000L);
    }

    @Override // com.ifmvo.togetherad.core.listener.SplashListener
    public void onAdLoaded(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
        MobclickAgent.onEvent(this.a, "SplashAdsLoad");
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdStartRequest(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
    }
}
