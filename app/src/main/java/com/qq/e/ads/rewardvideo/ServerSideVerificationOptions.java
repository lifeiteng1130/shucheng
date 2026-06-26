package com.qq.e.ads.rewardvideo;

/* JADX INFO: loaded from: classes.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2750b;

    public static class Builder {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2751b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f2751b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.a = builder.a;
        this.f2750b = builder.f2751b;
    }

    public String getCustomData() {
        return this.a;
    }

    public String getUserId() {
        return this.f2750b;
    }
}
