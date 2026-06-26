package okio;

import c.a.a.a.a;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RealBufferedSink.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bQ\u0010RJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ'\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001fJ\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020 H\u0016¢\u0006\u0004\b\t\u0010!J'\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\t\u0010\"J\u0017\u0010\t\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020#H\u0016¢\u0006\u0004\b\t\u0010$J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010(J\u0017\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010\u001aJ\u0017\u0010,\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010\u001aJ\u0017\u0010-\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000eH\u0016¢\u0006\u0004\b-\u0010\u001aJ\u0017\u0010/\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010\u001aJ\u0017\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b0\u0010\u001aJ\u0017\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u00103J\u0017\u00105\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u00103J\u0017\u00106\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u00103J\u000f\u00107\u001a\u00020\u0001H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0001H\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\bH\u0016¢\u0006\u0004\bB\u0010>J\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0011H\u0016¢\u0006\u0004\bF\u0010GR\u001d\u0010\u0003\u001a\u00020\u00028Ö\u0002@\u0016X\u0096\u0004¢\u0006\f\u0012\u0004\bI\u0010>\u001a\u0004\bH\u0010\u0004R\u0016\u0010J\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "source", "", "byteCount", "Lf/v;", "write", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "(Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "(Lokio/ByteString;II)Lokio/BufferedSink;", "", "string", "writeUtf8", "(Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "writeUtf8CodePoint", "(I)Lokio/BufferedSink;", "Ljava/nio/charset/Charset;", "charset", "writeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/BufferedSink;", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/BufferedSink;", "", "([B)Lokio/BufferedSink;", "([BII)Lokio/BufferedSink;", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "Lokio/Source;", "writeAll", "(Lokio/Source;)J", "(Lokio/Source;J)Lokio/BufferedSink;", "b", "writeByte", ai.az, "writeShort", "writeShortLe", ai.aA, "writeInt", "writeIntLe", ai.aC, "writeLong", "(J)Lokio/BufferedSink;", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "emitCompleteSegments", "()Lokio/BufferedSink;", "emit", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "flush", "()V", "", "isOpen", "()Z", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "toString", "()Ljava/lang/String;", "getBuffer", "getBuffer$annotations", "closed", "Z", "Lokio/Sink;", "sink", "Lokio/Sink;", "bufferField", "Lokio/Buffer;", "<init>", "(Lokio/Sink;)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class RealBufferedSink implements BufferedSink {

    @JvmField
    @NotNull
    public final Buffer bufferField;

    @JvmField
    public boolean closed;

    @JvmField
    @NotNull
    public final Sink sink;

    public RealBufferedSink(@NotNull Sink sink) {
        j.e(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSink
    @NotNull
    /* JADX INFO: renamed from: buffer, reason: from getter */
    public Buffer getBufferField() {
        return this.bufferField;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (this.bufferField.size() > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.size());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emit() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = this.bufferField.size();
        if (size > 0) {
            this.sink.write(this.bufferField, size);
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emitCompleteSegments() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long jCompleteSegmentByteCount = this.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.bufferField, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        this.sink.flush();
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.RealBufferedSink.outputStream.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws Throwable {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            @NotNull
            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int b2) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.bufferField.writeByte((int) ((byte) b2));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(@NotNull byte[] data, int offset, int byteCount) throws IOException {
                j.e(data, "data");
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.bufferField.write(data, offset, byteCount);
                    RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.Sink
    @NotNull
    /* JADX INFO: renamed from: timeout */
    public Timeout getThis$0() {
        return this.sink.getThis$0();
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("buffer(");
        sbR.append(this.sink);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) {
        j.e(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.bufferField.write(source);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) {
        j.e(source, "source");
        long j2 = 0;
        while (true) {
            long j3 = source.read(this.bufferField, 8192);
            if (j3 == -1) {
                return j2;
            }
            j2 += j3;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeByte(int b2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeByte(b2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeDecimalLong(long v) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeDecimalLong(v);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long v) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeHexadecimalUnsignedLong(v);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeInt(int i2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeInt(i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeIntLe(int i2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeIntLe(i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLong(long v) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeLong(v);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLongLe(long v) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeLongLe(v);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShort(int s) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShort(s);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShortLe(int s) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShortLe(s);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String string, @NotNull Charset charset) {
        j.e(string, "string");
        j.e(charset, "charset");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeString(string, charset);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String string) {
        j.e(string, "string");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8(string);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8CodePoint(int codePoint) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8CodePoint(codePoint);
        return emitCompleteSegments();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        j.e(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, byteCount);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String string, int beginIndex, int endIndex, @NotNull Charset charset) {
        j.e(string, "string");
        j.e(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(string, beginIndex, endIndex, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String string, int beginIndex, int endIndex) {
        j.e(string, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(string, beginIndex, endIndex);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString) {
        j.e(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString, int offset, int byteCount) {
        j.e(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, offset, byteCount);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] source) {
        j.e(source, "source");
        if (!this.closed) {
            this.bufferField.write(source);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] source, int offset, int byteCount) {
        j.e(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, offset, byteCount);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull Source source, long byteCount) throws EOFException {
        j.e(source, "source");
        while (byteCount > 0) {
            long j2 = source.read(this.bufferField, byteCount);
            if (j2 != -1) {
                byteCount -= j2;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
