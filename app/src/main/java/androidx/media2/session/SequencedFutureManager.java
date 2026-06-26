package androidx.media2.session;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SequencedFutureManager implements Closeable {
    private static final boolean DEBUG = false;
    private static final String TAG = "SequencedFutureManager";

    @GuardedBy("mLock")
    private int mNextSequenceNumber;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private ArrayMap<Integer, SequencedFuture<?>> mSeqToFutureMap = new ArrayMap<>();

    public static final class SequencedFuture<T> extends AbstractResolvableFuture<T> {
        private final T mResultWhenClosed;
        private final int mSequenceNumber;

        private SequencedFuture(int i2, @NonNull T t) {
            this.mSequenceNumber = i2;
            this.mResultWhenClosed = t;
        }

        public static <T> SequencedFuture<T> create(int i2, @NonNull T t) {
            return new SequencedFuture<>(i2, t);
        }

        @NonNull
        public T getResultWhenClosed() {
            return this.mResultWhenClosed;
        }

        public int getSequenceNumber() {
            return this.mSequenceNumber;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture
        public boolean set(@Nullable T t) {
            return super.set(t);
        }

        public void setWithTheValueOfResultWhenClosed() {
            set(this.mResultWhenClosed);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mSeqToFutureMap.values());
            this.mSeqToFutureMap.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SequencedFuture) it.next()).setWithTheValueOfResultWhenClosed();
        }
    }

    public <T> SequencedFuture<T> createSequencedFuture(T t) {
        SequencedFuture<T> sequencedFutureCreate;
        synchronized (this.mLock) {
            int iObtainNextSequenceNumber = obtainNextSequenceNumber();
            sequencedFutureCreate = SequencedFuture.create(iObtainNextSequenceNumber, t);
            this.mSeqToFutureMap.put(Integer.valueOf(iObtainNextSequenceNumber), sequencedFutureCreate);
        }
        return sequencedFutureCreate;
    }

    public int obtainNextSequenceNumber() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mNextSequenceNumber;
            this.mNextSequenceNumber = i2 + 1;
        }
        return i2;
    }

    public <T> void setFutureResult(int i2, T t) {
        synchronized (this.mLock) {
            SequencedFuture<?> sequencedFutureRemove = this.mSeqToFutureMap.remove(Integer.valueOf(i2));
            if (sequencedFutureRemove != null) {
                if (t == null || sequencedFutureRemove.getResultWhenClosed().getClass() == t.getClass()) {
                    sequencedFutureRemove.set(t);
                } else {
                    String str = "Type mismatch, expected " + sequencedFutureRemove.getResultWhenClosed().getClass() + ", but was " + t.getClass();
                }
            }
        }
    }
}
