package e.a.a.g.e;

import android.content.DialogInterface;
import io.legado.app.ui.config.OtherConfigFragment;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OtherConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ OtherConfigFragment this$0;

    /* JADX INFO: compiled from: OtherConfigFragment.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ OtherConfigFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OtherConfigFragment otherConfigFragment) {
            super(1);
            this.this$0 = otherConfigFragment;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            e.a.a.d.g gVar = e.a.a.d.g.a;
            FileUtils fileUtils = FileUtils.a;
            fileUtils.h(fileUtils.o(e.a.a.d.g.f5530b, "book_cache"));
            String absolutePath = this.this$0.requireActivity().getCacheDir().getAbsolutePath();
            f.c0.c.j.d(absolutePath, "requireActivity().cacheDir.absolutePath");
            fileUtils.h(absolutePath);
            e.a.a.h.m.l(this.this$0, R.string.clear_cache_success);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(OtherConfigFragment otherConfigFragment) {
        super(1);
        this.this$0 = otherConfigFragment;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        hVar.m(new a(this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
