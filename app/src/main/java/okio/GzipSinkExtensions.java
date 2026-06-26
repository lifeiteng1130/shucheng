package okio;

import com.efs.sdk.base.Constants;
import f.c0.c.j;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* JADX INFO: compiled from: GzipSink.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/Sink;", "Lokio/GzipSink;", Constants.CP_GZIP, "(Lokio/Sink;)Lokio/GzipSink;", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-GzipSinkExtensions")
public final class GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink sink) {
        j.e(sink, "$this$gzip");
        return new GzipSink(sink);
    }
}
