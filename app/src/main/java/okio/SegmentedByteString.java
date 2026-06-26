package okio;

import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.j;
import f.x.e;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import okio.internal.SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020'0N\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bS\u0010TJ\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\rJ\u001f\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001aH\u0010¢\u0006\u0004\b!\u0010\"J\u000f\u0010&\u001a\u00020\u001aH\u0010¢\u0006\u0004\b$\u0010%J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b0\u00101J'\u00100\u001a\u00020/2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0010¢\u0006\u0004\b6\u00107J/\u0010;\u001a\u00020:2\u0006\u00104\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0016¢\u0006\u0004\b;\u0010<J/\u0010;\u001a\u00020:2\u0006\u00104\u001a\u00020\u001a2\u0006\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0016¢\u0006\u0004\b;\u0010=J\u001f\u0010?\u001a\u00020\u001a2\u0006\u00108\u001a\u00020'2\u0006\u0010>\u001a\u00020\u001aH\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\u001a2\u0006\u00108\u001a\u00020'2\u0006\u0010>\u001a\u00020\u001aH\u0016¢\u0006\u0004\bA\u0010@J\u000f\u0010C\u001a\u00020'H\u0010¢\u0006\u0004\bB\u0010)J\u001a\u0010E\u001a\u00020:2\b\u00108\u001a\u0004\u0018\u00010DH\u0096\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u001aH\u0016¢\u0006\u0004\bG\u0010%J\u000f\u0010H\u001a\u00020\tH\u0016¢\u0006\u0004\bH\u0010\rR\u001c\u0010J\u001a\u00020I8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020'0N8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "toByteString", "()Lokio/ByteString;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "()Ljava/lang/String;", "hex", "toAsciiLowercase", "toAsciiUppercase", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "getSize$okio", "()I", "getSize", "", "toByteArray", "()[B", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "Lf/v;", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "fromIndex", "indexOf", "([BI)I", "lastIndexOf", "internalArray$okio", "internalArray", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "", "directory", "[I", "getDirectory$okio", "()[I", "", "segments", "[[B", "getSegments$okio", "()[[B", "<init>", "([[B[I)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class SegmentedByteString extends ByteString {

    @NotNull
    private final transient int[] directory;

    @NotNull
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] bArr, @NotNull int[] iArr) {
        super(ByteString.EMPTY.getData());
        j.e(bArr, "segments");
        j.e(iArr, "directory");
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        Objects.requireNonNull(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        j.d(byteBufferAsReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) throws NoSuchAlgorithmException {
        j.e(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = getDirectory()[length + i2];
            int i5 = getDirectory()[i2];
            messageDigest.update(getSegments()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] bArrDigest = messageDigest.digest();
        j.d(bArrDigest, "digest.digest()");
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: getDirectory$okio, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    @NotNull
    /* JADX INFO: renamed from: getSegments$okio, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = getDirectory()[length + i2];
            int i6 = getDirectory()[i2];
            byte[] bArr = getSegments()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        setHashCode$okio(i3);
        return i3;
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) throws NoSuchAlgorithmException {
        j.e(algorithm, "algorithm");
        j.e(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments().length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = getDirectory()[length + i2];
                int i5 = getDirectory()[i2];
                mac.update(getSegments()[i2], i4, i5 - i3);
                i2++;
                i3 = i5;
            }
            byte[] bArrDoFinal = mac.doFinal();
            j.d(bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] other, int fromIndex) {
        j.e(other, "other");
        return toByteString().indexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int pos) {
        Util.checkOffsetAndCount(getDirectory()[getSegments().length - 1], pos, 1L);
        int iSegment = SegmentedByteStringKt.segment(this, pos);
        return getSegments()[iSegment][(pos - (iSegment == 0 ? 0 : getDirectory()[iSegment - 1])) + getDirectory()[getSegments().length + iSegment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] other, int fromIndex) {
        j.e(other, "other");
        return toByteString().lastIndexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        j.e(other, "other");
        if (offset < 0 || offset > size() - byteCount) {
            return false;
        }
        int i2 = byteCount + offset;
        int iSegment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = iSegment == 0 ? 0 : getDirectory()[iSegment - 1];
            int i4 = getDirectory()[iSegment] - i3;
            int i5 = getDirectory()[getSegments().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - offset;
            if (!other.rangeEquals(otherOffset, getSegments()[iSegment], (offset - i3) + i5, iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset) {
        j.e(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int beginIndex, int endIndex) {
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(a.d("beginIndex=", beginIndex, " < 0").toString());
        }
        if (!(endIndex <= size())) {
            StringBuilder sbS = a.s("endIndex=", endIndex, " > length(");
            sbS.append(size());
            sbS.append(')');
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        int i2 = endIndex - beginIndex;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a.e("endIndex=", endIndex, " < beginIndex=", beginIndex).toString());
        }
        if (beginIndex == 0 && endIndex == size()) {
            return this;
        }
        if (beginIndex == endIndex) {
            return ByteString.EMPTY;
        }
        int iSegment = SegmentedByteStringKt.segment(this, beginIndex);
        int iSegment2 = SegmentedByteStringKt.segment(this, endIndex - 1);
        byte[][] bArr = (byte[][]) e.g(getSegments(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i3 = 0;
            int i4 = iSegment;
            while (true) {
                iArr[i3] = Math.min(getDirectory()[i4] - beginIndex, i2);
                int i5 = i3 + 1;
                iArr[i3 + bArr.length] = getDirectory()[getSegments().length + i4];
                if (i4 == iSegment2) {
                    break;
                }
                i4++;
                i3 = i5;
            }
        }
        int i6 = iSegment != 0 ? getDirectory()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = (beginIndex - i6) + iArr[length];
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = getDirectory()[length + i2];
            int i6 = getDirectory()[i2];
            int i7 = i6 - i3;
            e.c(getSegments()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream out) throws IOException {
        j.e(out, "out");
        int length = getSegments().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = getDirectory()[length + i2];
            int i5 = getDirectory()[i2];
            out.write(getSegments()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@NotNull Buffer buffer, int offset, int byteCount) {
        j.e(buffer, "buffer");
        int i2 = byteCount + offset;
        int iSegment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = iSegment == 0 ? 0 : getDirectory()[iSegment - 1];
            int i4 = getDirectory()[iSegment] - i3;
            int i5 = getDirectory()[getSegments().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - offset;
            int i6 = (offset - i3) + i5;
            Segment segment = new Segment(getSegments()[iSegment], i6, i6 + iMin, true, false);
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
            offset += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) size()));
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        j.e(other, "other");
        if (offset < 0 || offset > size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i2 = byteCount + offset;
        int iSegment = SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            int i3 = iSegment == 0 ? 0 : getDirectory()[iSegment - 1];
            int i4 = getDirectory()[iSegment] - i3;
            int i5 = getDirectory()[getSegments().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - offset;
            if (!Util.arrayRangeEquals(getSegments()[iSegment], (offset - i3) + i5, other, otherOffset, iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iSegment++;
        }
        return true;
    }
}
