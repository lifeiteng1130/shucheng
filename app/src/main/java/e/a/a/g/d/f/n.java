package e.a.a.g.d.f;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import f.v;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.book.group.GroupSelectDialog;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GroupSelectDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, v> {
    public final /* synthetic */ BookGroup $bookGroup;
    public final /* synthetic */ GroupSelectDialog this$0;

    /* JADX INFO: compiled from: GroupSelectDialog.kt */
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

    /* JADX INFO: compiled from: GroupSelectDialog.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ BookGroup $bookGroup;
        public final /* synthetic */ GroupSelectDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, GroupSelectDialog groupSelectDialog, BookGroup bookGroup) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.this$0 = groupSelectDialog;
            this.$bookGroup = bookGroup;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            String string;
            f.c0.c.j.e(dialogInterface, "it");
            Editable text = this.$alertBinding.f6613b.getText();
            if (text == null || (string = text.toString()) == null) {
                return;
            }
            GroupSelectDialog.Q(this.this$0).f(BookGroup.copy$default(this.$bookGroup, 0L, string, 0, false, 13, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(GroupSelectDialog groupSelectDialog, BookGroup bookGroup) {
        super(1);
        this.this$0 = groupSelectDialog;
        this.$bookGroup = bookGroup;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        DialogEditTextBinding dialogEditTextBindingA = DialogEditTextBinding.a(this.this$0.getLayoutInflater());
        BookGroup bookGroup = this.$bookGroup;
        dialogEditTextBindingA.f6613b.setHint(R.string.group_name);
        dialogEditTextBindingA.f6613b.setText(bookGroup.getGroupName());
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                editView.setHint(R.string.group_name)\n                editView.setText(bookGroup.groupName)\n            }");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.i(new b(dialogEditTextBindingA, this.this$0, this.$bookGroup));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
