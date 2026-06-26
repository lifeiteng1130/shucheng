package e.a.a.g.d.l.c;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.service.CheckSourceService;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import io.legado.app.ui.book.source.manage.BookSourceAdapter;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookSourceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
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
            if (text != null && (string = text.toString()) != null) {
                if (string.length() > 0) {
                    f.c0.c.j.e(string, "<set-?>");
                    e.a.a.f.s.i.a = string;
                }
            }
            BookSourceActivity bookSourceActivity = this.this$0;
            BookSourceAdapter bookSourceAdapter = bookSourceActivity.adapter;
            if (bookSourceAdapter == null) {
                f.c0.c.j.m("adapter");
                throw null;
            }
            List<BookSource> listA = bookSourceAdapter.A();
            f.c0.c.j.e(bookSourceActivity, com.umeng.analytics.pro.c.R);
            f.c0.c.j.e(listA, "sources");
            if (listA.isEmpty()) {
                c.b.a.m.f.Q5(bookSourceActivity, R.string.non_select);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(c.b.a.m.f.S0(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(arrayList.add(((BookSource) it.next()).getBookSourceUrl())));
            }
            Intent intent = new Intent(bookSourceActivity, (Class<?>) CheckSourceService.class);
            intent.setAction("start");
            intent.putExtra("selectIds", arrayList);
            bookSourceActivity.startService(intent);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(BookSourceActivity bookSourceActivity) {
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
        dialogEditTextBindingA.f6613b.setText(e.a.a.f.s.i.a);
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                editView.setText(CheckSource.keyword)\n            }");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
