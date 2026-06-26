package c.e.a.b.w;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import c.e.a.b.w.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public final o[] a = new o[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f1249b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f1250c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f1251d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f1252e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f1253f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f1254g = new o();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f1255h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f1256i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f1257j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f1258k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1259l = true;

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    public static class a {
        public static final m a = new m();
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface b {
    }

    public m() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.a[i2] = new o();
            this.f1249b[i2] = new Matrix();
            this.f1250c[i2] = new Matrix();
        }
    }

    public void a(l lVar, float f2, RectF rectF, @NonNull Path path) {
        b(lVar, f2, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void b(l lVar, float f2, RectF rectF, b bVar, @NonNull Path path) {
        path.rewind();
        this.f1252e.rewind();
        this.f1253f.rewind();
        this.f1253f.addRect(rectF, Path.Direction.CW);
        int i2 = 0;
        while (i2 < 4) {
            c cVar = i2 != 1 ? i2 != 2 ? i2 != 3 ? lVar.f1232g : lVar.f1231f : lVar.f1234i : lVar.f1233h;
            d dVar = i2 != 1 ? i2 != 2 ? i2 != 3 ? lVar.f1228c : lVar.f1227b : lVar.f1230e : lVar.f1229d;
            o oVar = this.a[i2];
            Objects.requireNonNull(dVar);
            dVar.a(oVar, 90.0f, f2, cVar.a(rectF));
            int i3 = i2 + 1;
            float f3 = i3 * 90;
            this.f1249b[i2].reset();
            PointF pointF = this.f1251d;
            if (i2 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i2 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i2 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            Matrix matrix = this.f1249b[i2];
            PointF pointF2 = this.f1251d;
            matrix.setTranslate(pointF2.x, pointF2.y);
            this.f1249b[i2].preRotate(f3);
            float[] fArr = this.f1255h;
            o[] oVarArr = this.a;
            fArr[0] = oVarArr[i2].f1263c;
            fArr[1] = oVarArr[i2].f1264d;
            this.f1249b[i2].mapPoints(fArr);
            this.f1250c[i2].reset();
            Matrix matrix2 = this.f1250c[i2];
            float[] fArr2 = this.f1255h;
            matrix2.setTranslate(fArr2[0], fArr2[1]);
            this.f1250c[i2].preRotate(f3);
            i2 = i3;
        }
        int i4 = 0;
        while (i4 < 4) {
            float[] fArr3 = this.f1255h;
            o[] oVarArr2 = this.a;
            fArr3[0] = oVarArr2[i4].a;
            fArr3[1] = oVarArr2[i4].f1262b;
            this.f1249b[i4].mapPoints(fArr3);
            if (i4 == 0) {
                float[] fArr4 = this.f1255h;
                path.moveTo(fArr4[0], fArr4[1]);
            } else {
                float[] fArr5 = this.f1255h;
                path.lineTo(fArr5[0], fArr5[1]);
            }
            this.a[i4].c(this.f1249b[i4], path);
            if (bVar != null) {
                o oVar2 = this.a[i4];
                Matrix matrix3 = this.f1249b[i4];
                MaterialShapeDrawable.a aVar = (MaterialShapeDrawable.a) bVar;
                BitSet bitSet = MaterialShapeDrawable.this.f2336f;
                Objects.requireNonNull(oVar2);
                bitSet.set(i4, false);
                o.f[] fVarArr = MaterialShapeDrawable.this.f2334d;
                oVar2.b(oVar2.f1266f);
                fVarArr[i4] = new n(oVar2, new ArrayList(oVar2.f1268h), new Matrix(matrix3));
            }
            int i5 = i4 + 1;
            int i6 = i5 % 4;
            float[] fArr6 = this.f1255h;
            o[] oVarArr3 = this.a;
            fArr6[0] = oVarArr3[i4].f1263c;
            fArr6[1] = oVarArr3[i4].f1264d;
            this.f1249b[i4].mapPoints(fArr6);
            float[] fArr7 = this.f1256i;
            o[] oVarArr4 = this.a;
            fArr7[0] = oVarArr4[i6].a;
            fArr7[1] = oVarArr4[i6].f1262b;
            this.f1249b[i6].mapPoints(fArr7);
            float f4 = this.f1255h[0];
            float[] fArr8 = this.f1256i;
            float fMax = Math.max(((float) Math.hypot(f4 - fArr8[0], r13[1] - fArr8[1])) - 0.001f, 0.0f);
            float[] fArr9 = this.f1255h;
            o[] oVarArr5 = this.a;
            fArr9[0] = oVarArr5[i4].f1263c;
            fArr9[1] = oVarArr5[i4].f1264d;
            this.f1249b[i4].mapPoints(fArr9);
            float fAbs = (i4 == 1 || i4 == 3) ? Math.abs(rectF.centerX() - this.f1255h[0]) : Math.abs(rectF.centerY() - this.f1255h[1]);
            this.f1254g.e(0.0f, 0.0f);
            f fVar = i4 != 1 ? i4 != 2 ? i4 != 3 ? lVar.f1236k : lVar.f1235j : lVar.m : lVar.f1237l;
            fVar.b(fMax, fAbs, f2, this.f1254g);
            this.f1257j.reset();
            this.f1254g.c(this.f1250c[i4], this.f1257j);
            if (this.f1259l && (fVar.a() || c(this.f1257j, i4) || c(this.f1257j, i6))) {
                Path path2 = this.f1257j;
                path2.op(path2, this.f1253f, Path.Op.DIFFERENCE);
                float[] fArr10 = this.f1255h;
                o oVar3 = this.f1254g;
                fArr10[0] = oVar3.a;
                fArr10[1] = oVar3.f1262b;
                this.f1250c[i4].mapPoints(fArr10);
                Path path3 = this.f1252e;
                float[] fArr11 = this.f1255h;
                path3.moveTo(fArr11[0], fArr11[1]);
                this.f1254g.c(this.f1250c[i4], this.f1252e);
            } else {
                this.f1254g.c(this.f1250c[i4], path);
            }
            if (bVar != null) {
                o oVar4 = this.f1254g;
                Matrix matrix4 = this.f1250c[i4];
                MaterialShapeDrawable.a aVar2 = (MaterialShapeDrawable.a) bVar;
                Objects.requireNonNull(oVar4);
                MaterialShapeDrawable.this.f2336f.set(i4 + 4, false);
                o.f[] fVarArr2 = MaterialShapeDrawable.this.f2335e;
                oVar4.b(oVar4.f1266f);
                fVarArr2[i4] = new n(oVar4, new ArrayList(oVar4.f1268h), new Matrix(matrix4));
            }
            i4 = i5;
        }
        path.close();
        this.f1252e.close();
        if (this.f1252e.isEmpty()) {
            return;
        }
        path.op(this.f1252e, Path.Op.UNION);
    }

    @RequiresApi(19)
    public final boolean c(Path path, int i2) {
        this.f1258k.reset();
        this.a[i2].c(this.f1249b[i2], this.f1258k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f1258k.computeBounds(rectF, true);
        path.op(this.f1258k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
