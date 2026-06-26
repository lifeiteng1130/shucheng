package e.a.a.g.e;

import android.content.DialogInterface;
import io.legado.app.help.ThemeConfig;
import io.legado.app.ui.config.ThemeListDialog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ThemeListDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ ThemeListDialog this$0;

    /* JADX INFO: compiled from: ThemeListDialog.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ int $index;
        public final /* synthetic */ ThemeListDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, ThemeListDialog themeListDialog) {
            super(1);
            this.$index = i2;
            this.this$0 = themeListDialog;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            ThemeConfig themeConfig = ThemeConfig.a;
            themeConfig.d().remove(this.$index);
            themeConfig.f();
            this.this$0.R();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(int i2, ThemeListDialog themeListDialog) {
        super(1);
        this.$index = i2;
        this.this$0 = themeListDialog;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        hVar.m(new a(this.$index, this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
