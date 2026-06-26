package com.qq.e.ads.nativ;

import android.content.Context;
import android.widget.FrameLayout;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.AdData;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeExpressADView extends FrameLayout implements DownloadConfirmListener, ApkDownloadComplianceInterface {
    public Map<String, String> ext;

    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(Context context) {
        super(context);
        this.ext = new HashMap();
    }

    public abstract void destroy();

    public abstract AdData getBoundData();

    public abstract int getECPM();

    public abstract String getECPMLevel();

    public abstract void negativeFeedback();

    public abstract void preloadVideo();

    public abstract void render();

    public abstract void sendLossNotification(int i2, int i3, String str);

    public abstract void sendWinNotification(int i2);

    @Deprecated
    public abstract void setAdSize(ADSize aDSize);

    public abstract void setBidECPM(int i2);

    public abstract void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener);

    public abstract void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener);
}
