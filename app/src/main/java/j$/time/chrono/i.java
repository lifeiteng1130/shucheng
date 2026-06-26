package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.l;
import j$.time.temporal.k;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends a implements Serializable {
    public static final i a = new i();

    private i() {
    }

    @Override // j$.time.chrono.h
    public String g() {
        return ExifInterface.TAG_RW2_ISO;
    }

    public boolean h(long j2) {
        return (3 & j2) == 0 && (j2 % 100 != 0 || j2 % 400 == 0);
    }

    @Override // j$.time.chrono.h
    public b i(k kVar) {
        return j$.time.e.v(kVar);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.h
    public c o(k kVar) {
        return j$.time.f.v(kVar);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.h
    public f r(Instant instant, ZoneId zoneId) {
        return l.t(instant, zoneId);
    }
}
