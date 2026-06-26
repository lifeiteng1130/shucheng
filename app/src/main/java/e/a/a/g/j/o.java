package e.a.a.g.j;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import io.legado.app.base.BaseViewModel;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.replace.GroupManageDialog;
import io.legado.app.ui.replace.ReplaceRuleViewModel;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GroupManageDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ GroupManageDialog this$0;

    /* JADX INFO: compiled from: GroupManageDialog.kt */
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
            DialogEditTextBinding dialogEditTextBinding = this.$alertBinding;
            dialogEditTextBinding.f6613b.setHint("分组名称");
            ScrollView scrollView = dialogEditTextBinding.a;
            f.c0.c.j.d(scrollView, "alertBinding.apply {\n                    editView.hint = \"分组名称\"\n                }.root");
            return scrollView;
        }
    }

    /* JADX INFO: compiled from: GroupManageDialog.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ GroupManageDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, GroupManageDialog groupManageDialog) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.this$0 = groupManageDialog;
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
            GroupManageDialog groupManageDialog = this.this$0;
            if (!f.h0.k.s(string)) {
                ReplaceRuleViewModel replaceRuleViewModelN = GroupManageDialog.N(groupManageDialog);
                Objects.requireNonNull(replaceRuleViewModelN);
                f.c0.c.j.e(string, "group");
                BaseViewModel.a(replaceRuleViewModelN, null, null, new s(string, null), 3, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(GroupManageDialog groupManageDialog) {
        super(1);
        this.this$0 = groupManageDialog;
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
        hVar.i(new b(dialogEditTextBindingA, this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
