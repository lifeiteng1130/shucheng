package k.b.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: ObjectUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final a a = new a();

    /* JADX INFO: compiled from: ObjectUtils.java */
    public static class a implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return c.a;
        }
    }
}
