package c.b.a.m;

import c.b.a.m.f;
import com.bumptech.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements f.d {
    public final /* synthetic */ ByteBuffer a;

    public g(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // c.b.a.m.f.d
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
        return imageHeaderParser.a(this.a);
    }
}
