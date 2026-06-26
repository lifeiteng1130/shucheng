package io.legado.app.ui.book.read;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.activity.ComponentActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.commonsdk.statistics.SdkVersion;
import e.a.a.d.q;
import e.a.a.d.u.b;
import e.a.a.e.a.h;
import e.a.a.e.a.i;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Bookmark;
import io.legado.app.databinding.ActivityBookReadBinding;
import io.legado.app.databinding.DialogBookmarkBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.read.config.ClickActionConfigDialog;
import io.legado.app.ui.book.read.page.ReadView;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ReadBookBaseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b$\u0010\u000bJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001b\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lio/legado/app/ui/book/read/ReadBookBaseActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityBookReadBinding;", "Lio/legado/app/ui/book/read/ReadBookViewModel;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "onCreate", "(Landroid/os/Bundle;)V", "O0", "V0", "()V", "S0", "Landroid/view/Window;", "window", "", "on", "U0", "(Landroid/view/Window;Z)V", "Lio/legado/app/data/entities/Bookmark;", "bookmark", "W0", "(Lio/legado/app/data/entities/Bookmark;)V", "g", "Lf/e;", "T0", "()Lio/legado/app/ui/book/read/ReadBookViewModel;", "viewModel", "", "h", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getBottomDialog", "()I", "setBottomDialog", "(I)V", "bottomDialog", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class ReadBookBaseActivity extends VMBaseActivity<ActivityBookReadBinding, ReadBookViewModel> {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int bottomDialog;

    /* JADX INFO: compiled from: ReadBookBaseActivity.kt */
    public static final class a extends k implements l<h<? extends DialogInterface>, v> {
        public final /* synthetic */ Bookmark $bookmark;
        public final /* synthetic */ ReadBookBaseActivity this$0;

        /* JADX INFO: renamed from: io.legado.app.ui.book.read.ReadBookBaseActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ReadBookBaseActivity.kt */
        public static final class C0201a extends k implements f.c0.b.a<View> {
            public final /* synthetic */ DialogBookmarkBinding $alertBinding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0201a(DialogBookmarkBinding dialogBookmarkBinding) {
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

        /* JADX INFO: compiled from: ReadBookBaseActivity.kt */
        public static final class b extends k implements l<DialogInterface, v> {
            public final /* synthetic */ DialogBookmarkBinding $alertBinding;
            public final /* synthetic */ Bookmark $bookmark;

            /* JADX INFO: renamed from: io.legado.app.ui.book.read.ReadBookBaseActivity$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ReadBookBaseActivity.kt */
            @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookBaseActivity$showBookMark$1$2$1$1", f = "ReadBookBaseActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0202a extends g implements p<a0, d<? super v>, Object> {
                public final /* synthetic */ Bookmark $bookmark;
                public final /* synthetic */ DialogBookmarkBinding $this_apply;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0202a(Bookmark bookmark, DialogBookmarkBinding dialogBookmarkBinding, d<? super C0202a> dVar) {
                    super(2, dVar);
                    this.$bookmark = bookmark;
                    this.$this_apply = dialogBookmarkBinding;
                }

                @Override // f.z.j.a.a
                @NotNull
                public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    return new C0202a(this.$bookmark, this.$this_apply, dVar);
                }

                @Override // f.c0.b.p
                @Nullable
                public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
                    return ((C0202a) create(a0Var, dVar)).invokeSuspend(v.a);
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
                b.C0148b.b(e.a.a.d.u.b.a, null, null, new C0202a(this.$bookmark, dialogBookmarkBinding, null), 3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Bookmark bookmark, ReadBookBaseActivity readBookBaseActivity) {
            super(1);
            this.$bookmark = bookmark;
            this.this$0 = readBookBaseActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            hVar.h(this.$bookmark.getChapterName());
            DialogBookmarkBinding dialogBookmarkBindingA = DialogBookmarkBinding.a(this.this$0.getLayoutInflater());
            Bookmark bookmark = this.$bookmark;
            dialogBookmarkBindingA.f6587b.setText(bookmark.getBookText());
            dialogBookmarkBindingA.f6588c.setText(bookmark.getContent());
            j.d(dialogBookmarkBindingA, "inflate(layoutInflater).apply {\n                editBookText.setText(bookmark.bookText)\n                editView.setText(bookmark.content)\n            }");
            hVar.d(new C0201a(dialogBookmarkBindingA));
            hVar.i(new b(dialogBookmarkBindingA, this.$bookmark));
            f.d4(hVar, null, 1, null);
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class b extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
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
    public static final class c extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
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

    public ReadBookBaseActivity() {
        super(false, null, null, false, false, 15);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(ReadBookViewModel.class), new c(this), new b(this));
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_book_read, (ViewGroup) null, false);
        int i2 = R.id.cursor_left;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.cursor_left);
        if (imageView != null) {
            i2 = R.id.cursor_right;
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cursor_right);
            if (imageView2 != null) {
                i2 = R.id.read_menu;
                ReadMenu readMenu = (ReadMenu) viewInflate.findViewById(R.id.read_menu);
                if (readMenu != null) {
                    i2 = R.id.read_view;
                    ReadView readView = (ReadView) viewInflate.findViewById(R.id.read_view);
                    if (readView != null) {
                        i2 = R.id.text_menu_position;
                        View viewFindViewById = viewInflate.findViewById(R.id.text_menu_position);
                        if (viewFindViewById != null) {
                            ActivityBookReadBinding activityBookReadBinding = new ActivityBookReadBinding((FrameLayout) viewInflate, imageView, imageView2, readMenu, readView, viewFindViewById);
                            j.d(activityBookReadBinding, "inflate(layoutInflater)");
                            return activityBookReadBinding;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        if (q.a.b(1, "readHelpVersion", "firstRead")) {
            return;
        }
        ClickActionConfigDialog clickActionConfigDialog = new ClickActionConfigDialog();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        clickActionConfigDialog.show(supportFragmentManager, "clickActionConfig");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void S0() {
        ReadMenu readMenu = ((ActivityBookReadBinding) K0()).f6485d;
        j.d(readMenu, "binding.readMenu");
        if (readMenu.getVisibility() == 0) {
            super.S0();
            return;
        }
        if (this.bottomDialog > 0) {
            super.S0();
            return;
        }
        e.a.a.d.e eVar = e.a.a.d.e.a;
        if (f.J2(k.d.a.h.g(), "immNavigationBar", true)) {
            ATH.a.g(this, 0);
        } else {
            ATH.a.g(this, Color.parseColor("#20000000"));
        }
    }

    @NotNull
    public ReadBookViewModel T0() {
        return (ReadBookViewModel) this.viewModel.getValue();
    }

    public final void U0(@NotNull Window window, boolean on) {
        j.e(window, "window");
        if (on) {
            window.addFlags(128);
        } else {
            window.clearFlags(128);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void V0() {
        e.a.a.d.e eVar = e.a.a.d.e.a;
        String strO2 = f.O2(k.d.a.h.g(), "screenOrientation", null, 2);
        if (strO2 != null) {
            switch (strO2.hashCode()) {
                case 48:
                    if (strO2.equals("0")) {
                        setRequestedOrientation(-1);
                        break;
                    }
                    break;
                case 49:
                    if (strO2.equals(SdkVersion.MINI_VERSION)) {
                        setRequestedOrientation(1);
                        break;
                    }
                    break;
                case 50:
                    if (strO2.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                        setRequestedOrientation(0);
                        break;
                    }
                    break;
                case 51:
                    if (strO2.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                        setRequestedOrientation(4);
                        break;
                    }
                    break;
            }
        }
    }

    @SuppressLint({"InflateParams"})
    public final void W0(@NotNull Bookmark bookmark) {
        j.e(bookmark, "bookmark");
        f.J4(((i) f.i0(this, getString(R.string.bookmark_add), null, new a(bookmark, this), 2)).p());
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        e.a.a.f.s.k.p = null;
        V0();
        if (Build.VERSION.SDK_INT >= 28 && ReadBookConfig.INSTANCE.getReadBodyToLh()) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        super.onCreate(savedInstanceState);
    }
}
