package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static void decrementAll(@NonNull List<DeferrableSurface> list) {
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            it.next().decrementUseCount();
        }
    }

    public static void incrementAll(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (list.isEmpty()) {
            return;
        }
        int i2 = 0;
        do {
            try {
                list.get(i2).incrementUseCount();
                i2++;
            } catch (DeferrableSurface.SurfaceClosedException e2) {
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    list.get(i3).decrementUseCount();
                }
                throw e2;
            }
        } while (i2 < list.size());
    }

    @NonNull
    public static a<List<Surface>> surfaceListWithTimeout(@NonNull Collection<DeferrableSurface> collection, final boolean z, final long j2, @NonNull final Executor executor, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        final ArrayList arrayList = new ArrayList();
        Iterator<DeferrableSurface> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSurface());
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.b.w1.i
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                List list = arrayList;
                ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService;
                final Executor executor2 = executor;
                final long j3 = j2;
                final boolean z2 = z;
                final c.e.b.a.a.a aVarSuccessfulAsList = Futures.successfulAsList(list);
                final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService2.schedule(new Runnable() { // from class: b.a.b.w1.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        Executor executor3 = executor2;
                        final c.e.b.a.a.a aVar = aVarSuccessfulAsList;
                        final CallbackToFutureAdapter.Completer completer2 = completer;
                        final long j4 = j3;
                        executor3.execute(new Runnable() { // from class: b.a.b.w1.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.e.b.a.a.a aVar2 = aVar;
                                CallbackToFutureAdapter.Completer completer3 = completer2;
                                long j5 = j4;
                                if (aVar2.isDone()) {
                                    return;
                                }
                                completer3.setException(new TimeoutException(c.a.a.a.a.f("Cannot complete surfaceList within ", j5)));
                                aVar2.cancel(true);
                            }
                        });
                    }
                }, j3, TimeUnit.MILLISECONDS);
                completer.addCancellationListener(new Runnable() { // from class: b.a.b.w1.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVarSuccessfulAsList.cancel(true);
                    }
                }, executor2);
                Futures.addCallback(aVarSuccessfulAsList, new FutureCallback<List<Surface>>() { // from class: androidx.camera.core.impl.DeferrableSurfaces.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(Throwable th) {
                        completer.set(Collections.unmodifiableList(Collections.emptyList()));
                        scheduledFutureSchedule.cancel(true);
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(@Nullable List<Surface> list2) {
                        ArrayList arrayList2 = new ArrayList(list2);
                        if (z2) {
                            arrayList2.removeAll(Collections.singleton(null));
                        }
                        completer.set(arrayList2);
                        scheduledFutureSchedule.cancel(true);
                    }
                }, executor2);
                return "surfaceList";
            }
        });
    }

    public static boolean tryIncrementAll(@NonNull List<DeferrableSurface> list) {
        try {
            incrementAll(list);
            return true;
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            return false;
        }
    }
}
