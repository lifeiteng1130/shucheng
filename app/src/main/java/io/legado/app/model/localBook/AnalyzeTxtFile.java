package io.legado.app.model.localBook;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import c.a.a.a.a;
import com.umeng.analytics.pro.ai;
import e.a.a.d.m;
import e.a.a.h.b0;
import e.a.a.h.l;
import e.a.a.h.v;
import f.b0.d;
import f.c0.c.f;
import f.c0.c.j;
import f.c0.c.y;
import f.h0.k;
import f.x.e;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.TxtTocRuleDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.TxtTocRule;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AnalyzeTxtFile.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lio/legado/app/model/localBook/AnalyzeTxtFile;", "", "Ljava/io/RandomAccessFile;", "bookStream", "Lio/legado/app/data/entities/Book;", "book", "Ljava/util/regex/Pattern;", "pattern", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/BookChapter;", "Lkotlin/collections/ArrayList;", "analyze", "(Ljava/io/RandomAccessFile;Lio/legado/app/data/entities/Book;Ljava/util/regex/Pattern;)Ljava/util/ArrayList;", "Lio/legado/app/data/entities/TxtTocRule;", "getTocRule", "(Ljava/io/RandomAccessFile;)Lio/legado/app/data/entities/TxtTocRule;", "(Lio/legado/app/data/entities/Book;)Ljava/util/ArrayList;", "Ljava/nio/charset/Charset;", "charset", "Ljava/nio/charset/Charset;", "tocRules", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AnalyzeTxtFile {
    private static final byte BLANK = 10;
    private static final int BUFFER_SIZE = 524288;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_LENGTH_WITH_NO_CHAPTER = 10240;
    private Charset charset;

    @NotNull
    private final ArrayList<TxtTocRule> tocRules = new ArrayList<>();

    /* JADX INFO: compiled from: AnalyzeTxtFile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0019"}, d2 = {"Lio/legado/app/model/localBook/AnalyzeTxtFile$Companion;", "", "Lio/legado/app/data/entities/Book;", "book", "Ljava/io/File;", "getBookFile", "(Lio/legado/app/data/entities/Book;)Ljava/io/File;", "", "Lio/legado/app/data/entities/TxtTocRule;", "getTocRules", "()Ljava/util/List;", "Lio/legado/app/data/entities/BookChapter;", "bookChapter", "", "getContent", "(Lio/legado/app/data/entities/Book;Lio/legado/app/data/entities/BookChapter;)Ljava/lang/String;", "", "BLANK", "B", "", "BUFFER_SIZE", OptRuntime.GeneratorState.resumptionPoint_TYPE, "MAX_LENGTH_WITH_NO_CHAPTER", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File getBookFile(Book book) throws IllegalAccessException, IOException, InvocationTargetException {
            if (!c.b.a.m.f.t3(book.getBookUrl())) {
                return new File(book.getBookUrl());
            }
            Uri uri = Uri.parse(book.getBookUrl());
            File cacheFolder = LocalBook.INSTANCE.getCacheFolder();
            String[] strArr = {book.getOriginName()};
            j.e(cacheFolder, "root");
            j.e(strArr, "subDirFiles");
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            j.e(cacheFolder, "root");
            j.e(strArr2, "subDirFiles");
            StringBuilder sb = new StringBuilder(cacheFolder.getAbsolutePath());
            for (String str : strArr2) {
                if (str.length() > 0) {
                    sb.append(File.separator);
                    sb.append(str);
                }
            }
            String string = sb.toString();
            j.d(string, "path.toString()");
            File file = new File(string);
            if (!file.exists()) {
                file.createNewFile();
                Context contextG = h.g();
                j.d(uri, "uri");
                byte[] bArrE = e.a.a.h.j.e(contextG, uri);
                if (bArrE != null) {
                    d.e(file, bArrE);
                }
            }
            return file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TxtTocRule> getTocRules() {
            List<TxtTocRule> enabled = AppDatabaseKt.getAppDb().getTxtTocRuleDao().getEnabled();
            if (!enabled.isEmpty()) {
                return enabled;
            }
            m mVar = m.a;
            List list = (List) m.f5547d.getValue();
            TxtTocRuleDao txtTocRuleDao = AppDatabaseKt.getAppDb().getTxtTocRuleDao();
            Object[] array = list.toArray(new TxtTocRule[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            TxtTocRule[] txtTocRuleArr = (TxtTocRule[]) array;
            txtTocRuleDao.insert((TxtTocRule[]) Arrays.copyOf(txtTocRuleArr, txtTocRuleArr.length));
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((TxtTocRule) obj).getEnable()) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        @NotNull
        public final String getContent(@NotNull Book book, @NotNull BookChapter bookChapter) throws IOException {
            j.e(book, "book");
            j.e(bookChapter, "bookChapter");
            RandomAccessFile randomAccessFile = new RandomAccessFile(getBookFile(book), "r");
            Long end = bookChapter.getEnd();
            j.c(end);
            long jLongValue = end.longValue();
            Long start = bookChapter.getStart();
            j.c(start);
            byte[] bArr = new byte[(int) (jLongValue - start.longValue())];
            Long start2 = bookChapter.getStart();
            j.c(start2);
            randomAccessFile.seek(start2.longValue());
            randomAccessFile.read(bArr);
            return a.j("^[\\n\\s]+", k.M(new String(bArr, book.fileCharset()), bookChapter.getTitle(), null, 2), "\u3000\u3000");
        }
    }

    private final TxtTocRule getTocRule(RandomAccessFile bookStream) throws IOException {
        byte[] bArr = new byte[131072];
        int i2 = bookStream.read(bArr, 0, 131072);
        Charset charset = this.charset;
        if (charset == null) {
            j.m("charset");
            throw null;
        }
        String str = new String(bArr, 0, i2, charset);
        for (TxtTocRule txtTocRule : this.tocRules) {
            if (Pattern.compile(txtTocRule.getRule(), 8).matcher(str).find()) {
                return txtTocRule;
            }
        }
        return null;
    }

    @NotNull
    public final ArrayList<BookChapter> analyze(@NotNull Book book) throws IllegalAccessException, IOException, InvocationTargetException {
        Pattern patternCompile;
        j.e(book, "book");
        Companion companion = INSTANCE;
        File bookFile = companion.getBookFile(book);
        if (book.getCharset() == null) {
            book.setCharset(l.a(bookFile));
        }
        this.charset = book.fileCharset();
        if (book.getTocUrl().length() > 0) {
            patternCompile = Pattern.compile(book.getTocUrl(), 8);
        } else {
            this.tocRules.addAll(companion.getTocRules());
            patternCompile = null;
        }
        return analyze(new RandomAccessFile(bookFile, "r"), book, patternCompile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    private final ArrayList<BookChapter> analyze(RandomAccessFile bookStream, Book book, Pattern pattern) throws IOException {
        TxtTocRule tocRule;
        Pattern patternCompile;
        long j2;
        ?? r21;
        byte[] bArr;
        Book book2;
        RandomAccessFile randomAccessFile;
        int i2;
        int i3;
        int i4;
        RandomAccessFile randomAccessFile2;
        int i5;
        long j3;
        int i6;
        String strSubstring;
        Long start;
        AnalyzeTxtFile analyzeTxtFile = this;
        RandomAccessFile randomAccessFile3 = bookStream;
        Book book3 = book;
        long j4 = 0;
        randomAccessFile3.seek(0L);
        ArrayList<BookChapter> arrayList = new ArrayList<>();
        if (pattern == null) {
            tocRule = getTocRule(bookStream);
            patternCompile = tocRule == null ? null : Pattern.compile(tocRule.getRule(), 8);
        } else {
            tocRule = null;
            patternCompile = pattern;
        }
        byte[] bArr2 = new byte[524288];
        randomAccessFile3.seek(0L);
        ?? r10 = 0;
        int i7 = 0;
        int i8 = 0;
        RandomAccessFile randomAccessFile4 = randomAccessFile3;
        ?? r8 = patternCompile;
        while (true) {
            int i9 = randomAccessFile4.read(bArr2);
            if (i9 > 0) {
                int i10 = i7 + 1;
                if (r8 != 0) {
                    Charset charset = analyzeTxtFile.charset;
                    if (charset != null) {
                        ?? str = new String(bArr2, (int) r10, i9, charset);
                        bArr = bArr2;
                        int iU = k.u(str, "\n", r10, r10, 6);
                        int i11 = i9;
                        ?? r11 = str;
                        if (iU > 0) {
                            String strSubstring2 = str.substring(r10, iU);
                            j.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            Charset charset2 = analyzeTxtFile.charset;
                            if (charset2 != null) {
                                byte[] bytes = strSubstring2.getBytes(charset2);
                                j.d(bytes, "(this as java.lang.String).getBytes(charset)");
                                int length = bytes.length;
                                i8 += length;
                                i11 = length;
                                randomAccessFile4.seek(i8);
                                r11 = strSubstring2;
                            } else {
                                j.m("charset");
                                throw null;
                            }
                        }
                        int i12 = i11;
                        Matcher matcher = r8.matcher(r11);
                        int i13 = i8;
                        j.d(matcher, "rulePattern.matcher(blockContent)");
                        int length2 = 0;
                        ?? r82 = r8;
                        ?? r112 = r11;
                        while (true) {
                            ?? r212 = r82;
                            if (matcher.find()) {
                                int iStart = matcher.start();
                                int i14 = i12;
                                String strSubstring3 = r112.substring(length2, iStart);
                                j.d(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                ?? r22 = r112;
                                Charset charset3 = analyzeTxtFile.charset;
                                if (charset3 != null) {
                                    byte[] bytes2 = strSubstring3.getBytes(charset3);
                                    j.d(bytes2, "(this as java.lang.String).getBytes(charset)");
                                    int length3 = bytes2.length;
                                    BookChapter bookChapter = (BookChapter) e.s(arrayList);
                                    Matcher matcher2 = matcher;
                                    long j5 = length3;
                                    if ((j4 + j5) - ((bookChapter == null || (start = bookChapter.getStart()) == null) ? 0L : start.longValue()) > 50000 && pattern == null) {
                                        ArrayList<TxtTocRule> arrayList2 = analyzeTxtFile.tocRules;
                                        Objects.requireNonNull(arrayList2, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                                        y.a(arrayList2).remove(tocRule);
                                        return analyzeTxtFile.analyze(randomAccessFile4, book3, null);
                                    }
                                    if (length2 == 0 && iStart != 0) {
                                        if (arrayList.isEmpty()) {
                                            b0 b0Var = b0.a;
                                            j.e(strSubstring3, ai.az);
                                            if (TextUtils.isEmpty(strSubstring3)) {
                                                strSubstring = "";
                                                j3 = j4;
                                            } else {
                                                int length4 = strSubstring3.length();
                                                int i15 = length4 - 1;
                                                j3 = j4;
                                                int i16 = 0;
                                                while (true) {
                                                    i6 = i15;
                                                    if (i16 >= i15 || (strSubstring3.charAt(i16) > ' ' && strSubstring3.charAt(i16) != 12288)) {
                                                        break;
                                                    }
                                                    i16++;
                                                    i15 = i6;
                                                }
                                                int i17 = i6;
                                                while (i16 < i17 && (strSubstring3.charAt(i17) <= ' ' || strSubstring3.charAt(i17) == 12288)) {
                                                    i17--;
                                                }
                                                if (i17 < length4) {
                                                    i17++;
                                                }
                                                if (i16 > 0 || i17 < length4) {
                                                    strSubstring = strSubstring3.substring(i16, i17);
                                                    j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                } else {
                                                    strSubstring = strSubstring3;
                                                }
                                            }
                                            if (strSubstring.length() > 0) {
                                                BookChapter bookChapter2 = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
                                                bookChapter2.setTitle("前言");
                                                bookChapter2.setStart(0L);
                                                bookChapter2.setEnd(Long.valueOf(j5));
                                                arrayList.add(bookChapter2);
                                            }
                                            BookChapter bookChapter3 = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
                                            String strGroup = matcher2.group();
                                            j.d(strGroup, "matcher.group()");
                                            bookChapter3.setTitle(strGroup);
                                            bookChapter3.setStart(Long.valueOf(j5));
                                            arrayList.add(bookChapter3);
                                        } else {
                                            j3 = j4;
                                            BookChapter bookChapter4 = (BookChapter) e.r(arrayList);
                                            Long end = bookChapter4.getEnd();
                                            j.c(end);
                                            bookChapter4.setEnd(Long.valueOf(end.longValue() + j5));
                                            BookChapter bookChapter5 = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
                                            String strGroup2 = matcher2.group();
                                            j.d(strGroup2, "matcher.group()");
                                            bookChapter5.setTitle(strGroup2);
                                            bookChapter5.setStart(bookChapter4.getEnd());
                                            arrayList.add(bookChapter5);
                                        }
                                    } else {
                                        j3 = j4;
                                        if (!arrayList.isEmpty()) {
                                            BookChapter bookChapter6 = (BookChapter) e.r(arrayList);
                                            Long start2 = bookChapter6.getStart();
                                            j.c(start2);
                                            long jLongValue = start2.longValue();
                                            Charset charset4 = analyzeTxtFile.charset;
                                            if (charset4 != null) {
                                                byte[] bytes3 = strSubstring3.getBytes(charset4);
                                                j.d(bytes3, "(this as java.lang.String).getBytes(charset)");
                                                bookChapter6.setEnd(Long.valueOf(jLongValue + ((long) bytes3.length)));
                                                BookChapter bookChapter7 = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
                                                String strGroup3 = matcher2.group();
                                                j.d(strGroup3, "matcher.group()");
                                                bookChapter7.setTitle(strGroup3);
                                                bookChapter7.setStart(bookChapter6.getEnd());
                                                arrayList.add(bookChapter7);
                                            } else {
                                                j.m("charset");
                                                throw null;
                                            }
                                        } else {
                                            BookChapter bookChapter8 = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
                                            String strGroup4 = matcher2.group();
                                            j.d(strGroup4, "matcher.group()");
                                            bookChapter8.setTitle(strGroup4);
                                            bookChapter8.setStart(0L);
                                            bookChapter8.setEnd(0L);
                                            arrayList.add(bookChapter8);
                                        }
                                    }
                                    length2 += strSubstring3.length();
                                    randomAccessFile4 = bookStream;
                                    book3 = book;
                                    i12 = i14;
                                    r82 = r212;
                                    r112 = r22;
                                    matcher = matcher2;
                                    j4 = j3;
                                } else {
                                    j.m("charset");
                                    throw null;
                                }
                            } else {
                                j2 = j4;
                                int i18 = i12;
                                if (length2 == 0) {
                                    i5 = i18;
                                    if (i5 > 50000 && pattern == null) {
                                        ArrayList<TxtTocRule> arrayList3 = analyzeTxtFile.tocRules;
                                        Objects.requireNonNull(arrayList3, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                                        y.a(arrayList3).remove(tocRule);
                                        return analyzeTxtFile.analyze(bookStream, book, null);
                                    }
                                    randomAccessFile = bookStream;
                                    book2 = book;
                                } else {
                                    randomAccessFile = bookStream;
                                    book2 = book;
                                    i5 = i18;
                                }
                                randomAccessFile4 = randomAccessFile;
                                i3 = i5;
                                i2 = i10;
                                i8 = i13;
                                r21 = r212;
                            }
                        }
                    } else {
                        j.m("charset");
                        throw null;
                    }
                } else {
                    j2 = j4;
                    r21 = r8;
                    bArr = bArr2;
                    int i19 = i9;
                    book2 = book3;
                    randomAccessFile = randomAccessFile3;
                    int i20 = 0;
                    int i21 = 0;
                    int i22 = i19;
                    while (i22 > 0) {
                        i20++;
                        if (i22 > MAX_LENGTH_WITH_NO_CHAPTER) {
                            int i23 = i21 + MAX_LENGTH_WITH_NO_CHAPTER;
                            int i24 = i19;
                            if (i23 < i24) {
                                while (true) {
                                    int i25 = i23 + 1;
                                    if (bArr[i23] == 10) {
                                        break;
                                    }
                                    if (i25 >= i24) {
                                        break;
                                    }
                                    i23 = i25;
                                }
                                i23 = i24;
                                BookChapter bookChapter9 = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
                                bookChapter9.setTitle((char) 31532 + i10 + "章(" + i20 + ')');
                                i4 = i8;
                                randomAccessFile2 = randomAccessFile4;
                                bookChapter9.setStart(Long.valueOf(j2 + ((long) i21) + 1));
                                bookChapter9.setEnd(Long.valueOf(j2 + ((long) i23)));
                                arrayList.add(bookChapter9);
                                i22 -= i23 - i21;
                                i21 = i23;
                                i19 = i24;
                            } else {
                                i23 = i24;
                                BookChapter bookChapter92 = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
                                bookChapter92.setTitle((char) 31532 + i10 + "章(" + i20 + ')');
                                i4 = i8;
                                randomAccessFile2 = randomAccessFile4;
                                bookChapter92.setStart(Long.valueOf(j2 + ((long) i21) + 1));
                                bookChapter92.setEnd(Long.valueOf(j2 + ((long) i23)));
                                arrayList.add(bookChapter92);
                                i22 -= i23 - i21;
                                i21 = i23;
                                i19 = i24;
                            }
                        } else {
                            i4 = i8;
                            randomAccessFile2 = randomAccessFile4;
                            BookChapter bookChapter10 = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
                            bookChapter10.setTitle((char) 31532 + i10 + "章(" + i20 + ')');
                            bookChapter10.setStart(Long.valueOf(j2 + ((long) i21) + 1));
                            bookChapter10.setEnd(Long.valueOf(j2 + ((long) i19)));
                            arrayList.add(bookChapter10);
                            i22 = 0;
                        }
                        i8 = i4;
                        randomAccessFile4 = randomAccessFile2;
                    }
                    i2 = i10;
                    i3 = i19;
                }
                long j6 = j2 + ((long) i3);
                if (r21 != 0) {
                    ((BookChapter) e.r(arrayList)).setEnd(Long.valueOf(j6));
                }
                if (i2 % 15 == 0) {
                    System.gc();
                    System.runFinalization();
                }
                r10 = 0;
                i7 = i2;
                bArr2 = bArr;
                r8 = r21;
                analyzeTxtFile = this;
                randomAccessFile3 = randomAccessFile;
                book3 = book2;
                j4 = j6;
            } else {
                Book book4 = book3;
                bookStream.close();
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    int i26 = 0;
                    while (true) {
                        int i27 = i26 + 1;
                        BookChapter bookChapter11 = arrayList.get(i26);
                        j.d(bookChapter11, "toc[i]");
                        BookChapter bookChapter12 = bookChapter11;
                        bookChapter12.setIndex(i26);
                        bookChapter12.setBookUrl(book.getBookUrl());
                        bookChapter12.setUrl(v.b(book.getOriginName() + i26 + bookChapter12.getTitle()));
                        if (i27 > size) {
                            break;
                        }
                        i26 = i27;
                    }
                }
                book4.setLatestChapterTitle(((BookChapter) e.r(arrayList)).getTitle());
                book4.setTotalChapterNum(arrayList.size());
                System.gc();
                System.runFinalization();
                if (tocRule != null) {
                    book4.setTocUrl(tocRule.getRule());
                }
                return arrayList;
            }
        }
    }
}
