package io.legado.app.ui.rss.source.debug;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.ActivitySourceDebugBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.model.Debug;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceDebugActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/legado/app/ui/rss/source/debug/RssSourceDebugActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivitySourceDebugBinding;", "Lio/legado/app/ui/rss/source/debug/RssSourceDebugModel;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/ui/rss/source/debug/RssSourceDebugAdapter;", ai.aA, "Lio/legado/app/ui/rss/source/debug/RssSourceDebugAdapter;", "adapter", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/rss/source/debug/RssSourceDebugModel;", "viewModel", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSourceDebugActivity extends VMBaseActivity<ActivitySourceDebugBinding, RssSourceDebugModel> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7533g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public RssSourceDebugAdapter adapter;

    /* JADX INFO: compiled from: RssSourceDebugActivity.kt */
    public static final class a extends k implements p<Integer, String, v> {

        /* JADX INFO: renamed from: io.legado.app.ui.rss.source.debug.RssSourceDebugActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RssSourceDebugActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.rss.source.debug.RssSourceDebugActivity$onActivityCreated$1$1", f = "RssSourceDebugActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0211a extends g implements p<a0, f.z.d<? super v>, Object> {
            public final /* synthetic */ String $msg;
            public final /* synthetic */ int $state;
            public int label;
            public final /* synthetic */ RssSourceDebugActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0211a(RssSourceDebugActivity rssSourceDebugActivity, String str, int i2, f.z.d<? super C0211a> dVar) {
                super(2, dVar);
                this.this$0 = rssSourceDebugActivity;
                this.$msg = str;
                this.$state = i2;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new C0211a(this.this$0, this.$msg, this.$state, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                return ((C0211a) create(a0Var, dVar)).invokeSuspend(v.a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
                RssSourceDebugAdapter rssSourceDebugAdapter = this.this$0.adapter;
                if (rssSourceDebugAdapter == null) {
                    j.m("adapter");
                    throw null;
                }
                rssSourceDebugAdapter.f(this.$msg);
                int i2 = this.$state;
                if (i2 == -1 || i2 == 1000) {
                    ((ActivitySourceDebugBinding) this.this$0.K0()).f6564c.a();
                }
                return v.a;
            }
        }

        public a() {
            super(2);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(Integer num, String str) {
            invoke(num.intValue(), str);
            return v.a;
        }

        public final void invoke(int i2, @NotNull String str) {
            j.e(str, NotificationCompat.CATEGORY_MESSAGE);
            RssSourceDebugActivity rssSourceDebugActivity = RssSourceDebugActivity.this;
            f.L3(rssSourceDebugActivity, null, null, new C0211a(rssSourceDebugActivity, str, i2, null), 3, null);
        }
    }

    /* JADX INFO: compiled from: RssSourceDebugActivity.kt */
    public static final class b extends k implements f.c0.b.a<v> {
        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            RssSourceDebugActivity rssSourceDebugActivity = RssSourceDebugActivity.this;
            RssSourceDebugAdapter rssSourceDebugAdapter = rssSourceDebugActivity.adapter;
            v vVar = null;
            if (rssSourceDebugAdapter == null) {
                j.m("adapter");
                throw null;
            }
            rssSourceDebugAdapter.h();
            RssSourceDebugModel rssSourceDebugModelT0 = rssSourceDebugActivity.T0();
            e.a.a.g.k.d.a.a aVar = new e.a.a.g.k.d.a.a(rssSourceDebugActivity);
            e.a.a.g.k.d.a.b bVar = new e.a.a.g.k.d.a.b(rssSourceDebugActivity);
            RssSource rssSource = rssSourceDebugModelT0.rssSource;
            if (rssSource != null) {
                aVar.invoke();
                Debug debug = Debug.INSTANCE;
                debug.setCallback(rssSourceDebugModelT0);
                debug.startDebug(rssSourceDebugModelT0, rssSource);
                vVar = v.a;
            }
            if (vVar == null) {
                bVar.invoke();
            }
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class c extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class d extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            j.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public RssSourceDebugActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(RssSourceDebugModel.class), new d(this), new c(this));
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        ActivitySourceDebugBinding activitySourceDebugBindingA = ActivitySourceDebugBinding.a(getLayoutInflater());
        j.d(activitySourceDebugBindingA, "inflate(layoutInflater)");
        return activitySourceDebugBindingA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        ATH.a.b(((ActivitySourceDebugBinding) K0()).f6563b);
        this.adapter = new RssSourceDebugAdapter(this);
        RecyclerView recyclerView = ((ActivitySourceDebugBinding) K0()).f6563b;
        RssSourceDebugAdapter rssSourceDebugAdapter = this.adapter;
        if (rssSourceDebugAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerView.setAdapter(rssSourceDebugAdapter);
        ((ActivitySourceDebugBinding) K0()).f6564c.setLoadingColor(f.M1(this));
        View viewFindViewById = ((ActivitySourceDebugBinding) K0()).f6565d.findViewById(R.id.search_view);
        j.d(viewFindViewById, "binding.titleBar.findViewById<SearchView>(R.id.search_view)");
        f.e3(viewFindViewById);
        RssSourceDebugModel rssSourceDebugModelT0 = T0();
        a aVar = new a();
        Objects.requireNonNull(rssSourceDebugModelT0);
        j.e(aVar, "callback");
        rssSourceDebugModelT0.callback = aVar;
        RssSourceDebugModel rssSourceDebugModelT02 = T0();
        String stringExtra = getIntent().getStringExtra("key");
        b bVar = new b();
        Objects.requireNonNull(rssSourceDebugModelT02);
        j.e(bVar, "finally");
        if (stringExtra == null) {
            return;
        }
        e.a.a.d.u.b.c(BaseViewModel.a(rssSourceDebugModelT02, null, null, new e.a.a.g.k.d.a.d(rssSourceDebugModelT02, stringExtra, null), 3, null), null, new e.a.a.g.k.d.a.e(bVar, null), 1);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.rss_source_debug, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.menu_content_src) {
            TextDialog.Companion companion = TextDialog.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            j.d(supportFragmentManager, "supportFragmentManager");
            TextDialog.Companion.a(companion, supportFragmentManager, T0().contentSrc, 0, 0L, false, 28);
        } else if (itemId == R.id.menu_list_src) {
            TextDialog.Companion companion2 = TextDialog.INSTANCE;
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            j.d(supportFragmentManager2, "supportFragmentManager");
            TextDialog.Companion.a(companion2, supportFragmentManager2, T0().listSrc, 0, 0L, false, 28);
        }
        return super.Q0(item);
    }

    @NotNull
    public RssSourceDebugModel T0() {
        return (RssSourceDebugModel) this.viewModel.getValue();
    }
}
