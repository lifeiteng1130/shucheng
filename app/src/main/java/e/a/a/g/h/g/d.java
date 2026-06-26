package e.a.a.g.h.g;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import f.c0.c.s;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.main.bookshelf.BookshelfFragment;
import io.legado.app.ui.main.bookshelf.BookshelfViewModel;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookshelfFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, v> {
    public final /* synthetic */ BookshelfFragment this$0;

    /* JADX INFO: compiled from: BookshelfFragment.kt */
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

    /* JADX INFO: compiled from: BookshelfFragment.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ BookshelfFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, BookshelfFragment bookshelfFragment) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.this$0 = bookshelfFragment;
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
            BookshelfViewModel bookshelfViewModelW = this.this$0.W();
            Objects.requireNonNull(bookshelfViewModelW);
            f.c0.c.j.e(string, "bookUrls");
            s sVar = new s();
            e.a.a.d.u.b bVarA = BaseViewModel.a(bookshelfViewModelW, null, null, new g(string, sVar, null), 3, null);
            bVarA.d(null, new h(sVar, bookshelfViewModelW, null));
            e.a.a.d.u.b.b(bVarA, null, new i(bookshelfViewModelW, null), 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BookshelfFragment bookshelfFragment) {
        super(1);
        this.this$0 = bookshelfFragment;
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
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater)");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
