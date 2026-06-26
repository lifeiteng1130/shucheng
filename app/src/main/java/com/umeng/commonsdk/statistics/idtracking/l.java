package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.config.FieldManager;

/* JADX INFO: compiled from: UTDIdTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends a {
    private static final String a = "utdid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5311b;

    public l(Context context) {
        super(a);
        this.f5311b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.u)) {
                return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", Context.class).invoke(null, this.f5311b);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
