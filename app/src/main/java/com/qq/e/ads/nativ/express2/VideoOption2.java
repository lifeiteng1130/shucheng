package com.qq.e.ads.nativ.express2;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class VideoOption2 {
    private AutoPlayPolicy a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2736e;

    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);

        public int a;

        AutoPlayPolicy(int i2) {
            this.a = i2;
        }

        public int getPolicy() {
            return this.a;
        }
    }

    public static class Builder {
        public AutoPlayPolicy a = AutoPlayPolicy.WIFI;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2738b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2739c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2741e;

        public VideoOption2 build() {
            return new VideoOption2(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f2738b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f2739c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f2740d = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f2741e = i2;
            return this;
        }
    }

    private VideoOption2(Builder builder) {
        this.a = builder.a;
        this.f2733b = builder.f2738b;
        this.f2734c = builder.f2739c;
        this.f2735d = builder.f2740d;
        this.f2736e = builder.f2741e;
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.a;
    }

    public int getMaxVideoDuration() {
        return this.f2735d;
    }

    public int getMinVideoDuration() {
        return this.f2736e;
    }

    public boolean isAutoPlayMuted() {
        return this.f2733b;
    }

    public boolean isDetailPageMuted() {
        return this.f2734c;
    }
}
