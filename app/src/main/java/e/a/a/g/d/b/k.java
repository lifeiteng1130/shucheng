package e.a.a.g.d.b;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import f.v;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.book.cache.CacheActivity;
import io.legado.app.ui.widget.text.AutoCompleteTextView;
import org.jetbrains.annotations.NotNull;
import org.jsoup.helper.DataUtil;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: CacheActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, v> {
    public final /* synthetic */ CacheActivity this$0;

    /* JADX INFO: compiled from: CacheActivity.kt */
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

    /* JADX INFO: compiled from: CacheActivity.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
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
            e.a.a.d.e eVar = e.a.a.d.e.a;
            Editable text = this.$alertBinding.f6613b.getText();
            String str = DataUtil.defaultCharset;
            if (text != null && (string = text.toString()) != null) {
                str = string;
            }
            f.c0.c.j.e(str, ES6Iterator.VALUE_PROPERTY);
            c.b.a.m.f.r4(k.d.a.h.g(), "exportCharset", str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(CacheActivity cacheActivity) {
        super(1);
        this.this$0 = cacheActivity;
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
        AutoCompleteTextView autoCompleteTextView = dialogEditTextBindingA.f6613b;
        e.a.a.c.c cVar = e.a.a.c.c.a;
        autoCompleteTextView.setFilterValues(e.a.a.c.c.m);
        dialogEditTextBindingA.f6613b.setText(e.a.a.d.e.a.d());
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                editView.setFilterValues(charsets)\n                editView.setText(AppConfig.exportCharset)\n            }");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA));
        c.b.a.m.f.K0(hVar, null, 1, null);
    }
}
