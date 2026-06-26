package j$.time.temporal;

import androidx.recyclerview.widget.RecyclerView;
import j$.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public enum i implements o {
    NANOS("Nanos", Duration.j(1)),
    MICROS("Micros", Duration.j(1000)),
    MILLIS("Millis", Duration.j(1000000)),
    SECONDS("Seconds", Duration.l(1)),
    MINUTES("Minutes", Duration.l(60)),
    HOURS("Hours", Duration.l(3600)),
    HALF_DAYS("HalfDays", Duration.l(43200)),
    DAYS("Days", Duration.l(86400)),
    WEEKS("Weeks", Duration.l(604800)),
    MONTHS("Months", Duration.l(2629746)),
    YEARS("Years", Duration.l(31556952)),
    DECADES("Decades", Duration.l(315569520)),
    CENTURIES("Centuries", Duration.l(3155695200L)),
    MILLENNIA("Millennia", Duration.l(31556952000L)),
    ERAS("Eras", Duration.l(31556952000000000L)),
    FOREVER("Forever", Duration.n(RecyclerView.FOREVER_NS, 999999999));


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7893b;

    i(String str, Duration duration) {
        this.f7893b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f7893b;
    }
}
