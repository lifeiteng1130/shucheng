package e.a.a.d;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookHelp.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.help.BookHelp$clearRemovedCache$1", f = "BookHelp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class h extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public int label;

    public h(f.z.d<? super h> dVar) {
        super(2, dVar);
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new h(dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((h) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = AppDatabaseKt.getAppDb().getBookDao().getAll().iterator();
        while (it.hasNext()) {
            arrayList.add(((Book) it.next()).getFolderName());
        }
        File file = g.f5530b;
        String[] strArr = {"book_cache"};
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr, "subDirFiles");
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        f.c0.c.j.e(file, "root");
        f.c0.c.j.e(strArr2, "subDirFiles");
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (String str : strArr2) {
            if (str.length() > 0) {
                sb.append(File.separator);
                sb.append(str);
            }
        }
        String string = sb.toString();
        f.c0.c.j.d(string, "path.toString()");
        File[] fileArrListFiles = new File(string).listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (!arrayList.contains(file2.getName())) {
                FileUtils fileUtils = FileUtils.a;
                String absolutePath = file2.getAbsolutePath();
                f.c0.c.j.d(absolutePath, "bookFile.absolutePath");
                fileUtils.h(absolutePath);
            }
        }
        return v.a;
    }
}
