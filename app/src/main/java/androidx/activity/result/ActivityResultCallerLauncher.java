package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import c.b.a.m.f;
import f.c0.c.j;
import f.e;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B1\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR)\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\u0013\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR%\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000e¨\u0006 "}, d2 = {"Landroidx/activity/result/ActivityResultCallerLauncher;", OptRuntime.GeneratorState.resumptionPoint_TYPE, "O", "Landroidx/activity/result/ActivityResultLauncher;", "Lf/v;", "void", "Landroidx/core/app/ActivityOptionsCompat;", "options", "launch", "(Lf/v;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "()V", "Landroidx/activity/result/contract/ActivityResultContract;", "getContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "resultContract$delegate", "Lf/e;", "getResultContract", "resultContract", "input", "Ljava/lang/Object;", "getInput", "()Ljava/lang/Object;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "callerContract", "Landroidx/activity/result/contract/ActivityResultContract;", "getCallerContract", "<init>", "(Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;)V", "activity-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<v> {

    @NotNull
    private final ActivityResultContract<I, O> callerContract;
    private final I input;

    @NotNull
    private final ActivityResultLauncher<I> launcher;

    /* JADX INFO: renamed from: resultContract$delegate, reason: from kotlin metadata */
    @NotNull
    private final e resultContract;

    public ActivityResultCallerLauncher(@NotNull ActivityResultLauncher<I> activityResultLauncher, @NotNull ActivityResultContract<I, O> activityResultContract, I i2) {
        j.e(activityResultLauncher, "launcher");
        j.e(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.input = i2;
        this.resultContract = f.N3(new ActivityResultCallerLauncher$resultContract$2(this));
    }

    @NotNull
    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @NotNull
    public ActivityResultContract<v, ?> getContract() {
        return getResultContract();
    }

    public final I getInput() {
        return this.input;
    }

    @NotNull
    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    @NotNull
    public final ActivityResultContract<v, O> getResultContract() {
        return (ActivityResultContract) this.resultContract.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(@Nullable v vVar, @Nullable ActivityOptionsCompat options) {
        this.launcher.launch(this.input, options);
    }
}
