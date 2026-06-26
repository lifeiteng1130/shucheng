package okio;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.bw;
import f.c0.c.f;
import f.c0.c.j;
import f.h0.a;
import f.h0.k;
import f.x.e;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0016\u0018\u0000 r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001rB\u0011\b\u0000\u0012\u0006\u0010i\u001a\u000209¢\u0006\u0004\bp\u0010qJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\fH\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0000H\u0016¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u0000H\u0016¢\u0006\u0004\b(\u0010\u0015J#\u0010,\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020)H\u0017¢\u0006\u0004\b,\u0010-J\u0017\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020)H\u0010¢\u0006\u0004\b0\u00101J\u0018\u00105\u001a\u00020/2\u0006\u00103\u001a\u00020)H\u0087\u0002¢\u0006\u0004\b4\u00101J\u000f\u00108\u001a\u00020)H\u0010¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u000209H\u0010¢\u0006\u0004\b<\u0010;J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ'\u0010B\u001a\u00020\u00052\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0010¢\u0006\u0004\bH\u0010IJ/\u0010M\u001a\u00020L2\u0006\u0010F\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bM\u0010NJ/\u0010M\u001a\u00020L2\u0006\u0010F\u001a\u00020)2\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bM\u0010OJ\u0015\u0010Q\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0000¢\u0006\u0004\bQ\u0010RJ\u0015\u0010Q\u001a\u00020L2\u0006\u0010P\u001a\u000209¢\u0006\u0004\bQ\u0010SJ\u0015\u0010U\u001a\u00020L2\u0006\u0010T\u001a\u00020\u0000¢\u0006\u0004\bU\u0010RJ\u0015\u0010U\u001a\u00020L2\u0006\u0010T\u001a\u000209¢\u0006\u0004\bU\u0010SJ!\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010V\u001a\u00020)H\u0007¢\u0006\u0004\bW\u0010XJ!\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u0002092\b\b\u0002\u0010V\u001a\u00020)H\u0017¢\u0006\u0004\bW\u0010YJ!\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010V\u001a\u00020)H\u0007¢\u0006\u0004\bZ\u0010XJ!\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u0002092\b\b\u0002\u0010V\u001a\u00020)H\u0017¢\u0006\u0004\bZ\u0010YJ\u001a\u0010\\\u001a\u00020L2\b\u0010J\u001a\u0004\u0018\u00010[H\u0096\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020)H\u0016¢\u0006\u0004\b^\u00107J\u0018\u0010_\u001a\u00020)2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\fH\u0016¢\u0006\u0004\ba\u0010\u000eJ\u0017\u00104\u001a\u00020/2\u0006\u00103\u001a\u00020)H\u0007¢\u0006\u0004\bb\u00101J\u000f\u0010d\u001a\u00020)H\u0007¢\u0006\u0004\bc\u00107R\"\u0010^\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010e\u001a\u0004\bf\u00107\"\u0004\bg\u0010hR\u0013\u0010d\u001a\u00020)8G@\u0006¢\u0006\u0006\u001a\u0004\bd\u00107R\u001c\u0010i\u001a\u0002098\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010;R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010l\u001a\u0004\bm\u0010\u000e\"\u0004\bn\u0010o¨\u0006s"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "Lf/v;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "utf8", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "md5", "()Lokio/ByteString;", "sha1", "sha256", "sha512", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "index", "getByte", "get", "getSize$okio", "()I", "getSize", "", "toByteArray", "()[B", "internalArray$okio", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "prefix", "startsWith", "(Lokio/ByteString;)Z", "([B)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "compareTo", "(Lokio/ByteString;)I", "toString", "-deprecated_getByte", "-deprecated_size", "size", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getHashCode$okio", "setHashCode$okio", "(I)V", "data", "[B", "getData$okio", "Ljava/lang/String;", "getUtf8$okio", "setUtf8$okio", "(Ljava/lang/String;)V", "<init>", "([B)V", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
public class ByteString implements Serializable, Comparable<ByteString> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @NotNull
    private final byte[] data;
    private transient int hashCode;

    @Nullable
    private transient String utf8;

    /* JADX INFO: compiled from: ByteString.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0005*\u00020\rH\u0007¢\u0006\u0004\b\u0006\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u0005*\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0011J\u0013\u0010\u0018\u001a\u00020\u0005*\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0011J\u001b\u0010\u001c\u001a\u00020\u0005*\u00020\u00192\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001f\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b \u0010\u0015J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007¢\u0006\u0004\b!\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\rH\u0007¢\u0006\u0004\b#\u0010\u000eJ'\u0010\u0006\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010\u000bJ\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010\u001bR\u0016\u0010'\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lokio/ByteString$Companion;", "", "", "", "data", "Lokio/ByteString;", "of", "([B)Lokio/ByteString;", "", "offset", "byteCount", "([BII)Lokio/ByteString;", "toByteString", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)Lokio/ByteString;", "", "encodeUtf8", "(Ljava/lang/String;)Lokio/ByteString;", "Ljava/nio/charset/Charset;", "charset", "encodeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", "encode", "decodeBase64", "decodeHex", "Ljava/io/InputStream;", "read", "(Ljava/io/InputStream;I)Lokio/ByteString;", "readByteString", "string", "-deprecated_decodeBase64", "-deprecated_decodeHex", "-deprecated_encodeString", "-deprecated_encodeUtf8", "buffer", "-deprecated_of", "array", "inputstream", "-deprecated_read", "EMPTY", "Lokio/ByteString;", "", "serialVersionUID", "J", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charset = a.a;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return companion.of(bArr, i2, i3);
        }

        @Deprecated(level = f.a.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @JvmName(name = "-deprecated_decodeBase64")
        @Nullable
        /* JADX INFO: renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m174deprecated_decodeBase64(@NotNull String string) {
            j.e(string, "string");
            return decodeBase64(string);
        }

        @Deprecated(level = f.a.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m175deprecated_decodeHex(@NotNull String string) {
            j.e(string, "string");
            return decodeHex(string);
        }

        @Deprecated(level = f.a.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m176deprecated_encodeString(@NotNull String string, @NotNull Charset charset) {
            j.e(string, "string");
            j.e(charset, "charset");
            return encodeString(string, charset);
        }

        @Deprecated(level = f.a.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m177deprecated_encodeUtf8(@NotNull String string) {
            j.e(string, "string");
            return encodeUtf8(string);
        }

        @Deprecated(level = f.a.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m178deprecated_of(@NotNull ByteBuffer buffer) {
            j.e(buffer, "buffer");
            return of(buffer);
        }

        @Deprecated(level = f.a.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m180deprecated_read(@NotNull InputStream inputstream, int byteCount) {
            j.e(inputstream, "inputstream");
            return read(inputstream, byteCount);
        }

        @JvmStatic
        @Nullable
        public final ByteString decodeBase64(@NotNull String str) {
            j.e(str, "$this$decodeBase64");
            byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final ByteString decodeHex(@NotNull String str) {
            j.e(str, "$this$decodeHex");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(c.a.a.a.a.i("Unexpected hex string: ", str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (ByteStringKt.decodeHexDigit(str.charAt(i3 + 1)) + (ByteStringKt.decodeHexDigit(str.charAt(i3)) << 4));
            }
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName(name = "encodeString")
        @NotNull
        public final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
            j.e(str, "$this$encode");
            j.e(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            j.d(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmStatic
        @NotNull
        public final ByteString encodeUtf8(@NotNull String str) {
            j.e(str, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull ByteBuffer byteBuffer) {
            j.e(byteBuffer, "$this$toByteString");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName(name = "read")
        @NotNull
        public final ByteString read(@NotNull InputStream inputStream, int i2) throws IOException {
            j.e(inputStream, "$this$readByteString");
            int i3 = 0;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException(c.a.a.a.a.G("byteCount < 0: ", i2).toString());
            }
            byte[] bArr = new byte[i2];
            while (i3 < i2) {
                int i4 = inputStream.read(bArr, i3, i2 - i3);
                if (i4 == -1) {
                    throw new EOFException();
                }
                i3 += i4;
            }
            return new ByteString(bArr);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @Deprecated(level = f.a.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m179deprecated_of(@NotNull byte[] array, int offset, int byteCount) {
            j.e(array, "array");
            return of(array, offset, byteCount);
        }

        @JvmStatic
        @NotNull
        public final ByteString of(@NotNull byte... data) {
            j.e(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(bArrCopyOf);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull byte[] bArr, int i2, int i3) {
            j.e(bArr, "$this$toByteString");
            Util.checkOffsetAndCount(bArr.length, i2, i3);
            return new ByteString(e.f(bArr, i2, i3 + i2));
        }
    }

    public ByteString(@NotNull byte[] bArr) {
        j.e(bArr, "data");
        this.data = bArr;
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return INSTANCE.decodeBase64(str);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return INSTANCE.decodeHex(str);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    @NotNull
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return INSTANCE.encodeString(str, charset);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return INSTANCE.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(byteString2, i2);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(bArr, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i2);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return INSTANCE.of(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return INSTANCE.of(bArr);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull byte[] bArr, int i2, int i3) {
        return INSTANCE.of(bArr, i2, i3);
    }

    @JvmStatic
    @JvmName(name = "read")
    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream, int i2) {
        return INSTANCE.read(inputStream, i2);
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException {
        ByteString byteString = INSTANCE.read(in, in.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        j.d(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = byteString.size();
        }
        return byteString.substring(i2, i3);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    @Deprecated(level = f.a.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m172deprecated_getByte(int index) {
        return getByte(index);
    }

    @Deprecated(level = f.a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m173deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        j.d(byteBufferAsReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return Base64.encodeBase64$default(getData(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return Base64.encodeBase64(getData(), Base64.getBASE64_URL_SAFE());
    }

    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        j.e(algorithm, "algorithm");
        byte[] bArrDigest = MessageDigest.getInstance(algorithm).digest(this.data);
        j.d(bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(bArrDigest);
    }

    public final boolean endsWith(@NotNull ByteString suffix) {
        j.e(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == getData().length && byteString.rangeEquals(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int index) {
        return internalGet$okio(index);
    }

    @NotNull
    /* JADX INFO: renamed from: getData$okio, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: getHashCode$okio, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData().length;
    }

    @Nullable
    /* JADX INFO: renamed from: getUtf8$okio, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(getData());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    @NotNull
    public String hex() {
        char[] cArr = new char[getData().length * 2];
        int i2 = 0;
        for (byte b2 : getData()) {
            int i3 = i2 + 1;
            cArr[i2] = ByteStringKt.getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = ByteStringKt.getHEX_DIGIT_CHARS()[b2 & bw.m];
        }
        return new String(cArr);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) throws NoSuchAlgorithmException {
        j.e(algorithm, "algorithm");
        j.e(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            j.d(bArrDoFinal, "mac.doFinal(data)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString key) {
        j.e(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString key) {
        j.e(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString key) {
        j.e(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString other, int fromIndex) {
        j.e(other, "other");
        return indexOf(other.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public final int indexOf(@NotNull byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData();
    }

    public byte internalGet$okio(int pos) {
        return getData()[pos];
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString other, int fromIndex) {
        j.e(other, "other");
        return lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        j.e(other, "other");
        return other.rangeEquals(otherOffset, getData(), offset, byteCount);
    }

    public final void setHashCode$okio(int i2) {
        this.hashCode = i2;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.utf8 = str;
    }

    @NotNull
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @NotNull
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString prefix) {
        j.e(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        j.e(charset, "charset");
        return new String(this.data, charset);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring(int i2) {
        return substring$default(this, i2, 0, 2, null);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int beginIndex, int endIndex) {
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (!(endIndex <= getData().length)) {
            throw new IllegalArgumentException(c.a.a.a.a.n(c.a.a.a.a.r("endIndex > length("), getData().length, ')').toString());
        }
        if (endIndex - beginIndex >= 0) {
            return (beginIndex == 0 && endIndex == getData().length) ? this : new ByteString(e.f(getData(), beginIndex, endIndex));
        }
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        byte b2;
        for (int i2 = 0; i2 < getData().length; i2++) {
            byte b3 = getData()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        byte b2;
        for (int i2 = 0; i2 < getData().length; i2++) {
            byte b3 = getData()[i2];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data = getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @NotNull
    public String toString() {
        if (getData().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = ByteStringKt.codePointIndexToCharIndex(getData(), 64);
        if (iCodePointIndexToCharIndex == -1) {
            if (getData().length <= 64) {
                StringBuilder sbR = c.a.a.a.a.r("[hex=");
                sbR.append(hex());
                sbR.append(']');
                return sbR.toString();
            }
            StringBuilder sbR2 = c.a.a.a.a.r("[size=");
            sbR2.append(getData().length);
            sbR2.append(" hex=");
            if (!(64 <= getData().length)) {
                throw new IllegalArgumentException(c.a.a.a.a.n(c.a.a.a.a.r("endIndex > length("), getData().length, ')').toString());
            }
            sbR2.append((64 == getData().length ? this : new ByteString(e.f(getData(), 0, 64))).hex());
            sbR2.append("…]");
            return sbR2.toString();
        }
        String strUtf8 = utf8();
        Objects.requireNonNull(strUtf8, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
        j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strC = k.C(k.C(k.C(strSubstring, "\\", "\\\\", false, 4), "\n", "\\n", false, 4), "\r", "\\r", false, 4);
        if (iCodePointIndexToCharIndex >= strUtf8.length()) {
            return "[text=" + strC + ']';
        }
        StringBuilder sbR3 = c.a.a.a.a.r("[size=");
        sbR3.append(getData().length);
        sbR3.append(" text=");
        sbR3.append(strC);
        sbR3.append("…]");
        return sbR3.toString();
    }

    @NotNull
    public String utf8() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@NotNull OutputStream out) throws IOException {
        j.e(out, "out");
        out.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer, int offset, int byteCount) {
        j.e(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, offset, byteCount);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(@org.jetbrains.annotations.NotNull okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            f.c0.c.j.e(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@NotNull byte[] suffix) {
        j.e(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] other, int fromIndex) {
        j.e(other, "other");
        int length = getData().length - other.length;
        int iMax = Math.max(fromIndex, 0);
        if (iMax <= length) {
            while (!Util.arrayRangeEquals(getData(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] other, int fromIndex) {
        j.e(other, "other");
        for (int iMin = Math.min(fromIndex, getData().length - other.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(getData(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        j.e(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && Util.arrayRangeEquals(getData(), offset, other, otherOffset, byteCount);
    }

    public final boolean startsWith(@NotNull byte[] prefix) {
        j.e(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }
}
