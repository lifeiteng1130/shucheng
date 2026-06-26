package io.legado.app.ui.book.read.config;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.i;
import e.a.a.g.d.i.r1.b4;
import e.a.a.g.d.i.r1.z3;
import e.a.a.h.f;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.e;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.HttpTTS;
import io.legado.app.databinding.DialogHttpTtsEditBinding;
import io.legado.app.databinding.DialogRecyclerViewBinding;
import io.legado.app.databinding.ItemHttpTtsBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.lib.theme.view.ATERadioButton;
import io.legado.app.ui.book.read.config.SpeakEngineDialog;
import io.legado.app.ui.book.read.config.SpeakEngineViewModel;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.legado.app.ui.widget.text.AccentTextView;
import io.legado.app.ui.widget.text.EditText;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpeakEngineDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EB\u0007¢\u0006\u0004\bD\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R&\u00105\u001a\u00060.R\u00020\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001d\u0010;\u001a\u0002068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010A\u001a\u00020<8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R$\u0010C\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010,¨\u0006F"}, d2 = {"Lio/legado/app/ui/book/read/config/SpeakEngineDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/data/entities/HttpTTS;", ai.aC, "Q", "(Lio/legado/app/data/entities/HttpTTS;)V", "Landroidx/lifecycle/LiveData;", "", "g", "Landroidx/lifecycle/LiveData;", "httpTTSData", "", "h", "J", "engineId", "", "d", "Ljava/lang/String;", "ttsUrlKey", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", ai.aA, "Landroidx/activity/result/ActivityResultLauncher;", "importDocResult", "Lio/legado/app/ui/book/read/config/SpeakEngineDialog$Adapter;", "e", "Lio/legado/app/ui/book/read/config/SpeakEngineDialog$Adapter;", "getAdapter", "()Lio/legado/app/ui/book/read/config/SpeakEngineDialog$Adapter;", "setAdapter", "(Lio/legado/app/ui/book/read/config/SpeakEngineDialog$Adapter;)V", "adapter", "Lio/legado/app/databinding/DialogRecyclerViewBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "getBinding", "()Lio/legado/app/databinding/DialogRecyclerViewBinding;", "binding", "Lio/legado/app/ui/book/read/config/SpeakEngineViewModel;", "f", "Lf/e;", "R", "()Lio/legado/app/ui/book/read/config/SpeakEngineViewModel;", "viewModel", "j", "exportDirResult", "<init>", "Adapter", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SpeakEngineDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7195b;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Adapter adapter;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<HttpTTS>> httpTTSData;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> importDocResult;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> exportDirResult;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new b());

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String ttsUrlKey = "ttsUrlKey";

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(SpeakEngineViewModel.class), new d(new c(this)), null);

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public long engineId = f.N2(k.d.a.h.g(), "speakEngine", 0, 2);

    /* JADX INFO: compiled from: SpeakEngineDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/book/read/config/SpeakEngineDialog$Adapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/HttpTTS;", "Lio/legado/app/databinding/ItemHttpTtsBinding;", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "<init>", "(Lio/legado/app/ui/book/read/config/SpeakEngineDialog;Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class Adapter extends RecyclerAdapter<HttpTTS, ItemHttpTtsBinding> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SpeakEngineDialog f7204f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(@NotNull SpeakEngineDialog speakEngineDialog, Context context) {
            super(context);
            j.e(speakEngineDialog, "this$0");
            j.e(context, com.umeng.analytics.pro.c.R);
            this.f7204f = speakEngineDialog;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, HttpTTS httpTTS, List list, int i2) {
            ItemHttpTtsBinding itemHttpTtsBinding = (ItemHttpTtsBinding) viewBinding;
            HttpTTS httpTTS2 = httpTTS;
            j.e(itemViewHolder, "holder");
            j.e(itemHttpTtsBinding, "binding");
            j.e(httpTTS2, "item");
            j.e(list, "payloads");
            SpeakEngineDialog speakEngineDialog = this.f7204f;
            itemHttpTtsBinding.f6797b.setText(httpTTS2.getName());
            itemHttpTtsBinding.f6797b.setChecked(httpTTS2.getId() == speakEngineDialog.engineId);
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            View viewInflate = this.inflater.inflate(R.layout.item_http_tts, viewGroup, false);
            int i2 = R.id.cb_name;
            ATERadioButton aTERadioButton = (ATERadioButton) viewInflate.findViewById(R.id.cb_name);
            if (aTERadioButton != null) {
                i2 = R.id.iv_edit;
                AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_edit);
                if (appCompatImageView != null) {
                    i2 = R.id.iv_menu_delete;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_menu_delete);
                    if (appCompatImageView2 != null) {
                        ItemHttpTtsBinding itemHttpTtsBinding = new ItemHttpTtsBinding((LinearLayout) viewInflate, aTERadioButton, appCompatImageView, appCompatImageView2);
                        j.d(itemHttpTtsBinding, "inflate(inflater, parent, false)");
                        return itemHttpTtsBinding;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            ItemHttpTtsBinding itemHttpTtsBinding = (ItemHttpTtsBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemHttpTtsBinding, "binding");
            final SpeakEngineDialog speakEngineDialog = this.f7204f;
            itemHttpTtsBinding.f6797b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpeakEngineDialog.Adapter adapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    SpeakEngineDialog speakEngineDialog2 = speakEngineDialog;
                    f.c0.c.j.e(adapter, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(speakEngineDialog2, "this$1");
                    HttpTTS item = adapter.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    speakEngineDialog2.engineId = item.getId();
                    adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                }
            });
            itemHttpTtsBinding.f6798c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpeakEngineDialog speakEngineDialog2 = speakEngineDialog;
                    SpeakEngineDialog.Adapter adapter = this;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(speakEngineDialog2, "this$0");
                    f.c0.c.j.e(adapter, "this$1");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    HttpTTS item = adapter.getItem(itemViewHolder2.getLayoutPosition());
                    f.f0.h<Object>[] hVarArr = SpeakEngineDialog.f7195b;
                    speakEngineDialog2.Q(item);
                }
            });
            itemHttpTtsBinding.f6799d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.v0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpeakEngineDialog.Adapter adapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(adapter, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    HttpTTS item = adapter.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    AppDatabaseKt.getAppDb().getHttpTTSDao().delete(item);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SpeakEngineDialog.kt */
    public static final class a extends k implements l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
        public final /* synthetic */ HttpTTS $httpTTS;

        /* JADX INFO: renamed from: io.legado.app.ui.book.read.config.SpeakEngineDialog$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SpeakEngineDialog.kt */
        public static final class C0203a extends k implements f.c0.b.a<View> {
            public final /* synthetic */ DialogHttpTtsEditBinding $alertBinding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0203a(DialogHttpTtsEditBinding dialogHttpTtsEditBinding) {
                super(0);
                this.$alertBinding = dialogHttpTtsEditBinding;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // f.c0.b.a
            @NotNull
            public final View invoke() {
                LinearLayout linearLayout = this.$alertBinding.a;
                j.d(linearLayout, "alertBinding.root");
                return linearLayout;
            }
        }

        /* JADX INFO: compiled from: SpeakEngineDialog.kt */
        public static final class b extends k implements l<DialogInterface, f.v> {
            public final /* synthetic */ DialogHttpTtsEditBinding $alertBinding;
            public final /* synthetic */ HttpTTS $httpTTS;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(DialogHttpTtsEditBinding dialogHttpTtsEditBinding, HttpTTS httpTTS) {
                super(1);
                this.$alertBinding = dialogHttpTtsEditBinding;
                this.$httpTTS = httpTTS;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return f.v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                DialogHttpTtsEditBinding dialogHttpTtsEditBinding = this.$alertBinding;
                HttpTTS httpTTS = this.$httpTTS;
                httpTTS.setName(String.valueOf(dialogHttpTtsEditBinding.f6620b.getText()));
                httpTTS.setUrl(String.valueOf(dialogHttpTtsEditBinding.f6621c.getText()));
                AppDatabaseKt.getAppDb().getHttpTTSDao().insert(httpTTS);
                e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
                e.a.a.f.s.j.f(k.d.a.h.g());
                e.a.a.f.s.j.f5674b = e.a.a.f.s.j.a();
            }
        }

        /* JADX INFO: compiled from: SpeakEngineDialog.kt */
        public static final class c extends k implements l<DialogInterface, f.v> {
            public final /* synthetic */ SpeakEngineDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(SpeakEngineDialog speakEngineDialog) {
                super(1);
                this.this$0 = speakEngineDialog;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) throws IOException {
                invoke2(dialogInterface);
                return f.v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) throws IOException {
                j.e(dialogInterface, "it");
                InputStream inputStreamOpen = this.this$0.requireContext().getAssets().open("help/httpTTSHelp.md");
                j.d(inputStreamOpen, "requireContext().assets.open(\"help/httpTTSHelp.md\")");
                String str = new String(f.w4(inputStreamOpen), f.h0.a.a);
                TextDialog.Companion companion = TextDialog.INSTANCE;
                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                j.d(childFragmentManager, "childFragmentManager");
                TextDialog.Companion.a(companion, childFragmentManager, str, 1, 0L, false, 24);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HttpTTS httpTTS) {
            super(1);
            this.$httpTTS = httpTTS;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            View viewInflate = SpeakEngineDialog.this.getLayoutInflater().inflate(R.layout.dialog_http_tts_edit, (ViewGroup) null, false);
            int i2 = R.id.tv_name;
            EditText editText = (EditText) viewInflate.findViewById(R.id.tv_name);
            if (editText != null) {
                i2 = R.id.tv_url;
                EditText editText2 = (EditText) viewInflate.findViewById(R.id.tv_url);
                if (editText2 != null) {
                    DialogHttpTtsEditBinding dialogHttpTtsEditBinding = new DialogHttpTtsEditBinding((LinearLayout) viewInflate, editText, editText2);
                    j.d(dialogHttpTtsEditBinding, "inflate(layoutInflater)");
                    editText.setText(this.$httpTTS.getName());
                    editText2.setText(this.$httpTTS.getUrl());
                    hVar.d(new C0203a(dialogHttpTtsEditBinding));
                    f.K0(hVar, null, 1, null);
                    hVar.m(new b(dialogHttpTtsEditBinding, this.$httpTTS));
                    hVar.a(R.string.help, new c(SpeakEngineDialog.this));
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class b extends k implements l<SpeakEngineDialog, DialogRecyclerViewBinding> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogRecyclerViewBinding invoke(@NotNull SpeakEngineDialog speakEngineDialog) {
            j.e(speakEngineDialog, "fragment");
            return DialogRecyclerViewBinding.a(speakEngineDialog.requireView());
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends k implements f.c0.b.a<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class d extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ f.c0.b.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f.c0.b.a aVar) {
            super(0);
            this.$ownerProducer = aVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
            j.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    static {
        h<Object>[] hVarArr = new h[2];
        q qVar = new q(v.a(SpeakEngineDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogRecyclerViewBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[0] = qVar;
        f7195b = hVarArr;
    }

    public SpeakEngineDialog() {
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.r1.u0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SpeakEngineDialog speakEngineDialog = this.a;
                Uri uri = (Uri) obj;
                f.f0.h<Object>[] hVarArr = SpeakEngineDialog.f7195b;
                f.c0.c.j.e(speakEngineDialog, "this$0");
                if (uri == null) {
                    return;
                }
                SpeakEngineViewModel speakEngineViewModelR = speakEngineDialog.R();
                Objects.requireNonNull(speakEngineViewModelR);
                f.c0.c.j.e(uri, "uri");
                e.a.a.d.u.b bVarA = BaseViewModel.a(speakEngineViewModelR, null, null, new c4(uri, speakEngineViewModelR, null), 3, null);
                bVarA.d(null, new d4(speakEngineViewModelR, null));
                e.a.a.d.u.b.b(bVarA, null, new e4(speakEngineViewModelR, null), 1);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(FilePicker()) {\n        it?.let {\n            viewModel.importLocal(it)\n        }\n    }");
        this.importDocResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.r1.y0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SpeakEngineDialog speakEngineDialog = this.a;
                Uri uri = (Uri) obj;
                f.f0.h<Object>[] hVarArr = SpeakEngineDialog.f7195b;
                f.c0.c.j.e(speakEngineDialog, "this$0");
                if (uri == null) {
                    return;
                }
                SpeakEngineViewModel speakEngineViewModelR = speakEngineDialog.R();
                Objects.requireNonNull(speakEngineViewModelR);
                f.c0.c.j.e(uri, "uri");
                BaseViewModel.a(speakEngineViewModelR, null, null, new a4(uri, speakEngineViewModelR, null), 3, null);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(FilePicker()) {\n        it?.let {\n            viewModel.export(it)\n        }\n    }");
        this.exportDirResult = activityResultLauncherRegisterForActivityResult2;
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        ViewBindingProperty viewBindingProperty = this.binding;
        h<?>[] hVarArr = f7195b;
        DialogRecyclerViewBinding dialogRecyclerViewBinding = (DialogRecyclerViewBinding) viewBindingProperty.b(this, hVarArr[0]);
        dialogRecyclerViewBinding.f6672c.setBackgroundColor(f.Q2(this));
        dialogRecyclerViewBinding.f6672c.setTitle(R.string.speak_engine);
        ATH.a.b(dialogRecyclerViewBinding.f6671b);
        dialogRecyclerViewBinding.f6671b.setLayoutManager(new LinearLayoutManager(requireContext()));
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        Adapter adapter = new Adapter(this, contextRequireContext);
        j.e(adapter, "<set-?>");
        this.adapter = adapter;
        dialogRecyclerViewBinding.f6671b.setAdapter(adapter);
        dialogRecyclerViewBinding.f6674e.setText(R.string.system_tts);
        AccentTextView accentTextView = dialogRecyclerViewBinding.f6674e;
        j.d(accentTextView, "tvFooterLeft");
        f.c6(accentTextView);
        dialogRecyclerViewBinding.f6674e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SpeakEngineDialog speakEngineDialog = this.a;
                f.f0.h<Object>[] hVarArr2 = SpeakEngineDialog.f7195b;
                f.c0.c.j.e(speakEngineDialog, "this$0");
                e.a.a.h.m.k(speakEngineDialog, "speakEngine");
                speakEngineDialog.dismissAllowingStateLoss();
            }
        });
        AccentTextView accentTextView2 = dialogRecyclerViewBinding.f6675f;
        j.d(accentTextView2, "tvOk");
        f.c6(accentTextView2);
        dialogRecyclerViewBinding.f6675f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SpeakEngineDialog speakEngineDialog = this.a;
                f.f0.h<Object>[] hVarArr2 = SpeakEngineDialog.f7195b;
                f.c0.c.j.e(speakEngineDialog, "this$0");
                long j2 = speakEngineDialog.engineId;
                f.c0.c.j.e(speakEngineDialog, "<this>");
                f.c0.c.j.e("speakEngine", "key");
                Context contextRequireContext2 = speakEngineDialog.requireContext();
                f.c0.c.j.d(contextRequireContext2, "requireContext()");
                SharedPreferences.Editor editorEdit = c.b.a.m.f.i2(contextRequireContext2).edit();
                f.c0.c.j.b(editorEdit, "editor");
                editorEdit.putLong("speakEngine", j2);
                editorEdit.apply();
                speakEngineDialog.dismissAllowingStateLoss();
            }
        });
        AccentTextView accentTextView3 = dialogRecyclerViewBinding.f6673d;
        j.d(accentTextView3, "tvCancel");
        f.c6(accentTextView3);
        dialogRecyclerViewBinding.f6673d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SpeakEngineDialog speakEngineDialog = this.a;
                f.f0.h<Object>[] hVarArr2 = SpeakEngineDialog.f7195b;
                f.c0.c.j.e(speakEngineDialog, "this$0");
                speakEngineDialog.dismissAllowingStateLoss();
            }
        });
        DialogRecyclerViewBinding dialogRecyclerViewBinding2 = (DialogRecyclerViewBinding) this.binding.b(this, hVarArr[0]);
        dialogRecyclerViewBinding2.f6672c.inflateMenu(R.menu.speak_engine);
        Menu menu = dialogRecyclerViewBinding2.f6672c.getMenu();
        j.d(menu, "toolBar.menu");
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        m.b(menu, contextRequireContext2, null, 2);
        dialogRecyclerViewBinding2.f6672c.setOnMenuItemClickListener(this);
        LiveData<List<HttpTTS>> liveData = this.httpTTSData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<HttpTTS>> liveDataObserveAll = AppDatabaseKt.getAppDb().getHttpTTSDao().observeAll();
        this.httpTTSData = liveDataObserveAll;
        if (liveDataObserveAll == null) {
            return;
        }
        liveDataObserveAll.observe(this, new Observer() { // from class: e.a.a.g.d.i.r1.c1
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                SpeakEngineDialog speakEngineDialog = this.a;
                List list = (List) obj;
                f.f0.h<Object>[] hVarArr2 = SpeakEngineDialog.f7195b;
                f.c0.c.j.e(speakEngineDialog, "this$0");
                SpeakEngineDialog.Adapter adapter2 = speakEngineDialog.adapter;
                if (adapter2 != null) {
                    adapter2.x(list);
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
    }

    @SuppressLint({"InflateParams"})
    public final void Q(HttpTTS v) {
        HttpTTS httpTTSCopy$default = v == null ? null : HttpTTS.copy$default(v, 0L, null, null, 7, null);
        if (httpTTSCopy$default == null) {
            httpTTSCopy$default = new HttpTTS(0L, null, null, 7, null);
        }
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        ((i) f.j0(contextRequireContext, Integer.valueOf(R.string.speak_engine), null, new a(httpTTSCopy$default), 2)).p();
    }

    public final SpeakEngineViewModel R() {
        return (SpeakEngineViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_recycler_view, container);
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_add) {
            Q(null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_default) {
            SpeakEngineViewModel speakEngineViewModelR = R();
            Objects.requireNonNull(speakEngineViewModelR);
            BaseViewModel.a(speakEngineViewModelR, null, null, new b4(null), 3, null);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_import_local) {
            this.importDocResult.launch(new e.a.a.g.f.d(1, null, new String[]{"txt", "json"}, null, 10));
            return true;
        }
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_import_onLine) {
            if (numValueOf == null || numValueOf.intValue() != R.id.menu_export) {
                return true;
            }
            this.exportDirResult.launch(null);
            return true;
        }
        f.b bVar = e.a.a.h.f.a;
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        e.a.a.h.f fVarA = f.b.a(bVar, contextRequireContext, null, 0L, 0, false, 14);
        String strA = fVarA.a(this.ttsUrlKey);
        List listL5 = strA == null ? null : c.b.a.m.f.L5(c.b.a.m.f.n5(strA, ","));
        if (listL5 == null) {
            listL5 = new ArrayList();
        }
        Integer numValueOf2 = Integer.valueOf(R.string.import_on_line);
        z3 z3Var = new z3(this, listL5, fVarA);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        ((i) c.b.a.m.f.h0(fragmentActivityRequireActivity, numValueOf2, null, z3Var)).p();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        DisplayMetrics displayMetricsV2 = c.b.a.m.f.V2(fragmentActivityRequireActivity);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), (int) (((double) displayMetricsV2.heightPixels) * 0.9d));
    }
}
