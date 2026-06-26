package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.k;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements h {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    protected a() {
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        return ExifInterface.TAG_RW2_ISO.compareTo(hVar.g());
    }

    @Override // j$.time.chrono.h
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && compareTo((a) obj) == 0;
    }

    public int hashCode() {
        return getClass().hashCode() ^ 72805;
    }

    @Override // j$.time.chrono.h
    public c o(k kVar) {
        try {
            return j$.time.f.z(j$.time.e.v(kVar), j$.time.g.v(kVar));
        } catch (j$.time.c e2) {
            StringBuilder sbA = j$.com.android.tools.r8.a.a("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            sbA.append(kVar.getClass());
            throw new j$.time.c(sbA.toString(), e2);
        }
    }

    @Override // j$.time.chrono.h
    public f r(Instant instant, ZoneId zoneId) {
        return g.t(this, instant, zoneId);
    }

    public String toString() {
        return ExifInterface.TAG_RW2_ISO;
    }
}
