package io.legado.app.ui.widget.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.ui.widget.image.PhotoView;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: PhotoView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u000bè\u0001µ\u0001u\u0003J\u0010\r\u0007\u0005B#\b\u0007\u0012\b\u0010ã\u0001\u001a\u00030â\u0001\u0012\f\b\u0002\u0010å\u0001\u001a\u0005\u0018\u00010ä\u0001¢\u0006\u0006\bæ\u0001\u0010ç\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\u0013J\u0015\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0004¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020&¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0004¢\u0006\u0004\b-\u0010%J\u0017\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0004H\u0017¢\u0006\u0004\b/\u0010%J\u0019\u00101\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00105\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0004H\u0014¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\b2\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J/\u0010>\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004H\u0014¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u0002072\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u0015\u0010\u0003\u001a\u0002072\u0006\u0010H\u001a\u00020&¢\u0006\u0004\b\u0003\u0010IJ\u0015\u0010J\u001a\u0002072\u0006\u0010H\u001a\u00020&¢\u0006\u0004\bJ\u0010IJ\u0017\u0010K\u001a\u0002072\u0006\u0010H\u001a\u00020\u0004H\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u0002072\u0006\u0010H\u001a\u00020\u0004H\u0016¢\u0006\u0004\bM\u0010LJ\r\u0010O\u001a\u00020N¢\u0006\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010e\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010]R\u0016\u0010f\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010`R\u0016\u0010i\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\"\u0010m\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010j\u001a\u0004\bk\u0010\u0013\"\u0004\bl\u0010%R\"\u0010p\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010j\u001a\u0004\bn\u0010\u0013\"\u0004\bo\u0010%R\"\u0010r\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010]\u001a\u0004\br\u0010s\"\u0004\bt\u0010:R\u001c\u0010w\u001a\u00020\u00048\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\bu\u0010j\u001a\u0004\bv\u0010\u0013R\"\u0010z\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010j\u001a\u0004\bx\u0010\u0013\"\u0004\by\u0010%R\"\u0010}\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010j\u001a\u0004\b{\u0010\u0013\"\u0004\b|\u0010%R\u0016\u0010\u007f\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010]R\u0018\u0010\u0081\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010hR\u0018\u0010\u0083\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010`R\u0018\u0010\u0085\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010ZR\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u008a\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010hR\u001e\u0010\u008e\u0001\u001a\u00070\u008b\u0001R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001e\u0010\u0092\u0001\u001a\u00070\u008f\u0001R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0017\u0010\u0097\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010jR\u0018\u0010\u0099\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010]R\u0018\u0010\u009b\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010]R\u0018\u0010\u009d\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010]R\u0018\u0010\u009f\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010hR\u0018\u0010¡\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010`R\u001e\u0010£\u0001\u001a\u00020&8\u0006@\u0006X\u0086D¢\u0006\r\n\u0004\b\u0003\u0010`\u001a\u0005\b¢\u0001\u0010+R\u001a\u0010¥\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010\u0095\u0001R\u0017\u0010¦\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010`R\u001a\u0010ª\u0001\u001a\u00030§\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R&\u0010¬\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b«\u0001\u0010]\u001a\u0005\b¬\u0001\u0010s\"\u0005\b\u00ad\u0001\u0010:R\u0018\u0010¯\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010jR\u001a\u0010³\u0001\u001a\u00030°\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0017\u0010´\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010jR\u001f\u0010·\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086D¢\u0006\u000e\n\u0005\bµ\u0001\u0010j\u001a\u0005\b¶\u0001\u0010\u0013R\u0018\u0010¹\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¸\u0001\u0010ZR\u001a\u0010»\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bº\u0001\u0010hR\u001a\u0010¿\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001a\u0010Á\u0001\u001a\u00030§\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010©\u0001R\u001e\u0010Å\u0001\u001a\u00070Â\u0001R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001a\u0010Ç\u0001\u001a\u00030§\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010©\u0001R\u001e\u0010Ë\u0001\u001a\u00070È\u0001R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0018\u0010Í\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÌ\u0001\u0010]R\u0018\u0010Ï\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÎ\u0001\u0010]R\u0017\u0010Ð\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010ZR\u0018\u0010Ò\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÑ\u0001\u0010`R\u001a\u0010Ö\u0001\u001a\u00030Ó\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0018\u0010Ø\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b×\u0001\u0010]R\u0017\u0010Ù\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010]R\u0018\u0010Û\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÚ\u0001\u0010hR\u001b\u0010Þ\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R%\u0010á\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0010\u0010j\u001a\u0005\bß\u0001\u0010\u0013\"\u0005\bà\u0001\u0010%¨\u0006é\u0001"}, d2 = {"Lio/legado/app/ui/widget/image/PhotoView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/drawable/Drawable;", "d", "", ai.aA, "(Landroid/graphics/drawable/Drawable;)I", "h", "Lf/v;", "j", "()V", "k", Constants.LANDSCAPE, "g", "Landroid/graphics/RectF;", "imgRect", "f", "(Landroid/graphics/RectF;)V", "getDefaultAnimDuring", "()I", "Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "Landroid/view/View$OnLongClickListener;", "setOnLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "Landroid/view/animation/Interpolator;", "interpolator", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "getAnimDuring", "during", "setAnimDuring", "(I)V", "", "maxScale", "setMaxScale", "(F)V", "getMaxScale", "()F", "wait", "setMaxAnimFromWaiteTime", "resId", "setImageResource", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "adjustViewBounds", "setAdjustViewBounds", "(Z)V", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "direction", "(F)Z", "e", "canScrollHorizontally", "(I)Z", "canScrollVertically", "Le/a/a/g/m/m/b/a;", "getInfo", "()Le/a/a/g/m/m/b/a;", ai.aF, "Landroid/widget/ImageView$ScaleType;", "mScaleType", "", "e0", "J", "mInfoTime", "Landroid/graphics/Matrix;", "o", "Landroid/graphics/Matrix;", "mTmpMatrix", "x", "Z", "hasOverTranslate", "H", "F", "mDegrees", "d0", "Le/a/a/g/m/m/b/a;", "mFromInfo", "isKnowSize", "mMaxScale", "Q", "Landroid/graphics/RectF;", "mWidgetRect", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getMAX_OVER_SCROLL", "setMAX_OVER_SCROLL", "MAX_OVER_SCROLL", "getMAX_ANIM_FROM_WAITE", "setMAX_ANIM_FROM_WAITE", "MAX_ANIM_FROM_WAITE", ai.aB, "isRotateEnable", "()Z", "setRotateEnable", ai.aD, "getANIMA_DURING", "ANIMA_DURING", "getMAX_OVER_RESISTANCE", "setMAX_OVER_RESISTANCE", "MAX_OVER_RESISTANCE", "getMAX_FLING_OVER_SCROLL", "setMAX_FLING_OVER_SCROLL", "MAX_FLING_OVER_SCROLL", ai.aE, "hasMultiTouch", "R", "mBaseRect", "G", "mRotateFlag", "n", "mSynthesisMatrix", ai.az, "Landroid/view/View$OnClickListener;", "mClickListener", ExifInterface.LATITUDE_SOUTH, "mImgRect", "Lio/legado/app/ui/widget/image/PhotoView$c;", "i0", "Lio/legado/app/ui/widget/image/PhotoView$c;", "mGestureListener", "Lio/legado/app/ui/widget/image/PhotoView$h;", "j0", "Lio/legado/app/ui/widget/image/PhotoView$h;", "mScaleListener", "Ljava/lang/Runnable;", "f0", "Ljava/lang/Runnable;", "mCompleteCallBack", "mMinRotate", "D", "canRotate", ExifInterface.LONGITUDE_EAST, "imgLargeWidth", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isInit", "U", "mCommonRect", "P", "mHalfBaseRectHeight", "getMAX_SCALE", "MAX_SCALE", "k0", "mClickRunnable", "mScale", "Landroid/graphics/PointF;", ExifInterface.LONGITUDE_WEST, "Landroid/graphics/PointF;", "mScaleCenter", "y", "isEnable", "setEnable", "K", "mTranslateY", "Le/a/a/g/m/m/b/c;", "p", "Le/a/a/g/m/m/b/c;", "mRotateDetector", "mTranslateX", "b", "getMIN_ROTATE", "MIN_ROTATE", "m", "mAnimMatrix", "c0", "mClip", "Landroid/view/GestureDetector;", "q", "Landroid/view/GestureDetector;", "mDetector", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "mScreenCenter", "Lio/legado/app/ui/widget/image/PhotoView$i;", "b0", "Lio/legado/app/ui/widget/image/PhotoView$i;", "mTranslate", "a0", "mRotateCenter", "Lio/legado/app/ui/widget/image/PhotoView$f;", "h0", "Lio/legado/app/ui/widget/image/PhotoView$f;", "mRotateListener", "B", "mAdjustViewBounds", ai.aC, "hasDrawable", "mBaseMatrix", "O", "mHalfBaseRectWidth", "Landroid/view/ScaleGestureDetector;", "r", "Landroid/view/ScaleGestureDetector;", "mScaleDetector", "C", "isZoonUp", "imgLargeHeight", ExifInterface.GPS_DIRECTION_TRUE, "mTmpRect", "g0", "Landroid/view/View$OnLongClickListener;", "mLongClick", "getMAnimaDuring", "setMAnimaDuring", "mAnimaDuring", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PhotoView extends AppCompatImageView {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public boolean isInit;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public boolean mAdjustViewBounds;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public boolean isZoonUp;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public boolean canRotate;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public boolean imgLargeWidth;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public boolean imgLargeHeight;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    public float mRotateFlag;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    public float mDegrees;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    public float mScale;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    public int mTranslateX;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int mTranslateY;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    public float mHalfBaseRectWidth;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    public float mHalfBaseRectHeight;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public final RectF mWidgetRect;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    @NotNull
    public final RectF mBaseRect;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    @NotNull
    public final RectF mImgRect;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    @NotNull
    public final RectF mTmpRect;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    @NotNull
    public final RectF mCommonRect;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    @NotNull
    public final PointF mScreenCenter;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    @NotNull
    public final PointF mScaleCenter;

    /* JADX INFO: renamed from: a0, reason: from kotlin metadata */
    @NotNull
    public final PointF mRotateCenter;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int MIN_ROTATE;

    /* JADX INFO: renamed from: b0, reason: from kotlin metadata */
    @NotNull
    public final i mTranslate;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int ANIMA_DURING;

    /* JADX INFO: renamed from: c0, reason: from kotlin metadata */
    @Nullable
    public RectF mClip;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final float MAX_SCALE;

    /* JADX INFO: renamed from: d0, reason: from kotlin metadata */
    @Nullable
    public e.a.a.g.m.m.b.a mFromInfo;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int mMinRotate;

    /* JADX INFO: renamed from: e0, reason: from kotlin metadata */
    public long mInfoTime;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int mAnimaDuring;

    /* JADX INFO: renamed from: f0, reason: from kotlin metadata */
    @Nullable
    public Runnable mCompleteCallBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public float mMaxScale;

    /* JADX INFO: renamed from: g0, reason: from kotlin metadata */
    @Nullable
    public View.OnLongClickListener mLongClick;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int MAX_OVER_SCROLL;

    /* JADX INFO: renamed from: h0, reason: from kotlin metadata */
    @NotNull
    public final f mRotateListener;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int MAX_FLING_OVER_SCROLL;

    /* JADX INFO: renamed from: i0, reason: from kotlin metadata */
    @NotNull
    public final c mGestureListener;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int MAX_OVER_RESISTANCE;

    /* JADX INFO: renamed from: j0, reason: from kotlin metadata */
    @NotNull
    public final h mScaleListener;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int MAX_ANIM_FROM_WAITE;

    /* JADX INFO: renamed from: k0, reason: from kotlin metadata */
    @NotNull
    public final Runnable mClickRunnable;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Matrix mBaseMatrix;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final Matrix mAnimMatrix;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final Matrix mSynthesisMatrix;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final Matrix mTmpMatrix;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final e.a.a.g.m.m.b.c mRotateDetector;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final GestureDetector mDetector;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final ScaleGestureDetector mScaleDetector;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @Nullable
    public View.OnClickListener mClickListener;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Nullable
    public ImageView.ScaleType mScaleType;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean hasMultiTouch;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public boolean hasDrawable;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public boolean isKnowSize;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public boolean hasOverTranslate;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public boolean isEnable;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public boolean isRotateEnable;

    /* JADX INFO: compiled from: PhotoView.kt */
    public interface a {
        float a();
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public final class b implements a {
        public final /* synthetic */ PhotoView a;

        public b(PhotoView photoView) {
            f.c0.c.j.e(photoView, "this$0");
            this.a = photoView;
        }

        @Override // io.legado.app.ui.widget.image.PhotoView.a
        public float a() {
            return this.a.mImgRect.bottom;
        }
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public final class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ PhotoView a;

        public c(PhotoView photoView) {
            f.c0.c.j.e(photoView, "this$0");
            this.a = photoView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent motionEvent) {
            float f2;
            float f3;
            f.c0.c.j.e(motionEvent, "e");
            this.a.mTranslate.c();
            RectF rectF = this.a.mImgRect;
            float f4 = 2;
            float fWidth = (rectF.width() / f4) + rectF.left;
            RectF rectF2 = this.a.mImgRect;
            float fHeight = (rectF2.height() / f4) + rectF2.top;
            this.a.mScaleCenter.set(fWidth, fHeight);
            this.a.mRotateCenter.set(fWidth, fHeight);
            PhotoView photoView = this.a;
            photoView.mTranslateX = 0;
            photoView.mTranslateY = 0;
            if (photoView.isZoonUp) {
                f2 = photoView.mScale;
                f3 = 1.0f;
            } else {
                float f5 = photoView.mScale;
                float f6 = photoView.mMaxScale;
                photoView.mScaleCenter.set(motionEvent.getX(), motionEvent.getY());
                f2 = f5;
                f3 = f6;
            }
            this.a.mTmpMatrix.reset();
            PhotoView photoView2 = this.a;
            Matrix matrix = photoView2.mTmpMatrix;
            RectF rectF3 = photoView2.mBaseRect;
            matrix.postTranslate(-rectF3.left, -rectF3.top);
            PhotoView photoView3 = this.a;
            Matrix matrix2 = photoView3.mTmpMatrix;
            PointF pointF = photoView3.mRotateCenter;
            matrix2.postTranslate(pointF.x, pointF.y);
            PhotoView photoView4 = this.a;
            photoView4.mTmpMatrix.postTranslate(-photoView4.mHalfBaseRectWidth, -photoView4.mHalfBaseRectHeight);
            PhotoView photoView5 = this.a;
            Matrix matrix3 = photoView5.mTmpMatrix;
            float f7 = photoView5.mDegrees;
            PointF pointF2 = photoView5.mRotateCenter;
            matrix3.postRotate(f7, pointF2.x, pointF2.y);
            PhotoView photoView6 = this.a;
            Matrix matrix4 = photoView6.mTmpMatrix;
            PointF pointF3 = photoView6.mScaleCenter;
            matrix4.postScale(f3, f3, pointF3.x, pointF3.y);
            this.a.mTmpMatrix.postTranslate(r2.mTranslateX, r2.mTranslateY);
            PhotoView photoView7 = this.a;
            photoView7.mTmpMatrix.mapRect(photoView7.mTmpRect, photoView7.mBaseRect);
            PhotoView photoView8 = this.a;
            photoView8.f(photoView8.mTmpRect);
            PhotoView photoView9 = this.a;
            photoView9.isZoonUp = !photoView9.isZoonUp;
            photoView9.mTranslate.e(f2, f3);
            this.a.mTranslate.b();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent motionEvent) {
            f.c0.c.j.e(motionEvent, "e");
            PhotoView photoView = this.a;
            photoView.hasOverTranslate = false;
            photoView.hasMultiTouch = false;
            photoView.canRotate = false;
            photoView.removeCallbacks(photoView.mClickRunnable);
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onFling(@org.jetbrains.annotations.NotNull android.view.MotionEvent r29, @org.jetbrains.annotations.NotNull android.view.MotionEvent r30, float r31, float r32) {
            /*
                Method dump skipped, instruction units count: 437
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.widget.image.PhotoView.c.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NotNull MotionEvent motionEvent) {
            f.c0.c.j.e(motionEvent, "e");
            PhotoView photoView = this.a;
            View.OnLongClickListener onLongClickListener = photoView.mLongClick;
            if (onLongClickListener == null) {
                return;
            }
            onLongClickListener.onLongClick(photoView);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent2, float f2, float f3) {
            f.c0.c.j.e(motionEvent, "e1");
            f.c0.c.j.e(motionEvent2, "e2");
            i iVar = this.a.mTranslate;
            if (iVar.a) {
                iVar.c();
            }
            if (this.a.d(f2)) {
                if (f2 < 0.0f) {
                    PhotoView photoView = this.a;
                    float f4 = photoView.mImgRect.left;
                    if (f4 - f2 > photoView.mWidgetRect.left) {
                        f2 = f4;
                    }
                }
                if (f2 > 0.0f) {
                    PhotoView photoView2 = this.a;
                    float f5 = photoView2.mImgRect.right;
                    float f6 = f5 - f2;
                    float f7 = photoView2.mWidgetRect.right;
                    if (f6 < f7) {
                        f2 = f5 - f7;
                    }
                }
                this.a.mAnimMatrix.postTranslate(-f2, 0.0f);
                this.a.mTranslateX -= (int) f2;
            } else {
                PhotoView photoView3 = this.a;
                if (photoView3.imgLargeWidth || photoView3.hasMultiTouch || photoView3.hasOverTranslate) {
                    PhotoView.a(photoView3);
                    PhotoView photoView4 = this.a;
                    if (!photoView4.hasMultiTouch) {
                        if (f2 < 0.0f) {
                            float f8 = photoView4.mImgRect.left;
                            float f9 = f8 - f2;
                            float f10 = photoView4.mCommonRect.left;
                            if (f9 > f10) {
                                f2 = PhotoView.b(photoView4, f8 - f10, f2);
                            }
                        }
                        if (f2 > 0.0f) {
                            PhotoView photoView5 = this.a;
                            float f11 = photoView5.mImgRect.right;
                            float f12 = f11 - f2;
                            float f13 = photoView5.mCommonRect.right;
                            if (f12 < f13) {
                                f2 = PhotoView.b(photoView5, f11 - f13, f2);
                            }
                        }
                    }
                    PhotoView photoView6 = this.a;
                    photoView6.mTranslateX -= (int) f2;
                    photoView6.mAnimMatrix.postTranslate(-f2, 0.0f);
                    this.a.hasOverTranslate = true;
                }
            }
            if (this.a.e(f3)) {
                if (f3 < 0.0f) {
                    PhotoView photoView7 = this.a;
                    float f14 = photoView7.mImgRect.top;
                    if (f14 - f3 > photoView7.mWidgetRect.top) {
                        f3 = f14;
                    }
                }
                if (f3 > 0.0f) {
                    PhotoView photoView8 = this.a;
                    float f15 = photoView8.mImgRect.bottom;
                    float f16 = f15 - f3;
                    float f17 = photoView8.mWidgetRect.bottom;
                    if (f16 < f17) {
                        f3 = f15 - f17;
                    }
                }
                this.a.mAnimMatrix.postTranslate(0.0f, -f3);
                this.a.mTranslateY -= (int) f3;
            } else {
                PhotoView photoView9 = this.a;
                if (photoView9.imgLargeHeight || photoView9.hasOverTranslate || photoView9.hasMultiTouch) {
                    PhotoView.a(photoView9);
                    PhotoView photoView10 = this.a;
                    if (!photoView10.hasMultiTouch) {
                        if (f3 < 0.0f) {
                            float f18 = photoView10.mImgRect.top;
                            float f19 = f18 - f3;
                            float f20 = photoView10.mCommonRect.top;
                            if (f19 > f20) {
                                f3 = PhotoView.c(photoView10, f18 - f20, f3);
                            }
                        }
                        if (f3 > 0.0f) {
                            PhotoView photoView11 = this.a;
                            float f21 = photoView11.mImgRect.bottom;
                            float f22 = f21 - f3;
                            float f23 = photoView11.mCommonRect.bottom;
                            if (f22 < f23) {
                                f3 = PhotoView.c(photoView11, f21 - f23, f3);
                            }
                        }
                    }
                    this.a.mAnimMatrix.postTranslate(0.0f, -f3);
                    PhotoView photoView12 = this.a;
                    photoView12.mTranslateY -= (int) f3;
                    photoView12.hasOverTranslate = true;
                }
            }
            this.a.g();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent motionEvent) {
            f.c0.c.j.e(motionEvent, "e");
            PhotoView photoView = this.a;
            photoView.postDelayed(photoView.mClickRunnable, 250L);
            return false;
        }
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public final class d implements Interpolator {

        @Nullable
        public Interpolator a;

        public d(PhotoView photoView) {
            f.c0.c.j.e(photoView, "this$0");
            this.a = new DecelerateInterpolator();
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            Interpolator interpolator = this.a;
            return interpolator == null ? f2 : interpolator.getInterpolation(f2);
        }
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public final class e implements a {
        public final /* synthetic */ PhotoView a;

        public e(PhotoView photoView) {
            f.c0.c.j.e(photoView, "this$0");
            this.a = photoView;
        }

        @Override // io.legado.app.ui.widget.image.PhotoView.a
        public float a() {
            RectF rectF = this.a.mImgRect;
            return (rectF.top + rectF.bottom) / 2;
        }
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public final class f implements e.a.a.g.m.m.b.b {
        public final /* synthetic */ PhotoView a;

        public f(PhotoView photoView) {
            f.c0.c.j.e(photoView, "this$0");
            this.a = photoView;
        }

        @Override // e.a.a.g.m.m.b.b
        public void a(float f2, float f3, float f4) {
            PhotoView photoView = this.a;
            float f5 = photoView.mRotateFlag + f2;
            photoView.mRotateFlag = f5;
            if (photoView.canRotate) {
                photoView.mDegrees += f2;
                photoView.mAnimMatrix.postRotate(f2, f3, f4);
                return;
            }
            float fAbs = Math.abs(f5);
            PhotoView photoView2 = this.a;
            if (fAbs >= photoView2.mMinRotate) {
                photoView2.canRotate = true;
                photoView2.mRotateFlag = 0.0f;
            }
        }
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public final class g implements a {
        public final /* synthetic */ PhotoView a;

        public g(PhotoView photoView) {
            f.c0.c.j.e(photoView, "this$0");
            this.a = photoView;
        }

        @Override // io.legado.app.ui.widget.image.PhotoView.a
        public float a() {
            return this.a.mImgRect.top;
        }
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public final class h implements ScaleGestureDetector.OnScaleGestureListener {
        public final /* synthetic */ PhotoView a;

        public h(PhotoView photoView) {
            f.c0.c.j.e(photoView, "this$0");
            this.a = photoView;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(@NotNull ScaleGestureDetector scaleGestureDetector) {
            f.c0.c.j.e(scaleGestureDetector, "detector");
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            PhotoView photoView = this.a;
            photoView.mScale *= scaleFactor;
            photoView.mAnimMatrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            this.a.g();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(@NotNull ScaleGestureDetector scaleGestureDetector) {
            f.c0.c.j.e(scaleGestureDetector, "detector");
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(@NotNull ScaleGestureDetector scaleGestureDetector) {
            f.c0.c.j.e(scaleGestureDetector, "detector");
        }
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public final class i implements Runnable {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public OverScroller f7716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public OverScroller f7717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public Scroller f7718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public Scroller f7719e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public Scroller f7720f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public a f7721g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7722h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7723i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7724j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7725k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NotNull
        public RectF f7726l;

        @NotNull
        public d m;
        public final /* synthetic */ PhotoView n;

        public i(PhotoView photoView) {
            f.c0.c.j.e(photoView, "this$0");
            this.n = photoView;
            this.f7726l = new RectF();
            this.m = new d(photoView);
            Context context = photoView.getContext();
            f.c0.c.j.d(context, com.umeng.analytics.pro.c.R);
            this.f7716b = new OverScroller(context, this.m);
            this.f7718d = new Scroller(context, this.m);
            this.f7717c = new OverScroller(context, this.m);
            this.f7719e = new Scroller(context, this.m);
            this.f7720f = new Scroller(context, this.m);
        }

        public final void a() {
            this.n.mAnimMatrix.reset();
            PhotoView photoView = this.n;
            Matrix matrix = photoView.mAnimMatrix;
            RectF rectF = photoView.mBaseRect;
            matrix.postTranslate(-rectF.left, -rectF.top);
            PhotoView photoView2 = this.n;
            Matrix matrix2 = photoView2.mAnimMatrix;
            PointF pointF = photoView2.mRotateCenter;
            matrix2.postTranslate(pointF.x, pointF.y);
            PhotoView photoView3 = this.n;
            photoView3.mAnimMatrix.postTranslate(-photoView3.mHalfBaseRectWidth, -photoView3.mHalfBaseRectHeight);
            PhotoView photoView4 = this.n;
            Matrix matrix3 = photoView4.mAnimMatrix;
            float f2 = photoView4.mDegrees;
            PointF pointF2 = photoView4.mRotateCenter;
            matrix3.postRotate(f2, pointF2.x, pointF2.y);
            PhotoView photoView5 = this.n;
            Matrix matrix4 = photoView5.mAnimMatrix;
            float f3 = photoView5.mScale;
            PointF pointF3 = photoView5.mScaleCenter;
            matrix4.postScale(f3, f3, pointF3.x, pointF3.y);
            this.n.mAnimMatrix.postTranslate(r0.mTranslateX, r0.mTranslateY);
            this.n.g();
        }

        public final void b() {
            this.a = true;
            this.n.post(this);
        }

        public final void c() {
            this.n.removeCallbacks(this);
            this.f7716b.abortAnimation();
            this.f7718d.abortAnimation();
            this.f7717c.abortAnimation();
            this.f7720f.abortAnimation();
            this.a = false;
        }

        public final void d(int i2, int i3) {
            this.f7720f.startScroll(i2, 0, i3 - i2, 0, this.n.getMAnimaDuring());
        }

        public final void e(float f2, float f3) {
            float f4 = 10000;
            this.f7718d.startScroll((int) (f2 * f4), 0, (int) ((f3 - f2) * f4), 0, this.n.getMAnimaDuring());
        }

        public final void f(int i2, int i3) {
            this.f7724j = 0;
            this.f7725k = 0;
            this.f7716b.startScroll(0, 0, i2, i3, this.n.getMAnimaDuring());
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2 = true;
            boolean z3 = false;
            if (this.f7718d.computeScrollOffset()) {
                this.n.mScale = this.f7718d.getCurrX() / 10000.0f;
                z = false;
            } else {
                z = true;
            }
            if (this.f7716b.computeScrollOffset()) {
                int currX = this.f7716b.getCurrX() - this.f7724j;
                int currY = this.f7716b.getCurrY() - this.f7725k;
                PhotoView photoView = this.n;
                photoView.mTranslateX += currX;
                photoView.mTranslateY += currY;
                this.f7724j = this.f7716b.getCurrX();
                this.f7725k = this.f7716b.getCurrY();
                z = false;
            }
            if (this.f7717c.computeScrollOffset()) {
                int currX2 = this.f7717c.getCurrX() - this.f7722h;
                int currY2 = this.f7717c.getCurrY() - this.f7723i;
                this.f7722h = this.f7717c.getCurrX();
                this.f7723i = this.f7717c.getCurrY();
                PhotoView photoView2 = this.n;
                photoView2.mTranslateX += currX2;
                photoView2.mTranslateY += currY2;
                z = false;
            }
            if (this.f7720f.computeScrollOffset()) {
                this.n.mDegrees = this.f7720f.getCurrX();
                z = false;
            }
            if (this.f7719e.computeScrollOffset() || this.n.mClip != null) {
                float currX3 = this.f7719e.getCurrX() / 10000.0f;
                float currY3 = this.f7719e.getCurrY() / 10000.0f;
                PhotoView photoView3 = this.n;
                Matrix matrix = photoView3.mTmpMatrix;
                RectF rectF = photoView3.mImgRect;
                float f2 = (rectF.left + rectF.right) / 2;
                a aVar = this.f7721g;
                f.c0.c.j.c(aVar);
                matrix.setScale(currX3, currY3, f2, aVar.a());
                PhotoView photoView4 = this.n;
                photoView4.mTmpMatrix.mapRect(this.f7726l, photoView4.mImgRect);
                if (currX3 == 1.0f) {
                    RectF rectF2 = this.f7726l;
                    RectF rectF3 = this.n.mWidgetRect;
                    rectF2.left = rectF3.left;
                    rectF2.right = rectF3.right;
                }
                if (currY3 == 1.0f) {
                    RectF rectF4 = this.f7726l;
                    RectF rectF5 = this.n.mWidgetRect;
                    rectF4.top = rectF5.top;
                    rectF4.bottom = rectF5.bottom;
                }
                this.n.mClip = this.f7726l;
            }
            if (!z) {
                a();
                if (this.a) {
                    this.n.post(this);
                    return;
                }
                return;
            }
            this.a = false;
            PhotoView photoView5 = this.n;
            if (photoView5.imgLargeWidth) {
                RectF rectF6 = photoView5.mImgRect;
                float f3 = rectF6.left;
                if (f3 > 0.0f) {
                    photoView5.mTranslateX -= (int) f3;
                } else if (rectF6.right < photoView5.mWidgetRect.width()) {
                    PhotoView photoView6 = this.n;
                    photoView6.mTranslateX -= (int) (photoView6.mWidgetRect.width() - this.n.mImgRect.right);
                }
                z3 = true;
            }
            PhotoView photoView7 = this.n;
            if (photoView7.imgLargeHeight) {
                RectF rectF7 = photoView7.mImgRect;
                float f4 = rectF7.top;
                if (f4 > 0.0f) {
                    photoView7.mTranslateY -= (int) f4;
                } else if (rectF7.bottom < photoView7.mWidgetRect.height()) {
                    PhotoView photoView8 = this.n;
                    photoView8.mTranslateY -= (int) (photoView8.mWidgetRect.height() - this.n.mImgRect.bottom);
                }
            } else {
                z2 = z3;
            }
            if (z2) {
                a();
            }
            this.n.invalidate();
            PhotoView photoView9 = this.n;
            Runnable runnable = photoView9.mCompleteCallBack;
            if (runnable == null) {
                return;
            }
            runnable.run();
            photoView9.mCompleteCallBack = null;
        }
    }

    /* JADX INFO: compiled from: PhotoView.kt */
    public /* synthetic */ class j {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            iArr[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            iArr[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoView(@NotNull Context context) {
        this(context, null);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
    }

    public static final void a(PhotoView photoView) {
        if (photoView.hasOverTranslate) {
            return;
        }
        RectF rectF = photoView.mWidgetRect;
        RectF rectF2 = photoView.mImgRect;
        RectF rectF3 = photoView.mCommonRect;
        float f2 = rectF.left;
        float f3 = rectF2.left;
        if (f2 <= f3) {
            f2 = f3;
        }
        float f4 = rectF.right;
        float f5 = rectF2.right;
        if (f4 >= f5) {
            f4 = f5;
        }
        if (f2 > f4) {
            rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        float f6 = rectF.top;
        float f7 = rectF2.top;
        if (f6 <= f7) {
            f6 = f7;
        }
        float f8 = rectF.bottom;
        float f9 = rectF2.bottom;
        if (f8 >= f9) {
            f8 = f9;
        }
        if (f6 > f8) {
            rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            rectF3.set(f2, f6, f4, f8);
        }
    }

    public static final float b(PhotoView photoView, float f2, float f3) {
        Objects.requireNonNull(photoView);
        return (Math.abs(Math.abs(f2) - photoView.MAX_OVER_RESISTANCE) / photoView.MAX_OVER_RESISTANCE) * f3;
    }

    public static final float c(PhotoView photoView, float f2, float f3) {
        Objects.requireNonNull(photoView);
        return (Math.abs(Math.abs(f2) - photoView.MAX_OVER_RESISTANCE) / photoView.MAX_OVER_RESISTANCE) * f3;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        if (this.hasMultiTouch) {
            return true;
        }
        return d(direction);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        if (this.hasMultiTouch) {
            return true;
        }
        return e(direction);
    }

    public final boolean d(float direction) {
        if (this.mImgRect.width() <= this.mWidgetRect.width()) {
            return false;
        }
        if (direction >= 0.0f || c.b.a.m.f.S4(this.mImgRect.left) - direction < this.mWidgetRect.left) {
            return direction <= 0.0f || ((float) c.b.a.m.f.S4(this.mImgRect.right)) - direction > this.mWidgetRect.right;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.widget.image.PhotoView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        f.c0.c.j.e(canvas, "canvas");
        RectF rectF = this.mClip;
        if (rectF != null) {
            canvas.clipRect(rectF);
            this.mClip = null;
        }
        super.draw(canvas);
    }

    public final boolean e(float direction) {
        if (this.mImgRect.height() <= this.mWidgetRect.height()) {
            return false;
        }
        if (direction >= 0.0f || c.b.a.m.f.S4(this.mImgRect.top) - direction < this.mWidgetRect.top) {
            return direction <= 0.0f || ((float) c.b.a.m.f.S4(this.mImgRect.bottom)) - direction > this.mWidgetRect.bottom;
        }
        return false;
    }

    public final void f(RectF imgRect) {
        float f2;
        int i2;
        float f3;
        int i3 = 0;
        if (imgRect.width() <= this.mWidgetRect.width()) {
            float f4 = 2;
            if (!(Math.abs(((float) c.b.a.m.f.S4(imgRect.left)) - ((this.mWidgetRect.width() - imgRect.width()) / f4)) < 1.0f)) {
                f2 = -(((this.mWidgetRect.width() - imgRect.width()) / f4) - imgRect.left);
                i2 = (int) f2;
            }
            i2 = 0;
        } else {
            float f5 = imgRect.left;
            RectF rectF = this.mWidgetRect;
            float f6 = rectF.left;
            if (f5 > f6) {
                f2 = f5 - f6;
            } else {
                float f7 = imgRect.right;
                float f8 = rectF.right;
                if (f7 < f8) {
                    f2 = f7 - f8;
                }
                i2 = 0;
            }
            i2 = (int) f2;
        }
        if (imgRect.height() <= this.mWidgetRect.height()) {
            float f9 = 2;
            if (!(Math.abs(((float) c.b.a.m.f.S4(imgRect.top)) - ((this.mWidgetRect.height() - imgRect.height()) / f9)) < 1.0f)) {
                f3 = -(((this.mWidgetRect.height() - imgRect.height()) / f9) - imgRect.top);
                i3 = (int) f3;
            }
        } else {
            float f10 = imgRect.top;
            RectF rectF2 = this.mWidgetRect;
            float f11 = rectF2.top;
            if (f10 > f11) {
                i3 = (int) (f10 - f11);
            } else {
                float f12 = imgRect.bottom;
                float f13 = rectF2.bottom;
                if (f12 < f13) {
                    f3 = f12 - f13;
                    i3 = (int) f3;
                }
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (!this.mTranslate.f7717c.isFinished()) {
            this.mTranslate.f7717c.abortAnimation();
        }
        this.mTranslate.f(-i2, -i3);
    }

    public final void g() {
        this.mSynthesisMatrix.set(this.mBaseMatrix);
        this.mSynthesisMatrix.postConcat(this.mAnimMatrix);
        setImageMatrix(this.mSynthesisMatrix);
        this.mAnimMatrix.mapRect(this.mImgRect, this.mBaseRect);
        this.imgLargeWidth = this.mImgRect.width() > this.mWidgetRect.width();
        this.imgLargeHeight = this.mImgRect.height() > this.mWidgetRect.height();
    }

    public final int getANIMA_DURING() {
        return this.ANIMA_DURING;
    }

    /* JADX INFO: renamed from: getAnimDuring, reason: from getter */
    public final int getMAnimaDuring() {
        return this.mAnimaDuring;
    }

    public final int getDefaultAnimDuring() {
        return this.ANIMA_DURING;
    }

    @NotNull
    public final e.a.a.g.m.m.b.a getInfo() {
        RectF rectF = new RectF();
        int[] iArr = {getLeft() + i, getTop() + i};
        int i2 = iArr[0];
        int i3 = iArr[1];
        Object parent = getParent();
        f.c0.c.j.d(parent, "target.parent");
        while (true) {
            if (!(parent instanceof View)) {
                iArr[0] = (int) (iArr[0] + 0.5f);
                iArr[1] = (int) (iArr[1] + 0.5f);
                break;
            }
            View view = (View) parent;
            if (view.getId() == R.id.content) {
                break;
            }
            iArr[0] = iArr[0] - view.getScrollX();
            iArr[1] = iArr[1] - view.getScrollY();
            iArr[0] = view.getLeft() + iArr[0];
            iArr[1] = view.getTop() + iArr[1];
            parent = view.getParent();
            f.c0.c.j.d(parent, "view.parent");
        }
        float f2 = iArr[0];
        RectF rectF2 = this.mImgRect;
        rectF.set(f2 + rectF2.left, iArr[1] + rectF2.top, iArr[0] + rectF2.right, iArr[1] + rectF2.bottom);
        return new e.a.a.g.m.m.b.a(rectF, this.mImgRect, this.mWidgetRect, this.mBaseRect, this.mScreenCenter, this.mScale, this.mDegrees, this.mScaleType);
    }

    public final int getMAX_ANIM_FROM_WAITE() {
        return this.MAX_ANIM_FROM_WAITE;
    }

    public final int getMAX_FLING_OVER_SCROLL() {
        return this.MAX_FLING_OVER_SCROLL;
    }

    public final int getMAX_OVER_RESISTANCE() {
        return this.MAX_OVER_RESISTANCE;
    }

    public final int getMAX_OVER_SCROLL() {
        return this.MAX_OVER_SCROLL;
    }

    public final float getMAX_SCALE() {
        return this.MAX_SCALE;
    }

    public final int getMAnimaDuring() {
        return this.mAnimaDuring;
    }

    public final int getMIN_ROTATE() {
        return this.MIN_ROTATE;
    }

    /* JADX INFO: renamed from: getMaxScale, reason: from getter */
    public final float getMMaxScale() {
        return this.mMaxScale;
    }

    public final int h(Drawable d2) {
        int intrinsicHeight = d2.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = d2.getMinimumHeight();
        }
        return intrinsicHeight <= 0 ? d2.getBounds().height() : intrinsicHeight;
    }

    public final int i(Drawable d2) {
        int intrinsicWidth = d2.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = d2.getMinimumWidth();
        }
        return intrinsicWidth <= 0 ? d2.getBounds().width() : intrinsicWidth;
    }

    public final void j() {
        if (this.hasDrawable && this.isKnowSize) {
            this.mBaseMatrix.reset();
            this.mAnimMatrix.reset();
            this.isZoonUp = false;
            Drawable drawable = getDrawable();
            int width = getWidth();
            int height = getHeight();
            f.c0.c.j.d(drawable, "img");
            int i2 = i(drawable);
            int iH = h(drawable);
            float f2 = i2;
            float f3 = iH;
            this.mBaseRect.set(0.0f, 0.0f, f2, f3);
            int i3 = (width - i2) / 2;
            int i4 = (height - iH) / 2;
            float f4 = i2 > width ? width / f2 : 1.0f;
            float f5 = iH > height ? height / f3 : 1.0f;
            if (f4 >= f5) {
                f4 = f5;
            }
            this.mBaseMatrix.reset();
            this.mBaseMatrix.postTranslate(i3, i4);
            Matrix matrix = this.mBaseMatrix;
            PointF pointF = this.mScreenCenter;
            matrix.postScale(f4, f4, pointF.x, pointF.y);
            this.mBaseMatrix.mapRect(this.mBaseRect);
            float f6 = 2;
            this.mHalfBaseRectWidth = this.mBaseRect.width() / f6;
            this.mHalfBaseRectHeight = this.mBaseRect.height() / f6;
            this.mScaleCenter.set(this.mScreenCenter);
            this.mRotateCenter.set(this.mScaleCenter);
            g();
            ImageView.ScaleType scaleType = this.mScaleType;
            switch (scaleType == null ? -1 : j.a[scaleType.ordinal()]) {
                case 1:
                    if (this.hasDrawable && this.isKnowSize) {
                        Drawable drawable2 = getDrawable();
                        f.c0.c.j.d(drawable2, "img");
                        int i5 = i(drawable2);
                        int iH2 = h(drawable2);
                        float f7 = i5;
                        if (f7 > this.mWidgetRect.width() || iH2 > this.mWidgetRect.height()) {
                            float fWidth = f7 / this.mImgRect.width();
                            float fHeight = iH2 / this.mImgRect.height();
                            if (fWidth <= fHeight) {
                                fWidth = fHeight;
                            }
                            this.mScale = fWidth;
                            Matrix matrix2 = this.mAnimMatrix;
                            PointF pointF2 = this.mScreenCenter;
                            matrix2.postScale(fWidth, fWidth, pointF2.x, pointF2.y);
                            g();
                            l();
                        }
                    }
                    break;
                case 2:
                    if (this.mImgRect.width() < this.mWidgetRect.width() || this.mImgRect.height() < this.mWidgetRect.height()) {
                        float fWidth2 = this.mWidgetRect.width() / this.mImgRect.width();
                        float fHeight2 = this.mWidgetRect.height() / this.mImgRect.height();
                        if (fWidth2 <= fHeight2) {
                            fWidth2 = fHeight2;
                        }
                        this.mScale = fWidth2;
                        Matrix matrix3 = this.mAnimMatrix;
                        PointF pointF3 = this.mScreenCenter;
                        matrix3.postScale(fWidth2, fWidth2, pointF3.x, pointF3.y);
                        g();
                        l();
                    }
                    break;
                case 3:
                    if (this.mImgRect.width() > this.mWidgetRect.width() || this.mImgRect.height() > this.mWidgetRect.height()) {
                        float fWidth3 = this.mWidgetRect.width() / this.mImgRect.width();
                        float fHeight3 = this.mWidgetRect.height() / this.mImgRect.height();
                        if (fWidth3 >= fHeight3) {
                            fWidth3 = fHeight3;
                        }
                        this.mScale = fWidth3;
                        Matrix matrix4 = this.mAnimMatrix;
                        PointF pointF4 = this.mScreenCenter;
                        matrix4.postScale(fWidth3, fWidth3, pointF4.x, pointF4.y);
                        g();
                        l();
                    }
                    break;
                case 4:
                    k();
                    break;
                case 5:
                    k();
                    float f8 = -this.mImgRect.top;
                    this.mAnimMatrix.postTranslate(0.0f, f8);
                    g();
                    l();
                    this.mTranslateY += (int) f8;
                    break;
                case 6:
                    k();
                    float f9 = this.mWidgetRect.bottom - this.mImgRect.bottom;
                    this.mTranslateY += (int) f9;
                    this.mAnimMatrix.postTranslate(0.0f, f9);
                    g();
                    l();
                    break;
                case 7:
                    float fWidth4 = this.mWidgetRect.width() / this.mImgRect.width();
                    float fHeight4 = this.mWidgetRect.height() / this.mImgRect.height();
                    Matrix matrix5 = this.mAnimMatrix;
                    PointF pointF5 = this.mScreenCenter;
                    matrix5.postScale(fWidth4, fHeight4, pointF5.x, pointF5.y);
                    g();
                    l();
                    break;
            }
            this.isInit = true;
            e.a.a.g.m.m.b.a aVar = this.mFromInfo;
            if (aVar != null && System.currentTimeMillis() - this.mInfoTime < getMAX_ANIM_FROM_WAITE()) {
                f.c0.c.j.e(aVar, "info");
                if (this.isInit) {
                    this.mAnimMatrix.reset();
                    g();
                    this.mScale = 1.0f;
                    this.mTranslateX = 0;
                    this.mTranslateY = 0;
                    e.a.a.g.m.m.b.a info = getInfo();
                    float fWidth5 = aVar.f5926b.width() / info.f5926b.width();
                    float fHeight5 = aVar.f5926b.height() / info.f5926b.height();
                    if (fWidth5 >= fHeight5) {
                        fWidth5 = fHeight5;
                    }
                    RectF rectF = aVar.a;
                    float fWidth6 = (rectF.width() / f6) + rectF.left;
                    RectF rectF2 = aVar.a;
                    float fHeight6 = (rectF2.height() / f6) + rectF2.top;
                    RectF rectF3 = info.a;
                    float fWidth7 = (rectF3.width() / f6) + rectF3.left;
                    RectF rectF4 = info.a;
                    float fHeight7 = (rectF4.height() / f6) + rectF4.top;
                    this.mAnimMatrix.reset();
                    float f10 = fWidth6 - fWidth7;
                    float f11 = fHeight6 - fHeight7;
                    this.mAnimMatrix.postTranslate(f10, f11);
                    this.mAnimMatrix.postScale(fWidth5, fWidth5, fWidth6, fHeight6);
                    this.mAnimMatrix.postRotate(aVar.f5930f, fWidth6, fHeight6);
                    g();
                    this.mScaleCenter.set(fWidth6, fHeight6);
                    this.mRotateCenter.set(fWidth6, fHeight6);
                    this.mTranslate.f((int) (-f10), (int) (-f11));
                    this.mTranslate.e(fWidth5, 1.0f);
                    this.mTranslate.d((int) aVar.f5930f, 0);
                    if (aVar.f5927c.width() < aVar.f5926b.width() || aVar.f5927c.height() < aVar.f5926b.height()) {
                        float fWidth8 = aVar.f5927c.width() / aVar.f5926b.width();
                        float fHeight8 = aVar.f5927c.height() / aVar.f5926b.height();
                        if (fWidth8 > 1.0f) {
                            fWidth8 = 1.0f;
                        }
                        float f12 = fHeight8 <= 1.0f ? fHeight8 : 1.0f;
                        ImageView.ScaleType scaleType2 = aVar.f5931g;
                        a gVar = scaleType2 == ImageView.ScaleType.FIT_START ? new g(this) : scaleType2 == ImageView.ScaleType.FIT_END ? new b(this) : new e(this);
                        i iVar = this.mTranslate;
                        float f13 = 1;
                        float f14 = 10000;
                        iVar.f7719e.startScroll((int) (fWidth8 * f14), (int) (f12 * f14), (int) ((f13 - fWidth8) * f14), (int) ((f13 - f12) * f14), this.mAnimaDuring / 3);
                        iVar.f7721g = gVar;
                        Matrix matrix6 = this.mTmpMatrix;
                        RectF rectF5 = this.mImgRect;
                        matrix6.setScale(fWidth8, f12, (rectF5.left + rectF5.right) / f6, gVar.a());
                        this.mTmpMatrix.mapRect(this.mTranslate.f7726l, this.mImgRect);
                        this.mClip = this.mTranslate.f7726l;
                    }
                    this.mTranslate.b();
                } else {
                    this.mFromInfo = aVar;
                    this.mInfoTime = System.currentTimeMillis();
                }
            }
            this.mFromInfo = null;
        }
    }

    public final void k() {
        if (this.mImgRect.width() < this.mWidgetRect.width()) {
            float fWidth = this.mWidgetRect.width() / this.mImgRect.width();
            this.mScale = fWidth;
            Matrix matrix = this.mAnimMatrix;
            PointF pointF = this.mScreenCenter;
            matrix.postScale(fWidth, fWidth, pointF.x, pointF.y);
            g();
            l();
        }
    }

    public final void l() {
        f.c0.c.j.d(getDrawable(), "img");
        this.mBaseRect.set(0.0f, 0.0f, i(r0), h(r0));
        this.mBaseMatrix.set(this.mSynthesisMatrix);
        this.mBaseMatrix.mapRect(this.mBaseRect);
        float f2 = 2;
        this.mHalfBaseRectWidth = this.mBaseRect.width() / f2;
        this.mHalfBaseRectHeight = this.mBaseRect.height() / f2;
        this.mScale = 1.0f;
        this.mTranslateX = 0;
        this.mTranslateY = 0;
        this.mAnimMatrix.reset();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!this.hasDrawable) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        Drawable drawable = getDrawable();
        f.c0.c.j.d(drawable, "d");
        int i2 = i(drawable);
        int iH = h(drawable);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i3 = layoutParams.width;
        if (i3 != -1 ? mode == Integer.MIN_VALUE ? i2 <= size : mode != 1073741824 : mode == 0) {
            size = i2;
        }
        int i4 = layoutParams.height;
        if (i4 != -1 ? mode2 == Integer.MIN_VALUE ? iH <= size2 : mode2 != 1073741824 : mode2 == 0) {
            size2 = iH;
        }
        if (this.mAdjustViewBounds) {
            float f2 = i2;
            float f3 = iH;
            float f4 = size;
            float f5 = size2;
            if (!(f2 / f3 == f4 / f5)) {
                float f6 = f5 / f3;
                float f7 = f4 / f2;
                if (f6 >= f7) {
                    f6 = f7;
                }
                if (i3 != -1) {
                    size = (int) (f2 * f6);
                }
                if (i4 != -1) {
                    size2 = (int) (f3 * f6);
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        float f2 = w;
        float f3 = h2;
        this.mWidgetRect.set(0.0f, 0.0f, f2, f3);
        this.mScreenCenter.set(f2 / 2.0f, f3 / 2.0f);
        if (this.isKnowSize) {
            return;
        }
        this.isKnowSize = true;
        j();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        super.setAdjustViewBounds(adjustViewBounds);
        this.mAdjustViewBounds = adjustViewBounds;
    }

    public final void setAnimDuring(int during) {
        this.mAnimaDuring = during;
    }

    public final void setEnable(boolean z) {
        this.isEnable = z;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        boolean z = false;
        if (drawable == null) {
            this.hasDrawable = false;
            return;
        }
        if ((drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) || ((drawable.getMinimumWidth() > 0 && drawable.getMinimumHeight() > 0) || (drawable.getBounds().width() > 0 && drawable.getBounds().height() > 0))) {
            z = true;
        }
        if (z) {
            if (!this.hasDrawable) {
                this.hasDrawable = true;
            }
            j();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setImageResource(int resId) {
        Drawable drawable = null;
        try {
            drawable = getResources().getDrawable(resId, null);
        } catch (Exception unused) {
        }
        setImageDrawable(drawable);
    }

    public final void setInterpolator(@Nullable Interpolator interpolator) {
        this.mTranslate.m.a = interpolator;
    }

    public final void setMAX_ANIM_FROM_WAITE(int i2) {
        this.MAX_ANIM_FROM_WAITE = i2;
    }

    public final void setMAX_FLING_OVER_SCROLL(int i2) {
        this.MAX_FLING_OVER_SCROLL = i2;
    }

    public final void setMAX_OVER_RESISTANCE(int i2) {
        this.MAX_OVER_RESISTANCE = i2;
    }

    public final void setMAX_OVER_SCROLL(int i2) {
        this.MAX_OVER_SCROLL = i2;
    }

    public final void setMAnimaDuring(int i2) {
        this.mAnimaDuring = i2;
    }

    public final void setMaxAnimFromWaiteTime(int wait) {
        this.MAX_ANIM_FROM_WAITE = wait;
    }

    public final void setMaxScale(float maxScale) {
        this.mMaxScale = maxScale;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener l2) {
        super.setOnClickListener(l2);
        this.mClickListener = l2;
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener l2) {
        this.mLongClick = l2;
    }

    public final void setRotateEnable(boolean z) {
        this.isRotateEnable = z;
    }

    @Override // android.widget.ImageView
    public void setScaleType(@NotNull ImageView.ScaleType scaleType) {
        f.c0.c.j.e(scaleType, "scaleType");
        if (scaleType == ImageView.ScaleType.MATRIX || scaleType == this.mScaleType) {
            return;
        }
        this.mScaleType = scaleType;
        if (this.isInit) {
            j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        this.MIN_ROTATE = 35;
        this.ANIMA_DURING = 340;
        this.MAX_SCALE = 2.5f;
        this.MAX_ANIM_FROM_WAITE = 500;
        this.mBaseMatrix = new Matrix();
        this.mAnimMatrix = new Matrix();
        this.mSynthesisMatrix = new Matrix();
        this.mTmpMatrix = new Matrix();
        this.isEnable = true;
        this.mScale = 1.0f;
        this.mWidgetRect = new RectF();
        this.mBaseRect = new RectF();
        this.mImgRect = new RectF();
        this.mTmpRect = new RectF();
        this.mCommonRect = new RectF();
        this.mScreenCenter = new PointF();
        this.mScaleCenter = new PointF();
        this.mRotateCenter = new PointF();
        this.mTranslate = new i(this);
        f fVar = new f(this);
        this.mRotateListener = fVar;
        c cVar = new c(this);
        this.mGestureListener = cVar;
        h hVar = new h(this);
        this.mScaleListener = hVar;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.mScaleType == null) {
            this.mScaleType = ImageView.ScaleType.CENTER_INSIDE;
        }
        this.mRotateDetector = new e.a.a.g.m.m.b.c(fVar);
        this.mDetector = new GestureDetector(context, cVar);
        this.mScaleDetector = new ScaleGestureDetector(context, hVar);
        float f2 = getResources().getDisplayMetrics().density;
        int i2 = (int) (30 * f2);
        this.MAX_OVER_SCROLL = i2;
        this.MAX_FLING_OVER_SCROLL = i2;
        this.MAX_OVER_RESISTANCE = (int) (f2 * 140);
        this.mMinRotate = 35;
        this.mAnimaDuring = 340;
        this.mMaxScale = 2.5f;
        this.mClickRunnable = new Runnable() { // from class: e.a.a.g.m.m.a
            @Override // java.lang.Runnable
            public final void run() {
                PhotoView photoView = this.a;
                int i3 = PhotoView.a;
                j.e(photoView, "this$0");
                View.OnClickListener onClickListener = photoView.mClickListener;
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(photoView);
            }
        };
    }
}
