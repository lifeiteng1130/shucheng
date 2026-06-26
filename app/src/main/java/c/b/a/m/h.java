package c.b.a.m;

import c.b.a.m.f;
import c.b.a.m.r.c.w;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements f.d {
    public final /* synthetic */ ParcelFileDescriptorRewinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.b.a.m.q.c0.b f307b;

    public h(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, c.b.a.m.q.c0.b bVar) {
        this.a = parcelFileDescriptorRewinder;
        this.f307b = bVar;
    }

    @Override // c.b.a.m.f.d
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
        w wVar = null;
        try {
            w wVar2 = new w(new FileInputStream(this.a.rewindAndGet().getFileDescriptor()), this.f307b);
            try {
                ImageHeaderParser.ImageType imageTypeB = imageHeaderParser.b(wVar2);
                try {
                    wVar2.close();
                } catch (IOException unused) {
                }
                this.a.rewindAndGet();
                return imageTypeB;
            } catch (Throwable th) {
                th = th;
                wVar = wVar2;
                if (wVar != null) {
                    try {
                        wVar.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.rewindAndGet();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
