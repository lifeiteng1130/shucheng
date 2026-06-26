package e.a.a.h;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GsonExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements ParameterizedType {

    @NotNull
    public final Class<?> a;

    public y(@NotNull Class<?> cls) {
        f.c0.c.j.e(cls, "clazz");
        this.a = cls;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type[] getActualTypeArguments() {
        return new Type[]{this.a};
    }

    @Override // java.lang.reflect.ParameterizedType
    @Nullable
    public Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type getRawType() {
        return List.class;
    }
}
