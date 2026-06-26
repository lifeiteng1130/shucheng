package e.b.a.q.a;

import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import e.b.a.i;
import e.b.a.j;
import e.b.a.o;
import io.noties.markwon.ext.tables.R$id;
import io.noties.markwon.ext.tables.TableRowSpan;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import k.c.d.s;

/* JADX INFO: compiled from: TablePlugin.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends e.b.a.a {
    public final a a;

    /* JADX INFO: compiled from: TablePlugin.java */
    public static class a {
        public final k a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<TableRowSpan.c> f6028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6030d;

        public a(@NonNull k kVar) {
            this.a = kVar;
        }

        public static void a(a aVar, e.b.a.i iVar, s sVar) {
            Objects.requireNonNull(aVar);
            e.b.a.j jVar = (e.b.a.j) iVar;
            int iC = jVar.c();
            jVar.g(sVar);
            if (aVar.f6028b != null) {
                o oVar = jVar.f5982c;
                int length = oVar.length();
                boolean z = length > 0 && '\n' != oVar.charAt(length - 1);
                if (z) {
                    jVar.f5982c.a.append('\n');
                }
                oVar.a.append((char) 160);
                TableRowSpan tableRowSpan = new TableRowSpan(aVar.a, aVar.f6028b, aVar.f6029c, aVar.f6030d % 2 == 1);
                aVar.f6030d = aVar.f6029c ? 0 : aVar.f6030d + 1;
                if (z) {
                    iC++;
                }
                jVar.d(iC, tableRowSpan);
                aVar.f6028b = null;
            }
        }
    }

    public f(@NonNull k kVar) {
        this.a = new a(kVar);
    }

    @Override // e.b.a.a, e.b.a.f
    public void d(@NonNull k.c.e.d dVar) {
        Set<k.c.a> setSingleton = Collections.singleton(new k.c.b.a.a.f());
        Objects.requireNonNull(setSingleton, "extensions must not be null");
        for (k.c.a aVar : setSingleton) {
            if (aVar instanceof k.c.e.e) {
                ((k.c.e.e) aVar).a(dVar);
            }
        }
    }

    @Override // e.b.a.a, e.b.a.f
    public void e(@NonNull s sVar) {
        a aVar = this.a;
        aVar.f6028b = null;
        aVar.f6029c = false;
        aVar.f6030d = 0;
    }

    @Override // e.b.a.a, e.b.a.f
    public void h(@NonNull TextView textView) {
        Object[] objArrF1 = c.b.a.m.f.F1(textView);
        if (objArrF1 == null || objArrF1.length <= 0) {
            return;
        }
        int i2 = R$id.markwon_tables_scheduler;
        if (textView.getTag(i2) == null) {
            h hVar = new h(textView);
            textView.addOnAttachStateChangeListener(hVar);
            textView.setTag(i2, hVar);
        }
        i iVar = new i(textView);
        for (Object obj : objArrF1) {
            ((TableRowSpan) obj).f7815k = iVar;
        }
    }

    @Override // e.b.a.a, e.b.a.f
    public void i(@NonNull TextView textView, @NonNull Spanned spanned) {
        c.b.a.m.f.S5(textView);
    }

    @Override // e.b.a.a, e.b.a.f
    public void j(@NonNull i.b bVar) {
        a aVar = this.a;
        Objects.requireNonNull(aVar);
        j.a aVar2 = (j.a) bVar;
        aVar2.a.put(k.c.b.a.a.a.class, new e(aVar));
        aVar2.a.put(k.c.b.a.a.b.class, new d(aVar));
        aVar2.a.put(k.c.b.a.a.e.class, new c(aVar));
        aVar2.a.put(k.c.b.a.a.d.class, new b(aVar));
        aVar2.a.put(k.c.b.a.a.c.class, new e.b.a.q.a.a(aVar));
    }
}
