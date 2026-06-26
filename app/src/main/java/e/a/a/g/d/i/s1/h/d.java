package e.a.a.g.d.i.s1.h;

import android.text.Layout;
import android.text.TextPaint;
import f.c0.c.j;
import java.util.Arrays;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ZhLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends Layout {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public int[] f5800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public float[] f5801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final TextPaint f5803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f5804f;

    /* JADX INFO: compiled from: ZhLayout.kt */
    public enum a {
        NORMAL,
        BREAK_ONE_CHAR,
        BREAK_MORE_CHAR,
        CPS_1,
        CPS_2,
        CPS_3;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            return (a[]) Arrays.copyOf(aVarArrValuesCustom, aVarArrValuesCustom.length);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(@org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull android.text.TextPaint r24, int r25) {
        /*
            Method dump skipped, instruction units count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.d.i.s1.h.d.<init>(java.lang.String, android.text.TextPaint, int):void");
    }

    public final void a(int i2) {
        int[] iArr = this.f5800b;
        if (iArr.length <= i2 + 1) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, this.a + i2);
            j.d(iArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.f5800b = iArrCopyOf;
            float[] fArrCopyOf = Arrays.copyOf(this.f5801c, i2 + this.a);
            j.d(fArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.f5801c = fArrCopyOf;
        }
    }

    public final float b(@NotNull String str, @NotNull TextPaint textPaint) {
        j.e(str, "sting");
        j.e(textPaint, "paint");
        return textPaint.measureText(str);
    }

    public final boolean c(String str) {
        return b(str, this.f5803e) < this.f5804f;
    }

    public final boolean d(String str) {
        String[] strArr = {"，", "。", "：", "？", "！", "、", "”", "’", "）", "》", "}", "】", ")", ">", "]", "}", ",", ".", "?", XPath.NOT, ":", "」", "；", ";"};
        for (int i2 = 0; i2 < 24; i2++) {
            if (j.a(strArr[i2], str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(String str) {
        String[] strArr = {"“", "（", "《", "【", "‘", "‘", "(", "<", "[", "{", "「"};
        for (int i2 = 0; i2 < 11; i2++) {
            if (j.a(strArr[i2], str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.Layout
    public int getBottomPadding() {
        return 0;
    }

    @Override // android.text.Layout
    public int getEllipsisCount(int i2) {
        return 0;
    }

    @Override // android.text.Layout
    public int getEllipsisStart(int i2) {
        return 0;
    }

    @Override // android.text.Layout
    public boolean getLineContainsTab(int i2) {
        return true;
    }

    @Override // android.text.Layout
    public int getLineCount() {
        return this.f5802d;
    }

    @Override // android.text.Layout
    public int getLineDescent(int i2) {
        return 0;
    }

    @Override // android.text.Layout
    @Nullable
    public Layout.Directions getLineDirections(int i2) {
        return null;
    }

    @Override // android.text.Layout
    public int getLineStart(int i2) {
        return this.f5800b[i2];
    }

    @Override // android.text.Layout
    public int getLineTop(int i2) {
        return 0;
    }

    @Override // android.text.Layout
    public float getLineWidth(int i2) {
        return this.f5801c[i2];
    }

    @Override // android.text.Layout
    public int getParagraphDirection(int i2) {
        return 0;
    }

    @Override // android.text.Layout
    public int getTopPadding() {
        return 0;
    }
}
