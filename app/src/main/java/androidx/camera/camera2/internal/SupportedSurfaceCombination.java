package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.workaround.ExcludedSupportedSizesContainer;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import c.a.a.a.a;
import com.uc.crashsdk.export.LogType;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SupportedSurfaceCombination {
    private static final int ALIGN16 = 16;
    private static final String TAG = "SupportedSurfaceCombination";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final String mCameraId;
    private final CameraCharacteristicsCompat mCharacteristics;
    private final ExcludedSupportedSizesContainer mExcludedSupportedSizesContainer;
    private final int mHardwareLevel;
    private final boolean mIsSensorLandscapeResolution;
    private SurfaceSizeDefinition mSurfaceSizeDefinition;
    private static final Size MAX_PREVIEW_SIZE = new Size(1920, 1080);
    private static final Size DEFAULT_SIZE = new Size(640, 480);
    private static final Size ZERO_SIZE = new Size(0, 0);
    private static final Size QUALITY_2160P_SIZE = new Size(3840, 2160);
    private static final Size QUALITY_1080P_SIZE = new Size(1920, 1080);
    private static final Size QUALITY_720P_SIZE = new Size(LogType.UNEXP_ANR, 720);
    private static final Size QUALITY_480P_SIZE = new Size(720, 480);
    private static final Rational ASPECT_RATIO_4_3 = new Rational(4, 3);
    private static final Rational ASPECT_RATIO_3_4 = new Rational(3, 4);
    private static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    private static final Rational ASPECT_RATIO_9_16 = new Rational(9, 16);
    private final List<SurfaceCombination> mSurfaceCombinations = new ArrayList();
    private final Map<Integer, Size> mMaxSizeCache = new HashMap();
    private final Map<Integer, List<Size>> mExcludedSizeListCache = new HashMap();
    private boolean mIsRawSupported = false;
    private boolean mIsBurstCaptureSupported = false;
    private Map<Integer, Size[]> mOutputSizesCache = new HashMap();

    public static final class CompareAspectRatiosByDistanceToTargetRatio implements Comparator<Rational>, j$.util.Comparator {
        private Rational mTargetRatio;

        public CompareAspectRatiosByDistanceToTargetRatio(Rational rational) {
            this.mTargetRatio = rational;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Rational rational, Rational rational2) {
            if (rational.equals(rational2)) {
                return 0;
            }
            return (int) Math.signum(Float.valueOf(Math.abs(rational.floatValue() - this.mTargetRatio.floatValue())).floatValue() - Float.valueOf(Math.abs(rational2.floatValue() - this.mTargetRatio.floatValue())).floatValue());
        }
    }

    public static final class CompareSizesByArea implements java.util.Comparator<Size>, j$.util.Comparator {
        private boolean mReverse;

        public CompareSizesByArea() {
            this.mReverse = false;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Size size, Size size2) {
            int iSignum = Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
            return this.mReverse ? iSignum * (-1) : iSignum;
        }

        public CompareSizesByArea(boolean z) {
            this.mReverse = false;
            this.mReverse = z;
        }
    }

    public SupportedSurfaceCombination(@NonNull Context context, @NonNull String str, @NonNull CameraManagerCompat cameraManagerCompat, @NonNull CamcorderProfileHelper camcorderProfileHelper) throws CameraUnavailableException {
        String str2 = (String) Preconditions.checkNotNull(str);
        this.mCameraId = str2;
        this.mCamcorderProfileHelper = (CamcorderProfileHelper) Preconditions.checkNotNull(camcorderProfileHelper);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.mExcludedSupportedSizesContainer = new ExcludedSupportedSizesContainer(str);
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str2);
            this.mCharacteristics = cameraCharacteristicsCompat;
            Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.mHardwareLevel = num != null ? num.intValue() : 2;
            this.mIsSensorLandscapeResolution = isSensorLandscapeResolution();
            generateSupportedCombinationList();
            generateSurfaceSizeDefinition(windowManager);
            checkCustomization();
        } catch (CameraAccessExceptionCompat e2) {
            throw CameraUnavailableExceptionHelper.createFrom(e2);
        }
    }

    private void checkCustomization() {
    }

    @NonNull
    private Size[] doGetAllOutputSizesByFormat(int i2) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
        }
        Size[] outputSizes = (Build.VERSION.SDK_INT >= 23 || i2 != 34) ? streamConfigurationMap.getOutputSizes(i2) : streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (outputSizes == null) {
            throw new IllegalArgumentException(a.G("Can not get supported output size for the format: ", i2));
        }
        Size[] sizeArrExcludeProblematicSizes = excludeProblematicSizes(outputSizes, i2);
        Arrays.sort(sizeArrExcludeProblematicSizes, new CompareSizesByArea(true));
        return sizeArrExcludeProblematicSizes;
    }

    @NonNull
    private Size[] excludeProblematicSizes(@NonNull Size[] sizeArr, int i2) {
        List<Size> listFetchExcludedSizes = fetchExcludedSizes(i2);
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        arrayList.removeAll(listFetchExcludedSizes);
        return (Size[]) arrayList.toArray(new Size[0]);
    }

    @NonNull
    private List<Size> fetchExcludedSizes(int i2) {
        List<Size> list = this.mExcludedSizeListCache.get(Integer.valueOf(i2));
        if (list != null) {
            return list;
        }
        List<Size> list2 = this.mExcludedSupportedSizesContainer.get(i2);
        this.mExcludedSizeListCache.put(Integer.valueOf(i2), list2);
        return list2;
    }

    private Size fetchMaxSize(int i2) {
        Size size = this.mMaxSizeCache.get(Integer.valueOf(i2));
        if (size != null) {
            return size;
        }
        Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(i2);
        this.mMaxSizeCache.put(Integer.valueOf(i2), maxOutputSizeByFormat);
        return maxOutputSizeByFormat;
    }

    @Nullable
    private Size flipSizeByRotation(@Nullable Size size, int i2) {
        return (size == null || !isRotationNeeded(i2)) ? size : new Size(size.getHeight(), size.getWidth());
    }

    private void generateSupportedCombinationList() {
        this.mSurfaceCombinations.addAll(getLegacySupportedCombinationList());
        int i2 = this.mHardwareLevel;
        if (i2 == 0 || i2 == 1 || i2 == 3) {
            this.mSurfaceCombinations.addAll(getLimitedSupportedCombinationList());
        }
        int i3 = this.mHardwareLevel;
        if (i3 == 1 || i3 == 3) {
            this.mSurfaceCombinations.addAll(getFullSupportedCombinationList());
        }
        int[] iArr = (int[]) this.mCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i4 : iArr) {
                if (i4 == 3) {
                    this.mIsRawSupported = true;
                } else if (i4 == 6) {
                    this.mIsBurstCaptureSupported = true;
                }
            }
        }
        if (this.mIsRawSupported) {
            this.mSurfaceCombinations.addAll(getRAWSupportedCombinationList());
        }
        if (this.mIsBurstCaptureSupported && this.mHardwareLevel == 0) {
            this.mSurfaceCombinations.addAll(getBurstSupportedCombinationList());
        }
        if (this.mHardwareLevel == 3) {
            this.mSurfaceCombinations.addAll(getLevel3SupportedCombinationList());
        }
    }

    private void generateSurfaceSizeDefinition(WindowManager windowManager) {
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(new Size(640, 480), getPreviewSize(windowManager), getRecordSize());
    }

    @NonNull
    private Size[] getAllOutputSizesByFormat(int i2) {
        Size[] sizeArr = this.mOutputSizesCache.get(Integer.valueOf(i2));
        if (sizeArr != null) {
            return sizeArr;
        }
        Size[] sizeArrDoGetAllOutputSizesByFormat = doGetAllOutputSizesByFormat(i2);
        this.mOutputSizesCache.put(Integer.valueOf(i2), sizeArrDoGetAllOutputSizesByFormat);
        return sizeArrDoGetAllOutputSizesByFormat;
    }

    private List<List<Size>> getAllPossibleSizeArrangements(List<List<Size>> list) {
        Iterator<List<Size>> it = list.iterator();
        int size = 1;
        while (it.hasNext()) {
            size *= it.next().size();
        }
        if (size == 0) {
            throw new IllegalArgumentException("Failed to find supported resolutions.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new ArrayList());
        }
        int size2 = size / list.get(0).size();
        int i3 = size;
        for (int i4 = 0; i4 < list.size(); i4++) {
            List<Size> list2 = list.get(i4);
            for (int i5 = 0; i5 < size; i5++) {
                ((List) arrayList.get(i5)).add(list2.get((i5 % i3) / size2));
            }
            if (i4 < list.size() - 1) {
                i3 = size2;
                size2 /= list.get(i4 + 1).size();
            }
        }
        return arrayList;
    }

    private static int getArea(Size size) {
        return size.getHeight() * size.getWidth();
    }

    @Nullable
    private Size[] getCustomizedSupportSizesFromConfig(int i2, @NonNull ImageOutputConfig imageOutputConfig) {
        Size[] sizeArr = null;
        List<Pair<Integer, Size[]>> supportedResolutions = imageOutputConfig.getSupportedResolutions(null);
        if (supportedResolutions != null) {
            Iterator<Pair<Integer, Size[]>> it = supportedResolutions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<Integer, Size[]> next = it.next();
                if (((Integer) next.first).intValue() == i2) {
                    sizeArr = (Size[]) next.second;
                    break;
                }
            }
        }
        if (sizeArr == null) {
            return sizeArr;
        }
        Size[] sizeArrExcludeProblematicSizes = excludeProblematicSizes(sizeArr, i2);
        Arrays.sort(sizeArrExcludeProblematicSizes, new CompareSizesByArea(true));
        return sizeArrExcludeProblematicSizes;
    }

    @NonNull
    public static Size getPreviewSize(@NonNull WindowManager windowManager) {
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        Size size = point.x > point.y ? new Size(point.x, point.y) : new Size(point.y, point.x);
        return (Size) Collections.min(Arrays.asList(new Size(size.getWidth(), size.getHeight()), MAX_PREVIEW_SIZE), new CompareSizesByArea());
    }

    @NonNull
    private Size getRecordSize() {
        Size size = QUALITY_480P_SIZE;
        try {
            int i2 = Integer.parseInt(this.mCameraId);
            if (this.mCamcorderProfileHelper.hasProfile(i2, 8)) {
                size = QUALITY_2160P_SIZE;
            } else if (this.mCamcorderProfileHelper.hasProfile(i2, 6)) {
                size = QUALITY_1080P_SIZE;
            } else if (this.mCamcorderProfileHelper.hasProfile(i2, 5)) {
                size = QUALITY_720P_SIZE;
            } else {
                this.mCamcorderProfileHelper.hasProfile(i2, 4);
            }
            return size;
        } catch (NumberFormatException unused) {
            return getRecordSizeFromStreamConfigurationMap();
        }
    }

    @NonNull
    private Size getRecordSizeFromStreamConfigurationMap() {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
        }
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(MediaRecorder.class);
        if (outputSizes == null) {
            return QUALITY_480P_SIZE;
        }
        Arrays.sort(outputSizes, new CompareSizesByArea(true));
        for (Size size : outputSizes) {
            int width = size.getWidth();
            Size size2 = QUALITY_1080P_SIZE;
            if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                return size;
            }
        }
        return QUALITY_480P_SIZE;
    }

    private Rational getTargetAspectRatio(@NonNull ImageOutputConfig imageOutputConfig) {
        Rational rational;
        int i2 = new TargetAspectRatio().get(imageOutputConfig, this.mCameraId, this.mCharacteristics);
        if (i2 == 0) {
            rational = this.mIsSensorLandscapeResolution ? ASPECT_RATIO_4_3 : ASPECT_RATIO_3_4;
        } else if (i2 == 1) {
            rational = this.mIsSensorLandscapeResolution ? ASPECT_RATIO_16_9 : ASPECT_RATIO_9_16;
        } else {
            if (i2 == 2) {
                Size sizeFetchMaxSize = fetchMaxSize(256);
                return new Rational(sizeFetchMaxSize.getWidth(), sizeFetchMaxSize.getHeight());
            }
            if (i2 != 3) {
                return null;
            }
            Size targetSize = getTargetSize(imageOutputConfig);
            if (!imageOutputConfig.hasTargetAspectRatio()) {
                if (targetSize != null) {
                    return new Rational(targetSize.getWidth(), targetSize.getHeight());
                }
                return null;
            }
            int targetAspectRatio = imageOutputConfig.getTargetAspectRatio();
            if (targetAspectRatio == 0) {
                rational = this.mIsSensorLandscapeResolution ? ASPECT_RATIO_4_3 : ASPECT_RATIO_3_4;
            } else {
                if (targetAspectRatio != 1) {
                    Logger.e(TAG, "Undefined target aspect ratio: " + targetAspectRatio);
                    return null;
                }
                rational = this.mIsSensorLandscapeResolution ? ASPECT_RATIO_16_9 : ASPECT_RATIO_9_16;
            }
        }
        return rational;
    }

    @Nullable
    private Size getTargetSize(@NonNull ImageOutputConfig imageOutputConfig) {
        return flipSizeByRotation(imageOutputConfig.getTargetResolution(null), imageOutputConfig.getTargetRotation(0));
    }

    private List<Integer> getUseCasesPriorityOrder(List<UseCaseConfig<?>> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<UseCaseConfig<?>> it = list.iterator();
        while (it.hasNext()) {
            int surfaceOccupancyPriority = it.next().getSurfaceOccupancyPriority(0);
            if (!arrayList2.contains(Integer.valueOf(surfaceOccupancyPriority))) {
                arrayList2.add(Integer.valueOf(surfaceOccupancyPriority));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            for (UseCaseConfig<?> useCaseConfig : list) {
                if (iIntValue == useCaseConfig.getSurfaceOccupancyPriority(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(useCaseConfig)));
                }
            }
        }
        return arrayList;
    }

    private Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> list) {
        HashMap map = new HashMap();
        map.put(ASPECT_RATIO_4_3, new ArrayList());
        map.put(ASPECT_RATIO_16_9, new ArrayList());
        for (Size size : list) {
            Rational rational = null;
            for (Rational rational2 : map.keySet()) {
                if (hasMatchingAspectRatio(size, rational2)) {
                    List list2 = (List) map.get(rational2);
                    if (!list2.contains(size)) {
                        list2.add(size);
                    }
                    rational = rational2;
                }
            }
            if (rational == null) {
                map.put(new Rational(size.getWidth(), size.getHeight()), new ArrayList(Collections.singleton(size)));
            }
        }
        return map;
    }

    public static boolean hasMatchingAspectRatio(Size size, Rational rational) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        if (getArea(size) >= getArea(DEFAULT_SIZE)) {
            return isPossibleMod16FromAspectRatio(size, rational);
        }
        return false;
    }

    private static boolean isPossibleMod16FromAspectRatio(Size size, Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i2 = width % 16;
        if (i2 == 0 && height % 16 == 0) {
            return ratioIntersectsMod16Segment(Math.max(0, height + (-16)), width, rational) || ratioIntersectsMod16Segment(Math.max(0, width + (-16)), height, rational2);
        }
        if (i2 == 0) {
            return ratioIntersectsMod16Segment(height, width, rational);
        }
        if (height % 16 == 0) {
            return ratioIntersectsMod16Segment(width, height, rational2);
        }
        return false;
    }

    private boolean isRotationNeeded(int i2) {
        Integer num = (Integer) this.mCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(num, "Camera HAL in bad state, unable to retrieve the SENSOR_ORIENTATION");
        int iSurfaceRotationToDegrees = CameraOrientationUtil.surfaceRotationToDegrees(i2);
        Integer num2 = (Integer) this.mCharacteristics.get(CameraCharacteristics.LENS_FACING);
        Preconditions.checkNotNull(num2, "Camera HAL in bad state, unable to retrieve the LENS_FACING");
        int relativeImageRotation = CameraOrientationUtil.getRelativeImageRotation(iSurfaceRotationToDegrees, num.intValue(), 1 == num2.intValue());
        return relativeImageRotation == 90 || relativeImageRotation == 270;
    }

    private boolean isSensorLandscapeResolution() {
        Size size = (Size) this.mCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        return size == null || size.getWidth() >= size.getHeight();
    }

    private static boolean ratioIntersectsMod16Segment(int i2, int i3, Rational rational) {
        Preconditions.checkArgument(i3 % 16 == 0);
        double numerator = ((double) (rational.getNumerator() * i2)) / ((double) rational.getDenominator());
        return numerator > ((double) Math.max(0, i3 + (-16))) && numerator < ((double) (i3 + 16));
    }

    private void removeSupportedSizesByTargetSize(List<Size> list, Size size) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Size size2 = list.get(i3);
            if (size2.getWidth() < size.getWidth() || size2.getHeight() < size.getHeight()) {
                break;
            }
            if (i2 >= 0) {
                arrayList.add(list.get(i2));
            }
            i2 = i3;
        }
        list.removeAll(arrayList);
    }

    public boolean checkSupported(List<SurfaceConfig> list) {
        Iterator<SurfaceCombination> it = this.mSurfaceCombinations.iterator();
        boolean zIsSupported = false;
        while (it.hasNext() && !(zIsSupported = it.next().isSupported(list))) {
        }
        return zIsSupported;
    }

    public List<SurfaceCombination> getBurstSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        return arrayList;
    }

    public String getCameraId() {
        return this.mCameraId;
    }

    public List<SurfaceCombination> getFullSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, configSize2));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.ANALYSIS;
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    public List<SurfaceCombination> getLegacySupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    public List<SurfaceCombination> getLevel3SupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.ANALYSIS;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.RAW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, configSize3));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3));
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    public List<SurfaceCombination> getLimitedSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType3, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    public Size getMaxOutputSizeByFormat(int i2) {
        return (Size) Collections.max(Arrays.asList(getAllOutputSizesByFormat(i2)), new CompareSizesByArea());
    }

    public List<SurfaceCombination> getRAWSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType4, configSize));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType4, configSize));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    public Map<UseCaseConfig<?>, Size> getSuggestedResolutions(List<SurfaceConfig> list, List<UseCaseConfig<?>> list2) {
        HashMap map = new HashMap();
        List<Integer> useCasesPriorityOrder = getUseCasesPriorityOrder(list2);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = useCasesPriorityOrder.iterator();
        while (it.hasNext()) {
            arrayList.add(getSupportedOutputSizes(list2.get(it.next().intValue())));
        }
        Iterator<List<Size>> it2 = getAllPossibleSizeArrangements(arrayList).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            List<Size> next = it2.next();
            ArrayList arrayList2 = new ArrayList(list);
            for (int i2 = 0; i2 < next.size(); i2++) {
                arrayList2.add(transformSurfaceConfig(list2.get(useCasesPriorityOrder.get(i2).intValue()).getInputFormat(), next.get(i2)));
            }
            if (checkSupported(arrayList2)) {
                for (UseCaseConfig<?> useCaseConfig : list2) {
                    map.put(useCaseConfig, next.get(useCasesPriorityOrder.indexOf(Integer.valueOf(list2.indexOf(useCaseConfig)))));
                }
            }
        }
        return map;
    }

    @NonNull
    @VisibleForTesting
    public List<Size> getSupportedOutputSizes(@NonNull UseCaseConfig<?> useCaseConfig) {
        int inputFormat = useCaseConfig.getInputFormat();
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        Size[] customizedSupportSizesFromConfig = getCustomizedSupportSizesFromConfig(inputFormat, imageOutputConfig);
        if (customizedSupportSizesFromConfig == null) {
            customizedSupportSizesFromConfig = getAllOutputSizesByFormat(inputFormat);
        }
        ArrayList arrayList = new ArrayList();
        Size maxResolution = imageOutputConfig.getMaxResolution(null);
        Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(inputFormat);
        if (maxResolution == null || getArea(maxOutputSizeByFormat) < getArea(maxResolution)) {
            maxResolution = maxOutputSizeByFormat;
        }
        Arrays.sort(customizedSupportSizesFromConfig, new CompareSizesByArea(true));
        Size targetSize = getTargetSize(imageOutputConfig);
        Size size = DEFAULT_SIZE;
        int area = getArea(size);
        if (getArea(maxResolution) < area) {
            size = ZERO_SIZE;
        } else if (targetSize != null && getArea(targetSize) < area) {
            size = targetSize;
        }
        for (Size size2 : customizedSupportSizesFromConfig) {
            if (getArea(size2) <= getArea(maxResolution) && getArea(size2) >= getArea(size) && !arrayList.contains(size2)) {
                arrayList.add(size2);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException(a.G("Can not get supported output size under supported maximum for the format: ", inputFormat));
        }
        Rational targetAspectRatio = getTargetAspectRatio(imageOutputConfig);
        if (targetSize == null) {
            targetSize = imageOutputConfig.getDefaultResolution(null);
        }
        ArrayList arrayList2 = new ArrayList();
        new HashMap();
        if (targetAspectRatio == null) {
            arrayList2.addAll(arrayList);
            if (targetSize != null) {
                removeSupportedSizesByTargetSize(arrayList2, targetSize);
            }
        } else {
            Map<Rational, List<Size>> mapGroupSizesByAspectRatio = groupSizesByAspectRatio(arrayList);
            if (targetSize != null) {
                Iterator<Rational> it = mapGroupSizesByAspectRatio.keySet().iterator();
                while (it.hasNext()) {
                    removeSupportedSizesByTargetSize(mapGroupSizesByAspectRatio.get(it.next()), targetSize);
                }
            }
            ArrayList arrayList3 = new ArrayList(mapGroupSizesByAspectRatio.keySet());
            Collections.sort(arrayList3, new CompareAspectRatiosByDistanceToTargetRatio(targetAspectRatio));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                for (Size size3 : mapGroupSizesByAspectRatio.get((Rational) it2.next())) {
                    if (!arrayList2.contains(size3)) {
                        arrayList2.add(size3);
                    }
                }
            }
        }
        return arrayList2;
    }

    public SurfaceSizeDefinition getSurfaceSizeDefinition() {
        return this.mSurfaceSizeDefinition;
    }

    public boolean isBurstCaptureSupported() {
        return this.mIsBurstCaptureSupported;
    }

    public boolean isRawSupported() {
        return this.mIsRawSupported;
    }

    public SurfaceConfig transformSurfaceConfig(int i2, Size size) {
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.NOT_SUPPORT;
        SurfaceConfig.ConfigType configType = i2 == 35 ? SurfaceConfig.ConfigType.YUV : i2 == 256 ? SurfaceConfig.ConfigType.JPEG : i2 == 32 ? SurfaceConfig.ConfigType.RAW : SurfaceConfig.ConfigType.PRIV;
        Size sizeFetchMaxSize = fetchMaxSize(i2);
        if (size.getHeight() * size.getWidth() <= this.mSurfaceSizeDefinition.getAnalysisSize().getHeight() * this.mSurfaceSizeDefinition.getAnalysisSize().getWidth()) {
            configSize = SurfaceConfig.ConfigSize.ANALYSIS;
        } else {
            if (size.getHeight() * size.getWidth() <= this.mSurfaceSizeDefinition.getPreviewSize().getHeight() * this.mSurfaceSizeDefinition.getPreviewSize().getWidth()) {
                configSize = SurfaceConfig.ConfigSize.PREVIEW;
            } else {
                if (size.getHeight() * size.getWidth() <= this.mSurfaceSizeDefinition.getRecordSize().getHeight() * this.mSurfaceSizeDefinition.getRecordSize().getWidth()) {
                    configSize = SurfaceConfig.ConfigSize.RECORD;
                } else {
                    if (size.getHeight() * size.getWidth() <= sizeFetchMaxSize.getHeight() * sizeFetchMaxSize.getWidth()) {
                        configSize = SurfaceConfig.ConfigSize.MAXIMUM;
                    }
                }
            }
        }
        return SurfaceConfig.create(configType, configSize);
    }
}
