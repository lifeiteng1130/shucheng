package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC0320m;
import com.tencent.bugly.proguard.M;
import com.tencent.bugly.proguard.sa;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BetaUploadStrategy implements Parcelable, Parcelable.Creator<BetaUploadStrategy> {
    public static final Parcelable.Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();
    public sa a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4001b;

    public BetaUploadStrategy() {
        sa saVar = new sa();
        this.a = saVar;
        saVar.f4441e = true;
        saVar.f4442f = true;
        String str = StrategyBean.a;
        saVar.f4443g = str;
        saVar.f4444h = str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.a.f4447k = jCurrentTimeMillis;
        this.f4001b = jCurrentTimeMillis;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(M.a((AbstractC0320m) this.a));
        parcel.writeLong(this.f4001b);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BetaUploadStrategy createFromParcel(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BetaUploadStrategy[] newArray(int i2) {
        return new BetaUploadStrategy[i2];
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.a = (sa) M.a(parcel.createByteArray(), sa.class);
        this.f4001b = parcel.readLong();
    }
}
