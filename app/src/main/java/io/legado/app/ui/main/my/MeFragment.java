package io.legado.app.ui.main.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.tencent.bugly.beta.Beta;
import e.a.a.d.w.e;
import e.a.a.h.m;
import e.a.a.h.n;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import f.h0.k;
import io.legado.app.base.BaseFragment;
import io.legado.app.data.entities.SwitchConfig;
import io.legado.app.databinding.FragmentMeConfigBinding;
import io.legado.app.ui.about.AboutActivity;
import io.legado.app.ui.about.FeedbackActivity;
import io.legado.app.ui.about.ReadRecordActivity;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import io.legado.app.ui.config.ConfigActivity;
import io.legado.app.ui.main.my.MeFragment;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MeFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lio/legado/app/ui/main/my/MeFragment;", "Lio/legado/app/base/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lio/legado/app/databinding/FragmentMeConfigBinding;", "e", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "U", "()Lio/legado/app/databinding/FragmentMeConfigBinding;", "binding", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class MeFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f7453b;

        public a(int i2, Object obj) {
            this.a = i2;
            this.f7453b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws IOException {
            switch (this.a) {
                case 0:
                    MeFragment meFragment = (MeFragment) this.f7453b;
                    meFragment.startActivity(new Intent(meFragment.requireContext(), (Class<?>) ReadRecordActivity.class));
                    return;
                case 1:
                    MeFragment meFragment2 = (MeFragment) this.f7453b;
                    Intent intent = new Intent(meFragment2.requireContext(), (Class<?>) ConfigActivity.class);
                    intent.putExtra("configType", 1);
                    meFragment2.startActivity(intent);
                    return;
                case 2:
                    MeFragment meFragment3 = (MeFragment) this.f7453b;
                    Intent intent2 = new Intent(meFragment3.requireContext(), (Class<?>) ConfigActivity.class);
                    intent2.putExtra("configType", 0);
                    meFragment3.startActivity(intent2);
                    return;
                case 3:
                    String string = ((MeFragment) this.f7453b).getString(R.string.app_name);
                    j.d(string, "getString(R.string.app_name)");
                    String strF = m.f((MeFragment) this.f7453b, "appDownloadUrl", null, 2);
                    FragmentActivity fragmentActivityRequireActivity = ((MeFragment) this.f7453b).requireActivity();
                    j.d(fragmentActivityRequireActivity, "requireActivity()");
                    String str = "我正在看看小说,快来" + string + "和我一起看吧,浏览器打开" + ((Object) strF) + "下载" + string + "app";
                    String string2 = ((MeFragment) this.f7453b).getString(R.string.app_name);
                    j.d(string2, "getString(R.string.app_name)");
                    f.f5(fragmentActivityRequireActivity, str, string2);
                    return;
                case 4:
                    InputStream inputStreamOpen = ((MeFragment) this.f7453b).requireContext().getAssets().open("help/disclaimer.md");
                    j.d(inputStreamOpen, "requireContext().assets.open(\"help/disclaimer.md\")");
                    String str2 = new String(f.w4(inputStreamOpen), f.h0.a.a);
                    String string3 = ((MeFragment) this.f7453b).getString(R.string.app_name);
                    j.d(string3, "getString(R.string.app_name)");
                    String strC = k.C(str2, "{{appName}}", string3, false, 4);
                    TextDialog.Companion companion = TextDialog.INSTANCE;
                    FragmentManager childFragmentManager = ((MeFragment) this.f7453b).getChildFragmentManager();
                    j.d(childFragmentManager, "childFragmentManager");
                    TextDialog.Companion.a(companion, childFragmentManager, strC, 1, 0L, false, 24);
                    return;
                case 5:
                    MeFragment meFragment4 = (MeFragment) this.f7453b;
                    meFragment4.startActivity(new Intent(meFragment4.requireContext(), (Class<?>) AboutActivity.class));
                    return;
                case 6:
                    MeFragment meFragment5 = (MeFragment) this.f7453b;
                    meFragment5.startActivity(new Intent(meFragment5.requireContext(), (Class<?>) BookSourceActivity.class));
                    return;
                default:
                    throw null;
            }
        }
    }

    /* JADX INFO: compiled from: Click.kt */
    public static final class b implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Beta.checkUpgrade();
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class c extends f.c0.c.k implements l<MeFragment, FragmentMeConfigBinding> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentMeConfigBinding invoke(@NotNull MeFragment meFragment) {
            j.e(meFragment, "fragment");
            View viewRequireView = meFragment.requireView();
            int i2 = R.id.about;
            LinearLayout linearLayout = (LinearLayout) viewRequireView.findViewById(R.id.about);
            if (linearLayout != null) {
                i2 = R.id.disclaimer;
                LinearLayout linearLayout2 = (LinearLayout) viewRequireView.findViewById(R.id.disclaimer);
                if (linearLayout2 != null) {
                    i2 = R.id.feedBack;
                    LinearLayout linearLayout3 = (LinearLayout) viewRequireView.findViewById(R.id.feedBack);
                    if (linearLayout3 != null) {
                        i2 = R.id.readRecord;
                        LinearLayout linearLayout4 = (LinearLayout) viewRequireView.findViewById(R.id.readRecord);
                        if (linearLayout4 != null) {
                            i2 = R.id.setting;
                            LinearLayout linearLayout5 = (LinearLayout) viewRequireView.findViewById(R.id.setting);
                            if (linearLayout5 != null) {
                                i2 = R.id.share_app;
                                LinearLayout linearLayout6 = (LinearLayout) viewRequireView.findViewById(R.id.share_app);
                                if (linearLayout6 != null) {
                                    i2 = R.id.sourceManage;
                                    LinearLayout linearLayout7 = (LinearLayout) viewRequireView.findViewById(R.id.sourceManage);
                                    if (linearLayout7 != null) {
                                        i2 = R.id.theme_setting;
                                        LinearLayout linearLayout8 = (LinearLayout) viewRequireView.findViewById(R.id.theme_setting);
                                        if (linearLayout8 != null) {
                                            i2 = R.id.title_bar;
                                            TitleBar titleBar = (TitleBar) viewRequireView.findViewById(R.id.title_bar);
                                            if (titleBar != null) {
                                                i2 = R.id.version;
                                                LinearLayout linearLayout9 = (LinearLayout) viewRequireView.findViewById(R.id.version);
                                                if (linearLayout9 != null) {
                                                    i2 = R.id.versionHint;
                                                    TextView textView = (TextView) viewRequireView.findViewById(R.id.versionHint);
                                                    if (textView != null) {
                                                        return new FragmentMeConfigBinding((LinearLayout) viewRequireView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, titleBar, linearLayout9, textView);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(v.a(MeFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentMeConfigBinding;");
        Objects.requireNonNull(v.a);
        f7451d = new h[]{qVar};
    }

    public MeFragment() {
        super(R.layout.fragment_me_config);
        this.binding = f.b6(this, new c());
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        SwitchConfig switchConfig;
        Object objM11constructorimpl;
        j.e(view, "view");
        T(U().f6728j.getToolbar());
        U().f6730l.setText("1.20.10");
        LinearLayout linearLayout = U().f6723e;
        j.d(linearLayout, "binding.readRecord");
        boolean zBooleanValue = false;
        linearLayout.setOnClickListener(new a(0, this));
        LinearLayout linearLayout2 = U().f6727i;
        j.d(linearLayout2, "binding.themeSetting");
        linearLayout2.setOnClickListener(new a(1, this));
        LinearLayout linearLayout3 = U().f6724f;
        j.d(linearLayout3, "binding.setting");
        linearLayout3.setOnClickListener(new a(2, this));
        LinearLayout linearLayout4 = U().f6725g;
        j.d(linearLayout4, "binding.shareApp");
        linearLayout4.setOnClickListener(new a(3, this));
        LinearLayout linearLayout5 = U().f6729k;
        j.d(linearLayout5, "binding.version");
        linearLayout5.setOnClickListener(new b());
        LinearLayout linearLayout6 = U().f6721c;
        j.d(linearLayout6, "binding.disclaimer");
        linearLayout6.setOnClickListener(new a(4, this));
        LinearLayout linearLayout7 = U().f6720b;
        j.d(linearLayout7, "binding.about");
        linearLayout7.setOnClickListener(new a(5, this));
        U().f6726h.setVisibility(8);
        Context context = getContext();
        if (context != null) {
            j.e(context, com.umeng.analytics.pro.c.R);
            try {
                Object obj = null;
                String strO2 = f.O2(context, "switchConfig", null, 2);
                if (strO2 == null) {
                    switchConfig = new SwitchConfig();
                } else {
                    Gson gsonA = n.a();
                    try {
                        Type type = new e().getType();
                        j.d(type, "object : TypeToken<T>() {}.type");
                        Object objFromJson = gsonA.fromJson(strO2, type);
                        if (!(objFromJson instanceof SwitchConfig)) {
                            objFromJson = null;
                        }
                        objM11constructorimpl = f.h.m11constructorimpl((SwitchConfig) objFromJson);
                    } catch (Throwable th) {
                        objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
                    }
                    if (!f.h.m16isFailureimpl(objM11constructorimpl)) {
                        obj = objM11constructorimpl;
                    }
                    switchConfig = (SwitchConfig) obj;
                    if (switchConfig == null) {
                        switchConfig = new SwitchConfig();
                    }
                }
            } catch (Exception unused) {
                switchConfig = new SwitchConfig();
            }
            zBooleanValue = Boolean.valueOf(switchConfig.getFeedBack()).booleanValue();
        }
        if (zBooleanValue) {
            LinearLayout linearLayout8 = U().f6722d;
            j.d(linearLayout8, "binding.feedBack");
            f.c6(linearLayout8);
        } else {
            LinearLayout linearLayout9 = U().f6722d;
            j.d(linearLayout9, "binding.feedBack");
            f.e3(linearLayout9);
        }
        U().f6722d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.h.i.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MeFragment meFragment = this.a;
                h<Object>[] hVarArr = MeFragment.f7451d;
                j.e(meFragment, "this$0");
                meFragment.startActivity(new Intent(meFragment.requireContext(), (Class<?>) FeedbackActivity.class));
            }
        });
        LinearLayout linearLayout10 = U().f6726h;
        j.d(linearLayout10, "binding.sourceManage");
        linearLayout10.setOnClickListener(new a(6, this));
    }

    public final FragmentMeConfigBinding U() {
        return (FragmentMeConfigBinding) this.binding.b(this, f7451d[0]);
    }
}
