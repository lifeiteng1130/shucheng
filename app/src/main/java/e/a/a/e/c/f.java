package e.a.a.e.c;

import android.content.Context;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FragmentSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements p {

    @NotNull
    public final WeakReference<Fragment> a;

    public f(@NotNull Fragment fragment) {
        f.c0.c.j.e(fragment, "fragment");
        this.a = new WeakReference<>(fragment);
    }

    @Override // e.a.a.e.c.p
    @Nullable
    public Context getContext() {
        Fragment fragment = this.a.get();
        if (fragment == null) {
            return null;
        }
        return fragment.requireContext();
    }
}
