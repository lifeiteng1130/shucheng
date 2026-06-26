package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import io.legado.app.base.BaseViewModel;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.book.read.config.SpeakEngineDialog;
import io.legado.app.ui.book.read.config.SpeakEngineViewModel;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpeakEngineDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z3 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ e.a.a.h.f $aCache;
    public final /* synthetic */ List<String> $cacheUrls;
    public final /* synthetic */ SpeakEngineDialog this$0;

    /* JADX INFO: compiled from: SpeakEngineDialog.kt */
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

    /* JADX INFO: compiled from: SpeakEngineDialog.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ e.a.a.h.f $aCache;
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ List<String> $cacheUrls;
        public final /* synthetic */ SpeakEngineDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, List<String> list, e.a.a.h.f fVar, SpeakEngineDialog speakEngineDialog) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.$cacheUrls = list;
            this.$aCache = fVar;
            this.this$0 = speakEngineDialog;
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
            List<String> list = this.$cacheUrls;
            e.a.a.h.f fVar = this.$aCache;
            SpeakEngineDialog speakEngineDialog = this.this$0;
            if (!list.contains(string)) {
                list.add(0, string);
                fVar.b(speakEngineDialog.ttsUrlKey, f.x.e.q(list, ",", null, null, 0, null, null, 62));
            }
            f.f0.h<Object>[] hVarArr = SpeakEngineDialog.f7195b;
            SpeakEngineViewModel speakEngineViewModelR = speakEngineDialog.R();
            Objects.requireNonNull(speakEngineViewModelR);
            f.c0.c.j.e(string, "url");
            e.a.a.d.u.b bVarA = BaseViewModel.a(speakEngineViewModelR, null, null, new f4(string, speakEngineViewModelR, null), 3, null);
            bVarA.d(null, new g4(speakEngineViewModelR, null));
            e.a.a.d.u.b.b(bVarA, null, new h4(speakEngineViewModelR, null), 1);
        }
    }

    /* JADX INFO: compiled from: SpeakEngineDialog.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.l<String, f.v> {
        public final /* synthetic */ e.a.a.h.f $aCache;
        public final /* synthetic */ List<String> $cacheUrls;
        public final /* synthetic */ SpeakEngineDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List<String> list, e.a.a.h.f fVar, SpeakEngineDialog speakEngineDialog) {
            super(1);
            this.$cacheUrls = list;
            this.$aCache = fVar;
            this.this$0 = speakEngineDialog;
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
            this.$aCache.b(this.this$0.ttsUrlKey, f.x.e.q(this.$cacheUrls, ",", null, null, 0, null, null, 62));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z3(SpeakEngineDialog speakEngineDialog, List<String> list, e.a.a.h.f fVar) {
        super(1);
        this.this$0 = speakEngineDialog;
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
        SpeakEngineDialog speakEngineDialog = this.this$0;
        dialogEditTextBindingA.f6613b.setFilterValues(list);
        dialogEditTextBindingA.f6613b.setDelCallBack(new c(list, fVar, speakEngineDialog));
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                editView.setFilterValues(cacheUrls)\n                editView.delCallBack = {\n                    cacheUrls.remove(it)\n                    aCache.put(ttsUrlKey, cacheUrls.joinToString(\",\"))\n                }\n            }");
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.$cacheUrls, this.$aCache, this.this$0));
    }
}
