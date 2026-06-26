package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c.b.a.b;
import c.b.a.i;
import c.b.a.n.q;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {
    public final c.b.a.n.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f1609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<SupportRequestManagerFragment> f1610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public SupportRequestManagerFragment f1611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public i f1612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Fragment f1613f;

    public class a implements q {
        public a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        c.b.a.n.a aVar = new c.b.a.n.a();
        this.f1609b = new a();
        this.f1610c = new HashSet();
        this.a = aVar;
    }

    @Nullable
    public final Fragment N() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f1613f;
    }

    public final void O(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        P();
        SupportRequestManagerFragment supportRequestManagerFragmentE = b.b(context).f201h.e(fragmentManager, null);
        this.f1611d = supportRequestManagerFragmentE;
        if (equals(supportRequestManagerFragmentE)) {
            return;
        }
        this.f1611d.f1610c.add(this);
    }

    public final void P() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f1611d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.f1610c.remove(this);
            this.f1611d = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment parentFragment = this;
        while (parentFragment.getParentFragment() != null) {
            parentFragment = parentFragment.getParentFragment();
        }
        FragmentManager fragmentManager = parentFragment.getFragmentManager();
        if (fragmentManager == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            O(getContext(), fragmentManager);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        P();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1613f = null;
        P();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + N() + "}";
    }
}
