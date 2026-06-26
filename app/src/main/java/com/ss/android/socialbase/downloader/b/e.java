package com.ss.android.socialbase.downloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.f.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* JADX INFO: compiled from: SqlDownloadCache.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends c.a implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SQLiteDatabase f3439b;
    public b a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f3440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f3441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g f3442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f3443f;

    public e() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (f3439b == null) {
            synchronized (e.class) {
                if (f3439b == null) {
                    try {
                        f3439b = a.a().getWritableDatabase();
                        this.f3440c = new g(f3439b, "downloader", com.ss.android.socialbase.downloader.constants.c.a, com.ss.android.socialbase.downloader.constants.c.f3495b);
                        this.f3441d = new g(f3439b, "downloadChunk", com.ss.android.socialbase.downloader.constants.c.f3496c, com.ss.android.socialbase.downloader.constants.c.f3497d);
                        this.f3442e = new g(f3439b, "segments", com.ss.android.socialbase.downloader.constants.c.f3498e, com.ss.android.socialbase.downloader.constants.c.f3499f);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private void i() {
        f3439b.beginTransaction();
    }

    private void j() {
        try {
            if (f3439b == null || !f3439b.inTransaction()) {
                return;
            }
            f3439b.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        try {
            i();
            f3439b.delete("downloader", null, null);
            f3439b.delete("downloadChunk", null, null);
            f3439b.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    private void update(final int i2, final ContentValues contentValues) {
        h();
        if (f3439b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.a(i2, contentValues);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> c(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> d(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e(int i2) {
        g gVar;
        h();
        if (f3439b != null && (gVar = this.f3440c) != null) {
            try {
                a(i2, gVar.b());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean f(final int i2) {
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.11
            @Override // java.lang.Runnable
            public void run() {
                e.this.e(i2);
                e.this.d(i2);
                e.this.m(i2);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo g(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, i> l(int i2) {
        Cursor cursorRawQuery;
        h();
        if (f3439b != null) {
            try {
                cursorRawQuery = f3439b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i2)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        int columnIndex = cursorRawQuery.getColumnIndex("info");
                        String string = columnIndex >= 0 ? cursorRawQuery.getString(columnIndex) : null;
                        HashMap map = new HashMap();
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            i iVar = new i(jSONArray.getJSONObject(i3));
                            map.put(Long.valueOf(iVar.c()), iVar);
                        }
                        com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                        return map;
                    }
                    com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursorRawQuery = null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i2) {
        h();
        if (f3439b == null) {
            return;
        }
        try {
            a(i2, this.f3442e.b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public e(boolean z) {
        this.a = null;
        if (z) {
            this.f3443f = false;
            a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2) {
        Cursor cursorRawQuery;
        h();
        if (f3439b != null) {
            try {
                cursorRawQuery = f3439b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i2)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                        com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                        return downloadInfo;
                    }
                    com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursorRawQuery = null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        ArrayList arrayList = new ArrayList();
        h();
        if (f3439b != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = f3439b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i2)});
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.b(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void d(final int i2) {
        h();
        if (f3439b == null || this.f3441d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i2, e.this.f3441d.b());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo i(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 1);
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo j(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-7));
        update(i2, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!a(downloadInfo.getId())) {
            c(downloadInfo);
        } else {
            g gVar = this.f3440c;
            if (gVar == null) {
                return;
            }
            try {
                b(downloadInfo, gVar.c());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo e(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j2));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ArrayList<i> n(int i2) {
        Map<Long, i> mapL = l(i2);
        if (mapL == null || mapL.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mapL.values());
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo h(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        a(bVar);
    }

    private void b(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a() {
        a(new SparseArray<>(), new SparseArray<>(), (d) null);
    }

    private void c(final DownloadInfo downloadInfo) {
        h();
        if (f3439b == null || this.f3440c == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e eVar = e.this;
                    eVar.a(downloadInfo, eVar.f3440c.a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, final d dVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.1
                /* JADX WARN: Removed duplicated region for block: B:167:0x0341 A[PHI: r0
  0x0341: PHI (r0v14 com.ss.android.socialbase.downloader.b.d) = (r0v13 com.ss.android.socialbase.downloader.b.d), (r0v18 com.ss.android.socialbase.downloader.b.d) binds: [B:166:0x033f, B:161:0x0336] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:84:0x01a6 A[PHI: r0
  0x01a6: PHI (r0v30 com.ss.android.socialbase.downloader.b.d) = 
  (r0v27 com.ss.android.socialbase.downloader.b.d)
  (r0v29 com.ss.android.socialbase.downloader.b.d)
  (r0v41 com.ss.android.socialbase.downloader.b.d)
  (r0v43 com.ss.android.socialbase.downloader.b.d)
 binds: [B:125:0x027b, B:120:0x0271, B:83:0x01a4, B:78:0x019b] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instruction units count: 877
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.b.e.AnonymousClass1.run():void");
                }
            };
            ExecutorService executorServiceR = com.ss.android.socialbase.downloader.downloader.c.r();
            if (executorServiceR != null) {
                executorServiceR.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo d(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j2));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void c() {
        h();
        if (f3439b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.i.f.b(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean d() {
        return this.f3443f;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j2));
        if (j2 > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo c(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j2));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i2, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || f3439b == null) {
            return;
        }
        synchronized (f3439b) {
            try {
                try {
                    i();
                    if (!list.isEmpty()) {
                        if (com.ss.android.socialbase.downloader.g.a.c().a("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                strArr[i2] = String.valueOf(list.get(i2));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            f3439b.delete("downloader", str, strArr);
                            f3439b.delete("downloadChunk", str, strArr);
                        } else {
                            String strJoin = TextUtils.join(", ", list2);
                            f3439b.delete("downloader", "_id IN (?)", new String[]{strJoin});
                            f3439b.delete("downloadChunk", "_id IN (?)", new String[]{strJoin});
                        }
                    }
                    for (int i3 = 0; i3 < size; i3++) {
                        int iKeyAt = sparseArray.keyAt(i3);
                        DownloadInfo downloadInfo = sparseArray.get(iKeyAt);
                        f3439b.delete("downloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                        f3439b.insert("downloader", null, downloadInfo.toContentValues());
                        if (downloadInfo.getChunkCount() > 1) {
                            List<com.ss.android.socialbase.downloader.model.b> listC = c(iKeyAt);
                            if (listC.size() > 0) {
                                f3439b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                                for (com.ss.android.socialbase.downloader.model.b bVar : listC) {
                                    bVar.b(downloadInfo.getId());
                                    f3439b.insert("downloadChunk", null, bVar.a());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        int size2 = sparseArray2.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            int id = sparseArray2.valueAt(i4).getId();
                            List<com.ss.android.socialbase.downloader.model.b> listA = com.ss.android.socialbase.downloader.i.f.a(c(id));
                            if (listA != null && listA.size() > 0) {
                                sparseArray3.put(id, listA);
                            }
                        }
                    }
                    f3439b.setTransactionSuccessful();
                } finally {
                    try {
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            d(i2);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                    if (bVar != null) {
                        a(bVar);
                        if (bVar.f()) {
                            Iterator<com.ss.android.socialbase.downloader.model.b> it = bVar.g().iterator();
                            while (it.hasNext()) {
                                a(it.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(int i2) {
        try {
            return b(i2) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> a(String str) {
        h();
        ArrayList arrayList = new ArrayList();
        if (f3439b != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = f3439b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursorRawQuery.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.i.f.a(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i2);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final com.ss.android.socialbase.downloader.model.b bVar) {
        h();
        if (f3439b == null || this.f3441d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(bVar, e.this.f3441d.a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.model.b bVar, SQLiteStatement sQLiteStatement) {
        if (bVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                bVar.a(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i2, final int i3, final long j2) {
        h();
        if (i2 == 0 || i3 < 0 || j2 < 0 || f3439b == null || this.f3441d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i2, i3, j2, e.this.f3441d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i2, final int i3, final int i4, final long j2) {
        h();
        if (i2 == 0 || i3 < 0 || i4 < 0 || j2 < 0 || f3439b == null || this.f3441d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i2, i3, i4, j2, e.this.f3441d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i2, final int i3, final int i4, final int i5) {
        h();
        if (i2 == 0 || i4 < 0 || i5 == i3 || i5 < 0 || f3439b == null || this.f3441d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i2, i3, i4, i5, e.this.f3441d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, int i5, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i5));
                f3439b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, long j2, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j2));
                f3439b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, long j2, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j2));
                f3439b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, int i3) {
        h();
        if (f3439b == null) {
            return null;
        }
        int i4 = 10;
        while (f3439b.isDbLockedByCurrentThread() && i4 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i3));
        f3439b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(final DownloadInfo downloadInfo) {
        h();
        if (downloadInfo == null || f3439b == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.10
            @Override // java.lang.Runnable
            public void run() {
                e.this.d(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j2));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j2));
        update(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i2, Map<Long, i> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        h();
        if (f3439b == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).k());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String str = "json=" + jSONArray;
        SQLiteStatement sQLiteStatementD = this.f3442e.d();
        synchronized (sQLiteStatementD) {
            sQLiteStatementD.clearBindings();
            sQLiteStatementD.bindLong(1, i2);
            sQLiteStatementD.bindString(2, jSONArray.toString());
            sQLiteStatementD.execute();
        }
        StringBuilder sbR = c.a.a.a.a.r("updateSegments cost=");
        sbR.append(com.ss.android.socialbase.downloader.i.f.c(jCurrentTimeMillis));
        com.ss.android.socialbase.downloader.c.a.b("SqlDownloadCache", sbR.toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, ContentValues contentValues) {
        int i3 = 10;
        while (f3439b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        try {
            f3439b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(b bVar) {
        this.a = bVar;
    }

    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2) {
        try {
            HashMap mapA = com.ss.android.socialbase.downloader.i.f.a(sparseArray);
            HashMap mapA2 = com.ss.android.socialbase.downloader.i.f.a(sparseArray2);
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(mapA, mapA2);
            }
        } catch (Throwable unused) {
        }
    }
}
