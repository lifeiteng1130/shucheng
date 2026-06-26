package com.ifmvo.togetherad.csj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: TogetherAdCsj.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bZ\u0010[J5\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJA\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\fJM\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJW\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R.\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\"\u0010/\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\"\u00102\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\"\u00105\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0013\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017R\"\u00108\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0013\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\u001a\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR\"\u0010E\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u001a\u001a\u0004\bF\u0010\u001c\"\u0004\bG\u0010\u001eR$\u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010 \u001a\u0004\bI\u0010\"\"\u0004\bJ\u0010$R\"\u0010K\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0013\u001a\u0004\bK\u0010\u0015\"\u0004\bL\u0010\u0017R!\u0010O\u001a\n N*\u0004\u0018\u00010M0M8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006\\"}, d2 = {"Lcom/ifmvo/togetherad/csj/TogetherAdCsj;", "", "Landroid/content/Context;", c.R, "", "adProviderType", "csjAdAppId", "appName", "Lf/v;", "init", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "providerClassPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "csjIdMap", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "", "allowShowNotify", "Z", "getAllowShowNotify", "()Z", "setAllowShowNotify", "(Z)V", "", "themeStatus", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getThemeStatus", "()I", "setThemeStatus", "(I)V", "data", "Ljava/lang/String;", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "", "idMapCsj", "Ljava/util/Map;", "getIdMapCsj", "()Ljava/util/Map;", "setIdMapCsj", "(Ljava/util/Map;)V", "titleBarTheme", "getTitleBarTheme", "setTitleBarTheme", "debug", "getDebug", "setDebug", "directDownloadNetworkType", "getDirectDownloadNetworkType", "setDirectDownloadNetworkType", "useTextureView", "getUseTextureView", "setUseTextureView", "supportMultiProcess", "getSupportMultiProcess", "setSupportMultiProcess", "Lcom/bytedance/sdk/openadsdk/TTAdSdk$InitCallback;", "initCallback", "Lcom/bytedance/sdk/openadsdk/TTAdSdk$InitCallback;", "getInitCallback", "()Lcom/bytedance/sdk/openadsdk/TTAdSdk$InitCallback;", "setInitCallback", "(Lcom/bytedance/sdk/openadsdk/TTAdSdk$InitCallback;)V", "downloadType", "getDownloadType", "setDownloadType", "pluginUpdateConfig", "getPluginUpdateConfig", "setPluginUpdateConfig", "keywords", "getKeywords", "setKeywords", "isPaid", "setPaid", "Lcom/bytedance/sdk/openadsdk/TTAdManager;", "kotlin.jvm.PlatformType", "mTTAdManager", "Lcom/bytedance/sdk/openadsdk/TTAdManager;", "getMTTAdManager", "()Lcom/bytedance/sdk/openadsdk/TTAdManager;", "Lcom/bytedance/sdk/openadsdk/TTCustomController;", "customController", "Lcom/bytedance/sdk/openadsdk/TTCustomController;", "getCustomController", "()Lcom/bytedance/sdk/openadsdk/TTCustomController;", "setCustomController", "(Lcom/bytedance/sdk/openadsdk/TTCustomController;)V", "<init>", "()V", "csj_release"}, k = 1, mv = {1, 4, 0})
public final class TogetherAdCsj {

    @Nullable
    private static TTCustomController customController;

    @Nullable
    private static String data;
    private static boolean debug;
    private static int downloadType;

    @Nullable
    private static TTAdSdk.InitCallback initCallback;
    private static boolean isPaid;

    @Nullable
    private static String keywords;
    private static boolean supportMultiProcess;
    private static int themeStatus;
    private static int titleBarTheme;
    private static boolean useTextureView;
    public static final TogetherAdCsj INSTANCE = new TogetherAdCsj();

    @NotNull
    private static Map<String, String> idMapCsj = new LinkedHashMap();
    private static boolean allowShowNotify = true;
    private static int directDownloadNetworkType = 5;
    private static int pluginUpdateConfig = -1;
    private static final TTAdManager mTTAdManager = TTAdSdk.getAdManager();

    private TogetherAdCsj() {
    }

    public static /* synthetic */ void init$default(TogetherAdCsj togetherAdCsj, Context context, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str4 = null;
        }
        togetherAdCsj.init(context, str, str2, str3, str4);
    }

    public final boolean getAllowShowNotify() {
        return allowShowNotify;
    }

    @Nullable
    public final TTCustomController getCustomController() {
        return customController;
    }

    @Nullable
    public final String getData() {
        return data;
    }

    public final boolean getDebug() {
        return debug;
    }

    public final int getDirectDownloadNetworkType() {
        return directDownloadNetworkType;
    }

    public final int getDownloadType() {
        return downloadType;
    }

    @NotNull
    public final Map<String, String> getIdMapCsj() {
        return idMapCsj;
    }

    @Nullable
    public final TTAdSdk.InitCallback getInitCallback() {
        return initCallback;
    }

    @Nullable
    public final String getKeywords() {
        return keywords;
    }

    public final TTAdManager getMTTAdManager() {
        return mTTAdManager;
    }

    public final int getPluginUpdateConfig() {
        return pluginUpdateConfig;
    }

    public final boolean getSupportMultiProcess() {
        return supportMultiProcess;
    }

    public final int getThemeStatus() {
        return themeStatus;
    }

    public final int getTitleBarTheme() {
        return titleBarTheme;
    }

    public final boolean getUseTextureView() {
        return useTextureView;
    }

    public final void init(@NotNull Context context, @NotNull String adProviderType, @NotNull String csjAdAppId, @NotNull String appName) {
        j.f(context, c.R);
        j.f(adProviderType, "adProviderType");
        j.f(csjAdAppId, "csjAdAppId");
        j.f(appName, "appName");
        init(context, adProviderType, csjAdAppId, appName, null, null);
    }

    public final boolean isPaid() {
        return isPaid;
    }

    public final void setAllowShowNotify(boolean z) {
        allowShowNotify = z;
    }

    public final void setCustomController(@Nullable TTCustomController tTCustomController) {
        customController = tTCustomController;
    }

    public final void setData(@Nullable String str) {
        data = str;
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setDirectDownloadNetworkType(int i2) {
        directDownloadNetworkType = i2;
    }

    public final void setDownloadType(int i2) {
        downloadType = i2;
    }

    public final void setIdMapCsj(@NotNull Map<String, String> map) {
        j.f(map, "<set-?>");
        idMapCsj = map;
    }

    public final void setInitCallback(@Nullable TTAdSdk.InitCallback initCallback2) {
        initCallback = initCallback2;
    }

    public final void setKeywords(@Nullable String str) {
        keywords = str;
    }

    public final void setPaid(boolean z) {
        isPaid = z;
    }

    public final void setPluginUpdateConfig(int i2) {
        pluginUpdateConfig = i2;
    }

    public final void setSupportMultiProcess(boolean z) {
        supportMultiProcess = z;
    }

    public final void setThemeStatus(int i2) {
        themeStatus = i2;
    }

    public final void setTitleBarTheme(int i2) {
        titleBarTheme = i2;
    }

    public final void setUseTextureView(boolean z) {
        useTextureView = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(TogetherAdCsj togetherAdCsj, Context context, String str, String str2, String str3, Map map, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            map = null;
        }
        togetherAdCsj.init(context, str, str2, str3, (Map<String, String>) map);
    }

    public final void init(@NotNull Context context, @NotNull String adProviderType, @NotNull String csjAdAppId, @NotNull String appName, @Nullable String providerClassPath) {
        j.f(context, c.R);
        j.f(adProviderType, "adProviderType");
        j.f(csjAdAppId, "csjAdAppId");
        j.f(appName, "appName");
        init(context, adProviderType, csjAdAppId, appName, null, providerClassPath);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(TogetherAdCsj togetherAdCsj, Context context, String str, String str2, String str3, Map map, String str4, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            map = null;
        }
        togetherAdCsj.init(context, str, str2, str3, map, str4);
    }

    public final void init(@NotNull Context context, @NotNull String adProviderType, @NotNull String csjAdAppId, @NotNull String appName, @Nullable Map<String, String> csjIdMap) {
        j.f(context, c.R);
        j.f(adProviderType, "adProviderType");
        j.f(csjAdAppId, "csjAdAppId");
        j.f(appName, "appName");
        init(context, adProviderType, csjAdAppId, appName, csjIdMap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void init(@org.jetbrains.annotations.NotNull android.content.Context r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r14, @org.jetbrains.annotations.Nullable java.lang.String r15) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            f.c0.c.j.f(r10, r0)
            java.lang.String r0 = "adProviderType"
            f.c0.c.j.f(r11, r0)
            java.lang.String r0 = "csjAdAppId"
            f.c0.c.j.f(r12, r0)
            java.lang.String r0 = "appName"
            f.c0.c.j.f(r13, r0)
            com.ifmvo.togetherad.core.TogetherAd r0 = com.ifmvo.togetherad.core.TogetherAd.INSTANCE
            r1 = 1
            r2 = 0
            if (r15 == 0) goto L25
            int r3 = r15.length()
            if (r3 != 0) goto L22
            r3 = 1
            goto L23
        L22:
            r3 = 0
        L23:
            if (r3 == 0) goto L2b
        L25:
            java.lang.Class<com.ifmvo.togetherad.csj.provider.CsjProvider> r15 = com.ifmvo.togetherad.csj.provider.CsjProvider.class
            java.lang.String r15 = r15.getName()
        L2b:
            r5 = r15
            java.lang.String r15 = "if (providerClassPath?.i…me else providerClassPath"
            f.c0.c.j.b(r5, r15)
            r6 = 0
            r7 = 4
            r8 = 0
            com.ifmvo.togetherad.core.entity.AdProviderEntity r15 = new com.ifmvo.togetherad.core.entity.AdProviderEntity
            r3 = r15
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r0.addProvider(r15)
            if (r14 == 0) goto L45
            java.util.Map<java.lang.String, java.lang.String> r11 = com.ifmvo.togetherad.csj.TogetherAdCsj.idMapCsj
            r11.putAll(r14)
        L45:
            com.bytedance.sdk.openadsdk.TTAdConfig$Builder r11 = new com.bytedance.sdk.openadsdk.TTAdConfig$Builder
            r11.<init>()
            r11.appId(r12)
            r11.appName(r13)
            int r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.themeStatus
            r11.themeStatus(r12)
            boolean r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.useTextureView
            r11.useTextureView(r12)
            int r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.titleBarTheme
            r11.titleBarTheme(r12)
            boolean r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.allowShowNotify
            r11.allowShowNotify(r12)
            boolean r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.debug
            r11.debug(r12)
            int[] r12 = new int[r1]
            int r13 = com.ifmvo.togetherad.csj.TogetherAdCsj.directDownloadNetworkType
            r12[r2] = r13
            r11.directDownloadNetworkType(r12)
            boolean r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.supportMultiProcess
            r11.supportMultiProcess(r12)
            boolean r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.isPaid
            r11.paid(r12)
            java.lang.String r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.keywords
            if (r12 == 0) goto L83
            r11.keywords(r12)
        L83:
            java.lang.String r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.data
            if (r12 == 0) goto L8a
            r11.data(r12)
        L8a:
            int r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.pluginUpdateConfig
            r13 = -1
            if (r12 == r13) goto L92
            r11.setPluginUpdateConfig(r12)
        L92:
            com.bytedance.sdk.openadsdk.TTCustomController r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.customController
            if (r12 == 0) goto L99
            r11.customController(r12)
        L99:
            com.bytedance.sdk.openadsdk.TTAdConfig r11 = r11.build()
            com.bytedance.sdk.openadsdk.TTAdSdk$InitCallback r12 = com.ifmvo.togetherad.csj.TogetherAdCsj.initCallback
            com.bytedance.sdk.openadsdk.TTAdSdk.init(r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ifmvo.togetherad.csj.TogetherAdCsj.init(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String):void");
    }
}
