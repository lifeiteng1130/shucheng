package e.a.a.d;

import android.net.Uri;
import e.a.a.h.b0;
import e.a.a.h.v;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.model.localBook.LocalBook;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookHelp.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    @NotNull
    public static final g a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final File f5530b = c.b.a.m.f.r2(k.d.a.h.g());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final CopyOnWriteArraySet<String> f5531c = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final f.e f5532d = c.b.a.m.f.N3(b.INSTANCE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final f.e f5533e = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final f.e f5534f = c.b.a.m.f.N3(e.INSTANCE);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final f.e f5535g = c.b.a.m.f.N3(c.INSTANCE);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final f.e f5536h = c.b.a.m.f.N3(d.INSTANCE);

    /* JADX INFO: compiled from: BookHelp.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<Pattern> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        public final Pattern invoke() {
            return Pattern.compile("^(.*?第([\\d零〇一二两三四五六七八九十百千万壹贰叁肆伍陆柒捌玖拾佰仟０-９\\s]+)[章节篇回集])[、，。\u3000：:.\\s]*");
        }
    }

    /* JADX INFO: compiled from: BookHelp.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.a<k.b.a.b.b.a> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final k.b.a.b.b.a invoke() {
            return new k.b.a.b.b.a();
        }
    }

    /* JADX INFO: compiled from: BookHelp.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.a<f.h0.g> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final f.h0.g invoke() {
            return new f.h0.g("\\s");
        }
    }

    /* JADX INFO: compiled from: BookHelp.kt */
    public static final class d extends f.c0.c.k implements f.c0.b.a<f.h0.g> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final f.h0.g invoke() {
            return new f.h0.g("^第.*?章|[(\\[][^()\\[\\]]{2,}[)\\]]$");
        }
    }

    /* JADX INFO: compiled from: BookHelp.kt */
    public static final class e extends f.c0.c.k implements f.c0.b.a<f.h0.g> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final f.h0.g invoke() {
            return new f.h0.g("[^\\w\\u4E00-\\u9FEF〇\\u3400-\\u4DBF\\u20000-\\u2A6DF\\u2A700-\\u2EBEF]");
        }
    }

    /* JADX INFO: compiled from: BookHelp.kt */
    @DebugMetadata(c = "io.legado.app.help.BookHelp", f = "BookHelp.kt", i = {}, l = {96}, m = "saveContent", n = {}, s = {})
    public static final class f extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public f(f.z.d<? super f> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return g.this.l(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: e.a.a.d.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BookHelp.kt */
    @DebugMetadata(c = "io.legado.app.help.BookHelp", f = "BookHelp.kt", i = {0, 0, 0}, l = {105, 113}, m = "saveImage", n = {"this", "book", "src"}, s = {"L$0", "L$1", "L$2"})
    public static final class C0147g extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public C0147g(f.z.d<? super C0147g> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return g.this.m(null, null, this);
        }
    }

    @NotNull
    public final String a(@NotNull String str) {
        f.c0.c.j.e(str, "author");
        e.a.a.c.d dVar = e.a.a.c.d.a;
        String strReplace = e.a.a.c.d.f5512f.replace(str, "");
        int length = strReplace.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = f.c0.c.j.g(strReplace.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        return strReplace.subSequence(i2, length + 1).toString();
    }

    @NotNull
    public final String b(@NotNull String str) {
        f.c0.c.j.e(str, "name");
        e.a.a.c.d dVar = e.a.a.c.d.a;
        String strReplace = e.a.a.c.d.f5511e.replace(str, "");
        int length = strReplace.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = f.c0.c.j.g(strReplace.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        return strReplace.subSequence(i2, length + 1).toString();
    }

    @NotNull
    public final List<String> c(@NotNull Book book) {
        String[] list;
        f.c0.c.j.e(book, "book");
        ArrayList arrayList = new ArrayList();
        if (!book.isLocalTxt() && (list = FileUtils.a.d(f5530b, "book_cache", book.getFolderName()).list()) != null) {
            c.b.a.m.f.T(arrayList, list);
        }
        return arrayList;
    }

    public final int d(String str) {
        if (str == null) {
            return -1;
        }
        Matcher matcher = ((Pattern) f5533e.getValue()).matcher(str);
        f.c0.c.j.d(matcher, "chapterNamePattern.matcher(chapterName)");
        if (matcher.find()) {
            return b0.a.b(matcher.group(2));
        }
        return -1;
    }

    @Nullable
    public final String e(@NotNull Book book, @NotNull BookChapter bookChapter) {
        f.c0.c.j.e(book, "book");
        f.c0.c.j.e(bookChapter, "bookChapter");
        if (book.isLocalTxt()) {
            return LocalBook.INSTANCE.getContext(book, bookChapter);
        }
        if (book.isEpub() && !k(book, bookChapter)) {
            String context = LocalBook.INSTANCE.getContext(book, bookChapter);
            if (context != null) {
                f.b0.d.f(FileUtils.a.a(f5530b, "book_cache", book.getFolderName(), bookChapter.getFileName()), context, null, 2);
            }
            return context;
        }
        File file = f5530b;
        String[] strArr = {"book_cache", book.getFolderName(), bookChapter.getFileName()};
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr, "subDirFiles");
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr2, "subDirFiles");
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (String str : strArr2) {
            if (str.length() > 0) {
                sb.append(File.separator);
                sb.append(str);
            }
        }
        String string = sb.toString();
        f.c0.c.j.d(string, "path.toString()");
        File file2 = new File(string);
        if (file2.exists()) {
            return f.b0.d.d(file2, null, 1);
        }
        return null;
    }

    public final int f(int i2, int i3, @Nullable String str, @NotNull List<BookChapter> list) {
        double d2;
        int i4;
        int iD;
        String str2;
        int i5;
        int i6;
        Double dValueOf;
        f.c0.c.j.e(list, "newChapterList");
        if (i3 == 0 || list.isEmpty()) {
            return i2;
        }
        int iD2 = d(str);
        String strJ = j(str);
        int size = list.size();
        int iMax = Math.max(0, Math.min(i2, r6) - 10);
        int iMin = Math.min(size - 1, Math.max(i2, (i2 - i3) + size) + 10);
        if ((strJ.length() > 0) && iMax <= iMin) {
            int i7 = iMax;
            double dDoubleValue = 0.0d;
            i4 = 0;
            while (true) {
                int i8 = i7 + 1;
                String strJ2 = j(list.get(i7).getTitle());
                Objects.requireNonNull((k.b.a.b.b.a) f5532d.getValue());
                if (strJ == null || strJ2 == null) {
                    break;
                }
                int length = strJ.length();
                int length2 = strJ2.length();
                if (length == 0 || length2 == 0) {
                    str2 = strJ;
                    i5 = i4;
                    i6 = i8;
                    dValueOf = Double.valueOf(0.0d);
                } else {
                    HashSet hashSet = new HashSet();
                    i5 = i4;
                    int i9 = 0;
                    while (i9 < length) {
                        hashSet.add(Character.valueOf(strJ.charAt(i9)));
                        i9++;
                        strJ = strJ;
                    }
                    str2 = strJ;
                    HashSet hashSet2 = new HashSet();
                    for (int i10 = 0; i10 < length2; i10++) {
                        hashSet2.add(Character.valueOf(strJ2.charAt(i10)));
                    }
                    HashSet hashSet3 = new HashSet(hashSet);
                    hashSet3.addAll(hashSet2);
                    int size2 = hashSet.size();
                    i6 = i8;
                    dValueOf = Double.valueOf((((double) ((hashSet2.size() + size2) - hashSet3.size())) * 1.0d) / ((double) hashSet3.size()));
                }
                f.c0.c.j.d(dValueOf, "temp");
                if (dValueOf.doubleValue() > dDoubleValue) {
                    dDoubleValue = dValueOf.doubleValue();
                    i4 = i7;
                } else {
                    i4 = i5;
                }
                if (i7 == iMin) {
                    d2 = dDoubleValue;
                    break;
                }
                i7 = i6;
                strJ = str2;
            }
            throw new IllegalArgumentException("Input cannot be null");
        }
        d2 = 0.0d;
        i4 = 0;
        if (d2 >= 0.96d || iD2 <= 0 || iMax > iMin) {
            iD = 0;
        } else {
            int i11 = 0;
            while (true) {
                int i12 = iMax + 1;
                iD = d(list.get(iMax).getTitle());
                if (iD == iD2) {
                    i4 = iMax;
                    break;
                }
                if (Math.abs(iD - iD2) < Math.abs(i11 - iD2)) {
                    i4 = iMax;
                    i11 = iD;
                }
                if (iMax == iMin) {
                    iD = i11;
                    break;
                }
                iMax = i12;
            }
        }
        return (d2 > 0.96d || Math.abs(iD - iD2) < 1) ? i4 : Math.min(Math.max(0, list.size() - 1), i2);
    }

    @NotNull
    public final File g(@NotNull Book book) throws Throwable {
        byte[] bArr;
        FileOutputStream fileOutputStream;
        f.c0.c.j.e(book, "book");
        File file = f5530b;
        String[] strArr = {"book_cache", book.getFolderName(), "index.epubx"};
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr, "subDirFiles");
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr2, "subDirFiles");
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (String str : strArr2) {
            if (str.length() > 0) {
                sb.append(File.separator);
                sb.append(str);
            }
        }
        String string = sb.toString();
        f.c0.c.j.d(string, "path.toString()");
        File file2 = new File(string);
        if (!file2.exists()) {
            InputStream inputStreamOpenInputStream = c.b.a.m.f.t3(book.getBookUrl()) ? k.d.a.h.g().getContentResolver().openInputStream(Uri.parse(book.getBookUrl())) : new FileInputStream(new File(book.getBookUrl()));
            if (inputStreamOpenInputStream != null) {
                f.c0.c.j.e(file2, "file");
                f.c0.c.j.e(inputStreamOpenInputStream, "data");
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        if (!file2.exists()) {
                            File parentFile = file2.getParentFile();
                            if (parentFile != null) {
                                parentFile.mkdirs();
                            }
                            file2.createNewFile();
                        }
                        bArr = new byte[4096];
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                while (true) {
                    try {
                        int i2 = inputStreamOpenInputStream.read(bArr, 0, 4096);
                        if (i2 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    } catch (IOException unused3) {
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        return file2;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
                inputStreamOpenInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        return file2;
    }

    @NotNull
    public final File h(@NotNull Book book, @NotNull String str) {
        f.c0.c.j.e(book, "book");
        f.c0.c.j.e(str, "src");
        File file = f5530b;
        String[] strArr = {"book_cache", book.getFolderName(), "images", f.c0.c.j.k(v.b(str), i(str))};
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr, "subDirFiles");
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr2, "subDirFiles");
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (String str2 : strArr2) {
            if (str2.length() > 0) {
                sb.append(File.separator);
                sb.append(str2);
            }
        }
        String string = sb.toString();
        f.c0.c.j.d(string, "path.toString()");
        return new File(string);
    }

    @NotNull
    public final String i(@NotNull String str) {
        f.c0.c.j.e(str, "src");
        String strP = f.h0.k.P(f.h0.k.O(str, ".", null, 2), ",", null, 2);
        return strP.length() > 5 ? ".jpg" : strP;
    }

    public final String j(String str) {
        if (str == null) {
            return "";
        }
        return ((f.h0.g) f5534f.getValue()).replace(((f.h0.g) f5536h.getValue()).replace(((f.h0.g) f5535g.getValue()).replace(b0.a.a(str), ""), ""), "");
    }

    public final boolean k(@NotNull Book book, @NotNull BookChapter bookChapter) {
        f.c0.c.j.e(book, "book");
        f.c0.c.j.e(bookChapter, "bookChapter");
        if (book.isLocalTxt()) {
            return true;
        }
        File file = f5530b;
        String[] strArr = {"book_cache", book.getFolderName(), bookChapter.getFileName()};
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr, "subDirFiles");
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, 3);
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr2, "subDirFiles");
        String[] strArr3 = (String[]) Arrays.copyOf(strArr2, strArr2.length);
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr3, "subDirFiles");
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (String str : strArr3) {
            if (str.length() > 0) {
                sb.append(File.separator);
                sb.append(str);
            }
        }
        String string = sb.toString();
        f.c0.c.j.d(string, "path.toString()");
        return new File(string).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(@org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r10, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.BookChapter r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull f.z.d<? super f.v> r13) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r13 instanceof e.a.a.d.g.f
            if (r0 == 0) goto L13
            r0 = r13
            e.a.a.d.g$f r0 = (e.a.a.d.g.f) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.d.g$f r0 = new e.a.a.d.g$f
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r10 = r0.L$2
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r0.L$1
            io.legado.app.data.entities.BookChapter r11 = (io.legado.app.data.entities.BookChapter) r11
            java.lang.Object r12 = r0.L$0
            io.legado.app.data.entities.Book r12 = (io.legado.app.data.entities.Book) r12
            c.b.a.m.f.E5(r13)
            goto L7f
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            c.b.a.m.f.E5(r13)
            int r13 = r12.length()
            r2 = 0
            if (r13 != 0) goto L47
            r13 = 1
            goto L48
        L47:
            r13 = 0
        L48:
            if (r13 == 0) goto L4d
            f.v r10 = f.v.a
            return r10
        L4d:
            io.legado.app.utils.FileUtils r13 = io.legado.app.utils.FileUtils.a
            java.io.File r4 = e.a.a.d.g.f5530b
            r5 = 3
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.String r6 = "book_cache"
            r5[r2] = r6
            java.lang.String r6 = r10.getFolderName()
            r5[r3] = r6
            java.lang.String r6 = r11.getFileName()
            r7 = 2
            r5[r7] = r6
            java.io.File r13 = r13.a(r4, r5)
            r4 = 0
            f.b0.d.f(r13, r12, r4, r7)
            java.lang.String r13 = "\n"
            java.lang.String[] r13 = new java.lang.String[]{r13}
            r4 = 6
            java.util.List r12 = f.h0.k.F(r12, r13, r2, r2, r4)
            java.util.Iterator r12 = r12.iterator()
            r8 = r12
            r12 = r10
            r10 = r8
        L7f:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto Lbb
            java.lang.Object r13 = r10.next()
            java.lang.String r13 = (java.lang.String) r13
            e.a.a.c.d r2 = e.a.a.c.d.a
            java.util.regex.Pattern r2 = e.a.a.c.d.f5510d
            java.util.regex.Matcher r13 = r2.matcher(r13)
            boolean r2 = r13.find()
            if (r2 == 0) goto L7f
            java.lang.String r13 = r13.group(r3)
            if (r13 != 0) goto La0
            goto L7f
        La0:
            e.a.a.h.x r2 = e.a.a.h.x.a
            java.lang.String r2 = r11.getUrl()
            java.lang.String r13 = e.a.a.h.x.a(r2, r13)
            e.a.a.d.g r2 = e.a.a.d.g.a
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r13 = r2.m(r12, r13, r0)
            if (r13 != r1) goto L7f
            return r1
        Lbb:
            java.lang.String r10 = "saveContent"
            com.jeremyliao.liveeventbus.core.Observable r10 = com.jeremyliao.liveeventbus.LiveEventBus.get(r10)
            r10.post(r11)
            f.v r10 = f.v.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.g.l(io.legado.app.data.entities.Book, io.legado.app.data.entities.BookChapter, java.lang.String, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff A[Catch: all -> 0x003a, Exception -> 0x003d, NoSuchAlgorithmException -> 0x011e, TryCatch #0 {Exception -> 0x003d, blocks: (B:13:0x0035, B:37:0x00b8, B:38:0x00d7, B:40:0x00ff, B:42:0x0109, B:43:0x010c, B:44:0x0114, B:48:0x0124, B:51:0x014b, B:47:0x011f), top: B:63:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(@org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r24, @org.jetbrains.annotations.NotNull java.lang.String r25, @org.jetbrains.annotations.NotNull f.z.d<? super f.v> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.g.m(io.legado.app.data.entities.Book, java.lang.String, f.z.d):java.lang.Object");
    }
}
