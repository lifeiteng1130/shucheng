package kotlin;

import f.w.a;
import f.w.b;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Experimental;
import kotlin.RequiresOptIn;
import kotlin.annotation.MustBeDocumented;

/* JADX INFO: compiled from: ExperimentalStdlibApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@SinceKotlin(version = "1.3")
@RequiresOptIn(level = RequiresOptIn.a.ERROR)
@kotlin.annotation.Target(allowedTargets = {b.CLASS, b.ANNOTATION_CLASS, b.PROPERTY, b.FIELD, b.LOCAL_VARIABLE, b.VALUE_PARAMETER, b.CONSTRUCTOR, b.FUNCTION, b.PROPERTY_GETTER, b.PROPERTY_SETTER, b.TYPEALIAS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(a.BINARY)
@MustBeDocumented
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/ExperimentalStdlibApi;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@Experimental(level = Experimental.a.ERROR)
@Documented
public @interface ExperimentalStdlibApi {
}
