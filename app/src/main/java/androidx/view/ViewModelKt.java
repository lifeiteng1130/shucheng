package androidx.view;

import c.b.a.m.f;
import f.c0.c.j;
import f.z.f;
import g.b.a0;
import g.b.f1;
import g.b.g2.m;
import g.b.k0;
import g.b.k1;
import g.b.y;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0017\u0010\u0007\u001a\u00020\u0004*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"", "JOB_KEY", "Ljava/lang/String;", "Landroidx/lifecycle/ViewModel;", "Lg/b/a0;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lg/b/a0;", "viewModelScope", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @NotNull
    public static final a0 getViewModelScope(@NotNull ViewModel viewModel) {
        j.e(viewModel, "$this$viewModelScope");
        a0 a0Var = (a0) viewModel.getTag(JOB_KEY);
        if (a0Var != null) {
            return a0Var;
        }
        f1 f1VarC = f.c(null, 1);
        y yVar = k0.a;
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(f.a.C0182a.d((k1) f1VarC, m.f6207b.n())));
        j.d(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (a0) tagIfAbsent;
    }
}
