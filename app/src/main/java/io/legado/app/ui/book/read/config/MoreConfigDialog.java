package io.legado.app.ui.book.read.config;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.i.r1.i3;
import e.a.a.h.m;
import f.c0.c.j;
import io.legado.app.base.BasePreferenceFragment;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.read.page.ReadView;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MoreConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lio/legado/app/ui/book/read/config/MoreConfigDialog;", "Landroidx/fragment/app/DialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "", ai.at, "Ljava/lang/String;", "readPreferTag", "<init>", "ReadPreferenceFragment", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class MoreConfigDialog extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final String readPreferTag = "readPreferenceFragment";

    /* JADX INFO: compiled from: MoreConfigDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u000fJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lio/legado/app/ui/book/read/config/MoreConfigDialog$ReadPreferenceFragment;", "Lio/legado/app/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "Lf/v;", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "Landroid/content/SharedPreferences;", "sharedPreferences", "key", "onSharedPreferenceChanged", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "Landroidx/preference/Preference;", "preference", "", "onPreferenceTreeClick", "(Landroidx/preference/Preference;)Z", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ReadPreferenceFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override // androidx.preference.PreferenceFragmentCompat
        @SuppressLint({"RestrictedApi"})
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            addPreferencesFromResource(R.xml.pref_config_read);
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
            super.onPause();
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(@Nullable Preference preference) {
            String key = preference.getKey();
            if (key != null) {
                int iHashCode = key.hashCode();
                if (iHashCode != -1164728855) {
                    if (iHashCode != 213844127) {
                        if (iHashCode == 240878282 && key.equals("fullScreenGesturesSupport")) {
                            FragmentActivity activity = getActivity();
                            ReadBookActivity readBookActivity = activity instanceof ReadBookActivity ? (ReadBookActivity) activity : null;
                            ReadView readView = readBookActivity != null ? (ReadView) readBookActivity.findViewById(R.id.read_view) : null;
                            Objects.requireNonNull(readView, "null cannot be cast to non-null type io.legado.app.ui.book.read.page.ReadView");
                            readView.g();
                        }
                    } else if (key.equals("customPageKey")) {
                        Context contextRequireContext = requireContext();
                        j.d(contextRequireContext, "requireContext()");
                        new i3(contextRequireContext).show();
                    }
                } else if (key.equals("clickRegionalConfig")) {
                    FragmentActivity activity2 = getActivity();
                    ReadBookActivity readBookActivity2 = activity2 instanceof ReadBookActivity ? (ReadBookActivity) activity2 : null;
                    if (readBookActivity2 != null) {
                        ClickActionConfigDialog clickActionConfigDialog = new ClickActionConfigDialog();
                        FragmentManager supportFragmentManager = readBookActivity2.getSupportFragmentManager();
                        j.d(supportFragmentManager, "supportFragmentManager");
                        clickActionConfigDialog.show(supportFragmentManager, "clickActionConfig");
                    }
                }
            }
            return super.onPreferenceTreeClick(preference);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
            FragmentActivity activity;
            if (key != null) {
                switch (key.hashCode()) {
                    case -1821121633:
                        if (key.equals("hideStatusBar")) {
                            ReadBookConfig.INSTANCE.setHideStatusBar(m.c(this, "hideStatusBar", false, 2));
                            LiveEventBus.get("upConfig").post(Boolean.TRUE);
                            return;
                        }
                        return;
                    case -1663029832:
                        if (!key.equals("textBottomJustify")) {
                            return;
                        }
                        break;
                    case -1655959479:
                        if (key.equals("selectText")) {
                            LiveEventBus.get(key).post(Boolean.valueOf(m.c(this, key, false, 2)));
                            return;
                        }
                        return;
                    case -1619312835:
                        if (key.equals("hideNavigationBar")) {
                            ReadBookConfig.INSTANCE.setHideNavigationBar(m.c(this, "hideNavigationBar", false, 2));
                            LiveEventBus.get("upConfig").post(Boolean.TRUE);
                            return;
                        }
                        return;
                    case -764080481:
                        if (!key.equals("useZhLayout")) {
                            return;
                        }
                        break;
                    case -531008781:
                        if (key.equals("showBrightnessView")) {
                            LiveEventBus.get("showBrightnessView").post("");
                            return;
                        }
                        return;
                    case -225639020:
                        if (!key.equals("textFullJustify")) {
                            return;
                        }
                        break;
                    case 227582404:
                        if (key.equals("screenOrientation")) {
                            FragmentActivity activity2 = getActivity();
                            ReadBookActivity readBookActivity = activity2 instanceof ReadBookActivity ? (ReadBookActivity) activity2 : null;
                            if (readBookActivity == null) {
                                return;
                            }
                            readBookActivity.V0();
                            return;
                        }
                        return;
                    case 255605199:
                        if (key.equals("readBodyToLh") && (activity = getActivity()) != null) {
                            activity.recreate();
                            return;
                        }
                        return;
                    case 1652706268:
                        if (key.equals("keep_light")) {
                            LiveEventBus.get(key).post(Boolean.TRUE);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                LiveEventBus.get("upConfig").post(Boolean.TRUE);
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
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ((ReadBookActivity) activity).bottomDialog++;
        LinearLayout linearLayout = new LinearLayout(getContext());
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        linearLayout.setBackgroundColor(f.T1(contextRequireContext));
        linearLayout.setId(R.id.tag1);
        if (container != null) {
            container.addView(linearLayout);
        }
        return linearLayout;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        j.e(dialog, "dialog");
        super.onDismiss(dialog);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ReadBookActivity readBookActivity = (ReadBookActivity) activity;
        readBookActivity.bottomDialog--;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(2);
        window.setBackgroundDrawableResource(R.color.background);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setLayout(-1, f.m2(360));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(this.readPreferTag);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = new ReadPreferenceFragment();
        }
        getChildFragmentManager().beginTransaction().replace(view.getId(), fragmentFindFragmentByTag, this.readPreferTag).commit();
    }
}
