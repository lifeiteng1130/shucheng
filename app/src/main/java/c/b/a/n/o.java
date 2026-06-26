package c.b.a.n;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: RequestManagerFragment.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class o extends Fragment {
    public final c.b.a.n.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<o> f602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public c.b.a.i f603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public o f604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Fragment f605f;

    /* JADX INFO: compiled from: RequestManagerFragment.java */
    public class a implements q {
        public a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        c.b.a.n.a aVar = new c.b.a.n.a();
        this.f601b = new a();
        this.f602c = new HashSet();
        this.a = aVar;
    }

    public final void a(@NonNull Activity activity) {
        b();
        p pVar = c.b.a.b.b(activity).f201h;
        Objects.requireNonNull(pVar);
        o oVarD = pVar.d(activity.getFragmentManager(), null);
        this.f604e = oVarD;
        if (equals(oVarD)) {
            return;
        }
        this.f604e.f602c.add(this);
    }

    public final void b() {
        o oVar = this.f604e;
        if (oVar != null) {
            oVar.f602c.remove(this);
            this.f604e = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        b();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        b();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f605f;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
