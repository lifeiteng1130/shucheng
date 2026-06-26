package e.b.a.p;

import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import e.b.a.g;
import e.b.a.h;
import e.b.a.i;
import e.b.a.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.c.d.t;
import k.c.d.u;
import k.c.d.v;
import k.c.d.w;
import k.c.d.x;
import k.c.d.y;

/* JADX INFO: compiled from: CorePlugin.java */
/* JADX INFO: loaded from: classes3.dex */
public class p extends e.b.a.a {
    public final List<a> a = new ArrayList(0);

    /* JADX INFO: compiled from: CorePlugin.java */
    public interface a {
        void a(@NonNull e.b.a.i iVar, @NonNull String str, int i2);
    }

    @VisibleForTesting
    public static void l(@NonNull e.b.a.i iVar, @Nullable String str, @NonNull String str2, @NonNull k.c.d.s sVar) {
        e.b.a.j jVar = (e.b.a.j) iVar;
        Objects.requireNonNull((e.b.a.b) jVar.f5984e);
        jVar.b();
        int iC = jVar.c();
        e.b.a.o oVar = jVar.f5982c;
        oVar.a.append((char) 160);
        oVar.a.append('\n');
        Objects.requireNonNull(jVar.a.f5970c);
        oVar.a(oVar.length(), str2);
        oVar.a.append((CharSequence) str2);
        jVar.b();
        jVar.f5982c.a.append((char) 160);
        e.b.a.k<String> kVar = q.f5996g;
        e.b.a.m mVar = jVar.f5981b;
        if (str == null) {
            mVar.a.remove(kVar);
        } else {
            mVar.a.put(kVar, str);
        }
        jVar.e(sVar, iC);
        jVar.a(sVar);
    }

    @Override // e.b.a.a, e.b.a.f
    public void a(@NonNull g.a aVar) {
        e.b.a.p.t.b bVar = new e.b.a.p.t.b();
        h.a aVar2 = (h.a) aVar;
        aVar2.a.put(w.class, new e.b.a.p.t.h());
        aVar2.a.put(k.c.d.g.class, new e.b.a.p.t.d());
        aVar2.a.put(k.c.d.b.class, new e.b.a.p.t.a());
        aVar2.a.put(k.c.d.d.class, new e.b.a.p.t.c());
        aVar2.a.put(k.c.d.h.class, bVar);
        aVar2.a.put(k.c.d.n.class, bVar);
        aVar2.a.put(k.c.d.r.class, new e.b.a.p.t.g());
        aVar2.a.put(k.c.d.j.class, new e.b.a.p.t.e());
        aVar2.a.put(k.c.d.o.class, new e.b.a.p.t.f());
        aVar2.a.put(y.class, new e.b.a.p.t.i());
    }

    @Override // e.b.a.a, e.b.a.f
    public void h(@NonNull TextView textView) {
        if (textView.getMovementMethod() == null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // e.b.a.a, e.b.a.f
    public void i(@NonNull TextView textView, @NonNull Spanned spanned) {
        e.b.a.p.u.h[] hVarArr;
        if ((spanned instanceof Spanned) && (hVarArr = (e.b.a.p.u.h[]) spanned.getSpans(0, spanned.length(), e.b.a.p.u.h.class)) != null) {
            TextPaint paint = textView.getPaint();
            for (e.b.a.p.u.h hVar : hVarArr) {
                hVar.f6025d = (int) (paint.measureText(hVar.f6023b) + 0.5f);
            }
        }
        if (spanned instanceof Spannable) {
            Spannable spannable = (Spannable) spanned;
            e.b.a.p.u.k[] kVarArr = (e.b.a.p.u.k[]) spannable.getSpans(0, spannable.length(), e.b.a.p.u.k.class);
            if (kVarArr != null) {
                for (e.b.a.p.u.k kVar : kVarArr) {
                    spannable.removeSpan(kVar);
                }
            }
            spannable.setSpan(new e.b.a.p.u.k(textView), 0, spannable.length(), 18);
        }
    }

    @Override // e.b.a.a, e.b.a.f
    public void j(@NonNull i.b bVar) {
        j.a aVar = (j.a) bVar;
        aVar.a.put(x.class, new g(this));
        aVar.a.put(w.class, new h());
        aVar.a.put(k.c.d.g.class, new i());
        aVar.a.put(k.c.d.b.class, new j());
        aVar.a.put(k.c.d.d.class, new k());
        aVar.a.put(k.c.d.h.class, new l());
        aVar.a.put(k.c.d.n.class, new m());
        aVar.a.put(k.c.d.m.class, new n());
        aVar.a.put(k.c.d.c.class, new s());
        aVar.a.put(t.class, new s());
        aVar.a.put(k.c.d.r.class, new o());
        aVar.a.put(y.class, new e.b.a.p.a());
        aVar.a.put(k.c.d.j.class, new b());
        aVar.a.put(v.class, new c());
        aVar.a.put(k.c.d.i.class, new d());
        aVar.a.put(u.class, new e());
        aVar.a.put(k.c.d.o.class, new f());
    }
}
