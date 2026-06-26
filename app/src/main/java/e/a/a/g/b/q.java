package e.a.a.g.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import androidx.view.MutableLiveData;
import io.legado.app.data.entities.Book;
import io.legado.app.model.localBook.LocalBook;
import io.legado.app.ui.association.FileAssociationViewModel;
import io.legado.app.ui.association.ImportBookSourceActivity;
import io.legado.app.ui.association.ImportReplaceRuleActivity;
import io.legado.app.ui.association.ImportRssSourceActivity;
import io.legado.app.ui.book.read.ReadBookActivity;
import java.io.File;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FileAssociationViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.association.FileAssociationViewModel$dispatchIndent$1", f = "FileAssociationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class q extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ FileAssociationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Uri uri, FileAssociationViewModel fileAssociationViewModel, f.z.d<? super q> dVar) {
        super(2, dVar);
        this.$uri = uri;
        this.this$0 = fileAssociationViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new q(this.$uri, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((q) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Exception {
        String strF;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        if (f.c0.c.j.a(this.$uri.getScheme(), "file") || f.c0.c.j.a(this.$uri.getScheme(), "content")) {
            if (f.c0.c.j.a(this.$uri.getScheme(), "file")) {
                strF = f.b0.d.d(new File(String.valueOf(this.$uri.getPath())), null, 1);
            } else {
                DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this.this$0.b(), this.$uri);
                if (documentFileFromSingleUri == null) {
                    strF = null;
                } else {
                    Context contextB = this.this$0.b();
                    f.c0.c.j.e(documentFileFromSingleUri, "<this>");
                    f.c0.c.j.e(contextB, com.umeng.analytics.pro.c.R);
                    Uri uri = documentFileFromSingleUri.getUri();
                    f.c0.c.j.d(uri, "this.uri");
                    strF = e.a.a.h.j.f(contextB, uri);
                }
            }
            if (strF == null) {
                throw new Exception("文件不存在");
            }
            if (c.b.a.m.f.B3(strF) || c.b.a.m.f.A3(strF)) {
                if (f.h0.k.d(strF, "bookSourceUrl", false, 2)) {
                    MutableLiveData<Intent> mutableLiveData = this.this$0.successLiveData;
                    Intent intent = new Intent(this.this$0.b(), (Class<?>) ImportBookSourceActivity.class);
                    intent.putExtra("dataKey", e.a.a.d.o.b(e.a.a.d.o.a, strF, null, 2));
                    f.v vVar = f.v.a;
                    mutableLiveData.postValue(intent);
                    return vVar;
                }
                if (f.h0.k.d(strF, "sourceUrl", false, 2)) {
                    MutableLiveData<Intent> mutableLiveData2 = this.this$0.successLiveData;
                    Intent intent2 = new Intent(this.this$0.b(), (Class<?>) ImportRssSourceActivity.class);
                    intent2.putExtra("dataKey", e.a.a.d.o.b(e.a.a.d.o.a, strF, null, 2));
                    f.v vVar2 = f.v.a;
                    mutableLiveData2.postValue(intent2);
                    return vVar2;
                }
                if (f.h0.k.d(strF, "pattern", false, 2)) {
                    MutableLiveData<Intent> mutableLiveData3 = this.this$0.successLiveData;
                    Intent intent3 = new Intent(this.this$0.b(), (Class<?>) ImportReplaceRuleActivity.class);
                    intent3.putExtra("dataKey", e.a.a.d.o.b(e.a.a.d.o.a, strF, null, 2));
                    f.v vVar3 = f.v.a;
                    mutableLiveData3.postValue(intent3);
                    return vVar3;
                }
            }
            Book bookImportFile = f.c0.c.j.a(this.$uri.getScheme(), "content") ? LocalBook.INSTANCE.importFile(this.$uri) : LocalBook.INSTANCE.importFile(this.$uri);
            Intent intent4 = new Intent(this.this$0.b(), (Class<?>) ReadBookActivity.class);
            intent4.putExtra("bookUrl", bookImportFile.getBookUrl());
            this.this$0.successLiveData.postValue(intent4);
        }
        return f.v.a;
    }
}
