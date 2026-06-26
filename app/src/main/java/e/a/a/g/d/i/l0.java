package e.a.a.g.d.i;

import android.content.DialogInterface;
import io.legado.app.data.entities.BookProgress;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadBookActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ BookProgress $progress;

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ BookProgress $progress;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BookProgress bookProgress) {
            super(1);
            this.$progress = bookProgress;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            e.a.a.f.s.k.a.r(this.$progress);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(BookProgress bookProgress) {
        super(1);
        this.$progress = bookProgress;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        hVar.g(R.string.current_progress_exceeds_cloud);
        hVar.m(new a(this.$progress));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
