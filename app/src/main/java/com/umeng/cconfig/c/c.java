package com.umeng.cconfig.c;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static BlockingQueue<Runnable> f5049d = new ArrayBlockingQueue(64);
    private static int a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f5047b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f5048c = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f5050e = new ThreadPoolExecutor(a, f5047b, f5048c, TimeUnit.SECONDS, f5049d);

    public static void a(Runnable runnable) {
        f5050e.execute(runnable);
    }
}
