package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpannableStringBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a)\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aA\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\t2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u000b\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0010\u001a-\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0010\u001a7\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0014\u001a\u00020\u00132\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0014\u001a\u00020\u00132\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0015\u001a-\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0010\u001a5\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u001c\u0010\u0010\u001a-\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u001d\u0010\u0010¨\u0006\u001e"}, d2 = {"Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "Lf/v;", "Lkotlin/ExtensionFunctionType;", "builderAction", "Landroid/text/SpannedString;", "buildSpannedString", "(Lf/c0/b/l;)Landroid/text/SpannedString;", "", "", "spans", "inSpans", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lf/c0/b/l;)Landroid/text/SpannableStringBuilder;", "span", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;Lf/c0/b/l;)Landroid/text/SpannableStringBuilder;", "bold", "(Landroid/text/SpannableStringBuilder;Lf/c0/b/l;)Landroid/text/SpannableStringBuilder;", "italic", "underline", "", "color", "(Landroid/text/SpannableStringBuilder;ILf/c0/b/l;)Landroid/text/SpannableStringBuilder;", "backgroundColor", "strikeThrough", "", "proportion", "scale", "(Landroid/text/SpannableStringBuilder;FLf/c0/b/l;)Landroid/text/SpannableStringBuilder;", "superscript", "subscript", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class SpannableStringBuilderKt {
    @NotNull
    public static final SpannableStringBuilder backgroundColor(@NotNull SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$backgroundColor");
        j.f(lVar, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i2);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder bold(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$bold");
        j.f(lVar, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannedString buildSpannedString(@NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(lVar, "builderAction");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        lVar.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @NotNull
    public static final SpannableStringBuilder color(@NotNull SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$color");
        j.f(lVar, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i2);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder inSpans(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Object[] objArr, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$inSpans");
        j.f(objArr, "spans");
        j.f(lVar, "builderAction");
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        for (Object obj : objArr) {
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder italic(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$italic");
        j.f(lVar, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder scale(@NotNull SpannableStringBuilder spannableStringBuilder, float f2, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$scale");
        j.f(lVar, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f2);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder strikeThrough(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$strikeThrough");
        j.f(lVar, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder subscript(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$subscript");
        j.f(lVar, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder superscript(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$superscript");
        j.f(lVar, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder underline(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$underline");
        j.f(lVar, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder inSpans(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Object obj, @NotNull l<? super SpannableStringBuilder, v> lVar) {
        j.f(spannableStringBuilder, "$this$inSpans");
        j.f(obj, "span");
        j.f(lVar, "builderAction");
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
