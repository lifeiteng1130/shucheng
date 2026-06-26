package com.qq.e.ads.nativ.express2;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NativeExpressAD2 extends NativeAbstractAD<NEIADI> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private VideoOption2 f2727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AdLoadListener f2728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Integer> f2729k = Collections.synchronizedList(new ArrayList());

    public interface AdLoadListener extends NativeAbstractAD.BasicADListener {
        void onLoadSuccess(List<NativeExpressADData2> list);
    }

    public static class AdLoadListenerAdapter implements ADListener {
        public AdLoadListener a;

        public AdLoadListenerAdapter(AdLoadListener adLoadListener) {
            this.a = adLoadListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.a != null) {
                int type = aDEvent.getType();
                if (type != 1) {
                    if (type != 2) {
                        return;
                    }
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    } else {
                        AbstractAD.a(NativeExpressAD2.class, aDEvent);
                    }
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    this.a.onLoadSuccess((List) aDEvent.getParas()[0]);
                } else {
                    AbstractAD.a(NativeExpressAD2.class, aDEvent);
                }
            }
        }
    }

    public NativeExpressAD2(Context context, String str, AdLoadListener adLoadListener) {
        GDTLogger.e("NativeExpressAD2 接口即将被移除，请使用 NativeExpressAD 接口");
        this.f2728j = adLoadListener;
        a(context, str);
    }

    public NEIADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate2(context, str, str2, new AdLoadListenerAdapter(this.f2728j));
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(context, pOFactory, str, str2);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEIADI neiadi) {
        super.a(neiadi);
        neiadi.setAdSize(this.f2725g, this.f2726h);
        neiadi.setVideoOption(this.f2727i);
        synchronized (this.f2729k) {
            Iterator<Integer> it = this.f2729k.iterator();
            while (it.hasNext()) {
                loadAd(it.next().intValue());
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        AdLoadListener adLoadListener = this.f2728j;
        if (adLoadListener != null) {
            adLoadListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void loadAd(int i2) {
        if (a()) {
            if (!b()) {
                this.f2729k.add(Integer.valueOf(i2));
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((NEIADI) t).loadAd(i2);
            } else {
                a("loadAd");
            }
        }
    }

    public void setAdSize(int i2, int i3) {
        this.f2725g = i2;
        this.f2726h = i3;
        T t = this.a;
        if (t != 0) {
            ((NEIADI) t).setAdSize(i2, i3);
        }
    }

    public void setVideoOption2(VideoOption2 videoOption2) {
        this.f2727i = videoOption2;
        T t = this.a;
        if (t != 0) {
            ((NEIADI) t).setVideoOption(videoOption2);
        }
    }
}
