package e.a.a.g.d.f;

import android.content.DialogInterface;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.ui.book.group.GroupManageDialog;
import io.legado.app.ui.book.group.GroupViewModel;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GroupManageDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, v> {
    public final /* synthetic */ BookGroup $bookGroup;
    public final /* synthetic */ GroupManageDialog this$0;

    /* JADX INFO: compiled from: GroupManageDialog.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<DialogInterface, v> {
        public final /* synthetic */ BookGroup $bookGroup;
        public final /* synthetic */ GroupManageDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GroupManageDialog groupManageDialog, BookGroup bookGroup) {
            super(1);
            this.this$0 = groupManageDialog;
            this.$bookGroup = bookGroup;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            GroupViewModel groupViewModelQ = GroupManageDialog.Q(this.this$0);
            BookGroup[] bookGroupArr = {this.$bookGroup};
            Objects.requireNonNull(groupViewModelQ);
            f.c0.c.j.e(bookGroupArr, "bookGroup");
            BaseViewModel.a(groupViewModelQ, null, null, new o(bookGroupArr, null), 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(GroupManageDialog groupManageDialog, BookGroup bookGroup) {
        super(1);
        this.this$0 = groupManageDialog;
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
        hVar.m(new a(this.this$0, this.$bookGroup));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
