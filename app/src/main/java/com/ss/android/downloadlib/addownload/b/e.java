package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModelBox.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.ss.android.downloadad.api.a.a {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DownloadModel f3052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownloadEventConfig f3053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DownloadController f3054d;

    public e() {
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        return this.f3052b.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        return this.f3052b.getId();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        return this.f3052b.isAd();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        return this.f3052b.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        return this.f3052b.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        if (this.f3052b.getDeepLink() != null) {
            return this.f3052b.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        return this.f3052b.getExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        if (this.f3054d.getDownloadMode() == 2) {
            return 2;
        }
        return this.f3052b.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        return this.f3053c.getRefer();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        return this.f3053c.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        return this.f3053c.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        return this.f3052b.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        return this.f3053c.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        return this.f3052b.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        return this.f3053c.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        return this.f3053c.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        return this.f3054d.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        return this.f3052b.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        return this.f3053c.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        return this.f3052b;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        return this.f3053c;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        return this.f3054d;
    }

    public boolean x() {
        DownloadModel downloadModel;
        if (this.a == 0 || (downloadModel = this.f3052b) == null || this.f3053c == null || this.f3054d == null) {
            return true;
        }
        return downloadModel.isAd() && this.a <= 0;
    }

    public boolean y() {
        if (x()) {
            return false;
        }
        if (!this.f3052b.isAd()) {
            return this.f3052b instanceof AdDownloadModel;
        }
        DownloadModel downloadModel = this.f3052b;
        return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.f3053c instanceof AdDownloadEventConfig) && (this.f3054d instanceof AdDownloadController);
    }

    public e(long j2, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.a = j2;
        this.f3052b = downloadModel;
        this.f3053c = downloadEventConfig;
        this.f3054d = downloadController;
    }
}
