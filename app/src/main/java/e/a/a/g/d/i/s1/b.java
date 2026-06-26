package e.a.a.g.d.i.s1;

import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import c.b.a.m.f;
import com.ifmvo.togetherad.core.listener.NativeExpressListener;
import com.umeng.analytics.MobclickAgent;
import f.c0.c.j;
import io.legado.app.ui.book.read.page.PageView;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: PageView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements NativeExpressListener {
    public final /* synthetic */ PageView a;

    public b(PageView pageView) {
        this.a = pageView;
    }

    @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
    public void onAdClicked(@NotNull String str, @Nullable Object obj) {
        j.e(str, "providerType");
        MobclickAgent.onEvent(this.a.getContext(), "readExpressClick");
        LinearLayout linearLayout = this.a.binding.f6866b;
        j.d(linearLayout, "binding.adContainer");
        f.e3(linearLayout);
        NativeExpressListener.DefaultImpls.onAdClicked(this, str, obj);
    }

    @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
    public void onAdClosed(@NotNull String str, @Nullable Object obj) {
        j.e(str, "providerType");
        LinearLayout linearLayout = this.a.binding.f6866b;
        j.d(linearLayout, "binding.adContainer");
        f.e3(linearLayout);
        NativeExpressListener.DefaultImpls.onAdClosed(this, str, obj);
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdFailed(@NotNull String str, @Nullable String str2) {
        j.e(str, "providerType");
        this.a.binding.f6866b.setVisibility(8);
        MobclickAgent.onEvent(this.a.getContext(), "readExpressLoadFaild");
        MobclickAgent.onEvent(this.a.getContext(), "readExpressLoadFaildMsg", str + Attributes.InternalPrefix + ((Object) str2));
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdFailedAll(@Nullable String str) {
        this.a.binding.f6866b.setVisibility(8);
        MobclickAgent.onEvent(this.a.getContext(), "readExpressLoadAllFaild");
        MobclickAgent.onEvent(this.a.getContext(), "readExpressLoadFaildMsg", str);
    }

    @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
    public void onAdLoaded(@NotNull String str, @NotNull List<? extends Object> list) {
        j.e(str, "providerType");
        j.e(list, "adList");
        this.a.setMAdObject(list.get(0));
        PageView pageView = this.a;
        pageView.needRequest = false;
        MobclickAgent.onEvent(pageView.getContext(), "readExpressLoad");
        if (this.a.getMAdObject() == null) {
            LinearLayout linearLayout = this.a.binding.f6866b;
            j.d(linearLayout, "binding.adContainer");
            f.e3(linearLayout);
        } else {
            AppCompatActivity appCompatActivityO1 = f.O1(this.a);
            if (appCompatActivityO1 == null) {
                return;
            }
            this.a.k(appCompatActivityO1, false);
        }
    }

    @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
    public void onAdRenderFail(@NotNull String str, @Nullable Object obj) {
        j.e(str, "providerType");
        LinearLayout linearLayout = this.a.binding.f6866b;
        j.d(linearLayout, "binding.adContainer");
        f.e3(linearLayout);
        MobclickAgent.onEvent(this.a.getContext(), "readExpressRenderFail");
        NativeExpressListener.DefaultImpls.onAdRenderFail(this, str, obj);
    }

    @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
    public void onAdRenderSuccess(@NotNull String str, @Nullable Object obj) {
        j.e(str, "providerType");
        NativeExpressListener.DefaultImpls.onAdRenderSuccess(this, str, obj);
    }

    @Override // com.ifmvo.togetherad.core.listener.NativeExpressListener
    public void onAdShow(@NotNull String str, @Nullable Object obj) {
        j.e(str, "providerType");
        NativeExpressListener.DefaultImpls.onAdShow(this, str, obj);
        PageView pageView = this.a;
        pageView.needRequest = true;
        MobclickAgent.onEvent(pageView.getContext(), "readExpressExposed");
    }

    @Override // com.ifmvo.togetherad.core.listener.BaseListener
    public void onAdStartRequest(@NotNull String str) {
        j.e(str, "providerType");
    }
}
