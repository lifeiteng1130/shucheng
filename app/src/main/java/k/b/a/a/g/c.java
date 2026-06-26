package k.b.a.a.g;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import k.b.a.a.c;

/* JADX INFO: compiled from: ToStringStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements Serializable {
    private static final long serialVersionUID = -2587890625525655916L;
    public static final c DEFAULT_STYLE = new a();
    public static final c MULTI_LINE_STYLE = new C0226c();
    public static final c NO_FIELD_NAMES_STYLE = new e();
    public static final c SHORT_PREFIX_STYLE = new f();
    public static final c SIMPLE_STYLE = new g();
    public static final c NO_CLASS_NAME_STYLE = new d();
    public static final c JSON_STYLE = new b();
    public static final ThreadLocal<WeakHashMap<Object, Object>> a = new ThreadLocal<>();
    private boolean useFieldNames = true;
    private boolean useClassName = true;
    private boolean useShortClassName = false;
    private boolean useIdentityHashCode = true;
    private String contentStart = "[";
    private String contentEnd = "]";
    private String fieldNameValueSeparator = "=";
    private boolean fieldSeparatorAtStart = false;
    private boolean fieldSeparatorAtEnd = false;
    private String fieldSeparator = ",";
    private String arrayStart = "{";
    private String arraySeparator = ",";
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private boolean defaultFullDetail = true;
    private String nullText = "<null>";
    private String sizeStartText = "<size=";
    private String sizeEndText = ">";
    private String summaryObjectStartText = "<";
    private String summaryObjectEndText = ">";

    /* JADX INFO: compiled from: ToStringStyle.java */
    public static final class a extends c {
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return c.DEFAULT_STYLE;
        }
    }

    /* JADX INFO: renamed from: k.b.a.a.g.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ToStringStyle.java */
    public static final class C0226c extends c {
        private static final long serialVersionUID = 1;

        public C0226c() {
            setContentStart("[");
            setFieldSeparator(System.lineSeparator() + "  ");
            setFieldSeparatorAtStart(true);
            setContentEnd(System.lineSeparator() + "]");
        }

        private Object readResolve() {
            return c.MULTI_LINE_STYLE;
        }
    }

    /* JADX INFO: compiled from: ToStringStyle.java */
    public static final class d extends c {
        private static final long serialVersionUID = 1;

        public d() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return c.NO_CLASS_NAME_STYLE;
        }
    }

    /* JADX INFO: compiled from: ToStringStyle.java */
    public static final class e extends c {
        private static final long serialVersionUID = 1;

        public e() {
            setUseFieldNames(false);
        }

        private Object readResolve() {
            return c.NO_FIELD_NAMES_STYLE;
        }
    }

    /* JADX INFO: compiled from: ToStringStyle.java */
    public static final class f extends c {
        private static final long serialVersionUID = 1;

        public f() {
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return c.SHORT_PREFIX_STYLE;
        }
    }

    /* JADX INFO: compiled from: ToStringStyle.java */
    public static final class g extends c {
        private static final long serialVersionUID = 1;

        public g() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }

        private Object readResolve() {
            return c.SIMPLE_STYLE;
        }
    }

    public static Map<Object, Object> getRegistry() {
        return a.get();
    }

    public static boolean isRegistered(Object obj) {
        Map<Object, Object> registry = getRegistry();
        return registry != null && registry.containsKey(obj);
    }

    public static void register(Object obj) {
        if (obj != null) {
            if (getRegistry() == null) {
                a.set(new WeakHashMap<>());
            }
            getRegistry().put(obj, null);
        }
    }

    public static void unregister(Object obj) {
        Map<Object, Object> registry;
        if (obj == null || (registry = getRegistry()) == null) {
            return;
        }
        registry.remove(obj);
        if (registry.isEmpty()) {
            a.remove();
        }
    }

    public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (obj == null) {
            appendNullText(stringBuffer, str);
        } else {
            appendInternal(stringBuffer, str, obj, isFullDetail(bool));
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendClassName(StringBuffer stringBuffer, Object obj) {
        if (!this.useClassName || obj == null) {
            return;
        }
        register(obj);
        if (this.useShortClassName) {
            stringBuffer.append(getShortClassName(obj.getClass()));
        } else {
            stringBuffer.append(obj.getClass().getName());
        }
    }

    public void appendContentEnd(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    public void appendContentStart(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    public void appendCyclicObject(StringBuffer stringBuffer, String str, Object obj) {
        c.a aVar = k.b.a.a.c.a;
        c.b.a.m.f.e4(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(hexString.length() + name.length() + stringBuffer.length() + 1);
        stringBuffer.append(name);
        stringBuffer.append('@');
        stringBuffer.append(hexString);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    public void appendEnd(StringBuffer stringBuffer, Object obj) {
        if (!this.fieldSeparatorAtEnd) {
            removeLastFieldSeparator(stringBuffer);
        }
        appendContentEnd(stringBuffer);
        unregister(obj);
    }

    public void appendFieldEnd(StringBuffer stringBuffer, String str) {
        appendFieldSeparator(stringBuffer);
    }

    public void appendFieldSeparator(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    public void appendFieldStart(StringBuffer stringBuffer, String str) {
        if (!this.useFieldNames || str == null) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(this.fieldNameValueSeparator);
    }

    public void appendIdentityHashCode(StringBuffer stringBuffer, Object obj) {
        if (!isUseIdentityHashCode() || obj == null) {
            return;
        }
        register(obj);
        stringBuffer.append('@');
        stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public void appendInternal(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        if (isRegistered(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            appendCyclicObject(stringBuffer, str, obj);
            return;
        }
        register(obj);
        try {
            if (obj instanceof Collection) {
                if (z) {
                    appendDetail(stringBuffer, str, (Collection<?>) obj);
                } else {
                    appendSummarySize(stringBuffer, str, ((Collection) obj).size());
                }
            } else if (obj instanceof Map) {
                if (z) {
                    appendDetail(stringBuffer, str, (Map<?, ?>) obj);
                } else {
                    appendSummarySize(stringBuffer, str, ((Map) obj).size());
                }
            } else if (obj instanceof long[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (long[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (long[]) obj);
                }
            } else if (obj instanceof int[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (int[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (int[]) obj);
                }
            } else if (obj instanceof short[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (short[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (short[]) obj);
                }
            } else if (obj instanceof byte[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (byte[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (byte[]) obj);
                }
            } else if (obj instanceof char[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (char[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (char[]) obj);
                }
            } else if (obj instanceof double[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (double[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (double[]) obj);
                }
            } else if (obj instanceof float[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (float[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (float[]) obj);
                }
            } else if (obj instanceof boolean[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (boolean[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (boolean[]) obj);
                }
            } else if (obj.getClass().isArray()) {
                if (z) {
                    appendDetail(stringBuffer, str, (Object[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (Object[]) obj);
                }
            } else if (z) {
                appendDetail(stringBuffer, str, obj);
            } else {
                appendSummary(stringBuffer, str, obj);
            }
        } finally {
            unregister(obj);
        }
    }

    public void appendNullText(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.nullText);
    }

    public void appendStart(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            appendClassName(stringBuffer, obj);
            appendIdentityHashCode(stringBuffer, obj);
            appendContentStart(stringBuffer);
            if (this.fieldSeparatorAtStart) {
                appendFieldSeparator(stringBuffer);
            }
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(getShortClassName(obj.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    public void appendSummarySize(StringBuffer stringBuffer, String str, int i2) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(i2);
        stringBuffer.append(this.sizeEndText);
    }

    public void appendSuper(StringBuffer stringBuffer, String str) {
        appendToString(stringBuffer, str);
    }

    public void appendToString(StringBuffer stringBuffer, String str) {
        if (str != null) {
            int length = this.contentStart.length() + str.indexOf(this.contentStart);
            int iLastIndexOf = str.lastIndexOf(this.contentEnd);
            if (length == iLastIndexOf || length < 0 || iLastIndexOf < 0) {
                return;
            }
            if (this.fieldSeparatorAtStart) {
                removeLastFieldSeparator(stringBuffer);
            }
            stringBuffer.append((CharSequence) str, length, iLastIndexOf);
            appendFieldSeparator(stringBuffer);
        }
    }

    public String getArrayEnd() {
        return this.arrayEnd;
    }

    public String getArraySeparator() {
        return this.arraySeparator;
    }

    public String getArrayStart() {
        return this.arrayStart;
    }

    public String getContentEnd() {
        return this.contentEnd;
    }

    public String getContentStart() {
        return this.contentStart;
    }

    public String getFieldNameValueSeparator() {
        return this.fieldNameValueSeparator;
    }

    public String getFieldSeparator() {
        return this.fieldSeparator;
    }

    public String getNullText() {
        return this.nullText;
    }

    public String getShortClassName(Class<?> cls) {
        return k.b.a.a.b.a(cls);
    }

    public String getSizeEndText() {
        return this.sizeEndText;
    }

    public String getSizeStartText() {
        return this.sizeStartText;
    }

    public String getSummaryObjectEndText() {
        return this.summaryObjectEndText;
    }

    public String getSummaryObjectStartText() {
        return this.summaryObjectStartText;
    }

    public boolean isArrayContentDetail() {
        return this.arrayContentDetail;
    }

    public boolean isDefaultFullDetail() {
        return this.defaultFullDetail;
    }

    public boolean isFieldSeparatorAtEnd() {
        return this.fieldSeparatorAtEnd;
    }

    public boolean isFieldSeparatorAtStart() {
        return this.fieldSeparatorAtStart;
    }

    public boolean isFullDetail(Boolean bool) {
        return bool == null ? this.defaultFullDetail : bool.booleanValue();
    }

    public boolean isUseClassName() {
        return this.useClassName;
    }

    public boolean isUseFieldNames() {
        return this.useFieldNames;
    }

    public boolean isUseIdentityHashCode() {
        return this.useIdentityHashCode;
    }

    public boolean isUseShortClassName() {
        return this.useShortClassName;
    }

    public void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.arrayStart);
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            appendDetail(stringBuffer, str, i2, Array.get(obj, i2));
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void removeLastFieldSeparator(StringBuffer stringBuffer) {
        String str = this.fieldSeparator;
        int i2 = k.b.a.a.f.a;
        boolean zG4 = false;
        if (stringBuffer == null || str == null) {
            if (stringBuffer == str) {
                zG4 = true;
            }
        } else if (str.length() <= stringBuffer.length()) {
            zG4 = c.b.a.m.f.G4(stringBuffer, false, stringBuffer.length() - str.length(), str, 0, str.length());
        }
        if (zG4) {
            stringBuffer.setLength(stringBuffer.length() - this.fieldSeparator.length());
        }
    }

    public void setArrayContentDetail(boolean z) {
        this.arrayContentDetail = z;
    }

    public void setArrayEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayEnd = str;
    }

    public void setArraySeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.arraySeparator = str;
    }

    public void setArrayStart(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayStart = str;
    }

    public void setContentEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.contentEnd = str;
    }

    public void setContentStart(String str) {
        if (str == null) {
            str = "";
        }
        this.contentStart = str;
    }

    public void setDefaultFullDetail(boolean z) {
        this.defaultFullDetail = z;
    }

    public void setFieldNameValueSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldNameValueSeparator = str;
    }

    public void setFieldSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldSeparator = str;
    }

    public void setFieldSeparatorAtEnd(boolean z) {
        this.fieldSeparatorAtEnd = z;
    }

    public void setFieldSeparatorAtStart(boolean z) {
        this.fieldSeparatorAtStart = z;
    }

    public void setNullText(String str) {
        if (str == null) {
            str = "";
        }
        this.nullText = str;
    }

    public void setSizeEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeEndText = str;
    }

    public void setSizeStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeStartText = str;
    }

    public void setSummaryObjectEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectEndText = str;
    }

    public void setSummaryObjectStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectStartText = str;
    }

    public void setUseClassName(boolean z) {
        this.useClassName = z;
    }

    public void setUseFieldNames(boolean z) {
        this.useFieldNames = z;
    }

    public void setUseIdentityHashCode(boolean z) {
        this.useIdentityHashCode = z;
    }

    public void setUseShortClassName(boolean z) {
        this.useShortClassName = z;
    }

    /* JADX INFO: compiled from: ToStringStyle.java */
    public static final class b extends c {
        private static final long serialVersionUID = 1;

        public b() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setContentStart("{");
            setContentEnd("}");
            setArrayStart("[");
            setArrayEnd("]");
            setFieldSeparator(",");
            setFieldNameValueSeparator(":");
            setNullText("null");
            setSummaryObjectStartText("\"<");
            setSummaryObjectEndText(">\"");
            setSizeStartText("\"<size=");
            setSizeEndText(">\"");
        }

        private Object readResolve() {
            return c.JSON_STYLE;
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!isFullDetail(bool)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, str, objArr, bool);
        }

        @Override // k.b.a.a.g.c
        public void appendDetail(StringBuffer stringBuffer, String str, char c2) {
            String strValueOf = String.valueOf(c2);
            stringBuffer.append('\"');
            stringBuffer.append(k.b.a.a.e.a(strValueOf));
            stringBuffer.append('\"');
        }

        @Override // k.b.a.a.g.c
        public void appendFieldStart(StringBuffer stringBuffer, String str) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            StringBuilder sbR = c.a.a.a.a.r("\"");
            sbR.append(k.b.a.a.e.a(str));
            sbR.append("\"");
            super.appendFieldStart(stringBuffer, sbR.toString());
        }

        @Override // k.b.a.a.g.c
        public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
            if (obj == null) {
                appendNullText(stringBuffer, str);
                return;
            }
            if (!(obj instanceof String) && !(obj instanceof Character)) {
                if (!(obj instanceof Number) && !(obj instanceof Boolean)) {
                    String string = obj.toString();
                    boolean z = false;
                    if (!(string.startsWith(getContentStart()) && string.endsWith(getContentEnd()))) {
                        if (string.startsWith(getArrayStart()) && string.endsWith(getArrayEnd())) {
                            z = true;
                        }
                        if (!z) {
                            appendDetail(stringBuffer, str, string);
                            return;
                        }
                    }
                    stringBuffer.append(obj);
                    return;
                }
                stringBuffer.append(obj);
                return;
            }
            String string2 = obj.toString();
            stringBuffer.append('\"');
            stringBuffer.append(k.b.a.a.e.a(string2));
            stringBuffer.append('\"');
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, jArr, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, iArr, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, sArr, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // k.b.a.a.g.c
        public void appendDetail(StringBuffer stringBuffer, String str, Map<?, ?> map) {
            if (map != null && !map.isEmpty()) {
                stringBuffer.append(getContentStart());
                boolean z = true;
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    String string = Objects.toString(entry.getKey(), null);
                    if (string != null) {
                        if (z) {
                            z = false;
                        } else {
                            appendFieldEnd(stringBuffer, string);
                        }
                        appendFieldStart(stringBuffer, string);
                        Object value = entry.getValue();
                        if (value == null) {
                            appendNullText(stringBuffer, string);
                        } else {
                            appendInternal(stringBuffer, string, value, true);
                        }
                    }
                }
                stringBuffer.append(getContentEnd());
                return;
            }
            stringBuffer.append(map);
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, bArr, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, cArr, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, dArr, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, fArr, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, zArr, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // k.b.a.a.g.c
        public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
            if (str != null) {
                if (isFullDetail(bool)) {
                    super.append(stringBuffer, str, obj, bool);
                    return;
                }
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            stringBuffer.append(collection);
            return;
        }
        stringBuffer.append(this.arrayStart);
        int i2 = 0;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            appendDetail(stringBuffer, str, i2, it.next());
            i2++;
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, Object[] objArr) {
        appendSummarySize(stringBuffer, str, objArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, long j2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, j2);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, long[] jArr) {
        appendSummarySize(stringBuffer, str, jArr.length);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, int[] iArr) {
        appendSummarySize(stringBuffer, str, iArr.length);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, short[] sArr) {
        appendSummarySize(stringBuffer, str, sArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, int i2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, i2);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, byte[] bArr) {
        appendSummarySize(stringBuffer, str, bArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, long j2) {
        stringBuffer.append(j2);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, char[] cArr) {
        appendSummarySize(stringBuffer, str, cArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, int i2) {
        stringBuffer.append(i2);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, double[] dArr) {
        appendSummarySize(stringBuffer, str, dArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, short s) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, s);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append((int) s);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, float[] fArr) {
        appendSummarySize(stringBuffer, str, fArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, byte b2) {
        stringBuffer.append((int) b2);
    }

    public void appendSummary(StringBuffer stringBuffer, String str, boolean[] zArr) {
        appendSummarySize(stringBuffer, str, zArr.length);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, char c2) {
        stringBuffer.append(c2);
    }

    public void append(StringBuffer stringBuffer, String str, byte b2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, b2);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, double d2) {
        stringBuffer.append(d2);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, float f2) {
        stringBuffer.append(f2);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, boolean z) {
        stringBuffer.append(z);
    }

    public void append(StringBuffer stringBuffer, String str, char c2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, c2);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            appendDetail(stringBuffer, str, i2, objArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, double d2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, d2);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, int i2, Object obj) {
        if (i2 > 0) {
            stringBuffer.append(this.arraySeparator);
        }
        if (obj == null) {
            appendNullText(stringBuffer, str);
        } else {
            appendInternal(stringBuffer, str, obj, this.arrayContentDetail);
        }
    }

    public void append(StringBuffer stringBuffer, String str, float f2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, f2);
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, jArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, boolean z) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, z);
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (objArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, objArr);
        } else {
            appendSummary(stringBuffer, str, objArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, iArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (jArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, jArr);
        } else {
            appendSummary(stringBuffer, str, jArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < sArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, sArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, bArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (iArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, iArr);
        } else {
            appendSummary(stringBuffer, str, iArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, cArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (sArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, sArr);
        } else {
            appendSummary(stringBuffer, str, sArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, dArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (bArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, bArr);
        } else {
            appendSummary(stringBuffer, str, bArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, fArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (cArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, cArr);
        } else {
            appendSummary(stringBuffer, str, cArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < zArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, zArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (dArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, dArr);
        } else {
            appendSummary(stringBuffer, str, dArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (fArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, fArr);
        } else {
            appendSummary(stringBuffer, str, fArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (zArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, zArr);
        } else {
            appendSummary(stringBuffer, str, zArr);
        }
        appendFieldEnd(stringBuffer, str);
    }
}
