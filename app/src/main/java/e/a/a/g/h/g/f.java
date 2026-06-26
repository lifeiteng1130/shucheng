package e.a.a.g.h.g;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import f.v;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.main.bookshelf.BookshelfFragment;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookshelfFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, v> {
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
            BookshelfFragment bookshelfFragment = this.this$0;
            bookshelfFragment.W().e(string, bookshelfFragment.V().getGroupId());
        }
    }

    /* JADX INFO: compiled from: BookshelfFragment.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.l<DialogInterface, v> {
        public final /* synthetic */ BookshelfFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BookshelfFragment bookshelfFragment) {
            super(1);
            this.this$0 = bookshelfFragment;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            this.this$0.importBookshelf.launch(new e.a.a.g.f.d(1, null, new String[]{"txt", "json"}, null, 10));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BookshelfFragment bookshelfFragment) {
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
        dialogEditTextBindingA.f6613b.setHint("url/json");
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                editView.hint = \"url/json\"\n            }");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
        hVar.a(R.string.select_file, new c(this.this$0));
    }
}
