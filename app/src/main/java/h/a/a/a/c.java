package h.a.a.a;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: Date.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Serializable {
    private static final long serialVersionUID = 7533866830395120136L;
    private String dateString;
    private a event;

    /* JADX INFO: compiled from: Date.java */
    public enum a {
        PUBLICATION("publication"),
        MODIFICATION("modification"),
        CREATION("creation");

        private final String value;

        a(String str) {
            this.value = str;
        }

        public static a fromValue(String str) {
            a[] aVarArrValues = values();
            for (int i2 = 0; i2 < 3; i2++) {
                a aVar = aVarArrValues[i2];
                if (aVar.value.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    public c() {
        this(new Date(), a.CREATION);
    }

    public a getEvent() {
        return this.event;
    }

    public String getValue() {
        return this.dateString;
    }

    public void setEvent(a aVar) {
        this.event = aVar;
    }

    public String toString() {
        if (this.event == null) {
            return this.dateString;
        }
        StringBuilder sbR = c.a.a.a.a.r("");
        sbR.append(this.event);
        sbR.append(":");
        sbR.append(this.dateString);
        return sbR.toString();
    }

    public c(Date date) {
        this(date, (a) null);
    }

    public c(String str) {
        this(str, (a) null);
    }

    public c(Date date, a aVar) {
        this(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(date), aVar);
    }

    public c(String str, a aVar) {
        this.dateString = str;
        this.event = aVar;
    }

    public c(Date date, String str) {
        this(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(date), str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String str, String str2) {
        this(str, a.fromValue(str2));
        if (str != null) {
            this.dateString = str;
            return;
        }
        throw new IllegalArgumentException("Cannot create a date from a blank string");
    }
}
