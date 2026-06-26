package b.a.b.x1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.internal.ThreadConfig;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ThreadConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c {
    @NonNull
    public static Executor a(ThreadConfig _this) {
        return (Executor) _this.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
    }

    @Nullable
    public static Executor b(@Nullable ThreadConfig _this, Executor executor) {
        return (Executor) _this.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
    }
}
