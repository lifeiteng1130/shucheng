package androidx.camera.view.video;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalVideo
@AutoValue
public abstract class OutputFileResults {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static OutputFileResults create(@Nullable Uri uri) {
        return new AutoValue_OutputFileResults(uri);
    }

    @Nullable
    public abstract Uri getSavedUri();
}
