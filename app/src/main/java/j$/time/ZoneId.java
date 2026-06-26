package j$.time;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ZoneId implements Serializable {
    public static final Map a;

    static {
        HashMap map = new HashMap(64);
        map.put("ACT", "Australia/Darwin");
        map.put("AET", "Australia/Sydney");
        map.put("AGT", "America/Argentina/Buenos_Aires");
        map.put("ART", "Africa/Cairo");
        map.put("AST", "America/Anchorage");
        map.put("BET", "America/Sao_Paulo");
        map.put("BST", "Asia/Dhaka");
        map.put("CAT", "Africa/Harare");
        map.put("CNT", "America/St_Johns");
        map.put("CST", "America/Chicago");
        map.put("CTT", "Asia/Shanghai");
        map.put("EAT", "Africa/Addis_Ababa");
        map.put("ECT", "Europe/Paris");
        map.put("IET", "America/Indiana/Indianapolis");
        map.put("IST", "Asia/Kolkata");
        map.put("JST", "Asia/Tokyo");
        map.put("MIT", "Pacific/Apia");
        map.put("NET", "Asia/Yerevan");
        map.put("NST", "Pacific/Auckland");
        map.put("PLT", "Asia/Karachi");
        map.put("PNT", "America/Phoenix");
        map.put("PRT", "America/Puerto_Rico");
        map.put("PST", "America/Los_Angeles");
        map.put("SST", "Pacific/Guadalcanal");
        map.put("VST", "Asia/Ho_Chi_Minh");
        map.put("EST", "-05:00");
        map.put("MST", "-07:00");
        map.put("HST", "-10:00");
        a = Collections.unmodifiableMap(map);
    }

    ZoneId() {
        if (getClass() != j.class && getClass() != k.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId v(String str, Map map) {
        int i2;
        Objects.requireNonNull(str, "zoneId");
        Objects.requireNonNull(map, "aliasMap");
        String str2 = (String) map.get(str);
        if (str2 != null) {
            str = str2;
        }
        if (str.length() <= 1 || str.startsWith(Marker.ANY_NON_NULL_MARKER) || str.startsWith("-")) {
            return j.z(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            i2 = 3;
        } else {
            if (!str.startsWith("UT")) {
                return k.y(str, true);
            }
            i2 = 2;
        }
        return x(str, i2, true);
    }

    public static ZoneId w(String str, j jVar) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(jVar, "offset");
        if (str.length() == 0) {
            return jVar;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (jVar.y() != 0) {
                str = str.concat(jVar.g());
            }
            return new k(str, j$.time.zone.c.e(jVar));
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: " + str);
    }

    private static ZoneId x(String str, int i2, boolean z) {
        String strSubstring = str.substring(0, i2);
        if (str.length() == i2) {
            return w(strSubstring, j.f7880d);
        }
        if (str.charAt(i2) != '+' && str.charAt(i2) != '-') {
            return k.y(str, z);
        }
        try {
            j jVarZ = j.z(str.substring(i2));
            return jVarZ == j.f7880d ? w(strSubstring, jVarZ) : w(strSubstring, jVarZ);
        } catch (c e2) {
            throw new c("Invalid ID for offset-based ZoneId: " + str, e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return g().equals(((ZoneId) obj).g());
        }
        return false;
    }

    public abstract String g();

    public int hashCode() {
        return g().hashCode();
    }

    public abstract j$.time.zone.c t();

    public String toString() {
        return g();
    }
}
