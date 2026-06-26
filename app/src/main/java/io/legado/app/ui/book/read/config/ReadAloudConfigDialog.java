package io.legado.app.ui.book.read.config;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.base.BasePreferenceFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.HttpTTS;
import io.legado.app.lib.theme.ATH;
import io.legado.app.service.BaseReadAloudService;
import io.wenyuange.app.release.R;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: ReadAloudConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/legado/app/ui/book/read/config/ReadAloudConfigDialog;", "Landroidx/fragment/app/DialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", ai.at, "Ljava/lang/String;", "readAloudPreferTag", "<init>", "ReadAloudPreferenceFragment", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadAloudConfigDialog extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final String readAloudPreferTag = "readAloudPreferTag";

    /* JADX INFO: compiled from: ReadAloudConfigDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\u000fJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00058B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lio/legado/app/ui/book/read/config/ReadAloudConfigDialog$ReadAloudPreferenceFragment;", "Lio/legado/app/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "Lf/v;", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "Landroidx/preference/Preference;", "preference", "", "onPreferenceTreeClick", "(Landroidx/preference/Preference;)Z", "Landroid/content/SharedPreferences;", "sharedPreferences", "key", "onSharedPreferenceChanged", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", ES6Iterator.VALUE_PROPERTY, "O", "(Landroidx/preference/Preference;Ljava/lang/String;)V", "N", "()Ljava/lang/String;", "speakEngineSummary", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ReadAloudPreferenceFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        public final String N() {
            HttpTTS httpTTS = AppDatabaseKt.getAppDb().getHttpTTSDao().get(f.N2(h.g(), "speakEngine", 0L, 2));
            String name = httpTTS == null ? null : httpTTS.getName();
            if (name != null) {
                return name;
            }
            String string = getString(R.string.system_tts);
            j.d(string, "getString(R.string.system_tts)");
            return string;
        }

        public final void O(Preference preference, String value) {
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int iFindIndexOfValue = listPreference.findIndexOfValue(value);
                listPreference.setSummary(iFindIndexOfValue >= 0 ? listPreference.getEntries()[iFindIndexOfValue] : null);
            } else {
                if (preference == null) {
                    return;
                }
                preference.setSummary(value);
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            addPreferencesFromResource(R.xml.pref_config_aloud);
            O(findPreference("speakEngine"), N());
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
            super.onPause();
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(@Nullable Preference preference) {
            if (j.a(preference.getKey(), "speakEngine")) {
                SpeakEngineDialog speakEngineDialog = new SpeakEngineDialog();
                FragmentManager childFragmentManager = getChildFragmentManager();
                j.d(childFragmentManager, "childFragmentManager");
                speakEngineDialog.show(childFragmentManager, "speakEngine");
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
            if (j.a(key, "readAloudByPage")) {
                if (BaseReadAloudService.f6927b) {
                    LiveEventBus.get("mediaButton").post(Boolean.FALSE);
                    return;
                }
                return;
            }
            if (j.a(key, "speakEngine")) {
                O(findPreference(key), N());
                e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
                e.a.a.f.s.j.f(h.g());
                e.a.a.f.s.j.f5674b = e.a.a.f.s.j.a();
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
            j.e(view, "view");
            super.onViewCreated(view, savedInstanceState);
            ATH.a.b(getListView());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        LinearLayout linearLayout = new LinearLayout(requireContext());
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        linearLayout.setBackgroundColor(f.R1(contextRequireContext));
        linearLayout.setId(R.id.tag1);
        if (container != null) {
            container.addView(linearLayout);
        }
        return linearLayout;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        DisplayMetrics displayMetricsV2 = f.V2(fragmentActivityRequireActivity);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), -2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(this.readAloudPreferTag);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = new ReadAloudPreferenceFragment();
        }
        getChildFragmentManager().beginTransaction().replace(view.getId(), fragmentFindFragmentByTag, this.readAloudPreferTag).commit();
    }
}
