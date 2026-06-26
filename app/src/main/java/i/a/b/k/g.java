package i.a.b.k;

/* JADX INFO: compiled from: ParseException.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends Exception {
    public static final int ERROR_UNEXPECTED_CHAR = 0;
    public static final int ERROR_UNEXPECTED_DUPLICATE_KEY = 5;
    public static final int ERROR_UNEXPECTED_EOF = 3;
    public static final int ERROR_UNEXPECTED_EXCEPTION = 2;
    public static final int ERROR_UNEXPECTED_LEADING_0 = 6;
    public static final int ERROR_UNEXPECTED_TOKEN = 1;
    public static final int ERROR_UNEXPECTED_UNICODE = 4;
    private static final long serialVersionUID = 8879024178584091857L;
    private int errorType;
    private int position;
    private Object unexpectedObject;

    public g(int i2, int i3, Object obj) {
        super(a(i2, i3, obj));
        this.position = i2;
        this.errorType = i3;
        this.unexpectedObject = obj;
    }

    public static String a(int i2, int i3, Object obj) {
        StringBuilder sb = new StringBuilder();
        if (i3 == 0) {
            sb.append("Unexpected character (");
            sb.append(obj);
            sb.append(") at position ");
            sb.append(i2);
            sb.append(".");
        } else if (i3 == 1) {
            sb.append("Unexpected token ");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i2);
            sb.append(".");
        } else if (i3 == 2) {
            sb.append("Unexpected exception ");
            sb.append(obj);
            sb.append(" occur at position ");
            sb.append(i2);
            sb.append(".");
        } else if (i3 == 3) {
            sb.append("Unexpected End Of File position ");
            sb.append(i2);
            sb.append(": ");
            sb.append(obj);
        } else if (i3 == 4) {
            sb.append("Unexpected unicode escape sequence ");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i2);
            sb.append(".");
        } else if (i3 == 5) {
            sb.append("Unexpected duplicate key:");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i2);
            sb.append(".");
        } else if (i3 == 6) {
            sb.append("Unexpected leading 0 in digit for token:");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i2);
            sb.append(".");
        } else {
            sb.append("Unkown error at position ");
            sb.append(i2);
            sb.append(".");
        }
        return sb.toString();
    }

    public int getErrorType() {
        return this.errorType;
    }

    public int getPosition() {
        return this.position;
    }

    public Object getUnexpectedObject() {
        return this.unexpectedObject;
    }

    public g(int i2, Throwable th) {
        super(a(i2, 2, th), th);
        this.position = i2;
        this.errorType = 2;
        this.unexpectedObject = th;
    }
}
