package androidx.media2.common;

import android.os.ParcelFileDescriptor;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.media2.common.MediaItem;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileMediaItem extends MediaItem {
    public static final long FD_LENGTH_UNKNOWN = 576460752303423487L;
    private static final String TAG = "FileMediaItem";

    @GuardedBy("mLock")
    private boolean mClosed;
    private final long mFDLength;
    private final long mFDOffset;
    private final Object mLock;
    private final ParcelFileDescriptor mPFD;

    @GuardedBy("mLock")
    private int mRefCount;

    public static final class Builder extends MediaItem.Builder {
        public long mFDLength;
        public long mFDOffset;
        public ParcelFileDescriptor mPFD;

        public Builder(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            this.mFDOffset = 0L;
            this.mFDLength = 576460752303423487L;
            Preconditions.checkNotNull(parcelFileDescriptor);
            this.mPFD = parcelFileDescriptor;
            this.mFDOffset = 0L;
            this.mFDLength = 576460752303423487L;
        }

        @NonNull
        public Builder setFileDescriptorLength(long j2) {
            if (j2 < 0) {
                j2 = 576460752303423487L;
            }
            this.mFDLength = j2;
            return this;
        }

        @NonNull
        public Builder setFileDescriptorOffset(long j2) {
            if (j2 < 0) {
                j2 = 0;
            }
            this.mFDOffset = j2;
            return this;
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public FileMediaItem build() {
            return new FileMediaItem(this);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setEndPosition(long j2) {
            return (Builder) super.setEndPosition(j2);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            return (Builder) super.setMetadata(mediaMetadata);
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setStartPosition(long j2) {
            return (Builder) super.setStartPosition(j2);
        }
    }

    public FileMediaItem(Builder builder) {
        super(builder);
        this.mLock = new Object();
        this.mPFD = builder.mPFD;
        this.mFDOffset = builder.mFDOffset;
        this.mFDLength = builder.mFDLength;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void close() {
        synchronized (this.mLock) {
            ParcelFileDescriptor parcelFileDescriptor = this.mPFD;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            this.mClosed = true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void decreaseRefCount() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            int i2 = this.mRefCount - 1;
            this.mRefCount = i2;
            try {
                if (i2 <= 0) {
                    try {
                        ParcelFileDescriptor parcelFileDescriptor = this.mPFD;
                        if (parcelFileDescriptor != null) {
                            parcelFileDescriptor.close();
                        }
                    } catch (IOException unused) {
                        String str = "Failed to close the ParcelFileDescriptor " + this.mPFD;
                    }
                }
            } finally {
                this.mClosed = true;
            }
        }
    }

    public long getFileDescriptorLength() {
        return this.mFDLength;
    }

    public long getFileDescriptorOffset() {
        return this.mFDOffset;
    }

    @NonNull
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mPFD;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void increaseRefCount() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mRefCount++;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mClosed;
        }
        return z;
    }
}
