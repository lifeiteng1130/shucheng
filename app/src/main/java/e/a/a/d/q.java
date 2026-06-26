package e.a.a.d;

import android.content.SharedPreferences;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LocalConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    @NotNull
    public static final q a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SharedPreferences f5554b = k.d.a.h.g().getSharedPreferences("local", 0);

    public final long a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = f5554b;
        long j2 = sharedPreferences.getLong("firstOpenTime", 0L);
        if (j2 != 0) {
            return j2;
        }
        f.c0.c.j.d(sharedPreferences, "localConfig");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putLong("firstOpenTime", jCurrentTimeMillis);
        editorEdit.apply();
        return jCurrentTimeMillis;
    }

    public final boolean b(int i2, String str, String str2) {
        SharedPreferences sharedPreferences = f5554b;
        int i3 = sharedPreferences.getInt(str, 0);
        if (i3 == 0 && str2 != null && !sharedPreferences.getBoolean(str2, true)) {
            i3 = 1;
        }
        if (i3 >= i2) {
            return true;
        }
        f.c0.c.j.d(sharedPreferences, "localConfig");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putInt(str, i2);
        editorEdit.apply();
        return false;
    }
}
