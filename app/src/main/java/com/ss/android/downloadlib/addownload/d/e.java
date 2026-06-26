package com.ss.android.downloadlib.addownload.d;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MistakeClickInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements d {
    private boolean b(int i2) {
        return com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i2, c cVar) {
        if (bVar == null || !b(bVar.s())) {
            return false;
        }
        if (System.currentTimeMillis() - bVar.T() > a(bVar.s())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
        return true;
    }

    private long a(int i2) {
        return com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_mistake_click_interval", 300);
    }
}
