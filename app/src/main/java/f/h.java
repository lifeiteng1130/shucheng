package f;

import java.io.Serializable;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
@JvmInline
public final class h<T> implements Serializable {

    @NotNull
    public static final a Companion = new a(null);

    @Nullable
    private final Object value;

    /* JADX INFO: compiled from: Result.kt */
    public static final class a {
        public a(f.c0.c.f fVar) {
        }
    }

    /* JADX INFO: compiled from: Result.kt */
    public static final class b implements Serializable {

        @JvmField
        @NotNull
        public final Throwable exception;

        public b(@NotNull Throwable th) {
            f.c0.c.j.e(th, "exception");
            this.exception = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof b) && f.c0.c.j.a(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("Failure(");
            sbR.append(this.exception);
            sbR.append(')');
            return sbR.toString();
        }
    }

    @PublishedApi
    public /* synthetic */ h(Object obj) {
        this.value = obj;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ h m10boximpl(Object obj) {
        return new h(obj);
    }

    @PublishedApi
    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Object m11constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m12equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof h) && f.c0.c.j.a(obj, ((h) obj2).m19unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m13equalsimpl0(Object obj, Object obj2) {
        return f.c0.c.j.a(obj, obj2);
    }

    @Nullable
    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m14exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m15hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m16isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m17isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m18toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m12equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m15hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m18toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m19unboximpl() {
        return this.value;
    }
}
