package f.h0;

import f.c0.b.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends f.c0.c.k implements p<CharSequence, Integer, f.g<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ char[] $delimiters;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(char[] cArr, boolean z) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z;
    }

    @Nullable
    public final f.g<Integer, Integer> invoke(@NotNull CharSequence charSequence, int i2) {
        f.c0.c.j.e(charSequence, "$receiver");
        int iR = k.r(charSequence, this.$delimiters, i2, this.$ignoreCase);
        if (iR < 0) {
            return null;
        }
        return new f.g<>(Integer.valueOf(iR), 1);
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ f.g<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }
}
