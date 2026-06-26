package c.d.a.a.a.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/* JADX INFO: compiled from: BasicDictionary.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public Map<Character, Character> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.d.a.a.a.a<String> f818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f819c;

    public a(Map<Character, Character> map, c.d.a.a.a.a<String> aVar, int i2) {
        this.a = null;
        this.f818b = null;
        this.f819c = 2;
        this.a = map;
        this.f818b = aVar;
        this.f819c = i2;
    }

    public String a(String str) {
        StringReader stringReader = new StringReader(str);
        StringWriter stringWriter = new StringWriter();
        try {
            b(stringReader, stringWriter);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return stringWriter.toString();
    }

    public void b(Reader reader, Writer writer) throws IOException {
        PushbackReader pushbackReader = new PushbackReader(new BufferedReader(reader), this.f819c);
        char[] cArr = new char[this.f819c];
        while (true) {
            int i2 = pushbackReader.read(cArr);
            if (i2 == -1) {
                return;
            }
            c.d.a.a.a.b<String> bVar = this.f818b.a;
            c.d.a.a.a.b<String> bVar2 = null;
            for (int i3 = 0; i3 < i2; i3++) {
                bVar = bVar.f815c.get(Character.valueOf(cArr[i3]));
                if (bVar == null) {
                    break;
                }
                if (bVar.f816d) {
                    bVar2 = bVar;
                }
            }
            if (bVar2 != null) {
                int i4 = bVar2.a;
                writer.write(bVar2.f817e);
                pushbackReader.unread(cArr, i4, i2 - i4);
            } else {
                pushbackReader.unread(cArr, 0, i2);
                char cCharValue = (char) pushbackReader.read();
                Character ch = this.a.get(Character.valueOf(cCharValue));
                if (ch != null) {
                    cCharValue = ch.charValue();
                }
                writer.write(cCharValue);
            }
        }
    }
}
