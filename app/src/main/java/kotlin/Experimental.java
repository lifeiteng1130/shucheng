package kotlin;

import com.umeng.analytics.pro.ai;
import f.w.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Experimental.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin(version = "1.2")
@Deprecated(message = "Please use RequiresOptIn instead.")
@kotlin.annotation.Target(allowedTargets = {b.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(f.w.a.BINARY)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009120\u0001¨\u0006\b"}, d2 = {"Lkotlin/Experimental;", "", "Lkotlin/Experimental$a;", "level", "()Lkotlin/Experimental$a;", "<init>", "(Lkotlin/Experimental$a;)V", ai.at, "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public @interface Experimental {

    /* JADX INFO: compiled from: Experimental.kt */
    public enum a {
        WARNING,
        ERROR
    }

    a level() default a.ERROR;
}
