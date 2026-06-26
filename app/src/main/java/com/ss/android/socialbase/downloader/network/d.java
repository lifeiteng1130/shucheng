package com.ss.android.socialbase.downloader.network;

/* JADX INFO: compiled from: ExponentialGeometricAverage.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private final double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f3901c = -1.0d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3902d;

    public d(double d2) {
        this.a = d2;
        this.f3900b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public void a(double d2) {
        double d3 = 1.0d - this.a;
        int i2 = this.f3902d;
        if (i2 > this.f3900b) {
            this.f3901c = Math.exp((Math.log(d2) * this.a) + (Math.log(this.f3901c) * d3));
        } else if (i2 > 0) {
            double d4 = (d3 * ((double) i2)) / (((double) i2) + 1.0d);
            this.f3901c = Math.exp((Math.log(d2) * (1.0d - d4)) + (Math.log(this.f3901c) * d4));
        } else {
            this.f3901c = d2;
        }
        this.f3902d++;
    }

    public double a() {
        return this.f3901c;
    }
}
