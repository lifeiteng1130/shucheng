package c.b.a.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: Option.java */
/* JADX INFO: loaded from: classes.dex */
public final class k<T> {
    public static final b<Object> a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<T> f310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile byte[] f312e;

    /* JADX INFO: compiled from: Option.java */
    public class a implements b<Object> {
        @Override // c.b.a.m.k.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* JADX INFO: compiled from: Option.java */
    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public k(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f311d = str;
        this.f309b = t;
        Objects.requireNonNull(bVar, "Argument must not be null");
        this.f310c = bVar;
    }

    @NonNull
    public static <T> k<T> a(@NonNull String str, @NonNull T t) {
        return new k<>(str, t, a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f311d.equals(((k) obj).f311d);
        }
        return false;
    }

    public int hashCode() {
        return this.f311d.hashCode();
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Option{key='");
        sbR.append(this.f311d);
        sbR.append('\'');
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
