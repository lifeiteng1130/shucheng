package e.a.a.g.d.i;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import e.a.a.f.s.k;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.book.read.ReadBookBaseActivity;
import io.legado.app.ui.widget.text.AutoCompleteTextView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadBookBaseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ ReadBookBaseActivity this$0;

    /* JADX INFO: compiled from: ReadBookBaseActivity.kt */
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

    /* JADX INFO: compiled from: ReadBookBaseActivity.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
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
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            f.c0.c.j.e(string, "charset");
            Book book = e.a.a.f.s.k.f5677c;
            if (book != null) {
                book.setCharset(string);
                k.a aVar = e.a.a.f.s.k.f5684j;
                if (aVar != null) {
                    aVar.O(book);
                }
            }
            kVar.q();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(ReadBookBaseActivity readBookBaseActivity) {
        super(1);
        this.this$0 = readBookBaseActivity;
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
        AutoCompleteTextView autoCompleteTextView = dialogEditTextBindingA.f6613b;
        e.a.a.c.c cVar = e.a.a.c.c.a;
        autoCompleteTextView.setFilterValues(e.a.a.c.c.m);
        AutoCompleteTextView autoCompleteTextView2 = dialogEditTextBindingA.f6613b;
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        autoCompleteTextView2.setText(book == null ? null : book.getCharset());
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                editView.setFilterValues(charsets)\n                editView.setText(ReadBook.book?.charset)\n            }");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA));
        c.b.a.m.f.K0(hVar, null, 1, null);
    }
}
