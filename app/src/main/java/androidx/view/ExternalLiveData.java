package androidx.view;

import androidx.annotation.NonNull;
import androidx.view.Lifecycle;
import androidx.view.LiveData;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ExternalLiveData<T> extends MutableLiveData<T> {
    public static final int START_VERSION = -1;

    public class ExternalLifecycleBoundObserver extends LiveData<T>.LifecycleBoundObserver {
        public ExternalLifecycleBoundObserver(@NonNull LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(lifecycleOwner, observer);
        }

        @Override // androidx.lifecycle.LiveData.LifecycleBoundObserver, androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(ExternalLiveData.this.observerActiveLevel());
        }
    }

    private Object callMethodPutIfAbsent(Object obj, Object obj2) throws NoSuchFieldException, NoSuchMethodException {
        Object fieldObservers = getFieldObservers();
        Method declaredMethod = fieldObservers.getClass().getDeclaredMethod("putIfAbsent", Object.class, Object.class);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(fieldObservers, obj, obj2);
    }

    private Object getFieldObservers() throws NoSuchFieldException {
        Field declaredField = LiveData.class.getDeclaredField("mObservers");
        declaredField.setAccessible(true);
        return declaredField.get(this);
    }

    @Override // androidx.view.LiveData
    public int getVersion() {
        return super.getVersion();
    }

    @Override // androidx.view.LiveData
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        try {
            ExternalLifecycleBoundObserver externalLifecycleBoundObserver = new ExternalLifecycleBoundObserver(lifecycleOwner, observer);
            LiveData.LifecycleBoundObserver lifecycleBoundObserver = (LiveData.LifecycleBoundObserver) callMethodPutIfAbsent(observer, externalLifecycleBoundObserver);
            if (lifecycleBoundObserver != null && !lifecycleBoundObserver.isAttachedTo(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
            if (lifecycleBoundObserver != null) {
                return;
            }
            lifecycleOwner.getLifecycle().addObserver(externalLifecycleBoundObserver);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Lifecycle.State observerActiveLevel() {
        return Lifecycle.State.CREATED;
    }
}
