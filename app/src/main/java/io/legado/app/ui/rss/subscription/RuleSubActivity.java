package io.legado.app.ui.rss.subscription;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.h;
import e.a.a.e.a.i;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import g.b.y;
import io.legado.app.base.BaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RuleSubDao;
import io.legado.app.data.entities.RuleSub;
import io.legado.app.databinding.ActivityRuleSubBinding;
import io.legado.app.databinding.DialogRuleSubEditBinding;
import io.legado.app.ui.association.ImportBookSourceActivity;
import io.legado.app.ui.association.ImportReplaceRuleActivity;
import io.legado.app.ui.association.ImportRssSourceActivity;
import io.legado.app.ui.rss.subscription.RuleSubActivity;
import io.legado.app.ui.rss.subscription.RuleSubAdapter;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.text.EditText;
import io.legado.app.ui.widget.text.TextInputLayout;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RuleSubActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b&\u0010\u001cJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J#\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0018\"\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010%\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lio/legado/app/ui/rss/subscription/RuleSubActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityRuleSubBinding;", "Lio/legado/app/ui/rss/subscription/RuleSubAdapter$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/data/entities/RuleSub;", "ruleSub", "p0", "(Lio/legado/app/data/entities/RuleSub;)V", "Q", "G0", "", "r", "([Lio/legado/app/data/entities/RuleSub;)V", ai.at, "()V", "Lio/legado/app/ui/rss/subscription/RuleSubAdapter;", "h", "Lio/legado/app/ui/rss/subscription/RuleSubAdapter;", "adapter", "Landroidx/lifecycle/LiveData;", "", ai.aA, "Landroidx/lifecycle/LiveData;", "liveData", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RuleSubActivity extends BaseActivity<ActivityRuleSubBinding> implements RuleSubAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7564g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public RuleSubAdapter adapter;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<RuleSub>> liveData;

    /* JADX INFO: compiled from: RuleSubActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.subscription.RuleSubActivity$delSubscription$1", f = "RuleSubActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ RuleSub $ruleSub;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RuleSub ruleSub, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$ruleSub = ruleSub;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$ruleSub, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            AppDatabaseKt.getAppDb().getRuleSubDao().delete(this.$ruleSub);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: RuleSubActivity.kt */
    public static final class b extends k implements l<h<? extends DialogInterface>, v> {
        public final /* synthetic */ RuleSub $ruleSub;

        /* JADX INFO: compiled from: RuleSubActivity.kt */
        public static final class a extends k implements f.c0.b.a<View> {
            public final /* synthetic */ DialogRuleSubEditBinding $alertBinding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(DialogRuleSubEditBinding dialogRuleSubEditBinding) {
                super(0);
                this.$alertBinding = dialogRuleSubEditBinding;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // f.c0.b.a
            @NotNull
            public final View invoke() {
                LinearLayout linearLayout = this.$alertBinding.a;
                j.d(linearLayout, "alertBinding.root");
                return linearLayout;
            }
        }

        /* JADX INFO: renamed from: io.legado.app.ui.rss.subscription.RuleSubActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RuleSubActivity.kt */
        public static final class C0213b extends k implements l<DialogInterface, v> {
            public final /* synthetic */ DialogRuleSubEditBinding $alertBinding;
            public final /* synthetic */ RuleSub $ruleSub;
            public final /* synthetic */ RuleSubActivity this$0;

            /* JADX INFO: renamed from: io.legado.app.ui.rss.subscription.RuleSubActivity$b$b$a */
            /* JADX INFO: compiled from: RuleSubActivity.kt */
            @DebugMetadata(c = "io.legado.app.ui.rss.subscription.RuleSubActivity$editSubscription$1$2$1", f = "RuleSubActivity.kt", i = {}, l = {109, 116}, m = "invokeSuspend", n = {}, s = {})
            public static final class a extends g implements p<a0, f.z.d<? super v>, Object> {
                public final /* synthetic */ DialogRuleSubEditBinding $alertBinding;
                public final /* synthetic */ RuleSub $ruleSub;
                public int label;
                public final /* synthetic */ RuleSubActivity this$0;

                /* JADX INFO: renamed from: io.legado.app.ui.rss.subscription.RuleSubActivity$b$b$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: RuleSubActivity.kt */
                @DebugMetadata(c = "io.legado.app.ui.rss.subscription.RuleSubActivity$editSubscription$1$2$1$1", f = "RuleSubActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                public static final class C0214a extends g implements p<a0, f.z.d<? super v>, Object> {
                    public final /* synthetic */ RuleSub $ruleSub;
                    public int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0214a(RuleSub ruleSub, f.z.d<? super C0214a> dVar) {
                        super(2, dVar);
                        this.$ruleSub = ruleSub;
                    }

                    @Override // f.z.j.a.a
                    @NotNull
                    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                        return new C0214a(this.$ruleSub, dVar);
                    }

                    @Override // f.c0.b.p
                    @Nullable
                    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                        return ((C0214a) create(a0Var, dVar)).invokeSuspend(v.a);
                    }

                    @Override // f.z.j.a.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        f.E5(obj);
                        AppDatabaseKt.getAppDb().getRuleSubDao().insert(this.$ruleSub);
                        return v.a;
                    }
                }

                /* JADX INFO: renamed from: io.legado.app.ui.rss.subscription.RuleSubActivity$b$b$a$b, reason: collision with other inner class name */
                /* JADX INFO: compiled from: RuleSubActivity.kt */
                @DebugMetadata(c = "io.legado.app.ui.rss.subscription.RuleSubActivity$editSubscription$1$2$1$rs$1", f = "RuleSubActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                public static final class C0215b extends g implements p<a0, f.z.d<? super RuleSub>, Object> {
                    public final /* synthetic */ RuleSub $ruleSub;
                    public int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0215b(RuleSub ruleSub, f.z.d<? super C0215b> dVar) {
                        super(2, dVar);
                        this.$ruleSub = ruleSub;
                    }

                    @Override // f.z.j.a.a
                    @NotNull
                    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                        return new C0215b(this.$ruleSub, dVar);
                    }

                    @Override // f.c0.b.p
                    @Nullable
                    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super RuleSub> dVar) {
                        return ((C0215b) create(a0Var, dVar)).invokeSuspend(v.a);
                    }

                    @Override // f.z.j.a.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        f.E5(obj);
                        return AppDatabaseKt.getAppDb().getRuleSubDao().findByUrl(this.$ruleSub.getUrl());
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(RuleSub ruleSub, DialogRuleSubEditBinding dialogRuleSubEditBinding, RuleSubActivity ruleSubActivity, f.z.d<? super a> dVar) {
                    super(2, dVar);
                    this.$ruleSub = ruleSub;
                    this.$alertBinding = dialogRuleSubEditBinding;
                    this.this$0 = ruleSubActivity;
                }

                @Override // f.z.j.a.a
                @NotNull
                public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                    return new a(this.$ruleSub, this.$alertBinding, this.this$0, dVar);
                }

                @Override // f.c0.b.p
                @Nullable
                public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                    return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
                }

                @Override // f.z.j.a.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                    String string;
                    String string2;
                    f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
                    int i2 = this.label;
                    if (i2 == 0) {
                        f.E5(obj);
                        this.$ruleSub.setType(this.$alertBinding.f6678d.getSelectedItemPosition());
                        RuleSub ruleSub = this.$ruleSub;
                        Editable text = this.$alertBinding.f6676b.getText();
                        String str = "";
                        if (text == null || (string = text.toString()) == null) {
                            string = "";
                        }
                        ruleSub.setName(string);
                        RuleSub ruleSub2 = this.$ruleSub;
                        Editable text2 = this.$alertBinding.f6677c.getText();
                        if (text2 != null && (string2 = text2.toString()) != null) {
                            str = string2;
                        }
                        ruleSub2.setUrl(str);
                        k0 k0Var = k0.f6264c;
                        y yVar = k0.f6263b;
                        C0215b c0215b = new C0215b(this.$ruleSub, null);
                        this.label = 1;
                        obj = f.f6(yVar, c0215b, this);
                        if (obj == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            f.E5(obj);
                            return v.a;
                        }
                        f.E5(obj);
                    }
                    RuleSub ruleSub3 = (RuleSub) obj;
                    if (ruleSub3 == null || ruleSub3.getId() == this.$ruleSub.getId()) {
                        k0 k0Var2 = k0.f6264c;
                        y yVar2 = k0.f6263b;
                        C0214a c0214a = new C0214a(this.$ruleSub, null);
                        this.label = 2;
                        if (f.f6(yVar2, c0214a, this) == aVar) {
                            return aVar;
                        }
                        return v.a;
                    }
                    f.R5(this.this$0, this.this$0.getString(R.string.url_already) + '(' + ruleSub3.getName() + ')');
                    return v.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0213b(RuleSubActivity ruleSubActivity, RuleSub ruleSub, DialogRuleSubEditBinding dialogRuleSubEditBinding) {
                super(1);
                this.this$0 = ruleSubActivity;
                this.$ruleSub = ruleSub;
                this.$alertBinding = dialogRuleSubEditBinding;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                RuleSubActivity ruleSubActivity = this.this$0;
                f.L3(ruleSubActivity, null, null, new a(this.$ruleSub, this.$alertBinding, ruleSubActivity, null), 3, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RuleSub ruleSub) {
            super(1);
            this.$ruleSub = ruleSub;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            View viewInflate = RuleSubActivity.this.getLayoutInflater().inflate(R.layout.dialog_rule_sub_edit, (ViewGroup) null, false);
            int i2 = R.id.et_name;
            EditText editText = (EditText) viewInflate.findViewById(R.id.et_name);
            if (editText != null) {
                i2 = R.id.et_url;
                EditText editText2 = (EditText) viewInflate.findViewById(R.id.et_url);
                if (editText2 != null) {
                    i2 = R.id.sp_type;
                    AppCompatSpinner appCompatSpinner = (AppCompatSpinner) viewInflate.findViewById(R.id.sp_type);
                    if (appCompatSpinner != null) {
                        i2 = R.id.til_name;
                        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.til_name);
                        if (textInputLayout != null) {
                            i2 = R.id.til_url;
                            TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.til_url);
                            if (textInputLayout2 != null) {
                                DialogRuleSubEditBinding dialogRuleSubEditBinding = new DialogRuleSubEditBinding((LinearLayout) viewInflate, editText, editText2, appCompatSpinner, textInputLayout, textInputLayout2);
                                RuleSub ruleSub = this.$ruleSub;
                                appCompatSpinner.setSelection(ruleSub.getType());
                                editText.setText(ruleSub.getName());
                                editText2.setText(ruleSub.getUrl());
                                j.d(dialogRuleSubEditBinding, "inflate(layoutInflater).apply {\n                spType.setSelection(ruleSub.type)\n                etName.setText(ruleSub.name)\n                etUrl.setText(ruleSub.url)\n            }");
                                hVar.d(new a(dialogRuleSubEditBinding));
                                hVar.m(new C0213b(RuleSubActivity.this, this.$ruleSub, dialogRuleSubEditBinding));
                                f.K0(hVar, null, 1, null);
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: compiled from: RuleSubActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.subscription.RuleSubActivity$upOrder$1", f = "RuleSubActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public c(f.z.d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new c(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            List<RuleSub> all = AppDatabaseKt.getAppDb().getRuleSubDao().getAll();
            Iterator<RuleSub> it = all.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2++;
                it.next().setCustomOrder(i2);
            }
            RuleSubDao ruleSubDao = AppDatabaseKt.getAppDb().getRuleSubDao();
            Object[] array = all.toArray(new RuleSub[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            RuleSub[] ruleSubArr = (RuleSub[]) array;
            ruleSubDao.update((RuleSub[]) Arrays.copyOf(ruleSubArr, ruleSubArr.length));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: RuleSubActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.subscription.RuleSubActivity$updateSourceSub$1", f = "RuleSubActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ RuleSub[] $ruleSub;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(RuleSub[] ruleSubArr, f.z.d<? super d> dVar) {
            super(2, dVar);
            this.$ruleSub = ruleSubArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new d(this.$ruleSub, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            RuleSubDao ruleSubDao = AppDatabaseKt.getAppDb().getRuleSubDao();
            RuleSub[] ruleSubArr = this.$ruleSub;
            ruleSubDao.update((RuleSub[]) Arrays.copyOf(ruleSubArr, ruleSubArr.length));
            return v.a;
        }
    }

    public RuleSubActivity() {
        super(false, null, null, false, false, 31);
    }

    @Override // io.legado.app.ui.rss.subscription.RuleSubAdapter.a
    public void G0(@NotNull RuleSub ruleSub) {
        j.e(ruleSub, "ruleSub");
        k0 k0Var = k0.f6264c;
        f.L3(this, k0.f6263b, null, new a(ruleSub, null), 2, null);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_rule_sub, (ViewGroup) null, false);
        int i2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            i2 = R.id.title_bar;
            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
            if (titleBar != null) {
                i2 = R.id.tv_empty_msg;
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_empty_msg);
                if (textView != null) {
                    ActivityRuleSubBinding activityRuleSubBinding = new ActivityRuleSubBinding((LinearLayout) viewInflate, recyclerView, titleBar, textView);
                    j.d(activityRuleSubBinding, "inflate(layoutInflater)");
                    return activityRuleSubBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        this.adapter = new RuleSubAdapter(this, this);
        RecyclerView recyclerView = K0().f6554b;
        RuleSubAdapter ruleSubAdapter = this.adapter;
        if (ruleSubAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerView.setAdapter(ruleSubAdapter);
        RuleSubAdapter ruleSubAdapter2 = this.adapter;
        if (ruleSubAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        ItemTouchCallback itemTouchCallback = new ItemTouchCallback(ruleSubAdapter2);
        itemTouchCallback.isCanDrag = true;
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(K0().f6554b);
        LiveData<List<RuleSub>> liveData = this.liveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<RuleSub>> liveDataObserveAll = AppDatabaseKt.getAppDb().getRuleSubDao().observeAll();
        this.liveData = liveDataObserveAll;
        if (liveDataObserveAll == null) {
            return;
        }
        liveDataObserveAll.observe(this, new Observer() { // from class: e.a.a.g.k.e.a
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                RuleSubActivity ruleSubActivity = this.a;
                List list = (List) obj;
                int i2 = RuleSubActivity.f7564g;
                j.e(ruleSubActivity, "this$0");
                TextView textView = ruleSubActivity.K0().f6555c;
                j.d(textView, "binding.tvEmptyMsg");
                j.d(list, "it");
                textView.setVisibility(list.isEmpty() ^ true ? 8 : 0);
                RuleSubAdapter ruleSubAdapter3 = ruleSubActivity.adapter;
                if (ruleSubAdapter3 != null) {
                    ruleSubAdapter3.x(list);
                } else {
                    j.m("adapter");
                    throw null;
                }
            }
        });
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.source_subscription, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.ui.rss.subscription.RuleSubAdapter.a
    public void Q(@NotNull RuleSub ruleSub) {
        j.e(ruleSub, "ruleSub");
        ((i) f.j0(this, Integer.valueOf(R.string.rule_subscription), null, new b(ruleSub), 2)).p();
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.menu_add) {
            Q(new RuleSub(0L, null, null, 0, AppDatabaseKt.getAppDb().getRuleSubDao().getMaxOrder() + 1, false, 0L, 111, null));
        }
        return super.Q0(item);
    }

    @Override // io.legado.app.ui.rss.subscription.RuleSubAdapter.a
    public void a() {
        k0 k0Var = k0.f6264c;
        f.L3(this, k0.f6263b, null, new c(null), 2, null);
    }

    @Override // io.legado.app.ui.rss.subscription.RuleSubAdapter.a
    public void p0(@NotNull RuleSub ruleSub) {
        j.e(ruleSub, "ruleSub");
        int type = ruleSub.getType();
        if (type == 0) {
            Intent intent = new Intent(this, (Class<?>) ImportBookSourceActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("source", ruleSub.getUrl());
            startActivity(intent);
            return;
        }
        if (type == 1) {
            Intent intent2 = new Intent(this, (Class<?>) ImportRssSourceActivity.class);
            intent2.addFlags(268435456);
            intent2.putExtra("source", ruleSub.getUrl());
            startActivity(intent2);
            return;
        }
        if (type != 2) {
            return;
        }
        Intent intent3 = new Intent(this, (Class<?>) ImportReplaceRuleActivity.class);
        intent3.addFlags(268435456);
        intent3.putExtra("source", ruleSub.getUrl());
        startActivity(intent3);
    }

    @Override // io.legado.app.ui.rss.subscription.RuleSubAdapter.a
    public void r(@NotNull RuleSub... ruleSub) {
        j.e(ruleSub, "ruleSub");
        k0 k0Var = k0.f6264c;
        f.L3(this, k0.f6263b, null, new d(ruleSub, null), 2, null);
    }
}
