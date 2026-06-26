package c.b.a.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import c.b.a.m.k;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: Options.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<k<?>, Object> f313b = new CachedHashCodeArrayMap();

    @Nullable
    public <T> T b(@NonNull k<T> kVar) {
        return this.f313b.containsKey(kVar) ? (T) this.f313b.get(kVar) : kVar.f309b;
    }

    public void c(@NonNull l lVar) {
        this.f313b.putAll((SimpleArrayMap<? extends k<?>, ? extends Object>) lVar.f313b);
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return this.f313b.equals(((l) obj).f313b);
        }
        return false;
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        return this.f313b.hashCode();
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Options{values=");
        sbR.append(this.f313b);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f313b.size(); i2++) {
            k<?> kVarKeyAt = this.f313b.keyAt(i2);
            Object objValueAt = this.f313b.valueAt(i2);
            k.b<?> bVar = kVarKeyAt.f310c;
            if (kVarKeyAt.f312e == null) {
                kVarKeyAt.f312e = kVarKeyAt.f311d.getBytes(j.a);
            }
            bVar.a(kVarKeyAt.f312e, objValueAt, messageDigest);
        }
    }
}
