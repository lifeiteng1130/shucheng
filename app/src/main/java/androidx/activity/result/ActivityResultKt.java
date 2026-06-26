package androidx.activity.result;

import android.content.Intent;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActivityResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/ActivityResult;", "", "component1", "(Landroidx/activity/result/ActivityResult;)I", "Landroid/content/Intent;", "component2", "(Landroidx/activity/result/ActivityResult;)Landroid/content/Intent;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class ActivityResultKt {
    public static final int component1(@NotNull ActivityResult activityResult) {
        j.e(activityResult, "$this$component1");
        return activityResult.getResultCode();
    }

    @Nullable
    public static final Intent component2(@NotNull ActivityResult activityResult) {
        j.e(activityResult, "$this$component2");
        return activityResult.getData();
    }
}
