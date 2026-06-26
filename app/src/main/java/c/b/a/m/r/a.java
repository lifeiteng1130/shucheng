package c.b.a.m.r;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import c.b.a.m.k;
import c.b.a.m.m;
import c.b.a.m.n;
import c.b.a.m.q.w;
import c.b.a.m.r.c.d;
import c.b.a.m.r.c.e;
import c.b.a.m.r.c.l;
import c.b.a.m.r.c.r;
import java.io.IOException;

/* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
public abstract class a<T> implements n<ImageDecoder.Source, T> {
    public final r a = r.a();

    /* JADX INFO: renamed from: c.b.a.m.r.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
    public class C0021a implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c.b.a.m.b f499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ l f500e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ m f501f;

        /* JADX INFO: renamed from: c.b.a.m.r.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
        public class C0022a implements ImageDecoder.OnPartialImageListener {
            public C0022a(C0021a c0021a) {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public C0021a(int i2, int i3, boolean z, c.b.a.m.b bVar, l lVar, m mVar) {
            this.a = i2;
            this.f497b = i3;
            this.f498c = z;
            this.f499d = bVar;
            this.f500e = lVar;
            this.f501f = mVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z = false;
            if (a.this.a.b(this.a, this.f497b, this.f498c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f499d == c.b.a.m.b.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0022a(this));
            Size size = imageInfo.getSize();
            int width = this.a;
            if (width == Integer.MIN_VALUE) {
                width = size.getWidth();
            }
            int height = this.f497b;
            if (height == Integer.MIN_VALUE) {
                height = size.getHeight();
            }
            float fB = this.f500e.b(size.getWidth(), size.getHeight(), width, height);
            int iRound = Math.round(size.getWidth() * fB);
            int iRound2 = Math.round(fB * size.getHeight());
            if (Log.isLoggable("ImageDecoder", 2)) {
                size.getWidth();
                size.getHeight();
            }
            imageDecoder.setTargetSize(iRound, iRound2);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 28) {
                if (i2 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            } else {
                if (this.f501f == m.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            }
        }
    }

    @Override // c.b.a.m.n
    public /* bridge */ /* synthetic */ boolean a(@NonNull ImageDecoder.Source source, @NonNull c.b.a.m.l lVar) {
        return true;
    }

    @Override // c.b.a.m.n
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final w<T> b(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull c.b.a.m.l lVar) throws IOException {
        c.b.a.m.b bVar = (c.b.a.m.b) lVar.b(c.b.a.m.r.c.m.a);
        l lVar2 = (l) lVar.b(l.f522f);
        k<Boolean> kVar = c.b.a.m.r.c.m.f526d;
        C0021a c0021a = new C0021a(i2, i3, lVar.b(kVar) != null && ((Boolean) lVar.b(kVar)).booleanValue(), bVar, lVar2, (m) lVar.b(c.b.a.m.r.c.m.f524b));
        d dVar = (d) this;
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, c0021a);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            bitmapDecodeBitmap.getWidth();
            bitmapDecodeBitmap.getHeight();
        }
        return new e(bitmapDecodeBitmap, dVar.f513b);
    }
}
