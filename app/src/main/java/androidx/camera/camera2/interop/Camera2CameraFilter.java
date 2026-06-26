package androidx.camera.camera2.interop;

import androidx.annotation.NonNull;
import androidx.camera.camera2.interop.Camera2CameraFilter;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalCamera2Interop
public final class Camera2CameraFilter {

    public interface Camera2Filter {
        @NonNull
        List<Camera2CameraInfo> filter(@NonNull List<Camera2CameraInfo> list);
    }

    private Camera2CameraFilter() {
    }

    @NonNull
    public static CameraFilter createCameraFilter(@NonNull final Camera2Filter camera2Filter) {
        return new CameraFilter() { // from class: b.a.a.e.i
            @Override // androidx.camera.core.CameraFilter
            public final List filter(List list) {
                Camera2CameraFilter.Camera2Filter camera2Filter2 = camera2Filter;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Camera2CameraInfo.from((CameraInfo) it.next()));
                }
                List<Camera2CameraInfo> listFilter = camera2Filter2.filter(Collections.unmodifiableList(arrayList));
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    CameraInfo cameraInfo = (CameraInfo) it2.next();
                    if (listFilter.contains(Camera2CameraInfo.from(cameraInfo))) {
                        arrayList2.add(cameraInfo);
                    }
                }
                return arrayList2;
            }
        };
    }
}
