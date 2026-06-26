package e.b.a.s.n;

import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.f;
import c.b.a.q.j.c;
import c.b.a.q.j.h;
import c.b.a.q.k.d;
import e.b.a.e;
import e.b.a.g;
import e.b.a.h;
import e.b.a.s.l;
import io.noties.markwon.R$id;
import java.util.HashMap;
import java.util.Map;
import k.c.d.m;

/* JADX INFO: compiled from: GlideImagesPlugin.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends e.b.a.a {
    public final a a;

    /* JADX INFO: compiled from: GlideImagesPlugin.java */
    public static class a extends e.b.a.s.b {
        public final InterfaceC0175b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<e.b.a.s.a, h<?>> f6118b = new HashMap(2);

        /* JADX INFO: renamed from: e.b.a.s.n.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideImagesPlugin.java */
        public class C0174a extends c<Drawable> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final e.b.a.s.a f6119d;

            public C0174a(@NonNull e.b.a.s.a aVar) {
                this.f6119d = aVar;
            }

            @Override // c.b.a.q.j.h
            public void b(@NonNull Object obj, @Nullable d dVar) {
                Drawable drawable = (Drawable) obj;
                if (a.this.f6118b.remove(this.f6119d) == null || !this.f6119d.c()) {
                    return;
                }
                f.o0(drawable);
                this.f6119d.e(drawable);
            }

            @Override // c.b.a.q.j.c, c.b.a.q.j.h
            public void d(@Nullable Drawable drawable) {
                if (a.this.f6118b.remove(this.f6119d) == null || drawable == null || !this.f6119d.c()) {
                    return;
                }
                f.o0(drawable);
                this.f6119d.e(drawable);
            }

            @Override // c.b.a.q.j.c, c.b.a.q.j.h
            public void e(@Nullable Drawable drawable) {
                if (drawable == null || !this.f6119d.c()) {
                    return;
                }
                f.o0(drawable);
                this.f6119d.e(drawable);
            }

            @Override // c.b.a.q.j.h
            public void g(@Nullable Drawable drawable) {
                e.b.a.s.a aVar;
                Drawable drawable2;
                if (!this.f6119d.c() || (drawable2 = (aVar = this.f6119d).f6101f) == null) {
                    return;
                }
                drawable2.setCallback(null);
                aVar.f6101f = null;
                aVar.setBounds(0, 0, 0, 0);
            }
        }

        public a(@NonNull InterfaceC0175b interfaceC0175b) {
            this.a = interfaceC0175b;
        }

        @Override // e.b.a.s.b
        public void a(@NonNull e.b.a.s.a aVar) {
            h<?> hVarRemove = this.f6118b.remove(aVar);
            if (hVarRemove != null) {
                ((e.b.a.s.n.a) this.a).a.j(hVarRemove);
            }
        }

        @Override // e.b.a.s.b
        public void b(@NonNull e.b.a.s.a aVar) {
            C0174a c0174a = new C0174a(aVar);
            this.f6118b.put(aVar, c0174a);
            c.b.a.h<Drawable> hVarK = ((e.b.a.s.n.a) this.a).a.k(aVar.a);
            hVarK.D(c0174a, null, hVarK, c.b.a.s.d.a);
        }

        @Override // e.b.a.s.b
        @Nullable
        public Drawable c(@NonNull e.b.a.s.a aVar) {
            return null;
        }
    }

    /* JADX INFO: renamed from: e.b.a.s.n.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlideImagesPlugin.java */
    public interface InterfaceC0175b {
    }

    public b(@NonNull InterfaceC0175b interfaceC0175b) {
        this.a = new a(interfaceC0175b);
    }

    @Override // e.b.a.a, e.b.a.f
    public void a(@NonNull g.a aVar) {
        ((h.a) aVar).a.put(m.class, new l());
    }

    @Override // e.b.a.a, e.b.a.f
    public void f(@NonNull e.b bVar) {
        bVar.f5975b = this.a;
    }

    @Override // e.b.a.a, e.b.a.f
    public void h(@NonNull TextView textView) {
        int i2 = R$id.markwon_drawables_scheduler_last_text_hashcode;
        Integer num = (Integer) textView.getTag(i2);
        int iHashCode = textView.getText().hashCode();
        if (num == null || num.intValue() != iHashCode) {
            textView.setTag(i2, Integer.valueOf(iHashCode));
            e.b.a.s.g[] gVarArrG1 = f.G1(textView);
            if (gVarArrG1 == null || gVarArrG1.length <= 0) {
                return;
            }
            int i3 = R$id.markwon_drawables_scheduler;
            if (textView.getTag(i3) == null) {
                e.b.a.s.d dVar = new e.b.a.s.d(textView);
                textView.addOnAttachStateChangeListener(dVar);
                textView.setTag(i3, dVar);
            }
            e.b.a.s.f fVar = new e.b.a.s.f(textView);
            for (e.b.a.s.g gVar : gVarArrG1) {
                e.b.a.s.a aVar = gVar.f6111b;
                aVar.d(new e.b.a.s.e(textView, fVar, aVar.getBounds()));
            }
        }
    }

    @Override // e.b.a.a, e.b.a.f
    public void i(@NonNull TextView textView, @NonNull Spanned spanned) {
        f.T5(textView);
    }
}
