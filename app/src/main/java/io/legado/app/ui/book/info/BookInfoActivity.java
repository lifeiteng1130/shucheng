package io.legado.app.ui.book.info;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.h;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.analytics.pro.ai;
import e.a.a.d.n;
import e.a.a.g.d.g.d0;
import e.a.a.g.d.g.e0;
import e.a.a.g.d.g.f0;
import e.a.a.g.d.g.g0;
import e.a.a.g.d.g.h0;
import e.a.a.g.d.g.i0;
import e.a.a.g.d.g.j0;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.ActivityBookInfoBinding;
import io.legado.app.ui.audio.AudioPlayActivity;
import io.legado.app.ui.book.changecover.ChangeCoverDialog;
import io.legado.app.ui.book.changesource.ChangeSourceDialog;
import io.legado.app.ui.book.group.GroupSelectDialog;
import io.legado.app.ui.book.info.BookInfoActivity;
import io.legado.app.ui.book.info.BookInfoViewModel;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.search.SearchActivity;
import io.legado.app.ui.book.toc.TocActivityResult;
import io.legado.app.ui.widget.ArcView;
import io.legado.app.ui.widget.LabelsBar;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.ui.widget.text.AccentBgTextView;
import io.legado.app.ui.widget.text.ScrollTextView;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\bE\u0010\u0015J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u0019\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010\fJ\u0017\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\nH\u0014¢\u0006\u0004\b4\u0010\u0015R$\u0010:\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010606058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010D\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010-0-058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00109¨\u0006F"}, d2 = {"Lio/legado/app/ui/book/info/BookInfoActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityBookInfoBinding;", "Lio/legado/app/ui/book/info/BookInfoViewModel;", "Lio/legado/app/ui/book/group/GroupSelectDialog$a;", "", "Lio/legado/app/ui/book/changesource/ChangeSourceDialog$a;", "Lio/legado/app/ui/book/changecover/ChangeCoverDialog$a;", "Lio/legado/app/data/entities/Book;", "book", "Lf/v;", "W0", "(Lio/legado/app/data/entities/Book;)V", "", "isLoading", "", "Lio/legado/app/data/entities/BookChapter;", "chapterList", "Y0", "(ZLjava/util/List;)V", "Z0", "()V", "", "groupId", "X0", "(J)V", ai.aD, "V0", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "P0", "(Landroid/view/Menu;)Z", "", "featureId", "onMenuOpened", "(ILandroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "coverUrl", "o0", "(Ljava/lang/String;)V", "requestCode", "L", "(IJ)V", "onDestroy", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", ai.aA, "Landroidx/activity/result/ActivityResultLauncher;", "readBookResult", "c0", "()Lio/legado/app/data/entities/Book;", "oldBook", "j", "Lf/e;", "U0", "()Lio/legado/app/ui/book/info/BookInfoViewModel;", "viewModel", "h", "tocActivityResult", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookInfoActivity extends VMBaseActivity<ActivityBookInfoBinding, BookInfoViewModel> implements GroupSelectDialog.a, ChangeSourceDialog.a, ChangeCoverDialog.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7112g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> tocActivityResult;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> readBookResult;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: compiled from: BookInfoActivity.kt */
    public static final class a extends k implements f.c0.b.a<v> {
        public final /* synthetic */ Book $book;

        /* JADX INFO: renamed from: io.legado.app.ui.book.info.BookInfoActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BookInfoActivity.kt */
        public static final class C0197a extends k implements f.c0.b.a<v> {
            public final /* synthetic */ Book $book;
            public final /* synthetic */ BookInfoActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0197a(BookInfoActivity bookInfoActivity, Book book) {
                super(0);
                this.this$0 = bookInfoActivity;
                this.$book = book;
            }

            @Override // f.c0.b.a
            public /* bridge */ /* synthetic */ v invoke() {
                invoke2();
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BookInfoActivity.T0(this.this$0, this.$book);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Book book) {
            super(0);
            this.$book = book;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BookInfoActivity.this.U0().l(new C0197a(BookInfoActivity.this, this.$book));
        }
    }

    /* JADX INFO: compiled from: BookInfoActivity.kt */
    public static final class b extends k implements f.c0.b.a<v> {
        public final /* synthetic */ Book $book;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Book book) {
            super(0);
            this.$book = book;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BookInfoActivity.T0(BookInfoActivity.this, this.$book);
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

    /* JADX INFO: compiled from: BookInfoActivity.kt */
    public static final class e extends k implements l<String, v> {
        public e() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable String str) {
            if (!(str == null || str.length() == 0)) {
                BookInfoActivity bookInfoActivity = BookInfoActivity.this;
                int i2 = BookInfoActivity.f7112g;
                ((ActivityBookInfoBinding) bookInfoActivity.K0()).m.setText(BookInfoActivity.this.getString(R.string.group_s, new Object[]{str}));
            } else {
                BookInfoActivity bookInfoActivity2 = BookInfoActivity.this;
                int i3 = BookInfoActivity.f7112g;
                TextView textView = ((ActivityBookInfoBinding) bookInfoActivity2.K0()).m;
                BookInfoActivity bookInfoActivity3 = BookInfoActivity.this;
                textView.setText(bookInfoActivity3.getString(R.string.group_s, new Object[]{bookInfoActivity3.getString(R.string.no_group)}));
            }
        }
    }

    public BookInfoActivity() {
        super(false, null, e.a.a.c.e.Dark, false, false, 27);
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new TocActivityResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.g.l
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Book value;
                BookInfoActivity bookInfoActivity = this.a;
                f.g gVar = (f.g) obj;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                if (((gVar == null || (value = bookInfoActivity.U0().bookData.getValue()) == null) ? null : c.b.a.m.f.L3(bookInfoActivity, null, null, new a0(bookInfoActivity, value, gVar, null), 3, null)) != null || bookInfoActivity.U0().inBookshelf) {
                    return;
                }
                bookInfoActivity.U0().g(false, null);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(TocActivityResult()) {\n        it?.let {\n            viewModel.bookData.value?.let { book ->\n                launch {\n                    withContext(IO) {\n                        book.durChapterIndex = it.first\n                        book.durChapterPos = it.second\n                        appDb.bookDao.update(book)\n                    }\n                    startReadActivity(book)\n                }\n            }\n        } ?: let {\n            if (!viewModel.inBookshelf) {\n                viewModel.delBook()\n            }\n        }\n    }");
        this.tocActivityResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.g.j
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                if (((ActivityResult) obj).getResultCode() == -1) {
                    bookInfoActivity.U0().inBookshelf = true;
                    bookInfoActivity.Z0();
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(\n        ActivityResultContracts.StartActivityForResult()\n    ) {\n        if (it.resultCode == RESULT_OK) {\n            viewModel.inBookshelf = true\n            upTvBookshelf()\n        }\n    }");
        this.readBookResult = activityResultLauncherRegisterForActivityResult2;
        j.d(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.g.i
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Book book;
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                if (((ActivityResult) obj).getResultCode() == -1) {
                    BookInfoViewModel bookInfoViewModelU0 = bookInfoActivity.U0();
                    Book value = bookInfoViewModelU0.bookData.getValue();
                    if (value == null || (book = AppDatabaseKt.getAppDb().getBookDao().getBook(value.getBookUrl())) == null) {
                        return;
                    }
                    bookInfoViewModelU0.bookData.postValue(book);
                }
            }
        }), "registerForActivityResult(\n        ActivityResultContracts.StartActivityForResult()\n    ) {\n        if (it.resultCode == RESULT_OK) {\n            viewModel.upEditBook()\n        }\n    }");
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(BookInfoViewModel.class), new d(this), new c(this));
    }

    public static final void T0(BookInfoActivity bookInfoActivity, Book book) {
        Objects.requireNonNull(bookInfoActivity);
        if (book.getType() == 1) {
            bookInfoActivity.readBookResult.launch(new Intent(bookInfoActivity, (Class<?>) AudioPlayActivity.class).putExtra("bookUrl", book.getBookUrl()).putExtra("inBookshelf", bookInfoActivity.U0().inBookshelf));
        } else {
            bookInfoActivity.readBookResult.launch(new Intent(bookInfoActivity, (Class<?>) ReadBookActivity.class).putExtra("bookUrl", book.getBookUrl()).putExtra("inBookshelf", bookInfoActivity.U0().inBookshelf));
        }
    }

    @Override // io.legado.app.ui.book.group.GroupSelectDialog.a
    public void L(int requestCode, long groupId) {
        X0(groupId);
        Book value = U0().bookData.getValue();
        if (value != null) {
            value.setGroup(groupId);
        }
        if (U0().inBookshelf) {
            U0().k(null);
        }
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_book_info, (ViewGroup) null, false);
        int i2 = R.id.arc_view;
        ArcView arcView = (ArcView) viewInflate.findViewById(R.id.arc_view);
        if (arcView != null) {
            i2 = R.id.bg_book;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.bg_book);
            if (imageView != null) {
                i2 = R.id.fl_action;
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.fl_action);
                if (linearLayout != null) {
                    i2 = R.id.ic_book_last;
                    ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ic_book_last);
                    if (imageView2 != null) {
                        i2 = R.id.iv_cover;
                        CoverImageView coverImageView = (CoverImageView) viewInflate.findViewById(R.id.iv_cover);
                        if (coverImageView != null) {
                            i2 = R.id.iv_web;
                            ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.iv_web);
                            if (imageView3 != null) {
                                i2 = R.id.lb_kind;
                                LabelsBar labelsBar = (LabelsBar) viewInflate.findViewById(R.id.lb_kind);
                                if (labelsBar != null) {
                                    i2 = R.id.ll_info;
                                    LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.ll_info);
                                    if (linearLayout2 != null) {
                                        i2 = R.id.scroll_view;
                                        ScrollView scrollView = (ScrollView) viewInflate.findViewById(R.id.scroll_view);
                                        if (scrollView != null) {
                                            i2 = R.id.title_bar;
                                            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                                            if (titleBar != null) {
                                                i2 = R.id.tv_author;
                                                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_author);
                                                if (textView != null) {
                                                    i2 = R.id.tv_change_group;
                                                    AccentBgTextView accentBgTextView = (AccentBgTextView) viewInflate.findViewById(R.id.tv_change_group);
                                                    if (accentBgTextView != null) {
                                                        i2 = R.id.tv_change_source;
                                                        AccentBgTextView accentBgTextView2 = (AccentBgTextView) viewInflate.findViewById(R.id.tv_change_source);
                                                        if (accentBgTextView2 != null) {
                                                            i2 = R.id.tv_group;
                                                            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_group);
                                                            if (textView2 != null) {
                                                                i2 = R.id.tv_intro;
                                                                ScrollTextView scrollTextView = (ScrollTextView) viewInflate.findViewById(R.id.tv_intro);
                                                                if (scrollTextView != null) {
                                                                    i2 = R.id.tv_lasted;
                                                                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_lasted);
                                                                    if (textView3 != null) {
                                                                        i2 = R.id.tv_name;
                                                                        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_name);
                                                                        if (textView4 != null) {
                                                                            i2 = R.id.tv_origin;
                                                                            TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_origin);
                                                                            if (textView5 != null) {
                                                                                i2 = R.id.tv_read;
                                                                                AccentBgTextView accentBgTextView3 = (AccentBgTextView) viewInflate.findViewById(R.id.tv_read);
                                                                                if (accentBgTextView3 != null) {
                                                                                    i2 = R.id.tv_shelf;
                                                                                    TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_shelf);
                                                                                    if (textView6 != null) {
                                                                                        i2 = R.id.tv_toc;
                                                                                        TextView textView7 = (TextView) viewInflate.findViewById(R.id.tv_toc);
                                                                                        if (textView7 != null) {
                                                                                            i2 = R.id.tv_toc_view;
                                                                                            AccentBgTextView accentBgTextView4 = (AccentBgTextView) viewInflate.findViewById(R.id.tv_toc_view);
                                                                                            if (accentBgTextView4 != null) {
                                                                                                i2 = R.id.vw_bg;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.vw_bg);
                                                                                                if (linearLayout3 != null) {
                                                                                                    ActivityBookInfoBinding activityBookInfoBinding = new ActivityBookInfoBinding((ConstraintLayout) viewInflate, arcView, imageView, linearLayout, imageView2, coverImageView, imageView3, labelsBar, linearLayout2, scrollView, titleBar, textView, accentBgTextView, accentBgTextView2, textView2, scrollTextView, textView3, textView4, textView5, accentBgTextView3, textView6, textView7, accentBgTextView4, linearLayout3);
                                                                                                    j.d(activityBookInfoBinding, "inflate(layoutInflater)");
                                                                                                    return activityBookInfoBinding;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
    @SuppressLint({"PrivateResource"})
    public void O0(@Nullable Bundle savedInstanceState) {
        TitleBar titleBar = ((ActivityBookInfoBinding) K0()).f6471i;
        titleBar.setElevation(0.0f);
        titleBar.setBackgroundColor(0);
        ((ActivityBookInfoBinding) K0()).f6464b.setBgColor(f.R1(this));
        ((ActivityBookInfoBinding) K0()).f6469g.setBackgroundColor(f.R1(this));
        ((ActivityBookInfoBinding) K0()).f6470h.setBackgroundColor(f.R1(this));
        ((ActivityBookInfoBinding) K0()).f6466d.setBackgroundColor(f.T1(this));
        TextView textView = ((ActivityBookInfoBinding) K0()).s;
        int iT1 = f.T1(this);
        textView.setTextColor(f.S2(this, ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d));
        ((ActivityBookInfoBinding) K0()).t.setText(getString(R.string.toc_s, new Object[]{getString(R.string.loading)}));
        U0().bookData.observe(this, new Observer() { // from class: e.a.a.g.d.g.t
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookInfoActivity bookInfoActivity = this.a;
                Book book = (Book) obj;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                f.c0.c.j.d(book, "it");
                ActivityBookInfoBinding activityBookInfoBinding = (ActivityBookInfoBinding) bookInfoActivity.K0();
                bookInfoActivity.W0(book);
                activityBookInfoBinding.p.setText(book.getName());
                activityBookInfoBinding.f6472j.setText(bookInfoActivity.getString(R.string.author_show, new Object[]{book.getRealAuthor()}));
                activityBookInfoBinding.q.setText(bookInfoActivity.getString(R.string.origin_show, new Object[]{book.getOriginName()}));
                activityBookInfoBinding.o.setText(bookInfoActivity.getString(R.string.lasted_show, new Object[]{book.getLatestChapterTitle()}));
                activityBookInfoBinding.n.setText(book.getDisplayIntro());
                bookInfoActivity.Z0();
                List<String> kindList = book.getKindList();
                if (kindList.isEmpty()) {
                    LabelsBar labelsBar = activityBookInfoBinding.f6468f;
                    f.c0.c.j.d(labelsBar, "lbKind");
                    c.b.a.m.f.e3(labelsBar);
                } else {
                    LabelsBar labelsBar2 = activityBookInfoBinding.f6468f;
                    f.c0.c.j.d(labelsBar2, "lbKind");
                    c.b.a.m.f.c6(labelsBar2);
                    activityBookInfoBinding.f6468f.setLabels(kindList);
                }
                bookInfoActivity.X0(book.getGroup());
            }
        });
        U0().chapterListData.observe(this, new Observer() { // from class: e.a.a.g.d.g.q
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                bookInfoActivity.Y0(false, (List) obj);
            }
        });
        BookInfoViewModel bookInfoViewModelU0 = U0();
        Intent intent = getIntent();
        j.d(intent, "intent");
        Objects.requireNonNull(bookInfoViewModelU0);
        j.e(intent, "intent");
        BaseViewModel.a(bookInfoViewModelU0, null, null, new h0(intent, bookInfoViewModelU0, null), 3, null);
        ActivityBookInfoBinding activityBookInfoBinding = (ActivityBookInfoBinding) K0();
        activityBookInfoBinding.f6467e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                Book value = bookInfoActivity.U0().bookData.getValue();
                if (value == null) {
                    return;
                }
                ChangeCoverDialog.Companion companion = ChangeCoverDialog.INSTANCE;
                FragmentManager supportFragmentManager = bookInfoActivity.getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                companion.a(supportFragmentManager, value.getName(), value.getAuthor());
            }
        });
        activityBookInfoBinding.r.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                Book value = bookInfoActivity.U0().bookData.getValue();
                if (value == null) {
                    return;
                }
                bookInfoActivity.V0(value);
            }
        });
        activityBookInfoBinding.s.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                if (!bookInfoActivity.U0().inBookshelf) {
                    BookInfoViewModel bookInfoViewModelU02 = bookInfoActivity.U0();
                    y yVar = new y(bookInfoActivity);
                    Objects.requireNonNull(bookInfoViewModelU02);
                    BaseViewModel.a(bookInfoViewModelU02, null, null, new b0(bookInfoViewModelU02, null), 3, null).d(null, new c0(yVar, null));
                    return;
                }
                Book value = bookInfoActivity.U0().bookData.getValue();
                if (value == null) {
                    return;
                }
                if (value.isLocalBook()) {
                    ((e.a.a.e.a.i) c.b.a.m.f.h0(bookInfoActivity, Integer.valueOf(R.string.sure), Integer.valueOf(R.string.sure_del), new w(bookInfoActivity))).p();
                } else {
                    bookInfoActivity.U0().g(false, new x(bookInfoActivity));
                }
            }
        });
        activityBookInfoBinding.f6474l.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                Book value = bookInfoActivity.U0().bookData.getValue();
                if (value == null) {
                    return;
                }
                ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                FragmentManager supportFragmentManager = bookInfoActivity.getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                companion.a(supportFragmentManager, value.getName(), value.getAuthor());
            }
        });
        activityBookInfoBinding.u.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                if (bookInfoActivity.U0().inBookshelf) {
                    bookInfoActivity.c();
                } else {
                    bookInfoActivity.U0().k(new z(bookInfoActivity));
                }
            }
        });
        activityBookInfoBinding.f6473k.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                Book value = bookInfoActivity.U0().bookData.getValue();
                if (value == null) {
                    return;
                }
                GroupSelectDialog.Companion companion = GroupSelectDialog.INSTANCE;
                FragmentManager supportFragmentManager = bookInfoActivity.getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                companion.a(supportFragmentManager, value.getGroup(), -1);
            }
        });
        activityBookInfoBinding.f6472j.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                Intent intent2 = new Intent(bookInfoActivity, (Class<?>) SearchActivity.class);
                intent2.addFlags(268435456);
                Book value = bookInfoActivity.U0().bookData.getValue();
                intent2.putExtra("key", value == null ? null : value.getAuthor());
                bookInfoActivity.startActivity(intent2);
            }
        });
        activityBookInfoBinding.p.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoActivity bookInfoActivity = this.a;
                int i2 = BookInfoActivity.f7112g;
                f.c0.c.j.e(bookInfoActivity, "this$0");
                Intent intent2 = new Intent(bookInfoActivity, (Class<?>) SearchActivity.class);
                intent2.addFlags(268435456);
                Book value = bookInfoActivity.U0().bookData.getValue();
                intent2.putExtra("key", value == null ? null : value.getName());
                bookInfoActivity.startActivity(intent2);
            }
        });
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_info, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        String bookUrl;
        String tocUrl;
        j.e(item, "item");
        v vVar = null;
        switch (item.getItemId()) {
            case R.id.menu_clear_cache /* 2131296801 */:
                BookInfoViewModel bookInfoViewModelU0 = U0();
                Objects.requireNonNull(bookInfoViewModelU0);
                e.a.a.d.u.b bVarA = BaseViewModel.a(bookInfoViewModelU0, null, null, new e0(bookInfoViewModelU0, null), 3, null);
                bVarA.d(null, new f0(bookInfoViewModelU0, null));
                e.a.a.d.u.b.b(bVarA, null, new g0(bookInfoViewModelU0, null), 1);
                break;
            case R.id.menu_copy_book_url /* 2131296804 */:
                Book value = U0().bookData.getValue();
                if (value != null && (bookUrl = value.getBookUrl()) != null) {
                    f.c5(this, bookUrl);
                    vVar = v.a;
                }
                if (vVar == null) {
                    f.Q5(this, R.string.no_book);
                }
                break;
            case R.id.menu_copy_toc_url /* 2131296807 */:
                Book value2 = U0().bookData.getValue();
                if (value2 != null && (tocUrl = value2.getTocUrl()) != null) {
                    f.c5(this, tocUrl);
                    vVar = v.a;
                }
                if (vVar == null) {
                    f.Q5(this, R.string.no_book);
                }
                break;
            case R.id.menu_refresh /* 2131296862 */:
                Y0(true, null);
                Book value3 = U0().bookData.getValue();
                if (value3 != null) {
                    if (value3.isLocalBook()) {
                        value3.setTocUrl("");
                    }
                    U0().i(value3, false, null);
                }
                break;
            case R.id.menu_share_it /* 2131296879 */:
                Book value4 = U0().bookData.getValue();
                if (value4 != null) {
                    String string = getString(R.string.app_name);
                    j.d(string, "getString(R.string.app_name)");
                    String strO2 = f.O2(this, "appDownloadUrl", null, 2);
                    StringBuilder sbR = c.a.a.a.a.r("我正在看");
                    sbR.append(value4.getName());
                    sbR.append(" 快来");
                    sbR.append(string);
                    sbR.append("和我一起看吧,浏览器打开   ");
                    sbR.append((Object) strO2);
                    sbR.append("  下载");
                    sbR.append(string);
                    sbR.append("app");
                    String string2 = sbR.toString();
                    String string3 = getString(R.string.app_name);
                    j.d(string3, "getString(R.string.app_name)");
                    f.f5(this, string2, string3);
                }
                break;
        }
        return super.Q0(item);
    }

    @NotNull
    public BookInfoViewModel U0() {
        return (BookInfoViewModel) this.viewModel.getValue();
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceDialog.a
    public void V(@NotNull Book book) {
        j.e(book, "book");
        Y0(true, null);
        BookInfoViewModel bookInfoViewModelU0 = U0();
        Objects.requireNonNull(bookInfoViewModelU0);
        j.e(book, "newBook");
        BaseViewModel.a(bookInfoViewModelU0, null, null, new d0(book, bookInfoViewModelU0, null), 3, null);
    }

    public final void V0(Book book) {
        if (U0().inBookshelf) {
            U0().k(new b(book));
        } else {
            U0().k(new a(book));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W0(Book book) {
        ((ActivityBookInfoBinding) K0()).f6467e.b(book.getDisplayCover(), book.getName(), book.getAuthor());
        h<Drawable> hVarA = n.a(this, book.getDisplayCover());
        c.b.a.m.r.e.c cVar = new c.b.a.m.r.e.c();
        cVar.a = new c.b.a.q.k.a(TTAdConstant.STYLE_SIZE_RADIO_3_2, false);
        h<Drawable> hVarJ = hVarA.J(cVar);
        CoverImageView coverImageView = CoverImageView.a;
        Drawable drawableA = CoverImageView.a();
        j.e(this, com.umeng.analytics.pro.c.R);
        h<Drawable> hVarA2 = c.b.a.b.d(this).i().G(drawableA).a(c.b.a.q.f.y(c.b.a.m.q.k.a));
        j.d(hVarA2, "with(context).load(drawable)");
        h<Drawable> hVarA3 = hVarA2.a(c.b.a.q.f.x(new e.a.a.d.f(this, 25)));
        j.d(hVarA3, "ImageLoader.load(this, CoverImageView.defaultDrawable)\n            .apply(bitmapTransform(BlurTransformation(this, 25)))");
        hVarJ.I(hVarA3).a(c.b.a.q.f.x(new e.a.a.d.f(this, 25))).E(((ActivityBookInfoBinding) K0()).f6465c);
    }

    public final void X0(long groupId) {
        BookInfoViewModel bookInfoViewModelU0 = U0();
        e eVar = new e();
        Objects.requireNonNull(bookInfoViewModelU0);
        j.e(eVar, "success");
        BaseViewModel.a(bookInfoViewModelU0, null, null, new i0(groupId, null), 3, null).d(null, new j0(eVar, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0(boolean isLoading, List<BookChapter> chapterList) {
        if (isLoading) {
            ((ActivityBookInfoBinding) K0()).t.setText(getString(R.string.toc_s, new Object[]{getString(R.string.loading)}));
            return;
        }
        if (chapterList == null || chapterList.isEmpty()) {
            ((ActivityBookInfoBinding) K0()).t.setText(getString(R.string.toc_s, new Object[]{getString(R.string.error_load_toc)}));
            return;
        }
        Book value = U0().bookData.getValue();
        if (value == null) {
            return;
        }
        if (value.getDurChapterIndex() < chapterList.size()) {
            ((ActivityBookInfoBinding) K0()).t.setText(getString(R.string.toc_s, new Object[]{chapterList.get(value.getDurChapterIndex()).getTitle()}));
        } else {
            ((ActivityBookInfoBinding) K0()).t.setText(getString(R.string.toc_s, new Object[]{((BookChapter) f.x.e.r(chapterList)).getTitle()}));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0() {
        if (U0().inBookshelf) {
            ((ActivityBookInfoBinding) K0()).s.setText(getString(R.string.remove_from_bookshelf));
        } else {
            ((ActivityBookInfoBinding) K0()).s.setText(getString(R.string.add_to_shelf));
        }
    }

    public final void c() {
        List<BookChapter> value = U0().chapterListData.getValue();
        if (value == null || value.isEmpty()) {
            f.Q5(this, R.string.chapter_list_empty);
            return;
        }
        Book value2 = U0().bookData.getValue();
        if (value2 == null) {
            return;
        }
        this.tocActivityResult.launch(value2.getBookUrl());
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceDialog.a
    @Nullable
    /* JADX INFO: renamed from: c0 */
    public Book getOldbook() {
        return U0().bookData.getValue();
    }

    @Override // io.legado.app.ui.book.changecover.ChangeCoverDialog.a
    public void o0(@NotNull String coverUrl) {
        j.e(coverUrl, "coverUrl");
        Book value = U0().bookData.getValue();
        if (value == null) {
            return;
        }
        value.setCoverUrl(coverUrl);
        U0().k(null);
        W0(value);
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int featureId, @NotNull Menu menu) {
        j.e(menu, "menu");
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_login);
        if (menuItemFindItem != null) {
            BookSource bookSource = U0().bookSource;
            String loginUrl = bookSource == null ? null : bookSource.getLoginUrl();
            menuItemFindItem.setVisible(!(loginUrl == null || f.h0.k.s(loginUrl)));
        }
        return super.onMenuOpened(featureId, menu);
    }
}
