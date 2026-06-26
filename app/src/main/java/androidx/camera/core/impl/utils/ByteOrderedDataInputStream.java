package androidx.camera.core.impl.utils;

import c.a.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class ByteOrderedDataInputStream extends InputStream implements DataInput {
    private ByteOrder mByteOrder;
    private final DataInputStream mDataInputStream;
    public final int mLength;
    public int mPosition;
    private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;

    public ByteOrderedDataInputStream(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.mDataInputStream.available();
    }

    public int getLength() {
        return this.mLength;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        synchronized (this.mDataInputStream) {
            this.mDataInputStream.mark(i2);
        }
    }

    public int peek() {
        return this.mPosition;
    }

    @Override // java.io.InputStream
    public int read() {
        this.mPosition++;
        return this.mDataInputStream.read();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        this.mPosition++;
        return this.mDataInputStream.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws EOFException {
        int i2 = this.mPosition + 1;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i3 = this.mDataInputStream.read();
        if (i3 >= 0) {
            return (byte) i3;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() {
        this.mPosition += 2;
        return this.mDataInputStream.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.mPosition + i3;
        this.mPosition = i4;
        if (i4 > this.mLength) {
            throw new EOFException();
        }
        if (this.mDataInputStream.read(bArr, i2, i3) != i3) {
            throw new IOException("Couldn't read up to the length of buffer");
        }
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        int i2 = this.mPosition + 4;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i3 = this.mDataInputStream.read();
        int i4 = this.mDataInputStream.read();
        int i5 = this.mDataInputStream.read();
        int i6 = this.mDataInputStream.read();
        if ((i3 | i4 | i5 | i6) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (i6 << 24) + (i5 << 16) + (i4 << 8) + i3;
        }
        if (byteOrder == BIG_ENDIAN) {
            return (i3 << 24) + (i4 << 16) + (i5 << 8) + i6;
        }
        StringBuilder sbR = a.r("Invalid byte order: ");
        sbR.append(this.mByteOrder);
        throw new IOException(sbR.toString());
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine() not implemented.");
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        int i2 = this.mPosition + 8;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i3 = this.mDataInputStream.read();
        int i4 = this.mDataInputStream.read();
        int i5 = this.mDataInputStream.read();
        int i6 = this.mDataInputStream.read();
        int i7 = this.mDataInputStream.read();
        int i8 = this.mDataInputStream.read();
        int i9 = this.mDataInputStream.read();
        int i10 = this.mDataInputStream.read();
        if ((i3 | i4 | i5 | i6 | i7 | i8 | i9 | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (((long) i10) << 56) + (((long) i9) << 48) + (((long) i8) << 40) + (((long) i7) << 32) + (((long) i6) << 24) + (((long) i5) << 16) + (((long) i4) << 8) + ((long) i3);
        }
        if (byteOrder == BIG_ENDIAN) {
            return (((long) i3) << 56) + (((long) i4) << 48) + (((long) i5) << 40) + (((long) i6) << 32) + (((long) i7) << 24) + (((long) i8) << 16) + (((long) i9) << 8) + ((long) i10);
        }
        StringBuilder sbR = a.r("Invalid byte order: ");
        sbR.append(this.mByteOrder);
        throw new IOException(sbR.toString());
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        int i2 = this.mPosition + 2;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i3 = this.mDataInputStream.read();
        int i4 = this.mDataInputStream.read();
        if ((i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (short) ((i4 << 8) + i3);
        }
        if (byteOrder == BIG_ENDIAN) {
            return (short) ((i3 << 8) + i4);
        }
        StringBuilder sbR = a.r("Invalid byte order: ");
        sbR.append(this.mByteOrder);
        throw new IOException(sbR.toString());
    }

    @Override // java.io.DataInput
    public String readUTF() {
        this.mPosition += 2;
        return this.mDataInputStream.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        this.mPosition++;
        return this.mDataInputStream.readUnsignedByte();
    }

    public long readUnsignedInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        int i2 = this.mPosition + 2;
        this.mPosition = i2;
        if (i2 > this.mLength) {
            throw new EOFException();
        }
        int i3 = this.mDataInputStream.read();
        int i4 = this.mDataInputStream.read();
        if ((i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (i4 << 8) + i3;
        }
        if (byteOrder == BIG_ENDIAN) {
            return (i3 << 8) + i4;
        }
        StringBuilder sbR = a.r("Invalid byte order: ");
        sbR.append(this.mByteOrder);
        throw new IOException(sbR.toString());
    }

    public void seek(long j2) throws IOException {
        int i2 = this.mPosition;
        if (i2 > j2) {
            this.mPosition = 0;
            this.mDataInputStream.reset();
            this.mDataInputStream.mark(this.mLength);
        } else {
            j2 -= (long) i2;
        }
        int i3 = (int) j2;
        if (skipBytes(i3) != i3) {
            throw new IOException("Couldn't seek up to the byteCount");
        }
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i2) {
        int iMin = Math.min(i2, this.mLength - this.mPosition);
        int iSkipBytes = 0;
        while (iSkipBytes < iMin) {
            iSkipBytes += this.mDataInputStream.skipBytes(iMin - iSkipBytes);
        }
        this.mPosition += iSkipBytes;
        return iSkipBytes;
    }

    public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) {
        this.mByteOrder = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.mDataInputStream = dataInputStream;
        int iAvailable = dataInputStream.available();
        this.mLength = iAvailable;
        this.mPosition = 0;
        dataInputStream.mark(iAvailable);
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.mDataInputStream.read(bArr, i2, i3);
        this.mPosition += i4;
        return i4;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        int length = this.mPosition + bArr.length;
        this.mPosition = length;
        if (length <= this.mLength) {
            if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
            return;
        }
        throw new EOFException();
    }

    public ByteOrderedDataInputStream(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
