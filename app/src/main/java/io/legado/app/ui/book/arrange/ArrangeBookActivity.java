package io.legado.app.ui.book.arrange;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.h;
import e.a.a.e.a.i;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.databinding.ActivityArrangeBookBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.arrange.ArrangeBookActivity;
import io.legado.app.ui.book.arrange.ArrangeBookAdapter;
import io.legado.app.ui.book.group.GroupManageDialog;
import io.legado.app.ui.book.group.GroupSelectDialog;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ArrangeBookActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\bO\u0010\u0017J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010\"\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\u0017J#\u0010)\u001a\u00020\n2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\n2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010\u0017J\u000f\u0010.\u001a\u00020\nH\u0002¢\u0006\u0004\b.\u0010\u0017R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u001e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00104R$\u0010;\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020807\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010=\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020'07\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010>R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010E\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR,\u0010L\u001a\u0012\u0012\u0004\u0012\u0002080Fj\b\u0012\u0004\u0012\u000208`G8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u001e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bM\u00104¨\u0006P"}, d2 = {"Lio/legado/app/ui/book/arrange/ArrangeBookActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityArrangeBookBinding;", "Lio/legado/app/ui/book/arrange/ArrangeBookViewModel;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lio/legado/app/ui/widget/SelectActionBar$a;", "Lio/legado/app/ui/book/arrange/ArrangeBookAdapter$a;", "Lio/legado/app/ui/book/group/GroupSelectDialog$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "onPrepareOptionsMenu", "selectAll", "E0", "(Z)V", "f0", "()V", "I0", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "onMenuItemClick", "", "requestCode", "", "groupId", "m0", "(IJ)V", "L", "o", "", "Lio/legado/app/data/entities/Book;", "book", "q", "([Lio/legado/app/data/entities/Book;)V", ai.aB, "(Lio/legado/app/data/entities/Book;)V", "U0", "V0", "Lio/legado/app/ui/book/arrange/ArrangeBookAdapter;", Constants.LANDSCAPE, "Lio/legado/app/ui/book/arrange/ArrangeBookAdapter;", "adapter", "j", OptRuntime.GeneratorState.resumptionPoint_TYPE, "groupRequestCode", "Landroidx/lifecycle/LiveData;", "", "Lio/legado/app/data/entities/BookGroup;", "m", "Landroidx/lifecycle/LiveData;", "groupLiveData", "n", "booksLiveData", "Landroid/view/Menu;", "p", "J", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/book/arrange/ArrangeBookViewModel;", "viewModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ai.aA, "Ljava/util/ArrayList;", "getGroupList", "()Ljava/util/ArrayList;", "groupList", "k", "addToGroupRequestCode", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ArrangeBookActivity extends VMBaseActivity<ActivityArrangeBookBinding, ArrangeBookViewModel> implements PopupMenu.OnMenuItemClickListener, SelectActionBar.a, ArrangeBookAdapter.a, GroupSelectDialog.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7020g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<BookGroup> groupList;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final int groupRequestCode;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final int addToGroupRequestCode;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public ArrangeBookAdapter adapter;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public LiveData<List<BookGroup>> groupLiveData;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @Nullable
    public LiveData<List<Book>> booksLiveData;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @Nullable
    public Menu menu;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public long groupId;

    /* JADX INFO: compiled from: ArrangeBookActivity.kt */
    public static final class a extends k implements l<h<? extends DialogInterface>, v> {
        public final /* synthetic */ Book $book;

        /* JADX INFO: renamed from: io.legado.app.ui.book.arrange.ArrangeBookActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ArrangeBookActivity.kt */
        public static final class C0196a extends k implements l<DialogInterface, v> {
            public final /* synthetic */ Book $book;
            public final /* synthetic */ ArrangeBookActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0196a(ArrangeBookActivity arrangeBookActivity, Book book) {
                super(1);
                this.this$0 = arrangeBookActivity;
                this.$book = book;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                this.this$0.T0().e(this.$book);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Book book) {
            super(1);
            this.$book = book;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            hVar.m(new C0196a(ArrangeBookActivity.this, this.$book));
        }
    }

    /* JADX INFO: compiled from: ArrangeBookActivity.kt */
    public static final class b extends k implements l<h<? extends DialogInterface>, v> {

        /* JADX INFO: compiled from: ArrangeBookActivity.kt */
        public static final class a extends k implements l<DialogInterface, v> {
            public final /* synthetic */ ArrangeBookActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ArrangeBookActivity arrangeBookActivity) {
                super(1);
                this.this$0 = arrangeBookActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                ArrangeBookViewModel arrangeBookViewModelT0 = this.this$0.T0();
                ArrangeBookAdapter arrangeBookAdapter = this.this$0.adapter;
                if (arrangeBookAdapter == null) {
                    j.m("adapter");
                    throw null;
                }
                Book[] bookArrA = arrangeBookAdapter.A();
                arrangeBookViewModelT0.e((Book[]) Arrays.copyOf(bookArrA, bookArrA.length));
            }
        }

        public b() {
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
            hVar.m(new a(ArrangeBookActivity.this));
            f.d4(hVar, null, 1, null);
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

    public ArrangeBookActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(ArrangeBookViewModel.class), new d(this), new c(this));
        this.groupList = new ArrayList<>();
        this.groupRequestCode = 22;
        this.addToGroupRequestCode = 34;
        this.groupId = -1L;
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void E0(boolean selectAll) {
        ArrangeBookAdapter arrangeBookAdapter = this.adapter;
        if (arrangeBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        if (selectAll) {
            Iterator it = arrangeBookAdapter.items.iterator();
            while (it.hasNext()) {
                arrangeBookAdapter.selectedBooks.add((Book) it.next());
            }
        } else {
            arrangeBookAdapter.selectedBooks.clear();
        }
        arrangeBookAdapter.notifyDataSetChanged();
        arrangeBookAdapter.callBack.o();
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void I0() {
        m0(this.groupRequestCode, 0L);
    }

    @Override // io.legado.app.ui.book.group.GroupSelectDialog.a
    public void L(int requestCode, long groupId) {
        if (requestCode == this.groupRequestCode) {
            ArrayList arrayList = new ArrayList();
            ArrangeBookAdapter arrangeBookAdapter = this.adapter;
            if (arrangeBookAdapter == null) {
                j.m("adapter");
                throw null;
            }
            for (Book book : arrangeBookAdapter.A()) {
                arrayList.add(Book.copy$default(book, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, groupId, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073725439, null));
            }
            ArrangeBookViewModel arrangeBookViewModelT0 = T0();
            Object[] array = arrayList.toArray(new Book[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Book[] bookArr = (Book[]) array;
            arrangeBookViewModelT0.g((Book[]) Arrays.copyOf(bookArr, bookArr.length));
            return;
        }
        ArrangeBookAdapter arrangeBookAdapter2 = this.adapter;
        if (arrangeBookAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        if (requestCode == arrangeBookAdapter2.groupRequestCode) {
            Book book2 = arrangeBookAdapter2.actionItem;
            if (book2 == null) {
                return;
            }
            T0().g(Book.copy$default(book2, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, groupId, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073725439, null));
            return;
        }
        if (requestCode == this.addToGroupRequestCode) {
            ArrayList arrayList2 = new ArrayList();
            ArrangeBookAdapter arrangeBookAdapter3 = this.adapter;
            if (arrangeBookAdapter3 == null) {
                j.m("adapter");
                throw null;
            }
            for (Book book3 : arrangeBookAdapter3.A()) {
                arrayList2.add(Book.copy$default(book3, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, book3.getGroup() | groupId, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073725439, null));
            }
            ArrangeBookViewModel arrangeBookViewModelT02 = T0();
            Object[] array2 = arrayList2.toArray(new Book[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            Book[] bookArr2 = (Book[]) array2;
            arrangeBookViewModelT02.g((Book[]) Arrays.copyOf(bookArr2, bookArr2.length));
        }
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_arrange_book, (ViewGroup) null, false);
        int i2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            i2 = R.id.select_action_bar;
            SelectActionBar selectActionBar = (SelectActionBar) viewInflate.findViewById(R.id.select_action_bar);
            if (selectActionBar != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    ActivityArrangeBookBinding activityArrangeBookBinding = new ActivityArrangeBookBinding((LinearLayout) viewInflate, recyclerView, selectActionBar, titleBar);
                    j.d(activityArrangeBookBinding, "inflate(layoutInflater)");
                    return activityArrangeBookBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        this.groupId = getIntent().getLongExtra("groupId", -1L);
        TitleBar titleBar = ((ActivityArrangeBookBinding) K0()).f6447d;
        String stringExtra = getIntent().getStringExtra("groupName");
        if (stringExtra == null) {
            stringExtra = getString(R.string.all);
        }
        titleBar.setSubtitle(stringExtra);
        ATH.a.b(((ActivityArrangeBookBinding) K0()).f6445b);
        ((ActivityArrangeBookBinding) K0()).f6445b.setLayoutManager(new LinearLayoutManager(this));
        ((ActivityArrangeBookBinding) K0()).f6445b.addItemDecoration(new VerticalDivider(this));
        this.adapter = new ArrangeBookAdapter(this, this);
        RecyclerView recyclerView = ((ActivityArrangeBookBinding) K0()).f6445b;
        ArrangeBookAdapter arrangeBookAdapter = this.adapter;
        if (arrangeBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerView.setAdapter(arrangeBookAdapter);
        ArrangeBookAdapter arrangeBookAdapter2 = this.adapter;
        if (arrangeBookAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        ItemTouchCallback itemTouchCallback = new ItemTouchCallback(arrangeBookAdapter2);
        itemTouchCallback.isCanDrag = f.M2(this, "bookshelfSort", 0, 2) == 3;
        ArrangeBookAdapter arrangeBookAdapter3 = this.adapter;
        if (arrangeBookAdapter3 == null) {
            j.m("adapter");
            throw null;
        }
        DragSelectTouchHelper dragSelectTouchHelper = new DragSelectTouchHelper(arrangeBookAdapter3.dragSelectCallback);
        dragSelectTouchHelper.j(16, 50);
        dragSelectTouchHelper.b(((ActivityArrangeBookBinding) K0()).f6445b);
        dragSelectTouchHelper.a();
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(((ActivityArrangeBookBinding) K0()).f6445b);
        ((ActivityArrangeBookBinding) K0()).f6446c.setMainActionText(R.string.move_to_group);
        ((ActivityArrangeBookBinding) K0()).f6446c.a(R.menu.arrange_book_sel);
        ((ActivityArrangeBookBinding) K0()).f6446c.setOnMenuItemClickListener(this);
        ((ActivityArrangeBookBinding) K0()).f6446c.setCallBack(this);
        LiveData<List<BookGroup>> liveData = this.groupLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<BookGroup>> liveDataLiveDataAll = AppDatabaseKt.getAppDb().getBookGroupDao().liveDataAll();
        this.groupLiveData = liveDataLiveDataAll;
        if (liveDataLiveDataAll != null) {
            liveDataLiveDataAll.observe(this, new Observer() { // from class: e.a.a.g.d.a.a
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    ArrangeBookActivity arrangeBookActivity = this.a;
                    int i2 = ArrangeBookActivity.f7020g;
                    f.c0.c.j.e(arrangeBookActivity, "this$0");
                    arrangeBookActivity.groupList.clear();
                    arrangeBookActivity.groupList.addAll((List) obj);
                    ArrangeBookAdapter arrangeBookAdapter4 = arrangeBookActivity.adapter;
                    if (arrangeBookAdapter4 == null) {
                        f.c0.c.j.m("adapter");
                        throw null;
                    }
                    arrangeBookAdapter4.notifyDataSetChanged();
                    arrangeBookActivity.V0();
                }
            });
        }
        U0();
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.arrange_book, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.menu_group_manage) {
            GroupManageDialog groupManageDialog = new GroupManageDialog();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            j.d(supportFragmentManager, "supportFragmentManager");
            groupManageDialog.show(supportFragmentManager, "groupManage");
        } else if (item.getGroupId() == R.id.menu_group) {
            ((ActivityArrangeBookBinding) K0()).f6447d.setSubtitle(item.getTitle());
            BookGroup byName = AppDatabaseKt.getAppDb().getBookGroupDao().getByName(item.getTitle().toString());
            this.groupId = byName == null ? 0L : byName.getGroupId();
            U0();
        }
        return super.Q0(item);
    }

    @NotNull
    public ArrangeBookViewModel T0() {
        return (ArrangeBookViewModel) this.viewModel.getValue();
    }

    public final void U0() {
        LiveData<List<Book>> liveData = this.booksLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        long j2 = this.groupId;
        LiveData<List<Book>> liveDataObserveAll = j2 == -1 ? AppDatabaseKt.getAppDb().getBookDao().observeAll() : j2 == -2 ? AppDatabaseKt.getAppDb().getBookDao().observeLocal() : j2 == -3 ? AppDatabaseKt.getAppDb().getBookDao().observeAudio() : j2 == -4 ? AppDatabaseKt.getAppDb().getBookDao().observeNoGroup() : AppDatabaseKt.getAppDb().getBookDao().observeByGroup(this.groupId);
        this.booksLiveData = liveDataObserveAll;
        if (liveDataObserveAll == null) {
            return;
        }
        liveDataObserveAll.observe(this, new Observer() { // from class: e.a.a.g.d.a.c
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                List listB;
                ArrangeBookActivity arrangeBookActivity = this.a;
                List list = (List) obj;
                int i2 = ArrangeBookActivity.f7020g;
                f.c0.c.j.e(arrangeBookActivity, "this$0");
                int iM2 = c.b.a.m.f.M2(arrangeBookActivity, "bookshelfSort", 0, 2);
                if (iM2 == 1) {
                    f.c0.c.j.d(list, "list");
                    listB = f.x.e.B(list, new i());
                } else if (iM2 == 2) {
                    f.c0.c.j.d(list, "list");
                    listB = f.x.e.B(list, b.a);
                } else if (iM2 != 3) {
                    f.c0.c.j.d(list, "list");
                    listB = f.x.e.B(list, new j());
                } else {
                    f.c0.c.j.d(list, "list");
                    listB = f.x.e.B(list, new h());
                }
                ArrangeBookAdapter arrangeBookAdapter = arrangeBookActivity.adapter;
                if (arrangeBookAdapter != null) {
                    arrangeBookAdapter.x(listB);
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
    }

    public final void V0() {
        SubMenu subMenu;
        Menu menu = this.menu;
        MenuItem menuItemFindItem = menu == null ? null : menu.findItem(R.id.menu_book_group);
        if (menuItemFindItem == null || (subMenu = menuItemFindItem.getSubMenu()) == null) {
            return;
        }
        subMenu.removeGroup(R.id.menu_group);
        for (BookGroup bookGroup : this.groupList) {
            subMenu.add(R.id.menu_group, bookGroup.getOrder(), 0, bookGroup.getGroupName());
        }
    }

    @Override // io.legado.app.ui.widget.SelectActionBar.a
    public void f0() {
        ArrangeBookAdapter arrangeBookAdapter = this.adapter;
        if (arrangeBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        for (Book book : arrangeBookAdapter.items) {
            if (arrangeBookAdapter.selectedBooks.contains(book)) {
                arrangeBookAdapter.selectedBooks.remove(book);
            } else {
                arrangeBookAdapter.selectedBooks.add(book);
            }
        }
        arrangeBookAdapter.notifyDataSetChanged();
        arrangeBookAdapter.callBack.o();
    }

    @Override // io.legado.app.ui.book.arrange.ArrangeBookAdapter.a
    public void m0(int requestCode, long groupId) {
        GroupSelectDialog.Companion companion = GroupSelectDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        companion.a(supportFragmentManager, groupId, requestCode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.arrange.ArrangeBookAdapter.a
    public void o() {
        SelectActionBar selectActionBar = ((ActivityArrangeBookBinding) K0()).f6446c;
        ArrangeBookAdapter arrangeBookAdapter = this.adapter;
        if (arrangeBookAdapter == null) {
            j.m("adapter");
            throw null;
        }
        int length = arrangeBookAdapter.A().length;
        ArrangeBookAdapter arrangeBookAdapter2 = this.adapter;
        if (arrangeBookAdapter2 != null) {
            selectActionBar.b(length, arrangeBookAdapter2.items.size());
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_del_selection) {
            ((i) f.h0(this, Integer.valueOf(R.string.draw), Integer.valueOf(R.string.sure_del), new b())).p();
        } else if (numValueOf != null && numValueOf.intValue() == R.id.menu_update_enable) {
            ArrangeBookViewModel arrangeBookViewModelT0 = T0();
            ArrangeBookAdapter arrangeBookAdapter = this.adapter;
            if (arrangeBookAdapter == null) {
                j.m("adapter");
                throw null;
            }
            arrangeBookViewModelT0.f(arrangeBookAdapter.A(), true);
        } else if (numValueOf != null && numValueOf.intValue() == R.id.menu_update_disable) {
            ArrangeBookViewModel arrangeBookViewModelT02 = T0();
            ArrangeBookAdapter arrangeBookAdapter2 = this.adapter;
            if (arrangeBookAdapter2 == null) {
                j.m("adapter");
                throw null;
            }
            arrangeBookViewModelT02.f(arrangeBookAdapter2.A(), false);
        } else if (numValueOf != null && numValueOf.intValue() == R.id.menu_add_to_group) {
            m0(this.addToGroupRequestCode, 0L);
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        this.menu = menu;
        V0();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // io.legado.app.ui.book.arrange.ArrangeBookAdapter.a
    public void q(@NotNull Book... book) {
        j.e(book, "book");
        T0().g((Book[]) Arrays.copyOf(book, book.length));
    }

    @Override // io.legado.app.ui.book.arrange.ArrangeBookAdapter.a
    public List u0() {
        return this.groupList;
    }

    @Override // io.legado.app.ui.book.arrange.ArrangeBookAdapter.a
    public void z(@NotNull Book book) {
        j.e(book, "book");
        ((i) f.h0(this, Integer.valueOf(R.string.draw), Integer.valueOf(R.string.sure_del), new a(book))).p();
    }
}
