package okio;

import com.efs.sdk.base.Constants;
import f.c0.c.j;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: renamed from: okio.-GzipSourceExtensions, reason: invalid class name */
/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u000b\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\"\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0016\u0010\u000e\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r\"\u0016\u0010\u000f\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\r\"\u0016\u0010\u0010\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\r\"\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b\"\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000b\"\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"", "bit", "", "getBit", "(II)Z", "Lokio/Source;", "Lokio/GzipSource;", Constants.CP_GZIP, "(Lokio/Source;)Lokio/GzipSource;", "", "SECTION_DONE", "B", "FHCRC", OptRuntime.GeneratorState.resumptionPoint_TYPE, "FEXTRA", "FCOMMENT", "FNAME", "SECTION_BODY", "SECTION_HEADER", "SECTION_TRAILER", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-GzipSourceExtensions")
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getBit(int i2, int i3) {
        return ((i2 >> i3) & 1) == 1;
    }

    @NotNull
    public static final GzipSource gzip(@NotNull Source source) {
        j.e(source, "$this$gzip");
        return new GzipSource(source);
    }
}
