package c.b.a.m.q;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.DataFetcher;

/* JADX INFO: compiled from: DataFetcherGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public interface g {

    /* JADX INFO: compiled from: DataFetcherGenerator.java */
    public interface a {
        void a(c.b.a.m.j jVar, Exception exc, DataFetcher<?> dataFetcher, c.b.a.m.a aVar);

        void c();

        void d(c.b.a.m.j jVar, @Nullable Object obj, DataFetcher<?> dataFetcher, c.b.a.m.a aVar, c.b.a.m.j jVar2);
    }

    boolean b();

    void cancel();
}
