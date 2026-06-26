package kotlinx.coroutines;

import f.w.a;
import f.w.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.RequiresOptIn;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/InternalCoroutinesApi;", "", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
@RequiresOptIn(level = RequiresOptIn.a.ERROR, message = "This is an internal kotlinx.coroutines API that should not be used from outside of kotlinx.coroutines. No compatibility guarantees are provided.It is recommended to report your use-case of internal API to kotlinx.coroutines issue tracker, so stable API could be provided instead")
@kotlin.annotation.Target(allowedTargets = {b.CLASS, b.FUNCTION, b.TYPEALIAS, b.PROPERTY})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(a.BINARY)
public @interface InternalCoroutinesApi {
}
