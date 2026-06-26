package c.b.a;

import c.b.a.j;

/* JADX INFO: compiled from: TransitionOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public c.b.a.q.k.e<? super TranscodeType> a = (c.b.a.q.k.e<? super TranscodeType>) c.b.a.q.k.c.f665b;

    public final CHILD a() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Object clone() {
        try {
            return (j) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
