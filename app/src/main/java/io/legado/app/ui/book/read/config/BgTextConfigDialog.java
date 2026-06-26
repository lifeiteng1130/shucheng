package io.legado.app.ui.book.read.config;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.documentfile.provider.DocumentFile;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.multidex.MultiDexExtractor;
import androidx.recyclerview.widget.RecyclerView;
import c.b.a.m.f;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import e.a.a.d.u.b;
import e.a.a.e.c.k;
import e.a.a.g.d.i.r1.b2;
import e.a.a.g.d.i.r1.c2;
import e.a.a.g.d.i.r1.d2;
import e.a.a.g.d.i.r1.j2;
import e.a.a.g.f.d;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogReadBgTextBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.widget.text.StrokeTextView;
import io.legado.app.utils.FileUtils;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010%\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001c0\u001c0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010/\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u001c8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b0\u0010\u001eR$\u00103\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010\u001aR\u0016\u00105\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010\"¨\u00067"}, d2 = {"Lio/legado/app/ui/book/read/config/BgTextConfigDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", ExifInterface.LATITUDE_SOUTH, "()V", "onStart", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", "k", "Landroidx/activity/result/ActivityResultLauncher;", "selectImportDoc", "", "h", "Ljava/lang/String;", "importFormNet", "", "f", OptRuntime.GeneratorState.resumptionPoint_TYPE, "primaryTextColor", ai.aA, "selectBgImage", "Lio/legado/app/ui/book/read/config/BgAdapter;", "e", "Lio/legado/app/ui/book/read/config/BgAdapter;", "adapter", "Lio/legado/app/databinding/DialogReadBgTextBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "R", "()Lio/legado/app/databinding/DialogReadBgTextBinding;", "binding", "d", "configFileName", "j", "selectExportDir", "g", "secondaryTextColor", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BgTextConfigDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7169b;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public BgAdapter adapter;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int primaryTextColor;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int secondaryTextColor;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> selectBgImage;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> selectExportDir;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> selectImportDoc;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new a());

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String configFileName = "readConfig.zip";

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String importFormNet = "网络导入";

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class a extends k implements l<BgTextConfigDialog, DialogReadBgTextBinding> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogReadBgTextBinding invoke(@NotNull BgTextConfigDialog bgTextConfigDialog) {
            j.e(bgTextConfigDialog, "fragment");
            View viewRequireView = bgTextConfigDialog.requireView();
            int i2 = R.id.iv_delete;
            ImageView imageView = (ImageView) viewRequireView.findViewById(R.id.iv_delete);
            if (imageView != null) {
                i2 = R.id.iv_edit;
                ImageView imageView2 = (ImageView) viewRequireView.findViewById(R.id.iv_edit);
                if (imageView2 != null) {
                    i2 = R.id.iv_export;
                    ImageView imageView3 = (ImageView) viewRequireView.findViewById(R.id.iv_export);
                    if (imageView3 != null) {
                        i2 = R.id.iv_import;
                        ImageView imageView4 = (ImageView) viewRequireView.findViewById(R.id.iv_import);
                        if (imageView4 != null) {
                            i2 = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.recycler_view);
                            if (recyclerView != null) {
                                LinearLayout linearLayout = (LinearLayout) viewRequireView;
                                i2 = R.id.sw_dark_status_icon;
                                ATESwitch aTESwitch = (ATESwitch) viewRequireView.findViewById(R.id.sw_dark_status_icon);
                                if (aTESwitch != null) {
                                    i2 = R.id.tv_bg_color;
                                    StrokeTextView strokeTextView = (StrokeTextView) viewRequireView.findViewById(R.id.tv_bg_color);
                                    if (strokeTextView != null) {
                                        i2 = R.id.tv_bg_image;
                                        TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_bg_image);
                                        if (textView != null) {
                                            i2 = R.id.tv_name;
                                            TextView textView2 = (TextView) viewRequireView.findViewById(R.id.tv_name);
                                            if (textView2 != null) {
                                                i2 = R.id.tv_name_title;
                                                TextView textView3 = (TextView) viewRequireView.findViewById(R.id.tv_name_title);
                                                if (textView3 != null) {
                                                    i2 = R.id.tv_restore;
                                                    TextView textView4 = (TextView) viewRequireView.findViewById(R.id.tv_restore);
                                                    if (textView4 != null) {
                                                        i2 = R.id.tv_text_color;
                                                        StrokeTextView strokeTextView2 = (StrokeTextView) viewRequireView.findViewById(R.id.tv_text_color);
                                                        if (strokeTextView2 != null) {
                                                            return new DialogReadBgTextBinding(linearLayout, imageView, imageView2, imageView3, imageView4, recyclerView, linearLayout, aTESwitch, strokeTextView, textView, textView2, textView3, textView4, strokeTextView2);
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
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(v.a(BgTextConfigDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogReadBgTextBinding;");
        Objects.requireNonNull(v.a);
        f7169b = new h[]{qVar};
    }

    public BgTextConfigDialog() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.r1.k
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                String name;
                Object objM11constructorimpl;
                BgTextConfigDialog bgTextConfigDialog = this.a;
                Uri uri = (Uri) obj;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                if (uri == null) {
                    Context contextRequireContext = bgTextConfigDialog.requireContext();
                    f.c0.c.j.d(contextRequireContext, "requireContext()");
                    c.b.a.m.f.R5(contextRequireContext, "选取背景失败，请重试");
                    e.a.a.h.u uVar = e.a.a.h.u.a;
                    e.a.a.h.u.b("BgTextConfigDialog", "获取内容为空");
                    return;
                }
                if (!c.b.a.m.f.t3(uri.toString())) {
                    k.a aVar = new k.a(bgTextConfigDialog);
                    aVar.a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
                    aVar.c(R.string.bg_image_per);
                    aVar.b(new k2(bgTextConfigDialog, uri));
                    aVar.d();
                    return;
                }
                DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(bgTextConfigDialog.requireContext(), uri);
                if (documentFileFromSingleUri == null || (name = documentFileFromSingleUri.getName()) == null) {
                    return;
                }
                FileUtils fileUtils = FileUtils.a;
                Context contextRequireContext2 = bgTextConfigDialog.requireContext();
                f.c0.c.j.d(contextRequireContext2, "requireContext()");
                File fileA = fileUtils.a(c.b.a.m.f.r2(contextRequireContext2), "bg", name);
                try {
                    Context contextRequireContext3 = bgTextConfigDialog.requireContext();
                    f.c0.c.j.d(contextRequireContext3, "requireContext()");
                    Uri uri2 = documentFileFromSingleUri.getUri();
                    f.c0.c.j.d(uri2, "doc.uri");
                    objM11constructorimpl = f.h.m11constructorimpl(e.a.a.h.j.e(contextRequireContext3, uri2));
                } catch (Throwable th) {
                    objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                }
                f.v vVar = null;
                if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                    objM11constructorimpl = null;
                }
                byte[] bArr = (byte[]) objM11constructorimpl;
                if (bArr != null) {
                    f.b0.d.e(fileA, bArr);
                    ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
                    ReadBookConfig.Config durConfig = readBookConfig.getDurConfig();
                    String absolutePath = fileA.getAbsolutePath();
                    f.c0.c.j.d(absolutePath, "file.absolutePath");
                    durConfig.setCurBg(2, absolutePath);
                    readBookConfig.upBg();
                    LiveEventBus.get("upConfig").post(Boolean.FALSE);
                    vVar = f.v.a;
                }
                if (vVar == null) {
                    e.a.a.h.m.m(bgTextConfigDialog, "获取文件出错");
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(ActivityResultContracts.GetContent()) {\n       if(it!=null) {\n           setBgFromUri(it)\n       }else{\n            requireContext().toastOnUi(\"选取背景失败，请重试\")\n            LogUtils.e(TAG,\"获取内容为空\")\n       }\n    }");
        this.selectBgImage = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.r1.q
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BgTextConfigDialog bgTextConfigDialog = this.a;
                Uri uri = (Uri) obj;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                if (uri == null) {
                    return;
                }
                ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
                String strK = f.h0.k.s(readBookConfig.getConfig().getName()) ? bgTextConfigDialog.configFileName : f.c0.c.j.k(readBookConfig.getConfig().getName(), MultiDexExtractor.EXTRACTED_SUFFIX);
                e.a.a.d.u.b bVarN = BaseDialogFragment.N(bgTextConfigDialog, null, null, new w1(bgTextConfigDialog, uri, strK, null), 3, null);
                bVarN.d(null, new x1(bgTextConfigDialog, strK, null));
                e.a.a.d.u.b.b(bVarN, null, new y1(bgTextConfigDialog, null), 1);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(FilePicker()) {\n        it?.let {\n            exportConfig(it)\n        }\n    }");
        this.selectExportDir = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.r1.p
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BgTextConfigDialog bgTextConfigDialog = this.a;
                Uri uri = (Uri) obj;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                if (uri == null) {
                    return;
                }
                if (!f.c0.c.j.a(uri.toString(), bgTextConfigDialog.importFormNet)) {
                    e.a.a.d.u.b.b(BaseDialogFragment.N(bgTextConfigDialog, null, null, new z1(bgTextConfigDialog, uri, null), 3, null), null, new a2(bgTextConfigDialog, null), 1);
                    return;
                }
                g2 g2Var = new g2(bgTextConfigDialog);
                FragmentActivity fragmentActivityRequireActivity = bgTextConfigDialog.requireActivity();
                f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
                ((e.a.a.e.a.i) c.b.a.m.f.g0(fragmentActivityRequireActivity, "输入地址", null, g2Var)).p();
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(FilePicker()) {\n        it ?: return@registerForActivityResult\n        if (it.toString() == importFormNet) {\n            importNetConfigAlert()\n        } else {\n            importConfig(it)\n        }\n    }");
        this.selectImportDoc = activityResultLauncherRegisterForActivityResult3;
    }

    public static final void Q(BgTextConfigDialog bgTextConfigDialog, byte[] bArr) {
        Objects.requireNonNull(bgTextConfigDialog);
        b bVarN = BaseDialogFragment.N(bgTextConfigDialog, null, null, new b2(bgTextConfigDialog, bArr, null), 3, null);
        bVarN.d(null, new c2(bgTextConfigDialog, null));
        b.b(bVarN, null, new d2(bgTextConfigDialog, null), 1);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) throws IOException {
        j.e(view, "view");
        DialogReadBgTextBinding dialogReadBgTextBindingR = R();
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        int iT1 = f.T1(contextRequireContext);
        boolean z = ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d;
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        this.primaryTextColor = f.S2(contextRequireContext2, z);
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        this.secondaryTextColor = f.U2(contextRequireContext3, z);
        dialogReadBgTextBindingR.f6643g.setBackgroundColor(iT1);
        dialogReadBgTextBindingR.f6648l.setTextColor(this.primaryTextColor);
        dialogReadBgTextBindingR.f6647k.setTextColor(this.secondaryTextColor);
        dialogReadBgTextBindingR.f6639c.setColorFilter(this.secondaryTextColor);
        dialogReadBgTextBindingR.m.setTextColor(this.primaryTextColor);
        dialogReadBgTextBindingR.f6644h.setTextColor(this.primaryTextColor);
        dialogReadBgTextBindingR.f6641e.setColorFilter(this.primaryTextColor);
        dialogReadBgTextBindingR.f6640d.setColorFilter(this.primaryTextColor);
        dialogReadBgTextBindingR.f6638b.setColorFilter(this.primaryTextColor);
        dialogReadBgTextBindingR.f6646j.setTextColor(this.primaryTextColor);
        Context contextRequireContext4 = requireContext();
        j.d(contextRequireContext4, "requireContext()");
        BgAdapter bgAdapter = new BgAdapter(contextRequireContext4, this.secondaryTextColor);
        this.adapter = bgAdapter;
        dialogReadBgTextBindingR.f6642f.setAdapter(bgAdapter);
        BgAdapter bgAdapter2 = this.adapter;
        if (bgAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        bgAdapter2.e(new j2(this));
        String[] list = requireContext().getAssets().list("bg");
        if (list != null) {
            BgAdapter bgAdapter3 = this.adapter;
            if (bgAdapter3 == null) {
                j.m("adapter");
                throw null;
            }
            bgAdapter3.x(f.K5(list));
        }
        S();
        final ReadBookConfig.Config durConfig = ReadBookConfig.INSTANCE.getDurConfig();
        R().f6639c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BgTextConfigDialog bgTextConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                Integer numValueOf = Integer.valueOf(R.string.style_name);
                h2 h2Var = new h2(bgTextConfigDialog);
                FragmentActivity fragmentActivityRequireActivity = bgTextConfigDialog.requireActivity();
                f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
                ((e.a.a.e.a.i) c.b.a.m.f.h0(fragmentActivityRequireActivity, numValueOf, null, h2Var)).p();
            }
        });
        R().m.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BgTextConfigDialog bgTextConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                e.a.a.d.m mVar = e.a.a.d.m.a;
                List<ReadBookConfig.Config> listA = e.a.a.d.m.a();
                ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(listA, 10));
                Iterator<T> it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ReadBookConfig.Config) it.next()).getName());
                }
                i2 i2Var = new i2(listA, bgTextConfigDialog);
                FragmentActivity activity = bgTextConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, "选择预设布局", arrayList, i2Var);
            }
        });
        R().f6644h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.i.r1.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                ReadBookConfig.Config config = durConfig;
                BgTextConfigDialog bgTextConfigDialog = this;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(config, "$this_with");
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                config.setCurStatusIconDark(z2);
                FragmentActivity activity = bgTextConfigDialog.getActivity();
                ReadBookActivity readBookActivity = activity instanceof ReadBookActivity ? (ReadBookActivity) activity : null;
                if (readBookActivity == null) {
                    return;
                }
                readBookActivity.l0();
            }
        });
        R().n.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadBookConfig.Config config = durConfig;
                BgTextConfigDialog bgTextConfigDialog = this;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(config, "$this_with");
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                ColorPickerDialog.j jVar = new ColorPickerDialog.j();
                jVar.f2585g = config.curTextColor();
                jVar.f2587i = false;
                jVar.f2583e = 0;
                jVar.f2586h = 121;
                jVar.b(bgTextConfigDialog.requireActivity());
            }
        });
        R().f6645i.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadBookConfig.Config config = durConfig;
                BgTextConfigDialog bgTextConfigDialog = this;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(config, "$this_with");
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                int color = config.curBgType() == 0 ? Color.parseColor(config.curBgStr()) : Color.parseColor("#015A86");
                ColorPickerDialog.j jVar = new ColorPickerDialog.j();
                jVar.f2585g = color;
                jVar.f2587i = false;
                jVar.f2583e = 0;
                jVar.f2586h = 122;
                jVar.b(bgTextConfigDialog.requireActivity());
            }
        });
        R().f6641e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BgTextConfigDialog bgTextConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                bgTextConfigDialog.selectImportDoc.launch(new e.a.a.g.f.d(1, bgTextConfigDialog.getString(R.string.import_str), new String[]{"zip"}, new String[]{bgTextConfigDialog.importFormNet}));
            }
        });
        R().f6640d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BgTextConfigDialog bgTextConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                bgTextConfigDialog.selectExportDir.launch(new e.a.a.g.f.d(0, bgTextConfigDialog.getString(R.string.export_str), null, null, 13));
            }
        });
        R().f6638b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BgTextConfigDialog bgTextConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = BgTextConfigDialog.f7169b;
                f.c0.c.j.e(bgTextConfigDialog, "this$0");
                if (!ReadBookConfig.INSTANCE.deleteDur()) {
                    e.a.a.h.m.m(bgTextConfigDialog, "数量已是最少,不能删除.");
                    return;
                }
                LiveEventBus.get("upConfig").post(Boolean.TRUE);
                bgTextConfigDialog.dismissAllowingStateLoss();
            }
        });
    }

    public final DialogReadBgTextBinding R() {
        return (DialogReadBgTextBinding) this.binding.b(this, f7169b[0]);
    }

    @SuppressLint({"InflateParams"})
    public final void S() {
        ReadBookConfig.Config durConfig = ReadBookConfig.INSTANCE.getDurConfig();
        TextView textView = R().f6647k;
        String name = durConfig.getName();
        if (f.h0.k.s(name)) {
            name = "文字";
        }
        textView.setText(name);
        R().f6644h.setChecked(durConfig.curStatusIconDark());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ((ReadBookActivity) activity).bottomDialog++;
        return inflater.inflate(R.layout.dialog_read_bg_text, container);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        j.e(dialog, "dialog");
        super.onDismiss(dialog);
        ReadBookConfig.INSTANCE.save();
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ReadBookActivity readBookActivity = (ReadBookActivity) activity;
        readBookActivity.bottomDialog--;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(2);
        window.setBackgroundDrawableResource(R.color.background);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setLayout(-1, -2);
    }
}
