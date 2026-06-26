package e.a.a.g.d.h;

import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.ui.book.local.ImportBookViewModel;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.local.ImportBookViewModel$deleteDoc$1", f = "ImportBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ HashSet<String> $uriList;
    public int label;
    public final /* synthetic */ ImportBookViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(HashSet<String> hashSet, ImportBookViewModel importBookViewModel, f.z.d<? super i> dVar) {
        super(2, dVar);
        this.$uriList = hashSet;
        this.this$0 = importBookViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new i(this.$uriList, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((i) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        HashSet<String> hashSet = this.$uriList;
        ImportBookViewModel importBookViewModel = this.this$0;
        Iterator<T> it = hashSet.iterator();
        while (it.hasNext()) {
            Uri uri = Uri.parse((String) it.next());
            f.c0.c.j.d(uri, "uri");
            if (c.b.a.m.f.s3(uri)) {
                DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(importBookViewModel.b(), uri);
                if (documentFileFromSingleUri != null) {
                    documentFileFromSingleUri.delete();
                }
            } else {
                String path = uri.getPath();
                if (path != null) {
                    new File(path).delete();
                }
            }
        }
        return v.a;
    }
}
