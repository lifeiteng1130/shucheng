package b.a.b.x1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.UseCaseEventConfig;

/* JADX INFO: compiled from: UseCaseEventConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d {
    @NonNull
    public static UseCase.EventCallback a(UseCaseEventConfig _this) {
        return (UseCase.EventCallback) _this.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK);
    }

    @Nullable
    public static UseCase.EventCallback b(@Nullable UseCaseEventConfig _this, UseCase.EventCallback eventCallback) {
        return (UseCase.EventCallback) _this.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
    }
}
