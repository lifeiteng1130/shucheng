package e.b.a.r.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.n;
import e.b.a.r.a;
import e.b.a.s.i;
import e.b.a.s.m.a;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ImageHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends h {
    public final a a;

    /* JADX INFO: compiled from: ImageHandler.java */
    public interface a {
    }

    public d(@NonNull a aVar) {
        this.a = aVar;
    }

    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Collections.singleton("img");
    }

    @Override // e.b.a.r.p.h
    @Nullable
    public Object d(@NonNull e.b.a.e eVar, @NonNull e.b.a.m mVar, @NonNull e.b.a.r.e eVar2) {
        n nVar;
        i.a aVarA;
        i.a aVarA2;
        String str = eVar2.d().get("src");
        e.b.a.s.i iVar = null;
        if (TextUtils.isEmpty(str) || (nVar = ((e.b.a.h) eVar.f5974g).a.get(k.c.d.m.class)) == null) {
            return null;
        }
        Objects.requireNonNull((a.b) eVar.f5972e);
        a aVar = this.a;
        Map<String, String> mapD = eVar2.d();
        e eVar3 = (e) aVar;
        Objects.requireNonNull(eVar3);
        String str2 = mapD.get("style");
        if (!TextUtils.isEmpty(str2)) {
            Objects.requireNonNull((a.b) eVar3.a);
            Iterator<e.b.a.r.b> it = new a.b.C0168a(str2).iterator();
            aVarA = null;
            aVarA2 = null;
            while (true) {
                a.b.C0168a.C0169a c0169a = (a.b.C0168a.C0169a) it;
                if (!c0169a.hasNext()) {
                    break;
                }
                e.b.a.r.b bVar = (e.b.a.r.b) c0169a.next();
                String str3 = bVar.a;
                if ("width".equals(str3)) {
                    aVarA = eVar3.a(bVar.f6038b);
                } else if ("height".equals(str3)) {
                    aVarA2 = eVar3.a(bVar.f6038b);
                }
                if (aVarA != null && aVarA2 != null) {
                    break;
                }
            }
        } else {
            aVarA = null;
            aVarA2 = null;
        }
        if (aVarA == null || aVarA2 == null) {
            if (aVarA == null) {
                aVarA = eVar3.a(mapD.get("width"));
            }
            if (aVarA2 == null) {
                aVarA2 = eVar3.a(mapD.get("height"));
            }
            if (aVarA != null || aVarA2 != null) {
                iVar = new e.b.a.s.i(aVarA, aVarA2);
            }
        } else {
            iVar = new e.b.a.s.i(aVarA, aVarA2);
        }
        e.b.a.s.h.a.b(mVar, str);
        e.b.a.s.h.f6115c.b(mVar, iVar);
        e.b.a.s.h.f6114b.b(mVar, Boolean.FALSE);
        return nVar.a(eVar, mVar);
    }
}
