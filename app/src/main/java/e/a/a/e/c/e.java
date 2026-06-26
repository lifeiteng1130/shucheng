package e.a.a.e.c;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActivitySource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements p {

    @NotNull
    public final WeakReference<AppCompatActivity> a;

    public e(@NotNull AppCompatActivity appCompatActivity) {
        f.c0.c.j.e(appCompatActivity, "activity");
        this.a = new WeakReference<>(appCompatActivity);
    }

    @Override // e.a.a.e.c.p
    @Nullable
    public Context getContext() {
        return this.a.get();
    }
}
