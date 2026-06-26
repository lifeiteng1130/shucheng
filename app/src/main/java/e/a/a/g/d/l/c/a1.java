package e.a.a.g.d.l.c;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import io.legado.app.base.BaseViewModel;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.book.source.manage.BookSourceViewModel;
import io.legado.app.ui.book.source.manage.GroupManageDialog;
import io.wenyuange.app.release.R;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GroupManageDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a1 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ String $group;
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
            ScrollView scrollView = this.$alertBinding.a;
            f.c0.c.j.d(scrollView, "alertBinding.root");
            return scrollView;
        }
    }

    /* JADX INFO: compiled from: GroupManageDialog.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ String $group;
        public final /* synthetic */ GroupManageDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GroupManageDialog groupManageDialog, String str, DialogEditTextBinding dialogEditTextBinding) {
            super(1);
            this.this$0 = groupManageDialog;
            this.$group = str;
            this.$alertBinding = dialogEditTextBinding;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            BookSourceViewModel bookSourceViewModelN = GroupManageDialog.N(this.this$0);
            String str = this.$group;
            Editable text = this.$alertBinding.f6613b.getText();
            String string = text == null ? null : text.toString();
            Objects.requireNonNull(bookSourceViewModelN);
            f.c0.c.j.e(str, "oldGroup");
            BaseViewModel.a(bookSourceViewModelN, null, null, new w0(str, string, null), 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(GroupManageDialog groupManageDialog, String str) {
        super(1);
        this.this$0 = groupManageDialog;
        this.$group = str;
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
        dialogEditTextBindingA.f6613b.setHint(R.string.group_name);
        dialogEditTextBindingA.f6613b.setText(this.$group);
        hVar.d(new a(dialogEditTextBindingA));
        hVar.i(new b(this.this$0, this.$group, dialogEditTextBindingA));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
