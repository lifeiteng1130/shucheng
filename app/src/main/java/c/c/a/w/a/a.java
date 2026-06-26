package c.c.a.w.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import c.c.a.i;
import c.c.a.m;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Map;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a extends i.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f796b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<ComponentName, IBinder> f798d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<ComponentName, f> f799e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e<Intent> f800f = new e<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<ComponentName, c.c.a.w.b> f801g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet<ComponentName> f802h = new HashSet<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashSet<ComponentName> f803i = new HashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f797c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c.c.a.w.a.a$a, reason: collision with other inner class name */
    public class RunnableC0037a implements Runnable {
        public final /* synthetic */ Intent a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f804b;

        public RunnableC0037a(Intent intent, String str) {
            this.a = intent;
            this.f804b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.p(this.a, this.f804b);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Intent a;

        public b(a aVar, Intent intent) {
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.m().f(this.a.getComponent());
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Intent a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f807c;

        public c(Intent intent, m mVar, int i2, String str) {
            this.a = intent;
            this.f806b = mVar;
            this.f807c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.g(this.a, this.f806b, this.f807c);
            } catch (RemoteException e2) {
                ZeusLogger.e(ZeusLogger.TAG_SERVICE, "bindService failed", e2);
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ m a;

        public d(m mVar) {
            this.a = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.n(this.a);
        }
    }

    public class e<T> extends HashMap<m, T> implements Map {
        public e() {
        }

        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, j$.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            Iterator<m> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (it.next().a() == ((m) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return Map.CC.$default$getOrDefault(this, obj, obj2);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return Map.CC.$default$putIfAbsent(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, j$.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            m next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<m> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (next.a() == ((m) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(next);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean remove(Object obj, Object obj2) {
            return Map.CC.$default$remove(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object replace(Object obj, Object obj2) {
            return Map.CC.$default$replace(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
            return Map.CC.$default$replace(this, obj, obj2, obj3);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }
    }

    public class f extends HashSet<m> implements Set {
        public f() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set, j$.util.Collection
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            Iterator<m> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (it.next().a() == ((m) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Q1.v(j$.time.a.A(this), true);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set, j$.util.Set, j$.util.Collection
        public final boolean remove(@Nullable Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            Object obj2 = null;
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m mVar = (m) it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (mVar.a() == ((m) obj).a()) {
                    obj2 = mVar;
                    break;
                }
            }
            return super.remove(obj2);
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.HashSet, java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return Set.CC.$default$spliterator(this);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Q1.v(j$.time.a.A(this), false);
        }
    }

    public static a m() {
        if (f796b == null) {
            synchronized (a.class) {
                if (f796b == null) {
                    f796b = new a();
                }
            }
        }
        return f796b;
    }

    public static c.c.a.w.b r(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
        } catch (Exception e2) {
            e = e2;
            zLoadPlugin = false;
        }
        try {
            c.c.a.w.b bVar = (c.c.a.w.b) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
            bVar.attach(plugin);
            bVar.onCreate();
            return bVar;
        } catch (Exception e3) {
            e = e3;
            ZeusLogger.e(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(zLoadPlugin)), e);
            throw new RuntimeException(e);
        }
    }

    @Override // c.c.a.i
    public final boolean a(Intent intent, m mVar, int i2, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g(intent, mVar, str);
            return true;
        }
        this.f797c.post(new c(intent, mVar, i2, str));
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // c.c.a.i
    public final ComponentName b(Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return p(intent, str);
        }
        this.f797c.post(new RunnableC0037a(intent, str));
        return intent.getComponent();
    }

    @Override // c.c.a.i
    public final boolean c(Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m().f(intent.getComponent());
            return true;
        }
        this.f797c.post(new b(this, intent));
        return true;
    }

    @Override // c.c.a.i
    public final void d(m mVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            n(mVar);
        } else {
            this.f797c.post(new d(mVar));
        }
    }

    public final synchronized boolean f(ComponentName componentName) {
        if (!this.f801g.containsKey(componentName)) {
            return false;
        }
        this.f803i.add(componentName);
        return o(componentName);
    }

    public final synchronized boolean g(Intent intent, m mVar, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f801g.containsKey(component)) {
            this.f801g.put(component, r(intent, str));
        }
        c.c.a.w.b bVar = this.f801g.get(component);
        if (!this.f798d.containsKey(component)) {
            this.f798d.put(component, bVar.onBind(intent));
        }
        IBinder iBinder = this.f798d.get(component);
        if (iBinder != null) {
            if (!this.f799e.containsKey(component)) {
                f fVar = new f();
                fVar.add(mVar);
                this.f799e.put(component, fVar);
                this.f800f.put(mVar, intent);
                mVar.e(component, iBinder);
            } else if (!this.f799e.get(component).contains(mVar)) {
                this.f799e.get(component).add(mVar);
                this.f800f.put(mVar, intent);
                mVar.e(component, iBinder);
            }
        }
        return true;
    }

    public final synchronized void n(m mVar) {
        for (ComponentName componentName : this.f799e.keySet()) {
            f fVar = this.f799e.get(componentName);
            if (fVar.contains(mVar)) {
                fVar.remove(mVar);
                Intent intentRemove = this.f800f.remove(mVar);
                if (fVar.size() == 0) {
                    this.f799e.remove(componentName);
                    c.c.a.w.b bVar = this.f801g.get(componentName);
                    if (bVar != null) {
                        bVar.onUnbind(intentRemove);
                    }
                }
                o(componentName);
                return;
            }
        }
    }

    public final boolean o(ComponentName componentName) {
        if (!this.f802h.contains(componentName)) {
            if (this.f799e.get(componentName) != null) {
                return false;
            }
            q(componentName);
            return true;
        }
        if (!this.f803i.contains(componentName) || this.f799e.containsKey(componentName)) {
            return false;
        }
        q(componentName);
        return true;
    }

    public final synchronized ComponentName p(Intent intent, String str) {
        ComponentName component;
        component = intent.getComponent();
        if (!this.f801g.containsKey(component)) {
            this.f801g.put(component, r(intent, str));
            this.f802h.add(component);
        }
        c.c.a.w.b bVar = this.f801g.get(component);
        if (bVar != null) {
            bVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    public final void q(ComponentName componentName) {
        c.c.a.w.b bVarRemove = this.f801g.remove(componentName);
        this.f803i.remove(componentName);
        this.f798d.remove(componentName);
        this.f802h.remove(componentName);
        if (bVarRemove != null) {
            bVarRemove.onDestroy();
        }
    }
}
