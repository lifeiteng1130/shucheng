package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Shader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/graphics/Shader;", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lf/v;", "Lkotlin/ExtensionFunctionType;", "block", "transform", "(Landroid/graphics/Shader;Lf/c0/b/l;)V", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class ShaderKt {
    public static final void transform(@NotNull Shader shader, @NotNull l<? super Matrix, v> lVar) {
        j.f(shader, "$this$transform");
        j.f(lVar, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        lVar.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
