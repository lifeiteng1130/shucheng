package androidx.core.os;

import androidx.exifinterface.media.ExifInterface;
import f.c0.b.a;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "sectionName", "Lkotlin/Function0;", "block", "trace", "(Ljava/lang/String;Lf/c0/b/a;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class TraceKt {
    public static final <T> T trace(@NotNull String str, @NotNull a<? extends T> aVar) {
        j.f(str, "sectionName");
        j.f(aVar, "block");
        TraceCompat.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            TraceCompat.endSection();
        }
    }
}
