package j$.time;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class k extends ZoneId implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient j$.time.zone.c f7886c;

    k(String str, j$.time.zone.c cVar) {
        this.f7885b = str;
        this.f7886c = cVar;
    }

    static k y(String str, boolean z) {
        int length = str.length();
        if (length < 2) {
            throw new c("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i2 == 0) && ((cCharAt < '0' || cCharAt > '9' || i2 == 0) && ((cCharAt != '~' || i2 == 0) && ((cCharAt != '.' || i2 == 0) && ((cCharAt != '_' || i2 == 0) && ((cCharAt != '+' || i2 == 0) && (cCharAt != '-' || i2 == 0))))))))) {
                throw new c("Invalid ID for region-based ZoneId, invalid format: " + str);
            }
        }
        j$.time.zone.c cVarA = null;
        try {
            cVarA = j$.time.zone.e.a(str, true);
        } catch (j$.time.zone.d e2) {
            if (z) {
                throw e2;
            }
        }
        return new k(str, cVarA);
    }

    @Override // j$.time.ZoneId
    public String g() {
        return this.f7885b;
    }

    @Override // j$.time.ZoneId
    public j$.time.zone.c t() {
        j$.time.zone.c cVar = this.f7886c;
        return cVar != null ? cVar : j$.time.zone.e.a(this.f7885b, false);
    }
}
