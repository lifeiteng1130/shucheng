package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ImageReader.java */
/* JADX INFO: loaded from: classes.dex */
public interface s {

    /* JADX INFO: compiled from: ImageReader.java */
    public static final class a implements s {
        public final InputStreamRewinder a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.b.a.m.q.c0.b f548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<ImageHeaderParser> f549c;

        public a(InputStream inputStream, List<ImageHeaderParser> list, c.b.a.m.q.c0.b bVar) {
            Objects.requireNonNull(bVar, "Argument must not be null");
            this.f548b = bVar;
            Objects.requireNonNull(list, "Argument must not be null");
            this.f549c = list;
            this.a = new InputStreamRewinder(inputStream, bVar);
        }

        @Override // c.b.a.m.r.c.s
        public int a() {
            return c.b.a.m.f.F2(this.f549c, this.a.rewindAndGet(), this.f548b);
        }

        @Override // c.b.a.m.r.c.s
        @Nullable
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.a.rewindAndGet(), null, options);
        }

        @Override // c.b.a.m.r.c.s
        public void c() {
            this.a.fixMarkLimits();
        }

        @Override // c.b.a.m.r.c.s
        public ImageHeaderParser.ImageType d() {
            return c.b.a.m.f.b3(this.f549c, this.a.rewindAndGet(), this.f548b);
        }
    }

    /* JADX INFO: compiled from: ImageReader.java */
    @RequiresApi(21)
    public static final class b implements s {
        public final c.b.a.m.q.c0.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ImageHeaderParser> f550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ParcelFileDescriptorRewinder f551c;

        public b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, c.b.a.m.q.c0.b bVar) {
            Objects.requireNonNull(bVar, "Argument must not be null");
            this.a = bVar;
            Objects.requireNonNull(list, "Argument must not be null");
            this.f550b = list;
            this.f551c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // c.b.a.m.r.c.s
        public int a() {
            return c.b.a.m.f.G2(this.f550b, new c.b.a.m.i(this.f551c, this.a));
        }

        @Override // c.b.a.m.r.c.s
        @Nullable
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.f551c.rewindAndGet().getFileDescriptor(), null, options);
        }

        @Override // c.b.a.m.r.c.s
        public void c() {
        }

        @Override // c.b.a.m.r.c.s
        public ImageHeaderParser.ImageType d() {
            return c.b.a.m.f.c3(this.f550b, new c.b.a.m.h(this.f551c, this.a));
        }
    }

    int a();

    @Nullable
    Bitmap b(BitmapFactory.Options options);

    void c();

    ImageHeaderParser.ImageType d();
}
