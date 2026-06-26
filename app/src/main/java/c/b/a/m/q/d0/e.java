package c.b.a.m.q.d0;

import android.util.Log;
import c.b.a.k.a;
import c.b.a.m.q.d0.a;
import c.b.a.m.q.d0.c;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: DiskLruCacheWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f367c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.b.a.k.a f369e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f368d = new c();
    public final k a = new k();

    @Deprecated
    public e(File file, long j2) {
        this.f366b = file;
        this.f367c = j2;
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
    @Override // c.b.a.m.q.d0.a
    public void a(c.b.a.m.j jVar, a.b bVar) {
        c.a aVarPoll;
        boolean z;
        String strA = this.a.a(jVar);
        c cVar = this.f368d;
        synchronized (cVar) {
            aVarPoll = cVar.a.get(strA);
            if (aVarPoll == null) {
                c.b bVar2 = cVar.f363b;
                synchronized (bVar2.a) {
                    aVarPoll = bVar2.a.poll();
                }
                if (aVarPoll == null) {
                    aVarPoll = new c.a();
                }
                cVar.a.put(strA, aVarPoll);
            }
            aVarPoll.f364b++;
        }
        aVarPoll.a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                String str = "Put: Obtained: " + strA + " for for Key: " + jVar;
            }
            try {
                c.b.a.k.a aVarC = c();
                if (aVarC.g(strA) == null) {
                    a.c cVarE = aVarC.e(strA);
                    if (cVarE == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strA);
                    }
                    try {
                        c.b.a.m.q.f fVar = (c.b.a.m.q.f) bVar;
                        if (fVar.a.encode(fVar.f387b, cVarE.b(0), fVar.f388c)) {
                            c.b.a.k.a.a(c.b.a.k.a.this, cVarE, true);
                            cVarE.f258c = true;
                        }
                        if (!z) {
                            try {
                                cVarE.a();
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!cVarE.f258c) {
                            try {
                                cVarE.a();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException unused3) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
        } finally {
            this.f368d.a(strA);
        }
    }

    @Override // c.b.a.m.q.d0.a
    public File b(c.b.a.m.j jVar) {
        String strA = this.a.a(jVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            String str = "Get: Obtained: " + strA + " for for Key: " + jVar;
        }
        try {
            a.e eVarG = c().g(strA);
            if (eVarG != null) {
                return eVarG.a[0];
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final synchronized c.b.a.k.a c() {
        if (this.f369e == null) {
            this.f369e = c.b.a.k.a.i(this.f366b, 1, 1, this.f367c);
        }
        return this.f369e;
    }
}
