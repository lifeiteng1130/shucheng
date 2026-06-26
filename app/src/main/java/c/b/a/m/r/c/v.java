package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import c.b.a.m.r.c.s;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.util.Objects;

/* JADX INFO: compiled from: ParcelFileDescriptorBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class v implements c.b.a.m.n<ParcelFileDescriptor, Bitmap> {
    public final m a;

    public v(m mVar) {
        this.a = mVar;
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull c.b.a.m.l lVar) {
        Objects.requireNonNull(this.a);
        return ParcelFileDescriptorRewinder.isSupported();
    }

    @Override // c.b.a.m.n
    @Nullable
    public c.b.a.m.q.w<Bitmap> b(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, @NonNull c.b.a.m.l lVar) {
        m mVar = this.a;
        return mVar.a(new s.b(parcelFileDescriptor, mVar.f534l, mVar.f533k), i2, i3, lVar, m.f528f);
    }
}
