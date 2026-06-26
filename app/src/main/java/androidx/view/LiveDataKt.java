package androidx.view;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function1;", "Lf/v;", "onChanged", "Landroidx/lifecycle/Observer;", "observe", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LifecycleOwner;Lf/c0/b/l;)Landroidx/lifecycle/Observer;", "lifecycle-livedata-core-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class LiveDataKt {
    @Deprecated(message = "This extension method is not required when using Kotlin 1.4. You should remove \"import androidx.lifecycle.observe\"")
    @MainThread
    @NotNull
    public static final <T> Observer<T> observe(@NotNull LiveData<T> liveData, @NotNull LifecycleOwner lifecycleOwner, @NotNull final l<? super T, v> lVar) {
        j.e(liveData, "$this$observe");
        j.e(lifecycleOwner, "owner");
        j.e(lVar, "onChanged");
        Observer<T> observer = new Observer<T>() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.view.Observer
            public final void onChanged(T t) {
                lVar.invoke(t);
            }
        };
        liveData.observe(lifecycleOwner, observer);
        return observer;
    }
}
