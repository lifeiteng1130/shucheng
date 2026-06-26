package io.legado.app.ui.association;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.d.v.i;
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
import io.legado.app.data.entities.ReplaceRule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportReplaceRuleViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R&\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R/\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0019"}, d2 = {"Lio/legado/app/ui/association/ImportReplaceRuleViewModel;", "Lio/legado/app/base/BaseViewModel;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Lf/v;", "e", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/ReplaceRule;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "allRules", "Landroidx/lifecycle/MutableLiveData;", ai.aD, "Landroidx/lifecycle/MutableLiveData;", "getErrorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "errorLiveData", "d", "getSuccessLiveData", "successLiveData", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ImportReplaceRuleViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> errorLiveData;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ArrayList<ReplaceRule>> successLiveData;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<ReplaceRule> allRules;

    /* JADX INFO: compiled from: ImportReplaceRuleViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportReplaceRuleViewModel$import$1", f = "ImportReplaceRuleViewModel.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super Boolean>, Object> {
        public final /* synthetic */ String $text;
        public int label;
        public final /* synthetic */ ImportReplaceRuleViewModel this$0;

        /* JADX INFO: renamed from: io.legado.app.ui.association.ImportReplaceRuleViewModel$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImportReplaceRuleViewModel.kt */
        public static final class C0191a extends k implements l<Request.Builder, v> {
            public final /* synthetic */ String $text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0191a(String str) {
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
        public a(String str, ImportReplaceRuleViewModel importReplaceRuleViewModel, d<? super a> dVar) {
            super(2, dVar);
            this.$text = str;
            this.this$0 = importReplaceRuleViewModel;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$text, this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super Boolean> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            boolean zAddAll;
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                if (!f.o3(this.$text)) {
                    zAddAll = this.this$0.allRules.addAll(e.a.a.d.w.p.a(this.$text));
                    return Boolean.valueOf(zAddAll);
                }
                OkHttpClient okHttpClientA = i.a();
                C0191a c0191a = new C0191a(this.$text);
                this.label = 1;
                obj = f.Z3(okHttpClientA, 0, c0191a, this, 1);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            String strC5 = f.C5((ResponseBody) obj, "utf-8");
            ImportReplaceRuleViewModel importReplaceRuleViewModel = this.this$0;
            zAddAll = Boolean.valueOf(importReplaceRuleViewModel.allRules.addAll(e.a.a.d.w.p.a(strC5))).booleanValue();
            return Boolean.valueOf(zAddAll);
        }
    }

    /* JADX INFO: compiled from: ImportReplaceRuleViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportReplaceRuleViewModel$import$2", f = "ImportReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements q<a0, Throwable, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public b(d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
            b bVar = ImportReplaceRuleViewModel.this.new b(dVar);
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
            MutableLiveData<String> mutableLiveData = ImportReplaceRuleViewModel.this.errorLiveData;
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "ERROR";
            }
            mutableLiveData.postValue(localizedMessage);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ImportReplaceRuleViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.association.ImportReplaceRuleViewModel$import$3", f = "ImportReplaceRuleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements q<a0, Boolean, d<? super v>, Object> {
        public int label;

        public c(d<? super c> dVar) {
            super(3, dVar);
        }

        @Nullable
        public final Object invoke(@NotNull a0 a0Var, boolean z, @Nullable d<? super v> dVar) {
            return ImportReplaceRuleViewModel.this.new c(dVar).invokeSuspend(v.a);
        }

        @Override // f.c0.b.q
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, Boolean bool, d<? super v> dVar) {
            return invoke(a0Var, bool.booleanValue(), dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            ImportReplaceRuleViewModel importReplaceRuleViewModel = ImportReplaceRuleViewModel.this;
            importReplaceRuleViewModel.successLiveData.postValue(importReplaceRuleViewModel.allRules);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportReplaceRuleViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "app");
        this.errorLiveData = new MutableLiveData<>();
        this.successLiveData = new MutableLiveData<>();
        this.allRules = new ArrayList<>();
    }

    public final void e(@NotNull String text) {
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        e.a.a.d.u.b bVarA = BaseViewModel.a(this, null, null, new a(text, this, null), 3, null);
        e.a.a.d.u.b.b(bVarA, null, new b(null), 1);
        bVarA.d(null, new c(null));
    }
}
