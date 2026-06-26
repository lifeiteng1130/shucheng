package e.a.a.g.m.l;

import android.net.Uri;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import g.b.a0;
import io.legado.app.ui.widget.font.FontSelectDialog;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FontSelectDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.widget.font.FontSelectDialog$loadFontFiles$4", f = "FontSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class g extends f.z.j.a.g implements p<a0, f.z.d<? super List<? extends e.a.a.h.i>>, Object> {
    public final /* synthetic */ String $path;
    public int label;
    public final /* synthetic */ FontSelectDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, FontSelectDialog fontSelectDialog, f.z.d<? super g> dVar) {
        super(2, dVar);
        this.$path = str;
        this.this$0 = fontSelectDialog;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new g(this.$path, this.this$0, dVar);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull a0 a0Var, @Nullable f.z.d<? super List<e.a.a.h.i>> dVar) {
        return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, f.z.d<? super List<? extends e.a.a.h.i>> dVar) {
        return invoke2(a0Var, (f.z.d<? super List<e.a.a.h.i>>) dVar);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList arrayList = new ArrayList();
        File file = new File(this.$path);
        final FontSelectDialog fontSelectDialog = this.this$0;
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: e.a.a.g.m.l.d
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                FontSelectDialog fontSelectDialog2 = fontSelectDialog;
                String name = file2.getName();
                j.d(name, "pathName.name");
                Locale locale = Locale.getDefault();
                j.d(locale, "getDefault()");
                String lowerCase = name.toLowerCase(locale);
                j.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return fontSelectDialog2.fontRegex.matches(lowerCase);
            }
        });
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                j.d(name, "it.name");
                j.d(file2, "it");
                String strB = f.b0.d.b(file2);
                long length = file2.length();
                Date date = new Date(file2.lastModified());
                Uri uri = Uri.parse(file2.getAbsolutePath());
                j.d(uri, "parse(it.absolutePath)");
                arrayList.add(new e.a.a.h.i(name, strB, length, date, uri));
            }
        }
        FontSelectDialog fontSelectDialog2 = this.this$0;
        return FontSelectDialog.R(fontSelectDialog2, arrayList, FontSelectDialog.Q(fontSelectDialog2));
    }
}
