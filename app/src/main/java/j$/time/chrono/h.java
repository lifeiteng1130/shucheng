package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.k;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends Comparable<h> {
    int e(h hVar);

    boolean equals(Object obj);

    String g();

    b i(k kVar);

    c o(k kVar);

    f r(Instant instant, ZoneId zoneId);
}
