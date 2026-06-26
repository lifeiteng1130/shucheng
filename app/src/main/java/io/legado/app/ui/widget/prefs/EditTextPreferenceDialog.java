package io.legado.app.ui.widget.prefs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.preference.EditTextPreferenceDialogFragmentCompat;
import f.c0.c.j;
import io.legado.app.lib.theme.ATH;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditTextPreferenceDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/legado/app/ui/widget/prefs/EditTextPreferenceDialog;", "Landroidx/preference/EditTextPreferenceDialogFragmentCompat;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class EditTextPreferenceDialog extends EditTextPreferenceDialogFragmentCompat {
    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        j.d(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(ATH.a.c());
        }
        return dialogOnCreateDialog;
    }
}
