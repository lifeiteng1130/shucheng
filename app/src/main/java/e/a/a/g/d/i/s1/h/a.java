package e.a.a.g.d.i.s1.h;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.StaticLayout;
import android.text.TextPaint;
import c.b.a.m.f;
import e.a.a.h.a0;
import f.c0.c.j;
import f.g;
import f.x.e;
import io.legado.app.data.entities.Book;
import io.legado.app.help.ReadBookConfig;
import java.util.ArrayList;
import java.util.LinkedList;
import k.d.a.h;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ChapterProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    @NotNull
    public static final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f5789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f5790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f5791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f5792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f5793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f5794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f5795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f5796j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f5797k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f5798l;
    public static int m;

    @NotNull
    public static Typeface n;
    public static TextPaint o;
    public static TextPaint p;

    static {
        a aVar = new a();
        a = aVar;
        Typeface typeface = Typeface.DEFAULT;
        j.d(typeface, Book.imgStyleDefault);
        n = typeface;
        aVar.i();
    }

    @NotNull
    public static final TextPaint d() {
        TextPaint textPaint = p;
        if (textPaint != null) {
            return textPaint;
        }
        j.m("contentPaint");
        throw null;
    }

    @NotNull
    public static final TextPaint g() {
        TextPaint textPaint = o;
        if (textPaint != null) {
            return textPaint;
        }
        j.m("titlePaint");
        throw null;
    }

    public final void a(e.a.a.g.d.i.s1.g.d dVar, String[] strArr, TextPaint textPaint, float f2, LinkedList<String> linkedList) {
        int length = strArr.length;
        float f3 = f2;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            float desiredWidth = StaticLayout.getDesiredWidth(str, textPaint) + f3;
            if (linkedList == null || !j.a(str, "▩")) {
                ArrayList<e.a.a.g.d.i.s1.g.c> arrayList = dVar.f5774b;
                int i3 = f5790d;
                arrayList.add(new e.a.a.g.d.i.s1.g.c(str, i3 + f3, i3 + desiredWidth, false, false, 24));
            } else {
                ArrayList<e.a.a.g.d.i.s1.g.c> arrayList2 = dVar.f5774b;
                String strRemoveFirst = linkedList.removeFirst();
                j.d(strRemoveFirst, "srcList.removeFirst()");
                String str2 = strRemoveFirst;
                int i4 = f5790d;
                arrayList2.add(new e.a.a.g.d.i.s1.g.c(str2, i4 + f3, i4 + desiredWidth, false, true, 8));
            }
            i2++;
            f3 = desiredWidth;
        }
        c(dVar, strArr);
    }

    public final void b(e.a.a.g.d.i.s1.g.d dVar, String[] strArr, TextPaint textPaint, float f2, float f3, LinkedList<String> linkedList) {
        if (!ReadBookConfig.INSTANCE.getTextFullJustify()) {
            a(dVar, strArr, textPaint, f3, linkedList);
            return;
        }
        float fZ2 = (f5792f - f2) / f.z2(strArr);
        int length = strArr.length;
        float f4 = f3;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            int i4 = i3 + 1;
            float desiredWidth = StaticLayout.getDesiredWidth(str, textPaint) + f4;
            if (i3 != f.z2(strArr)) {
                desiredWidth += fZ2;
            }
            float f5 = desiredWidth;
            if (linkedList == null || !j.a(str, "▩")) {
                ArrayList<e.a.a.g.d.i.s1.g.c> arrayList = dVar.f5774b;
                float f6 = f5790d;
                arrayList.add(new e.a.a.g.d.i.s1.g.c(str, f6 + f4, f6 + f5, false, false, 24));
            } else {
                ArrayList<e.a.a.g.d.i.s1.g.c> arrayList2 = dVar.f5774b;
                String strRemoveFirst = linkedList.removeFirst();
                j.d(strRemoveFirst, "srcList.removeFirst()");
                String str2 = strRemoveFirst;
                float f7 = f5790d;
                arrayList2.add(new e.a.a.g.d.i.s1.g.c(str2, f7 + f4, f7 + f5, false, true, 8));
            }
            i2++;
            f4 = f5;
            i3 = i4;
        }
        c(dVar, strArr);
    }

    public final void c(e.a.a.g.d.i.s1.g.d dVar, String[] strArr) {
        float f2 = ((e.a.a.g.d.i.s1.g.c) e.r(dVar.f5774b)).f5771c;
        float f3 = f5794h;
        if (f2 <= f3) {
            return;
        }
        float length = (f2 - f3) / strArr.length;
        int i2 = 0;
        int iZ2 = f.z2(strArr);
        if (iZ2 < 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            ArrayList<e.a.a.g.d.i.s1.g.c> arrayList = dVar.f5774b;
            e.a.a.g.d.i.s1.g.c cVar = arrayList.get(e.m(arrayList) - i2);
            j.d(cVar, "textChars[textChars.lastIndex - index]");
            e.a.a.g.d.i.s1.g.c cVar2 = cVar;
            float length2 = (strArr.length - i2) * length;
            cVar2.f5770b -= length2;
            cVar2.f5771c -= length2;
            if (i2 == iZ2) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x022f  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e.a.a.g.d.i.s1.g.b e(@org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r38, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.BookChapter r39, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r40, int r41) {
        /*
            Method dump skipped, instruction units count: 983
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.d.i.s1.h.a.e(io.legado.app.data.entities.Book, io.legado.app.data.entities.BookChapter, java.util.List, int):e.a.a.g.d.i.s1.g.b");
    }

    public final float f(@NotNull TextPaint textPaint) {
        j.e(textPaint, "<this>");
        return (textPaint.getFontMetrics().descent - textPaint.getFontMetrics().ascent) + textPaint.getFontMetrics().leading;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0268 A[LOOP:0: B:13:0x003d->B:52:0x0268, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0272 A[EDGE_INSN: B:58:0x0272->B:54:0x0272 BREAK  A[LOOP:0: B:13:0x003d->B:52:0x0268], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float h(java.lang.String r35, float r36, java.util.ArrayList<e.a.a.g.d.i.s1.g.e> r37, java.lang.StringBuilder r38, boolean r39, android.text.TextPaint r40, java.util.LinkedList<java.lang.String> r41) {
        /*
            Method dump skipped, instruction units count: 645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.d.i.s1.h.a.h(java.lang.String, float, java.util.ArrayList, java.lang.StringBuilder, boolean, android.text.TextPaint, java.util.LinkedList):float");
    }

    public final void i() {
        Object objM11constructorimpl;
        g gVar;
        g gVar2;
        Typeface typefaceCreateFromFile;
        String textFont = ReadBookConfig.INSTANCE.getTextFont();
        try {
            if (f.t3(textFont) && Build.VERSION.SDK_INT >= 26) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = h.g().getContentResolver().openFileDescriptor(Uri.parse(textFont), "r");
                j.c(parcelFileDescriptorOpenFileDescriptor);
                typefaceCreateFromFile = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).build();
            } else if (f.t3(textFont)) {
                Context contextG = h.g();
                Uri uri = Uri.parse(textFont);
                j.d(uri, "parse(fontPath)");
                typefaceCreateFromFile = Typeface.createFromFile(a0.b(contextG, uri));
            } else {
                if (textFont.length() > 0) {
                    typefaceCreateFromFile = Typeface.createFromFile(textFont);
                } else {
                    e.a.a.d.e eVar = e.a.a.d.e.a;
                    int iM2 = f.M2(h.g(), "system_typefaces", 0, 2);
                    typefaceCreateFromFile = iM2 != 1 ? iM2 != 2 ? Typeface.SANS_SERIF : Typeface.MONOSPACE : Typeface.SERIF;
                }
            }
            objM11constructorimpl = f.h.m11constructorimpl(typefaceCreateFromFile);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
        }
        if (f.h.m14exceptionOrNullimpl(objM11constructorimpl) != null) {
            ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
            readBookConfig.setTextFont("");
            readBookConfig.save();
            objM11constructorimpl = Typeface.SANS_SERIF;
        }
        j.d(objM11constructorimpl, "runCatching {\n            when {\n                fontPath.isContentScheme() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {\n                    val fd = appCtx.contentResolver\n                        .openFileDescriptor(Uri.parse(fontPath), \"r\")!!\n                        .fileDescriptor\n                    Typeface.Builder(fd).build()\n                }\n                fontPath.isContentScheme() -> {\n                    Typeface.createFromFile(RealPathUtil.getPath(appCtx, Uri.parse(fontPath)))\n                }\n                fontPath.isNotEmpty() -> Typeface.createFromFile(fontPath)\n                else -> when (AppConfig.systemTypefaces) {\n                    1 -> Typeface.SERIF\n                    2 -> Typeface.MONOSPACE\n                    else -> Typeface.SANS_SERIF\n                }\n            }\n        }.getOrElse {\n            ReadBookConfig.textFont = \"\"\n            ReadBookConfig.save()\n            Typeface.SANS_SERIF\n        }");
        Typeface typeface = (Typeface) objM11constructorimpl;
        n = typeface;
        Typeface typefaceCreate = Typeface.create(typeface, 1);
        Typeface typefaceCreate2 = Typeface.create(typeface, 0);
        ReadBookConfig readBookConfig2 = ReadBookConfig.INSTANCE;
        int textBold = readBookConfig2.getTextBold();
        if (textBold != 1) {
            if (textBold != 2) {
                gVar = new g(typefaceCreate, typefaceCreate2);
            } else if (Build.VERSION.SDK_INT >= 28) {
                gVar2 = new g(typefaceCreate2, Typeface.create(typeface, 300, false));
                gVar = gVar2;
            } else {
                gVar = new g(typefaceCreate2, typefaceCreate2);
            }
        } else if (Build.VERSION.SDK_INT >= 28) {
            gVar2 = new g(Typeface.create(typeface, 900, false), typefaceCreate);
            gVar = gVar2;
        } else {
            gVar = new g(typefaceCreate, typefaceCreate);
        }
        Typeface typeface2 = (Typeface) gVar.component1();
        Typeface typeface3 = (Typeface) gVar.component2();
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(readBookConfig2.getTextColor());
        textPaint.setLetterSpacing(readBookConfig2.getLetterSpacing());
        textPaint.setTypeface(typeface2);
        textPaint.setTextSize(f.W2(readBookConfig2.getTitleSize() + readBookConfig2.getTextSize()));
        textPaint.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setColor(readBookConfig2.getTextColor());
        textPaint2.setLetterSpacing(readBookConfig2.getLetterSpacing());
        textPaint2.setTypeface(typeface3);
        textPaint2.setTextSize(f.W2(readBookConfig2.getTextSize()));
        textPaint2.setAntiAlias(true);
        g gVar3 = new g(textPaint, textPaint2);
        TextPaint textPaint3 = (TextPaint) gVar3.getFirst();
        j.e(textPaint3, "<set-?>");
        o = textPaint3;
        TextPaint textPaint4 = (TextPaint) gVar3.getSecond();
        j.e(textPaint4, "<set-?>");
        p = textPaint4;
        f5796j = readBookConfig2.getLineSpacingExtra();
        f5797k = readBookConfig2.getParagraphSpacing();
        f5798l = f.m2(readBookConfig2.getTitleTopSpacing());
        m = f.m2(readBookConfig2.getTitleBottomSpacing());
        j();
    }

    public final void j() {
        if (f5788b <= 0 || f5789c <= 0) {
            return;
        }
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        f5790d = f.m2(readBookConfig.getPaddingLeft());
        f5791e = f.m2(readBookConfig.getPaddingTop());
        f5792f = (f5788b - f5790d) - f.m2(readBookConfig.getPaddingRight());
        int iM2 = (f5789c - f5791e) - f.m2(readBookConfig.getPaddingBottom());
        f5793g = iM2;
        f5794h = f5790d + f5792f;
        f5795i = f5791e + iM2;
    }
}
