package com.ss.android.downloadlib.g;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* JADX INFO: compiled from: AsyncTaskUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final a a = new C0085b();

    /* JADX INFO: compiled from: AsyncTaskUtils.java */
    public static class a {
        private a() {
        }

        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTaskUtils.java */
    @TargetApi(11)
    public static class C0085b extends a {
        private C0085b() {
            super();
        }

        @Override // com.ss.android.downloadlib.g.b.a
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        a.a(asyncTask, tArr);
    }
}
