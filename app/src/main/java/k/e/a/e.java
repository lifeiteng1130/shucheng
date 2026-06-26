package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public e(int i2) {
        if (i2 != 262144 && i2 != 327680) {
            throw new IllegalArgumentException();
        }
    }

    public abstract void a(int i2, int i3, String str, String str2, String str3, String[] strArr);

    public abstract a b(String str, boolean z);

    public abstract o c(int i2, String str, String str2, String str3, String[] strArr);

    public abstract a d(int i2, s sVar, String str, boolean z);
}
