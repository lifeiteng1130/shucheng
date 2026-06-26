package io.legado.app.ui.main.bookshelf;

import android.app.Application;
import c.b.a.m.f;
import e.a.a.d.v.i;
import e.a.a.g.h.g.m;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookshelfViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lio/legado/app/ui/main/bookshelf/BookshelfViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "str", "", "groupId", "Lf/v;", "e", "(Ljava/lang/String;J)V", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookshelfViewModel extends BaseViewModel {

    /* JADX INFO: compiled from: BookshelfViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$importBookshelf$1", f = "BookshelfViewModel.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ long $groupId;
        public final /* synthetic */ String $str;
        public int label;
        public final /* synthetic */ BookshelfViewModel this$0;

        /* JADX INFO: renamed from: io.legado.app.ui.main.bookshelf.BookshelfViewModel$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BookshelfViewModel.kt */
        public static final class C0210a extends k implements l<Request.Builder, v> {
            public final /* synthetic */ String $text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0210a(String str) {
                super(1);
                this.$text = str;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
                invoke2(builder);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Request.Builder builder) {
                j.e(builder, "$this$newCall");
                builder.url(this.$text);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, BookshelfViewModel bookshelfViewModel, long j2, d<? super a> dVar) {
            super(2, dVar);
            this.$str = str;
            this.this$0 = bookshelfViewModel;
            this.$groupId = j2;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$str, this.this$0, this.$groupId, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Exception {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                String str = this.$str;
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                String string = f.h0.k.R(str).toString();
                if (!f.o3(string)) {
                    if (!f.A3(string)) {
                        throw new Exception("格式不对");
                    }
                    BookshelfViewModel bookshelfViewModel = this.this$0;
                    long j2 = this.$groupId;
                    Objects.requireNonNull(bookshelfViewModel);
                    e.a.a.d.u.b.c(BaseViewModel.a(bookshelfViewModel, null, null, new e.a.a.g.h.g.l(string, j2, null), 3, null), null, new m(bookshelfViewModel, null), 1);
                    return v.a;
                }
                OkHttpClient okHttpClientA = i.a();
                C0210a c0210a = new C0210a(string);
                this.label = 1;
                obj = f.Z3(okHttpClientA, 0, c0210a, this, 1);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            this.this$0.e(f.D5((ResponseBody) obj, null, 1), this.$groupId);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookshelfViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$importBookshelf$2", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements q<a0, Throwable, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public b(d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
            b bVar = BookshelfViewModel.this.new b(dVar);
            bVar.L$0 = th;
            return bVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            BookshelfViewModel bookshelfViewModel = BookshelfViewModel.this;
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "ERROR";
            }
            f.R5(bookshelfViewModel.b(), localizedMessage);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookshelfViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public final void e(@NotNull String str, long groupId) {
        j.e(str, "str");
        e.a.a.d.u.b.b(BaseViewModel.a(this, null, null, new a(str, this, groupId, null), 3, null), null, new b(null), 1);
    }
}
