package io.legado.app.model;

import androidx.media2.session.SessionCommand;
import e.a.a.c.a;
import f.c0.c.j;
import f.g;
import f.x.e;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AdsConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\bS\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\be\u0010fR>\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R>\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R>\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010 \u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R>\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0007\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR\u001c\u0010%\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001c\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018R\u001c\u00101\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010R\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010*\u001a\u0004\b4\u0010,\"\u0004\b5\u0010.R\u001c\u00106\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b7\u0010\u0018R>\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0007\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\u000bR\u001c\u0010;\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b;\u0010\u000e\u001a\u0004\b<\u0010\u0010R\u001c\u0010=\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b=\u0010\u0016\u001a\u0004\b>\u0010\u0018R\u001c\u0010?\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b?\u0010\u0016\u001a\u0004\b@\u0010\u0018R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010*\u001a\u0004\bB\u0010,\"\u0004\bC\u0010.R\u001c\u0010D\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bD\u0010\u000e\u001a\u0004\bE\u0010\u0010R\u001c\u0010F\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bF\u0010\u0016\u001a\u0004\bG\u0010\u0018R\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010*\u001a\u0004\bI\u0010,\"\u0004\bJ\u0010.R\u001c\u0010K\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bK\u0010\u000e\u001a\u0004\bL\u0010\u0010R\"\u0010M\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010\u000e\u001a\u0004\bN\u0010\u0010\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bQ\u0010\u000e\u001a\u0004\bR\u0010\u0010R\u001c\u0010S\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bS\u0010\u000e\u001a\u0004\bT\u0010\u0010R\u001c\u0010U\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bU\u0010\u000e\u001a\u0004\bV\u0010\u0010R\u001c\u0010W\u001a\u00020\u00038\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001c\u0010[\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b[\u0010\u000e\u001a\u0004\b\\\u0010\u0010R\"\u0010]\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010*\u001a\u0004\b^\u0010,\"\u0004\b_\u0010.R\u001c\u0010`\u001a\u00020\f8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b`\u0010\u000e\u001a\u0004\ba\u0010\u0010R>\u0010b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010\u0007\u001a\u0004\bc\u0010\t\"\u0004\bd\u0010\u000b¨\u0006g"}, d2 = {"Lio/legado/app/model/AdsConfig;", "", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "adsWeight", "Ljava/util/LinkedHashMap;", "getAdsWeight", "()Ljava/util/LinkedHashMap;", "setAdsWeight", "(Ljava/util/LinkedHashMap;)V", "", "enableContentSearch", "Z", "getEnableContentSearch", "()Z", "splashWeight", "getSplashWeight", "setSplashWeight", "", "installInfoTime", "J", "getInstallInfoTime", "()J", "installShelfTime", "getInstallShelfTime", "readWeight", "getReadWeight", "setReadWeight", "enableBook", "getEnableBook", "rewardTime", "getRewardTime", "readBannerWeight", "getReadBannerWeight", "setReadBannerWeight", "installCacheTime", "getInstallCacheTime", "enableAds", "getEnableAds", "searcherRange", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getSearcherRange", "()I", "setSearcherRange", "(I)V", "hotSplashTime", "getHotSplashTime", "enableReward", "getEnableReward", "infoRange", "getInfoRange", "setInfoRange", "installRewardTime", "getInstallRewardTime", "cacheWeight", "getCacheWeight", "setCacheWeight", "mustReward", "getMustReward", "installSplashTime", "getInstallSplashTime", "installSearchTime", "getInstallSearchTime", "shelfRange", "getShelfRange", "setShelfRange", "enableSearch", "getEnableSearch", "installBookTime", "getInstallBookTime", "contentSearcherRange", "getContentSearcherRange", "setContentSearcherRange", "enableShelf", "getEnableShelf", "refreshBanner", "getRefreshBanner", "setRefreshBanner", "(Z)V", "enableInfo", "getEnableInfo", "enableBookBanner", "getEnableBookBanner", "enableHotSplash", "getEnableHotSplash", "rewardContent", "Ljava/lang/String;", "getRewardContent", "()Ljava/lang/String;", "enableCache", "getEnableCache", "bannerRefreshTime", "getBannerRefreshTime", "setBannerRefreshTime", "enableSplash", "getEnableSplash", "rewardWeight", "getRewardWeight", "setRewardWeight", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AdsConfig {

    @NotNull
    private LinkedHashMap<String, Integer> adsWeight;
    private int bannerRefreshTime;

    @NotNull
    private LinkedHashMap<String, Integer> cacheWeight;
    private int contentSearcherRange;
    private final boolean enableAds;
    private final boolean enableBook;
    private final boolean enableBookBanner;
    private final boolean enableCache;
    private final boolean enableContentSearch;
    private final boolean enableHotSplash;
    private final boolean enableInfo;
    private final boolean enableReward;
    private final boolean enableSearch;
    private final boolean enableShelf;
    private final boolean enableSplash;
    private final long hotSplashTime;
    private int infoRange;
    private final long installBookTime;
    private final long installCacheTime;
    private final long installInfoTime;
    private final long installRewardTime;
    private final long installSearchTime;
    private final long installShelfTime;
    private final long installSplashTime;
    private final boolean mustReward;

    @NotNull
    private LinkedHashMap<String, Integer> readBannerWeight;

    @NotNull
    private LinkedHashMap<String, Integer> readWeight;
    private boolean refreshBanner;

    @NotNull
    private final String rewardContent;
    private final long rewardTime;

    @NotNull
    private LinkedHashMap<String, Integer> rewardWeight;
    private int searcherRange;
    private int shelfRange;

    @NotNull
    private LinkedHashMap<String, Integer> splashWeight;

    public AdsConfig() {
        a aVar = a.GDT;
        a aVar2 = a.CSJ;
        a aVar3 = a.BAIDU;
        this.adsWeight = e.t(new g(aVar.getType(), 1), new g(aVar2.getType(), 1), new g(aVar3.getType(), 0));
        this.installSplashTime = 86400L;
        this.hotSplashTime = 300L;
        this.splashWeight = e.t(new g(aVar.getType(), 1), new g(aVar2.getType(), 1), new g(aVar3.getType(), 0));
        this.installBookTime = 864000L;
        this.readWeight = e.t(new g(aVar.getType(), 1), new g(aVar2.getType(), 1), new g(aVar3.getType(), 0));
        this.bannerRefreshTime = SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME;
        this.readBannerWeight = e.t(new g(aVar.getType(), 1), new g(aVar2.getType(), 1), new g(aVar3.getType(), 0));
        this.rewardContent = "亲，您已经累计看了一个小时的书，我们看个广告休息一下吧";
        this.rewardTime = 3600L;
        this.installRewardTime = 43200L;
        this.rewardWeight = e.t(new g(aVar.getType(), 1), new g(aVar2.getType(), 1), new g(aVar3.getType(), 0));
        this.installCacheTime = 86400L;
        this.searcherRange = 100;
        this.contentSearcherRange = 50;
        this.installSearchTime = 86400L;
        this.infoRange = 100;
        this.installInfoTime = 86400L;
        this.shelfRange = 100;
        this.installShelfTime = 86400L;
        this.cacheWeight = e.t(new g(aVar.getType(), 1), new g(aVar2.getType(), 1), new g(aVar3.getType(), 0));
    }

    @NotNull
    public final LinkedHashMap<String, Integer> getAdsWeight() {
        return this.adsWeight;
    }

    public final int getBannerRefreshTime() {
        return this.bannerRefreshTime;
    }

    @NotNull
    public final LinkedHashMap<String, Integer> getCacheWeight() {
        return this.cacheWeight;
    }

    public final int getContentSearcherRange() {
        return this.contentSearcherRange;
    }

    public final boolean getEnableAds() {
        return false; // AD REMOVED: force disable all ads
    }

    public final boolean getEnableBook() {
        return false; // AD REMOVED
    }

    public final boolean getEnableBookBanner() {
        return false; // AD REMOVED
    }

    public final boolean getEnableCache() {
        return false; // AD REMOVED
    }

    public final boolean getEnableContentSearch() {
        return false; // AD REMOVED
    }

    public final boolean getEnableHotSplash() {
        return false; // AD REMOVED
    }

    public final boolean getEnableInfo() {
        return false; // AD REMOVED
    }

    public final boolean getEnableReward() {
        return false; // AD REMOVED: disable reward ads
    }

    public final boolean getEnableSearch() {
        return false; // AD REMOVED
    }

    public final boolean getEnableShelf() {
        return false; // AD REMOVED
    }

    public final boolean getEnableSplash() {
        return false; // AD REMOVED: disable splash ads
    }

    public final long getHotSplashTime() {
        return this.hotSplashTime;
    }

    public final int getInfoRange() {
        return this.infoRange;
    }

    public final long getInstallBookTime() {
        return this.installBookTime;
    }

    public final long getInstallCacheTime() {
        return this.installCacheTime;
    }

    public final long getInstallInfoTime() {
        return this.installInfoTime;
    }

    public final long getInstallRewardTime() {
        return this.installRewardTime;
    }

    public final long getInstallSearchTime() {
        return this.installSearchTime;
    }

    public final long getInstallShelfTime() {
        return this.installShelfTime;
    }

    public final long getInstallSplashTime() {
        return this.installSplashTime;
    }

    public final boolean getMustReward() {
        return false; // AD REMOVED: never force reward
    }

    @NotNull
    public final LinkedHashMap<String, Integer> getReadBannerWeight() {
        return this.readBannerWeight;
    }

    @NotNull
    public final LinkedHashMap<String, Integer> getReadWeight() {
        return this.readWeight;
    }

    public final boolean getRefreshBanner() {
        return this.refreshBanner;
    }

    @NotNull
    public final String getRewardContent() {
        return this.rewardContent;
    }

    public final long getRewardTime() {
        return this.rewardTime;
    }

    @NotNull
    public final LinkedHashMap<String, Integer> getRewardWeight() {
        return this.rewardWeight;
    }

    public final int getSearcherRange() {
        return this.searcherRange;
    }

    public final int getShelfRange() {
        return this.shelfRange;
    }

    @NotNull
    public final LinkedHashMap<String, Integer> getSplashWeight() {
        return this.splashWeight;
    }

    public final void setAdsWeight(@NotNull LinkedHashMap<String, Integer> linkedHashMap) {
        j.e(linkedHashMap, "<set-?>");
        this.adsWeight = linkedHashMap;
    }

    public final void setBannerRefreshTime(int i2) {
        this.bannerRefreshTime = i2;
    }

    public final void setCacheWeight(@NotNull LinkedHashMap<String, Integer> linkedHashMap) {
        j.e(linkedHashMap, "<set-?>");
        this.cacheWeight = linkedHashMap;
    }

    public final void setContentSearcherRange(int i2) {
        this.contentSearcherRange = i2;
    }

    public final void setInfoRange(int i2) {
        this.infoRange = i2;
    }

    public final void setReadBannerWeight(@NotNull LinkedHashMap<String, Integer> linkedHashMap) {
        j.e(linkedHashMap, "<set-?>");
        this.readBannerWeight = linkedHashMap;
    }

    public final void setReadWeight(@NotNull LinkedHashMap<String, Integer> linkedHashMap) {
        j.e(linkedHashMap, "<set-?>");
        this.readWeight = linkedHashMap;
    }

    public final void setRefreshBanner(boolean z) {
        this.refreshBanner = z;
    }

    public final void setRewardWeight(@NotNull LinkedHashMap<String, Integer> linkedHashMap) {
        j.e(linkedHashMap, "<set-?>");
        this.rewardWeight = linkedHashMap;
    }

    public final void setSearcherRange(int i2) {
        this.searcherRange = i2;
    }

    public final void setShelfRange(int i2) {
        this.shelfRange = i2;
    }

    public final void setSplashWeight(@NotNull LinkedHashMap<String, Integer> linkedHashMap) {
        j.e(linkedHashMap, "<set-?>");
        this.splashWeight = linkedHashMap;
    }
}
