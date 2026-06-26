package io.legado.app.ui.widget.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import c.b.a.m.f;
import c.b.a.m.q.r;
import c.b.a.q.j.h;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.n;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoverImageView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b?\u0010@J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001b\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010-\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\"R\u001d\u00103\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010)R\u001d\u00107\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00102R\"\u0010\u0014\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u0010\"\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&¨\u0006A"}, d2 = {"Lio/legado/app/ui/widget/image/CoverImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "widthMeasureSpec", "heightMeasureSpec", "Lf/v;", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "height", "setHeight", "(I)V", "", "path", "name", "author", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Constants.LANDSCAPE, "Z", "loadFailed", "", "d", "F", "getWidth$app_adsRelease", "()F", "setWidth$app_adsRelease", "(F)V", "width", "k", "Ljava/lang/String;", "f", "nameHeight", "g", "authorHeight", "Landroid/text/TextPaint;", ai.aA, "Lf/e;", "getAuthorPaint", "()Landroid/text/TextPaint;", "authorPaint", "j", "h", "getNamePaint", "namePaint", "e", "getHeight$app_adsRelease", "setHeight$app_adsRelease", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class CoverImageView extends AppCompatImageView {

    @NotNull
    public static final CoverImageView a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Drawable f7690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float width;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public float height;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float nameHeight;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public float authorHeight;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e namePaint;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e authorPaint;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String name;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String author;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public boolean loadFailed;

    /* JADX INFO: compiled from: CoverImageView.kt */
    public static final class a extends k implements f.c0.b.a<TextPaint> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final TextPaint invoke() {
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.DEFAULT);
            textPaint.setAntiAlias(true);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSkewX(-0.1f);
            return textPaint;
        }
    }

    /* JADX INFO: compiled from: CoverImageView.kt */
    public static final class b implements c.b.a.q.e<Drawable> {
        public b() {
        }

        @Override // c.b.a.q.e
        public boolean a(@Nullable r rVar, @Nullable Object obj, @Nullable h<Drawable> hVar, boolean z) {
            CoverImageView.this.loadFailed = true;
            return false;
        }

        @Override // c.b.a.q.e
        public boolean b(Drawable drawable, Object obj, h<Drawable> hVar, c.b.a.m.a aVar, boolean z) {
            CoverImageView.this.loadFailed = false;
            return false;
        }
    }

    /* JADX INFO: compiled from: CoverImageView.kt */
    public static final class c extends k implements f.c0.b.a<TextPaint> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final TextPaint invoke() {
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.DEFAULT_BOLD);
            textPaint.setAntiAlias(true);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSkewX(-0.2f);
            return textPaint;
        }
    }

    static {
        c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CoverImageView(@NotNull Context context) {
        this(context, null);
        j.e(context, com.umeng.analytics.pro.c.R);
    }

    @NotNull
    public static final Drawable a() {
        Drawable drawable = f7690c;
        if (drawable != null) {
            return drawable;
        }
        j.m("defaultDrawable");
        throw null;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public static final void c() {
        Drawable drawableCreateFromPath = Drawable.createFromPath(f.O2(k.d.a.h.g(), "defaultCover", null, 2));
        if (drawableCreateFromPath == null) {
            f7689b = true;
            drawableCreateFromPath = k.d.a.h.g().getResources().getDrawable(R.drawable.image_cover_default, null);
        } else {
            f7689b = false;
        }
        j.c(drawableCreateFromPath);
        j.e(drawableCreateFromPath, "<set-?>");
        f7690c = drawableCreateFromPath;
    }

    private final TextPaint getAuthorPaint() {
        return (TextPaint) this.authorPaint.getValue();
    }

    private final TextPaint getNamePaint() {
        return (TextPaint) this.namePaint.getValue();
    }

    public final void b(@Nullable String path, @Nullable String name, @Nullable String author) {
        if (name == null) {
            name = null;
        } else if (name.length() > 5) {
            String strSubstring = name.substring(0, 4);
            j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            name = j.k(strSubstring, "…");
        }
        this.name = name;
        if (author == null) {
            author = null;
        } else if (author.length() > 8) {
            String strSubstring2 = author.substring(0, 7);
            j.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            author = j.k(strSubstring2, "…");
        }
        this.author = author;
        e.a.a.d.e eVar = e.a.a.d.e.a;
        if (f.J2(k.d.a.h.g(), "useDefaultCover", false)) {
            Context context = getContext();
            j.d(context, com.umeng.analytics.pro.c.R);
            Drawable drawable = f7690c;
            if (drawable == null) {
                j.m("defaultDrawable");
                throw null;
            }
            j.e(context, com.umeng.analytics.pro.c.R);
            c.b.a.h<Drawable> hVarA = c.b.a.b.d(context).i().G(drawable).a(c.b.a.q.f.y(c.b.a.m.q.k.a));
            j.d(hVarA, "with(context).load(drawable)");
            hVarA.c().E(this);
            return;
        }
        Context context2 = getContext();
        j.d(context2, com.umeng.analytics.pro.c.R);
        c.b.a.h<Drawable> hVarA2 = n.a(context2, path);
        Drawable drawable2 = f7690c;
        if (drawable2 == null) {
            j.m("defaultDrawable");
            throw null;
        }
        c.b.a.h hVarN = hVarA2.n(drawable2);
        Drawable drawable3 = f7690c;
        if (drawable3 != null) {
            hVarN.h(drawable3).F(new b()).c().E(this);
        } else {
            j.m("defaultDrawable");
            throw null;
        }
    }

    /* JADX INFO: renamed from: getHeight$app_adsRelease, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: getWidth$app_adsRelease, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        if (this.width >= 10.0f && this.height > 10.0f) {
            Path path = new Path();
            path.moveTo(10.0f, 0.0f);
            float f2 = 10;
            path.lineTo(this.width - f2, 0.0f);
            float f3 = this.width;
            path.quadTo(f3, 0.0f, f3, 10.0f);
            path.lineTo(this.width, this.height - f2);
            float f4 = this.width;
            float f5 = this.height;
            path.quadTo(f4, f5, f4 - f2, f5);
            path.lineTo(10.0f, this.height);
            float f6 = this.height;
            path.quadTo(0.0f, f6, 0.0f, f6 - f2);
            path.lineTo(0.0f, 10.0f);
            path.quadTo(0.0f, 0.0f, 10.0f, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
        if (this.loadFailed && f7689b) {
            String str = this.name;
            if (str != null) {
                getNamePaint().setColor(-1);
                getNamePaint().setStyle(Paint.Style.STROKE);
                float f7 = 2;
                canvas.drawText(str, getWidth() / f7, this.nameHeight, getNamePaint());
                getNamePaint().setColor(-65536);
                getNamePaint().setStyle(Paint.Style.FILL);
                canvas.drawText(str, getWidth() / f7, this.nameHeight, getNamePaint());
            }
            String str2 = this.author;
            if (str2 == null) {
                return;
            }
            getAuthorPaint().setColor(-1);
            getAuthorPaint().setStyle(Paint.Style.STROKE);
            float f8 = 2;
            canvas.drawText(str2, getWidth() / f8, this.authorHeight, getAuthorPaint());
            getAuthorPaint().setColor(-65536);
            getAuthorPaint().setStyle(Paint.Style.FILL);
            canvas.drawText(str2, getWidth() / f8, this.authorHeight, getAuthorPaint());
        }
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.width = getWidth();
        this.height = getHeight();
        getNamePaint().setTextSize(this.width / 6);
        float f2 = 10;
        getNamePaint().setStrokeWidth(getNamePaint().getTextSize() / f2);
        getAuthorPaint().setTextSize(this.width / 9);
        getAuthorPaint().setStrokeWidth(getAuthorPaint().getTextSize() / f2);
        Paint.FontMetrics fontMetrics = getNamePaint().getFontMetrics();
        float f3 = this.height * 0.5f;
        float f4 = fontMetrics.bottom;
        float f5 = fontMetrics.top;
        float fA = c.a.a.a.a.a(f4, f5, 0.5f, f3);
        this.nameHeight = fA;
        this.authorHeight = c.a.a.a.a.a(f4, f5, 0.6f, fA);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(widthMeasureSpec) * 7) / 5, BasicMeasure.EXACTLY));
    }

    public final void setHeight(int height) {
        setMinimumWidth((height * 5) / 7);
    }

    public final void setHeight$app_adsRelease(float f2) {
        this.height = f2;
    }

    public final void setWidth$app_adsRelease(float f2) {
        this.width = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CoverImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, com.umeng.analytics.pro.c.R);
        this.namePaint = f.N3(c.INSTANCE);
        this.authorPaint = f.N3(a.INSTANCE);
    }
}
