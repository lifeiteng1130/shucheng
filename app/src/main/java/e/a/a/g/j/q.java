package e.a.a.g.j;

import android.content.DialogInterface;
import io.legado.app.ui.replace.ReplaceRuleActivity;
import io.legado.app.ui.replace.ReplaceRuleAdapter;
import io.legado.app.ui.replace.ReplaceRuleViewModel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReplaceRuleActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ ReplaceRuleActivity this$0;

    /* JADX INFO: compiled from: ReplaceRuleActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ ReplaceRuleActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReplaceRuleActivity replaceRuleActivity) {
            super(1);
            this.this$0 = replaceRuleActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            ReplaceRuleViewModel replaceRuleViewModelT0 = this.this$0.T0();
            ReplaceRuleAdapter replaceRuleAdapter = this.this$0.adapter;
            if (replaceRuleAdapter != null) {
                replaceRuleViewModelT0.e(replaceRuleAdapter.A());
            } else {
                f.c0.c.j.m("adapter");
                throw null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(ReplaceRuleActivity replaceRuleActivity) {
        super(1);
        this.this$0 = replaceRuleActivity;
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
