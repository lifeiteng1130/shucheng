package f.h0;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends f.c0.c.k implements f.c0.b.l<f.e0.d, String> {
    public final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    @Override // f.c0.b.l
    @NotNull
    public final String invoke(@NotNull f.e0.d dVar) {
        f.c0.c.j.e(dVar, "it");
        return k.L(this.$this_splitToSequence, dVar);
    }
}
