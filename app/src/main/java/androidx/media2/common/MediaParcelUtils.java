package androidx.media2.common;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaParcelUtils {
    public static final String TAG = "MediaParcelUtils";

    @SuppressLint({"RestrictedApi"})
    public static class MediaItemParcelImpl extends ParcelImpl {
        private final MediaItem mItem;

        public MediaItemParcelImpl(MediaItem mediaItem) {
            super(new MediaItem(mediaItem));
            this.mItem = mediaItem;
        }

        @Override // androidx.versionedparcelable.ParcelImpl
        public MediaItem getVersionedParcel() {
            return this.mItem;
        }
    }

    private MediaParcelUtils() {
    }

    @Nullable
    public static <T extends VersionedParcelable> T fromParcelable(@NonNull ParcelImpl parcelImpl) {
        return (T) ParcelUtils.fromParcelable(parcelImpl);
    }

    @NonNull
    public static <T extends VersionedParcelable> List<T> fromParcelableList(@NonNull List<ParcelImpl> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(fromParcelable(list.get(i2)));
        }
        return arrayList;
    }

    @NonNull
    public static ParcelImpl toParcelable(@Nullable VersionedParcelable versionedParcelable) {
        return versionedParcelable instanceof MediaItem ? new MediaItemParcelImpl((MediaItem) versionedParcelable) : (ParcelImpl) ParcelUtils.toParcelable(versionedParcelable);
    }

    @NonNull
    public static List<ParcelImpl> toParcelableList(@NonNull List<? extends VersionedParcelable> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(toParcelable(list.get(i2)));
        }
        return arrayList;
    }
}
