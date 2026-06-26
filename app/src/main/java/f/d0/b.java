package f.d0;

import f.c0.c.j;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends f.d0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6127b = new a();

    /* JADX INFO: compiled from: PlatformRandom.kt */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // f.d0.a
    @NotNull
    public Random getImpl() {
        Random random = this.f6127b.get();
        j.d(random, "implStorage.get()");
        return random;
    }
}
