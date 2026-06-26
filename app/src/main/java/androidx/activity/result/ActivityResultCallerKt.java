package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a[\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\r\u001aS\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {OptRuntime.GeneratorState.resumptionPoint_TYPE, "O", "Landroidx/activity/result/ActivityResultCaller;", "Landroidx/activity/result/contract/ActivityResultContract;", "contract", "input", "Landroidx/activity/result/ActivityResultRegistry;", "registry", "Lkotlin/Function1;", "Lf/v;", "callback", "Landroidx/activity/result/ActivityResultLauncher;", "registerForActivityResult", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/activity/result/ActivityResultRegistry;Lf/c0/b/l;)Landroidx/activity/result/ActivityResultLauncher;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Lf/c0/b/l;)Landroidx/activity/result/ActivityResultLauncher;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class ActivityResultCallerKt {
    @NotNull
    public static final <I, O> ActivityResultLauncher<v> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> activityResultContract, I i2, @NotNull ActivityResultRegistry activityResultRegistry, @NotNull final l<? super O, v> lVar) {
        j.e(activityResultCaller, "$this$registerForActivityResult");
        j.e(activityResultContract, "contract");
        j.e(activityResultRegistry, "registry");
        j.e(lVar, "callback");
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                lVar.invoke(o);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(activityResultLauncherRegisterForActivityResult, activityResultContract, i2);
    }

    @NotNull
    public static final <I, O> ActivityResultLauncher<v> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> activityResultContract, I i2, @NotNull final l<? super O, v> lVar) {
        j.e(activityResultCaller, "$this$registerForActivityResult");
        j.e(activityResultContract, "contract");
        j.e(lVar, "callback");
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                lVar.invoke(o);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(activityResultLauncherRegisterForActivityResult, activityResultContract, i2);
    }
}
