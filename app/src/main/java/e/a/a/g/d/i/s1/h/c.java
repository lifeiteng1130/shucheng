package e.a.a.g.d.i.s1.h;

import c.b.a.m.f;
import com.tencent.bugly.beta.tinker.TinkerReport;
import e.a.a.f.s.k;
import e.a.a.g.d.i.s1.g.e;
import f.c0.c.j;
import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextPageFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @NotNull
    public final e.a.a.g.d.i.s1.e.a a;

    public c(@NotNull e.a.a.g.d.i.s1.e.a aVar) {
        j.e(aVar, "dataSource");
        j.e(aVar, "dataSource");
        this.a = aVar;
    }

    @NotNull
    public e a() {
        e.a.a.g.d.i.s1.e.a aVar = this.a;
        k kVar = k.a;
        String str = k.p;
        if (str != null) {
            e eVar = new e(0, str, null, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK);
            eVar.a();
            return eVar;
        }
        e.a.a.g.d.i.s1.g.b currentChapter = aVar.getCurrentChapter();
        if (currentChapter == null) {
            e eVar2 = new e(0, null, null, null, 0, 0, 0, 0.0f, 255);
            eVar2.a();
            return eVar2;
        }
        e eVarD = currentChapter.d(aVar.getPageIndex());
        if (eVarD != null) {
            return eVarD;
        }
        e eVar3 = new e(0, null, currentChapter.f5766b, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
        eVar3.a();
        return eVar3;
    }

    @NotNull
    public e b() {
        e.a.a.g.d.i.s1.e.a aVar = this.a;
        k kVar = k.a;
        String str = k.p;
        if (str != null) {
            e eVar = new e(0, str, null, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK);
            eVar.a();
            return eVar;
        }
        e.a.a.g.d.i.s1.g.b currentChapter = aVar.getCurrentChapter();
        e eVar2 = null;
        if (currentChapter != null && aVar.getPageIndex() < currentChapter.b() - 1) {
            e eVarD = currentChapter.d(aVar.getPageIndex() + 1);
            if (eVarD != null) {
                eVarD.e();
                eVar2 = eVarD;
            }
            if (eVar2 != null) {
                return eVar2;
            }
            e eVar3 = new e(0, null, currentChapter.f5766b, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
            eVar3.a();
            return eVar3;
        }
        if (!aVar.c()) {
            return new e(0, "", null, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK);
        }
        e.a.a.g.d.i.s1.g.b nextChapter = aVar.getNextChapter();
        if (nextChapter == null) {
            e eVar4 = new e(0, null, null, null, 0, 0, 0, 0.0f, 255);
            eVar4.a();
            return eVar4;
        }
        e eVarD2 = nextChapter.d(0);
        if (eVarD2 != null) {
            eVarD2.e();
            eVar2 = eVarD2;
        }
        if (eVar2 != null) {
            return eVar2;
        }
        e eVar5 = new e(0, null, nextChapter.f5766b, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
        eVar5.a();
        return eVar5;
    }

    @NotNull
    public e c() {
        e.a.a.g.d.i.s1.g.b currentChapter;
        e.a.a.g.d.i.s1.e.a aVar = this.a;
        k kVar = k.a;
        String str = k.p;
        if (str != null) {
            e eVar = new e(0, str, null, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK);
            eVar.a();
            return eVar;
        }
        e eVar2 = null;
        if (aVar.getPageIndex() > 0 && (currentChapter = aVar.getCurrentChapter()) != null) {
            e eVarD = currentChapter.d(aVar.getPageIndex() - 1);
            if (eVarD != null) {
                eVarD.e();
                eVar2 = eVarD;
            }
            if (eVar2 != null) {
                return eVar2;
            }
            e eVar3 = new e(0, null, currentChapter.f5766b, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
            eVar3.a();
            return eVar3;
        }
        e.a.a.g.d.i.s1.g.b prevChapter = aVar.getPrevChapter();
        if (prevChapter == null) {
            e eVar4 = new e(0, null, null, null, 0, 0, 0, 0.0f, 255);
            eVar4.a();
            return eVar4;
        }
        e eVar5 = (e) f.x.e.s(prevChapter.f5768d);
        if (eVar5 != null) {
            eVar5.e();
            eVar2 = eVar5;
        }
        if (eVar2 != null) {
            return eVar2;
        }
        e eVar6 = new e(0, null, prevChapter.f5766b, null, 0, 0, 0, 0.0f, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION);
        eVar6.a();
        return eVar6;
    }

    public boolean d() {
        Boolean boolValueOf;
        e.a.a.g.d.i.s1.e.a aVar = this.a;
        if (!aVar.c()) {
            e.a.a.g.d.i.s1.g.b currentChapter = aVar.getCurrentChapter();
            if (currentChapter == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(aVar.getPageIndex() >= currentChapter.f5768d.size() - 1);
            }
            if (j.a(boolValueOf, Boolean.TRUE)) {
                return false;
            }
        }
        return true;
    }

    public boolean e() {
        e.a.a.g.d.i.s1.e.a aVar = this.a;
        return aVar.a() || aVar.getPageIndex() > 0;
    }

    public boolean f(boolean z) throws IllegalAccessException, InvocationTargetException {
        Boolean boolValueOf;
        e.a.a.g.d.i.s1.e.a aVar = this.a;
        if (!d()) {
            return false;
        }
        e.a.a.g.d.i.s1.g.b currentChapter = aVar.getCurrentChapter();
        if (currentChapter == null) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(aVar.getPageIndex() >= currentChapter.f5768d.size() - 1);
        }
        if (j.a(boolValueOf, Boolean.TRUE)) {
            k.a.k(z);
        } else {
            k kVar = k.a;
            int pageIndex = aVar.getPageIndex() + 1;
            e.a.a.g.d.i.s1.g.b bVar = k.f5686l;
            if (bVar != null) {
                pageIndex = bVar.c(pageIndex);
            }
            k.f5682h = pageIndex;
            kVar.q();
            kVar.f();
        }
        if (!z) {
            return true;
        }
        f.W5(aVar, 0, false, 1, null);
        return true;
    }

    public boolean g(boolean z) throws IllegalAccessException, InvocationTargetException {
        e.a.a.g.d.i.s1.e.a aVar = this.a;
        if (!e()) {
            return false;
        }
        if (aVar.getPageIndex() <= 0) {
            k.a.m(z, true);
        } else {
            k kVar = k.a;
            int pageIndex = aVar.getPageIndex() - 1;
            e.a.a.g.d.i.s1.g.b bVar = k.f5686l;
            if (bVar != null) {
                pageIndex = bVar.c(pageIndex);
            }
            k.f5682h = pageIndex;
            kVar.q();
            kVar.f();
        }
        if (!z) {
            return true;
        }
        f.W5(aVar, 0, false, 1, null);
        return true;
    }
}
