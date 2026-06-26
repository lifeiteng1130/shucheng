package c.e.c.a0.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final c DATA_MASK_000;
    public static final c DATA_MASK_001;
    public static final c DATA_MASK_010;
    public static final c DATA_MASK_011;
    public static final c DATA_MASK_100;
    public static final c DATA_MASK_101;
    public static final c DATA_MASK_110;
    public static final c DATA_MASK_111;
    public static final /* synthetic */ c[] a;

    /* JADX INFO: compiled from: DataMask.java */
    public enum a extends c {
        public a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // c.e.c.a0.c.c
        public boolean isMasked(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        DATA_MASK_000 = aVar;
        c cVar = new c("DATA_MASK_001", 1) { // from class: c.e.c.a0.c.c.b
            @Override // c.e.c.a0.c.c
            public boolean isMasked(int i2, int i3) {
                return (i2 & 1) == 0;
            }
        };
        DATA_MASK_001 = cVar;
        c cVar2 = new c("DATA_MASK_010", 2) { // from class: c.e.c.a0.c.c.c
            @Override // c.e.c.a0.c.c
            public boolean isMasked(int i2, int i3) {
                return i3 % 3 == 0;
            }
        };
        DATA_MASK_010 = cVar2;
        c cVar3 = new c("DATA_MASK_011", 3) { // from class: c.e.c.a0.c.c.d
            @Override // c.e.c.a0.c.c
            public boolean isMasked(int i2, int i3) {
                return (i2 + i3) % 3 == 0;
            }
        };
        DATA_MASK_011 = cVar3;
        c cVar4 = new c("DATA_MASK_100", 4) { // from class: c.e.c.a0.c.c.e
            @Override // c.e.c.a0.c.c
            public boolean isMasked(int i2, int i3) {
                return (((i3 / 3) + (i2 / 2)) & 1) == 0;
            }
        };
        DATA_MASK_100 = cVar4;
        c cVar5 = new c("DATA_MASK_101", 5) { // from class: c.e.c.a0.c.c.f
            @Override // c.e.c.a0.c.c
            public boolean isMasked(int i2, int i3) {
                return (i2 * i3) % 6 == 0;
            }
        };
        DATA_MASK_101 = cVar5;
        c cVar6 = new c("DATA_MASK_110", 6) { // from class: c.e.c.a0.c.c.g
            @Override // c.e.c.a0.c.c
            public boolean isMasked(int i2, int i3) {
                return (i2 * i3) % 6 < 3;
            }
        };
        DATA_MASK_110 = cVar6;
        c cVar7 = new c("DATA_MASK_111", 7) { // from class: c.e.c.a0.c.c.h
            @Override // c.e.c.a0.c.c
            public boolean isMasked(int i2, int i3) {
                return ((((i2 * i3) % 3) + (i2 + i3)) & 1) == 0;
            }
        };
        DATA_MASK_111 = cVar7;
        a = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
    }

    public c(String str, int i2, a aVar) {
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) a.clone();
    }

    public abstract boolean isMasked(int i2, int i3);

    public final void unmaskBitMatrix(c.e.c.v.b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (isMasked(i3, i4)) {
                    bVar.a(i4, i3);
                }
            }
        }
    }
}
