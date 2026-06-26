package com.ss.android.download.api.config;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;

/* JADX INFO: compiled from: DownloadUIFactory.java */
/* JADX INFO: loaded from: classes.dex */
public interface k {
    void a(int i2, @Nullable Context context, @Nullable DownloadModel downloadModel, String str, Drawable drawable, int i3);

    Dialog b(@NonNull com.ss.android.download.api.model.b bVar);
}
