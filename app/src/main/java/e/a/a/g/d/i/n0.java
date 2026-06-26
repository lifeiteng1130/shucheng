package e.a.a.g.d.i;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.DialogDownloadChoiceBinding;
import io.legado.app.ui.book.read.ReadBookBaseActivity;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadBookBaseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ ReadBookBaseActivity this$0;

    /* JADX INFO: compiled from: ReadBookBaseActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<View> {
        public final /* synthetic */ DialogDownloadChoiceBinding $alertBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DialogDownloadChoiceBinding dialogDownloadChoiceBinding) {
            super(0);
            this.$alertBinding = dialogDownloadChoiceBinding;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final View invoke() {
            LinearLayout linearLayout = this.$alertBinding.a;
            f.c0.c.j.d(linearLayout, "alertBinding.root");
            return linearLayout;
        }
    }

    /* JADX INFO: compiled from: ReadBookBaseActivity.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ DialogDownloadChoiceBinding $alertBinding;
        public final /* synthetic */ Book $book;
        public final /* synthetic */ ReadBookBaseActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogDownloadChoiceBinding dialogDownloadChoiceBinding, Book book, ReadBookBaseActivity readBookBaseActivity) {
            super(1);
            this.$alertBinding = dialogDownloadChoiceBinding;
            this.$book = book;
            this.this$0 = readBookBaseActivity;
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
            DialogDownloadChoiceBinding dialogDownloadChoiceBinding = this.$alertBinding;
            Book book = this.$book;
            ReadBookBaseActivity readBookBaseActivity = this.this$0;
            Editable text = dialogDownloadChoiceBinding.f6612c.getText();
            Integer numValueOf = null;
            String string2 = text == null ? null : text.toString();
            int i2 = string2 == null ? 0 : Integer.parseInt(string2);
            Editable text2 = dialogDownloadChoiceBinding.f6611b.getText();
            if (text2 != null && (string = text2.toString()) != null) {
                numValueOf = Integer.valueOf(Integer.parseInt(string));
            }
            e.a.a.f.s.h.a.c(readBookBaseActivity, book.getBookUrl(), i2 - 1, (numValueOf == null ? book.getTotalChapterNum() : numValueOf.intValue()) - 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(ReadBookBaseActivity readBookBaseActivity, Book book) {
        super(1);
        this.this$0 = readBookBaseActivity;
        this.$book = book;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        View viewInflate = this.this$0.getLayoutInflater().inflate(R.layout.dialog_download_choice, (ViewGroup) null, false);
        int i2 = R.id.edit_end;
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_end);
        if (editText != null) {
            i2 = R.id.edit_start;
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.edit_start);
            if (editText2 != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                DialogDownloadChoiceBinding dialogDownloadChoiceBinding = new DialogDownloadChoiceBinding(linearLayout, editText, editText2, linearLayout);
                Book book = this.$book;
                Context context = linearLayout.getContext();
                f.c0.c.j.d(context, "root.context");
                linearLayout.setBackgroundColor(c.b.a.m.f.R1(context));
                editText2.setText(String.valueOf(book.getDurChapterIndex() + 1));
                editText.setText(String.valueOf(book.getTotalChapterNum()));
                f.c0.c.j.d(dialogDownloadChoiceBinding, "inflate(layoutInflater).apply {\n                    root.setBackgroundColor(root.context.backgroundColor)\n                    editStart.setText((book.durChapterIndex + 1).toString())\n                    editEnd.setText(book.totalChapterNum.toString())\n                }");
                hVar.d(new a(dialogDownloadChoiceBinding));
                hVar.i(new b(dialogDownloadChoiceBinding, this.$book, this.this$0));
                c.b.a.m.f.d4(hVar, null, 1, null);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
