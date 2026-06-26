package io.legado.app.ui.book.source.edit;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.media.AudioAttributesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.tabs.TabLayout;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.q;
import e.a.a.e.a.i;
import e.a.a.g.d.l.b.o;
import e.a.a.h.n;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import g.b.g2.m;
import g.b.k0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.rule.BookInfoRule;
import io.legado.app.data.entities.rule.ContentRule;
import io.legado.app.data.entities.rule.ExploreRule;
import io.legado.app.data.entities.rule.SearchRule;
import io.legado.app.data.entities.rule.TocRule;
import io.legado.app.databinding.ActivityBookSourceEditBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.book.source.debug.BookSourceDebugActivity;
import io.legado.app.ui.book.source.edit.BookSourceEditActivity;
import io.legado.app.ui.book.source.edit.BookSourceEditViewModel;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.login.SourceLoginActivity;
import io.legado.app.ui.qrcode.QrCodeResult;
import io.legado.app.ui.widget.KeyboardToolPop;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.wenyuange.app.release.R;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001RB\u0007¢\u0006\u0004\bQ\u0010\u0018J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010'\u001a\u00020\u0007H\u0014¢\u0006\u0004\b'\u0010\u0018J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010\u0016R$\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00070\u00070)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R&\u00103\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R$\u00109\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u000107070)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010,R&\u0010;\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00102R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR&\u0010E\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00102R\u001d\u0010J\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR&\u0010L\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00102R&\u0010N\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u00102R&\u0010P\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u00102¨\u0006S"}, d2 = {"Lio/legado/app/ui/book/source/edit/BookSourceEditActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityBookSourceEditBinding;", "Lio/legado/app/ui/book/source/edit/BookSourceEditViewModel;", "Lio/legado/app/ui/widget/KeyboardToolPop$a;", "", "tabPosition", "Lf/v;", "Y0", "(Ljava/lang/Integer;)V", "Lio/legado/app/data/entities/BookSource;", "source", "a1", "(Lio/legado/app/data/entities/BookSource;)V", "V0", "()Lio/legado/app/data/entities/BookSource;", "", "U0", "(Lio/legado/app/data/entities/BookSource;)Z", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "X0", "(Ljava/lang/String;)V", "Z0", "()V", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "onPostCreate", "Landroid/view/Menu;", "menu", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "finish", "onDestroy", "B", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "p", "Landroidx/activity/result/ActivityResultLauncher;", "qrCodeResult", "Ljava/util/ArrayList;", "Le/a/a/g/d/l/b/o;", "Lkotlin/collections/ArrayList;", "m", "Ljava/util/ArrayList;", "infoEntities", ai.az, "Z", "mIsSoftKeyBoardShowing", "Le/a/a/g/f/d;", "q", "selectDoc", "k", "searchEntities", "Landroid/widget/PopupWindow;", "r", "Landroid/widget/PopupWindow;", "mSoftKeyboardTool", "Lio/legado/app/ui/book/source/edit/BookSourceEditAdapter;", ai.aA, "Lio/legado/app/ui/book/source/edit/BookSourceEditAdapter;", "adapter", "n", "tocEntities", "h", "Lf/e;", "W0", "()Lio/legado/app/ui/book/source/edit/BookSourceEditViewModel;", "viewModel", "o", "contentEntities", Constants.LANDSCAPE, "findEntities", "j", "sourceEntities", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookSourceEditActivity extends VMBaseActivity<ActivityBookSourceEditBinding, BookSourceEditViewModel> implements KeyboardToolPop.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7298g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final BookSourceEditAdapter adapter;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<o> sourceEntities;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<o> searchEntities;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<o> findEntities;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<o> infoEntities;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<o> tocEntities;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<o> contentEntities;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<v> qrCodeResult;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> selectDoc;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @Nullable
    public PopupWindow mSoftKeyboardTool;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public boolean mIsSoftKeyBoardShowing;

    /* JADX INFO: compiled from: BookSourceEditActivity.kt */
    public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ BookSourceEditActivity a;

        public a(BookSourceEditActivity bookSourceEditActivity) {
            j.e(bookSourceEditActivity, "this$0");
            this.a = bookSourceEditActivity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PopupWindow popupWindow;
            Rect rect = new Rect();
            this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i2 = c.b.a.m.f.V2(this.a).heightPixels;
            int i3 = i2 - rect.bottom;
            boolean z = this.a.mIsSoftKeyBoardShowing;
            if (Math.abs(i3) <= i2 / 5) {
                BookSourceEditActivity bookSourceEditActivity = this.a;
                bookSourceEditActivity.mIsSoftKeyBoardShowing = false;
                ((ActivityBookSourceEditBinding) bookSourceEditActivity.K0()).f6502d.setPadding(0, 0, 0, 0);
                if (!z || (popupWindow = this.a.mSoftKeyboardTool) == null) {
                    return;
                }
                popupWindow.dismiss();
                return;
            }
            BookSourceEditActivity bookSourceEditActivity2 = this.a;
            bookSourceEditActivity2.mIsSoftKeyBoardShowing = true;
            ((ActivityBookSourceEditBinding) bookSourceEditActivity2.K0()).f6502d.setPadding(0, 0, 0, 100);
            BookSourceEditActivity bookSourceEditActivity3 = this.a;
            PopupWindow popupWindow2 = bookSourceEditActivity3.mSoftKeyboardTool;
            if (popupWindow2 == null || popupWindow2.isShowing() || bookSourceEditActivity3.isFinishing()) {
                return;
            }
            popupWindow2.showAtLocation(((ActivityBookSourceEditBinding) bookSourceEditActivity3.K0()).a, 80, 0, 0);
        }
    }

    /* JADX INFO: compiled from: BookSourceEditActivity.kt */
    public static final class b extends k implements l<e.a.a.e.a.h<? extends DialogInterface>, v> {

        /* JADX INFO: compiled from: BookSourceEditActivity.kt */
        public static final class a extends k implements l<DialogInterface, v> {
            public final /* synthetic */ BookSourceEditActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(BookSourceEditActivity bookSourceEditActivity) {
                super(1);
                this.this$0 = bookSourceEditActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                BookSourceEditActivity.super.finish();
            }
        }

        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            hVar.g(R.string.exit_no_save);
            hVar.c(R.string.yes, null);
            hVar.e(R.string.no, new a(BookSourceEditActivity.this));
        }
    }

    /* JADX INFO: compiled from: BookSourceEditActivity.kt */
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
            BookSourceEditActivity bookSourceEditActivity = BookSourceEditActivity.this;
            int i2 = BookSourceEditActivity.f7298g;
            bookSourceEditActivity.a1(bookSourceEditActivity.W0().bookSource);
        }
    }

    /* JADX INFO: compiled from: BookSourceEditActivity.kt */
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
            BookSourceEditActivity.this.setResult(-1);
            BookSourceEditActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: BookSourceEditActivity.kt */
    public static final class e extends k implements f.c0.b.a<v> {
        public final /* synthetic */ BookSource $source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(BookSource bookSource) {
            super(0);
            this.$source = bookSource;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BookSourceEditActivity bookSourceEditActivity = BookSourceEditActivity.this;
            BookSource bookSource = this.$source;
            Intent intent = new Intent(bookSourceEditActivity, (Class<?>) BookSourceDebugActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("key", bookSource.getBookSourceUrl());
            bookSourceEditActivity.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: BookSourceEditActivity.kt */
    public static final class f extends k implements l<BookSource, v> {
        public f() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(BookSource bookSource) {
            invoke2(bookSource);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BookSource bookSource) {
            j.e(bookSource, "it");
            BookSourceEditActivity bookSourceEditActivity = BookSourceEditActivity.this;
            int i2 = BookSourceEditActivity.f7298g;
            bookSourceEditActivity.a1(bookSource);
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class g extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
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
    public static final class h extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
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

    public BookSourceEditActivity() {
        super(false, null, null, false, false, 30);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(BookSourceEditViewModel.class), new h(this), new g(this));
        this.adapter = new BookSourceEditAdapter();
        this.sourceEntities = new ArrayList<>();
        this.searchEntities = new ArrayList<>();
        this.findEntities = new ArrayList<>();
        this.infoEntities = new ArrayList<>();
        this.tocEntities = new ArrayList<>();
        this.contentEntities = new ArrayList<>();
        ActivityResultLauncher<v> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new QrCodeResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.l.b.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookSourceEditActivity bookSourceEditActivity = this.a;
                String str = (String) obj;
                int i2 = BookSourceEditActivity.f7298g;
                f.c0.c.j.e(bookSourceEditActivity, "this$0");
                if (str == null) {
                    return;
                }
                BookSourceEditViewModel bookSourceEditViewModelW0 = bookSourceEditActivity.W0();
                d dVar = new d(bookSourceEditActivity);
                Objects.requireNonNull(bookSourceEditViewModelW0);
                f.c0.c.j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                f.c0.c.j.e(dVar, "finally");
                e.a.a.d.u.b.b(BaseViewModel.a(bookSourceEditViewModelW0, null, null, new h(str, dVar, null), 3, null), null, new i(bookSourceEditViewModelW0, null), 1);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(QrCodeResult()) {\n        it ?: return@registerForActivityResult\n        viewModel.importSource(it) { source ->\n            upRecyclerView(source)\n        }\n    }");
        this.qrCodeResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.l.b.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookSourceEditActivity bookSourceEditActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = BookSourceEditActivity.f7298g;
                f.c0.c.j.e(bookSourceEditActivity, "this$0");
                if (uri == null) {
                    return;
                }
                if (!c.b.a.m.f.s3(uri)) {
                    bookSourceEditActivity.B(String.valueOf(uri.getPath()));
                    return;
                }
                String string = uri.toString();
                f.c0.c.j.d(string, "uri.toString()");
                bookSourceEditActivity.B(string);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            sendText(uri.toString())\n        } else {\n            sendText(uri.path.toString())\n        }\n    }");
        this.selectDoc = activityResultLauncherRegisterForActivityResult2;
    }

    @Override // io.legado.app.ui.widget.KeyboardToolPop.a
    public void B(@NotNull String text) {
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        e.a.a.c.c cVar = e.a.a.c.c.a;
        if (!j.a(text, e.a.a.c.c.b().get(0))) {
            X0(text);
        } else {
            c.b.a.m.f.Z4(this, getString(R.string.help), f.x.e.a("插入URL参数", "书源教程", "正则教程", "选择文件"), new e.a.a.g.d.l.b.e(this));
        }
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_book_source_edit, (ViewGroup) null, false);
        int i2 = R.id.cb_is_enable;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_is_enable);
        if (aTECheckBox != null) {
            i2 = R.id.cb_is_enable_find;
            ATECheckBox aTECheckBox2 = (ATECheckBox) viewInflate.findViewById(R.id.cb_is_enable_find);
            if (aTECheckBox2 != null) {
                i2 = R.id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
                if (recyclerView != null) {
                    i2 = R.id.sp_type;
                    AppCompatSpinner appCompatSpinner = (AppCompatSpinner) viewInflate.findViewById(R.id.sp_type);
                    if (appCompatSpinner != null) {
                        i2 = R.id.tab_layout;
                        TabLayout tabLayout = (TabLayout) viewInflate.findViewById(R.id.tab_layout);
                        if (tabLayout != null) {
                            i2 = R.id.title_bar;
                            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                            if (titleBar != null) {
                                ActivityBookSourceEditBinding activityBookSourceEditBinding = new ActivityBookSourceEditBinding((LinearLayout) viewInflate, aTECheckBox, aTECheckBox2, recyclerView, appCompatSpinner, tabLayout, titleBar);
                                j.d(activityBookSourceEditBinding, "inflate(layoutInflater)");
                                return activityBookSourceEditBinding;
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
        ATH.a.b(((ActivityBookSourceEditBinding) K0()).f6502d);
        e.a.a.c.c cVar = e.a.a.c.c.a;
        this.mSoftKeyboardTool = new KeyboardToolPop(this, e.a.a.c.c.b(), this);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        ((ActivityBookSourceEditBinding) K0()).f6502d.setLayoutManager(new LinearLayoutManager(this));
        ((ActivityBookSourceEditBinding) K0()).f6502d.setAdapter(this.adapter);
        ((ActivityBookSourceEditBinding) K0()).f6504f.setBackgroundColor(c.b.a.m.f.R1(this));
        ((ActivityBookSourceEditBinding) K0()).f6504f.addOnTabSelectedListener((TabLayout.d) new e.a.a.g.d.l.b.c(this));
        BookSourceEditViewModel bookSourceEditViewModelW0 = W0();
        Intent intent = getIntent();
        j.d(intent, "intent");
        c cVar2 = new c();
        Objects.requireNonNull(bookSourceEditViewModelW0);
        j.e(intent, "intent");
        j.e(cVar2, "onFinally");
        e.a.a.d.u.b.c(BaseViewModel.a(bookSourceEditViewModelW0, null, null, new e.a.a.g.d.l.b.j(intent, bookSourceEditViewModelW0, null), 3, null), null, new e.a.a.g.d.l.b.k(cVar2, null), 1);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.source_edit, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        boolean z = true;
        switch (item.getItemId()) {
            case R.id.menu_copy_source /* 2131296805 */:
                String json = n.a().toJson(V0());
                j.d(json, "GSON.toJson(getSource())");
                c.b.a.m.f.c5(this, json);
                break;
            case R.id.menu_debug_source /* 2131296808 */:
                BookSource bookSourceV0 = V0();
                if (U0(bookSourceV0)) {
                    W0().e(bookSourceV0, new e(bookSourceV0));
                }
                break;
            case R.id.menu_login /* 2131296852 */:
                BookSource bookSourceV02 = V0();
                if (U0(bookSourceV02)) {
                    String loginUrl = bookSourceV02.getLoginUrl();
                    if (loginUrl != null && loginUrl.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        Intent intent = new Intent(this, (Class<?>) SourceLoginActivity.class);
                        intent.addFlags(268435456);
                        intent.putExtra("sourceUrl", bookSourceV02.getBookSourceUrl());
                        intent.putExtra("loginUrl", bookSourceV02.getLoginUrl());
                        intent.putExtra(TTDownloadField.TT_USERAGENT, bookSourceV02.getHeaderMap().get("User-Agent"));
                        startActivity(intent);
                    } else {
                        c.b.a.m.f.Q5(this, R.string.source_no_login);
                    }
                }
                break;
            case R.id.menu_paste_source /* 2131296858 */:
                BookSourceEditViewModel bookSourceEditViewModelW0 = W0();
                f fVar = new f();
                Objects.requireNonNull(bookSourceEditViewModelW0);
                j.e(fVar, "onSuccess");
                k0 k0Var = k0.f6264c;
                e.a.a.d.u.b bVarA = BaseViewModel.a(bookSourceEditViewModelW0, null, m.f6207b, new e.a.a.g.d.l.b.l(bookSourceEditViewModelW0, null), 1, null);
                e.a.a.d.u.b.b(bVarA, null, new e.a.a.g.d.l.b.m(bookSourceEditViewModelW0, null), 1);
                bVarA.d(null, new e.a.a.g.d.l.b.n(fVar, bookSourceEditViewModelW0, null));
                break;
            case R.id.menu_qr_code_camera /* 2131296860 */:
                this.qrCodeResult.launch(null);
                break;
            case R.id.menu_save /* 2131296870 */:
                BookSource bookSourceV03 = V0();
                BookSource bookSource = W0().bookSource;
                if (bookSource == null) {
                    bookSource = new BookSource(null, null, null, 0, null, 0, false, false, null, null, null, 0L, 0, null, null, null, null, null, null, null, 1048575, null);
                }
                if (!bookSourceV03.equal(bookSource)) {
                    bookSourceV03.setLastUpdateTime(System.currentTimeMillis());
                }
                if (U0(bookSourceV03)) {
                    W0().e(bookSourceV03, new d());
                }
                break;
            case R.id.menu_share_qr /* 2131296880 */:
                String json2 = n.a().toJson(V0());
                j.d(json2, "GSON.toJson(getSource())");
                String string = getString(R.string.share_book_source);
                j.d(string, "getString(R.string.share_book_source)");
                c.b.a.m.f.h5(this, json2, string);
                break;
            case R.id.menu_share_str /* 2131296882 */:
                String json3 = n.a().toJson(V0());
                j.d(json3, "GSON.toJson(getSource())");
                c.b.a.m.f.g5(this, json3, null, 2);
                break;
        }
        return super.Q0(item);
    }

    public final boolean U0(BookSource source) {
        if (!f.h0.k.s(source.getBookSourceUrl()) && !f.h0.k.s(source.getBookSourceName())) {
            return true;
        }
        c.b.a.m.f.Q5(this, R.string.non_null_name_url);
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final BookSource V0() {
        ContentRule contentRule;
        TocRule tocRule;
        BookInfoRule bookInfoRule;
        Iterator it;
        String str;
        BookSource bookSource = W0().bookSource;
        BookSource bookSourceCopy = bookSource == null ? null : bookSource.copy((1048575 & 1) != 0 ? bookSource.bookSourceName : null, (1048575 & 2) != 0 ? bookSource.bookSourceGroup : null, (1048575 & 4) != 0 ? bookSource.bookSourceUrl : null, (1048575 & 8) != 0 ? bookSource.bookSourceType : 0, (1048575 & 16) != 0 ? bookSource.bookUrlPattern : null, (1048575 & 32) != 0 ? bookSource.customOrder : 0, (1048575 & 64) != 0 ? bookSource.enabled : false, (1048575 & 128) != 0 ? bookSource.enabledExplore : false, (1048575 & 256) != 0 ? bookSource.header : null, (1048575 & 512) != 0 ? bookSource.loginUrl : null, (1048575 & 1024) != 0 ? bookSource.bookSourceComment : null, (1048575 & 2048) != 0 ? bookSource.lastUpdateTime : 0L, (1048575 & 4096) != 0 ? bookSource.weight : 0, (1048575 & 8192) != 0 ? bookSource.exploreUrl : null, (1048575 & 16384) != 0 ? bookSource.ruleExplore : null, (1048575 & 32768) != 0 ? bookSource.searchUrl : null, (1048575 & 65536) != 0 ? bookSource.ruleSearch : null, (1048575 & 131072) != 0 ? bookSource.ruleBookInfo : null, (1048575 & 262144) != 0 ? bookSource.ruleToc : null, (1048575 & 524288) != 0 ? bookSource.ruleContent : null);
        if (bookSourceCopy == null) {
            bookSourceCopy = new BookSource(null, null, null, 0, null, 0, false, false, null, null, null, 0L, 0, null, null, null, null, null, null, null, 1048575, null);
        }
        bookSourceCopy.setEnabled(((ActivityBookSourceEditBinding) K0()).f6500b.isChecked());
        bookSourceCopy.setEnabledExplore(((ActivityBookSourceEditBinding) K0()).f6501c.isChecked());
        bookSourceCopy.setBookSourceType(((ActivityBookSourceEditBinding) K0()).f6503e.getSelectedItemPosition());
        SearchRule searchRule = new SearchRule(null, null, null, null, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null);
        ExploreRule exploreRule = new ExploreRule(null, null, null, null, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null);
        BookInfoRule bookInfoRule2 = new BookInfoRule(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        TocRule tocRule2 = new TocRule(null, null, null, null, null, null, 63, null);
        ContentRule contentRule2 = new ContentRule(null, null, null, null, null, null, 63, null);
        for (o oVar : this.sourceEntities) {
            String str2 = oVar.a;
            switch (str2.hashCode()) {
                case -1656694038:
                    if (str2.equals("bookUrlPattern")) {
                        bookSourceCopy.setBookUrlPattern(oVar.f5820b);
                    }
                    break;
                case -1478223601:
                    if (str2.equals("bookSourceName")) {
                        String str3 = oVar.f5820b;
                        bookSourceCopy.setBookSourceName(str3 != null ? str3 : "");
                    }
                    break;
                case -1221270899:
                    if (str2.equals("header")) {
                        bookSourceCopy.setHeader(oVar.f5820b);
                    }
                    break;
                case 1413752955:
                    if (str2.equals("bookSourceGroup")) {
                        bookSourceCopy.setBookSourceGroup(oVar.f5820b);
                    }
                    break;
                case 1614890603:
                    if (str2.equals("bookSourceUrl")) {
                        String str4 = oVar.f5820b;
                        bookSourceCopy.setBookSourceUrl(str4 != null ? str4 : "");
                    }
                    break;
                case 2022750534:
                    if (str2.equals("loginUrl")) {
                        bookSourceCopy.setLoginUrl(oVar.f5820b);
                    }
                    break;
                case 2063896923:
                    if (str2.equals("bookSourceComment")) {
                        String str5 = oVar.f5820b;
                        bookSourceCopy.setBookSourceComment(str5 != null ? str5 : "");
                    }
                    break;
            }
        }
        Iterator it2 = this.searchEntities.iterator();
        while (true) {
            String str6 = "bookList";
            ContentRule contentRule3 = contentRule2;
            TocRule tocRule3 = tocRule2;
            BookInfoRule bookInfoRule3 = bookInfoRule2;
            if (!it2.hasNext()) {
                Iterator it3 = this.findEntities.iterator();
                while (it3.hasNext()) {
                    o oVar2 = (o) it3.next();
                    Iterator it4 = it3;
                    String str7 = oVar2.a;
                    switch (str7.hashCode()) {
                        case -1671787305:
                            str = str6;
                            if (str7.equals("lastChapter")) {
                                exploreRule.setLastChapter(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case -1406328437:
                            str = str6;
                            if (str7.equals("author")) {
                                exploreRule.setAuthor(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case -351778248:
                            str = str6;
                            if (str7.equals("coverUrl")) {
                                exploreRule.setCoverUrl(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case -295931082:
                            str = str6;
                            if (str7.equals("updateTime")) {
                                exploreRule.setUpdateTime(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case 3292052:
                            str = str6;
                            if (str7.equals("kind")) {
                                exploreRule.setKind(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case 3373707:
                            str = str6;
                            if (str7.equals("name")) {
                                exploreRule.setName(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case 64667078:
                            str = str6;
                            if (str7.equals("bookUrl")) {
                                exploreRule.setBookUrl(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case 100361836:
                            str = str6;
                            if (str7.equals("intro")) {
                                exploreRule.setIntro(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case 864120869:
                            str = str6;
                            if (str7.equals("wordCount")) {
                                exploreRule.setWordCount(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case 1754392028:
                            str = str6;
                            if (str7.equals("exploreUrl")) {
                                bookSourceCopy.setExploreUrl(oVar2.f5820b);
                                continue;
                            }
                            it3 = it4;
                            str6 = str;
                            break;
                        case 2004402983:
                            if (str7.equals(str6)) {
                                exploreRule.setBookList(oVar2.f5820b);
                            }
                            break;
                    }
                    str = str6;
                    it3 = it4;
                    str6 = str;
                }
                Iterator it5 = this.infoEntities.iterator();
                while (it5.hasNext()) {
                    o oVar3 = (o) it5.next();
                    String str8 = oVar3.a;
                    switch (str8.hashCode()) {
                        case -1671787305:
                            bookInfoRule = bookInfoRule3;
                            it = it5;
                            if (str8.equals("lastChapter")) {
                                bookInfoRule.setLastChapter(oVar3.f5820b);
                            }
                            break;
                        case -1406328437:
                            bookInfoRule = bookInfoRule3;
                            it = it5;
                            if (str8.equals("author")) {
                                bookInfoRule.setAuthor(oVar3.f5820b);
                            }
                            break;
                        case -868440313:
                            bookInfoRule = bookInfoRule3;
                            it = it5;
                            if (str8.equals("tocUrl")) {
                                bookInfoRule.setTocUrl(oVar3.f5820b);
                            }
                            break;
                        case -351778248:
                            bookInfoRule = bookInfoRule3;
                            it = it5;
                            if (str8.equals("coverUrl")) {
                                bookInfoRule.setCoverUrl(oVar3.f5820b);
                            }
                            break;
                        case -295931082:
                            bookInfoRule = bookInfoRule3;
                            it = it5;
                            if (str8.equals("updateTime")) {
                                bookInfoRule.setUpdateTime(oVar3.f5820b);
                            }
                            break;
                        case -11011250:
                            bookInfoRule = bookInfoRule3;
                            it = it5;
                            if (str8.equals("canReName")) {
                                bookInfoRule.setCanReName(oVar3.f5820b);
                            }
                            break;
                        case 3237136:
                            bookInfoRule = bookInfoRule3;
                            it = it5;
                            if (str8.equals("init")) {
                                bookInfoRule.setInit(oVar3.f5820b);
                            }
                            break;
                        case 3292052:
                            bookInfoRule = bookInfoRule3;
                            if (str8.equals("kind")) {
                                bookInfoRule.setKind(oVar3.f5820b);
                            }
                            it = it5;
                            break;
                        case 3373707:
                            bookInfoRule = bookInfoRule3;
                            if (str8.equals("name")) {
                                bookInfoRule.setName(oVar3.f5820b);
                            }
                            it = it5;
                            break;
                        case 100361836:
                            bookInfoRule = bookInfoRule3;
                            if (str8.equals("intro")) {
                                bookInfoRule.setIntro(oVar3.f5820b);
                            }
                            it = it5;
                            break;
                        case 864120869:
                            if (str8.equals("wordCount")) {
                                bookInfoRule = bookInfoRule3;
                                bookInfoRule.setWordCount(oVar3.f5820b);
                            }
                            it = it5;
                        default:
                            bookInfoRule = bookInfoRule3;
                            it = it5;
                            break;
                    }
                    it5 = it;
                    bookInfoRule3 = bookInfoRule;
                }
                BookInfoRule bookInfoRule4 = bookInfoRule3;
                for (o oVar4 : this.tocEntities) {
                    String str9 = oVar4.a;
                    switch (str9.hashCode()) {
                        case -1240474662:
                            tocRule = tocRule3;
                            if (str9.equals("nextTocUrl")) {
                                tocRule.setNextTocUrl(oVar4.f5820b);
                                continue;
                            }
                            tocRule3 = tocRule;
                            break;
                        case -295931082:
                            tocRule = tocRule3;
                            if (str9.equals("updateTime")) {
                                tocRule.setUpdateTime(oVar4.f5820b);
                                continue;
                            }
                            tocRule3 = tocRule;
                            break;
                        case 16142818:
                            tocRule = tocRule3;
                            if (str9.equals("chapterUrl")) {
                                tocRule.setChapterUrl(oVar4.f5820b);
                                continue;
                            }
                            tocRule3 = tocRule;
                            break;
                        case 100481683:
                            tocRule = tocRule3;
                            if (str9.equals("isVip")) {
                                tocRule.setVip(oVar4.f5820b);
                                continue;
                            }
                            tocRule3 = tocRule;
                            break;
                        case 500150923:
                            tocRule = tocRule3;
                            if (str9.equals("chapterList")) {
                                tocRule.setChapterList(oVar4.f5820b);
                                continue;
                            }
                            tocRule3 = tocRule;
                            break;
                        case 500202616:
                            if (str9.equals("chapterName")) {
                                tocRule = tocRule3;
                                tocRule.setChapterName(oVar4.f5820b);
                            }
                            tocRule3 = tocRule;
                            break;
                    }
                    tocRule = tocRule3;
                    tocRule3 = tocRule;
                }
                TocRule tocRule4 = tocRule3;
                for (o oVar5 : this.contentEntities) {
                    String str10 = oVar5.a;
                    switch (str10.hashCode()) {
                        case -1453841130:
                            contentRule = contentRule3;
                            if (str10.equals("imageStyle")) {
                                contentRule.setImageStyle(oVar5.f5820b);
                                continue;
                            }
                            contentRule3 = contentRule;
                            break;
                        case -1065669239:
                            contentRule = contentRule3;
                            if (str10.equals("nextContentUrl")) {
                                contentRule.setNextContentUrl(oVar5.f5820b);
                                continue;
                            }
                            contentRule3 = contentRule;
                            break;
                        case -97095444:
                            contentRule = contentRule3;
                            if (str10.equals("sourceRegex")) {
                                contentRule.setSourceRegex(oVar5.f5820b);
                                continue;
                            }
                            contentRule3 = contentRule;
                            break;
                        case 113004477:
                            contentRule = contentRule3;
                            if (str10.equals("webJs")) {
                                contentRule.setWebJs(oVar5.f5820b);
                                continue;
                            }
                            contentRule3 = contentRule;
                            break;
                        case 448650739:
                            contentRule = contentRule3;
                            if (str10.equals("replaceRegex")) {
                                contentRule.setReplaceRegex(oVar5.f5820b);
                                continue;
                            }
                            contentRule3 = contentRule;
                            break;
                        case 951530617:
                            if (str10.equals("content")) {
                                contentRule = contentRule3;
                                contentRule.setContent(oVar5.f5820b);
                            }
                            contentRule3 = contentRule;
                            break;
                    }
                    contentRule = contentRule3;
                    contentRule3 = contentRule;
                }
                bookSourceCopy.setRuleSearch(searchRule);
                bookSourceCopy.setRuleExplore(exploreRule);
                bookSourceCopy.setRuleBookInfo(bookInfoRule4);
                bookSourceCopy.setRuleToc(tocRule4);
                bookSourceCopy.setRuleContent(contentRule3);
                return bookSourceCopy;
            }
            o oVar6 = (o) it2.next();
            Iterator it6 = it2;
            String str11 = oVar6.a;
            switch (str11.hashCode()) {
                case -1671787305:
                    if (str11.equals("lastChapter")) {
                        searchRule.setLastChapter(oVar6.f5820b);
                    }
                    break;
                case -1406328437:
                    if (str11.equals("author")) {
                        searchRule.setAuthor(oVar6.f5820b);
                    }
                    break;
                case -351778248:
                    if (str11.equals("coverUrl")) {
                        searchRule.setCoverUrl(oVar6.f5820b);
                    }
                    break;
                case -295931082:
                    if (str11.equals("updateTime")) {
                        searchRule.setUpdateTime(oVar6.f5820b);
                    }
                    break;
                case 3292052:
                    if (str11.equals("kind")) {
                        searchRule.setKind(oVar6.f5820b);
                    }
                    break;
                case 3373707:
                    if (str11.equals("name")) {
                        searchRule.setName(oVar6.f5820b);
                    }
                    break;
                case 64667078:
                    if (str11.equals("bookUrl")) {
                        searchRule.setBookUrl(oVar6.f5820b);
                    }
                    break;
                case 100361836:
                    if (str11.equals("intro")) {
                        searchRule.setIntro(oVar6.f5820b);
                    }
                    break;
                case 864120869:
                    if (str11.equals("wordCount")) {
                        searchRule.setWordCount(oVar6.f5820b);
                    }
                    break;
                case 1778198183:
                    if (str11.equals("searchUrl")) {
                        bookSourceCopy.setSearchUrl(oVar6.f5820b);
                    }
                    break;
                case 2004402983:
                    if (str11.equals("bookList")) {
                        searchRule.setBookList(oVar6.f5820b);
                    }
                    break;
            }
            contentRule2 = contentRule3;
            tocRule2 = tocRule3;
            bookInfoRule2 = bookInfoRule3;
            it2 = it6;
        }
    }

    @NotNull
    public BookSourceEditViewModel W0() {
        return (BookSourceEditViewModel) this.viewModel.getValue();
    }

    public final void X0(String text) {
        if (f.h0.k.s(text)) {
            return;
        }
        View viewFindFocus = getWindow().getDecorView().findFocus();
        if (viewFindFocus instanceof EditText) {
            EditText editText = (EditText) viewFindFocus;
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            Editable editableText = editText.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) text);
            } else {
                editableText.replace(selectionStart, selectionEnd, text);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0(Integer tabPosition) {
        if (tabPosition != null && tabPosition.intValue() == 1) {
            this.adapter.d(this.searchEntities);
        } else if (tabPosition != null && tabPosition.intValue() == 2) {
            this.adapter.d(this.findEntities);
        } else if (tabPosition != null && tabPosition.intValue() == 3) {
            this.adapter.d(this.infoEntities);
        } else if (tabPosition != null && tabPosition.intValue() == 4) {
            this.adapter.d(this.tocEntities);
        } else if (tabPosition != null && tabPosition.intValue() == 5) {
            this.adapter.d(this.contentEntities);
        } else {
            this.adapter.d(this.sourceEntities);
        }
        ((ActivityBookSourceEditBinding) K0()).f6502d.scrollToPosition(0);
    }

    public final void Z0() {
        InputStream inputStreamOpen = getAssets().open("help/ruleHelp.md");
        j.d(inputStreamOpen, "assets.open(\"help/ruleHelp.md\")");
        String str = new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a);
        TextDialog.Companion companion = TextDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        TextDialog.Companion.a(companion, supportFragmentManager, str, 1, 0L, false, 24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a1(BookSource source) {
        if (source != null) {
            ((ActivityBookSourceEditBinding) K0()).f6500b.setChecked(source.getEnabled());
            ((ActivityBookSourceEditBinding) K0()).f6501c.setChecked(source.getEnabledExplore());
            ((ActivityBookSourceEditBinding) K0()).f6503e.setSelection(source.getBookSourceType());
        }
        this.sourceEntities.clear();
        ArrayList<o> arrayList = this.sourceEntities;
        arrayList.add(new o("bookSourceUrl", source == null ? null : source.getBookSourceUrl(), R.string.source_url));
        arrayList.add(new o("bookSourceName", source == null ? null : source.getBookSourceName(), R.string.source_name));
        arrayList.add(new o("bookSourceGroup", source == null ? null : source.getBookSourceGroup(), R.string.source_group));
        arrayList.add(new o("bookSourceComment", source == null ? null : source.getBookSourceComment(), R.string.comment));
        arrayList.add(new o("loginUrl", source == null ? null : source.getLoginUrl(), R.string.login_url));
        arrayList.add(new o("bookUrlPattern", source == null ? null : source.getBookUrlPattern(), R.string.book_url_pattern));
        arrayList.add(new o("header", source == null ? null : source.getHeader(), R.string.source_http_header));
        SearchRule searchRule = source == null ? null : source.getSearchRule();
        this.searchEntities.clear();
        ArrayList<o> arrayList2 = this.searchEntities;
        arrayList2.add(new o("searchUrl", source == null ? null : source.getSearchUrl(), R.string.r_search_url));
        arrayList2.add(new o("bookList", searchRule == null ? null : searchRule.getBookList(), R.string.r_book_list));
        arrayList2.add(new o("name", searchRule == null ? null : searchRule.getName(), R.string.r_book_name));
        arrayList2.add(new o("author", searchRule == null ? null : searchRule.getAuthor(), R.string.r_author));
        arrayList2.add(new o("kind", searchRule == null ? null : searchRule.getKind(), R.string.rule_book_kind));
        arrayList2.add(new o("wordCount", searchRule == null ? null : searchRule.getWordCount(), R.string.rule_word_count));
        arrayList2.add(new o("lastChapter", searchRule == null ? null : searchRule.getLastChapter(), R.string.rule_last_chapter));
        arrayList2.add(new o("intro", searchRule == null ? null : searchRule.getIntro(), R.string.rule_book_intro));
        arrayList2.add(new o("coverUrl", searchRule == null ? null : searchRule.getCoverUrl(), R.string.rule_cover_url));
        arrayList2.add(new o("bookUrl", searchRule == null ? null : searchRule.getBookUrl(), R.string.r_book_url));
        BookInfoRule bookInfoRule = source == null ? null : source.getBookInfoRule();
        this.infoEntities.clear();
        ArrayList<o> arrayList3 = this.infoEntities;
        arrayList3.add(new o("init", bookInfoRule == null ? null : bookInfoRule.getInit(), R.string.rule_book_info_init));
        arrayList3.add(new o("name", bookInfoRule == null ? null : bookInfoRule.getName(), R.string.r_book_name));
        arrayList3.add(new o("author", bookInfoRule == null ? null : bookInfoRule.getAuthor(), R.string.r_author));
        arrayList3.add(new o("kind", bookInfoRule == null ? null : bookInfoRule.getKind(), R.string.rule_book_kind));
        arrayList3.add(new o("wordCount", bookInfoRule == null ? null : bookInfoRule.getWordCount(), R.string.rule_word_count));
        arrayList3.add(new o("lastChapter", bookInfoRule == null ? null : bookInfoRule.getLastChapter(), R.string.rule_last_chapter));
        arrayList3.add(new o("intro", bookInfoRule == null ? null : bookInfoRule.getIntro(), R.string.rule_book_intro));
        arrayList3.add(new o("coverUrl", bookInfoRule == null ? null : bookInfoRule.getCoverUrl(), R.string.rule_cover_url));
        arrayList3.add(new o("tocUrl", bookInfoRule == null ? null : bookInfoRule.getTocUrl(), R.string.rule_toc_url));
        arrayList3.add(new o("canReName", bookInfoRule == null ? null : bookInfoRule.getCanReName(), R.string.rule_can_re_name));
        TocRule tocRule = source == null ? null : source.getTocRule();
        this.tocEntities.clear();
        ArrayList<o> arrayList4 = this.tocEntities;
        arrayList4.add(new o("chapterList", tocRule == null ? null : tocRule.getChapterList(), R.string.rule_chapter_list));
        arrayList4.add(new o("chapterName", tocRule == null ? null : tocRule.getChapterName(), R.string.rule_chapter_name));
        arrayList4.add(new o("chapterUrl", tocRule == null ? null : tocRule.getChapterUrl(), R.string.rule_chapter_url));
        arrayList4.add(new o("isVip", tocRule == null ? null : tocRule.isVip(), R.string.rule_is_vip));
        arrayList4.add(new o("updateTime", tocRule == null ? null : tocRule.getUpdateTime(), R.string.rule_update_time));
        arrayList4.add(new o("nextTocUrl", tocRule == null ? null : tocRule.getNextTocUrl(), R.string.rule_next_toc_url));
        ContentRule contentRule = source == null ? null : source.getContentRule();
        this.contentEntities.clear();
        ArrayList<o> arrayList5 = this.contentEntities;
        arrayList5.add(new o("content", contentRule == null ? null : contentRule.getContent(), R.string.rule_book_content));
        arrayList5.add(new o("nextContentUrl", contentRule == null ? null : contentRule.getNextContentUrl(), R.string.rule_next_content));
        arrayList5.add(new o("webJs", contentRule == null ? null : contentRule.getWebJs(), R.string.rule_web_js));
        arrayList5.add(new o("sourceRegex", contentRule == null ? null : contentRule.getSourceRegex(), R.string.rule_source_regex));
        arrayList5.add(new o("replaceRegex", contentRule == null ? null : contentRule.getReplaceRegex(), R.string.rule_replace_regex));
        arrayList5.add(new o("imageStyle", contentRule == null ? null : contentRule.getImageStyle(), R.string.rule_image_style));
        ExploreRule exploreRule = source == null ? null : source.getExploreRule();
        this.findEntities.clear();
        ArrayList<o> arrayList6 = this.findEntities;
        arrayList6.add(new o("exploreUrl", source == null ? null : source.getExploreUrl(), R.string.r_find_url));
        arrayList6.add(new o("bookList", exploreRule == null ? null : exploreRule.getBookList(), R.string.r_book_list));
        arrayList6.add(new o("name", exploreRule == null ? null : exploreRule.getName(), R.string.r_book_name));
        arrayList6.add(new o("author", exploreRule == null ? null : exploreRule.getAuthor(), R.string.r_author));
        arrayList6.add(new o("kind", exploreRule == null ? null : exploreRule.getKind(), R.string.rule_book_kind));
        arrayList6.add(new o("wordCount", exploreRule == null ? null : exploreRule.getWordCount(), R.string.rule_word_count));
        arrayList6.add(new o("lastChapter", exploreRule == null ? null : exploreRule.getLastChapter(), R.string.rule_last_chapter));
        arrayList6.add(new o("intro", exploreRule == null ? null : exploreRule.getIntro(), R.string.rule_book_intro));
        arrayList6.add(new o("coverUrl", exploreRule == null ? null : exploreRule.getCoverUrl(), R.string.rule_cover_url));
        arrayList6.add(new o("bookUrl", exploreRule == null ? null : exploreRule.getBookUrl(), R.string.r_book_url));
        ((ActivityBookSourceEditBinding) K0()).f6504f.k(((ActivityBookSourceEditBinding) K0()).f6504f.g(0), true);
        Y0(0);
    }

    @Override // io.legado.app.base.BaseActivity, android.app.Activity
    public void finish() {
        BookSource bookSourceV0 = V0();
        BookSource bookSource = W0().bookSource;
        if (bookSource == null) {
            bookSource = new BookSource(null, null, null, 0, null, 0, false, false, null, null, null, 0L, 0, null, null, null, null, null, null, null, 1048575, null);
        }
        if (bookSourceV0.equal(bookSource)) {
            super.finish();
        } else {
            ((i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.exit), null, new b(), 2)).p();
        }
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.mSoftKeyboardTool;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (q.a.b(1, "ruleHelpVersion", null)) {
            return;
        }
        Z0();
    }
}
