package d.a.a;

import com.efs.sdk.base.Constants;
import com.tencent.bugly.beta.tinker.TinkerReport;
import j$.lang.Iterable;
import j$.util.DesugarTimeZone;
import j$.util.Map;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: compiled from: NanoHTTPD.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final String MIME_HTML = "text/html";
    public static final String MIME_PLAINTEXT = "text/plain";
    public static Map<String, String> MIME_TYPES = null;
    private static final String QUERY_STRING_PARAMETER = "NanoHttpd.QUERY_STRING";
    public static final int SOCKET_READ_TIMEOUT = 5000;
    public b asyncRunner;
    private final String hostname;
    private final int myPort;
    private volatile ServerSocket myServerSocket;
    private Thread myThread;
    private s serverSocketFactory;
    private v tempFileManagerFactory;
    private static final String CONTENT_DISPOSITION_REGEX = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";
    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile(CONTENT_DISPOSITION_REGEX, 2);
    private static final String CONTENT_TYPE_REGEX = "([ |\t]*content-type[ |\t]*:)(.*)";
    private static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile(CONTENT_TYPE_REGEX, 2);
    private static final String CONTENT_DISPOSITION_ATTRIBUTE_REGEX = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]";
    private static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = Pattern.compile(CONTENT_DISPOSITION_ATTRIBUTE_REGEX);
    private static final Logger LOG = Logger.getLogger(a.class.getName());

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public interface b {
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public class c implements Runnable {
        public final InputStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Socket f5451b;

        public c(InputStream inputStream, Socket socket) {
            this.a = inputStream;
            this.f5451b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = this.f5451b.getOutputStream();
                    Objects.requireNonNull((k) a.this.tempFileManagerFactory);
                    l lVar = a.this.new l(new j(), this.a, outputStream, this.f5451b.getInetAddress());
                    while (!this.f5451b.isClosed()) {
                        lVar.d();
                    }
                    a.safeClose(outputStream);
                    a.safeClose(this.a);
                    a.safeClose(this.f5451b);
                    bVar = a.this.asyncRunner;
                } catch (Exception e2) {
                    if ((!(e2 instanceof SocketException) || !"NanoHttpd Shutdown".equals(e2.getMessage())) && !(e2 instanceof SocketTimeoutException)) {
                        a.LOG.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e2);
                    }
                    a.safeClose(outputStream);
                    a.safeClose(this.a);
                    a.safeClose(this.f5451b);
                    bVar = a.this.asyncRunner;
                }
                ((g) bVar).f5460b.remove(this);
            } catch (Throwable th) {
                a.safeClose(outputStream);
                a.safeClose(this.a);
                a.safeClose(this.f5451b);
                ((g) a.this.asyncRunner).f5460b.remove(this);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static class d {
        public static final Pattern a = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Pattern f5453b = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Pattern f5454c = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f5455d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f5456e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f5457f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f5458g;

        public d(String str) {
            this.f5455d = str;
            if (str != null) {
                this.f5456e = a(str, a, "", 1);
                this.f5457f = a(str, f5453b, null, 2);
            } else {
                this.f5456e = "";
                this.f5457f = DataUtil.defaultCharset;
            }
            if (HttpConnection.MULTIPART_FORM_DATA.equalsIgnoreCase(this.f5456e)) {
                this.f5458g = a(str, f5454c, null, 2);
            } else {
                this.f5458g = null;
            }
        }

        public final String a(String str, Pattern pattern, String str2, int i2) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(i2) : str2;
        }

        public String b() {
            String str = this.f5457f;
            return str == null ? "US-ASCII" : str;
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static class e {
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public class f implements Iterable<String>, Iterable {
        public final HashMap<String, String> a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f5459b = new ArrayList<>();

        public f(a aVar, Map<String, String> map) {
            String str = map.get("cookie");
            if (str != null) {
                for (String str2 : str.split(";")) {
                    String[] strArrSplit = str2.trim().split("=");
                    if (strArrSplit.length == 2) {
                        this.a.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
            }
        }

        public void a(o oVar) {
            Iterator<e> it = this.f5459b.iterator();
            while (it.hasNext()) {
                Objects.requireNonNull(it.next());
                oVar.f5477e.put("Set-Cookie", String.format("%s=%s; expires=%s", null, null, null));
            }
        }

        @Override // j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator<String> iterator() {
            return this.a.keySet().iterator();
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return j$.util.v.o(iterator(), 0);
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static class g implements b {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f5460b = Collections.synchronizedList(new ArrayList());

        public void a(c cVar) {
            this.a++;
            Thread thread = new Thread(cVar);
            thread.setDaemon(true);
            StringBuilder sbR = c.a.a.a.a.r("NanoHttpd Request Processor (#");
            sbR.append(this.a);
            sbR.append(")");
            thread.setName(sbR.toString());
            this.f5460b.add(cVar);
            thread.start();
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static class h implements s {
        @Override // d.a.a.a.s
        public ServerSocket a() {
            return new ServerSocket();
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static class i implements t {
        public final File a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OutputStream f5461b;

        public i(File file) throws IOException {
            File fileCreateTempFile = File.createTempFile("NanoHTTPD-", "", file);
            this.a = fileCreateTempFile;
            this.f5461b = new FileOutputStream(fileCreateTempFile);
        }

        @Override // d.a.a.a.t
        public void a() throws Exception {
            a.safeClose(this.f5461b);
            if (this.a.delete()) {
                return;
            }
            StringBuilder sbR = c.a.a.a.a.r("could not delete temporary file: ");
            sbR.append(this.a.getAbsolutePath());
            throw new Exception(sbR.toString());
        }

        public String b() {
            return this.a.getAbsolutePath();
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static class j implements u {
        public final File a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<t> f5462b;

        public j() {
            File file = new File(System.getProperty("java.io.tmpdir"));
            this.a = file;
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f5462b = new ArrayList();
        }

        public void a() {
            Iterator<t> it = this.f5462b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a();
                } catch (Exception e2) {
                    a.LOG.log(Level.WARNING, "could not delete file ", (Throwable) e2);
                }
            }
            this.f5462b.clear();
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public class k implements v {
        public k(a aVar, C0141a c0141a) {
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public class l implements m {
        public final u a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OutputStream f5463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BufferedInputStream f5464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5466e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f5467f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public n f5468g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map<String, List<String>> f5469h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f5470i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public f f5471j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f5472k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f5473l;
        public String m;

        public l(u uVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            this.a = uVar;
            this.f5464c = new BufferedInputStream(inputStream, 8192);
            this.f5463b = outputStream;
            this.f5473l = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            if (!inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress()) {
                inetAddress.getHostName().toString();
            }
            this.f5470i = new HashMap();
        }

        public final void a(BufferedReader bufferedReader, Map<String, String> map, Map<String, List<String>> map2, Map<String, String> map3) throws p {
            String strDecodePercent;
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(line);
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new p(o.d.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
                map.put("method", stringTokenizer.nextToken());
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new p(o.d.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(63);
                if (iIndexOf >= 0) {
                    c(strNextToken.substring(iIndexOf + 1), map2);
                    strDecodePercent = a.decodePercent(strNextToken.substring(0, iIndexOf));
                } else {
                    strDecodePercent = a.decodePercent(strNextToken);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    this.m = stringTokenizer.nextToken();
                } else {
                    this.m = "HTTP/1.1";
                    a.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                }
                String line2 = bufferedReader.readLine();
                while (line2 != null && !line2.trim().isEmpty()) {
                    int iIndexOf2 = line2.indexOf(58);
                    if (iIndexOf2 >= 0) {
                        map3.put(line2.substring(0, iIndexOf2).trim().toLowerCase(Locale.US), line2.substring(iIndexOf2 + 1).trim());
                    }
                    line2 = bufferedReader.readLine();
                }
                map.put("uri", strDecodePercent);
            } catch (IOException e2) {
                o.d dVar = o.d.INTERNAL_ERROR;
                StringBuilder sbR = c.a.a.a.a.r("SERVER INTERNAL ERROR: IOException: ");
                sbR.append(e2.getMessage());
                throw new p(dVar, sbR.toString(), e2);
            }
        }

        public final void b(d dVar, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) throws Throwable {
            byte b2;
            String strGroup;
            d dVar2 = dVar;
            try {
                int[] iArrF = f(byteBuffer, dVar2.f5458g.getBytes());
                int i2 = 2;
                if (iArrF.length < 2) {
                    throw new p(o.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
                }
                int i3 = 1024;
                byte[] bArr = new byte[1024];
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i5 < iArrF.length - 1) {
                    byteBuffer.position(iArrF[i5]);
                    int iRemaining = byteBuffer.remaining() < i3 ? byteBuffer.remaining() : 1024;
                    byteBuffer.get(bArr, i4, iRemaining);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i4, iRemaining), Charset.forName(dVar.b())), iRemaining);
                    String line = bufferedReader.readLine();
                    if (line == null || !line.contains(dVar2.f5458g)) {
                        throw new p(o.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                    }
                    String line2 = bufferedReader.readLine();
                    String str = null;
                    String strTrim = null;
                    int i7 = i6;
                    int i8 = 2;
                    String strGroup2 = null;
                    while (line2 != null && line2.trim().length() > 0) {
                        Matcher matcher = a.CONTENT_DISPOSITION_PATTERN.matcher(line2);
                        if (matcher.matches()) {
                            Matcher matcher2 = a.CONTENT_DISPOSITION_ATTRIBUTE_PATTERN.matcher(matcher.group(i2));
                            while (matcher2.find()) {
                                String strGroup3 = matcher2.group(1);
                                if ("name".equalsIgnoreCase(strGroup3)) {
                                    strGroup = matcher2.group(2);
                                } else if ("filename".equalsIgnoreCase(strGroup3)) {
                                    strGroup2 = matcher2.group(2);
                                    if (!strGroup2.isEmpty()) {
                                        if (i7 > 0) {
                                            strGroup = str + String.valueOf(i7);
                                            i7++;
                                        } else {
                                            i7++;
                                        }
                                    }
                                }
                                str = strGroup;
                            }
                        }
                        Matcher matcher3 = a.CONTENT_TYPE_PATTERN.matcher(line2);
                        if (matcher3.matches()) {
                            strTrim = matcher3.group(2).trim();
                        }
                        line2 = bufferedReader.readLine();
                        i8++;
                        i2 = 2;
                    }
                    int i9 = 0;
                    while (true) {
                        int i10 = i8 - 1;
                        if (i8 <= 0) {
                            break;
                        }
                        do {
                            b2 = bArr[i9];
                            i9++;
                        } while (b2 != 10);
                        i8 = i10;
                    }
                    if (i9 >= iRemaining - 4) {
                        throw new p(o.d.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                    }
                    int i11 = iArrF[i5] + i9;
                    i5++;
                    int i12 = iArrF[i5] - 4;
                    byteBuffer.position(i11);
                    List<String> arrayList = map.get(str);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        map.put(str, arrayList);
                    }
                    if (strTrim == null) {
                        byte[] bArr2 = new byte[i12 - i11];
                        byteBuffer.get(bArr2);
                        arrayList.add(new String(bArr2, dVar.b()));
                    } else {
                        String strH = h(byteBuffer, i11, i12 - i11, strGroup2);
                        if (map2.containsKey(str)) {
                            int i13 = 2;
                            while (true) {
                                if (!map2.containsKey(str + i13)) {
                                    break;
                                } else {
                                    i13++;
                                }
                            }
                            map2.put(str + i13, strH);
                        } else {
                            map2.put(str, strH);
                        }
                        arrayList.add(strGroup2);
                    }
                    dVar2 = dVar;
                    i6 = i7;
                    i3 = 1024;
                    i2 = 2;
                    i4 = 0;
                }
            } catch (p e2) {
                throw e2;
            } catch (Exception e3) {
                throw new p(o.d.INTERNAL_ERROR, e3.toString());
            }
        }

        public final void c(String str, Map<String, List<String>> map) {
            String strTrim;
            String strDecodePercent;
            if (str == null) {
                this.f5472k = "";
                return;
            }
            this.f5472k = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf >= 0) {
                    strTrim = a.decodePercent(strNextToken.substring(0, iIndexOf)).trim();
                    strDecodePercent = a.decodePercent(strNextToken.substring(iIndexOf + 1));
                } else {
                    strTrim = a.decodePercent(strNextToken).trim();
                    strDecodePercent = "";
                }
                List<String> arrayList = map.get(strTrim);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    map.put(strTrim, arrayList);
                }
                arrayList.add(strDecodePercent);
            }
        }

        public void d() {
            byte[] bArr;
            boolean z;
            o oVarServe = null;
            try {
                try {
                    try {
                        try {
                            try {
                                bArr = new byte[8192];
                                z = false;
                                this.f5465d = 0;
                                this.f5466e = 0;
                                this.f5464c.mark(8192);
                            } catch (SocketTimeoutException e2) {
                                throw e2;
                            }
                        } catch (p e3) {
                            a.newFixedLengthResponse(e3.getStatus(), a.MIME_PLAINTEXT, e3.getMessage()).c(this.f5463b);
                            a.safeClose(this.f5463b);
                        }
                    } catch (SSLException e4) {
                        a.newFixedLengthResponse(o.d.INTERNAL_ERROR, a.MIME_PLAINTEXT, "SSL PROTOCOL FAILURE: " + e4.getMessage()).c(this.f5463b);
                        a.safeClose(this.f5463b);
                    }
                } catch (SocketException e5) {
                    throw e5;
                } catch (IOException e6) {
                    a.newFixedLengthResponse(o.d.INTERNAL_ERROR, a.MIME_PLAINTEXT, "SERVER INTERNAL ERROR: IOException: " + e6.getMessage()).c(this.f5463b);
                    a.safeClose(this.f5463b);
                }
                try {
                    int i2 = this.f5464c.read(bArr, 0, 8192);
                    if (i2 == -1) {
                        a.safeClose(this.f5464c);
                        a.safeClose(this.f5463b);
                        throw new SocketException("NanoHttpd Shutdown");
                    }
                    while (i2 > 0) {
                        int i3 = this.f5466e + i2;
                        this.f5466e = i3;
                        int iE = e(bArr, i3);
                        this.f5465d = iE;
                        if (iE > 0) {
                            break;
                        }
                        BufferedInputStream bufferedInputStream = this.f5464c;
                        int i4 = this.f5466e;
                        i2 = bufferedInputStream.read(bArr, i4, 8192 - i4);
                    }
                    if (this.f5465d < this.f5466e) {
                        this.f5464c.reset();
                        this.f5464c.skip(this.f5465d);
                    }
                    this.f5469h = new HashMap();
                    Map<String, String> map = this.f5470i;
                    if (map == null) {
                        this.f5470i = new HashMap();
                    } else {
                        map.clear();
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f5466e)));
                    HashMap map2 = new HashMap();
                    a(bufferedReader, map2, this.f5469h, this.f5470i);
                    String str = this.f5473l;
                    if (str != null) {
                        this.f5470i.put("remote-addr", str);
                        this.f5470i.put("http-client-ip", this.f5473l);
                    }
                    n nVarLookup = n.lookup((String) map2.get("method"));
                    this.f5468g = nVarLookup;
                    if (nVarLookup == null) {
                        throw new p(o.d.BAD_REQUEST, "BAD REQUEST: Syntax error. HTTP verb " + ((String) map2.get("method")) + " unhandled.");
                    }
                    this.f5467f = (String) map2.get("uri");
                    this.f5471j = new f(a.this, this.f5470i);
                    String str2 = this.f5470i.get(d.a.a.b.HEADER_CONNECTION);
                    boolean z2 = "HTTP/1.1".equals(this.m) && (str2 == null || !str2.matches("(?i).*close.*"));
                    oVarServe = a.this.serve(this);
                    if (oVarServe == null) {
                        throw new p(o.d.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                    }
                    String str3 = this.f5470i.get("accept-encoding");
                    this.f5471j.a(oVarServe);
                    oVarServe.i(this.f5468g);
                    if (a.this.useGzipWhenAccepted(oVarServe) && str3 != null && str3.contains(Constants.CP_GZIP)) {
                        z = true;
                    }
                    oVarServe.g(z);
                    oVarServe.h(z2);
                    oVarServe.c(this.f5463b);
                    if (!z2 || oVarServe.a()) {
                        throw new SocketException("NanoHttpd Shutdown");
                    }
                } catch (SSLException e7) {
                    throw e7;
                } catch (IOException unused) {
                    a.safeClose(this.f5464c);
                    a.safeClose(this.f5463b);
                    throw new SocketException("NanoHttpd Shutdown");
                }
            } finally {
                a.safeClose(null);
                ((j) this.a).a();
            }
        }

        public final int e(byte[] bArr, int i2) {
            int i3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i5 >= i2) {
                    return 0;
                }
                if (bArr[i4] == 13 && bArr[i5] == 10 && (i3 = i4 + 3) < i2 && bArr[i4 + 2] == 13 && bArr[i3] == 10) {
                    return i4 + 4;
                }
                if (bArr[i4] == 10 && bArr[i5] == 10) {
                    return i4 + 2;
                }
                i4 = i5;
            }
        }

        public final int[] f(ByteBuffer byteBuffer, byte[] bArr) {
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            int length = bArr.length + 4096;
            byte[] bArr2 = new byte[length];
            int iRemaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
            byteBuffer.get(bArr2, 0, iRemaining);
            int length2 = iRemaining - bArr.length;
            int i2 = 0;
            do {
                for (int i3 = 0; i3 < length2; i3++) {
                    for (int i4 = 0; i4 < bArr.length && bArr2[i3 + i4] == bArr[i4]; i4++) {
                        if (i4 == bArr.length - 1) {
                            int[] iArr2 = new int[iArr.length + 1];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[iArr.length] = i2 + i3;
                            iArr = iArr2;
                        }
                    }
                }
                i2 += length2;
                System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
                length2 = length - bArr.length;
                if (byteBuffer.remaining() < length2) {
                    length2 = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length2);
            } while (length2 > 0);
            return iArr;
        }

        public void g(Map<String, String> map) throws Throwable {
            long j2;
            RandomAccessFile randomAccessFile;
            ByteArrayOutputStream byteArrayOutputStream;
            DataOutput dataOutputStream;
            ByteBuffer map2;
            RandomAccessFile randomAccessFile2 = null;
            try {
                if (this.f5470i.containsKey("content-length")) {
                    j2 = Long.parseLong(this.f5470i.get("content-length"));
                } else {
                    j2 = this.f5465d < this.f5466e ? r4 - r3 : 0L;
                }
                if (j2 < 1024) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream2);
                    byteArrayOutputStream = byteArrayOutputStream2;
                    randomAccessFile = null;
                } else {
                    try {
                        j jVar = (j) this.a;
                        i iVar = new i(jVar.a);
                        jVar.f5462b.add(iVar);
                        randomAccessFile = new RandomAccessFile(iVar.b(), "rw");
                        byteArrayOutputStream = null;
                        dataOutputStream = randomAccessFile;
                    } catch (Exception e2) {
                        throw new Error(e2);
                    }
                }
                try {
                    byte[] bArr = new byte[512];
                    while (this.f5466e >= 0 && j2 > 0) {
                        int i2 = this.f5464c.read(bArr, 0, (int) Math.min(j2, 512L));
                        this.f5466e = i2;
                        j2 -= (long) i2;
                        if (i2 > 0) {
                            dataOutputStream.write(bArr, 0, i2);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    } else {
                        map2 = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile.length());
                        randomAccessFile.seek(0L);
                    }
                    if (n.POST.equals(this.f5468g)) {
                        d dVar = new d(this.f5470i.get("content-type"));
                        if (!HttpConnection.MULTIPART_FORM_DATA.equalsIgnoreCase(dVar.f5456e)) {
                            byte[] bArr2 = new byte[map2.remaining()];
                            map2.get(bArr2);
                            String strTrim = new String(bArr2, dVar.b()).trim();
                            if (HttpConnection.FORM_URL_ENCODED.equalsIgnoreCase(dVar.f5456e)) {
                                c(strTrim, this.f5469h);
                            } else if (strTrim.length() != 0) {
                                map.put("postData", strTrim);
                            }
                        } else {
                            if (dVar.f5458g == null) {
                                throw new p(o.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                            }
                            b(dVar, map2, this.f5469h, map);
                        }
                    } else if (n.PUT.equals(this.f5468g)) {
                        map.put("content", h(map2, 0, map2.limit(), null));
                    }
                    a.safeClose(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    a.safeClose(randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                a.safeClose(randomAccessFile2);
                throw th;
            }
        }

        public final String h(ByteBuffer byteBuffer, int i2, int i3, String str) throws Throwable {
            FileOutputStream fileOutputStream;
            i iVar;
            ByteBuffer byteBufferDuplicate;
            if (i3 <= 0) {
                return "";
            }
            try {
                try {
                    j jVar = (j) this.a;
                    iVar = new i(jVar.a);
                    jVar.f5462b.add(iVar);
                    byteBufferDuplicate = byteBuffer.duplicate();
                    fileOutputStream = new FileOutputStream(iVar.b());
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                FileChannel channel = fileOutputStream.getChannel();
                byteBufferDuplicate.position(i2).limit(i2 + i3);
                channel.write(byteBufferDuplicate.slice());
                String strB = iVar.b();
                a.safeClose(fileOutputStream);
                return strB;
            } catch (Exception e3) {
                e = e3;
                throw new Error(e);
            } catch (Throwable th2) {
                th = th2;
                a.safeClose(fileOutputStream);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public interface m {
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public enum n {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        public static n lookup(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static class o implements Closeable {
        public c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public InputStream f5475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f5476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, String> f5477e = new C0142a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, String> f5478f = new HashMap();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public n f5479g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f5480h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f5481i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f5482j;

        /* JADX INFO: renamed from: d.a.a.a$o$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NanoHTTPD.java */
        public class C0142a extends HashMap<String, String> implements j$.util.Map {
            public C0142a() {
            }

            @Override // j$.util.Map
            public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
                return Map.CC.$default$compute(this, obj, biFunction);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
                return Map.CC.$default$computeIfAbsent(this, obj, function);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
                return Map.CC.$default$computeIfPresent(this, obj, biFunction);
            }

            @Override // j$.util.Map
            public /* synthetic */ void forEach(BiConsumer biConsumer) {
                Map.CC.$default$forEach(this, biConsumer);
            }

            @Override // java.util.HashMap, java.util.Map, j$.util.Map
            public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return Map.CC.$default$getOrDefault(this, obj, obj2);
            }

            @Override // j$.util.Map
            public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
                return Map.CC.$default$merge(this, obj, obj2, biFunction);
            }

            @Override // java.util.HashMap, java.util.Map, j$.util.Map
            public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
                return Map.CC.$default$putIfAbsent(this, obj, obj2);
            }

            @Override // java.util.HashMap, java.util.Map, j$.util.Map
            public /* synthetic */ boolean remove(Object obj, Object obj2) {
                return Map.CC.$default$remove(this, obj, obj2);
            }

            @Override // java.util.HashMap, java.util.Map, j$.util.Map
            public /* synthetic */ Object replace(Object obj, Object obj2) {
                return Map.CC.$default$replace(this, obj, obj2);
            }

            @Override // java.util.HashMap, java.util.Map, j$.util.Map
            public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
                return Map.CC.$default$replace(this, obj, obj2, obj3);
            }

            @Override // j$.util.Map
            public /* synthetic */ void replaceAll(BiFunction biFunction) {
                Map.CC.$default$replaceAll(this, biFunction);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, j$.util.Map
            public String put(String str, String str2) {
                o.this.f5478f.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put(str, str2);
            }
        }

        /* JADX INFO: compiled from: NanoHTTPD.java */
        public static class b extends FilterOutputStream {
            public b(OutputStream outputStream) {
                super(outputStream);
            }

            public void a() throws IOException {
                ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) throws IOException {
                write(new byte[]{(byte) i2}, 0, 1);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) throws IOException {
                if (i3 == 0) {
                    return;
                }
                ((FilterOutputStream) this).out.write(String.format("%x\r\n", Integer.valueOf(i3)).getBytes());
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                ((FilterOutputStream) this).out.write("\r\n".getBytes());
            }
        }

        /* JADX INFO: compiled from: NanoHTTPD.java */
        public interface c {
            String getDescription();
        }

        /* JADX INFO: compiled from: NanoHTTPD.java */
        public enum d implements c {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(200, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            MULTI_STATUS(207, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(307, "Temporary Redirect"),
            BAD_REQUEST(TinkerReport.KEY_LOADED_SUCC_COST_500_LESS, "Bad Request"),
            UNAUTHORIZED(TinkerReport.KEY_LOADED_SUCC_COST_1000_LESS, "Unauthorized"),
            FORBIDDEN(TinkerReport.KEY_LOADED_SUCC_COST_5000_LESS, "Forbidden"),
            NOT_FOUND(TinkerReport.KEY_LOADED_SUCC_COST_OTHER, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            GONE(410, "Gone"),
            LENGTH_REQUIRED(411, "Length Required"),
            PRECONDITION_FAILED(412, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(417, "Expectation Failed"),
            TOO_MANY_REQUESTS(429, "Too Many Requests"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");

            private final String description;
            private final int requestStatus;

            d(int i2, String str) {
                this.requestStatus = i2;
                this.description = str;
            }

            public static d lookup(int i2) {
                d[] dVarArrValues = values();
                for (int i3 = 0; i3 < 32; i3++) {
                    d dVar = dVarArrValues[i3];
                    if (dVar.getRequestStatus() == i2) {
                        return dVar;
                    }
                }
                return null;
            }

            @Override // d.a.a.a.o.c
            public String getDescription() {
                StringBuilder sbR = c.a.a.a.a.r("");
                sbR.append(this.requestStatus);
                sbR.append(" ");
                sbR.append(this.description);
                return sbR.toString();
            }

            public int getRequestStatus() {
                return this.requestStatus;
            }
        }

        public o(c cVar, String str, InputStream inputStream, long j2) {
            this.a = cVar;
            this.f5474b = str;
            if (inputStream == null) {
                this.f5475c = new ByteArrayInputStream(new byte[0]);
                this.f5476d = 0L;
            } else {
                this.f5475c = inputStream;
                this.f5476d = j2;
            }
            this.f5480h = this.f5476d < 0;
            this.f5482j = true;
        }

        public boolean a() {
            return "close".equals(this.f5478f.get(d.a.a.b.HEADER_CONNECTION.toLowerCase()));
        }

        public void b(PrintWriter printWriter, String str, String str2) {
            printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
        }

        public void c(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
            try {
                if (this.a == null) {
                    throw new Error("sendResponse(): Status can't be null.");
                }
                PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new d(this.f5474b).b())), false);
                printWriter.append("HTTP/1.1 ").append((CharSequence) this.a.getDescription()).append(" \r\n");
                String str = this.f5474b;
                if (str != null) {
                    b(printWriter, HttpConnection.CONTENT_TYPE, str);
                }
                if (this.f5478f.get("date".toLowerCase()) == null) {
                    b(printWriter, "Date", simpleDateFormat.format(new Date()));
                }
                for (Map.Entry<String, String> entry : this.f5477e.entrySet()) {
                    b(printWriter, entry.getKey(), entry.getValue());
                }
                if (this.f5478f.get(d.a.a.b.HEADER_CONNECTION.toLowerCase()) == null) {
                    b(printWriter, "Connection", this.f5482j ? "keep-alive" : "close");
                }
                if (this.f5478f.get("content-length".toLowerCase()) != null) {
                    this.f5481i = false;
                }
                if (this.f5481i) {
                    b(printWriter, HttpConnection.CONTENT_ENCODING, Constants.CP_GZIP);
                    this.f5480h = true;
                }
                long jF = this.f5475c != null ? this.f5476d : 0L;
                if (this.f5479g != n.HEAD && this.f5480h) {
                    b(printWriter, "Transfer-Encoding", "chunked");
                } else if (!this.f5481i) {
                    jF = f(printWriter, jF);
                }
                printWriter.append("\r\n");
                printWriter.flush();
                e(outputStream, jF);
                outputStream.flush();
                a.safeClose(this.f5475c);
            } catch (IOException e2) {
                a.LOG.log(Level.SEVERE, "Could not send response to the client", (Throwable) e2);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.f5475c;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public final void d(OutputStream outputStream, long j2) throws IOException {
            byte[] bArr = new byte[(int) 16384];
            boolean z = j2 == -1;
            while (true) {
                if (j2 <= 0 && !z) {
                    return;
                }
                int i2 = this.f5475c.read(bArr, 0, (int) (z ? 16384L : Math.min(j2, 16384L)));
                if (i2 <= 0) {
                    return;
                }
                outputStream.write(bArr, 0, i2);
                if (!z) {
                    j2 -= (long) i2;
                }
            }
        }

        public final void e(OutputStream outputStream, long j2) throws IOException {
            if (this.f5479g == n.HEAD || !this.f5480h) {
                if (!this.f5481i) {
                    d(outputStream, j2);
                    return;
                }
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                d(gZIPOutputStream, -1L);
                gZIPOutputStream.finish();
                return;
            }
            b bVar = new b(outputStream);
            if (this.f5481i) {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(bVar);
                d(gZIPOutputStream2, -1L);
                gZIPOutputStream2.finish();
            } else {
                d(bVar, -1L);
            }
            bVar.a();
        }

        public long f(PrintWriter printWriter, long j2) {
            String str = this.f5478f.get("content-length".toLowerCase());
            if (str != null) {
                try {
                    j2 = Long.parseLong(str);
                } catch (NumberFormatException unused) {
                    a.LOG.severe("content-length was no number " + str);
                }
            }
            printWriter.print("Content-Length: " + j2 + "\r\n");
            return j2;
        }

        public void g(boolean z) {
            this.f5481i = z;
        }

        public void h(boolean z) {
            this.f5482j = z;
        }

        public void i(n nVar) {
            this.f5479g = nVar;
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static class q implements s {
        public SSLServerSocketFactory a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f5483b;

        public q(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
            this.a = sSLServerSocketFactory;
            this.f5483b = strArr;
        }

        @Override // d.a.a.a.s
        public ServerSocket a() {
            SSLServerSocket sSLServerSocket = (SSLServerSocket) this.a.createServerSocket();
            String[] strArr = this.f5483b;
            if (strArr != null) {
                sSLServerSocket.setEnabledProtocols(strArr);
            } else {
                sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
            }
            sSLServerSocket.setUseClientMode(false);
            sSLServerSocket.setWantClientAuth(false);
            sSLServerSocket.setNeedClientAuth(false);
            return sSLServerSocket;
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public class r implements Runnable {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IOException f5484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5485c = false;

        public r(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.myServerSocket.bind(a.this.hostname != null ? new InetSocketAddress(a.this.hostname, a.this.myPort) : new InetSocketAddress(a.this.myPort));
                this.f5485c = true;
                do {
                    try {
                        Socket socketAccept = a.this.myServerSocket.accept();
                        int i2 = this.a;
                        if (i2 > 0) {
                            socketAccept.setSoTimeout(i2);
                        }
                        InputStream inputStream = socketAccept.getInputStream();
                        a aVar = a.this;
                        ((g) aVar.asyncRunner).a(aVar.createClientHandler(socketAccept, inputStream));
                    } catch (IOException e2) {
                        a.LOG.log(Level.FINE, "Communication with the client broken", (Throwable) e2);
                    }
                } while (!a.this.myServerSocket.isClosed());
            } catch (IOException e3) {
                this.f5484b = e3;
            }
        }
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public interface s {
        ServerSocket a();
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public interface t {
        void a();
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public interface u {
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public interface v {
    }

    public a(int i2) {
        this(null, i2);
    }

    public static java.util.Map<String, List<String>> decodeParameters(java.util.Map<String, String> map) {
        return decodeParameters(map.get(QUERY_STRING_PARAMETER));
    }

    public static String decodePercent(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e2) {
            LOG.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e2);
            return null;
        }
    }

    public static String getMimeTypeForFile(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        String str2 = iLastIndexOf >= 0 ? mimeTypes().get(str.substring(iLastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? "application/octet-stream" : str2;
    }

    private static void loadMimeTypes(java.util.Map<String, String> map, String str) {
        try {
            Enumeration<URL> resources = a.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                Properties properties = new Properties();
                InputStream inputStreamOpenStream = null;
                try {
                    try {
                        inputStreamOpenStream = urlNextElement.openStream();
                        properties.load(inputStreamOpenStream);
                    } catch (IOException e2) {
                        LOG.log(Level.SEVERE, "could not load mimetypes from " + urlNextElement, (Throwable) e2);
                    }
                    safeClose(inputStreamOpenStream);
                    map.putAll(properties);
                } catch (Throwable th) {
                    safeClose(inputStreamOpenStream);
                    throw th;
                }
            }
        } catch (IOException unused) {
            LOG.log(Level.INFO, "no mime types available at " + str);
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManager[] keyManagerArr) throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(keyManagerArr, trustManagerFactory.getTrustManagers(), null);
            return sSLContext.getServerSocketFactory();
        } catch (Exception e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public static java.util.Map<String, String> mimeTypes() {
        if (MIME_TYPES == null) {
            HashMap map = new HashMap();
            MIME_TYPES = map;
            loadMimeTypes(map, "META-INF/nanohttpd/default-mimetypes.properties");
            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
            if (MIME_TYPES.isEmpty()) {
                LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return MIME_TYPES;
    }

    public static o newChunkedResponse(o.c cVar, String str, InputStream inputStream) {
        return new o(cVar, str, inputStream, -1L);
    }

    public static o newFixedLengthResponse(o.c cVar, String str, InputStream inputStream, long j2) {
        return new o(cVar, str, inputStream, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void safeClose(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e2) {
                LOG.log(Level.SEVERE, "Could not close", (Throwable) e2);
            }
        }
    }

    public synchronized void closeAllConnections() {
        stop();
    }

    public c createClientHandler(Socket socket, InputStream inputStream) {
        return new c(inputStream, socket);
    }

    public r createServerRunnable(int i2) {
        return new r(i2);
    }

    public String getHostname() {
        return this.hostname;
    }

    public final int getListeningPort() {
        if (this.myServerSocket == null) {
            return -1;
        }
        return this.myServerSocket.getLocalPort();
    }

    public s getServerSocketFactory() {
        return this.serverSocketFactory;
    }

    public v getTempFileManagerFactory() {
        return this.tempFileManagerFactory;
    }

    public final boolean isAlive() {
        return wasStarted() && !this.myServerSocket.isClosed() && this.myThread.isAlive();
    }

    public void makeSecure(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.serverSocketFactory = new q(sSLServerSocketFactory, strArr);
    }

    public o serve(m mVar) throws Throwable {
        java.util.Map<String, String> map = new HashMap<>();
        l lVar = (l) mVar;
        n nVar = lVar.f5468g;
        if (n.PUT.equals(nVar) || n.POST.equals(nVar)) {
            try {
                ((l) mVar).g(map);
            } catch (p e2) {
                return newFixedLengthResponse(e2.getStatus(), MIME_PLAINTEXT, e2.getMessage());
            } catch (IOException e3) {
                o.d dVar = o.d.INTERNAL_ERROR;
                StringBuilder sbR = c.a.a.a.a.r("SERVER INTERNAL ERROR: IOException: ");
                sbR.append(e3.getMessage());
                return newFixedLengthResponse(dVar, MIME_PLAINTEXT, sbR.toString());
            }
        }
        HashMap map2 = new HashMap();
        for (String str : lVar.f5469h.keySet()) {
            map2.put(str, lVar.f5469h.get(str).get(0));
        }
        map2.put(QUERY_STRING_PARAMETER, lVar.f5472k);
        return serve(lVar.f5467f, nVar, lVar.f5470i, map2, map);
    }

    public void setAsyncRunner(b bVar) {
        this.asyncRunner = bVar;
    }

    public void setServerSocketFactory(s sVar) {
        this.serverSocketFactory = sVar;
    }

    public void setTempFileManagerFactory(v vVar) {
        this.tempFileManagerFactory = vVar;
    }

    public void start() throws IOException {
        start(5000);
    }

    public void stop() {
        try {
            safeClose(this.myServerSocket);
            g gVar = (g) this.asyncRunner;
            Objects.requireNonNull(gVar);
            for (c cVar : new ArrayList(gVar.f5460b)) {
                safeClose(cVar.a);
                safeClose(cVar.f5451b);
            }
            Thread thread = this.myThread;
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e2) {
            LOG.log(Level.SEVERE, "Could not stop all connections", (Throwable) e2);
        }
    }

    public boolean useGzipWhenAccepted(o oVar) {
        String str = oVar.f5474b;
        return str != null && (str.toLowerCase().contains("text/") || oVar.f5474b.toLowerCase().contains("/json"));
    }

    public final boolean wasStarted() {
        return (this.myServerSocket == null || this.myThread == null) ? false : true;
    }

    /* JADX INFO: compiled from: NanoHTTPD.java */
    public static final class p extends Exception {
        private static final long serialVersionUID = 6569838532917408380L;
        private final o.d status;

        public p(o.d dVar, String str) {
            super(str);
            this.status = dVar;
        }

        public o.d getStatus() {
            return this.status;
        }

        public p(o.d dVar, String str, Exception exc) {
            super(str, exc);
            this.status = dVar;
        }
    }

    public a(String str, int i2) {
        this.serverSocketFactory = new h();
        this.hostname = str;
        this.myPort = i2;
        setTempFileManagerFactory(new k(this, null));
        setAsyncRunner(new g());
    }

    public static java.util.Map<String, List<String>> decodeParameters(String str) {
        HashMap map = new HashMap();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                String strTrim = (iIndexOf >= 0 ? decodePercent(strNextToken.substring(0, iIndexOf)) : decodePercent(strNextToken)).trim();
                if (!map.containsKey(strTrim)) {
                    map.put(strTrim, new ArrayList());
                }
                String strDecodePercent = iIndexOf >= 0 ? decodePercent(strNextToken.substring(iIndexOf + 1)) : null;
                if (strDecodePercent != null) {
                    ((List) map.get(strTrim)).add(strDecodePercent);
                }
            }
        }
        return map;
    }

    public static o newFixedLengthResponse(o.c cVar, String str, String str2) {
        byte[] bytes;
        d dVar = new d(str);
        if (str2 == null) {
            return newFixedLengthResponse(cVar, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            if (!Charset.forName(dVar.b()).newEncoder().canEncode(str2) && dVar.f5457f == null) {
                dVar = new d(str + "; charset=UTF-8");
            }
            bytes = str2.getBytes(dVar.b());
        } catch (UnsupportedEncodingException e2) {
            LOG.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e2);
            bytes = new byte[0];
        }
        return newFixedLengthResponse(cVar, dVar.f5455d, new ByteArrayInputStream(bytes), bytes.length);
    }

    public void start(int i2) throws IOException {
        start(i2, true);
    }

    public void start(int i2, boolean z) throws IOException {
        this.myServerSocket = getServerSocketFactory().a();
        this.myServerSocket.setReuseAddress(true);
        r rVarCreateServerRunnable = createServerRunnable(i2);
        Thread thread = new Thread(rVarCreateServerRunnable);
        this.myThread = thread;
        thread.setDaemon(z);
        this.myThread.setName("NanoHttpd Main Listener");
        this.myThread.start();
        while (!rVarCreateServerRunnable.f5485c && rVarCreateServerRunnable.f5484b == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        IOException iOException = rVarCreateServerRunnable.f5484b;
        if (iOException != null) {
            throw iOException;
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManagerFactory keyManagerFactory) throws IOException {
        try {
            return makeSSLSocketFactory(keyStore, keyManagerFactory.getKeyManagers());
        } catch (Exception e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(String str, char[] cArr) throws IOException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = a.class.getResourceAsStream(str);
            if (resourceAsStream != null) {
                keyStore.load(resourceAsStream, cArr);
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, cArr);
                return makeSSLSocketFactory(keyStore, keyManagerFactory);
            }
            throw new IOException("Unable to load keystore from classpath: " + str);
        } catch (Exception e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public static o newFixedLengthResponse(String str) {
        return newFixedLengthResponse(o.d.OK, MIME_HTML, str);
    }

    @Deprecated
    public o serve(String str, n nVar, java.util.Map<String, String> map, java.util.Map<String, String> map2, java.util.Map<String, String> map3) {
        return newFixedLengthResponse(o.d.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
    }
}
