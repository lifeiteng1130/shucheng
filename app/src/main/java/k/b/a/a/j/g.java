package k.b.a.a.j;

import com.ss.android.download.api.constant.BaseConstants;
import j$.C$r8$retargetLibraryMember$virtualDispatch$TimeZone$toZoneId$dispatchInterface;
import j$.time.ZoneId;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: GmtTimeZone.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends TimeZone implements C$r8$retargetLibraryMember$virtualDispatch$TimeZone$toZoneId$dispatchInterface {
    public static final long serialVersionUID = 1;
    private final int offset;
    private final String zoneId;

    public g(boolean z, int i2, int i3) {
        if (i2 >= 24) {
            throw new IllegalArgumentException(i2 + " hours out of range");
        }
        if (i3 >= 60) {
            throw new IllegalArgumentException(i3 + " minutes out of range");
        }
        int i4 = ((i2 * 60) + i3) * BaseConstants.Time.MINUTE;
        this.offset = z ? -i4 : i4;
        StringBuilder sb = new StringBuilder(9);
        sb.append("GMT");
        sb.append(z ? '-' : '+');
        sb.append((char) ((i2 / 10) + 48));
        sb.append((char) ((i2 % 10) + 48));
        sb.append(':');
        sb.append((char) ((i3 / 10) + 48));
        sb.append((char) ((i3 % 10) + 48));
        this.zoneId = sb.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.zoneId == ((g) obj).zoneId;
    }

    @Override // java.util.TimeZone
    public String getID() {
        return this.zoneId;
    }

    @Override // java.util.TimeZone
    public int getOffset(int i2, int i3, int i4, int i5, int i6, int i7) {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.offset;
    }

    public int hashCode() {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return false;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i2) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("[GmtTimeZone id=\"");
        sbR.append(this.zoneId);
        sbR.append("\",offset=");
        return c.a.a.a.a.n(sbR, this.offset, ']');
    }

    @Override // java.util.TimeZone, j$.C$r8$retargetLibraryMember$virtualDispatch$TimeZone$toZoneId$dispatchInterface
    public /* synthetic */ ZoneId toZoneId() {
        return DesugarTimeZone.toZoneId(this);
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return false;
    }
}
