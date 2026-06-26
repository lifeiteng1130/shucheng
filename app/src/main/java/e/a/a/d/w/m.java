package e.a.a.d.w;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookProgress;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookWebDav.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.help.storage.BookWebDav$uploadBookProgress$1", f = "BookWebDav.kt", i = {0, 0}, l = {155, 156}, m = "invokeSuspend", n = {"json", "url"}, s = {"L$0", "L$1"})
public final class m extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Book book, f.z.d<? super m> dVar) {
        super(2, dVar);
        this.$book = book;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new m(this.$book, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((m) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        String str;
        String str2;
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            String json = e.a.a.h.n.a().toJson(new BookProgress(this.$book.getName(), this.$book.getAuthor(), this.$book.getDurChapterIndex(), this.$book.getDurChapterPos(), this.$book.getDurChapterTime(), this.$book.getDurChapterTitle()));
            j jVar = j.a;
            String strF = jVar.f(this.$book);
            this.L$0 = json;
            this.L$1 = strF;
            this.label = 1;
            Object objH = jVar.h(this);
            if (objH == aVar) {
                return aVar;
            }
            str = json;
            obj = objH;
            str2 = strF;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                return v.a;
            }
            str2 = (String) this.L$1;
            str = (String) this.L$0;
            c.b.a.m.f.E5(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            e.a.a.e.e.b bVar = new e.a.a.e.e.b(str2);
            f.c0.c.j.d(str, "json");
            byte[] bytes = str.getBytes(f.h0.a.a);
            f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (bVar.i(bytes, null, this) == aVar) {
                return aVar;
            }
        }
        return v.a;
    }
}
