package androidx.core.util;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import f.c0.b.l;
import f.c0.c.j;
import f.h0.a;
import f.v;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AtomicFile.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a7\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0087\b¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u0012\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\n*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/util/AtomicFile;", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "Lf/v;", "block", "tryWrite", "(Landroid/util/AtomicFile;Lf/c0/b/l;)V", "", "array", "writeBytes", "(Landroid/util/AtomicFile;[B)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Ljava/nio/charset/Charset;", "charset", "writeText", "(Landroid/util/AtomicFile;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "readBytes", "(Landroid/util/AtomicFile;)[B", "readText", "(Landroid/util/AtomicFile;Ljava/nio/charset/Charset;)Ljava/lang/String;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class AtomicFileKt {
    @RequiresApi(17)
    @NotNull
    public static final byte[] readBytes(@NotNull android.util.AtomicFile atomicFile) throws IOException {
        j.f(atomicFile, "$this$readBytes");
        byte[] fully = atomicFile.readFully();
        j.b(fully, "readFully()");
        return fully;
    }

    @RequiresApi(17)
    @NotNull
    public static final String readText(@NotNull android.util.AtomicFile atomicFile, @NotNull Charset charset) throws IOException {
        j.f(atomicFile, "$this$readText");
        j.f(charset, "charset");
        byte[] fully = atomicFile.readFully();
        j.b(fully, "readFully()");
        return new String(fully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = a.a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@NotNull android.util.AtomicFile atomicFile, @NotNull l<? super FileOutputStream, v> lVar) throws IOException {
        j.f(atomicFile, "$this$tryWrite");
        j.f(lVar, "block");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            j.b(fileOutputStreamStartWrite, "stream");
            lVar.invoke(fileOutputStreamStartWrite);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@NotNull android.util.AtomicFile atomicFile, @NotNull byte[] bArr) throws IOException {
        j.f(atomicFile, "$this$writeBytes");
        j.f(bArr, "array");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            j.b(fileOutputStreamStartWrite, "stream");
            fileOutputStreamStartWrite.write(bArr);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@NotNull android.util.AtomicFile atomicFile, @NotNull String str, @NotNull Charset charset) throws IOException {
        j.f(atomicFile, "$this$writeText");
        j.f(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        j.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        j.b(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = a.a;
        }
        writeText(atomicFile, str, charset);
    }
}
