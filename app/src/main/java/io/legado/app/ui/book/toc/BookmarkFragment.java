package io.legado.app.ui.book.toc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import e.a.a.d.u.b;
import e.a.a.e.a.i;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.e;
import f.f0.h;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.VMBaseFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.Bookmark;
import io.legado.app.databinding.DialogBookmarkBinding;
import io.legado.app.databinding.FragmentBookmarkBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.toc.BookmarkAdapter;
import io.legado.app.ui.book.toc.BookmarkFragment;
import io.legado.app.ui.book.toc.TocViewModel;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookmarkFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b-\u0010.J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100 \u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020\u00028T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lio/legado/app/ui/book/toc/BookmarkFragment;", "Lio/legado/app/base/VMBaseFragment;", "Lio/legado/app/ui/book/toc/TocViewModel;", "Lio/legado/app/ui/book/toc/BookmarkAdapter$a;", "Lio/legado/app/ui/book/toc/TocViewModel$a;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "newText", Constants.LANDSCAPE, "(Ljava/lang/String;)V", "Lio/legado/app/data/entities/Bookmark;", "bookmark", "q", "(Lio/legado/app/data/entities/Bookmark;)V", "D", "Lio/legado/app/data/entities/Book;", "book", ExifInterface.LONGITUDE_WEST, "(Lio/legado/app/data/entities/Book;)V", "Lio/legado/app/databinding/FragmentBookmarkBinding;", "f", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "U", "()Lio/legado/app/databinding/FragmentBookmarkBinding;", "binding", "Landroidx/lifecycle/LiveData;", "", "h", "Landroidx/lifecycle/LiveData;", "bookmarkLiveData", "e", "Lf/e;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lio/legado/app/ui/book/toc/TocViewModel;", "viewModel", "Lio/legado/app/ui/book/toc/BookmarkAdapter;", "g", "Lio/legado/app/ui/book/toc/BookmarkAdapter;", "adapter", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookmarkFragment extends VMBaseFragment<TocViewModel> implements BookmarkAdapter.a, TocViewModel.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public BookmarkAdapter adapter;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<Bookmark>> bookmarkLiveData;

    /* JADX INFO: compiled from: BookmarkFragment.kt */
    public static final class a extends k implements l<e.a.a.e.a.h<? extends DialogInterface>, v> {
        public final /* synthetic */ Bookmark $bookmark;
        public final /* synthetic */ BookmarkFragment this$0;

        /* JADX INFO: renamed from: io.legado.app.ui.book.toc.BookmarkFragment$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BookmarkFragment.kt */
        public static final class C0206a extends k implements f.c0.b.a<View> {
            public final /* synthetic */ DialogBookmarkBinding $alertBinding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0206a(DialogBookmarkBinding dialogBookmarkBinding) {
                super(0);
                this.$alertBinding = dialogBookmarkBinding;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // f.c0.b.a
            @NotNull
            public final View invoke() {
                ScrollView scrollView = this.$alertBinding.a;
                j.d(scrollView, "alertBinding.root");
                return scrollView;
            }
        }

        /* JADX INFO: compiled from: BookmarkFragment.kt */
        public static final class b extends k implements l<DialogInterface, v> {
            public final /* synthetic */ DialogBookmarkBinding $alertBinding;
            public final /* synthetic */ Bookmark $bookmark;

            /* JADX INFO: renamed from: io.legado.app.ui.book.toc.BookmarkFragment$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: BookmarkFragment.kt */
            @DebugMetadata(c = "io.legado.app.ui.book.toc.BookmarkFragment$onLongClick$1$2$1$1", f = "BookmarkFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0207a extends g implements p<a0, f.z.d<? super v>, Object> {
                public final /* synthetic */ Bookmark $bookmark;
                public final /* synthetic */ DialogBookmarkBinding $this_apply;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0207a(Bookmark bookmark, DialogBookmarkBinding dialogBookmarkBinding, f.z.d<? super C0207a> dVar) {
                    super(2, dVar);
                    this.$bookmark = bookmark;
                    this.$this_apply = dialogBookmarkBinding;
                }

                @Override // f.z.j.a.a
                @NotNull
                public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                    return new C0207a(this.$bookmark, this.$this_apply, dVar);
                }

                @Override // f.c0.b.p
                @Nullable
                public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                    return ((C0207a) create(a0Var, dVar)).invokeSuspend(v.a);
                }

                @Override // f.z.j.a.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f.E5(obj);
                    this.$bookmark.setBookText(String.valueOf(this.$this_apply.f6587b.getText()));
                    this.$bookmark.setContent(String.valueOf(this.$this_apply.f6588c.getText()));
                    AppDatabaseKt.getAppDb().getBookmarkDao().insert(this.$bookmark);
                    return v.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(DialogBookmarkBinding dialogBookmarkBinding, Bookmark bookmark) {
                super(1);
                this.$alertBinding = dialogBookmarkBinding;
                this.$bookmark = bookmark;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                DialogBookmarkBinding dialogBookmarkBinding = this.$alertBinding;
                b.C0148b.b(e.a.a.d.u.b.a, null, null, new C0207a(this.$bookmark, dialogBookmarkBinding, null), 3);
            }
        }

        /* JADX INFO: compiled from: BookmarkFragment.kt */
        public static final class c extends k implements l<DialogInterface, v> {
            public final /* synthetic */ Bookmark $bookmark;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Bookmark bookmark) {
                super(1);
                this.$bookmark = bookmark;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                AppDatabaseKt.getAppDb().getBookmarkDao().delete(this.$bookmark);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Bookmark bookmark, BookmarkFragment bookmarkFragment) {
            super(1);
            this.$bookmark = bookmark;
            this.this$0 = bookmarkFragment;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            hVar.h(this.$bookmark.getChapterName());
            DialogBookmarkBinding dialogBookmarkBindingA = DialogBookmarkBinding.a(this.this$0.getLayoutInflater());
            Bookmark bookmark = this.$bookmark;
            dialogBookmarkBindingA.f6587b.setText(bookmark.getBookText());
            dialogBookmarkBindingA.f6588c.setText(bookmark.getContent());
            dialogBookmarkBindingA.f6587b.setTextSize(15.0f);
            dialogBookmarkBindingA.f6588c.setTextSize(15.0f);
            dialogBookmarkBindingA.f6587b.setMaxLines(6);
            dialogBookmarkBindingA.f6588c.setMaxLines(6);
            j.d(dialogBookmarkBindingA, "inflate(layoutInflater).apply {\n                editBookText.setText(bookmark.bookText)\n                editView.setText(bookmark.content)\n                editBookText.textSize = 15f\n                editView.textSize = 15f\n                editBookText.maxLines= 6\n                editView.maxLines= 6\n            }");
            hVar.d(new C0206a(dialogBookmarkBindingA));
            hVar.i(new b(dialogBookmarkBindingA, this.$bookmark));
            f.d4(hVar, null, 1, null);
            hVar.a(R.string.delete, new c(this.$bookmark));
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class b extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            j.d(fragmentActivityRequireActivity, "requireActivity()");
            ViewModelStore viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
            j.d(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            j.d(fragmentActivityRequireActivity, "requireActivity()");
            return fragmentActivityRequireActivity.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class d extends k implements l<BookmarkFragment, FragmentBookmarkBinding> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentBookmarkBinding invoke(@NotNull BookmarkFragment bookmarkFragment) {
            j.e(bookmarkFragment, "fragment");
            View viewRequireView = bookmarkFragment.requireView();
            FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) viewRequireView.findViewById(R.id.recycler_view);
            if (fastScrollRecyclerView != null) {
                return new FragmentBookmarkBinding((ConstraintLayout) viewRequireView, fastScrollRecyclerView);
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(R.id.recycler_view)));
        }
    }

    static {
        h<Object>[] hVarArr = new h[2];
        q qVar = new q(f.c0.c.v.a(BookmarkFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentBookmarkBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        hVarArr[1] = qVar;
        f7322d = hVarArr;
    }

    public BookmarkFragment() {
        super(R.layout.fragment_bookmark);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, f.c0.c.v.a(TocViewModel.class), new b(this), new c(this));
        this.binding = f.b6(this, new d());
    }

    @Override // io.legado.app.ui.book.toc.BookmarkAdapter.a
    public void D(@NotNull Bookmark bookmark) {
        j.e(bookmark, "bookmark");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        f.J4(((i) f.j0(contextRequireContext, Integer.valueOf(R.string.bookmark), null, new a(bookmark, this), 2)).p());
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        V().bookMarkCallBack = this;
        ATH.a.b(U().f6706b);
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        this.adapter = new BookmarkAdapter(contextRequireContext, this);
        U().f6706b.setLayoutManager(new LinearLayoutManager(requireContext()));
        FastScrollRecyclerView fastScrollRecyclerView = U().f6706b;
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        fastScrollRecyclerView.addItemDecoration(new VerticalDivider(contextRequireContext2));
        FastScrollRecyclerView fastScrollRecyclerView2 = U().f6706b;
        BookmarkAdapter bookmarkAdapter = this.adapter;
        if (bookmarkAdapter == null) {
            j.m("adapter");
            throw null;
        }
        fastScrollRecyclerView2.setAdapter(bookmarkAdapter);
        V().bookData.observe(this, new Observer() { // from class: e.a.a.g.d.m.b
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookmarkFragment bookmarkFragment = this.a;
                Book book = (Book) obj;
                f.f0.h<Object>[] hVarArr = BookmarkFragment.f7322d;
                f.c0.c.j.e(bookmarkFragment, "this$0");
                f.c0.c.j.d(book, "it");
                bookmarkFragment.W(book);
            }
        });
    }

    public final FragmentBookmarkBinding U() {
        return (FragmentBookmarkBinding) this.binding.b(this, f7322d[1]);
    }

    @NotNull
    public TocViewModel V() {
        return (TocViewModel) this.viewModel.getValue();
    }

    public final void W(Book book) {
        LiveData<List<Bookmark>> liveData = this.bookmarkLiveData;
        if (liveData != null) {
            liveData.removeObservers(getViewLifecycleOwner());
        }
        LiveData<List<Bookmark>> liveDataObserveByBook = AppDatabaseKt.getAppDb().getBookmarkDao().observeByBook(book.getBookUrl(), book.getName(), book.getAuthor());
        this.bookmarkLiveData = liveDataObserveByBook;
        if (liveDataObserveByBook == null) {
            return;
        }
        liveDataObserveByBook.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.m.c
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookmarkFragment bookmarkFragment = this.a;
                List list = (List) obj;
                f.f0.h<Object>[] hVarArr = BookmarkFragment.f7322d;
                f.c0.c.j.e(bookmarkFragment, "this$0");
                BookmarkAdapter bookmarkAdapter = bookmarkFragment.adapter;
                if (bookmarkAdapter != null) {
                    bookmarkAdapter.x(list);
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
    }

    @Override // io.legado.app.ui.book.toc.TocViewModel.a
    public void l(@Nullable String newText) {
        if (newText == null || f.h0.k.s(newText)) {
            Book value = V().bookData.getValue();
            if (value == null) {
                return;
            }
            W(value);
            return;
        }
        LiveData<List<Bookmark>> liveData = this.bookmarkLiveData;
        if (liveData != null) {
            liveData.removeObservers(getViewLifecycleOwner());
        }
        LiveData<List<Bookmark>> liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getBookmarkDao().liveDataSearch(V().bookUrl, newText);
        this.bookmarkLiveData = liveDataLiveDataSearch;
        if (liveDataLiveDataSearch == null) {
            return;
        }
        liveDataLiveDataSearch.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.m.d
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookmarkFragment bookmarkFragment = this.a;
                List list = (List) obj;
                f.f0.h<Object>[] hVarArr = BookmarkFragment.f7322d;
                f.c0.c.j.e(bookmarkFragment, "this$0");
                BookmarkAdapter bookmarkAdapter = bookmarkFragment.adapter;
                if (bookmarkAdapter != null) {
                    bookmarkAdapter.x(list);
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
    }

    @Override // io.legado.app.ui.book.toc.BookmarkAdapter.a
    public void q(@NotNull Bookmark bookmark) {
        j.e(bookmark, "bookmark");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("index", bookmark.getChapterIndex());
        intent.putExtra("chapterPos", bookmark.getChapterPos());
        activity.setResult(-1, intent);
        activity.finish();
    }
}
