package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeExpressADCore extends LiteAbstractAD<NEADVI> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private NativeExpressMediaListener f2710i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final NEADI f2712k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final NEADVI f2713l;
    private final NativeExpressADData2 m;
    private ADSize n;
    public final JSONObject o;
    public final HashMap<String, Object> p;
    private NativeExpressADView q;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f2708g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f2709h = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f2711j = false;

    public NativeExpressADCore(NativeExpressADView nativeExpressADView, NEADI neadi, NEADVI neadvi, NativeExpressADData2 nativeExpressADData2, Context context, ADSize aDSize, String str, JSONObject jSONObject, HashMap map) {
        this.q = nativeExpressADView;
        this.f2712k = neadi;
        this.f2713l = neadvi;
        this.m = nativeExpressADData2;
        this.n = aDSize;
        this.o = jSONObject;
        this.p = map;
        a(context, str);
    }

    public NEADVI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADView(this.f2712k, this.f2713l, this.m, context, this.q, this.n, str, str2, this.o, this.p);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(context, pOFactory, str, str2);
    }

    public void a(NativeExpressMediaListener nativeExpressMediaListener) {
        this.f2710i = nativeExpressMediaListener;
        T t = this.a;
        if (t == 0 || nativeExpressMediaListener == null) {
            return;
        }
        ((NEADVI) t).setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
    }

    public void d() {
        NativeExpressMediaListener nativeExpressMediaListener = this.f2710i;
        if (nativeExpressMediaListener != null) {
            this.f2710i = nativeExpressMediaListener;
            T t = this.a;
            if (t != 0) {
                ((NEADVI) t).setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
            }
        }
        if (this.f2708g) {
            preloadVideo();
        }
        if (this.f2709h) {
            render();
        }
        if (this.f2711j) {
            negativeFeedback();
        }
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((NEADVI) t).destroy();
        }
    }

    public void negativeFeedback() {
        boolean z;
        if (b()) {
            T t = this.a;
            if (t == 0) {
                a("negativeFeedback");
                return;
            } else {
                ((NEADVI) t).reportAdNegative();
                z = false;
            }
        } else {
            z = true;
        }
        this.f2711j = z;
    }

    public void preloadVideo() {
        if (!b()) {
            this.f2708g = true;
            return;
        }
        T t = this.a;
        if (t != 0) {
            ((NEADVI) t).preloadVideo();
        } else {
            a("preloadVideo");
        }
    }

    public void render() {
        if (!b()) {
            this.f2709h = true;
            return;
        }
        T t = this.a;
        if (t != 0) {
            ((NEADVI) t).render();
        } else {
            a("render");
        }
    }

    @Deprecated
    public void setAdSize(ADSize aDSize) {
        T t = this.a;
        if (t != 0) {
            ((NEADVI) t).setAdSize(aDSize);
        }
    }
}
