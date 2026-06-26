package com.efs.sdk.pa;

/* JADX INFO: loaded from: classes.dex */
public final class a implements PAANRListener {
    private PAFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PATraceListener f1872b;

    public a(PAFactory pAFactory) {
        this.a = pAFactory;
        this.f1872b = pAFactory.getTraceListener();
        boolean zEnableTracer = pAFactory.getConfigManager().enableTracer();
        if (zEnableTracer) {
            c.a(this.a, "patracepv", null);
        }
        PATraceListener pATraceListener = this.f1872b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(zEnableTracer);
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void anrStack(String str) {
        if (str == null || str.length() <= 200) {
            return;
        }
        c.a(this.a, "patrace", str);
        PATraceListener pATraceListener = this.f1872b;
        if (pATraceListener != null) {
            pATraceListener.onAnrTrace();
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void unexcept(Object obj) {
        PATraceListener pATraceListener = this.f1872b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
