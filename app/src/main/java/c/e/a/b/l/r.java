package c.e.a.b.l;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: PickerFragment.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class r<S> extends Fragment {
    public final LinkedHashSet<q<S>> a = new LinkedHashSet<>();

    public boolean N(q<S> qVar) {
        return this.a.add(qVar);
    }
}
