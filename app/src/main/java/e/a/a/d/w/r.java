package e.a.a.d.w;

import e.a.a.h.y;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookDao;
import io.legado.app.data.dao.BookGroupDao;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.dao.BookmarkDao;
import io.legado.app.data.dao.HttpTTSDao;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.dao.RssStarDao;
import io.legado.app.data.dao.RuleSubDao;
import io.legado.app.data.dao.SearchKeywordDao;
import io.legado.app.data.dao.TxtTocRuleDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.Bookmark;
import io.legado.app.data.entities.HttpTTS;
import io.legado.app.data.entities.ReadRecord;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.data.entities.RssSource;
import io.legado.app.data.entities.RssStar;
import io.legado.app.data.entities.RuleSub;
import io.legado.app.data.entities.SearchKeyword;
import io.legado.app.data.entities.TxtTocRule;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Restore.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.help.storage.Restore$restoreDatabase$2", f = "Restore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class r extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $path;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String str, f.z.d<? super r> dVar) {
        super(2, dVar);
        this.$path = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new r(this.$path, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((r) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        List list8;
        List list9;
        List list10;
        List list11;
        List<ReadRecord> list12;
        Object objM11constructorimpl;
        Object objM11constructorimpl2;
        Object objM11constructorimpl3;
        Object objM11constructorimpl4;
        Object objM11constructorimpl5;
        Object objM11constructorimpl6;
        Object objM11constructorimpl7;
        Object objM11constructorimpl8;
        Object objM11constructorimpl9;
        Object objM11constructorimpl10;
        Object objM11constructorimpl11;
        Object objM11constructorimpl12;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        q qVar = q.a;
        String str = this.$path;
        try {
            try {
                Object objFromJson = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str + ((Object) File.separator) + "bookshelf.json"), null, 1), new y(Book.class));
                objM11constructorimpl12 = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl12 = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl12)) {
                objM11constructorimpl12 = null;
            }
            list = (List) objM11constructorimpl12;
        } catch (Exception e2) {
            e2.printStackTrace();
            list = null;
        }
        if (list != null) {
            BookDao bookDao = AppDatabaseKt.getAppDb().getBookDao();
            Object[] array = list.toArray(new Book[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Book[] bookArr = (Book[]) array;
            bookDao.insert((Book[]) Arrays.copyOf(bookArr, bookArr.length));
        }
        q qVar2 = q.a;
        String str2 = this.$path;
        try {
            try {
                Object objFromJson2 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str2 + ((Object) File.separator) + "bookmark.json"), null, 1), new y(Bookmark.class));
                objM11constructorimpl11 = f.h.m11constructorimpl(objFromJson2 instanceof List ? (List) objFromJson2 : null);
            } catch (Throwable th2) {
                objM11constructorimpl11 = f.h.m11constructorimpl(c.b.a.m.f.m1(th2));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl11)) {
                objM11constructorimpl11 = null;
            }
            list2 = (List) objM11constructorimpl11;
        } catch (Exception e3) {
            e3.printStackTrace();
            list2 = null;
        }
        if (list2 != null) {
            BookmarkDao bookmarkDao = AppDatabaseKt.getAppDb().getBookmarkDao();
            Object[] array2 = list2.toArray(new Bookmark[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            Bookmark[] bookmarkArr = (Bookmark[]) array2;
            bookmarkDao.insert((Bookmark[]) Arrays.copyOf(bookmarkArr, bookmarkArr.length));
        }
        q qVar3 = q.a;
        String str3 = this.$path;
        try {
            try {
                Object objFromJson3 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str3 + ((Object) File.separator) + "bookGroup.json"), null, 1), new y(BookGroup.class));
                objM11constructorimpl10 = f.h.m11constructorimpl(objFromJson3 instanceof List ? (List) objFromJson3 : null);
            } catch (Throwable th3) {
                objM11constructorimpl10 = f.h.m11constructorimpl(c.b.a.m.f.m1(th3));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl10)) {
                objM11constructorimpl10 = null;
            }
            list3 = (List) objM11constructorimpl10;
        } catch (Exception e4) {
            e4.printStackTrace();
            list3 = null;
        }
        if (list3 != null) {
            BookGroupDao bookGroupDao = AppDatabaseKt.getAppDb().getBookGroupDao();
            Object[] array3 = list3.toArray(new BookGroup[0]);
            Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T>");
            BookGroup[] bookGroupArr = (BookGroup[]) array3;
            bookGroupDao.insert((BookGroup[]) Arrays.copyOf(bookGroupArr, bookGroupArr.length));
        }
        q qVar4 = q.a;
        String str4 = this.$path;
        try {
            try {
                Object objFromJson4 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str4 + ((Object) File.separator) + "bookSource.json"), null, 1), new y(BookSource.class));
                objM11constructorimpl9 = f.h.m11constructorimpl(objFromJson4 instanceof List ? (List) objFromJson4 : null);
            } catch (Throwable th4) {
                objM11constructorimpl9 = f.h.m11constructorimpl(c.b.a.m.f.m1(th4));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl9)) {
                objM11constructorimpl9 = null;
            }
            list4 = (List) objM11constructorimpl9;
        } catch (Exception e5) {
            e5.printStackTrace();
            list4 = null;
        }
        if (list4 != null) {
            BookSourceDao bookSourceDao = AppDatabaseKt.getAppDb().getBookSourceDao();
            Object[] array4 = list4.toArray(new BookSource[0]);
            Objects.requireNonNull(array4, "null cannot be cast to non-null type kotlin.Array<T>");
            BookSource[] bookSourceArr = (BookSource[]) array4;
            bookSourceDao.insert((BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length));
        }
        q qVar5 = q.a;
        String str5 = this.$path;
        try {
            try {
                Object objFromJson5 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str5 + ((Object) File.separator) + "rssSources.json"), null, 1), new y(RssSource.class));
                objM11constructorimpl8 = f.h.m11constructorimpl(objFromJson5 instanceof List ? (List) objFromJson5 : null);
            } catch (Throwable th5) {
                objM11constructorimpl8 = f.h.m11constructorimpl(c.b.a.m.f.m1(th5));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl8)) {
                objM11constructorimpl8 = null;
            }
            list5 = (List) objM11constructorimpl8;
        } catch (Exception e6) {
            e6.printStackTrace();
            list5 = null;
        }
        if (list5 != null) {
            RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
            Object[] array5 = list5.toArray(new RssSource[0]);
            Objects.requireNonNull(array5, "null cannot be cast to non-null type kotlin.Array<T>");
            RssSource[] rssSourceArr = (RssSource[]) array5;
            rssSourceDao.insert((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
        }
        q qVar6 = q.a;
        String str6 = this.$path;
        try {
            try {
                Object objFromJson6 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str6 + ((Object) File.separator) + "rssStar.json"), null, 1), new y(RssStar.class));
                objM11constructorimpl7 = f.h.m11constructorimpl(objFromJson6 instanceof List ? (List) objFromJson6 : null);
            } catch (Throwable th6) {
                objM11constructorimpl7 = f.h.m11constructorimpl(c.b.a.m.f.m1(th6));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl7)) {
                objM11constructorimpl7 = null;
            }
            list6 = (List) objM11constructorimpl7;
        } catch (Exception e7) {
            e7.printStackTrace();
            list6 = null;
        }
        if (list6 != null) {
            RssStarDao rssStarDao = AppDatabaseKt.getAppDb().getRssStarDao();
            Object[] array6 = list6.toArray(new RssStar[0]);
            Objects.requireNonNull(array6, "null cannot be cast to non-null type kotlin.Array<T>");
            RssStar[] rssStarArr = (RssStar[]) array6;
            rssStarDao.insert((RssStar[]) Arrays.copyOf(rssStarArr, rssStarArr.length));
        }
        q qVar7 = q.a;
        String str7 = this.$path;
        try {
            try {
                Object objFromJson7 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str7 + ((Object) File.separator) + "replaceRule.json"), null, 1), new y(ReplaceRule.class));
                objM11constructorimpl6 = f.h.m11constructorimpl(objFromJson7 instanceof List ? (List) objFromJson7 : null);
            } catch (Throwable th7) {
                objM11constructorimpl6 = f.h.m11constructorimpl(c.b.a.m.f.m1(th7));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl6)) {
                objM11constructorimpl6 = null;
            }
            list7 = (List) objM11constructorimpl6;
        } catch (Exception e8) {
            e8.printStackTrace();
            list7 = null;
        }
        if (list7 != null) {
            ReplaceRuleDao replaceRuleDao = AppDatabaseKt.getAppDb().getReplaceRuleDao();
            Object[] array7 = list7.toArray(new ReplaceRule[0]);
            Objects.requireNonNull(array7, "null cannot be cast to non-null type kotlin.Array<T>");
            ReplaceRule[] replaceRuleArr = (ReplaceRule[]) array7;
            replaceRuleDao.insert((ReplaceRule[]) Arrays.copyOf(replaceRuleArr, replaceRuleArr.length));
        }
        q qVar8 = q.a;
        String str8 = this.$path;
        try {
            try {
                Object objFromJson8 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str8 + ((Object) File.separator) + "searchHistory.json"), null, 1), new y(SearchKeyword.class));
                objM11constructorimpl5 = f.h.m11constructorimpl(objFromJson8 instanceof List ? (List) objFromJson8 : null);
            } catch (Throwable th8) {
                objM11constructorimpl5 = f.h.m11constructorimpl(c.b.a.m.f.m1(th8));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl5)) {
                objM11constructorimpl5 = null;
            }
            list8 = (List) objM11constructorimpl5;
        } catch (Exception e9) {
            e9.printStackTrace();
            list8 = null;
        }
        if (list8 != null) {
            SearchKeywordDao searchKeywordDao = AppDatabaseKt.getAppDb().getSearchKeywordDao();
            Object[] array8 = list8.toArray(new SearchKeyword[0]);
            Objects.requireNonNull(array8, "null cannot be cast to non-null type kotlin.Array<T>");
            SearchKeyword[] searchKeywordArr = (SearchKeyword[]) array8;
            searchKeywordDao.insert((SearchKeyword[]) Arrays.copyOf(searchKeywordArr, searchKeywordArr.length));
        }
        q qVar9 = q.a;
        String str9 = this.$path;
        try {
            try {
                Object objFromJson9 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str9 + ((Object) File.separator) + "sourceSub.json"), null, 1), new y(RuleSub.class));
                objM11constructorimpl4 = f.h.m11constructorimpl(objFromJson9 instanceof List ? (List) objFromJson9 : null);
            } catch (Throwable th9) {
                objM11constructorimpl4 = f.h.m11constructorimpl(c.b.a.m.f.m1(th9));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl4)) {
                objM11constructorimpl4 = null;
            }
            list9 = (List) objM11constructorimpl4;
        } catch (Exception e10) {
            e10.printStackTrace();
            list9 = null;
        }
        if (list9 != null) {
            RuleSubDao ruleSubDao = AppDatabaseKt.getAppDb().getRuleSubDao();
            Object[] array9 = list9.toArray(new RuleSub[0]);
            Objects.requireNonNull(array9, "null cannot be cast to non-null type kotlin.Array<T>");
            RuleSub[] ruleSubArr = (RuleSub[]) array9;
            ruleSubDao.insert((RuleSub[]) Arrays.copyOf(ruleSubArr, ruleSubArr.length));
        }
        q qVar10 = q.a;
        String str10 = this.$path;
        try {
            try {
                Object objFromJson10 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str10 + ((Object) File.separator) + "txtTocRule.json"), null, 1), new y(TxtTocRule.class));
                objM11constructorimpl3 = f.h.m11constructorimpl(objFromJson10 instanceof List ? (List) objFromJson10 : null);
            } catch (Throwable th10) {
                objM11constructorimpl3 = f.h.m11constructorimpl(c.b.a.m.f.m1(th10));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl3)) {
                objM11constructorimpl3 = null;
            }
            list10 = (List) objM11constructorimpl3;
        } catch (Exception e11) {
            e11.printStackTrace();
            list10 = null;
        }
        if (list10 != null) {
            TxtTocRuleDao txtTocRuleDao = AppDatabaseKt.getAppDb().getTxtTocRuleDao();
            Object[] array10 = list10.toArray(new TxtTocRule[0]);
            Objects.requireNonNull(array10, "null cannot be cast to non-null type kotlin.Array<T>");
            TxtTocRule[] txtTocRuleArr = (TxtTocRule[]) array10;
            txtTocRuleDao.insert((TxtTocRule[]) Arrays.copyOf(txtTocRuleArr, txtTocRuleArr.length));
        }
        q qVar11 = q.a;
        String str11 = this.$path;
        try {
            try {
                Object objFromJson11 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str11 + ((Object) File.separator) + "httpTTS.json"), null, 1), new y(HttpTTS.class));
                objM11constructorimpl2 = f.h.m11constructorimpl(objFromJson11 instanceof List ? (List) objFromJson11 : null);
            } catch (Throwable th11) {
                objM11constructorimpl2 = f.h.m11constructorimpl(c.b.a.m.f.m1(th11));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl2)) {
                objM11constructorimpl2 = null;
            }
            list11 = (List) objM11constructorimpl2;
        } catch (Exception e12) {
            e12.printStackTrace();
            list11 = null;
        }
        if (list11 != null) {
            HttpTTSDao httpTTSDao = AppDatabaseKt.getAppDb().getHttpTTSDao();
            Object[] array11 = list11.toArray(new HttpTTS[0]);
            Objects.requireNonNull(array11, "null cannot be cast to non-null type kotlin.Array<T>");
            HttpTTS[] httpTTSArr = (HttpTTS[]) array11;
            httpTTSDao.insert((HttpTTS[]) Arrays.copyOf(httpTTSArr, httpTTSArr.length));
        }
        q qVar12 = q.a;
        String str12 = this.$path;
        try {
            try {
                Object objFromJson12 = e.a.a.h.n.a().fromJson(f.b0.d.d(FileUtils.a.b(str12 + ((Object) File.separator) + "readRecord.json"), null, 1), new y(ReadRecord.class));
                objM11constructorimpl = f.h.m11constructorimpl(objFromJson12 instanceof List ? (List) objFromJson12 : null);
            } catch (Throwable th12) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th12));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                objM11constructorimpl = null;
            }
            list12 = (List) objM11constructorimpl;
        } catch (Exception e13) {
            e13.printStackTrace();
            list12 = null;
        }
        if (list12 == null) {
            return null;
        }
        for (ReadRecord readRecord : list12) {
            String deviceId = readRecord.getDeviceId();
            e.a.a.c.c cVar = e.a.a.c.c.a;
            Object value = e.a.a.c.c.f5505k.getValue();
            f.c0.c.j.d(value, "<get-androidId>(...)");
            if (f.c0.c.j.a(deviceId, (String) value)) {
                Long readTime = AppDatabaseKt.getAppDb().getReadRecordDao().getReadTime(readRecord.getDeviceId(), readRecord.getBookName());
                if (readTime == null || readTime.longValue() < readRecord.getReadTime()) {
                    AppDatabaseKt.getAppDb().getReadRecordDao().insert(readRecord);
                }
            } else {
                AppDatabaseKt.getAppDb().getReadRecordDao().insert(readRecord);
            }
        }
        return v.a;
    }
}
