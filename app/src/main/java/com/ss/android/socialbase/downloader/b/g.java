package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;

/* JADX INFO: compiled from: TableStatements.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private final SQLiteDatabase a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f3479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f3480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SQLiteStatement f3481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SQLiteStatement f3482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SQLiteStatement f3483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SQLiteStatement f3484h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.f3478b = str;
        this.f3479c = strArr;
        this.f3480d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f3481e == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f3478b, this.f3479c));
            synchronized (this) {
                if (this.f3481e == null) {
                    this.f3481e = sQLiteStatementCompileStatement;
                }
            }
            if (this.f3481e != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.f3481e;
    }

    public SQLiteStatement b() {
        if (this.f3483g == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement(i.a(this.f3478b, this.f3480d));
            synchronized (this) {
                if (this.f3483g == null) {
                    this.f3483g = sQLiteStatementCompileStatement;
                }
            }
            if (this.f3483g != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.f3483g;
    }

    public SQLiteStatement c() {
        if (this.f3482f == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement(i.a(this.f3478b, this.f3479c, this.f3480d));
            synchronized (this) {
                if (this.f3482f == null) {
                    this.f3482f = sQLiteStatementCompileStatement;
                }
            }
            if (this.f3482f != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.f3482f;
    }

    public SQLiteStatement d() {
        if (this.f3484h == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement(i.b(this.f3478b, this.f3479c, this.f3480d));
            synchronized (this) {
                if (this.f3484h == null) {
                    this.f3484h = sQLiteStatementCompileStatement;
                }
            }
            if (this.f3484h != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.f3484h;
    }
}
