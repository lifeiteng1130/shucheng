package e.a.a.h;

import android.graphics.Bitmap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: QRCodeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {

    @NotNull
    public static final z a = new z();

    public final c.e.c.p a(c.e.c.j jVar, c.e.c.i iVar) {
        c.e.c.p pVarC;
        try {
            c.e.c.c cVar = new c.e.c.c(new c.e.c.v.i(iVar));
            if (jVar.f1346b == null) {
                jVar.d(null);
            }
            pVarC = jVar.c(cVar);
        } catch (Exception unused) {
            pVarC = null;
        }
        if (pVarC != null) {
            return pVarC;
        }
        try {
            c.e.c.c cVar2 = new c.e.c.c(new c.e.c.v.h(iVar));
            if (jVar.f1346b == null) {
                jVar.d(null);
            }
            return jVar.c(cVar2);
        } catch (Exception unused2) {
            return pVarC;
        }
    }

    public final c.e.c.m b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return new c.e.c.m(width, height, iArr);
    }

    @Nullable
    public final c.e.c.p c(@Nullable c.e.c.i iVar, @Nullable Map<c.e.c.e, ? extends Object> map) {
        c.e.c.j jVar = new c.e.c.j();
        c.e.c.p pVarA = null;
        try {
            try {
                jVar.d(map);
                pVarA = a(jVar, iVar);
                if (pVarA == null) {
                    c.e.c.h hVar = new c.e.c.h(iVar);
                    f.c0.c.j.d(hVar, "source.invert()");
                    pVarA = a(jVar, hVar);
                }
            } catch (Exception e2) {
                String message = e2.getMessage();
                c.g.a.p.a.a();
                String.valueOf(message);
            }
            return pVarA;
        } finally {
            jVar.b();
        }
    }
}
