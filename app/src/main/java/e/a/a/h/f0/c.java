package e.a.a.h.f0;

import androidx.fragment.app.Fragment;
import androidx.view.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import f.c0.b.l;
import f.c0.c.j;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FragmentViewBindings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c<F extends Fragment, T extends ViewBinding> extends ViewBindingProperty<F, T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull l<? super F, ? extends T> lVar) {
        super(lVar);
        j.e(lVar, "viewBinder");
    }

    @Override // io.legado.app.utils.viewbindingdelegate.ViewBindingProperty
    public LifecycleOwner a(Object obj) {
        Fragment fragment = (Fragment) obj;
        j.e(fragment, "thisRef");
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        j.d(viewLifecycleOwner, "thisRef.viewLifecycleOwner");
        return viewLifecycleOwner;
    }
}
