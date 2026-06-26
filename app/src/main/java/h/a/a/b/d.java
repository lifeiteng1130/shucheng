package h.a.a.b;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jsoup.helper.DataUtil;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: EpubProcessorSupport.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static DocumentBuilderFactory a;

    /* JADX INFO: compiled from: EpubProcessorSupport.java */
    public static class a implements EntityResolver {
        public String a;

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            String string;
            if (str2.startsWith("http:")) {
                URL url = new URL(str2);
                StringBuilder sbR = c.a.a.a.a.r("dtd/");
                sbR.append(url.getHost());
                sbR.append(url.getPath());
                string = sbR.toString();
                this.a = string.substring(0, string.lastIndexOf(47));
            } else {
                string = this.a + str2.substring(str2.lastIndexOf(47));
            }
            ClassLoader classLoader = a.class.getClassLoader();
            Objects.requireNonNull(classLoader);
            if (classLoader.getResource(string) == null) {
                throw new RuntimeException(c.a.a.a.a.k("remote resource is not cached : [", str2, "] cannot continue"));
            }
            ClassLoader classLoader2 = d.class.getClassLoader();
            Objects.requireNonNull(classLoader2);
            return new InputSource(classLoader2.getResourceAsStream(string));
        }
    }

    static {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        a = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        a.setValidating(false);
    }

    public static XmlSerializer a(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, DataUtil.defaultCharset);
        XmlSerializer xmlSerializerNewSerializer = null;
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setValidating(true);
            xmlSerializerNewSerializer = xmlPullParserFactoryNewInstance.newSerializer();
            xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            xmlSerializerNewSerializer.setOutput(outputStreamWriter);
            return xmlSerializerNewSerializer;
        } catch (Exception e2) {
            e2.getClass().getName();
            e2.getMessage();
            return xmlSerializerNewSerializer;
        }
    }
}
