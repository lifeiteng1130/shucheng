package okio;

import f.c0.c.j;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lokio/Source;", "Ljava/util/zip/Inflater;", "inflater", "Lokio/InflaterSource;", "inflate", "(Lokio/Source;Ljava/util/zip/Inflater;)Lokio/InflaterSource;", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-InflaterSourceExtensions")
public final class InflaterSourceExtensions {
    @NotNull
    public static final InflaterSource inflate(@NotNull Source source, @NotNull Inflater inflater) {
        j.e(source, "$this$inflate");
        j.e(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            inflater = new Inflater();
        }
        j.e(source, "$this$inflate");
        j.e(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
