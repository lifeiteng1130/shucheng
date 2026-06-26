package com.ifmvo.togetherad.core.config;

import com.ifmvo.togetherad.core.TogetherAd;
import com.ifmvo.togetherad.core.entity.AdProviderEntity;
import com.ifmvo.togetherad.core.provider.BaseAdProvider;
import f.c0.c.j;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdProviderLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/ifmvo/togetherad/core/config/AdProviderLoader;", "", "", "providerType", "getProviderInstance", "(Ljava/lang/String;)Ljava/lang/Object;", "Ljava/lang/Class;", "clz", "Ljava/lang/reflect/Constructor;", "getConstructor", "(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;", "classPath", "getSDKClass", "(Ljava/lang/String;)Ljava/lang/Class;", "Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "loadAdProvider", "(Ljava/lang/String;)Lcom/ifmvo/togetherad/core/provider/BaseAdProvider;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class AdProviderLoader {
    public static final AdProviderLoader INSTANCE = new AdProviderLoader();

    private AdProviderLoader() {
    }

    private final Constructor<?> getConstructor(Class<?> clz) {
        try {
            return clz.getConstructor(new Class[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private final Object getProviderInstance(String providerType) {
        String classPath;
        AdProviderLoader adProviderLoader;
        Class<?> sDKClass;
        Constructor<?> constructor;
        try {
            AdProviderEntity provider$core_release = TogetherAd.INSTANCE.getProvider$core_release(providerType);
            if (provider$core_release == null || (classPath = provider$core_release.getClassPath()) == null || (sDKClass = (adProviderLoader = INSTANCE).getSDKClass(classPath)) == null || (constructor = adProviderLoader.getConstructor(sDKClass)) == null) {
                return null;
            }
            return constructor.newInstance(new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private final Class<?> getSDKClass(String classPath) {
        try {
            return Class.forName(classPath);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final BaseAdProvider loadAdProvider(@NotNull String providerType) {
        j.f(providerType, "providerType");
        try {
            Object providerInstance = getProviderInstance(providerType);
            if (providerInstance instanceof BaseAdProvider) {
                return (BaseAdProvider) providerInstance;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }
}
