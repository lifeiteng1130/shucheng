package c.b.a.p;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public final List<C0025a<?>> a = new ArrayList();

    /* JADX INFO: renamed from: c.b.a.p.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EncoderRegistry.java */
    public static final class C0025a<T> {
        public final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.b.a.m.d<T> f614b;

        public C0025a(@NonNull Class<T> cls, @NonNull c.b.a.m.d<T> dVar) {
            this.a = cls;
            this.f614b = dVar;
        }
    }
}
