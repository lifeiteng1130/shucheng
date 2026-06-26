package k.a.a.a.m0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import k.a.a.a.h0;
import k.a.a.a.i0;
import k.a.a.a.s;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: IntervalSet.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements e {
    public static final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f8513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<h> f8514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8515d;

    static {
        i iVarH = h(0, s.MAX_CHAR_VALUE);
        a = iVarH;
        iVarH.j(true);
        i iVar = new i(new int[0]);
        f8513b = iVar;
        iVar.j(true);
    }

    public i(int... iArr) {
        this.f8514c = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            a(i2);
        }
    }

    public static i h(int i2, int i3) {
        i iVar = new i(new int[0]);
        iVar.b(i2, i3);
        return iVar;
    }

    public static i l(i iVar, i iVar2) {
        int i2 = 0;
        if (iVar.g()) {
            return new i(new int[0]);
        }
        i iVar3 = new i(new int[0]);
        iVar3.c(iVar);
        if (!iVar2.g()) {
            int i3 = 0;
            while (i2 < iVar3.f8514c.size() && i3 < iVar2.f8514c.size()) {
                h hVar = iVar3.f8514c.get(i2);
                h hVar2 = iVar2.f8514c.get(i3);
                int i4 = hVar2.f8512d;
                int i5 = hVar.f8511c;
                if (i4 >= i5) {
                    int i6 = hVar2.f8511c;
                    int i7 = hVar.f8512d;
                    if (i6 <= i7) {
                        h hVar3 = i6 > i5 ? new h(i5, i6 - 1) : null;
                        h hVar4 = i4 < i7 ? new h(i4 + 1, i7) : null;
                        if (hVar3 != null) {
                            if (hVar4 != null) {
                                iVar3.f8514c.set(i2, hVar3);
                                i2++;
                                iVar3.f8514c.add(i2, hVar4);
                            } else {
                                iVar3.f8514c.set(i2, hVar3);
                            }
                        } else if (hVar4 != null) {
                            iVar3.f8514c.set(i2, hVar4);
                        } else {
                            iVar3.f8514c.remove(i2);
                        }
                    }
                    i2++;
                }
                i3++;
            }
        }
        return iVar3;
    }

    public void a(int i2) {
        if (this.f8515d) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        }
        b(i2, i2);
    }

    public void b(int i2, int i3) {
        h hVarC = h.c(i2, i3);
        if (this.f8515d) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        }
        if (hVarC.f8512d < hVarC.f8511c) {
            return;
        }
        ListIterator<h> listIterator = this.f8514c.listIterator();
        while (listIterator.hasNext()) {
            h next = listIterator.next();
            if (hVarC.equals(next)) {
                return;
            }
            if (hVarC.a(next) || !hVarC.b(next)) {
                h hVarD = hVarC.d(next);
                listIterator.set(hVarD);
                while (listIterator.hasNext()) {
                    h next2 = listIterator.next();
                    if (!hVarD.a(next2) && hVarD.b(next2)) {
                        return;
                    }
                    listIterator.remove();
                    listIterator.previous();
                    listIterator.set(hVarD.d(next2));
                    listIterator.next();
                }
                return;
            }
            int i4 = hVarC.f8511c;
            int i5 = next.f8511c;
            if (i4 < i5 && hVarC.f8512d < i5) {
                listIterator.previous();
                listIterator.add(hVarC);
                return;
            }
        }
        this.f8514c.add(hVarC);
    }

    public i c(e eVar) {
        if (eVar == null) {
            return this;
        }
        int i2 = 0;
        if (eVar instanceof i) {
            i iVar = (i) eVar;
            int size = iVar.f8514c.size();
            while (i2 < size) {
                h hVar = iVar.f8514c.get(i2);
                b(hVar.f8511c, hVar.f8512d);
                i2++;
            }
        } else {
            i iVar2 = (i) eVar;
            ArrayList arrayList = new ArrayList();
            int size2 = iVar2.f8514c.size();
            while (i2 < size2) {
                h hVar2 = iVar2.f8514c.get(i2);
                int i3 = hVar2.f8512d;
                for (int i4 = hVar2.f8511c; i4 <= i3; i4++) {
                    arrayList.add(Integer.valueOf(i4));
                }
                i2++;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a(((Integer) it.next()).intValue());
            }
        }
        return this;
    }

    public boolean d(int i2) {
        int size = this.f8514c.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            h hVar = this.f8514c.get(i4);
            int i5 = hVar.f8511c;
            if (hVar.f8512d < i2) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i2) {
                    return true;
                }
                size = i4 - 1;
            }
        }
        return false;
    }

    public String e(h0 h0Var, int i2) {
        return i2 == -1 ? "<EOF>" : i2 == -2 ? "<EPSILON>" : ((i0) h0Var).a(i2);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        return this.f8514c.equals(((i) obj).f8514c);
    }

    public int f() {
        if (g()) {
            throw new RuntimeException("set is empty");
        }
        return this.f8514c.get(0).f8511c;
    }

    public boolean g() {
        List<h> list = this.f8514c;
        return list == null || list.isEmpty();
    }

    public int hashCode() {
        int iX5 = 0;
        for (h hVar : this.f8514c) {
            iX5 = c.b.a.m.f.X5(c.b.a.m.f.X5(iX5, hVar.f8511c), hVar.f8512d);
        }
        return c.b.a.m.f.I1(iX5, this.f8514c.size() * 2);
    }

    public void i(int i2) {
        if (this.f8515d) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        }
        int size = this.f8514c.size();
        for (int i3 = 0; i3 < size; i3++) {
            h hVar = this.f8514c.get(i3);
            int i4 = hVar.f8511c;
            int i5 = hVar.f8512d;
            if (i2 < i4) {
                return;
            }
            if (i2 == i4 && i2 == i5) {
                this.f8514c.remove(i3);
                return;
            }
            if (i2 == i4) {
                hVar.f8511c = i4 + 1;
                return;
            }
            if (i2 == i5) {
                hVar.f8512d = i5 - 1;
                return;
            }
            if (i2 > i4 && i2 < i5) {
                hVar.f8512d = i2 - 1;
                b(i2 + 1, i5);
            }
        }
    }

    public void j(boolean z) {
        if (this.f8515d && !z) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        }
        this.f8515d = z;
    }

    public int k() {
        int size = this.f8514c.size();
        if (size == 1) {
            h hVar = this.f8514c.get(0);
            return (hVar.f8512d - hVar.f8511c) + 1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            h hVar2 = this.f8514c.get(i3);
            i2 += (hVar2.f8512d - hVar2.f8511c) + 1;
        }
        return i2;
    }

    public String m(h0 h0Var) {
        StringBuilder sb = new StringBuilder();
        List<h> list = this.f8514c;
        if (list == null || list.isEmpty()) {
            return MessageFormatter.DELIM_STR;
        }
        if (k() > 1) {
            sb.append("{");
        }
        Iterator<h> it = this.f8514c.iterator();
        while (it.hasNext()) {
            h next = it.next();
            int i2 = next.f8511c;
            int i3 = next.f8512d;
            if (i2 == i3) {
                sb.append(e(h0Var, i2));
            } else {
                for (int i4 = i2; i4 <= i3; i4++) {
                    if (i4 > i2) {
                        sb.append(", ");
                    }
                    sb.append(e(h0Var, i4));
                }
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (k() > 1) {
            sb.append("}");
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<h> list = this.f8514c;
        if (list == null || list.isEmpty()) {
            return MessageFormatter.DELIM_STR;
        }
        if (k() > 1) {
            sb.append("{");
        }
        Iterator<h> it = this.f8514c.iterator();
        while (it.hasNext()) {
            h next = it.next();
            int i2 = next.f8511c;
            int i3 = next.f8512d;
            if (i2 != i3) {
                sb.append(i2);
                sb.append("..");
                sb.append(i3);
            } else if (i2 == -1) {
                sb.append("<EOF>");
            } else {
                sb.append(i2);
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (k() > 1) {
            sb.append("}");
        }
        return sb.toString();
    }
}
