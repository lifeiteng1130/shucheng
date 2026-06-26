package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FileUtil {
    private FileUtil() {
    }

    @SuppressLint({"LambdaLast"})
    public static void copy(@NonNull ReadableByteChannel readableByteChannel, @NonNull FileChannel fileChannel) {
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream inputStreamNewInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream outputStreamNewOutputStream = Channels.newOutputStream(fileChannel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int i2 = inputStreamNewInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    } else {
                        outputStreamNewOutputStream.write(bArr, 0, i2);
                    }
                }
            } else {
                fileChannel.transferFrom(readableByteChannel, 0L, RecyclerView.FOREVER_NS);
            }
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
