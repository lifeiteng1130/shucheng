package com.ss.android.socialbase.downloader.f;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: SegmentStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    private final JSONObject a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3666b;

    private n(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    private int p() {
        return this.a.optInt("url_balance", 2);
    }

    public void a(int i2) {
        this.f3666b = b(i2);
    }

    public boolean b() {
        return p() > 0;
    }

    public boolean c() {
        return p() == 1;
    }

    public int d() {
        return this.a.optInt("buffer_count", 512);
    }

    public int e() {
        return this.a.optInt("buffer_size", 8192);
    }

    public boolean f() {
        return this.a.optInt("segment_mode", 1) == 0;
    }

    public long g() {
        long jOptInt = ((long) this.a.optInt("segment_min_kb", 512)) * 1024;
        return jOptInt < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : jOptInt;
    }

    public long h() {
        long jOptInt = ((long) this.a.optInt("segment_min_init_mb", 10)) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public long i() {
        long jOptInt = ((long) this.a.optInt("segment_max_kb", 0)) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (jOptInt < g()) {
            return -1L;
        }
        return jOptInt;
    }

    public long j() {
        long jOptInt = this.a.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public long k() {
        long jOptInt = this.a.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public int l() {
        return this.a.optInt("ip_strategy", 0);
    }

    public float m() {
        return (float) this.a.optDouble("main_ratio", 0.0d);
    }

    public int n() {
        return this.a.optInt("ratio_segment", 0);
    }

    public float o() {
        return Math.min(Math.max(0.0f, (float) this.a.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    private int b(int i2) {
        int iOptInt = this.a.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return p() == 1 ? Math.min(iOptInt, i2) : iOptInt;
        }
        if (p() > 0) {
            return i2;
        }
        return 1;
    }

    public int a() {
        return this.f3666b;
    }

    @NonNull
    public static n a(@NonNull JSONObject jSONObject) {
        return new n(jSONObject);
    }
}
