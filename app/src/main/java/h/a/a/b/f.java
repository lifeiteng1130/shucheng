package h.a.a.b;

import com.bytedance.pangle.servermanager.AbsServerManager;
import h.a.a.a.m;
import h.a.a.a.p;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.jsoup.helper.DataUtil;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: EpubWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public c a;

    public f() {
        int i2 = c.a;
        this.a = a.f6316b;
    }

    public void a(h.a.a.a.d dVar, OutputStream outputStream) throws IOException {
        c cVar = this.a;
        if (cVar != null) {
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        ZipEntry zipEntry = new ZipEntry("mimetype");
        zipEntry.setMethod(0);
        byte[] bytes = m.f6305b.getName().getBytes();
        zipEntry.setSize(bytes.length);
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        zipEntry.setCrc(crc32.getValue());
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(bytes);
        zipOutputStream.putNextEntry(new ZipEntry("META-INF/container.xml"));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(zipOutputStream);
        outputStreamWriter.write("<?xml version=\"1.0\"?>\n");
        outputStreamWriter.write("<container version=\"1.0\" xmlns=\"urn:oasis:names:tc:opendocument:xmlns:container\">\n");
        outputStreamWriter.write("\t<rootfiles>\n");
        outputStreamWriter.write("\t\t<rootfile full-path=\"OEBPS/content.opf\" media-type=\"application/oebps-package+xml\"/>\n");
        outputStreamWriter.write("\t</rootfiles>\n");
        outputStreamWriter.write("</container>");
        outputStreamWriter.flush();
        try {
            p pVarA = dVar.isEpub3() ? h.a(dVar) : g.a(dVar);
            p tocResource = dVar.getSpine().getTocResource();
            if (tocResource != null) {
                dVar.getResources().remove(tocResource.getHref());
            }
            dVar.getSpine().setTocResource(pVarA);
            dVar.getResources().add(pVarA);
        } catch (Exception e2) {
            e2.getClass().getName();
            e2.getMessage();
        }
        for (p pVar : dVar.getResources().getAll()) {
            if (pVar != null) {
                try {
                    zipOutputStream.putNextEntry(new ZipEntry("OEBPS/" + pVar.getHref()));
                    InputStream inputStream = pVar.getInputStream();
                    h.a.a.c.a.a(inputStream, zipOutputStream);
                    inputStream.close();
                } catch (Exception e3) {
                    e3.getMessage();
                }
            }
        }
        zipOutputStream.putNextEntry(new ZipEntry("OEBPS/content.opf"));
        XmlSerializer xmlSerializerA = d.a(zipOutputStream);
        int i2 = l.a;
        try {
            xmlSerializerA.startDocument(DataUtil.defaultCharset, Boolean.FALSE);
            xmlSerializerA.setPrefix("", "http://www.idpf.org/2007/opf");
            xmlSerializerA.setPrefix("dc", "http://purl.org/dc/elements/1.1/");
            xmlSerializerA.startTag("http://www.idpf.org/2007/opf", AbsServerManager.PACKAGE_QUERY_BINDER);
            xmlSerializerA.attribute("", "version", dVar.getVersion());
            xmlSerializerA.attribute("", "unique-identifier", "BookId");
            c.b.a.m.f.h6(dVar, xmlSerializerA);
            l.c(dVar, this, xmlSerializerA);
            l.d(dVar, xmlSerializerA);
            l.a(dVar, this, xmlSerializerA);
            xmlSerializerA.endTag("http://www.idpf.org/2007/opf", AbsServerManager.PACKAGE_QUERY_BINDER);
            xmlSerializerA.endDocument();
            xmlSerializerA.flush();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        xmlSerializerA.flush();
        zipOutputStream.close();
    }
}
