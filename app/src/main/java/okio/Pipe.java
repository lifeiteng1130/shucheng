package okio;

import c.a.a.a.a;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Pipe.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b0\u00101J-\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\u0082\b¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0011\u001a\u00020\u000e8G@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\u0011\u0010\u0010R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000bR\u0019\u0010\t\u001a\u00020\u00028G@\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b\t\u0010\rR\"\u0010%\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001c\u0010)\u001a\u00020(8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001f¨\u00062"}, d2 = {"Lokio/Pipe;", "", "Lokio/Sink;", "Lkotlin/Function1;", "Lf/v;", "Lkotlin/ExtensionFunctionType;", "block", "forward", "(Lokio/Sink;Lf/c0/b/l;)V", "sink", "fold", "(Lokio/Sink;)V", "-deprecated_sink", "()Lokio/Sink;", "Lokio/Source;", "-deprecated_source", "()Lokio/Source;", "source", "cancel", "()V", "", "maxBufferSize", "J", "getMaxBufferSize$okio", "()J", "", "canceled", "Z", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "Lokio/Source;", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "setFoldedSink$okio", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "<init>", "(J)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class Pipe {

    @NotNull
    private final Buffer buffer = new Buffer();
    private boolean canceled;

    @Nullable
    private Sink foldedSink;
    private final long maxBufferSize;

    @NotNull
    private final Sink sink;
    private boolean sinkClosed;

    @NotNull
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j2) {
        this.maxBufferSize = j2;
        if (!(j2 >= 1)) {
            throw new IllegalArgumentException(a.f("maxBufferSize < 1: ", j2).toString());
        }
        this.sink = new Sink() { // from class: okio.Pipe.sink.1
            private final Timeout timeout = new Timeout();

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                synchronized (Pipe.this.getBuffer()) {
                    if (Pipe.this.getSinkClosed()) {
                        return;
                    }
                    Sink foldedSink = Pipe.this.getFoldedSink();
                    if (foldedSink == null) {
                        if (Pipe.this.getSourceClosed() && Pipe.this.getBuffer().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        Pipe.this.setSinkClosed$okio(true);
                        Buffer buffer = Pipe.this.getBuffer();
                        if (buffer == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer.notifyAll();
                        foldedSink = null;
                    }
                    if (foldedSink != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = foldedSink.getTimeout();
                        Timeout timeout2 = pipe.sink().getTimeout();
                        long timeoutNanos = timeout.getTimeoutNanos();
                        long jMinTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(jMinTimeout, timeUnit);
                        if (!timeout.getHasDeadline()) {
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.clearDeadline();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th;
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink.close();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                            throw th2;
                        }
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                Sink foldedSink;
                synchronized (Pipe.this.getBuffer()) {
                    if (!(!Pipe.this.getSinkClosed())) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (Pipe.this.getCanceled()) {
                        throw new IOException("canceled");
                    }
                    foldedSink = Pipe.this.getFoldedSink();
                    if (foldedSink == null) {
                        if (Pipe.this.getSourceClosed() && Pipe.this.getBuffer().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        foldedSink = null;
                    }
                }
                if (foldedSink != null) {
                    Pipe pipe = Pipe.this;
                    Timeout timeout = foldedSink.getTimeout();
                    Timeout timeout2 = pipe.sink().getTimeout();
                    long timeoutNanos = timeout.getTimeoutNanos();
                    long jMinTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout.timeout(jMinTimeout, timeUnit);
                    if (!timeout.getHasDeadline()) {
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            foldedSink.flush();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                            throw th;
                        }
                    }
                    long jDeadlineNanoTime = timeout.deadlineNanoTime();
                    if (timeout2.getHasDeadline()) {
                        timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                    }
                    try {
                        foldedSink.flush();
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(jDeadlineNanoTime);
                        }
                    } catch (Throwable th2) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(jDeadlineNanoTime);
                        }
                        throw th2;
                    }
                }
            }

            @Override // okio.Sink
            @NotNull
            /* JADX INFO: renamed from: timeout, reason: from getter */
            public Timeout getTimeout() {
                return this.timeout;
            }

            @Override // okio.Sink
            public void write(@NotNull Buffer source, long byteCount) {
                Sink foldedSink;
                j.e(source, "source");
                synchronized (Pipe.this.getBuffer()) {
                    if (!(!Pipe.this.getSinkClosed())) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (!Pipe.this.getCanceled()) {
                        while (true) {
                            if (byteCount <= 0) {
                                foldedSink = null;
                                break;
                            }
                            foldedSink = Pipe.this.getFoldedSink();
                            if (foldedSink != null) {
                                break;
                            }
                            if (Pipe.this.getSourceClosed()) {
                                throw new IOException("source is closed");
                            }
                            long maxBufferSize = Pipe.this.getMaxBufferSize() - Pipe.this.getBuffer().size();
                            if (maxBufferSize == 0) {
                                this.timeout.waitUntilNotified(Pipe.this.getBuffer());
                                if (Pipe.this.getCanceled()) {
                                    throw new IOException("canceled");
                                }
                            } else {
                                long jMin = Math.min(maxBufferSize, byteCount);
                                Pipe.this.getBuffer().write(source, jMin);
                                byteCount -= jMin;
                                Buffer buffer = Pipe.this.getBuffer();
                                if (buffer == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                }
                                buffer.notifyAll();
                            }
                        }
                    } else {
                        throw new IOException("canceled");
                    }
                }
                if (foldedSink != null) {
                    Pipe pipe = Pipe.this;
                    Timeout timeout = foldedSink.getTimeout();
                    Timeout timeout2 = pipe.sink().getTimeout();
                    long timeoutNanos = timeout.getTimeoutNanos();
                    long jMinTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout.timeout(jMinTimeout, timeUnit);
                    if (!timeout.getHasDeadline()) {
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            foldedSink.write(source, byteCount);
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                            throw th;
                        }
                    }
                    long jDeadlineNanoTime = timeout.deadlineNanoTime();
                    if (timeout2.getHasDeadline()) {
                        timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                    }
                    try {
                        foldedSink.write(source, byteCount);
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(jDeadlineNanoTime);
                        }
                    } catch (Throwable th2) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(jDeadlineNanoTime);
                        }
                        throw th2;
                    }
                }
            }
        };
        this.source = new Source() { // from class: okio.Pipe.source.1
            private final Timeout timeout = new Timeout();

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                synchronized (Pipe.this.getBuffer()) {
                    Pipe.this.setSourceClosed$okio(true);
                    Buffer buffer = Pipe.this.getBuffer();
                    if (buffer == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    buffer.notifyAll();
                }
            }

            @Override // okio.Source
            public long read(@NotNull Buffer sink, long byteCount) {
                j.e(sink, "sink");
                synchronized (Pipe.this.getBuffer()) {
                    if (!(!Pipe.this.getSourceClosed())) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (Pipe.this.getCanceled()) {
                        throw new IOException("canceled");
                    }
                    while (Pipe.this.getBuffer().size() == 0) {
                        if (Pipe.this.getSinkClosed()) {
                            return -1L;
                        }
                        this.timeout.waitUntilNotified(Pipe.this.getBuffer());
                        if (Pipe.this.getCanceled()) {
                            throw new IOException("canceled");
                        }
                    }
                    long j3 = Pipe.this.getBuffer().read(sink, byteCount);
                    Buffer buffer = Pipe.this.getBuffer();
                    if (buffer == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    buffer.notifyAll();
                    return j3;
                }
            }

            @Override // okio.Source
            @NotNull
            /* JADX INFO: renamed from: timeout, reason: from getter */
            public Timeout getTimeout() {
                return this.timeout;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forward(Sink sink, l<? super Sink, v> lVar) {
        Timeout timeout = sink.getTimeout();
        Timeout timeout2 = sink().getTimeout();
        long timeoutNanos = timeout.getTimeoutNanos();
        long jMinTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(jMinTimeout, timeUnit);
        if (!timeout.getHasDeadline()) {
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                lVar.invoke(sink);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.getHasDeadline()) {
                    timeout.clearDeadline();
                    return;
                }
                return;
            } catch (Throwable th) {
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.getHasDeadline()) {
                    timeout.clearDeadline();
                }
                throw th;
            }
        }
        long jDeadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.getHasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            lVar.invoke(sink);
            timeout.timeout(timeoutNanos, timeUnit);
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
        } catch (Throwable th2) {
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
            throw th2;
        }
    }

    @Deprecated(level = f.a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    @JvmName(name = "-deprecated_sink")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_sink, reason: not valid java name and from getter */
    public final Sink getSink() {
        return this.sink;
    }

    @Deprecated(level = f.a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}))
    @JvmName(name = "-deprecated_source")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_source, reason: not valid java name and from getter */
    public final Source getSource() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            this.canceled = true;
            this.buffer.clear();
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
            buffer.notifyAll();
        }
    }

    public final void fold(@NotNull Sink sink) {
        boolean z;
        Buffer buffer;
        j.e(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                }
                z = this.sinkClosed;
                buffer = new Buffer();
                Buffer buffer2 = this.buffer;
                buffer.write(buffer2, buffer2.size());
                Buffer buffer3 = this.buffer;
                if (buffer3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                buffer3.notifyAll();
            }
            try {
                sink.write(buffer, buffer.size());
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    Buffer buffer4 = this.buffer;
                    if (buffer4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    buffer4.notifyAll();
                    throw th;
                }
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getBuffer$okio, reason: from getter */
    public final Buffer getBuffer() {
        return this.buffer;
    }

    /* JADX INFO: renamed from: getCanceled$okio, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    @Nullable
    /* JADX INFO: renamed from: getFoldedSink$okio, reason: from getter */
    public final Sink getFoldedSink() {
        return this.foldedSink;
    }

    /* JADX INFO: renamed from: getMaxBufferSize$okio, reason: from getter */
    public final long getMaxBufferSize() {
        return this.maxBufferSize;
    }

    /* JADX INFO: renamed from: getSinkClosed$okio, reason: from getter */
    public final boolean getSinkClosed() {
        return this.sinkClosed;
    }

    /* JADX INFO: renamed from: getSourceClosed$okio, reason: from getter */
    public final boolean getSourceClosed() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @JvmName(name = "sink")
    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @JvmName(name = "source")
    @NotNull
    public final Source source() {
        return this.source;
    }
}
