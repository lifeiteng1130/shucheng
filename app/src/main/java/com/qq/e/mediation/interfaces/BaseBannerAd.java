package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.view.View;
import com.qq.e.ads.banner2.UnifiedBannerADListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBannerAd {
    public BaseBannerAd(Activity activity, String str, String str2, String str3) {
    }

    public abstract void destroy();

    public abstract View getAdView();

    public abstract int getECPM();

    public abstract void loadAD();

    public abstract void setAdListener(UnifiedBannerADListener unifiedBannerADListener);

    public abstract void setAdSize(int i2, int i3);
}
