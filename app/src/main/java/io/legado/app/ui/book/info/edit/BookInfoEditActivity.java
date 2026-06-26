package io.legado.app.ui.book.info.edit;

import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentManager;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import e.a.a.e.c.k;
import e.a.a.g.d.g.l0.g;
import e.a.a.g.d.g.l0.h;
import e.a.a.g.d.g.l0.i;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.ActivityBookInfoEditBinding;
import io.legado.app.ui.book.changecover.ChangeCoverDialog;
import io.legado.app.ui.book.info.edit.BookInfoEditActivity;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.ui.widget.text.EditText;
import io.legado.app.ui.widget.text.StrokeTextView;
import io.legado.app.ui.widget.text.TextInputLayout;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import java.io.File;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b#\u0010\u0018J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00130\u00130\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lio/legado/app/ui/book/info/edit/BookInfoEditActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityBookInfoEditBinding;", "Lio/legado/app/ui/book/info/edit/BookInfoEditViewModel;", "Lio/legado/app/ui/book/changecover/ChangeCoverDialog$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "", "coverUrl", "o0", "(Ljava/lang/String;)V", "U0", "()V", ai.aA, "Lf/e;", "T0", "()Lio/legado/app/ui/book/info/edit/BookInfoEditViewModel;", "viewModel", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "h", "Landroidx/activity/result/ActivityResultLauncher;", "selectCoverResult", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookInfoEditActivity extends VMBaseActivity<ActivityBookInfoEditBinding, BookInfoEditViewModel> implements ChangeCoverDialog.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7121g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> selectCoverResult;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class a extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ComponentActivity componentActivity) {
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
    public static final class b extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
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

    public BookInfoEditActivity() {
        super(false, null, null, false, false, 31);
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: e.a.a.g.d.g.l0.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                String name;
                Object objM11constructorimpl;
                BookInfoEditActivity bookInfoEditActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = BookInfoEditActivity.f7121g;
                f.c0.c.j.e(bookInfoEditActivity, "this$0");
                if (uri == null) {
                    return;
                }
                if (!c.b.a.m.f.s3(uri)) {
                    k.a aVar = new k.a(bookInfoEditActivity);
                    aVar.a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
                    aVar.c(R.string.bg_image_per);
                    aVar.b(new f(bookInfoEditActivity, uri));
                    aVar.d();
                    return;
                }
                DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(bookInfoEditActivity, uri);
                if (documentFileFromSingleUri == null || (name = documentFileFromSingleUri.getName()) == null) {
                    return;
                }
                File fileA = FileUtils.a.a(c.b.a.m.f.r2(bookInfoEditActivity), "covers", name);
                try {
                    Uri uri2 = documentFileFromSingleUri.getUri();
                    f.c0.c.j.d(uri2, "doc.uri");
                    objM11constructorimpl = f.h.m11constructorimpl(e.a.a.h.j.e(bookInfoEditActivity, uri2));
                } catch (Throwable th) {
                    objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                }
                v vVar = null;
                if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                    objM11constructorimpl = null;
                }
                byte[] bArr = (byte[]) objM11constructorimpl;
                if (bArr != null) {
                    f.b0.d.e(fileA, bArr);
                    String absolutePath = fileA.getAbsolutePath();
                    f.c0.c.j.d(absolutePath, "file.absolutePath");
                    bookInfoEditActivity.o0(absolutePath);
                    vVar = v.a;
                }
                if (vVar == null) {
                    c.b.a.m.f.R5(bookInfoEditActivity, "获取文件出错");
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(ActivityResultContracts.GetContent()) {\n            it?.let { uri ->\n                coverChangeTo(uri)\n            }\n        }");
        this.selectCoverResult = activityResultLauncherRegisterForActivityResult;
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(BookInfoEditViewModel.class), new b(this), new a(this));
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_book_info_edit, (ViewGroup) null, false);
        int i2 = R.id.iv_cover;
        CoverImageView coverImageView = (CoverImageView) viewInflate.findViewById(R.id.iv_cover);
        if (coverImageView != null) {
            i2 = R.id.tie_book_author;
            EditText editText = (EditText) viewInflate.findViewById(R.id.tie_book_author);
            if (editText != null) {
                i2 = R.id.tie_book_intro;
                EditText editText2 = (EditText) viewInflate.findViewById(R.id.tie_book_intro);
                if (editText2 != null) {
                    i2 = R.id.tie_book_name;
                    EditText editText3 = (EditText) viewInflate.findViewById(R.id.tie_book_name);
                    if (editText3 != null) {
                        i2 = R.id.tie_cover_url;
                        EditText editText4 = (EditText) viewInflate.findViewById(R.id.tie_cover_url);
                        if (editText4 != null) {
                            i2 = R.id.til_book_author;
                            TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.til_book_author);
                            if (textInputLayout != null) {
                                i2 = R.id.til_book_jj;
                                TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.til_book_jj);
                                if (textInputLayout2 != null) {
                                    i2 = R.id.til_book_name;
                                    TextInputLayout textInputLayout3 = (TextInputLayout) viewInflate.findViewById(R.id.til_book_name);
                                    if (textInputLayout3 != null) {
                                        i2 = R.id.til_cover_url;
                                        TextInputLayout textInputLayout4 = (TextInputLayout) viewInflate.findViewById(R.id.til_cover_url);
                                        if (textInputLayout4 != null) {
                                            i2 = R.id.title_bar;
                                            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                                            if (titleBar != null) {
                                                i2 = R.id.tv_change_cover;
                                                StrokeTextView strokeTextView = (StrokeTextView) viewInflate.findViewById(R.id.tv_change_cover);
                                                if (strokeTextView != null) {
                                                    i2 = R.id.tv_refresh_cover;
                                                    StrokeTextView strokeTextView2 = (StrokeTextView) viewInflate.findViewById(R.id.tv_refresh_cover);
                                                    if (strokeTextView2 != null) {
                                                        i2 = R.id.tv_select_cover;
                                                        StrokeTextView strokeTextView3 = (StrokeTextView) viewInflate.findViewById(R.id.tv_select_cover);
                                                        if (strokeTextView3 != null) {
                                                            ActivityBookInfoEditBinding activityBookInfoEditBinding = new ActivityBookInfoEditBinding((LinearLayout) viewInflate, coverImageView, editText, editText2, editText3, editText4, textInputLayout, textInputLayout2, textInputLayout3, textInputLayout4, titleBar, strokeTextView, strokeTextView2, strokeTextView3);
                                                            j.d(activityBookInfoEditBinding, "inflate(layoutInflater)");
                                                            return activityBookInfoEditBinding;
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
    public void O0(@Nullable Bundle savedInstanceState) {
        String stringExtra;
        T0().bookData.observe(this, new Observer() { // from class: e.a.a.g.d.g.l0.e
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookInfoEditActivity bookInfoEditActivity = this.a;
                Book book = (Book) obj;
                int i2 = BookInfoEditActivity.f7121g;
                f.c0.c.j.e(bookInfoEditActivity, "this$0");
                f.c0.c.j.d(book, "it");
                ActivityBookInfoEditBinding activityBookInfoEditBinding = (ActivityBookInfoEditBinding) bookInfoEditActivity.K0();
                activityBookInfoEditBinding.f6478e.setText(book.getName());
                activityBookInfoEditBinding.f6476c.setText(book.getAuthor());
                activityBookInfoEditBinding.f6479f.setText(book.getDisplayCover());
                activityBookInfoEditBinding.f6477d.setText(book.getDisplayIntro());
                bookInfoEditActivity.U0();
            }
        });
        if (T0().bookData.getValue() == null && (stringExtra = getIntent().getStringExtra("bookUrl")) != null) {
            BookInfoEditViewModel bookInfoEditViewModelT0 = T0();
            Objects.requireNonNull(bookInfoEditViewModelT0);
            j.e(stringExtra, "bookUrl");
            BaseViewModel.a(bookInfoEditViewModelT0, null, null, new h(bookInfoEditViewModelT0, stringExtra, null), 3, null);
        }
        final ActivityBookInfoEditBinding activityBookInfoEditBinding = (ActivityBookInfoEditBinding) K0();
        activityBookInfoEditBinding.f6480g.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.l0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoEditActivity bookInfoEditActivity = this.a;
                int i2 = BookInfoEditActivity.f7121g;
                f.c0.c.j.e(bookInfoEditActivity, "this$0");
                Book value = bookInfoEditActivity.T0().bookData.getValue();
                if (value == null) {
                    return;
                }
                ChangeCoverDialog.Companion companion = ChangeCoverDialog.INSTANCE;
                FragmentManager supportFragmentManager = bookInfoEditActivity.getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                companion.a(supportFragmentManager, value.getName(), value.getAuthor());
            }
        });
        activityBookInfoEditBinding.f6482i.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.l0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoEditActivity bookInfoEditActivity = this.a;
                int i2 = BookInfoEditActivity.f7121g;
                f.c0.c.j.e(bookInfoEditActivity, "this$0");
                bookInfoEditActivity.selectCoverResult.launch("image/*");
            }
        });
        activityBookInfoEditBinding.f6481h.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.l0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookInfoEditActivity bookInfoEditActivity = this.a;
                ActivityBookInfoEditBinding activityBookInfoEditBinding2 = activityBookInfoEditBinding;
                int i2 = BookInfoEditActivity.f7121g;
                f.c0.c.j.e(bookInfoEditActivity, "this$0");
                f.c0.c.j.e(activityBookInfoEditBinding2, "$this_with");
                Book book = bookInfoEditActivity.T0().book;
                if (book != null) {
                    Editable text = activityBookInfoEditBinding2.f6479f.getText();
                    book.setCustomCoverUrl(text == null ? null : text.toString());
                }
                bookInfoEditActivity.U0();
            }
        });
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_info_edit, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        String string;
        String string2;
        j.e(item, "item");
        if (item.getItemId() == R.id.menu_save) {
            ActivityBookInfoEditBinding activityBookInfoEditBinding = (ActivityBookInfoEditBinding) K0();
            Book book = T0().book;
            if (book != null) {
                Editable text = activityBookInfoEditBinding.f6478e.getText();
                String str = "";
                if (text == null || (string = text.toString()) == null) {
                    string = "";
                }
                book.setName(string);
                Editable text2 = activityBookInfoEditBinding.f6476c.getText();
                if (text2 != null && (string2 = text2.toString()) != null) {
                    str = string2;
                }
                book.setAuthor(str);
                Editable text3 = activityBookInfoEditBinding.f6479f.getText();
                String string3 = text3 == null ? null : text3.toString();
                if (j.a(string3, book.getCoverUrl())) {
                    string3 = null;
                }
                book.setCustomCoverUrl(string3);
                Editable text4 = activityBookInfoEditBinding.f6477d.getText();
                book.setCustomIntro(text4 == null ? null : text4.toString());
                BookInfoEditViewModel bookInfoEditViewModelT0 = T0();
                g gVar = new g(this);
                Objects.requireNonNull(bookInfoEditViewModelT0);
                j.e(book, "book");
                BaseViewModel.a(bookInfoEditViewModelT0, null, null, new i(book, null), 3, null).d(null, new e.a.a.g.d.g.l0.j(gVar, null));
            }
        }
        return super.Q0(item);
    }

    @NotNull
    public BookInfoEditViewModel T0() {
        return (BookInfoEditViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U0() {
        Book book = T0().book;
        ((ActivityBookInfoEditBinding) K0()).f6475b.b(book == null ? null : book.getDisplayCover(), book == null ? null : book.getName(), book != null ? book.getAuthor() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.changecover.ChangeCoverDialog.a
    public void o0(@NotNull String coverUrl) {
        j.e(coverUrl, "coverUrl");
        Book book = T0().book;
        if (book != null) {
            book.setCustomCoverUrl(coverUrl);
        }
        ((ActivityBookInfoEditBinding) K0()).f6479f.setText(coverUrl);
        U0();
    }
}
