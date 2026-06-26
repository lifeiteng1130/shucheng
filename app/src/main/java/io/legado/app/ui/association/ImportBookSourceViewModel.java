package io.legado.app.ui.association;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.g.b.u;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.BookSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR)\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R$\u0010!\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\fR)\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0\rj\b\u0012\u0004\u0012\u00020\"`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b#\u0010\u0011R-\u0010&\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\"0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\"`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b%\u0010\u0011¨\u0006+"}, d2 = {"Lio/legado/app/ui/association/ImportBookSourceViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "g", "()Z", "", "h", "()I", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Lf/v;", "f", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getSelectStatus", "()Ljava/util/ArrayList;", "selectStatus", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "getSuccessLiveData", "()Landroidx/lifecycle/MutableLiveData;", "successLiveData", "d", "getErrorLiveData", "errorLiveData", ai.aD, "Ljava/lang/String;", "getGroupName", "()Ljava/lang/String;", "setGroupName", "groupName", "Lio/legado/app/data/entities/BookSource;", "getAllSources", "allSources", "getCheckSources", "checkSources", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ImportBookSourceViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String groupName;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> errorLiveData;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> successLiveData;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<BookSource> allSources;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<BookSource> checkSources;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<Boolean> selectStatus;

    /* JADX INFO: compiled from: ImportBookSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportBookSourceViewModel$importSource$1", f = "ImportBookSourceViewModel.kt", i = {}, l = {185, 203}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super Object>, Object> {
        public final /* synthetic */ String $text;
        public Object L$0;
        public Object L$1;
        public int label;
        public final /* synthetic */ ImportBookSourceViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ImportBookSourceViewModel importBookSourceViewModel, d<? super a> dVar) {
            super(2, dVar);
            this.$text = str;
            this.this$0 = importBookSourceViewModel;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$text, this.this$0, dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable d<Object> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, d<? super Object> dVar) {
            return invoke2(a0Var, (d<Object>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) throws java.lang.Exception {
            /*
                Method dump skipped, instruction units count: 270
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.association.ImportBookSourceViewModel.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: ImportBookSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportBookSourceViewModel$importSource$2", f = "ImportBookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements q<a0, Throwable, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public b(d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
            b bVar = ImportBookSourceViewModel.this.new b(dVar);
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
            th.printStackTrace();
            MutableLiveData<String> mutableLiveData = ImportBookSourceViewModel.this.errorLiveData;
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "";
            }
            mutableLiveData.postValue(localizedMessage);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ImportBookSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportBookSourceViewModel$importSource$3", f = "ImportBookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements q<a0, Object, d<? super v>, Object> {
        public int label;

        public c(d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable Object obj, @Nullable d<? super v> dVar) {
            return ImportBookSourceViewModel.this.new c(dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            ImportBookSourceViewModel importBookSourceViewModel = ImportBookSourceViewModel.this;
            Objects.requireNonNull(importBookSourceViewModel);
            BaseViewModel.a(importBookSourceViewModel, null, null, new u(importBookSourceViewModel, null), 3, null);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportBookSourceViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "app");
        this.errorLiveData = new MutableLiveData<>();
        this.successLiveData = new MutableLiveData<>();
        this.allSources = new ArrayList<>();
        this.checkSources = new ArrayList<>();
        this.selectStatus = new ArrayList<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(io.legado.app.ui.association.ImportBookSourceViewModel r5, java.lang.String r6, f.z.d r7) throws java.lang.Throwable {
        /*
            java.util.Objects.requireNonNull(r5)
            boolean r0 = r7 instanceof e.a.a.g.b.x
            if (r0 == 0) goto L16
            r0 = r7
            e.a.a.g.b.x r0 = (e.a.a.g.b.x) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            e.a.a.g.b.x r0 = new e.a.a.g.b.x
            r0.<init>(r5, r7)
        L1b:
            java.lang.Object r7 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r5 = r0.L$0
            io.legado.app.ui.association.ImportBookSourceViewModel r5 = (io.legado.app.ui.association.ImportBookSourceViewModel) r5
            c.b.a.m.f.E5(r7)
            goto L4e
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            c.b.a.m.f.E5(r7)
            okhttp3.OkHttpClient r7 = e.a.a.d.v.i.a()
            e.a.a.g.b.y r2 = new e.a.a.g.b.y
            r2.<init>(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = c.b.a.m.f.Z3(r7, r3, r2, r0, r4)
            if (r7 != r1) goto L4e
            goto La0
        L4e:
            okhttp3.ResponseBody r7 = (okhttp3.ResponseBody) r7
            java.lang.String r6 = "utf-8"
            java.lang.String r6 = c.b.a.m.f.C5(r7, r6)
            e.a.a.d.w.q r7 = e.a.a.d.w.q.a
            com.jayway.jsonpath.ParseContext r7 = r7.b()
            com.jayway.jsonpath.DocumentContext r6 = r7.parse(r6)
            com.jayway.jsonpath.Predicate[] r7 = new com.jayway.jsonpath.Predicate[r3]
            java.lang.String r0 = "$"
            java.lang.Object r6 = r6.read(r0, r7)
            java.lang.String r7 = "Restore.jsonPath.parse(body).read(\"$\")"
            f.c0.c.j.d(r6, r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
        L73:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L9e
            java.lang.Object r7 = r6.next()
            java.util.Map r7 = (java.util.Map) r7
            e.a.a.d.w.q r0 = e.a.a.d.w.q.a
            com.jayway.jsonpath.ParseContext r0 = r0.b()
            com.jayway.jsonpath.DocumentContext r7 = r0.parse(r7)
            io.legado.app.help.storage.OldRule r0 = io.legado.app.help.storage.OldRule.a
            java.lang.String r7 = r7.jsonString()
            java.lang.String r1 = "jsonItem.jsonString()"
            f.c0.c.j.d(r7, r1)
            io.legado.app.data.entities.BookSource r7 = r0.a(r7)
            java.util.ArrayList<io.legado.app.data.entities.BookSource> r0 = r5.allSources
            r0.add(r7)
            goto L73
        L9e:
            f.v r1 = f.v.a
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.association.ImportBookSourceViewModel.e(io.legado.app.ui.association.ImportBookSourceViewModel, java.lang.String, f.z.d):java.lang.Object");
    }

    public final void f(@NotNull String text) {
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        e.a.a.d.u.b bVarA = BaseViewModel.a(this, null, null, new a(text, this, null), 3, null);
        e.a.a.d.u.b.b(bVarA, null, new b(null), 1);
        bVarA.d(null, new c(null));
    }

    public final boolean g() {
        Iterator<T> it = this.selectStatus.iterator();
        while (it.hasNext()) {
            if (!((Boolean) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final int h() {
        Iterator<T> it = this.selectStatus.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((Boolean) it.next()).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }
}
