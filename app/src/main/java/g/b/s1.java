package g.b;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(level = f.a.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
public interface s1 extends f1 {
    @InternalCoroutinesApi
    @NotNull
    CancellationException j();
}
