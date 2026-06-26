package e.b.a.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: HtmlTag.java */
/* JADX INFO: loaded from: classes3.dex */
public interface e {

    /* JADX INFO: compiled from: HtmlTag.java */
    public interface a extends e {
        @Nullable
        a a();

        @NonNull
        List<a> e();
    }

    /* JADX INFO: compiled from: HtmlTag.java */
    public interface b extends e {
    }

    @NonNull
    a b();

    boolean c();

    @NonNull
    Map<String, String> d();

    int f();

    boolean isClosed();

    @NonNull
    String name();

    int start();
}
