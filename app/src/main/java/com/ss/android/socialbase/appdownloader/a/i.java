package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.analytics.pro.ai;
import org.json.JSONObject;

/* JADX INFO: compiled from: O3DevicePlan.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3302e;

    public i(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str, String str2, String str3) {
        super(context, aVar, str);
        this.f3301d = str2;
        this.f3302e = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String str;
        String strC = this.f3298b.c(ai.az);
        String strA = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("ak"), strC);
        String strA2 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("am"), strC);
        String strA3 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("an"), strC);
        String strSubstring = null;
        if (!TextUtils.isEmpty(strA3) && strA3.split(",").length == 2) {
            String[] strArrSplit = strA3.split(",");
            String strA4 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("al"), strC);
            String strA5 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("ao"), strC);
            if (!TextUtils.isEmpty(strA5) && strA5.split(",").length == 2) {
                String[] strArrSplit2 = strA5.split(",");
                JSONObject jSONObjectD = this.f3298b.d("download_dir");
                if (jSONObjectD != null) {
                    String strOptString = jSONObjectD.optString("dir_name");
                    if (TextUtils.isEmpty(strOptString) || !strOptString.contains("%s")) {
                        str = this.f3302e;
                    } else {
                        try {
                            str = String.format(strOptString, this.f3302e);
                        } catch (Throwable unused) {
                            str = this.f3302e;
                        }
                    }
                    strSubstring = str;
                    if (strSubstring.length() > 255) {
                        strSubstring = strA4.substring(strSubstring.length() - 255);
                    }
                }
                Intent intent = new Intent(strA);
                intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
                intent.putExtra(strA2, this.f3301d);
                intent.putExtra(strA4, strSubstring);
                intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
