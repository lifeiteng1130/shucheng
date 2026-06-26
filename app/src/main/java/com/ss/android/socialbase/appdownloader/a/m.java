package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.analytics.pro.ai;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: VbiDevicePlan.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends a {
    public m(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        return string.endsWith("&") ? string.substring(0, string.length() - 1) : string;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String strC = this.f3298b.c(ai.az);
        String strA = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("bb"), strC);
        if (!TextUtils.isEmpty(strA) && strA.split(",").length == 2) {
            String strA2 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("bc"), strC);
            if (!TextUtils.isEmpty(strA2) && strA2.split(",").length == 2) {
                String[] strArrSplit = strA.split(",");
                String[] strArrSplit2 = strA2.split(",");
                String strA3 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("bd"), strC);
                String strA4 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("be"), strC);
                String strA5 = com.ss.android.socialbase.appdownloader.f.c.a(this.f3298b.c("bf"), strC);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strA3, this.f3299c);
                Intent intent = new Intent();
                intent.setAction(strA5);
                StringBuilder sbR = c.a.a.a.a.r(strA4);
                sbR.append(a(map));
                intent.setData(Uri.parse(sbR.toString()));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
