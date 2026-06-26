package c.c.a.i$b;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class a implements XmlResourceParser {
    public b a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f742d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f750l;
    public int m;
    public int n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f740b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0032a f743e = new C0032a();

    /* JADX INFO: renamed from: c.c.a.i$b.a$a, reason: collision with other inner class name */
    public static final class C0032a {
        public int[] a = new int[32];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f752c;

        public final int a(int i2) {
            int i3 = this.f751b;
            if (i3 == 0) {
                return -1;
            }
            int i4 = i3 - 1;
            for (int i5 = this.f752c; i5 != 0; i5--) {
                i4 -= 2;
                for (int i6 = this.a[i4]; i6 != 0; i6--) {
                    int[] iArr = this.a;
                    if (iArr[i4 + 1] == i2) {
                        return iArr[i4];
                    }
                    i4 -= 2;
                }
            }
            return -1;
        }

        public final int b(int i2, boolean z) {
            if (this.f751b != 0 && i2 >= 0) {
                int iB = 0;
                for (int i3 = this.f752c; i3 != 0; i3--) {
                    int[] iArr = this.a;
                    int i4 = iArr[iB];
                    if (i2 < i4) {
                        int iB2 = c.a.a.a.a.b(i2, 2, 1, iB);
                        if (!z) {
                            iB2++;
                        }
                        return iArr[iB2];
                    }
                    i2 -= i4;
                    iB = c.a.a.a.a.b(i4, 2, 2, iB);
                }
            }
            return -1;
        }

        public final void c() {
            d();
            int i2 = this.f751b;
            int[] iArr = this.a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.f751b = i2 + 2;
            this.f752c++;
        }

        public final void d() {
            int[] iArr = this.a;
            int length = iArr.length;
            int i2 = this.f751b;
            int i3 = length - i2;
            if (i3 <= 2) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.a = iArr2;
            }
        }
    }

    public a() {
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        return r0 / 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            c.c.a.i$b.d r0 = r5.f741c
            r1 = -1
            if (r0 == 0) goto L31
            if (r7 == 0) goto L31
            int r7 = r0.a(r7)
            if (r7 != r1) goto Le
            return r1
        Le:
            if (r6 == 0) goto L17
            c.c.a.i$b.d r0 = r5.f741c
            int r6 = r0.a(r6)
            goto L18
        L17:
            r6 = -1
        L18:
            r0 = 0
        L19:
            int[] r2 = r5.f749k
            int r3 = r2.length
            if (r0 == r3) goto L31
            int r3 = r0 + 1
            r4 = r2[r3]
            if (r7 != r4) goto L2f
            if (r6 == r1) goto L2c
            int r4 = r0 + 0
            r2 = r2[r4]
            if (r6 != r2) goto L2f
        L2c:
            int r0 = r0 / 5
            return r0
        L2f:
            r0 = r3
            goto L19
        L31:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.i$b.a.a(java.lang.String, java.lang.String):int");
    }

    public final void b() {
        this.f745g = -1;
        this.f746h = -1;
        this.f747i = -1;
        this.f748j = -1;
        this.f749k = null;
        this.f750l = -1;
        this.m = -1;
        this.n = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0122, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r4 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0250, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r8 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.i$b.a.c():void");
    }

    @Override // android.content.res.XmlResourceParser, java.lang.AutoCloseable
    public final void close() {
        if (this.f740b) {
            this.f740b = false;
            b bVar = this.a;
            InputStream inputStream = bVar.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a = null;
                bVar.f753b = 0;
            }
            this.a = null;
            this.f741c = null;
            this.f742d = null;
            C0032a c0032a = this.f743e;
            c0032a.f751b = 0;
            c0032a.f752c = 0;
            b();
        }
    }

    public final int d(int i2) {
        if (this.f745g != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.f749k.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // android.util.AttributeSet
    public final boolean getAttributeBooleanValue(int i2, boolean z) {
        return getAttributeIntValue(i2, z ? 1 : 0) != 0;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final int getAttributeCount() {
        if (this.f745g != 2) {
            return -1;
        }
        return this.f749k.length / 5;
    }

    @Override // android.util.AttributeSet
    public final float getAttributeFloatValue(int i2, float f2) {
        int iD = d(i2);
        int[] iArr = this.f749k;
        return iArr[iD + 3] == 4 ? Float.intBitsToFloat(iArr[iD + 4]) : f2;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeIntValue(int i2, int i3) {
        int iD = d(i2);
        int[] iArr = this.f749k;
        int i4 = iArr[iD + 3];
        return (i4 < 16 || i4 > 31) ? i3 : iArr[iD + 4];
    }

    @Override // android.util.AttributeSet
    public final int getAttributeListValue(int i2, String[] strArr, int i3) {
        return 0;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeListValue(String str, String str2, String[] strArr, int i2) {
        return 0;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeName(int i2) {
        int i3 = this.f749k[d(i2) + 1];
        return i3 == -1 ? "" : this.f741c.c(i3);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeNameResource(int i2) {
        int i3 = this.f749k[d(i2) + 1];
        int[] iArr = this.f742d;
        if (iArr == null || i3 < 0 || i3 >= iArr.length) {
            return 0;
        }
        return iArr[i3];
    }

    @Override // android.content.res.XmlResourceParser, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeNamespace(int i2) {
        int i3 = this.f749k[d(i2) + 0];
        return i3 == -1 ? "" : this.f741c.c(i3);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributePrefix(int i2) {
        int iA = this.f743e.a(this.f749k[d(i2) + 0]);
        return iA == -1 ? "" : this.f741c.c(iA);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeResourceValue(int i2, int i3) {
        int iD = d(i2);
        int[] iArr = this.f749k;
        return iArr[iD + 3] == 1 ? iArr[iD + 4] : i3;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributeType(int i2) {
        return "CDATA";
    }

    @Override // android.util.AttributeSet
    public final int getAttributeUnsignedIntValue(int i2, int i3) {
        return getAttributeIntValue(i2, i3);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeValue(int i2) {
        int iD = d(i2);
        int[] iArr = this.f749k;
        if (iArr[iD + 3] != 3) {
            return "";
        }
        return this.f741c.c(iArr[iD + 2]);
    }

    @Override // android.util.AttributeSet
    public final String getClassAttribute() {
        int i2 = this.m;
        if (i2 == -1) {
            return null;
        }
        return this.f741c.c(this.f749k[d(i2) + 2]);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getColumnNumber() {
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getDepth() {
        return this.f743e.f752c - 1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getEventType() {
        return this.f745g;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean getFeature(String str) {
        return false;
    }

    @Override // android.util.AttributeSet
    public final String getIdAttribute() {
        int i2 = this.f750l;
        if (i2 == -1) {
            return null;
        }
        return this.f741c.c(this.f749k[d(i2) + 2]);
    }

    @Override // android.util.AttributeSet
    public final int getIdAttributeResourceValue(int i2) {
        int i3 = this.f750l;
        if (i3 == -1) {
            return i2;
        }
        int iD = d(i3);
        int[] iArr = this.f749k;
        return iArr[iD + 3] != 1 ? i2 : iArr[iD + 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getInputEncoding() {
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getLineNumber() {
        return this.f746h;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getName() {
        int i2 = this.f747i;
        if (i2 == -1) {
            return null;
        }
        int i3 = this.f745g;
        if (i3 == 2 || i3 == 3) {
            return this.f741c.c(i2);
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespace() {
        return this.f741c.c(this.f748j);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getNamespaceCount(int i2) {
        C0032a c0032a = this.f743e;
        int i3 = 0;
        if (c0032a.f751b != 0 && i2 >= 0) {
            int i4 = c0032a.f752c;
            if (i2 > i4) {
                i2 = i4;
            }
            int iB = 0;
            while (i2 != 0) {
                int i5 = c0032a.a[iB];
                i3 += i5;
                iB = c.a.a.a.a.b(i5, 2, 2, iB);
                i2--;
            }
        }
        return i3;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespacePrefix(int i2) {
        return this.f741c.c(this.f743e.b(i2, true));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespaceUri(int i2) {
        return this.f741c.c(this.f743e.b(i2, false));
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getPositionDescription() {
        return "XML line #" + this.f746h;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getPrefix() {
        return this.f741c.c(this.f743e.a(this.f748j));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final Object getProperty(String str) {
        return null;
    }

    @Override // android.util.AttributeSet
    public final int getStyleAttribute() {
        int i2 = this.n;
        if (i2 == -1) {
            return 0;
        }
        return this.f749k[d(i2) + 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getText() {
        int i2 = this.f747i;
        if (i2 == -1 || this.f745g != 4) {
            return null;
        }
        return this.f741c.c(i2);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            return null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isAttributeDefault(int i2) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isEmptyElementTag() {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isWhitespace() {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int next() throws XmlPullParserException, IOException {
        if (this.a == null) {
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
        try {
            c();
            return this.f745g;
        } catch (IOException e2) {
            close();
            throw e2;
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int nextTag() throws XmlPullParserException, IOException {
        int next = next();
        if (next == 2 || next == 3) {
            return next;
        }
        throw new XmlPullParserException("Expected start or end tag.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String nextText() throws XmlPullParserException, IOException {
        if (this.f745g != 2) {
            throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
        }
        int next = next();
        if (next != 4) {
            if (next == 3) {
                return "";
            }
            throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
        }
        String text = getText();
        if (next() == 3) {
            return text;
        }
        throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int nextToken() {
        return next();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void require(int i2, String str, String str2) throws XmlPullParserException {
        if (i2 != this.f745g || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException(c.a.a.a.a.p(new StringBuilder(), XmlResourceParser.TYPES[i2], " is expected."), this, null);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setFeature(String str, boolean z) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setProperty(String str, Object obj) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // android.util.AttributeSet
    public final boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int iA = a(str, str2);
        return iA == -1 ? z : getAttributeBooleanValue(iA, z);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeUnsignedIntValue(String str, String str2, int i2) {
        int iA = a(str, str2);
        return iA == -1 ? i2 : getAttributeIntValue(iA, i2);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespace(String str) {
        throw new RuntimeException("Method is not supported.");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setInput(Reader reader) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // android.util.AttributeSet
    public final int getAttributeIntValue(String str, String str2, int i2) {
        int iA = a(str, str2);
        return iA == -1 ? i2 : getAttributeIntValue(iA, i2);
    }

    @Override // android.util.AttributeSet
    public final int getAttributeResourceValue(String str, String str2, int i2) {
        int iA = a(str, str2);
        return iA == -1 ? i2 : getAttributeResourceValue(iA, i2);
    }

    @Override // android.util.AttributeSet
    public final float getAttributeFloatValue(String str, String str2, float f2) {
        int iA = a(str, str2);
        return iA == -1 ? f2 : getAttributeFloatValue(iA, f2);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeValue(String str, String str2) {
        int iA = a(str, str2);
        if (iA == -1) {
            return null;
        }
        return getAttributeValue(iA);
    }
}
