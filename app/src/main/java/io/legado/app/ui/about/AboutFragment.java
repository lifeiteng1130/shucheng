package io.legado.app.ui.about;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.c.c;
import e.a.a.e.a.i;
import f.c0.c.j;
import f.g;
import f.x.e;
import io.wenyuange.app.release.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AboutFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R2\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lio/legado/app/ui/about/AboutFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "Lf/v;", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/preference/Preference;", "preference", "", "onPreferenceTreeClick", "(Landroidx/preference/Preference;)Z", "", "addressID", "N", "(I)V", ai.at, "Ljava/lang/String;", "licenseUrl", "b", "disclaimerUrl", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", ai.aD, "Ljava/util/LinkedHashMap;", "qqGroups", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AboutFragment extends PreferenceFragmentCompat {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final String licenseUrl = "https://github.com/gedoor/legado/blob/master/LICENSE";

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String disclaimerUrl = "https://gedoor.github.io/MyBookshelf/disclaimer.html";

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashMap<String, String> qqGroups = e.t(new g("(QQ群VIP1)701903217", "-iolizL4cbJSutKRpeImHlXlpLDZnzeF"), new g("(QQ群VIP2)263949160", "xwfh7_csb2Gf3Aw2qexEcEtviLfLfd4L"), new g("(QQ群VIP3)680280282", "_N0i7yZObjKSeZQvzoe2ej7j02kLnOOK"), new g("(QQ群VIP4)682555679", "VF2UwvUCuaqlo6pddWTe_kw__a1_Fr8O"), new g("(QQ群1)805192012", "6GlFKjLeIk5RhQnR3PNVDaKB6j10royo"), new g("(QQ群2)773736122", "5Bm5w6OgLupXnICbYvbgzpPUgf0UlsJF"), new g("(QQ群3)981838750", "g_Sgmp2nQPKqcZQ5qPcKLHziwX_mpps9"), new g("(QQ群4)256929088", "czEJPLDnT4Pd9SKQ6RoRVzKhDxLchZrO"), new g("(QQ群5)811843556", "zKZ2UYGZ7o5CzcA6ylxzlqi21si_iqaX"), new g("(QQ群6)870270970", "FeCF8iSxfQbe90HPvGsvcqs5P5oSeY5n"), new g("(QQ群7)15987187", "S2g2TMD0LGd3sefUADd1AbyPEW2o2XfC"), new g("(QQ群8)1079926194", "gg2qFH8q9IPFaCHV3H7CqCN-YljvazE1"), new g("(QQ群9)892108780", "Ci_O3aysKjEBfplOWeCud-rxl71TjU2Q"));

    public final void N(@StringRes int addressID) {
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        String string = getString(addressID);
        j.d(string, "getString(addressID)");
        f.i4(contextRequireContext, string);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        addPreferencesFromResource(R.xml.about);
        Preference preferenceFindPreference = findPreference("update_log");
        if (preferenceFindPreference != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.version));
            sb.append(' ');
            c cVar = c.a;
            sb.append(c.a().f5507b);
            preferenceFindPreference.setSummary(sb.toString());
        }
        e.a.a.d.e eVar = e.a.a.d.e.a;
        if (e.a.a.d.e.f5517b) {
            getPreferenceScreen().removePreferenceRecursively("check_update");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(@Nullable Preference preference) {
        Context context;
        File externalCacheDir;
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -899562001:
                    if (key.equals("sourceRuleSummary")) {
                        N(R.string.source_rule_url);
                    }
                    break;
                case 3616:
                    if (key.equals("qq")) {
                        Integer numValueOf = Integer.valueOf(R.string.join_qq_group);
                        e.a.a.g.a.f fVar = new e.a.a.g.a.f(this);
                        FragmentActivity fragmentActivityRequireActivity = requireActivity();
                        j.d(fragmentActivityRequireActivity, "requireActivity()");
                        ((i) f.h0(fragmentActivityRequireActivity, numValueOf, null, fVar)).p();
                    }
                    break;
                case 3699:
                    if (key.equals("tg")) {
                        N(R.string.tg_url);
                    }
                    break;
                case 102354:
                    if (key.equals("git")) {
                        N(R.string.this_github_url);
                    }
                    break;
                case 3343799:
                    if (key.equals("mail")) {
                        Context contextRequireContext = requireContext();
                        j.d(contextRequireContext, "requireContext()");
                        j.e(contextRequireContext, "<this>");
                        j.e("kunfei.ge@gmail.com", "mail");
                        try {
                            Intent intent = new Intent("android.intent.action.SENDTO");
                            intent.setData(Uri.parse(j.k("mailto:", "kunfei.ge@gmail.com")));
                            intent.addFlags(268435456);
                            contextRequireContext.startActivity(intent);
                        } catch (Exception e2) {
                            String localizedMessage = e2.getLocalizedMessage();
                            if (localizedMessage == null) {
                                localizedMessage = "Error";
                            }
                            f.R5(contextRequireContext, localizedMessage);
                        }
                    }
                    break;
                case 98829282:
                    if (key.equals("gzGzh")) {
                        Context contextRequireContext2 = requireContext();
                        j.d(contextRequireContext2, "requireContext()");
                        String string = getString(R.string.legado_gzh);
                        j.d(string, "getString(R.string.legado_gzh)");
                        f.c5(contextRequireContext2, string);
                    }
                    break;
                case 144316384:
                    if (key.equals("check_update")) {
                        N(R.string.latest_release_url);
                    }
                    break;
                case 166757441:
                    if (key.equals("license")) {
                        Context contextRequireContext3 = requireContext();
                        j.d(contextRequireContext3, "requireContext()");
                        f.i4(contextRequireContext3, this.licenseUrl);
                    }
                    break;
                case 432371099:
                    if (key.equals("disclaimer")) {
                        Context contextRequireContext4 = requireContext();
                        j.d(contextRequireContext4, "requireContext()");
                        f.i4(contextRequireContext4, this.disclaimerUrl);
                    }
                    break;
                case 1375976184:
                    if (key.equals("contributors")) {
                        N(R.string.contributors_url);
                    }
                    break;
                case 1671380268:
                    if (key.equals("discord")) {
                        N(R.string.discord_url);
                    }
                    break;
                case 1722143261:
                    if (key.equals("crashLog") && (context = getContext()) != null && (externalCacheDir = context.getExternalCacheDir()) != null) {
                        String[] strArr = {"crash"};
                        j.e(externalCacheDir, "root");
                        j.e(strArr, "subDirFiles");
                        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
                        j.e(externalCacheDir, "root");
                        j.e(strArr2, "subDirFiles");
                        StringBuilder sb = new StringBuilder(externalCacheDir.getAbsolutePath());
                        for (String str : strArr2) {
                            if (str.length() > 0) {
                                sb.append(File.separator);
                                sb.append(str);
                            }
                        }
                        String string2 = sb.toString();
                        j.d(string2, "path.toString()");
                        File[] fileArrListFiles = new File(string2).listFiles();
                        ArrayList arrayList = new ArrayList();
                        if (fileArrListFiles != null) {
                            for (File file : fileArrListFiles) {
                                arrayList.add(file.getName());
                            }
                        }
                        Context context2 = getContext();
                        if (context2 != null) {
                            f.a5(context2, Integer.valueOf(R.string.crash_log), arrayList, new e.a.a.g.a.e(fileArrListFiles, this));
                        }
                    }
                    break;
                case 2118081007:
                    if (key.equals("home_page")) {
                        N(R.string.home_page_url);
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getListView().setOverScrollMode(2);
    }
}
