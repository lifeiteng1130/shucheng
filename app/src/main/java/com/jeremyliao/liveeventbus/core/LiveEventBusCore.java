package com.jeremyliao.liveeventbus.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.view.ExternalLiveData;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import com.jeremyliao.liveeventbus.ipc.IpcConst;
import com.jeremyliao.liveeventbus.ipc.encode.IEncoder;
import com.jeremyliao.liveeventbus.ipc.encode.ValueEncoder;
import com.jeremyliao.liveeventbus.ipc.json.GsonConverter;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;
import com.jeremyliao.liveeventbus.ipc.receiver.LebIpcReceiver;
import com.jeremyliao.liveeventbus.logger.DefaultLogger;
import com.jeremyliao.liveeventbus.logger.Logger;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import com.jeremyliao.liveeventbus.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class LiveEventBusCore {
    private Context appContext;
    private boolean autoClear;
    private final Map<String, LiveEvent<Object>> bus;
    private final Config config;
    private IEncoder encoder;
    private boolean lifecycleObserverAlwaysActive;
    private LoggerManager logger;
    private LebIpcReceiver receiver;

    public class LiveEvent<T> implements Observable<T> {

        @NonNull
        private final String key;
        private final Map<Observer, ObserverWrapper<T>> observerMap = new HashMap();
        private final Handler mainHandler = new Handler(Looper.getMainLooper());
        private final LiveEvent<T>.LifecycleLiveData<T> liveData = new LifecycleLiveData<>();

        public class LifecycleLiveData<T> extends ExternalLiveData<T> {
            private LifecycleLiveData() {
            }

            @Override // androidx.view.ExternalLiveData
            public Lifecycle.State observerActiveLevel() {
                return LiveEventBusCore.this.lifecycleObserverAlwaysActive ? Lifecycle.State.CREATED : Lifecycle.State.STARTED;
            }

            @Override // androidx.view.LiveData
            public void removeObserver(@NonNull Observer<? super T> observer) {
                super.removeObserver(observer);
                if (LiveEventBusCore.this.autoClear && !LiveEvent.this.liveData.hasObservers()) {
                    LiveEventBusCore.get().bus.remove(LiveEvent.this.key);
                }
                LiveEventBusCore.this.logger.log(Level.INFO, "observer removed: " + observer);
            }
        }

        public class PostLifeValueTask implements Runnable {
            private Object newValue;
            private LifecycleOwner owner;

            public PostLifeValueTask(@NonNull Object obj, @Nullable LifecycleOwner lifecycleOwner) {
                this.newValue = obj;
                this.owner = lifecycleOwner;
            }

            @Override // java.lang.Runnable
            public void run() {
                LifecycleOwner lifecycleOwner = this.owner;
                if (lifecycleOwner == null || !lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    return;
                }
                LiveEvent.this.postInternal(this.newValue);
            }
        }

        public class PostValueTask implements Runnable {
            private Object newValue;

            public PostValueTask(@NonNull Object obj) {
                this.newValue = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                LiveEvent.this.postInternal(this.newValue);
            }
        }

        public LiveEvent(@NonNull String str) {
            this.key = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @MainThread
        public void broadcastInternal(T t, boolean z) {
            LiveEventBusCore.this.logger.log(Level.INFO, "broadcast: " + t + " foreground: " + z + " with key: " + this.key);
            Intent intent = new Intent(IpcConst.ACTION);
            if (z) {
                intent.addFlags(268435456);
            }
            intent.putExtra(IpcConst.KEY, this.key);
            try {
                LiveEventBusCore.this.encoder.encode(intent, t);
                LiveEventBusCore.this.appContext.sendBroadcast(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @MainThread
        public void observeForeverInternal(@NonNull Observer<T> observer) {
            ObserverWrapper<T> observerWrapper = LiveEventBusCore.this.new ObserverWrapper<>(observer);
            ((ObserverWrapper) observerWrapper).preventNextEvent = this.liveData.getVersion() > -1;
            this.observerMap.put(observer, observerWrapper);
            this.liveData.observeForever(observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe forever observer: " + observerWrapper + "(" + observer + ") with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @MainThread
        public void observeInternal(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer) {
            ObserverWrapper observerWrapper = LiveEventBusCore.this.new ObserverWrapper(observer);
            observerWrapper.preventNextEvent = this.liveData.getVersion() > -1;
            this.liveData.observe(lifecycleOwner, observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe observer: " + observerWrapper + "(" + observer + ") on owner: " + lifecycleOwner + " with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @MainThread
        public void observeStickyForeverInternal(@NonNull Observer<T> observer) {
            ObserverWrapper<T> observerWrapper = LiveEventBusCore.this.new ObserverWrapper<>(observer);
            this.observerMap.put(observer, observerWrapper);
            this.liveData.observeForever(observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe sticky forever observer: " + observerWrapper + "(" + observer + ") with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @MainThread
        public void observeStickyInternal(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer) {
            ObserverWrapper observerWrapper = LiveEventBusCore.this.new ObserverWrapper(observer);
            this.liveData.observe(lifecycleOwner, observerWrapper);
            LiveEventBusCore.this.logger.log(Level.INFO, "observe sticky observer: " + observerWrapper + "(" + observer + ") on owner: " + lifecycleOwner + " with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @MainThread
        public void postInternal(T t) {
            LiveEventBusCore.this.logger.log(Level.INFO, "post: " + t + " with key: " + this.key);
            this.liveData.setValue(t);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @MainThread
        public void removeObserverInternal(@NonNull Observer<T> observer) {
            if (this.observerMap.containsKey(observer)) {
                observer = this.observerMap.remove(observer);
            }
            this.liveData.removeObserver(observer);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void broadcast(T t) {
            broadcast(t, false);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observe(@NonNull final LifecycleOwner lifecycleOwner, @NonNull final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeInternal(lifecycleOwner, observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeInternal(lifecycleOwner, observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeForever(@NonNull final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeForeverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.4
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeForeverInternal(observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeSticky(@NonNull final LifecycleOwner lifecycleOwner, @NonNull final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeStickyInternal(lifecycleOwner, observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeStickyInternal(lifecycleOwner, observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeStickyForever(@NonNull final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeStickyForeverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeStickyForeverInternal(observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void post(T t) {
            if (ThreadUtils.isMainThread()) {
                postInternal(t);
            } else {
                this.mainHandler.post(new PostValueTask(t));
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postDelay(T t, long j2) {
            this.mainHandler.postDelayed(new PostValueTask(t), j2);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postOrderly(T t) {
            this.mainHandler.post(new PostValueTask(t));
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void removeObserver(@NonNull final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                removeObserverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.6
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.removeObserverInternal(observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void broadcast(final T t, final boolean z) {
            if (LiveEventBusCore.this.appContext == null) {
                post(t);
            } else if (ThreadUtils.isMainThread()) {
                broadcastInternal(t, z);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.broadcastInternal(t, z);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postDelay(LifecycleOwner lifecycleOwner, T t, long j2) {
            this.mainHandler.postDelayed(new PostLifeValueTask(t, lifecycleOwner), j2);
        }
    }

    public class ObserverWrapper<T> implements Observer<T> {

        @NonNull
        private final Observer<T> observer;
        private boolean preventNextEvent = false;

        public ObserverWrapper(@NonNull Observer<T> observer) {
            this.observer = observer;
        }

        @Override // androidx.view.Observer
        public void onChanged(@Nullable T t) {
            if (this.preventNextEvent) {
                this.preventNextEvent = false;
                return;
            }
            LiveEventBusCore.this.logger.log(Level.INFO, "message received: " + t);
            try {
                this.observer.onChanged(t);
            } catch (ClassCastException e2) {
                LiveEventBusCore.this.logger.log(Level.WARNING, "class cast error on message received: " + t, e2);
            } catch (Exception e3) {
                LiveEventBusCore.this.logger.log(Level.WARNING, "error on message received: " + t, e3);
            }
        }
    }

    public static class SingletonHolder {
        private static final LiveEventBusCore DEFAULT_BUS = new LiveEventBusCore();

        private SingletonHolder() {
        }
    }

    public static LiveEventBusCore get() {
        return SingletonHolder.DEFAULT_BUS;
    }

    public Config config() {
        return this.config;
    }

    public void enableLogger(boolean z) {
        this.logger.setEnable(z);
    }

    public void registerReceiver(Context context) {
        if (context != null) {
            this.appContext = context.getApplicationContext();
        }
        if (this.appContext != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IpcConst.ACTION);
            this.appContext.registerReceiver(this.receiver, intentFilter);
        }
    }

    public void setAutoClear(boolean z) {
        this.autoClear = z;
    }

    public void setJsonConverter(JsonConverter jsonConverter) {
        if (jsonConverter == null) {
            return;
        }
        this.encoder = new ValueEncoder(jsonConverter);
        this.receiver.setJsonConverter(jsonConverter);
    }

    public void setLifecycleObserverAlwaysActive(boolean z) {
        this.lifecycleObserverAlwaysActive = z;
    }

    public void setLogger(@NonNull Logger logger) {
        this.logger.setLogger(logger);
    }

    public synchronized <T> Observable<T> with(String str, Class<T> cls) {
        if (!this.bus.containsKey(str)) {
            this.bus.put(str, new LiveEvent<>(str));
        }
        return this.bus.get(str);
    }

    private LiveEventBusCore() {
        this.config = new Config();
        this.bus = new HashMap();
        this.lifecycleObserverAlwaysActive = true;
        this.autoClear = false;
        this.logger = new LoggerManager(new DefaultLogger());
        GsonConverter gsonConverter = new GsonConverter();
        this.encoder = new ValueEncoder(gsonConverter);
        this.receiver = new LebIpcReceiver(gsonConverter);
    }
}
