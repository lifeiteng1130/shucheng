package io.legado.app.data.entities;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AppUpgrade.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)¨\u0006/"}, d2 = {"Lio/legado/app/data/entities/AppUpgrade;", "", "", "whiteMessage", "Ljava/lang/String;", "getWhiteMessage", "()Ljava/lang/String;", "setWhiteMessage", "(Ljava/lang/String;)V", "upgradeContent", "getUpgradeContent", "setUpgradeContent", "upgradeUrl", "getUpgradeUrl", "setUpgradeUrl", "", "", "whiteList", "Ljava/util/List;", "getWhiteList", "()Ljava/util/List;", "setWhiteList", "(Ljava/util/List;)V", "versionCode", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getVersionCode", "()I", "setVersionCode", "(I)V", "versionName", "getVersionName", "setVersionName", "upgradeTitle", "getUpgradeTitle", "setUpgradeTitle", "", "enableWhite", "Z", "getEnableWhite", "()Z", "setEnableWhite", "(Z)V", "forceUpgrade", "getForceUpgrade", "setForceUpgrade", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AppUpgrade {
    private boolean enableWhite;
    private boolean forceUpgrade;

    @Nullable
    private String upgradeContent;

    @Nullable
    private String upgradeTitle;

    @Nullable
    private String upgradeUrl;
    private int versionCode;

    @Nullable
    private String versionName;

    @Nullable
    private List<Integer> whiteList;

    @Nullable
    private String whiteMessage;

    public final boolean getEnableWhite() {
        return this.enableWhite;
    }

    public final boolean getForceUpgrade() {
        return this.forceUpgrade;
    }

    @Nullable
    public final String getUpgradeContent() {
        return this.upgradeContent;
    }

    @Nullable
    public final String getUpgradeTitle() {
        return this.upgradeTitle;
    }

    @Nullable
    public final String getUpgradeUrl() {
        return this.upgradeUrl;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @Nullable
    public final String getVersionName() {
        return this.versionName;
    }

    @Nullable
    public final List<Integer> getWhiteList() {
        return this.whiteList;
    }

    @Nullable
    public final String getWhiteMessage() {
        return this.whiteMessage;
    }

    public final void setEnableWhite(boolean z) {
        this.enableWhite = z;
    }

    public final void setForceUpgrade(boolean z) {
        this.forceUpgrade = z;
    }

    public final void setUpgradeContent(@Nullable String str) {
        this.upgradeContent = str;
    }

    public final void setUpgradeTitle(@Nullable String str) {
        this.upgradeTitle = str;
    }

    public final void setUpgradeUrl(@Nullable String str) {
        this.upgradeUrl = str;
    }

    public final void setVersionCode(int i2) {
        this.versionCode = i2;
    }

    public final void setVersionName(@Nullable String str) {
        this.versionName = str;
    }

    public final void setWhiteList(@Nullable List<Integer> list) {
        this.whiteList = list;
    }

    public final void setWhiteMessage(@Nullable String str) {
        this.whiteMessage = str;
    }
}
