package e.a.a.g.b;

import android.content.DialogInterface;
import io.legado.app.ui.association.ImportBookSourceActivity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImportBookSourceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ ImportBookSourceActivity this$0;

    /* JADX INFO: compiled from: ImportBookSourceActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
        }
    }

    /* JADX INFO: compiled from: ImportBookSourceActivity.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ ImportBookSourceActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImportBookSourceActivity importBookSourceActivity) {
            super(1);
            this.this$0 = importBookSourceActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            this.this$0.finish();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(ImportBookSourceActivity importBookSourceActivity) {
        super(1);
        this.this$0 = importBookSourceActivity;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        hVar.m(a.INSTANCE);
        hVar.l(new b(this.this$0));
    }
}
