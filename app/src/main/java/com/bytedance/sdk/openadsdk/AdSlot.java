package com.bytedance.sdk.openadsdk;

import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.api.b.d;
import org.json.JSONObject;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
public class AdSlot implements TTAdSlot {
    private TTAdLoadType A;
    private int B;
    private int C;
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f1623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f1628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f1630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f1631l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private int[] r;
    private String s;
    private int t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public static class Builder {
        private String A;
        private String B;
        private String a;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f1639i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f1642l;
        private String m;
        private int n;
        private float o;
        private float p;
        private int[] r;
        private int s;
        private String t;
        private String u;
        private String v;
        private String z;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1632b = 640;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1633c = 320;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1634d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1635e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1636f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f1637g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1638h = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f1640j = "defaultUser";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f1641k = 2;
        private boolean q = true;
        private int w = 1;
        private int x = 0;
        private TTAdLoadType y = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.a = this.a;
            adSlot.f1625f = this.f1636f;
            adSlot.f1626g = this.f1634d;
            adSlot.f1627h = this.f1635e;
            adSlot.f1621b = this.f1632b;
            adSlot.f1622c = this.f1633c;
            float f2 = this.o;
            if (f2 <= 0.0f) {
                adSlot.f1623d = this.f1632b;
                adSlot.f1624e = this.f1633c;
            } else {
                adSlot.f1623d = f2;
                adSlot.f1624e = this.p;
            }
            adSlot.f1628i = this.f1637g;
            adSlot.f1629j = this.f1638h;
            adSlot.f1630k = this.f1639i;
            adSlot.f1631l = this.f1640j;
            adSlot.m = this.f1641k;
            adSlot.o = this.f1642l;
            adSlot.q = this.q;
            adSlot.r = this.r;
            adSlot.t = this.s;
            adSlot.u = this.t;
            adSlot.s = this.m;
            adSlot.w = this.z;
            adSlot.x = this.A;
            adSlot.y = this.B;
            adSlot.n = this.n;
            adSlot.v = this.u;
            adSlot.z = this.v;
            adSlot.A = this.y;
            adSlot.B = this.w;
            adSlot.C = this.x;
            return adSlot;
        }

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
                d.b(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            }
            if (i2 > 20) {
                d.b(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i2 = 20;
            }
            this.f1636f = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.z = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.y = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i2) {
            this.n = i2;
            return this;
        }

        public Builder setAdloadSeq(int i2) {
            this.s = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.a = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.A = str;
            return this;
        }

        public Builder setDownloadType(int i2) {
            if (i2 != 1) {
                i2 = 0;
            }
            this.x = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.o = f2;
            this.p = f3;
            return this;
        }

        public Builder setExt(String str) {
            this.B = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.r = iArr;
            return this;
        }

        public Builder setExtraParam(String str) {
            this.m = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.f1632b = i2;
            this.f1633c = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f1639i = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.f1642l = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.f1641k = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.t = str;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.f1638h = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f1637g = str;
            return this;
        }

        public Builder setSplashButtonType(int i2) {
            if (i2 != 2) {
                i2 = 1;
            }
            this.w = i2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f1634d = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.v = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f1640j = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.f1635e = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.u = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdCount() {
        return this.f1625f;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getAdId() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public TTAdLoadType getAdLoadType() {
        return this.A;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdType() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdloadSeq() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getBidAdm() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCodeId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCreativeId() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDownloadType() {
        return this.C;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDurationSlotType() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedHeight() {
        return this.f1624e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.f1623d;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExt() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int[] getExternalABVid() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExtraSmartLookParam() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedHeight() {
        return this.f1622c;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.f1621b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        return this.f1630k;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getNativeAdType() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getOrientation() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getPrimeRit() {
        String str = this.u;
        return str == null ? "" : str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getRewardAmount() {
        return this.f1629j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getRewardName() {
        return this.f1628i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getSplashButtonType() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserData() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserID() {
        return this.f1631l;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isAutoPlay() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportDeepLink() {
        return this.f1626g;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.f1627h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i2) {
        this.f1625f = i2;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.A = tTAdLoadType;
    }

    public void setDownloadType(int i2) {
        this.C = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i2) {
        this.p = i2;
    }

    public void setExternalABVid(int... iArr) {
        this.r = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i2) {
        this.o = i2;
    }

    public void setSplashButtonType(int i2) {
        this.B = i2;
    }

    public void setUserData(String str) {
        this.z = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.a);
            jSONObject.put("mIsAutoPlay", this.q);
            jSONObject.put("mImgAcceptedWidth", this.f1621b);
            jSONObject.put("mImgAcceptedHeight", this.f1622c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f1623d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f1624e);
            jSONObject.put("mAdCount", this.f1625f);
            jSONObject.put("mSupportDeepLink", this.f1626g);
            jSONObject.put("mSupportRenderControl", this.f1627h);
            jSONObject.put("mRewardName", this.f1628i);
            jSONObject.put("mRewardAmount", this.f1629j);
            jSONObject.put("mMediaExtra", this.f1630k);
            jSONObject.put("mUserID", this.f1631l);
            jSONObject.put("mOrientation", this.m);
            jSONObject.put("mNativeAdType", this.o);
            jSONObject.put("mAdloadSeq", this.t);
            jSONObject.put("mPrimeRit", this.u);
            jSONObject.put("mExtraSmartLookParam", this.s);
            jSONObject.put("mAdId", this.w);
            jSONObject.put("mCreativeId", this.x);
            jSONObject.put("mExt", this.y);
            jSONObject.put("mBidAdm", this.v);
            jSONObject.put("mUserData", this.z);
            jSONObject.put("mAdLoadType", this.A);
            jSONObject.put("mSplashButtonType", this.B);
            jSONObject.put("mDownloadType", this.C);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sbR = a.r("AdSlot{mCodeId='");
        a.y(sbR, this.a, '\'', ", mImgAcceptedWidth=");
        sbR.append(this.f1621b);
        sbR.append(", mImgAcceptedHeight=");
        sbR.append(this.f1622c);
        sbR.append(", mExpressViewAcceptedWidth=");
        sbR.append(this.f1623d);
        sbR.append(", mExpressViewAcceptedHeight=");
        sbR.append(this.f1624e);
        sbR.append(", mAdCount=");
        sbR.append(this.f1625f);
        sbR.append(", mSupportDeepLink=");
        sbR.append(this.f1626g);
        sbR.append(", mSupportRenderControl=");
        sbR.append(this.f1627h);
        sbR.append(", mRewardName='");
        a.y(sbR, this.f1628i, '\'', ", mRewardAmount=");
        sbR.append(this.f1629j);
        sbR.append(", mMediaExtra='");
        a.y(sbR, this.f1630k, '\'', ", mUserID='");
        a.y(sbR, this.f1631l, '\'', ", mOrientation=");
        sbR.append(this.m);
        sbR.append(", mNativeAdType=");
        sbR.append(this.o);
        sbR.append(", mIsAutoPlay=");
        sbR.append(this.q);
        sbR.append(", mPrimeRit");
        sbR.append(this.u);
        sbR.append(", mAdloadSeq");
        sbR.append(this.t);
        sbR.append(", mAdId");
        sbR.append(this.w);
        sbR.append(", mCreativeId");
        sbR.append(this.x);
        sbR.append(", mExt");
        sbR.append(this.y);
        sbR.append(", mUserData");
        sbR.append(this.z);
        sbR.append(", mAdLoadType");
        sbR.append(this.A);
        sbR.append(", mSplashButtonType=");
        sbR.append(this.B);
        sbR.append(", mDownloadType=");
        return a.n(sbR, this.C, MessageFormatter.DELIM_STOP);
    }

    private AdSlot() {
        this.m = 2;
        this.q = true;
        this.B = 1;
        this.C = 0;
    }
}
