package com.ifmvo.togetherad.core.entity;

import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdProviderEntity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0003\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J.\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/ifmvo/togetherad/core/entity/AdProviderEntity;", "", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "providerType", "classPath", "desc", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ifmvo/togetherad/core/entity/AdProviderEntity;", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDesc", "getClassPath", "getProviderType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 0})
public final /* data */ class AdProviderEntity {

    @NotNull
    private final String classPath;

    @NotNull
    private final String desc;

    @NotNull
    private final String providerType;

    public AdProviderEntity(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        j.f(str, "providerType");
        j.f(str2, "classPath");
        j.f(str3, "desc");
        this.providerType = str;
        this.classPath = str2;
        this.desc = str3;
    }

    public static /* synthetic */ AdProviderEntity copy$default(AdProviderEntity adProviderEntity, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adProviderEntity.providerType;
        }
        if ((i2 & 2) != 0) {
            str2 = adProviderEntity.classPath;
        }
        if ((i2 & 4) != 0) {
            str3 = adProviderEntity.desc;
        }
        return adProviderEntity.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProviderType() {
        return this.providerType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClassPath() {
        return this.classPath;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final AdProviderEntity copy(@NotNull String providerType, @NotNull String classPath, @NotNull String desc) {
        j.f(providerType, "providerType");
        j.f(classPath, "classPath");
        j.f(desc, "desc");
        return new AdProviderEntity(providerType, classPath, desc);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdProviderEntity)) {
            return false;
        }
        AdProviderEntity adProviderEntity = (AdProviderEntity) other;
        return j.a(this.providerType, adProviderEntity.providerType) && j.a(this.classPath, adProviderEntity.classPath) && j.a(this.desc, adProviderEntity.desc);
    }

    @NotNull
    public final String getClassPath() {
        return this.classPath;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getProviderType() {
        return this.providerType;
    }

    public int hashCode() {
        String str = this.providerType;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.classPath;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.desc;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("AdProviderEntity(providerType=");
        sbR.append(this.providerType);
        sbR.append(", classPath='");
        sbR.append(this.classPath);
        sbR.append("', desc='");
        return a.p(sbR, this.desc, "')");
    }

    public /* synthetic */ AdProviderEntity(String str, String str2, String str3, int i2, f fVar) {
        this(str, str2, (i2 & 4) != 0 ? str2 : str3);
    }
}
