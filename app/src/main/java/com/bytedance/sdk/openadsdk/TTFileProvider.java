package com.bytedance.sdk.openadsdk;

import androidx.core.content.FileProvider;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import com.bytedance.sdk.openadsdk.api.plugin.g;

/* JADX INFO: loaded from: classes.dex */
public class TTFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        boolean zOnCreate = super.onCreate();
        g.a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TTFileProvider.1
            @Override // java.lang.Runnable
            public void run() {
                f.a(TTFileProvider.this.getContext()).a();
            }
        });
        return zOnCreate;
    }
}
