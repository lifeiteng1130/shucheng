package kotlin.internal;

import f.a0.c;
import f.w.a;
import f.w.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.Repeatable;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@SinceKotlin(version = "1.2")
@kotlin.annotation.Target(allowedTargets = {b.CLASS, b.FUNCTION, b.PROPERTY, b.CONSTRUCTOR, b.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(a.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0081\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u0013\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/internal/RequireKotlin;", "", "Lf/a;", "level", "()Lf/a;", "", "message", "()Ljava/lang/String;", "version", "Lf/a0/c;", "versionKind", "()Lf/a0/c;", "", "errorCode", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lf/a;Lf/a0/c;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@Repeatable
public @interface RequireKotlin {
    int errorCode() default -1;

    f.a level() default f.a.ERROR;

    String message() default "";

    String version();

    c versionKind() default c.LANGUAGE_VERSION;
}
