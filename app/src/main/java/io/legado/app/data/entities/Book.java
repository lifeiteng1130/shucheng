package io.legado.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e.a.a.c.b;
import e.a.a.c.d;
import e.a.a.f.s.k;
import e.a.a.h.n;
import e.a.a.h.v;
import f.c0.c.f;
import f.c0.c.j;
import f.e;
import f.h;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BaseBook;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.helper.DataUtil;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: Book.kt */
/* JADX INFO: loaded from: classes3.dex */
@TypeConverters({Converters.class})
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b3\b\u0087\b\u0018\u0000 Ý\u00012\u00020\u00012\u00020\u0002:\u0006Ý\u0001Þ\u0001ß\u0001BÍ\u0002\u0012\b\b\u0002\u0010b\u001a\u00020\u0013\u0012\b\b\u0002\u0010c\u001a\u00020\u0013\u0012\b\b\u0002\u0010d\u001a\u00020\u0013\u0012\b\b\u0002\u0010e\u001a\u00020\u0013\u0012\b\b\u0002\u0010f\u001a\u00020\u0013\u0012\b\b\u0002\u0010g\u001a\u00020\u0013\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010o\u001a\u00020\u0010\u0012\b\b\u0002\u0010p\u001a\u000204\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010r\u001a\u000204\u0012\b\b\u0002\u0010s\u001a\u000204\u0012\b\b\u0002\u0010t\u001a\u00020\u0010\u0012\b\b\u0002\u0010u\u001a\u00020\u0010\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010w\u001a\u00020\u0010\u0012\b\b\u0002\u0010x\u001a\u00020\u0010\u0012\b\b\u0002\u0010y\u001a\u000204\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010{\u001a\u00020\u0006\u0012\b\b\u0002\u0010|\u001a\u00020\u0010\u0012\b\b\u0002\u0010}\u001a\u00020\u0010\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\bJ\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u0012J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001e\u0010\u001aJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\bJ\u0015\u0010'\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b'\u0010$J\r\u0010(\u001a\u00020\u0006¢\u0006\u0004\b(\u0010\bJ\r\u0010)\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\bJ\u0015\u0010+\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010$J\r\u0010,\u001a\u00020\u0010¢\u0006\u0004\b,\u0010\u0012J\u0015\u0010.\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0010¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b0\u0010\u001aJ\u0017\u00102\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b2\u00103J\u0015\u00106\u001a\u00020\u00162\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\u00062\u0006\u00105\u001a\u000204¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0013¢\u0006\u0004\b:\u0010\u001aJ\r\u0010<\u001a\u00020;¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0000¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00162\b\u0010A\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\bB\u0010@J\u0010\u0010C\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\bC\u0010\u001aJ\u0010\u0010D\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\bD\u0010\u001aJ\u0010\u0010E\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\bE\u0010\u001aJ\u0010\u0010F\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\bF\u0010\u001aJ\u0010\u0010G\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\bG\u0010\u001aJ\u0010\u0010H\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\bH\u0010\u001aJ\u0012\u0010I\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bI\u0010\u001aJ\u0012\u0010J\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bJ\u0010\u001aJ\u0012\u0010K\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bK\u0010\u001aJ\u0012\u0010L\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bL\u0010\u001aJ\u0012\u0010M\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bM\u0010\u001aJ\u0012\u0010N\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bN\u0010\u001aJ\u0012\u0010O\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bO\u0010\u001aJ\u0010\u0010P\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\bP\u0010\u0012J\u0010\u0010Q\u001a\u000204HÆ\u0003¢\u0006\u0004\bQ\u0010RJ\u0012\u0010S\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bS\u0010\u001aJ\u0010\u0010T\u001a\u000204HÆ\u0003¢\u0006\u0004\bT\u0010RJ\u0010\u0010U\u001a\u000204HÆ\u0003¢\u0006\u0004\bU\u0010RJ\u0010\u0010V\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\bV\u0010\u0012J\u0010\u0010W\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\bW\u0010\u0012J\u0012\u0010X\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bX\u0010\u001aJ\u0010\u0010Y\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\bY\u0010\u0012J\u0010\u0010Z\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\bZ\u0010\u0012J\u0010\u0010[\u001a\u000204HÆ\u0003¢\u0006\u0004\b[\u0010RJ\u0012\u0010\\\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\\\u0010\u001aJ\u0010\u0010]\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b]\u0010\bJ\u0010\u0010^\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b^\u0010\u0012J\u0010\u0010_\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b_\u0010\u0012J\u0012\u0010`\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b`\u0010\u001aJ\u0012\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\ba\u0010\u0005J×\u0002\u0010\u0080\u0001\u001a\u00020\u00002\b\b\u0002\u0010b\u001a\u00020\u00132\b\b\u0002\u0010c\u001a\u00020\u00132\b\b\u0002\u0010d\u001a\u00020\u00132\b\b\u0002\u0010e\u001a\u00020\u00132\b\b\u0002\u0010f\u001a\u00020\u00132\b\b\u0002\u0010g\u001a\u00020\u00132\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010o\u001a\u00020\u00102\b\b\u0002\u0010p\u001a\u0002042\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010r\u001a\u0002042\b\b\u0002\u0010s\u001a\u0002042\b\b\u0002\u0010t\u001a\u00020\u00102\b\b\u0002\u0010u\u001a\u00020\u00102\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010w\u001a\u00020\u00102\b\b\u0002\u0010x\u001a\u00020\u00102\b\b\u0002\u0010y\u001a\u0002042\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010{\u001a\u00020\u00062\b\b\u0002\u0010|\u001a\u00020\u00102\b\b\u0002\u0010}\u001a\u00020\u00102\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0012\u0010\u0082\u0001\u001a\u00020\u0013HÖ\u0001¢\u0006\u0005\b\u0082\u0001\u0010\u001aJ\u0012\u0010\u0083\u0001\u001a\u00020\u0010HÖ\u0001¢\u0006\u0005\b\u0083\u0001\u0010\u0012J&\u0010\u0087\u0001\u001a\u00020\u00162\b\u0010\u0085\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u0010HÖ\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001R%\u0010e\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\be\u0010\u0089\u0001\u001a\u0005\b\u008a\u0001\u0010\u001a\"\u0005\b\u008b\u0001\u00103R%\u0010p\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bp\u0010\u008c\u0001\u001a\u0005\b\u008d\u0001\u0010R\"\u0005\b\u008e\u0001\u00107R%\u0010c\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bc\u0010\u0089\u0001\u001a\u0005\b\u008f\u0001\u0010\u001a\"\u0005\b\u0090\u0001\u00103R%\u0010g\u001a\u00020\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bg\u0010\u0089\u0001\u001a\u0005\b\u0091\u0001\u0010\u001a\"\u0005\b\u0092\u0001\u00103R%\u0010f\u001a\u00020\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bf\u0010\u0089\u0001\u001a\u0005\b\u0093\u0001\u0010\u001a\"\u0005\b\u0094\u0001\u00103R%\u0010o\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bo\u0010\u0095\u0001\u001a\u0005\b\u0096\u0001\u0010\u0012\"\u0005\b\u0097\u0001\u0010/R%\u0010}\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b}\u0010\u0095\u0001\u001a\u0005\b\u0098\u0001\u0010\u0012\"\u0005\b\u0099\u0001\u0010/R%\u0010b\u001a\u00020\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bb\u0010\u0089\u0001\u001a\u0005\b\u009a\u0001\u0010\u001a\"\u0005\b\u009b\u0001\u00103R%\u0010w\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bw\u0010\u0095\u0001\u001a\u0005\b\u009c\u0001\u0010\u0012\"\u0005\b\u009d\u0001\u0010/R%\u0010r\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\br\u0010\u008c\u0001\u001a\u0005\b\u009e\u0001\u0010R\"\u0005\b\u009f\u0001\u00107R'\u0010l\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bl\u0010\u0089\u0001\u001a\u0005\b \u0001\u0010\u001a\"\u0005\b¡\u0001\u00103R%\u0010s\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bs\u0010\u008c\u0001\u001a\u0005\b¢\u0001\u0010R\"\u0005\b£\u0001\u00107R'\u0010z\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bz\u0010\u0089\u0001\u001a\u0005\b¤\u0001\u0010\u001a\"\u0005\b¥\u0001\u00103R%\u0010{\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b{\u0010¦\u0001\u001a\u0005\b§\u0001\u0010\b\"\u0005\b¨\u0001\u0010$R'\u0010j\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bj\u0010\u0089\u0001\u001a\u0005\b©\u0001\u0010\u001a\"\u0005\bª\u0001\u00103R%\u0010d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bd\u0010\u0089\u0001\u001a\u0005\b«\u0001\u0010\u001a\"\u0005\b¬\u0001\u00103R7\u0010´\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00ad\u00018V@\u0017X\u0097\u0084\u0002¢\u0006\u0018\n\u0006\b®\u0001\u0010¯\u0001\u0012\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b°\u0001\u0010±\u0001R%\u0010t\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bt\u0010\u0095\u0001\u001a\u0005\bµ\u0001\u0010\u0012\"\u0005\b¶\u0001\u0010/R'\u0010m\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bm\u0010\u0089\u0001\u001a\u0005\b·\u0001\u0010\u001a\"\u0005\b¸\u0001\u00103R'\u0010n\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bn\u0010\u0089\u0001\u001a\u0005\b¹\u0001\u0010\u001a\"\u0005\bº\u0001\u00103R'\u0010i\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bi\u0010\u0089\u0001\u001a\u0005\b»\u0001\u0010\u001a\"\u0005\b¼\u0001\u00103R'\u0010k\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bk\u0010\u0089\u0001\u001a\u0005\b½\u0001\u0010\u001a\"\u0005\b¾\u0001\u00103R%\u0010y\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\by\u0010\u008c\u0001\u001a\u0005\b¿\u0001\u0010R\"\u0005\bÀ\u0001\u00107R(\u0010\u007f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u007f\u0010Á\u0001\u001a\u0005\bÂ\u0001\u0010\u0005\"\u0006\bÃ\u0001\u0010Ä\u0001R1\u0010Å\u0001\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u001e\n\u0006\bÅ\u0001\u0010\u0089\u0001\u0012\u0006\bÈ\u0001\u0010³\u0001\u001a\u0005\bÆ\u0001\u0010\u001a\"\u0005\bÇ\u0001\u00103R%\u0010x\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bx\u0010\u0095\u0001\u001a\u0005\bÉ\u0001\u0010\u0012\"\u0005\bÊ\u0001\u0010/R'\u0010~\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b~\u0010\u0089\u0001\u001a\u0005\bË\u0001\u0010\u001a\"\u0005\bÌ\u0001\u00103R%\u0010|\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b|\u0010\u0095\u0001\u001a\u0005\bÍ\u0001\u0010\u0012\"\u0005\bÎ\u0001\u0010/R'\u0010q\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bq\u0010\u0089\u0001\u001a\u0005\bÏ\u0001\u0010\u001a\"\u0005\bÐ\u0001\u00103R%\u0010u\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bu\u0010\u0095\u0001\u001a\u0005\bÑ\u0001\u0010\u0012\"\u0005\bÒ\u0001\u0010/R1\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u001e\n\u0006\bÓ\u0001\u0010\u0089\u0001\u0012\u0006\bÖ\u0001\u0010³\u0001\u001a\u0005\bÔ\u0001\u0010\u001a\"\u0005\bÕ\u0001\u00103R'\u0010h\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bh\u0010\u0089\u0001\u001a\u0005\b×\u0001\u0010\u001a\"\u0005\bØ\u0001\u00103R'\u0010v\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bv\u0010\u0089\u0001\u001a\u0005\bÙ\u0001\u0010\u001a\"\u0005\bÚ\u0001\u00103¨\u0006à\u0001"}, d2 = {"Lio/legado/app/data/entities/Book;", "Landroid/os/Parcelable;", "Lio/legado/app/data/entities/BaseBook;", "Lio/legado/app/data/entities/Book$ReadConfig;", "config", "()Lio/legado/app/data/entities/Book$ReadConfig;", "", "isLocalBook", "()Z", "isLocalTxt", "isEpub", "isOnLineTxt", "", "other", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "key", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "putVariable", "(Ljava/lang/String;Ljava/lang/String;)V", "getRealAuthor", "()Ljava/lang/String;", "getUnreadChapterNum", "getDisplayTag", "getDisplayCover", "getDisplayIntro", "Ljava/nio/charset/Charset;", "fileCharset", "()Ljava/nio/charset/Charset;", "reverseToc", "setReverseToc", "(Z)V", "getReverseToc", "useReplaceRule", "setUseReplaceRule", "getUseReplaceRule", "getReSegment", "reSegment", "setReSegment", "getPageAnim", "pageAnim", "setPageAnim", "(I)V", "getImageStyle", "imageStyle", "setImageStyle", "(Ljava/lang/String;)V", "", "tag", "setDelTag", "(J)V", "getDelTag", "(J)Z", "getFolderName", "Lio/legado/app/data/entities/SearchBook;", "toSearchBook", "()Lio/legado/app/data/entities/SearchBook;", "newBook", "changeTo", "(Lio/legado/app/data/entities/Book;)V", "oldBook", "upInfoFromOld", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "()J", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "bookUrl", "tocUrl", "origin", "originName", "name", "author", "kind", "customTag", "coverUrl", "customCoverUrl", "intro", "customIntro", "charset", "type", "group", "latestChapterTitle", "latestChapterTime", "lastCheckTime", "lastCheckCount", "totalChapterNum", "durChapterTitle", "durChapterIndex", "durChapterPos", "durChapterTime", "wordCount", "canUpdate", "order", "originOrder", "variable", "readConfig", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;JJIILjava/lang/String;IIJLjava/lang/String;ZIILjava/lang/String;Lio/legado/app/data/entities/Book$ReadConfig;)Lio/legado/app/data/entities/Book;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getOriginName", "setOriginName", "J", "getGroup", "setGroup", "getTocUrl", "setTocUrl", "getAuthor", "setAuthor", "getName", "setName", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getType", "setType", "getOriginOrder", "setOriginOrder", "getBookUrl", "setBookUrl", "getDurChapterIndex", "setDurChapterIndex", "getLatestChapterTime", "setLatestChapterTime", "getIntro", "setIntro", "getLastCheckTime", "setLastCheckTime", "getWordCount", "setWordCount", "Z", "getCanUpdate", "setCanUpdate", "getCoverUrl", "setCoverUrl", "getOrigin", "setOrigin", "Ljava/util/HashMap;", "variableMap$delegate", "Lf/e;", "getVariableMap", "()Ljava/util/HashMap;", "getVariableMap$annotations", "()V", "variableMap", "getLastCheckCount", "setLastCheckCount", "getCustomIntro", "setCustomIntro", "getCharset", "setCharset", "getCustomTag", "setCustomTag", "getCustomCoverUrl", "setCustomCoverUrl", "getDurChapterTime", "setDurChapterTime", "Lio/legado/app/data/entities/Book$ReadConfig;", "getReadConfig", "setReadConfig", "(Lio/legado/app/data/entities/Book$ReadConfig;)V", "infoHtml", "getInfoHtml", "setInfoHtml", "getInfoHtml$annotations", "getDurChapterPos", "setDurChapterPos", "getVariable", "setVariable", "getOrder", "setOrder", "getLatestChapterTitle", "setLatestChapterTitle", "getTotalChapterNum", "setTotalChapterNum", "tocHtml", "getTocHtml", "setTocHtml", "getTocHtml$annotations", "getKind", "setKind", "getDurChapterTitle", "setDurChapterTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;JJIILjava/lang/String;IIJLjava/lang/String;ZIILjava/lang/String;Lio/legado/app/data/entities/Book$ReadConfig;)V", "Companion", "Converters", "ReadConfig", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
@Entity(indices = {@Index(unique = true, value = {"name", "author"})}, tableName = "books")
public final /* data */ class Book implements Parcelable, BaseBook {
    public static final long hTag = 2;

    @NotNull
    public static final String imgStyleDefault = "DEFAULT";

    @NotNull
    public static final String imgStyleFull = "FULL";

    @NotNull
    public static final String imgStyleText = "TEXT";
    public static final long imgTag = 8;
    public static final long rubyTag = 4;

    @NotNull
    private String author;

    @PrimaryKey
    @NotNull
    private String bookUrl;
    private boolean canUpdate;

    @Nullable
    private String charset;

    @Nullable
    private String coverUrl;

    @Nullable
    private String customCoverUrl;

    @Nullable
    private String customIntro;

    @Nullable
    private String customTag;
    private int durChapterIndex;
    private int durChapterPos;
    private long durChapterTime;

    @Nullable
    private String durChapterTitle;
    private long group;

    @Ignore
    @Nullable
    private String infoHtml;

    @Nullable
    private String intro;

    @Nullable
    private String kind;
    private int lastCheckCount;
    private long lastCheckTime;
    private long latestChapterTime;

    @Nullable
    private String latestChapterTitle;

    @NotNull
    private String name;
    private int order;

    @NotNull
    private String origin;

    @NotNull
    private String originName;
    private int originOrder;

    @Nullable
    private ReadConfig readConfig;

    @Ignore
    @Nullable
    private String tocHtml;

    @NotNull
    private String tocUrl;
    private int totalChapterNum;
    private int type;

    @Nullable
    private String variable;

    /* JADX INFO: renamed from: variableMap$delegate, reason: from kotlin metadata */
    @Ignore
    @NotNull
    private final transient e variableMap;

    @Nullable
    private String wordCount;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<Book> CREATOR = new Creator();

    /* JADX INFO: compiled from: Book.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0016\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\t¨\u0006\u0013"}, d2 = {"Lio/legado/app/data/entities/Book$Companion;", "", "Lio/legado/app/data/entities/Book;", "book", "Lf/v;", "delete", "(Lio/legado/app/data/entities/Book;)V", "", "hTag", "J", "", "imgStyleDefault", "Ljava/lang/String;", "imgStyleFull", "imgStyleText", "imgTag", "rubyTag", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void delete(@Nullable Book book) {
            if (book == null) {
                return;
            }
            k kVar = k.a;
            Book book2 = k.f5677c;
            if (j.a(book2 == null ? null : book2.getBookUrl(), book.getBookUrl())) {
                k.f5677c = null;
            }
            AppDatabaseKt.getAppDb().getBookDao().delete(book);
        }
    }

    /* JADX INFO: compiled from: Book.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lio/legado/app/data/entities/Book$Converters;", "", "Lio/legado/app/data/entities/Book$ReadConfig;", "config", "", "readConfigToString", "(Lio/legado/app/data/entities/Book$ReadConfig;)Ljava/lang/String;", "json", "stringToReadConfig", "(Ljava/lang/String;)Lio/legado/app/data/entities/Book$ReadConfig;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Converters {
        @TypeConverter
        @NotNull
        public final String readConfigToString(@Nullable ReadConfig config) {
            String json = n.a().toJson(config);
            j.d(json, "GSON.toJson(config)");
            return json;
        }

        @TypeConverter
        @Nullable
        public final ReadConfig stringToReadConfig(@Nullable String json) {
            Object objM11constructorimpl;
            Gson gsonA = n.a();
            try {
                Type type = new TypeToken<ReadConfig>() { // from class: io.legado.app.data.entities.Book$Converters$stringToReadConfig$$inlined$fromJsonObject$1
                }.getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(json, type);
                if (!(objFromJson instanceof ReadConfig)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((ReadConfig) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            return (ReadConfig) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        }
    }

    /* JADX INFO: compiled from: Book.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<Book> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Book createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new Book(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : ReadConfig.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Book[] newArray(int i2) {
            return new Book[i2];
        }
    }

    public Book() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0L, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073741823, null);
    }

    public Book(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, int i2, long j2, @Nullable String str14, long j3, long j4, int i3, int i4, @Nullable String str15, int i5, int i6, long j5, @Nullable String str16, boolean z, int i7, int i8, @Nullable String str17, @Nullable ReadConfig readConfig) {
        j.e(str, "bookUrl");
        j.e(str2, "tocUrl");
        j.e(str3, "origin");
        j.e(str4, "originName");
        j.e(str5, "name");
        j.e(str6, "author");
        this.bookUrl = str;
        this.tocUrl = str2;
        this.origin = str3;
        this.originName = str4;
        this.name = str5;
        this.author = str6;
        this.kind = str7;
        this.customTag = str8;
        this.coverUrl = str9;
        this.customCoverUrl = str10;
        this.intro = str11;
        this.customIntro = str12;
        this.charset = str13;
        this.type = i2;
        this.group = j2;
        this.latestChapterTitle = str14;
        this.latestChapterTime = j3;
        this.lastCheckTime = j4;
        this.lastCheckCount = i3;
        this.totalChapterNum = i4;
        this.durChapterTitle = str15;
        this.durChapterIndex = i5;
        this.durChapterPos = i6;
        this.durChapterTime = j5;
        this.wordCount = str16;
        this.canUpdate = z;
        this.order = i7;
        this.originOrder = i8;
        this.variable = str17;
        this.readConfig = readConfig;
        this.variableMap = c.b.a.m.f.N3(new Book$variableMap$2(this));
    }

    private final ReadConfig config() {
        if (this.readConfig == null) {
            this.readConfig = new ReadConfig(false, 0, false, null, false, 0L, 63, null);
        }
        ReadConfig readConfig = this.readConfig;
        j.c(readConfig);
        return readConfig;
    }

    public static /* synthetic */ Book copy$default(Book book, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2, long j2, String str14, long j3, long j4, int i3, int i4, String str15, int i5, int i6, long j5, String str16, boolean z, int i7, int i8, String str17, ReadConfig readConfig, int i9, Object obj) {
        String bookUrl = (i9 & 1) != 0 ? book.getBookUrl() : str;
        String str18 = (i9 & 2) != 0 ? book.tocUrl : str2;
        String str19 = (i9 & 4) != 0 ? book.origin : str3;
        String str20 = (i9 & 8) != 0 ? book.originName : str4;
        String name = (i9 & 16) != 0 ? book.getName() : str5;
        String author = (i9 & 32) != 0 ? book.getAuthor() : str6;
        String kind = (i9 & 64) != 0 ? book.getKind() : str7;
        String str21 = (i9 & 128) != 0 ? book.customTag : str8;
        String str22 = (i9 & 256) != 0 ? book.coverUrl : str9;
        String str23 = (i9 & 512) != 0 ? book.customCoverUrl : str10;
        String str24 = (i9 & 1024) != 0 ? book.intro : str11;
        String str25 = (i9 & 2048) != 0 ? book.customIntro : str12;
        String str26 = (i9 & 4096) != 0 ? book.charset : str13;
        int i10 = (i9 & 8192) != 0 ? book.type : i2;
        String str27 = str26;
        long j6 = (i9 & 16384) != 0 ? book.group : j2;
        String str28 = (i9 & 32768) != 0 ? book.latestChapterTitle : str14;
        long j7 = (65536 & i9) != 0 ? book.latestChapterTime : j3;
        long j8 = (i9 & 131072) != 0 ? book.lastCheckTime : j4;
        int i11 = (i9 & 262144) != 0 ? book.lastCheckCount : i3;
        return book.copy(bookUrl, str18, str19, str20, name, author, kind, str21, str22, str23, str24, str25, str27, i10, j6, str28, j7, j8, i11, (524288 & i9) != 0 ? book.totalChapterNum : i4, (i9 & 1048576) != 0 ? book.durChapterTitle : str15, (i9 & 2097152) != 0 ? book.durChapterIndex : i5, (i9 & 4194304) != 0 ? book.durChapterPos : i6, (i9 & 8388608) != 0 ? book.durChapterTime : j5, (i9 & 16777216) != 0 ? book.getWordCount() : str16, (i9 & 33554432) != 0 ? book.canUpdate : z, (67108864 & i9) != 0 ? book.order : i7, (i9 & 134217728) != 0 ? book.originOrder : i8, (i9 & 268435456) != 0 ? book.variable : str17, (i9 & 536870912) != 0 ? book.readConfig : readConfig);
    }

    public static /* synthetic */ void getInfoHtml$annotations() {
    }

    public static /* synthetic */ void getTocHtml$annotations() {
    }

    public static /* synthetic */ void getVariableMap$annotations() {
    }

    public final void changeTo(@NotNull Book newBook) {
        j.e(newBook, "newBook");
        newBook.group = this.group;
        newBook.order = this.order;
        newBook.customCoverUrl = this.customCoverUrl;
        newBook.customIntro = this.customIntro;
        newBook.customTag = this.customTag;
        newBook.canUpdate = this.canUpdate;
        newBook.readConfig = this.readConfig;
        INSTANCE.delete(this);
        AppDatabaseKt.getAppDb().getBookDao().insert(newBook);
    }

    @NotNull
    public final String component1() {
        return getBookUrl();
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCustomCoverUrl() {
        return this.customCoverUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getIntro() {
        return this.intro;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCustomIntro() {
        return this.customIntro;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCharset() {
        return this.charset;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getGroup() {
        return this.group;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getLatestChapterTitle() {
        return this.latestChapterTitle;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final long getLatestChapterTime() {
        return this.latestChapterTime;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final long getLastCheckTime() {
        return this.lastCheckTime;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getLastCheckCount() {
        return this.lastCheckCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTocUrl() {
        return this.tocUrl;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getTotalChapterNum() {
        return this.totalChapterNum;
    }

    @Nullable
    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getDurChapterTitle() {
        return this.durChapterTitle;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getDurChapterIndex() {
        return this.durChapterIndex;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getDurChapterPos() {
        return this.durChapterPos;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final long getDurChapterTime() {
        return this.durChapterTime;
    }

    @Nullable
    public final String component25() {
        return getWordCount();
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getCanUpdate() {
        return this.canUpdate;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final int getOriginOrder() {
        return this.originOrder;
    }

    @Nullable
    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getVariable() {
        return this.variable;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    @Nullable
    /* JADX INFO: renamed from: component30, reason: from getter */
    public final ReadConfig getReadConfig() {
        return this.readConfig;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOriginName() {
        return this.originName;
    }

    @NotNull
    public final String component5() {
        return getName();
    }

    @NotNull
    public final String component6() {
        return getAuthor();
    }

    @Nullable
    public final String component7() {
        return getKind();
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCustomTag() {
        return this.customTag;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final Book copy(@NotNull String bookUrl, @NotNull String tocUrl, @NotNull String origin, @NotNull String originName, @NotNull String name, @NotNull String author, @Nullable String kind, @Nullable String customTag, @Nullable String coverUrl, @Nullable String customCoverUrl, @Nullable String intro, @Nullable String customIntro, @Nullable String charset, int type, long group, @Nullable String latestChapterTitle, long latestChapterTime, long lastCheckTime, int lastCheckCount, int totalChapterNum, @Nullable String durChapterTitle, int durChapterIndex, int durChapterPos, long durChapterTime, @Nullable String wordCount, boolean canUpdate, int order, int originOrder, @Nullable String variable, @Nullable ReadConfig readConfig) {
        j.e(bookUrl, "bookUrl");
        j.e(tocUrl, "tocUrl");
        j.e(origin, "origin");
        j.e(originName, "originName");
        j.e(name, "name");
        j.e(author, "author");
        return new Book(bookUrl, tocUrl, origin, originName, name, author, kind, customTag, coverUrl, customCoverUrl, intro, customIntro, charset, type, group, latestChapterTitle, latestChapterTime, lastCheckTime, lastCheckCount, totalChapterNum, durChapterTitle, durChapterIndex, durChapterPos, durChapterTime, wordCount, canUpdate, order, originOrder, variable, readConfig);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof Book) {
            return j.a(((Book) other).getBookUrl(), getBookUrl());
        }
        return false;
    }

    @NotNull
    public final Charset fileCharset() {
        String str = this.charset;
        if (str == null) {
            str = DataUtil.defaultCharset;
        }
        Charset charsetForName = Charset.forName(str);
        j.d(charsetForName, "Charset.forName(charsetName)");
        return charsetForName;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @NotNull
    public String getAuthor() {
        return this.author;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @NotNull
    public String getBookUrl() {
        return this.bookUrl;
    }

    public final boolean getCanUpdate() {
        return this.canUpdate;
    }

    @Nullable
    public final String getCharset() {
        return this.charset;
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final String getCustomCoverUrl() {
        return this.customCoverUrl;
    }

    @Nullable
    public final String getCustomIntro() {
        return this.customIntro;
    }

    @Nullable
    public final String getCustomTag() {
        return this.customTag;
    }

    public final boolean getDelTag(long tag) {
        return (config().getDelTag() & tag) == tag;
    }

    @Nullable
    public final String getDisplayCover() {
        String str = this.customCoverUrl;
        return str == null || str.length() == 0 ? this.coverUrl : this.customCoverUrl;
    }

    @Nullable
    public final String getDisplayIntro() {
        String str = this.customIntro;
        return str == null || str.length() == 0 ? this.intro : this.customIntro;
    }

    @Nullable
    public final String getDisplayTag() {
        String str = this.customTag;
        return str == null || f.h0.k.s(str) ? getKind() : this.customTag;
    }

    public final int getDurChapterIndex() {
        return this.durChapterIndex;
    }

    public final int getDurChapterPos() {
        return this.durChapterPos;
    }

    public final long getDurChapterTime() {
        return this.durChapterTime;
    }

    @Nullable
    public final String getDurChapterTitle() {
        return this.durChapterTitle;
    }

    @NotNull
    public final String getFolderName() {
        String name = getName();
        d dVar = d.a;
        String strReplace = d.f5513g.replace(name, "");
        String strSubstring = strReplace.substring(0, Math.min(9, strReplace.length()));
        j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return j.k(strSubstring, v.b(getBookUrl()));
    }

    public final long getGroup() {
        return this.group;
    }

    @Nullable
    public final String getImageStyle() {
        return config().getImageStyle();
    }

    @Override // io.legado.app.data.entities.BaseBook
    @Nullable
    public String getInfoHtml() {
        return this.infoHtml;
    }

    @Nullable
    public final String getIntro() {
        return this.intro;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @Nullable
    public String getKind() {
        return this.kind;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @NotNull
    public List<String> getKindList() {
        return BaseBook.DefaultImpls.getKindList(this);
    }

    public final int getLastCheckCount() {
        return this.lastCheckCount;
    }

    public final long getLastCheckTime() {
        return this.lastCheckTime;
    }

    public final long getLatestChapterTime() {
        return this.latestChapterTime;
    }

    @Nullable
    public final String getLatestChapterTitle() {
        return this.latestChapterTitle;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @NotNull
    public String getName() {
        return this.name;
    }

    public final int getOrder() {
        return this.order;
    }

    @NotNull
    public final String getOrigin() {
        return this.origin;
    }

    @NotNull
    public final String getOriginName() {
        return this.originName;
    }

    public final int getOriginOrder() {
        return this.originOrder;
    }

    public final int getPageAnim() {
        return config().getPageAnim();
    }

    public final boolean getReSegment() {
        return config().getReSegment();
    }

    @Nullable
    public final ReadConfig getReadConfig() {
        return this.readConfig;
    }

    @NotNull
    public final String getRealAuthor() {
        String author = getAuthor();
        d dVar = d.a;
        return d.f5512f.replace(author, "");
    }

    public final boolean getReverseToc() {
        return config().getReverseToc();
    }

    @Override // io.legado.app.data.entities.BaseBook
    @Nullable
    public String getTocHtml() {
        return this.tocHtml;
    }

    @NotNull
    public final String getTocUrl() {
        return this.tocUrl;
    }

    public final int getTotalChapterNum() {
        return this.totalChapterNum;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUnreadChapterNum() {
        return Math.max((this.totalChapterNum - this.durChapterIndex) - 1, 0);
    }

    public final boolean getUseReplaceRule() {
        return config().getUseReplaceRule();
    }

    @Nullable
    public final String getVariable() {
        return this.variable;
    }

    @Override // io.legado.app.model.analyzeRule.RuleDataInterface
    @NotNull
    public HashMap<String, String> getVariableMap() {
        return (HashMap) this.variableMap.getValue();
    }

    @Override // io.legado.app.data.entities.BaseBook
    @Nullable
    public String getWordCount() {
        return this.wordCount;
    }

    public int hashCode() {
        return getBookUrl().hashCode();
    }

    public final boolean isEpub() {
        return f.h0.k.f(this.originName, ".epub", true);
    }

    public final boolean isLocalBook() {
        return j.a(this.origin, "loc_book");
    }

    public final boolean isLocalTxt() {
        return isLocalBook() && f.h0.k.f(this.originName, ".txt", true);
    }

    public final boolean isOnLineTxt() {
        return !isLocalBook() && this.type == 0;
    }

    @Override // io.legado.app.model.analyzeRule.RuleDataInterface
    public void putVariable(@NotNull String key, @NotNull String value) {
        j.e(key, "key");
        j.e(value, ES6Iterator.VALUE_PROPERTY);
        getVariableMap().put(key, value);
        this.variable = n.a().toJson(getVariableMap());
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setAuthor(@NotNull String str) {
        j.e(str, "<set-?>");
        this.author = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setBookUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookUrl = str;
    }

    public final void setCanUpdate(boolean z) {
        this.canUpdate = z;
    }

    public final void setCharset(@Nullable String str) {
        this.charset = str;
    }

    public final void setCoverUrl(@Nullable String str) {
        this.coverUrl = str;
    }

    public final void setCustomCoverUrl(@Nullable String str) {
        this.customCoverUrl = str;
    }

    public final void setCustomIntro(@Nullable String str) {
        this.customIntro = str;
    }

    public final void setCustomTag(@Nullable String str) {
        this.customTag = str;
    }

    public final void setDelTag(long tag) {
        ReadConfig readConfigConfig = config();
        long delTag = config().getDelTag() & tag;
        long delTag2 = config().getDelTag();
        readConfigConfig.setDelTag(delTag == tag ? (~tag) & delTag2 : tag | delTag2);
    }

    public final void setDurChapterIndex(int i2) {
        this.durChapterIndex = i2;
    }

    public final void setDurChapterPos(int i2) {
        this.durChapterPos = i2;
    }

    public final void setDurChapterTime(long j2) {
        this.durChapterTime = j2;
    }

    public final void setDurChapterTitle(@Nullable String str) {
        this.durChapterTitle = str;
    }

    public final void setGroup(long j2) {
        this.group = j2;
    }

    public final void setImageStyle(@Nullable String imageStyle) {
        config().setImageStyle(imageStyle);
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setInfoHtml(@Nullable String str) {
        this.infoHtml = str;
    }

    public final void setIntro(@Nullable String str) {
        this.intro = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setKind(@Nullable String str) {
        this.kind = str;
    }

    public final void setLastCheckCount(int i2) {
        this.lastCheckCount = i2;
    }

    public final void setLastCheckTime(long j2) {
        this.lastCheckTime = j2;
    }

    public final void setLatestChapterTime(long j2) {
        this.latestChapterTime = j2;
    }

    public final void setLatestChapterTitle(@Nullable String str) {
        this.latestChapterTitle = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.name = str;
    }

    public final void setOrder(int i2) {
        this.order = i2;
    }

    public final void setOrigin(@NotNull String str) {
        j.e(str, "<set-?>");
        this.origin = str;
    }

    public final void setOriginName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.originName = str;
    }

    public final void setOriginOrder(int i2) {
        this.originOrder = i2;
    }

    public final void setPageAnim(int pageAnim) {
        config().setPageAnim(pageAnim);
    }

    public final void setReSegment(boolean reSegment) {
        config().setReSegment(reSegment);
    }

    public final void setReadConfig(@Nullable ReadConfig readConfig) {
        this.readConfig = readConfig;
    }

    public final void setReverseToc(boolean reverseToc) {
        config().setReverseToc(reverseToc);
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setTocHtml(@Nullable String str) {
        this.tocHtml = str;
    }

    public final void setTocUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.tocUrl = str;
    }

    public final void setTotalChapterNum(int i2) {
        this.totalChapterNum = i2;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public final void setUseReplaceRule(boolean useReplaceRule) {
        config().setUseReplaceRule(useReplaceRule);
    }

    public final void setVariable(@Nullable String str) {
        this.variable = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setWordCount(@Nullable String str) {
        this.wordCount = str;
    }

    @NotNull
    public final SearchBook toSearchBook() {
        String name = getName();
        String author = getAuthor();
        String kind = getKind();
        String bookUrl = getBookUrl();
        String str = this.origin;
        String str2 = this.originName;
        int i2 = this.type;
        String wordCount = getWordCount();
        String str3 = this.latestChapterTitle;
        long j2 = 0;
        SearchBook searchBook = new SearchBook(bookUrl, str, str2, i2, name, author, kind, this.coverUrl, this.intro, wordCount, str3, this.tocUrl, j2, this.variable, this.originOrder, 4096, null);
        searchBook.setInfoHtml(getInfoHtml());
        searchBook.setTocHtml(getTocHtml());
        return searchBook;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("Book(bookUrl=");
        sbR.append(getBookUrl());
        sbR.append(", tocUrl=");
        sbR.append(this.tocUrl);
        sbR.append(", origin=");
        sbR.append(this.origin);
        sbR.append(", originName=");
        sbR.append(this.originName);
        sbR.append(", name=");
        sbR.append(getName());
        sbR.append(", author=");
        sbR.append(getAuthor());
        sbR.append(", kind=");
        sbR.append((Object) getKind());
        sbR.append(", customTag=");
        sbR.append((Object) this.customTag);
        sbR.append(", coverUrl=");
        sbR.append((Object) this.coverUrl);
        sbR.append(", customCoverUrl=");
        sbR.append((Object) this.customCoverUrl);
        sbR.append(", intro=");
        sbR.append((Object) this.intro);
        sbR.append(", customIntro=");
        sbR.append((Object) this.customIntro);
        sbR.append(", charset=");
        sbR.append((Object) this.charset);
        sbR.append(", type=");
        sbR.append(this.type);
        sbR.append(", group=");
        sbR.append(this.group);
        sbR.append(", latestChapterTitle=");
        sbR.append((Object) this.latestChapterTitle);
        sbR.append(", latestChapterTime=");
        sbR.append(this.latestChapterTime);
        sbR.append(", lastCheckTime=");
        sbR.append(this.lastCheckTime);
        sbR.append(", lastCheckCount=");
        sbR.append(this.lastCheckCount);
        sbR.append(", totalChapterNum=");
        sbR.append(this.totalChapterNum);
        sbR.append(", durChapterTitle=");
        sbR.append((Object) this.durChapterTitle);
        sbR.append(", durChapterIndex=");
        sbR.append(this.durChapterIndex);
        sbR.append(", durChapterPos=");
        sbR.append(this.durChapterPos);
        sbR.append(", durChapterTime=");
        sbR.append(this.durChapterTime);
        sbR.append(", wordCount=");
        sbR.append((Object) getWordCount());
        sbR.append(", canUpdate=");
        sbR.append(this.canUpdate);
        sbR.append(", order=");
        sbR.append(this.order);
        sbR.append(", originOrder=");
        sbR.append(this.originOrder);
        sbR.append(", variable=");
        sbR.append((Object) this.variable);
        sbR.append(", readConfig=");
        sbR.append(this.readConfig);
        sbR.append(')');
        return sbR.toString();
    }

    public final void upInfoFromOld(@Nullable Book oldBook) {
        if (oldBook == null) {
            return;
        }
        setGroup(oldBook.getGroup());
        setDurChapterIndex(oldBook.getDurChapterIndex());
        setDurChapterPos(oldBook.getDurChapterPos());
        setDurChapterTitle(oldBook.getDurChapterTitle());
        setCustomCoverUrl(oldBook.getCustomCoverUrl());
        setCustomIntro(oldBook.getCustomIntro());
        setOrder(oldBook.getOrder());
        String coverUrl = getCoverUrl();
        if (coverUrl == null || coverUrl.length() == 0) {
            setCoverUrl(oldBook.getDisplayCover());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.bookUrl);
        parcel.writeString(this.tocUrl);
        parcel.writeString(this.origin);
        parcel.writeString(this.originName);
        parcel.writeString(this.name);
        parcel.writeString(this.author);
        parcel.writeString(this.kind);
        parcel.writeString(this.customTag);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.customCoverUrl);
        parcel.writeString(this.intro);
        parcel.writeString(this.customIntro);
        parcel.writeString(this.charset);
        parcel.writeInt(this.type);
        parcel.writeLong(this.group);
        parcel.writeString(this.latestChapterTitle);
        parcel.writeLong(this.latestChapterTime);
        parcel.writeLong(this.lastCheckTime);
        parcel.writeInt(this.lastCheckCount);
        parcel.writeInt(this.totalChapterNum);
        parcel.writeString(this.durChapterTitle);
        parcel.writeInt(this.durChapterIndex);
        parcel.writeInt(this.durChapterPos);
        parcel.writeLong(this.durChapterTime);
        parcel.writeString(this.wordCount);
        parcel.writeInt(this.canUpdate ? 1 : 0);
        parcel.writeInt(this.order);
        parcel.writeInt(this.originOrder);
        parcel.writeString(this.variable);
        ReadConfig readConfig = this.readConfig;
        if (readConfig == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            readConfig.writeToParcel(parcel, flags);
        }
    }

    /* JADX INFO: compiled from: Book.kt */
    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b#\u0010$R$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010(R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010,R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010-\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u00100R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010-\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u00100R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010-\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u00100R\"\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u00105\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u00108¨\u0006;"}, d2 = {"Lio/legado/app/data/entities/Book$ReadConfig;", "Landroid/os/Parcelable;", "", "component1", "()Z", "", "component2", "()I", "component3", "", "component4", "()Ljava/lang/String;", "component5", "", "component6", "()J", "reverseToc", "pageAnim", "reSegment", "imageStyle", "useReplaceRule", "delTag", "copy", "(ZIZLjava/lang/String;ZJ)Lio/legado/app/data/entities/Book$ReadConfig;", "toString", TTDownloadField.TT_HASHCODE, "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getImageStyle", "setImageStyle", "(Ljava/lang/String;)V", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getPageAnim", "setPageAnim", "(I)V", "Z", "getUseReplaceRule", "setUseReplaceRule", "(Z)V", "getReSegment", "setReSegment", "getReverseToc", "setReverseToc", "J", "getDelTag", "setDelTag", "(J)V", "<init>", "(ZIZLjava/lang/String;ZJ)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final /* data */ class ReadConfig implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<ReadConfig> CREATOR = new Creator();
        private long delTag;

        @Nullable
        private String imageStyle;
        private int pageAnim;
        private boolean reSegment;
        private boolean reverseToc;
        private boolean useReplaceRule;

        /* JADX INFO: compiled from: Book.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        public static final class Creator implements Parcelable.Creator<ReadConfig> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ReadConfig createFromParcel(@NotNull Parcel parcel) {
                j.e(parcel, "parcel");
                return new ReadConfig(parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ReadConfig[] newArray(int i2) {
                return new ReadConfig[i2];
            }
        }

        public ReadConfig() {
            this(false, 0, false, null, false, 0L, 63, null);
        }

        public ReadConfig(boolean z, int i2, boolean z2, @Nullable String str, boolean z3, long j2) {
            this.reverseToc = z;
            this.pageAnim = i2;
            this.reSegment = z2;
            this.imageStyle = str;
            this.useReplaceRule = z3;
            this.delTag = j2;
        }

        public static /* synthetic */ ReadConfig copy$default(ReadConfig readConfig, boolean z, int i2, boolean z2, String str, boolean z3, long j2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z = readConfig.reverseToc;
            }
            if ((i3 & 2) != 0) {
                i2 = readConfig.pageAnim;
            }
            int i4 = i2;
            if ((i3 & 4) != 0) {
                z2 = readConfig.reSegment;
            }
            boolean z4 = z2;
            if ((i3 & 8) != 0) {
                str = readConfig.imageStyle;
            }
            String str2 = str;
            if ((i3 & 16) != 0) {
                z3 = readConfig.useReplaceRule;
            }
            boolean z5 = z3;
            if ((i3 & 32) != 0) {
                j2 = readConfig.delTag;
            }
            return readConfig.copy(z, i4, z4, str2, z5, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getReverseToc() {
            return this.reverseToc;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPageAnim() {
            return this.pageAnim;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getReSegment() {
            return this.reSegment;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImageStyle() {
            return this.imageStyle;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getUseReplaceRule() {
            return this.useReplaceRule;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getDelTag() {
            return this.delTag;
        }

        @NotNull
        public final ReadConfig copy(boolean reverseToc, int pageAnim, boolean reSegment, @Nullable String imageStyle, boolean useReplaceRule, long delTag) {
            return new ReadConfig(reverseToc, pageAnim, reSegment, imageStyle, useReplaceRule, delTag);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReadConfig)) {
                return false;
            }
            ReadConfig readConfig = (ReadConfig) other;
            return this.reverseToc == readConfig.reverseToc && this.pageAnim == readConfig.pageAnim && this.reSegment == readConfig.reSegment && j.a(this.imageStyle, readConfig.imageStyle) && this.useReplaceRule == readConfig.useReplaceRule && this.delTag == readConfig.delTag;
        }

        public final long getDelTag() {
            return this.delTag;
        }

        @Nullable
        public final String getImageStyle() {
            return this.imageStyle;
        }

        public final int getPageAnim() {
            return this.pageAnim;
        }

        public final boolean getReSegment() {
            return this.reSegment;
        }

        public final boolean getReverseToc() {
            return this.reverseToc;
        }

        public final boolean getUseReplaceRule() {
            return this.useReplaceRule;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            boolean z = this.reverseToc;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i2 = ((r0 * 31) + this.pageAnim) * 31;
            boolean z2 = this.reSegment;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i3 = (i2 + r2) * 31;
            String str = this.imageStyle;
            int iHashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
            boolean z3 = this.useReplaceRule;
            return b.a(this.delTag) + ((iHashCode + (z3 ? 1 : z3)) * 31);
        }

        public final void setDelTag(long j2) {
            this.delTag = j2;
        }

        public final void setImageStyle(@Nullable String str) {
            this.imageStyle = str;
        }

        public final void setPageAnim(int i2) {
            this.pageAnim = i2;
        }

        public final void setReSegment(boolean z) {
            this.reSegment = z;
        }

        public final void setReverseToc(boolean z) {
            this.reverseToc = z;
        }

        public final void setUseReplaceRule(boolean z) {
            this.useReplaceRule = z;
        }

        @NotNull
        public String toString() {
            StringBuilder sbR = a.r("ReadConfig(reverseToc=");
            sbR.append(this.reverseToc);
            sbR.append(", pageAnim=");
            sbR.append(this.pageAnim);
            sbR.append(", reSegment=");
            sbR.append(this.reSegment);
            sbR.append(", imageStyle=");
            sbR.append((Object) this.imageStyle);
            sbR.append(", useReplaceRule=");
            sbR.append(this.useReplaceRule);
            sbR.append(", delTag=");
            sbR.append(this.delTag);
            sbR.append(')');
            return sbR.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            j.e(parcel, "out");
            parcel.writeInt(this.reverseToc ? 1 : 0);
            parcel.writeInt(this.pageAnim);
            parcel.writeInt(this.reSegment ? 1 : 0);
            parcel.writeString(this.imageStyle);
            parcel.writeInt(this.useReplaceRule ? 1 : 0);
            parcel.writeLong(this.delTag);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ReadConfig(boolean z, int i2, boolean z2, String str, boolean z3, long j2, int i3, f fVar) {
            boolean z4 = (i3 & 1) != 0 ? false : z;
            int i4 = (i3 & 2) != 0 ? -1 : i2;
            boolean z5 = (i3 & 4) == 0 ? z2 : false;
            String str2 = (i3 & 8) != 0 ? null : str;
            if ((i3 & 16) != 0) {
                e.a.a.d.e eVar = e.a.a.d.e.a;
                z3 = c.b.a.m.f.J2(k.d.a.h.g(), "replaceEnableDefault", true);
            }
            this(z4, i4, z5, str2, z3, (i3 & 32) != 0 ? 0L : j2);
        }
    }

    public /* synthetic */ Book(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2, long j2, String str14, long j3, long j4, int i3, int i4, String str15, int i5, int i6, long j5, String str16, boolean z, int i7, int i8, String str17, ReadConfig readConfig, int i9, f fVar) {
        this((i9 & 1) != 0 ? "" : str, (i9 & 2) != 0 ? "" : str2, (i9 & 4) != 0 ? "loc_book" : str3, (i9 & 8) != 0 ? "" : str4, (i9 & 16) != 0 ? "" : str5, (i9 & 32) == 0 ? str6 : "", (i9 & 64) != 0 ? null : str7, (i9 & 128) != 0 ? null : str8, (i9 & 256) != 0 ? null : str9, (i9 & 512) != 0 ? null : str10, (i9 & 1024) != 0 ? null : str11, (i9 & 2048) != 0 ? null : str12, (i9 & 4096) != 0 ? null : str13, (i9 & 8192) != 0 ? 0 : i2, (i9 & 16384) != 0 ? 0L : j2, (32768 & i9) != 0 ? null : str14, (i9 & 65536) != 0 ? System.currentTimeMillis() : j3, (i9 & 131072) != 0 ? System.currentTimeMillis() : j4, (i9 & 262144) != 0 ? 0 : i3, (i9 & 524288) != 0 ? 0 : i4, (i9 & 1048576) != 0 ? null : str15, (i9 & 2097152) != 0 ? 0 : i5, (i9 & 4194304) != 0 ? 0 : i6, (i9 & 8388608) != 0 ? System.currentTimeMillis() : j5, (i9 & 16777216) != 0 ? null : str16, (i9 & 33554432) != 0 ? true : z, (i9 & 67108864) != 0 ? 0 : i7, (i9 & 134217728) == 0 ? i8 : 0, (i9 & 268435456) != 0 ? null : str17, (i9 & 536870912) != 0 ? null : readConfig);
    }
}
