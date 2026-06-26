package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes.dex */
public class TTLocation implements LocationProvider {
    private double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f1667b;

    public TTLocation(double d2, double d3) {
        this.a = 0.0d;
        this.f1667b = 0.0d;
        this.a = d2;
        this.f1667b = d3;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.f1667b;
    }

    public void setLatitude(double d2) {
        this.a = d2;
    }

    public void setLongitude(double d2) {
        this.f1667b = d2;
    }
}
