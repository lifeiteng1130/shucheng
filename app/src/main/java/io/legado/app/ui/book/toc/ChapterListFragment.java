package io.legado.app.ui.book.toc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.umeng.analytics.pro.ai;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.e;
import f.f0.h;
import f.v;
import io.legado.app.base.VMBaseFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.databinding.FragmentChapterListBinding;
import io.legado.app.ui.book.toc.ChapterListAdapter;
import io.legado.app.ui.book.toc.ChapterListFragment;
import io.legado.app.ui.book.toc.TocViewModel;
import io.legado.app.ui.widget.recycler.UpLinearLayoutManager;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$2;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ChapterListFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b?\u0010\rJ!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\rR\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR$\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001e\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020\u00028T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00106\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lio/legado/app/ui/book/toc/ChapterListFragment;", "Lio/legado/app/base/VMBaseFragment;", "Lio/legado/app/ui/book/toc/TocViewModel;", "Lio/legado/app/ui/book/toc/ChapterListAdapter$a;", "Lio/legado/app/ui/book/toc/TocViewModel$b;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "O", "()V", "", "newText", ai.aB, "(Ljava/lang/String;)V", "", "n", "()I", "Lio/legado/app/data/entities/BookChapter;", "bookChapter", ai.aA, "(Lio/legado/app/data/entities/BookChapter;)V", "X", "Lio/legado/app/ui/widget/recycler/UpLinearLayoutManager;", "Lio/legado/app/ui/widget/recycler/UpLinearLayoutManager;", "mLayoutManager", "Landroidx/lifecycle/LiveData;", "", "j", "Landroidx/lifecycle/LiveData;", "tocLiveData", "", "o", "()Z", "isLocalBook", "h", OptRuntime.GeneratorState.resumptionPoint_TYPE, "durChapterIndex", "e", "Lf/e;", ExifInterface.LONGITUDE_WEST, "()Lio/legado/app/ui/book/toc/TocViewModel;", "viewModel", "k", "Z", "scrollToDurChapter", "Lio/legado/app/databinding/FragmentChapterListBinding;", "f", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lio/legado/app/databinding/FragmentChapterListBinding;", "binding", "Lio/legado/app/ui/book/toc/ChapterListAdapter;", "g", "Lio/legado/app/ui/book/toc/ChapterListAdapter;", "U", "()Lio/legado/app/ui/book/toc/ChapterListAdapter;", "setAdapter", "(Lio/legado/app/ui/book/toc/ChapterListAdapter;)V", "adapter", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChapterListFragment extends VMBaseFragment<TocViewModel> implements ChapterListAdapter.a, TocViewModel.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public ChapterListAdapter adapter;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int durChapterIndex;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public UpLinearLayoutManager mLayoutManager;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<BookChapter>> tocLiveData;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean scrollToDurChapter;

    /* JADX INFO: compiled from: ChapterListFragment.kt */
    public static final class a extends k implements l<BookChapter, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(BookChapter bookChapter) {
            invoke2(bookChapter);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BookChapter bookChapter) {
            String bookUrl;
            j.e(bookChapter, "chapter");
            Book value = ChapterListFragment.this.W().bookData.getValue();
            if (value == null || (bookUrl = value.getBookUrl()) == null) {
                return;
            }
            ChapterListFragment chapterListFragment = ChapterListFragment.this;
            if (j.a(bookChapter.getBookUrl(), bookUrl)) {
                chapterListFragment.U().cacheFileNames.add(bookChapter.getFileName());
                chapterListFragment.U().notifyItemChanged(bookChapter.getIndex(), Boolean.TRUE);
            }
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
    public static final class d extends k implements l<ChapterListFragment, FragmentChapterListBinding> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentChapterListBinding invoke(@NotNull ChapterListFragment chapterListFragment) {
            j.e(chapterListFragment, "fragment");
            View viewRequireView = chapterListFragment.requireView();
            int i2 = R.id.iv_chapter_bottom;
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_chapter_bottom);
            if (appCompatImageView != null) {
                i2 = R.id.iv_chapter_top;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_chapter_top);
                if (appCompatImageView2 != null) {
                    i2 = R.id.ll_chapter_base_info;
                    LinearLayout linearLayout = (LinearLayout) viewRequireView.findViewById(R.id.ll_chapter_base_info);
                    if (linearLayout != null) {
                        i2 = R.id.recycler_view;
                        FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) viewRequireView.findViewById(R.id.recycler_view);
                        if (fastScrollRecyclerView != null) {
                            i2 = R.id.tv_current_chapter_info;
                            TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_current_chapter_info);
                            if (textView != null) {
                                return new FragmentChapterListBinding((ConstraintLayout) viewRequireView, appCompatImageView, appCompatImageView2, linearLayout, fastScrollRecyclerView, textView);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        h<Object>[] hVarArr = new h[2];
        q qVar = new q(f.c0.c.v.a(ChapterListFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentChapterListBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        hVarArr[1] = qVar;
        f7329d = hVarArr;
    }

    public ChapterListFragment() {
        super(R.layout.fragment_chapter_list);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, f.c0.c.v.a(TocViewModel.class), new b(this), new c(this));
        this.binding = f.b6(this, new d());
    }

    @Override // io.legado.app.base.BaseFragment
    public void O() {
        String[] strArr = {"saveContent"};
        EventBusExtensionsKt$observeEvent$o$2 eventBusExtensionsKt$observeEvent$o$2 = new EventBusExtensionsKt$observeEvent$o$2(new a());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], BookChapter.class);
            j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$2);
        }
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        int color;
        j.e(view, "view");
        FragmentChapterListBinding fragmentChapterListBindingV = V();
        W().chapterCallBack = this;
        j.e(this, "<this>");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = contextRequireContext.getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorBackground});
        j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
        } catch (Exception unused) {
            color = 0;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        int i2 = sharedPreferences.getInt("bottomBackground", color);
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        int iS2 = f.S2(contextRequireContext2, ((double) 1) - (((((double) Color.blue(i2)) * 0.114d) + ((((double) Color.green(i2)) * 0.587d) + (((double) Color.red(i2)) * 0.299d))) / ((double) 255)) < 0.4d);
        fragmentChapterListBindingV.f6714d.setBackgroundColor(i2);
        fragmentChapterListBindingV.f6716f.setTextColor(iS2);
        fragmentChapterListBindingV.f6713c.setColorFilter(iS2);
        fragmentChapterListBindingV.f6712b.setColorFilter(iS2);
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        ChapterListAdapter chapterListAdapter = new ChapterListAdapter(contextRequireContext3, this);
        j.e(chapterListAdapter, "<set-?>");
        this.adapter = chapterListAdapter;
        Context contextRequireContext4 = requireContext();
        j.d(contextRequireContext4, "requireContext()");
        this.mLayoutManager = new UpLinearLayoutManager(contextRequireContext4);
        FastScrollRecyclerView fastScrollRecyclerView = V().f6715e;
        UpLinearLayoutManager upLinearLayoutManager = this.mLayoutManager;
        if (upLinearLayoutManager == null) {
            j.m("mLayoutManager");
            throw null;
        }
        fastScrollRecyclerView.setLayoutManager(upLinearLayoutManager);
        FastScrollRecyclerView fastScrollRecyclerView2 = V().f6715e;
        Context contextRequireContext5 = requireContext();
        j.d(contextRequireContext5, "requireContext()");
        fastScrollRecyclerView2.addItemDecoration(new VerticalDivider(contextRequireContext5));
        V().f6715e.setAdapter(U());
        FragmentChapterListBinding fragmentChapterListBindingV2 = V();
        fragmentChapterListBindingV2.f6713c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.m.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChapterListFragment chapterListFragment = this.a;
                f.f0.h<Object>[] hVarArr = ChapterListFragment.f7329d;
                f.c0.c.j.e(chapterListFragment, "this$0");
                UpLinearLayoutManager upLinearLayoutManager2 = chapterListFragment.mLayoutManager;
                if (upLinearLayoutManager2 != null) {
                    upLinearLayoutManager2.scrollToPositionWithOffset(0, 0);
                } else {
                    f.c0.c.j.m("mLayoutManager");
                    throw null;
                }
            }
        });
        fragmentChapterListBindingV2.f6712b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.m.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChapterListFragment chapterListFragment = this.a;
                f.f0.h<Object>[] hVarArr = ChapterListFragment.f7329d;
                f.c0.c.j.e(chapterListFragment, "this$0");
                if (chapterListFragment.U().getItemCount() > 0) {
                    UpLinearLayoutManager upLinearLayoutManager2 = chapterListFragment.mLayoutManager;
                    if (upLinearLayoutManager2 != null) {
                        upLinearLayoutManager2.scrollToPositionWithOffset(chapterListFragment.U().getItemCount() - 1, 0);
                    } else {
                        f.c0.c.j.m("mLayoutManager");
                        throw null;
                    }
                }
            }
        });
        fragmentChapterListBindingV2.f6716f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.m.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChapterListFragment chapterListFragment = this.a;
                f.f0.h<Object>[] hVarArr = ChapterListFragment.f7329d;
                f.c0.c.j.e(chapterListFragment, "this$0");
                UpLinearLayoutManager upLinearLayoutManager2 = chapterListFragment.mLayoutManager;
                if (upLinearLayoutManager2 != null) {
                    upLinearLayoutManager2.scrollToPositionWithOffset(chapterListFragment.durChapterIndex, 0);
                } else {
                    f.c0.c.j.m("mLayoutManager");
                    throw null;
                }
            }
        });
        W().bookData.observe(this, new Observer() { // from class: e.a.a.g.d.m.k
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ChapterListFragment chapterListFragment = this.a;
                Book book = (Book) obj;
                f.f0.h<Object>[] hVarArr = ChapterListFragment.f7329d;
                f.c0.c.j.e(chapterListFragment, "this$0");
                f.c0.c.j.d(book, "it");
                c.b.a.m.f.L3(chapterListFragment, null, null, new p(chapterListFragment, book, null), 3, null);
            }
        });
    }

    @NotNull
    public final ChapterListAdapter U() {
        ChapterListAdapter chapterListAdapter = this.adapter;
        if (chapterListAdapter != null) {
            return chapterListAdapter;
        }
        j.m("adapter");
        throw null;
    }

    public final FragmentChapterListBinding V() {
        return (FragmentChapterListBinding) this.binding.b(this, f7329d[1]);
    }

    @NotNull
    public TocViewModel W() {
        return (TocViewModel) this.viewModel.getValue();
    }

    public final void X() {
        LiveData<List<BookChapter>> liveData = this.tocLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<BookChapter>> liveDataObserveByBook = AppDatabaseKt.getAppDb().getBookChapterDao().observeByBook(W().bookUrl);
        this.tocLiveData = liveDataObserveByBook;
        if (liveDataObserveByBook == null) {
            return;
        }
        liveDataObserveByBook.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.m.i
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ChapterListFragment chapterListFragment = this.a;
                f.f0.h<Object>[] hVarArr = ChapterListFragment.f7329d;
                f.c0.c.j.e(chapterListFragment, "this$0");
                chapterListFragment.U().x((List) obj);
                if (chapterListFragment.scrollToDurChapter) {
                    return;
                }
                UpLinearLayoutManager upLinearLayoutManager = chapterListFragment.mLayoutManager;
                if (upLinearLayoutManager == null) {
                    f.c0.c.j.m("mLayoutManager");
                    throw null;
                }
                upLinearLayoutManager.scrollToPositionWithOffset(chapterListFragment.durChapterIndex, 0);
                chapterListFragment.scrollToDurChapter = true;
            }
        });
    }

    @Override // io.legado.app.ui.book.toc.ChapterListAdapter.a
    public void i(@NotNull BookChapter bookChapter) {
        j.e(bookChapter, "bookChapter");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setResult(-1, new Intent().putExtra("index", bookChapter.getIndex()));
        activity.finish();
    }

    @Override // io.legado.app.ui.book.toc.ChapterListAdapter.a
    public int n() {
        return Math.min(this.durChapterIndex, U().getItemCount());
    }

    @Override // io.legado.app.ui.book.toc.ChapterListAdapter.a
    public boolean o() {
        Book value = W().bookData.getValue();
        return j.a(value == null ? null : Boolean.valueOf(value.isLocalBook()), Boolean.TRUE);
    }

    @Override // io.legado.app.ui.book.toc.TocViewModel.b
    public void z(@Nullable String newText) {
        if (newText == null || f.h0.k.s(newText)) {
            X();
            return;
        }
        LiveData<List<BookChapter>> liveData = this.tocLiveData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<BookChapter>> liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getBookChapterDao().liveDataSearch(W().bookUrl, newText);
        this.tocLiveData = liveDataLiveDataSearch;
        if (liveDataLiveDataSearch == null) {
            return;
        }
        liveDataLiveDataSearch.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.m.g
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ChapterListFragment chapterListFragment = this.a;
                f.f0.h<Object>[] hVarArr = ChapterListFragment.f7329d;
                f.c0.c.j.e(chapterListFragment, "this$0");
                chapterListFragment.U().x((List) obj);
            }
        });
    }
}
