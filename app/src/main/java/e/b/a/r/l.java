package e.b.a.r;

import androidx.annotation.NonNull;
import e.b.a.r.e;
import java.util.Collection;

/* JADX INFO: compiled from: TagHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    public static void c(@NonNull e.b.a.i iVar, @NonNull i iVar2, @NonNull e.a aVar) {
        for (e.a aVar2 : aVar.e()) {
            if (aVar2.isClosed()) {
                l lVarB = iVar2.b(aVar2.name());
                if (lVarB != null) {
                    lVarB.a(iVar, iVar2, aVar2);
                } else {
                    c(iVar, iVar2, aVar2);
                }
            }
        }
    }

    public abstract void a(@NonNull e.b.a.i iVar, @NonNull i iVar2, @NonNull e eVar);

    @NonNull
    public abstract Collection<String> b();
}
