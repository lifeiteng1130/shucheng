package c.b.a.m.r.g;

import android.util.Log;
import androidx.annotation.NonNull;
import c.b.a.m.l;
import c.b.a.m.o;
import c.b.a.m.q.w;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: GifDrawableEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements o<GifDrawable> {
    @Override // c.b.a.m.o
    @NonNull
    public c.b.a.m.c a(@NonNull l lVar) {
        return c.b.a.m.c.SOURCE;
    }

    @Override // c.b.a.m.d
    public boolean encode(@NonNull Object obj, @NonNull File file, @NonNull l lVar) throws Throwable {
        try {
            c.b.a.s.a.b(((GifDrawable) ((w) obj).get()).a.a.a.getData().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
