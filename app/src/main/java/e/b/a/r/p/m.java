package e.b.a.r.p;

import android.text.style.UnderlineSpan;
import androidx.annotation.NonNull;
import com.umeng.analytics.pro.ai;
import e.b.a.o;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: UnderlineHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends e.b.a.r.l {
    @Override // e.b.a.r.l
    public void a(@NonNull e.b.a.i iVar, @NonNull e.b.a.r.i iVar2, @NonNull e.b.a.r.e eVar) {
        if (eVar.c()) {
            e.b.a.r.l.c(iVar, iVar2, eVar.b());
        }
        o.c(((e.b.a.j) iVar).f5982c, new UnderlineSpan(), eVar.start(), eVar.f());
    }

    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Arrays.asList(ai.aE, "ins");
    }
}
