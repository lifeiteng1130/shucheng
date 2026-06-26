package e.a.a.g.d.l.c;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import io.legado.app.ui.book.source.manage.BookSourceAdapter;
import io.legado.app.ui.book.source.manage.BookSourceViewModel;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookSourceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ BookSourceActivity this$0;

    /* JADX INFO: compiled from: BookSourceActivity.kt */
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

    /* JADX INFO: compiled from: BookSourceActivity.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ BookSourceActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, BookSourceActivity bookSourceActivity) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.this$0 = bookSourceActivity;
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
            BookSourceActivity bookSourceActivity = this.this$0;
            if (string.length() > 0) {
                BookSourceViewModel bookSourceViewModelT0 = bookSourceActivity.T0();
                BookSourceAdapter bookSourceAdapter = bookSourceActivity.adapter;
                if (bookSourceAdapter == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                List<BookSource> listA = bookSourceAdapter.A();
                Objects.requireNonNull(bookSourceViewModelT0);
                f.c0.c.j.e(listA, "sources");
                f.c0.c.j.e(string, "groups");
                BaseViewModel.a(bookSourceViewModelT0, null, null, new s0(listA, string, null), 3, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(BookSourceActivity bookSourceActivity) {
        super(1);
        this.this$0 = bookSourceActivity;
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
        BookSourceActivity bookSourceActivity = this.this$0;
        dialogEditTextBindingA.f6613b.setHint(R.string.group_name);
        dialogEditTextBindingA.f6613b.setFilterValues(f.x.e.F(bookSourceActivity.groups));
        dialogEditTextBindingA.f6613b.setDropDownHeight(c.b.a.m.f.m2(180));
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                editView.setHint(R.string.group_name)\n                editView.setFilterValues(groups.toList())\n                editView.dropDownHeight = 180.dp\n            }");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.this$0));
        c.b.a.m.f.K0(hVar, null, 1, null);
    }
}
