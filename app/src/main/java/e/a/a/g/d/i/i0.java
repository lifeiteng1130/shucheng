package e.a.a.g.d.i;

import com.ifmvo.togetherad.core.helper.AdHelperInter;
import com.ifmvo.togetherad.core.listener.InterListener;
import com.umeng.analytics.MobclickAgent;
import io.legado.app.ui.book.read.ReadBookActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: ReadBookActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements InterListener {
    public final /* synthetic */ ReadBookActivity a;

    public i0(ReadBookActivity readBookActivity) {
        this.a = readBookActivity;
    }

    @Override // com.ifmvo.togetherad.core.listener.InterListener
    public void onAdClicked(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
        MobclickAgent.onEvent(this.a, "cacheAdsClick");
    }

    @Override // com.ifmvo.togetherad.core.listener.InterListener
    public void onAdClose(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
    }

    @Override // com.ifmvo.togetherad.core.listener.InterListener
    public void onAdExpose(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
        MobclickAgent.onEvent(this.a, "cacheAdsExpose");
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdFailed(@NotNull String str, @Nullable String str2) {
        f.c0.c.j.e(str, "providerType");
        MobclickAgent.onEvent(this.a, "cacheAdsFaild");
        MobclickAgent.onEvent(this.a, "cacheAdsFaildMsg", str + Attributes.InternalPrefix + ((Object) str2));
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdFailedAll(@Nullable String str) {
        MobclickAgent.onEvent(this.a, "cacheAdsFaildAll");
        MobclickAgent.onEvent(this.a, "cacheAdsFaildMsg", String.valueOf(str));
    }

    @Override // com.ifmvo.togetherad.core.listener.InterListener
    public void onAdLoaded(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
        AdHelperInter adHelperInter = this.a.adHelperInter;
        if (adHelperInter == null) {
            return;
        }
        adHelperInter.show();
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdStartRequest(@NotNull String str) {
        f.c0.c.j.e(str, "providerType");
    }
}
