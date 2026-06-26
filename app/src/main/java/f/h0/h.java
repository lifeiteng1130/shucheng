package f.h0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h<T> extends f.c0.c.k implements f.c0.b.l<T, Boolean> {
    public final /* synthetic */ int $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(int i2) {
        super(1);
        this.$value$inlined = i2;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((Enum) obj));
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean invoke(Enum r3) {
        c cVar = (c) r3;
        return (this.$value$inlined & cVar.getMask()) == cVar.getValue();
    }
}
