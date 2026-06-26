package androidx.media2.session;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.media2.common.MediaItem;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.session.MediaLibraryService;
import androidx.versionedparcelable.CustomVersionedParcelable;
import c.e.b.a.a.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LibraryResult extends CustomVersionedParcelable implements RemoteResult {
    public long mCompletionTime;
    public MediaItem mItem;
    public List<MediaItem> mItemList;
    public ParcelImplListSlice mItemListSlice;
    public MediaLibraryService.LibraryParams mParams;
    public MediaItem mParcelableItem;
    public int mResultCode;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ResultCode {
    }

    public LibraryResult() {
    }

    public static a<LibraryResult> createFutureWithResult(int i2) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        resolvableFutureCreate.set(new LibraryResult(i2));
        return resolvableFutureCreate;
    }

    @Override // androidx.media2.common.BaseResult
    public long getCompletionTime() {
        return this.mCompletionTime;
    }

    @Nullable
    public MediaLibraryService.LibraryParams getLibraryParams() {
        return this.mParams;
    }

    @Override // androidx.media2.common.BaseResult
    @Nullable
    public MediaItem getMediaItem() {
        return this.mItem;
    }

    @Nullable
    public List<MediaItem> getMediaItems() {
        return this.mItemList;
    }

    @Override // androidx.media2.common.BaseResult
    public int getResultCode() {
        return this.mResultCode;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPostParceling() {
        this.mItem = this.mParcelableItem;
        this.mItemList = MediaUtils.convertParcelImplListSliceToMediaItemList(this.mItemListSlice);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        MediaItem mediaItem = this.mItem;
        if (mediaItem != null) {
            synchronized (mediaItem) {
                if (this.mParcelableItem == null) {
                    this.mParcelableItem = MediaUtils.upcastForPreparceling(this.mItem);
                }
            }
        }
        List<MediaItem> list = this.mItemList;
        if (list != null) {
            synchronized (list) {
                if (this.mItemListSlice == null) {
                    this.mItemListSlice = MediaUtils.convertMediaItemListToParcelImplListSlice(this.mItemList);
                }
            }
        }
    }

    public LibraryResult(int i2) {
        this(i2, null, null, null);
    }

    public LibraryResult(int i2, @Nullable MediaItem mediaItem, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this(i2, mediaItem, null, libraryParams);
    }

    public LibraryResult(int i2, @Nullable List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this(i2, null, list, libraryParams);
    }

    private LibraryResult(int i2, @Nullable MediaItem mediaItem, @Nullable List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        this.mResultCode = i2;
        this.mCompletionTime = SystemClock.elapsedRealtime();
        this.mItem = mediaItem;
        this.mItemList = list;
        this.mParams = libraryParams;
    }
}
