package kotlin.coroutines.jvm.internal;

import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import f.w.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0081\u0002\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u000b\u001a\u00020\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\u00068\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0013\u0010\u0015\u001a\u00020\u00128\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u00020\u00068\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000e¨\u0006\u001c"}, d2 = {"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "", ai.aA, "()[I", "indexToLabel", "", "m", "()Ljava/lang/String;", "methodName", Constants.LANDSCAPE, "lineNumbers", "", ai.az, "()[Ljava/lang/String;", "spilled", "f", "sourceFile", "", ai.aC, "()I", "version", ai.aD, "className", "n", "localNames", "<init>", "(ILjava/lang/String;[ILkotlin/Array;Lkotlin/Array;[ILjava/lang/String;Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {b.CLASS})
@Retention(RetentionPolicy.RUNTIME)
public @interface DebugMetadata {
    @JvmName(name = ai.aD)
    String c() default "";

    @JvmName(name = "f")
    String f() default "";

    @JvmName(name = ai.aA)
    int[] i() default {};

    @JvmName(name = Constants.LANDSCAPE)
    int[] l() default {};

    @JvmName(name = "m")
    String m() default "";

    @JvmName(name = "n")
    String[] n() default {};

    @JvmName(name = ai.az)
    String[] s() default {};

    @JvmName(name = ai.aC)
    int v() default 1;
}
