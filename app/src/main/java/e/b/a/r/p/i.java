package e.b.a.r.p;

import android.text.style.StrikethroughSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ai;
import e.b.a.n;
import e.b.a.o;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;

/* JADX INFO: compiled from: StrikeHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends e.b.a.r.l {
    public static final boolean a;

    static {
        boolean z;
        try {
            Class.forName("org.commonmark.ext.gfm.strikethrough.Strikethrough");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        a = z;
    }

    @Nullable
    public static Object d(@NonNull e.b.a.i iVar) {
        e.b.a.j jVar = (e.b.a.j) iVar;
        e.b.a.e eVar = jVar.a;
        n nVar = ((e.b.a.h) eVar.f5974g).a.get(Strikethrough.class);
        if (nVar == null) {
            return null;
        }
        return nVar.a(eVar, jVar.f5981b);
    }

    @Override // e.b.a.r.l
    public void a(@NonNull e.b.a.i iVar, @NonNull e.b.a.r.i iVar2, @NonNull e.b.a.r.e eVar) {
        if (eVar.c()) {
            e.b.a.r.l.c(iVar, iVar2, eVar.b());
        }
        o.c(((e.b.a.j) iVar).f5982c, a ? d(iVar) : new StrikethroughSpan(), eVar.start(), eVar.f());
    }

    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Arrays.asList(ai.az, "del");
    }
}
