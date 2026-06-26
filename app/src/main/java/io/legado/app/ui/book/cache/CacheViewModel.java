package io.legado.app.ui.book.cache;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.documentfile.provider.DocumentFile;
import c.b.a.h;
import c.b.a.i;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.h.x;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.h0.k;
import f.v;
import g.b.a0;
import h.a.a.a.m;
import h.a.a.a.n;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J@\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\f\u0010\rJ@\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\u000e\u0010\rJ:\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012JK\u0010\u0017\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00020\u00140\u0013j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00020\u0014`\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001c¨\u0006#"}, d2 = {"Lio/legado/app/ui/book/cache/CacheViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "path", "Lio/legado/app/data/entities/Book;", "book", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_MESSAGE, "Lf/v;", "finally", "g", "(Ljava/lang/String;Lio/legado/app/data/entities/Book;Lf/c0/b/l;)V", "h", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "append", ai.aA, "(Lio/legado/app/data/entities/Book;Lf/c0/b/l;)V", "Ljava/util/ArrayList;", "Lf/j;", "", "Lkotlin/collections/ArrayList;", "j", "(Lio/legado/app/data/entities/Book;)Ljava/util/ArrayList;", "Lh/a/a/a/d;", "epubBook", "k", "(Lio/legado/app/data/entities/Book;Lh/a/a/a/d;)V", Constants.LANDSCAPE, "m", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class CacheViewModel extends BaseViewModel {

    /* JADX INFO: compiled from: CacheViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.cache.CacheViewModel$export$1", f = "CacheViewModel.kt", i = {}, l = {39, 42}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ String $path;
        public int label;
        public final /* synthetic */ CacheViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, CacheViewModel cacheViewModel, Book book, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$path = str;
            this.this$0 = cacheViewModel;
            this.$book = book;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$path, this.this$0, this.$book, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    c.b.a.m.f.E5(obj);
                    return v.a;
                }
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                return v.a;
            }
            c.b.a.m.f.E5(obj);
            if (c.b.a.m.f.t3(this.$path)) {
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.this$0.b(), Uri.parse(this.$path));
                if (documentFileFromTreeUri == null) {
                    return null;
                }
                CacheViewModel cacheViewModel = this.this$0;
                Book book = this.$book;
                this.label = 1;
                if (CacheViewModel.e(cacheViewModel, documentFileFromTreeUri, book, this) == aVar) {
                    return aVar;
                }
                return v.a;
            }
            CacheViewModel cacheViewModel2 = this.this$0;
            String str = this.$path;
            j.e(str, "filePath");
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            Book book2 = this.$book;
            this.label = 2;
            if (CacheViewModel.f(cacheViewModel2, file, book2, this) == aVar) {
                return aVar;
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: CacheViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.cache.CacheViewModel$export$2", f = "CacheViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public final /* synthetic */ l<String, v> $finally;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(l<? super String, v> lVar, f.z.d<? super b> dVar) {
            super(3, dVar);
            this.$finally = lVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            b bVar = new b(this.$finally, dVar);
            bVar.L$0 = th;
            return bVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            l<String, v> lVar = this.$finally;
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "ERROR";
            }
            lVar.invoke(localizedMessage);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: CacheViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.cache.CacheViewModel$export$3", f = "CacheViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
        public final /* synthetic */ l<String, v> $finally;
        public int label;
        public final /* synthetic */ CacheViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(l<? super String, v> lVar, CacheViewModel cacheViewModel, f.z.d<? super c> dVar) {
            super(3, dVar);
            this.$finally = lVar;
            this.this$0 = cacheViewModel;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable v vVar, @Nullable f.z.d<? super v> dVar) {
            return new c(this.$finally, this.this$0, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            l<String, v> lVar = this.$finally;
            String string = this.this$0.b().getString(R.string.success);
            j.d(string, "context.getString(R.string.success)");
            lVar.invoke(string);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: CacheViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.cache.CacheViewModel$exportEPUB$1", f = "CacheViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ String $path;
        public int label;
        public final /* synthetic */ CacheViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, CacheViewModel cacheViewModel, Book book, f.z.d<? super d> dVar) {
            super(2, dVar);
            this.$path = str;
            this.this$0 = cacheViewModel;
            this.$book = book;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new d(this.$path, this.this$0, this.$book, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            OutputStream outputStreamOpenOutputStream;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            if (!c.b.a.m.f.t3(this.$path)) {
                CacheViewModel cacheViewModel = this.this$0;
                FileUtils fileUtils = FileUtils.a;
                File fileE = fileUtils.e(this.$path);
                Book book = this.$book;
                Objects.requireNonNull(cacheViewModel);
                String str = book.getName() + " by " + book.getAuthor() + ".epub";
                h.a.a.a.d dVar = new h.a.a.a.d();
                dVar.setVersion("2.0");
                cacheViewModel.m(book, dVar);
                cacheViewModel.k(book, dVar);
                dVar.getResources().add(new h.a.a.a.p(k.e("body,div{background:white;outline:none;width:100%;}h2{color:#005a9c;text-align:left;}p{text-indent:2em;text-align:justify;}img{display:inline-block;width:100%;height:auto;max-width: 100%;max-height:100%;}"), "css/style.css"));
                File fileC = fileUtils.c(fileUtils.o(fileE, str));
                cacheViewModel.l(book, dVar);
                new h.a.a.b.f().a(dVar, new FileOutputStream(fileC));
                return v.a;
            }
            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.this$0.b(), Uri.parse(this.$path));
            if (documentFileFromTreeUri == null) {
                return null;
            }
            CacheViewModel cacheViewModel2 = this.this$0;
            Book book2 = this.$book;
            Objects.requireNonNull(cacheViewModel2);
            String str2 = book2.getName() + " by " + book2.getAuthor() + ".epub";
            e.a.a.h.j jVar = e.a.a.h.j.a;
            jVar.c(documentFileFromTreeUri, str2, new String[0]);
            h.a.a.a.d dVar2 = new h.a.a.a.d();
            dVar2.setVersion("2.0");
            cacheViewModel2.m(book2, dVar2);
            cacheViewModel2.k(book2, dVar2);
            dVar2.getResources().add(new h.a.a.a.p(k.e("body,div{background:white;outline:none;width:100%;}h2{color:#005a9c;text-align:left;}p{text-indent:2em;text-align:justify;}img{display:inline-block;width:100%;height:auto;max-width: 100%;max-height:100%;}"), "css/style.css"));
            cacheViewModel2.l(book2, dVar2);
            DocumentFile documentFileA = e.a.a.h.j.a(jVar, documentFileFromTreeUri, str2, null, new String[0], 4);
            if (documentFileA != null && (outputStreamOpenOutputStream = cacheViewModel2.b().getContentResolver().openOutputStream(documentFileA.getUri(), "wa")) != null) {
                try {
                    new h.a.a.b.f().a(dVar2, outputStreamOpenOutputStream);
                    c.b.a.m.f.P0(outputStreamOpenOutputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        c.b.a.m.f.P0(outputStreamOpenOutputStream, th);
                        throw th2;
                    }
                }
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: CacheViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.cache.CacheViewModel$exportEPUB$2", f = "CacheViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public final /* synthetic */ l<String, v> $finally;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(l<? super String, v> lVar, f.z.d<? super e> dVar) {
            super(3, dVar);
            this.$finally = lVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            e eVar = new e(this.$finally, dVar);
            eVar.L$0 = th;
            return eVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            l<String, v> lVar = this.$finally;
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "ERROR";
            }
            lVar.invoke(localizedMessage);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: CacheViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.cache.CacheViewModel$exportEPUB$3", f = "CacheViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
        public final /* synthetic */ l<String, v> $finally;
        public int label;
        public final /* synthetic */ CacheViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(l<? super String, v> lVar, CacheViewModel cacheViewModel, f.z.d<? super f> dVar) {
            super(3, dVar);
            this.$finally = lVar;
            this.this$0 = cacheViewModel;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable v vVar, @Nullable f.z.d<? super v> dVar) {
            return new f(this.$finally, this.this$0, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            l<String, v> lVar = this.$finally;
            String string = this.this$0.b().getString(R.string.success);
            j.d(string, "context.getString(R.string.success)");
            lVar.invoke(string);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: CacheViewModel.kt */
    public static final class g extends c.b.a.q.j.c<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h.a.a.a.d f7042d;

        public g(h.a.a.a.d dVar) {
            this.f7042d = dVar;
        }

        @Override // c.b.a.q.j.h
        public void b(Object obj, c.b.a.q.k.d dVar) throws IOException {
            Bitmap bitmap = (Bitmap) obj;
            j.e(bitmap, "resource");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            j.d(byteArray, "stream.toByteArray()");
            bitmap.recycle();
            byteArrayOutputStream.close();
            this.f7042d.setCoverImage(new h.a.a.a.p(byteArray, "cover.jpg"));
        }

        @Override // c.b.a.q.j.h
        public void g(@Nullable Drawable drawable) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(io.legado.app.ui.book.cache.CacheViewModel r11, androidx.documentfile.provider.DocumentFile r12, io.legado.app.data.entities.Book r13, f.z.d r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.cache.CacheViewModel.e(io.legado.app.ui.book.cache.CacheViewModel, androidx.documentfile.provider.DocumentFile, io.legado.app.data.entities.Book, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(io.legado.app.ui.book.cache.CacheViewModel r8, java.io.File r9, io.legado.app.data.entities.Book r10, f.z.d r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.cache.CacheViewModel.f(io.legado.app.ui.book.cache.CacheViewModel, java.io.File, io.legado.app.data.entities.Book, f.z.d):java.lang.Object");
    }

    public final void g(@NotNull String path, @NotNull Book book, @NotNull l<? super String, v> lVar) {
        j.e(path, "path");
        j.e(book, "book");
        j.e(lVar, "finally");
        e.a.a.d.u.b bVarA = BaseViewModel.a(this, null, null, new a(path, this, book, null), 3, null);
        e.a.a.d.u.b.b(bVarA, null, new b(lVar, null), 1);
        bVarA.d(null, new c(lVar, this, null));
    }

    public final void h(@NotNull String path, @NotNull Book book, @NotNull l<? super String, v> lVar) {
        j.e(path, "path");
        j.e(book, "book");
        j.e(lVar, "finally");
        e.a.a.d.u.b bVarA = BaseViewModel.a(this, null, null, new d(path, this, book, null), 3, null);
        e.a.a.d.u.b.b(bVarA, null, new e(lVar, null), 1);
        bVarA.d(null, new f(lVar, this, null));
    }

    public final void i(Book book, l<? super String, v> append) {
        boolean zF = e.a.a.d.e.a.f();
        e.a.a.d.k kVar = new e.a.a.d.k(book.getName(), book.getOrigin());
        append.invoke(book.getName() + '\n' + b().getString(R.string.author_show, book.getAuthor()));
        for (BookChapter bookChapter : AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(book.getBookUrl())) {
            String strE = e.a.a.d.g.a.e(book, bookChapter);
            append.invoke(j.k("\n\n", f.x.e.q(kVar.a(book, bookChapter.getTitle(), strE == null ? "null" : strE, false, zF), "\n", null, null, 0, null, null, 62)));
        }
    }

    public final ArrayList<f.j<String, Integer, String>> j(Book book) {
        ArrayList<f.j<String, Integer, String>> arrayList = new ArrayList<>();
        for (BookChapter bookChapter : AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(book.getBookUrl())) {
            String strE = e.a.a.d.g.a.e(book, bookChapter);
            if (strE != null) {
                int i2 = 0;
                for (Object obj : k.F(strE, new String[]{"\n"}, false, 0, 6)) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        f.x.e.D();
                        throw null;
                    }
                    e.a.a.c.d dVar = e.a.a.c.d.a;
                    Iterator it = f.h0.g.findAll$default(new f.h0.g(e.a.a.c.d.f5510d), (String) obj, 0, 2, null).iterator();
                    while (it.hasNext()) {
                        String str = ((f.h0.e) it.next()).a().get(1);
                        x xVar = x.a;
                        arrayList.add(new f.j<>(bookChapter.getTitle(), Integer.valueOf(i2), x.a(bookChapter.getUrl(), str)));
                    }
                    i2 = i3;
                }
            }
        }
        return arrayList;
    }

    public final void k(Book book, h.a.a.a.d epubBook) {
        i iVarD = c.b.a.b.d(b());
        Objects.requireNonNull(iVarD);
        h hVarG = new h(iVarD.f235b, iVarD, Bitmap.class, iVarD.f236c).a(i.a).G(book.getDisplayCover());
        hVarG.D(new g(epubBook), null, hVarG, c.b.a.s.d.a);
    }

    public final void l(Book book, h.a.a.a.d epubBook) throws IOException {
        String[] strArr;
        boolean zF = e.a.a.d.e.a.f();
        e.a.a.d.k kVar = new e.a.a.d.k(book.getName(), book.getOrigin());
        for (BookChapter bookChapter : AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(book.getBookUrl())) {
            String strE = e.a.a.d.g.a.e(book, bookChapter);
            if (strE == null) {
                strE = "null";
            }
            StringBuilder sb = new StringBuilder("");
            int i2 = 0;
            Iterator it = k.F(strE, new String[]{"\n"}, false, 0, 6).iterator();
            while (it.hasNext()) {
                String strC = (String) it.next();
                e.a.a.c.d dVar = e.a.a.c.d.a;
                Iterator it2 = f.h0.g.findAll$default(new f.h0.g(e.a.a.c.d.f5510d), strC, i2, 2, null).iterator();
                while (it2.hasNext()) {
                    String str = ((f.h0.e) it2.next()).a().get(1);
                    x xVar = x.a;
                    String strA = x.a(bookChapter.getUrl(), str);
                    String strB = e.a.a.h.v.b(strA);
                    e.a.a.d.g gVar = e.a.a.d.g.a;
                    String strK = j.k(strB, gVar.i(strA));
                    File fileH = gVar.h(book, strA);
                    Iterator it3 = it;
                    h.a.a.a.f fVar = new h.a.a.a.f(fileH.getParent());
                    if (fileH.exists()) {
                        epubBook.getResources().add(new h.a.a.a.j(fVar, strK));
                    }
                    strC = k.C(strC, strA, j.k(e.a.a.h.v.b(strA), gVar.i(strA)), false, 4);
                    it = it3;
                    i2 = 0;
                }
                sb.append(strC);
                sb.append("\n");
            }
            String string = sb.toString();
            j.d(string, "data.toString()");
            String strQ = f.x.e.q(kVar.a(book, "", string, false, zF), "\n", null, null, 0, null, null, 62);
            String title = bookChapter.getTitle();
            String title2 = bookChapter.getTitle();
            StringBuilder sb2 = new StringBuilder();
            String[] strArrSplit = strQ.split("\\r?\\n");
            int length = strArrSplit.length;
            int i3 = 0;
            while (i3 < length) {
                String strSubstring = strArrSplit[i3];
                if (strSubstring == null || strSubstring.isEmpty()) {
                    strArr = strArrSplit;
                    strSubstring = "";
                } else {
                    int length2 = strSubstring.length();
                    int i4 = length2 - 1;
                    int i5 = 0;
                    while (true) {
                        strArr = strArrSplit;
                        if (i5 >= i4 || (strSubstring.charAt(i5) > ' ' && strSubstring.charAt(i5) != 12288)) {
                            break;
                        }
                        i5++;
                        strArrSplit = strArr;
                    }
                    while (i5 < i4 && (strSubstring.charAt(i4) <= ' ' || strSubstring.charAt(i4) == 12288)) {
                        i4--;
                    }
                    if (i4 < length2) {
                        i4++;
                    }
                    if (i5 > 0 || i4 < length2) {
                        strSubstring = strSubstring.substring(i5, i4);
                    }
                }
                if (strSubstring.length() != 0) {
                    if (strSubstring.contains("<img")) {
                        sb2.append("<div class=\"duokan-image-single img-note\">");
                        sb2.append(strSubstring);
                        sb2.append("</div>");
                    } else {
                        sb2.append("<p>");
                        sb2.append(strSubstring);
                        sb2.append("</p>");
                    }
                }
                i3++;
                strArrSplit = strArr;
            }
            epubBook.addSection(title, new h.a.a.a.p(("<?xml version=\"1.0\" encoding=\"utf-8\"?><html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:epub=\"http://www.idpf.org/2007/ops\"><head><title>" + title2 + "</title><link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\"/><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/></head><body><h2>" + title2 + "</h2>" + ((Object) sb2) + "</body></html>").getBytes(), m.a));
        }
    }

    public final void m(Book book, h.a.a.a.d epubBook) {
        n nVar = new n();
        nVar.getTitles().add(book.getName());
        nVar.getAuthors().add(new h.a.a.a.b(book.getRealAuthor()));
        nVar.setLanguage("zh");
        nVar.getDates().add(new h.a.a.a.c());
        nVar.getPublishers().add("Legado APP");
        nVar.getDescriptions().add(book.getDisplayIntro());
        epubBook.setMetadata(nVar);
    }
}
