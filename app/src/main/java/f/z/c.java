package f.z;

import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.s;
import f.v;
import f.z.f;
import java.io.Serializable;
import java.util.Objects;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public final class c implements f, Serializable {
    private final f.a element;
    private final f left;

    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class a implements Serializable {

        @NotNull
        public static final C0180a Companion = new C0180a(null);
        private static final long serialVersionUID = 0;

        @NotNull
        private final f[] elements;

        /* JADX INFO: renamed from: f.z.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContextImpl.kt */
        public static final class C0180a {
            public C0180a(f.c0.c.f fVar) {
            }
        }

        public a(@NotNull f[] fVarArr) {
            j.e(fVarArr, "elements");
            this.elements = fVarArr;
        }

        private final Object readResolve() {
            f[] fVarArr = this.elements;
            f fVarPlus = h.INSTANCE;
            for (f fVar : fVarArr) {
                fVarPlus = fVarPlus.plus(fVar);
            }
            return fVarPlus;
        }

        @NotNull
        public final f[] getElements() {
            return this.elements;
        }
    }

    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class b extends k implements p<String, f.a, String> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @Override // f.c0.b.p
        @NotNull
        public final String invoke(@NotNull String str, @NotNull f.a aVar) {
            j.e(str, "acc");
            j.e(aVar, "element");
            if (str.length() == 0) {
                return aVar.toString();
            }
            return str + ", " + aVar;
        }
    }

    /* JADX INFO: renamed from: f.z.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class C0181c extends k implements p<v, f.a, v> {
        public final /* synthetic */ f[] $elements;
        public final /* synthetic */ s $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0181c(f[] fVarArr, s sVar) {
            super(2);
            this.$elements = fVarArr;
            this.$index = sVar;
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(v vVar, f.a aVar) {
            invoke2(vVar, aVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull v vVar, @NotNull f.a aVar) {
            j.e(vVar, "<anonymous parameter 0>");
            j.e(aVar, "element");
            f[] fVarArr = this.$elements;
            s sVar = this.$index;
            int i2 = sVar.element;
            sVar.element = i2 + 1;
            fVarArr[i2] = aVar;
        }
    }

    public c(@NotNull f fVar, @NotNull f.a aVar) {
        j.e(fVar, "left");
        j.e(aVar, "element");
        this.left = fVar;
        this.element = aVar;
    }

    private final Object writeReplace() {
        int iA = a();
        f[] fVarArr = new f[iA];
        s sVar = new s();
        sVar.element = 0;
        fold(v.a, new C0181c(fVarArr, sVar));
        if (sVar.element == iA) {
            return new a(fVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int a() {
        int i2 = 2;
        c cVar = this;
        while (true) {
            f fVar = cVar.left;
            if (!(fVar instanceof c)) {
                fVar = null;
            }
            cVar = (c) fVar;
            if (cVar == null) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        boolean zA;
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.a() != a()) {
                return false;
            }
            Objects.requireNonNull(cVar);
            c cVar2 = this;
            while (true) {
                f.a aVar = cVar2.element;
                if (!j.a(cVar.get(aVar.getKey()), aVar)) {
                    zA = false;
                    break;
                }
                f fVar = cVar2.left;
                if (!(fVar instanceof c)) {
                    Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    f.a aVar2 = (f.a) fVar;
                    zA = j.a(cVar.get(aVar2.getKey()), aVar2);
                    break;
                }
                cVar2 = (c) fVar;
            }
            if (!zA) {
                return false;
            }
        }
        return true;
    }

    @Override // f.z.f
    public <R> R fold(R r, @NotNull p<? super R, ? super f.a, ? extends R> pVar) {
        j.e(pVar, "operation");
        return pVar.invoke((Object) this.left.fold(r, pVar), this.element);
    }

    @Override // f.z.f
    @Nullable
    public <E extends f.a> E get(@NotNull f.b<E> bVar) {
        j.e(bVar, "key");
        c cVar = this;
        while (true) {
            E e2 = (E) cVar.element.get(bVar);
            if (e2 != null) {
                return e2;
            }
            f fVar = cVar.left;
            if (!(fVar instanceof c)) {
                return (E) fVar.get(bVar);
            }
            cVar = (c) fVar;
        }
    }

    public int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // f.z.f
    @NotNull
    public f minusKey(@NotNull f.b<?> bVar) {
        j.e(bVar, "key");
        if (this.element.get(bVar) != null) {
            return this.left;
        }
        f fVarMinusKey = this.left.minusKey(bVar);
        return fVarMinusKey == this.left ? this : fVarMinusKey == h.INSTANCE ? this.element : new c(fVarMinusKey, this.element);
    }

    @Override // f.z.f
    @NotNull
    public f plus(@NotNull f fVar) {
        j.e(fVar, com.umeng.analytics.pro.c.R);
        j.e(fVar, com.umeng.analytics.pro.c.R);
        return fVar == h.INSTANCE ? this : (f) fVar.fold(this, g.INSTANCE);
    }

    @NotNull
    public String toString() {
        return c.a.a.a.a.p(c.a.a.a.a.r("["), (String) fold("", b.INSTANCE), "]");
    }
}
