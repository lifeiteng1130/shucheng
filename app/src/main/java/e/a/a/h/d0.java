package e.a.a.h;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.zip.ZipOutputStream;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ZipUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.utils.ZipUtils$zipFiles$3", f = "ZipUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super Boolean>, Object> {
    public final /* synthetic */ String $comment;
    public final /* synthetic */ Collection<String> $srcFilePaths;
    public final /* synthetic */ String $zipFilePath;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(Collection<String> collection, String str, String str2, f.z.d<? super d0> dVar) {
        super(2, dVar);
        this.$srcFilePaths = collection;
        this.$zipFilePath = str;
        this.$comment = str2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d0(this.$srcFilePaths, this.$zipFilePath, this.$comment, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super Boolean> dVar) {
        return ((d0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        if (this.$srcFilePaths == null || this.$zipFilePath == null) {
            return Boolean.FALSE;
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(this.$zipFilePath));
        Collection<String> collection = this.$srcFilePaths;
        String str = this.$comment;
        try {
            for (String str2 : collection) {
                e0 e0Var = e0.a;
                File fileB = e0Var.b(str2);
                f.c0.c.j.c(fileB);
                if (!e0Var.f(fileB, "", zipOutputStream, str)) {
                    Boolean bool = Boolean.FALSE;
                    c.b.a.m.f.P0(zipOutputStream, null);
                    return bool;
                }
            }
            Boolean bool2 = Boolean.TRUE;
            c.b.a.m.f.P0(zipOutputStream, null);
            return bool2;
        } finally {
        }
    }
}
