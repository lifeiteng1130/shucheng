package io.legado.app.ui.association;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.google.gson.reflect.TypeToken;
import com.umeng.analytics.pro.ai;
import e.a.a.g.b.d0;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.RssSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\fR)\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR)\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R-\u0010&\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019j\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a`\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b%\u0010\u001e¨\u0006+"}, d2 = {"Lio/legado/app/ui/association/ImportRssSourceViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "g", "()Z", "", "h", "()I", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Lf/v;", "f", "(Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getErrorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "errorLiveData", ai.aD, "Ljava/lang/String;", "getGroupName", "()Ljava/lang/String;", "setGroupName", "groupName", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/RssSource;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getAllSources", "()Ljava/util/ArrayList;", "allSources", "getSelectStatus", "selectStatus", "e", "getSuccessLiveData", "successLiveData", "getCheckSources", "checkSources", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ImportRssSourceViewModel extends BaseViewModel {

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
    public final ArrayList<RssSource> allSources;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<RssSource> checkSources;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<Boolean> selectStatus;

    /* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportRssSourceViewModel$importSource$1", f = "ImportRssSourceViewModel.kt", i = {}, l = {80, 98}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super Object>, Object> {
        public final /* synthetic */ String $text;
        public Object L$0;
        public Object L$1;
        public int label;
        public final /* synthetic */ ImportRssSourceViewModel this$0;

        /* JADX INFO: renamed from: io.legado.app.ui.association.ImportRssSourceViewModel$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GsonExtensions.kt */
        public static final class C0193a extends TypeToken<RssSource> {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ImportRssSourceViewModel importRssSourceViewModel, d<? super a> dVar) {
            super(2, dVar);
            this.$text = str;
            this.this$0 = importRssSourceViewModel;
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

        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws java.lang.Exception {
            /*
                Method dump skipped, instruction units count: 360
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.association.ImportRssSourceViewModel.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportRssSourceViewModel$importSource$2", f = "ImportRssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements q<a0, Throwable, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public b(d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
            b bVar = ImportRssSourceViewModel.this.new b(dVar);
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
            ImportRssSourceViewModel.this.errorLiveData.postValue(j.k("ImportError:", ((Throwable) this.L$0).getLocalizedMessage()));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportRssSourceViewModel$importSource$3", f = "ImportRssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements q<a0, Object, d<? super v>, Object> {
        public int label;

        public c(d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable Object obj, @Nullable d<? super v> dVar) {
            return ImportRssSourceViewModel.this.new c(dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            ImportRssSourceViewModel importRssSourceViewModel = ImportRssSourceViewModel.this;
            Objects.requireNonNull(importRssSourceViewModel);
            BaseViewModel.a(importRssSourceViewModel, null, null, new d0(importRssSourceViewModel, null), 3, null);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportRssSourceViewModel(@NotNull Application application) {
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
    public static final java.lang.Object e(io.legado.app.ui.association.ImportRssSourceViewModel r5, java.lang.String r6, f.z.d r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.association.ImportRssSourceViewModel.e(io.legado.app.ui.association.ImportRssSourceViewModel, java.lang.String, f.z.d):java.lang.Object");
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
