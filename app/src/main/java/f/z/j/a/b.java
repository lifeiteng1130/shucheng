package f.z.j.a;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements f.z.d<Object> {

    @NotNull
    public static final b a = new b();

    @Override // f.z.d
    @NotNull
    public f.z.f getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // f.z.d
    public void resumeWith(@NotNull Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @NotNull
    public String toString() {
        return "This continuation is already complete";
    }
}
