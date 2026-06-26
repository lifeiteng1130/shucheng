package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.AbstractC0320m;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.M;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BetaGrayStrategy implements Parcelable, Parcelable.Creator<BetaGrayStrategy> {
    public static final Parcelable.Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();
    public B a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4000e;

    public BetaGrayStrategy(Parcel parcel) {
        this.f3997b = 0;
        this.f3998c = -1L;
        this.f3999d = false;
        this.f4000e = -1L;
        this.a = (B) M.a(parcel.createByteArray(), B.class);
        this.f3997b = parcel.readInt();
        this.f3998c = parcel.readLong();
        this.f3999d = 1 == parcel.readByte();
        this.f4000e = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(M.a((AbstractC0320m) this.a));
        parcel.writeInt(this.f3997b);
        parcel.writeLong(this.f3998c);
        parcel.writeByte(this.f3999d ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f4000e);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BetaGrayStrategy createFromParcel(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BetaGrayStrategy[] newArray(int i2) {
        return new BetaGrayStrategy[i2];
    }

    public BetaGrayStrategy() {
        this.f3997b = 0;
        this.f3998c = -1L;
        this.f3999d = false;
        this.f4000e = -1L;
    }
}
