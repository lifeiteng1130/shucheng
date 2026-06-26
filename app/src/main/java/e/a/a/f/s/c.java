package e.a.a.f.s;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookChapter;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlay.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.help.AudioPlay$saveDurChapter$1", f = "AudioPlay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class c extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ long $audioSize;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(long j2, f.z.d<? super c> dVar) {
        super(2, dVar);
        this.$audioSize = j2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new c(this.$audioSize, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a aVar = a.a;
        BookChapter bookChapter = a.f5666f;
        if (bookChapter == null) {
            return null;
        }
        bookChapter.setEnd(new Long(this.$audioSize));
        AppDatabaseKt.getAppDb().getBookChapterDao().insert(bookChapter);
        return v.a;
    }
}
