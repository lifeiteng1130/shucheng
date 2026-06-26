package io.legado.app.data.entities;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AppVersionConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b¨\u00063"}, d2 = {"Lio/legado/app/data/entities/AppVersionConfig;", "", "", "switchName", "Ljava/lang/String;", "getSwitchName", "()Ljava/lang/String;", "setSwitchName", "(Ljava/lang/String;)V", "", "adsCode", "Ljava/lang/Integer;", "getAdsCode", "()Ljava/lang/Integer;", "setAdsCode", "(Ljava/lang/Integer;)V", "invalidSourceName", "getInvalidSourceName", "setInvalidSourceName", "sourceName", "getSourceName", "setSourceName", "invalidSourceCode", "getInvalidSourceCode", "setInvalidSourceCode", "upgradeName", "getUpgradeName", "setUpgradeName", "sourceCode", "getSourceCode", "setSourceCode", "switchCode", "getSwitchCode", "setSwitchCode", "", "isAppOpen", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setAppOpen", "(Ljava/lang/Boolean;)V", "adsName", "getAdsName", "setAdsName", "upgradeCode", "getUpgradeCode", "setUpgradeCode", TTDownloadField.TT_DOWNLOAD_URL, "getDownloadUrl", "setDownloadUrl", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AppVersionConfig {

    @Nullable
    private Integer adsCode;

    @Nullable
    private String adsName;

    @Nullable
    private Integer invalidSourceCode;

    @Nullable
    private String invalidSourceName;

    @Nullable
    private Integer sourceCode;

    @Nullable
    private String sourceName;

    @Nullable
    private Integer switchCode;

    @Nullable
    private String switchName;

    @Nullable
    private Integer upgradeCode;

    @Nullable
    private String upgradeName;

    @Nullable
    private Boolean isAppOpen = Boolean.TRUE;

    @Nullable
    private String downloadUrl = "";

    @Nullable
    public final Integer getAdsCode() {
        return this.adsCode;
    }

    @Nullable
    public final String getAdsName() {
        return this.adsName;
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Nullable
    public final Integer getInvalidSourceCode() {
        return this.invalidSourceCode;
    }

    @Nullable
    public final String getInvalidSourceName() {
        return this.invalidSourceName;
    }

    @Nullable
    public final Integer getSourceCode() {
        return this.sourceCode;
    }

    @Nullable
    public final String getSourceName() {
        return this.sourceName;
    }

    @Nullable
    public final Integer getSwitchCode() {
        return this.switchCode;
    }

    @Nullable
    public final String getSwitchName() {
        return this.switchName;
    }

    @Nullable
    public final Integer getUpgradeCode() {
        return this.upgradeCode;
    }

    @Nullable
    public final String getUpgradeName() {
        return this.upgradeName;
    }

    @Nullable
    /* JADX INFO: renamed from: isAppOpen, reason: from getter */
    public final Boolean getIsAppOpen() {
        return this.isAppOpen;
    }

    public final void setAdsCode(@Nullable Integer num) {
        this.adsCode = num;
    }

    public final void setAdsName(@Nullable String str) {
        this.adsName = str;
    }

    public final void setAppOpen(@Nullable Boolean bool) {
        this.isAppOpen = bool;
    }

    public final void setDownloadUrl(@Nullable String str) {
        this.downloadUrl = str;
    }

    public final void setInvalidSourceCode(@Nullable Integer num) {
        this.invalidSourceCode = num;
    }

    public final void setInvalidSourceName(@Nullable String str) {
        this.invalidSourceName = str;
    }

    public final void setSourceCode(@Nullable Integer num) {
        this.sourceCode = num;
    }

    public final void setSourceName(@Nullable String str) {
        this.sourceName = str;
    }

    public final void setSwitchCode(@Nullable Integer num) {
        this.switchCode = num;
    }

    public final void setSwitchName(@Nullable String str) {
        this.switchName = str;
    }

    public final void setUpgradeCode(@Nullable Integer num) {
        this.upgradeCode = num;
    }

    public final void setUpgradeName(@Nullable String str) {
        this.upgradeName = str;
    }
}
