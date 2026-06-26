package com.tencent.bugly.beta.global;

import android.os.Parcel;
import android.os.Parcelable;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class ResBean implements Parcelable, Parcelable.Creator<ResBean> {
    public static ResBean a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f3977c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3978d = "#273238";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3979e = "#757575";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f3976b = {"IMG_title", "VAL_style", "tacticsSource", "h5"};
    public static final Parcelable.Creator<ResBean> CREATOR = new ResBean();

    public ResBean() {
    }

    public String a(String str) {
        return this.f3977c.get(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ResBean[] newArray(int i2) {
        return new ResBean[0];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        for (String str : f3976b) {
            parcel.writeString(this.f3977c.get(str));
        }
    }

    public void a(String str, Object obj) {
        if (obj instanceof String) {
            this.f3977c.put(str, (String) obj);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ResBean createFromParcel(Parcel parcel) {
        return new ResBean(parcel);
    }

    public ResBean(Parcel parcel) {
        try {
            for (String str : f3976b) {
                this.f3977c.put(str, parcel.readString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
