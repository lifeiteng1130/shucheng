package e.a.a.g.d.l.c;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.association.ImportBookSourceActivity;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookSourceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ e.a.a.h.f $aCache;
    public final /* synthetic */ List<String> $cacheUrls;
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
        public final /* synthetic */ e.a.a.h.f $aCache;
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ List<String> $cacheUrls;
        public final /* synthetic */ BookSourceActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, List<String> list, e.a.a.h.f fVar, BookSourceActivity bookSourceActivity) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.$cacheUrls = list;
            this.$aCache = fVar;
            this.this$0 = bookSourceActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            Editable text = this.$alertBinding.f6613b.getText();
            String string = text == null ? null : text.toString();
            if (string == null) {
                return;
            }
            List<String> list = this.$cacheUrls;
            e.a.a.h.f fVar = this.$aCache;
            BookSourceActivity bookSourceActivity = this.this$0;
            if (!list.contains(string)) {
                list.add(0, string);
                fVar.b(bookSourceActivity.importRecordKey, f.x.e.q(list, ",", null, null, 0, null, null, 62));
            }
            Intent intent = new Intent(bookSourceActivity, (Class<?>) ImportBookSourceActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("source", string);
            bookSourceActivity.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: BookSourceActivity.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.l<String, f.v> {
        public final /* synthetic */ e.a.a.h.f $aCache;
        public final /* synthetic */ List<String> $cacheUrls;
        public final /* synthetic */ BookSourceActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List<String> list, e.a.a.h.f fVar, BookSourceActivity bookSourceActivity) {
            super(1);
            this.$cacheUrls = list;
            this.$aCache = fVar;
            this.this$0 = bookSourceActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(String str) {
            invoke2(str);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            f.c0.c.j.e(str, "it");
            this.$cacheUrls.remove(str);
            this.$aCache.b(this.this$0.importRecordKey, f.x.e.q(this.$cacheUrls, ",", null, null, 0, null, null, 62));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(BookSourceActivity bookSourceActivity, List<String> list, e.a.a.h.f fVar) {
        super(1);
        this.this$0 = bookSourceActivity;
        this.$cacheUrls = list;
        this.$aCache = fVar;
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
        List<String> list = this.$cacheUrls;
        e.a.a.h.f fVar = this.$aCache;
        BookSourceActivity bookSourceActivity = this.this$0;
        dialogEditTextBindingA.f6613b.setFilterValues(list);
        dialogEditTextBindingA.f6613b.setDelCallBack(new c(list, fVar, bookSourceActivity));
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                editView.setFilterValues(cacheUrls)\n                editView.delCallBack = {\n                    cacheUrls.remove(it)\n                    aCache.put(importRecordKey, cacheUrls.joinToString(\",\"))\n                }\n            }");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.$cacheUrls, this.$aCache, this.this$0));
        c.b.a.m.f.K0(hVar, null, 1, null);
    }
}
