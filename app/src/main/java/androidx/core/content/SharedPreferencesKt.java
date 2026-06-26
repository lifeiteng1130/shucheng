package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SharedPreferences.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/SharedPreferences;", "", "commit", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lf/v;", "Lkotlin/ExtensionFunctionType;", "action", "edit", "(Landroid/content/SharedPreferences;ZLf/c0/b/l;)V", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@NotNull SharedPreferences sharedPreferences, boolean z, @NotNull l<? super SharedPreferences.Editor, v> lVar) {
        j.f(sharedPreferences, "$this$edit");
        j.f(lVar, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        j.b(editorEdit, "editor");
        lVar.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        j.f(sharedPreferences, "$this$edit");
        j.f(lVar, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        j.b(editorEdit, "editor");
        lVar.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
