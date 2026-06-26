package c.b.a.m.q;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import c.b.a.g;
import c.b.a.m.q.i;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: DecodePath.java */
/* JADX INFO: loaded from: classes.dex */
public class j<DataType, ResourceType, Transcode> {
    public final Class<DataType> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends c.b.a.m.n<DataType, ResourceType>> f416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.m.r.h.e<ResourceType, Transcode> f417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f419e;

    /* JADX INFO: compiled from: DecodePath.java */
    public interface a<ResourceType> {
    }

    public j(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends c.b.a.m.n<DataType, ResourceType>> list, c.b.a.m.r.h.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.f416b = list;
        this.f417c = eVar;
        this.f418d = pool;
        StringBuilder sbR = c.a.a.a.a.r("Failed DecodePath{");
        sbR.append(cls.getSimpleName());
        sbR.append("->");
        sbR.append(cls2.getSimpleName());
        sbR.append("->");
        sbR.append(cls3.getSimpleName());
        sbR.append("}");
        this.f419e = sbR.toString();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public w<Transcode> a(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull c.b.a.m.l lVar, a<ResourceType> aVar) {
        w<ResourceType> wVarA;
        c.b.a.m.p pVar;
        c.b.a.m.c cVarA;
        c.b.a.m.j eVar;
        List<Throwable> listAcquire = this.f418d.acquire();
        Objects.requireNonNull(listAcquire, "Argument must not be null");
        List<Throwable> list = listAcquire;
        try {
            w<ResourceType> wVarB = b(dataRewinder, i2, i3, lVar, list);
            this.f418d.release(list);
            i.b bVar = (i.b) aVar;
            i iVar = i.this;
            c.b.a.m.a aVar2 = bVar.a;
            Objects.requireNonNull(iVar);
            Class<?> cls = wVarB.get().getClass();
            c.b.a.m.o oVarA = null;
            if (aVar2 != c.b.a.m.a.RESOURCE_DISK_CACHE) {
                c.b.a.m.p pVarF = iVar.a.f(cls);
                pVar = pVarF;
                wVarA = pVarF.a(iVar.f406h, wVarB, iVar.f410l, iVar.m);
            } else {
                wVarA = wVarB;
                pVar = null;
            }
            if (!wVarB.equals(wVarA)) {
                wVarB.recycle();
            }
            boolean z = false;
            if (iVar.a.f390c.f216c.f227d.a(wVarA.c()) != null) {
                oVarA = iVar.a.f390c.f216c.f227d.a(wVarA.c());
                if (oVarA == null) {
                    throw new g.d(wVarA.c());
                }
                cVarA = oVarA.a(iVar.o);
            } else {
                cVarA = c.b.a.m.c.NONE;
            }
            c.b.a.m.o oVar = oVarA;
            h<R> hVar = iVar.a;
            c.b.a.m.j jVar = iVar.x;
            List<ModelLoader.LoadData<?>> listC = hVar.c();
            int size = listC.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                }
                if (listC.get(i4).sourceKey.equals(jVar)) {
                    z = true;
                    break;
                }
                i4++;
            }
            Object obj = wVarA;
            if (iVar.n.d(!z, aVar2, cVarA)) {
                if (oVar == null) {
                    throw new g.d(wVarA.get().getClass());
                }
                int iOrdinal = cVarA.ordinal();
                if (iOrdinal == 0) {
                    eVar = new e(iVar.x, iVar.f407i);
                } else {
                    if (iOrdinal != 1) {
                        throw new IllegalArgumentException("Unknown strategy: " + cVarA);
                    }
                    eVar = new y(iVar.a.f390c.f215b, iVar.x, iVar.f407i, iVar.f410l, iVar.m, pVar, cls, iVar.o);
                }
                v<Z> vVarA = v.a(wVarA);
                i.c<?> cVar = iVar.f404f;
                cVar.a = eVar;
                cVar.f412b = oVar;
                cVar.f413c = vVarA;
                obj = vVarA;
            }
            return this.f417c.a(obj, lVar);
        } catch (Throwable th) {
            this.f418d.release(list);
            throw th;
        }
    }

    @NonNull
    public final w<ResourceType> b(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull c.b.a.m.l lVar, List<Throwable> list) throws r {
        int size = this.f416b.size();
        w<ResourceType> wVarB = null;
        for (int i4 = 0; i4 < size; i4++) {
            c.b.a.m.n<DataType, ResourceType> nVar = this.f416b.get(i4);
            try {
                if (nVar.a(dataRewinder.rewindAndGet(), lVar)) {
                    wVarB = nVar.b(dataRewinder.rewindAndGet(), i2, i3, lVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    String str = "Failed to decode data for " + nVar;
                }
                list.add(e2);
            }
            if (wVarB != null) {
                break;
            }
        }
        if (wVarB != null) {
            return wVarB;
        }
        throw new r(this.f419e, new ArrayList(list));
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("DecodePath{ dataClass=");
        sbR.append(this.a);
        sbR.append(", decoders=");
        sbR.append(this.f416b);
        sbR.append(", transcoder=");
        sbR.append(this.f417c);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
