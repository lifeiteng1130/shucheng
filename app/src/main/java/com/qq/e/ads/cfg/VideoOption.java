package com.qq.e.ads.cfg;

import c.a.a.a.a;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class VideoOption {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f2660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f2661g;

    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {
        private boolean a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2662b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2663c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2664d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2665e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2666f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f2667g = false;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.a = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                i2 = 1;
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
            }
            this.f2662b = i2;
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f2667g = z;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.f2665e = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.f2666f = z;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.f2664d = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.f2663c = z;
            return this;
        }
    }

    @Deprecated
    public static final class VideoADContainerRender {
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
    }

    @Deprecated
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    private VideoOption(Builder builder) {
        this.a = builder.a;
        this.f2656b = builder.f2662b;
        this.f2657c = builder.f2663c;
        this.f2658d = builder.f2664d;
        this.f2659e = builder.f2665e;
        this.f2660f = builder.f2666f;
        this.f2661g = builder.f2667g;
    }

    public boolean getAutoPlayMuted() {
        return this.a;
    }

    public int getAutoPlayPolicy() {
        return this.f2656b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f2656b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f2661g));
        } catch (Exception e2) {
            StringBuilder sbR = a.r("Get video options error: ");
            sbR.append(e2.getMessage());
            GDTLogger.d(sbR.toString());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f2661g;
    }

    public boolean isEnableDetailPage() {
        return this.f2659e;
    }

    public boolean isEnableUserControl() {
        return this.f2660f;
    }

    public boolean isNeedCoverImage() {
        return this.f2658d;
    }

    public boolean isNeedProgressBar() {
        return this.f2657c;
    }
}
