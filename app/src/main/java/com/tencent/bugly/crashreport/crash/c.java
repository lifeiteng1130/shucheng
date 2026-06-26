package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class c implements Parcelable.Creator<CrashDetailBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CrashDetailBean createFromParcel(Parcel parcel) {
        return new CrashDetailBean(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CrashDetailBean[] newArray(int i2) {
        return new CrashDetailBean[i2];
    }
}
