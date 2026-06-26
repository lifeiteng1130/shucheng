package okio;

import f.c0.c.j;
import f.h0.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\u0002\u0010\t\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\b¢\u0006\u0004\b\u0006\u0010\n\u001a\u001d\u0010\u0002\u001a\u00020\u0001*\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0002\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0001*\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u000b¢\u0006\u0004\b\u0006\u0010\u0011\u001a'\u0010\u0002\u001a\u00020\u0001*\u00020\u00122\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0004\b\u0002\u0010\u0016\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00122\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0004\b\u0006\u0010\u0017\"$\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u001e\u0010 \u001a\u00020\f*\u00060\u001ej\u0002`\u001f8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Ljava/io/OutputStream;", "Lokio/Sink;", "sink", "(Ljava/io/OutputStream;)Lokio/Sink;", "Ljava/io/InputStream;", "Lokio/Source;", "source", "(Ljava/io/InputStream;)Lokio/Source;", "Ljava/net/Socket;", "(Ljava/net/Socket;)Lokio/Sink;", "(Ljava/net/Socket;)Lokio/Source;", "Ljava/io/File;", "", "append", "(Ljava/io/File;Z)Lokio/Sink;", "appendingSink", "(Ljava/io/File;)Lokio/Sink;", "(Ljava/io/File;)Lokio/Source;", "Ljava/nio/file/Path;", "", "Ljava/nio/file/OpenOption;", "options", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "getLogger$Okio__JvmOkioKt", "()Ljava/util/logging/Logger;", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "isAndroidGetsocknameError", "(Ljava/lang/AssertionError;)Z", "okio"}, k = 5, mv = {1, 4, 0}, xs = "okio/Okio")
public final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    @NotNull
    public static final Sink appendingSink(@NotNull File file) {
        j.e(file, "$this$appendingSink");
        return Okio.sink(new FileOutputStream(file, true));
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError assertionError) {
        j.e(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? k.d(message, "getsockname failed", false, 2) : false;
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file) {
        return sink$default(file, false, 1, null);
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream outputStream) {
        j.e(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    @NotNull
    public static final Source source(@NotNull InputStream inputStream) {
        j.e(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    @NotNull
    public static final Sink sink(@NotNull Socket socket) throws IOException {
        j.e(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        j.d(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @NotNull
    public static final Source source(@NotNull Socket socket) throws IOException {
        j.e(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        j.d(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file, boolean z) {
        j.e(file, "$this$sink");
        return Okio.sink(new FileOutputStream(file, z));
    }

    @NotNull
    public static final Source source(@NotNull File file) {
        j.e(file, "$this$source");
        return Okio.source(new FileInputStream(file));
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        j.e(path, "$this$sink");
        j.e(openOptionArr, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        j.d(outputStreamNewOutputStream, "Files.newOutputStream(this, *options)");
        return Okio.sink(outputStreamNewOutputStream);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        j.e(path, "$this$source");
        j.e(openOptionArr, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        j.d(inputStreamNewInputStream, "Files.newInputStream(this, *options)");
        return Okio.source(inputStreamNewInputStream);
    }
}
