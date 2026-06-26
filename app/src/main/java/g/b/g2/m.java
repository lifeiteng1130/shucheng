package g.b.g2;

import g.b.o1;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final o1 f6207b;

    static {
        m mVar = new m();
        String strY5 = c.b.a.m.f.y5("kotlinx.coroutines.fast.service.loader");
        a = strY5 != null ? Boolean.parseBoolean(strY5) : true;
        f6207b = mVar.a();
    }

    public final o1 a() {
        Object obj;
        List<? extends MainDispatcherFactory> listJ5 = c.b.a.m.f.J5(c.b.a.m.f.q0(defpackage.a.b()));
        Iterator it = listJ5.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
        if (mainDispatcherFactory != null) {
            try {
                o1 o1VarCreateDispatcher = mainDispatcherFactory.createDispatcher(listJ5);
                if (o1VarCreateDispatcher != null) {
                    return o1VarCreateDispatcher;
                }
            } catch (Throwable th) {
                mainDispatcherFactory.hintOnError();
                throw th;
            }
        }
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
