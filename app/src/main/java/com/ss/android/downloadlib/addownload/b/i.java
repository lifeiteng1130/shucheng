package com.ss.android.downloadlib.addownload.b;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.j;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SharedPrefsManager.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: compiled from: SharedPrefsManager.java */
    public static class a {
        private static i a = new i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences c() {
        return j.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    @NonNull
    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> b() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = c().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.a.b bVarB = com.ss.android.downloadad.api.a.b.b(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && bVarB != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), bVarB);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    private i() {
    }

    public static i a() {
        return a.a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        a((Collection<com.ss.android.downloadad.api.a.b>) arrayList);
    }

    public synchronized void a(final Collection<com.ss.android.downloadad.api.a.b> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.i.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = i.this.c().edit();
                        for (com.ss.android.downloadad.api.a.b bVar : collection) {
                            if (bVar != null && bVar.b() != 0) {
                                editorEdit.putString(String.valueOf(bVar.b()), bVar.ae().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void a(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.i.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = i.this.c().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
