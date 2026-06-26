package okio;

import f.a;
import f.c0.c.f;
import f.c0.c.j;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HashingSink.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018B!\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0013\u0010\f\u001a\u00020\t8G@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Buffer;", "source", "", "byteCount", "Lf/v;", "write", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "-deprecated_hash", "()Lokio/ByteString;", "hash", "Ljavax/crypto/Mac;", "mac", "Ljavax/crypto/Mac;", "Ljava/security/MessageDigest;", "messageDigest", "Ljava/security/MessageDigest;", "Lokio/Sink;", "sink", "", "algorithm", "<init>", "(Lokio/Sink;Ljava/lang/String;)V", "key", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
public final class HashingSink extends ForwardingSink {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* JADX INFO: compiled from: HashingSink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lokio/HashingSink$Companion;", "", "Lokio/Sink;", "sink", "Lokio/HashingSink;", "md5", "(Lokio/Sink;)Lokio/HashingSink;", "sha1", "sha256", "sha512", "Lokio/ByteString;", "key", "hmacSha1", "(Lokio/Sink;Lokio/ByteString;)Lokio/HashingSink;", "hmacSha256", "hmacSha512", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString key) {
            j.e(sink, "sink");
            j.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString key) {
            j.e(sink, "sink");
            j.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString key) {
            j.e(sink, "sink");
            j.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        @JvmStatic
        @NotNull
        public final HashingSink md5(@NotNull Sink sink) {
            j.e(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha1(@NotNull Sink sink) {
            j.e(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha256(@NotNull Sink sink) {
            j.e(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha512(@NotNull Sink sink) {
            j.e(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull String str) {
        super(sink);
        j.e(sink, "sink");
        j.e(str, "algorithm");
        this.messageDigest = MessageDigest.getInstance(str);
        this.mac = null;
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString byteString) {
        return INSTANCE.hmacSha1(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString byteString) {
        return INSTANCE.hmacSha256(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString byteString) {
        return INSTANCE.hmacSha512(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink md5(@NotNull Sink sink) {
        return INSTANCE.md5(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha1(@NotNull Sink sink) {
        return INSTANCE.sha1(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha256(@NotNull Sink sink) {
        return INSTANCE.sha256(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha512(@NotNull Sink sink) {
        return INSTANCE.sha512(sink);
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    @JvmName(name = "-deprecated_hash")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m185deprecated_hash() {
        return hash();
    }

    @JvmName(name = "hash")
    @NotNull
    public final ByteString hash() {
        byte[] bArrDoFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            bArrDoFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            j.c(mac);
            bArrDoFinal = mac.doFinal();
        }
        j.d(bArrDoFinal, "result");
        return new ByteString(bArrDoFinal);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        j.e(source, "source");
        Util.checkOffsetAndCount(source.size(), 0L, byteCount);
        Segment segment = source.head;
        j.c(segment);
        long j2 = 0;
        while (j2 < byteCount) {
            int iMin = (int) Math.min(byteCount - j2, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, iMin);
            } else {
                Mac mac = this.mac;
                j.c(mac);
                mac.update(segment.data, segment.pos, iMin);
            }
            j2 += (long) iMin;
            segment = segment.next;
            j.c(segment);
        }
        super.write(source, byteCount);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull ByteString byteString, @NotNull String str) throws NoSuchAlgorithmException {
        super(sink);
        j.e(sink, "sink");
        j.e(byteString, "key");
        j.e(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.mac = mac;
            this.messageDigest = null;
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
