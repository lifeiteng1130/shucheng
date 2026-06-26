package e.a.a.g.a;

import android.content.Intent;
import f.c0.b.p;
import f.v;
import g.b.a0;
import g.b.k0;
import g.b.y;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.ReadRecordShow;
import io.legado.app.ui.about.ReadRecordActivity;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.search.SearchActivity;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRecordActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.about.ReadRecordActivity$RecordAdapter$registerListener$1$1$1", f = "ReadRecordActivity.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ ReadRecordShow $item;
    public int label;
    public final /* synthetic */ ReadRecordActivity this$0;

    /* JADX INFO: compiled from: ReadRecordActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.about.ReadRecordActivity$RecordAdapter$registerListener$1$1$1$book$1", f = "ReadRecordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements p<a0, f.z.d<? super Book>, Object> {
        public final /* synthetic */ ReadRecordShow $item;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReadRecordShow readRecordShow, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$item = readRecordShow;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$item, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super Book> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            return f.x.e.l(AppDatabaseKt.getAppDb().getBookDao().findByName(this.$item.getBookName()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ReadRecordActivity readRecordActivity, ReadRecordShow readRecordShow, f.z.d<? super g> dVar) {
        super(2, dVar);
        this.this$0 = readRecordActivity;
        this.$item = readRecordShow;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new g(this.this$0, this.$item, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            k0 k0Var = k0.f6264c;
            y yVar = k0.f6263b;
            a aVar2 = new a(this.$item, null);
            this.label = 1;
            obj = c.b.a.m.f.f6(yVar, aVar2, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        Book book = (Book) obj;
        if (book == null) {
            ReadRecordActivity readRecordActivity = this.this$0;
            ReadRecordShow readRecordShow = this.$item;
            Intent intent = new Intent(readRecordActivity, (Class<?>) SearchActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("key", readRecordShow.getBookName());
            readRecordActivity.startActivity(intent);
        } else {
            ReadRecordActivity readRecordActivity2 = this.this$0;
            Intent intent2 = new Intent(readRecordActivity2, (Class<?>) ReadBookActivity.class);
            intent2.addFlags(268435456);
            intent2.putExtra("bookUrl", book.getBookUrl());
            readRecordActivity2.startActivity(intent2);
        }
        return v.a;
    }
}
