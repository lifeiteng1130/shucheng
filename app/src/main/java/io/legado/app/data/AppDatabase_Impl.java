package io.legado.app.data;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.dao.BookChapterDao_Impl;
import io.legado.app.data.dao.BookDao;
import io.legado.app.data.dao.BookDao_Impl;
import io.legado.app.data.dao.BookGroupDao;
import io.legado.app.data.dao.BookGroupDao_Impl;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.dao.BookSourceDao_Impl;
import io.legado.app.data.dao.BookmarkDao;
import io.legado.app.data.dao.BookmarkDao_Impl;
import io.legado.app.data.dao.CacheDao;
import io.legado.app.data.dao.CacheDao_Impl;
import io.legado.app.data.dao.CookieDao;
import io.legado.app.data.dao.CookieDao_Impl;
import io.legado.app.data.dao.HttpTTSDao;
import io.legado.app.data.dao.HttpTTSDao_Impl;
import io.legado.app.data.dao.ReadRecordDao;
import io.legado.app.data.dao.ReadRecordDao_Impl;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.dao.ReplaceRuleDao_Impl;
import io.legado.app.data.dao.RssArticleDao;
import io.legado.app.data.dao.RssArticleDao_Impl;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.dao.RssSourceDao_Impl;
import io.legado.app.data.dao.RssStarDao;
import io.legado.app.data.dao.RssStarDao_Impl;
import io.legado.app.data.dao.RuleSubDao;
import io.legado.app.data.dao.RuleSubDao_Impl;
import io.legado.app.data.dao.SearchBookDao;
import io.legado.app.data.dao.SearchBookDao_Impl;
import io.legado.app.data.dao.SearchKeywordDao;
import io.legado.app.data.dao.SearchKeywordDao_Impl;
import io.legado.app.data.dao.TxtTocRuleDao;
import io.legado.app.data.dao.TxtTocRuleDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private volatile BookChapterDao _bookChapterDao;
    private volatile BookDao _bookDao;
    private volatile BookGroupDao _bookGroupDao;
    private volatile BookSourceDao _bookSourceDao;
    private volatile BookmarkDao _bookmarkDao;
    private volatile CacheDao _cacheDao;
    private volatile CookieDao _cookieDao;
    private volatile HttpTTSDao _httpTTSDao;
    private volatile ReadRecordDao _readRecordDao;
    private volatile ReplaceRuleDao _replaceRuleDao;
    private volatile RssArticleDao _rssArticleDao;
    private volatile RssSourceDao _rssSourceDao;
    private volatile RssStarDao _rssStarDao;
    private volatile RuleSubDao _ruleSubDao;
    private volatile SearchBookDao _searchBookDao;
    private volatile SearchKeywordDao _searchKeywordDao;
    private volatile TxtTocRuleDao _txtTocRuleDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        if (1 == 0) {
            try {
                writableDatabase.execSQL("PRAGMA foreign_keys = FALSE");
            } finally {
                super.endTransaction();
                if (1 == 0) {
                    writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
                }
                writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
                if (!writableDatabase.inTransaction()) {
                    writableDatabase.execSQL("VACUUM");
                }
            }
        }
        super.beginTransaction();
        if (1 != 0) {
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
        }
        writableDatabase.execSQL("DELETE FROM `books`");
        writableDatabase.execSQL("DELETE FROM `book_groups`");
        writableDatabase.execSQL("DELETE FROM `book_sources`");
        writableDatabase.execSQL("DELETE FROM `chapters`");
        writableDatabase.execSQL("DELETE FROM `replace_rules`");
        writableDatabase.execSQL("DELETE FROM `searchBooks`");
        writableDatabase.execSQL("DELETE FROM `search_keywords`");
        writableDatabase.execSQL("DELETE FROM `cookies`");
        writableDatabase.execSQL("DELETE FROM `rssSources`");
        writableDatabase.execSQL("DELETE FROM `bookmarks`");
        writableDatabase.execSQL("DELETE FROM `rssArticles`");
        writableDatabase.execSQL("DELETE FROM `rssReadRecords`");
        writableDatabase.execSQL("DELETE FROM `rssStars`");
        writableDatabase.execSQL("DELETE FROM `txtTocRules`");
        writableDatabase.execSQL("DELETE FROM `readRecord`");
        writableDatabase.execSQL("DELETE FROM `httpTTS`");
        writableDatabase.execSQL("DELETE FROM `caches`");
        writableDatabase.execSQL("DELETE FROM `ruleSubs`");
        super.setTransactionSuccessful();
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "books", "book_groups", "book_sources", "chapters", "replace_rules", "searchBooks", "search_keywords", "cookies", "rssSources", "bookmarks", "rssArticles", "rssReadRecords", "rssStars", "txtTocRules", "readRecord", "httpTTS", "caches", "ruleSubs");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(32) { // from class: io.legado.app.data.AppDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `books` (`bookUrl` TEXT NOT NULL, `tocUrl` TEXT NOT NULL, `origin` TEXT NOT NULL, `originName` TEXT NOT NULL, `name` TEXT NOT NULL, `author` TEXT NOT NULL, `kind` TEXT, `customTag` TEXT, `coverUrl` TEXT, `customCoverUrl` TEXT, `intro` TEXT, `customIntro` TEXT, `charset` TEXT, `type` INTEGER NOT NULL, `group` INTEGER NOT NULL, `latestChapterTitle` TEXT, `latestChapterTime` INTEGER NOT NULL, `lastCheckTime` INTEGER NOT NULL, `lastCheckCount` INTEGER NOT NULL, `totalChapterNum` INTEGER NOT NULL, `durChapterTitle` TEXT, `durChapterIndex` INTEGER NOT NULL, `durChapterPos` INTEGER NOT NULL, `durChapterTime` INTEGER NOT NULL, `wordCount` TEXT, `canUpdate` INTEGER NOT NULL, `order` INTEGER NOT NULL, `originOrder` INTEGER NOT NULL, `variable` TEXT, `readConfig` TEXT, PRIMARY KEY(`bookUrl`))");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_books_name_author` ON `books` (`name`, `author`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `book_groups` (`groupId` INTEGER NOT NULL, `groupName` TEXT NOT NULL, `order` INTEGER NOT NULL, `show` INTEGER NOT NULL, PRIMARY KEY(`groupId`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `book_sources` (`bookSourceName` TEXT NOT NULL, `bookSourceGroup` TEXT, `bookSourceUrl` TEXT NOT NULL, `bookSourceType` INTEGER NOT NULL, `bookUrlPattern` TEXT, `customOrder` INTEGER NOT NULL, `enabled` INTEGER NOT NULL, `enabledExplore` INTEGER NOT NULL, `header` TEXT, `loginUrl` TEXT, `bookSourceComment` TEXT, `lastUpdateTime` INTEGER NOT NULL, `weight` INTEGER NOT NULL, `exploreUrl` TEXT, `ruleExplore` TEXT, `searchUrl` TEXT, `ruleSearch` TEXT, `ruleBookInfo` TEXT, `ruleToc` TEXT, `ruleContent` TEXT, PRIMARY KEY(`bookSourceUrl`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_book_sources_bookSourceUrl` ON `book_sources` (`bookSourceUrl`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `chapters` (`url` TEXT NOT NULL, `title` TEXT NOT NULL, `baseUrl` TEXT NOT NULL, `bookUrl` TEXT NOT NULL, `index` INTEGER NOT NULL, `resourceUrl` TEXT, `tag` TEXT, `start` INTEGER, `end` INTEGER, `startFragmentId` TEXT, `endFragmentId` TEXT, `variable` TEXT, PRIMARY KEY(`url`, `bookUrl`), FOREIGN KEY(`bookUrl`) REFERENCES `books`(`bookUrl`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_chapters_bookUrl` ON `chapters` (`bookUrl`)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_chapters_bookUrl_index` ON `chapters` (`bookUrl`, `index`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `replace_rules` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `group` TEXT, `pattern` TEXT NOT NULL, `replacement` TEXT NOT NULL, `scope` TEXT, `isEnabled` INTEGER NOT NULL, `isRegex` INTEGER NOT NULL, `sortOrder` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_replace_rules_id` ON `replace_rules` (`id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `searchBooks` (`bookUrl` TEXT NOT NULL, `origin` TEXT NOT NULL, `originName` TEXT NOT NULL, `type` INTEGER NOT NULL, `name` TEXT NOT NULL, `author` TEXT NOT NULL, `kind` TEXT, `coverUrl` TEXT, `intro` TEXT, `wordCount` TEXT, `latestChapterTitle` TEXT, `tocUrl` TEXT NOT NULL, `time` INTEGER NOT NULL, `variable` TEXT, `originOrder` INTEGER NOT NULL, PRIMARY KEY(`bookUrl`), FOREIGN KEY(`origin`) REFERENCES `book_sources`(`bookSourceUrl`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_searchBooks_bookUrl` ON `searchBooks` (`bookUrl`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_searchBooks_origin` ON `searchBooks` (`origin`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `search_keywords` (`word` TEXT NOT NULL, `usage` INTEGER NOT NULL, `lastUseTime` INTEGER NOT NULL, PRIMARY KEY(`word`))");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_search_keywords_word` ON `search_keywords` (`word`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `cookies` (`url` TEXT NOT NULL, `cookie` TEXT NOT NULL, PRIMARY KEY(`url`))");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_cookies_url` ON `cookies` (`url`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `rssSources` (`sourceUrl` TEXT NOT NULL, `sourceName` TEXT NOT NULL, `sourceIcon` TEXT NOT NULL, `sourceGroup` TEXT, `sourceComment` TEXT, `enabled` INTEGER NOT NULL, `sortUrl` TEXT, `singleUrl` INTEGER NOT NULL, `articleStyle` INTEGER NOT NULL, `ruleArticles` TEXT, `ruleNextPage` TEXT, `ruleTitle` TEXT, `rulePubDate` TEXT, `ruleDescription` TEXT, `ruleImage` TEXT, `ruleLink` TEXT, `ruleContent` TEXT, `style` TEXT, `header` TEXT, `enableJs` INTEGER NOT NULL, `loadWithBaseUrl` INTEGER NOT NULL, `customOrder` INTEGER NOT NULL, PRIMARY KEY(`sourceUrl`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_rssSources_sourceUrl` ON `rssSources` (`sourceUrl`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `bookmarks` (`time` INTEGER NOT NULL, `bookUrl` TEXT NOT NULL, `bookName` TEXT NOT NULL, `bookAuthor` TEXT NOT NULL, `chapterIndex` INTEGER NOT NULL, `chapterPos` INTEGER NOT NULL, `chapterName` TEXT NOT NULL, `bookText` TEXT NOT NULL, `content` TEXT NOT NULL, PRIMARY KEY(`time`))");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_bookmarks_time` ON `bookmarks` (`time`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `rssArticles` (`origin` TEXT NOT NULL, `sort` TEXT NOT NULL, `title` TEXT NOT NULL, `order` INTEGER NOT NULL, `link` TEXT NOT NULL, `pubDate` TEXT, `description` TEXT, `content` TEXT, `image` TEXT, `read` INTEGER NOT NULL, `variable` TEXT, PRIMARY KEY(`origin`, `link`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `rssReadRecords` (`record` TEXT NOT NULL, `read` INTEGER NOT NULL, PRIMARY KEY(`record`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `rssStars` (`origin` TEXT NOT NULL, `sort` TEXT NOT NULL, `title` TEXT NOT NULL, `starTime` INTEGER NOT NULL, `link` TEXT NOT NULL, `pubDate` TEXT, `description` TEXT, `content` TEXT, `image` TEXT, `variable` TEXT, PRIMARY KEY(`origin`, `link`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `txtTocRules` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `rule` TEXT NOT NULL, `serialNumber` INTEGER NOT NULL, `enable` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `readRecord` (`deviceId` TEXT NOT NULL, `bookName` TEXT NOT NULL, `readTime` INTEGER NOT NULL, PRIMARY KEY(`deviceId`, `bookName`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `httpTTS` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `url` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `caches` (`key` TEXT NOT NULL, `value` TEXT, `deadline` INTEGER NOT NULL, PRIMARY KEY(`key`))");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_caches_key` ON `caches` (`key`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ruleSubs` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `url` TEXT NOT NULL, `type` INTEGER NOT NULL, `customOrder` INTEGER NOT NULL, `autoUpdate` INTEGER NOT NULL, `update` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd1c390e708a1e89c7d016cdd2e0b2e88')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `books`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `book_groups`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `book_sources`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `chapters`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `replace_rules`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `searchBooks`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `search_keywords`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `cookies`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `rssSources`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `bookmarks`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `rssArticles`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `rssReadRecords`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `rssStars`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `txtTocRules`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `readRecord`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `httpTTS`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `caches`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ruleSubs`");
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i2)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i2)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                AppDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                AppDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i2)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(30);
                map.put("bookUrl", new TableInfo.Column("bookUrl", "TEXT", true, 1, null, 1));
                map.put("tocUrl", new TableInfo.Column("tocUrl", "TEXT", true, 0, null, 1));
                map.put("origin", new TableInfo.Column("origin", "TEXT", true, 0, null, 1));
                map.put("originName", new TableInfo.Column("originName", "TEXT", true, 0, null, 1));
                map.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map.put("author", new TableInfo.Column("author", "TEXT", true, 0, null, 1));
                map.put("kind", new TableInfo.Column("kind", "TEXT", false, 0, null, 1));
                map.put("customTag", new TableInfo.Column("customTag", "TEXT", false, 0, null, 1));
                map.put("coverUrl", new TableInfo.Column("coverUrl", "TEXT", false, 0, null, 1));
                map.put("customCoverUrl", new TableInfo.Column("customCoverUrl", "TEXT", false, 0, null, 1));
                map.put("intro", new TableInfo.Column("intro", "TEXT", false, 0, null, 1));
                map.put("customIntro", new TableInfo.Column("customIntro", "TEXT", false, 0, null, 1));
                map.put("charset", new TableInfo.Column("charset", "TEXT", false, 0, null, 1));
                map.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                map.put("group", new TableInfo.Column("group", "INTEGER", true, 0, null, 1));
                map.put("latestChapterTitle", new TableInfo.Column("latestChapterTitle", "TEXT", false, 0, null, 1));
                map.put("latestChapterTime", new TableInfo.Column("latestChapterTime", "INTEGER", true, 0, null, 1));
                map.put("lastCheckTime", new TableInfo.Column("lastCheckTime", "INTEGER", true, 0, null, 1));
                map.put("lastCheckCount", new TableInfo.Column("lastCheckCount", "INTEGER", true, 0, null, 1));
                map.put("totalChapterNum", new TableInfo.Column("totalChapterNum", "INTEGER", true, 0, null, 1));
                map.put("durChapterTitle", new TableInfo.Column("durChapterTitle", "TEXT", false, 0, null, 1));
                map.put("durChapterIndex", new TableInfo.Column("durChapterIndex", "INTEGER", true, 0, null, 1));
                map.put("durChapterPos", new TableInfo.Column("durChapterPos", "INTEGER", true, 0, null, 1));
                map.put("durChapterTime", new TableInfo.Column("durChapterTime", "INTEGER", true, 0, null, 1));
                map.put("wordCount", new TableInfo.Column("wordCount", "TEXT", false, 0, null, 1));
                map.put("canUpdate", new TableInfo.Column("canUpdate", "INTEGER", true, 0, null, 1));
                map.put("order", new TableInfo.Column("order", "INTEGER", true, 0, null, 1));
                map.put("originOrder", new TableInfo.Column("originOrder", "INTEGER", true, 0, null, 1));
                map.put("variable", new TableInfo.Column("variable", "TEXT", false, 0, null, 1));
                map.put("readConfig", new TableInfo.Column("readConfig", "TEXT", false, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_books_name_author", true, Arrays.asList("name", "author")));
                TableInfo tableInfo = new TableInfo("books", map, hashSet, hashSet2);
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "books");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "books(io.legado.app.data.entities.Book).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(4);
                map2.put("groupId", new TableInfo.Column("groupId", "INTEGER", true, 1, null, 1));
                map2.put("groupName", new TableInfo.Column("groupName", "TEXT", true, 0, null, 1));
                map2.put("order", new TableInfo.Column("order", "INTEGER", true, 0, null, 1));
                map2.put("show", new TableInfo.Column("show", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("book_groups", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "book_groups");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "book_groups(io.legado.app.data.entities.BookGroup).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(20);
                map3.put("bookSourceName", new TableInfo.Column("bookSourceName", "TEXT", true, 0, null, 1));
                map3.put("bookSourceGroup", new TableInfo.Column("bookSourceGroup", "TEXT", false, 0, null, 1));
                map3.put("bookSourceUrl", new TableInfo.Column("bookSourceUrl", "TEXT", true, 1, null, 1));
                map3.put("bookSourceType", new TableInfo.Column("bookSourceType", "INTEGER", true, 0, null, 1));
                map3.put("bookUrlPattern", new TableInfo.Column("bookUrlPattern", "TEXT", false, 0, null, 1));
                map3.put("customOrder", new TableInfo.Column("customOrder", "INTEGER", true, 0, null, 1));
                map3.put("enabled", new TableInfo.Column("enabled", "INTEGER", true, 0, null, 1));
                map3.put("enabledExplore", new TableInfo.Column("enabledExplore", "INTEGER", true, 0, null, 1));
                map3.put("header", new TableInfo.Column("header", "TEXT", false, 0, null, 1));
                map3.put("loginUrl", new TableInfo.Column("loginUrl", "TEXT", false, 0, null, 1));
                map3.put("bookSourceComment", new TableInfo.Column("bookSourceComment", "TEXT", false, 0, null, 1));
                map3.put("lastUpdateTime", new TableInfo.Column("lastUpdateTime", "INTEGER", true, 0, null, 1));
                map3.put(ActivityChooserModel.ATTRIBUTE_WEIGHT, new TableInfo.Column(ActivityChooserModel.ATTRIBUTE_WEIGHT, "INTEGER", true, 0, null, 1));
                map3.put("exploreUrl", new TableInfo.Column("exploreUrl", "TEXT", false, 0, null, 1));
                map3.put("ruleExplore", new TableInfo.Column("ruleExplore", "TEXT", false, 0, null, 1));
                map3.put("searchUrl", new TableInfo.Column("searchUrl", "TEXT", false, 0, null, 1));
                map3.put("ruleSearch", new TableInfo.Column("ruleSearch", "TEXT", false, 0, null, 1));
                map3.put("ruleBookInfo", new TableInfo.Column("ruleBookInfo", "TEXT", false, 0, null, 1));
                map3.put("ruleToc", new TableInfo.Column("ruleToc", "TEXT", false, 0, null, 1));
                map3.put("ruleContent", new TableInfo.Column("ruleContent", "TEXT", false, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_book_sources_bookSourceUrl", false, Arrays.asList("bookSourceUrl")));
                TableInfo tableInfo5 = new TableInfo("book_sources", map3, hashSet3, hashSet4);
                TableInfo tableInfo6 = TableInfo.read(supportSQLiteDatabase, "book_sources");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "book_sources(io.legado.app.data.entities.BookSource).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(12);
                map4.put("url", new TableInfo.Column("url", "TEXT", true, 1, null, 1));
                map4.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                map4.put("baseUrl", new TableInfo.Column("baseUrl", "TEXT", true, 0, null, 1));
                map4.put("bookUrl", new TableInfo.Column("bookUrl", "TEXT", true, 2, null, 1));
                map4.put("index", new TableInfo.Column("index", "INTEGER", true, 0, null, 1));
                map4.put("resourceUrl", new TableInfo.Column("resourceUrl", "TEXT", false, 0, null, 1));
                map4.put("tag", new TableInfo.Column("tag", "TEXT", false, 0, null, 1));
                map4.put("start", new TableInfo.Column("start", "INTEGER", false, 0, null, 1));
                map4.put("end", new TableInfo.Column("end", "INTEGER", false, 0, null, 1));
                map4.put("startFragmentId", new TableInfo.Column("startFragmentId", "TEXT", false, 0, null, 1));
                map4.put("endFragmentId", new TableInfo.Column("endFragmentId", "TEXT", false, 0, null, 1));
                map4.put("variable", new TableInfo.Column("variable", "TEXT", false, 0, null, 1));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new TableInfo.ForeignKey("books", "CASCADE", "NO ACTION", Arrays.asList("bookUrl"), Arrays.asList("bookUrl")));
                HashSet hashSet6 = new HashSet(2);
                hashSet6.add(new TableInfo.Index("index_chapters_bookUrl", false, Arrays.asList("bookUrl")));
                hashSet6.add(new TableInfo.Index("index_chapters_bookUrl_index", true, Arrays.asList("bookUrl", "index")));
                TableInfo tableInfo7 = new TableInfo("chapters", map4, hashSet5, hashSet6);
                TableInfo tableInfo8 = TableInfo.read(supportSQLiteDatabase, "chapters");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "chapters(io.legado.app.data.entities.BookChapter).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(9);
                map5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map5.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map5.put("group", new TableInfo.Column("group", "TEXT", false, 0, null, 1));
                map5.put("pattern", new TableInfo.Column("pattern", "TEXT", true, 0, null, 1));
                map5.put("replacement", new TableInfo.Column("replacement", "TEXT", true, 0, null, 1));
                map5.put("scope", new TableInfo.Column("scope", "TEXT", false, 0, null, 1));
                map5.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", true, 0, null, 1));
                map5.put("isRegex", new TableInfo.Column("isRegex", "INTEGER", true, 0, null, 1));
                map5.put("sortOrder", new TableInfo.Column("sortOrder", "INTEGER", true, 0, null, 1));
                HashSet hashSet7 = new HashSet(0);
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.Index("index_replace_rules_id", false, Arrays.asList("id")));
                TableInfo tableInfo9 = new TableInfo("replace_rules", map5, hashSet7, hashSet8);
                TableInfo tableInfo10 = TableInfo.read(supportSQLiteDatabase, "replace_rules");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "replace_rules(io.legado.app.data.entities.ReplaceRule).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                HashMap map6 = new HashMap(15);
                map6.put("bookUrl", new TableInfo.Column("bookUrl", "TEXT", true, 1, null, 1));
                map6.put("origin", new TableInfo.Column("origin", "TEXT", true, 0, null, 1));
                map6.put("originName", new TableInfo.Column("originName", "TEXT", true, 0, null, 1));
                map6.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                map6.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map6.put("author", new TableInfo.Column("author", "TEXT", true, 0, null, 1));
                map6.put("kind", new TableInfo.Column("kind", "TEXT", false, 0, null, 1));
                map6.put("coverUrl", new TableInfo.Column("coverUrl", "TEXT", false, 0, null, 1));
                map6.put("intro", new TableInfo.Column("intro", "TEXT", false, 0, null, 1));
                map6.put("wordCount", new TableInfo.Column("wordCount", "TEXT", false, 0, null, 1));
                map6.put("latestChapterTitle", new TableInfo.Column("latestChapterTitle", "TEXT", false, 0, null, 1));
                map6.put("tocUrl", new TableInfo.Column("tocUrl", "TEXT", true, 0, null, 1));
                map6.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                map6.put("variable", new TableInfo.Column("variable", "TEXT", false, 0, null, 1));
                map6.put("originOrder", new TableInfo.Column("originOrder", "INTEGER", true, 0, null, 1));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.ForeignKey("book_sources", "CASCADE", "NO ACTION", Arrays.asList("origin"), Arrays.asList("bookSourceUrl")));
                HashSet hashSet10 = new HashSet(2);
                hashSet10.add(new TableInfo.Index("index_searchBooks_bookUrl", true, Arrays.asList("bookUrl")));
                hashSet10.add(new TableInfo.Index("index_searchBooks_origin", false, Arrays.asList("origin")));
                TableInfo tableInfo11 = new TableInfo("searchBooks", map6, hashSet9, hashSet10);
                TableInfo tableInfo12 = TableInfo.read(supportSQLiteDatabase, "searchBooks");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenHelper.ValidationResult(false, "searchBooks(io.legado.app.data.entities.SearchBook).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                HashMap map7 = new HashMap(3);
                map7.put("word", new TableInfo.Column("word", "TEXT", true, 1, null, 1));
                map7.put("usage", new TableInfo.Column("usage", "INTEGER", true, 0, null, 1));
                map7.put("lastUseTime", new TableInfo.Column("lastUseTime", "INTEGER", true, 0, null, 1));
                HashSet hashSet11 = new HashSet(0);
                HashSet hashSet12 = new HashSet(1);
                hashSet12.add(new TableInfo.Index("index_search_keywords_word", true, Arrays.asList("word")));
                TableInfo tableInfo13 = new TableInfo("search_keywords", map7, hashSet11, hashSet12);
                TableInfo tableInfo14 = TableInfo.read(supportSQLiteDatabase, "search_keywords");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenHelper.ValidationResult(false, "search_keywords(io.legado.app.data.entities.SearchKeyword).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                HashMap map8 = new HashMap(2);
                map8.put("url", new TableInfo.Column("url", "TEXT", true, 1, null, 1));
                map8.put("cookie", new TableInfo.Column("cookie", "TEXT", true, 0, null, 1));
                HashSet hashSet13 = new HashSet(0);
                HashSet hashSet14 = new HashSet(1);
                hashSet14.add(new TableInfo.Index("index_cookies_url", true, Arrays.asList("url")));
                TableInfo tableInfo15 = new TableInfo("cookies", map8, hashSet13, hashSet14);
                TableInfo tableInfo16 = TableInfo.read(supportSQLiteDatabase, "cookies");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new RoomOpenHelper.ValidationResult(false, "cookies(io.legado.app.data.entities.Cookie).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16);
                }
                HashMap map9 = new HashMap(22);
                map9.put("sourceUrl", new TableInfo.Column("sourceUrl", "TEXT", true, 1, null, 1));
                map9.put("sourceName", new TableInfo.Column("sourceName", "TEXT", true, 0, null, 1));
                map9.put("sourceIcon", new TableInfo.Column("sourceIcon", "TEXT", true, 0, null, 1));
                map9.put("sourceGroup", new TableInfo.Column("sourceGroup", "TEXT", false, 0, null, 1));
                map9.put("sourceComment", new TableInfo.Column("sourceComment", "TEXT", false, 0, null, 1));
                map9.put("enabled", new TableInfo.Column("enabled", "INTEGER", true, 0, null, 1));
                map9.put("sortUrl", new TableInfo.Column("sortUrl", "TEXT", false, 0, null, 1));
                map9.put("singleUrl", new TableInfo.Column("singleUrl", "INTEGER", true, 0, null, 1));
                map9.put("articleStyle", new TableInfo.Column("articleStyle", "INTEGER", true, 0, null, 1));
                map9.put("ruleArticles", new TableInfo.Column("ruleArticles", "TEXT", false, 0, null, 1));
                map9.put("ruleNextPage", new TableInfo.Column("ruleNextPage", "TEXT", false, 0, null, 1));
                map9.put("ruleTitle", new TableInfo.Column("ruleTitle", "TEXT", false, 0, null, 1));
                map9.put("rulePubDate", new TableInfo.Column("rulePubDate", "TEXT", false, 0, null, 1));
                map9.put("ruleDescription", new TableInfo.Column("ruleDescription", "TEXT", false, 0, null, 1));
                map9.put("ruleImage", new TableInfo.Column("ruleImage", "TEXT", false, 0, null, 1));
                map9.put("ruleLink", new TableInfo.Column("ruleLink", "TEXT", false, 0, null, 1));
                map9.put("ruleContent", new TableInfo.Column("ruleContent", "TEXT", false, 0, null, 1));
                map9.put("style", new TableInfo.Column("style", "TEXT", false, 0, null, 1));
                map9.put("header", new TableInfo.Column("header", "TEXT", false, 0, null, 1));
                map9.put("enableJs", new TableInfo.Column("enableJs", "INTEGER", true, 0, null, 1));
                map9.put("loadWithBaseUrl", new TableInfo.Column("loadWithBaseUrl", "INTEGER", true, 0, null, 1));
                map9.put("customOrder", new TableInfo.Column("customOrder", "INTEGER", true, 0, null, 1));
                HashSet hashSet15 = new HashSet(0);
                HashSet hashSet16 = new HashSet(1);
                hashSet16.add(new TableInfo.Index("index_rssSources_sourceUrl", false, Arrays.asList("sourceUrl")));
                TableInfo tableInfo17 = new TableInfo("rssSources", map9, hashSet15, hashSet16);
                TableInfo tableInfo18 = TableInfo.read(supportSQLiteDatabase, "rssSources");
                if (!tableInfo17.equals(tableInfo18)) {
                    return new RoomOpenHelper.ValidationResult(false, "rssSources(io.legado.app.data.entities.RssSource).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfo18);
                }
                HashMap map10 = new HashMap(9);
                map10.put("time", new TableInfo.Column("time", "INTEGER", true, 1, null, 1));
                map10.put("bookUrl", new TableInfo.Column("bookUrl", "TEXT", true, 0, null, 1));
                map10.put("bookName", new TableInfo.Column("bookName", "TEXT", true, 0, null, 1));
                map10.put("bookAuthor", new TableInfo.Column("bookAuthor", "TEXT", true, 0, null, 1));
                map10.put("chapterIndex", new TableInfo.Column("chapterIndex", "INTEGER", true, 0, null, 1));
                map10.put("chapterPos", new TableInfo.Column("chapterPos", "INTEGER", true, 0, null, 1));
                map10.put("chapterName", new TableInfo.Column("chapterName", "TEXT", true, 0, null, 1));
                map10.put("bookText", new TableInfo.Column("bookText", "TEXT", true, 0, null, 1));
                map10.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                HashSet hashSet17 = new HashSet(0);
                HashSet hashSet18 = new HashSet(1);
                hashSet18.add(new TableInfo.Index("index_bookmarks_time", true, Arrays.asList("time")));
                TableInfo tableInfo19 = new TableInfo("bookmarks", map10, hashSet17, hashSet18);
                TableInfo tableInfo20 = TableInfo.read(supportSQLiteDatabase, "bookmarks");
                if (!tableInfo19.equals(tableInfo20)) {
                    return new RoomOpenHelper.ValidationResult(false, "bookmarks(io.legado.app.data.entities.Bookmark).\n Expected:\n" + tableInfo19 + "\n Found:\n" + tableInfo20);
                }
                HashMap map11 = new HashMap(11);
                map11.put("origin", new TableInfo.Column("origin", "TEXT", true, 1, null, 1));
                map11.put("sort", new TableInfo.Column("sort", "TEXT", true, 0, null, 1));
                map11.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                map11.put("order", new TableInfo.Column("order", "INTEGER", true, 0, null, 1));
                map11.put("link", new TableInfo.Column("link", "TEXT", true, 2, null, 1));
                map11.put("pubDate", new TableInfo.Column("pubDate", "TEXT", false, 0, null, 1));
                map11.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                map11.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, 1));
                map11.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, 1));
                map11.put("read", new TableInfo.Column("read", "INTEGER", true, 0, null, 1));
                map11.put("variable", new TableInfo.Column("variable", "TEXT", false, 0, null, 1));
                TableInfo tableInfo21 = new TableInfo("rssArticles", map11, new HashSet(0), new HashSet(0));
                TableInfo tableInfo22 = TableInfo.read(supportSQLiteDatabase, "rssArticles");
                if (!tableInfo21.equals(tableInfo22)) {
                    return new RoomOpenHelper.ValidationResult(false, "rssArticles(io.legado.app.data.entities.RssArticle).\n Expected:\n" + tableInfo21 + "\n Found:\n" + tableInfo22);
                }
                HashMap map12 = new HashMap(2);
                map12.put("record", new TableInfo.Column("record", "TEXT", true, 1, null, 1));
                map12.put("read", new TableInfo.Column("read", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo23 = new TableInfo("rssReadRecords", map12, new HashSet(0), new HashSet(0));
                TableInfo tableInfo24 = TableInfo.read(supportSQLiteDatabase, "rssReadRecords");
                if (!tableInfo23.equals(tableInfo24)) {
                    return new RoomOpenHelper.ValidationResult(false, "rssReadRecords(io.legado.app.data.entities.RssReadRecord).\n Expected:\n" + tableInfo23 + "\n Found:\n" + tableInfo24);
                }
                HashMap map13 = new HashMap(10);
                map13.put("origin", new TableInfo.Column("origin", "TEXT", true, 1, null, 1));
                map13.put("sort", new TableInfo.Column("sort", "TEXT", true, 0, null, 1));
                map13.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                map13.put("starTime", new TableInfo.Column("starTime", "INTEGER", true, 0, null, 1));
                map13.put("link", new TableInfo.Column("link", "TEXT", true, 2, null, 1));
                map13.put("pubDate", new TableInfo.Column("pubDate", "TEXT", false, 0, null, 1));
                map13.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                map13.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, 1));
                map13.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, 1));
                map13.put("variable", new TableInfo.Column("variable", "TEXT", false, 0, null, 1));
                TableInfo tableInfo25 = new TableInfo("rssStars", map13, new HashSet(0), new HashSet(0));
                TableInfo tableInfo26 = TableInfo.read(supportSQLiteDatabase, "rssStars");
                if (!tableInfo25.equals(tableInfo26)) {
                    return new RoomOpenHelper.ValidationResult(false, "rssStars(io.legado.app.data.entities.RssStar).\n Expected:\n" + tableInfo25 + "\n Found:\n" + tableInfo26);
                }
                HashMap map14 = new HashMap(5);
                map14.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map14.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map14.put("rule", new TableInfo.Column("rule", "TEXT", true, 0, null, 1));
                map14.put("serialNumber", new TableInfo.Column("serialNumber", "INTEGER", true, 0, null, 1));
                map14.put("enable", new TableInfo.Column("enable", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo27 = new TableInfo("txtTocRules", map14, new HashSet(0), new HashSet(0));
                TableInfo tableInfo28 = TableInfo.read(supportSQLiteDatabase, "txtTocRules");
                if (!tableInfo27.equals(tableInfo28)) {
                    return new RoomOpenHelper.ValidationResult(false, "txtTocRules(io.legado.app.data.entities.TxtTocRule).\n Expected:\n" + tableInfo27 + "\n Found:\n" + tableInfo28);
                }
                HashMap map15 = new HashMap(3);
                map15.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 1, null, 1));
                map15.put("bookName", new TableInfo.Column("bookName", "TEXT", true, 2, null, 1));
                map15.put("readTime", new TableInfo.Column("readTime", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo29 = new TableInfo("readRecord", map15, new HashSet(0), new HashSet(0));
                TableInfo tableInfo30 = TableInfo.read(supportSQLiteDatabase, "readRecord");
                if (!tableInfo29.equals(tableInfo30)) {
                    return new RoomOpenHelper.ValidationResult(false, "readRecord(io.legado.app.data.entities.ReadRecord).\n Expected:\n" + tableInfo29 + "\n Found:\n" + tableInfo30);
                }
                HashMap map16 = new HashMap(3);
                map16.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map16.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map16.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, 1));
                TableInfo tableInfo31 = new TableInfo("httpTTS", map16, new HashSet(0), new HashSet(0));
                TableInfo tableInfo32 = TableInfo.read(supportSQLiteDatabase, "httpTTS");
                if (!tableInfo31.equals(tableInfo32)) {
                    return new RoomOpenHelper.ValidationResult(false, "httpTTS(io.legado.app.data.entities.HttpTTS).\n Expected:\n" + tableInfo31 + "\n Found:\n" + tableInfo32);
                }
                HashMap map17 = new HashMap(3);
                map17.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
                map17.put(ES6Iterator.VALUE_PROPERTY, new TableInfo.Column(ES6Iterator.VALUE_PROPERTY, "TEXT", false, 0, null, 1));
                map17.put("deadline", new TableInfo.Column("deadline", "INTEGER", true, 0, null, 1));
                HashSet hashSet19 = new HashSet(0);
                HashSet hashSet20 = new HashSet(1);
                hashSet20.add(new TableInfo.Index("index_caches_key", true, Arrays.asList("key")));
                TableInfo tableInfo33 = new TableInfo("caches", map17, hashSet19, hashSet20);
                TableInfo tableInfo34 = TableInfo.read(supportSQLiteDatabase, "caches");
                if (!tableInfo33.equals(tableInfo34)) {
                    return new RoomOpenHelper.ValidationResult(false, "caches(io.legado.app.data.entities.Cache).\n Expected:\n" + tableInfo33 + "\n Found:\n" + tableInfo34);
                }
                HashMap map18 = new HashMap(7);
                map18.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map18.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map18.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, 1));
                map18.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                map18.put("customOrder", new TableInfo.Column("customOrder", "INTEGER", true, 0, null, 1));
                map18.put("autoUpdate", new TableInfo.Column("autoUpdate", "INTEGER", true, 0, null, 1));
                map18.put("update", new TableInfo.Column("update", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo35 = new TableInfo("ruleSubs", map18, new HashSet(0), new HashSet(0));
                TableInfo tableInfo36 = TableInfo.read(supportSQLiteDatabase, "ruleSubs");
                if (tableInfo35.equals(tableInfo36)) {
                    return new RoomOpenHelper.ValidationResult(true, null);
                }
                return new RoomOpenHelper.ValidationResult(false, "ruleSubs(io.legado.app.data.entities.RuleSub).\n Expected:\n" + tableInfo35 + "\n Found:\n" + tableInfo36);
            }
        }, "d1c390e708a1e89c7d016cdd2e0b2e88", "ab70ed147aad3bf95973430ae41ad752")).build());
    }

    @Override // io.legado.app.data.AppDatabase
    public BookChapterDao getBookChapterDao() {
        BookChapterDao bookChapterDao;
        if (this._bookChapterDao != null) {
            return this._bookChapterDao;
        }
        synchronized (this) {
            if (this._bookChapterDao == null) {
                this._bookChapterDao = new BookChapterDao_Impl(this);
            }
            bookChapterDao = this._bookChapterDao;
        }
        return bookChapterDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public BookDao getBookDao() {
        BookDao bookDao;
        if (this._bookDao != null) {
            return this._bookDao;
        }
        synchronized (this) {
            if (this._bookDao == null) {
                this._bookDao = new BookDao_Impl(this);
            }
            bookDao = this._bookDao;
        }
        return bookDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public BookGroupDao getBookGroupDao() {
        BookGroupDao bookGroupDao;
        if (this._bookGroupDao != null) {
            return this._bookGroupDao;
        }
        synchronized (this) {
            if (this._bookGroupDao == null) {
                this._bookGroupDao = new BookGroupDao_Impl(this);
            }
            bookGroupDao = this._bookGroupDao;
        }
        return bookGroupDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public BookSourceDao getBookSourceDao() {
        BookSourceDao bookSourceDao;
        if (this._bookSourceDao != null) {
            return this._bookSourceDao;
        }
        synchronized (this) {
            if (this._bookSourceDao == null) {
                this._bookSourceDao = new BookSourceDao_Impl(this);
            }
            bookSourceDao = this._bookSourceDao;
        }
        return bookSourceDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public BookmarkDao getBookmarkDao() {
        BookmarkDao bookmarkDao;
        if (this._bookmarkDao != null) {
            return this._bookmarkDao;
        }
        synchronized (this) {
            if (this._bookmarkDao == null) {
                this._bookmarkDao = new BookmarkDao_Impl(this);
            }
            bookmarkDao = this._bookmarkDao;
        }
        return bookmarkDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public CacheDao getCacheDao() {
        CacheDao cacheDao;
        if (this._cacheDao != null) {
            return this._cacheDao;
        }
        synchronized (this) {
            if (this._cacheDao == null) {
                this._cacheDao = new CacheDao_Impl(this);
            }
            cacheDao = this._cacheDao;
        }
        return cacheDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public CookieDao getCookieDao() {
        CookieDao cookieDao;
        if (this._cookieDao != null) {
            return this._cookieDao;
        }
        synchronized (this) {
            if (this._cookieDao == null) {
                this._cookieDao = new CookieDao_Impl(this);
            }
            cookieDao = this._cookieDao;
        }
        return cookieDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public HttpTTSDao getHttpTTSDao() {
        HttpTTSDao httpTTSDao;
        if (this._httpTTSDao != null) {
            return this._httpTTSDao;
        }
        synchronized (this) {
            if (this._httpTTSDao == null) {
                this._httpTTSDao = new HttpTTSDao_Impl(this);
            }
            httpTTSDao = this._httpTTSDao;
        }
        return httpTTSDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public ReadRecordDao getReadRecordDao() {
        ReadRecordDao readRecordDao;
        if (this._readRecordDao != null) {
            return this._readRecordDao;
        }
        synchronized (this) {
            if (this._readRecordDao == null) {
                this._readRecordDao = new ReadRecordDao_Impl(this);
            }
            readRecordDao = this._readRecordDao;
        }
        return readRecordDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public ReplaceRuleDao getReplaceRuleDao() {
        ReplaceRuleDao replaceRuleDao;
        if (this._replaceRuleDao != null) {
            return this._replaceRuleDao;
        }
        synchronized (this) {
            if (this._replaceRuleDao == null) {
                this._replaceRuleDao = new ReplaceRuleDao_Impl(this);
            }
            replaceRuleDao = this._replaceRuleDao;
        }
        return replaceRuleDao;
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(BookDao.class, BookDao_Impl.getRequiredConverters());
        map.put(BookGroupDao.class, BookGroupDao_Impl.getRequiredConverters());
        map.put(BookSourceDao.class, BookSourceDao_Impl.getRequiredConverters());
        map.put(BookChapterDao.class, BookChapterDao_Impl.getRequiredConverters());
        map.put(ReplaceRuleDao.class, ReplaceRuleDao_Impl.getRequiredConverters());
        map.put(SearchBookDao.class, SearchBookDao_Impl.getRequiredConverters());
        map.put(SearchKeywordDao.class, SearchKeywordDao_Impl.getRequiredConverters());
        map.put(RssSourceDao.class, RssSourceDao_Impl.getRequiredConverters());
        map.put(BookmarkDao.class, BookmarkDao_Impl.getRequiredConverters());
        map.put(RssArticleDao.class, RssArticleDao_Impl.getRequiredConverters());
        map.put(RssStarDao.class, RssStarDao_Impl.getRequiredConverters());
        map.put(CookieDao.class, CookieDao_Impl.getRequiredConverters());
        map.put(TxtTocRuleDao.class, TxtTocRuleDao_Impl.getRequiredConverters());
        map.put(ReadRecordDao.class, ReadRecordDao_Impl.getRequiredConverters());
        map.put(HttpTTSDao.class, HttpTTSDao_Impl.getRequiredConverters());
        map.put(CacheDao.class, CacheDao_Impl.getRequiredConverters());
        map.put(RuleSubDao.class, RuleSubDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // io.legado.app.data.AppDatabase
    public RssArticleDao getRssArticleDao() {
        RssArticleDao rssArticleDao;
        if (this._rssArticleDao != null) {
            return this._rssArticleDao;
        }
        synchronized (this) {
            if (this._rssArticleDao == null) {
                this._rssArticleDao = new RssArticleDao_Impl(this);
            }
            rssArticleDao = this._rssArticleDao;
        }
        return rssArticleDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public RssSourceDao getRssSourceDao() {
        RssSourceDao rssSourceDao;
        if (this._rssSourceDao != null) {
            return this._rssSourceDao;
        }
        synchronized (this) {
            if (this._rssSourceDao == null) {
                this._rssSourceDao = new RssSourceDao_Impl(this);
            }
            rssSourceDao = this._rssSourceDao;
        }
        return rssSourceDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public RssStarDao getRssStarDao() {
        RssStarDao rssStarDao;
        if (this._rssStarDao != null) {
            return this._rssStarDao;
        }
        synchronized (this) {
            if (this._rssStarDao == null) {
                this._rssStarDao = new RssStarDao_Impl(this);
            }
            rssStarDao = this._rssStarDao;
        }
        return rssStarDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public RuleSubDao getRuleSubDao() {
        RuleSubDao ruleSubDao;
        if (this._ruleSubDao != null) {
            return this._ruleSubDao;
        }
        synchronized (this) {
            if (this._ruleSubDao == null) {
                this._ruleSubDao = new RuleSubDao_Impl(this);
            }
            ruleSubDao = this._ruleSubDao;
        }
        return ruleSubDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public SearchBookDao getSearchBookDao() {
        SearchBookDao searchBookDao;
        if (this._searchBookDao != null) {
            return this._searchBookDao;
        }
        synchronized (this) {
            if (this._searchBookDao == null) {
                this._searchBookDao = new SearchBookDao_Impl(this);
            }
            searchBookDao = this._searchBookDao;
        }
        return searchBookDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public SearchKeywordDao getSearchKeywordDao() {
        SearchKeywordDao searchKeywordDao;
        if (this._searchKeywordDao != null) {
            return this._searchKeywordDao;
        }
        synchronized (this) {
            if (this._searchKeywordDao == null) {
                this._searchKeywordDao = new SearchKeywordDao_Impl(this);
            }
            searchKeywordDao = this._searchKeywordDao;
        }
        return searchKeywordDao;
    }

    @Override // io.legado.app.data.AppDatabase
    public TxtTocRuleDao getTxtTocRuleDao() {
        TxtTocRuleDao txtTocRuleDao;
        if (this._txtTocRuleDao != null) {
            return this._txtTocRuleDao;
        }
        synchronized (this) {
            if (this._txtTocRuleDao == null) {
                this._txtTocRuleDao = new TxtTocRuleDao_Impl(this);
            }
            txtTocRuleDao = this._txtTocRuleDao;
        }
        return txtTocRuleDao;
    }
}
