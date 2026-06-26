package k.a.a.a.k0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: ATNState.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8433c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k.a.a.a.m0.i f8436f;
    public a a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8432b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8434d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<o1> f8435e = new ArrayList(4);

    static {
        Collections.unmodifiableList(Arrays.asList("INVALID", "BASIC", "RULE_START", "BLOCK_START", "PLUS_BLOCK_START", "STAR_BLOCK_START", "TOKEN_START", "RULE_STOP", "BLOCK_END", "STAR_LOOP_BACK", "STAR_LOOP_ENTRY", "PLUS_LOOP_BACK", "LOOP_END"));
    }

    public void a(o1 o1Var) {
        int size = this.f8435e.size();
        boolean z = true;
        if (this.f8435e.isEmpty()) {
            this.f8434d = o1Var.b();
        } else if (this.f8434d != o1Var.b()) {
            System.err.format(Locale.getDefault(), "ATN state %d has both epsilon and non-epsilon transitions.\n", Integer.valueOf(this.f8432b));
            this.f8434d = false;
        }
        Iterator<o1> it = this.f8435e.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            o1 next = it.next();
            if (next.f8448b.f8432b == o1Var.f8448b.f8432b && ((next.c() != null && o1Var.c() != null && next.c().equals(o1Var.c())) || (next.b() && o1Var.b()))) {
                break;
            }
        }
        if (z) {
            return;
        }
        this.f8435e.add(size, o1Var);
    }

    public int b() {
        return this.f8435e.size();
    }

    public abstract int c();

    public o1 d(int i2) {
        return this.f8435e.get(i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && this.f8432b == ((i) obj).f8432b;
    }

    public int hashCode() {
        return this.f8432b;
    }

    public String toString() {
        return String.valueOf(this.f8432b);
    }
}
