package com.jayway.jsonpath.spi.cache;

import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.internal.Utils;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* JADX INFO: loaded from: classes.dex */
public class CacheProvider {
    private static Cache cache;

    public static Cache getCache() {
        if (cache == null) {
            synchronized (CacheProvider.class) {
                if (cache == null) {
                    cache = getDefaultCache();
                }
            }
        }
        return cache;
    }

    private static Cache getDefaultCache() {
        return new LRUCache(TinkerReport.KEY_LOADED_SUCC_COST_500_LESS);
    }

    public static void setCache(Cache cache2) {
        Utils.notNull(cache2, "Cache may not be null", new Object[0]);
        synchronized (CacheProvider.class) {
            if (cache != null) {
                throw new JsonPathException("Cache provider must be configured before cache is accessed.");
            }
            cache = cache2;
        }
    }
}
