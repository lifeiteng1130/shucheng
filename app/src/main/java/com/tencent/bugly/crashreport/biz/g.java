package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class g implements Parcelable.Creator<UserInfoBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public UserInfoBean createFromParcel(Parcel parcel) {
        return new UserInfoBean(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public UserInfoBean[] newArray(int i2) {
        return new UserInfoBean[i2];
    }
}
