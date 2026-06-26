package org.mozilla.javascript.typedarrays;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes3.dex */
public class ByteIo {
    private static short doReadInt16(byte[] bArr, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i3 = bArr[i2] & ExifInterface.MARKER;
            i4 = (bArr[i2 + 1] & ExifInterface.MARKER) << 8;
        } else {
            i3 = (bArr[i2] & ExifInterface.MARKER) << 8;
            i4 = bArr[i2 + 1] & ExifInterface.MARKER;
        }
        return (short) (i4 | i3);
    }

    private static void doWriteInt16(byte[] bArr, int i2, int i3, boolean z) {
        if (z) {
            bArr[i2] = (byte) (i3 & 255);
            bArr[i2 + 1] = (byte) ((i3 >>> 8) & 255);
        } else {
            bArr[i2] = (byte) ((i3 >>> 8) & 255);
            bArr[i2 + 1] = (byte) (i3 & 255);
        }
    }

    public static Float readFloat32(byte[] bArr, int i2, boolean z) {
        return Float.valueOf(Float.intBitsToFloat((int) readUint32Primitive(bArr, i2, z)));
    }

    public static Double readFloat64(byte[] bArr, int i2, boolean z) {
        return Double.valueOf(Double.longBitsToDouble(readUint64Primitive(bArr, i2, z)));
    }

    public static Short readInt16(byte[] bArr, int i2, boolean z) {
        return Short.valueOf(doReadInt16(bArr, i2, z));
    }

    public static Integer readInt32(byte[] bArr, int i2, boolean z) {
        if (z) {
            return Integer.valueOf(((bArr[i2 + 3] & ExifInterface.MARKER) << 24) | (bArr[i2] & ExifInterface.MARKER) | ((bArr[i2 + 1] & ExifInterface.MARKER) << 8) | ((bArr[i2 + 2] & ExifInterface.MARKER) << 16));
        }
        return Integer.valueOf((bArr[i2 + 3] & ExifInterface.MARKER) | ((bArr[i2] & ExifInterface.MARKER) << 24) | ((bArr[i2 + 1] & ExifInterface.MARKER) << 16) | ((bArr[i2 + 2] & ExifInterface.MARKER) << 8));
    }

    public static Byte readInt8(byte[] bArr, int i2) {
        return Byte.valueOf(bArr[i2]);
    }

    public static Integer readUint16(byte[] bArr, int i2, boolean z) {
        return Integer.valueOf(doReadInt16(bArr, i2, z) & 65535);
    }

    public static Object readUint32(byte[] bArr, int i2, boolean z) {
        return Long.valueOf(readUint32Primitive(bArr, i2, z));
    }

    public static long readUint32Primitive(byte[] bArr, int i2, boolean z) {
        long j2;
        long j3;
        if (z) {
            j2 = ((((long) bArr[i2 + 2]) & 255) << 16) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8);
            j3 = (((long) bArr[i2 + 3]) & 255) << 24;
        } else {
            j2 = ((((long) bArr[i2 + 1]) & 255) << 16) | ((((long) bArr[i2]) & 255) << 24) | ((((long) bArr[i2 + 2]) & 255) << 8);
            j3 = ((long) bArr[i2 + 3]) & 255;
        }
        return (j3 | j2) & 4294967295L;
    }

    public static long readUint64Primitive(byte[] bArr, int i2, boolean z) {
        long j2;
        long j3;
        if (z) {
            j2 = ((((long) bArr[i2 + 2]) & 255) << 16) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            j3 = (((long) bArr[i2 + 7]) & 255) << 56;
        } else {
            j2 = ((((long) bArr[i2 + 1]) & 255) << 48) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i2 + 2]) & 255) << 40) | ((((long) bArr[i2 + 3]) & 255) << 32) | ((((long) bArr[i2 + 4]) & 255) << 24) | ((((long) bArr[i2 + 5]) & 255) << 16) | ((((long) bArr[i2 + 6]) & 255) << 8);
            j3 = (((long) bArr[i2 + 7]) & 255) << 0;
        }
        return j3 | j2;
    }

    public static Integer readUint8(byte[] bArr, int i2) {
        return Integer.valueOf(bArr[i2] & ExifInterface.MARKER);
    }

    public static void writeFloat32(byte[] bArr, int i2, double d2, boolean z) {
        writeUint32(bArr, i2, Float.floatToIntBits((float) d2), z);
    }

    public static void writeFloat64(byte[] bArr, int i2, double d2, boolean z) {
        writeUint64(bArr, i2, Double.doubleToLongBits(d2), z);
    }

    public static void writeInt16(byte[] bArr, int i2, int i3, boolean z) {
        doWriteInt16(bArr, i2, i3, z);
    }

    public static void writeInt32(byte[] bArr, int i2, int i3, boolean z) {
        if (z) {
            bArr[i2] = (byte) (i3 & 255);
            bArr[i2 + 1] = (byte) ((i3 >>> 8) & 255);
            bArr[i2 + 2] = (byte) ((i3 >>> 16) & 255);
            bArr[i2 + 3] = (byte) ((i3 >>> 24) & 255);
            return;
        }
        bArr[i2] = (byte) ((i3 >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i3 >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i3 >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i3 & 255);
    }

    public static void writeInt8(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) i3;
    }

    public static void writeUint16(byte[] bArr, int i2, int i3, boolean z) {
        doWriteInt16(bArr, i2, i3 & 65535, z);
    }

    public static void writeUint32(byte[] bArr, int i2, long j2, boolean z) {
        if (z) {
            bArr[i2] = (byte) (j2 & 255);
            bArr[i2 + 1] = (byte) ((j2 >>> 8) & 255);
            bArr[i2 + 2] = (byte) ((j2 >>> 16) & 255);
            bArr[i2 + 3] = (byte) ((j2 >>> 24) & 255);
            return;
        }
        bArr[i2] = (byte) ((j2 >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((j2 >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((j2 >>> 8) & 255);
        bArr[i2 + 3] = (byte) (j2 & 255);
    }

    public static void writeUint64(byte[] bArr, int i2, long j2, boolean z) {
        if (z) {
            bArr[i2] = (byte) (j2 & 255);
            bArr[i2 + 1] = (byte) ((j2 >>> 8) & 255);
            bArr[i2 + 2] = (byte) ((j2 >>> 16) & 255);
            bArr[i2 + 3] = (byte) ((j2 >>> 24) & 255);
            bArr[i2 + 4] = (byte) ((j2 >>> 32) & 255);
            bArr[i2 + 5] = (byte) ((j2 >>> 40) & 255);
            bArr[i2 + 6] = (byte) ((j2 >>> 48) & 255);
            bArr[i2 + 7] = (byte) ((j2 >>> 56) & 255);
            return;
        }
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        bArr[i2 + 1] = (byte) ((j2 >>> 48) & 255);
        bArr[i2 + 2] = (byte) ((j2 >>> 40) & 255);
        bArr[i2 + 3] = (byte) ((j2 >>> 32) & 255);
        bArr[i2 + 4] = (byte) ((j2 >>> 24) & 255);
        bArr[i2 + 5] = (byte) ((j2 >>> 16) & 255);
        bArr[i2 + 6] = (byte) ((j2 >>> 8) & 255);
        bArr[i2 + 7] = (byte) (j2 & 255);
    }

    public static void writeUint8(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 & 255);
    }
}
