package f.h0;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum i implements c {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);

    private final int mask;
    private final int value;

    i(int i2, int i3, int i4, f.c0.c.f fVar) {
        i3 = (i4 & 2) != 0 ? i2 : i3;
        this.value = i2;
        this.mask = i3;
    }

    @Override // f.h0.c
    public int getMask() {
        return this.mask;
    }

    @Override // f.h0.c
    public int getValue() {
        return this.value;
    }
}
