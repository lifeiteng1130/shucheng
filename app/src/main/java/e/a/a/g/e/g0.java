package e.a.a.g.e;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.ScrollView;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.help.ThemeConfig;
import io.legado.app.ui.config.ThemeConfigFragment;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ThemeConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ String $key;
    public final /* synthetic */ ThemeConfigFragment this$0;

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
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

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ DialogEditTextBinding $alertBinding;
        public final /* synthetic */ String $key;
        public final /* synthetic */ ThemeConfigFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DialogEditTextBinding dialogEditTextBinding, String str, ThemeConfigFragment themeConfigFragment) {
            super(1);
            this.$alertBinding = dialogEditTextBinding;
            this.$key = str;
            this.this$0 = themeConfigFragment;
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
            String str = this.$key;
            ThemeConfigFragment themeConfigFragment = this.this$0;
            if (f.c0.c.j.a(str, "saveDayTheme")) {
                ThemeConfig themeConfig = ThemeConfig.a;
                Context contextRequireContext = themeConfigFragment.requireContext();
                f.c0.c.j.d(contextRequireContext, "requireContext()");
                f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
                f.c0.c.j.e(string, "name");
                themeConfig.a(new ThemeConfig.Config(string, false, f.c0.c.j.k("#", c.b.a.m.f.w2(c.b.a.m.f.L2(contextRequireContext, "colorPrimary", c.b.a.m.f.c2(contextRequireContext, R.color.md_brown_500)))), f.c0.c.j.k("#", c.b.a.m.f.w2(c.b.a.m.f.L2(contextRequireContext, "colorAccent", c.b.a.m.f.c2(contextRequireContext, R.color.md_red_600)))), f.c0.c.j.k("#", c.b.a.m.f.w2(c.b.a.m.f.L2(contextRequireContext, "colorBackground", c.b.a.m.f.c2(contextRequireContext, R.color.md_grey_100)))), f.c0.c.j.k("#", c.b.a.m.f.w2(c.b.a.m.f.L2(contextRequireContext, "colorBottomBackground", c.b.a.m.f.c2(contextRequireContext, R.color.md_grey_200))))));
                return;
            }
            if (f.c0.c.j.a(str, "saveNightTheme")) {
                ThemeConfig themeConfig2 = ThemeConfig.a;
                Context contextRequireContext2 = themeConfigFragment.requireContext();
                f.c0.c.j.d(contextRequireContext2, "requireContext()");
                f.c0.c.j.e(contextRequireContext2, com.umeng.analytics.pro.c.R);
                f.c0.c.j.e(string, "name");
                themeConfig2.a(new ThemeConfig.Config(string, true, f.c0.c.j.k("#", c.b.a.m.f.w2(c.b.a.m.f.L2(contextRequireContext2, "colorPrimaryNight", c.b.a.m.f.c2(contextRequireContext2, R.color.md_blue_grey_600)))), f.c0.c.j.k("#", c.b.a.m.f.w2(c.b.a.m.f.L2(contextRequireContext2, "colorAccentNight", c.b.a.m.f.c2(contextRequireContext2, R.color.md_deep_orange_800)))), f.c0.c.j.k("#", c.b.a.m.f.w2(c.b.a.m.f.L2(contextRequireContext2, "colorBackgroundNight", c.b.a.m.f.c2(contextRequireContext2, R.color.md_grey_900)))), f.c0.c.j.k("#", c.b.a.m.f.w2(c.b.a.m.f.L2(contextRequireContext2, "colorBottomBackgroundNight", c.b.a.m.f.c2(contextRequireContext2, R.color.md_grey_850))))));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(ThemeConfigFragment themeConfigFragment, String str) {
        super(1);
        this.this$0 = themeConfigFragment;
        this.$key = str;
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
        hVar.d(new a(dialogEditTextBindingA));
        hVar.m(new b(dialogEditTextBindingA, this.$key, this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
