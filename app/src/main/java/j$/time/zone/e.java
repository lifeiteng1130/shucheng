package j$.time.zone;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    private static final CopyOnWriteArrayList a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap f7913b;

    class a implements PrivilegedAction<Object> {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
            if (property == null) {
                e.d(new b());
                return null;
            }
            try {
                e eVar = (e) e.class.cast(Class.forName(property, true, e.class.getClassLoader()).newInstance());
                e.d(eVar);
                this.a.add(eVar);
                return null;
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }
    }

    private static final class b extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set f7914c;

        b() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : TimeZone.getAvailableIDs()) {
                linkedHashSet.add(str);
            }
            this.f7914c = Collections.unmodifiableSet(linkedHashSet);
        }

        @Override // j$.time.zone.e
        protected c b(String str, boolean z) {
            if (this.f7914c.contains(str)) {
                return new c(TimeZone.getTimeZone(str));
            }
            throw new d("Not a built-in time zone: " + str);
        }

        @Override // j$.time.zone.e
        protected Set c() {
            return this.f7914c;
        }
    }

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        a = copyOnWriteArrayList;
        f7913b = new ConcurrentHashMap(512, 0.75f, 2);
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new a(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    protected e() {
    }

    public static c a(String str, boolean z) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentMap concurrentMap = f7913b;
        e eVar = (e) concurrentMap.get(str);
        if (eVar != null) {
            return eVar.b(str, z);
        }
        if (concurrentMap.isEmpty()) {
            throw new d("No time-zone data files registered");
        }
        throw new d("Unknown time-zone ID: " + str);
    }

    public static void d(e eVar) {
        Objects.requireNonNull(eVar, com.umeng.analytics.pro.c.M);
        for (String str : eVar.c()) {
            Objects.requireNonNull(str, "zoneId");
            if (((e) f7913b.putIfAbsent(str, eVar)) != null) {
                throw new d("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + eVar);
            }
        }
        a.add(eVar);
    }

    protected abstract c b(String str, boolean z);

    protected abstract Set c();
}
