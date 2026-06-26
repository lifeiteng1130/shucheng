package com.bytedance.pangle.download;

import androidx.annotation.Keep;
import c.a.a.a.a;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PluginDownloadBean {
    public boolean isOffline;
    public boolean isRevert;
    public boolean isWifiOnly;
    public int mApiVersionMax;
    public int mApiVersionMin;
    public List<String> mBackupUrlList;
    public int mClientVersionMax;
    public int mClientVersionMin;
    public int mDownloadType;
    public String mMd5;
    public int mOrder;
    public String mPackageName;
    public String mUrl;
    public int mVersionCode;

    public String toString() {
        StringBuilder sb = new StringBuilder("PluginDownloadBean{mPackageName='");
        a.y(sb, this.mPackageName, '\'', ", mVersionCode=");
        sb.append(this.mVersionCode);
        sb.append(", mUrl='");
        a.y(sb, this.mUrl, '\'', ", mMd5='");
        a.y(sb, this.mMd5, '\'', ", mOrder=");
        sb.append(this.mOrder);
        sb.append(", isOffline=");
        sb.append(this.isOffline);
        sb.append(", isRevert=");
        sb.append(this.isRevert);
        sb.append(", isWifiOnly=");
        sb.append(this.isWifiOnly);
        sb.append(", mClientVersionMin=");
        sb.append(this.mClientVersionMin);
        sb.append(", mClientVersionMax=");
        sb.append(this.mClientVersionMax);
        sb.append(", mApiVersionMin=");
        sb.append(this.mApiVersionMin);
        sb.append(", mApiVersionMax=");
        sb.append(this.mApiVersionMax);
        sb.append(", mDownloadType=");
        sb.append(this.mDownloadType);
        sb.append(", mBackupUrlList=");
        sb.append(this.mBackupUrlList);
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
