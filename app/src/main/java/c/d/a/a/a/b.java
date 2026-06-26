package c.d.a.a.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TrieNode.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char f814b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f817e;
    public int a = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<Character, b<T>> f815c = new HashMap();

    public b(char c2) {
        this.f814b = c2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f814b);
        if (this.f817e != null) {
            sb.append(":");
            sb.append(this.f817e);
        }
        return sb.toString();
    }
}
