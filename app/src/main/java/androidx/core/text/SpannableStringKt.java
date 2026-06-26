package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import f.c0.c.j;
import f.e0.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpannableString.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\f\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\f\u0010\r\u001a$\u0010\f\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "Landroid/text/Spannable;", "toSpannable", "(Ljava/lang/CharSequence;)Landroid/text/Spannable;", "Lf/v;", "clearSpans", "(Landroid/text/Spannable;)V", "", "start", "end", "", "span", "set", "(Landroid/text/Spannable;IILjava/lang/Object;)V", "Lf/e0/d;", "range", "(Landroid/text/Spannable;Lf/e0/d;Ljava/lang/Object;)V", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@NotNull Spannable spannable) {
        j.f(spannable, "$this$clearSpans");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        j.b(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@NotNull Spannable spannable, int i2, int i3, @NotNull Object obj) {
        j.f(spannable, "$this$set");
        j.f(obj, "span");
        spannable.setSpan(obj, i2, i3, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence charSequence) {
        j.f(charSequence, "$this$toSpannable");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        j.b(spannableStringValueOf, "SpannableString.valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void set(@NotNull Spannable spannable, @NotNull d dVar, @NotNull Object obj) {
        j.f(spannable, "$this$set");
        j.f(dVar, "range");
        j.f(obj, "span");
        spannable.setSpan(obj, dVar.getStart().intValue(), dVar.getEndInclusive().intValue(), 17);
    }
}
