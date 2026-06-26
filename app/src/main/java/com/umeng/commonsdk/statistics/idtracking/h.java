package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.analytics.pro.ai;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;

/* JADX INFO: compiled from: NewUMIDTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends a {
    private static final String a = "newumid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5303b;

    public h(Context context) {
        super(a);
        this.f5303b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return UMEnvelopeBuild.imprintProperty(this.f5303b, ai.f4653g, null);
    }
}
