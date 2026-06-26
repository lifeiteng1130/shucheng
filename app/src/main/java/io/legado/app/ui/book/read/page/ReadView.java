package io.legado.app.ui.book.read.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.i.s1.f.g;
import f.c0.c.j;
import f.c0.c.k;
import f.h;
import f.v;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.page.ReadView;
import java.lang.reflect.InvocationTargetException;
import java.text.BreakIterator;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ReadView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B\u001d\u0012\b\u0010·\u0001\u001a\u00030¶\u0001\u0012\b\u0010¹\u0001\u001a\u00030¸\u0001¢\u0006\u0006\bº\u0001\u0010»\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\tJ\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u001b\u0010\u0019J'\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b\u000b\u0010 J\u0015\u0010#\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0005¢\u0006\u0004\b%\u0010\tJ\u001f\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0017H\u0016¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0005¢\u0006\u0004\b*\u0010\tJ\u000f\u0010+\u001a\u00020\u0017H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010,R\u0016\u00100\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00107\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001d\u0010<\u001a\u00020\u00038F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010?R\"\u0010K\u001a\u00020E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010/R\"\u0010O\u001a\u00020E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010F\u001a\u0004\bM\u0010H\"\u0004\bN\u0010JR\u0016\u0010Q\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010?R\"\u0010T\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u00102\u001a\u0004\bR\u00104\"\u0004\bS\u00106R\"\u0010X\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u00102\u001a\u0004\bV\u00104\"\u0004\bW\u00106R\u001d\u0010]\u001a\u00020Y8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u00109\u001a\u0004\b[\u0010\\R\"\u0010_\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010/\u001a\u0004\b_\u0010,\"\u0004\b`\u0010aR\"\u0010h\u001a\u00020b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010/R\u0018\u0010n\u001a\u0004\u0018\u00010k8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010r\u001a\u00020o8F@\u0006¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0016\u0010s\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010CR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bu\u0010ZR\u0016\u0010x\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010?R\"\u0010|\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u00102\u001a\u0004\bz\u00104\"\u0004\b{\u00106R\u0016\u0010}\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010?R#\u0010\u007f\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010/\u001a\u0004\b\u007f\u0010,\"\u0005\b\u0080\u0001\u0010aR\u0017\u0010\u0081\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010CR\u0018\u0010\u0083\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010/R&\u0010\u0085\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010/\u001a\u0005\b\u0085\u0001\u0010,\"\u0005\b\u0086\u0001\u0010aR\u001a\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008f\u0001\u001a\u00030\u008b\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008c\u0001\u00109\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0091\u0001\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010?R,\u0010\u0097\u0001\u001a\r \u0093\u0001*\u0005\u0018\u00010\u0092\u00010\u0092\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0094\u0001\u00109\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R7\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0098\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0006@BX\u0086\u000e¢\u0006\u0017\n\u0005\b+\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0017\u0010 \u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010CR\u001a\u0010¢\u0001\u001a\u0004\u0018\u00010k8V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010mR%\u0010¥\u0001\u001a\u00020E8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0006\u0010F\u001a\u0005\b£\u0001\u0010H\"\u0005\b¤\u0001\u0010JR&\u0010©\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u00102\u001a\u0005\b§\u0001\u00104\"\u0005\b¨\u0001\u00106R&\u0010\u00ad\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bª\u0001\u00102\u001a\u0005\b«\u0001\u00104\"\u0005\b¬\u0001\u00106R\u001e\u0010¯\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086D¢\u0006\r\n\u0004\b\u000b\u0010C\u001a\u0005\b®\u0001\u0010;R\u0018\u0010±\u0001\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b°\u0001\u0010?R\u0018\u0010³\u0001\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b²\u0001\u0010?R\u001a\u0010µ\u0001\u001a\u0004\u0018\u00010k8V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010m¨\u0006¼\u0001"}, d2 = {"Lio/legado/app/ui/book/read/page/ReadView;", "Landroid/widget/FrameLayout;", "Le/a/a/g/d/i/s1/e/a;", "", "action", "Lf/v;", "e", "(I)V", "g", "()V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "computeScroll", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "", "x", "y", "invalidate", "(FFZ)V", "Le/a/a/g/d/i/s1/g/a;", "direction", "f", "(Le/a/a/g/d/i/s1/g/a;)Z", "k", "relativePosition", "resetPageOffset", "b", "(IZ)V", "j", ai.aD, "()Z", ai.at, ai.aA, "Z", "pressDown", "n", "F", "getLastY", "()F", "setLastY", "(F)V", "lastY", ai.aB, "Lf/e;", "getSlopSquare", "()I", "slopSquare", "Landroid/graphics/RectF;", "C", "Landroid/graphics/RectF;", "trRect", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tlRect", OptRuntime.GeneratorState.resumptionPoint_TYPE, "brRect", "Lio/legado/app/ui/book/read/page/PageView;", "Lio/legado/app/ui/book/read/page/PageView;", "getNextPage", "()Lio/legado/app/ui/book/read/page/PageView;", "setNextPage", "(Lio/legado/app/ui/book/read/page/PageView;)V", "nextPage", "isMove", "getCurPage", "setCurPage", "curPage", "D", "mlRect", "getStartX", "setStartX", "startX", "p", "getTouchY", "setTouchY", "touchY", "Landroid/graphics/Rect;", "J", "getAutoPageRect", "()Landroid/graphics/Rect;", "autoPageRect", ai.aE, "isTextSelected", "setTextSelected", "(Z)V", "Le/a/a/g/d/i/s1/h/c;", "Le/a/a/g/d/i/s1/h/c;", "getPageFactory", "()Le/a/a/g/d/i/s1/h/c;", "setPageFactory", "(Le/a/a/g/d/i/s1/h/c;)V", "pageFactory", ai.aC, "pressOnTextSelected", "Le/a/a/g/d/i/s1/g/b;", "getCurrentChapter", "()Le/a/a/g/d/i/s1/g/b;", "currentChapter", "Lio/legado/app/ui/book/read/page/ReadView$a;", "getCallBack", "()Lio/legado/app/ui/book/read/page/ReadView$a;", "callBack", "firstRelativePage", "", ai.az, "longPressTimeout", "H", "bcRect", "o", "getTouchX", "setTouchX", "touchX", "mrRect", "d", "isScroll", "setScroll", "firstLineIndex", "r", "longPressed", "q", "isAbortAnim", "setAbortAnim", "Ljava/lang/Runnable;", ai.aF, "Ljava/lang/Runnable;", "longPressRunnable", "Landroid/graphics/Paint;", "K", "getAutoPagePint", "()Landroid/graphics/Paint;", "autoPagePint", ExifInterface.LONGITUDE_EAST, "mcRect", "Ljava/text/BreakIterator;", "kotlin.jvm.PlatformType", "O", "getBoundary", "()Ljava/text/BreakIterator;", "boundary", "Le/a/a/g/d/i/s1/f/e;", ES6Iterator.VALUE_PROPERTY, "Le/a/a/g/d/i/s1/f/e;", "getPageDelegate", "()Le/a/a/g/d/i/s1/f/e;", "setPageDelegate", "(Le/a/a/g/d/i/s1/f/e;)V", "pageDelegate", "firstCharIndex", "getNextChapter", "nextChapter", "getPrevPage", "setPrevPage", "prevPage", Constants.LANDSCAPE, "getStartY", "setStartY", "startY", "m", "getLastX", "setLastX", "lastX", "getDefaultAnimationSpeed", "defaultAnimationSpeed", "B", "tcRect", "G", "blRect", "getPrevChapter", "prevChapter", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadView extends FrameLayout implements e.a.a.g.d.i.s1.e.a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    @NotNull
    public final RectF tlRect;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    @NotNull
    public final RectF tcRect;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    @NotNull
    public final RectF trRect;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    @NotNull
    public final RectF mlRect;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    @NotNull
    public final RectF mcRect;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    @NotNull
    public final RectF mrRect;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    @NotNull
    public final RectF blRect;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    @NotNull
    public final RectF bcRect;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    @NotNull
    public final RectF brRect;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    @NotNull
    public final f.e autoPageRect;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    @NotNull
    public final f.e autoPagePint;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    @NotNull
    public final f.e boundary;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public e.a.a.g.d.i.s1.h.c pageFactory;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public e.a.a.g.d.i.s1.f.e pageDelegate;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean isScroll;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public PageView prevPage;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public PageView curPage;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public PageView nextPage;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int defaultAnimationSpeed;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean pressDown;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean isMove;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public float startX;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public float startY;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public float lastX;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public float lastY;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public float touchX;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public float touchY;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public boolean isAbortAnim;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public boolean longPressed;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final long longPressTimeout;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @NotNull
    public final Runnable longPressRunnable;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean isTextSelected;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public boolean pressOnTextSelected;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public int firstRelativePage;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public int firstLineIndex;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public int firstCharIndex;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    @NotNull
    public final f.e slopSquare;

    /* JADX INFO: compiled from: ReadView.kt */
    public interface a {
        void B0();

        void C();

        void Z();

        void i();

        /* JADX INFO: renamed from: w */
        boolean getIsAutoPage();

        /* JADX INFO: renamed from: x0 */
        int getAutoPageProgress();

        boolean y0();
    }

    /* JADX INFO: compiled from: ReadView.kt */
    public static final class b extends k implements f.c0.b.a<Paint> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setColor(f.M1(this.$context));
            return paint;
        }
    }

    /* JADX INFO: compiled from: ReadView.kt */
    public static final class c extends k implements f.c0.b.a<Rect> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final Rect invoke() {
            return new Rect();
        }
    }

    /* JADX INFO: compiled from: ReadView.kt */
    public static final class d extends k implements f.c0.b.a<BreakIterator> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        @Override // f.c0.b.a
        public final BreakIterator invoke() {
            return BreakIterator.getWordInstance(Locale.getDefault());
        }
    }

    /* JADX INFO: compiled from: ReadView.kt */
    public static final class e extends k implements f.c0.b.a<Integer> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return ViewConfiguration.get(this.$context).getScaledTouchSlop();
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, com.umeng.analytics.pro.c.R);
        j.e(attributeSet, "attrs");
        this.pageFactory = new e.a.a.g.d.i.s1.h.c(this);
        this.prevPage = new PageView(context);
        this.curPage = new PageView(context);
        this.nextPage = new PageView(context);
        this.defaultAnimationSpeed = 300;
        this.longPressTimeout = 600L;
        this.longPressRunnable = new Runnable() { // from class: e.a.a.g.d.i.s1.a
            @Override // java.lang.Runnable
            public final void run() {
                ReadView readView = this.a;
                int i2 = ReadView.a;
                j.e(readView, "this$0");
                readView.longPressed = true;
                try {
                    readView.getCurPage().g(readView.getStartX(), readView.getStartY(), new c(readView, readView.getCurPage().getTextPage()));
                    h.m11constructorimpl(v.a);
                } catch (Throwable th) {
                    h.m11constructorimpl(f.m1(th));
                }
            }
        };
        this.slopSquare = f.N3(new e(context));
        this.tlRect = new RectF();
        this.tcRect = new RectF();
        this.trRect = new RectF();
        this.mlRect = new RectF();
        this.mcRect = new RectF();
        this.mrRect = new RectF();
        this.blRect = new RectF();
        this.bcRect = new RectF();
        this.brRect = new RectF();
        this.autoPageRect = f.N3(c.INSTANCE);
        this.autoPagePint = f.N3(new b(context));
        this.boundary = f.N3(d.INSTANCE);
        addView(this.nextPage);
        addView(this.curPage);
        addView(this.prevPage);
        if (!isInEditMode()) {
            j();
            setWillNotDraw(false);
            k();
        }
        g();
    }

    private final Paint getAutoPagePint() {
        return (Paint) this.autoPagePint.getValue();
    }

    private final Rect getAutoPageRect() {
        return (Rect) this.autoPageRect.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BreakIterator getBoundary() {
        return (BreakIterator) this.boundary.getValue();
    }

    public static void i(ReadView readView, float f2, float f3, boolean z, int i2) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        readView.lastX = readView.touchX;
        readView.lastY = readView.touchY;
        readView.touchX = f2;
        readView.touchY = f3;
        if (z) {
            readView.invalidate();
        }
        e.a.a.g.d.i.s1.f.e eVar = readView.pageDelegate;
        if (eVar == null) {
            return;
        }
        eVar.p();
    }

    private final void setPageDelegate(e.a.a.g.d.i.s1.f.e eVar) {
        e.a.a.g.d.i.s1.f.e eVar2 = this.pageDelegate;
        if (eVar2 != null) {
            eVar2.n();
        }
        this.pageDelegate = null;
        this.pageDelegate = eVar;
        f.W5(this, 0, false, 3, null);
    }

    @Override // e.a.a.g.d.i.s1.e.a
    public boolean a() {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        return e.a.a.f.s.k.f5681g > 0;
    }

    @Override // e.a.a.g.d.i.s1.e.a
    public void b(int relativePosition, boolean resetPageOffset) {
        this.curPage.setContentDescription(this.pageFactory.a().f5781b);
        if (!this.isScroll || getCallBack().getIsAutoPage()) {
            this.curPage.d();
            if (relativePosition == -1) {
                PageView.i(this.prevPage, this.pageFactory.c(), false, false, 6);
            } else if (relativePosition != 1) {
                PageView.i(this.curPage, this.pageFactory.a(), false, true, 2);
                PageView.i(this.nextPage, this.pageFactory.b(), false, false, 6);
                PageView.i(this.prevPage, this.pageFactory.c(), false, false, 6);
            } else {
                PageView.i(this.nextPage, this.pageFactory.b(), false, false, 6);
            }
        } else {
            this.curPage.h(this.pageFactory.a(), resetPageOffset, true);
        }
        getCallBack().B0();
    }

    @Override // e.a.a.g.d.i.s1.e.a
    public boolean c() {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        return e.a.a.f.s.k.f5681g < e.a.a.f.s.k.f5680f - 1;
    }

    @Override // android.view.View
    public void computeScroll() {
        e.a.a.g.d.i.s1.f.e eVar = this.pageDelegate;
        if (eVar == null) {
            return;
        }
        if (eVar.b().computeScrollOffset()) {
            i(eVar.a, eVar.b().getCurrX(), eVar.b().getCurrY(), false, 4);
        } else if (eVar.f5764k) {
            eVar.m();
            eVar.f5764k = false;
            eVar.a.post(new e.a.a.g.d.i.s1.f.a(eVar));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        Bitmap bitmapY4;
        j.e(canvas, "canvas");
        super.dispatchDraw(canvas);
        e.a.a.g.d.i.s1.f.e eVar = this.pageDelegate;
        if (eVar != null) {
            eVar.o(canvas);
        }
        if (isInEditMode() || !getCallBack().getIsAutoPage() || this.isScroll || (bitmapY4 = f.Y4(this.nextPage)) == null) {
            return;
        }
        int iX0 = getCallBack().getAutoPageProgress();
        getAutoPageRect().set(0, 0, getWidth(), iX0);
        canvas.drawBitmap(bitmapY4, getAutoPageRect(), getAutoPageRect(), (Paint) null);
        float f2 = iX0;
        canvas.drawRect(0.0f, f2 - 1, getWidth(), f2, getAutoPagePint());
    }

    public final void e(int action) throws IllegalAccessException, InvocationTargetException {
        if (action == 0) {
            getCallBack().C();
            return;
        }
        if (action == 1) {
            e.a.a.g.d.i.s1.f.e eVar = this.pageDelegate;
            if (eVar == null) {
                return;
            }
            eVar.k(this.defaultAnimationSpeed);
            return;
        }
        if (action == 2) {
            e.a.a.g.d.i.s1.f.e eVar2 = this.pageDelegate;
            if (eVar2 == null) {
                return;
            }
            eVar2.r(this.defaultAnimationSpeed);
            return;
        }
        if (action == 3) {
            e.a.a.f.s.k.a.k(true);
        } else {
            if (action != 4) {
                return;
            }
            e.a.a.f.s.k.a.m(true, false);
        }
    }

    public final boolean f(@NotNull e.a.a.g.d.i.s1.g.a direction) {
        j.e(direction, "direction");
        int iOrdinal = direction.ordinal();
        if (iOrdinal == 1) {
            return this.pageFactory.g(true);
        }
        if (iOrdinal != 2) {
            return false;
        }
        return this.pageFactory.f(true);
    }

    public final void g() {
        e.a.a.d.e eVar = e.a.a.d.e.a;
        float f2 = f.J2(k.d.a.h.g(), "fullScreenGesturesSupport", false) ? 200.0f : 0.0f;
        float f3 = f2 + 0.0f;
        this.tlRect.set(f3, 0.0f, getWidth() * 0.33f, getHeight() * 0.33f);
        this.tcRect.set(getWidth() * 0.33f, 0.0f, getWidth() * 0.66f, getHeight() * 0.33f);
        this.trRect.set(getWidth() * 0.36f, 0.0f, (getWidth() - 0.0f) - f2, getHeight() * 0.33f);
        this.mlRect.set(f3, getHeight() * 0.33f, getWidth() * 0.33f, getHeight() * 0.66f);
        this.mcRect.set(getWidth() * 0.33f, getHeight() * 0.33f, getWidth() * 0.66f, getHeight() * 0.66f);
        this.mrRect.set(getWidth() * 0.66f, getHeight() * 0.33f, (getWidth() - 0.0f) - f2, getHeight() * 0.66f);
        this.blRect.set(f3, getHeight() * 0.66f, getWidth() * 0.33f, (getHeight() - 10.0f) - f2);
        this.bcRect.set(getWidth() * 0.33f, getHeight() * 0.66f, getWidth() * 0.66f, (getHeight() - 0.0f) - f2);
        this.brRect.set(getWidth() * 0.66f, getHeight() * 0.66f, (getWidth() - 0.0f) - f2, (getHeight() - 0.0f) - f2);
    }

    @NotNull
    public final a getCallBack() {
        KeyEventDispatcher.Component componentO1 = f.O1(this);
        Objects.requireNonNull(componentO1, "null cannot be cast to non-null type io.legado.app.ui.book.read.page.ReadView.CallBack");
        return (a) componentO1;
    }

    @NotNull
    public final PageView getCurPage() {
        return this.curPage;
    }

    @Override // e.a.a.g.d.i.s1.e.a
    @Nullable
    public e.a.a.g.d.i.s1.g.b getCurrentChapter() {
        if (getCallBack().y0()) {
            return e.a.a.f.s.k.a.t(0);
        }
        return null;
    }

    public final int getDefaultAnimationSpeed() {
        return this.defaultAnimationSpeed;
    }

    public final float getLastX() {
        return this.lastX;
    }

    public final float getLastY() {
        return this.lastY;
    }

    @Override // e.a.a.g.d.i.s1.e.a
    @Nullable
    public e.a.a.g.d.i.s1.g.b getNextChapter() {
        if (getCallBack().y0()) {
            return e.a.a.f.s.k.a.t(1);
        }
        return null;
    }

    @NotNull
    public final PageView getNextPage() {
        return this.nextPage;
    }

    @Nullable
    public final e.a.a.g.d.i.s1.f.e getPageDelegate() {
        return this.pageDelegate;
    }

    @NotNull
    public final e.a.a.g.d.i.s1.h.c getPageFactory() {
        return this.pageFactory;
    }

    @Override // e.a.a.g.d.i.s1.e.a
    public int getPageIndex() {
        j.e(this, "this");
        return e.a.a.f.s.k.a.h();
    }

    @Override // e.a.a.g.d.i.s1.e.a
    @Nullable
    public e.a.a.g.d.i.s1.g.b getPrevChapter() {
        if (getCallBack().y0()) {
            return e.a.a.f.s.k.a.t(-1);
        }
        return null;
    }

    @NotNull
    public final PageView getPrevPage() {
        return this.prevPage;
    }

    public final int getSlopSquare() {
        return ((Number) this.slopSquare.getValue()).intValue();
    }

    public final float getStartX() {
        return this.startX;
    }

    public final float getStartY() {
        return this.startY;
    }

    public final float getTouchX() {
        return this.touchX;
    }

    public final float getTouchY() {
        return this.touchY;
    }

    public final void h(float x, float y, boolean invalidate) {
        this.startX = x;
        this.startY = y;
        this.lastX = x;
        this.lastY = y;
        this.touchX = x;
        this.touchY = y;
        if (invalidate) {
            invalidate();
        }
    }

    public final void j() {
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        if (readBookConfig.getBg() == null) {
            readBookConfig.upBg();
        }
        this.curPage.setBg(readBookConfig.getBg());
        this.prevPage.setBg(readBookConfig.getBg());
        this.nextPage.setBg(readBookConfig.getBg());
    }

    public final void k() {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        this.isScroll = kVar.n() == 3;
        int iN = kVar.n();
        if (iN == 0) {
            if (this.pageDelegate instanceof e.a.a.g.d.i.s1.f.b) {
                return;
            }
            setPageDelegate(new e.a.a.g.d.i.s1.f.b(this));
            return;
        }
        if (iN == 1) {
            if (this.pageDelegate instanceof e.a.a.g.d.i.s1.f.h) {
                return;
            }
            setPageDelegate(new e.a.a.g.d.i.s1.f.h(this));
        } else if (iN == 2) {
            if (this.pageDelegate instanceof g) {
                return;
            }
            setPageDelegate(new g(this));
        } else if (iN != 3) {
            if (this.pageDelegate instanceof e.a.a.g.d.i.s1.f.d) {
                return;
            }
            setPageDelegate(new e.a.a.g.d.i.s1.f.d(this));
        } else {
            if (this.pageDelegate instanceof e.a.a.g.d.i.s1.f.f) {
                return;
            }
            setPageDelegate(new e.a.a.g.d.i.s1.f.f(this));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev) {
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        g();
        this.prevPage.setX(-w);
        e.a.a.g.d.i.s1.f.e eVar = this.pageDelegate;
        if (eVar == null) {
            return;
        }
        eVar.t(w, h2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r6) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.page.ReadView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setAbortAnim(boolean z) {
        this.isAbortAnim = z;
    }

    public final void setCurPage(@NotNull PageView pageView) {
        j.e(pageView, "<set-?>");
        this.curPage = pageView;
    }

    public final void setLastX(float f2) {
        this.lastX = f2;
    }

    public final void setLastY(float f2) {
        this.lastY = f2;
    }

    public final void setNextPage(@NotNull PageView pageView) {
        j.e(pageView, "<set-?>");
        this.nextPage = pageView;
    }

    public final void setPageFactory(@NotNull e.a.a.g.d.i.s1.h.c cVar) {
        j.e(cVar, "<set-?>");
        this.pageFactory = cVar;
    }

    public final void setPrevPage(@NotNull PageView pageView) {
        j.e(pageView, "<set-?>");
        this.prevPage = pageView;
    }

    public final void setScroll(boolean z) {
        this.isScroll = z;
    }

    public final void setStartX(float f2) {
        this.startX = f2;
    }

    public final void setStartY(float f2) {
        this.startY = f2;
    }

    public final void setTextSelected(boolean z) {
        this.isTextSelected = z;
    }

    public final void setTouchX(float f2) {
        this.touchX = f2;
    }

    public final void setTouchY(float f2) {
        this.touchY = f2;
    }
}
