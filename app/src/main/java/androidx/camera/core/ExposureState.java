package androidx.camera.core;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalExposureCompensation
public interface ExposureState {
    int getExposureCompensationIndex();

    @NonNull
    Range<Integer> getExposureCompensationRange();

    @NonNull
    Rational getExposureCompensationStep();

    boolean isExposureCompensationSupported();
}
