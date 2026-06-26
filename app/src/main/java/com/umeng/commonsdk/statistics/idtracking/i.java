package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManager;

/* JADX INFO: compiled from: OaidTracking.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends a {
    public static final String a = "umeng_sp_oaid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5304b = "key_umeng_sp_oaid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5305c = "key_umeng_sp_oaid_required_time";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5306d = "oaid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f5307e;

    public i(Context context) {
        super(f5306d);
        this.f5307e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f5307e.getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f5304b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
