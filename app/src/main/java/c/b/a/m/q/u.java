package c.b.a.m.q;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import c.b.a.m.q.j;
import com.bumptech.glide.load.data.DataRewinder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: LoadPath.java */
/* JADX INFO: loaded from: classes.dex */
public class u<Data, ResourceType, Transcode> {
    public final Pools.Pool<List<Throwable>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends j<Data, ResourceType, Transcode>> f472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f473c;

    public u(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<j<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.a = pool;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f472b = list;
        StringBuilder sbR = c.a.a.a.a.r("Failed LoadPath{");
        sbR.append(cls.getSimpleName());
        sbR.append("->");
        sbR.append(cls2.getSimpleName());
        sbR.append("->");
        sbR.append(cls3.getSimpleName());
        sbR.append("}");
        this.f473c = sbR.toString();
    }

    public w<Transcode> a(DataRewinder<Data> dataRewinder, @NonNull c.b.a.m.l lVar, int i2, int i3, j.a<ResourceType> aVar) {
        List<Throwable> listAcquire = this.a.acquire();
        Objects.requireNonNull(listAcquire, "Argument must not be null");
        List<Throwable> list = listAcquire;
        try {
            int size = this.f472b.size();
            w<Transcode> wVarA = null;
            for (int i4 = 0; i4 < size; i4++) {
                try {
                    wVarA = this.f472b.get(i4).a(dataRewinder, i2, i3, lVar, aVar);
                } catch (r e2) {
                    list.add(e2);
                }
                if (wVarA != null) {
                    break;
                }
            }
            if (wVarA != null) {
                return wVarA;
            }
            throw new r(this.f473c, new ArrayList(list));
        } finally {
            this.a.release(list);
        }
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("LoadPath{decodePaths=");
        sbR.append(Arrays.toString(this.f472b.toArray()));
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
