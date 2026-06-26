package f.z.j.a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.j;
import f.h;
import f.v;
import f.z.j.a.e;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.SinceKotlin;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public abstract class a implements f.z.d<Object>, d, Serializable {

    @Nullable
    private final f.z.d<Object> completion;

    public a(@Nullable f.z.d<Object> dVar) {
        this.completion = dVar;
    }

    @NotNull
    public f.z.d<v> create(@NotNull f.z.d<?> dVar) {
        j.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // f.z.j.a.d
    @Nullable
    public d getCallerFrame() {
        f.z.d<Object> dVar = this.completion;
        if (!(dVar instanceof d)) {
            dVar = null;
        }
        return (d) dVar;
    }

    @Nullable
    public final f.z.d<Object> getCompletion() {
        return this.completion;
    }

    @Override // f.z.d
    @NotNull
    public abstract /* synthetic */ f.z.f getContext();

    @Nullable
    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        j.e(this, "$this$getStackTraceElementImpl");
        DebugMetadata debugMetadata = (DebugMetadata) getClass().getAnnotation(DebugMetadata.class);
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        if (debugMetadata == null) {
            return null;
        }
        int iV = debugMetadata.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField(TTDownloadField.TT_LABEL);
            j.d(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i2 = iIntValue >= 0 ? debugMetadata.l()[iIntValue] : -1;
        j.e(this, "continuation");
        e.a aVar = e.f6166b;
        if (aVar == null) {
            try {
                e.a aVar2 = new e.a(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
                e.f6166b = aVar2;
                aVar = aVar2;
            } catch (Exception unused2) {
                aVar = e.a;
                e.f6166b = aVar;
            }
        }
        if (aVar != e.a && (method = aVar.a) != null && (objInvoke = method.invoke(getClass(), new Object[0])) != null && (method2 = aVar.f6168b) != null && (objInvoke2 = method2.invoke(objInvoke, new Object[0])) != null) {
            Method method3 = aVar.f6169c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
            str = (String) (objInvoke3 instanceof String ? objInvoke3 : null);
        }
        if (str == null) {
            strC = debugMetadata.c();
        } else {
            strC = str + Attributes.InternalPrefix + debugMetadata.c();
        }
        return new StackTraceElement(strC, debugMetadata.m(), debugMetadata.f(), i2);
    }

    @Nullable
    public abstract Object invokeSuspend(@NotNull Object obj);

    public void releaseIntercepted() {
    }

    @Override // f.z.d
    public final void resumeWith(@NotNull Object obj) {
        Object objInvokeSuspend;
        a aVar = this;
        while (true) {
            j.e(aVar, "frame");
            f.z.d<Object> dVar = aVar.completion;
            j.c(dVar);
            try {
                objInvokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                obj = h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            if (objInvokeSuspend == f.z.i.a.COROUTINE_SUSPENDED) {
                return;
            }
            obj = h.m11constructorimpl(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar instanceof a)) {
                dVar.resumeWith(obj);
                return;
            }
            aVar = (a) dVar;
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sbR.append(stackTraceElement);
        return sbR.toString();
    }

    @NotNull
    public f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        j.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
