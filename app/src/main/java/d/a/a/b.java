package d.a.a;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.bw;
import d.a.a.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: NanoWSD.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends d.a.a.a {
    public static final String HEADER_CONNECTION = "connection";
    public static final String HEADER_CONNECTION_VALUE = "Upgrade";
    public static final String HEADER_UPGRADE = "upgrade";
    public static final String HEADER_UPGRADE_VALUE = "websocket";
    public static final String HEADER_WEBSOCKET_ACCEPT = "sec-websocket-accept";
    public static final String HEADER_WEBSOCKET_KEY = "sec-websocket-key";
    public static final String HEADER_WEBSOCKET_PROTOCOL = "sec-websocket-protocol";
    public static final String HEADER_WEBSOCKET_VERSION = "sec-websocket-version";
    public static final String HEADER_WEBSOCKET_VERSION_VALUE = "13";
    private static final String WEBSOCKET_KEY_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final Logger LOG = Logger.getLogger(b.class.getName());
    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* JADX INFO: renamed from: d.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NanoWSD.java */
    public enum EnumC0143b {
        UNCONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* JADX INFO: compiled from: NanoWSD.java */
    public static abstract class c {
        private final a.m handshakeRequest;
        private final a.o handshakeResponse;
        private final InputStream in;
        private OutputStream out;
        private e.c continuousOpCode = null;
        private final List<e> continuousFrames = new LinkedList();
        private EnumC0143b state = EnumC0143b.UNCONNECTED;

        /* JADX INFO: compiled from: NanoWSD.java */
        public class a extends a.o {
            public a(a.o.c cVar, String str, InputStream inputStream, long j2) {
                super(cVar, null, null, j2);
            }

            @Override // d.a.a.a.o
            public void c(OutputStream outputStream) {
                c.this.out = outputStream;
                c.this.state = EnumC0143b.CONNECTING;
                super.c(outputStream);
                c.this.state = EnumC0143b.OPEN;
                c.this.onOpen();
                c.this.readWebsocket();
            }
        }

        public c(a.m mVar) {
            a aVar = new a(a.o.d.SWITCH_PROTOCOL, null, null, 0L);
            this.handshakeResponse = aVar;
            this.handshakeRequest = mVar;
            this.in = ((a.l) mVar).f5464c;
            aVar.f5477e.put(b.HEADER_UPGRADE, b.HEADER_UPGRADE_VALUE);
            aVar.f5477e.put(b.HEADER_CONNECTION, b.HEADER_CONNECTION_VALUE);
        }

        private void doClose(e.a aVar, String str, boolean z) {
            if (this.state == EnumC0143b.CLOSED) {
                return;
            }
            InputStream inputStream = this.in;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    b.LOG.log(Level.FINE, "close failed", (Throwable) e2);
                }
            }
            OutputStream outputStream = this.out;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    b.LOG.log(Level.FINE, "close failed", (Throwable) e3);
                }
            }
            this.state = EnumC0143b.CLOSED;
            onClose(aVar, str, z);
        }

        private void handleCloseFrame(e eVar) {
            String str;
            e.a aVar = e.a.NormalClosure;
            if (eVar instanceof e.C0144b) {
                e.C0144b c0144b = (e.C0144b) eVar;
                aVar = c0144b.f5494h;
                str = c0144b.f5495i;
            } else {
                str = "";
            }
            if (this.state == EnumC0143b.CLOSING) {
                doClose(aVar, str, false);
            } else {
                close(aVar, str, true);
            }
        }

        private void handleFrameFragment(e eVar) throws d {
            e.c cVar = eVar.f5488b;
            if (cVar != e.c.Continuation) {
                if (this.continuousOpCode != null) {
                    throw new d(e.a.ProtocolError, "Previous continuous frame sequence not completed.");
                }
                this.continuousOpCode = cVar;
                this.continuousFrames.clear();
                this.continuousFrames.add(eVar);
                return;
            }
            if (!eVar.f5489c) {
                if (this.continuousOpCode == null) {
                    throw new d(e.a.ProtocolError, "Continuous frame sequence was not started.");
                }
                this.continuousFrames.add(eVar);
            } else {
                if (this.continuousOpCode == null) {
                    throw new d(e.a.ProtocolError, "Continuous frame sequence was not started.");
                }
                this.continuousFrames.add(eVar);
                onMessage(new e(this.continuousOpCode, this.continuousFrames));
                this.continuousOpCode = null;
                this.continuousFrames.clear();
            }
        }

        private void handleWebsocketFrame(e eVar) throws d {
            debugFrameReceived(eVar);
            e.c cVar = eVar.f5488b;
            if (cVar == e.c.Close) {
                handleCloseFrame(eVar);
                return;
            }
            if (cVar == e.c.Ping) {
                sendFrame(new e(e.c.Pong, true, eVar.f5491e));
                return;
            }
            if (cVar == e.c.Pong) {
                onPong(eVar);
                return;
            }
            if (!eVar.f5489c || cVar == e.c.Continuation) {
                handleFrameFragment(eVar);
            } else {
                if (this.continuousOpCode != null) {
                    throw new d(e.a.ProtocolError, "Continuous frame sequence not completed.");
                }
                if (cVar != e.c.Text && cVar != e.c.Binary) {
                    throw new d(e.a.ProtocolError, "Non control or continuous frame expected.");
                }
                onMessage(eVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void readWebsocket() {
            while (true) {
                try {
                    try {
                        if (this.state != EnumC0143b.OPEN) {
                            break;
                        } else {
                            handleWebsocketFrame(e.d(this.in));
                        }
                    } catch (CharacterCodingException e2) {
                        onException(e2);
                        doClose(e.a.InvalidFramePayloadData, e2.toString(), false);
                    } catch (IOException e3) {
                        onException(e3);
                        if (e3 instanceof d) {
                            doClose(((d) e3).getCode(), ((d) e3).getReason(), false);
                        }
                    }
                } finally {
                    doClose(e.a.InternalServerError, "Handler terminated without closing the connection.", false);
                }
            }
        }

        public void close(e.a aVar, String str, boolean z) {
            EnumC0143b enumC0143b = this.state;
            this.state = EnumC0143b.CLOSING;
            if (enumC0143b == EnumC0143b.OPEN) {
                sendFrame(new e.C0144b(aVar, str));
            } else {
                doClose(aVar, str, z);
            }
        }

        public void debugFrameReceived(e eVar) {
        }

        public void debugFrameSent(e eVar) {
        }

        public a.m getHandshakeRequest() {
            return this.handshakeRequest;
        }

        public a.o getHandshakeResponse() {
            return this.handshakeResponse;
        }

        public boolean isOpen() {
            return this.state == EnumC0143b.OPEN;
        }

        public abstract void onClose(e.a aVar, String str, boolean z);

        public abstract void onException(IOException iOException);

        public abstract void onMessage(e eVar);

        public abstract void onOpen();

        public abstract void onPong(e eVar);

        public void ping(byte[] bArr) {
            sendFrame(new e(e.c.Ping, true, bArr));
        }

        public void send(byte[] bArr) {
            sendFrame(new e(e.c.Binary, true, bArr));
        }

        public synchronized void sendFrame(e eVar) {
            debugFrameSent(eVar);
            eVar.g(this.out);
        }

        public void send(String str) {
            sendFrame(new e(e.c.Text, true, str));
        }
    }

    /* JADX INFO: compiled from: NanoWSD.java */
    public static class d extends IOException {
        private static final long serialVersionUID = 1;
        private final e.a code;
        private final String reason;

        public d(e.a aVar, String str) {
            this(aVar, str, null);
        }

        public e.a getCode() {
            return this.code;
        }

        public String getReason() {
            return this.reason;
        }

        public d(e.a aVar, String str, Exception exc) {
            super(aVar + ": " + str, exc);
            this.code = aVar;
            this.reason = str;
        }

        public d(Exception exc) {
            this(e.a.InternalServerError, exc.toString(), exc);
        }
    }

    public b(int i2) {
        super(i2);
    }

    private static String encodeBase64(byte[] bArr) {
        int i2;
        byte b2;
        byte b3;
        int length = bArr.length;
        char[] cArr = new char[((length + 2) / 3) * 4];
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i3 + 1;
            byte b4 = bArr[i3];
            if (i5 < length) {
                i2 = i5 + 1;
                b2 = bArr[i5];
            } else {
                i2 = i5;
                b2 = 0;
            }
            if (i2 < length) {
                b3 = bArr[i2];
                i2++;
            } else {
                b3 = 0;
            }
            int i6 = i4 + 1;
            char[] cArr2 = ALPHABET;
            cArr[i4] = cArr2[(b4 >> 2) & 63];
            int i7 = i6 + 1;
            cArr[i6] = cArr2[((b4 << 4) | ((b2 & ExifInterface.MARKER) >> 4)) & 63];
            int i8 = i7 + 1;
            cArr[i7] = cArr2[((b2 << 2) | ((b3 & ExifInterface.MARKER) >> 6)) & 63];
            i4 = i8 + 1;
            cArr[i8] = cArr2[b3 & Utf8.REPLACEMENT_BYTE];
            i3 = i2;
        }
        int i9 = length % 3;
        if (i9 != 1) {
            if (i9 == 2) {
            }
            return new String(cArr);
        }
        i4--;
        cArr[i4] = '=';
        cArr[i4 - 1] = '=';
        return new String(cArr);
    }

    private boolean isWebSocketConnectionHeader(Map<String, String> map) {
        String str = map.get(HEADER_CONNECTION);
        return str != null && str.toLowerCase().contains(HEADER_CONNECTION_VALUE.toLowerCase());
    }

    public static String makeAcceptKey(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        String strI = c.a.a.a.a.i(str, "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        messageDigest.update(strI.getBytes(), 0, strI.length());
        return encodeBase64(messageDigest.digest());
    }

    public boolean isWebsocketRequested(a.m mVar) {
        Map<String, String> map = ((a.l) mVar).f5470i;
        return HEADER_UPGRADE_VALUE.equalsIgnoreCase(map.get(HEADER_UPGRADE)) && isWebSocketConnectionHeader(map);
    }

    public abstract c openWebSocket(a.m mVar);

    @Override // d.a.a.a
    public a.o serve(a.m mVar) {
        Map<String, String> map = ((a.l) mVar).f5470i;
        if (!isWebsocketRequested(mVar)) {
            return serveHttp(mVar);
        }
        if (!HEADER_WEBSOCKET_VERSION_VALUE.equalsIgnoreCase(map.get(HEADER_WEBSOCKET_VERSION))) {
            a.o.d dVar = a.o.d.BAD_REQUEST;
            StringBuilder sbR = c.a.a.a.a.r("Invalid Websocket-Version ");
            sbR.append(map.get(HEADER_WEBSOCKET_VERSION));
            return d.a.a.a.newFixedLengthResponse(dVar, d.a.a.a.MIME_PLAINTEXT, sbR.toString());
        }
        if (!map.containsKey(HEADER_WEBSOCKET_KEY)) {
            return d.a.a.a.newFixedLengthResponse(a.o.d.BAD_REQUEST, d.a.a.a.MIME_PLAINTEXT, "Missing Websocket-Key");
        }
        a.o handshakeResponse = openWebSocket(mVar).getHandshakeResponse();
        try {
            handshakeResponse.f5477e.put(HEADER_WEBSOCKET_ACCEPT, makeAcceptKey(map.get(HEADER_WEBSOCKET_KEY)));
            if (map.containsKey(HEADER_WEBSOCKET_PROTOCOL)) {
                handshakeResponse.f5477e.put(HEADER_WEBSOCKET_PROTOCOL, map.get(HEADER_WEBSOCKET_PROTOCOL).split(",")[0]);
            }
            return handshakeResponse;
        } catch (NoSuchAlgorithmException unused) {
            return d.a.a.a.newFixedLengthResponse(a.o.d.INTERNAL_ERROR, d.a.a.a.MIME_PLAINTEXT, "The SHA-1 Algorithm required for websockets is not available on the server.");
        }
    }

    public a.o serveHttp(a.m mVar) {
        return super.serve(mVar);
    }

    @Override // d.a.a.a
    public boolean useGzipWhenAccepted(a.o oVar) {
        return false;
    }

    public b(String str, int i2) {
        super(str, i2);
    }

    /* JADX INFO: compiled from: NanoWSD.java */
    public static class e {
        public static final Charset a = Charset.forName(DataUtil.defaultCharset);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f5488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f5490d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f5491e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public transient int f5492f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public transient String f5493g;

        /* JADX INFO: compiled from: NanoWSD.java */
        public enum a {
            NormalClosure(1000),
            GoingAway(1001),
            ProtocolError(PointerIconCompat.TYPE_HAND),
            UnsupportedData(PointerIconCompat.TYPE_HELP),
            NoStatusRcvd(WebSocketProtocol.CLOSE_NO_STATUS_CODE),
            AbnormalClosure(PointerIconCompat.TYPE_CELL),
            InvalidFramePayloadData(PointerIconCompat.TYPE_CROSSHAIR),
            PolicyViolation(PointerIconCompat.TYPE_TEXT),
            MessageTooBig(PointerIconCompat.TYPE_VERTICAL_TEXT),
            MandatoryExt(PointerIconCompat.TYPE_ALIAS),
            InternalServerError(PointerIconCompat.TYPE_COPY),
            TLSHandshake(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);

            private final int code;

            a(int i2) {
                this.code = i2;
            }

            public static a find(int i2) {
                a[] aVarArrValues = values();
                for (int i3 = 0; i3 < 12; i3++) {
                    a aVar = aVarArrValues[i3];
                    if (aVar.getValue() == i2) {
                        return aVar;
                    }
                }
                return null;
            }

            public int getValue() {
                return this.code;
            }
        }

        /* JADX INFO: compiled from: NanoWSD.java */
        public enum c {
            Continuation(0),
            Text(1),
            Binary(2),
            Close(8),
            Ping(9),
            Pong(10);

            private final byte code;

            c(int i2) {
                this.code = (byte) i2;
            }

            public static c find(byte b2) {
                c[] cVarArrValues = values();
                for (int i2 = 0; i2 < 6; i2++) {
                    c cVar = cVarArrValues[i2];
                    if (cVar.getValue() == b2) {
                        return cVar;
                    }
                }
                return null;
            }

            public byte getValue() {
                return this.code;
            }

            public boolean isControlFrame() {
                return this == Close || this == Ping || this == Pong;
            }
        }

        public e(c cVar, boolean z) {
            this.f5488b = cVar;
            this.f5489c = z;
        }

        public static int a(int i2) throws EOFException {
            if (i2 >= 0) {
                return i2;
            }
            throw new EOFException();
        }

        public static e d(InputStream inputStream) throws IOException {
            int i2 = inputStream.read();
            a(i2);
            byte b2 = (byte) i2;
            int i3 = 0;
            boolean z = (b2 & 128) != 0;
            int i4 = b2 & bw.m;
            c cVarFind = c.find((byte) i4);
            int i5 = b2 & 112;
            if (i5 != 0) {
                a aVar = a.ProtocolError;
                StringBuilder sbR = c.a.a.a.a.r("The reserved bits (");
                sbR.append(Integer.toBinaryString(i5));
                sbR.append(") must be 0.");
                throw new d(aVar, sbR.toString());
            }
            if (cVarFind == null) {
                throw new d(a.ProtocolError, c.a.a.a.a.d("Received frame with reserved/unknown opcode ", i4, "."));
            }
            if (cVarFind.isControlFrame() && !z) {
                throw new d(a.ProtocolError, "Fragmented control frame.");
            }
            e eVar = new e(cVarFind, z);
            int i6 = inputStream.read();
            a(i6);
            byte b3 = (byte) i6;
            boolean z2 = (b3 & 128) != 0;
            byte b4 = (byte) (b3 & 127);
            eVar.f5492f = b4;
            if (b4 == 126) {
                int i7 = inputStream.read();
                a(i7);
                int i8 = inputStream.read();
                a(i8);
                int i9 = ((i7 << 8) | i8) & 65535;
                eVar.f5492f = i9;
                if (i9 < 126) {
                    throw new d(a.ProtocolError, "Invalid data frame 2byte length. (not using minimal length encoding)");
                }
            } else if (b4 == 127) {
                int i10 = inputStream.read();
                a(i10);
                long j2 = ((long) i10) << 56;
                int i11 = inputStream.read();
                a(i11);
                long j3 = j2 | (((long) i11) << 48);
                int i12 = inputStream.read();
                a(i12);
                long j4 = j3 | (((long) i12) << 40);
                int i13 = inputStream.read();
                a(i13);
                long j5 = j4 | (((long) i13) << 32);
                int i14 = inputStream.read();
                a(i14);
                long j6 = j5 | ((long) (i14 << 24));
                int i15 = inputStream.read();
                a(i15);
                long j7 = j6 | ((long) (i15 << 16));
                int i16 = inputStream.read();
                a(i16);
                long j8 = j7 | ((long) (i16 << 8));
                int i17 = inputStream.read();
                a(i17);
                long j9 = j8 | ((long) i17);
                if (j9 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    throw new d(a.ProtocolError, "Invalid data frame 4byte length. (not using minimal length encoding)");
                }
                if (j9 < 0 || j9 > 2147483647L) {
                    throw new d(a.MessageTooBig, "Max frame length has been exceeded.");
                }
                eVar.f5492f = (int) j9;
            }
            if (eVar.f5488b.isControlFrame()) {
                int i18 = eVar.f5492f;
                if (i18 > 125) {
                    throw new d(a.ProtocolError, "Control frame with payload length > 125 bytes.");
                }
                if (eVar.f5488b == c.Close && i18 == 1) {
                    throw new d(a.ProtocolError, "Received close frame with payload len 1.");
                }
            }
            if (z2) {
                eVar.f5490d = new byte[4];
                int i19 = 0;
                while (true) {
                    byte[] bArr = eVar.f5490d;
                    if (i19 >= bArr.length) {
                        break;
                    }
                    int i20 = inputStream.read(bArr, i19, bArr.length - i19);
                    a(i20);
                    i19 += i20;
                }
            }
            eVar.f5491e = new byte[eVar.f5492f];
            int i21 = 0;
            while (true) {
                int i22 = eVar.f5492f;
                if (i21 >= i22) {
                    break;
                }
                int i23 = inputStream.read(eVar.f5491e, i21, i22 - i21);
                a(i23);
                i21 += i23;
            }
            if (eVar.c()) {
                while (true) {
                    byte[] bArr2 = eVar.f5491e;
                    if (i3 >= bArr2.length) {
                        break;
                    }
                    bArr2[i3] = (byte) (bArr2[i3] ^ eVar.f5490d[i3 % 4]);
                    i3++;
                }
            }
            if (eVar.f5488b == c.Text) {
                eVar.f5493g = new String(eVar.f5491e, a);
            }
            return eVar.f5488b == c.Close ? new C0144b(eVar, (a) null) : eVar;
        }

        public String b() {
            if (this.f5493g == null) {
                try {
                    this.f5493g = new String(this.f5491e, a);
                } catch (CharacterCodingException e2) {
                    throw new RuntimeException("Undetected CharacterCodingException", e2);
                }
            }
            return this.f5493g;
        }

        public boolean c() {
            byte[] bArr = this.f5490d;
            return bArr != null && bArr.length == 4;
        }

        public void e(byte[] bArr) {
            this.f5491e = bArr;
            this.f5492f = bArr.length;
            this.f5493g = null;
        }

        public void f(byte[] bArr) {
            if (bArr == null || bArr.length == 4) {
                this.f5490d = bArr;
                return;
            }
            StringBuilder sbR = c.a.a.a.a.r("MaskingKey ");
            sbR.append(Arrays.toString(bArr));
            sbR.append(" hasn't length 4");
            throw new IllegalArgumentException(sbR.toString());
        }

        public void g(OutputStream outputStream) throws IOException {
            outputStream.write((byte) ((this.f5489c ? (byte) 128 : (byte) 0) | (this.f5488b.getValue() & bw.m)));
            int length = this.f5491e.length;
            this.f5492f = length;
            if (length <= 125) {
                outputStream.write(c() ? ((byte) this.f5492f) | 128 : (byte) this.f5492f);
            } else if (length <= 65535) {
                outputStream.write(c() ? TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE : 126);
                outputStream.write(this.f5492f >>> 8);
                outputStream.write(this.f5492f);
            } else {
                outputStream.write(c() ? 255 : 127);
                outputStream.write((this.f5492f >>> 56) & 0);
                outputStream.write((this.f5492f >>> 48) & 0);
                outputStream.write((this.f5492f >>> 40) & 0);
                outputStream.write((this.f5492f >>> 32) & 0);
                outputStream.write(this.f5492f >>> 24);
                outputStream.write(this.f5492f >>> 16);
                outputStream.write(this.f5492f >>> 8);
                outputStream.write(this.f5492f);
            }
            if (c()) {
                outputStream.write(this.f5490d);
                for (int i2 = 0; i2 < this.f5492f; i2++) {
                    outputStream.write(this.f5491e[i2] ^ this.f5490d[i2 % 4]);
                }
            } else {
                outputStream.write(this.f5491e);
            }
            outputStream.flush();
        }

        public String toString() {
            String string;
            StringBuilder sb = new StringBuilder("WS[");
            sb.append(this.f5488b);
            sb.append(", ");
            sb.append(this.f5489c ? "fin" : "inter");
            sb.append(", ");
            sb.append(c() ? "masked" : "unmasked");
            sb.append(", ");
            if (this.f5491e == null) {
                string = "null";
            } else {
                StringBuilder sbQ = c.a.a.a.a.q('[');
                sbQ.append(this.f5491e.length);
                sbQ.append("b] ");
                if (this.f5488b == c.Text) {
                    String strB = b();
                    if (strB.length() > 100) {
                        sbQ.append(strB.substring(0, 100));
                        sbQ.append("...");
                    } else {
                        sbQ.append(strB);
                    }
                } else {
                    sbQ.append("0x");
                    for (int i2 = 0; i2 < Math.min(this.f5491e.length, 50); i2++) {
                        sbQ.append(Integer.toHexString(this.f5491e[i2] & ExifInterface.MARKER));
                    }
                    if (this.f5491e.length > 50) {
                        sbQ.append("...");
                    }
                }
                string = sbQ.toString();
            }
            sb.append(string);
            sb.append(']');
            return sb.toString();
        }

        public e(c cVar, boolean z, String str) {
            this.f5488b = cVar;
            this.f5489c = z;
            f(null);
            this.f5491e = str.getBytes(a);
            this.f5492f = str.length();
            this.f5493g = str;
        }

        /* JADX INFO: renamed from: d.a.a.b$e$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NanoWSD.java */
        public static class C0144b extends e {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public a f5494h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public String f5495i;

            /* JADX WARN: Illegal instructions before constructor call */
            public C0144b(a aVar, String str) {
                byte[] bArr;
                c cVar = c.Close;
                if (aVar != null) {
                    byte[] bytes = str.getBytes(e.a);
                    bArr = new byte[bytes.length + 2];
                    bArr[0] = (byte) ((aVar.getValue() >> 8) & 255);
                    bArr[1] = (byte) (aVar.getValue() & 255);
                    System.arraycopy(bytes, 0, bArr, 2, bytes.length);
                } else {
                    bArr = new byte[0];
                }
                super(cVar, true, bArr);
            }

            public C0144b(e eVar, a aVar) {
                super(eVar);
                byte[] bArr = eVar.f5491e;
                if (bArr.length >= 2) {
                    this.f5494h = a.find((bArr[1] & ExifInterface.MARKER) | ((bArr[0] & ExifInterface.MARKER) << 8));
                    byte[] bArr2 = this.f5491e;
                    this.f5495i = new String(bArr2, 2, bArr2.length - 2, e.a);
                }
            }
        }

        public e(c cVar, boolean z, byte[] bArr) {
            this.f5488b = cVar;
            this.f5489c = z;
            f(null);
            this.f5491e = bArr;
            this.f5492f = bArr.length;
            this.f5493g = null;
        }

        public e(c cVar, List<e> list) throws d {
            this.f5488b = cVar;
            this.f5489c = true;
            Iterator<e> it = list.iterator();
            long length = 0;
            while (it.hasNext()) {
                length += (long) it.next().f5491e.length;
            }
            if (length >= 0 && length <= 2147483647L) {
                int i2 = (int) length;
                this.f5492f = i2;
                byte[] bArr = new byte[i2];
                int length2 = 0;
                for (e eVar : list) {
                    byte[] bArr2 = eVar.f5491e;
                    System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                    length2 += eVar.f5491e.length;
                }
                this.f5491e = bArr;
                this.f5492f = i2;
                this.f5493g = null;
                return;
            }
            throw new d(a.MessageTooBig, "Max frame length has been exceeded.");
        }

        public e(e eVar) {
            this.f5488b = eVar.f5488b;
            this.f5489c = eVar.f5489c;
            e(eVar.f5491e);
            f(eVar.f5490d);
        }
    }
}
