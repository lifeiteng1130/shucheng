package okio;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.bw;
import f.c0.c.j;
import f.x.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import okhttp3.internal.connection.RealConnection;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Î\u0001B\b¢\u0006\u0005\bÍ\u0001\u0010jJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0001H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010&J+\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b)\u0010*J'\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b)\u0010+J\u001f\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010,J!\u0010-\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b-\u0010.J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010/J\u001d\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u00100J\r\u00101\u001a\u00020\u0007¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u0018\u00109\u001a\u0002032\u0006\u00106\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b7\u00108J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u00102J\u000f\u0010A\u001a\u00020:H\u0016¢\u0006\u0004\bA\u0010<J\u000f\u0010B\u001a\u00020=H\u0016¢\u0006\u0004\bB\u0010?J\u000f\u0010C\u001a\u00020\u0007H\u0016¢\u0006\u0004\bC\u00102J\u000f\u0010D\u001a\u00020\u0007H\u0016¢\u0006\u0004\bD\u00102J\u000f\u0010E\u001a\u00020\u0007H\u0016¢\u0006\u0004\bE\u00102J\u000f\u0010F\u001a\u00020\u0010H\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010F\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bF\u0010HJ\u0017\u0010K\u001a\u00020=2\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u001f\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010Q\u001a\u00020\u00072\u0006\u0010M\u001a\u00020PH\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u000eH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010S\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bS\u0010UJ\u0017\u0010X\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bX\u0010YJ\u001f\u0010X\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bX\u0010ZJ\u0011\u0010[\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b[\u0010TJ\u000f\u0010\\\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\\\u0010TJ\u0017\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\\\u0010UJ\u000f\u0010^\u001a\u00020=H\u0016¢\u0006\u0004\b^\u0010?J\u000f\u0010`\u001a\u00020_H\u0016¢\u0006\u0004\b`\u0010aJ\u0017\u0010`\u001a\u00020_2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b`\u0010bJ\u0017\u0010c\u001a\u00020=2\u0006\u0010M\u001a\u00020_H\u0016¢\u0006\u0004\bc\u0010dJ\u0017\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020_H\u0016¢\u0006\u0004\bN\u0010eJ'\u0010c\u001a\u00020=2\u0006\u0010M\u001a\u00020_2\u0006\u0010(\u001a\u00020=2\u0006\u0010\b\u001a\u00020=H\u0016¢\u0006\u0004\bc\u0010fJ\u0017\u0010c\u001a\u00020=2\u0006\u0010M\u001a\u00020gH\u0016¢\u0006\u0004\bc\u0010hJ\r\u0010i\u001a\u00020\u000b¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bk\u0010 J\u0017\u0010m\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0010H\u0016¢\u0006\u0004\bm\u0010nJ'\u0010m\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u00102\u0006\u0010(\u001a\u00020=2\u0006\u0010\b\u001a\u00020=H\u0016¢\u0006\u0004\bm\u0010oJ\u0017\u0010q\u001a\u00020\u00002\u0006\u0010p\u001a\u00020\u000eH\u0016¢\u0006\u0004\bq\u0010rJ'\u0010q\u001a\u00020\u00002\u0006\u0010p\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020=2\u0006\u0010t\u001a\u00020=H\u0016¢\u0006\u0004\bq\u0010uJ\u0017\u0010w\u001a\u00020\u00002\u0006\u0010v\u001a\u00020=H\u0016¢\u0006\u0004\bw\u0010xJ\u001f\u0010y\u001a\u00020\u00002\u0006\u0010p\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\by\u0010zJ/\u0010y\u001a\u00020\u00002\u0006\u0010p\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020=2\u0006\u0010t\u001a\u00020=2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\by\u0010{J\u0017\u0010m\u001a\u00020\u00002\u0006\u0010|\u001a\u00020_H\u0016¢\u0006\u0004\bm\u0010}J'\u0010m\u001a\u00020\u00002\u0006\u0010|\u001a\u00020_2\u0006\u0010(\u001a\u00020=2\u0006\u0010\b\u001a\u00020=H\u0016¢\u0006\u0004\bm\u0010~J\u0017\u0010m\u001a\u00020=2\u0006\u0010|\u001a\u00020gH\u0016¢\u0006\u0004\bm\u0010hJ\u001a\u0010\u0080\u0001\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u007fH\u0016¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J \u0010m\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\u007f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0005\bm\u0010\u0082\u0001J\u001a\u0010\u0084\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020=H\u0016¢\u0006\u0005\b\u0084\u0001\u0010xJ\u001a\u0010\u0086\u0001\u001a\u00020\u00002\u0007\u0010\u0085\u0001\u001a\u00020=H\u0016¢\u0006\u0005\b\u0086\u0001\u0010xJ\u001a\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0085\u0001\u001a\u00020=H\u0016¢\u0006\u0005\b\u0087\u0001\u0010xJ\u001a\u0010\u0089\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u00020=H\u0016¢\u0006\u0005\b\u0089\u0001\u0010xJ\u001a\u0010\u008a\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u00020=H\u0016¢\u0006\u0005\b\u008a\u0001\u0010xJ\u001b\u0010\u008c\u0001\u001a\u00020\u00002\u0007\u0010\u008b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001b\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u008e\u0001\u0010\u008d\u0001J\u001b\u0010\u008f\u0001\u001a\u00020\u00002\u0007\u0010\u008b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u008d\u0001J\u001b\u0010\u0090\u0001\u001a\u00020\u00002\u0007\u0010\u008b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u008d\u0001J\u001c\u0010\u0095\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0091\u0001\u001a\u00020=H\u0000¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001f\u0010m\u001a\u00020\u000b2\u0006\u0010|\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bm\u0010OJ \u0010c\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0005\bc\u0010\u0096\u0001J\u001b\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u000203H\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J$\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0099\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u009a\u0001J-\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0099\u0001\u001a\u00020\u00072\u0007\u0010\u009b\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u009c\u0001J\u001b\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u009e\u0001J$\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u00102\u0007\u0010\u0099\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u009f\u0001J\u001b\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b¡\u0001\u0010\u009e\u0001J$\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u00102\u0007\u0010\u0099\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b¡\u0001\u0010\u009f\u0001J#\u0010¢\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0006\b¢\u0001\u0010£\u0001J4\u0010¢\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u00102\u0007\u0010¤\u0001\u001a\u00020=2\u0006\u0010\b\u001a\u00020=H\u0016¢\u0006\u0006\b¢\u0001\u0010¥\u0001J\u0011\u0010¦\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b¦\u0001\u0010jJ\u0011\u0010§\u0001\u001a\u00020\tH\u0016¢\u0006\u0005\b§\u0001\u0010\u001eJ\u0011\u0010¨\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b¨\u0001\u0010jJ\u0013\u0010ª\u0001\u001a\u00030©\u0001H\u0016¢\u0006\u0006\bª\u0001\u0010«\u0001J\u000f\u0010¬\u0001\u001a\u00020\u0010¢\u0006\u0005\b¬\u0001\u0010GJ\u000f\u0010\u00ad\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u00ad\u0001\u0010GJ\u000f\u0010®\u0001\u001a\u00020\u0010¢\u0006\u0005\b®\u0001\u0010GJ\u000f\u0010¯\u0001\u001a\u00020\u0010¢\u0006\u0005\b¯\u0001\u0010GJ\u0018\u0010°\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\b°\u0001\u0010±\u0001J\u0018\u0010²\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\b²\u0001\u0010±\u0001J\u0018\u0010³\u0001\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0006\b³\u0001\u0010±\u0001J\u001f\u0010¶\u0001\u001a\u00020\t2\n\u0010µ\u0001\u001a\u0005\u0018\u00010´\u0001H\u0096\u0002¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u0011\u0010¸\u0001\u001a\u00020=H\u0016¢\u0006\u0005\b¸\u0001\u0010?J\u0011\u0010¹\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b¹\u0001\u0010TJ\u000f\u0010º\u0001\u001a\u00020\u0000¢\u0006\u0005\bº\u0001\u0010\u0017J\u0011\u0010»\u0001\u001a\u00020\u0000H\u0016¢\u0006\u0005\b»\u0001\u0010\u0017J\u000f\u0010¼\u0001\u001a\u00020\u0010¢\u0006\u0005\b¼\u0001\u0010GJ\u0018\u0010¼\u0001\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020=¢\u0006\u0006\b¼\u0001\u0010½\u0001J\u001f\u0010À\u0001\u001a\u00030¾\u00012\n\b\u0002\u0010¿\u0001\u001a\u00030¾\u0001H\u0007¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u001f\u0010Â\u0001\u001a\u00030¾\u00012\n\b\u0002\u0010¿\u0001\u001a\u00030¾\u0001H\u0007¢\u0006\u0006\bÂ\u0001\u0010Á\u0001J\u0019\u00107\u001a\u0002032\u0007\u0010Ã\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\bÄ\u0001\u00108J\u0011\u0010Æ\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\bÅ\u0001\u00102R0\u0010Æ\u0001\u001a\u00020\u00072\u0007\u0010Ç\u0001\u001a\u00020\u00078G@@X\u0086\u000e¢\u0006\u0016\n\u0006\bÆ\u0001\u0010È\u0001\u001a\u0005\bÆ\u0001\u00102\"\u0005\bÉ\u0001\u0010 R\u001c\u0010Ê\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010\u0016\u001a\u00020\u00008V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\bÌ\u0001\u0010\u0017¨\u0006Ï\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "Ljava/io/InputStream;", "input", "", "byteCount", "", "forever", "Lf/v;", "readFrom", "(Ljava/io/InputStream;JZ)V", "", "algorithm", "Lokio/ByteString;", "digest", "(Ljava/lang/String;)Lokio/ByteString;", "key", "hmac", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "buffer", "()Lokio/Buffer;", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "emitCompleteSegments", "emit", "exhausted", "()Z", "require", "(J)V", "request", "(J)Z", "peek", "()Lokio/BufferedSource;", "inputStream", "()Ljava/io/InputStream;", "out", "offset", "copyTo", "(Ljava/io/OutputStream;JJ)Lokio/Buffer;", "(Lokio/Buffer;JJ)Lokio/Buffer;", "(Lokio/Buffer;J)Lokio/Buffer;", "writeTo", "(Ljava/io/OutputStream;J)Lokio/Buffer;", "(Ljava/io/InputStream;)Lokio/Buffer;", "(Ljava/io/InputStream;J)Lokio/Buffer;", "completeSegmentByteCount", "()J", "", "readByte", "()B", "pos", "getByte", "(J)B", "get", "", "readShort", "()S", "", "readInt", "()I", "readLong", "readShortLe", "readIntLe", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "select", "(Lokio/Options;)I", "sink", "readFully", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "", "readByteArray", "()[B", "(J)[B", "read", "([B)I", "([B)V", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "clear", "()V", "skip", "byteString", "write", "(Lokio/ByteString;)Lokio/Buffer;", "(Lokio/ByteString;II)Lokio/Buffer;", "string", "writeUtf8", "(Ljava/lang/String;)Lokio/Buffer;", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "writeUtf8CodePoint", "(I)Lokio/Buffer;", "writeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/Buffer;", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/Buffer;", "source", "([B)Lokio/Buffer;", "([BII)Lokio/Buffer;", "Lokio/Source;", "writeAll", "(Lokio/Source;)J", "(Lokio/Source;J)Lokio/Buffer;", "b", "writeByte", ai.az, "writeShort", "writeShortLe", ai.aA, "writeInt", "writeIntLe", ai.aC, "writeLong", "(J)Lokio/Buffer;", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "minimumCapacity", "Lokio/Segment;", "writableSegment$okio", "(I)Lokio/Segment;", "writableSegment", "(Lokio/Buffer;J)J", "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "targetBytes", "indexOfElement", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "flush", "isOpen", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "md5", "sha1", "sha256", "sha512", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "", "other", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "copy", "clone", "snapshot", "(I)Lokio/ByteString;", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readUnsafe", "(Lokio/Buffer$UnsafeCursor;)Lokio/Buffer$UnsafeCursor;", "readAndWriteUnsafe", "index", "-deprecated_getByte", "-deprecated_size", "size", "<set-?>", "J", "setSize$okio", "head", "Lokio/Segment;", "getBuffer", "<init>", "UnsafeCursor", "okio"}, k = 1, mv = {1, 4, 0})
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @JvmField
    @Nullable
    public Segment head;
    private long size;

    /* JADX INFO: compiled from: Buffer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "", ES6Iterator.NEXT_METHOD, "()I", "", "offset", "seek", "(J)I", "newSize", "resizeBuffer", "(J)J", "minByteCount", "expandBuffer", "(I)J", "Lf/v;", "close", "()V", "Lokio/Segment;", "segment", "Lokio/Segment;", "start", OptRuntime.GeneratorState.resumptionPoint_TYPE, "", "data", "[B", "end", "J", "", "readWrite", "Z", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "<init>", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class UnsafeCursor implements Closeable {

        @JvmField
        @Nullable
        public Buffer buffer;

        @JvmField
        @Nullable
        public byte[] data;

        @JvmField
        public boolean readWrite;
        private Segment segment;

        @JvmField
        public long offset = -1;

        @JvmField
        public int start = -1;

        @JvmField
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int minByteCount) {
            if (!(minByteCount > 0)) {
                throw new IllegalArgumentException(a.G("minByteCount <= 0: ", minByteCount).toString());
            }
            if (!(minByteCount <= 8192)) {
                throw new IllegalArgumentException(a.G("minByteCount > Segment.SIZE: ", minByteCount).toString());
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(minByteCount);
            int i2 = 8192 - segmentWritableSegment$okio.limit;
            segmentWritableSegment$okio.limit = 8192;
            long j2 = i2;
            buffer.setSize$okio(size + j2);
            this.segment = segmentWritableSegment$okio;
            this.offset = size;
            this.data = segmentWritableSegment$okio.data;
            this.start = 8192 - i2;
            this.end = 8192;
            return j2;
        }

        public final int next() {
            long j2 = this.offset;
            Buffer buffer = this.buffer;
            j.c(buffer);
            if (!(j2 != buffer.size())) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j3 = this.offset;
            return seek(j3 == -1 ? 0L : j3 + ((long) (this.end - this.start)));
        }

        public final long resizeBuffer(long newSize) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            int i2 = 1;
            if (newSize <= size) {
                if (!(newSize >= 0)) {
                    throw new IllegalArgumentException(a.f("newSize < 0: ", newSize).toString());
                }
                long j2 = size - newSize;
                while (true) {
                    if (j2 <= 0) {
                        break;
                    }
                    Segment segment = buffer.head;
                    j.c(segment);
                    Segment segment2 = segment.prev;
                    j.c(segment2);
                    int i3 = segment2.limit;
                    long j3 = i3 - segment2.pos;
                    if (j3 > j2) {
                        segment2.limit = i3 - ((int) j2);
                        break;
                    }
                    buffer.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                    j2 -= j3;
                }
                this.segment = null;
                this.offset = newSize;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (newSize > size) {
                long j4 = newSize - size;
                boolean z = true;
                while (j4 > 0) {
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
                    int iMin = (int) Math.min(j4, 8192 - segmentWritableSegment$okio.limit);
                    int i4 = segmentWritableSegment$okio.limit + iMin;
                    segmentWritableSegment$okio.limit = i4;
                    j4 -= (long) iMin;
                    if (z) {
                        this.segment = segmentWritableSegment$okio;
                        this.offset = size;
                        this.data = segmentWritableSegment$okio.data;
                        this.start = i4 - iMin;
                        this.end = i4;
                        z = false;
                    }
                    i2 = 1;
                }
            }
            buffer.setSize$okio(newSize);
            return size;
        }

        public final int seek(long offset) {
            Segment segmentPush;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (offset < -1 || offset > buffer.size()) {
                String str = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(offset), Long.valueOf(buffer.size())}, 2));
                j.d(str, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(str);
            }
            if (offset == -1 || offset == buffer.size()) {
                this.segment = null;
                this.offset = offset;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long j2 = 0;
            long size = buffer.size();
            Segment segment = buffer.head;
            Segment segment2 = this.segment;
            if (segment2 != null) {
                long j3 = this.offset;
                int i2 = this.start;
                j.c(segment2);
                long j4 = j3 - ((long) (i2 - segment2.pos));
                if (j4 > offset) {
                    segmentPush = segment;
                    segment = this.segment;
                    size = j4;
                } else {
                    segmentPush = this.segment;
                    j2 = j4;
                }
            } else {
                segmentPush = segment;
            }
            if (size - offset > offset - j2) {
                while (true) {
                    j.c(segmentPush);
                    int i3 = segmentPush.limit;
                    int i4 = segmentPush.pos;
                    if (offset < ((long) (i3 - i4)) + j2) {
                        break;
                    }
                    j2 += (long) (i3 - i4);
                    segmentPush = segmentPush.next;
                }
            } else {
                while (size > offset) {
                    j.c(segment);
                    segment = segment.prev;
                    j.c(segment);
                    size -= (long) (segment.limit - segment.pos);
                }
                j2 = size;
                segmentPush = segment;
            }
            if (this.readWrite) {
                j.c(segmentPush);
                if (segmentPush.shared) {
                    Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                    if (buffer.head == segmentPush) {
                        buffer.head = segmentUnsharedCopy;
                    }
                    segmentPush = segmentPush.push(segmentUnsharedCopy);
                    Segment segment3 = segmentPush.prev;
                    j.c(segment3);
                    segment3.pop();
                }
            }
            this.segment = segmentPush;
            this.offset = offset;
            j.c(segmentPush);
            this.data = segmentPush.data;
            int i5 = segmentPush.pos + ((int) (offset - j2));
            this.start = i5;
            int i6 = segmentPush.limit;
            this.end = i6;
            return i6 - i5;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            j3 = buffer.size - j4;
        }
        return buffer.copyTo(outputStream, j4, j3);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return buffer.copyTo(buffer2, j2);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return buffer.copyTo(buffer2, j2, j3);
    }

    private final ByteString digest(String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            messageDigest.update(bArr, i2, segment.limit - i2);
            Segment segment2 = segment.next;
            j.c(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i3 = segment2.pos;
                messageDigest.update(bArr2, i3, segment2.limit - i3);
                segment2 = segment2.next;
                j.c(segment2);
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        j.d(bArrDigest, "messageDigest.digest()");
        return new ByteString(bArrDigest);
    }

    private final ByteString hmac(String algorithm, ByteString key) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.internalArray$okio(), algorithm));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i2 = segment.pos;
                mac.update(bArr, i2, segment.limit - i2);
                Segment segment2 = segment.next;
                j.c(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i3 = segment2.pos;
                    mac.update(bArr2, i3, segment2.limit - i3);
                    segment2 = segment2.next;
                    j.c(segment2);
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            j.d(bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = buffer.size;
        }
        return buffer.writeTo(outputStream, j2);
    }

    @Deprecated(level = f.a.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m169deprecated_getByte(long index) {
        return getByte(index);
    }

    @Deprecated(level = f.a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    /* JADX INFO: renamed from: buffer */
    public Buffer getBufferField() {
        return this;
    }

    public final void clear() throws EOFException {
        skip(size());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        j.c(segment);
        Segment segment2 = segment.prev;
        j.c(segment2);
        int i2 = segment2.limit;
        if (i2 < 8192 && segment2.owner) {
            size -= (long) (i2 - segment2.pos);
        }
        return size;
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            j.c(segment);
            Segment segmentSharedCopy = segment.sharedCopy();
            buffer.head = segmentSharedCopy;
            segmentSharedCopy.prev = segmentSharedCopy;
            segmentSharedCopy.next = segmentSharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = segmentSharedCopy.prev;
                j.c(segment3);
                j.c(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream) {
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j2) {
        return copyTo$default(this, outputStream, j2, 0L, 4, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out, long offset, long byteCount) throws IOException {
        j.e(out, "out");
        Util.checkOffsetAndCount(this.size, offset, byteCount);
        if (byteCount == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            j.c(segment);
            int i2 = segment.limit;
            int i3 = segment.pos;
            if (offset < i2 - i3) {
                break;
            }
            offset -= (long) (i2 - i3);
            segment = segment.next;
        }
        while (byteCount > 0) {
            j.c(segment);
            int i4 = (int) (((long) segment.pos) + offset);
            int iMin = (int) Math.min(segment.limit - i4, byteCount);
            out.write(segment.data, i4, iMin);
            byteCount -= (long) iMin;
            segment = segment.next;
            offset = 0;
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof Buffer)) {
                return false;
            }
            Buffer buffer = (Buffer) other;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() != 0) {
                Segment segment = this.head;
                j.c(segment);
                Segment segment2 = buffer.head;
                j.c(segment2);
                int i2 = segment.pos;
                int i3 = segment2.pos;
                long j2 = 0;
                while (j2 < size()) {
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
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    @JvmName(name = "getByte")
    public final byte getByte(long pos) {
        Util.checkOffsetAndCount(size(), pos, 1L);
        Segment segment = this.head;
        if (segment == null) {
            Segment segment2 = null;
            j.c(null);
            return segment2.data[(int) ((((long) segment2.pos) + pos) - (-1))];
        }
        if (size() - pos < pos) {
            long size = size();
            while (size > pos) {
                segment = segment.prev;
                j.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            j.c(segment);
            return segment.data[(int) ((((long) segment.pos) + pos) - size)];
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j2;
            if (j3 > pos) {
                j.c(segment);
                return segment.data[(int) ((((long) segment.pos) + pos) - j2)];
            }
            segment = segment.next;
            j.c(segment);
            j2 = j3;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
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
        } while (segment != this.head);
        return i2;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString key) {
        j.e(key, "key");
        return hmac("HmacSHA1", key);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString key) {
        j.e(key, "key");
        return hmac("HmacSHA256", key);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString key) {
        j.e(key, "key");
        return hmac("HmacSHA512", key);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, RecyclerView.FOREVER_NS);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes) {
        j.e(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.inputStream.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & ExifInterface.MARKER;
                }
                return -1;
            }

            @NotNull
            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(@NotNull byte[] sink, int offset, int byteCount) {
                j.e(sink, "sink");
                return Buffer.this.read(sink, offset, byteCount);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.outputStream.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @NotNull
            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int b2) {
                Buffer.this.writeByte(b2);
            }

            @Override // java.io.OutputStream
            public void write(@NotNull byte[] data, int offset, int byteCount) {
                j.e(data, "data");
                Buffer.this.write(data, offset, byteCount);
            }
        };
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, @NotNull ByteString bytes) {
        j.e(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) {
        j.e(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, iMin);
        int i2 = segment.pos + iMin;
        segment.pos = i2;
        this.size -= (long) iMin;
        if (i2 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) {
        j.e(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        j.e(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        j.c(segment);
        int i2 = segment.pos;
        int i3 = segment.limit;
        int i4 = i2 + 1;
        byte b2 = segment.data[i2];
        setSize$okio(size() - 1);
        if (i4 == i3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return b2;
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab A[EDGE_INSN: B:48:0x00ab->B:38:0x00ab BREAK  A[LOOP:0: B:5:0x0011->B:50:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            r17 = this;
            r0 = r17
            long r1 = r17.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lb9
            r1 = -7
            r5 = 0
            r6 = 0
            r7 = 0
        L11:
            okio.Segment r8 = r0.head
            f.c0.c.j.c(r8)
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L1c:
            if (r10 >= r11) goto L97
            r12 = r9[r10]
            r13 = 48
            byte r13 = (byte) r13
            if (r12 < r13) goto L6c
            r14 = 57
            byte r14 = (byte) r14
            if (r12 > r14) goto L6c
            int r13 = r13 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r16 < 0) goto L43
            if (r16 != 0) goto L3c
            long r14 = (long) r13
            int r16 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r16 >= 0) goto L3c
            goto L43
        L3c:
            r14 = 10
            long r3 = r3 * r14
            long r12 = (long) r13
            long r3 = r3 + r12
            goto L77
        L43:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong(r3)
            okio.Buffer r1 = r1.writeByte(r12)
            if (r6 != 0) goto L55
            r1.readByte()
        L55:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.String r3 = "Number too large: "
            java.lang.StringBuilder r3 = c.a.a.a.a.r(r3)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6c:
            r13 = 45
            byte r13 = (byte) r13
            if (r12 != r13) goto L7c
            if (r5 != 0) goto L7c
            r12 = 1
            long r1 = r1 - r12
            r6 = 1
        L77:
            int r10 = r10 + 1
            int r5 = r5 + 1
            goto L1c
        L7c:
            if (r5 == 0) goto L80
            r7 = 1
            goto L97
        L80:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r2 = c.a.a.a.a.r(r2)
            java.lang.String r3 = okio.Util.toHexString(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L97:
            if (r10 != r11) goto La3
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto La5
        La3:
            r8.pos = r10
        La5:
            if (r7 != 0) goto Lab
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L11
        Lab:
            long r1 = r17.size()
            long r7 = (long) r5
            long r1 = r1 - r7
            r0.setSize$okio(r1)
            if (r6 == 0) goto Lb7
            goto Lb8
        Lb7:
            long r3 = -r3
        Lb8:
            return r3
        Lb9:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input) throws IOException {
        j.e(input, "input");
        readFrom(input, RecyclerView.FOREVER_NS, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer sink, long byteCount) throws EOFException {
        j.e(sink, "sink");
        if (size() >= byteCount) {
            sink.write(this, byteCount);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[EDGE_INSN: B:43:0x00a5->B:37:0x00a5 BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Laf
            r0 = 0
            r1 = 0
            r4 = r2
        Ld:
            okio.Segment r6 = r15.head
            f.c0.c.j.c(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L18:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L42
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L34
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L34
            goto L3e
        L34:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L76
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L76
        L3e:
            int r11 = r10 - r11
            int r11 = r11 + 10
        L42:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L52
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L52:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r2 = c.a.a.a.a.r(r2)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L76:
            if (r0 == 0) goto L7a
            r1 = 1
            goto L91
        L7a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r1 = c.a.a.a.a.r(r1)
            java.lang.String r2 = okio.Util.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto L9f
        L9d:
            r6.pos = r8
        L9f:
            if (r1 != 0) goto La5
            okio.Segment r6 = r15.head
            if (r6 != 0) goto Ld
        La5:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Laf:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        j.c(segment);
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 4) {
            return ((readByte() & ExifInterface.MARKER) << 24) | ((readByte() & ExifInterface.MARKER) << 16) | ((readByte() & ExifInterface.MARKER) << 8) | (readByte() & ExifInterface.MARKER);
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & ExifInterface.MARKER) << 24) | ((bArr[i4] & ExifInterface.MARKER) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & ExifInterface.MARKER) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & ExifInterface.MARKER);
        setSize$okio(size() - 4);
        if (i9 == i3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i9;
        }
        return i10;
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        j.c(segment);
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
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
        setSize$okio(size() - 8);
        if (i11 == i3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i11;
        }
        return j9;
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        j.c(segment);
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 2) {
            return (short) (((readByte() & ExifInterface.MARKER) << 8) | (readByte() & ExifInterface.MARKER));
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & ExifInterface.MARKER) << 8) | (bArr[i4] & ExifInterface.MARKER);
        setSize$okio(size() - 2);
        if (i5 == i3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        j.e(charset, "charset");
        return readString(this.size, charset);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        j.e(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        return readString(this.size, f.h0.a.a);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b2 = getByte(0L);
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
                skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = b2 & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j2 = i3;
        if (size() < j2) {
            StringBuilder sbS = a.s("size < ", i3, ": ");
            sbS.append(size());
            sbS.append(" (to read code point prefixed 0x");
            sbS.append(Util.toHexString(b2));
            sbS.append(')');
            throw new EOFException(sbS.toString());
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j3 = i5;
            byte b3 = getByte(j3);
            if ((b3 & 192) != 128) {
                skip(j3);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = (i2 << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
        }
        skip(j2);
        return i2 > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i2 && 57343 >= i2) || i2 < i4) ? Utf8.REPLACEMENT_CODE_POINT : i2;
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this, jIndexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(RecyclerView.FOREVER_NS);
    }

    @Override // okio.BufferedSource
    public boolean request(long byteCount) {
        return this.size >= byteCount;
    }

    @Override // okio.BufferedSource
    public void require(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) throws EOFException {
        j.e(options, "options");
        int iSelectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public final void setSize$okio(long j2) {
        this.size = j2;
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    @JvmName(name = "size")
    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long byteCount) throws EOFException {
        while (byteCount > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(byteCount, segment.limit - segment.pos);
            long j2 = iMin;
            setSize$okio(size() - j2);
            byteCount -= j2;
            int i2 = segment.pos + iMin;
            segment.pos = i2;
            if (i2 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        StringBuilder sbR = a.r("size > Int.MAX_VALUE: ");
        sbR.append(size());
        throw new IllegalStateException(sbR.toString().toString());
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int minimumCapacity) {
        if (!(minimumCapacity >= 1 && minimumCapacity <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = this.head;
        if (segment != null) {
            j.c(segment);
            Segment segment2 = segment.prev;
            j.c(segment2);
            return (segment2.limit + minimumCapacity > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        this.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) {
        j.e(source, "source");
        long j2 = 0;
        while (true) {
            long j3 = source.read(this, 8192);
            if (j3 == -1) {
                return j2;
            }
            j2 += j3;
        }
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream outputStream) {
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream out, long byteCount) throws IOException {
        j.e(out, "out");
        Util.checkOffsetAndCount(this.size, 0L, byteCount);
        Segment segment = this.head;
        while (byteCount > 0) {
            j.c(segment);
            int iMin = (int) Math.min(byteCount, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, iMin);
            int i2 = segment.pos + iMin;
            segment.pos = i2;
            long j2 = iMin;
            this.size -= j2;
            byteCount -= j2;
            if (i2 == segment.limit) {
                Segment segmentPop = segment.pop();
                this.head = segmentPop;
                SegmentPool.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    @NotNull
    public Buffer clone() {
        return copy();
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long fromIndex) {
        return indexOf(b2, fromIndex, RecyclerView.FOREVER_NS);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes, long fromIndex) {
        int i2;
        int i3;
        j.e(targetBytes, "targetBytes");
        long size = 0;
        if (!(fromIndex >= 0)) {
            throw new IllegalArgumentException(a.f("fromIndex < 0: ", fromIndex).toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - fromIndex < fromIndex) {
            size = size();
            while (size > fromIndex) {
                segment = segment.prev;
                j.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            if (targetBytes.size() == 2) {
                byte b2 = targetBytes.getByte(0);
                byte b3 = targetBytes.getByte(1);
                while (size < size()) {
                    byte[] bArr = segment.data;
                    i2 = (int) ((((long) segment.pos) + fromIndex) - size);
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
                    fromIndex = size;
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
            while (size < size()) {
                byte[] bArr2 = segment.data;
                i2 = (int) ((((long) segment.pos) + fromIndex) - size);
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
                fromIndex = size;
            }
            return -1L;
        }
        while (true) {
            long j2 = ((long) (segment.limit - segment.pos)) + size;
            if (j2 > fromIndex) {
                break;
            }
            segment = segment.next;
            j.c(segment);
            size = j2;
        }
        if (targetBytes.size() == 2) {
            byte b7 = targetBytes.getByte(0);
            byte b8 = targetBytes.getByte(1);
            while (size < size()) {
                byte[] bArr3 = segment.data;
                i2 = (int) ((((long) segment.pos) + fromIndex) - size);
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
                fromIndex = size;
            }
            return -1L;
        }
        byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
        while (size < size()) {
            byte[] bArr4 = segment.data;
            i2 = (int) ((((long) segment.pos) + fromIndex) - size);
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
            fromIndex = size;
        }
        return -1L;
        return ((long) (i2 - i3)) + size;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, @NotNull ByteString bytes, int bytesOffset, int byteCount) {
        j.e(bytes, "bytes");
        if (offset < 0 || bytesOffset < 0 || byteCount < 0 || size() - offset < byteCount || bytes.size() - bytesOffset < byteCount) {
            return false;
        }
        for (int i2 = 0; i2 < byteCount; i2++) {
            if (getByte(((long) i2) + offset) != bytes.getByte(bytesOffset + i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long byteCount) throws EOFException {
        if (!(byteCount >= 0 && byteCount <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.f("byteCount: ", byteCount).toString());
        }
        if (size() < byteCount) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) byteCount];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long byteCount) throws EOFException {
        if (!(byteCount >= 0 && byteCount <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.f("byteCount: ", byteCount).toString());
        }
        if (size() < byteCount) {
            throw new EOFException();
        }
        if (byteCount < 4096) {
            return new ByteString(readByteArray(byteCount));
        }
        ByteString byteStringSnapshot = snapshot((int) byteCount);
        skip(byteCount);
        return byteStringSnapshot;
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input, long byteCount) throws IOException {
        j.e(input, "input");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(a.f("byteCount < 0: ", byteCount).toString());
        }
        readFrom(input, byteCount, false);
        return this;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long byteCount, @NotNull Charset charset) throws EOFException {
        j.e(charset, "charset");
        if (!(byteCount >= 0 && byteCount <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.f("byteCount: ", byteCount).toString());
        }
        if (this.size < byteCount) {
            throw new EOFException();
        }
        if (byteCount == 0) {
            return "";
        }
        Segment segment = this.head;
        j.c(segment);
        int i2 = segment.pos;
        if (((long) i2) + byteCount > segment.limit) {
            return new String(readByteArray(byteCount), charset);
        }
        int i3 = (int) byteCount;
        String str = new String(segment.data, i2, i3, charset);
        int i4 = segment.pos + i3;
        segment.pos = i4;
        this.size -= byteCount;
        if (i4 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long byteCount) throws EOFException {
        return readString(byteCount, f.h0.a.a);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(a.f("limit < 0: ", limit).toString());
        }
        long j2 = RecyclerView.FOREVER_NS;
        if (limit != RecyclerView.FOREVER_NS) {
            j2 = limit + 1;
        }
        byte b2 = (byte) 10;
        long jIndexOf = indexOf(b2, 0L, j2);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this, jIndexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == ((byte) 13) && getByte(j2) == b2) {
            return BufferKt.readUtf8Line(this, j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, size()));
        StringBuilder sbR = a.r("\\n not found: limit=");
        sbR.append(Math.min(size(), limit));
        sbR.append(" content=");
        sbR.append(buffer.readByteString().hex());
        sbR.append((char) 8230);
        throw new EOFException(sbR.toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeByte(int b2) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) b2;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeDecimalLong(long v) {
        if (v == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (v < 0) {
            v = -v;
            if (v < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (v >= 100000000) {
            i2 = v < 1000000000000L ? v < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? v < 1000000000 ? 9 : 10 : v < 100000000000L ? 11 : 12 : v < 1000000000000000L ? v < 10000000000000L ? 13 : v < 100000000000000L ? 14 : 15 : v < 100000000000000000L ? v < 10000000000000000L ? 16 : 17 : v < 1000000000000000000L ? 18 : 19;
        } else if (v >= 10000) {
            i2 = v < 1000000 ? v < 100000 ? 5 : 6 : v < 10000000 ? 7 : 8;
        } else if (v >= 100) {
            i2 = v < 1000 ? 3 : 4;
        } else if (v >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment segmentWritableSegment$okio = writableSegment$okio(i2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit + i2;
        while (v != 0) {
            long j2 = 10;
            i3--;
            bArr[i3] = BufferKt.getHEX_DIGIT_BYTES()[(int) (v % j2)];
            v /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i2;
        setSize$okio(size() + ((long) i2));
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long v) {
        if (v == 0) {
            return writeByte(48);
        }
        long j2 = (v >>> 1) | v;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i2 = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = writableSegment$okio(i2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & v)];
            v >>>= 4;
        }
        segmentWritableSegment$okio.limit += i2;
        setSize$okio(size() + ((long) i2));
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeInt(int i2) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
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
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeIntLe(int i2) {
        return writeInt(Util.reverseBytes(i2));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLong(long v) {
        Segment segmentWritableSegment$okio = writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((v >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((v >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((v >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((v >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((v >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((v >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((v >>> 8) & 255);
        bArr[i9] = (byte) (v & 255);
        segmentWritableSegment$okio.limit = i9 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLongLe(long v) {
        return writeLong(Util.reverseBytes(v));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShort(int s) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((s >>> 8) & 255);
        bArr[i3] = (byte) (s & 255);
        segmentWritableSegment$okio.limit = i3 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShortLe(int s) {
        return writeShort((int) Util.reverseBytes((short) s));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8CodePoint(int codePoint) {
        if (codePoint < 128) {
            writeByte(codePoint);
        } else if (codePoint < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i2 = segmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((codePoint >> 6) | 192);
            bArr[i2 + 1] = (byte) ((codePoint & 63) | 128);
            segmentWritableSegment$okio.limit = i2 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= codePoint && 57343 >= codePoint) {
            writeByte(63);
        } else if (codePoint < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i3 = segmentWritableSegment$okio2.limit;
            bArr2[i3] = (byte) ((codePoint >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((codePoint >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((codePoint & 63) | 128);
            segmentWritableSegment$okio2.limit = i3 + 3;
            setSize$okio(size() + 3);
        } else {
            if (codePoint > 1114111) {
                StringBuilder sbR = a.r("Unexpected code point: 0x");
                sbR.append(Util.toHexString(codePoint));
                throw new IllegalArgumentException(sbR.toString());
            }
            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i4 = segmentWritableSegment$okio3.limit;
            bArr3[i4] = (byte) ((codePoint >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((codePoint & 63) | 128);
            segmentWritableSegment$okio3.limit = i4 + 4;
            setSize$okio(size() + 4);
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes) {
        j.e(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, @NotNull Charset charset) {
        j.e(string, "string");
        j.e(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string) {
        j.e(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    private final void readFrom(InputStream input, long byteCount, boolean forever) throws IOException {
        while (true) {
            if (byteCount <= 0 && !forever) {
                return;
            }
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int i2 = input.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(byteCount, 8192 - segmentWritableSegment$okio.limit));
            if (i2 == -1) {
                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                    this.head = segmentWritableSegment$okio.pop();
                    SegmentPool.recycle(segmentWritableSegment$okio);
                }
                if (!forever) {
                    throw new EOFException();
                }
                return;
            }
            segmentWritableSegment$okio.limit += i2;
            long j2 = i2;
            this.size += j2;
            byteCount -= j2;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long fromIndex, long toIndex) {
        Segment segment;
        int i2;
        long size = 0;
        if (!(0 <= fromIndex && toIndex >= fromIndex)) {
            StringBuilder sbR = a.r("size=");
            sbR.append(size());
            sbR.append(" fromIndex=");
            sbR.append(fromIndex);
            sbR.append(" toIndex=");
            sbR.append(toIndex);
            throw new IllegalArgumentException(sbR.toString().toString());
        }
        if (toIndex > size()) {
            toIndex = size();
        }
        if (fromIndex == toIndex || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - fromIndex < fromIndex) {
            size = size();
            while (size > fromIndex) {
                segment = segment.prev;
                j.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            while (size < toIndex) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + toIndex) - size);
                i2 = (int) ((((long) segment.pos) + fromIndex) - size);
                while (i2 < iMin) {
                    if (bArr[i2] != b2) {
                        i2++;
                    }
                }
                size += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j.c(segment);
                fromIndex = size;
            }
            return -1L;
        }
        while (true) {
            long j2 = ((long) (segment.limit - segment.pos)) + size;
            if (j2 > fromIndex) {
                break;
            }
            segment = segment.next;
            j.c(segment);
            size = j2;
        }
        while (size < toIndex) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + toIndex) - size);
            i2 = (int) ((((long) segment.pos) + fromIndex) - size);
            while (i2 < iMin2) {
                if (bArr2[i2] != b2) {
                    i2++;
                }
            }
            size += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j.c(segment);
            fromIndex = size;
        }
        return -1L;
        return ((long) (i2 - segment.pos)) + size;
    }

    @NotNull
    public final ByteString snapshot(int byteCount) {
        if (byteCount == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0L, byteCount);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < byteCount) {
            j.c(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < byteCount) {
            j.c(segment2);
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, byteCount);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, int beginIndex, int endIndex, @NotNull Charset charset) {
        j.e(string, "string");
        j.e(charset, "charset");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(a.G("beginIndex < 0: ", beginIndex).toString());
        }
        if (endIndex >= beginIndex) {
            if (endIndex <= string.length()) {
                if (j.a(charset, f.h0.a.a)) {
                    return writeUtf8(string, beginIndex, endIndex);
                }
                String strSubstring = string.substring(beginIndex, endIndex);
                j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                byte[] bytes = strSubstring.getBytes(charset);
                j.d(bytes, "(this as java.lang.String).getBytes(charset)");
                return write(bytes, 0, bytes.length);
            }
            StringBuilder sbS = a.s("endIndex > string.length: ", endIndex, " > ");
            sbS.append(string.length());
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        throw new IllegalArgumentException(a.e("endIndex < beginIndex: ", endIndex, " < ", beginIndex).toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string, int beginIndex, int endIndex) {
        char cCharAt;
        j.e(string, "string");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(a.G("beginIndex < 0: ", beginIndex).toString());
        }
        if (endIndex >= beginIndex) {
            if (!(endIndex <= string.length())) {
                StringBuilder sbS = a.s("endIndex > string.length: ", endIndex, " > ");
                sbS.append(string.length());
                throw new IllegalArgumentException(sbS.toString().toString());
            }
            while (beginIndex < endIndex) {
                char cCharAt2 = string.charAt(beginIndex);
                if (cCharAt2 < 128) {
                    Segment segmentWritableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = segmentWritableSegment$okio.data;
                    int i2 = segmentWritableSegment$okio.limit - beginIndex;
                    int iMin = Math.min(endIndex, 8192 - i2);
                    int i3 = beginIndex + 1;
                    bArr[beginIndex + i2] = (byte) cCharAt2;
                    while (true) {
                        beginIndex = i3;
                        if (beginIndex >= iMin || (cCharAt = string.charAt(beginIndex)) >= 128) {
                            break;
                        }
                        i3 = beginIndex + 1;
                        bArr[beginIndex + i2] = (byte) cCharAt;
                    }
                    int i4 = segmentWritableSegment$okio.limit;
                    int i5 = (i2 + beginIndex) - i4;
                    segmentWritableSegment$okio.limit = i4 + i5;
                    setSize$okio(size() + ((long) i5));
                } else {
                    if (cCharAt2 < 2048) {
                        Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = segmentWritableSegment$okio2.data;
                        int i6 = segmentWritableSegment$okio2.limit;
                        bArr2[i6] = (byte) ((cCharAt2 >> 6) | 192);
                        bArr2[i6 + 1] = (byte) ((cCharAt2 & '?') | 128);
                        segmentWritableSegment$okio2.limit = i6 + 2;
                        setSize$okio(size() + 2);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i7 = beginIndex + 1;
                        char cCharAt3 = i7 < endIndex ? string.charAt(i7) : (char) 0;
                        if (cCharAt2 <= 56319 && 56320 <= cCharAt3 && 57343 >= cCharAt3) {
                            int i8 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = segmentWritableSegment$okio3.data;
                            int i9 = segmentWritableSegment$okio3.limit;
                            bArr3[i9] = (byte) ((i8 >> 18) | 240);
                            bArr3[i9 + 1] = (byte) (((i8 >> 12) & 63) | 128);
                            bArr3[i9 + 2] = (byte) (((i8 >> 6) & 63) | 128);
                            bArr3[i9 + 3] = (byte) ((i8 & 63) | 128);
                            segmentWritableSegment$okio3.limit = i9 + 4;
                            setSize$okio(size() + 4);
                            beginIndex += 2;
                        } else {
                            writeByte(63);
                            beginIndex = i7;
                        }
                    } else {
                        Segment segmentWritableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i10 = segmentWritableSegment$okio4.limit;
                        bArr4[i10] = (byte) ((cCharAt2 >> '\f') | 224);
                        bArr4[i10 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                        bArr4[i10 + 2] = (byte) ((cCharAt2 & '?') | 128);
                        segmentWritableSegment$okio4.limit = i10 + 3;
                        setSize$okio(size() + 3);
                    }
                    beginIndex++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(a.e("endIndex < beginIndex: ", endIndex, " < ", beginIndex).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] sink) throws EOFException {
        j.e(sink, "sink");
        int i2 = 0;
        while (i2 < sink.length) {
            int i3 = read(sink, i2, sink.length - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) {
        j.e(source, "source");
        int iRemaining = source.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i2, 8192 - segmentWritableSegment$okio.limit);
            source.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i2 -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink) {
        j.e(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long offset) {
        j.e(out, "out");
        return copyTo(out, offset, this.size - offset);
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink, int offset, int byteCount) {
        j.e(sink, "sink");
        Util.checkOffsetAndCount(sink.length, offset, byteCount);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteCount, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i2 = segment.pos;
        e.c(bArr, sink, offset, i2, i2 + iMin);
        segment.pos += iMin;
        setSize$okio(size() - ((long) iMin));
        if (segment.pos != segment.limit) {
            return iMin;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return iMin;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long offset, long byteCount) {
        j.e(out, "out");
        Util.checkOffsetAndCount(size(), offset, byteCount);
        if (byteCount != 0) {
            out.setSize$okio(out.size() + byteCount);
            Segment segment = this.head;
            while (true) {
                j.c(segment);
                int i2 = segment.limit;
                int i3 = segment.pos;
                if (offset < i2 - i3) {
                    break;
                }
                offset -= (long) (i2 - i3);
                segment = segment.next;
            }
            while (byteCount > 0) {
                j.c(segment);
                Segment segmentSharedCopy = segment.sharedCopy();
                int i4 = segmentSharedCopy.pos + ((int) offset);
                segmentSharedCopy.pos = i4;
                segmentSharedCopy.limit = Math.min(i4 + ((int) byteCount), segmentSharedCopy.limit);
                Segment segment2 = out.head;
                if (segment2 == null) {
                    segmentSharedCopy.prev = segmentSharedCopy;
                    segmentSharedCopy.next = segmentSharedCopy;
                    out.head = segmentSharedCopy;
                } else {
                    j.c(segment2);
                    Segment segment3 = segment2.prev;
                    j.c(segment3);
                    segment3.push(segmentSharedCopy);
                }
                byteCount -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
                segment = segment.next;
                offset = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        j.e(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString, int offset, int byteCount) {
        j.e(byteString, "byteString");
        byteString.write$okio(this, offset, byteCount);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source) {
        j.e(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source, int offset, int byteCount) {
        j.e(source, "source");
        long j2 = byteCount;
        Util.checkOffsetAndCount(source.length, offset, j2);
        int i2 = byteCount + offset;
        while (offset < i2) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i2 - offset, 8192 - segmentWritableSegment$okio.limit);
            int i3 = offset + iMin;
            e.c(source, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, offset, i3);
            segmentWritableSegment$okio.limit += iMin;
            offset = i3;
        }
        setSize$okio(size() + j2);
        return this;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) {
        j.e(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(a.f("byteCount < 0: ", byteCount).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (byteCount > size()) {
            byteCount = size();
        }
        sink.write(this, byteCount);
        return byteCount;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull Source source, long byteCount) throws EOFException {
        j.e(source, "source");
        while (byteCount > 0) {
            long j2 = source.read(this, byteCount);
            if (j2 == -1) {
                throw new EOFException();
            }
            byteCount -= j2;
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long fromIndex) {
        int i2;
        j.e(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long size = 0;
        if (fromIndex >= 0) {
            Segment segment = this.head;
            if (segment != null) {
                if (size() - fromIndex < fromIndex) {
                    size = size();
                    while (size > fromIndex) {
                        segment = segment.prev;
                        j.c(segment);
                        size -= (long) (segment.limit - segment.pos);
                    }
                    byte[] bArrInternalArray$okio = bytes.internalArray$okio();
                    byte b2 = bArrInternalArray$okio[0];
                    int size2 = bytes.size();
                    long size3 = (size() - ((long) size2)) + 1;
                    while (size < size3) {
                        byte[] bArr = segment.data;
                        int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size3) - size);
                        i2 = (int) ((((long) segment.pos) + fromIndex) - size);
                        while (i2 < iMin) {
                            if (bArr[i2] == b2 && BufferKt.rangeEquals(segment, i2 + 1, bArrInternalArray$okio, 1, size2)) {
                                return ((long) (i2 - segment.pos)) + size;
                            }
                            i2++;
                        }
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        j.c(segment);
                        fromIndex = size;
                    }
                } else {
                    while (true) {
                        long j2 = ((long) (segment.limit - segment.pos)) + size;
                        if (j2 > fromIndex) {
                            break;
                        }
                        segment = segment.next;
                        j.c(segment);
                        size = j2;
                    }
                    byte[] bArrInternalArray$okio2 = bytes.internalArray$okio();
                    byte b3 = bArrInternalArray$okio2[0];
                    int size4 = bytes.size();
                    long size5 = (size() - ((long) size4)) + 1;
                    while (size < size5) {
                        byte[] bArr2 = segment.data;
                        int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size5) - size);
                        i2 = (int) ((((long) segment.pos) + fromIndex) - size);
                        while (i2 < iMin2) {
                            if (bArr2[i2] == b3 && BufferKt.rangeEquals(segment, i2 + 1, bArrInternalArray$okio2, 1, size4)) {
                                return ((long) (i2 - segment.pos)) + size;
                            }
                            i2++;
                        }
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        j.c(segment);
                        fromIndex = size;
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(a.f("fromIndex < 0: ", fromIndex).toString());
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        Segment segment;
        j.e(source, "source");
        if (source != this) {
            Util.checkOffsetAndCount(source.size(), 0L, byteCount);
            while (byteCount > 0) {
                Segment segment2 = source.head;
                j.c(segment2);
                int i2 = segment2.limit;
                j.c(source.head);
                if (byteCount < i2 - r2.pos) {
                    Segment segment3 = this.head;
                    if (segment3 != null) {
                        j.c(segment3);
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + byteCount) - ((long) (segment.shared ? 0 : segment.pos)) <= 8192) {
                            Segment segment4 = source.head;
                            j.c(segment4);
                            segment4.writeTo(segment, (int) byteCount);
                            source.setSize$okio(source.size() - byteCount);
                            setSize$okio(size() + byteCount);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    j.c(segment5);
                    source.head = segment5.split((int) byteCount);
                }
                Segment segment6 = source.head;
                j.c(segment6);
                long j2 = segment6.limit - segment6.pos;
                source.head = segment6.pop();
                Segment segment7 = this.head;
                if (segment7 == null) {
                    this.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    j.c(segment7);
                    Segment segment8 = segment7.prev;
                    j.c(segment8);
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j2);
                setSize$okio(size() + j2);
                byteCount -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}
