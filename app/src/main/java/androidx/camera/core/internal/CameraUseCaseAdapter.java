package androidx.camera.core.internal;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.experimental.UseExperimental;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExperimentalCameraFilter;
import androidx.camera.core.ExperimentalUseCaseGroup;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;

    @NonNull
    private CameraInternal mCameraInternal;
    private final LinkedHashSet<CameraInternal> mCameraInternals;
    private final CameraId mId;
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    @Nullable
    @GuardedBy("mLock")
    private ViewPort mViewPort;

    @GuardedBy("mLock")
    private final List<UseCase> mUseCases = new ArrayList();

    @NonNull
    @GuardedBy("mLock")
    private CameraConfig mCameraConfig = CameraConfigs.emptyConfig();
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private boolean mAttached = true;

    @GuardedBy("mLock")
    private Config mInteropConfig = null;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(@NonNull String str) {
            super(str);
        }

        public CameraException(@NonNull Throwable th) {
            super(th);
        }
    }

    public static final class CameraId {
        private final List<String> mIds = new ArrayList();

        public CameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
            Iterator<CameraInternal> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                this.mIds.add(it.next().getCameraInfoInternal().getCameraId());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof CameraId) {
                return this.mIds.equals(((CameraId) obj).mIds);
            }
            return false;
        }

        public int hashCode() {
            return this.mIds.hashCode() * 53;
        }
    }

    public static class ConfigPair {
        public UseCaseConfig<?> mCameraConfig;
        public UseCaseConfig<?> mExtendedConfig;

        public ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.mExtendedConfig = useCaseConfig;
            this.mCameraConfig = useCaseConfig2;
        }
    }

    public CameraUseCaseAdapter(@NonNull LinkedHashSet<CameraInternal> linkedHashSet, @NonNull CameraDeviceSurfaceManager cameraDeviceSurfaceManager, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        this.mCameraInternal = linkedHashSet.iterator().next();
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet);
        this.mCameraInternals = linkedHashSet2;
        this.mId = new CameraId(linkedHashSet2);
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
    }

    private void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    private Map<UseCase, Size> calculateSuggestedResolutions(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull List<UseCase> list, @NonNull List<UseCase> list2, @NonNull Map<UseCase, ConfigPair> map) {
        ArrayList arrayList = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        HashMap map2 = new HashMap();
        for (UseCase useCase : list2) {
            arrayList.add(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(cameraId, useCase.getImageFormat(), useCase.getAttachedSurfaceResolution()));
            map2.put(useCase, useCase.getAttachedSurfaceResolution());
        }
        if (!list.isEmpty()) {
            HashMap map3 = new HashMap();
            for (UseCase useCase2 : list) {
                ConfigPair configPair = map.get(useCase2);
                map3.put(useCase2.mergeConfigs(cameraInfoInternal, configPair.mExtendedConfig, configPair.mCameraConfig), useCase2);
            }
            Map<UseCaseConfig<?>, Size> suggestedResolutions = this.mCameraDeviceSurfaceManager.getSuggestedResolutions(cameraId, arrayList, new ArrayList(map3.keySet()));
            for (Map.Entry entry : map3.entrySet()) {
                map2.put((UseCase) entry.getValue(), suggestedResolutions.get(entry.getKey()));
            }
        }
        return map2;
    }

    @NonNull
    public static CameraId generateCameraId(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        return new CameraId(linkedHashSet);
    }

    private Map<UseCase, ConfigPair> getConfigs(List<UseCase> list, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap map = new HashMap();
        for (UseCase useCase : list) {
            map.put(useCase, new ConfigPair(useCase.getDefaultConfig(false, useCaseConfigFactory), useCase.getDefaultConfig(true, useCaseConfigFactory2)));
        }
        return map;
    }

    private void restoreInteropConfig() {
        synchronized (this.mLock) {
            if (this.mInteropConfig != null) {
                this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
            }
        }
    }

    @UseExperimental(markerClass = ExperimentalUseCaseGroup.class)
    private void updateViewPort(@NonNull Map<UseCase, Size> map, @NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            if (this.mViewPort != null) {
                Map<UseCase, Rect> mapCalculateViewPortRects = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), this.mCameraInternal.getCameraInfoInternal().getLensFacing().intValue() == 0, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), map);
                for (UseCase useCase : collection) {
                    useCase.setViewPortCropRect((Rect) Preconditions.checkNotNull(mapCalculateViewPortRects.get(useCase)));
                }
            }
        }
    }

    @UseExperimental(markerClass = ExperimentalUseCaseGroup.class)
    public void addUseCases(@NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            ArrayList<UseCase> arrayList = new ArrayList();
            for (UseCase useCase : collection) {
                if (this.mUseCases.contains(useCase)) {
                    Logger.d(TAG, "Attempting to attach already attached UseCase");
                } else {
                    arrayList.add(useCase);
                }
            }
            Map<UseCase, ConfigPair> configs = getConfigs(arrayList, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
            try {
                Map<UseCase, Size> mapCalculateSuggestedResolutions = calculateSuggestedResolutions(this.mCameraInternal.getCameraInfoInternal(), arrayList, this.mUseCases, configs);
                updateViewPort(mapCalculateSuggestedResolutions, collection);
                for (UseCase useCase2 : arrayList) {
                    ConfigPair configPair = configs.get(useCase2);
                    useCase2.onAttach(this.mCameraInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                    useCase2.updateSuggestedResolution((Size) Preconditions.checkNotNull(mapCalculateSuggestedResolutions.get(useCase2)));
                }
                this.mUseCases.addAll(arrayList);
                if (this.mAttached) {
                    this.mCameraInternal.attachUseCases(arrayList);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((UseCase) it.next()).notifyState();
                }
            } catch (IllegalArgumentException e2) {
                throw new CameraException(e2.getMessage());
            }
        }
    }

    public void attachUseCases() {
        synchronized (this.mLock) {
            if (!this.mAttached) {
                this.mCameraInternal.attachUseCases(this.mUseCases);
                restoreInteropConfig();
                Iterator<UseCase> it = this.mUseCases.iterator();
                while (it.hasNext()) {
                    it.next().notifyState();
                }
                this.mAttached = true;
            }
        }
    }

    public void checkAttachUseCases(@NonNull List<UseCase> list) {
        synchronized (this.mLock) {
            try {
                try {
                    calculateSuggestedResolutions(this.mCameraInternal.getCameraInfoInternal(), list, Collections.emptyList(), getConfigs(list, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory));
                } catch (IllegalArgumentException e2) {
                    throw new CameraException(e2.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void detachUseCases() {
        synchronized (this.mLock) {
            if (this.mAttached) {
                cacheInteropConfig();
                this.mCameraInternal.detachUseCases(new ArrayList(this.mUseCases));
                this.mAttached = false;
            }
        }
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraControl getCameraControl() {
        return this.mCameraInternal.getCameraControlInternal();
    }

    @NonNull
    public CameraId getCameraId() {
        return this.mId;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraInfo getCameraInfo() {
        return this.mCameraInternal.getCameraInfoInternal();
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.mCameraInternals;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraConfig getExtendedConfig() {
        CameraConfig cameraConfig;
        synchronized (this.mLock) {
            cameraConfig = this.mCameraConfig;
        }
        return cameraConfig;
    }

    @NonNull
    public List<UseCase> getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mUseCases);
        }
        return arrayList;
    }

    public boolean isEquivalent(@NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        return this.mId.equals(cameraUseCaseAdapter.getCameraId());
    }

    public void removeUseCases(@NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            this.mCameraInternal.detachUseCases(collection);
            for (UseCase useCase : collection) {
                if (this.mUseCases.contains(useCase)) {
                    useCase.onDetach(this.mCameraInternal);
                } else {
                    Logger.e(TAG, "Attempting to detach non-attached UseCase: " + useCase);
                }
            }
            this.mUseCases.removeAll(collection);
        }
    }

    @Override // androidx.camera.core.Camera
    @UseExperimental(markerClass = ExperimentalCameraFilter.class)
    public void setExtendedConfig(@Nullable CameraConfig cameraConfig) {
        synchronized (this.mLock) {
            if (cameraConfig == null) {
                try {
                    cameraConfig = CameraConfigs.emptyConfig();
                } catch (Throwable th) {
                    throw th;
                }
            }
            CameraInternal cameraInternalSelect = new CameraSelector.Builder().addCameraFilter(cameraConfig.getCameraFilter()).build().select(this.mCameraInternals);
            Map<UseCase, ConfigPair> configs = getConfigs(this.mUseCases, cameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
            try {
                Map<UseCase, Size> mapCalculateSuggestedResolutions = calculateSuggestedResolutions(cameraInternalSelect.getCameraInfoInternal(), this.mUseCases, Collections.emptyList(), configs);
                updateViewPort(mapCalculateSuggestedResolutions, this.mUseCases);
                if (this.mAttached) {
                    this.mCameraInternal.detachUseCases(this.mUseCases);
                }
                Iterator<UseCase> it = this.mUseCases.iterator();
                while (it.hasNext()) {
                    it.next().onDetach(this.mCameraInternal);
                }
                for (UseCase useCase : this.mUseCases) {
                    ConfigPair configPair = configs.get(useCase);
                    useCase.onAttach(cameraInternalSelect, configPair.mExtendedConfig, configPair.mCameraConfig);
                    useCase.updateSuggestedResolution((Size) Preconditions.checkNotNull(mapCalculateSuggestedResolutions.get(useCase)));
                }
                if (this.mAttached) {
                    cameraInternalSelect.attachUseCases(this.mUseCases);
                }
                Iterator<UseCase> it2 = this.mUseCases.iterator();
                while (it2.hasNext()) {
                    it2.next().notifyState();
                }
                this.mCameraInternal = cameraInternalSelect;
                this.mCameraConfig = cameraConfig;
            } catch (IllegalArgumentException e2) {
                throw new CameraException(e2.getMessage());
            }
        }
    }

    public void setViewPort(@Nullable ViewPort viewPort) {
        synchronized (this.mLock) {
            this.mViewPort = viewPort;
        }
    }
}
