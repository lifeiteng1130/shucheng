package com.ifmvo.togetherad.gdt.other;

import android.app.Activity;
import android.text.TextUtils;
import c.a.a.a.a;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DownloadConfirmHelper {
    private static final String APK_FILE_SIZE_KEY = "fileSize";
    private static final String APP_NAME_KEY = "appName";
    private static final String AUTHOR_NAME_KEY = "authorName";
    public static final DownloadConfirmListener DOWNLOAD_CONFIRM_LISTENER = new DownloadConfirmListener() { // from class: com.ifmvo.togetherad.gdt.other.DownloadConfirmHelper.1
        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            new DownloadApkConfirmDialogWebView(activity, str, downloadConfirmCallBack).show();
        }
    };
    private static final String ICON_URL_KEY = "iconUrl";
    private static final String JSON_DATA_KEY = "data";
    private static final String JSON_INFO_PARAMETER = "&resType=api";
    private static final String JSON_RESULT_KEY = "ret";
    private static final String PERMISSIONS_KEY = "permissions";
    private static final String PRIVACY_AGREEMENT_KEY = "privacyAgreement";
    public static final String TAG = "DownloadConfirmHelper";
    private static final String UPDATE_TIME_KEY = "apkPublishTime";
    private static final String VERSION_NAME_KEY = "versionName";

    public static class ApkInfo {
        public long apkPublishTime;
        public String appName;
        public String authorName;
        public long fileSize;
        public String iconUrl;
        public List<String> permissions;
        public String privacyAgreementUrl;
        public String versionName;
    }

    public static String getApkJsonInfoUrl(String str) {
        return a.i(str, JSON_INFO_PARAMETER);
    }

    public static ApkInfo getAppInfoFromJson(String str) {
        JSONObject jSONObjectOptJSONObject;
        ApkInfo apkInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ret", -1) != 0 || (jSONObjectOptJSONObject = jSONObject.optJSONObject(JSON_DATA_KEY)) == null) {
                return null;
            }
            ApkInfo apkInfo2 = new ApkInfo();
            try {
                apkInfo2.iconUrl = jSONObjectOptJSONObject.optString(ICON_URL_KEY);
                apkInfo2.appName = jSONObjectOptJSONObject.optString(APP_NAME_KEY);
                apkInfo2.versionName = jSONObjectOptJSONObject.optString(VERSION_NAME_KEY);
                apkInfo2.authorName = jSONObjectOptJSONObject.optString(AUTHOR_NAME_KEY);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(PERMISSIONS_KEY);
                if (jSONArrayOptJSONArray != null) {
                    apkInfo2.permissions = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        apkInfo2.permissions.add(jSONArrayOptJSONArray.getString(i2));
                    }
                }
                apkInfo2.privacyAgreementUrl = jSONObjectOptJSONObject.optString(PRIVACY_AGREEMENT_KEY);
                long jOptLong = jSONObjectOptJSONObject.optLong(UPDATE_TIME_KEY);
                if (jOptLong <= 946688401000L) {
                    jOptLong *= 1000;
                }
                apkInfo2.apkPublishTime = jOptLong;
                apkInfo2.fileSize = jSONObjectOptJSONObject.optLong(APK_FILE_SIZE_KEY);
                return apkInfo2;
            } catch (JSONException e2) {
                e = e2;
                apkInfo = apkInfo2;
            }
        } catch (JSONException e3) {
            e = e3;
        }
        e.printStackTrace();
        return apkInfo;
    }
}
