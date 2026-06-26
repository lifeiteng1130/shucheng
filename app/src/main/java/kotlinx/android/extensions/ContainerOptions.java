package kotlinx.android.extensions;

import g.a.a.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContainerOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlinx/android/extensions/ContainerOptions;", "", "Lg/a/a/a;", "cache", "()Lg/a/a/a;", "<init>", "(Lg/a/a/a;)V", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 5, 1})
public @interface ContainerOptions {
    a cache() default a.HASH_MAP;
}
