package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import f.c0.c.j;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Throttler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\tB\t\b\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0004J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001c¨\u0006\u001f"}, d2 = {"Lokio/Throttler;", "", "", "nanosToBytes", "(J)J", "bytesToNanos", "nanosToWait", "Lf/v;", "waitNanos", "(J)V", "bytesPerSecond", "waitByteCount", "maxByteCount", "(JJJ)V", "byteCount", "take$okio", "take", "now", "byteCountOrWaitNanos$okio", "(JJ)J", "byteCountOrWaitNanos", "Lokio/Source;", "source", "(Lokio/Source;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Sink;)Lokio/Sink;", "allocatedUntil", "J", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j2) {
        this.allocatedUntil = j2;
        this.waitByteCount = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = throttler.waitByteCount;
        }
        long j5 = j3;
        if ((i2 & 4) != 0) {
            j4 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j2, j5, j4);
    }

    private final long bytesToNanos(long j2) {
        return (j2 * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j2) {
        return (j2 * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long nanosToWait) throws InterruptedException {
        long j2 = nanosToWait / 1000000;
        wait(j2, (int) (nanosToWait - (1000000 * j2)));
    }

    public final long byteCountOrWaitNanos$okio(long now, long byteCount) {
        if (this.bytesPerSecond == 0) {
            return byteCount;
        }
        long jMax = Math.max(this.allocatedUntil - now, 0L);
        long jNanosToBytes = this.maxByteCount - nanosToBytes(jMax);
        if (jNanosToBytes >= byteCount) {
            this.allocatedUntil = now + jMax + bytesToNanos(byteCount);
            return byteCount;
        }
        long j2 = this.waitByteCount;
        if (jNanosToBytes >= j2) {
            this.allocatedUntil = now + bytesToNanos(this.maxByteCount);
            return jNanosToBytes;
        }
        long jMin = Math.min(j2, byteCount);
        long jBytesToNanos = jMax + bytesToNanos(jMin - this.maxByteCount);
        if (jBytesToNanos != 0) {
            return -jBytesToNanos;
        }
        this.allocatedUntil = now + bytesToNanos(this.maxByteCount);
        return jMin;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j2) {
        bytesPerSecond$default(this, j2, 0L, 0L, 6, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j2, long j3) {
        bytesPerSecond$default(this, j2, j3, 0L, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long bytesPerSecond, long waitByteCount, long maxByteCount) {
        synchronized (this) {
            if (!(bytesPerSecond >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(waitByteCount > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(maxByteCount >= waitByteCount)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.bytesPerSecond = bytesPerSecond;
            this.waitByteCount = waitByteCount;
            this.maxByteCount = maxByteCount;
            notifyAll();
        }
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        j.e(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler.sink.1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(@NotNull Buffer source, long byteCount) throws InterruptedIOException {
                j.e(source, "source");
                while (byteCount > 0) {
                    try {
                        long jTake$okio = Throttler.this.take$okio(byteCount);
                        super.write(source, jTake$okio);
                        byteCount -= jTake$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull final Source source) {
        j.e(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler.source.1
            @Override // okio.ForwardingSource, okio.Source
            public long read(@NotNull Buffer sink, long byteCount) throws InterruptedIOException {
                j.e(sink, "sink");
                try {
                    return super.read(sink, Throttler.this.take$okio(byteCount));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long byteCount) {
        long jByteCountOrWaitNanos$okio;
        if (!(byteCount > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            while (true) {
                jByteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), byteCount);
                if (jByteCountOrWaitNanos$okio < 0) {
                    waitNanos(-jByteCountOrWaitNanos$okio);
                }
            }
        }
        return jByteCountOrWaitNanos$okio;
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
