package com.qq.e.ads;

import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownAPPConfirmPolicy f2643f;

    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(T t) {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f2643f;
        if (downAPPConfirmPolicy != null) {
            setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    @Deprecated
    public void setBrowserType(BrowserType browserType) {
        GDTLogger.w("setBrowserType已废弃，调用无效");
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f2643f = downAPPConfirmPolicy;
        T t = this.a;
        if (t == null || downAPPConfirmPolicy == null) {
            return;
        }
        t.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
