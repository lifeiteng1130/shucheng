package okhttp3.internal;

import androidx.exifinterface.media.ExifInterface;
import c.a.a.a.a;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.y;
import f.e0.d;
import f.h0.g;
import f.h0.k;
import f.v;
import f.x.e;
import f.x.i;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0007*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u001c\u0010\u001d\u001a%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\"\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#\u001a%\u0010$\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b$\u0010#\u001a%\u0010%\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010)\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010,\u001a\u0011\u0010-\u001a\u00020\u001b*\u00020\u0007¢\u0006\u0004\b-\u0010.\u001a\u0011\u0010/\u001a\u00020\t*\u00020\u0007¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002020\u000e\"\u000202¢\u0006\u0004\b1\u00104\u001a\u0019\u00108\u001a\u000206*\u0002052\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109\u001a'\u0010=\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>\u001a\u0011\u0010?\u001a\u00020\u001b*\u00020*¢\u0006\u0004\b?\u0010@\u001a\u0017\u0010D\u001a\u00020C*\b\u0012\u0004\u0012\u00020B0A¢\u0006\u0004\bD\u0010E\u001a\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020B0A*\u00020C¢\u0006\u0004\bF\u0010G\u001a\u0019\u0010H\u001a\u00020\t*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\bH\u0010I\u001a\u0011\u0010L\u001a\u00020K*\u00020J¢\u0006\u0004\bL\u0010M\u001a\u001c\u0010P\u001a\u00020\u001b*\u00020N2\u0006\u0010O\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bP\u0010Q\u001a\u001c\u0010P\u001a\u00020\u001b*\u00020R2\u0006\u0010O\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bP\u0010S\u001a\u001c\u0010P\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010O\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\bP\u0010T\u001a\u0019\u0010W\u001a\u00020\u0004*\u00020U2\u0006\u0010V\u001a\u00020\u001b¢\u0006\u0004\bW\u0010X\u001a\u0011\u0010Y\u001a\u00020\u001b*\u000205¢\u0006\u0004\bY\u0010Z\u001a!\u0010]\u001a\u00020\t*\u00020[2\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020;¢\u0006\u0004\b]\u0010^\u001a!\u0010`\u001a\u00020\t*\u00020[2\u0006\u0010_\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020;¢\u0006\u0004\b`\u0010^\u001a\u0011\u0010b\u001a\u00020\u0007*\u00020a¢\u0006\u0004\bb\u0010c\u001a\u0019\u0010e\u001a\u00020\t*\u00020a2\u0006\u0010d\u001a\u000205¢\u0006\u0004\be\u0010f\u001a!\u0010i\u001a\u00020\u00042\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040gH\u0086\bø\u0001\u0000¢\u0006\u0004\bi\u0010j\u001a)\u0010k\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040gH\u0086\bø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001a\u0019\u0010]\u001a\u00020\u001b*\u00020m2\u0006\u0010n\u001a\u00020N¢\u0006\u0004\b]\u0010o\u001a\u001b\u0010p\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b¢\u0006\u0004\bp\u0010q\u001a\u0011\u0010s\u001a\u00020\u0000*\u00020r¢\u0006\u0004\bs\u0010t\u001a\u0019\u0010v\u001a\u00020\u0000*\u00020\u00072\u0006\u0010u\u001a\u00020\u0000¢\u0006\u0004\bv\u0010w\u001a\u001b\u0010x\u001a\u00020\u001b*\u0004\u0018\u00010\u00072\u0006\u0010u\u001a\u00020\u001b¢\u0006\u0004\bx\u0010q\u001a#\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010y*\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bz\u0010{\u001a/\u0010}\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010y2\u0012\u0010|\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e\"\u00028\u0000H\u0007¢\u0006\u0004\b}\u0010~\u001a;\u0010\u0082\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0081\u0001\"\u0004\b\u0000\u0010\u007f\"\u0005\b\u0001\u0010\u0080\u0001*\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0081\u0001¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0015\u0010\u0085\u0001\u001a\u00020\u0004*\u00030\u0084\u0001¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0014\u0010\u0085\u0001\u001a\u00020\u0004*\u00020a¢\u0006\u0006\b\u0085\u0001\u0010\u0087\u0001\u001a\u0015\u0010\u0085\u0001\u001a\u00020\u0004*\u00030\u0088\u0001¢\u0006\u0006\b\u0085\u0001\u0010\u0089\u0001\u001a\u001f\u0010\u008d\u0001\u001a\u00020\t*\u00030\u008a\u00012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0014\u0010\u008f\u0001\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0014\u0010\u008f\u0001\u001a\u00020\u0007*\u00020\u001b¢\u0006\u0006\b\u008f\u0001\u0010\u0091\u0001\u001a\u0017\u0010\u0092\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0017\u0010\u0094\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u0094\u0001\u0010\u0093\u0001\u001a\u0017\u0010\u0095\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u0095\u0001\u0010\u0093\u0001\u001a:\u0010\u009a\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010y2\u0007\u0010\u0096\u0001\u001a\u0002022\u000e\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0097\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a-\u0010\u009f\u0001\u001a\u00020\u0004\"\u0005\b\u0000\u0010\u009c\u0001*\t\u0012\u0004\u0012\u00028\u00000\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00028\u0000H\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0017\u0010¡\u0001\u001a\u00020\u0004*\u000202H\u0080\b¢\u0006\u0006\b¡\u0001\u0010\u0093\u0001\u001a\u0017\u0010¢\u0001\u001a\u00020\u0004*\u000202H\u0080\b¢\u0006\u0006\b¢\u0001\u0010\u0093\u0001\u001a0\u0010§\u0001\u001a\u00030¦\u0001*\b0£\u0001j\u0003`¤\u00012\u0013\u0010¥\u0001\u001a\u000e\u0012\n\u0012\b0£\u0001j\u0003`¤\u00010A¢\u0006\u0006\b§\u0001\u0010¨\u0001\u001aI\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010y*\t\u0012\u0004\u0012\u00028\u00000©\u00012\u001a\u0010¬\u0001\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0ª\u0001¢\u0006\u0003\b«\u0001H\u0086\bø\u0001\u0000¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001\"\u0019\u0010¯\u0001\u001a\u00020\u00078\u0000@\u0001X\u0081\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001\"\u0019\u0010±\u0001\u001a\u00020\t8\u0000@\u0001X\u0081\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001\"\u001a\u0010´\u0001\u001a\u00030³\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001\"\u001a\u0010·\u0001\u001a\u00030¶\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001\"\u001a\u0010º\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001\"\u0019\u0010¼\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\b\n\u0006\b¼\u0001\u0010°\u0001\"\u001a\u0010¾\u0001\u001a\u00030½\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001\"\u001a\u0010Á\u0001\u001a\u00030À\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001\"\u0019\u0010Ã\u0001\u001a\u00020C8\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001\"\u001a\u0010Æ\u0001\u001a\u00030Å\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006È\u0001"}, d2 = {"", "arrayLength", "offset", "count", "Lf/v;", "checkOffsetAndCount", "(JJJ)V", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "", "other", "Ljava/util/Comparator;", "comparator", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/HttpUrl;", "includeDefaultPort", "toHostHeader", "(Lokhttp3/HttpUrl;Z)Ljava/lang/String;", ES6Iterator.VALUE_PROPERTY, "", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "indexOfFirstNonAsciiWhitespace", "(Ljava/lang/String;II)I", "indexOfLastNonAsciiWhitespace", "trimSubstring", "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", "delimiterOffset", "(Ljava/lang/String;Ljava/lang/String;II)I", "", "delimiter", "(Ljava/lang/String;CII)I", "indexOfControlOrNonAscii", "(Ljava/lang/String;)I", "canParseAsIpAddress", "(Ljava/lang/String;)Z", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lokio/BufferedSource;", "Ljava/nio/charset/Charset;", "default", "readBomAsCharset", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "checkDuration", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "parseHexDigit", "(C)I", "", "Lokhttp3/internal/http2/Header;", "Lokhttp3/Headers;", "toHeaders", "(Ljava/util/List;)Lokhttp3/Headers;", "toHeaderList", "(Lokhttp3/Headers;)Ljava/util/List;", "canReuseConnectionFor", "(Lokhttp3/HttpUrl;Lokhttp3/HttpUrl;)Z", "Lokhttp3/EventListener;", "Lokhttp3/EventListener$Factory;", "asFactory", "(Lokhttp3/EventListener;)Lokhttp3/EventListener$Factory;", "", "mask", "and", "(BI)I", "", "(SI)I", "(IJ)J", "Lokio/BufferedSink;", "medium", "writeMedium", "(Lokio/BufferedSink;I)V", "readMedium", "(Lokio/BufferedSource;)I", "Lokio/Source;", "timeUnit", "skipAll", "(Lokio/Source;ILjava/util/concurrent/TimeUnit;)Z", "timeout", "discard", "Ljava/net/Socket;", "peerName", "(Ljava/net/Socket;)Ljava/lang/String;", "source", "isHealthy", "(Ljava/net/Socket;Lokio/BufferedSource;)Z", "Lkotlin/Function0;", "block", "ignoreIoExceptions", "(Lf/c0/b/a;)V", "threadName", "(Ljava/lang/String;Lf/c0/b/a;)V", "Lokio/Buffer;", "b", "(Lokio/Buffer;B)I", "indexOfNonWhitespace", "(Ljava/lang/String;I)I", "Lokhttp3/Response;", "headersContentLength", "(Lokhttp3/Response;)J", "defaultValue", "toLongOrDefault", "(Ljava/lang/String;J)J", "toNonNegativeInt", ExifInterface.GPS_DIRECTION_TRUE, "toImmutableList", "(Ljava/util/List;)Ljava/util/List;", "elements", "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/io/Closeable;", "closeQuietly", "(Ljava/io/Closeable;)V", "(Ljava/net/Socket;)V", "Ljava/net/ServerSocket;", "(Ljava/net/ServerSocket;)V", "Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "file", "isCivilized", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;)Z", "toHexString", "(J)Ljava/lang/String;", "(I)Ljava/lang/String;", "wait", "(Ljava/lang/Object;)V", "notify", "notifyAll", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "readFieldOrNull", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "", "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "assertThreadHoldsLock", "assertThreadDoesntHoldLock", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "withSuppressed", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "predicate", "filterList", "(Ljava/lang/Iterable;Lf/c0/b/l;)Ljava/util/List;", "okHttpName", "Ljava/lang/String;", "assertionsEnabled", "Z", "Lokhttp3/RequestBody;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "Lokio/Options;", "UNICODE_BOMS", "Lokio/Options;", "Lf/h0/g;", "VERIFY_AS_IP_ADDRESS", "Lf/h0/g;", TTDownloadField.TT_USERAGENT, "", "EMPTY_BYTE_ARRAY", "[B", "Ljava/util/TimeZone;", "UTC", "Ljava/util/TimeZone;", "EMPTY_HEADERS", "Lokhttp3/Headers;", "Lokhttp3/ResponseBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "okhttp"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Util")
public final class Util {

    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY;

    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = Headers.INSTANCE.of(new String[0]);

    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST;

    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;

    @JvmField
    @NotNull
    public static final TimeZone UTC;
    private static final g VERIFY_AS_IP_ADDRESS;

    @JvmField
    public static final boolean assertionsEnabled;

    @JvmField
    @NotNull
    public static final String okHttpName;

    @NotNull
    public static final String userAgent = "okhttp/4.9.1";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.INSTANCE, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.INSTANCE, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = DesugarTimeZone.getTimeZone("GMT");
        j.c(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new g("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        j.d(name, "OkHttpClient::class.java.name");
        String strA = k.A(name, "okhttp3.");
        j.e(strA, "$this$removeSuffix");
        j.e("Client", "suffix");
        if (k.g(strA, "Client", false, 2)) {
            strA = strA.substring(0, strA.length() - "Client".length());
            j.d(strA, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        okHttpName = strA;
    }

    public static final <E> void addIfAbsent(@NotNull List<E> list, E e2) {
        j.e(list, "$this$addIfAbsent");
        if (list.contains(e2)) {
            return;
        }
        list.add(e2);
    }

    public static final int and(byte b2, int i2) {
        return b2 & i2;
    }

    public static final int and(short s, int i2) {
        return s & i2;
    }

    public static final long and(int i2, long j2) {
        return ((long) i2) & j2;
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull final EventListener eventListener) {
        j.e(eventListener, "$this$asFactory");
        return new EventListener.Factory() { // from class: okhttp3.internal.Util.asFactory.1
            @Override // okhttp3.EventListener.Factory
            @NotNull
            public final EventListener create(@NotNull Call call) {
                j.e(call, "it");
                return eventListener;
            }
        };
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object obj) {
        j.e(obj, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            StringBuilder sbR = a.r("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            j.d(threadCurrentThread, "Thread.currentThread()");
            sbR.append(threadCurrentThread.getName());
            sbR.append(" MUST NOT hold lock on ");
            sbR.append(obj);
            throw new AssertionError(sbR.toString());
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object obj) {
        j.e(obj, "$this$assertThreadHoldsLock");
        if (!assertionsEnabled || Thread.holdsLock(obj)) {
            return;
        }
        StringBuilder sbR = a.r("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        j.d(threadCurrentThread, "Thread.currentThread()");
        sbR.append(threadCurrentThread.getName());
        sbR.append(" MUST hold lock on ");
        sbR.append(obj);
        throw new AssertionError(sbR.toString());
    }

    public static final boolean canParseAsIpAddress(@NotNull String str) {
        j.e(str, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl httpUrl, @NotNull HttpUrl httpUrl2) {
        j.e(httpUrl, "$this$canReuseConnectionFor");
        j.e(httpUrl2, "other");
        return j.a(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && j.a(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(@NotNull String str, long j2, @Nullable TimeUnit timeUnit) {
        j.e(str, "name");
        boolean z = true;
        if (!(j2 >= 0)) {
            throw new IllegalStateException(a.i(str, " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j2);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.i(str, " too large.").toString());
        }
        if (millis == 0 && j2 > 0) {
            z = false;
        }
        if (z) {
            return (int) millis;
        }
        throw new IllegalArgumentException(a.i(str, " too small.").toString());
    }

    public static final void checkOffsetAndCount(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(@NotNull Closeable closeable) {
        j.e(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final String[] concat(@NotNull String[] strArr, @NotNull String str) {
        j.e(strArr, "$this$concat");
        j.e(str, ES6Iterator.VALUE_PROPERTY);
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        j.d(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[f.z2(strArr2)] = str;
        return strArr2;
    }

    public static final int delimiterOffset(@NotNull String str, @NotNull String str2, int i2, int i3) {
        j.e(str, "$this$delimiterOffset");
        j.e(str2, "delimiters");
        while (i2 < i3) {
            if (k.c(str2, str.charAt(i2), false, 2)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, str2, i2, i3);
    }

    public static final boolean discard(@NotNull Source source, int i2, @NotNull TimeUnit timeUnit) {
        j.e(source, "$this$discard");
        j.e(timeUnit, "timeUnit");
        try {
            return skipAll(source, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> iterable, @NotNull l<? super T, Boolean> lVar) {
        j.e(iterable, "$this$filterList");
        j.e(lVar, "predicate");
        ArrayList arrayList = i.INSTANCE;
        for (T t : iterable) {
            if (lVar.invoke(t).booleanValue()) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                y.b(arrayList).add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final String format(@NotNull String str, @NotNull Object... objArr) {
        j.e(str, "format");
        j.e(objArr, "args");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        j.d(str2, "java.lang.String.format(locale, format, *args)");
        return str2;
    }

    public static final boolean hasIntersection(@NotNull String[] strArr, @Nullable String[] strArr2, @NotNull Comparator<? super String> comparator) {
        j.e(strArr, "$this$hasIntersection");
        j.e(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(@NotNull Response response) {
        j.e(response, "$this$headersContentLength");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(@NotNull f.c0.b.a<v> aVar) {
        j.e(aVar, "block");
        try {
            aVar.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(@NotNull T... tArr) {
        j.e(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(e.u(Arrays.copyOf(objArr, objArr.length)));
        j.d(listUnmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int indexOf(@NotNull String[] strArr, @NotNull String str, @NotNull Comparator<String> comparator) {
        j.e(strArr, "$this$indexOf");
        j.e(str, ES6Iterator.VALUE_PROPERTY);
        j.e(comparator, "comparator");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@NotNull String str) {
        j.e(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (j.g(cCharAt, 31) <= 0 || j.g(cCharAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String str, int i2, int i3) {
        j.e(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String str, int i2, int i3) {
        j.e(str, "$this$indexOfLastNonAsciiWhitespace");
        int i4 = i3 - 1;
        if (i4 >= i2) {
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4--;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfNonWhitespace(@NotNull String str, int i2) {
        j.e(str, "$this$indexOfNonWhitespace");
        int length = str.length();
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return indexOfNonWhitespace(str, i2);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] strArr, @NotNull String[] strArr2, @NotNull Comparator<? super String> comparator) {
        j.e(strArr, "$this$intersect");
        j.e(strArr2, "other");
        j.e(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public static final boolean isCivilized(@NotNull FileSystem fileSystem, @NotNull File file) throws IOException {
        j.e(fileSystem, "$this$isCivilized");
        j.e(file, "file");
        Sink sink = fileSystem.sink(file);
        try {
            fileSystem.delete(file);
            f.P0(sink, null);
            return true;
        } catch (IOException unused) {
            f.P0(sink, null);
            fileSystem.delete(file);
            return false;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.P0(sink, th);
                throw th2;
            }
        }
    }

    public static final boolean isHealthy(@NotNull Socket socket, @NotNull BufferedSource bufferedSource) {
        j.e(socket, "$this$isHealthy");
        j.e(bufferedSource, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z = !bufferedSource.exhausted();
                socket.setSoTimeout(soTimeout);
                return z;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void notify(@NotNull Object obj) {
        j.e(obj, "$this$notify");
        obj.notify();
    }

    public static final void notifyAll(@NotNull Object obj) {
        j.e(obj, "$this$notifyAll");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    @NotNull
    public static final String peerName(@NotNull Socket socket) {
        j.e(socket, "$this$peerName");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        j.d(hostName, "address.hostName");
        return hostName;
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource bufferedSource, @NotNull Charset charset) {
        Charset charsetForName;
        j.e(bufferedSource, "$this$readBomAsCharset");
        j.e(charset, "default");
        int iSelect = bufferedSource.select(UNICODE_BOMS);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            j.d(charset2, "UTF_8");
            return charset2;
        }
        if (iSelect == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            j.d(charset3, "UTF_16BE");
            return charset3;
        }
        if (iSelect == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            j.d(charset4, "UTF_16LE");
            return charset4;
        }
        if (iSelect == 3) {
            f.h0.a aVar = f.h0.a.f6144d;
            charsetForName = f.h0.a.f6143c;
            if (charsetForName == null) {
                charsetForName = Charset.forName("UTF-32BE");
                j.d(charsetForName, "Charset.forName(\"UTF-32BE\")");
                f.h0.a.f6143c = charsetForName;
            }
        } else {
            if (iSelect != 4) {
                throw new AssertionError();
            }
            f.h0.a aVar2 = f.h0.a.f6144d;
            charsetForName = f.h0.a.f6142b;
            if (charsetForName == null) {
                charsetForName = Charset.forName("UTF-32LE");
                j.d(charsetForName, "Charset.forName(\"UTF-32LE\")");
                f.h0.a.f6142b = charsetForName;
            }
        }
        return charsetForName;
    }

    @Nullable
    public static final <T> T readFieldOrNull(@NotNull Object obj, @NotNull Class<T> cls, @NotNull String str) throws IllegalAccessException {
        T tCast;
        Object fieldOrNull;
        j.e(obj, "instance");
        j.e(cls, "fieldType");
        j.e(str, "fieldName");
        Class<?> superclass = obj.getClass();
        while (true) {
            tCast = null;
            if (!(!j.a(superclass, Object.class))) {
                if (!(!j.a(str, "delegate")) || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, cls, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                j.d(declaredField, "field");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    break;
                }
                tCast = cls.cast(obj2);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                j.d(superclass, "c.superclass");
            }
        }
        return tCast;
    }

    public static final int readMedium(@NotNull BufferedSource bufferedSource) {
        j.e(bufferedSource, "$this$readMedium");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[PHI: r12
  0x005b: PHI (r12v6 boolean) = (r12v5 boolean), (r12v10 boolean) binds: [B:23:0x007e, B:13:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean skipAll(@org.jetbrains.annotations.NotNull okio.Source r11, int r12, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit r13) {
        /*
            java.lang.String r0 = "$this$skipAll"
            f.c0.c.j.e(r11, r0)
            java.lang.String r0 = "timeUnit"
            f.c0.c.j.e(r13, r0)
            long r0 = java.lang.System.nanoTime()
            okio.Timeout r2 = r11.timeout()
            boolean r2 = r2.getHasDeadline()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L27
            okio.Timeout r2 = r11.timeout()
            long r5 = r2.deadlineNanoTime()
            long r5 = r5 - r0
            goto L28
        L27:
            r5 = r3
        L28:
            okio.Timeout r2 = r11.timeout()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.deadlineNanoTime(r12)
            okio.Buffer r12 = new okio.Buffer     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r12.<init>()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
        L3e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.read(r12, r7)     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L4e
            r12.clear()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            goto L3e
        L4e:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
        L53:
            okio.Timeout r11 = r11.timeout()
            r11.clearDeadline()
            goto L81
        L5b:
            okio.Timeout r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
            goto L81
        L64:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L71
            okio.Timeout r11 = r11.timeout()
            r11.clearDeadline()
            goto L79
        L71:
            okio.Timeout r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
        L79:
            throw r12
        L7a:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
            goto L53
        L81:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull final String str, final boolean z) {
        j.e(str, "name");
        return new ThreadFactory() { // from class: okhttp3.internal.Util.threadFactory.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static final void threadName(@NotNull String str, @NotNull f.c0.b.a<v> aVar) {
        j.e(str, "name");
        j.e(aVar, "block");
        Thread threadCurrentThread = Thread.currentThread();
        j.d(threadCurrentThread, "currentThread");
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(str);
        try {
            aVar.invoke();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers headers) {
        j.e(headers, "$this$toHeaderList");
        d dVarF = f.e0.e.f(0, headers.size());
        ArrayList arrayList = new ArrayList(f.S0(dVarF, 10));
        Iterator<Integer> it = dVarF.iterator();
        while (it.hasNext()) {
            int iNextInt = ((f.x.l) it).nextInt();
            arrayList.add(new Header(headers.name(iNextInt), headers.value(iNextInt)));
        }
        return arrayList;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> list) {
        j.e(list, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.getName().utf8(), header.getValue().utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final String toHexString(long j2) {
        String hexString = Long.toHexString(j2);
        j.d(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl httpUrl, boolean z) {
        String strHost;
        j.e(httpUrl, "$this$toHostHeader");
        if (k.d(httpUrl.host(), ":", false, 2)) {
            StringBuilder sbQ = a.q('[');
            sbQ.append(httpUrl.host());
            sbQ.append(']');
            strHost = sbQ.toString();
        } else {
            strHost = httpUrl.host();
        }
        if (!z && httpUrl.port() == HttpUrl.INSTANCE.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> list) {
        j.e(list, "$this$toImmutableList");
        List<T> listUnmodifiableList = Collections.unmodifiableList(e.I(list));
        j.d(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> map) {
        j.e(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return e.i();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        j.d(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return mapUnmodifiableMap;
    }

    public static final long toLongOrDefault(@NotNull String str, long j2) {
        j.e(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static final int toNonNegativeInt(@Nullable String str, int i2) {
        if (str != null) {
            try {
                long j2 = Long.parseLong(str);
                if (j2 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j2 < 0) {
                    return 0;
                }
                return (int) j2;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    @NotNull
    public static final String trimSubstring(@NotNull String str, int i2, int i3) {
        j.e(str, "$this$trimSubstring");
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i2, i3);
        String strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i3));
        j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return trimSubstring(str, i2, i3);
    }

    public static final void wait(@NotNull Object obj) throws InterruptedException {
        j.e(obj, "$this$wait");
        obj.wait();
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception exc, @NotNull List<? extends Exception> list) {
        j.e(exc, "$this$withSuppressed");
        j.e(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            f.V(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(@NotNull BufferedSink bufferedSink, int i2) {
        j.e(bufferedSink, "$this$writeMedium");
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
    }

    public static final int delimiterOffset(@NotNull String str, char c2, int i2, int i3) {
        j.e(str, "$this$delimiterOffset");
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, c2, i2, i3);
    }

    @NotNull
    public static final String toHexString(int i2) {
        String hexString = Integer.toHexString(i2);
        j.d(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final void closeQuietly(@NotNull Socket socket) {
        j.e(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!j.a(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(@NotNull ServerSocket serverSocket) {
        j.e(serverSocket, "$this$closeQuietly");
        try {
            serverSocket.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(@NotNull Buffer buffer, byte b2) throws EOFException {
        j.e(buffer, "$this$skipAll");
        int i2 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b2) {
            i2++;
            buffer.readByte();
        }
        return i2;
    }
}
