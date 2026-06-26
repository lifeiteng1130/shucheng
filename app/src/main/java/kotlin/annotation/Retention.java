package kotlin.annotation;

import f.w.a;
import f.w.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/annotation/Retention;", "", "Lf/w/a;", ES6Iterator.VALUE_PROPERTY, "()Lf/w/a;", "<init>", "(Lf/w/a;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@Target(allowedTargets = {b.ANNOTATION_CLASS})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface Retention {
    a value() default a.RUNTIME;
}
