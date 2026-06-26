package okio.internal;

import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import c.b.a.m.f;
import f.c0.c.j;
import java.io.EOFException;
import kotlin.Metadata;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0080\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u0012*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u001c\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0080\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0014\u0010\u001c\u001a\u00020\u001b*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001bH\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a,\u0010\u0005\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0018H\u0080\b¢\u0006\u0004\b\u0005\u0010\"\u001a$\u0010\u001f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u001f\u0010#\u001a\u001c\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020$H\u0080\b¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010(\u001a\u00020'*\u00020\u0000H\u0080\b¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010(\u001a\u00020'*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b(\u0010*\u001a\u0016\u0010+\u001a\u0004\u0018\u00010'*\u00020\u0000H\u0080\b¢\u0006\u0004\b+\u0010)\u001a\u001c\u0010-\u001a\u00020'*\u00020\u00002\u0006\u0010,\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b-\u0010*\u001a\u0014\u0010.\u001a\u00020\u0018*\u00020\u0000H\u0080\b¢\u0006\u0004\b.\u0010/\u001a\u0014\u00101\u001a\u000200*\u00020\u0000H\u0080\b¢\u0006\u0004\b1\u00102\u001a\u0014\u00103\u001a\u000200*\u00020\u0000H\u0080\b¢\u0006\u0004\b3\u00102\u001a\u0014\u00104\u001a\u00020\u0018*\u00020\u0000H\u0080\b¢\u0006\u0004\b4\u0010/\u001a\u0014\u00105\u001a\u00020\u0018*\u00020\u0000H\u0080\b¢\u0006\u0004\b5\u0010/\u001a\u0014\u00106\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b6\u00107\u001a\u0014\u00108\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b8\u00107\u001a\u0014\u00109\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b9\u00107\u001a\u0014\u0010:\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b:\u00107\u001a\u001c\u0010;\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b;\u0010\f\u001a,\u0010?\u001a\u00020\u0003*\u00020\u00002\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b?\u0010@\u001a$\u0010?\u001a\u00020\u0003*\u00020\u00002\u0006\u0010A\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b?\u0010B\u001a$\u0010D\u001a\u00020\u0003*\u00020\u00002\u0006\u0010C\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\bD\u0010B\u001a4\u0010F\u001a\u00020\u0007*\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0018H\u0080\b¢\u0006\u0004\bF\u0010G\u001a\u0014\u0010I\u001a\u00020H*\u00020\u0000H\u0080\b¢\u0006\u0004\bI\u0010J\u001a\u0014\u0010K\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\bK\u0010L\u001a\u0014\u0010N\u001a\u00020M*\u00020\u0000H\u0080\b¢\u0006\u0004\bN\u0010O\u001a\u0014\u0010P\u001a\u00020'*\u00020\u0000H\u0080\b¢\u0006\u0004\bP\u0010)¨\u0006Q"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/Buffer;", "sink", "", "byteCount", "commonRead", "(Lokio/RealBufferedSource;Lokio/Buffer;J)J", "", "commonExhausted", "(Lokio/RealBufferedSource;)Z", "Lf/v;", "commonRequire", "(Lokio/RealBufferedSource;J)V", "commonRequest", "(Lokio/RealBufferedSource;J)Z", "", "commonReadByte", "(Lokio/RealBufferedSource;)B", "Lokio/ByteString;", "commonReadByteString", "(Lokio/RealBufferedSource;)Lokio/ByteString;", "(Lokio/RealBufferedSource;J)Lokio/ByteString;", "Lokio/Options;", "options", "", "commonSelect", "(Lokio/RealBufferedSource;Lokio/Options;)I", "", "commonReadByteArray", "(Lokio/RealBufferedSource;)[B", "(Lokio/RealBufferedSource;J)[B", "commonReadFully", "(Lokio/RealBufferedSource;[B)V", "offset", "(Lokio/RealBufferedSource;[BII)I", "(Lokio/RealBufferedSource;Lokio/Buffer;J)V", "Lokio/Sink;", "commonReadAll", "(Lokio/RealBufferedSource;Lokio/Sink;)J", "", "commonReadUtf8", "(Lokio/RealBufferedSource;)Ljava/lang/String;", "(Lokio/RealBufferedSource;J)Ljava/lang/String;", "commonReadUtf8Line", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", "(Lokio/RealBufferedSource;)I", "", "commonReadShort", "(Lokio/RealBufferedSource;)S", "commonReadShortLe", "commonReadInt", "commonReadIntLe", "commonReadLong", "(Lokio/RealBufferedSource;)J", "commonReadLongLe", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonSkip", "b", "fromIndex", "toIndex", "commonIndexOf", "(Lokio/RealBufferedSource;BJJ)J", "bytes", "(Lokio/RealBufferedSource;Lokio/ByteString;J)J", "targetBytes", "commonIndexOfElement", "bytesOffset", "commonRangeEquals", "(Lokio/RealBufferedSource;JLokio/ByteString;II)Z", "Lokio/BufferedSource;", "commonPeek", "(Lokio/RealBufferedSource;)Lokio/BufferedSource;", "commonClose", "(Lokio/RealBufferedSource;)V", "Lokio/Timeout;", "commonTimeout", "(Lokio/RealBufferedSource;)Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 4, 0})
public final class RealBufferedSourceKt {
    public static final void commonClose(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonClose");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(@NotNull RealBufferedSource realBufferedSource) {
        j.e(realBufferedSource, "$this$commonExhausted");
        if (!realBufferedSource.closed) {
            return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource realBufferedSource, byte b2, long j2, long j3) {
        j.e(realBufferedSource, "$this$commonIndexOf");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        while (j2 < j3) {
            long jIndexOf = realBufferedSource.bufferField.indexOf(b2, j2, j3);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (size >= j3 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                break;
            }
            j2 = Math.max(j2, size);
        }
        return -1L;
    }

    public static final long commonIndexOfElement(@NotNull RealBufferedSource realBufferedSource, @NotNull ByteString byteString, long j2) {
        j.e(realBufferedSource, "$this$commonIndexOfElement");
        j.e(byteString, "targetBytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j2);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull RealBufferedSource realBufferedSource) {
        j.e(realBufferedSource, "$this$commonPeek");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(@NotNull RealBufferedSource realBufferedSource, long j2, @NotNull ByteString byteString, int i2, int i3) {
        j.e(realBufferedSource, "$this$commonRangeEquals");
        j.e(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j2 < 0 || i2 < 0 || i3 < 0 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            long j3 = ((long) i4) + j2;
            if (!realBufferedSource.request(1 + j3) || realBufferedSource.bufferField.getByte(j3) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public static final long commonRead(@NotNull RealBufferedSource realBufferedSource, @NotNull Buffer buffer, long j2) {
        j.e(realBufferedSource, "$this$commonRead");
        j.e(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(a.f("byteCount < 0: ", j2).toString());
        }
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1L;
        }
        return realBufferedSource.bufferField.read(buffer, Math.min(j2, realBufferedSource.bufferField.size()));
    }

    public static final long commonReadAll(@NotNull RealBufferedSource realBufferedSource, @NotNull Sink sink) {
        j.e(realBufferedSource, "$this$commonReadAll");
        j.e(sink, "sink");
        long j2 = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1) {
            long jCompleteSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j2 += jCompleteSegmentByteCount;
                sink.write(realBufferedSource.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j2;
        }
        long size = j2 + realBufferedSource.bufferField.size();
        Buffer buffer = realBufferedSource.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadByte");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource realBufferedSource, long j2) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readByteArray(j2);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource realBufferedSource, long j2) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readByteString(j2);
    }

    public static final long commonReadDecimalLong(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        byte b2;
        j.e(realBufferedSource, "$this$commonReadDecimalLong");
        realBufferedSource.require(1L);
        long j2 = 0;
        while (true) {
            long j3 = j2 + 1;
            if (!realBufferedSource.request(j3)) {
                break;
            }
            b2 = realBufferedSource.bufferField.getByte(j2);
            if ((b2 < ((byte) 48) || b2 > ((byte) 57)) && !(j2 == 0 && b2 == ((byte) 45))) {
                break;
            }
            j2 = j3;
        }
        if (j2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9] or '-' character but was 0x");
            f.N0(16);
            f.N0(16);
            String string = Integer.toString(b2, 16);
            j.d(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(@NotNull RealBufferedSource realBufferedSource, @NotNull byte[] bArr) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadFully");
        j.e(bArr, "sink");
        try {
            realBufferedSource.require(bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int i3 = buffer.read(bArr, i2, (int) buffer.size());
                if (i3 == -1) {
                    throw new AssertionError();
                }
                i2 += i3;
            }
            throw e2;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        byte b2;
        j.e(realBufferedSource, "$this$commonReadHexadecimalUnsignedLong");
        realBufferedSource.require(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!realBufferedSource.request(i3)) {
                break;
            }
            b2 = realBufferedSource.bufferField.getByte(i2);
            if ((b2 < ((byte) 48) || b2 > ((byte) 57)) && ((b2 < ((byte) 97) || b2 > ((byte) 102)) && (b2 < ((byte) 65) || b2 > ((byte) 70)))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            f.N0(16);
            f.N0(16);
            String string = Integer.toString(b2, 16);
            j.d(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadInt");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadIntLe");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadLong");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadLongLe");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadShort");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadShortLe");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource realBufferedSource, long j2) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readUtf8(j2);
    }

    public static final int commonReadUtf8CodePoint(@NotNull RealBufferedSource realBufferedSource) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadUtf8CodePoint");
        realBufferedSource.require(1L);
        byte b2 = realBufferedSource.bufferField.getByte(0L);
        if ((b2 & 224) == 192) {
            realBufferedSource.require(2L);
        } else if ((b2 & 240) == 224) {
            realBufferedSource.require(3L);
        } else if ((b2 & 248) == 240) {
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull RealBufferedSource realBufferedSource) {
        j.e(realBufferedSource, "$this$commonReadUtf8Line");
        long jIndexOf = realBufferedSource.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, jIndexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull RealBufferedSource realBufferedSource, long j2) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadUtf8LineStrict");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(a.f("limit < 0: ", j2).toString());
        }
        long j3 = j2 == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j2 + 1;
        byte b2 = (byte) 10;
        long jIndexOf = realBufferedSource.indexOf(b2, 0L, j3);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, jIndexOf);
        }
        if (j3 < RecyclerView.FOREVER_NS && realBufferedSource.request(j3) && realBufferedSource.bufferField.getByte(j3 - 1) == ((byte) 13) && realBufferedSource.request(1 + j3) && realBufferedSource.bufferField.getByte(j3) == b2) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, j3);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = realBufferedSource.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        StringBuilder sbR = a.r("\\n not found: limit=");
        sbR.append(Math.min(realBufferedSource.bufferField.size(), j2));
        sbR.append(" content=");
        sbR.append(buffer.readByteString().hex());
        sbR.append("…");
        throw new EOFException(sbR.toString());
    }

    public static final boolean commonRequest(@NotNull RealBufferedSource realBufferedSource, long j2) {
        j.e(realBufferedSource, "$this$commonRequest");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(a.f("byteCount < 0: ", j2).toString());
        }
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (realBufferedSource.bufferField.size() < j2) {
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(@NotNull RealBufferedSource realBufferedSource, long j2) throws EOFException {
        j.e(realBufferedSource, "$this$commonRequire");
        if (!realBufferedSource.request(j2)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@NotNull RealBufferedSource realBufferedSource, @NotNull Options options) throws EOFException {
        j.e(realBufferedSource, "$this$commonSelect");
        j.e(options, "options");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iSelectPrefix = BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                realBufferedSource.bufferField.skip(options.getByteStrings()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1);
        return -1;
    }

    public static final void commonSkip(@NotNull RealBufferedSource realBufferedSource, long j2) throws EOFException {
        j.e(realBufferedSource, "$this$commonSkip");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j2, realBufferedSource.bufferField.size());
            realBufferedSource.bufferField.skip(jMin);
            j2 -= jMin;
        }
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSource realBufferedSource) {
        j.e(realBufferedSource, "$this$commonTimeout");
        return realBufferedSource.source.getTimeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSource realBufferedSource) {
        j.e(realBufferedSource, "$this$commonToString");
        return "buffer(" + realBufferedSource.source + ')';
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource realBufferedSource) {
        j.e(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource realBufferedSource) {
        j.e(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource realBufferedSource) {
        j.e(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(@NotNull RealBufferedSource realBufferedSource, @NotNull Buffer buffer, long j2) throws EOFException {
        j.e(realBufferedSource, "$this$commonReadFully");
        j.e(buffer, "sink");
        try {
            realBufferedSource.require(j2);
            realBufferedSource.bufferField.readFully(buffer, j2);
        } catch (EOFException e2) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e2;
        }
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource realBufferedSource, @NotNull ByteString byteString, long j2) {
        j.e(realBufferedSource, "$this$commonIndexOf");
        j.e(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOf = realBufferedSource.bufferField.indexOf(byteString, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (size - ((long) byteString.size())) + 1);
        }
    }

    public static final int commonRead(@NotNull RealBufferedSource realBufferedSource, @NotNull byte[] bArr, int i2, int i3) {
        j.e(realBufferedSource, "$this$commonRead");
        j.e(bArr, "sink");
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i2, (int) Math.min(j2, realBufferedSource.bufferField.size()));
    }
}
