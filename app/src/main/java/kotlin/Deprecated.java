package kotlin;

import f.a;
import f.w.b;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.MustBeDocumented;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlin/Deprecated;", "", "Lkotlin/ReplaceWith;", "replaceWith", "()Lkotlin/ReplaceWith;", "Lf/a;", "level", "()Lf/a;", "", "message", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lkotlin/ReplaceWith;Lf/a;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {b.CLASS, b.FUNCTION, b.PROPERTY, b.ANNOTATION_CLASS, b.CONSTRUCTOR, b.PROPERTY_SETTER, b.PROPERTY_GETTER, b.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Deprecated {
    a level() default a.WARNING;

    String message();

    ReplaceWith replaceWith() default @ReplaceWith(expression = "", imports = {});
}
