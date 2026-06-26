package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g2 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX INFO: compiled from: BgTextConfigDialog.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<View> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DialogEditTextBinding dialogEditTextBinding) {
            super(0);
            this.$alertBinding = dialogEditTextBinding;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final View invoke() {
            ScrollView scrollView = this.$alertBinding.a;
            f.c0.c.j.d(scrollView, "alertBinding.root");
            return scrollView;
        }
    }

    /* JADX INFO: compiled from: BgTextConfigDialog.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ BgTextConfigDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, BgTextConfigDialog bgTextConfigDialog) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.this$0 = bgTextConfigDialog;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            String string;
            f.c0.c.j.e(dialogInterface, "it");
            Editable text = this.$alertBinding.f6613b.getText();
            if (text == null || (string = text.toString()) == null) {
                return;
            }
            BgTextConfigDialog bgTextConfigDialog = this.this$0;
            f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
            Objects.requireNonNull(bgTextConfigDialog);
            e.a.a.d.u.b.b(BaseDialogFragment.N(bgTextConfigDialog, null, null, new e2(string, bgTextConfigDialog, null), 3, null), null, new f2(bgTextConfigDialog, null), 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(BgTextConfigDialog bgTextConfigDialog) {
        super(1);
        this.this$0 = bgTextConfigDialog;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        DialogEditTextBinding dialogEditTextBindingA = DialogEditTextBinding.a(this.this$0.getLayoutInflater());
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater)");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
