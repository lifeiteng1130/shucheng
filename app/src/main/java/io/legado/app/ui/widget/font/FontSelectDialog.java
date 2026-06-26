package io.legado.app.ui.widget.font;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.KeyEventDispatcher;
import androidx.documentfile.provider.DocumentFile;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.ai;
import e.a.a.e.c.k;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogFontSelectBinding;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.widget.font.FontAdapter;
import io.legado.app.ui.widget.font.FontSelectDialog;
import io.legado.app.utils.FileUtils;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FontSelectDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001FB\u0007¢\u0006\u0004\bE\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$R$\u0010*\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010&0&0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u00100\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u0010:\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010<R\u0016\u0010@\u001a\u00020!8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lio/legado/app/ui/widget/font/FontSelectDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lio/legado/app/ui/widget/font/FontAdapter$a;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Le/a/a/h/i;", "docItem", "e", "(Le/a/a/h/i;)V", ExifInterface.LONGITUDE_WEST, "Landroidx/documentfile/provider/DocumentFile;", "doc", "U", "(Landroidx/documentfile/provider/DocumentFile;)V", "", "path", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", "g", "Landroidx/activity/result/ActivityResultLauncher;", "selectFontDir", "Lio/legado/app/databinding/DialogFontSelectBinding;", "f", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", ExifInterface.LATITUDE_SOUTH, "()Lio/legado/app/databinding/DialogFontSelectBinding;", "binding", "Lf/h0/g;", ai.aD, "Lf/h0/g;", "fontRegex", "Ljava/io/File;", "d", "Lf/e;", "getFontFolder", "()Ljava/io/File;", "fontFolder", "Lio/legado/app/ui/widget/font/FontAdapter;", "Lio/legado/app/ui/widget/font/FontAdapter;", "adapter", "b", "()Ljava/lang/String;", "curFilePath", "Lio/legado/app/ui/widget/font/FontSelectDialog$a;", ExifInterface.GPS_DIRECTION_TRUE, "()Lio/legado/app/ui/widget/font/FontSelectDialog$a;", "callBack", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FontSelectDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener, FontAdapter.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ f.f0.h<Object>[] f7672b;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public FontAdapter adapter;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> selectFontDir;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.h0.g fontRegex = new f.h0.g(".*\\.[ot]tf");

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e fontFolder = c.b.a.m.f.N3(b.INSTANCE);

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = c.b.a.m.f.b6(this, new k());

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    public interface a {
        @NotNull
        String L();

        void s(@NotNull String str);
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.a<File> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final File invoke() {
            FileUtils fileUtils = FileUtils.a;
            File filesDir = k.d.a.h.g().getFilesDir();
            f.c0.c.j.d(filesDir, "appCtx.filesDir");
            return fileUtils.d(filesDir, "Fonts");
        }
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.font.FontSelectDialog$loadFontFiles$1", f = "FontSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends f.z.j.a.g implements p<a0, f.z.d<? super List<? extends e.a.a.h.i>>, Object> {
        public final /* synthetic */ DocumentFile $doc;
        public int label;
        public final /* synthetic */ FontSelectDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DocumentFile documentFile, FontSelectDialog fontSelectDialog, f.z.d<? super c> dVar) {
            super(2, dVar);
            this.$doc = documentFile;
            this.this$0 = fontSelectDialog;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new c(this.$doc, this.this$0, dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable f.z.d<? super List<e.a.a.h.i>> dVar) {
            return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, f.z.d<? super List<? extends e.a.a.h.i>> dVar) {
            return invoke2(a0Var, (f.z.d<? super List<e.a.a.h.i>>) dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            ArrayList arrayList = new ArrayList();
            e.a.a.h.j jVar = e.a.a.h.j.a;
            Context contextG = k.d.a.h.g();
            Uri uri = this.$doc.getUri();
            f.c0.c.j.d(uri, "doc.uri");
            ArrayList<e.a.a.h.i> arrayListD = jVar.d(contextG, uri);
            FontSelectDialog fontSelectDialog = this.this$0;
            for (e.a.a.h.i iVar : arrayListD) {
                String str = iVar.a;
                Locale locale = Locale.getDefault();
                f.c0.c.j.d(locale, "getDefault()");
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str.toLowerCase(locale);
                f.c0.c.j.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (fontSelectDialog.fontRegex.matches(lowerCase)) {
                    arrayList.add(iVar);
                }
            }
            FontSelectDialog fontSelectDialog2 = this.this$0;
            return FontSelectDialog.R(fontSelectDialog2, arrayList, FontSelectDialog.Q(fontSelectDialog2));
        }
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.font.FontSelectDialog$loadFontFiles$2", f = "FontSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends f.z.j.a.g implements q<a0, List<? extends e.a.a.h.i>, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public d(f.z.d<? super d> dVar) {
            super(3, dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @NotNull List<e.a.a.h.i> list, @Nullable f.z.d<? super v> dVar) {
            d dVar2 = FontSelectDialog.this.new d(dVar);
            dVar2.L$0 = list;
            return dVar2.invokeSuspend(v.a);
        }

        @Override // f.c0.b.q
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, List<? extends e.a.a.h.i> list, f.z.d<? super v> dVar) {
            return invoke2(a0Var, (List<e.a.a.h.i>) list, dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            List list = (List) this.L$0;
            FontAdapter fontAdapter = FontSelectDialog.this.adapter;
            if (fontAdapter != null) {
                fontAdapter.x(list);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.font.FontSelectDialog$loadFontFiles$3", f = "FontSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public e(f.z.d<? super e> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            e eVar = FontSelectDialog.this.new e(dVar);
            eVar.L$0 = th;
            return eVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            m.m(FontSelectDialog.this, f.c0.c.j.k("getFontFiles:", ((Throwable) this.L$0).getLocalizedMessage()));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    public static final class f extends f.c0.c.k implements f.c0.b.a<v> {
        public final /* synthetic */ String $path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(0);
            this.$path = str;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FontSelectDialog fontSelectDialog = FontSelectDialog.this;
            String str = this.$path;
            f.f0.h<Object>[] hVarArr = FontSelectDialog.f7672b;
            Objects.requireNonNull(fontSelectDialog);
            e.a.a.d.u.b bVarN = BaseDialogFragment.N(fontSelectDialog, null, null, new e.a.a.g.m.l.g(str, fontSelectDialog, null), 3, null);
            bVarN.d(null, new e.a.a.g.m.l.h(fontSelectDialog, null));
            e.a.a.d.u.b.b(bVarN, null, new e.a.a.g.m.l.i(fontSelectDialog, null), 1);
        }
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.font.FontSelectDialog$onClick$1", f = "FontSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ e.a.a.h.i $docItem;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e.a.a.h.i iVar, f.z.d<? super g> dVar) {
            super(2, dVar);
            this.$docItem = iVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return FontSelectDialog.this.new g(this.$docItem, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            FileUtils fileUtils = FileUtils.a;
            String absolutePath = ((File) FontSelectDialog.this.fontFolder.getValue()).getAbsolutePath();
            f.c0.c.j.d(absolutePath, "fontFolder.absolutePath");
            fileUtils.h(absolutePath);
            a aVarT = FontSelectDialog.this.T();
            if (aVarT == null) {
                return null;
            }
            String string = this.$docItem.f5957e.toString();
            f.c0.c.j.d(string, "docItem.uri.toString()");
            aVarT.s(string);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.font.FontSelectDialog$onClick$2", f = "FontSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
        public int label;

        public h(f.z.d<? super h> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable v vVar, @Nullable f.z.d<? super v> dVar) {
            return FontSelectDialog.this.new h(dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            FontSelectDialog.this.dismissAllowingStateLoss();
            return v.a;
        }
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    public static final class i extends f.c0.c.k implements l<e.a.a.e.a.h<? extends DialogInterface>, v> {
        public final /* synthetic */ Context $requireContext;
        public final /* synthetic */ FontSelectDialog this$0;

        /* JADX INFO: compiled from: FontSelectDialog.kt */
        public static final class a extends f.c0.c.k implements p<DialogInterface, Integer, v> {
            public final /* synthetic */ FontSelectDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(FontSelectDialog fontSelectDialog) {
                super(2);
                this.this$0 = fontSelectDialog;
            }

            @Override // f.c0.b.p
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
                invoke(dialogInterface, num.intValue());
                return v.a;
            }

            public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
                f.c0.c.j.e(dialogInterface, "$noName_0");
                e.a.a.d.e eVar = e.a.a.d.e.a;
                c.b.a.m.f.p4(k.d.a.h.g(), "system_typefaces", i2);
                FontSelectDialog fontSelectDialog = this.this$0;
                f.f0.h<Object>[] hVarArr = FontSelectDialog.f7672b;
                a aVarT = fontSelectDialog.T();
                if (aVarT != null) {
                    aVarT.s("");
                }
                this.this$0.dismissAllowingStateLoss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Context context, FontSelectDialog fontSelectDialog) {
            super(1);
            this.$requireContext = context;
            this.this$0 = fontSelectDialog;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
            f.c0.c.j.e(hVar, "$this$alert");
            String[] stringArray = this.$requireContext.getResources().getStringArray(R.array.system_typefaces);
            f.c0.c.j.d(stringArray, "requireContext.resources.getStringArray(R.array.system_typefaces)");
            hVar.b(c.b.a.m.f.K5(stringArray), new a(this.this$0));
        }
    }

    /* JADX INFO: compiled from: FontSelectDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.font.FontSelectDialog$openFolder$1", f = "FontSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public j(f.z.d<? super j> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return FontSelectDialog.this.new j(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((j) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            FontSelectDialog.this.selectFontDir.launch(new e.a.a.g.f.d(0, null, null, new String[]{"SD" + ((Object) File.separator) + "Fonts"}, 7));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class k extends f.c0.c.k implements l<FontSelectDialog, DialogFontSelectBinding> {
        public k() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogFontSelectBinding invoke(@NotNull FontSelectDialog fontSelectDialog) {
            f.c0.c.j.e(fontSelectDialog, "fragment");
            View viewRequireView = fontSelectDialog.requireView();
            int i2 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i2 = R.id.tool_bar;
                Toolbar toolbar = (Toolbar) viewRequireView.findViewById(R.id.tool_bar);
                if (toolbar != null) {
                    return new DialogFontSelectBinding((LinearLayout) viewRequireView, recyclerView, toolbar);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        f.f0.h<Object>[] hVarArr = new f.f0.h[2];
        f.c0.c.q qVar = new f.c0.c.q(f.c0.c.v.a(FontSelectDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogFontSelectBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        hVarArr[1] = qVar;
        f7672b = hVarArr;
    }

    public FontSelectDialog() {
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.m.l.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ContentResolver contentResolver;
                FontSelectDialog fontSelectDialog = this.a;
                Uri uri = (Uri) obj;
                f.f0.h<Object>[] hVarArr = FontSelectDialog.f7672b;
                j.e(fontSelectDialog, "this$0");
                if (uri == null) {
                    return;
                }
                if (!c.b.a.m.f.t3(uri.toString())) {
                    String path = uri.getPath();
                    if (path == null) {
                        return;
                    }
                    m.j(fontSelectDialog, "fontFolder", path);
                    fontSelectDialog.V(path);
                    return;
                }
                String string = uri.toString();
                j.d(string, "uri.toString()");
                m.j(fontSelectDialog, "fontFolder", string);
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(fontSelectDialog.requireContext(), uri);
                if (documentFileFromTreeUri != null) {
                    Context context = fontSelectDialog.getContext();
                    if (context != null && (contentResolver = context.getContentResolver()) != null) {
                        contentResolver.takePersistableUriPermission(uri, 1);
                    }
                    fontSelectDialog.U(documentFileFromTreeUri);
                    return;
                }
                Context contextRequireContext = fontSelectDialog.requireContext();
                j.d(contextRequireContext, "requireContext()");
                String strB = e.a.a.h.a0.b(contextRequireContext, uri);
                if (strB == null) {
                    return;
                }
                fontSelectDialog.V(strB);
            }
        });
        f.c0.c.j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.toString().isContentScheme()) {\n            putPrefString(PreferKey.fontFolder, uri.toString())\n            val doc = DocumentFile.fromTreeUri(requireContext(), uri)\n            if (doc != null) {\n                context?.contentResolver?.takePersistableUriPermission(\n                    uri,\n                    Intent.FLAG_GRANT_READ_URI_PERMISSION\n                )\n                loadFontFiles(doc)\n            } else {\n                RealPathUtil.getPath(requireContext(), uri)?.let {\n                    loadFontFilesByPermission(it)\n                }\n            }\n        } else {\n            uri.path?.let { path ->\n                putPrefString(PreferKey.fontFolder, path)\n                loadFontFilesByPermission(path)\n            }\n        }\n    }");
        this.selectFontDir = activityResultLauncherRegisterForActivityResult;
    }

    public static final ArrayList Q(final FontSelectDialog fontSelectDialog) {
        Objects.requireNonNull(fontSelectDialog);
        ArrayList arrayList = new ArrayList();
        FileUtils fileUtils = FileUtils.a;
        Context contextRequireContext = fontSelectDialog.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        File[] fileArrListFiles = fileUtils.d(c.b.a.m.f.r2(contextRequireContext), "font").listFiles(new FileFilter() { // from class: e.a.a.g.m.l.e
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                FontSelectDialog fontSelectDialog2 = this.a;
                f.f0.h<Object>[] hVarArr = FontSelectDialog.f7672b;
                j.e(fontSelectDialog2, "this$0");
                String name = file.getName();
                j.d(name, "pathName.name");
                Locale locale = Locale.getDefault();
                j.d(locale, "getDefault()");
                String lowerCase = name.toLowerCase(locale);
                j.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return fontSelectDialog2.fontRegex.matches(lowerCase);
            }
        });
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                f.c0.c.j.d(name, "it.name");
                f.c0.c.j.d(file, "it");
                String strB = f.b0.d.b(file);
                long length = file.length();
                Date date = new Date(file.lastModified());
                Uri uri = Uri.parse(file.getAbsolutePath());
                f.c0.c.j.d(uri, "parse(it.absolutePath)");
                arrayList.add(new e.a.a.h.i(name, strB, length, date, uri));
            }
        }
        return arrayList;
    }

    public static final List R(FontSelectDialog fontSelectDialog, ArrayList arrayList, ArrayList arrayList2) {
        Objects.requireNonNull(fontSelectDialog);
        ArrayList arrayList3 = new ArrayList(arrayList);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            e.a.a.h.i iVar = (e.a.a.h.i) it.next();
            boolean z = false;
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (f.c0.c.j.a(iVar.a, ((e.a.a.h.i) it2.next()).a)) {
                    z = true;
                }
            }
            if (!z) {
                arrayList3.add(iVar);
            }
        }
        return f.x.e.B(arrayList3, e.a.a.g.m.l.c.a);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        f.c0.c.j.e(view, "view");
        S().f6619c.setBackgroundColor(c.b.a.m.f.Q2(this));
        S().f6619c.setTitle(R.string.select_font);
        S().f6619c.inflateMenu(R.menu.font_select);
        Menu menu = S().f6619c.getMenu();
        f.c0.c.j.d(menu, "binding.toolBar.menu");
        Context contextRequireContext = requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
        S().f6619c.setOnMenuItemClickListener(this);
        Context contextRequireContext2 = requireContext();
        f.c0.c.j.d(contextRequireContext2, "requireContext()");
        this.adapter = new FontAdapter(contextRequireContext2, this);
        S().f6618b.setLayoutManager(new LinearLayoutManager(getContext()));
        S().f6618b.setAdapter(this.adapter);
        String strF = m.f(this, "fontFolder", null, 2);
        if (strF == null || strF.length() == 0) {
            W();
            return;
        }
        if (!c.b.a.m.f.t3(strF)) {
            V(strF);
            return;
        }
        DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(requireContext(), Uri.parse(strF));
        if (f.c0.c.j.a(documentFileFromTreeUri != null ? Boolean.valueOf(documentFileFromTreeUri.canRead()) : null, Boolean.TRUE)) {
            U(documentFileFromTreeUri);
        } else {
            W();
        }
    }

    public final DialogFontSelectBinding S() {
        return (DialogFontSelectBinding) this.binding.b(this, f7672b[1]);
    }

    public final a T() {
        ActivityResultCaller parentFragment = getParentFragment();
        a aVar = parentFragment instanceof a ? (a) parentFragment : null;
        if (aVar != null) {
            return aVar;
        }
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof a) {
            return (a) activity;
        }
        return null;
    }

    public final void U(DocumentFile doc) {
        e.a.a.d.u.b bVarN = BaseDialogFragment.N(this, null, null, new c(doc, this, null), 3, null);
        bVarN.d(null, new d(null));
        e.a.a.d.u.b.b(bVarN, null, new e(null), 1);
    }

    public final void V(String path) {
        k.a aVar = new k.a(this);
        String[] strArr = e.a.a.e.c.j.a;
        aVar.a((String[]) Arrays.copyOf(strArr, strArr.length));
        aVar.c(R.string.tip_perm_request_storage);
        aVar.b(new f(path));
        aVar.d();
    }

    public final void W() {
        k0 k0Var = k0.f6264c;
        c.b.a.m.f.L3(this, g.b.g2.m.f6207b, null, new j(null), 2, null);
    }

    @Override // io.legado.app.ui.widget.font.FontAdapter.a
    @NotNull
    public String b() {
        a aVarT = T();
        return aVarT == null ? "" : aVarT.L();
    }

    @Override // io.legado.app.ui.widget.font.FontAdapter.a
    public void e(@NotNull e.a.a.h.i docItem) {
        f.c0.c.j.e(docItem, "docItem");
        BaseDialogFragment.N(this, null, null, new g(docItem, null), 3, null).d(null, new h(null));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        f.c0.c.j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_font_select, container);
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_default) {
            if (numValueOf == null || numValueOf.intValue() != R.id.menu_other) {
                return true;
            }
            W();
            return true;
        }
        Context contextRequireContext = requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        Integer numValueOf2 = Integer.valueOf(R.string.system_typeface);
        i iVar = new i(contextRequireContext, this);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
        ((e.a.a.e.a.i) c.b.a.m.f.h0(fragmentActivityRequireActivity, numValueOf2, null, iVar)).p();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
        DisplayMetrics displayMetricsV2 = c.b.a.m.f.V2(fragmentActivityRequireActivity);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), (int) (((double) displayMetricsV2.heightPixels) * 0.9d));
    }
}
