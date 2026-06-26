package io.legado.app.ui.book.local;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.documentfile.provider.DocumentFile;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.e.c.k;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.u;
import f.v;
import g.b.a0;
import g.b.f1;
import g.b.g2.m;
import g.b.k0;
import g.b.o1;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.databinding.ActivityImportBookBinding;
import io.legado.app.ui.book.local.ImportBookActivity;
import io.legado.app.ui.book.local.ImportBookAdapter;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.ui.widget.text.StrokeTextView;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: ImportBookActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\bT\u0010\tJ\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tJ\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\tJ\u0017\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\tJ\u000f\u0010*\u001a\u00020\u0007H\u0016¢\u0006\u0004\b*\u0010\tR\u001d\u0010/\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R&\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000b00j\b\u0012\u0004\u0012\u00020\u000b`18\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010@\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010<0<0;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R1\u0010H\u001a\u001d\u0012\u0013\u0012\u00110B¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020\u00070A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u00107R$\u0010S\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002050P\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lio/legado/app/ui/book/local/ImportBookActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityImportBookBinding;", "Lio/legado/app/ui/book/local/ImportBookViewModel;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lio/legado/app/ui/book/local/ImportBookAdapter$a;", "Lio/legado/app/ui/widget/SelectActionBar$a;", "Lf/v;", "V0", "()V", "Y0", "Landroidx/documentfile/provider/DocumentFile;", "rootDoc", "W0", "(Landroidx/documentfile/provider/DocumentFile;)V", "X0", "", "U0", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "onMenuItemClick", "selectAll", "E0", "(Z)V", "f0", "I0", "Landroid/net/Uri;", "uri", ExifInterface.GPS_DIRECTION_TRUE, "(Landroid/net/Uri;)V", "onBackPressed", "b", "o", "Lf/e;", "T0", "()Lio/legado/app/ui/book/local/ImportBookViewModel;", "viewModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ai.aA, "Ljava/util/ArrayList;", "subDocs", "", "m", "Ljava/lang/String;", "path", "h", "Landroidx/documentfile/provider/DocumentFile;", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", "n", "Landroidx/activity/result/ActivityResultLauncher;", "selectFolder", "Lkotlin/Function1;", "Le/a/a/h/i;", "Lkotlin/ParameterName;", "name", "docItem", "p", "Lf/c0/b/l;", "find", "Lio/legado/app/ui/book/local/ImportBookAdapter;", "j", "Lio/legado/app/ui/book/local/ImportBookAdapter;", "adapter", Constants.LANDSCAPE, "sdPath", "Landroidx/lifecycle/LiveData;", "", "k", "Landroidx/lifecycle/LiveData;", "localUriLiveData", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ImportBookActivity extends VMBaseActivity<ActivityImportBookBinding, ImportBookViewModel> implements PopupMenu.OnMenuItemClickListener, ImportBookAdapter.a, SelectActionBar.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7126g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public DocumentFile rootDoc;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<DocumentFile> subDocs;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public ImportBookAdapter adapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<String>> localUriLiveData;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String sdPath;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public String path;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> selectFolder;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final l<e.a.a.h.i, v> find;

    /* JADX INFO: compiled from: ImportBookActivity.kt */
    public static final class a extends k implements l<e.a.a.h.i, v> {

        /* JADX INFO: renamed from: io.legado.app.ui.book.local.ImportBookActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImportBookActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.local.ImportBookActivity$find$1$1", f = "ImportBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0198a extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
            public final /* synthetic */ e.a.a.h.i $it;
            public int label;
            public final /* synthetic */ ImportBookActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0198a(ImportBookActivity importBookActivity, e.a.a.h.i iVar, f.z.d<? super C0198a> dVar) {
                super(2, dVar);
                this.this$0 = importBookActivity;
                this.$it = iVar;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new C0198a(this.this$0, this.$it, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                return ((C0198a) create(a0Var, dVar)).invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                ImportBookAdapter importBookAdapter = this.this$0.adapter;
                if (importBookAdapter != null) {
                    importBookAdapter.f(this.$it);
                    return v.a;
                }
                j.m("adapter");
                throw null;
            }
        }

        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(e.a.a.h.i iVar) {
            invoke2(iVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.h.i iVar) {
            j.e(iVar, "it");
            ImportBookActivity importBookActivity = ImportBookActivity.this;
            c.b.a.m.f.L3(importBookActivity, null, null, new C0198a(importBookActivity, iVar, null), 3, null);
        }
    }

    /* JADX INFO: compiled from: ImportBookActivity.kt */
    public static final class b extends k implements f.c0.b.a<v> {
        public final /* synthetic */ String $lastPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.$lastPath = str;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ImportBookActivity importBookActivity = ImportBookActivity.this;
            importBookActivity.rootDoc = null;
            importBookActivity.subDocs.clear();
            ImportBookActivity importBookActivity2 = ImportBookActivity.this;
            importBookActivity2.path = this.$lastPath;
            importBookActivity2.Y0();
        }
    }

    /* JADX INFO: compiled from: ImportBookActivity.kt */
    public static final class c extends k implements f.c0.b.a<v> {
        public c() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ImportBookAdapter importBookAdapter = ImportBookActivity.this.adapter;
            if (importBookAdapter != null) {
                importBookAdapter.notifyDataSetChanged();
            } else {
                j.m("adapter");
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: ImportBookActivity.kt */
    public static final class d extends k implements f.c0.b.a<v> {
        public d() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ImportBookAdapter importBookAdapter = ImportBookActivity.this.adapter;
            if (importBookAdapter == null) {
                j.m("adapter");
                throw null;
            }
            int iM = f.x.e.m(importBookAdapter.items);
            if (iM < 0) {
                return;
            }
            while (true) {
                int i2 = iM - 1;
                HashSet<String> hashSet = importBookAdapter.selectedUris;
                e.a.a.h.i item = importBookAdapter.getItem(iM);
                if (hashSet.contains(String.valueOf(item == null ? null : item.f5957e))) {
                    synchronized (importBookAdapter) {
                        try {
                            if (importBookAdapter.items.remove(iM) != null) {
                                importBookAdapter.notifyItemRemoved(iM + importBookAdapter.l());
                            }
                            importBookAdapter.v();
                            f.h.m11constructorimpl(v.a);
                        } finally {
                        }
                    }
                }
                if (i2 < 0) {
                    return;
                } else {
                    iM = i2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class e extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
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
    public static final class f extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
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

    /* JADX INFO: compiled from: ImportBookActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.local.ImportBookActivity$upDocs$1", f = "ImportBookActivity.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ u<DocumentFile> $lastDoc;
        public int label;

        /* JADX INFO: compiled from: ImportBookActivity.kt */
        public static final class a extends k implements l<e.a.a.h.i, Comparable<?>> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // f.c0.b.l
            @Nullable
            public final Comparable<?> invoke(@NotNull e.a.a.h.i iVar) {
                j.e(iVar, "it");
                return Boolean.valueOf(!iVar.a());
            }
        }

        /* JADX INFO: compiled from: ImportBookActivity.kt */
        public static final class b extends k implements l<e.a.a.h.i, Comparable<?>> {
            public static final b INSTANCE = new b();

            public b() {
                super(1);
            }

            @Override // f.c0.b.l
            @Nullable
            public final Comparable<?> invoke(@NotNull e.a.a.h.i iVar) {
                j.e(iVar, "it");
                return iVar.a;
            }
        }

        /* JADX INFO: compiled from: ImportBookActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.local.ImportBookActivity$upDocs$1$3", f = "ImportBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class c extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
            public final /* synthetic */ ArrayList<e.a.a.h.i> $docList;
            public int label;
            public final /* synthetic */ ImportBookActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(ImportBookActivity importBookActivity, ArrayList<e.a.a.h.i> arrayList, f.z.d<? super c> dVar) {
                super(2, dVar);
                this.this$0 = importBookActivity;
                this.$docList = arrayList;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new c(this.this$0, this.$docList, dVar);
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
                c.b.a.m.f.E5(obj);
                ImportBookAdapter importBookAdapter = this.this$0.adapter;
                if (importBookAdapter != null) {
                    importBookAdapter.x(this.$docList);
                    return v.a;
                }
                j.m("adapter");
                throw null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(u<DocumentFile> uVar, f.z.d<? super g> dVar) {
            super(2, dVar);
            this.$lastDoc = uVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return ImportBookActivity.this.new g(this.$lastDoc, dVar);
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
                e.a.a.h.j jVar = e.a.a.h.j.a;
                ImportBookActivity importBookActivity = ImportBookActivity.this;
                Uri uri = this.$lastDoc.element.getUri();
                j.d(uri, "lastDoc.uri");
                ArrayList<e.a.a.h.i> arrayListD = jVar.d(importBookActivity, uri);
                int iM = f.x.e.m(arrayListD);
                if (iM >= 0) {
                    while (true) {
                        int i3 = iM - 1;
                        e.a.a.h.i iVar = arrayListD.get(iM);
                        j.d(iVar, "docList[i]");
                        e.a.a.h.i iVar2 = iVar;
                        if (f.h0.k.K(iVar2.a, ".", false, 2)) {
                            arrayListD.remove(iM);
                        } else if (!iVar2.a() && !f.h0.k.f(iVar2.a, ".txt", true) && !f.h0.k.f(iVar2.a, ".epub", true)) {
                            arrayListD.remove(iM);
                        }
                        if (i3 < 0) {
                            break;
                        }
                        iM = i3;
                    }
                }
                c.b.a.m.f.m5(arrayListD, c.b.a.m.f.U0(a.INSTANCE, b.INSTANCE));
                k0 k0Var = k0.f6264c;
                o1 o1Var = m.f6207b;
                c cVar = new c(ImportBookActivity.this, arrayListD, null);
                this.label = 1;
                if (c.b.a.m.f.f6(o1Var, cVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ImportBookActivity.kt */
    public static final class h extends k implements l<e.a.a.h.i, Comparable<?>> {
        public static final h INSTANCE = new h();

        public h() {
            super(1);
        }

        @Override // f.c0.b.l
        @Nullable
        public final Comparable<?> invoke(@NotNull e.a.a.h.i iVar) {
            j.e(iVar, "it");
            return Boolean.valueOf(!iVar.a());
        }
    }

    /* JADX INFO: compiled from: ImportBookActivity.kt */
    public static final class i extends k implements l<e.a.a.h.i, Comparable<?>> {
        public static final i INSTANCE = new i();

        public i() {
            super(1);
        }

        @Override // f.c0.b.l
        @Nullable
        public final Comparable<?> invoke(@NotNull e.a.a.h.i iVar) {
            j.e(iVar, "it");
            return iVar.a;
        }
    }

    public ImportBookActivity() {
        super(false, null, null, false, false, 31);
        this.subDocs = new ArrayList<>();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        try {
            absolutePath = new File(absolutePath).getCanonicalPath();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        j.d(absolutePath, "sdCardDirectory");
        this.sdPath = absolutePath;
        this.path = absolutePath;
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.h.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ImportBookActivity importBookActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = ImportBookActivity.f7126g;
                f.c0.c.j.e(importBookActivity, "this$0");
                if (uri == null) {
                    return;
                }
                if (c.b.a.m.f.s3(uri)) {
                    e.a.a.d.e eVar = e.a.a.d.e.a;
                    String string = uri.toString();
                    if (string == null) {
                        c.b.a.m.f.H4(k.d.a.h.g(), "importBookPath");
                    } else {
                        c.b.a.m.f.r4(k.d.a.h.g(), "importBookPath", string);
                    }
                    importBookActivity.V0();
                    return;
                }
                String path = uri.getPath();
                if (path == null) {
                    return;
                }
                e.a.a.d.e eVar2 = e.a.a.d.e.a;
                c.b.a.m.f.r4(k.d.a.h.g(), "importBookPath", path);
                importBookActivity.V0();
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            AppConfig.importBookPath = uri.toString()\n            initRootDoc()\n        } else {\n            uri.path?.let { path ->\n                AppConfig.importBookPath = path\n                initRootDoc()\n            }\n        }\n    }");
        this.selectFolder = activityResultLauncherRegisterForActivityResult;
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(ImportBookViewModel.class), new f(this), new e(this));
        this.find = new a();
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void E0(boolean selectAll) {
        ImportBookAdapter importBookAdapter = this.adapter;
        if (importBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        if (selectAll) {
            for (e.a.a.h.i iVar : importBookAdapter.items) {
                if (!iVar.a() && !importBookAdapter.bookFileNames.contains(iVar.a)) {
                    importBookAdapter.selectedUris.add(iVar.f5957e.toString());
                }
            }
        } else {
            importBookAdapter.selectedUris.clear();
        }
        importBookAdapter.notifyDataSetChanged();
        importBookAdapter.callBack.b();
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void I0() {
        ImportBookViewModel importBookViewModelT0 = T0();
        ImportBookAdapter importBookAdapter = this.adapter;
        if (importBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        HashSet<String> hashSet = importBookAdapter.selectedUris;
        c cVar = new c();
        Objects.requireNonNull(importBookViewModelT0);
        j.e(hashSet, "uriList");
        j.e(cVar, "finally");
        e.a.a.d.u.b.c(BaseViewModel.a(importBookViewModelT0, null, null, new e.a.a.g.d.h.g(hashSet, null), 3, null), null, new e.a.a.g.d.h.h(cVar, null), 1);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_import_book, (ViewGroup) null, false);
        int i2 = R.id.lay_top;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.lay_top);
        if (linearLayout != null) {
            i2 = R.id.recycler_view;
            FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) viewInflate.findViewById(R.id.recycler_view);
            if (fastScrollRecyclerView != null) {
                i2 = R.id.refresh_progress_bar;
                RefreshProgressBar refreshProgressBar = (RefreshProgressBar) viewInflate.findViewById(R.id.refresh_progress_bar);
                if (refreshProgressBar != null) {
                    i2 = R.id.select_action_bar;
                    SelectActionBar selectActionBar = (SelectActionBar) viewInflate.findViewById(R.id.select_action_bar);
                    if (selectActionBar != null) {
                        i2 = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.titleBar);
                        if (titleBar != null) {
                            i2 = R.id.tv_empty_msg;
                            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_empty_msg);
                            if (textView != null) {
                                i2 = R.id.tv_go_back;
                                StrokeTextView strokeTextView = (StrokeTextView) viewInflate.findViewById(R.id.tv_go_back);
                                if (strokeTextView != null) {
                                    i2 = R.id.tv_path;
                                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_path);
                                    if (textView2 != null) {
                                        ActivityImportBookBinding activityImportBookBinding = new ActivityImportBookBinding((ConstraintLayout) viewInflate, linearLayout, fastScrollRecyclerView, refreshProgressBar, selectActionBar, titleBar, textView, strokeTextView, textView2);
                                        j.d(activityImportBookBinding, "inflate(layoutInflater)");
                                        return activityImportBookBinding;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        ((ActivityImportBookBinding) K0()).f6515b.setBackgroundColor(c.b.a.m.f.R1(this));
        ((ActivityImportBookBinding) K0()).f6516c.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new ImportBookAdapter(this, this);
        FastScrollRecyclerView fastScrollRecyclerView = ((ActivityImportBookBinding) K0()).f6516c;
        ImportBookAdapter importBookAdapter = this.adapter;
        if (importBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        fastScrollRecyclerView.setAdapter(importBookAdapter);
        ((ActivityImportBookBinding) K0()).f6518e.setMainActionText(R.string.add_to_shelf);
        ((ActivityImportBookBinding) K0()).f6518e.a(R.menu.import_book_sel);
        ((ActivityImportBookBinding) K0()).f6518e.setOnMenuItemClickListener(this);
        ((ActivityImportBookBinding) K0()).f6518e.setCallBack(this);
        ((ActivityImportBookBinding) K0()).f6520g.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.h.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImportBookActivity importBookActivity = this.a;
                int i2 = ImportBookActivity.f7126g;
                f.c0.c.j.e(importBookActivity, "this$0");
                importBookActivity.U0();
            }
        });
        LiveData<List<String>> liveData = this.localUriLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<String>> liveDataObserveLocalUri = AppDatabaseKt.getAppDb().getBookDao().observeLocalUri();
        this.localUriLiveData = liveDataObserveLocalUri;
        if (liveDataObserveLocalUri != null) {
            liveDataObserveLocalUri.observe(this, new Observer() { // from class: e.a.a.g.d.h.b
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    String strSubstring;
                    String string;
                    ImportBookActivity importBookActivity = this.a;
                    List list = (List) obj;
                    int i2 = ImportBookActivity.f7126g;
                    f.c0.c.j.e(importBookActivity, "this$0");
                    ImportBookAdapter importBookAdapter2 = importBookActivity.adapter;
                    if (importBookAdapter2 == null) {
                        f.c0.c.j.m("adapter");
                        throw null;
                    }
                    f.c0.c.j.d(list, "it");
                    f.c0.c.j.e(list, "bookUrls");
                    importBookAdapter2.bookFileNames.clear();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String strDecode = Uri.decode((String) it.next());
                        ArrayList<String> arrayList = importBookAdapter2.bookFileNames;
                        if (strDecode == null) {
                            string = "";
                        } else {
                            int iT = f.h0.k.t(strDecode, Attributes.InternalPrefix, 0, false, 6);
                            if (iT >= 0) {
                                string = strDecode.substring(iT + 1);
                                f.c0.c.j.d(string, "(this as java.lang.String).substring(startIndex)");
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(System.currentTimeMillis());
                                sb.append('.');
                                f.c0.c.j.e(strDecode, "pathOrUrl");
                                int iT2 = f.h0.k.t(strDecode, '.', 0, false, 6);
                                if (iT2 >= 0) {
                                    strSubstring = strDecode.substring(iT2 + 1);
                                    f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                                } else {
                                    strSubstring = "ext";
                                }
                                sb.append(strSubstring);
                                string = sb.toString();
                            }
                        }
                        arrayList.add(string);
                    }
                    importBookAdapter2.notifyDataSetChanged();
                    importBookAdapter2.A();
                }
            });
        }
        V0();
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.import_book, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        f1 f1VarL3;
        j.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.menu_scan_folder) {
            DocumentFile documentFile = this.rootDoc;
            if (documentFile == null) {
                f1VarL3 = null;
            } else {
                ImportBookAdapter importBookAdapter = this.adapter;
                if (importBookAdapter == null) {
                    j.m("adapter");
                    throw null;
                }
                importBookAdapter.h();
                DocumentFile documentFile2 = (DocumentFile) f.x.e.s(this.subDocs);
                if (documentFile2 != null) {
                    documentFile = documentFile2;
                }
                ((ActivityImportBookBinding) K0()).f6517d.setAutoLoading(true);
                k0 k0Var = k0.f6264c;
                f1VarL3 = c.b.a.m.f.L3(this, k0.f6263b, null, new e.a.a.g.d.h.e(this, documentFile, null), 2, null);
            }
            if (f1VarL3 == null) {
                e.a.a.d.e eVar = e.a.a.d.e.a;
                String strO2 = c.b.a.m.f.O2(k.d.a.h.g(), "importBookPath", null, 2);
                if (strO2 == null || strO2.length() == 0) {
                    c.b.a.m.f.Q5(this, R.string.empty_msg_import_book);
                } else {
                    ImportBookAdapter importBookAdapter2 = this.adapter;
                    if (importBookAdapter2 == null) {
                        j.m("adapter");
                        throw null;
                    }
                    importBookAdapter2.h();
                    File file = new File(this.path);
                    ((ActivityImportBookBinding) K0()).f6517d.setAutoLoading(true);
                    k0 k0Var2 = k0.f6264c;
                    c.b.a.m.f.L3(this, k0.f6263b, null, new e.a.a.g.d.h.f(this, file, null), 2, null);
                }
            }
        } else if (itemId == R.id.menu_select_folder) {
            this.selectFolder.launch(null);
        }
        return super.Q0(item);
    }

    @Override // io.legado.app.ui.book.local.ImportBookAdapter.a
    public synchronized void T(@NotNull Uri uri) {
        j.e(uri, "uri");
        if (c.b.a.m.f.t3(uri.toString())) {
            ArrayList<DocumentFile> arrayList = this.subDocs;
            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this, uri);
            j.c(documentFileFromSingleUri);
            arrayList.add(documentFileFromSingleUri);
        } else {
            this.path = String.valueOf(uri.getPath());
        }
        Y0();
    }

    @NotNull
    public ImportBookViewModel T0() {
        return (ImportBookViewModel) this.viewModel.getValue();
    }

    public final synchronized boolean U0() {
        String parent;
        boolean z = false;
        if (this.rootDoc == null) {
            if (!j.a(this.path, this.sdPath) && (parent = new File(this.path).getParent()) != null) {
                this.path = parent;
                Y0();
                return true;
            }
            return false;
        }
        if (!this.subDocs.isEmpty()) {
            ArrayList<DocumentFile> arrayList = this.subDocs;
            arrayList.remove(f.x.e.m(arrayList));
            Y0();
            z = true;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V0() {
        e.a.a.d.e eVar = e.a.a.d.e.a;
        String strO2 = c.b.a.m.f.O2(k.d.a.h.g(), "importBookPath", null, 2);
        if (strO2 == null || strO2.length() == 0) {
            TextView textView = ((ActivityImportBookBinding) K0()).f6519f;
            j.d(textView, "binding.tvEmptyMsg");
            c.b.a.m.f.c6(textView);
            this.selectFolder.launch(null);
            return;
        }
        if (c.b.a.m.f.t3(strO2)) {
            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this, Uri.parse(strO2));
            this.rootDoc = documentFileFromTreeUri;
            if (documentFileFromTreeUri != null) {
                this.subDocs.clear();
                Y0();
                return;
            } else {
                TextView textView2 = ((ActivityImportBookBinding) K0()).f6519f;
                j.d(textView2, "binding.tvEmptyMsg");
                c.b.a.m.f.c6(textView2);
                this.selectFolder.launch(null);
                return;
            }
        }
        if (Build.VERSION.SDK_INT > 29) {
            TextView textView3 = ((ActivityImportBookBinding) K0()).f6519f;
            j.d(textView3, "binding.tvEmptyMsg");
            c.b.a.m.f.c6(textView3);
            this.selectFolder.launch(null);
            return;
        }
        TextView textView4 = ((ActivityImportBookBinding) K0()).f6519f;
        j.d(textView4, "binding.tvEmptyMsg");
        c.b.a.m.f.c6(textView4);
        k.a aVar = new k.a(this);
        String[] strArr = e.a.a.e.c.j.a;
        aVar.a((String[]) Arrays.copyOf(strArr, strArr.length));
        aVar.c(R.string.tip_perm_request_storage);
        aVar.b(new b(strO2));
        aVar.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, androidx.documentfile.provider.DocumentFile, java.lang.Object] */
    public final void W0(DocumentFile rootDoc) {
        TextView textView = ((ActivityImportBookBinding) K0()).f6519f;
        j.d(textView, "binding.tvEmptyMsg");
        c.b.a.m.f.e3(textView);
        String strK = j.k(rootDoc.getName(), File.separator);
        u uVar = new u();
        uVar.element = rootDoc;
        for (DocumentFile documentFile : this.subDocs) {
            j.d(documentFile, "doc");
            uVar.element = documentFile;
            StringBuilder sbR = c.a.a.a.a.r(strK);
            sbR.append((Object) documentFile.getName());
            sbR.append((Object) File.separator);
            strK = sbR.toString();
        }
        ((ActivityImportBookBinding) K0()).f6521h.setText(strK);
        ImportBookAdapter importBookAdapter = this.adapter;
        if (importBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        importBookAdapter.selectedUris.clear();
        ImportBookAdapter importBookAdapter2 = this.adapter;
        if (importBookAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        importBookAdapter2.h();
        k0 k0Var = k0.f6264c;
        c.b.a.m.f.L3(this, k0.f6263b, null, new g(uVar, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X0() {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.local.ImportBookActivity.X0():void");
    }

    public final synchronized void Y0() {
        v vVar;
        DocumentFile documentFile = this.rootDoc;
        if (documentFile == null) {
            vVar = null;
        } else {
            W0(documentFile);
            vVar = v.a;
        }
        if (vVar == null) {
            X0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.local.ImportBookAdapter.a
    public void b() {
        SelectActionBar selectActionBar = ((ActivityImportBookBinding) K0()).f6518e;
        ImportBookAdapter importBookAdapter = this.adapter;
        if (importBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        int size = importBookAdapter.selectedUris.size();
        ImportBookAdapter importBookAdapter2 = this.adapter;
        if (importBookAdapter2 != null) {
            selectActionBar.b(size, importBookAdapter2.checkableCount);
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void f0() {
        ImportBookAdapter importBookAdapter = this.adapter;
        if (importBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        for (e.a.a.h.i iVar : importBookAdapter.items) {
            if (!iVar.a()) {
                if (importBookAdapter.selectedUris.contains(iVar.f5957e.toString())) {
                    importBookAdapter.selectedUris.remove(iVar.f5957e.toString());
                } else {
                    importBookAdapter.selectedUris.add(iVar.f5957e.toString());
                }
            }
        }
        importBookAdapter.callBack.b();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (U0()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_del_selection) {
            return false;
        }
        ImportBookViewModel importBookViewModelT0 = T0();
        ImportBookAdapter importBookAdapter = this.adapter;
        if (importBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        HashSet<String> hashSet = importBookAdapter.selectedUris;
        d dVar = new d();
        Objects.requireNonNull(importBookViewModelT0);
        j.e(hashSet, "uriList");
        j.e(dVar, "finally");
        e.a.a.d.u.b.c(BaseViewModel.a(importBookViewModelT0, null, null, new e.a.a.g.d.h.i(hashSet, importBookViewModelT0, null), 3, null), null, new e.a.a.g.d.h.j(dVar, null), 1);
        return false;
    }
}
