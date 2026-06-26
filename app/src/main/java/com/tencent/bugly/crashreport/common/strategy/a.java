package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a implements Parcelable.Creator<StrategyBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StrategyBean createFromParcel(Parcel parcel) {
        return new StrategyBean(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StrategyBean[] newArray(int i2) {
        return new StrategyBean[i2];
    }
}
