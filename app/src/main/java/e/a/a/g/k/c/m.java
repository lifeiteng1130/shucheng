package e.a.a.g.k.c;

import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import f.v;
import g.b.a0;
import io.legado.app.ui.rss.read.ReadRssViewModel;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: ReadRssViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.read.ReadRssViewModel$saveImage$1", f = "ReadRssViewModel.kt", i = {0}, l = {Token.EMPTY}, m = "invokeSuspend", n = {"fileName"}, s = {"L$0"})
public final class m extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $path;
    public final /* synthetic */ String $webPic;
    public Object L$0;
    public int label;
    public final /* synthetic */ ReadRssViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ReadRssViewModel readRssViewModel, String str, String str2, f.z.d<? super m> dVar) {
        super(2, dVar);
        this.this$0 = readRssViewModel;
        this.$webPic = str;
        this.$path = str2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new m(this.this$0, this.$webPic, this.$path, dVar);
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
        DocumentFile documentFileA;
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            e.a.a.c.c cVar = e.a.a.c.c.a;
            String strK = f.c0.c.j.k(((SimpleDateFormat) e.a.a.c.c.f5499e.getValue()).format(new Date(System.currentTimeMillis())), ".jpg");
            ReadRssViewModel readRssViewModel = this.this$0;
            String str2 = this.$webPic;
            this.L$0 = strK;
            this.label = 1;
            Object objG = ReadRssViewModel.g(readRssViewModel, str2, this);
            if (objG == aVar) {
                return aVar;
            }
            str = strK;
            obj = objG;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str3 = (String) this.L$0;
            c.b.a.m.f.E5(obj);
            str = str3;
        }
        byte[] bArr = (byte[]) obj;
        v vVar = null;
        if (bArr != null) {
            String str4 = this.$path;
            ReadRssViewModel readRssViewModel2 = this.this$0;
            if (c.b.a.m.f.t3(str4)) {
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(readRssViewModel2.b(), Uri.parse(str4));
                if (documentFileFromTreeUri != null && (documentFileA = e.a.a.h.j.a(e.a.a.h.j.a, documentFileFromTreeUri, str, null, new String[0], 4)) != null) {
                    c.b.a.m.f.g6(documentFileA, readRssViewModel2.b(), bArr);
                    vVar = v.a;
                }
            } else {
                f.b0.d.e(FileUtils.a.a(new File(str4), str), bArr);
                vVar = v.a;
            }
        }
        if (vVar != null) {
            return v.a;
        }
        throw new Throwable("NULL");
    }
}
