package androidx.camera.camera2.internal;

import android.content.Context;
import android.media.CamcorderProfile;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2DeviceSurfaceManager implements CameraDeviceSurfaceManager {
    private static final String TAG = "Camera2DeviceSurfaceManager";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final Map<String, SupportedSurfaceCombination> mCameraSupportedSurfaceCombinationMap;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2DeviceSurfaceManager(@NonNull Context context, @Nullable Object obj, @NonNull Set<String> set) {
        this(context, new CamcorderProfileHelper() { // from class: b.a.a.d.a
            @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
            public final boolean hasProfile(int i2, int i3) {
                return CamcorderProfile.hasProfile(i2, i3);
            }
        }, obj, set);
    }

    private void init(@NonNull Context context, @NonNull CameraManagerCompat cameraManagerCompat, @NonNull Set<String> set) {
        Preconditions.checkNotNull(context);
        for (String str : set) {
            this.mCameraSupportedSurfaceCombinationMap.put(str, new SupportedSurfaceCombination(context, str, cameraManagerCompat, this.mCamcorderProfileHelper));
        }
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public boolean checkSupported(@NonNull String str, @Nullable List<SurfaceConfig> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.checkSupported(list);
        }
        return false;
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    @NonNull
    public Map<UseCaseConfig<?>, Size> getSuggestedResolutions(@NonNull String str, @NonNull List<SurfaceConfig> list, @NonNull List<UseCaseConfig<?>> list2) {
        Preconditions.checkArgument(!list2.isEmpty(), "No new use cases to be bound.");
        ArrayList arrayList = new ArrayList(list);
        Iterator<UseCaseConfig<?>> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(transformSurfaceConfig(str, it.next().getInputFormat(), new Size(640, 480)));
        }
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination == null) {
            throw new IllegalArgumentException(a.i("No such camera id in supported combination list: ", str));
        }
        if (supportedSurfaceCombination.checkSupported(arrayList)) {
            return supportedSurfaceCombination.getSuggestedResolutions(list, list2);
        }
        throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + str + ".  May be attempting to bind too many use cases. Existing surfaces: " + list + " New configs: " + list2);
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    @Nullable
    public SurfaceConfig transformSurfaceConfig(@NonNull String str, int i2, @NonNull Size size) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.transformSurfaceConfig(i2, size);
        }
        return null;
    }

    public Camera2DeviceSurfaceManager(@NonNull Context context, @NonNull CamcorderProfileHelper camcorderProfileHelper, @Nullable Object obj, @NonNull Set<String> set) {
        this.mCameraSupportedSurfaceCombinationMap = new HashMap();
        Preconditions.checkNotNull(camcorderProfileHelper);
        this.mCamcorderProfileHelper = camcorderProfileHelper;
        init(context, obj instanceof CameraManagerCompat ? (CameraManagerCompat) obj : CameraManagerCompat.from(context), set);
    }
}
