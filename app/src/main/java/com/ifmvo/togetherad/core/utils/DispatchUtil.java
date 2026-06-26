package com.ifmvo.togetherad.core.utils;

import com.ifmvo.togetherad.core.DispatchType;
import com.ifmvo.togetherad.core.TogetherAd;
import f.c0.c.j;
import f.d0.c;
import f.f;
import f.h0.k;
import f.x.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DispatchUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0007\u001a\u0004\u0018\u00010\u00032$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u000b\u001a\u0004\u0018\u00010\u00032$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u000eJ?\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00032$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\n¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ifmvo/togetherad/core/utils/DispatchUtil;", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ratioMap", "getAdProviderPriority", "(Ljava/util/HashMap;)Ljava/lang/String;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getAdProviderRandom", "(Ljava/util/LinkedHashMap;)Ljava/lang/String;", "ratio", "(Ljava/lang/String;)Ljava/lang/String;", "alias", "getAdProvider", "(Ljava/lang/String;Ljava/util/LinkedHashMap;)Ljava/lang/String;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class DispatchUtil {
    public static final DispatchUtil INSTANCE = new DispatchUtil();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DispatchType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[DispatchType.Priority.ordinal()] = 1;
            iArr[DispatchType.Random.ordinal()] = 2;
        }
    }

    private DispatchUtil() {
    }

    private final String getAdProviderPriority(@NotNull HashMap<String, Integer> ratioMap) {
        LogExtKt.logi$default("提供商权重：" + ratioMap, null, 1, null);
        Set<Map.Entry<String, Integer>> setEntrySet = ratioMap.entrySet();
        j.b(setEntrySet, "ratioMap.entries");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Integer num = (Integer) ((Map.Entry) next).getValue();
            if (num == null || num.intValue() != 0) {
                arrayList.add(next);
            }
        }
        Map.Entry entry = (Map.Entry) e.n(e.B(arrayList, new DispatchUtil$getAdProviderPriority$$inlined$sortedByDescending$1()), 0);
        String str = entry != null ? (String) entry.getKey() : null;
        LogExtKt.logi$default("权重最高的是: " + str, null, 1, null);
        return str;
    }

    private final String getAdProviderRandom(@NotNull LinkedHashMap<String, Integer> ratioMap) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry<String, Integer>> setEntrySet = ratioMap.entrySet();
        j.b(setEntrySet, "ratioMap.entries");
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            sb.append(((String) entry.getKey()) + ':' + ((Integer) entry.getValue()));
            sb.append(",");
            Object value = entry.getValue();
            j.b(value, "entry.value");
            int iIntValue = ((Number) value).intValue();
            for (int i2 = 0; i2 < iIntValue; i2++) {
                Object key = entry.getKey();
                j.b(key, "entry.key");
                arrayList.add(key);
            }
        }
        LogExtKt.logi$default("提供商权重：" + ((Object) sb), null, 1, null);
        if (arrayList.isEmpty()) {
            return null;
        }
        String str = (String) arrayList.get(f.e0.e.d(f.e0.e.f(0, arrayList.size()), c.Default));
        LogExtKt.logi$default("随机到的广告: " + str, null, 1, null);
        return str;
    }

    @Nullable
    public final String getAdProvider(@NotNull String alias, @NotNull LinkedHashMap<String, Integer> ratioMap) {
        j.f(alias, "alias");
        j.f(ratioMap, "ratioMap");
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        DispatchType dispatchType = togetherAd.getMDispatchTypeMap().get(alias);
        if (dispatchType == null) {
            dispatchType = togetherAd.getDispatchType();
        }
        int iOrdinal = dispatchType.ordinal();
        if (iOrdinal == 0) {
            return getAdProviderRandom(ratioMap);
        }
        if (iOrdinal == 1) {
            return getAdProviderPriority(ratioMap);
        }
        throw new f();
    }

    private final String getAdProviderRandom(@NotNull String ratio) {
        LogExtKt.logi$default("提供商权重：" + ratio, null, 1, null);
        ArrayList arrayList = new ArrayList();
        for (String str : k.F(ratio, new String[]{","}, false, 0, 6)) {
            if (str.length() == 0) {
                break;
            }
            List listF = k.F(str, new String[]{":"}, false, 0, 6);
            if (listF.size() != 2) {
                break;
            }
            String str2 = (String) listF.get(0);
            String str3 = (String) listF.get(1);
            if (str2.length() == 0) {
                break;
            }
            if (str3.length() == 0) {
                break;
            }
            Integer numQ = k.Q(str3);
            int iIntValue = numQ != null ? numQ.intValue() : 0;
            for (int i2 = 0; i2 < iIntValue; i2++) {
                arrayList.add(str2);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        String str4 = (String) arrayList.get(f.e0.e.d(f.e0.e.f(0, arrayList.size()), c.Default));
        LogExtKt.logi$default("随机到的广告: " + str4, null, 1, null);
        return str4;
    }
}
