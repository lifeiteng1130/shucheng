package com.ifmvo.togetherad.gdt;

import android.content.Context;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TogetherAdGdt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ7\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJC\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJO\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/ifmvo/togetherad/gdt/TogetherAdGdt;", "", "Landroid/content/Context;", c.R, "", "adProviderType", "gdtAdAppId", "Lf/v;", "init", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "providerClassPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "gdtIdMap", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "Lcom/qq/e/comm/compliance/DownloadConfirmListener;", "downloadConfirmListener", "Lcom/qq/e/comm/compliance/DownloadConfirmListener;", "getDownloadConfirmListener", "()Lcom/qq/e/comm/compliance/DownloadConfirmListener;", "setDownloadConfirmListener", "(Lcom/qq/e/comm/compliance/DownloadConfirmListener;)V", "", "idMapGDT", "Ljava/util/Map;", "getIdMapGDT", "()Ljava/util/Map;", "setIdMapGDT", "(Ljava/util/Map;)V", "<init>", "()V", "gdt_release"}, k = 1, mv = {1, 4, 0})
public final class TogetherAdGdt {

    @Nullable
    private static DownloadConfirmListener downloadConfirmListener;
    public static final TogetherAdGdt INSTANCE = new TogetherAdGdt();

    @NotNull
    private static Map<String, String> idMapGDT = new LinkedHashMap();

    private TogetherAdGdt() {
    }

    public static /* synthetic */ void init$default(TogetherAdGdt togetherAdGdt, Context context, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        togetherAdGdt.init(context, str, str2, str3);
    }

    @Nullable
    public final DownloadConfirmListener getDownloadConfirmListener() {
        return downloadConfirmListener;
    }

    @NotNull
    public final Map<String, String> getIdMapGDT() {
        return idMapGDT;
    }

    public final void init(@NotNull Context context, @NotNull String adProviderType, @NotNull String gdtAdAppId) {
        j.f(context, c.R);
        j.f(adProviderType, "adProviderType");
        j.f(gdtAdAppId, "gdtAdAppId");
        init(context, adProviderType, gdtAdAppId, null, null);
    }

    public final void setDownloadConfirmListener(@Nullable DownloadConfirmListener downloadConfirmListener2) {
        downloadConfirmListener = downloadConfirmListener2;
    }

    public final void setIdMapGDT(@NotNull Map<String, String> map) {
        j.f(map, "<set-?>");
        idMapGDT = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(TogetherAdGdt togetherAdGdt, Context context, String str, String str2, Map map, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            map = null;
        }
        togetherAdGdt.init(context, str, str2, (Map<String, String>) map);
    }

    public final void init(@NotNull Context context, @NotNull String adProviderType, @NotNull String gdtAdAppId, @Nullable String providerClassPath) {
        j.f(context, c.R);
        j.f(adProviderType, "adProviderType");
        j.f(gdtAdAppId, "gdtAdAppId");
        init(context, adProviderType, gdtAdAppId, null, providerClassPath);
    }

    public final void init(@NotNull Context context, @NotNull String adProviderType, @NotNull String gdtAdAppId, @Nullable Map<String, String> gdtIdMap) {
        j.f(context, c.R);
        j.f(adProviderType, "adProviderType");
        j.f(gdtAdAppId, "gdtAdAppId");
        init(context, adProviderType, gdtAdAppId, gdtIdMap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void init(@org.jetbrains.annotations.NotNull android.content.Context r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r11, @org.jetbrains.annotations.Nullable java.lang.String r12) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            f.c0.c.j.f(r8, r0)
            java.lang.String r0 = "adProviderType"
            f.c0.c.j.f(r9, r0)
            java.lang.String r0 = "gdtAdAppId"
            f.c0.c.j.f(r10, r0)
            com.ifmvo.togetherad.core.TogetherAd r0 = com.ifmvo.togetherad.core.TogetherAd.INSTANCE
            if (r12 == 0) goto L1e
            int r1 = r12.length()
            if (r1 != 0) goto L1b
            r1 = 1
            goto L1c
        L1b:
            r1 = 0
        L1c:
            if (r1 == 0) goto L24
        L1e:
            java.lang.Class<com.ifmvo.togetherad.gdt.provider.GdtProvider> r12 = com.ifmvo.togetherad.gdt.provider.GdtProvider.class
            java.lang.String r12 = r12.getName()
        L24:
            r3 = r12
            java.lang.String r12 = "if (providerClassPath?.i…me else providerClassPath"
            f.c0.c.j.b(r3, r12)
            r4 = 0
            r5 = 4
            r6 = 0
            com.ifmvo.togetherad.core.entity.AdProviderEntity r12 = new com.ifmvo.togetherad.core.entity.AdProviderEntity
            r1 = r12
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r0.addProvider(r12)
            if (r11 == 0) goto L3e
            java.util.Map<java.lang.String, java.lang.String> r9 = com.ifmvo.togetherad.gdt.TogetherAdGdt.idMapGDT
            r9.putAll(r11)
        L3e:
            com.qq.e.comm.managers.GDTADManager r9 = com.qq.e.comm.managers.GDTADManager.getInstance()
            r9.initWith(r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ifmvo.togetherad.gdt.TogetherAdGdt.init(android.content.Context, java.lang.String, java.lang.String, java.util.Map, java.lang.String):void");
    }
}
