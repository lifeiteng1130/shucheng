package c.b.a.m.q.c0;

import c.b.a.m.q.c0.l;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: BaseKeyPool.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends l> {
    public final Queue<T> a;

    public c() {
        char[] cArr = c.b.a.s.i.a;
        this.a = new ArrayDeque(20);
    }

    public abstract T a();

    public T b() {
        T tPoll = this.a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
