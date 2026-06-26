package e.a.a.g.d.m;

import android.widget.TextView;
import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.data.entities.Book;
import io.legado.app.ui.book.toc.ChapterListFragment;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: ChapterListFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.toc.ChapterListFragment$initBook$1", f = "ChapterListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public int label;
    public final /* synthetic */ ChapterListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(ChapterListFragment chapterListFragment, Book book, f.z.d<? super p> dVar) {
        super(2, dVar);
        this.this$0 = chapterListFragment;
        this.$book = book;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new p(this.this$0, this.$book, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((p) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ChapterListFragment chapterListFragment = this.this$0;
        f.f0.h<Object>[] hVarArr = ChapterListFragment.f7329d;
        chapterListFragment.X();
        this.this$0.durChapterIndex = this.$book.getDurChapterIndex();
        TextView textView = this.this$0.V().f6716f;
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.$book.getDurChapterTitle());
        sb.append('(');
        sb.append(this.$book.getDurChapterIndex() + 1);
        sb.append(Attributes.InternalPrefix);
        sb.append(this.$book.getTotalChapterNum());
        sb.append(')');
        textView.setText(sb.toString());
        ChapterListFragment chapterListFragment2 = this.this$0;
        Book book = this.$book;
        Objects.requireNonNull(chapterListFragment2);
        k0 k0Var = k0.f6264c;
        c.b.a.m.f.L3(chapterListFragment2, k0.f6263b, null, new q(chapterListFragment2, book, null), 2, null);
        return v.a;
    }
}
