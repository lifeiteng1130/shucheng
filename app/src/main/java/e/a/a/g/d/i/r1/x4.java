package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import com.google.android.material.snackbar.Snackbar;
import io.legado.app.base.BaseViewModel;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.ui.book.read.config.TocRegexDialog;
import io.legado.app.ui.book.read.config.TocRegexViewModel;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TocRegexDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x4 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ e.a.a.h.f $aCache;
    public final /* synthetic */ List<String> $cacheUrls;
    public final /* synthetic */ TocRegexDialog this$0;

    /* JADX INFO: compiled from: TocRegexDialog.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<String, f.v> {
        public final /* synthetic */ e.a.a.h.f $aCache;
        public final /* synthetic */ List<String> $cacheUrls;
        public final /* synthetic */ TocRegexDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<String> list, e.a.a.h.f fVar, TocRegexDialog tocRegexDialog) {
            super(1);
            this.$cacheUrls = list;
            this.$aCache = fVar;
            this.this$0 = tocRegexDialog;
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
            this.$aCache.b(this.this$0.importTocRuleKey, f.x.e.q(this.$cacheUrls, ",", null, null, 0, null, null, 62));
        }
    }

    /* JADX INFO: compiled from: TocRegexDialog.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.a<View> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding) {
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

    /* JADX INFO: compiled from: TocRegexDialog.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ e.a.a.h.f $aCache;
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ List<String> $cacheUrls;
        public final /* synthetic */ TocRegexDialog this$0;

        /* JADX INFO: compiled from: TocRegexDialog.kt */
        public static final class a extends f.c0.c.k implements f.c0.b.l<String, f.v> {
            public final /* synthetic */ TocRegexDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(TocRegexDialog tocRegexDialog) {
                super(1);
                this.this$0 = tocRegexDialog;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ f.v invoke(String str) {
                invoke2(str);
                return f.v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String str) {
                f.c0.c.j.e(str, NotificationCompat.CATEGORY_MESSAGE);
                TocRegexDialog tocRegexDialog = this.this$0;
                TocRegexDialog.Companion companion = TocRegexDialog.INSTANCE;
                Toolbar toolbar = tocRegexDialog.R().f6697c;
                f.c0.c.j.d(toolbar, "binding.toolBar");
                c.b.a.m.f.k5(toolbar, str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DialogEditTextBinding dialogEditTextBinding, List<String> list, e.a.a.h.f fVar, TocRegexDialog tocRegexDialog) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.$cacheUrls = list;
            this.$aCache = fVar;
            this.this$0 = tocRegexDialog;
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
            TocRegexDialog tocRegexDialog = this.this$0;
            if (!list.contains(string)) {
                list.add(0, string);
                fVar.b(tocRegexDialog.importTocRuleKey, f.x.e.q(list, ",", null, null, 0, null, null, 62));
            }
            TocRegexDialog.Companion companion = TocRegexDialog.INSTANCE;
            Snackbar.k(tocRegexDialog.R().f6697c, R.string.importing, -2).o();
            TocRegexViewModel tocRegexViewModel = (TocRegexViewModel) tocRegexDialog.viewModel.getValue();
            a aVar = new a(tocRegexDialog);
            Objects.requireNonNull(tocRegexViewModel);
            f.c0.c.j.e(string, "url");
            f.c0.c.j.e(aVar, "finally");
            e.a.a.d.u.b bVarA = BaseViewModel.a(tocRegexViewModel, null, null, new z4(string, null), 3, null);
            bVarA.d(null, new a5(aVar, null));
            e.a.a.d.u.b.b(bVarA, null, new b5(aVar, null), 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x4(TocRegexDialog tocRegexDialog, List<String> list, e.a.a.h.f fVar) {
        super(1);
        this.this$0 = tocRegexDialog;
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
        f.c0.c.j.d(dialogEditTextBindingA, "inflate(layoutInflater)");
        List<String> list = this.$cacheUrls;
        e.a.a.h.f fVar = this.$aCache;
        TocRegexDialog tocRegexDialog = this.this$0;
        dialogEditTextBindingA.f6613b.setFilterValues(list);
        dialogEditTextBindingA.f6613b.setDelCallBack(new a(list, fVar, tocRegexDialog));
        hVar.d(new b(dialogEditTextBindingA));
        hVar.m(new c(dialogEditTextBindingA, this.$cacheUrls, this.$aCache, this.this$0));
        c.b.a.m.f.K0(hVar, null, 1, null);
    }
}
