package io.legado.app.ui.book.source.manage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentManager;
import androidx.media2.session.MediaConstants;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.snackbar.Snackbar;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.q;
import e.a.a.e.a.h;
import e.a.a.e.a.i;
import e.a.a.g.d.l.c.a0;
import e.a.a.g.d.l.c.b0;
import e.a.a.g.d.l.c.c0;
import e.a.a.g.d.l.c.e0;
import e.a.a.g.d.l.c.g0;
import e.a.a.g.d.l.c.h0;
import e.a.a.g.d.l.c.i0;
import e.a.a.g.d.l.c.j0;
import e.a.a.g.d.l.c.k0;
import e.a.a.g.d.l.c.t;
import e.a.a.g.d.l.c.t0;
import e.a.a.g.d.l.c.u0;
import e.a.a.g.d.l.c.v0;
import e.a.a.g.d.l.c.x0;
import e.a.a.g.d.l.c.y0;
import e.a.a.h.f;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.ActivityBookSourceBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.service.CheckSourceService;
import io.legado.app.ui.association.ImportBookSourceActivity;
import io.legado.app.ui.book.source.debug.BookSourceDebugActivity;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import io.legado.app.ui.book.source.manage.BookSourceAdapter;
import io.legado.app.ui.book.source.manage.BookSourceViewModel;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.qrcode.QrCodeResult;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$1;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u00019B\u0007¢\u0006\u0004\bk\u0010'J\u001b\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010!\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0012H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001cH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010'J\u0019\u0010)\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b)\u0010\"J\u000f\u0010*\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010'J\u000f\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010'J\u0019\u0010-\u001a\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b0\u0010.J\u0017\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J#\u00106\u001a\u00020\n2\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020105\"\u000201H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b8\u00104J\u000f\u00109\u001a\u00020\nH\u0016¢\u0006\u0004\b9\u0010'J\u0017\u0010:\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b:\u00104J\u0017\u0010;\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b;\u00104J\u0017\u0010<\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b<\u00104J\u000f\u0010=\u001a\u00020\nH\u0016¢\u0006\u0004\b=\u0010'R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010I\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\n0\n0F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010KR\u001d\u0010Q\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR$\u0010U\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u0011\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR$\u0010Z\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010Y0Y0F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010HR$\u0010\\\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010Y0Y0F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010HR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R&\u0010c\u001a\u0012\u0012\u0004\u0012\u00020\b0_j\b\u0012\u0004\u0012\u00020\b``8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020\b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006l"}, d2 = {"Lio/legado/app/ui/book/source/manage/BookSourceActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityBookSourceBinding;", "Lio/legado/app/ui/book/source/manage/BookSourceViewModel;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lio/legado/app/ui/book/source/manage/BookSourceAdapter$a;", "Lio/legado/app/ui/widget/SelectActionBar$a;", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "", "searchKey", "Lf/v;", "U0", "(Ljava/lang/String;)V", "Lio/legado/app/ui/book/source/manage/BookSourceActivity$a;", "sort", "V0", "(Lio/legado/app/ui/book/source/manage/BookSourceActivity$a;)V", "", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "W0", "()Ljava/util/List;", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "onPrepareOptionsMenu", "item", "Q0", "(Landroid/view/MenuItem;)Z", "selectAll", "E0", "(Z)V", "f0", "()V", "I0", "onMenuItemClick", "N0", "b", "newText", "onQueryTextChange", "(Ljava/lang/String;)Z", MediaConstants.MEDIA_URI_QUERY_QUERY, "onQueryTextSubmit", "Lio/legado/app/data/entities/BookSource;", "bookSource", "n0", "(Lio/legado/app/data/entities/BookSource;)V", "", "update", "([Lio/legado/app/data/entities/BookSource;)V", ai.az, ai.at, "j", "C0", "X", "finish", "Lcom/google/android/material/snackbar/Snackbar;", "q", "Lcom/google/android/material/snackbar/Snackbar;", "snackBar", "Landroid/view/SubMenu;", "n", "Landroid/view/SubMenu;", "groupMenu", "Landroidx/activity/result/ActivityResultLauncher;", "r", "Landroidx/activity/result/ActivityResultLauncher;", "qrResult", "Lio/legado/app/ui/book/source/manage/BookSourceAdapter;", "Lio/legado/app/ui/book/source/manage/BookSourceAdapter;", "adapter", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/book/source/manage/BookSourceViewModel;", "viewModel", "Landroidx/lifecycle/LiveData;", Constants.LANDSCAPE, "Landroidx/lifecycle/LiveData;", "bookSourceLiveDate", "p", "Z", "sortAscending", "Le/a/a/g/f/d;", "importDoc", ai.aF, "exportDir", "o", "Lio/legado/app/ui/book/source/manage/BookSourceActivity$a;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "m", "Ljava/util/LinkedHashSet;", "groups", "Landroidx/appcompat/widget/SearchView;", "k", "Landroidx/appcompat/widget/SearchView;", "searchView", ai.aA, "Ljava/lang/String;", "importRecordKey", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookSourceActivity extends VMBaseActivity<ActivityBookSourceBinding, BookSourceViewModel> implements PopupMenu.OnMenuItemClickListener, BookSourceAdapter.a, SelectActionBar.a, SearchView.OnQueryTextListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7306g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String importRecordKey;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public BookSourceAdapter adapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public SearchView searchView;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<BookSource>> bookSourceLiveDate;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final LinkedHashSet<String> groups;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @Nullable
    public SubMenu groupMenu;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public a sort;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public boolean sortAscending;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @Nullable
    public Snackbar snackBar;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<v> qrResult;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> importDoc;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> exportDir;

    /* JADX INFO: compiled from: BookSourceActivity.kt */
    public enum a {
        Default,
        Name,
        Url,
        Weight,
        Update,
        Enable;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            return (a[]) Arrays.copyOf(aVarArrValuesCustom, aVarArrValuesCustom.length);
        }
    }

    /* JADX INFO: compiled from: BookSourceActivity.kt */
    public static final class b extends k implements l<String, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, NotificationCompat.CATEGORY_MESSAGE);
            Snackbar snackbar = BookSourceActivity.this.snackBar;
            if (snackbar == null) {
                snackbar = null;
            } else {
                snackbar.n(str);
            }
            if (snackbar == null) {
                final BookSourceActivity bookSourceActivity = BookSourceActivity.this;
                Snackbar snackbarL = Snackbar.l(((ActivityBookSourceBinding) bookSourceActivity.K0()).a, str, -2);
                snackbarL.m(snackbarL.f2377e.getText(R.string.cancel), new View.OnClickListener() { // from class: e.a.a.g.d.l.c.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookSourceActivity bookSourceActivity2 = bookSourceActivity;
                        f.c0.c.j.e(bookSourceActivity2, "this$0");
                        f.c0.c.j.e(bookSourceActivity2, com.umeng.analytics.pro.c.R);
                        Intent intent = new Intent(bookSourceActivity2, (Class<?>) CheckSourceService.class);
                        intent.setAction("stop");
                        bookSourceActivity2.startService(intent);
                    }
                });
                snackbarL.o();
                bookSourceActivity.snackBar = snackbarL;
            }
        }
    }

    /* JADX INFO: compiled from: BookSourceActivity.kt */
    public static final class c extends k implements l<Integer, v> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            Snackbar snackbar = BookSourceActivity.this.snackBar;
            if (snackbar != null) {
                snackbar.b(3);
            }
            BookSourceActivity bookSourceActivity = BookSourceActivity.this;
            bookSourceActivity.snackBar = null;
            LinkedHashSet<String> linkedHashSet = bookSourceActivity.groups;
            ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(linkedHashSet, 10));
            Iterator<T> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                if (f.h0.k.d((String) it.next(), "失效", false, 2)) {
                    SearchView searchView = bookSourceActivity.searchView;
                    if (searchView == null) {
                        j.m("searchView");
                        throw null;
                    }
                    searchView.setQuery("失效", true);
                    c.b.a.m.f.R5(bookSourceActivity, "发现有失效书源，已为您自动筛选！");
                }
                arrayList.add(v.a);
            }
        }
    }

    /* JADX INFO: compiled from: BookSourceActivity.kt */
    public static final class d extends k implements l<h<? extends DialogInterface>, v> {

        /* JADX INFO: compiled from: BookSourceActivity.kt */
        public static final class a extends k implements l<DialogInterface, v> {
            public final /* synthetic */ BookSourceActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(BookSourceActivity bookSourceActivity) {
                super(1);
                this.this$0 = bookSourceActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                BookSourceViewModel bookSourceViewModelT0 = this.this$0.T0();
                BookSourceAdapter bookSourceAdapter = this.this$0.adapter;
                if (bookSourceAdapter == null) {
                    j.m("adapter");
                    throw null;
                }
                List<BookSource> listA = bookSourceAdapter.A();
                Objects.requireNonNull(bookSourceViewModelT0);
                j.e(listA, "sources");
                BaseViewModel.a(bookSourceViewModelT0, null, null, new g0(listA, null), 3, null);
            }
        }

        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            hVar.m(new a(BookSourceActivity.this));
            c.b.a.m.f.d4(hVar, null, 1, null);
        }
    }

    /* JADX INFO: compiled from: BookSourceActivity.kt */
    public static final class e extends k implements l<Intent, v> {
        public e() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Intent intent) {
            invoke2(intent);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Intent intent) {
            j.e(intent, "it");
            BookSourceActivity bookSourceActivity = BookSourceActivity.this;
            bookSourceActivity.startActivity(Intent.createChooser(intent, bookSourceActivity.getString(R.string.share_selected_source)));
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class f extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
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
    public static final class g extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
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

    public BookSourceActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(BookSourceViewModel.class), new g(this), new f(this));
        this.importRecordKey = "bookSourceRecordKey";
        this.groups = new LinkedHashSet<>();
        this.sort = a.Default;
        this.sortAscending = true;
        ActivityResultLauncher<v> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new QrCodeResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.l.c.e
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookSourceActivity bookSourceActivity = this.a;
                String str = (String) obj;
                int i2 = BookSourceActivity.f7306g;
                f.c0.c.j.e(bookSourceActivity, "this$0");
                if (str == null) {
                    return;
                }
                Intent intent = new Intent(bookSourceActivity, (Class<?>) ImportBookSourceActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("source", str);
                bookSourceActivity.startActivity(intent);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(QrCodeResult()) {\n        it ?: return@registerForActivityResult\n        startActivity<ImportBookSourceActivity> {\n            putExtra(\"source\", it)\n        }\n    }");
        this.qrResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.l.c.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookSourceActivity bookSourceActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = BookSourceActivity.f7306g;
                f.c0.c.j.e(bookSourceActivity, "this$0");
                if (uri == null) {
                    return;
                }
                try {
                    String strB4 = c.b.a.m.f.B4(uri, bookSourceActivity);
                    if (strB4 == null) {
                        return;
                    }
                    String strB = e.a.a.d.o.b(e.a.a.d.o.a, strB4, null, 2);
                    Intent intent = new Intent(bookSourceActivity, (Class<?>) ImportBookSourceActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("dataKey", strB);
                    bookSourceActivity.startActivity(intent);
                } catch (Exception e2) {
                    c.b.a.m.f.R5(bookSourceActivity, f.c0.c.j.k("readTextError:", e2.getLocalizedMessage()));
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        try {\n            uri.readText(this)?.let {\n                val dataKey = IntentDataHelp.putData(it)\n                startActivity<ImportBookSourceActivity> {\n                    putExtra(\"dataKey\", dataKey)\n                }\n            }\n        } catch (e: Exception) {\n            toastOnUi(\"readTextError:${e.localizedMessage}\")\n        }\n    }");
        this.importDoc = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.l.c.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookSourceActivity bookSourceActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = BookSourceActivity.f7306g;
                f.c0.c.j.e(bookSourceActivity, "this$0");
                if (uri == null) {
                    return;
                }
                if (c.b.a.m.f.s3(uri)) {
                    DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(bookSourceActivity, uri);
                    if (documentFileFromTreeUri == null) {
                        return;
                    }
                    BookSourceViewModel bookSourceViewModelT0 = bookSourceActivity.T0();
                    BookSourceAdapter bookSourceAdapter = bookSourceActivity.adapter;
                    if (bookSourceAdapter == null) {
                        f.c0.c.j.m("adapter");
                        throw null;
                    }
                    List<BookSource> listA = bookSourceAdapter.A();
                    Objects.requireNonNull(bookSourceViewModelT0);
                    f.c0.c.j.e(listA, "sources");
                    f.c0.c.j.e(documentFileFromTreeUri, "doc");
                    e.a.a.d.u.b bVarA = BaseViewModel.a(bookSourceViewModelT0, null, null, new o0(listA, documentFileFromTreeUri, bookSourceViewModelT0, null), 3, null);
                    bVarA.d(null, new p0(bookSourceViewModelT0, documentFileFromTreeUri, null));
                    e.a.a.d.u.b.b(bVarA, null, new q0(bookSourceViewModelT0, null), 1);
                    return;
                }
                String path = uri.getPath();
                if (path == null) {
                    return;
                }
                BookSourceViewModel bookSourceViewModelT02 = bookSourceActivity.T0();
                BookSourceAdapter bookSourceAdapter2 = bookSourceActivity.adapter;
                if (bookSourceAdapter2 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                List<BookSource> listA2 = bookSourceAdapter2.A();
                File file = new File(path);
                Objects.requireNonNull(bookSourceViewModelT02);
                f.c0.c.j.e(listA2, "sources");
                f.c0.c.j.e(file, "file");
                e.a.a.d.u.b bVarA2 = BaseViewModel.a(bookSourceViewModelT02, null, null, new l0(listA2, file, null), 3, null);
                bVarA2.d(null, new m0(bookSourceViewModelT02, file, null));
                e.a.a.d.u.b.b(bVarA2, null, new n0(bookSourceViewModelT02, null), 1);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            DocumentFile.fromTreeUri(this, uri)?.let {\n                viewModel.exportSelection(adapter.getSelection(), it)\n            }\n        } else {\n            uri.path?.let {\n                viewModel.exportSelection(adapter.getSelection(), File(it))\n            }\n        }\n    }");
        this.exportDir = activityResultLauncherRegisterForActivityResult3;
    }

    @Override // io.legado.app.ui.book.source.manage.BookSourceAdapter.a
    public void C0(@NotNull BookSource bookSource) {
        j.e(bookSource, "bookSource");
        T0().e(bookSource);
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void E0(boolean selectAll) {
        if (!selectAll) {
            BookSourceAdapter bookSourceAdapter = this.adapter;
            if (bookSourceAdapter != null) {
                bookSourceAdapter.B();
                return;
            } else {
                j.m("adapter");
                throw null;
            }
        }
        BookSourceAdapter bookSourceAdapter2 = this.adapter;
        if (bookSourceAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        Iterator it = bookSourceAdapter2.items.iterator();
        while (it.hasNext()) {
            bookSourceAdapter2.selected.add((BookSource) it.next());
        }
        bookSourceAdapter2.notifyItemRangeChanged(0, bookSourceAdapter2.getItemCount(), BundleKt.bundleOf(new f.g("selected", null)));
        bookSourceAdapter2.callBack.b();
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void I0() {
        ((i) c.b.a.m.f.h0(this, Integer.valueOf(R.string.draw), Integer.valueOf(R.string.sure_del), new d())).p();
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_book_source, (ViewGroup) null, false);
        int i2 = R.id.recycler_view;
        FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) viewInflate.findViewById(R.id.recycler_view);
        if (fastScrollRecyclerView != null) {
            i2 = R.id.select_action_bar;
            SelectActionBar selectActionBar = (SelectActionBar) viewInflate.findViewById(R.id.select_action_bar);
            if (selectActionBar != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    ActivityBookSourceBinding activityBookSourceBinding = new ActivityBookSourceBinding((LinearLayout) viewInflate, fastScrollRecyclerView, selectActionBar, titleBar);
                    j.d(activityBookSourceBinding, "inflate(layoutInflater)");
                    return activityBookSourceBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void N0() {
        String[] strArr = {"checkSource"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$1 = new EventBusExtensionsKt$observeEvent$o$1(new b());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], String.class);
            j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$1);
        }
        String[] strArr2 = {"checkSourceDone"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$12 = new EventBusExtensionsKt$observeEvent$o$1(new c());
        for (int i3 = 0; i3 < 1; i3++) {
            Observable observable2 = LiveEventBus.get(strArr2[i3], Integer.class);
            j.d(observable2, "get(tag, EVENT::class.java)");
            observable2.observe(this, eventBusExtensionsKt$observeEvent$o$12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) throws IOException {
        View viewFindViewById = ((ActivityBookSourceBinding) K0()).f6499d.findViewById(R.id.search_view);
        j.d(viewFindViewById, "binding.titleBar.findViewById(R.id.search_view)");
        this.searchView = (SearchView) viewFindViewById;
        ATH ath = ATH.a;
        ath.b(((ActivityBookSourceBinding) K0()).f6497b);
        ((ActivityBookSourceBinding) K0()).f6497b.addItemDecoration(new VerticalDivider(this));
        this.adapter = new BookSourceAdapter(this, this);
        FastScrollRecyclerView fastScrollRecyclerView = ((ActivityBookSourceBinding) K0()).f6497b;
        BookSourceAdapter bookSourceAdapter = this.adapter;
        if (bookSourceAdapter == null) {
            j.m("adapter");
            throw null;
        }
        fastScrollRecyclerView.setAdapter(bookSourceAdapter);
        BookSourceAdapter bookSourceAdapter2 = this.adapter;
        if (bookSourceAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        DragSelectTouchHelper dragSelectTouchHelper = new DragSelectTouchHelper(bookSourceAdapter2.dragSelectCallback);
        dragSelectTouchHelper.j(16, 50);
        dragSelectTouchHelper.b(((ActivityBookSourceBinding) K0()).f6497b);
        dragSelectTouchHelper.a();
        BookSourceAdapter bookSourceAdapter3 = this.adapter;
        if (bookSourceAdapter3 == null) {
            j.m("adapter");
            throw null;
        }
        ItemTouchCallback itemTouchCallback = new ItemTouchCallback(bookSourceAdapter3);
        itemTouchCallback.isCanDrag = true;
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(((ActivityBookSourceBinding) K0()).f6497b);
        SearchView searchView = this.searchView;
        if (searchView == null) {
            j.m("searchView");
            throw null;
        }
        ATH.h(ath, searchView, c.b.a.m.f.R2(this), false, 4);
        SearchView searchView2 = this.searchView;
        if (searchView2 == null) {
            j.m("searchView");
            throw null;
        }
        searchView2.onActionViewExpanded();
        SearchView searchView3 = this.searchView;
        if (searchView3 == null) {
            j.m("searchView");
            throw null;
        }
        searchView3.setQueryHint(getString(R.string.search_book_source));
        SearchView searchView4 = this.searchView;
        if (searchView4 == null) {
            j.m("searchView");
            throw null;
        }
        searchView4.clearFocus();
        SearchView searchView5 = this.searchView;
        if (searchView5 == null) {
            j.m("searchView");
            throw null;
        }
        searchView5.setOnQueryTextListener(this);
        U0(null);
        AppDatabaseKt.getAppDb().getBookSourceDao().liveGroup().observe(this, new Observer() { // from class: e.a.a.g.d.l.c.j
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookSourceActivity bookSourceActivity = this.a;
                List<String> list = (List) obj;
                int i2 = BookSourceActivity.f7306g;
                f.c0.c.j.e(bookSourceActivity, "this$0");
                bookSourceActivity.groups.clear();
                f.c0.c.j.d(list, "it");
                for (String str : list) {
                    LinkedHashSet<String> linkedHashSet = bookSourceActivity.groups;
                    e.a.a.c.d dVar = e.a.a.c.d.a;
                    c.b.a.m.f.T(linkedHashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2));
                }
                bookSourceActivity.W0();
            }
        });
        ((ActivityBookSourceBinding) K0()).f6498c.setMainActionText(R.string.delete);
        ((ActivityBookSourceBinding) K0()).f6498c.a(R.menu.book_source_sel);
        ((ActivityBookSourceBinding) K0()).f6498c.setOnMenuItemClickListener(this);
        ((ActivityBookSourceBinding) K0()).f6498c.setCallBack(this);
        if (q.a.b(1, "bookSourceHelpVersion", "firstOpenBookSources")) {
            return;
        }
        InputStream inputStreamOpen = getAssets().open("help/SourceMBookHelp.md");
        j.d(inputStreamOpen, "assets.open(\"help/SourceMBookHelp.md\")");
        String str = new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a);
        TextDialog.Companion companion = TextDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        TextDialog.Companion.a(companion, supportFragmentManager, str, 1, 0L, false, 24);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_source, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.menu_disabled_group /* 2131296815 */:
                SearchView searchView = this.searchView;
                if (searchView == null) {
                    j.m("searchView");
                    throw null;
                }
                searchView.setQuery(getString(R.string.disabled), true);
                break;
                break;
            case R.id.menu_enabled_group /* 2131296823 */:
                SearchView searchView2 = this.searchView;
                if (searchView2 == null) {
                    j.m("searchView");
                    throw null;
                }
                searchView2.setQuery(getString(R.string.enabled), true);
                break;
                break;
            case R.id.menu_group_manage /* 2131296835 */:
                new GroupManageDialog().show(getSupportFragmentManager(), "groupManage");
                break;
            case R.id.menu_share_source /* 2131296881 */:
                BookSourceViewModel bookSourceViewModelT0 = T0();
                BookSourceAdapter bookSourceAdapter = this.adapter;
                if (bookSourceAdapter == null) {
                    j.m("adapter");
                    throw null;
                }
                List<BookSource> listA = bookSourceAdapter.A();
                e eVar = new e();
                Objects.requireNonNull(bookSourceViewModelT0);
                j.e(listA, "sources");
                j.e(eVar, "success");
                e.a.a.d.u.b bVarA = BaseViewModel.a(bookSourceViewModelT0, null, null, new t0(bookSourceViewModelT0, listA, null), 3, null);
                bVarA.d(null, new u0(eVar, null));
                e.a.a.d.u.b.b(bVarA, null, new v0(bookSourceViewModelT0, null), 1);
                break;
                break;
            default:
                switch (itemId) {
                    case R.id.menu_import_local /* 2131296845 */:
                        this.importDoc.launch(new e.a.a.g.f.d(1, null, new String[]{"txt", "json"}, null, 10));
                        break;
                    case R.id.menu_import_onLine /* 2131296846 */:
                        e.a.a.h.f fVarA = f.b.a(e.a.a.h.f.a, this, null, 0L, 0, false, 14);
                        String strA = fVarA.a(this.importRecordKey);
                        List listL5 = strA == null ? null : c.b.a.m.f.L5(c.b.a.m.f.n5(strA, ","));
                        if (listL5 == null) {
                            listL5 = new ArrayList();
                        }
                        ((i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.import_on_line), null, new c0(this, listL5, fVarA), 2)).p();
                        break;
                    case R.id.menu_import_qr /* 2131296847 */:
                        this.qrResult.launch(null);
                        break;
                    default:
                        switch (itemId) {
                            case R.id.menu_sort_auto /* 2131296883 */:
                                item.setChecked(true);
                                V0(a.Weight);
                                SearchView searchView3 = this.searchView;
                                if (searchView3 == null) {
                                    j.m("searchView");
                                    throw null;
                                }
                                CharSequence query = searchView3.getQuery();
                                U0(query == null ? null : query.toString());
                                break;
                                break;
                            case R.id.menu_sort_enable /* 2131296884 */:
                                item.setChecked(true);
                                V0(a.Enable);
                                SearchView searchView4 = this.searchView;
                                if (searchView4 == null) {
                                    j.m("searchView");
                                    throw null;
                                }
                                CharSequence query2 = searchView4.getQuery();
                                U0(query2 == null ? null : query2.toString());
                                break;
                                break;
                            case R.id.menu_sort_manual /* 2131296885 */:
                                item.setChecked(true);
                                V0(a.Default);
                                SearchView searchView5 = this.searchView;
                                if (searchView5 == null) {
                                    j.m("searchView");
                                    throw null;
                                }
                                CharSequence query3 = searchView5.getQuery();
                                U0(query3 == null ? null : query3.toString());
                                break;
                                break;
                            case R.id.menu_sort_name /* 2131296886 */:
                                item.setChecked(true);
                                V0(a.Name);
                                SearchView searchView6 = this.searchView;
                                if (searchView6 == null) {
                                    j.m("searchView");
                                    throw null;
                                }
                                CharSequence query4 = searchView6.getQuery();
                                U0(query4 == null ? null : query4.toString());
                                break;
                                break;
                            case R.id.menu_sort_time /* 2131296887 */:
                                item.setChecked(true);
                                V0(a.Update);
                                SearchView searchView7 = this.searchView;
                                if (searchView7 == null) {
                                    j.m("searchView");
                                    throw null;
                                }
                                CharSequence query5 = searchView7.getQuery();
                                U0(query5 == null ? null : query5.toString());
                                break;
                                break;
                            case R.id.menu_sort_url /* 2131296888 */:
                                item.setChecked(true);
                                V0(a.Url);
                                SearchView searchView8 = this.searchView;
                                if (searchView8 == null) {
                                    j.m("searchView");
                                    throw null;
                                }
                                CharSequence query6 = searchView8.getQuery();
                                U0(query6 == null ? null : query6.toString());
                                break;
                                break;
                        }
                        break;
                }
                break;
        }
        if (item.getGroupId() == R.id.source_group) {
            SearchView searchView9 = this.searchView;
            if (searchView9 == null) {
                j.m("searchView");
                throw null;
            }
            searchView9.setQuery(j.k("group:", item.getTitle()), true);
        }
        return super.Q0(item);
    }

    @NotNull
    public BookSourceViewModel T0() {
        return (BookSourceViewModel) this.viewModel.getValue();
    }

    public final void U0(String searchKey) {
        LiveData<List<BookSource>> liveDataLiveDataSearch;
        LiveData<List<BookSource>> liveData = this.bookSourceLiveDate;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        if (searchKey == null || searchKey.length() == 0) {
            liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getBookSourceDao().liveDataAll();
        } else if (j.a(searchKey, getString(R.string.enabled))) {
            liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getBookSourceDao().liveDataEnabled();
        } else if (j.a(searchKey, getString(R.string.disabled))) {
            liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getBookSourceDao().liveDataDisabled();
        } else if (f.h0.k.K(searchKey, "group:", false, 2)) {
            String strM = f.h0.k.M(searchKey, "group:", null, 2);
            liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getBookSourceDao().liveDataGroupSearch('%' + strM + '%');
        } else {
            BookSourceDao bookSourceDao = AppDatabaseKt.getAppDb().getBookSourceDao();
            StringBuilder sb = new StringBuilder();
            sb.append('%');
            sb.append((Object) searchKey);
            sb.append('%');
            liveDataLiveDataSearch = bookSourceDao.liveDataSearch(sb.toString());
        }
        liveDataLiveDataSearch.observe(this, new Observer() { // from class: e.a.a.g.d.l.c.b
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookSourceActivity bookSourceActivity = this.a;
                List listB = (List) obj;
                int i2 = BookSourceActivity.f7306g;
                f.c0.c.j.e(bookSourceActivity, "this$0");
                if (bookSourceActivity.sortAscending) {
                    int iOrdinal = bookSourceActivity.sort.ordinal();
                    if (iOrdinal == 1) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, k.a);
                    } else if (iOrdinal == 2) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, new v());
                    } else if (iOrdinal == 3) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, new u());
                    } else if (iOrdinal == 4) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, new x());
                    } else if (iOrdinal == 5) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, h.a);
                    }
                } else {
                    int iOrdinal2 = bookSourceActivity.sort.ordinal();
                    if (iOrdinal2 == 1) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, d.a);
                    } else if (iOrdinal2 == 2) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, new z());
                    } else if (iOrdinal2 == 3) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, new y());
                    } else if (iOrdinal2 == 4) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, new w());
                    } else if (iOrdinal2 != 5) {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.z(listB);
                    } else {
                        f.c0.c.j.d(listB, "data");
                        listB = f.x.e.B(listB, i.a);
                    }
                }
                BookSourceAdapter bookSourceAdapter = bookSourceActivity.adapter;
                if (bookSourceAdapter != null) {
                    bookSourceAdapter.y(listB, new DiffUtil.ItemCallback<BookSource>() { // from class: io.legado.app.ui.book.source.manage.BookSourceAdapter$diffItemCallback$1
                        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                        public boolean areContentsTheSame(BookSource bookSource, BookSource bookSource2) {
                            BookSource bookSource3 = bookSource;
                            BookSource bookSource4 = bookSource2;
                            j.e(bookSource3, "oldItem");
                            j.e(bookSource4, "newItem");
                            return j.a(bookSource3.getBookSourceName(), bookSource4.getBookSourceName()) && j.a(bookSource3.getBookSourceGroup(), bookSource4.getBookSourceGroup()) && bookSource3.getEnabled() == bookSource4.getEnabled() && bookSource3.getEnabledExplore() == bookSource4.getEnabledExplore() && j.a(bookSource3.getExploreUrl(), bookSource4.getExploreUrl());
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                        public boolean areItemsTheSame(BookSource bookSource, BookSource bookSource2) {
                            BookSource bookSource3 = bookSource;
                            BookSource bookSource4 = bookSource2;
                            j.e(bookSource3, "oldItem");
                            j.e(bookSource4, "newItem");
                            return j.a(bookSource3.getBookSourceUrl(), bookSource4.getBookSourceUrl());
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                        public Object getChangePayload(BookSource bookSource, BookSource bookSource2) {
                            BookSource bookSource3 = bookSource;
                            BookSource bookSource4 = bookSource2;
                            j.e(bookSource3, "oldItem");
                            j.e(bookSource4, "newItem");
                            Bundle bundle = new Bundle();
                            if (!j.a(bookSource3.getBookSourceName(), bookSource4.getBookSourceName())) {
                                bundle.putString("name", bookSource4.getBookSourceName());
                            }
                            if (!j.a(bookSource3.getBookSourceGroup(), bookSource4.getBookSourceGroup())) {
                                bundle.putString("group", bookSource4.getBookSourceGroup());
                            }
                            if (bookSource3.getEnabled() != bookSource4.getEnabled()) {
                                bundle.putBoolean("enabled", bookSource4.getEnabled());
                            }
                            if (bookSource3.getEnabledExplore() != bookSource4.getEnabledExplore() || !j.a(bookSource3.getExploreUrl(), bookSource4.getExploreUrl())) {
                                bundle.putBoolean("showExplore", true);
                            }
                            if (bundle.isEmpty()) {
                                return null;
                            }
                            return bundle;
                        }
                    });
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
        this.bookSourceLiveDate = liveDataLiveDataSearch;
    }

    public final void V0(a sort) {
        if (this.sort == sort) {
            this.sortAscending = !this.sortAscending;
        } else {
            this.sortAscending = true;
            this.sort = sort;
        }
    }

    public final List<MenuItem> W0() {
        SubMenu subMenu = this.groupMenu;
        if (subMenu == null) {
            return null;
        }
        subMenu.removeGroup(R.id.source_group);
        List listB = f.x.e.B(this.groups, e.a.a.g.d.l.c.a.a);
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(listB, 10));
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(subMenu.add(R.id.source_group, 0, 0, (String) it.next()));
        }
        return arrayList;
    }

    @Override // io.legado.app.ui.book.source.manage.BookSourceAdapter.a
    public void X(@NotNull BookSource bookSource) {
        j.e(bookSource, "bookSource");
        Intent intent = new Intent(this, (Class<?>) BookSourceDebugActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("key", bookSource.getBookSourceUrl());
        startActivity(intent);
    }

    @Override // io.legado.app.ui.book.source.manage.BookSourceAdapter.a
    public void a() {
        BookSourceViewModel bookSourceViewModelT0 = T0();
        Objects.requireNonNull(bookSourceViewModelT0);
        BaseViewModel.a(bookSourceViewModelT0, null, null, new x0(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.source.manage.BookSourceAdapter.a
    public void b() {
        SelectActionBar selectActionBar = ((ActivityBookSourceBinding) K0()).f6498c;
        BookSourceAdapter bookSourceAdapter = this.adapter;
        if (bookSourceAdapter == null) {
            j.m("adapter");
            throw null;
        }
        int size = bookSourceAdapter.A().size();
        BookSourceAdapter bookSourceAdapter2 = this.adapter;
        if (bookSourceAdapter2 != null) {
            selectActionBar.b(size, bookSourceAdapter2.getItemCount());
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void f0() {
        BookSourceAdapter bookSourceAdapter = this.adapter;
        if (bookSourceAdapter != null) {
            bookSourceAdapter.B();
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // io.legado.app.base.BaseActivity, android.app.Activity
    public void finish() {
        SearchView searchView = this.searchView;
        if (searchView == null) {
            j.m("searchView");
            throw null;
        }
        CharSequence query = searchView.getQuery();
        if (query == null || query.length() == 0) {
            super.finish();
            return;
        }
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setQuery("", true);
        } else {
            j.m("searchView");
            throw null;
        }
    }

    @Override // io.legado.app.ui.book.source.manage.BookSourceAdapter.a
    public void j(@NotNull BookSource bookSource) {
        j.e(bookSource, "bookSource");
        T0().f(bookSource);
    }

    @Override // io.legado.app.ui.book.source.manage.BookSourceAdapter.a
    public void n0(@NotNull BookSource bookSource) {
        j.e(bookSource, "bookSource");
        BookSourceViewModel bookSourceViewModelT0 = T0();
        Objects.requireNonNull(bookSourceViewModelT0);
        j.e(bookSource, "bookSource");
        BaseViewModel.a(bookSourceViewModelT0, null, null, new e0(bookSource, null), 3, null);
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_enable_selection) {
            BookSourceViewModel bookSourceViewModelT0 = T0();
            BookSourceAdapter bookSourceAdapter = this.adapter;
            if (bookSourceAdapter == null) {
                j.m("adapter");
                throw null;
            }
            List<BookSource> listA = bookSourceAdapter.A();
            Objects.requireNonNull(bookSourceViewModelT0);
            j.e(listA, "sources");
            BaseViewModel.a(bookSourceViewModelT0, null, null, new k0(listA, null), 3, null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_disable_selection) {
            BookSourceViewModel bookSourceViewModelT02 = T0();
            BookSourceAdapter bookSourceAdapter2 = this.adapter;
            if (bookSourceAdapter2 == null) {
                j.m("adapter");
                throw null;
            }
            List<BookSource> listA2 = bookSourceAdapter2.A();
            Objects.requireNonNull(bookSourceViewModelT02);
            j.e(listA2, "sources");
            BaseViewModel.a(bookSourceViewModelT02, null, null, new i0(listA2, null), 3, null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_enable_explore) {
            BookSourceViewModel bookSourceViewModelT03 = T0();
            BookSourceAdapter bookSourceAdapter3 = this.adapter;
            if (bookSourceAdapter3 == null) {
                j.m("adapter");
                throw null;
            }
            List<BookSource> listA3 = bookSourceAdapter3.A();
            Objects.requireNonNull(bookSourceViewModelT03);
            j.e(listA3, "sources");
            BaseViewModel.a(bookSourceViewModelT03, null, null, new j0(listA3, null), 3, null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_disable_explore) {
            BookSourceViewModel bookSourceViewModelT04 = T0();
            BookSourceAdapter bookSourceAdapter4 = this.adapter;
            if (bookSourceAdapter4 == null) {
                j.m("adapter");
                throw null;
            }
            List<BookSource> listA4 = bookSourceAdapter4.A();
            Objects.requireNonNull(bookSourceViewModelT04);
            j.e(listA4, "sources");
            BaseViewModel.a(bookSourceViewModelT04, null, null, new h0(listA4, null), 3, null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_check_source) {
            ((i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.search_book_key), null, new t(this), 2)).p();
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_top_sel) {
            BookSourceViewModel bookSourceViewModelT05 = T0();
            BookSourceAdapter bookSourceAdapter5 = this.adapter;
            if (bookSourceAdapter5 == null) {
                j.m("adapter");
                throw null;
            }
            Object[] array = bookSourceAdapter5.A().toArray(new BookSource[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            BookSource[] bookSourceArr = (BookSource[]) array;
            bookSourceViewModelT05.f((BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length));
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_bottom_sel) {
            BookSourceViewModel bookSourceViewModelT06 = T0();
            BookSourceAdapter bookSourceAdapter6 = this.adapter;
            if (bookSourceAdapter6 == null) {
                j.m("adapter");
                throw null;
            }
            Object[] array2 = bookSourceAdapter6.A().toArray(new BookSource[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            BookSource[] bookSourceArr2 = (BookSource[]) array2;
            bookSourceViewModelT06.e((BookSource[]) Arrays.copyOf(bookSourceArr2, bookSourceArr2.length));
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_add_group) {
            ((i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.add_group), null, new a0(this), 2)).p();
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_remove_group) {
            ((i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.remove_group), null, new b0(this), 2)).p();
            return true;
        }
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_export_selection) {
            return true;
        }
        this.exportDir.launch(null);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        MenuItem menuItemFindItem;
        SubMenu subMenu;
        SubMenu subMenu2 = (menu == null || (menuItemFindItem = menu.findItem(R.id.menu_group)) == null) ? null : menuItemFindItem.getSubMenu();
        this.groupMenu = subMenu2;
        MenuItem menuItemFindItem2 = subMenu2 != null ? subMenu2.findItem(R.id.action_sort) : null;
        if (menuItemFindItem2 != null && (subMenu = menuItemFindItem2.getSubMenu()) != null) {
            subMenu.setGroupCheckable(R.id.menu_group_sort, true, true);
        }
        W0();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(@Nullable String newText) {
        if (newText == null) {
            return false;
        }
        U0(newText);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(@Nullable String query) {
        return false;
    }

    @Override // io.legado.app.ui.book.source.manage.BookSourceAdapter.a
    public void s(@NotNull BookSource bookSource) {
        j.e(bookSource, "bookSource");
    }

    @Override // io.legado.app.ui.book.source.manage.BookSourceAdapter.a
    public void update(@NotNull BookSource... bookSource) {
        j.e(bookSource, "bookSource");
        BookSourceViewModel bookSourceViewModelT0 = T0();
        BookSource[] bookSourceArr = (BookSource[]) Arrays.copyOf(bookSource, bookSource.length);
        Objects.requireNonNull(bookSourceViewModelT0);
        j.e(bookSourceArr, "bookSource");
        BaseViewModel.a(bookSourceViewModelT0, null, null, new y0(bookSourceArr, null), 3, null);
    }
}
