package com.jeremyliao.liveeventbus;

import android.app.Application;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * Stub implementation of LiveEventBus.
 * Provides no-op implementations so the app compiles without the real library.
 */
public class LiveEventBus {

    public static LiveEventConfig config() {
        return new LiveEventConfig();
    }

    public static <T> LiveEventBusData<T> get(String key) {
        return new LiveEventBusData<>();
    }

    public static class LiveEventConfig {
        public LiveEventConfig supportBroadcast(Application app) { return this; }
        public LiveEventConfig lifecycleObserverAlwaysActive(boolean active) { return this; }
        public LiveEventConfig autoClear(boolean clear) { return this; }
    }

    public static class LiveEventBusData<T> {
        private final MutableLiveData<T> liveData = new MutableLiveData<>();

        public void post(T value) {
            // no-op in stub
        }

        public void observe(LifecycleOwner owner, Observer<T> observer) {
            // no-op in stub
        }

        public void observeSticky(LifecycleOwner owner, Observer<T> observer) {
            // no-op in stub
        }
    }
}
