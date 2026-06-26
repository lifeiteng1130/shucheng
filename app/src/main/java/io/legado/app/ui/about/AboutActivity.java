package io.legado.app.ui.about;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import f.c0.c.j;
import f.h0.k;
import io.legado.app.base.BaseActivity;
import io.legado.app.databinding.ActivityAboutBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AboutActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/legado/app/ui/about/AboutActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityAboutBinding;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AboutActivity extends BaseActivity<ActivityAboutBinding> {

    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f6969b;

        public a(int i2, Object obj) {
            this.a = i2;
            this.f6969b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws IOException {
            int i2 = this.a;
            if (i2 == 0) {
                InputStream inputStreamOpen = ((AboutActivity) this.f6969b).getAssets().open("help/useAgreement.md");
                j.d(inputStreamOpen, "assets.open(\"help/useAgreement.md\")");
                String str = new String(f.w4(inputStreamOpen), f.h0.a.a);
                String string = ((AboutActivity) this.f6969b).getString(R.string.app_name);
                j.d(string, "getString(R.string.app_name)");
                String strC = k.C(str, "{{appName}}", string, false, 4);
                TextDialog.Companion companion = TextDialog.INSTANCE;
                FragmentManager supportFragmentManager = ((AboutActivity) this.f6969b).getSupportFragmentManager();
                j.d(supportFragmentManager, "supportFragmentManager");
                TextDialog.Companion.a(companion, supportFragmentManager, strC, 1, 0L, false, 24);
                return;
            }
            if (i2 != 1) {
                throw null;
            }
            InputStream inputStreamOpen2 = ((AboutActivity) this.f6969b).getAssets().open("help/privacyAgreement.md");
            j.d(inputStreamOpen2, "assets.open(\"help/privacyAgreement.md\")");
            String str2 = new String(f.w4(inputStreamOpen2), f.h0.a.a);
            String string2 = ((AboutActivity) this.f6969b).getString(R.string.app_name);
            j.d(string2, "getString(R.string.app_name)");
            String strC2 = k.C(str2, "{{appName}}", string2, false, 4);
            TextDialog.Companion companion2 = TextDialog.INSTANCE;
            FragmentManager supportFragmentManager2 = ((AboutActivity) this.f6969b).getSupportFragmentManager();
            j.d(supportFragmentManager2, "supportFragmentManager");
            TextDialog.Companion.a(companion2, supportFragmentManager2, strC2, 1, 0L, false, 24);
        }
    }

    public AboutActivity() {
        super(false, null, null, false, false, 31);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_about, (ViewGroup) null, false);
        int i2 = R.id.conactUs;
        TextView textView = (TextView) viewInflate.findViewById(R.id.conactUs);
        if (textView != null) {
            i2 = R.id.ll_about;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_about);
            if (linearLayout != null) {
                i2 = R.id.privacyAgreement;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.privacyAgreement);
                if (textView2 != null) {
                    i2 = R.id.title_bar;
                    TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                    if (titleBar != null) {
                        i2 = R.id.userAgreement;
                        TextView textView3 = (TextView) viewInflate.findViewById(R.id.userAgreement);
                        if (textView3 != null) {
                            i2 = R.id.version;
                            TextView textView4 = (TextView) viewInflate.findViewById(R.id.version);
                            if (textView4 != null) {
                                ActivityAboutBinding activityAboutBinding = new ActivityAboutBinding((LinearLayout) viewInflate, textView, linearLayout, textView2, titleBar, textView3, textView4);
                                j.d(activityAboutBinding, "inflate(layoutInflater)");
                                return activityAboutBinding;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        K0().f6441b.setBackground(ATH.a.c());
        K0().f6444e.setText("1.20.10");
        TextView textView = K0().f6443d;
        j.d(textView, "binding.userAgreement");
        textView.setOnClickListener(new a(0, this));
        TextView textView2 = K0().f6442c;
        j.d(textView2, "binding.privacyAgreement");
        textView2.setOnClickListener(new a(1, this));
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.about, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.menu_share_it) {
            String string = getString(R.string.app_share_description);
            j.d(string, "getString(R.string.app_share_description)");
            String string2 = getString(R.string.app_name);
            j.d(string2, "getString(R.string.app_name)");
            f.f5(this, string, string2);
        }
        return super.Q0(item);
    }
}
