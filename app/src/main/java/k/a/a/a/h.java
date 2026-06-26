package k.a.a.a;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import org.jsoup.parser.CharacterReader;

/* JADX INFO: compiled from: CodePointBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteBuffer f8359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharBuffer f8360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IntBuffer f8361d;

    /* JADX INFO: compiled from: CodePointBuffer.java */
    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteBuffer f8362b;
        public c a = c.BYTE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharBuffer f8363c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public IntBuffer f8364d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8365e = -1;

        public b(int i2, a aVar) {
            this.f8362b = ByteBuffer.allocate(i2);
        }

        public static int c(int i2) {
            return (int) Math.pow(2.0d, 32 - Integer.numberOfLeadingZeros(i2 - 1));
        }

        public final void a(CharBuffer charBuffer) {
            char[] cArrArray = charBuffer.array();
            int iPosition = charBuffer.position() + charBuffer.arrayOffset();
            int iLimit = charBuffer.limit() + charBuffer.arrayOffset();
            char[] cArrArray2 = this.f8363c.array();
            int iPosition2 = this.f8363c.position() + this.f8363c.arrayOffset();
            while (iPosition < iLimit) {
                char c2 = cArrArray[iPosition];
                if (Character.isHighSurrogate(c2)) {
                    charBuffer.position(iPosition - charBuffer.arrayOffset());
                    CharBuffer charBuffer2 = this.f8363c;
                    charBuffer2.position(iPosition2 - charBuffer2.arrayOffset());
                    int iRemaining = charBuffer.remaining();
                    this.f8363c.flip();
                    IntBuffer intBufferAllocate = IntBuffer.allocate(Math.max(this.f8363c.remaining() + iRemaining, this.f8363c.capacity() / 2));
                    while (this.f8363c.hasRemaining()) {
                        intBufferAllocate.put(this.f8363c.get() & CharacterReader.EOF);
                    }
                    this.a = c.INT;
                    this.f8363c = null;
                    this.f8364d = intBufferAllocate;
                    b(charBuffer);
                    return;
                }
                cArrArray2[iPosition2] = c2;
                iPosition++;
                iPosition2++;
            }
            charBuffer.position(iPosition - charBuffer.arrayOffset());
            CharBuffer charBuffer3 = this.f8363c;
            charBuffer3.position(iPosition2 - charBuffer3.arrayOffset());
        }

        public final void b(CharBuffer charBuffer) {
            char[] cArrArray = charBuffer.array();
            int iPosition = charBuffer.position() + charBuffer.arrayOffset();
            int iLimit = charBuffer.limit() + charBuffer.arrayOffset();
            int[] iArrArray = this.f8364d.array();
            int iPosition2 = this.f8364d.position() + this.f8364d.arrayOffset();
            while (iPosition < iLimit) {
                char c2 = cArrArray[iPosition];
                iPosition++;
                if (this.f8365e != -1) {
                    if (Character.isLowSurrogate(c2)) {
                        iArrArray[iPosition2] = Character.toCodePoint((char) this.f8365e, c2);
                        iPosition2++;
                        this.f8365e = -1;
                    } else {
                        iArrArray[iPosition2] = this.f8365e;
                        iPosition2++;
                        if (Character.isHighSurrogate(c2)) {
                            this.f8365e = c2 & CharacterReader.EOF;
                        } else {
                            iArrArray[iPosition2] = 65535 & c2;
                            iPosition2++;
                            this.f8365e = -1;
                        }
                    }
                } else if (Character.isHighSurrogate(c2)) {
                    this.f8365e = c2 & CharacterReader.EOF;
                } else {
                    iArrArray[iPosition2] = c2 & CharacterReader.EOF;
                    iPosition2++;
                }
            }
            int i2 = this.f8365e;
            if (i2 != -1) {
                iArrArray[iPosition2] = i2 & 65535;
                iPosition2++;
            }
            charBuffer.position(iPosition - charBuffer.arrayOffset());
            IntBuffer intBuffer = this.f8364d;
            intBuffer.position(iPosition2 - intBuffer.arrayOffset());
        }
    }

    /* JADX INFO: compiled from: CodePointBuffer.java */
    public enum c {
        BYTE,
        CHAR,
        INT
    }

    public h(c cVar, ByteBuffer byteBuffer, CharBuffer charBuffer, IntBuffer intBuffer, a aVar) {
        this.a = cVar;
        this.f8359b = byteBuffer;
        this.f8360c = charBuffer;
        this.f8361d = intBuffer;
    }

    public int a() {
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            return this.f8359b.arrayOffset();
        }
        if (iOrdinal == 1) {
            return this.f8360c.arrayOffset();
        }
        if (iOrdinal == 2) {
            return this.f8361d.arrayOffset();
        }
        throw new UnsupportedOperationException("Not reached");
    }

    public int b() {
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            return this.f8359b.position();
        }
        if (iOrdinal == 1) {
            return this.f8360c.position();
        }
        if (iOrdinal == 2) {
            return this.f8361d.position();
        }
        throw new UnsupportedOperationException("Not reached");
    }

    public int c() {
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            return this.f8359b.remaining();
        }
        if (iOrdinal == 1) {
            return this.f8360c.remaining();
        }
        if (iOrdinal == 2) {
            return this.f8361d.remaining();
        }
        throw new UnsupportedOperationException("Not reached");
    }
}
