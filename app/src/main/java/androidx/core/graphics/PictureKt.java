package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import com.umeng.analytics.pro.ai;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Picture.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/graphics/Picture;", "", "width", "height", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lf/v;", "Lkotlin/ExtensionFunctionType;", "block", "record", "(Landroid/graphics/Picture;IILf/c0/b/l;)Landroid/graphics/Picture;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture picture, int i2, int i3, @NotNull l<? super Canvas, v> lVar) {
        j.f(picture, "$this$record");
        j.f(lVar, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i2, i3);
        try {
            j.b(canvasBeginRecording, ai.aD);
            lVar.invoke(canvasBeginRecording);
            return picture;
        } finally {
            picture.endRecording();
        }
    }
}
