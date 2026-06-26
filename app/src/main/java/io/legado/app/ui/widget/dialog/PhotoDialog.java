package io.legado.app.ui.widget.dialog;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.c0.c.k;
import f.f0.h;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.DialogPhotoViewBinding;
import io.legado.app.ui.widget.image.PhotoView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PhotoDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lio/legado/app/ui/widget/dialog/PhotoDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lio/legado/app/databinding/DialogPhotoViewBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "getBinding", "()Lio/legado/app/databinding/DialogPhotoViewBinding;", "binding", "<init>", "b", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PhotoDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new d());

    /* JADX INFO: renamed from: io.legado.app.ui.widget.dialog.PhotoDialog$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PhotoDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }
    }

    /* JADX INFO: compiled from: PhotoDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.dialog.PhotoDialog$onFragmentCreated$1$1$1$1", f = "PhotoDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, f.z.d<? super Bitmap>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ int $chapterIndex;
        public final /* synthetic */ String $src;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Book book, int i2, String str, f.z.d<? super b> dVar) {
            super(2, dVar);
            this.$book = book;
            this.$chapterIndex = i2;
            this.$src = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new b(this.$book, this.$chapterIndex, this.$src, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super Bitmap> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            return e.a.a.g.d.i.s1.h.b.a.a(this.$book, this.$chapterIndex, this.$src, false);
        }
    }

    /* JADX INFO: compiled from: PhotoDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.dialog.PhotoDialog$onFragmentCreated$1$1$1$2", f = "PhotoDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements q<a0, Bitmap, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public c(f.z.d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable Bitmap bitmap, @Nullable f.z.d<? super v> dVar) {
            c cVar = PhotoDialog.this.new c(dVar);
            cVar.L$0 = bitmap;
            return cVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            Bitmap bitmap = (Bitmap) this.L$0;
            if (bitmap != null) {
                PhotoDialog photoDialog = PhotoDialog.this;
                ((DialogPhotoViewBinding) photoDialog.binding.b(photoDialog, PhotoDialog.f7653c[0])).f6626b.setImageBitmap(bitmap);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class d extends k implements l<PhotoDialog, DialogPhotoViewBinding> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogPhotoViewBinding invoke(@NotNull PhotoDialog photoDialog) {
            j.e(photoDialog, "fragment");
            View viewRequireView = photoDialog.requireView();
            PhotoView photoView = (PhotoView) viewRequireView.findViewById(R.id.photo_view);
            if (photoView != null) {
                return new DialogPhotoViewBinding((ConstraintLayout) viewRequireView, photoView);
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(R.id.photo_view)));
        }
    }

    static {
        f.c0.c.q qVar = new f.c0.c.q(f.c0.c.v.a(PhotoDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogPhotoViewBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        f7653c = new h[]{qVar};
        INSTANCE = new Companion(null);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        int i2 = arguments.getInt("chapterIndex");
        String string = arguments.getString("src");
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        if (book == null || string == null) {
            return;
        }
        BaseDialogFragment.N(this, null, null, new b(book, i2, string, null), 3, null).d(null, new c(null));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_photo_view, container);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -1);
    }
}
