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
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: PurelyImplements.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@kotlin.annotation.Target(allowedTargets = {b.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(a.RUNTIME)
@MustBeDocumented
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/PurelyImplements;", "", "", ES6Iterator.VALUE_PROPERTY, "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@Documented
public @interface PurelyImplements {
    String value();
}
