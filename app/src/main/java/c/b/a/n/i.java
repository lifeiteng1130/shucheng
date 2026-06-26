package c.b.a.n;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: FirstFrameAndAfterTrimMemoryWaiter.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class i implements k, ComponentCallbacks2 {
    @Override // c.b.a.n.k
    public void a(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
    }
}
