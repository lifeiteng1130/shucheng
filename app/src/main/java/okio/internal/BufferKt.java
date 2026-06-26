package okio.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.bw;
import f.c0.b.p;
import f.c0.c.j;
import f.x.e;
import java.io.EOFException;
import kotlin.Metadata;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0012\u001a7\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aA\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0011*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\f2\u001a\u0010\u0014\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001a\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a,\u0010\u001f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010$\u001a\u00020#*\u00020\u000bH\u0080\b¢\u0006\u0004\b$\u0010%\u001a\u0014\u0010'\u001a\u00020&*\u00020\u000bH\u0080\b¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010+\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\b+\u0010\"\u001a\u001c\u0010-\u001a\u00020#*\u00020\u000b2\u0006\u0010,\u001a\u00020\fH\u0080\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u00100\u001a\u00020/*\u00020\u000bH\u0080\b¢\u0006\u0004\b0\u00101\u001a\u001c\u00102\u001a\u00020/*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b2\u00103\u001a0\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u00105\u001a\u0002042\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b6\u00107\u001a\u001c\u00109\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\b9\u0010:\u001a\u001c\u0010;\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\b;\u0010:\u001a\u001c\u0010=\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010<\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b=\u0010>\u001a\u001c\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\b6\u0010@\u001a,\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b6\u0010A\u001a\u0014\u0010B\u001a\u00020\u0004*\u00020\u000bH\u0080\b¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010B\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bB\u0010D\u001a\u001c\u0010F\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010E\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\bF\u0010G\u001a\u001c\u0010H\u001a\u00020/*\u00020\u000b2\u0006\u0010E\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\bH\u0010I\u001a,\u0010F\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bF\u0010J\u001a\u0014\u0010K\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\bK\u0010\"\u001a\u0014\u0010L\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\bL\u0010\"\u001a\u0014\u0010M\u001a\u000204*\u00020\u000bH\u0080\b¢\u0006\u0004\bM\u0010N\u001a\u001c\u0010M\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bM\u0010O\u001a\u001c\u0010P\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0080\b¢\u0006\u0004\bP\u0010Q\u001a$\u0010H\u001a\u00020/*\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bH\u0010R\u001a\u001c\u0010T\u001a\u00020\f*\u00020\u000b2\u0006\u0010E\u001a\u00020SH\u0080\b¢\u0006\u0004\bT\u0010U\u001a\u001c\u0010V\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bV\u0010\u0010\u001a\u0016\u0010W\u001a\u0004\u0018\u00010\u000e*\u00020\u000bH\u0080\b¢\u0006\u0004\bW\u0010X\u001a\u001c\u0010Z\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010Y\u001a\u00020\fH\u0080\b¢\u0006\u0004\bZ\u0010\u0010\u001a\u0014\u0010[\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0004\b[\u0010*\u001a,\u0010_\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u00022\u0006\u0010^\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b_\u0010`\u001a\u001c\u0010b\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010a\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bb\u0010c\u001a\u001c\u0010e\u001a\u00020\f*\u00020\u000b2\u0006\u0010?\u001a\u00020dH\u0080\b¢\u0006\u0004\be\u0010f\u001a$\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020d2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b6\u0010g\u001a\u001c\u0010i\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010h\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bi\u0010c\u001a\u001c\u0010k\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010j\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bk\u0010c\u001a\u001c\u0010m\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010l\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bm\u0010c\u001a\u001c\u0010n\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\bn\u0010:\u001a$\u00106\u001a\u00020/*\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b6\u0010R\u001a$\u0010F\u001a\u00020\f*\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bF\u0010o\u001a,\u0010q\u001a\u00020\f*\u00020\u000b2\u0006\u0010h\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010p\u001a\u00020\fH\u0080\b¢\u0006\u0004\bq\u0010r\u001a$\u0010q\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\u0080\b¢\u0006\u0004\bq\u0010s\u001a$\u0010u\u001a\u00020\f*\u00020\u000b2\u0006\u0010t\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\u0080\b¢\u0006\u0004\bu\u0010s\u001a4\u0010v\u001a\u00020\b*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bv\u0010w\u001a\u001e\u0010z\u001a\u00020\b*\u00020\u000b2\b\u0010y\u001a\u0004\u0018\u00010xH\u0080\b¢\u0006\u0004\bz\u0010{\u001a\u0014\u0010|\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0004\b|\u0010*\u001a\u0014\u0010}\u001a\u00020\u000b*\u00020\u000bH\u0080\b¢\u0006\u0004\b}\u0010~\u001a\u0014\u0010\u007f\u001a\u000204*\u00020\u000bH\u0080\b¢\u0006\u0004\b\u007f\u0010N\u001a\u001d\u0010\u007f\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0005\b\u007f\u0010\u0080\u0001\"\u0019\u0010\u0081\u0001\u001a\u00020\f8\u0000@\u0000X\u0080T¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0019\u0010\u0083\u0001\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001\"!\u0010\u0085\u0001\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0019\u0010\u0089\u0001\u001a\u00020\f8\u0000@\u0000X\u0080T¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0082\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008a\u0001"}, d2 = {"Lokio/Segment;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "rangeEquals", "(Lokio/Segment;I[BII)Z", "Lokio/Buffer;", "", "newline", "", "readUtf8Line", "(Lokio/Buffer;J)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "fromIndex", "Lkotlin/Function2;", "lambda", "seek", "(Lokio/Buffer;JLf/c0/b/p;)Ljava/lang/Object;", "Lokio/Options;", "options", "selectTruncated", "selectPrefix", "(Lokio/Buffer;Lokio/Options;Z)I", "out", "offset", "byteCount", "commonCopyTo", "(Lokio/Buffer;Lokio/Buffer;JJ)Lokio/Buffer;", "commonCompleteSegmentByteCount", "(Lokio/Buffer;)J", "", "commonReadByte", "(Lokio/Buffer;)B", "", "commonReadShort", "(Lokio/Buffer;)S", "commonReadInt", "(Lokio/Buffer;)I", "commonReadLong", "pos", "commonGet", "(Lokio/Buffer;J)B", "Lf/v;", "commonClear", "(Lokio/Buffer;)V", "commonSkip", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "commonWrite", "(Lokio/Buffer;Lokio/ByteString;II)Lokio/Buffer;", ai.aC, "commonWriteDecimalLong", "(Lokio/Buffer;J)Lokio/Buffer;", "commonWriteHexadecimalUnsignedLong", "minimumCapacity", "commonWritableSegment", "(Lokio/Buffer;I)Lokio/Segment;", "source", "(Lokio/Buffer;[B)Lokio/Buffer;", "(Lokio/Buffer;[BII)Lokio/Buffer;", "commonReadByteArray", "(Lokio/Buffer;)[B", "(Lokio/Buffer;J)[B", "sink", "commonRead", "(Lokio/Buffer;[B)I", "commonReadFully", "(Lokio/Buffer;[B)V", "(Lokio/Buffer;[BII)I", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "(Lokio/Buffer;)Lokio/ByteString;", "(Lokio/Buffer;J)Lokio/ByteString;", "commonSelect", "(Lokio/Buffer;Lokio/Options;)I", "(Lokio/Buffer;Lokio/Buffer;J)V", "Lokio/Sink;", "commonReadAll", "(Lokio/Buffer;Lokio/Sink;)J", "commonReadUtf8", "commonReadUtf8Line", "(Lokio/Buffer;)Ljava/lang/String;", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", "string", "beginIndex", "endIndex", "commonWriteUtf8", "(Lokio/Buffer;Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "commonWriteUtf8CodePoint", "(Lokio/Buffer;I)Lokio/Buffer;", "Lokio/Source;", "commonWriteAll", "(Lokio/Buffer;Lokio/Source;)J", "(Lokio/Buffer;Lokio/Source;J)Lokio/Buffer;", "b", "commonWriteByte", ai.az, "commonWriteShort", ai.aA, "commonWriteInt", "commonWriteLong", "(Lokio/Buffer;Lokio/Buffer;J)J", "toIndex", "commonIndexOf", "(Lokio/Buffer;BJJ)J", "(Lokio/Buffer;Lokio/ByteString;J)J", "targetBytes", "commonIndexOfElement", "commonRangeEquals", "(Lokio/Buffer;JLokio/ByteString;II)Z", "", "other", "commonEquals", "(Lokio/Buffer;Ljava/lang/Object;)Z", "commonHashCode", "commonCopy", "(Lokio/Buffer;)Lokio/Buffer;", "commonSnapshot", "(Lokio/Buffer;I)Lokio/ByteString;", "OVERFLOW_DIGIT_START", "J", "SEGMENTING_THRESHOLD", OptRuntime.GeneratorState.resumptionPoint_TYPE, "HEX_DIGIT_BYTES", "[B", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_ZONE", "okio"}, k = 2, mv = {1, 4, 0})
public final class BufferKt {

    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@NotNull Buffer buffer) throws EOFException {
        j.e(buffer, "$this$commonClear");
        buffer.skip(buffer.size());
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer buffer) {
        j.e(buffer, "$this$commonCompleteSegmentByteCount");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        j.c(segment);
        Segment segment2 = segment.prev;
        j.c(segment2);
        int i2 = segment2.limit;
        return (i2 >= 8192 || !segment2.owner) ? size : size - ((long) (i2 - segment2.pos));
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer buffer) {
        j.e(buffer, "$this$commonCopy");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        j.c(segment);
        Segment segmentSharedCopy = segment.sharedCopy();
        buffer2.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = segmentSharedCopy.prev;
            j.c(segment3);
            j.c(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j2, long j3) {
        j.e(buffer, "$this$commonCopyTo");
        j.e(buffer2, "out");
        Util.checkOffsetAndCount(buffer.size(), j2, j3);
        if (j3 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j3);
        Segment segment = buffer.head;
        while (true) {
            j.c(segment);
            int i2 = segment.limit;
            int i3 = segment.pos;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= (long) (i2 - i3);
            segment = segment.next;
        }
        while (j3 > 0) {
            j.c(segment);
            Segment segmentSharedCopy = segment.sharedCopy();
            int i4 = segmentSharedCopy.pos + ((int) j2);
            segmentSharedCopy.pos = i4;
            segmentSharedCopy.limit = Math.min(i4 + ((int) j3), segmentSharedCopy.limit);
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                segmentSharedCopy.prev = segmentSharedCopy;
                segmentSharedCopy.next = segmentSharedCopy;
                buffer2.head = segmentSharedCopy;
            } else {
                j.c(segment2);
                Segment segment3 = segment2.prev;
                j.c(segment3);
                segment3.push(segmentSharedCopy);
            }
            j3 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
            segment = segment.next;
            j2 = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(@NotNull Buffer buffer, @Nullable Object obj) {
        j.e(buffer, "$this$commonEquals");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer2 = (Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        j.c(segment);
        Segment segment2 = buffer2.head;
        j.c(segment2);
        int i2 = segment.pos;
        int i3 = segment2.pos;
        long j2 = 0;
        while (j2 < buffer.size()) {
            long jMin = Math.min(segment.limit - i2, segment2.limit - i3);
            long j3 = 0;
            while (j3 < jMin) {
                int i4 = i2 + 1;
                int i5 = i3 + 1;
                if (segment.data[i2] != segment2.data[i3]) {
                    return false;
                }
                j3++;
                i2 = i4;
                i3 = i5;
            }
            if (i2 == segment.limit) {
                segment = segment.next;
                j.c(segment);
                i2 = segment.pos;
            }
            if (i3 == segment2.limit) {
                segment2 = segment2.next;
                j.c(segment2);
                i3 = segment2.pos;
            }
            j2 += jMin;
        }
        return true;
    }

    public static final byte commonGet(@NotNull Buffer buffer, long j2) {
        j.e(buffer, "$this$commonGet");
        Util.checkOffsetAndCount(buffer.size(), j2, 1L);
        Segment segment = buffer.head;
        if (segment == null) {
            Segment segment2 = null;
            j.c(null);
            return segment2.data[(int) ((((long) segment2.pos) + j2) - (-1))];
        }
        if (buffer.size() - j2 < j2) {
            long size = buffer.size();
            while (size > j2) {
                segment = segment.prev;
                j.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            j.c(segment);
            return segment.data[(int) ((((long) segment.pos) + j2) - size)];
        }
        long j3 = 0;
        while (true) {
            long j4 = ((long) (segment.limit - segment.pos)) + j3;
            if (j4 > j2) {
                j.c(segment);
                return segment.data[(int) ((((long) segment.pos) + j2) - j3)];
            }
            segment = segment.next;
            j.c(segment);
            j3 = j4;
        }
    }

    public static final int commonHashCode(@NotNull Buffer buffer) {
        j.e(buffer, "$this$commonHashCode");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.limit;
            for (int i4 = segment.pos; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.data[i4];
            }
            segment = segment.next;
            j.c(segment);
        } while (segment != buffer.head);
        return i2;
    }

    public static final long commonIndexOf(@NotNull Buffer buffer, byte b2, long j2, long j3) {
        Segment segment;
        int i2;
        j.e(buffer, "$this$commonIndexOf");
        long size = 0;
        if (!(0 <= j2 && j3 >= j2)) {
            StringBuilder sbR = a.r("size=");
            sbR.append(buffer.size());
            sbR.append(" fromIndex=");
            sbR.append(j2);
            sbR.append(" toIndex=");
            sbR.append(j3);
            throw new IllegalArgumentException(sbR.toString().toString());
        }
        if (j3 > buffer.size()) {
            j3 = buffer.size();
        }
        if (j2 == j3 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j2 < j2) {
            size = buffer.size();
            while (size > j2) {
                segment = segment.prev;
                j.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            while (size < j3) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j3) - size);
                i2 = (int) ((((long) segment.pos) + j2) - size);
                while (i2 < iMin) {
                    if (bArr[i2] != b2) {
                        i2++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j.c(segment);
                j2 = size;
            }
            return -1L;
        }
        while (true) {
            long j4 = ((long) (segment.limit - segment.pos)) + size;
            if (j4 > j2) {
                break;
            }
            segment = segment.next;
            j.c(segment);
            size = j4;
        }
        while (size < j3) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j3) - size);
            i2 = (int) ((((long) segment.pos) + j2) - size);
            while (i2 < iMin2) {
                if (bArr2[i2] != b2) {
                    i2++;
                }
            }
            size += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j.c(segment);
            j2 = size;
        }
        return -1L;
        return ((long) (i2 - segment.pos)) + size;
    }

    public static final long commonIndexOfElement(@NotNull Buffer buffer, @NotNull ByteString byteString, long j2) {
        int i2;
        int i3;
        j.e(buffer, "$this$commonIndexOfElement");
        j.e(byteString, "targetBytes");
        long size = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(a.f("fromIndex < 0: ", j2).toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            return -1L;
        }
        if (buffer.size() - j2 < j2) {
            size = buffer.size();
            while (size > j2) {
                segment = segment.prev;
                j.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            if (byteString.size() == 2) {
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (size < buffer.size()) {
                    byte[] bArr = segment.data;
                    i2 = (int) ((((long) segment.pos) + j2) - size);
                    int i4 = segment.limit;
                    while (i2 < i4) {
                        byte b4 = bArr[i2];
                        if (b4 == b2 || b4 == b3) {
                            i3 = segment.pos;
                        } else {
                            i2++;
                        }
                    }
                    size += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j.c(segment);
                    j2 = size;
                }
            } else {
                byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                while (size < buffer.size()) {
                    byte[] bArr2 = segment.data;
                    i2 = (int) ((((long) segment.pos) + j2) - size);
                    int i5 = segment.limit;
                    while (i2 < i5) {
                        byte b5 = bArr2[i2];
                        for (byte b6 : bArrInternalArray$okio) {
                            if (b5 == b6) {
                                i3 = segment.pos;
                            }
                        }
                        i2++;
                    }
                    size += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j.c(segment);
                    j2 = size;
                }
            }
            return -1L;
        }
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + size;
            if (j3 > j2) {
                break;
            }
            segment = segment.next;
            j.c(segment);
            size = j3;
        }
        if (byteString.size() == 2) {
            byte b7 = byteString.getByte(0);
            byte b8 = byteString.getByte(1);
            while (size < buffer.size()) {
                byte[] bArr3 = segment.data;
                i2 = (int) ((((long) segment.pos) + j2) - size);
                int i6 = segment.limit;
                while (i2 < i6) {
                    byte b9 = bArr3[i2];
                    if (b9 == b7 || b9 == b8) {
                        i3 = segment.pos;
                    } else {
                        i2++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j.c(segment);
                j2 = size;
            }
        } else {
            byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
            while (size < buffer.size()) {
                byte[] bArr4 = segment.data;
                i2 = (int) ((((long) segment.pos) + j2) - size);
                int i7 = segment.limit;
                while (i2 < i7) {
                    byte b10 = bArr4[i2];
                    for (byte b11 : bArrInternalArray$okio2) {
                        if (b10 == b11) {
                            i3 = segment.pos;
                        }
                    }
                    i2++;
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j.c(segment);
                j2 = size;
            }
        }
        return -1L;
        return ((long) (i2 - i3)) + size;
    }

    public static final boolean commonRangeEquals(@NotNull Buffer buffer, long j2, @NotNull ByteString byteString, int i2, int i3) {
        j.e(buffer, "$this$commonRangeEquals");
        j.e(byteString, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || buffer.size() - j2 < i3 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (buffer.getByte(((long) i4) + j2) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        j.e(buffer, "$this$commonRead");
        j.e(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(@NotNull Buffer buffer, @NotNull Sink sink) {
        j.e(buffer, "$this$commonReadAll");
        j.e(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final byte commonReadByte(@NotNull Buffer buffer) throws EOFException {
        j.e(buffer, "$this$commonReadByte");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        j.c(segment);
        int i2 = segment.pos;
        int i3 = segment.limit;
        int i4 = i2 + 1;
        byte b2 = segment.data[i2];
        buffer.setSize$okio(buffer.size() - 1);
        if (i4 == i3) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return b2;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer) {
        j.e(buffer, "$this$commonReadByteArray");
        return buffer.readByteArray(buffer.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer) {
        j.e(buffer, "$this$commonReadByteString");
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0 A[EDGE_INSN: B:48:0x00b0->B:38:0x00b0 BREAK  A[LOOP:0: B:5:0x0016->B:50:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.Buffer r17) throws java.io.EOFException {
        /*
            r0 = r17
            java.lang.String r1 = "$this$commonReadDecimalLong"
            f.c0.c.j.e(r0, r1)
            long r1 = r17.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lbe
            r1 = -7
            r5 = 0
            r6 = 0
            r7 = 0
        L16:
            okio.Segment r8 = r0.head
            f.c0.c.j.c(r8)
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L21:
            if (r10 >= r11) goto L9c
            r12 = r9[r10]
            r13 = 48
            byte r13 = (byte) r13
            if (r12 < r13) goto L71
            r14 = 57
            byte r14 = (byte) r14
            if (r12 > r14) goto L71
            int r13 = r13 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r16 < 0) goto L48
            if (r16 != 0) goto L41
            long r14 = (long) r13
            int r16 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r16 >= 0) goto L41
            goto L48
        L41:
            r14 = 10
            long r3 = r3 * r14
            long r12 = (long) r13
            long r3 = r3 + r12
            goto L7c
        L48:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong(r3)
            okio.Buffer r0 = r0.writeByte(r12)
            if (r6 != 0) goto L5a
            r0.readByte()
        L5a:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r2 = c.a.a.a.a.r(r2)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L71:
            r13 = 45
            byte r13 = (byte) r13
            if (r12 != r13) goto L81
            if (r5 != 0) goto L81
            r12 = 1
            long r1 = r1 - r12
            r6 = 1
        L7c:
            int r10 = r10 + 1
            int r5 = r5 + 1
            goto L21
        L81:
            if (r5 == 0) goto L85
            r7 = 1
            goto L9c
        L85:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r1 = c.a.a.a.a.r(r1)
            java.lang.String r2 = okio.Util.toHexString(r12)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9c:
            if (r10 != r11) goto La8
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto Laa
        La8:
            r8.pos = r10
        Laa:
            if (r7 != 0) goto Lb0
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L16
        Lb0:
            long r1 = r17.size()
            long r7 = (long) r5
            long r1 = r1 - r7
            r0.setSize$okio(r1)
            if (r6 == 0) goto Lbc
            goto Lbd
        Lbc:
            long r3 = -r3
        Lbd:
            return r3
        Lbe:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(@NotNull Buffer buffer, @NotNull byte[] bArr) throws EOFException {
        j.e(buffer, "$this$commonReadFully");
        j.e(bArr, "sink");
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = buffer.read(bArr, i2, bArr.length - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00aa A[EDGE_INSN: B:43:0x00aa->B:37:0x00aa BREAK  A[LOOP:0: B:5:0x0012->B:45:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.Buffer r15) throws java.io.EOFException {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            f.c0.c.j.e(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb4
            r0 = 0
            r1 = 0
            r4 = r2
        L12:
            okio.Segment r6 = r15.head
            f.c0.c.j.c(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1d:
            if (r8 >= r9) goto L96
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L2e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L2e
            int r11 = r10 - r11
            goto L47
        L2e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L39
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L39
            goto L43
        L39:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
        L43:
            int r11 = r10 - r11
            int r11 = r11 + 10
        L47:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L57
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1d
        L57:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Number too large: "
            java.lang.StringBuilder r1 = c.a.a.a.a.r(r1)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L96
        L7f:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r0 = c.a.a.a.a.r(r0)
            java.lang.String r1 = okio.Util.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L96:
            if (r8 != r9) goto La2
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto La4
        La2:
            r6.pos = r8
        La4:
            if (r1 != 0) goto Laa
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L12
        Laa:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lb4:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@NotNull Buffer buffer) throws EOFException {
        j.e(buffer, "$this$commonReadInt");
        if (buffer.size() < 4) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        j.c(segment);
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 4) {
            return (buffer.readByte() & ExifInterface.MARKER) | ((buffer.readByte() & ExifInterface.MARKER) << 24) | ((buffer.readByte() & ExifInterface.MARKER) << 16) | ((buffer.readByte() & ExifInterface.MARKER) << 8);
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & ExifInterface.MARKER) << 24) | ((bArr[i4] & ExifInterface.MARKER) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & ExifInterface.MARKER) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & ExifInterface.MARKER);
        buffer.setSize$okio(buffer.size() - 4);
        if (i9 == i3) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i9;
        }
        return i10;
    }

    public static final long commonReadLong(@NotNull Buffer buffer) throws EOFException {
        j.e(buffer, "$this$commonReadLong");
        if (buffer.size() < 8) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        j.c(segment);
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 8) {
            return ((((long) buffer.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) buffer.readInt()));
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        long j2 = (((long) bArr[i2]) & 255) << 56;
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 48);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 40);
        int i7 = i6 + 1;
        long j5 = ((((long) bArr[i6]) & 255) << 32) | j4;
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 24);
        int i9 = i8 + 1;
        long j7 = j6 | ((((long) bArr[i8]) & 255) << 16);
        int i10 = i9 + 1;
        long j8 = j7 | ((((long) bArr[i9]) & 255) << 8);
        int i11 = i10 + 1;
        long j9 = j8 | (((long) bArr[i10]) & 255);
        buffer.setSize$okio(buffer.size() - 8);
        if (i11 == i3) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i11;
        }
        return j9;
    }

    public static final short commonReadShort(@NotNull Buffer buffer) throws EOFException {
        j.e(buffer, "$this$commonReadShort");
        if (buffer.size() < 2) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        j.c(segment);
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 2) {
            return (short) ((buffer.readByte() & ExifInterface.MARKER) | ((buffer.readByte() & ExifInterface.MARKER) << 8));
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & ExifInterface.MARKER) << 8) | (bArr[i4] & ExifInterface.MARKER);
        buffer.setSize$okio(buffer.size() - 2);
        if (i5 == i3) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer buffer, long j2) throws EOFException {
        j.e(buffer, "$this$commonReadUtf8");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.f("byteCount: ", j2).toString());
        }
        if (buffer.size() < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return "";
        }
        Segment segment = buffer.head;
        j.c(segment);
        int i2 = segment.pos;
        if (((long) i2) + j2 > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j2), 0, 0, 3, null);
        }
        int i3 = (int) j2;
        String strCommonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i2, i2 + i3);
        segment.pos += i3;
        buffer.setSize$okio(buffer.size() - j2);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return strCommonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer buffer) throws EOFException {
        int i2;
        int i3;
        int i4;
        j.e(buffer, "$this$commonReadUtf8CodePoint");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        byte b2 = buffer.getByte(0L);
        if ((b2 & 128) == 0) {
            i2 = b2 & 127;
            i3 = 1;
            i4 = 0;
        } else if ((b2 & 224) == 192) {
            i2 = b2 & 31;
            i3 = 2;
            i4 = 128;
        } else if ((b2 & 240) == 224) {
            i2 = b2 & bw.m;
            i3 = 3;
            i4 = 2048;
        } else {
            if ((b2 & 248) != 240) {
                buffer.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = b2 & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j2 = i3;
        if (buffer.size() < j2) {
            StringBuilder sbS = a.s("size < ", i3, ": ");
            sbS.append(buffer.size());
            sbS.append(" (to read code point prefixed 0x");
            sbS.append(Util.toHexString(b2));
            sbS.append(')');
            throw new EOFException(sbS.toString());
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j3 = i5;
            byte b3 = buffer.getByte(j3);
            if ((b3 & 192) != 128) {
                buffer.skip(j3);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = (i2 << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
        }
        buffer.skip(j2);
        return i2 > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i2 && 57343 >= i2) || i2 < i4) ? Utf8.REPLACEMENT_CODE_POINT : i2;
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer buffer) {
        j.e(buffer, "$this$commonReadUtf8Line");
        long jIndexOf = buffer.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(buffer, jIndexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer buffer, long j2) throws EOFException {
        j.e(buffer, "$this$commonReadUtf8LineStrict");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(a.f("limit < 0: ", j2).toString());
        }
        long j3 = RecyclerView.FOREVER_NS;
        if (j2 != RecyclerView.FOREVER_NS) {
            j3 = j2 + 1;
        }
        byte b2 = (byte) 10;
        long jIndexOf = buffer.indexOf(b2, 0L, j3);
        if (jIndexOf != -1) {
            return readUtf8Line(buffer, jIndexOf);
        }
        if (j3 < buffer.size() && buffer.getByte(j3 - 1) == ((byte) 13) && buffer.getByte(j3) == b2) {
            return readUtf8Line(buffer, j3);
        }
        Buffer buffer2 = new Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
        StringBuilder sbR = a.r("\\n not found: limit=");
        sbR.append(Math.min(buffer.size(), j2));
        sbR.append(" content=");
        sbR.append(buffer2.readByteString().hex());
        sbR.append((char) 8230);
        throw new EOFException(sbR.toString());
    }

    public static final int commonSelect(@NotNull Buffer buffer, @NotNull Options options) throws EOFException {
        j.e(buffer, "$this$commonSelect");
        j.e(options, "options");
        int iSelectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public static final void commonSkip(@NotNull Buffer buffer, long j2) throws EOFException {
        j.e(buffer, "$this$commonSkip");
        while (j2 > 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j2, segment.limit - segment.pos);
            long j3 = iMin;
            buffer.setSize$okio(buffer.size() - j3);
            j2 -= j3;
            int i2 = segment.pos + iMin;
            segment.pos = i2;
            if (i2 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer) {
        j.e(buffer, "$this$commonSnapshot");
        if (buffer.size() <= ((long) Integer.MAX_VALUE)) {
            return buffer.snapshot((int) buffer.size());
        }
        StringBuilder sbR = a.r("size > Int.MAX_VALUE: ");
        sbR.append(buffer.size());
        throw new IllegalStateException(sbR.toString().toString());
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer buffer, int i2) {
        j.e(buffer, "$this$commonWritableSegment");
        if (!(i2 >= 1 && i2 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = buffer.head;
        if (segment != null) {
            j.c(segment);
            Segment segment2 = segment.prev;
            j.c(segment2);
            return (segment2.limit + i2 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        buffer.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull ByteString byteString, int i2, int i3) {
        j.e(buffer, "$this$commonWrite");
        j.e(byteString, "byteString");
        byteString.write$okio(buffer, i2, i3);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = byteString.size();
        }
        j.e(buffer, "$this$commonWrite");
        j.e(byteString, "byteString");
        byteString.write$okio(buffer, i2, i3);
        return buffer;
    }

    public static final long commonWriteAll(@NotNull Buffer buffer, @NotNull Source source) {
        j.e(buffer, "$this$commonWriteAll");
        j.e(source, "source");
        long j2 = 0;
        while (true) {
            long j3 = source.read(buffer, 8192);
            if (j3 == -1) {
                return j2;
            }
            j2 += j3;
        }
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer buffer, int i2) {
        j.e(buffer, "$this$commonWriteByte");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i3 + 1;
        bArr[i3] = (byte) i2;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer buffer, long j2) {
        j.e(buffer, "$this$commonWriteDecimalLong");
        if (j2 == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit + i2;
        while (j2 != 0) {
            long j3 = 10;
            i3--;
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i2;
        buffer.setSize$okio(buffer.size() + ((long) i2));
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer buffer, long j2) {
        j.e(buffer, "$this$commonWriteHexadecimalUnsignedLong");
        if (j2 == 0) {
            return buffer.writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = getHEX_DIGIT_BYTES()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        segmentWritableSegment$okio.limit += i2;
        buffer.setSize$okio(buffer.size() + ((long) i2));
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer buffer, int i2) {
        j.e(buffer, "$this$commonWriteInt");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        segmentWritableSegment$okio.limit = i6 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer buffer, long j2) {
        j.e(buffer, "$this$commonWriteLong");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j2 >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j2 >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j2 >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j2 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j2 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j2 >>> 8) & 255);
        bArr[i9] = (byte) (j2 & 255);
        segmentWritableSegment$okio.limit = i9 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer buffer, int i2) {
        j.e(buffer, "$this$commonWriteShort");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        segmentWritableSegment$okio.limit = i4 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer buffer, @NotNull String str, int i2, int i3) {
        char cCharAt;
        j.e(buffer, "$this$commonWriteUtf8");
        j.e(str, "string");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a.G("beginIndex < 0: ", i2).toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(a.e("endIndex < beginIndex: ", i3, " < ", i2).toString());
        }
        if (!(i3 <= str.length())) {
            StringBuilder sbS = a.s("endIndex > string.length: ", i3, " > ");
            sbS.append(str.length());
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        while (i2 < i3) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 128) {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                byte[] bArr = segmentWritableSegment$okio.data;
                int i4 = segmentWritableSegment$okio.limit - i2;
                int iMin = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                bArr[i2 + i4] = (byte) cCharAt2;
                while (true) {
                    i2 = i5;
                    if (i2 >= iMin || (cCharAt = str.charAt(i2)) >= 128) {
                        break;
                    }
                    i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) cCharAt;
                }
                int i6 = segmentWritableSegment$okio.limit;
                int i7 = (i4 + i2) - i6;
                segmentWritableSegment$okio.limit = i6 + i7;
                buffer.setSize$okio(buffer.size() + ((long) i7));
            } else {
                if (cCharAt2 < 2048) {
                    Segment segmentWritableSegment$okio2 = buffer.writableSegment$okio(2);
                    byte[] bArr2 = segmentWritableSegment$okio2.data;
                    int i8 = segmentWritableSegment$okio2.limit;
                    bArr2[i8] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i8 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    segmentWritableSegment$okio2.limit = i8 + 2;
                    buffer.setSize$okio(buffer.size() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    Segment segmentWritableSegment$okio3 = buffer.writableSegment$okio(3);
                    byte[] bArr3 = segmentWritableSegment$okio3.data;
                    int i9 = segmentWritableSegment$okio3.limit;
                    bArr3[i9] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i9 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    segmentWritableSegment$okio3.limit = i9 + 3;
                    buffer.setSize$okio(buffer.size() + 3);
                } else {
                    int i10 = i2 + 1;
                    char cCharAt3 = i10 < i3 ? str.charAt(i10) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        buffer.writeByte(63);
                        i2 = i10;
                    } else {
                        int i11 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment$okio4 = buffer.writableSegment$okio(4);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i12 = segmentWritableSegment$okio4.limit;
                        bArr4[i12] = (byte) ((i11 >> 18) | 240);
                        bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                        segmentWritableSegment$okio4.limit = i12 + 4;
                        buffer.setSize$okio(buffer.size() + 4);
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer buffer, int i2) {
        j.e(buffer, "$this$commonWriteUtf8CodePoint");
        if (i2 < 128) {
            buffer.writeByte(i2);
        } else if (i2 < 2048) {
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i3 = segmentWritableSegment$okio.limit;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            segmentWritableSegment$okio.limit = i3 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i2 && 57343 >= i2) {
            buffer.writeByte(63);
        } else if (i2 < 65536) {
            Segment segmentWritableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i4 = segmentWritableSegment$okio2.limit;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            segmentWritableSegment$okio2.limit = i4 + 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else {
            if (i2 > 1114111) {
                StringBuilder sbR = a.r("Unexpected code point: 0x");
                sbR.append(Util.toHexString(i2));
                throw new IllegalArgumentException(sbR.toString());
            }
            Segment segmentWritableSegment$okio3 = buffer.writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i5 = segmentWritableSegment$okio3.limit;
            bArr3[i5] = (byte) ((i2 >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
            segmentWritableSegment$okio3.limit = i5 + 4;
            buffer.setSize$okio(buffer.size() + 4);
        }
        return buffer;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i2, @NotNull byte[] bArr, int i3, int i4) {
        j.e(segment, "segment");
        j.e(bArr, "bytes");
        int i5 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i3 < i4) {
            if (i2 == i5) {
                segment = segment.next;
                j.c(segment);
                byte[] bArr3 = segment.data;
                bArr2 = bArr3;
                i2 = segment.pos;
                i5 = segment.limit;
            }
            if (bArr2[i2] != bArr[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer buffer, long j2) throws EOFException {
        j.e(buffer, "$this$readUtf8Line");
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (buffer.getByte(j3) == ((byte) 13)) {
                String utf8 = buffer.readUtf8(j3);
                buffer.skip(2L);
                return utf8;
            }
        }
        String utf82 = buffer.readUtf8(j2);
        buffer.skip(1L);
        return utf82;
    }

    public static final <T> T seek(@NotNull Buffer buffer, long j2, @NotNull p<? super Segment, ? super Long, ? extends T> pVar) {
        j.e(buffer, "$this$seek");
        j.e(pVar, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return pVar.invoke(null, -1L);
        }
        if (buffer.size() - j2 < j2) {
            long size = buffer.size();
            while (size > j2) {
                segment = segment.prev;
                j.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return pVar.invoke(segment, Long.valueOf(size));
        }
        long j3 = 0;
        while (true) {
            long j4 = ((long) (segment.limit - segment.pos)) + j3;
            if (j4 > j2) {
                return pVar.invoke(segment, Long.valueOf(j3));
            }
            segment = segment.next;
            j.c(segment);
            j3 = j4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        if (r19 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int selectPrefix(@org.jetbrains.annotations.NotNull okio.Buffer r17, @org.jetbrains.annotations.NotNull okio.Options r18, boolean r19) {
        /*
            r0 = r17
            java.lang.String r1 = "$this$selectPrefix"
            f.c0.c.j.e(r0, r1)
            java.lang.String r1 = "options"
            r2 = r18
            f.c0.c.j.e(r2, r1)
            okio.Segment r0 = r0.head
            r1 = -2
            r3 = -1
            if (r0 == 0) goto Lac
            byte[] r4 = r0.data
            int r5 = r0.pos
            int r6 = r0.limit
            int[] r2 = r18.getTrie()
            r7 = 0
            r9 = r0
            r8 = 0
            r10 = -1
        L22:
            int r11 = r8 + 1
            r8 = r2[r8]
            int r12 = r11 + 1
            r11 = r2[r11]
            if (r11 == r3) goto L2d
            r10 = r11
        L2d:
            if (r9 != 0) goto L30
            goto L5d
        L30:
            r11 = 0
            if (r8 >= 0) goto L7d
            int r8 = r8 * (-1)
            int r13 = r8 + r12
        L37:
            int r8 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r14 = r12 + 1
            r12 = r2[r12]
            if (r5 == r12) goto L44
            return r10
        L44:
            if (r14 != r13) goto L48
            r5 = 1
            goto L49
        L48:
            r5 = 0
        L49:
            if (r8 != r6) goto L6a
            f.c0.c.j.c(r9)
            okio.Segment r4 = r9.next
            f.c0.c.j.c(r4)
            int r6 = r4.pos
            byte[] r8 = r4.data
            int r9 = r4.limit
            if (r4 != r0) goto L64
            if (r5 != 0) goto L61
        L5d:
            if (r19 == 0) goto L60
            return r1
        L60:
            return r10
        L61:
            r4 = r8
            r8 = r11
            goto L70
        L64:
            r16 = r8
            r8 = r4
            r4 = r16
            goto L70
        L6a:
            r16 = r9
            r9 = r6
            r6 = r8
            r8 = r16
        L70:
            if (r5 == 0) goto L78
            r5 = r2[r14]
            r13 = r6
            r6 = r9
            r9 = r8
            goto La2
        L78:
            r5 = r6
            r6 = r9
            r12 = r14
            r9 = r8
            goto L37
        L7d:
            int r13 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r14 = r12 + r8
        L85:
            if (r12 != r14) goto L88
            return r10
        L88:
            r15 = r2[r12]
            if (r5 != r15) goto La9
            int r12 = r12 + r8
            r5 = r2[r12]
            if (r13 != r6) goto La2
            okio.Segment r9 = r9.next
            f.c0.c.j.c(r9)
            int r4 = r9.pos
            byte[] r6 = r9.data
            int r8 = r9.limit
            r13 = r4
            r4 = r6
            r6 = r8
            if (r9 != r0) goto La2
            r9 = r11
        La2:
            if (r5 < 0) goto La5
            return r5
        La5:
            int r8 = -r5
            r5 = r13
            goto L22
        La9:
            int r12 = r12 + 1
            goto L85
        Lac:
            if (r19 == 0) goto Laf
            goto Lb0
        Laf:
            r1 = -1
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.selectPrefix(okio.Buffer, okio.Options, boolean):int");
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(@NotNull Buffer buffer, @NotNull byte[] bArr, int i2, int i3) {
        j.e(buffer, "$this$commonRead");
        j.e(bArr, "sink");
        Util.checkOffsetAndCount(bArr.length, i2, i3);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i3, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i4 = segment.pos;
        e.c(bArr2, bArr, i2, i4, i4 + iMin);
        segment.pos += iMin;
        buffer.setSize$okio(buffer.size() - ((long) iMin));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer, long j2) throws EOFException {
        j.e(buffer, "$this$commonReadByteArray");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.f("byteCount: ", j2).toString());
        }
        if (buffer.size() < j2) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j2];
        buffer.readFully(bArr);
        return bArr;
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer, long j2) throws EOFException {
        j.e(buffer, "$this$commonReadByteString");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.f("byteCount: ", j2).toString());
        }
        if (buffer.size() < j2) {
            throw new EOFException();
        }
        if (j2 < 4096) {
            return new ByteString(buffer.readByteArray(j2));
        }
        ByteString byteStringSnapshot = buffer.snapshot((int) j2);
        buffer.skip(j2);
        return byteStringSnapshot;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        j.e(buffer, "$this$commonWrite");
        j.e(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull byte[] bArr, int i2, int i3) {
        j.e(buffer, "$this$commonWrite");
        j.e(bArr, "source");
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            int iMin = Math.min(i4 - i2, 8192 - segmentWritableSegment$okio.limit);
            int i5 = i2 + iMin;
            e.c(bArr, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i2, i5);
            segmentWritableSegment$okio.limit += iMin;
            i2 = i5;
        }
        buffer.setSize$okio(buffer.size() + j2);
        return buffer;
    }

    public static final void commonReadFully(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j2) throws EOFException {
        j.e(buffer, "$this$commonReadFully");
        j.e(buffer2, "sink");
        if (buffer.size() >= j2) {
            buffer2.write(buffer, j2);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer, int i2) {
        j.e(buffer, "$this$commonSnapshot");
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(buffer.size(), 0L, i2);
        Segment segment = buffer.head;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            j.c(segment);
            int i6 = segment.limit;
            int i7 = segment.pos;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[i5 * 2];
        Segment segment2 = buffer.head;
        int i8 = 0;
        while (i3 < i2) {
            j.c(segment2);
            bArr[i8] = segment2.data;
            i3 += segment2.limit - segment2.pos;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = segment2.pos;
            segment2.shared = true;
            i8++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull Source source, long j2) throws EOFException {
        j.e(buffer, "$this$commonWrite");
        j.e(source, "source");
        while (j2 > 0) {
            long j3 = source.read(buffer, j2);
            if (j3 == -1) {
                throw new EOFException();
            }
            j2 -= j3;
        }
        return buffer;
    }

    public static final long commonRead(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j2) {
        j.e(buffer, "$this$commonRead");
        j.e(buffer2, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(a.f("byteCount < 0: ", j2).toString());
        }
        if (buffer.size() == 0) {
            return -1L;
        }
        if (j2 > buffer.size()) {
            j2 = buffer.size();
        }
        buffer2.write(buffer, j2);
        return j2;
    }

    public static final void commonWrite(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j2) {
        Segment segment;
        j.e(buffer, "$this$commonWrite");
        j.e(buffer2, "source");
        if (buffer2 != buffer) {
            Util.checkOffsetAndCount(buffer2.size(), 0L, j2);
            while (j2 > 0) {
                Segment segment2 = buffer2.head;
                j.c(segment2);
                int i2 = segment2.limit;
                j.c(buffer2.head);
                if (j2 < i2 - r2.pos) {
                    Segment segment3 = buffer.head;
                    if (segment3 != null) {
                        j.c(segment3);
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j2) - ((long) (segment.shared ? 0 : segment.pos)) <= 8192) {
                            Segment segment4 = buffer2.head;
                            j.c(segment4);
                            segment4.writeTo(segment, (int) j2);
                            buffer2.setSize$okio(buffer2.size() - j2);
                            buffer.setSize$okio(buffer.size() + j2);
                            return;
                        }
                    }
                    Segment segment5 = buffer2.head;
                    j.c(segment5);
                    buffer2.head = segment5.split((int) j2);
                }
                Segment segment6 = buffer2.head;
                j.c(segment6);
                long j3 = segment6.limit - segment6.pos;
                buffer2.head = segment6.pop();
                Segment segment7 = buffer.head;
                if (segment7 == null) {
                    buffer.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    j.c(segment7);
                    Segment segment8 = segment7.prev;
                    j.c(segment8);
                    segment8.push(segment6).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j3);
                buffer.setSize$okio(buffer.size() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(@NotNull Buffer buffer, @NotNull ByteString byteString, long j2) {
        int i2;
        long j3 = j2;
        j.e(buffer, "$this$commonIndexOf");
        j.e(byteString, "bytes");
        if (!(byteString.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j4 = 0;
        if (j3 >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1L;
            }
            if (buffer.size() - j3 < j3) {
                long size = buffer.size();
                while (size > j3) {
                    segment = segment.prev;
                    j.c(segment);
                    size -= (long) (segment.limit - segment.pos);
                }
                byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                byte b2 = bArrInternalArray$okio[0];
                int size2 = byteString.size();
                long size3 = (buffer.size() - ((long) size2)) + 1;
                j4 = size;
                while (j4 < size3) {
                    byte[] bArr = segment.data;
                    long j5 = size3;
                    int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size3) - j4);
                    i2 = (int) ((((long) segment.pos) + j3) - j4);
                    while (i2 < iMin) {
                        if (bArr[i2] == b2 && rangeEquals(segment, i2 + 1, bArrInternalArray$okio, 1, size2)) {
                        }
                        i2++;
                    }
                    j4 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j.c(segment);
                    size3 = j5;
                    j3 = j4;
                }
                return -1L;
            }
            while (true) {
                long j6 = ((long) (segment.limit - segment.pos)) + j4;
                if (j6 > j3) {
                    break;
                }
                segment = segment.next;
                j.c(segment);
                j4 = j6;
            }
            byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
            byte b3 = bArrInternalArray$okio2[0];
            int size4 = byteString.size();
            long size5 = (buffer.size() - ((long) size4)) + 1;
            while (j4 < size5) {
                byte[] bArr2 = segment.data;
                int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size5) - j4);
                i2 = (int) ((((long) segment.pos) + j3) - j4);
                while (i2 < iMin2) {
                    if (bArr2[i2] != b3 || !rangeEquals(segment, i2 + 1, bArrInternalArray$okio2, 1, size4)) {
                        i2++;
                    }
                }
                j4 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j.c(segment);
                j3 = j4;
            }
            return -1L;
            return ((long) (i2 - segment.pos)) + j4;
        }
        throw new IllegalArgumentException(a.f("fromIndex < 0: ", j3).toString());
    }
}
