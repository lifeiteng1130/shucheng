package com.qq.e.ads.nativ.express2;

import android.app.Activity;
import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NativeExpressADDataAdapter implements NativeExpressADData2, DownloadConfirmListener {
    private NativeExpressADData2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaEventListener f2730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AdEventListener f2731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DownloadConfirmListener f2732d;

    public NativeExpressADDataAdapter(NativeExpressADData2 nativeExpressADData2) {
        this.a = nativeExpressADData2;
        if (nativeExpressADData2 instanceof ADEventListener) {
            ((ADEventListener) nativeExpressADData2).setAdListener(new ADListener() { // from class: com.qq.e.ads.nativ.express2.NativeExpressADDataAdapter.1
                @Override // com.qq.e.comm.adevent.ADListener
                public void onADEvent(ADEvent aDEvent) {
                    if (aDEvent.getType() < 201) {
                        NativeExpressADDataAdapter.a(NativeExpressADDataAdapter.this, aDEvent);
                    } else if (aDEvent.getType() < 301) {
                        NativeExpressADDataAdapter.b(NativeExpressADDataAdapter.this, aDEvent);
                    }
                }
            });
        }
    }

    public static void a(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.f2731c != null) {
            switch (aDEvent.getType()) {
                case 101:
                    nativeExpressADDataAdapter.f2731c.onClick();
                    break;
                case 102:
                    nativeExpressADDataAdapter.f2731c.onExposed();
                    break;
                case 103:
                    nativeExpressADDataAdapter.f2731c.onRenderSuccess();
                    break;
                case 104:
                    nativeExpressADDataAdapter.f2731c.onRenderFail();
                    break;
                case 105:
                    nativeExpressADDataAdapter.f2731c.onAdClosed();
                    break;
            }
        }
    }

    public static void b(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.f2730b != null) {
            switch (aDEvent.getType()) {
                case 201:
                    nativeExpressADDataAdapter.f2730b.onVideoCache();
                    break;
                case 202:
                    nativeExpressADDataAdapter.f2730b.onVideoStart();
                    break;
                case 203:
                    nativeExpressADDataAdapter.f2730b.onVideoResume();
                    break;
                case 204:
                case 205:
                    nativeExpressADDataAdapter.f2730b.onVideoPause();
                    break;
                case 206:
                    nativeExpressADDataAdapter.f2730b.onVideoComplete();
                    break;
                case 207:
                    nativeExpressADDataAdapter.f2730b.onVideoError();
                    break;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        this.a.destroy();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public View getAdView() {
        return this.a.getAdView();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NativeExpressADData2 nativeExpressADData2 = this.a;
        if (nativeExpressADData2 != null) {
            return nativeExpressADData2.getApkInfoUrl();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getECPM() {
        return this.a.getECPM();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public String getECPMLevel() {
        return this.a.getECPMLevel();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public Map<String, Object> getExtraInfo() {
        return this.a.getExtraInfo();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getVideoDuration() {
        return this.a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public boolean isVideoAd() {
        return this.a.isVideoAd();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f2732d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void render() {
        this.a.render();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void sendLossNotification(int i2, int i3, String str) {
        this.a.sendLossNotification(i2, i3, str);
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void sendWinNotification(int i2) {
        this.a.sendWinNotification(i2);
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setAdEventListener(AdEventListener adEventListener) {
        this.f2731c = adEventListener;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setBidECPM(int i2) {
        this.a.setBidECPM(i2);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f2732d = downloadConfirmListener;
        NativeExpressADData2 nativeExpressADData2 = this.a;
        if (nativeExpressADData2 != null) {
            nativeExpressADData2.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setMediaListener(MediaEventListener mediaEventListener) {
        this.f2730b = mediaEventListener;
    }
}
