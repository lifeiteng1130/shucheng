package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AdListenerAdapter f2716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private NativeADUnifiedListener f2717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Integer> f2718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f2719j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile int f2720k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f2721l;
    private String m;
    private LoadAdParams n;

    public static class AdListenerAdapter implements ADListener {
        private NativeADUnifiedListener a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.a != null) {
                Object[] paras = aDEvent.getParas();
                int type = aDEvent.getType();
                if (type != 1) {
                    if (type != 2) {
                        return;
                    }
                    if (paras.length < 1 || !(paras[0] instanceof Integer)) {
                        AbstractAD.a(NativeUnifiedAD.class, aDEvent);
                        return;
                    } else {
                        this.a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                }
                if (paras.length != 1 || !(paras[0] instanceof List)) {
                    AbstractAD.a(NativeUnifiedAD.class, aDEvent);
                    return;
                }
                List list = (List) paras[0];
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                    }
                }
                this.a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f2718i = new ArrayList();
        this.f2717h = nativeADUnifiedListener;
        this.f2716g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f2718i = new ArrayList();
        this.f2717h = nativeADUnifiedListener;
        this.f2716g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    @Deprecated
    public NativeUnifiedAD(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        this(context, str2, nativeADUnifiedListener);
        c();
    }

    private void a(int i2, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.f2718i.add(Integer.valueOf(i2));
                    return;
                }
                return;
            }
            T t = this.a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.n;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i2, loadAdParams);
                } else {
                    nuadi.loadData(i2);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f2716g);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        super.a(nuadi);
        nuadi.setMinVideoDuration(this.f2720k);
        nuadi.setMaxVideoDuration(this.f2721l);
        nuadi.setVastClassName(this.m);
        List<String> list = this.f2719j;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f2718i.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f2717h;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i2) {
        a(i2, true);
    }

    public void loadData(int i2, LoadAdParams loadAdParams) {
        this.n = loadAdParams;
        loadData(i2);
    }

    public void setCategories(List<String> list) {
        this.f2719j = list;
        T t = this.a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i2) {
        this.f2721l = i2;
        if (this.f2721l > 0 && this.f2720k > this.f2721l) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.f2721l);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f2720k = i2;
        if (this.f2721l > 0 && this.f2720k > this.f2721l) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.f2720k);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.m = str;
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }

    @Deprecated
    public void setVideoADContainerRender(int i2) {
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
    }
}
