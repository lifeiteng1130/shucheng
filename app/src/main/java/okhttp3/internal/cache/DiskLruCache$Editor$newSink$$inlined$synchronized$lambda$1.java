package okhttp3.internal.cache;

import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import java.io.IOException;
import kotlin.Metadata;
import okhttp3.internal.cache.DiskLruCache;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DiskLruCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/io/IOException;", "it", "Lf/v;", "invoke", "(Ljava/io/IOException;)V", "okhttp3/internal/cache/DiskLruCache$Editor$newSink$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 extends k implements l<IOException, v> {
    public final /* synthetic */ int $index$inlined;
    public final /* synthetic */ DiskLruCache.Editor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(DiskLruCache.Editor editor, int i2) {
        super(1);
        this.this$0 = editor;
        this.$index$inlined = i2;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(IOException iOException) {
        invoke2(iOException);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull IOException iOException) {
        j.e(iOException, "it");
        synchronized (this.this$0.this$0) {
            this.this$0.detach$okhttp();
        }
    }
}
