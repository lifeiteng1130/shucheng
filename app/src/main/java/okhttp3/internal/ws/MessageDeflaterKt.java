package okhttp3.internal.ws;

import kotlin.Metadata;
import okio.ByteString;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: MessageDeflater.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION", OptRuntime.GeneratorState.resumptionPoint_TYPE, "Lokio/ByteString;", "EMPTY_DEFLATE_BLOCK", "Lokio/ByteString;", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class MessageDeflaterKt {
    private static final ByteString EMPTY_DEFLATE_BLOCK = ByteString.INSTANCE.decodeHex("000000ffff");
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;
}
