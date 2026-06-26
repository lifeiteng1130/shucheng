package e.a.a.g.e;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.config.OtherConfigFragment;
import io.legado.app.ui.widget.text.AutoCompleteTextView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OtherConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ OtherConfigFragment this$0;

    /* JADX INFO: compiled from: OtherConfigFragment.kt */
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

    /* JADX INFO: compiled from: OtherConfigFragment.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ OtherConfigFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, OtherConfigFragment otherConfigFragment) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.this$0 = otherConfigFragment;
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
            if (string == null || f.h0.k.s(string)) {
                e.a.a.h.m.k(this.this$0, TTDownloadField.TT_USERAGENT);
            } else {
                e.a.a.h.m.j(this.this$0, TTDownloadField.TT_USERAGENT, string);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(OtherConfigFragment otherConfigFragment) {
        super(1);
        this.this$0 = otherConfigFragment;
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
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater)");
        AutoCompleteTextView autoCompleteTextView = dialogEditTextBindingA.f6613b;
        e.a.a.d.e eVar = e.a.a.d.e.a;
        autoCompleteTextView.setText(e.a.a.d.e.f5518c);
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
