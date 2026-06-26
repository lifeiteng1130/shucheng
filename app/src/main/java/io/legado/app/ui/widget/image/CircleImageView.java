package io.legado.app.ui.widget.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import io.legado.app.R$styleable;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: CircleImageView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B#\b\u0007\u0012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001\u0012\f\b\u0002\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\tJ/\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\"\u0010\u001dJ/\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010\u001dJ\u0017\u0010'\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u0012¢\u0006\u0004\b'\u0010\u0015J\u0017\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u00020\u00022\b\b\u0001\u00100\u001a\u00020\u0012H\u0016¢\u0006\u0004\b1\u0010\u0015J\u0019\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0011\u0010:\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<H\u0017¢\u0006\u0004\b>\u0010?R&\u0010@\u001a\u00020\u00122\b\b\u0001\u0010@\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010\u0015R\u0018\u0010F\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010O\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\tR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010IR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\\R\u0016\u0010_\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010LR\"\u0010c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010L\u001a\u0004\bc\u0010P\"\u0004\bd\u0010\tR\u0016\u0010f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010^R&\u0010g\u001a\u00020\u00122\b\b\u0001\u0010g\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010B\"\u0004\bi\u0010\u0015R\u0016\u0010k\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010^R\u0016\u0010m\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010XR\u0016\u0010o\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010LR\u0016\u0010q\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010^R*\u0010t\u001a\u00020\u00062\u0006\u0010r\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010L\u001a\u0004\bt\u0010P\"\u0004\bu\u0010\tR$\u0010v\u001a\u00020\u00122\u0006\u0010v\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u0010B\"\u0004\bx\u0010\u0015R\u0018\u0010{\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010^R\u0017\u0010\u0080\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010XR\u001a\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010^R\"\u0010\u008e\u0001\u001a\u00030\u008a\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0019\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0090\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010L¨\u0006\u0097\u0001"}, d2 = {"Lio/legado/app/ui/widget/image/CircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lf/v;", ai.at, "()V", "b", "", "adjustViewBounds", "setAdjustViewBounds", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "setText", "(Ljava/lang/String;)V", "", "textColor", "setTextColor", "(I)V", "bold", "setTextBold", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "left", "top", "right", "bottom", "setPadding", "start", "end", "setPaddingRelative", "circleBackgroundRes", "setCircleBackgroundColorResource", "Landroid/graphics/Bitmap;", "bm", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "resId", "setImageResource", "Landroid/net/Uri;", "uri", "setImageURI", "(Landroid/net/Uri;)V", "Landroid/graphics/ColorFilter;", "cf", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getColorFilter", "()Landroid/graphics/ColorFilter;", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "circleBackgroundColor", "getCircleBackgroundColor", "()I", "setCircleBackgroundColor", "r", "Landroid/graphics/ColorFilter;", "mColorFilter", "", "q", "F", "mBorderRadius", ai.aF, "Z", "mSetupPending", "borderOverlay", "isBorderOverlay", "()Z", "setBorderOverlay", "Landroid/graphics/BitmapShader;", "m", "Landroid/graphics/BitmapShader;", "mBitmapShader", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "mBorderPaint", "p", "mDrawableRadius", "Ljava/lang/String;", "n", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mBitmapWidth", "y", "textBold", ai.aB, "isInView", "setInView", "j", "mBorderWidth", "borderColor", "getBorderColor", "setBorderColor", "k", "mCircleBackgroundColor", "e", "mBitmapPaint", ai.aE, "mBorderOverlay", "o", "mBitmapHeight", "disableCircularTransformation", ai.aC, "isDisableCircularTransformation", "setDisableCircularTransformation", "borderWidth", "getBorderWidth", "setBorderWidth", Constants.LANDSCAPE, "Landroid/graphics/Bitmap;", "mBitmap", ai.aA, "mBorderColor", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mDrawableRect", ai.aD, "mBorderRect", "g", "mCircleBackgroundPaint", "Landroid/graphics/Matrix;", "d", "Landroid/graphics/Matrix;", "mShaderMatrix", "x", "Landroid/text/TextPaint;", "Lf/e;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint", ai.az, "mReady", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class CircleImageView extends AppCompatImageView {

    @NotNull
    public static final Bitmap.Config a = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final RectF mDrawableRect;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final RectF mBorderRect;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Matrix mShaderMatrix;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Paint mBitmapPaint;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Paint mBorderPaint;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Paint mCircleBackgroundPaint;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e textPaint;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int mBorderColor;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int mBorderWidth;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int mCircleBackgroundColor;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Bitmap mBitmap;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public BitmapShader mBitmapShader;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int mBitmapWidth;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int mBitmapHeight;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public float mDrawableRadius;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public float mBorderRadius;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @Nullable
    public ColorFilter mColorFilter;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public boolean mReady;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public boolean mSetupPending;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean mBorderOverlay;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public boolean isDisableCircularTransformation;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    @Nullable
    public String text;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public int textColor;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public boolean textBold;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public boolean isInView;

    /* JADX INFO: compiled from: CircleImageView.kt */
    @RequiresApi(api = 21)
    public final class a extends ViewOutlineProvider {
        public final /* synthetic */ CircleImageView a;

        public a(CircleImageView circleImageView) {
            j.e(circleImageView, "this$0");
            this.a = circleImageView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            j.e(view, "view");
            j.e(outline, "outline");
            Rect rect = new Rect();
            this.a.mBorderRect.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    /* JADX INFO: compiled from: CircleImageView.kt */
    public static final class b extends k implements f.c0.b.a<TextPaint> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final TextPaint invoke() {
            TextPaint textPaint = new TextPaint();
            textPaint.setAntiAlias(true);
            textPaint.setTextAlign(Paint.Align.CENTER);
            return textPaint;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleImageView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    private final TextPaint getTextPaint() {
        return (TextPaint) this.textPaint.getValue();
    }

    public final void a() {
        Drawable drawable;
        Bitmap bitmapCreateBitmap;
        Bitmap bitmap = null;
        if (!this.isDisableCircularTransformation && (drawable = getDrawable()) != null) {
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else {
                try {
                    if (drawable instanceof ColorDrawable) {
                        bitmapCreateBitmap = Bitmap.createBitmap(2, 2, a);
                        j.d(bitmapCreateBitmap, "{\n                Bitmap.createBitmap(\n                    COLOR_DRAWABLE_DIMENSION,\n                    COLOR_DRAWABLE_DIMENSION,\n                    BITMAP_CONFIG\n                )\n            }");
                    } else {
                        bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), a);
                        j.d(bitmapCreateBitmap, "{\n                Bitmap.createBitmap(\n                    drawable.intrinsicWidth,\n                    drawable.intrinsicHeight,\n                    BITMAP_CONFIG\n                )\n            }");
                    }
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawable.draw(canvas);
                    bitmap = bitmapCreateBitmap;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.mBitmap = bitmap;
        b();
    }

    public final void b() {
        float fWidth;
        float fHeight;
        int i2;
        if (!this.mReady) {
            this.mSetupPending = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.mBitmap == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.mBitmap;
        j.c(bitmap);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setShader(this.mBitmapShader);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mCircleBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mCircleBackgroundPaint.setAntiAlias(true);
        this.mCircleBackgroundPaint.setColor(this.mCircleBackgroundColor);
        Bitmap bitmap2 = this.mBitmap;
        j.c(bitmap2);
        this.mBitmapHeight = bitmap2.getHeight();
        Bitmap bitmap3 = this.mBitmap;
        j.c(bitmap3);
        this.mBitmapWidth = bitmap3.getWidth();
        RectF rectF = this.mBorderRect;
        int iMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = ((r1 - iMin) / 2.0f) + getPaddingLeft();
        float paddingTop = ((r2 - iMin) / 2.0f) + getPaddingTop();
        float f2 = iMin;
        rectF.set(new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop));
        this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
        this.mDrawableRect.set(this.mBorderRect);
        if (!this.mBorderOverlay && (i2 = this.mBorderWidth) > 0) {
            float f3 = i2 - 1.0f;
            this.mDrawableRect.inset(f3, f3);
        }
        this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
        this.mBitmapPaint.setColorFilter(this.mColorFilter);
        this.mShaderMatrix.set(null);
        float fWidth2 = 0.0f;
        if (this.mDrawableRect.height() * this.mBitmapWidth > this.mDrawableRect.width() * this.mBitmapHeight) {
            fWidth = this.mDrawableRect.height() / this.mBitmapHeight;
            fWidth2 = (this.mDrawableRect.width() - (this.mBitmapWidth * fWidth)) * 0.5f;
            fHeight = 0.0f;
        } else {
            fWidth = this.mDrawableRect.width() / this.mBitmapWidth;
            fHeight = (this.mDrawableRect.height() - (this.mBitmapHeight * fWidth)) * 0.5f;
        }
        this.mShaderMatrix.setScale(fWidth, fWidth);
        Matrix matrix = this.mShaderMatrix;
        RectF rectF2 = this.mDrawableRect;
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF2.left, ((int) (fHeight + 0.5f)) + rectF2.top);
        BitmapShader bitmapShader = this.mBitmapShader;
        j.c(bitmapShader);
        bitmapShader.setLocalMatrix(this.mShaderMatrix);
        invalidate();
    }

    /* JADX INFO: renamed from: getBorderColor, reason: from getter */
    public final int getMBorderColor() {
        return this.mBorderColor;
    }

    /* JADX INFO: renamed from: getBorderWidth, reason: from getter */
    public final int getMBorderWidth() {
        return this.mBorderWidth;
    }

    /* JADX INFO: renamed from: getCircleBackgroundColor, reason: from getter */
    public final int getMCircleBackgroundColor() {
        return this.mCircleBackgroundColor;
    }

    @Override // android.widget.ImageView
    @Nullable
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        if (this.isDisableCircularTransformation) {
            super.onDraw(canvas);
            return;
        }
        if (this.mBitmap == null) {
            return;
        }
        if (this.mCircleBackgroundColor != 0) {
            canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mCircleBackgroundPaint);
        }
        canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mBitmapPaint);
        if (this.mBorderWidth > 0) {
            canvas.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mBorderPaint);
        }
        String str = this.text;
        if (str == null) {
            return;
        }
        getTextPaint().setColor(this.textColor);
        getTextPaint().setFakeBoldText(this.textBold);
        getTextPaint().setTextSize(f.W2(15));
        Paint.FontMetrics fontMetrics = getTextPaint().getFontMetrics();
        float f2 = fontMetrics.bottom;
        canvas.drawText(str, getWidth() * 0.5f, (((f2 - fontMetrics.top) * 0.5f) + (getHeight() * 0.5f)) - f2, getTextPaint());
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        b();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        j.e(event, NotificationCompat.CATEGORY_EVENT);
        if (event.getAction() == 0) {
            this.isInView = Math.pow((double) (event.getY() - this.mBorderRect.centerY()), 2.0d) + Math.pow((double) (event.getX() - this.mBorderRect.centerX()), 2.0d) <= Math.pow((double) this.mBorderRadius, 2.0d);
        }
        return super.onTouchEvent(event);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        if (adjustViewBounds) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public final void setBorderColor(@ColorInt int i2) {
        if (i2 == this.mBorderColor) {
            return;
        }
        this.mBorderColor = i2;
        this.mBorderPaint.setColor(i2);
        invalidate();
    }

    public final void setBorderOverlay(boolean z) {
        if (z == this.mBorderOverlay) {
            return;
        }
        this.mBorderOverlay = z;
        b();
    }

    public final void setBorderWidth(int i2) {
        if (i2 == this.mBorderWidth) {
            return;
        }
        this.mBorderWidth = i2;
        b();
    }

    public final void setCircleBackgroundColor(@ColorInt int i2) {
        if (i2 == this.mCircleBackgroundColor) {
            return;
        }
        this.mCircleBackgroundColor = i2;
        this.mCircleBackgroundPaint.setColor(i2);
        invalidate();
    }

    public final void setCircleBackgroundColorResource(@ColorRes int circleBackgroundRes) {
        Context context = getContext();
        j.d(context, c.R);
        setCircleBackgroundColor(f.c2(context, circleBackgroundRes));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(@NotNull ColorFilter cf) {
        j.e(cf, "cf");
        if (cf == this.mColorFilter) {
            return;
        }
        this.mColorFilter = cf;
        this.mBitmapPaint.setColorFilter(cf);
        invalidate();
    }

    public final void setDisableCircularTransformation(boolean z) {
        if (this.isDisableCircularTransformation == z) {
            return;
        }
        this.isDisableCircularTransformation = z;
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(@NotNull Bitmap bm) {
        j.e(bm, "bm");
        super.setImageBitmap(bm);
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int resId) {
        super.setImageResource(resId);
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        a();
    }

    public final void setInView(boolean z) {
        this.isInView = z;
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        b();
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        super.setPaddingRelative(start, top, end, bottom);
        b();
    }

    public final void setText(@Nullable String text) {
        this.text = text;
        setContentDescription(text);
        invalidate();
    }

    public final void setTextBold(boolean bold) {
        this.textBold = bold;
        invalidate();
    }

    public final void setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.textPaint = f.N3(b.INSTANCE);
        this.mBorderColor = ViewCompat.MEASURED_STATE_MASK;
        this.textColor = f.c2(context, R.color.primaryText);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleImageView);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)");
        this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.mBorderColor = typedArrayObtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderOverlay = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.mCircleBackgroundColor = typedArrayObtainStyledAttributes.getColor(3, 0);
        String string = typedArrayObtainStyledAttributes.getString(4);
        this.text = string;
        setContentDescription(string);
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            this.textColor = typedArrayObtainStyledAttributes.getColor(5, f.c2(context, R.color.primaryText));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.mReady = true;
        setOutlineProvider(new a(this));
        if (this.mSetupPending) {
            b();
            this.mSetupPending = false;
        }
    }
}
