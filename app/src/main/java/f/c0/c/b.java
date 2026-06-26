package f.c0.c;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.SinceKotlin;

/* JADX INFO: compiled from: CallableReference.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements f.f0.b, Serializable {

    @SinceKotlin(version = "1.1")
    public static final Object NO_RECEIVER = a.a;

    @SinceKotlin(version = "1.4")
    private final boolean isTopLevel;

    @SinceKotlin(version = "1.4")
    private final String name;

    @SinceKotlin(version = "1.4")
    private final Class owner;

    @SinceKotlin(version = "1.1")
    public final Object receiver;
    private transient f.f0.b reflected;

    @SinceKotlin(version = "1.4")
    private final String signature;

    /* JADX INFO: compiled from: CallableReference.java */
    @SinceKotlin(version = "1.2")
    public static class a implements Serializable {
        public static final a a = new a();

        private Object readResolve() {
            return a;
        }
    }

    public b() {
        this(NO_RECEIVER);
    }

    @Override // f.f0.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // f.f0.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @SinceKotlin(version = "1.1")
    public f.f0.b compute() {
        f.f0.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        f.f0.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract f.f0.b computeReflected();

    @Override // f.f0.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @SinceKotlin(version = "1.1")
    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public f.f0.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return v.a(cls);
        }
        Objects.requireNonNull(v.a);
        return new o(cls, "");
    }

    @Override // f.f0.b
    public List<?> getParameters() {
        return getReflected().getParameters();
    }

    @SinceKotlin(version = "1.1")
    public f.f0.b getReflected() {
        f.f0.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new f.c0.a();
    }

    @Override // f.f0.b
    public f.f0.k getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // f.f0.b
    @SinceKotlin(version = "1.1")
    public List<?> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // f.f0.b
    @SinceKotlin(version = "1.1")
    public f.f0.l getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // f.f0.b
    @SinceKotlin(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // f.f0.b
    @SinceKotlin(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // f.f0.b
    @SinceKotlin(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // f.f0.b
    @SinceKotlin(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @SinceKotlin(version = "1.1")
    public b(Object obj) {
        this(obj, null, null, null, false);
    }

    @SinceKotlin(version = "1.4")
    public b(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}
