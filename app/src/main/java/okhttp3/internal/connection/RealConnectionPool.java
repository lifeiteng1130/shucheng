package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import c.a.a.a.a;
import d.a.a.b;
import f.c0.c.f;
import f.c0.c.j;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RealConnectionPool.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001*\u0018\u0000 42\u00020\u0001:\u00014B'\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010/\u001a\u00020\u0004\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ5\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00065"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "Lokhttp3/internal/connection/RealConnection;", b.HEADER_CONNECTION, "", "now", "", "pruneAndGetAllocationCount", "(Lokhttp3/internal/connection/RealConnection;J)I", "idleConnectionCount", "()I", "connectionCount", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "", "Lokhttp3/Route;", "routes", "", "requireMultiplexed", "callAcquirePooledConnection", "(Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Ljava/util/List;Z)Z", "Lf/v;", "put", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionBecameIdle", "(Lokhttp3/internal/connection/RealConnection;)Z", "evictAll", "()V", "cleanup", "(J)J", "maxIdleConnections", OptRuntime.GeneratorState.resumptionPoint_TYPE, "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "keepAliveDurationNs", "J", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealConnectionPool {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* JADX INFO: compiled from: RealConnectionPool.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "Lokhttp3/ConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "get", "(Lokhttp3/ConnectionPool;)Lokhttp3/internal/connection/RealConnectionPool;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final RealConnectionPool get(@NotNull ConnectionPool connectionPool) {
            j.e(connectionPool, "connectionPool");
            return connectionPool.getDelegate();
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(@NotNull TaskRunner taskRunner, int i2, long j2, @NotNull TimeUnit timeUnit) {
        j.e(taskRunner, "taskRunner");
        j.e(timeUnit, "timeUnit");
        this.maxIdleConnections = i2;
        this.keepAliveDurationNs = timeUnit.toNanos(j2);
        this.cleanupQueue = taskRunner.newQueue();
        final String strP = a.p(new StringBuilder(), Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new Task(strP) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return this.this$0.cleanup(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(a.f("keepAliveDuration <= 0: ", j2).toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection connection, long now) {
        if (Util.assertionsEnabled && !Thread.holdsLock(connection)) {
            StringBuilder sbR = a.r("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            j.d(threadCurrentThread, "Thread.currentThread()");
            sbR.append(threadCurrentThread.getName());
            sbR.append(" MUST hold lock on ");
            sbR.append(connection);
            throw new AssertionError(sbR.toString());
        }
        List<Reference<RealCall>> calls = connection.getCalls();
        int i2 = 0;
        while (i2 < calls.size()) {
            Reference<RealCall> reference = calls.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                StringBuilder sbR2 = a.r("A connection to ");
                sbR2.append(connection.getRoute().address().url());
                sbR2.append(" was leaked. ");
                sbR2.append("Did you forget to close a response body?");
                Platform.INSTANCE.get().logCloseableLeak(sbR2.toString(), ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i2);
                connection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    connection.setIdleAtNs$okhttp(now - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    public final boolean callAcquirePooledConnection(@NotNull Address address, @NotNull RealCall call, @Nullable List<Route> routes, boolean requireMultiplexed) {
        j.e(address, "address");
        j.e(call, NotificationCompat.CATEGORY_CALL);
        for (RealConnection realConnection : this.connections) {
            j.d(realConnection, b.HEADER_CONNECTION);
            synchronized (realConnection) {
                if (requireMultiplexed) {
                    if (!realConnection.isMultiplexed$okhttp()) {
                    }
                }
                if (realConnection.isEligible$okhttp(address, routes)) {
                    call.acquireConnectionNoEvents(realConnection);
                    return true;
                }
            }
        }
        return false;
    }

    public final long cleanup(long now) {
        int i2 = 0;
        long j2 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i3 = 0;
        for (RealConnection realConnection2 : this.connections) {
            j.d(realConnection2, b.HEADER_CONNECTION);
            synchronized (realConnection2) {
                if (pruneAndGetAllocationCount(realConnection2, now) > 0) {
                    i3++;
                } else {
                    i2++;
                    long idleAtNs = now - realConnection2.getIdleAtNs();
                    if (idleAtNs > j2) {
                        realConnection = realConnection2;
                        j2 = idleAtNs;
                    }
                }
            }
        }
        long j3 = this.keepAliveDurationNs;
        if (j2 < j3 && i2 <= this.maxIdleConnections) {
            if (i2 > 0) {
                return j3 - j2;
            }
            if (i3 > 0) {
                return j3;
            }
            return -1L;
        }
        j.c(realConnection);
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs() + j2 != now) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(@NotNull RealConnection connection) {
        j.e(connection, b.HEADER_CONNECTION);
        if (Util.assertionsEnabled && !Thread.holdsLock(connection)) {
            StringBuilder sbR = a.r("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            j.d(threadCurrentThread, "Thread.currentThread()");
            sbR.append(threadCurrentThread.getName());
            sbR.append(" MUST hold lock on ");
            sbR.append(connection);
            throw new AssertionError(sbR.toString());
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        connection.setNoNewExchanges(true);
        this.connections.remove(connection);
        if (!this.connections.isEmpty()) {
            return true;
        }
        this.cleanupQueue.cancelAll();
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        j.d(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection next = it.next();
            j.d(next, b.HEADER_CONNECTION);
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean zIsEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i2 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (RealConnection realConnection : concurrentLinkedQueue) {
                j.d(realConnection, "it");
                synchronized (realConnection) {
                    zIsEmpty = realConnection.getCalls().isEmpty();
                }
                if (zIsEmpty && (i2 = i2 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i2;
    }

    public final void put(@NotNull RealConnection connection) {
        j.e(connection, b.HEADER_CONNECTION);
        if (!Util.assertionsEnabled || Thread.holdsLock(connection)) {
            this.connections.add(connection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return;
        }
        StringBuilder sbR = a.r("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        j.d(threadCurrentThread, "Thread.currentThread()");
        sbR.append(threadCurrentThread.getName());
        sbR.append(" MUST hold lock on ");
        sbR.append(connection);
        throw new AssertionError(sbR.toString());
    }
}
