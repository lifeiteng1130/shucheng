package f.h0;

import f.g0.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements e {
    public List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matcher f6154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f6155c;

    /* JADX INFO: compiled from: Regex.kt */
    public static final class a extends f.x.b<String> {
        public a() {
        }

        @Override // f.x.a, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return super.contains((String) obj);
            }
            return false;
        }

        @Override // f.x.b, java.util.List, j$.util.List
        public Object get(int i2) {
            String strGroup = f.this.f6154b.group(i2);
            return strGroup != null ? strGroup : "";
        }

        @Override // f.x.b, f.x.a
        public int getSize() {
            return f.this.f6154b.groupCount() + 1;
        }

        @Override // f.x.b, java.util.List, j$.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return super.indexOf((String) obj);
            }
            return -1;
        }

        @Override // f.x.b, java.util.List, j$.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return super.lastIndexOf((String) obj);
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    public static final class b extends f.x.a<d> implements Collection, f.c0.c.z.a, j$.util.Collection {

        /* JADX INFO: compiled from: Regex.kt */
        public static final class a extends f.c0.c.k implements f.c0.b.l<Integer, d> {
            public a() {
                super(1);
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ d invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final d invoke(int i2) {
                b bVar = b.this;
                Matcher matcher = f.this.f6154b;
                f.e0.d dVarF = f.e0.e.f(matcher.start(i2), matcher.end(i2));
                if (dVarF.getStart().intValue() < 0) {
                    return null;
                }
                String strGroup = f.this.f6154b.group(i2);
                f.c0.c.j.d(strGroup, "matchResult.group(index)");
                return new d(strGroup, dVarF);
            }
        }

        public b() {
        }

        @Override // f.x.a, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof d : true) {
                return super.contains((d) obj);
            }
            return false;
        }

        @Override // f.x.a
        public int getSize() {
            return f.this.f6154b.groupCount() + 1;
        }

        @Override // f.x.a, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // f.x.a, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        @NotNull
        public Iterator<d> iterator() {
            f.c0.c.j.e(this, "$this$indices");
            f.e0.d dVar = new f.e0.d(0, size() - 1);
            f.c0.c.j.e(dVar, "$this$asSequence");
            f.x.g gVar = new f.x.g(dVar);
            a aVar = new a();
            f.c0.c.j.e(gVar, "$this$map");
            f.c0.c.j.e(aVar, "transform");
            return new g.a();
        }
    }

    public f(@NotNull Matcher matcher, @NotNull CharSequence charSequence) {
        f.c0.c.j.e(matcher, "matcher");
        f.c0.c.j.e(charSequence, "input");
        this.f6154b = matcher;
        this.f6155c = charSequence;
        new b();
    }

    @Override // f.h0.e
    @NotNull
    public List<String> a() {
        if (this.a == null) {
            this.a = new a();
        }
        List<String> list = this.a;
        f.c0.c.j.c(list);
        return list;
    }

    @Override // f.h0.e
    @NotNull
    public f.e0.d b() {
        Matcher matcher = this.f6154b;
        return f.e0.e.f(matcher.start(), matcher.end());
    }

    @Override // f.h0.e
    @Nullable
    public e next() {
        int iEnd = this.f6154b.end() + (this.f6154b.end() == this.f6154b.start() ? 1 : 0);
        if (iEnd > this.f6155c.length()) {
            return null;
        }
        Matcher matcher = this.f6154b.pattern().matcher(this.f6155c);
        f.c0.c.j.d(matcher, "matcher.pattern().matcher(input)");
        CharSequence charSequence = this.f6155c;
        if (matcher.find(iEnd)) {
            return new f(matcher, charSequence);
        }
        return null;
    }
}
