package h.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: Resource.java */
/* JADX INFO: loaded from: classes3.dex */
public class p implements Serializable {
    private static final long serialVersionUID = 1043946707835004037L;
    public byte[] data;
    private String href;
    private String id;
    private String inputEncoding;
    private l mediaType;
    public final String originalHref;
    private String properties;
    private String title;

    public p(String str) {
        this(null, new byte[0], str, m.a(str));
    }

    public void close() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.href.equals(((p) obj).getHref());
        }
        return false;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getHref() {
        return this.href;
    }

    public String getId() {
        return this.id;
    }

    public String getInputEncoding() {
        return this.inputEncoding;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(getData());
    }

    public l getMediaType() {
        return this.mediaType;
    }

    public String getProperties() {
        return this.properties;
    }

    public Reader getReader() {
        return new h.a.a.c.b.a.e(new ByteArrayInputStream(getData()), getInputEncoding());
    }

    public long getSize() {
        return this.data.length;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.href.hashCode();
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInputEncoding(String str) {
        this.inputEncoding = str;
    }

    public void setMediaType(l lVar) {
        this.mediaType = lVar;
    }

    public void setProperties(String str) {
        this.properties = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        Object[] objArr = new Object[12];
        objArr[0] = "id";
        objArr[1] = this.id;
        objArr[2] = "title";
        objArr[3] = this.title;
        objArr[4] = "encoding";
        objArr[5] = this.inputEncoding;
        objArr[6] = "mediaType";
        objArr[7] = this.mediaType;
        objArr[8] = "href";
        objArr[9] = this.href;
        objArr[10] = "size";
        byte[] bArr = this.data;
        objArr[11] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        StringBuilder sbQ = c.a.a.a.a.q('[');
        for (int i2 = 0; i2 < 12; i2 += 2) {
            if (i2 > 0) {
                sbQ.append(", ");
            }
            sbQ.append(objArr[i2]);
            sbQ.append(": ");
            int i3 = i2 + 1;
            Object obj = i3 < 12 ? objArr[i3] : null;
            if (obj == null) {
                sbQ.append("<null>");
            } else {
                sbQ.append('\'');
                sbQ.append(obj);
                sbQ.append('\'');
            }
        }
        sbQ.append(']');
        return sbQ.toString();
    }

    public p(byte[] bArr, l lVar) {
        this(null, bArr, null, lVar);
    }

    public p(Reader reader, String str) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        while (true) {
            int i2 = reader.read(cArr);
            if (-1 != i2) {
                stringWriter.write(cArr, 0, i2);
            } else {
                stringWriter.flush();
                this(null, stringWriter.toString().getBytes(DataUtil.defaultCharset), str, m.a(str), DataUtil.defaultCharset);
                return;
            }
        }
    }

    public p(byte[] bArr, String str) {
        this(null, bArr, str, m.a(str), DataUtil.defaultCharset);
    }

    public p(InputStream inputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        h.a.a.c.a.a(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        this(null, byteArrayOutputStream.toByteArray(), str, m.a(str));
    }

    public p(String str, byte[] bArr, String str2, l lVar) {
        this(str, bArr, str2, lVar, DataUtil.defaultCharset);
    }

    public p(String str, byte[] bArr, String str2, l lVar, String str3) {
        this.id = str;
        this.href = str2;
        this.originalHref = str2;
        this.mediaType = lVar;
        this.inputEncoding = str3;
        this.data = bArr;
    }
}
