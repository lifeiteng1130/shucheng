package e.a.a.g.d.l.c;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import io.legado.app.data.entities.BookSource;
import io.legado.app.ui.book.source.manage.BookSourceViewModel;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$exportSelection$4", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class o0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ DocumentFile $doc;
    public final /* synthetic */ List<BookSource> $sources;
    public int label;
    public final /* synthetic */ BookSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(List<BookSource> list, DocumentFile documentFile, BookSourceViewModel bookSourceViewModel, f.z.d<? super o0> dVar) {
        super(2, dVar);
        this.$sources = list;
        this.$doc = documentFile;
        this.this$0 = bookSourceViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new o0(this.$sources, this.$doc, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((o0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String json = e.a.a.h.n.a().toJson(this.$sources);
        DocumentFile documentFileFindFile = this.$doc.findFile("exportBookSource.json");
        if (documentFileFindFile != null) {
            documentFileFindFile.delete();
        }
        DocumentFile documentFileCreateFile = this.$doc.createFile("", "exportBookSource.json");
        if (documentFileCreateFile == null) {
            return null;
        }
        Context contextB = this.this$0.b();
        f.c0.c.j.d(json, "json");
        c.b.a.m.f.j6(documentFileCreateFile, contextB, json, null, 4);
        return f.v.a;
    }
}
