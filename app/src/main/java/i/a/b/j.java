package i.a.b;

import java.io.IOException;

/* JADX INFO: compiled from: JStylerObj.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public static final d a = new d(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f6362b = new e(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f6363c = new c(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f6364d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6365e = new a(null);

    /* JADX INFO: compiled from: JStylerObj.java */
    public static class a implements g {
        public a(a aVar) {
        }

        @Override // i.a.b.j.g
        public void a(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char cCharAt = str.charAt(i2);
                    if (cCharAt == '\f') {
                        appendable.append("\\f");
                    } else if (cCharAt == '\r') {
                        appendable.append("\\r");
                    } else if (cCharAt == '\"') {
                        appendable.append("\\\"");
                    } else if (cCharAt == '/') {
                        appendable.append("\\/");
                    } else if (cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                appendable.append("\\b");
                                break;
                            case '\t':
                                appendable.append("\\t");
                                break;
                            case '\n':
                                appendable.append("\\n");
                                break;
                            default:
                                if ((cCharAt < 0 || cCharAt > 31) && ((cCharAt < 127 || cCharAt > 159) && (cCharAt < 8192 || cCharAt > 8447))) {
                                    appendable.append(cCharAt);
                                } else {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> 4) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> 0) & 15));
                                }
                                break;
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Error");
            }
        }
    }

    /* JADX INFO: compiled from: JStylerObj.java */
    public static class b implements g {
        public b(b bVar) {
        }

        @Override // i.a.b.j.g
        public void a(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char cCharAt = str.charAt(i2);
                    if (cCharAt == '\f') {
                        appendable.append("\\f");
                    } else if (cCharAt == '\r') {
                        appendable.append("\\r");
                    } else if (cCharAt == '\"') {
                        appendable.append("\\\"");
                    } else if (cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                appendable.append("\\b");
                                break;
                            case '\t':
                                appendable.append("\\t");
                                break;
                            case '\n':
                                appendable.append("\\n");
                                break;
                            default:
                                if ((cCharAt < 0 || cCharAt > 31) && ((cCharAt < 127 || cCharAt > 159) && (cCharAt < 8192 || cCharAt > 8447))) {
                                    appendable.append(cCharAt);
                                } else {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> 4) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> 0) & 15));
                                }
                                break;
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Exeption");
            }
        }
    }

    /* JADX INFO: compiled from: JStylerObj.java */
    public static class c implements f {
        public c(c cVar) {
        }

        @Override // i.a.b.j.f
        public boolean a(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char cCharAt = str.charAt(0);
            if (!j.b(cCharAt) && !j.c(cCharAt)) {
                for (int i2 = 1; i2 < length; i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (!(cCharAt2 == '}' || cCharAt2 == ']' || cCharAt2 == ',' || cCharAt2 == ':') && !j.c(cCharAt2)) {
                    }
                }
                if (j.a(str)) {
                    return true;
                }
                char cCharAt3 = str.charAt(0);
                if ((cCharAt3 >= '0' && cCharAt3 <= '9') || cCharAt3 == '-') {
                    int i3 = 1;
                    while (i3 < length) {
                        cCharAt3 = str.charAt(i3);
                        if (cCharAt3 < '0' || cCharAt3 > '9') {
                            break;
                        }
                        i3++;
                    }
                    if (i3 == length) {
                        return true;
                    }
                    if (cCharAt3 == '.') {
                        i3++;
                    }
                    while (i3 < length) {
                        cCharAt3 = str.charAt(i3);
                        if (cCharAt3 < '0' || cCharAt3 > '9') {
                            break;
                        }
                        i3++;
                    }
                    if (i3 == length) {
                        return true;
                    }
                    if (cCharAt3 == 'E' || cCharAt3 == 'e') {
                        i3++;
                        if (i3 == length) {
                            return false;
                        }
                        char cCharAt4 = str.charAt(i3);
                        if (cCharAt4 == '+' || cCharAt4 == '-') {
                            i3++;
                            str.charAt(i3);
                        }
                    }
                    if (i3 == length) {
                        return false;
                    }
                    while (i3 < length) {
                        char cCharAt5 = str.charAt(i3);
                        if (cCharAt5 < '0' || cCharAt5 > '9') {
                            break;
                        }
                        i3++;
                    }
                    if (i3 == length) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: JStylerObj.java */
    public static class d implements f {
        public d(d dVar) {
        }

        @Override // i.a.b.j.f
        public boolean a(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char cCharAt = str.charAt(0);
            if ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '-') {
                return true;
            }
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt2 = str.charAt(i2);
                if ((cCharAt2 == '\r' || cCharAt2 == '\n' || cCharAt2 == '\t' || cCharAt2 == ' ') || j.b(cCharAt2)) {
                    return true;
                }
                if ((cCharAt2 == '\b' || cCharAt2 == '\f' || cCharAt2 == '\n') || j.c(cCharAt2)) {
                    return true;
                }
            }
            return j.a(str);
        }
    }

    /* JADX INFO: compiled from: JStylerObj.java */
    public static class e implements f {
        public e(e eVar) {
        }

        @Override // i.a.b.j.f
        public boolean a(String str) {
            return true;
        }
    }

    /* JADX INFO: compiled from: JStylerObj.java */
    public interface f {
        boolean a(String str);
    }

    /* JADX INFO: compiled from: JStylerObj.java */
    public interface g {
        void a(String str, Appendable appendable);
    }

    public static boolean a(String str) {
        if (str.length() < 3) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'n') {
            return str.equals("null");
        }
        if (cCharAt == 't') {
            return str.equals("true");
        }
        if (cCharAt == 'f') {
            return str.equals("false");
        }
        if (cCharAt == 'N') {
            return str.equals("NaN");
        }
        return false;
    }

    public static boolean b(char c2) {
        return c2 == '{' || c2 == '[' || c2 == ',' || c2 == '}' || c2 == ']' || c2 == ':' || c2 == '\'' || c2 == '\"';
    }

    public static boolean c(char c2) {
        if (c2 >= 0 && c2 <= 31) {
            return true;
        }
        if (c2 < 127 || c2 > 159) {
            return c2 >= 8192 && c2 <= 8447;
        }
        return true;
    }
}
