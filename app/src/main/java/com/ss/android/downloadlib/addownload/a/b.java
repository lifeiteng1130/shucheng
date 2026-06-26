package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdDownloadDialogSpHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> a(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = j.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.ss.android.downloadlib.addownload.b.a aVarA = com.ss.android.downloadlib.addownload.b.a.a(jSONObject.optJSONObject(itKeys.next()));
                    if (aVarA != null) {
                        copyOnWriteArrayList.add(aVarA);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        j.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    public void a(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.ss.android.downloadlib.addownload.b.a aVar : copyOnWriteArrayList) {
                if (aVar != null) {
                    jSONObject.put(String.valueOf(aVar.f3022b), aVar.a());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        j.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
