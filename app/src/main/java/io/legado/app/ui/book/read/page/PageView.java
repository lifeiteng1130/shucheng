package io.legado.app.ui.book.read.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.ifmvo.togetherad.core.helper.AdHelperBanner;
import com.ifmvo.togetherad.core.helper.AdHelperNativeExpress;
import com.ifmvo.togetherad.core.listener.BannerListener;
import com.ifmvo.togetherad.core.utils.ScreenUtil;
import com.ifmvo.togetherad.core.utils.SizeExtKt;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import com.ifmvo.togetherad.gdt.provider.GdtProvider;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.ai;
import e.a.a.d.r;
import e.a.a.d.w.c;
import e.a.a.g.d.i.h0;
import e.a.a.g.d.i.s1.g.d;
import e.a.a.h.n;
import f.c0.b.l;
import f.c0.b.q;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.h;
import f.v;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.ViewBookPageBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.model.AdsConfig;
import io.legado.app.ui.widget.BatteryView;
import io.legado.app.ui.widget.dialog.PhotoDialog;
import io.wenyuange.app.release.R;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: PageView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u0015\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b \u0010!Jj\u0010,\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2K\u0010+\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00020%¢\u0006\u0004\b,\u0010-J%\u0010.\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011¢\u0006\u0004\b.\u0010/J%\u00100\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011¢\u0006\u0004\b0\u0010/J\r\u00101\u001a\u00020\u0002¢\u0006\u0004\b1\u0010\u0004J\r\u00102\u001a\u00020\u0002¢\u0006\u0004\b2\u0010\u0004J\u0019\u00105\u001a\u0004\u0018\u0001042\u0006\u00103\u001a\u00020\u0011H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0002H\u0003¢\u0006\u0004\b7\u0010\u0004R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00108R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010;R\u0018\u0010=\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00108R\u0018\u0010>\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u00108R$\u0010E\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00108R\u001f\u0010K\u001a\u0004\u0018\u00010G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010H\u001a\u0004\bI\u0010JR\u0013\u0010\u0016\u001a\u00020\u00158F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010MR$\u0010P\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010@\u001a\u0004\bN\u0010B\"\u0004\bO\u0010DR\u0018\u0010Q\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00108R\u0016\u0010S\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010RR\u0018\u0010T\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00108R\u0018\u0010U\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u00108R\u0013\u0010X\u001a\u00020\u001b8F@\u0006¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0013\u0010[\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010RR\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010^¨\u0006d"}, d2 = {"Lio/legado/app/ui/book/read/page/PageView;", "Landroid/widget/FrameLayout;", "Lf/v;", "n", "()V", "Landroid/app/Activity;", "activity", "", "bannerShow", "k", "(Landroid/app/Activity;Z)V", "m", "Landroid/graphics/drawable/Drawable;", "bg", "setBg", "(Landroid/graphics/drawable/Drawable;)V", "o", "", ai.Z, Constants.LANDSCAPE, "(I)V", "Le/a/a/g/d/i/s1/g/e;", "textPage", "resetPageOffset", "showAds", "h", "(Le/a/a/g/d/i/s1/g/e;ZZ)V", "", "content", "setContentDescription", "(Ljava/lang/String;)V", "d", "j", "(Le/a/a/g/d/i/s1/g/e;)Le/a/a/g/d/i/s1/g/e;", "", "x", "y", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "relativePage", "lineIndex", "charIndex", "select", "g", "(FFLf/c0/b/q;)V", "f", "(III)V", "e", ai.at, ai.aD, "tip", "Lio/legado/app/ui/widget/BatteryView;", "b", "(I)Lio/legado/app/ui/widget/BatteryView;", "p", "Lio/legado/app/ui/widget/BatteryView;", "tvTotalProgress", "tvPageAndTotal", OptRuntime.GeneratorState.resumptionPoint_TYPE, ai.aA, "tvBookName", "tvPage", "", "Ljava/lang/Object;", "getMAdBannerObject", "()Ljava/lang/Object;", "setMAdBannerObject", "(Ljava/lang/Object;)V", "mAdBannerObject", "tvTitle", "Lcom/ifmvo/togetherad/core/helper/AdHelperNativeExpress;", "Lf/e;", "getAdHelperNativeExpress2", "()Lcom/ifmvo/togetherad/core/helper/AdHelperNativeExpress;", "adHelperNativeExpress2", "getTextPage", "()Le/a/a/g/d/i/s1/g/e;", "getMAdObject", "setMAdObject", "mAdObject", "tvTime", "Z", "needBannerRequest", "tvBattery", "tvTimeBattery", "getSelectedText", "()Ljava/lang/String;", "selectedText", "getHeaderHeight", "()I", "headerHeight", "needRequest", "Lio/legado/app/databinding/ViewBookPageBinding;", "Lio/legado/app/databinding/ViewBookPageBinding;", "binding", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "<init>", "(Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final ViewBookPageBinding binding;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int battery;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BatteryView tvTitle;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BatteryView tvTime;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BatteryView tvBattery;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BatteryView tvPage;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BatteryView tvTotalProgress;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BatteryView tvPageAndTotal;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BatteryView tvBookName;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BatteryView tvTimeBattery;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Object mAdObject;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Object mAdBannerObject;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public boolean needRequest;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public boolean needBannerRequest;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final e adHelperNativeExpress2;

    /* JADX INFO: compiled from: PageView.kt */
    public static final class a extends k implements l<e.a.a.g.d.i.s1.g.e, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(e.a.a.g.d.i.s1.g.e eVar) {
            invoke2(eVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.g.d.i.s1.g.e eVar) {
            j.e(eVar, "it");
            PageView.this.j(eVar);
        }
    }

    /* JADX INFO: compiled from: PageView.kt */
    public static final class b extends k implements f.c0.b.a<AdHelperNativeExpress> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ PageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, PageView pageView) {
            super(0);
            this.$context = context;
            this.this$0 = pageView;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @Nullable
        public final AdHelperNativeExpress invoke() {
            Object objM11constructorimpl;
            AdsConfig adsConfig;
            Context context = this.$context;
            j.e(context, com.umeng.analytics.pro.c.R);
            String strO2 = f.O2(context, "adsConfig", null, 2);
            if (strO2 == null) {
                adsConfig = new AdsConfig();
            } else {
                Gson gsonA = n.a();
                try {
                    Type type = new c.a().getType();
                    j.d(type, "object : TypeToken<T>() {}.type");
                    Object objFromJson = gsonA.fromJson(strO2, type);
                    if (!(objFromJson instanceof AdsConfig)) {
                        objFromJson = null;
                    }
                    objM11constructorimpl = h.m11constructorimpl((AdsConfig) objFromJson);
                } catch (Throwable th) {
                    objM11constructorimpl = h.m11constructorimpl(f.m1(th));
                }
                if (h.m16isFailureimpl(objM11constructorimpl)) {
                    objM11constructorimpl = null;
                }
                adsConfig = (AdsConfig) objM11constructorimpl;
                if (adsConfig == null) {
                    adsConfig = new AdsConfig();
                } else {
                    adsConfig.getEnableAds();
                }
            }
            AppCompatActivity appCompatActivityO1 = f.O1(this.this$0);
            if (appCompatActivityO1 == null) {
                return null;
            }
            return new AdHelperNativeExpress(appCompatActivityO1, "ad_native_express_simple", adsConfig.getReadWeight(), 1);
        }
    }

    /* JADX INFO: compiled from: PageView.kt */
    public static final class c implements BannerListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsConfig f7241b;

        public c(AdsConfig adsConfig) {
            this.f7241b = adsConfig;
        }

        @Override // com.ifmvo.togetherad.core.listener.BannerListener
        public void onAdClicked(@NotNull String str) {
            j.e(str, "providerType");
            PageView.this.binding.f6867c.setVisibility(8);
            // AD REMOVED: MobclickAgent.onEvent(PageView.this.getContext(), "readBannerClick");
        }

        @Override // com.ifmvo.togetherad.core.listener.BannerListener
        public void onAdClose(@NotNull String str) {
            j.e(str, "providerType");
            PageView.this.binding.f6867c.setVisibility(8);
        }

        @Override // com.ifmvo.togetherad.core.listener.BannerListener
        public void onAdExpose(@NotNull String str) {
            j.e(str, "providerType");
            PageView.this.needBannerRequest = this.f7241b.getRefreshBanner();
            // AD REMOVED: MobclickAgent.onEvent(PageView.this.getContext(), "readBannerExposed");
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdFailed(@NotNull String str, @Nullable String str2) {
            j.e(str, "providerType");
            // AD REMOVED: MobclickAgent.onEvent(PageView.this.getContext(), "readBannerLoadFaild");
            // AD REMOVED: MobclickAgent.onEvent(PageView.this.getContext(), "readBannerAdsLoadFaildMsg", j.k(str, str2));
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdFailedAll(@Nullable String str) {
            PageView.this.binding.f6867c.setVisibility(8);
            PageView pageView = PageView.this;
            pageView.needBannerRequest = true;
            // AD REMOVED: MobclickAgent.onEvent(pageView.getContext(), "readBannerFaildAll");
            // AD REMOVED: MobclickAgent.onEvent(PageView.this.getContext(), "readBannerAdsLoadFaildMsg", str);
        }

        @Override // com.ifmvo.togetherad.core.listener.BannerListener
        public void onAdLoaded(@NotNull String str) {
            j.e(str, "providerType");
            // AD REMOVED: MobclickAgent.onEvent(PageView.this.getContext(), "readBannerLoad");
            PageView.this.needBannerRequest = false;
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdStartRequest(@NotNull String str) {
            j.e(str, "providerType");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageView(@NotNull Context context) {
        super(context);
        j.e(context, com.umeng.analytics.pro.c.R);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_book_page, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = R.id.adContainer;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.adContainer);
        if (linearLayout != null) {
            i2 = R.id.bannerContainer;
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.bannerContainer);
            if (frameLayout != null) {
                i2 = R.id.bv_footer_left;
                BatteryView batteryView = (BatteryView) viewInflate.findViewById(R.id.bv_footer_left);
                if (batteryView != null) {
                    i2 = R.id.bv_header_left;
                    BatteryView batteryView2 = (BatteryView) viewInflate.findViewById(R.id.bv_header_left);
                    if (batteryView2 != null) {
                        i2 = R.id.content_text_view;
                        ContentTextView contentTextView = (ContentTextView) viewInflate.findViewById(R.id.content_text_view);
                        if (contentTextView != null) {
                            i2 = R.id.ll_footer;
                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.ll_footer);
                            if (constraintLayout != null) {
                                i2 = R.id.ll_header;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.ll_header);
                                if (constraintLayout2 != null) {
                                    i2 = R.id.page_nv_bar;
                                    View viewFindViewById = viewInflate.findViewById(R.id.page_nv_bar);
                                    if (viewFindViewById != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                                        i2 = R.id.tv_footer_left;
                                        BatteryView batteryView3 = (BatteryView) viewInflate.findViewById(R.id.tv_footer_left);
                                        if (batteryView3 != null) {
                                            i2 = R.id.tv_footer_middle;
                                            BatteryView batteryView4 = (BatteryView) viewInflate.findViewById(R.id.tv_footer_middle);
                                            if (batteryView4 != null) {
                                                i2 = R.id.tv_footer_right;
                                                BatteryView batteryView5 = (BatteryView) viewInflate.findViewById(R.id.tv_footer_right);
                                                if (batteryView5 != null) {
                                                    i2 = R.id.tv_header_left;
                                                    BatteryView batteryView6 = (BatteryView) viewInflate.findViewById(R.id.tv_header_left);
                                                    if (batteryView6 != null) {
                                                        i2 = R.id.tv_header_middle;
                                                        BatteryView batteryView7 = (BatteryView) viewInflate.findViewById(R.id.tv_header_middle);
                                                        if (batteryView7 != null) {
                                                            i2 = R.id.tv_header_right;
                                                            BatteryView batteryView8 = (BatteryView) viewInflate.findViewById(R.id.tv_header_right);
                                                            if (batteryView8 != null) {
                                                                i2 = R.id.vw_bottom_divider;
                                                                View viewFindViewById2 = viewInflate.findViewById(R.id.vw_bottom_divider);
                                                                if (viewFindViewById2 != null) {
                                                                    i2 = R.id.vw_status_bar;
                                                                    FrameLayout frameLayout2 = (FrameLayout) viewInflate.findViewById(R.id.vw_status_bar);
                                                                    if (frameLayout2 != null) {
                                                                        i2 = R.id.vw_top_divider;
                                                                        View viewFindViewById3 = viewInflate.findViewById(R.id.vw_top_divider);
                                                                        if (viewFindViewById3 != null) {
                                                                            ViewBookPageBinding viewBookPageBinding = new ViewBookPageBinding(linearLayout2, linearLayout, frameLayout, batteryView, batteryView2, contentTextView, constraintLayout, constraintLayout2, viewFindViewById, linearLayout2, batteryView3, batteryView4, batteryView5, batteryView6, batteryView7, batteryView8, viewFindViewById2, frameLayout2, viewFindViewById3);
                                                                            j.d(viewBookPageBinding, "inflate(LayoutInflater.from(context), this, true)");
                                                                            this.binding = viewBookPageBinding;
                                                                            this.battery = 100;
                                                                            this.needRequest = true;
                                                                            this.needBannerRequest = true;
                                                                            this.adHelperNativeExpress2 = f.N3(new b(context, this));
                                                                            if (!isInEditMode()) {
                                                                                setBackgroundColor(f.c2(context, R.color.background));
                                                                                n();
                                                                            }
                                                                            contentTextView.setUpView(new a());
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    private final AdHelperNativeExpress getAdHelperNativeExpress2() {
        return (AdHelperNativeExpress) this.adHelperNativeExpress2.getValue();
    }

    public static /* synthetic */ void i(PageView pageView, e.a.a.g.d.i.s1.g.e eVar, boolean z, boolean z2, int i2) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        pageView.h(eVar, z, z2);
    }

    public final void a() {
        ContentTextView contentTextView = this.binding.f6870f;
        int i2 = contentTextView.callBack.A() ? 2 : 0;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                Iterator<T> it = contentTextView.c(i3).f5783d.iterator();
                while (it.hasNext()) {
                    Iterator<T> it2 = ((d) it.next()).f5774b.iterator();
                    while (it2.hasNext()) {
                        ((e.a.a.g.d.i.s1.g.c) it2.next()).f5772d = false;
                    }
                }
                if (i3 == i2) {
                    break;
                } else {
                    i3 = i4;
                }
            }
        }
        contentTextView.invalidate();
        contentTextView.callBack.t();
    }

    public final BatteryView b(int tip) {
        ViewBookPageBinding viewBookPageBinding = this.binding;
        r rVar = r.a;
        if (tip == rVar.i()) {
            return tip == 1 ? viewBookPageBinding.n : viewBookPageBinding.f6869e;
        }
        if (tip == rVar.j()) {
            return viewBookPageBinding.o;
        }
        if (tip == rVar.k()) {
            return viewBookPageBinding.p;
        }
        if (tip == rVar.f()) {
            return tip == 1 ? viewBookPageBinding.f6875k : viewBookPageBinding.f6868d;
        }
        if (tip == rVar.g()) {
            return viewBookPageBinding.f6876l;
        }
        if (tip == rVar.h()) {
            return viewBookPageBinding.m;
        }
        return null;
    }

    public final void c() {
        AdHelperBanner adHelperBanner = AdHelperBanner.INSTANCE;
        if (adHelperBanner != null) {
            adHelperBanner.destroy();
        }
        AdHelperNativeExpress adHelperNativeExpress2 = getAdHelperNativeExpress2();
        if (adHelperNativeExpress2 != null) {
            adHelperNativeExpress2.destroyAllExpressAd();
        }
        this.binding.f6867c.removeAllViews();
    }

    public final void d() {
        this.binding.f6870f.pageOffset = 0;
    }

    public final void e(int relativePage, int lineIndex, int charIndex) {
        ContentTextView contentTextView = this.binding.f6870f;
        contentTextView.selectEnd[0] = Integer.valueOf(relativePage);
        contentTextView.selectEnd[1] = Integer.valueOf(lineIndex);
        contentTextView.selectEnd[2] = Integer.valueOf(charIndex);
        d dVarB = contentTextView.c(relativePage).b(lineIndex);
        float f2 = dVarB.a(charIndex).f5771c;
        float fB = contentTextView.b(relativePage) + dVarB.f5777e;
        contentTextView.callBack.E(f2, fB + r6.j0());
        contentTextView.f();
    }

    public final void f(int relativePage, int lineIndex, int charIndex) {
        ContentTextView contentTextView = this.binding.f6870f;
        contentTextView.selectStart[0] = Integer.valueOf(relativePage);
        contentTextView.selectStart[1] = Integer.valueOf(lineIndex);
        contentTextView.selectStart[2] = Integer.valueOf(charIndex);
        d dVarB = contentTextView.c(relativePage).b(lineIndex);
        contentTextView.g(dVarB.a(charIndex).f5770b, contentTextView.b(relativePage) + dVarB.f5777e, contentTextView.b(relativePage) + dVarB.f5775c);
        contentTextView.f();
    }

    public final void g(float x, float y, @NotNull q<? super Integer, ? super Integer, ? super Integer, v> select) {
        FragmentManager supportFragmentManager;
        j.e(select, "select");
        ContentTextView contentTextView = this.binding.f6870f;
        float headerHeight = y - getHeaderHeight();
        Objects.requireNonNull(contentTextView);
        j.e(select, "select");
        if (!contentTextView.selectAble || !contentTextView.visibleRect.contains(x, headerHeight)) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            float fB = contentTextView.b(i3);
            if (i3 > 0) {
                if (!contentTextView.callBack.A()) {
                    return;
                }
                e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
                if (fB >= e.a.a.g.d.i.s1.h.a.f5793g) {
                    return;
                }
            }
            e.a.a.g.d.i.s1.g.e eVarC = contentTextView.c(i3);
            int i5 = 0;
            for (d dVar : eVarC.f5783d) {
                int i6 = i5 + 1;
                if (headerHeight > dVar.f5775c + fB && headerHeight < dVar.f5777e + fB) {
                    for (e.a.a.g.d.i.s1.g.c cVar : dVar.f5774b) {
                        int i7 = i2 + 1;
                        if (x > cVar.f5770b && x < cVar.f5771c) {
                            if (!cVar.f5773e) {
                                cVar.f5772d = true;
                                contentTextView.invalidate();
                                select.invoke(Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i2));
                                return;
                            }
                            AppCompatActivity appCompatActivityO1 = f.O1(contentTextView);
                            if (appCompatActivityO1 == null || (supportFragmentManager = appCompatActivityO1.getSupportFragmentManager()) == null) {
                                return;
                            }
                            PhotoDialog.Companion aVar2 = PhotoDialog.INSTANCE;
                            int i8 = eVarC.f5786g;
                            String str = cVar.a;
                            Objects.requireNonNull(aVar2);
                            j.e(supportFragmentManager, "fragmentManager");
                            j.e(str, "src");
                            PhotoDialog photoDialog = new PhotoDialog();
                            Bundle bundle = new Bundle();
                            bundle.putInt("chapterIndex", i8);
                            bundle.putString("src", str);
                            photoDialog.setArguments(bundle);
                            photoDialog.show(supportFragmentManager, "photoDialog");
                            return;
                        }
                        i2 = i7;
                    }
                    return;
                }
                i5 = i6;
            }
            if (i4 > 2) {
                return;
            } else {
                i3 = i4;
            }
        }
    }

    public final int getHeaderHeight() {
        int iX2;
        if (ReadBookConfig.INSTANCE.getHideStatusBar()) {
            iX2 = 0;
        } else {
            Context context = getContext();
            j.d(context, com.umeng.analytics.pro.c.R);
            iX2 = f.X2(context);
        }
        ConstraintLayout constraintLayout = this.binding.f6872h;
        j.d(constraintLayout, "binding.llHeader");
        return iX2 + (constraintLayout.getVisibility() == 8 ? 0 : this.binding.f6872h.getHeight());
    }

    @Nullable
    public final Object getMAdBannerObject() {
        return this.mAdBannerObject;
    }

    @Nullable
    public final Object getMAdObject() {
        return this.mAdObject;
    }

    @NotNull
    public final String getSelectedText() {
        return this.binding.f6870f.getSelectedText();
    }

    @NotNull
    public final e.a.a.g.d.i.s1.g.e getTextPage() {
        return this.binding.f6870f.getTextPage();
    }

    public final void h(@NotNull e.a.a.g.d.i.s1.g.e textPage, boolean resetPageOffset, boolean showAds) {
        Object objM11constructorimpl;
        AdsConfig adsConfig;
        j.e(textPage, "textPage");
        j(textPage);
        if (resetPageOffset) {
            d();
        }
        this.binding.f6870f.setContent(textPage);
        Context context = getContext();
        j.d(context, com.umeng.analytics.pro.c.R);
        j.e(context, com.umeng.analytics.pro.c.R);
        String strO2 = f.O2(context, "adsConfig", null, 2);
        if (strO2 == null) {
            adsConfig = new AdsConfig();
        } else {
            Gson gsonA = n.a();
            try {
                Type type = new c.a().getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(strO2, type);
                if (!(objFromJson instanceof AdsConfig)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((AdsConfig) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            adsConfig = (AdsConfig) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            if (adsConfig == null) {
                adsConfig = new AdsConfig();
            } else {
                adsConfig.getEnableAds();
            }
        }
        if (adsConfig.getEnableAds()) {
            j.e(adsConfig, "adsConfig");
            if (System.currentTimeMillis() - e.a.a.d.q.a.a() > adsConfig.getInstallBookTime() * ((long) 1000)) {
                if (textPage.a == 0 && adsConfig.getEnableBook()) {
                    this.binding.f6866b.setVisibility(8);
                    this.binding.f6867c.setVisibility(8);
                }
                int i2 = textPage.f5784e;
                if (i2 <= 1 || textPage.a != i2 - 1 || !showAds) {
                    LinearLayout linearLayout = this.binding.f6866b;
                    j.d(linearLayout, "binding.adContainer");
                    f.e3(linearLayout);
                    FrameLayout frameLayout = this.binding.f6867c;
                    j.d(frameLayout, "binding.bannerContainer");
                    f.e3(frameLayout);
                    return;
                }
                float f2 = textPage.f5787h;
                e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
                if (f2 >= e.a.a.g.d.i.s1.h.a.f5793g / 2 || !adsConfig.getEnableBook()) {
                    int i3 = e.a.a.g.d.i.s1.h.a.f5793g;
                    if (i3 / 2 >= f2 || f2 >= i3 - 200 || !adsConfig.getEnableBookBanner()) {
                        LinearLayout linearLayout2 = this.binding.f6866b;
                        j.d(linearLayout2, "binding.adContainer");
                        f.e3(linearLayout2);
                        FrameLayout frameLayout2 = this.binding.f6867c;
                        j.d(frameLayout2, "binding.bannerContainer");
                        f.e3(frameLayout2);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                    Context context2 = getContext();
                    j.d(context2, com.umeng.analytics.pro.c.R);
                    layoutParams.topMargin = SizeExtKt.dpToPx(context2, 12) + ((int) f2);
                    this.binding.f6867c.setLayoutParams(layoutParams);
                    AppCompatActivity appCompatActivityO1 = f.O1(this);
                    if (appCompatActivityO1 == null) {
                        return;
                    }
                    k(appCompatActivityO1, true);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.leftMargin = 12;
                layoutParams2.rightMargin = 12;
                layoutParams2.topMargin = (int) f2;
                this.binding.f6866b.setLayoutParams(layoutParams2);
                if (this.needRequest) {
                    if (this.mAdObject != null) {
                        LinearLayout linearLayout3 = this.binding.f6866b;
                        j.d(linearLayout3, "binding.adContainer");
                        f.c6(linearLayout3);
                    } else {
                        LinearLayout linearLayout4 = this.binding.f6866b;
                        j.d(linearLayout4, "binding.adContainer");
                        f.e3(linearLayout4);
                    }
                } else {
                    if (this.mAdObject != null) {
                        LinearLayout linearLayout5 = this.binding.f6866b;
                        j.d(linearLayout5, "binding.adContainer");
                        f.c6(linearLayout5);
                        AppCompatActivity appCompatActivityO12 = f.O1(this);
                        if (appCompatActivityO12 == null) {
                            return;
                        }
                        k(appCompatActivityO12, false);
                        return;
                    }
                    LinearLayout linearLayout6 = this.binding.f6866b;
                    j.d(linearLayout6, "binding.adContainer");
                    f.e3(linearLayout6);
                    this.needRequest = true;
                }
                Context context3 = getContext();
                j.d(context3, com.umeng.analytics.pro.c.R);
                ScreenUtil screenUtil = ScreenUtil.INSTANCE;
                Context context4 = getContext();
                j.d(context4, com.umeng.analytics.pro.c.R);
                float fPx2dp = (SizeExtKt.px2dp(context3, screenUtil.getDisplayMetricsHeight(context4)) / 2) - 100;
                Context context5 = getContext();
                j.d(context5, com.umeng.analytics.pro.c.R);
                Context context6 = getContext();
                j.d(context6, com.umeng.analytics.pro.c.R);
                CsjProvider.NativeExpress.INSTANCE.setExpressViewAcceptedSize(SizeExtKt.px2dp(context5, screenUtil.getDisplayMetricsHeight(context6)), fPx2dp);
                AdHelperNativeExpress adHelperNativeExpress2 = getAdHelperNativeExpress2();
                if (adHelperNativeExpress2 == null) {
                    return;
                }
                adHelperNativeExpress2.getExpressList(new e.a.a.g.d.i.s1.b(this));
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    @NotNull
    public final e.a.a.g.d.i.s1.g.e j(@NotNull e.a.a.g.d.i.s1.g.e textPage) {
        j.e(textPage, "textPage");
        BatteryView batteryView = this.tvBookName;
        if (batteryView != null) {
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            Book book = e.a.a.f.s.k.f5677c;
            batteryView.setText(book == null ? null : book.getName());
        }
        BatteryView batteryView2 = this.tvTitle;
        if (batteryView2 != null) {
            batteryView2.setText(textPage.f5782c);
        }
        BatteryView batteryView3 = this.tvPage;
        if (batteryView3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(textPage.a + 1);
            sb.append(Attributes.InternalPrefix);
            sb.append(textPage.f5784e);
            batteryView3.setText(sb.toString());
        }
        BatteryView batteryView4 = this.tvTotalProgress;
        if (batteryView4 != null) {
            batteryView4.setText(textPage.d());
        }
        BatteryView batteryView5 = this.tvPageAndTotal;
        if (batteryView5 != null) {
            batteryView5.setText((textPage.a + 1) + Attributes.InternalPrefix + textPage.f5784e + "  " + textPage.d());
        }
        return textPage;
    }

    public final void k(@NotNull Activity activity, boolean bannerShow) {
        j.e(activity, "activity");
        if (!bannerShow) {
            if (this.mAdObject == null) {
                return;
            }
            this.binding.f6866b.removeAllViews();
            AdHelperNativeExpress.INSTANCE.show(this.mAdObject, this.binding.f6866b, new h0());
            return;
        }
        this.binding.f6867c.setVisibility(0);
        Context context = getContext();
        j.d(context, com.umeng.analytics.pro.c.R);
        e.a.a.d.w.c.c(context);
        if (this.needBannerRequest) {
            this.binding.f6867c.removeAllViews();
            Context context2 = getContext();
            j.d(context2, com.umeng.analytics.pro.c.R);
            AdsConfig adsConfigC = e.a.a.d.w.c.c(context2);
            GdtProvider.Banner.INSTANCE.setSlideIntervalTime((adsConfigC.getBannerRefreshTime() / 1000) + 30);
            CsjProvider.Banner banner = CsjProvider.Banner.INSTANCE;
            banner.setSlideIntervalTime(adsConfigC.getBannerRefreshTime());
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            banner.setExpressViewAcceptedSize(SizeExtKt.px2dp(activity, screenUtil.getDisplayMetricsWidth(activity)), SizeExtKt.px2dp(activity, screenUtil.getDisplayMetricsWidth(activity) / 8));
            FrameLayout frameLayout = this.binding.f6867c;
            LinkedHashMap<String, Integer> readBannerWeight = adsConfigC.getReadBannerWeight();
            c cVar = new c(adsConfigC);
            AdHelperBanner adHelperBanner = AdHelperBanner.INSTANCE;
            j.d(frameLayout, "bannerContainer");
            adHelperBanner.show(activity, "ad_banner", readBannerWeight, frameLayout, cVar);
        }
    }

    public final void l(int battery) {
        this.battery = battery;
        BatteryView batteryView = this.tvBattery;
        if (batteryView != null) {
            batteryView.setBattery(battery);
        }
        p();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r5 = this;
            io.legado.app.databinding.ViewBookPageBinding r0 = r5.binding
            android.widget.FrameLayout r0 = r0.r
            int r1 = r0.getPaddingLeft()
            android.content.Context r2 = r0.getContext()
            java.lang.String r3 = "context"
            f.c0.c.j.d(r2, r3)
            int r2 = c.b.a.m.f.X2(r2)
            int r3 = r0.getPaddingRight()
            int r4 = r0.getPaddingBottom()
            r0.setPadding(r1, r2, r3, r4)
            java.lang.String r1 = ""
            f.c0.c.j.d(r0, r1)
            io.legado.app.help.ReadBookConfig r1 = io.legado.app.help.ReadBookConfig.INSTANCE
            boolean r1 = r1.getHideStatusBar()
            r2 = 0
            if (r1 != 0) goto L51
            androidx.appcompat.app.AppCompatActivity r1 = c.b.a.m.f.O1(r0)
            boolean r3 = r1 instanceof io.legado.app.base.BaseActivity
            r4 = 0
            if (r3 == 0) goto L3a
            io.legado.app.base.BaseActivity r1 = (io.legado.app.base.BaseActivity) r1
            goto L3b
        L3a:
            r1 = r4
        L3b:
            if (r1 != 0) goto L3e
            goto L46
        L3e:
            boolean r1 = r1.M0()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
        L46:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r1 = f.c0.c.j.a(r4, r1)
            if (r1 == 0) goto L4f
            goto L51
        L4f:
            r1 = 0
            goto L52
        L51:
            r1 = 1
        L52:
            if (r1 == 0) goto L56
            r2 = 8
        L56:
            r0.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.page.PageView.m():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.page.PageView.n():void");
    }

    public final void o() {
        BatteryView batteryView = this.tvTime;
        if (batteryView != null) {
            e.a.a.c.c cVar = e.a.a.c.c.a;
            batteryView.setText(((SimpleDateFormat) e.a.a.c.c.f5497c.getValue()).format(new Date(System.currentTimeMillis())));
        }
        p();
    }

    @SuppressLint({"SetTextI18n"})
    public final void p() {
        BatteryView batteryView = this.tvTimeBattery;
        if (batteryView == null) {
            return;
        }
        e.a.a.c.c cVar = e.a.a.c.c.a;
        String str = ((SimpleDateFormat) e.a.a.c.c.f5497c.getValue()).format(new Date(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder();
        sb.append((Object) str);
        sb.append(' ');
        sb.append(this.battery);
        sb.append('%');
        batteryView.setText(sb.toString());
    }

    public final void setBg(@Nullable Drawable bg) {
        this.binding.f6874j.setBackground(bg);
    }

    public final void setContentDescription(@NotNull String content) {
        j.e(content, "content");
        this.binding.f6870f.setContentDescription(content);
    }

    public final void setMAdBannerObject(@Nullable Object obj) {
        this.mAdBannerObject = obj;
    }

    public final void setMAdObject(@Nullable Object obj) {
        this.mAdObject = obj;
    }
}
