package androidx.core.text;

import android.text.TextUtils;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CharSequence.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "", "isDigitsOnly", "(Ljava/lang/CharSequence;)Z", "", "trimmedLength", "(Ljava/lang/CharSequence;)I", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(@NotNull CharSequence charSequence) {
        j.f(charSequence, "$this$isDigitsOnly");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(@NotNull CharSequence charSequence) {
        j.f(charSequence, "$this$trimmedLength");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
