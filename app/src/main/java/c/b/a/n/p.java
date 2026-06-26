package c.b.a.n;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import c.b.a.c;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: RequestManagerRetriever.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements Handler.Callback {
    public static final b a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c.b.a.i f606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    public final Map<FragmentManager, o> f607c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f608d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f611g;

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    public class a implements b {
    }

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    public interface b {
    }

    public p(@Nullable b bVar, c.b.a.e eVar) {
        new ArrayMap();
        new ArrayMap();
        new Bundle();
        this.f610f = bVar == null ? a : bVar;
        this.f609e = new Handler(Looper.getMainLooper(), this);
        this.f611g = (c.b.a.m.r.c.r.f538b && c.b.a.m.r.c.r.a) ? eVar.a.containsKey(c.d.class) ? new i() : new j() : new g();
    }

    @Nullable
    public static Activity a(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean f(Context context) {
        Activity activityA = a(context);
        return activityA == null || !activityA.isFinishing();
    }

    @NonNull
    public c.b.a.i b(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (c.b.a.s.i.i() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return c((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (c.b.a.s.i.h()) {
                    return b(activity.getApplicationContext());
                }
                if (activity instanceof FragmentActivity) {
                    return c((FragmentActivity) activity);
                }
                if (activity.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                this.f611g.a(activity);
                FragmentManager fragmentManager = activity.getFragmentManager();
                boolean zF = f(activity);
                o oVarD = d(fragmentManager, null);
                c.b.a.i iVar = oVarD.f603d;
                if (iVar != null) {
                    return iVar;
                }
                c.b.a.b bVarB = c.b.a.b.b(activity);
                b bVar = this.f610f;
                c.b.a.n.a aVar = oVarD.a;
                q qVar = oVarD.f601b;
                Objects.requireNonNull((a) bVar);
                c.b.a.i iVar2 = new c.b.a.i(bVarB, aVar, qVar, activity);
                if (zF) {
                    iVar2.onStart();
                }
                oVarD.f603d = iVar2;
                return iVar2;
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f606b == null) {
            synchronized (this) {
                if (this.f606b == null) {
                    c.b.a.b bVarB2 = c.b.a.b.b(context.getApplicationContext());
                    b bVar2 = this.f610f;
                    c.b.a.n.b bVar3 = new c.b.a.n.b();
                    h hVar = new h();
                    Context applicationContext = context.getApplicationContext();
                    Objects.requireNonNull((a) bVar2);
                    this.f606b = new c.b.a.i(bVarB2, bVar3, hVar, applicationContext);
                }
            }
        }
        return this.f606b;
    }

    @NonNull
    public c.b.a.i c(@NonNull FragmentActivity fragmentActivity) {
        if (c.b.a.s.i.h()) {
            return b(fragmentActivity.getApplicationContext());
        }
        if (fragmentActivity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f611g.a(fragmentActivity);
        androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        boolean zF = f(fragmentActivity);
        SupportRequestManagerFragment supportRequestManagerFragmentE = e(supportFragmentManager, null);
        c.b.a.i iVar = supportRequestManagerFragmentE.f1612e;
        if (iVar != null) {
            return iVar;
        }
        c.b.a.b bVarB = c.b.a.b.b(fragmentActivity);
        b bVar = this.f610f;
        c.b.a.n.a aVar = supportRequestManagerFragmentE.a;
        q qVar = supportRequestManagerFragmentE.f1609b;
        Objects.requireNonNull((a) bVar);
        c.b.a.i iVar2 = new c.b.a.i(bVarB, aVar, qVar, fragmentActivity);
        if (zF) {
            iVar2.onStart();
        }
        supportRequestManagerFragmentE.f1612e = iVar2;
        return iVar2;
    }

    @NonNull
    public final o d(@NonNull FragmentManager fragmentManager, @Nullable Fragment fragment) {
        o oVar = (o) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (oVar == null && (oVar = this.f607c.get(fragmentManager)) == null) {
            oVar = new o();
            oVar.f605f = fragment;
            if (fragment != null && fragment.getActivity() != null) {
                oVar.a(fragment.getActivity());
            }
            this.f607c.put(fragmentManager, oVar);
            fragmentManager.beginTransaction().add(oVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f609e.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return oVar;
    }

    @NonNull
    public final SupportRequestManagerFragment e(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable androidx.fragment.app.Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f608d.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.f1613f = fragment;
            if (fragment != null && fragment.getContext() != null) {
                androidx.fragment.app.Fragment parentFragment = fragment;
                while (parentFragment.getParentFragment() != null) {
                    parentFragment = parentFragment.getParentFragment();
                }
                androidx.fragment.app.FragmentManager fragmentManager2 = parentFragment.getFragmentManager();
                if (fragmentManager2 != null) {
                    supportRequestManagerFragment.O(fragment.getContext(), fragmentManager2);
                }
            }
            this.f608d.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f609e.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            objRemove = this.f607c.remove(obj);
        } else {
            if (i2 != 2) {
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    String str = "Failed to remove expected request manager fragment, manager: " + obj2;
                }
                return z;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            objRemove = this.f608d.remove(obj);
        }
        Object obj4 = obj;
        obj3 = objRemove;
        obj2 = obj4;
        if (z) {
            String str2 = "Failed to remove expected request manager fragment, manager: " + obj2;
        }
        return z;
    }
}
