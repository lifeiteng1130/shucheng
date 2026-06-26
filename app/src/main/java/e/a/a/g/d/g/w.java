package e.a.a.g.d.g;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import io.legado.app.ui.book.info.BookInfoActivity;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookInfoActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ BookInfoActivity this$0;

    /* JADX INFO: compiled from: BookInfoActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<View> {
        public final /* synthetic */ LinearLayout $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LinearLayout linearLayout) {
            super(0);
            this.$view = linearLayout;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final View invoke() {
            return this.$view;
        }
    }

    /* JADX INFO: compiled from: BookInfoActivity.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ CheckBox $checkBox;
        public final /* synthetic */ BookInfoActivity this$0;

        /* JADX INFO: compiled from: BookInfoActivity.kt */
        public static final class a extends f.c0.c.k implements f.c0.b.a<f.v> {
            public final /* synthetic */ BookInfoActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(BookInfoActivity bookInfoActivity) {
                super(0);
                this.this$0 = bookInfoActivity;
            }

            @Override // f.c0.b.a
            public /* bridge */ /* synthetic */ f.v invoke() {
                invoke2();
                return f.v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.finish();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BookInfoActivity bookInfoActivity, CheckBox checkBox) {
            super(1);
            this.this$0 = bookInfoActivity;
            this.$checkBox = checkBox;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            this.this$0.U0().g(this.$checkBox.isChecked(), new a(this.this$0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(BookInfoActivity bookInfoActivity) {
        super(1);
        this.this$0 = bookInfoActivity;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        CheckBox checkBox = new CheckBox(this.this$0);
        checkBox.setText(R.string.delete_book_file);
        LinearLayout linearLayout = new LinearLayout(this.this$0);
        linearLayout.setPadding(c.b.a.m.f.m2(16), 0, c.b.a.m.f.m2(16), 0);
        linearLayout.addView(checkBox);
        hVar.d(new a(linearLayout));
        hVar.c(R.string.yes, new b(this.this$0, checkBox));
        hVar.e(R.string.no, null);
    }
}
