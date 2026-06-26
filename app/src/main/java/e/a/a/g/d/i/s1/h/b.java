package e.a.a.g.d.i.s1.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import c.b.a.m.f;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.model.localBook.EpubFile;
import io.legado.app.utils.FileUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImageProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    @NotNull
    public static final b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ConcurrentHashMap<Integer, ConcurrentHashMap<String, Bitmap>> f5799b = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: ImageProvider.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.page.provider.ImageProvider$getImage$3", f = "ImageProvider.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ String $src;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Book book, String str, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$book = book;
            this.$src = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$book, this.$src, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                e.a.a.d.g gVar = e.a.a.d.g.a;
                Book book = this.$book;
                String str = this.$src;
                this.label = 1;
                if (gVar.m(book, str, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return v.a;
        }
    }

    @Nullable
    public final Bitmap a(@NotNull Book book, int i2, @NotNull String str, boolean z) {
        Bitmap bitmap;
        j.e(book, "book");
        j.e(str, "src");
        synchronized (this) {
            j.e(str, "src");
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) f5799b.get(Integer.valueOf(i2));
            bitmap = concurrentHashMap == null ? null : (Bitmap) concurrentHashMap.get(str);
        }
        if (bitmap != null) {
            return bitmap;
        }
        File fileH = e.a.a.d.g.a.h(book, str);
        if (!fileH.exists()) {
            if (book.isEpub()) {
                InputStream image = EpubFile.INSTANCE.getImage(book, str);
                if (image != null) {
                    try {
                        FileUtils fileUtils = FileUtils.a;
                        String absolutePath = fileH.getAbsolutePath();
                        j.d(absolutePath, "vFile.absolutePath");
                        FileOutputStream fileOutputStream = new FileOutputStream(fileUtils.b(absolutePath));
                        try {
                            f.h1(image, fileOutputStream, 0, 2);
                            f.P0(fileOutputStream, null);
                            f.P0(image, null);
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            f.P0(image, th);
                            throw th2;
                        }
                    }
                }
            } else if (!z) {
                f.T4(null, new a(book, str, null), 1, null);
            }
        }
        try {
            String absolutePath2 = fileH.getAbsolutePath();
            j.d(absolutePath2, "vFile.absolutePath");
            e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
            int i3 = e.a.a.g.d.i.s1.h.a.f5792f;
            int i4 = e.a.a.g.d.i.s1.h.a.f5793g;
            j.e(absolutePath2, "path");
            BitmapFactory.Options options = new BitmapFactory.Options();
            FileInputStream fileInputStream = new FileInputStream(absolutePath2);
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options);
            int iCeil = (int) Math.ceil(options.outWidth / i3);
            int iCeil2 = (int) Math.ceil(options.outHeight / i4);
            if (iCeil > 1 && iCeil2 > 1) {
                if (iCeil > iCeil2) {
                    options.inSampleSize = iCeil;
                } else {
                    options.inSampleSize = iCeil2;
                }
            }
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options);
            if (bitmapDecodeFileDescriptor != null) {
                b(i2, str, bitmapDecodeFileDescriptor);
            }
            return bitmapDecodeFileDescriptor;
        } catch (Exception unused) {
            return null;
        }
    }

    public final synchronized void b(int i2, @NotNull String str, @NotNull Bitmap bitmap) {
        j.e(str, "src");
        j.e(bitmap, "bitmap");
        ConcurrentHashMap<Integer, ConcurrentHashMap<String, Bitmap>> concurrentHashMap = f5799b;
        ConcurrentHashMap<String, Bitmap> concurrentHashMap2 = (ConcurrentHashMap) concurrentHashMap.get(Integer.valueOf(i2));
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap.put(Integer.valueOf(i2), concurrentHashMap2);
        }
        concurrentHashMap2.put(str, bitmap);
    }
}
