package e.a.a.g.k.d.b;

import android.text.Editable;
import android.text.TextWatcher;
import com.umeng.analytics.pro.ai;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceEditAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements TextWatcher {
    public final /* synthetic */ b a;

    public f(b bVar) {
        this.a = bVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        this.a.f5881b = editable == null ? null : editable.toString();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
        f.c0.c.j.e(charSequence, ai.az);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
        f.c0.c.j.e(charSequence, ai.az);
    }
}
