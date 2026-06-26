package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import f.c0.c.j;
import kotlin.Metadata;

/* JADX INFO: compiled from: FragmentTransaction.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aB\u0010\t\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\t\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0004\b\t\u0010\u000b\u001aB\u0010\f\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Landroidx/fragment/app/Fragment;", "F", "Landroidx/fragment/app/FragmentTransaction;", "", "containerViewId", "", "tag", "Landroid/os/Bundle;", "args", "add", "(Landroidx/fragment/app/FragmentTransaction;ILjava/lang/String;Landroid/os/Bundle;)Landroidx/fragment/app/FragmentTransaction;", "(Landroidx/fragment/app/FragmentTransaction;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/fragment/app/FragmentTransaction;", "replace", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, @IdRes int i2, String str, Bundle bundle) {
        j.e(fragmentTransaction, "$this$add");
        j.i();
        throw null;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, int i2, String str, Bundle bundle, int i3, Object obj) {
        int i4 = i3 & 2;
        int i5 = i3 & 4;
        j.e(fragmentTransaction, "$this$add");
        j.i();
        throw null;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction fragmentTransaction, @IdRes int i2, String str, Bundle bundle) {
        j.e(fragmentTransaction, "$this$replace");
        j.i();
        throw null;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int i2, String str, Bundle bundle, int i3, Object obj) {
        int i4 = i3 & 2;
        int i5 = i3 & 4;
        j.e(fragmentTransaction, "$this$replace");
        j.i();
        throw null;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, String str, Bundle bundle) {
        j.e(fragmentTransaction, "$this$add");
        j.e(str, "tag");
        j.i();
        throw null;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, String str, Bundle bundle, int i2, Object obj) {
        int i3 = i2 & 2;
        j.e(fragmentTransaction, "$this$add");
        j.e(str, "tag");
        j.i();
        throw null;
    }
}
