package androidx.view;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import f.c0.b.a;
import f.c0.c.j;
import f.e;
import f.f0.c;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B1\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\n¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00028\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "Landroidx/lifecycle/ViewModel;", "VM", "Lf/e;", "", "isInitialized", "()Z", "getValue", "()Landroidx/lifecycle/ViewModel;", ES6Iterator.VALUE_PROPERTY, "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "Lf/c0/b/a;", "cached", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lf/f0/c;", "viewModelClass", "Lf/f0/c;", "<init>", "(Lf/f0/c;Lf/c0/b/a;Lf/c0/b/a;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class ViewModelLazy<VM extends ViewModel> implements e<VM> {
    private VM cached;
    private final a<ViewModelProvider.Factory> factoryProducer;
    private final a<ViewModelStore> storeProducer;
    private final c<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@NotNull c<VM> cVar, @NotNull a<? extends ViewModelStore> aVar, @NotNull a<? extends ViewModelProvider.Factory> aVar2) {
        j.e(cVar, "viewModelClass");
        j.e(aVar, "storeProducer");
        j.e(aVar2, "factoryProducer");
        this.viewModelClass = cVar;
        this.storeProducer = aVar;
        this.factoryProducer = aVar2;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // f.e
    @NotNull
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke());
        c<VM> cVar = this.viewModelClass;
        j.e(cVar, "$this$java");
        Class<?> clsA = ((f.c0.c.c) cVar).a();
        Objects.requireNonNull(clsA, "null cannot be cast to non-null type java.lang.Class<T>");
        VM vm2 = (VM) viewModelProvider.get(clsA);
        this.cached = vm2;
        j.d(vm2, "ViewModelProvider(store,…ed = it\n                }");
        return vm2;
    }
}
