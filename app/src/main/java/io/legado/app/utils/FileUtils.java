package io.legado.app.utils;

import c.b.a.m.f;
import f.c0.c.j;
import f.h0.k;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.d.a.h;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileUtils {

    @NotNull
    public static final FileUtils a = new FileUtils();

    /* JADX INFO: compiled from: FileUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/legado/app/utils/FileUtils$SortType;", "", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(f.w.a.SOURCE)
    public @interface SortType {
    }

    /* JADX INFO: compiled from: FileUtils.kt */
    public static final class a implements Comparator<File>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Object obj, Object obj2) {
            File file = (File) obj;
            File file2 = (File) obj2;
            if (file == null || file2 == null) {
                if (file == null) {
                    return -1;
                }
            } else {
                if (file.isDirectory() && file2.isFile()) {
                    return -1;
                }
                if (!file.isFile() || !file2.isDirectory()) {
                    String name = file.getName();
                    String name2 = file2.getName();
                    j.d(name, "s1");
                    j.d(name2, "s2");
                    return k.a(name, name2, true);
                }
            }
            return 1;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public static boolean g(FileUtils fileUtils, String str, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        j.e(str, "path");
        File file = new File(str);
        if (file.exists()) {
            return fileUtils.f(file, z);
        }
        return false;
    }

    public static File[] p(FileUtils fileUtils, String str, String[] strArr, int i2) throws IOException {
        File[] fileArr;
        File[] fileArr2;
        int i3 = i2 & 2;
        j.e(str, "startDirPath");
        j.e(str, "startDirPath");
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        final Pattern pattern = null;
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: e.a.a.h.c
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    Pattern pattern2 = pattern;
                    if (file2 == null || file2.isDirectory()) {
                        return false;
                    }
                    Matcher matcher = pattern2 == null ? null : pattern2.matcher(file2.getName());
                    if (matcher == null) {
                        return true;
                    }
                    return matcher.find();
                }
            });
            if (fileArrListFiles == null) {
                fileArr = new File[0];
            } else {
                int length = fileArrListFiles.length;
                int i4 = 0;
                while (i4 < length) {
                    File file2 = fileArrListFiles[i4];
                    i4++;
                    arrayList.add(file2.getAbsoluteFile());
                }
                Collections.sort(arrayList, new a());
                Object[] array = arrayList.toArray(new File[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                fileArr = (File[]) array;
            }
        } else {
            fileArr = new File[0];
        }
        j.e(str, "startDirPath");
        ArrayList arrayList2 = new ArrayList();
        File file3 = new File(str);
        if (file3.isDirectory()) {
            File[] fileArrListFiles2 = file3.listFiles(new FileFilter() { // from class: e.a.a.h.b
                @Override // java.io.FileFilter
                public final boolean accept(File file4) {
                    if (file4 == null) {
                        return false;
                    }
                    return file4.isDirectory();
                }
            });
            if (fileArrListFiles2 == null) {
                fileArr2 = new File[0];
            } else {
                String[] strArr2 = new String[0];
                int length2 = fileArrListFiles2.length;
                int i5 = 0;
                while (i5 < length2) {
                    File file4 = fileArrListFiles2[i5];
                    i5++;
                    File absoluteFile = file4.getAbsoluteFile();
                    String strD1 = f.d1(strArr2);
                    String name = absoluteFile.getName();
                    j.d(name, "file.name");
                    if (!k.d(strD1, name, false, 2)) {
                        arrayList2.add(absoluteFile);
                    }
                }
                Collections.sort(arrayList2, new a());
                Object[] array2 = arrayList2.toArray(new File[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                fileArr2 = (File[]) array2;
            }
        } else {
            fileArr2 = new File[0];
        }
        if (fileArr == null) {
            return null;
        }
        File[] fileArr3 = new File[fileArr2.length + fileArr.length];
        System.arraycopy(fileArr2, 0, fileArr3, 0, fileArr2.length);
        System.arraycopy(fileArr, 0, fileArr3, fileArr2.length, fileArr.length);
        return fileArr3;
    }

    @NotNull
    public final File a(@NotNull File file, @NotNull String... strArr) {
        j.e(file, "root");
        j.e(strArr, "subDirFiles");
        return b(o(file, (String[]) Arrays.copyOf(strArr, strArr.length)));
    }

    @NotNull
    public final synchronized File b(@NotNull String str) {
        File file;
        j.e(str, "filePath");
        file = new File(str);
        try {
            if (!file.exists()) {
                String parent = file.getParent();
                if (parent != null) {
                    j.e(parent, "filePath");
                    File file2 = new File(parent);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                }
                file.createNewFile();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return file;
    }

    @NotNull
    public final File c(@NotNull String str) throws IOException {
        j.e(str, "filePath");
        File file = new File(str);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            String parent = file.getParent();
            if (parent != null) {
                j.e(parent, "filePath");
                File file2 = new File(parent);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            file.createNewFile();
        }
        return file;
    }

    @NotNull
    public final File d(@NotNull File file, @NotNull String... strArr) {
        j.e(file, "root");
        j.e(strArr, "subDirs");
        return e(o(file, (String[]) Arrays.copyOf(strArr, strArr.length)));
    }

    @NotNull
    public final File e(@NotNull String str) {
        j.e(str, "filePath");
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @JvmOverloads
    public final boolean f(@NotNull File file, boolean z) {
        j.e(file, "file");
        if (file.isFile()) {
            return i(file);
        }
        File[] fileArrListFiles = file.listFiles();
        int i2 = 0;
        if (fileArrListFiles == null) {
            return false;
        }
        boolean zI = true;
        if (!(fileArrListFiles.length == 0)) {
            int length = fileArrListFiles.length;
            zI = false;
            while (i2 < length) {
                File file2 = fileArrListFiles[i2];
                i2++;
                j.d(file2, "f");
                f(file2, z);
                zI = i(file2);
            }
        } else if (!z || !i(file)) {
            zI = false;
        }
        return z ? i(file) : zI;
    }

    public final synchronized void h(@NotNull String str) {
        File[] fileArrListFiles;
        j.e(str, "filePath");
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    String path = file2.getPath();
                    FileUtils fileUtils = a;
                    j.d(path, "path");
                    fileUtils.h(path);
                }
            }
            file.delete();
        }
    }

    public final boolean i(File file) {
        File file2 = new File(j.k(file.getAbsolutePath(), Long.valueOf(System.currentTimeMillis())));
        file.renameTo(file2);
        return file2.delete();
    }

    public final boolean j(@NotNull String str) {
        j.e(str, "path");
        return new File(str).exists();
    }

    @NotNull
    public final String k() {
        File externalCacheDir = h.g().getExternalCacheDir();
        String absolutePath = externalCacheDir == null ? null : externalCacheDir.getAbsolutePath();
        if (absolutePath != null) {
            return absolutePath;
        }
        String absolutePath2 = h.g().getCacheDir().getAbsolutePath();
        j.d(absolutePath2, "appCtx.cacheDir.absolutePath");
        return absolutePath2;
    }

    @NotNull
    public final String l(@NotNull String str) {
        j.e(str, "pathOrUrl");
        int iT = k.t(str, '.', 0, false, 6);
        if (iT < 0) {
            return "ext";
        }
        String strSubstring = str.substring(iT + 1);
        j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @NotNull
    public final File m(@NotNull File file, @NotNull String... strArr) {
        j.e(file, "root");
        j.e(strArr, "subDirFiles");
        return new File(o(file, (String[]) Arrays.copyOf(strArr, strArr.length)));
    }

    @NotNull
    public final String n(@Nullable String str) {
        if (str == null) {
            return "";
        }
        int iT = k.t(str, Attributes.InternalPrefix, 0, false, 6);
        if (iT >= 0) {
            String strSubstring = str.substring(iT + 1);
            j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        return System.currentTimeMillis() + '.' + l(str);
    }

    @NotNull
    public final String o(@NotNull File file, @NotNull String... strArr) {
        j.e(file, "root");
        j.e(strArr, "subDirFiles");
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (String str : strArr) {
            if (str.length() > 0) {
                sb.append(File.separator);
                sb.append(str);
            }
        }
        String string = sb.toString();
        j.d(string, "path.toString()");
        return string;
    }
}
