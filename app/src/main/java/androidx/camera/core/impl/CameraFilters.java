package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraFilters;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CameraFilters {
    public static final CameraFilter ANY = new CameraFilter() { // from class: b.a.b.w1.a
        @Override // androidx.camera.core.CameraFilter
        public final List filter(List list) {
            CameraFilter cameraFilter = CameraFilters.ANY;
            return list;
        }
    };
    public static final CameraFilter NONE = new CameraFilter() { // from class: b.a.b.w1.b
        @Override // androidx.camera.core.CameraFilter
        public final List filter(List list) {
            CameraFilter cameraFilter = CameraFilters.ANY;
            return Collections.emptyList();
        }
    };

    private CameraFilters() {
    }
}
