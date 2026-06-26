package io.legado.app.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import c.a.a.a.a;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.ui.widget.prefs.EditTextPreferenceDialog;
import io.legado.app.ui.widget.prefs.ListPreferenceDialog;
import io.legado.app.ui.widget.prefs.MultiSelectListPreferenceDialog;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BasePreferenceFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lio/legado/app/base/BasePreferenceFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Landroidx/preference/Preference;", "preference", "Lf/v;", "onDisplayPreferenceDialog", "(Landroidx/preference/Preference;)V", "", ai.at, "Ljava/lang/String;", "dialogFragmentTag", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BasePreferenceFragment extends PreferenceFragmentCompat {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final String dialogFragmentTag = "androidx.preference.PreferenceFragment.DIALOG";

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    @SuppressLint({"RestrictedApi"})
    public void onDisplayPreferenceDialog(@NotNull Preference preference) {
        boolean zOnPreferenceDisplayDialog;
        DialogFragment multiSelectListPreferenceDialog;
        j.e(preference, "preference");
        if (getCallbackFragment() instanceof PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback) {
            ActivityResultCaller callbackFragment = getCallbackFragment();
            Objects.requireNonNull(callbackFragment, "null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback");
            zOnPreferenceDisplayDialog = ((PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback) callbackFragment).onPreferenceDisplayDialog(this, preference);
        } else {
            zOnPreferenceDisplayDialog = false;
        }
        if (!zOnPreferenceDisplayDialog && (getActivity() instanceof PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback)) {
            KeyEventDispatcher.Component activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback");
            zOnPreferenceDisplayDialog = ((PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback) activity).onPreferenceDisplayDialog(this, preference);
        }
        if (!zOnPreferenceDisplayDialog && getParentFragmentManager().findFragmentByTag(this.dialogFragmentTag) == null) {
            if (preference instanceof EditTextPreference) {
                String key = preference.getKey();
                j.d(key, "preference.getKey()");
                j.e(key, "key");
                multiSelectListPreferenceDialog = new EditTextPreferenceDialog();
                Bundle bundle = new Bundle(1);
                bundle.putString("key", key);
                multiSelectListPreferenceDialog.setArguments(bundle);
            } else if (preference instanceof ListPreference) {
                String key2 = preference.getKey();
                multiSelectListPreferenceDialog = new ListPreferenceDialog();
                Bundle bundle2 = new Bundle(1);
                bundle2.putString("key", key2);
                multiSelectListPreferenceDialog.setArguments(bundle2);
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    StringBuilder sbR = a.r("Cannot display dialog for an unknown Preference type: ");
                    sbR.append((Object) preference.getClass().getSimpleName());
                    sbR.append(". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                    throw new IllegalArgumentException(sbR.toString());
                }
                String key3 = preference.getKey();
                multiSelectListPreferenceDialog = new MultiSelectListPreferenceDialog();
                Bundle bundle3 = new Bundle(1);
                bundle3.putString("key", key3);
                multiSelectListPreferenceDialog.setArguments(bundle3);
            }
            multiSelectListPreferenceDialog.setTargetFragment(this, 0);
            multiSelectListPreferenceDialog.show(getParentFragmentManager(), this.dialogFragmentTag);
        }
    }
}
