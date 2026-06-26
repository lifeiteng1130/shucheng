package e.a.a.g.h.g;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import f.v;
import io.legado.app.databinding.DialogBookshelfConfigBinding;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.main.bookshelf.BookshelfFragment;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookshelfFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, v> {
    public final /* synthetic */ BookshelfFragment this$0;

    /* JADX INFO: compiled from: BookshelfFragment.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<View> {
        public final /* synthetic */ DialogBookshelfConfigBinding $alertBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DialogBookshelfConfigBinding dialogBookshelfConfigBinding) {
            super(0);
            this.$alertBinding = dialogBookshelfConfigBinding;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final View invoke() {
            ConstraintLayout constraintLayout = this.$alertBinding.a;
            f.c0.c.j.d(constraintLayout, "alertBinding.root");
            return constraintLayout;
        }
    }

    /* JADX INFO: compiled from: BookshelfFragment.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, v> {
        public final /* synthetic */ DialogBookshelfConfigBinding $alertBinding;
        public final /* synthetic */ int $bookshelfLayout;
        public final /* synthetic */ int $bookshelfSort;
        public final /* synthetic */ BookshelfFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogBookshelfConfigBinding dialogBookshelfConfigBinding, int i2, BookshelfFragment bookshelfFragment, int i3) {
            super(1);
            this.$alertBinding = dialogBookshelfConfigBinding;
            this.$bookshelfLayout = i2;
            this.this$0 = bookshelfFragment;
            this.$bookshelfSort = i3;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            boolean z;
            FragmentActivity activity;
            f.c0.c.j.e(dialogInterface, "it");
            DialogBookshelfConfigBinding dialogBookshelfConfigBinding = this.$alertBinding;
            int i2 = this.$bookshelfLayout;
            BookshelfFragment bookshelfFragment = this.this$0;
            int i3 = this.$bookshelfSort;
            RadioGroup radioGroup = dialogBookshelfConfigBinding.f6589b;
            f.c0.c.j.d(radioGroup, "rgLayout");
            boolean z2 = true;
            if (i2 != c.b.a.m.f.U1(radioGroup)) {
                RadioGroup radioGroup2 = dialogBookshelfConfigBinding.f6589b;
                f.c0.c.j.d(radioGroup2, "rgLayout");
                e.a.a.h.m.i(bookshelfFragment, "bookshelfLayout", c.b.a.m.f.U1(radioGroup2));
                z = true;
            } else {
                z = false;
            }
            RadioGroup radioGroup3 = dialogBookshelfConfigBinding.f6590c;
            f.c0.c.j.d(radioGroup3, "rgSort");
            if (i3 != c.b.a.m.f.U1(radioGroup3)) {
                RadioGroup radioGroup4 = dialogBookshelfConfigBinding.f6590c;
                f.c0.c.j.d(radioGroup4, "rgSort");
                e.a.a.h.m.i(bookshelfFragment, "bookshelfSort", c.b.a.m.f.U1(radioGroup4));
                z = true;
            }
            if (e.a.a.d.e.a.j() != dialogBookshelfConfigBinding.f6591d.isChecked()) {
                c.b.a.m.f.o4(k.d.a.h.g(), "showUnread", dialogBookshelfConfigBinding.f6591d.isChecked());
            } else {
                z2 = z;
            }
            if (!z2 || (activity = bookshelfFragment.getActivity()) == null) {
                return;
            }
            activity.recreate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BookshelfFragment bookshelfFragment) {
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
        int iE = e.a.a.h.m.e(this.this$0, "bookshelfLayout", 0, 2);
        int iE2 = e.a.a.h.m.e(this.this$0, "bookshelfSort", 0, 2);
        View viewInflate = this.this$0.getLayoutInflater().inflate(R.layout.dialog_bookshelf_config, (ViewGroup) null, false);
        int i2 = R.id.ll_layout;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_layout);
        if (linearLayout != null) {
            i2 = R.id.ll_sort;
            LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.ll_sort);
            if (linearLayout2 != null) {
                i2 = R.id.rg_layout;
                RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.id.rg_layout);
                if (radioGroup != null) {
                    i2 = R.id.rg_sort;
                    RadioGroup radioGroup2 = (RadioGroup) viewInflate.findViewById(R.id.rg_sort);
                    if (radioGroup2 != null) {
                        i2 = R.id.sw_show_unread;
                        ATESwitch aTESwitch = (ATESwitch) viewInflate.findViewById(R.id.sw_show_unread);
                        if (aTESwitch != null) {
                            DialogBookshelfConfigBinding dialogBookshelfConfigBinding = new DialogBookshelfConfigBinding((ConstraintLayout) viewInflate, linearLayout, linearLayout2, radioGroup, radioGroup2, aTESwitch);
                            f.c0.c.j.d(radioGroup, "rgLayout");
                            c.b.a.m.f.M0(radioGroup, iE);
                            f.c0.c.j.d(radioGroup2, "rgSort");
                            c.b.a.m.f.M0(radioGroup2, iE2);
                            aTESwitch.setChecked(e.a.a.d.e.a.j());
                            f.c0.c.j.d(dialogBookshelfConfigBinding, "inflate(layoutInflater)\n                    .apply {\n                        rgLayout.checkByIndex(bookshelfLayout)\n                        rgSort.checkByIndex(bookshelfSort)\n                        swShowUnread.isChecked = AppConfig.showUnread\n                    }");
                            hVar.d(new a(dialogBookshelfConfigBinding));
                            hVar.m(new b(dialogBookshelfConfigBinding, iE, this.this$0, iE2));
                            c.b.a.m.f.d4(hVar, null, 1, null);
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
