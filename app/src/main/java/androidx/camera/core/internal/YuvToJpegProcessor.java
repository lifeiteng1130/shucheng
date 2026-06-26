package androidx.camera.core.internal;

import android.graphics.Rect;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.core.util.Preconditions;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class YuvToJpegProcessor implements CaptureProcessor {
    private static final String TAG = "YuvToJpegProcessor";
    private static final Rect UNINITIALIZED_RECT = new Rect(0, 0, 0, 0);

    @GuardedBy("mLock")
    private ImageWriter mImageWriter;
    private final int mMaxImages;

    @IntRange(from = 0, to = 100)
    private final int mQuality;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private boolean mClosed = false;

    @GuardedBy("mLock")
    private int mProcessingImages = 0;

    @GuardedBy("mLock")
    private Rect mImageRect = UNINITIALIZED_RECT;

    public YuvToJpegProcessor(@IntRange(from = 0, to = 100) int i2, int i3) {
        this.mQuality = i2;
        this.mMaxImages = i3;
    }

    @NonNull
    private static ExifData getExifData(@NonNull ImageProxy imageProxy) {
        ExifData.Builder builderBuilderForDevice = ExifData.builderForDevice();
        imageProxy.getImageInfo().populateExifData(builderBuilderForDevice);
        return builderBuilderForDevice.setImageWidth(imageProxy.getWidth()).setImageHeight(imageProxy.getHeight()).build();
    }

    public void close() {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mClosed = true;
                if (this.mProcessingImages != 0 || this.mImageWriter == null) {
                    Logger.d(TAG, "close() called while processing. Will close after completion.");
                } else {
                    Logger.d(TAG, "No processing in progress. Closing immediately.");
                    this.mImageWriter.close();
                }
            }
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onOutputSurface(@NonNull Surface surface, int i2) {
        Preconditions.checkState(i2 == 256, "YuvToJpegProcessor only supports JPEG output format.");
        synchronized (this.mLock) {
            if (this.mClosed) {
                Logger.w(TAG, "Cannot set output surface. Processor is closed.");
            } else {
                if (this.mImageWriter != null) {
                    throw new IllegalStateException("Output surface already set.");
                }
                this.mImageWriter = ImageWriterCompat.newInstance(surface, this.mMaxImages, i2);
            }
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onResolutionUpdate(@NonNull Size size) {
        synchronized (this.mLock) {
            this.mImageRect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012a A[Catch: all -> 0x014d, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x014d, blocks: (B:42:0x00dc, B:86:0x012a), top: B:143:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0151  */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.media.ImageWriter] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [android.media.Image] */
    /* JADX WARN: Type inference failed for: r8v12, types: [int] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.media.Image] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.media.Image] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.camera.core.impl.CaptureProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void process(@androidx.annotation.NonNull androidx.camera.core.impl.ImageProxyBundle r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.YuvToJpegProcessor.process(androidx.camera.core.impl.ImageProxyBundle):void");
    }

    public static final class ByteBufferOutputStream extends OutputStream {
        private final ByteBuffer mByteBuffer;

        public ByteBufferOutputStream(@NonNull ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws EOFException {
            if (!this.mByteBuffer.hasRemaining()) {
                throw new EOFException("Output ByteBuffer has no bytes remaining.");
            }
            this.mByteBuffer.put((byte) i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws EOFException {
            int i4;
            Objects.requireNonNull(bArr);
            if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return;
            }
            if (this.mByteBuffer.remaining() >= i3) {
                this.mByteBuffer.put(bArr, i2, i3);
                return;
            }
            throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
        }
    }
}
