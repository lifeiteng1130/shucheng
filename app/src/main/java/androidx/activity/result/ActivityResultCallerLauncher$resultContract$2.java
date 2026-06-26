package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.umeng.analytics.pro.c;
import f.c0.b.a;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {OptRuntime.GeneratorState.resumptionPoint_TYPE, "O", "androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "invoke", "()Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class ActivityResultCallerLauncher$resultContract$2 extends k implements a<AnonymousClass1> {
    public final /* synthetic */ ActivityResultCallerLauncher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
    @Override // f.c0.b.a
    @NotNull
    public final AnonymousClass1 invoke() {
        return new ActivityResultContract<v, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
            @Override // androidx.activity.result.contract.ActivityResultContract
            public O parseResult(int resultCode, @Nullable Intent intent) {
                return (O) ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().parseResult(resultCode, intent);
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            @NotNull
            public Intent createIntent(@NotNull Context context, @Nullable v vVar) {
                j.e(context, c.R);
                Intent intentCreateIntent = ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().createIntent(context, ActivityResultCallerLauncher$resultContract$2.this.this$0.getInput());
                j.d(intentCreateIntent, "callerContract.createIntent(context, input)");
                return intentCreateIntent;
            }
        };
    }
}
