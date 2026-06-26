package io.legado.app.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import e.a.a.c.c;
import e.a.a.d.e;
import f.c0.c.f;
import f.c0.c.j;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.dao.BookDao;
import io.legado.app.data.dao.BookGroupDao;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.dao.BookmarkDao;
import io.legado.app.data.dao.CacheDao;
import io.legado.app.data.dao.CookieDao;
import io.legado.app.data.dao.HttpTTSDao;
import io.legado.app.data.dao.ReadRecordDao;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.dao.RssArticleDao;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.dao.RssStarDao;
import io.legado.app.data.dao.RuleSubDao;
import io.legado.app.data.dao.SearchBookDao;
import io.legado.app.data.dao.SearchKeywordDao;
import io.legado.app.data.dao.TxtTocRuleDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.Bookmark;
import io.legado.app.data.entities.Cache;
import io.legado.app.data.entities.Cookie;
import io.legado.app.data.entities.HttpTTS;
import io.legado.app.data.entities.ReadRecord;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssReadRecord;
import io.legado.app.data.entities.RssSource;
import io.legado.app.data.entities.RssStar;
import io.legado.app.data.entities.RuleSub;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.data.entities.SearchKeyword;
import io.legado.app.data.entities.TxtTocRule;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AppDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Database(entities = {Book.class, BookGroup.class, BookSource.class, BookChapter.class, ReplaceRule.class, SearchBook.class, SearchKeyword.class, Cookie.class, RssSource.class, Bookmark.class, RssArticle.class, RssReadRecord.class, RssStar.class, TxtTocRule.class, ReadRecord.class, HttpTTS.class, Cache.class, RuleSub.class}, exportSchema = true, version = 32)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\bF\u0010GR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006I"}, d2 = {"Lio/legado/app/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "Lio/legado/app/data/dao/TxtTocRuleDao;", "getTxtTocRuleDao", "()Lio/legado/app/data/dao/TxtTocRuleDao;", "txtTocRuleDao", "Lio/legado/app/data/dao/CacheDao;", "getCacheDao", "()Lio/legado/app/data/dao/CacheDao;", "cacheDao", "Lio/legado/app/data/dao/RuleSubDao;", "getRuleSubDao", "()Lio/legado/app/data/dao/RuleSubDao;", "ruleSubDao", "Lio/legado/app/data/dao/SearchKeywordDao;", "getSearchKeywordDao", "()Lio/legado/app/data/dao/SearchKeywordDao;", "searchKeywordDao", "Lio/legado/app/data/dao/BookmarkDao;", "getBookmarkDao", "()Lio/legado/app/data/dao/BookmarkDao;", "bookmarkDao", "Lio/legado/app/data/dao/HttpTTSDao;", "getHttpTTSDao", "()Lio/legado/app/data/dao/HttpTTSDao;", "httpTTSDao", "Lio/legado/app/data/dao/RssStarDao;", "getRssStarDao", "()Lio/legado/app/data/dao/RssStarDao;", "rssStarDao", "Lio/legado/app/data/dao/ReplaceRuleDao;", "getReplaceRuleDao", "()Lio/legado/app/data/dao/ReplaceRuleDao;", "replaceRuleDao", "Lio/legado/app/data/dao/RssSourceDao;", "getRssSourceDao", "()Lio/legado/app/data/dao/RssSourceDao;", "rssSourceDao", "Lio/legado/app/data/dao/ReadRecordDao;", "getReadRecordDao", "()Lio/legado/app/data/dao/ReadRecordDao;", "readRecordDao", "Lio/legado/app/data/dao/RssArticleDao;", "getRssArticleDao", "()Lio/legado/app/data/dao/RssArticleDao;", "rssArticleDao", "Lio/legado/app/data/dao/BookGroupDao;", "getBookGroupDao", "()Lio/legado/app/data/dao/BookGroupDao;", "bookGroupDao", "Lio/legado/app/data/dao/BookChapterDao;", "getBookChapterDao", "()Lio/legado/app/data/dao/BookChapterDao;", "bookChapterDao", "Lio/legado/app/data/dao/SearchBookDao;", "getSearchBookDao", "()Lio/legado/app/data/dao/SearchBookDao;", "searchBookDao", "Lio/legado/app/data/dao/BookDao;", "getBookDao", "()Lio/legado/app/data/dao/BookDao;", "bookDao", "Lio/legado/app/data/dao/CookieDao;", "getCookieDao", "()Lio/legado/app/data/dao/CookieDao;", "cookieDao", "Lio/legado/app/data/dao/BookSourceDao;", "getBookSourceDao", "()Lio/legado/app/data/dao/BookSourceDao;", "bookSourceDao", "<init>", "()V", "Companion", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AppDatabase extends RoomDatabase {

    @NotNull
    private static final String DATABASE_NAME = "legado.db";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AppDatabase$Companion$dbCallback$1 dbCallback = new RoomDatabase.Callback() { // from class: io.legado.app.data.AppDatabase$Companion$dbCallback$1
        @Override // androidx.room.RoomDatabase.Callback
        public void onCreate(@NotNull SupportSQLiteDatabase db) {
            j.e(db, "db");
            db.setLocale(Locale.CHINESE);
        }

        @Override // androidx.room.RoomDatabase.Callback
        public void onOpen(@NotNull SupportSQLiteDatabase db) {
            j.e(db, "db");
            db.execSQL("insert into book_groups(groupId, groupName, 'order', show) select -1, '全部', -10, 1\n                    where not exists (select * from book_groups where groupId = -1)");
            db.execSQL("insert into book_groups(groupId, groupName, 'order', show) select -2, '本地', -9, 1\n                    where not exists (select * from book_groups where groupId = -2)");
            db.execSQL("insert into book_groups(groupId, groupName, 'order', show) select -3, '音频', -8, 1\n                    where not exists (select * from book_groups where groupId = -3)");
            db.execSQL("insert into book_groups(groupId, groupName, 'order', show) select -4, '未分组', -7, 1\n                    where not exists (select * from book_groups where groupId = -4)");
            e eVar = e.a;
            if (e.f5517b) {
                db.execSQL("\n                        delete from rssSources where sourceUrl = 'https://github.com/gedoor/legado/releases'\n                    ");
            }
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_10_11$1 migration_10_11 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_10_11$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("DROP TABLE txtTocRules");
            database.execSQL("CREATE TABLE txtTocRules(id INTEGER NOT NULL, \n                    name TEXT NOT NULL, rule TEXT NOT NULL, serialNumber INTEGER NOT NULL, \n                    enable INTEGER NOT NULL, PRIMARY KEY (id))");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_11_12$1 migration_11_12 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_11_12$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE rssSources ADD style TEXT ");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_12_13$1 migration_12_13 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_12_13$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE rssSources ADD articleStyle INTEGER NOT NULL DEFAULT 0 ");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_13_14$1 migration_13_14 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_13_14$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `books_new` (`bookUrl` TEXT NOT NULL, `tocUrl` TEXT NOT NULL, `origin` TEXT NOT NULL,\n                    `originName` TEXT NOT NULL, `name` TEXT NOT NULL, `author` TEXT NOT NULL, `kind` TEXT, `customTag` TEXT, `coverUrl` TEXT, \n                    `customCoverUrl` TEXT, `intro` TEXT, `customIntro` TEXT, `charset` TEXT, `type` INTEGER NOT NULL, `group` INTEGER NOT NULL, \n                    `latestChapterTitle` TEXT, `latestChapterTime` INTEGER NOT NULL, `lastCheckTime` INTEGER NOT NULL, `lastCheckCount` INTEGER NOT NULL, \n                    `totalChapterNum` INTEGER NOT NULL, `durChapterTitle` TEXT, `durChapterIndex` INTEGER NOT NULL, `durChapterPos` INTEGER NOT NULL, \n                    `durChapterTime` INTEGER NOT NULL, `wordCount` TEXT, `canUpdate` INTEGER NOT NULL, `order` INTEGER NOT NULL, \n                    `originOrder` INTEGER NOT NULL, `useReplaceRule` INTEGER NOT NULL, `variable` TEXT, PRIMARY KEY(`bookUrl`))");
            database.execSQL("INSERT INTO books_new select * from books ");
            database.execSQL("DROP TABLE books");
            database.execSQL("ALTER TABLE books_new RENAME TO books");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_books_name_author` ON `books` (`name`, `author`) ");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_14_15$1 migration_14_15 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_14_15$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE bookmarks ADD bookAuthor TEXT NOT NULL DEFAULT ''");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_15_17$1 migration_15_17 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_15_17$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `readRecord` (`bookName` TEXT NOT NULL, `readTime` INTEGER NOT NULL, PRIMARY KEY(`bookName`))");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_17_18$1 migration_17_18 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_17_18$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `httpTTS` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `url` TEXT NOT NULL, PRIMARY KEY(`id`))");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_18_19$1 migration_18_19 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_18_19$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `readRecordNew` (`androidId` TEXT NOT NULL, `bookName` TEXT NOT NULL, `readTime` INTEGER NOT NULL, \n                    PRIMARY KEY(`androidId`, `bookName`))");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO readRecordNew(androidId, bookName, readTime) select '");
            c cVar = c.a;
            Object value = c.f5505k.getValue();
            j.d(value, "<get-androidId>(...)");
            sb.append((String) value);
            sb.append("' as androidId, bookName, readTime from readRecord");
            database.execSQL(sb.toString());
            database.execSQL("DROP TABLE readRecord");
            database.execSQL("ALTER TABLE readRecordNew RENAME TO readRecord");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_19_20$1 migration_19_20 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_19_20$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE book_sources ADD bookSourceComment TEXT");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_20_21$1 migration_20_21 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_20_21$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE book_groups ADD show INTEGER NOT NULL DEFAULT 1");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_21_22$1 migration_21_22 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_21_22$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `books_new` (`bookUrl` TEXT NOT NULL, `tocUrl` TEXT NOT NULL, `origin` TEXT NOT NULL, \n                    `originName` TEXT NOT NULL, `name` TEXT NOT NULL, `author` TEXT NOT NULL, `kind` TEXT, `customTag` TEXT, \n                    `coverUrl` TEXT, `customCoverUrl` TEXT, `intro` TEXT, `customIntro` TEXT, `charset` TEXT, `type` INTEGER NOT NULL, \n                    `group` INTEGER NOT NULL, `latestChapterTitle` TEXT, `latestChapterTime` INTEGER NOT NULL, `lastCheckTime` INTEGER NOT NULL, \n                    `lastCheckCount` INTEGER NOT NULL, `totalChapterNum` INTEGER NOT NULL, `durChapterTitle` TEXT, `durChapterIndex` INTEGER NOT NULL, \n                    `durChapterPos` INTEGER NOT NULL, `durChapterTime` INTEGER NOT NULL, `wordCount` TEXT, `canUpdate` INTEGER NOT NULL, \n                    `order` INTEGER NOT NULL, `originOrder` INTEGER NOT NULL, `variable` TEXT, `readConfig` TEXT, PRIMARY KEY(`bookUrl`))");
            database.execSQL("INSERT INTO books_new select `bookUrl`, `tocUrl`, `origin`, `originName`, `name`, `author`, `kind`, `customTag`, `coverUrl`, \n                    `customCoverUrl`, `intro`, `customIntro`, `charset`, `type`, `group`, `latestChapterTitle`, `latestChapterTime`, `lastCheckTime`, \n                    `lastCheckCount`, `totalChapterNum`, `durChapterTitle`, `durChapterIndex`, `durChapterPos`, `durChapterTime`, `wordCount`, `canUpdate`, \n                    `order`, `originOrder`, `variable`, null\n                    from books");
            database.execSQL("DROP TABLE books");
            database.execSQL("ALTER TABLE books_new RENAME TO books");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_books_name_author` ON `books` (`name`, `author`) ");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_22_23$1 migration_22_23 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_22_23$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE chapters ADD baseUrl TEXT NOT NULL DEFAULT ''");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_23_24$1 migration_23_24 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_23_24$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `caches` (`key` TEXT NOT NULL, `value` TEXT, `deadline` INTEGER NOT NULL, PRIMARY KEY(`key`))");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_caches_key` ON `caches` (`key`)");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_24_25$1 migration_24_25 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_24_25$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `sourceSubs` \n                    (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `url` TEXT NOT NULL, `type` INTEGER NOT NULL, `customOrder` INTEGER NOT NULL, \n                    PRIMARY KEY(`id`))");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_25_26$1 migration_25_26 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_25_26$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `ruleSubs` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `url` TEXT NOT NULL, `type` INTEGER NOT NULL, \n                    `customOrder` INTEGER NOT NULL, `autoUpdate` INTEGER NOT NULL, `update` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            database.execSQL(" insert into `ruleSubs` select *, 0, 0 from `sourceSubs` ");
            database.execSQL("DROP TABLE `sourceSubs`");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_26_27$1 migration_26_27 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_26_27$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL(" ALTER TABLE rssSources ADD singleUrl INTEGER NOT NULL DEFAULT 0 ");
            database.execSQL("CREATE TABLE IF NOT EXISTS `bookmarks1` (`time` INTEGER NOT NULL, `bookUrl` TEXT NOT NULL, `bookName` TEXT NOT NULL, \n                        `bookAuthor` TEXT NOT NULL, `chapterIndex` INTEGER NOT NULL, `chapterPos` INTEGER NOT NULL, `chapterName` TEXT NOT NULL, \n                        `bookText` TEXT NOT NULL, `content` TEXT NOT NULL, PRIMARY KEY(`time`))");
            database.execSQL("insert into `bookmarks1` \n                        select `time`, `bookUrl`, `bookName`, `bookAuthor`, `chapterIndex`, `pageIndex`, `chapterName`, '', `content` \n                        from bookmarks");
            database.execSQL(" DROP TABLE `bookmarks` ");
            database.execSQL(" ALTER TABLE bookmarks1 RENAME TO bookmarks ");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_bookmarks_time` ON `bookmarks` (`time`)");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_27_28$1 migration_27_28 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_27_28$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE rssArticles ADD variable TEXT");
            database.execSQL("ALTER TABLE rssStars ADD variable TEXT");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_28_29$1 migration_28_29 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_28_29$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE rssSources ADD sourceComment TEXT");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_29_30$1 migration_29_30 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_29_30$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE chapters ADD `startFragmentId` TEXT");
            database.execSQL("ALTER TABLE chapters ADD `endFragmentId` TEXT");
            database.execSQL("\n                    CREATE TABLE IF NOT EXISTS `epubChapters` \n                    (`bookUrl` TEXT NOT NULL, `href` TEXT NOT NULL, `parentHref` TEXT, \n                    PRIMARY KEY(`bookUrl`, `href`), FOREIGN KEY(`bookUrl`) REFERENCES `books`(`bookUrl`) ON UPDATE NO ACTION ON DELETE CASCADE )\n                ");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_epubChapters_bookUrl` ON `epubChapters` (`bookUrl`)");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_epubChapters_bookUrl_href` ON `epubChapters` (`bookUrl`, `href`)");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_30_31$1 migration_30_31 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_30_31$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("ALTER TABLE readRecord RENAME TO readRecord1");
            database.execSQL("\n                    CREATE TABLE IF NOT EXISTS `readRecord` (`deviceId` TEXT NOT NULL, `bookName` TEXT NOT NULL, `readTime` INTEGER NOT NULL, PRIMARY KEY(`deviceId`, `bookName`))\n                ");
            database.execSQL("insert into readRecord (deviceId, bookName, readTime) select androidId, bookName, readTime from readRecord1");
        }
    };

    @NotNull
    private static final AppDatabase$Companion$migration_31_32$1 migration_31_32 = new Migration() { // from class: io.legado.app.data.AppDatabase$Companion$migration_31_32$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            j.e(database, "database");
            database.execSQL("DROP TABLE `epubChapters`");
        }
    };

    /* JADX INFO: compiled from: AppDatabase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006*\u0016\n\r\u0010\u0013\u0016\u0019\u001c\u001f\"%(+.147:=@CFI\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bL\u0010MJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lio/legado/app/data/AppDatabase$Companion;", "", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "Lio/legado/app/data/AppDatabase;", "createDatabase", "(Landroid/content/Context;)Lio/legado/app/data/AppDatabase;", "", "DATABASE_NAME", "Ljava/lang/String;", "io/legado/app/data/AppDatabase$Companion$dbCallback$1", "dbCallback", "Lio/legado/app/data/AppDatabase$Companion$dbCallback$1;", "io/legado/app/data/AppDatabase$Companion$migration_10_11$1", "migration_10_11", "Lio/legado/app/data/AppDatabase$Companion$migration_10_11$1;", "io/legado/app/data/AppDatabase$Companion$migration_11_12$1", "migration_11_12", "Lio/legado/app/data/AppDatabase$Companion$migration_11_12$1;", "io/legado/app/data/AppDatabase$Companion$migration_12_13$1", "migration_12_13", "Lio/legado/app/data/AppDatabase$Companion$migration_12_13$1;", "io/legado/app/data/AppDatabase$Companion$migration_13_14$1", "migration_13_14", "Lio/legado/app/data/AppDatabase$Companion$migration_13_14$1;", "io/legado/app/data/AppDatabase$Companion$migration_14_15$1", "migration_14_15", "Lio/legado/app/data/AppDatabase$Companion$migration_14_15$1;", "io/legado/app/data/AppDatabase$Companion$migration_15_17$1", "migration_15_17", "Lio/legado/app/data/AppDatabase$Companion$migration_15_17$1;", "io/legado/app/data/AppDatabase$Companion$migration_17_18$1", "migration_17_18", "Lio/legado/app/data/AppDatabase$Companion$migration_17_18$1;", "io/legado/app/data/AppDatabase$Companion$migration_18_19$1", "migration_18_19", "Lio/legado/app/data/AppDatabase$Companion$migration_18_19$1;", "io/legado/app/data/AppDatabase$Companion$migration_19_20$1", "migration_19_20", "Lio/legado/app/data/AppDatabase$Companion$migration_19_20$1;", "io/legado/app/data/AppDatabase$Companion$migration_20_21$1", "migration_20_21", "Lio/legado/app/data/AppDatabase$Companion$migration_20_21$1;", "io/legado/app/data/AppDatabase$Companion$migration_21_22$1", "migration_21_22", "Lio/legado/app/data/AppDatabase$Companion$migration_21_22$1;", "io/legado/app/data/AppDatabase$Companion$migration_22_23$1", "migration_22_23", "Lio/legado/app/data/AppDatabase$Companion$migration_22_23$1;", "io/legado/app/data/AppDatabase$Companion$migration_23_24$1", "migration_23_24", "Lio/legado/app/data/AppDatabase$Companion$migration_23_24$1;", "io/legado/app/data/AppDatabase$Companion$migration_24_25$1", "migration_24_25", "Lio/legado/app/data/AppDatabase$Companion$migration_24_25$1;", "io/legado/app/data/AppDatabase$Companion$migration_25_26$1", "migration_25_26", "Lio/legado/app/data/AppDatabase$Companion$migration_25_26$1;", "io/legado/app/data/AppDatabase$Companion$migration_26_27$1", "migration_26_27", "Lio/legado/app/data/AppDatabase$Companion$migration_26_27$1;", "io/legado/app/data/AppDatabase$Companion$migration_27_28$1", "migration_27_28", "Lio/legado/app/data/AppDatabase$Companion$migration_27_28$1;", "io/legado/app/data/AppDatabase$Companion$migration_28_29$1", "migration_28_29", "Lio/legado/app/data/AppDatabase$Companion$migration_28_29$1;", "io/legado/app/data/AppDatabase$Companion$migration_29_30$1", "migration_29_30", "Lio/legado/app/data/AppDatabase$Companion$migration_29_30$1;", "io/legado/app/data/AppDatabase$Companion$migration_30_31$1", "migration_30_31", "Lio/legado/app/data/AppDatabase$Companion$migration_30_31$1;", "io/legado/app/data/AppDatabase$Companion$migration_31_32$1", "migration_31_32", "Lio/legado/app/data/AppDatabase$Companion$migration_31_32$1;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @NotNull
        public final AppDatabase createDatabase(@NotNull Context context) {
            j.e(context, com.umeng.analytics.pro.c.R);
            RoomDatabase roomDatabaseBuild = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME).fallbackToDestructiveMigration().addMigrations(AppDatabase.migration_10_11, AppDatabase.migration_11_12, AppDatabase.migration_12_13, AppDatabase.migration_13_14, AppDatabase.migration_14_15, AppDatabase.migration_15_17, AppDatabase.migration_17_18, AppDatabase.migration_18_19, AppDatabase.migration_19_20, AppDatabase.migration_20_21, AppDatabase.migration_21_22, AppDatabase.migration_22_23, AppDatabase.migration_23_24, AppDatabase.migration_24_25, AppDatabase.migration_25_26, AppDatabase.migration_26_27, AppDatabase.migration_27_28, AppDatabase.migration_28_29, AppDatabase.migration_29_30, AppDatabase.migration_30_31, AppDatabase.migration_31_32).allowMainThreadQueries().addCallback(AppDatabase.dbCallback).build();
            j.d(roomDatabaseBuild, "databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)\n                .fallbackToDestructiveMigration()\n                .addMigrations(\n                    migration_10_11, migration_11_12, migration_12_13, migration_13_14,\n                    migration_14_15, migration_15_17, migration_17_18, migration_18_19,\n                    migration_19_20, migration_20_21, migration_21_22, migration_22_23,\n                    migration_23_24, migration_24_25, migration_25_26, migration_26_27,\n                    migration_27_28, migration_28_29, migration_29_30, migration_30_31,\n                    migration_31_32\n                )\n                .allowMainThreadQueries()\n                .addCallback(dbCallback)\n                .build()");
            return (AppDatabase) roomDatabaseBuild;
        }
    }

    @NotNull
    public abstract BookChapterDao getBookChapterDao();

    @NotNull
    public abstract BookDao getBookDao();

    @NotNull
    public abstract BookGroupDao getBookGroupDao();

    @NotNull
    public abstract BookSourceDao getBookSourceDao();

    @NotNull
    public abstract BookmarkDao getBookmarkDao();

    @NotNull
    public abstract CacheDao getCacheDao();

    @NotNull
    public abstract CookieDao getCookieDao();

    @NotNull
    public abstract HttpTTSDao getHttpTTSDao();

    @NotNull
    public abstract ReadRecordDao getReadRecordDao();

    @NotNull
    public abstract ReplaceRuleDao getReplaceRuleDao();

    @NotNull
    public abstract RssArticleDao getRssArticleDao();

    @NotNull
    public abstract RssSourceDao getRssSourceDao();

    @NotNull
    public abstract RssStarDao getRssStarDao();

    @NotNull
    public abstract RuleSubDao getRuleSubDao();

    @NotNull
    public abstract SearchBookDao getSearchBookDao();

    @NotNull
    public abstract SearchKeywordDao getSearchKeywordDao();

    @NotNull
    public abstract TxtTocRuleDao getTxtTocRuleDao();
}
