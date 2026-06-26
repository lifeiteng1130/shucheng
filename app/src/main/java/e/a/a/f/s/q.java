package e.a.a.f.s;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.ReadRecord;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.help.ReadBook$upReadStartTime$1", f = "ReadBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class q extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public int label;

    public q(f.z.d<? super q> dVar) {
        super(2, dVar);
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new q(dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((q) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ReadRecord readRecord = k.r;
        long jCurrentTimeMillis = System.currentTimeMillis() + readRecord.getReadTime();
        k kVar = k.a;
        readRecord.setReadTime(jCurrentTimeMillis - k.s);
        k.s = System.currentTimeMillis();
        AppDatabaseKt.getAppDb().getReadRecordDao().insert(readRecord);
        return v.a;
    }
}
