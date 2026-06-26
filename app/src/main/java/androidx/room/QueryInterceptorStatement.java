package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> mBindArgsCache = new ArrayList();
    private final SupportSQLiteStatement mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;
    private final String mSqlStatement;

    public QueryInterceptorStatement(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RoomDatabase.QueryCallback queryCallback, String str, @NonNull Executor executor) {
        this.mDelegate = supportSQLiteStatement;
        this.mQueryCallback = queryCallback;
        this.mSqlStatement = str;
        this.mQueryCallbackExecutor = executor;
    }

    private void saveArgsToCache(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 >= this.mBindArgsCache.size()) {
            for (int size = this.mBindArgsCache.size(); size <= i3; size++) {
                this.mBindArgsCache.add(null);
            }
        }
        this.mBindArgsCache.set(i3, obj);
    }

    public /* synthetic */ void a() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    public /* synthetic */ void b() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i2, byte[] bArr) {
        saveArgsToCache(i2, bArr);
        this.mDelegate.bindBlob(i2, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i2, double d2) {
        saveArgsToCache(i2, Double.valueOf(d2));
        this.mDelegate.bindDouble(i2, d2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i2, long j2) {
        saveArgsToCache(i2, Long.valueOf(j2));
        this.mDelegate.bindLong(i2, j2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i2) {
        saveArgsToCache(i2, this.mBindArgsCache.toArray());
        this.mDelegate.bindNull(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i2, String str) {
        saveArgsToCache(i2, str);
        this.mDelegate.bindString(i2, str);
    }

    public /* synthetic */ void c() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    public /* synthetic */ void d() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    public /* synthetic */ void e() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: b.d.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        });
        this.mDelegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: b.d.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
        return this.mDelegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: b.d.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        });
        return this.mDelegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: b.d.n0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        });
        return this.mDelegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: b.d.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
        return this.mDelegate.simpleQueryForString();
    }
}
