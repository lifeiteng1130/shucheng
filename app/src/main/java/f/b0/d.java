package f.b0;

import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.umeng.analytics.pro.n;
import f.c0.c.j;
import f.h0.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static File a(File file, File file2, boolean z, int i2, int i3) throws IOException {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 8192;
        }
        j.e(file, "$this$copyTo");
        j.e(file2, "target");
        if (!file.exists()) {
            throw new e(file, null, "The source file doesn't exist.", 2, null);
        }
        if (file2.exists()) {
            if (!z) {
                throw new b(file, file2, "The destination file already exists.");
            }
            if (!file2.delete()) {
                throw new b(file, file2, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = file2.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    f.g1(fileInputStream, fileOutputStream, i2);
                    f.P0(fileOutputStream, null);
                    f.P0(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!file2.mkdirs()) {
            throw new c(file, file2, "Failed to create target directory.");
        }
        return file2;
    }

    @NotNull
    public static final String b(@NotNull File file) {
        j.e(file, "$this$extension");
        String name = file.getName();
        j.d(name, "name");
        return k.N(name, '.', "");
    }

    @NotNull
    public static final byte[] c(@NotNull File file) {
        j.e(file, "$this$readBytes");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i2 = (int) length;
            byte[] bArrCopyOf = new byte[i2];
            int i3 = i2;
            int i4 = 0;
            while (i3 > 0) {
                int i5 = fileInputStream.read(bArrCopyOf, i4, i3);
                if (i5 < 0) {
                    break;
                }
                i3 -= i5;
                i4 += i5;
            }
            if (i3 > 0) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i4);
                j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            } else {
                int i6 = fileInputStream.read();
                if (i6 != -1) {
                    a aVar = new a(n.a.p);
                    aVar.write(i6);
                    f.h1(fileInputStream, aVar, 0, 2);
                    int size = aVar.size() + i2;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = aVar.a();
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                    j.d(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                    f.x.e.c(bArrA, bArrCopyOf, i2, 0, aVar.size());
                }
            }
            f.P0(fileInputStream, null);
            return bArrCopyOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.P0(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static String d(File file, Charset charset, int i2) {
        Charset charset2 = (i2 & 1) != 0 ? f.h0.a.a : null;
        j.e(file, "$this$readText");
        j.e(charset2, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset2);
        try {
            String strC4 = f.C4(inputStreamReader);
            f.P0(inputStreamReader, null);
            return strC4;
        } finally {
        }
    }

    public static final void e(@NotNull File file, @NotNull byte[] bArr) {
        j.e(file, "$this$writeBytes");
        j.e(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            f.P0(fileOutputStream, null);
        } finally {
        }
    }

    public static void f(File file, String str, Charset charset, int i2) {
        Charset charset2 = (i2 & 2) != 0 ? f.h0.a.a : null;
        j.e(file, "$this$writeText");
        j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        j.e(charset2, "charset");
        byte[] bytes = str.getBytes(charset2);
        j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        e(file, bytes);
    }
}
