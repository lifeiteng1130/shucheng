package com.ifmvo.togetherad.core;

import com.ifmvo.togetherad.core.custom.native_.imageloader.AdImageLoader;
import com.ifmvo.togetherad.core.custom.native_.imageloader.DefaultImageLoader;
import com.ifmvo.togetherad.core.entity.AdProviderEntity;
import com.ifmvo.togetherad.core.listener.AllAdListener;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import f.c0.c.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: TogetherAd.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0010\u001a\u00020\u00042$\b\u0001\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R2\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r`\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R>\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0-j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f`.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R<\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020<2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020<8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R*\u0010C\u001a\u00020A2\u0006\u0010B\u001a\u00020A8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00107\u001a\u0004\bJ\u00109\"\u0004\bK\u0010;¨\u0006N"}, d2 = {"Lcom/ifmvo/togetherad/core/TogetherAd;", "", "Lcom/ifmvo/togetherad/core/entity/AdProviderEntity;", "adProviderEntity", "Lf/v;", "addProvider", "(Lcom/ifmvo/togetherad/core/entity/AdProviderEntity;)V", "", "providerType", "getProvider$core_release", "(Ljava/lang/String;)Lcom/ifmvo/togetherad/core/entity/AdProviderEntity;", "getProvider", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "ratioMap", "setPublicProviderRatio", "(Ljava/util/LinkedHashMap;)V", "getPublicProviderRatio", "()Ljava/util/LinkedHashMap;", "Lcom/ifmvo/togetherad/core/custom/native_/imageloader/AdImageLoader;", "imageLoader", "setCustomImageLoader", "(Lcom/ifmvo/togetherad/core/custom/native_/imageloader/AdImageLoader;)V", "mRatioPublicMap", "Ljava/util/LinkedHashMap;", "<set-?>", "mImageLoader", "Lcom/ifmvo/togetherad/core/custom/native_/imageloader/AdImageLoader;", "getMImageLoader", "()Lcom/ifmvo/togetherad/core/custom/native_/imageloader/AdImageLoader;", "Lcom/ifmvo/togetherad/core/DispatchType;", "dispatchType", "Lcom/ifmvo/togetherad/core/DispatchType;", "getDispatchType", "()Lcom/ifmvo/togetherad/core/DispatchType;", "setDispatchType", "(Lcom/ifmvo/togetherad/core/DispatchType;)V", "Lcom/ifmvo/togetherad/core/listener/AllAdListener;", "allAdListener", "Lcom/ifmvo/togetherad/core/listener/AllAdListener;", "getAllAdListener", "()Lcom/ifmvo/togetherad/core/listener/AllAdListener;", "setAllAdListener", "(Lcom/ifmvo/togetherad/core/listener/AllAdListener;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mDispatchTypeMap", "Ljava/util/HashMap;", "getMDispatchTypeMap", "()Ljava/util/HashMap;", "setMDispatchTypeMap", "(Ljava/util/HashMap;)V", "", "failedSwitchEnable", "Z", "getFailedSwitchEnable", "()Z", "setFailedSwitchEnable", "(Z)V", "", "mProviders", "Ljava/util/Map;", "getMProviders", "()Ljava/util/Map;", "", ES6Iterator.VALUE_PROPERTY, "maxFetchDelay", "J", "getMaxFetchDelay", "()J", "setMaxFetchDelay", "(J)V", "printLogEnable", "getPrintLogEnable", "setPrintLogEnable", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class TogetherAd {

    @Nullable
    private static AllAdListener allAdListener;
    private static long maxFetchDelay;
    public static final TogetherAd INSTANCE = new TogetherAd();
    private static final LinkedHashMap<String, Integer> mRatioPublicMap = new LinkedHashMap<>();

    @NotNull
    private static HashMap<String, DispatchType> mDispatchTypeMap = new HashMap<>();

    @NotNull
    private static Map<String, AdProviderEntity> mProviders = new LinkedHashMap();

    @Nullable
    private static AdImageLoader mImageLoader = new DefaultImageLoader();
    private static boolean printLogEnable = true;
    private static boolean failedSwitchEnable = true;

    @NotNull
    private static DispatchType dispatchType = DispatchType.Random;

    private TogetherAd() {
    }

    public final void addProvider(@NotNull AdProviderEntity adProviderEntity) {
        j.f(adProviderEntity, "adProviderEntity");
        mProviders.put(adProviderEntity.getProviderType(), adProviderEntity);
        LogExtKt.logi$default("注册广告提供商：" + adProviderEntity.getProviderType(), null, 1, null);
    }

    @Nullable
    public final AllAdListener getAllAdListener() {
        return allAdListener;
    }

    @NotNull
    public final DispatchType getDispatchType() {
        return dispatchType;
    }

    public final boolean getFailedSwitchEnable() {
        return failedSwitchEnable;
    }

    @NotNull
    public final HashMap<String, DispatchType> getMDispatchTypeMap() {
        return mDispatchTypeMap;
    }

    @Nullable
    public final AdImageLoader getMImageLoader() {
        return mImageLoader;
    }

    @NotNull
    public final Map<String, AdProviderEntity> getMProviders() {
        return mProviders;
    }

    public final long getMaxFetchDelay() {
        return maxFetchDelay;
    }

    public final boolean getPrintLogEnable() {
        return printLogEnable;
    }

    @Nullable
    public final AdProviderEntity getProvider$core_release(@NotNull String providerType) {
        j.f(providerType, "providerType");
        return mProviders.get(providerType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final LinkedHashMap<String, Integer> getPublicProviderRatio() {
        LinkedHashMap<String, Integer> linkedHashMap = mRatioPublicMap;
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = new LinkedHashMap<>();
            Iterator<T> it = mProviders.entrySet().iterator();
            while (it.hasNext()) {
                linkedHashMap.put(((Map.Entry) it.next()).getKey(), 0);
            }
        }
        return linkedHashMap;
    }

    public final void setAllAdListener(@Nullable AllAdListener allAdListener2) {
        allAdListener = allAdListener2;
    }

    public final void setCustomImageLoader(@NotNull AdImageLoader imageLoader) {
        j.f(imageLoader, "imageLoader");
        mImageLoader = imageLoader;
    }

    public final void setDispatchType(@NotNull DispatchType dispatchType2) {
        j.f(dispatchType2, "<set-?>");
        dispatchType = dispatchType2;
    }

    public final void setFailedSwitchEnable(boolean z) {
        failedSwitchEnable = z;
    }

    public final void setMDispatchTypeMap(@NotNull HashMap<String, DispatchType> map) {
        j.f(map, "<set-?>");
        mDispatchTypeMap = map;
    }

    public final void setMaxFetchDelay(long j2) {
        if (j2 < 3000) {
            j2 = 3000;
        } else if (j2 > 10000) {
            j2 = 10000;
        }
        maxFetchDelay = j2;
    }

    public final void setPrintLogEnable(boolean z) {
        printLogEnable = z;
    }

    public final void setPublicProviderRatio(@NotNull LinkedHashMap<String, Integer> ratioMap) {
        j.f(ratioMap, "ratioMap");
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Integer>> setEntrySet = ratioMap.entrySet();
        j.b(setEntrySet, "ratioMap.entries");
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append(((String) entry.getKey()) + ':' + ((Integer) entry.getValue()));
            sb.append(",");
        }
        LogExtKt.logi$default("设置默认广告提供商比例：" + ((Object) sb), null, 1, null);
        LinkedHashMap<String, Integer> linkedHashMap = mRatioPublicMap;
        linkedHashMap.clear();
        linkedHashMap.putAll(ratioMap);
    }
}
