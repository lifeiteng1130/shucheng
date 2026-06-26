package androidx.camera.camera2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import b.a.a.b;
import b.a.a.c;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2Config {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class DefaultProvider implements CameraXConfig.Provider {
        @Override // androidx.camera.core.CameraXConfig.Provider
        @NonNull
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.defaultConfig();
        }
    }

    private Camera2Config() {
    }

    @NonNull
    public static CameraXConfig defaultConfig() {
        c cVar = new CameraFactory.Provider() { // from class: b.a.a.c
            @Override // androidx.camera.core.impl.CameraFactory.Provider
            public final CameraFactory newInstance(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) {
                return new Camera2CameraFactory(context, cameraThreadConfig, cameraSelector);
            }
        };
        b bVar = new CameraDeviceSurfaceManager.Provider() { // from class: b.a.a.b
            @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager.Provider
            public final CameraDeviceSurfaceManager newInstance(Context context, Object obj, Set set) throws InitializationException {
                try {
                    return new Camera2DeviceSurfaceManager(context, obj, set);
                } catch (CameraUnavailableException e2) {
                    throw new InitializationException(e2);
                }
            }
        };
        return new CameraXConfig.Builder().setCameraFactoryProvider(cVar).setDeviceSurfaceManagerProvider(bVar).setUseCaseConfigFactoryProvider(new UseCaseConfigFactory.Provider() { // from class: b.a.a.a
            @Override // androidx.camera.core.impl.UseCaseConfigFactory.Provider
            public final UseCaseConfigFactory newInstance(Context context) {
                return new Camera2UseCaseConfigFactory(context);
            }
        }).build();
    }
}
