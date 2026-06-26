package e.a.a.g.d.k;

import f.c0.b.p;
import f.v;
import g.b.a0;
import g.b.g2.m;
import g.b.k0;
import g.b.o1;
import io.legado.app.data.entities.Book;
import io.legado.app.ui.book.searchContent.SearchContentActivity;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchContentActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.searchContent.SearchContentActivity$initCacheFileNames$1", f = "SearchContentActivity.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
public final class d extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public int label;
    public final /* synthetic */ SearchContentActivity this$0;

    /* JADX INFO: compiled from: SearchContentActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.searchContent.SearchContentActivity$initCacheFileNames$1$1", f = "SearchContentActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public int label;
        public final /* synthetic */ SearchContentActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SearchContentActivity searchContentActivity, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.this$0 = searchContentActivity;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            this.this$0.U0().notifyItemRangeChanged(0, this.this$0.U0().getItemCount(), Boolean.TRUE);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SearchContentActivity searchContentActivity, Book book, f.z.d<? super d> dVar) {
        super(2, dVar);
        this.this$0 = searchContentActivity;
        this.$book = book;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d(this.this$0, this.$book, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            this.this$0.U0().cacheFileNames.addAll(e.a.a.d.g.a.c(this.$book));
            k0 k0Var = k0.f6264c;
            o1 o1Var = m.f6207b;
            a aVar2 = new a(this.this$0, null);
            this.label = 1;
            if (c.b.a.m.f.f6(o1Var, aVar2, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        return v.a;
    }
}
