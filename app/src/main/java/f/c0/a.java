package f.c0;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KotlinReflectionNotSupportedError.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends Error {
    public a() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public a(@Nullable String str) {
        super(str);
    }

    public a(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public a(@Nullable Throwable th) {
        super(th);
    }
}
