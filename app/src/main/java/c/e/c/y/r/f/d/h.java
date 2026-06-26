package c.e.c.y.r.f.d;

/* JADX INFO: compiled from: AI01decoder.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends j {
    public h(c.e.c.v.a aVar) {
        super(aVar);
    }

    public final void b(StringBuilder sb, int i2) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        c(sb, i2, length);
    }

    public final void c(StringBuilder sb, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int iC = this.f1507b.c((i4 * 10) + i2, 10);
            if (iC / 100 == 0) {
                sb.append('0');
            }
            if (iC / 10 == 0) {
                sb.append('0');
            }
            sb.append(iC);
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 13; i6++) {
            int iCharAt = sb.charAt(i6 + i3) - '0';
            if ((i6 & 1) == 0) {
                iCharAt *= 3;
            }
            i5 += iCharAt;
        }
        int i7 = 10 - (i5 % 10);
        sb.append(i7 != 10 ? i7 : 0);
    }
}
