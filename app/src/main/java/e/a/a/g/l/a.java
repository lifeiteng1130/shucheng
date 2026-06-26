package e.a.a.g.l;

import android.content.Intent;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.main.MainActivity;
import io.legado.app.ui.welcome.SplashActivity;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ SplashActivity a;

    @Override // java.lang.Runnable
    public final void run() {
        SplashActivity splashActivity = this.a;
        int i2 = SplashActivity.f7570g;
        f.c0.c.j.e(splashActivity, "this$0");
        splashActivity.finish();
        if (splashActivity.from == 1) {
            splashActivity.finish();
            return;
        }
        Intent intent = new Intent(splashActivity, (Class<?>) MainActivity.class);
        intent.addFlags(268435456);
        splashActivity.startActivity(intent);
        if (c.b.a.m.f.K2(splashActivity, "defaultToRead", false, 2)) {
            Intent intent2 = new Intent(splashActivity, (Class<?>) ReadBookActivity.class);
            intent2.addFlags(268435456);
            splashActivity.startActivity(intent2);
        }
        splashActivity.finish();
    }
}
