package e.a.a.f.s;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.help.ReadBook$loadContent$2$1", f = "ReadBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class o extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ int $index;
    public final /* synthetic */ boolean $resetPageOffset;
    public final /* synthetic */ f.c0.b.a<v> $success;
    public final /* synthetic */ boolean $upContent;
    public int label;

    /* JADX INFO: compiled from: ReadBook.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<v> {
        public final /* synthetic */ f.c0.b.a<v> $success;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f.c0.b.a<v> aVar) {
            super(0);
            this.$success = aVar;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            f.c0.b.a<v> aVar = this.$success;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Book book, int i2, boolean z, boolean z2, f.c0.b.a<v> aVar, f.z.d<? super o> dVar) {
        super(2, dVar);
        this.$book = book;
        this.$index = i2;
        this.$resetPageOffset = z;
        this.$upContent = z2;
        this.$success = aVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new o(this.$book, this.$index, this.$resetPageOffset, this.$upContent, this.$success, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((o) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        v vVar;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BookChapter chapter = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(this.$book.getBookUrl(), this.$index);
        v vVar2 = null;
        if (chapter != null) {
            Book book = this.$book;
            boolean z = this.$resetPageOffset;
            boolean z2 = this.$upContent;
            f.c0.b.a<v> aVar = this.$success;
            String strE = e.a.a.d.g.a.e(book, chapter);
            if (strE == null) {
                vVar = null;
            } else {
                k kVar = k.a;
                kVar.d(book, chapter, strE, z2, z, new a(aVar));
                kVar.p(chapter.getIndex());
                vVar = v.a;
            }
            if (vVar == null) {
                k.g(k.a, chapter, z, null, 4);
            }
            vVar2 = v.a;
        }
        if (vVar2 == null) {
            k.a.p(this.$index);
        }
        return v.a;
    }
}
