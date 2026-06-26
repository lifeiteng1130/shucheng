package e.b.a.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.r.e;
import e.b.a.r.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: MarkwonHtmlRendererImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends i {
    public final Map<String, l> a;

    /* JADX INFO: compiled from: MarkwonHtmlRendererImpl.java */
    public class a {
        public final /* synthetic */ e.b.a.i a;

        public a(e.b.a.i iVar) {
            this.a = iVar;
        }

        public void a(@NonNull List<e.a> list) {
            for (e.a aVar : list) {
                if (aVar.isClosed()) {
                    l lVarB = j.this.b(aVar.name());
                    if (lVarB != null) {
                        lVarB.a(this.a, j.this, aVar);
                    } else {
                        a(aVar.e());
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: MarkwonHtmlRendererImpl.java */
    public static class b {
        public final Map<String, l> a = new HashMap(2);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6056b;

        public void a(@NonNull l lVar) {
            for (String str : lVar.b()) {
                if (!this.a.containsKey(str)) {
                    this.a.put(str, lVar);
                }
            }
        }
    }

    public j(boolean z, @NonNull Map<String, l> map) {
        this.a = map;
    }

    @Override // e.b.a.r.i
    public void a(@NonNull e.b.a.i iVar, @NonNull g gVar) {
        l lVarB;
        l lVarB2;
        h hVar = (h) gVar;
        if (hVar.f6051f.size() > 0) {
            for (e.b bVar : Collections.unmodifiableList(hVar.f6051f)) {
                if (bVar.isClosed() && (lVarB2 = b(bVar.name())) != null) {
                    lVarB2.a(iVar, this, bVar);
                }
            }
            hVar.f6051f.clear();
        } else {
            for (e.b bVar2 : Collections.emptyList()) {
                if (bVar2.isClosed() && (lVarB = b(bVar2.name())) != null) {
                    lVarB.a(iVar, this, bVar2);
                }
            }
        }
        a aVar = new a(iVar);
        f.a aVar2 = hVar.f6052g;
        while (true) {
            f.a aVar3 = aVar2.f6045e;
            if (aVar3 == null) {
                break;
            } else {
                aVar2 = aVar3;
            }
        }
        List<e.a> listE = aVar2.e();
        if (listE.size() > 0) {
            aVar.a(listE);
        } else {
            aVar.a(Collections.emptyList());
        }
        hVar.f6052g = f.a.h();
        hVar.f6051f.clear();
        hVar.f6052g = f.a.h();
    }

    @Override // e.b.a.r.i
    @Nullable
    public l b(@NonNull String str) {
        return this.a.get(str);
    }
}
