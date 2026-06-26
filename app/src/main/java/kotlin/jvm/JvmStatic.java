package kotlin.jvm;

import f.w.a;
import f.w.b;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;

/* JADX INFO: compiled from: JvmPlatformAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {b.FUNCTION, b.PROPERTY, b.PROPERTY_GETTER, b.PROPERTY_SETTER})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(a.RUNTIME)
@MustBeDocumented
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/jvm/JvmStatic;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@Documented
public @interface JvmStatic {
}
