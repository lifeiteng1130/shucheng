package g.b.g2;

import f.z.f;
import g.b.x1;
import java.util.Objects;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    @JvmField
    @NotNull
    public static final q a = new q("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f.c0.b.p<Object, f.a, Object> f6209b = a.INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f.c0.b.p<x1<?>, f.a, x1<?>> f6210c = b.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f.c0.b.p<v, f.a, v> f6211d = c.INSTANCE;

    /* JADX INFO: compiled from: ThreadContext.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.p<Object, f.a, Object> {
        public static final a INSTANCE = new a();

        public a() {
            super(2);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@Nullable Object obj, @NotNull f.a aVar) {
            if (!(aVar instanceof x1)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? aVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* JADX INFO: compiled from: ThreadContext.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.p<x1<?>, f.a, x1<?>> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @Override // f.c0.b.p
        @Nullable
        public final x1<?> invoke(@Nullable x1<?> x1Var, @NotNull f.a aVar) {
            if (x1Var != null) {
                return x1Var;
            }
            if (!(aVar instanceof x1)) {
                aVar = null;
            }
            return (x1) aVar;
        }
    }

    /* JADX INFO: compiled from: ThreadContext.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.p<v, f.a, v> {
        public static final c INSTANCE = new c();

        public c() {
            super(2);
        }

        @Override // f.c0.b.p
        @NotNull
        public final v invoke(@NotNull v vVar, @NotNull f.a aVar) {
            if (aVar instanceof x1) {
                x1<Object> x1Var = (x1) aVar;
                Object objL = x1Var.l(vVar.f6214d);
                Object[] objArr = vVar.a;
                int i2 = vVar.f6213c;
                objArr[i2] = objL;
                x1<Object>[] x1VarArr = vVar.f6212b;
                vVar.f6213c = i2 + 1;
                Objects.requireNonNull(x1Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                x1VarArr[i2] = x1Var;
            }
            return vVar;
        }
    }

    public static final void a(@NotNull f.z.f fVar, @Nullable Object obj) {
        if (obj == a) {
            return;
        }
        if (!(obj instanceof v)) {
            Object objFold = fVar.fold(null, f6210c);
            Objects.requireNonNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((x1) objFold).i(fVar, obj);
            return;
        }
        v vVar = (v) obj;
        int length = vVar.f6212b.length;
        while (true) {
            length--;
            if (length < 0) {
                return;
            }
            x1<Object> x1Var = vVar.f6212b[length];
            f.c0.c.j.c(x1Var);
            x1Var.i(fVar, vVar.a[length]);
        }
    }

    @Nullable
    public static final Object b(@NotNull f.z.f fVar, @Nullable Object obj) {
        if (obj == null) {
            obj = fVar.fold(0, f6209b);
            f.c0.c.j.c(obj);
        }
        return obj == 0 ? a : obj instanceof Integer ? fVar.fold(new v(fVar, ((Number) obj).intValue()), f6211d) : ((x1) obj).l(fVar);
    }
}
