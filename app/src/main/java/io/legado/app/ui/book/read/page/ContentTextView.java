package io.legado.app.ui.book.read.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.KeyEventDispatcher;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.g.d.i.s1.g.d;
import e.a.a.g.d.i.s1.g.e;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.h;
import f.v;
import io.legado.app.data.entities.Book;
import io.legado.app.help.ReadBookConfig;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* JADX INFO: compiled from: ContentTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010W\u001a\u00020V\u0012\b\u0010Y\u001a\u0004\u0018\u00010X¢\u0006\u0004\bZ\u0010[J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010\fJ/\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0014¢\u0006\u0004\b*\u0010+R\u001d\u00100\u001a\u00020,8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00108R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010:R$\u0010\u001e\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00108R\u0013\u0010D\u001a\u00020A8F@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010FR0\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010U\u001a\u00020O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006\\"}, d2 = {"Lio/legado/app/ui/book/read/page/ContentTextView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "Le/a/a/g/d/i/s1/g/d;", "textLine", "", "relativeOffset", "Lf/v;", ai.at, "(Landroid/graphics/Canvas;Le/a/a/g/d/i/s1/g/d;F)V", "f", "()V", "x", "y", "top", "Lio/legado/app/ui/book/read/page/ContentTextView$a;", "g", "(FFF)Lio/legado/app/ui/book/read/page/ContentTextView$a;", "", "", "select", "e", "([Ljava/lang/Integer;)I", "relativePos", "b", "(I)F", "Le/a/a/g/d/i/s1/g/e;", ai.aD, "(I)Le/a/a/g/d/i/s1/g/e;", "textPage", "setContent", "(Le/a/a/g/d/i/s1/g/e;)V", "h", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "onDraw", "(Landroid/graphics/Canvas;)V", "mOffset", "d", "(I)V", "Landroid/graphics/Paint;", "Lf/e;", "getSelectedPaint", "()Landroid/graphics/Paint;", "selectedPaint", ai.aA, OptRuntime.GeneratorState.resumptionPoint_TYPE, "pageOffset", "Le/a/a/g/d/i/s1/h/c;", "getPageFactory", "()Le/a/a/g/d/i/s1/h/c;", "pageFactory", "[Ljava/lang/Integer;", "selectEnd", "Lio/legado/app/ui/book/read/page/ContentTextView$a;", "callBack", "<set-?>", "Le/a/a/g/d/i/s1/g/e;", "getTextPage", "()Le/a/a/g/d/i/s1/g/e;", "selectStart", "", "getSelectedText", "()Ljava/lang/String;", "selectedText", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "visibleRect", "Lkotlin/Function1;", "Lf/c0/b/l;", "getUpView", "()Lf/c0/b/l;", "setUpView", "(Lf/c0/b/l;)V", "upView", "", "Z", "getSelectAble", "()Z", "setSelectAble", "(Z)V", "selectAble", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ContentTextView extends View {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public boolean selectAble;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public l<? super e, v> upView;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e selectedPaint;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public a callBack;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final RectF visibleRect;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Integer[] selectStart;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Integer[] selectEnd;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public e textPage;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int pageOffset;

    /* JADX INFO: compiled from: ContentTextView.kt */
    public interface a {
        boolean A();

        void E(float f2, float f3);

        @NotNull
        e.a.a.g.d.i.s1.h.c H();

        int j0();

        void t();

        void v0(float f2, float f3, float f4);
    }

    /* JADX INFO: compiled from: ContentTextView.kt */
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
            paint.setColor(f.c2(this.$context, R.color.btn_bg_press_2));
            paint.setStyle(Paint.Style.FILL);
            return paint;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.selectAble = f.J2(context, "selectText", true);
        this.selectedPaint = f.N3(new b(context));
        this.visibleRect = new RectF();
        this.selectStart = new Integer[]{0, 0, 0};
        this.selectEnd = new Integer[]{0, 0, 0};
        this.textPage = new e(0, null, null, null, 0, 0, 0, 0.0f, 255);
        KeyEventDispatcher.Component componentO1 = f.O1(this);
        Objects.requireNonNull(componentO1, "null cannot be cast to non-null type io.legado.app.ui.book.read.page.ContentTextView.CallBack");
        this.callBack = (a) componentO1;
    }

    private final e.a.a.g.d.i.s1.h.c getPageFactory() {
        return this.callBack.H();
    }

    private final Paint getSelectedPaint() {
        return (Paint) this.selectedPaint.getValue();
    }

    public final void a(Canvas canvas, d textLine, float relativeOffset) {
        TextPaint textPaintD;
        int textColor;
        Bitmap bitmapA;
        RectF rectF;
        Object objM11constructorimpl;
        float f2 = textLine.f5775c + relativeOffset;
        float f3 = textLine.f5776d + relativeOffset;
        float f4 = relativeOffset + textLine.f5777e;
        ArrayList<e.a.a.g.d.i.s1.g.c> arrayList = textLine.f5774b;
        boolean z = textLine.f5778f;
        boolean z2 = textLine.f5779g;
        boolean z3 = textLine.f5780h;
        if (z) {
            e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
            textPaintD = e.a.a.g.d.i.s1.h.a.g();
        } else {
            e.a.a.g.d.i.s1.h.a aVar2 = e.a.a.g.d.i.s1.h.a.a;
            textPaintD = e.a.a.g.d.i.s1.h.a.d();
        }
        TextPaint textPaint = textPaintD;
        if (z2) {
            Context context = getContext();
            j.d(context, c.R);
            textColor = f.M1(context);
        } else {
            textColor = ReadBookConfig.INSTANCE.getTextColor();
        }
        textPaint.setColor(textColor);
        for (e.a.a.g.d.i.s1.g.c cVar : arrayList) {
            if (cVar.f5773e) {
                e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                Book book = e.a.a.f.s.k.f5677c;
                if (book != null && (bitmapA = e.a.a.g.d.i.s1.h.b.a.a(book, getTextPage().f5786g, cVar.a, true)) != null) {
                    if (z3) {
                        rectF = new RectF(cVar.f5770b, f2, cVar.f5771c, f4);
                    } else {
                        float width = ((f4 - f2) - (((cVar.f5771c - cVar.f5770b) / bitmapA.getWidth()) * bitmapA.getHeight())) / 2;
                        rectF = new RectF(cVar.f5770b, f2 + width, cVar.f5771c, f4 - width);
                    }
                    try {
                        canvas.drawBitmap(bitmapA, (Rect) null, rectF, (Paint) null);
                        objM11constructorimpl = h.m11constructorimpl(v.a);
                    } catch (Throwable th) {
                        objM11constructorimpl = h.m11constructorimpl(f.m1(th));
                    }
                    Throwable thM14exceptionOrNullimpl = h.m14exceptionOrNullimpl(objM11constructorimpl);
                    if (thM14exceptionOrNullimpl != null) {
                        Context context2 = getContext();
                        j.d(context2, c.R);
                        f.R5(context2, thM14exceptionOrNullimpl.getLocalizedMessage());
                    }
                    h.m10boximpl(objM11constructorimpl);
                }
            } else {
                canvas.drawText(cVar.a, cVar.f5770b, f3, textPaint);
            }
            if (cVar.f5772d) {
                canvas.drawRect(cVar.f5770b, f2, cVar.f5771c, f4, getSelectedPaint());
            }
        }
    }

    public final float b(int relativePos) {
        float f2;
        float f3;
        if (relativePos == 0) {
            return this.pageOffset;
        }
        if (relativePos != 1) {
            f2 = this.pageOffset + this.textPage.f5787h;
            f3 = getPageFactory().b().f5787h;
        } else {
            f2 = this.pageOffset;
            f3 = this.textPage.f5787h;
        }
        return f2 + f3;
    }

    public final e c(int relativePos) {
        e eVarB;
        if (relativePos == 0) {
            return this.textPage;
        }
        if (relativePos != 1) {
            e.a.a.g.d.i.s1.e.a aVar = getPageFactory().a;
            e.a.a.g.d.i.s1.g.b currentChapter = aVar.getCurrentChapter();
            if (currentChapter == null) {
                eVarB = new e(0, null, null, null, 0, 0, 0, 0.0f, 255);
                eVarB.a();
            } else {
                e eVar = null;
                if (aVar.getPageIndex() < currentChapter.b() - 2) {
                    e eVarD = currentChapter.d(aVar.getPageIndex() + 2);
                    if (eVarD != null) {
                        eVarD.e();
                        eVar = eVarD;
                    }
                    if (eVar == null) {
                        eVar = new e(0, null, currentChapter.f5766b, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                        eVar.a();
                    }
                } else {
                    e.a.a.g.d.i.s1.g.b nextChapter = aVar.getNextChapter();
                    if (nextChapter != null) {
                        if (aVar.getPageIndex() < currentChapter.b() - 1) {
                            e eVarD2 = nextChapter.d(0);
                            if (eVarD2 != null) {
                                eVarD2.e();
                                eVar = eVarD2;
                            }
                            if (eVar == null) {
                                eVar = new e(0, null, nextChapter.f5766b, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                                eVar.a();
                            }
                        } else {
                            e eVarD3 = nextChapter.d(1);
                            if (eVarD3 != null) {
                                eVarD3.e();
                                eVar = eVarD3;
                            }
                            if (eVar == null) {
                                eVar = new e(0, null, nextChapter.f5766b, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
                                eVar.a();
                            }
                        }
                    }
                    eVarB = new e(0, null, null, null, 0, 0, 0, 0.0f, 255);
                    eVarB.a();
                }
                eVarB = eVar;
            }
        } else {
            eVarB = getPageFactory().b();
        }
        return eVarB;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(int r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L3
            return
        L3:
            int r0 = r4.pageOffset
            int r0 = r0 + r5
            r4.pageOffset = r0
            e.a.a.g.d.i.s1.h.c r5 = r4.getPageFactory()
            boolean r5 = r5.e()
            r0 = 0
            if (r5 != 0) goto L1b
            int r5 = r4.pageOffset
            if (r5 <= 0) goto L1b
            r4.pageOffset = r0
            goto L9d
        L1b:
            e.a.a.g.d.i.s1.h.c r5 = r4.getPageFactory()
            boolean r5 = r5.d()
            if (r5 != 0) goto L42
            int r5 = r4.pageOffset
            if (r5 >= 0) goto L42
            float r5 = (float) r5
            e.a.a.g.d.i.s1.g.e r1 = r4.textPage
            float r1 = r1.f5787h
            float r5 = r5 + r1
            e.a.a.g.d.i.s1.h.a r2 = e.a.a.g.d.i.s1.h.a.a
            int r2 = e.a.a.g.d.i.s1.h.a.f5793g
            float r3 = (float) r2
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 >= 0) goto L42
            float r5 = (float) r2
            float r5 = r5 - r1
            int r5 = (int) r5
            int r5 = java.lang.Math.min(r0, r5)
            r4.pageOffset = r5
            goto L9d
        L42:
            int r5 = r4.pageOffset
            if (r5 <= 0) goto L6f
            e.a.a.g.d.i.s1.h.c r5 = r4.getPageFactory()
            r5.g(r0)
            e.a.a.g.d.i.s1.h.c r5 = r4.getPageFactory()
            e.a.a.g.d.i.s1.g.e r5 = r5.a()
            r4.textPage = r5
            int r0 = r4.pageOffset
            float r1 = r5.f5787h
            int r1 = (int) r1
            int r0 = r0 - r1
            r4.pageOffset = r0
            f.c0.b.l<? super e.a.a.g.d.i.s1.g.e, f.v> r0 = r4.upView
            if (r0 != 0) goto L64
            goto L67
        L64:
            r0.invoke(r5)
        L67:
            e.a.a.g.d.i.s1.g.e r5 = r4.textPage
            java.lang.String r5 = r5.f5781b
            r4.setContentDescription(r5)
            goto L9d
        L6f:
            float r1 = (float) r5
            e.a.a.g.d.i.s1.g.e r2 = r4.textPage
            float r2 = r2.f5787h
            float r3 = -r2
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L9d
            int r1 = (int) r2
            int r5 = r5 + r1
            r4.pageOffset = r5
            e.a.a.g.d.i.s1.h.c r5 = r4.getPageFactory()
            r5.f(r0)
            e.a.a.g.d.i.s1.h.c r5 = r4.getPageFactory()
            e.a.a.g.d.i.s1.g.e r5 = r5.a()
            r4.textPage = r5
            f.c0.b.l<? super e.a.a.g.d.i.s1.g.e, f.v> r0 = r4.upView
            if (r0 != 0) goto L93
            goto L96
        L93:
            r0.invoke(r5)
        L96:
            e.a.a.g.d.i.s1.g.e r5 = r4.textPage
            java.lang.String r5 = r5.f5781b
            r4.setContentDescription(r5)
        L9d:
            r4.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.page.ContentTextView.d(int):void");
    }

    public final int e(Integer[] select) {
        return select[2].intValue() + (select[1].intValue() * 100000) + (select[0].intValue() * FastDtoa.kTen7);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.page.ContentTextView.f():void");
    }

    public final a g(float x, float y, float top) {
        a aVar = this.callBack;
        aVar.v0(x, y + aVar.j0(), top + aVar.j0());
        return aVar;
    }

    public final boolean getSelectAble() {
        return this.selectAble;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0201 A[LOOP:0: B:4:0x001a->B:63:0x0201, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0205 A[EDGE_INSN: B:66:0x0205->B:64:0x0205 BREAK  A[LOOP:0: B:4:0x001a->B:63:0x0201], SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getSelectedText() {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.page.ContentTextView.getSelectedText():java.lang.String");
    }

    @NotNull
    public final e getTextPage() {
        return this.textPage;
    }

    @Nullable
    public final l<e, v> getUpView() {
        return this.upView;
    }

    public final void h() {
        RectF rectF = this.visibleRect;
        e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
        rectF.set(e.a.a.g.d.i.s1.h.a.f5790d, e.a.a.g.d.i.s1.h.a.f5791e, e.a.a.g.d.i.s1.h.a.f5794h, e.a.a.g.d.i.s1.h.a.f5795i);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(@org.jetbrains.annotations.NotNull android.graphics.Canvas r6) {
        /*
            r5 = this;
            java.lang.String r0 = "canvas"
            f.c0.c.j.e(r6, r0)
            super.onDraw(r6)
            android.graphics.RectF r0 = r5.visibleRect
            r6.clipRect(r0)
            r0 = 0
            float r1 = r5.b(r0)
            e.a.a.g.d.i.s1.g.e r2 = r5.textPage
            java.util.ArrayList<e.a.a.g.d.i.s1.g.d> r2 = r2.f5783d
            java.util.Iterator r2 = r2.iterator()
        L1a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L2a
            java.lang.Object r3 = r2.next()
            e.a.a.g.d.i.s1.g.d r3 = (e.a.a.g.d.i.s1.g.d) r3
            r5.a(r6, r3, r1)
            goto L1a
        L2a:
            io.legado.app.ui.book.read.page.ContentTextView$a r1 = r5.callBack
            boolean r1 = r1.A()
            if (r1 != 0) goto L34
            goto Laa
        L34:
            e.a.a.g.d.i.s1.h.c r1 = r5.getPageFactory()
            boolean r1 = r1.d()
            if (r1 != 0) goto L3f
            goto Laa
        L3f:
            r1 = 1
            e.a.a.g.d.i.s1.g.e r2 = r5.c(r1)
            float r3 = r5.b(r1)
            java.util.ArrayList<e.a.a.g.d.i.s1.g.d> r2 = r2.f5783d
            java.util.Iterator r2 = r2.iterator()
        L4e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L5e
            java.lang.Object r4 = r2.next()
            e.a.a.g.d.i.s1.g.d r4 = (e.a.a.g.d.i.s1.g.d) r4
            r5.a(r6, r4, r3)
            goto L4e
        L5e:
            e.a.a.g.d.i.s1.h.c r2 = r5.getPageFactory()
            e.a.a.g.d.i.s1.e.a r2 = r2.a
            boolean r3 = r2.c()
            if (r3 != 0) goto L7e
            int r3 = r2.getPageIndex()
            e.a.a.g.d.i.s1.g.b r2 = r2.getCurrentChapter()
            if (r2 != 0) goto L76
            r2 = 1
            goto L7a
        L76:
            int r2 = r2.b()
        L7a:
            int r2 = r2 + (-2)
            if (r3 >= r2) goto L7f
        L7e:
            r0 = 1
        L7f:
            if (r0 != 0) goto L82
            goto Laa
        L82:
            r0 = 2
            float r1 = r5.b(r0)
            e.a.a.g.d.i.s1.h.a r2 = e.a.a.g.d.i.s1.h.a.a
            int r2 = e.a.a.g.d.i.s1.h.a.f5793g
            float r2 = (float) r2
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 >= 0) goto Laa
            e.a.a.g.d.i.s1.g.e r0 = r5.c(r0)
            java.util.ArrayList<e.a.a.g.d.i.s1.g.d> r0 = r0.f5783d
            java.util.Iterator r0 = r0.iterator()
        L9a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Laa
            java.lang.Object r2 = r0.next()
            e.a.a.g.d.i.s1.g.d r2 = (e.a.a.g.d.i.s1.g.d) r2
            r5.a(r6, r2, r1)
            goto L9a
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.page.ContentTextView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
        if (w > 0 && h2 > 0 && (w != e.a.a.g.d.i.s1.h.a.f5788b || h2 != e.a.a.g.d.i.s1.h.a.f5789c)) {
            e.a.a.g.d.i.s1.h.a.f5788b = w;
            e.a.a.g.d.i.s1.h.a.f5789c = h2;
            aVar.j();
            LiveEventBus.get("upConfig").post(Boolean.TRUE);
        }
        h();
        this.textPage.a();
    }

    public final void setContent(@NotNull e textPage) {
        j.e(textPage, "textPage");
        this.textPage = textPage;
        invalidate();
    }

    public final void setSelectAble(boolean z) {
        this.selectAble = z;
    }

    public final void setUpView(@Nullable l<? super e, v> lVar) {
        this.upView = lVar;
    }
}
