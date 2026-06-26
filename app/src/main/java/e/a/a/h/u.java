package e.a.a.h;

import androidx.core.app.NotificationCompat;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LogUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {

    @NotNull
    public static final u a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.e f5965b = c.b.a.m.f.N3(b.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f.e f5966c = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: compiled from: LogUtils.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<FileHandler> {
        public static final a INSTANCE = new a();

        /* JADX INFO: renamed from: e.a.a.h.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LogUtils.kt */
        public static final class C0166a extends Formatter {
            @Override // java.util.logging.Formatter
            @NotNull
            public String format(@NotNull LogRecord logRecord) {
                f.c0.c.j.e(logRecord, "record");
                StringBuilder sb = new StringBuilder();
                u uVar = u.a;
                f.c0.c.j.e("yyyy-MM-dd HH:mm:ss", "pattern");
                String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                f.c0.c.j.d(str, "sdf.format(date)");
                sb.append(str);
                sb.append(": ");
                sb.append((Object) logRecord.getMessage());
                sb.append('\n');
                return sb.toString();
            }
        }

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @Nullable
        public final FileHandler invoke() {
            File externalCacheDir = k.d.a.h.g().getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            FileUtils fileUtils = FileUtils.a;
            FileHandler fileHandler = new FileHandler(fileUtils.o(fileUtils.d(externalCacheDir, "logs"), "appLog"), 10240, 10);
            fileHandler.setFormatter(new C0166a());
            fileHandler.setLevel(c.b.a.m.f.K2(k.d.a.h.g(), "recordLog", false, 2) ? Level.INFO : Level.OFF);
            return fileHandler;
        }
    }

    /* JADX INFO: compiled from: LogUtils.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.a<Logger> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        public final Logger invoke() {
            Logger global = Logger.getGlobal();
            u uVar = u.a;
            FileHandler fileHandler = (FileHandler) u.f5966c.getValue();
            if (fileHandler != null) {
                global.addHandler(fileHandler);
            }
            return global;
        }
    }

    @JvmStatic
    public static final void a(@NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(str, "tag");
        f.c0.c.j.e(str2, NotificationCompat.CATEGORY_MESSAGE);
        Object value = f5965b.getValue();
        f.c0.c.j.d(value, "<get-logger>(...)");
        ((Logger) value).log(Level.INFO, str + ' ' + str2);
    }

    @JvmStatic
    public static final void b(@NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(str, "tag");
        f.c0.c.j.e(str2, NotificationCompat.CATEGORY_MESSAGE);
        Object value = f5965b.getValue();
        f.c0.c.j.d(value, "<get-logger>(...)");
        ((Logger) value).log(Level.WARNING, str + ' ' + str2);
    }

    public final void c() {
        FileHandler fileHandler = (FileHandler) f5966c.getValue();
        if (fileHandler == null) {
            return;
        }
        fileHandler.setLevel(c.b.a.m.f.K2(k.d.a.h.g(), "recordLog", false, 2) ? Level.INFO : Level.OFF);
    }
}
