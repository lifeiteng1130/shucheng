package e.a.a.f.s;

import android.content.Context;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlay.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.help.AudioPlay$skipTo$1", f = "AudioPlay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $index;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, Context context, f.z.d<? super d> dVar) {
        super(2, dVar);
        this.$index = i2;
        this.$context = context;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d(this.$index, this.$context, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a aVar = a.a;
        Book book = a.f5665e;
        if (book == null) {
            return null;
        }
        int i2 = this.$index;
        Context context = this.$context;
        a.f5668h = i2;
        a.f5669i = 0;
        a.f5666f = null;
        book.setDurChapterIndex(a.f5668h);
        book.setDurChapterPos(0);
        aVar.f();
        aVar.d(context);
        return v.a;
    }
}
