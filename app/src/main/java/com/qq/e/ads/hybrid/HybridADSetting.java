package com.qq.e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HybridADSetting implements Parcelable {
    public static final Parcelable.Creator<HybridADSetting> CREATOR = new Parcelable.Creator<HybridADSetting>() { // from class: com.qq.e.ads.hybrid.HybridADSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HybridADSetting createFromParcel(Parcel parcel) {
            return new HybridADSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HybridADSetting[] newArray(int i2) {
            return new HybridADSetting[i2];
        }
    };
    public static final int TYPE_REWARD_VIDEO = 1;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2686j;

    public HybridADSetting() {
        this.a = 1;
        this.f2678b = 44;
        this.f2679c = -1;
        this.f2680d = -14013133;
        this.f2681e = 16;
        this.f2685i = -1776153;
        this.f2686j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.a = 1;
        this.f2678b = 44;
        this.f2679c = -1;
        this.f2680d = -14013133;
        this.f2681e = 16;
        this.f2685i = -1776153;
        this.f2686j = 16;
        this.a = parcel.readInt();
        this.f2678b = parcel.readInt();
        this.f2679c = parcel.readInt();
        this.f2680d = parcel.readInt();
        this.f2681e = parcel.readInt();
        this.f2682f = parcel.readString();
        this.f2683g = parcel.readString();
        this.f2684h = parcel.readString();
        this.f2685i = parcel.readInt();
        this.f2686j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f2683g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.f2686j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f2684h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f2683g;
    }

    public int getBackSeparatorLength() {
        return this.f2686j;
    }

    public String getCloseButtonImage() {
        return this.f2684h;
    }

    public int getSeparatorColor() {
        return this.f2685i;
    }

    public String getTitle() {
        return this.f2682f;
    }

    public int getTitleBarColor() {
        return this.f2679c;
    }

    public int getTitleBarHeight() {
        return this.f2678b;
    }

    public int getTitleColor() {
        return this.f2680d;
    }

    public int getTitleSize() {
        return this.f2681e;
    }

    public int getType() {
        return this.a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f2685i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f2682f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f2679c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.f2678b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f2680d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f2681e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.a = i2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f2678b);
        parcel.writeInt(this.f2679c);
        parcel.writeInt(this.f2680d);
        parcel.writeInt(this.f2681e);
        parcel.writeString(this.f2682f);
        parcel.writeString(this.f2683g);
        parcel.writeString(this.f2684h);
        parcel.writeInt(this.f2685i);
        parcel.writeInt(this.f2686j);
    }
}
