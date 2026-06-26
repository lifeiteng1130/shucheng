package io.legado.app.ui.main.my;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import androidx.view.Observer;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.tencent.bugly.beta.Beta;
import com.umeng.analytics.pro.c;
import e.a.a.d.e;
import e.a.a.h.m;
import e.a.a.h.u;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.f0.h;
import f.v;
import io.legado.app.base.BaseFragment;
import io.legado.app.base.BasePreferenceFragment;
import io.legado.app.databinding.FragmentMyConfigBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.service.WebService;
import io.legado.app.ui.about.AboutActivity;
import io.legado.app.ui.about.ReadRecordActivity;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import io.legado.app.ui.config.ConfigActivity;
import io.legado.app.ui.replace.ReplaceRuleActivity;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.legado.app.ui.widget.prefs.PreferenceCategory;
import io.legado.app.ui.widget.prefs.SwitchPreference;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MyFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lio/legado/app/ui/main/my/MyFragment;", "Lio/legado/app/base/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "P", "(Landroid/view/Menu;)V", "Landroid/view/MenuItem;", "item", "Q", "(Landroid/view/MenuItem;)V", "Lio/legado/app/databinding/FragmentMyConfigBinding;", "e", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "getBinding", "()Lio/legado/app/databinding/FragmentMyConfigBinding;", "binding", "<init>", "()V", "PreferenceFragment", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class MyFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: compiled from: MyFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u000fJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lio/legado/app/ui/main/my/MyFragment$PreferenceFragment;", "Lio/legado/app/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "Lf/v;", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "Landroid/content/SharedPreferences;", "sharedPreferences", "key", "onSharedPreferenceChanged", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "Landroidx/preference/Preference;", "preference", "", "onPreferenceTreeClick", "(Landroidx/preference/Preference;)Z", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PreferenceFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* JADX INFO: compiled from: MyFragment.kt */
        public static final class a extends k implements l<String, v> {
            public final /* synthetic */ SwitchPreference $webServicePre;
            public final /* synthetic */ PreferenceFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(SwitchPreference switchPreference, PreferenceFragment preferenceFragment) {
                super(1);
                this.$webServicePre = switchPreference;
                this.this$0 = preferenceFragment;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(String str) {
                invoke2(str);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String str) {
                j.e(str, "it");
                SwitchPreference switchPreference = this.$webServicePre;
                if (switchPreference == null) {
                    return;
                }
                PreferenceFragment preferenceFragment = this.this$0;
                switchPreference.setChecked(WebService.f6964b);
                switchPreference.setSummary(WebService.f6964b ? WebService.f6965c : preferenceFragment.getString(R.string.web_service_desc));
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            PreferenceCategory preferenceCategory;
            if (WebService.f6964b) {
                m.h(this, "webService", true);
            } else {
                m.h(this, "webService", false);
            }
            addPreferencesFromResource(R.xml.pref_main);
            Preference preferenceFindPreference = findPreference("version");
            if (preferenceFindPreference != null) {
                preferenceFindPreference.setSummary("1.20.10");
            }
            String[] strArr = {"webService"};
            final a aVar = new a((SwitchPreference) findPreference("webService"), this);
            Observer observer = new Observer() { // from class: io.legado.app.utils.EventBusExtensionsKt$observeEventSticky$o$2
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // androidx.view.Observer
                public final void onChanged(EVENT event) {
                    aVar.invoke(event);
                }
            };
            for (int i2 = 0; i2 < 1; i2++) {
                Observable observable = LiveEventBus.get(strArr[i2], String.class);
                j.d(observable, "get(tag, EVENT::class.java)");
                observable.observeSticky(this, observer);
            }
            e eVar = e.a;
            if (!e.f5517b || (preferenceCategory = (PreferenceCategory) findPreference("aboutCategory")) == null) {
                return;
            }
            preferenceCategory.removePreferenceRecursively("donate");
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
            super.onPause();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(@Nullable Preference preference) throws IOException {
            u uVar = u.a;
            u.a("MyFragment", j.k("mykey is ", preference.getKey()));
            String key = preference.getKey();
            if (key != null) {
                switch (key.hashCode()) {
                    case -1581715007:
                        if (key.equals("share_app")) {
                            String string = getString(R.string.app_name);
                            j.d(string, "getString(R.string.app_name)");
                            String strF = m.f(this, "appDownloadUrl", null, 2);
                            FragmentActivity fragmentActivityRequireActivity = requireActivity();
                            j.d(fragmentActivityRequireActivity, "requireActivity()");
                            StringBuilder sb = new StringBuilder();
                            sb.append("我正在看看小说,快来");
                            sb.append(string);
                            sb.append("和我一起看吧,浏览器打开");
                            sb.append((Object) strF);
                            sb.append("下载");
                            String strP = c.a.a.a.a.p(sb, string, "app");
                            String string2 = getString(R.string.app_name);
                            j.d(string2, "getString(R.string.app_name)");
                            f.f5(fragmentActivityRequireActivity, strP, string2);
                        }
                        break;
                    case -543118969:
                        if (key.equals("readRecord")) {
                            startActivity(new Intent(requireContext(), (Class<?>) ReadRecordActivity.class));
                        }
                        break;
                    case 92611469:
                        if (key.equals("about")) {
                            startActivity(new Intent(requireContext(), (Class<?>) AboutActivity.class));
                        }
                        break;
                    case 351608024:
                        if (key.equals("version")) {
                            Beta.checkUpgrade();
                        }
                        break;
                    case 432371099:
                        if (key.equals("disclaimer")) {
                            InputStream inputStreamOpen = requireContext().getAssets().open("help/disclaimer.md");
                            j.d(inputStreamOpen, "requireContext().assets.open(\"help/disclaimer.md\")");
                            String str = new String(f.w4(inputStreamOpen), f.h0.a.a);
                            String string3 = getString(R.string.app_name);
                            j.d(string3, "getString(R.string.app_name)");
                            String strC = f.h0.k.C(str, "{{appName}}", string3, false, 4);
                            TextDialog.Companion companion = TextDialog.INSTANCE;
                            FragmentManager childFragmentManager = getChildFragmentManager();
                            j.d(childFragmentManager, "childFragmentManager");
                            TextDialog.Companion.a(companion, childFragmentManager, strC, 1, 0L, false, 24);
                        }
                        break;
                    case 506944319:
                        if (key.equals("web_dav_setting")) {
                            Intent intent = new Intent(requireContext(), (Class<?>) ConfigActivity.class);
                            intent.putExtra("configType", 2);
                            startActivity(intent);
                        }
                        break;
                    case 876635449:
                        if (key.equals("replaceManage")) {
                            startActivity(new Intent(requireContext(), (Class<?>) ReplaceRuleActivity.class));
                        }
                        break;
                    case 1032694505:
                        if (key.equals("bookSourceManage")) {
                            startActivity(new Intent(requireContext(), (Class<?>) BookSourceActivity.class));
                        }
                        break;
                    case 1985941072:
                        if (key.equals("setting")) {
                            Intent intent2 = new Intent(requireContext(), (Class<?>) ConfigActivity.class);
                            intent2.putExtra("configType", 0);
                            startActivity(intent2);
                        }
                        break;
                    case 1995985370:
                        if (key.equals("theme_setting")) {
                            Intent intent3 = new Intent(requireContext(), (Class<?>) ConfigActivity.class);
                            intent3.putExtra("configType", 1);
                            startActivity(intent3);
                        }
                        break;
                }
            }
            return super.onPreferenceTreeClick(preference);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
            if (!j.a(key, "webService")) {
                if (j.a(key, "recordLog")) {
                    u.a.c();
                    return;
                }
                return;
            }
            Context contextRequireContext = requireContext();
            j.d(contextRequireContext, "requireContext()");
            if (!f.K2(contextRequireContext, "webService", false, 2)) {
                Context contextRequireContext2 = requireContext();
                j.d(contextRequireContext2, "requireContext()");
                WebService.b(contextRequireContext2);
            } else {
                Context contextRequireContext3 = requireContext();
                j.d(contextRequireContext3, "requireContext()");
                j.e(contextRequireContext3, c.R);
                contextRequireContext3.startService(new Intent(contextRequireContext3, (Class<?>) WebService.class));
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
            j.e(view, "view");
            super.onViewCreated(view, savedInstanceState);
            ATH.a.b(getListView());
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class a extends k implements l<MyFragment, FragmentMyConfigBinding> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentMyConfigBinding invoke(@NotNull MyFragment myFragment) {
            j.e(myFragment, "fragment");
            View viewRequireView = myFragment.requireView();
            int i2 = R.id.pre_fragment;
            LinearLayout linearLayout = (LinearLayout) viewRequireView.findViewById(R.id.pre_fragment);
            if (linearLayout != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewRequireView.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    return new FragmentMyConfigBinding((LinearLayout) viewRequireView, linearLayout, titleBar);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(f.c0.c.v.a(MyFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentMyConfigBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        f7454d = new h[]{qVar};
    }

    public MyFragment() {
        super(R.layout.fragment_my_config);
        this.binding = f.b6(this, new a());
    }

    @Override // io.legado.app.base.BaseFragment
    public void P(@NotNull Menu menu) {
        j.e(menu, "menu");
        N().inflate(R.menu.main_my, menu);
    }

    @Override // io.legado.app.base.BaseFragment
    public void Q(@NotNull MenuItem item) {
        j.e(item, "item");
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        T(((FragmentMyConfigBinding) this.binding.b(this, f7454d[0])).f6731b.getToolbar());
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("prefFragment");
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = new PreferenceFragment();
        }
        getChildFragmentManager().beginTransaction().replace(R.id.pre_fragment, fragmentFindFragmentByTag, "prefFragment").commit();
    }
}
