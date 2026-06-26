package androidx.media2.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.media2.common.MediaItem;

/* JADX INFO: loaded from: classes.dex */
public class CallbackMediaItem extends MediaItem {
    private final DataSourceCallback mDataSourceCallback;

    public static final class Builder extends MediaItem.Builder {
        public DataSourceCallback mDataSourceCallback;

        public Builder(@NonNull DataSourceCallback dataSourceCallback) {
            Preconditions.checkNotNull(dataSourceCallback);
            this.mDataSourceCallback = dataSourceCallback;
        }

        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public CallbackMediaItem build() {
            return new CallbackMediaItem(this);
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

    public CallbackMediaItem(Builder builder) {
        super(builder);
        this.mDataSourceCallback = builder.mDataSourceCallback;
    }

    @NonNull
    public DataSourceCallback getDataSourceCallback() {
        return this.mDataSourceCallback;
    }
}
