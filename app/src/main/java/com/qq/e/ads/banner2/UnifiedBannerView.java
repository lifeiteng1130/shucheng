package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface {
    public final UnifiedBannerAD a;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, (Map) null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.a = new UnifiedBannerAD(activity, this, str, unifiedBannerADListener);
        a();
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map, String str2) {
        super(activity);
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e(UnifiedBannerView.class.getSimpleName() + "构造函数中 token 参数不可为空");
        }
        this.a = new UnifiedBannerAD(activity, this, str, str2, unifiedBannerADListener);
        a();
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, str2, unifiedBannerADListener, (Map) null);
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        this(activity, str2, unifiedBannerADListener, map);
        GDTLogger.e(UnifiedBannerView.class.getSimpleName() + ":此构造方法已废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo，构造函数中传入的appId将被忽略，实际使用的是GDTADManager.getInstance().initWith() 传入的appId");
    }

    private void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void destroy() {
        this.a.destroy();
    }

    public String getAdNetWorkName() {
        return this.a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.a.getApkInfoUrl();
    }

    public int getECPM() {
        return this.a.getECPM();
    }

    public String getECPMLevel() {
        return this.a.getECPMLevel();
    }

    public Map getExt() {
        return this.a.getExt();
    }

    public Map<String, Object> getExtraInfo() {
        return this.a.getExtraInfo();
    }

    public void loadAD() {
        this.a.loadAD();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.a.onWindowFocusChanged(z);
    }

    public void sendLossNotification(int i2, int i3, String str) {
        this.a.sendLossNotification(i2, i3, str);
    }

    public void sendWinNotification(int i2) {
        this.a.sendWinNotification(i2);
    }

    public void setBidECPM(int i2) {
        this.a.setBidECPM(i2);
    }

    public void setDownConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.a.a(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.a.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.a.setLoadAdParams(loadAdParams);
    }

    public void setRefresh(int i2) {
        this.a.c(i2);
    }
}
