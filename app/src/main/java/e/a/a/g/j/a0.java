package e.a.a.g.j;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.ui.replace.ReplaceRuleViewModel;
import java.util.LinkedHashSet;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.replace.ReplaceRuleViewModel$exportSelection$4", f = "ReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class a0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ DocumentFile $doc;
    public final /* synthetic */ LinkedHashSet<ReplaceRule> $sources;
    public int label;
    public final /* synthetic */ ReplaceRuleViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(LinkedHashSet<ReplaceRule> linkedHashSet, DocumentFile documentFile, ReplaceRuleViewModel replaceRuleViewModel, f.z.d<? super a0> dVar) {
        super(2, dVar);
        this.$sources = linkedHashSet;
        this.$doc = documentFile;
        this.this$0 = replaceRuleViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new a0(this.$sources, this.$doc, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((a0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String json = e.a.a.h.n.a().toJson(this.$sources);
        DocumentFile documentFileFindFile = this.$doc.findFile("exportReplaceRule.json");
        if (documentFileFindFile != null) {
            documentFileFindFile.delete();
        }
        DocumentFile documentFileCreateFile = this.$doc.createFile("", "exportReplaceRule.json");
        if (documentFileCreateFile == null) {
            return null;
        }
        Context contextB = this.this$0.b();
        f.c0.c.j.d(json, "json");
        c.b.a.m.f.j6(documentFileCreateFile, contextB, json, null, 4);
        return f.v.a;
    }
}
