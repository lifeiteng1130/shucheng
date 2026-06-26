package kotlin;

import f.w.a;
import f.w.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.jvm.JvmName;

/* JADX INFO: compiled from: Metadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0002\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00038\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0013\u0010\u0011\u001a\u00020\u00038\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0013\u0010\u0015\u001a\u00020\u00128\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\n8\u0007@\u0007X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\f¨\u0006\u001c"}, d2 = {"Lkotlin/Metadata;", "", "", "", "d1", "()[Ljava/lang/String;", "data1", "pn", "()Ljava/lang/String;", "packageName", "", "mv", "()[I", "metadataVersion", "d2", "data2", "xs", "extraString", "", "k", "()I", "kind", "xi", "extraInt", "bv", "bytecodeVersion", "<init>", "(I[I[ILkotlin/Array;Lkotlin/Array;Ljava/lang/String;Ljava/lang/String;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {b.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(a.RUNTIME)
public @interface Metadata {
    @JvmName(name = "bv")
    int[] bv() default {1, 0, 3};

    @JvmName(name = "d1")
    String[] d1() default {};

    @JvmName(name = "d2")
    String[] d2() default {};

    @JvmName(name = "k")
    int k() default 1;

    @JvmName(name = "mv")
    int[] mv() default {};

    @JvmName(name = "pn")
    String pn() default "";

    @JvmName(name = "xi")
    int xi() default 0;

    @JvmName(name = "xs")
    String xs() default "";
}
