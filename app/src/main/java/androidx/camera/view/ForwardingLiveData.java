package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.view.LiveData;
import androidx.view.MediatorLiveData;
import androidx.view.Observer;

/* JADX INFO: loaded from: classes.dex */
public final class ForwardingLiveData<T> extends MediatorLiveData<T> {
    private LiveData<T> mLiveDataSource;

    @Override // androidx.view.LiveData
    public T getValue() {
        LiveData<T> liveData = this.mLiveDataSource;
        if (liveData == null) {
            return null;
        }
        return liveData.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSource(@NonNull LiveData<T> liveData) {
        LiveData<T> liveData2 = this.mLiveDataSource;
        if (liveData2 != null) {
            super.removeSource(liveData2);
        }
        this.mLiveDataSource = liveData;
        super.addSource(liveData, new Observer() { // from class: b.a.d.a
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                this.a.setValue(obj);
            }
        });
    }
}
