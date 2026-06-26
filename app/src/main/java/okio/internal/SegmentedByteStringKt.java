package okio.internal;

import c.a.a.a.a;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import f.x.e;
import kotlin.Metadata;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001ad\u0010\u0014\u001a\u00020\u0012*\u00020\u00072K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aq\u0010\u0014\u001a\u00020\u0012*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\u0082\b¢\u0006\u0004\b\u0014\u0010\u0018\u001a$\u0010\u001a\u001a\u00020\u0019*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001d\u001a\u00020\u001c*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0014\u0010\u001f\u001a\u00020\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\f*\u00020\u0007H\u0080\b¢\u0006\u0004\b!\u0010\"\u001a,\u0010%\u001a\u00020\u0012*\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b%\u0010&\u001a4\u0010*\u001a\u00020)*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b*\u0010+\u001a4\u0010*\u001a\u00020)*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b*\u0010,\u001a\u001e\u0010.\u001a\u00020)*\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010-H\u0080\b¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b0\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061"}, d2 = {"", "", ES6Iterator.VALUE_PROPERTY, "fromIndex", "toIndex", "binarySearch", "([IIII)I", "Lokio/SegmentedByteString;", "pos", "segment", "(Lokio/SegmentedByteString;I)I", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "data", "offset", "byteCount", "Lf/v;", "action", "forEachSegment", "(Lokio/SegmentedByteString;Lf/c0/b/q;)V", "beginIndex", "endIndex", "(Lokio/SegmentedByteString;IILf/c0/b/q;)V", "Lokio/ByteString;", "commonSubstring", "(Lokio/SegmentedByteString;II)Lokio/ByteString;", "", "commonInternalGet", "(Lokio/SegmentedByteString;I)B", "commonGetSize", "(Lokio/SegmentedByteString;)I", "commonToByteArray", "(Lokio/SegmentedByteString;)[B", "Lokio/Buffer;", "buffer", "commonWrite", "(Lokio/SegmentedByteString;Lokio/Buffer;II)V", "other", "otherOffset", "", "commonRangeEquals", "(Lokio/SegmentedByteString;ILokio/ByteString;II)Z", "(Lokio/SegmentedByteString;I[BII)Z", "", "commonEquals", "(Lokio/SegmentedByteString;Ljava/lang/Object;)Z", "commonHashCode", "okio"}, k = 2, mv = {1, 4, 0})
public final class SegmentedByteStringKt {
    public static final int binarySearch(@NotNull int[] iArr, int i2, int i3, int i4) {
        j.e(iArr, "$this$binarySearch");
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i2) {
                i3 = i6 + 1;
            } else {
                if (i7 <= i2) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return (-i3) - 1;
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString segmentedByteString, @Nullable Object obj) {
        j.e(segmentedByteString, "$this$commonEquals");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString segmentedByteString) {
        j.e(segmentedByteString, "$this$commonGetSize");
        return segmentedByteString.getDirectory()[segmentedByteString.getSegments().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString segmentedByteString) {
        j.e(segmentedByteString, "$this$commonHashCode");
        int hashCode = segmentedByteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = segmentedByteString.getSegments().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            int i5 = segmentedByteString.getDirectory()[length + i2];
            int i6 = segmentedByteString.getDirectory()[i2];
            byte[] bArr = segmentedByteString.getSegments()[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        segmentedByteString.setHashCode$okio(i4);
        return i4;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString segmentedByteString, int i2) {
        j.e(segmentedByteString, "$this$commonInternalGet");
        Util.checkOffsetAndCount(segmentedByteString.getDirectory()[segmentedByteString.getSegments().length - 1], i2, 1L);
        int iSegment = segment(segmentedByteString, i2);
        return segmentedByteString.getSegments()[iSegment][(i2 - (iSegment == 0 ? 0 : segmentedByteString.getDirectory()[iSegment - 1])) + segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + iSegment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString, int i2, @NotNull ByteString byteString, int i3, int i4) {
        j.e(segmentedByteString, "$this$commonRangeEquals");
        j.e(byteString, "other");
        if (i2 < 0 || i2 > segmentedByteString.size() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int iSegment = segment(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = iSegment == 0 ? 0 : segmentedByteString.getDirectory()[iSegment - 1];
            int i7 = segmentedByteString.getDirectory()[iSegment] - i6;
            int i8 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i5, i7 + i6) - i2;
            if (!byteString.rangeEquals(i3, segmentedByteString.getSegments()[iSegment], (i2 - i6) + i8, iMin)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iSegment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString segmentedByteString, int i2, int i3) {
        j.e(segmentedByteString, "$this$commonSubstring");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a.d("beginIndex=", i2, " < 0").toString());
        }
        if (!(i3 <= segmentedByteString.size())) {
            StringBuilder sbS = a.s("endIndex=", i3, " > length(");
            sbS.append(segmentedByteString.size());
            sbS.append(')');
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        int i4 = i3 - i2;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(a.e("endIndex=", i3, " < beginIndex=", i2).toString());
        }
        if (i2 == 0 && i3 == segmentedByteString.size()) {
            return segmentedByteString;
        }
        if (i2 == i3) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(segmentedByteString, i2);
        int iSegment2 = segment(segmentedByteString, i3 - 1);
        byte[][] bArr = (byte[][]) e.g(segmentedByteString.getSegments(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i5 = 0;
            int i6 = iSegment;
            while (true) {
                iArr[i5] = Math.min(segmentedByteString.getDirectory()[i6] - i2, i4);
                int i7 = i5 + 1;
                iArr[i5 + bArr.length] = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + i6];
                if (i6 == iSegment2) {
                    break;
                }
                i6++;
                i5 = i7;
            }
        }
        int i8 = iSegment != 0 ? segmentedByteString.getDirectory()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = (i2 - i8) + iArr[length];
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString segmentedByteString) {
        j.e(segmentedByteString, "$this$commonToByteArray");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = segmentedByteString.getDirectory()[length + i2];
            int i6 = segmentedByteString.getDirectory()[i2];
            int i7 = i6 - i3;
            e.c(segmentedByteString.getSegments()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString segmentedByteString, @NotNull Buffer buffer, int i2, int i3) {
        j.e(segmentedByteString, "$this$commonWrite");
        j.e(buffer, "buffer");
        int i4 = i3 + i2;
        int iSegment = segment(segmentedByteString, i2);
        while (i2 < i4) {
            int i5 = iSegment == 0 ? 0 : segmentedByteString.getDirectory()[iSegment - 1];
            int i6 = segmentedByteString.getDirectory()[iSegment] - i5;
            int i7 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i2;
            int i8 = (i2 - i5) + i7;
            Segment segment = new Segment(segmentedByteString.getSegments()[iSegment], i8, i8 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                j.c(segment2);
                Segment segment3 = segment2.prev;
                j.c(segment3);
                segment3.push(segment);
            }
            i2 += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) segmentedByteString.size()));
    }

    public static final void forEachSegment(@NotNull SegmentedByteString segmentedByteString, @NotNull q<? super byte[], ? super Integer, ? super Integer, v> qVar) {
        j.e(segmentedByteString, "$this$forEachSegment");
        j.e(qVar, "action");
        int length = segmentedByteString.getSegments().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = segmentedByteString.getDirectory()[length + i2];
            int i5 = segmentedByteString.getDirectory()[i2];
            qVar.invoke(segmentedByteString.getSegments()[i2], Integer.valueOf(i4), Integer.valueOf(i5 - i3));
            i2++;
            i3 = i5;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segmentedByteString, int i2) {
        j.e(segmentedByteString, "$this$segment");
        int iBinarySearch = binarySearch(segmentedByteString.getDirectory(), i2 + 1, 0, segmentedByteString.getSegments().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i2, int i3, q<? super byte[], ? super Integer, ? super Integer, v> qVar) {
        int iSegment = segment(segmentedByteString, i2);
        while (i2 < i3) {
            int i4 = iSegment == 0 ? 0 : segmentedByteString.getDirectory()[iSegment - 1];
            int i5 = segmentedByteString.getDirectory()[iSegment] - i4;
            int i6 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i3, i5 + i4) - i2;
            qVar.invoke(segmentedByteString.getSegments()[iSegment], Integer.valueOf((i2 - i4) + i6), Integer.valueOf(iMin));
            i2 += iMin;
            iSegment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString, int i2, @NotNull byte[] bArr, int i3, int i4) {
        j.e(segmentedByteString, "$this$commonRangeEquals");
        j.e(bArr, "other");
        if (i2 < 0 || i2 > segmentedByteString.size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int iSegment = segment(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = iSegment == 0 ? 0 : segmentedByteString.getDirectory()[iSegment - 1];
            int i7 = segmentedByteString.getDirectory()[iSegment] - i6;
            int i8 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i5, i7 + i6) - i2;
            if (!Util.arrayRangeEquals(segmentedByteString.getSegments()[iSegment], (i2 - i6) + i8, bArr, i3, iMin)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iSegment++;
        }
        return true;
    }
}
