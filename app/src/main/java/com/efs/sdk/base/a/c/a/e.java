package com.efs.sdk.base.a.c.a;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.e.f;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {
    public volatile SharedPreferences a;

    public static void b() {
        File fileA = com.efs.sdk.base.a.h.a.a(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a);
        if (fileA.exists()) {
            fileA.delete();
        }
    }

    private void d() {
        if (this.a == null) {
            synchronized (com.efs.sdk.base.a.e.b.class) {
                if (this.a == null) {
                    this.a = SharedPreferencesUtils.getSharedPreferences(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.h.c.b.a(("config_" + com.efs.sdk.base.a.d.a.a().a.toLowerCase()).getBytes()));
                    this.a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    public final boolean a(@NonNull b bVar) {
        c();
        if (this.a == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.clear();
        editorEdit.putInt("cver", bVar.a);
        editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : bVar.f1789e.entrySet()) {
            editorEdit.putString(entry.getKey(), entry.getValue());
        }
        editorEdit.apply();
        return true;
    }

    public final void c() {
        try {
            d();
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.b("efs.config", "init sharedpreferences error", th);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (f.a.a.a()) {
            return;
        }
        c.a().b();
    }

    public static boolean a() {
        com.efs.sdk.base.a.c.a aVarA = com.efs.sdk.base.a.d.a.a();
        File fileB = com.efs.sdk.base.a.h.a.b(aVarA.f1776c, aVarA.a);
        if (!fileB.exists()) {
            return false;
        }
        com.efs.sdk.base.a.h.b.b(fileB);
        return true;
    }
}
