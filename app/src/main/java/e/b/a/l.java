package e.b.a;

import androidx.annotation.NonNull;
import e.b.a.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: RegistryImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements f.a {
    public final List<f> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f5985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<f> f5986c = new HashSet(3);

    public l(@NonNull List<f> list) {
        this.a = list;
        this.f5985b = new ArrayList(list.size());
    }
}
