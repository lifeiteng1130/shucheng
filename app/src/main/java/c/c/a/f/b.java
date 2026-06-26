package c.c.a.f;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.multidex.MultiDexExtractor;
import c.c.a.x.f;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Closeable {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RandomAccessFile f693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FileChannel f694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FileLock f695f;

    public static class a extends File {
        public long a;

        public a(File file, String str) {
            super(file, str);
            this.a = -1L;
        }
    }

    public b(File file, File file2) {
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.a = file;
        this.f692c = file2;
        this.f691b = e(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f693d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f694e = channel;
            try {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Blocking on lock " + file3.getPath());
                this.f695f = channel.lock();
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex " + file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                c(this.f694e);
                throw e;
            } catch (Error e3) {
                e = e3;
                c(this.f694e);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                c(this.f694e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            c(this.f693d);
            throw e5;
        }
    }

    public static void c(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to close resource", e2);
        }
    }

    public static void d(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), MultiDexExtractor.EXTRACTED_SUFFIX, file.getParentFile());
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        zipOutputStream.write(bArr, 0, i2);
                    }
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Renaming to " + file.getPath());
                if (fileCreateTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            c(inputStream);
            fileCreateTempFile.delete();
        }
    }

    public static long e(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            f fVarQ = c.b.a.m.f.q(randomAccessFile);
            CRC32 crc32 = new CRC32();
            long j2 = fVarQ.f813b;
            randomAccessFile.seek(fVarQ.a);
            int iMin = (int) Math.min(16384L, j2);
            byte[] bArr = new byte[16384];
            while (true) {
                int i2 = randomAccessFile.read(bArr, 0, iMin);
                if (i2 == -1) {
                    break;
                }
                crc32.update(bArr, 0, i2);
                j2 -= (long) i2;
                if (j2 == 0) {
                    break;
                }
                iMin = (int) Math.min(16384L, j2);
            }
            long value = crc32.getValue();
            randomAccessFile.close();
            return value == -1 ? value - 1 : value;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public final List<a> a(Context context, String str) throws IOException {
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex loading existing secondary dex files");
        String str2 = this.a.getName() + ".classes";
        SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", 4);
        int i2 = sharedPreferences.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + (-1));
        int i3 = 2;
        while (i3 <= i2) {
            a aVar = new a(this.f692c, c.a.a.a.a.d(str2, i3, MultiDexExtractor.EXTRACTED_SUFFIX));
            if (!aVar.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + aVar.getPath() + "'");
            }
            aVar.a = e(aVar);
            long j2 = sharedPreferences.getLong(str + "dex.crc." + i3, -1L);
            long j3 = sharedPreferences.getLong(str + "dex.time." + i3, -1L);
            long jLastModified = aVar.lastModified();
            if (j3 == jLastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (j2 == aVar.a) {
                    arrayList.add(aVar);
                    i3++;
                    sharedPreferences = sharedPreferences2;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + aVar + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + jLastModified + ", expected crc: " + j2 + ", file crc: " + aVar.a);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0266, code lost:
    
        throw new java.io.IOException("Could not create zip file " + r13.getAbsolutePath() + " for secondary dex (" + r11 + ")");
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0162 A[Catch: all -> 0x0332, TryCatch #0 {all -> 0x0332, blocks: (B:37:0x015c, B:39:0x0162, B:43:0x0196, B:45:0x019d, B:49:0x01be, B:53:0x01cc, B:55:0x01fb, B:57:0x0204, B:48:0x01a7, B:61:0x0228, B:62:0x0244, B:63:0x0266), top: B:88:0x015c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0267 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<? extends java.io.File> b(android.content.Context r22, java.lang.String r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.f.b.b(android.content.Context, java.lang.String, boolean):java.util.List");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f695f.release();
        this.f694e.close();
        this.f693d.close();
    }
}
