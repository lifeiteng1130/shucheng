package c.e.a.b.w;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    @Deprecated
    public float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f1262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f1263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f1264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f1265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f1266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<e> f1267g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<f> f1268h = new ArrayList();

    /* JADX INFO: compiled from: ShapePath.java */
    public static class a extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f1269b;

        public a(c cVar) {
            this.f1269b = cVar;
        }

        @Override // c.e.a.b.w.o.f
        public void a(Matrix matrix, @NonNull c.e.a.b.v.a aVar, int i2, @NonNull Canvas canvas) {
            c cVar = this.f1269b;
            float f2 = cVar.f1278g;
            float f3 = cVar.f1279h;
            c cVar2 = this.f1269b;
            RectF rectF = new RectF(cVar2.f1274c, cVar2.f1275d, cVar2.f1276e, cVar2.f1277f);
            boolean z = f3 < 0.0f;
            Path path = aVar.f1223k;
            if (z) {
                int[] iArr = c.e.a.b.v.a.f1215c;
                iArr[0] = 0;
                iArr[1] = aVar.f1222j;
                iArr[2] = aVar.f1221i;
                iArr[3] = aVar.f1220h;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f2, f3);
                path.close();
                float f4 = -i2;
                rectF.inset(f4, f4);
                int[] iArr2 = c.e.a.b.v.a.f1215c;
                iArr2[0] = 0;
                iArr2[1] = aVar.f1220h;
                iArr2[2] = aVar.f1221i;
                iArr2[3] = aVar.f1222j;
            }
            float fWidth = rectF.width() / 2.0f;
            if (fWidth <= 0.0f) {
                return;
            }
            float f5 = 1.0f - (i2 / fWidth);
            float[] fArr = c.e.a.b.v.a.f1216d;
            fArr[1] = f5;
            fArr[2] = ((1.0f - f5) / 2.0f) + f5;
            aVar.f1218f.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, c.e.a.b.v.a.f1215c, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            if (!z) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, aVar.f1224l);
            }
            canvas.drawArc(rectF, f2, f3, true, aVar.f1218f);
            canvas.restore();
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class b extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f1270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f1271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f1272d;

        public b(d dVar, float f2, float f3) {
            this.f1270b = dVar;
            this.f1271c = f2;
            this.f1272d = f3;
        }

        @Override // c.e.a.b.w.o.f
        public void a(Matrix matrix, @NonNull c.e.a.b.v.a aVar, int i2, @NonNull Canvas canvas) {
            d dVar = this.f1270b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(dVar.f1281c - this.f1272d, dVar.f1280b - this.f1271c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f1271c, this.f1272d);
            matrix2.preRotate(b());
            Objects.requireNonNull(aVar);
            rectF.bottom += i2;
            rectF.offset(0.0f, -i2);
            int[] iArr = c.e.a.b.v.a.a;
            iArr[0] = aVar.f1222j;
            iArr[1] = aVar.f1221i;
            iArr[2] = aVar.f1220h;
            Paint paint = aVar.f1219g;
            float f2 = rectF.left;
            paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, c.e.a.b.v.a.f1214b, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, aVar.f1219g);
            canvas.restore();
        }

        public float b() {
            d dVar = this.f1270b;
            return (float) Math.toDegrees(Math.atan((dVar.f1281c - this.f1272d) / (dVar.f1280b - this.f1271c)));
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final RectF f1273b = new RectF();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f1274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f1275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f1276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f1277f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f1278g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Deprecated
        public float f1279h;

        public c(float f2, float f3, float f4, float f5) {
            this.f1274c = f2;
            this.f1275d = f3;
            this.f1276e = f4;
            this.f1277f = f5;
        }

        @Override // c.e.a.b.w.o.e
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f1273b;
            rectF.set(this.f1274c, this.f1275d, this.f1276e, this.f1277f);
            path.arcTo(rectF, this.f1278g, this.f1279h, false);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1281c;

        @Override // c.e.a.b.w.o.e
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f1280b, this.f1281c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class e {
        public final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class f {
        public static final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, c.e.a.b.v.a aVar, int i2, Canvas canvas);
    }

    public o() {
        e(0.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f1278g = f6;
        cVar.f1279h = f7;
        this.f1267g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.f1268h.add(aVar);
        this.f1265e = f9;
        double d2 = f8;
        this.f1263c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.f1264d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.f1265e;
        if (f3 == f2) {
            return;
        }
        float f4 = ((f2 - f3) + 360.0f) % 360.0f;
        if (f4 > 180.0f) {
            return;
        }
        float f5 = this.f1263c;
        float f6 = this.f1264d;
        c cVar = new c(f5, f6, f5, f6);
        cVar.f1278g = this.f1265e;
        cVar.f1279h = f4;
        this.f1268h.add(new a(cVar));
        this.f1265e = f2;
    }

    public void c(Matrix matrix, Path path) {
        int size = this.f1267g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1267g.get(i2).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d dVar = new d();
        dVar.f1280b = f2;
        dVar.f1281c = f3;
        this.f1267g.add(dVar);
        b bVar = new b(dVar, this.f1263c, this.f1264d);
        float fB = bVar.b() + 270.0f;
        float fB2 = bVar.b() + 270.0f;
        b(fB);
        this.f1268h.add(bVar);
        this.f1265e = fB2;
        this.f1263c = f2;
        this.f1264d = f3;
    }

    public void e(float f2, float f3) {
        f(f2, f3, 270.0f, 0.0f);
    }

    public void f(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.f1262b = f3;
        this.f1263c = f2;
        this.f1264d = f3;
        this.f1265e = f4;
        this.f1266f = (f4 + f5) % 360.0f;
        this.f1267g.clear();
        this.f1268h.clear();
    }
}
