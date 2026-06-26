package e.a.a.d.u;

import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.y;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import g.b.a2;
import g.b.l1;
import g.b.o0;
import g.b.s;
import g.b.z1;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Coroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.help.coroutine.Coroutine$executeBlock$2", f = "Coroutine.kt", i = {}, l = {198, 201}, m = "invokeSuspend", n = {}, s = {})
public final class e<T> extends g implements p<a0, f.z.d<? super T>, Object> {
    public final /* synthetic */ p<a0, f.z.d<? super T>, Object> $block;
    public final /* synthetic */ long $timeMillis;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: compiled from: Coroutine.kt */
    @DebugMetadata(c = "io.legado.app.help.coroutine.Coroutine$executeBlock$2$1", f = "Coroutine.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, f.z.d<? super T>, Object> {
        public final /* synthetic */ p<a0, f.z.d<? super T>, Object> $block;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(p<? super a0, ? super f.z.d<? super T>, ? extends Object> pVar, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$block = pVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            a aVar = new a(this.$block, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super T> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                a0 a0Var = (a0) this.L$0;
                p<a0, f.z.d<? super T>, Object> pVar = this.$block;
                this.label = 1;
                obj = pVar.invoke(a0Var, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            return obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(long j2, p<? super a0, ? super f.z.d<? super T>, ? extends Object> pVar, f.z.d<? super e> dVar) {
        super(2, dVar);
        this.$timeMillis = j2;
        this.$block = pVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        e eVar = new e(this.$timeMillis, this.$block, dVar);
        eVar.L$0 = obj;
        return eVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super T> dVar) {
        return ((e) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Object objH;
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        boolean z = true;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            a0 a0Var = (a0) this.L$0;
            long j2 = this.$timeMillis;
            if (j2 > 0) {
                a aVar2 = new a(this.$block, null);
                this.label = 1;
                if (j2 <= 0) {
                    throw new z1("Timed out immediately");
                }
                a2 a2Var = new a2(j2, this);
                a2Var.F(new o0(c.b.a.m.f.j2(a2Var.f6208d.getContext()).h(a2Var.f6172e, a2Var, a2Var.f6170b)));
                a2Var.U();
                try {
                    y.d(aVar2, 2);
                    obj = aVar2.invoke(a2Var, a2Var);
                } catch (Throwable th) {
                    obj = new s(th, false, 2);
                }
                f.z.i.a aVar3 = f.z.i.a.COROUTINE_SUSPENDED;
                if (obj == aVar3 || (objH = a2Var.H(obj)) == l1.f6272b) {
                    obj = aVar3;
                } else if (objH instanceof s) {
                    Throwable th2 = ((s) objH).f6298b;
                    if ((th2 instanceof z1) && ((z1) th2).coroutine == a2Var) {
                        z = false;
                    }
                    if (z) {
                        throw th2;
                    }
                    if (obj instanceof s) {
                        throw ((s) obj).f6298b;
                    }
                } else {
                    obj = l1.a(objH);
                }
                if (obj == aVar3) {
                    j.e(this, "frame");
                }
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                p<a0, f.z.d<? super T>, Object> pVar = this.$block;
                this.label = 2;
                obj = pVar.invoke(a0Var, this);
                if (obj == aVar) {
                    return aVar;
                }
            }
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        return obj;
    }
}
