package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import c.e.b.a.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ImageProxyBundle {
    @NonNull
    List<Integer> getCaptureIds();

    @NonNull
    a<ImageProxy> getImageProxy(int i2);
}
