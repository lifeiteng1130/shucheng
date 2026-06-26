package io.legado.app.ui.document;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import h.a.a.a.w;
import io.legado.app.databinding.DialogFileChooserBinding;
import io.legado.app.ui.document.adapter.FileAdapter;
import io.legado.app.ui.document.adapter.PathAdapter;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.utils.FileUtils;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: FilePickerDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\\]B\u0007¢\u0006\u0004\b[\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\"H\u0002¢\u0006\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\"\u00101\u001a\u00020\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\u00168V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010.R$\u0010C\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010)\u001a\u0004\b@\u0010A\"\u0004\bB\u0010%R\u0016\u0010F\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001d\u0010L\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bN\u0010OR*\u0010V\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u0001068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bQ\u00108\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010Z\u001a\u00020\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bW\u0010,\u001a\u0004\bX\u0010.\"\u0004\bY\u00100¨\u0006^"}, d2 = {"Lio/legado/app/ui/document/FilePickerDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lio/legado/app/ui/document/adapter/FileAdapter$a;", "Lio/legado/app/ui/document/adapter/PathAdapter$a;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "", "position", "p", "(I)V", "C", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "", "currentPath", "O", "(Ljava/lang/String;)V", "path", "P", ai.aA, "Ljava/lang/String;", "initPath", "f", "Z", "B", "()Z", "setShowUpDir", "(Z)V", "isShowUpDir", "g", "M", "setShowHideDir", "isShowHideDir", "", "m", "[Ljava/lang/String;", "menus", "Lio/legado/app/ui/document/adapter/FileAdapter;", "k", "Lio/legado/app/ui/document/adapter/FileAdapter;", "fileAdapter", "isSelectDir", "h", "getTitle", "()Ljava/lang/String;", "setTitle", "title", "j", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mode", "Lio/legado/app/databinding/DialogFileChooserBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "N", "()Lio/legado/app/databinding/DialogFileChooserBinding;", "binding", "Lio/legado/app/ui/document/adapter/PathAdapter;", Constants.LANDSCAPE, "Lio/legado/app/ui/document/adapter/PathAdapter;", "pathAdapter", "d", ai.aE, "()[Ljava/lang/String;", "setAllowExtensions", "([Ljava/lang/String;)V", "allowExtensions", "e", "w", "setShowHomeDir", "isShowHomeDir", "<init>", ai.at, "b", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FilePickerDialog extends DialogFragment implements Toolbar.OnMenuItemClickListener, FileAdapter.a, PathAdapter.a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7365b;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String[] allowExtensions;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean isShowHomeDir;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean isShowHideDir;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String title;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String initPath;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int mode;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public FileAdapter fileAdapter;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public PathAdapter pathAdapter;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public String[] menus;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new c());

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isShowUpDir = true;

    /* JADX INFO: compiled from: FilePickerDialog.kt */
    public interface a {
        void D0(@NotNull Intent intent);
    }

    /* JADX INFO: renamed from: io.legado.app.ui.document.FilePickerDialog$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: FilePickerDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }

        public static void a(Companion companion, FragmentManager fragmentManager, int i2, String str, String str2, boolean z, boolean z2, boolean z3, String[] strArr, String[] strArr2, int i3) {
            if ((i3 & 2) != 0) {
                i2 = 1;
            }
            int i4 = i3 & 4;
            int i5 = i3 & 8;
            if ((i3 & 16) != 0) {
                z = false;
            }
            if ((i3 & 32) != 0) {
                z2 = true;
            }
            if ((i3 & 64) != 0) {
                z3 = false;
            }
            if ((i3 & 128) != 0) {
                strArr = null;
            }
            int i6 = i3 & 256;
            Objects.requireNonNull(companion);
            j.e(fragmentManager, "manager");
            FilePickerDialog filePickerDialog = new FilePickerDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("mode", i2);
            bundle.putString("title", null);
            bundle.putBoolean("isShowHomeDir", z);
            bundle.putBoolean("isShowUpDir", z2);
            bundle.putBoolean("isShowHideDir", z3);
            bundle.putString("initPath", null);
            bundle.putStringArray("allowExtensions", strArr);
            bundle.putStringArray("menus", null);
            filePickerDialog.setArguments(bundle);
            filePickerDialog.show(fragmentManager, "FileChooserDialog");
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class c extends k implements l<FilePickerDialog, DialogFileChooserBinding> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogFileChooserBinding invoke(@NotNull FilePickerDialog filePickerDialog) {
            j.e(filePickerDialog, "fragment");
            View viewRequireView = filePickerDialog.requireView();
            int i2 = R.id.rv_file;
            RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.rv_file);
            if (recyclerView != null) {
                i2 = R.id.rv_path;
                RecyclerView recyclerView2 = (RecyclerView) viewRequireView.findViewById(R.id.rv_path);
                if (recyclerView2 != null) {
                    i2 = R.id.tool_bar;
                    Toolbar toolbar = (Toolbar) viewRequireView.findViewById(R.id.tool_bar);
                    if (toolbar != null) {
                        i2 = R.id.tv_empty;
                        TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_empty);
                        if (textView != null) {
                            return new DialogFileChooserBinding((LinearLayout) viewRequireView, recyclerView, recyclerView2, toolbar, textView);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(v.a(FilePickerDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogFileChooserBinding;");
        Objects.requireNonNull(v.a);
        f7365b = new h[]{qVar};
        INSTANCE = new Companion(null);
    }

    public FilePickerDialog() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        try {
            absolutePath = new File(absolutePath).getCanonicalPath();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        j.d(absolutePath, "sdCardDirectory");
        this.initPath = absolutePath;
        this.mode = 1;
    }

    @Override // io.legado.app.ui.document.adapter.FileAdapter.a
    /* JADX INFO: renamed from: B, reason: from getter */
    public boolean getIsShowUpDir() {
        return this.isShowUpDir;
    }

    @Override // io.legado.app.ui.document.adapter.PathAdapter.a
    public void C(int position) throws IOException {
        String string;
        PathAdapter pathAdapter = this.pathAdapter;
        if (pathAdapter == null) {
            j.m("pathAdapter");
            throw null;
        }
        StringBuilder sb = new StringBuilder(j.k(PathAdapter.f7384g, w.DEFAULT_PATH_SEPARATOR));
        if (position == 0) {
            string = sb.toString();
            j.d(string, "tmp.toString()");
        } else {
            int i2 = 1;
            if (1 <= position) {
                while (true) {
                    int i3 = i2 + 1;
                    sb.append(pathAdapter.paths.get(i2));
                    sb.append(w.DEFAULT_PATH_SEPARATOR);
                    if (i2 == position) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            string = sb.toString();
            j.d(string, "tmp.toString()");
        }
        O(string);
    }

    @Override // io.legado.app.ui.document.adapter.FileAdapter.a
    /* JADX INFO: renamed from: M, reason: from getter */
    public boolean getIsShowHideDir() {
        return this.isShowHideDir;
    }

    public final DialogFileChooserBinding N() {
        return (DialogFileChooserBinding) this.binding.b(this, f7365b[0]);
    }

    public final void O(String currentPath) throws IOException {
        if (j.a(currentPath, w.DEFAULT_PATH_SEPARATOR)) {
            PathAdapter pathAdapter = this.pathAdapter;
            if (pathAdapter == null) {
                j.m("pathAdapter");
                throw null;
            }
            pathAdapter.A(w.DEFAULT_PATH_SEPARATOR);
        } else {
            PathAdapter pathAdapter2 = this.pathAdapter;
            if (pathAdapter2 == null) {
                j.m("pathAdapter");
                throw null;
            }
            pathAdapter2.A(currentPath);
        }
        FileAdapter fileAdapter = this.fileAdapter;
        if (fileAdapter == null) {
            j.m("fileAdapter");
            throw null;
        }
        if (currentPath != null) {
            ArrayList arrayList = new ArrayList();
            if (fileAdapter.rootPath == null) {
                fileAdapter.rootPath = currentPath;
            }
            fileAdapter.currentPath = currentPath;
            if (fileAdapter.callBack.getIsShowHomeDir()) {
                e.a.a.g.f.f.a aVar = new e.a.a.g.f.f.a();
                aVar.setDirectory(true);
                aVar.setIcon(fileAdapter.homeIcon);
                aVar.setName(".");
                aVar.setSize(0L);
                String str = fileAdapter.rootPath;
                if (str == null) {
                    str = currentPath;
                }
                aVar.setPath(str);
                arrayList.add(aVar);
            }
            if (fileAdapter.callBack.getIsShowUpDir()) {
                PathAdapter pathAdapter3 = PathAdapter.f7383f;
                if (!j.a(currentPath, PathAdapter.f7384g)) {
                    e.a.a.g.f.f.a aVar2 = new e.a.a.g.f.f.a();
                    aVar2.setDirectory(true);
                    aVar2.setIcon(fileAdapter.upIcon);
                    aVar2.setName("..");
                    aVar2.setSize(0L);
                    String parent = new File(currentPath).getParent();
                    if (parent == null) {
                        parent = "";
                    }
                    aVar2.setPath(parent);
                    arrayList.add(aVar2);
                }
            }
            String str2 = fileAdapter.currentPath;
            if (str2 != null) {
                File[] fileArrP = FileUtils.p(FileUtils.a, str2, null, 2);
                if (fileArrP != null) {
                    Iterator itI3 = f.I3(fileArrP);
                    while (true) {
                        f.c0.c.a aVar3 = (f.c0.c.a) itI3;
                        if (!aVar3.hasNext()) {
                            break;
                        }
                        File file = (File) aVar3.next();
                        if (file != null) {
                            if (!fileAdapter.callBack.getIsShowHideDir()) {
                                String name = file.getName();
                                j.d(name, "file.name");
                                if (f.h0.k.K(name, ".", false, 2)) {
                                }
                            }
                            e.a.a.g.f.f.a aVar4 = new e.a.a.g.f.f.a();
                            boolean zIsDirectory = file.isDirectory();
                            aVar4.setDirectory(zIsDirectory);
                            if (zIsDirectory) {
                                aVar4.setIcon(fileAdapter.folderIcon);
                                aVar4.setSize(0L);
                            } else {
                                aVar4.setIcon(fileAdapter.fileIcon);
                                aVar4.setSize(file.length());
                            }
                            aVar4.setName(file.getName());
                            String absolutePath = file.getAbsolutePath();
                            j.d(absolutePath, "file.absolutePath");
                            aVar4.setPath(absolutePath);
                            arrayList.add(aVar4);
                        }
                    }
                }
                fileAdapter.x(arrayList);
            }
        }
        FileAdapter fileAdapter2 = this.fileAdapter;
        if (fileAdapter2 == null) {
            j.m("fileAdapter");
            throw null;
        }
        int itemCount = fileAdapter2.getItemCount();
        if (this.isShowHomeDir) {
            itemCount--;
        }
        if (this.isShowUpDir) {
            itemCount--;
        }
        if (itemCount >= 1) {
            TextView textView = N().f6617e;
            j.d(textView, "binding.tvEmpty");
            f.e3(textView);
        } else {
            TextView textView2 = N().f6617e;
            j.d(textView2, "binding.tvEmpty");
            f.c6(textView2);
            N().f6617e.setText(R.string.empty);
        }
    }

    public final void P(String path) {
        Intent data = new Intent().setData(Uri.fromFile(new File(path)));
        j.d(data, "Intent().setData(Uri.fromFile(File(path)))");
        ActivityResultCaller parentFragment = getParentFragment();
        a aVar = parentFragment instanceof a ? (a) parentFragment : null;
        if (aVar != null) {
            aVar.D0(data);
        }
        KeyEventDispatcher.Component activity = getActivity();
        a aVar2 = activity instanceof a ? (a) activity : null;
        if (aVar2 == null) {
            return;
        }
        aVar2.D0(data);
    }

    @Override // io.legado.app.ui.document.adapter.FileAdapter.a
    public boolean f() {
        return this.mode == 0;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_file_chooser, container, true);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        j.e(dialog, "dialog");
        super.onDismiss(dialog);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_ok) {
            return true;
        }
        FileAdapter fileAdapter = this.fileAdapter;
        if (fileAdapter == null) {
            j.m("fileAdapter");
            throw null;
        }
        String str = fileAdapter.currentPath;
        if (str == null) {
            return true;
        }
        P(str);
        dismissAllowingStateLoss();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        DisplayMetrics displayMetricsV2 = f.V2(fragmentActivityRequireActivity);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), (int) (((double) displayMetricsV2.heightPixels) * 0.8d));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) throws IOException {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        N().f6616d.setBackgroundColor(f.Q2(this));
        view.setBackgroundResource(R.color.background_card);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mode = arguments.getInt("mode", 1);
            this.title = arguments.getString("title");
            this.isShowHomeDir = arguments.getBoolean("isShowHomeDir");
            this.isShowUpDir = arguments.getBoolean("isShowUpDir");
            this.isShowHideDir = arguments.getBoolean("isShowHideDir");
            String string = arguments.getString("initPath");
            if (string != null) {
                this.initPath = string;
            }
            this.allowExtensions = arguments.getStringArray("allowExtensions");
            this.menus = arguments.getStringArray("menus");
        }
        Toolbar toolbar = N().f6616d;
        String string2 = this.title;
        if (string2 == null) {
            string2 = f() ? getString(R.string.folder_chooser) : getString(R.string.file_chooser);
        }
        toolbar.setTitle(string2);
        N().f6616d.inflateMenu(R.menu.file_chooser);
        if (f()) {
            N().f6616d.getMenu().findItem(R.id.menu_ok).setVisible(true);
        }
        String[] strArr = this.menus;
        if (strArr != null) {
            for (String str : strArr) {
                N().f6616d.getMenu().add(str);
            }
        }
        Menu menu = N().f6616d.getMenu();
        j.d(menu, "binding.toolBar.menu");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
        N().f6616d.setOnMenuItemClickListener(this);
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        this.fileAdapter = new FileAdapter(contextRequireContext2, this);
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        this.pathAdapter = new PathAdapter(contextRequireContext3, this);
        RecyclerView recyclerView = N().f6614b;
        Context contextRequireContext4 = requireContext();
        j.d(contextRequireContext4, "requireContext()");
        recyclerView.addItemDecoration(new VerticalDivider(contextRequireContext4));
        N().f6614b.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView2 = N().f6614b;
        FileAdapter fileAdapter = this.fileAdapter;
        if (fileAdapter == null) {
            j.m("fileAdapter");
            throw null;
        }
        recyclerView2.setAdapter(fileAdapter);
        N().f6615c.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        RecyclerView recyclerView3 = N().f6615c;
        PathAdapter pathAdapter = this.pathAdapter;
        if (pathAdapter == null) {
            j.m("pathAdapter");
            throw null;
        }
        recyclerView3.setAdapter(pathAdapter);
        O(this.initPath);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    @Override // io.legado.app.ui.document.adapter.FileAdapter.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p(int r7) throws java.io.IOException {
        /*
            r6 = this;
            io.legado.app.ui.document.adapter.FileAdapter r0 = r6.fileAdapter
            r1 = 0
            if (r0 == 0) goto L8c
            java.util.List<ITEM> r0 = r0.items
            java.lang.Object r7 = f.x.e.n(r0, r7)
            e.a.a.g.f.f.a r7 = (e.a.a.g.f.f.a) r7
            if (r7 != 0) goto L11
            r0 = r1
            goto L19
        L11:
            boolean r0 = r7.isDirectory()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L19:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r0 = f.c0.c.j.a(r0, r2)
            if (r0 == 0) goto L2a
            java.lang.String r7 = r7.getPath()
            r6.O(r7)
            goto L8b
        L2a:
            if (r7 != 0) goto L2d
            goto L8b
        L2d:
            java.lang.String r7 = r7.getPath()
            if (r7 != 0) goto L34
            goto L8b
        L34:
            int r0 = r6.mode
            if (r0 != 0) goto L3e
            java.lang.String r7 = "这是文件夹选择,不能选择文件,点击右上角的确定选择文件夹"
            e.a.a.h.m.m(r6, r7)
            goto L8b
        L3e:
            java.lang.String[] r0 = r6.allowExtensions
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L4f
            int r5 = r0.length
            if (r5 != 0) goto L49
            r5 = 1
            goto L4a
        L49:
            r5 = 0
        L4a:
            if (r5 == 0) goto L4d
            goto L4f
        L4d:
            r5 = 0
            goto L50
        L4f:
            r5 = 1
        L50:
            if (r5 != 0) goto L85
            if (r0 != 0) goto L55
            goto L78
        L55:
            java.lang.String r1 = "pathOrUrl"
            f.c0.c.j.e(r7, r1)
            r1 = 46
            r5 = 6
            int r1 = f.h0.k.t(r7, r1, r3, r3, r5)
            if (r1 < 0) goto L6e
            int r1 = r1 + r4
            java.lang.String r1 = r7.substring(r1)
            java.lang.String r3 = "(this as java.lang.String).substring(startIndex)"
            f.c0.c.j.d(r1, r3)
            goto L70
        L6e:
            java.lang.String r1 = "ext"
        L70:
            boolean r0 = c.b.a.m.f.b1(r0, r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
        L78:
            boolean r0 = f.c0.c.j.a(r1, r2)
            if (r0 == 0) goto L7f
            goto L85
        L7f:
            java.lang.String r7 = "不能打开此文件"
            e.a.a.h.m.m(r6, r7)
            goto L8b
        L85:
            r6.P(r7)
            r6.dismissAllowingStateLoss()
        L8b:
            return
        L8c:
            java.lang.String r7 = "fileAdapter"
            f.c0.c.j.m(r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.document.FilePickerDialog.p(int):void");
    }

    @Override // io.legado.app.ui.document.adapter.FileAdapter.a
    @Nullable
    /* JADX INFO: renamed from: u, reason: from getter */
    public String[] getAllowExtensions() {
        return this.allowExtensions;
    }

    @Override // io.legado.app.ui.document.adapter.FileAdapter.a
    /* JADX INFO: renamed from: w, reason: from getter */
    public boolean getIsShowHomeDir() {
        return this.isShowHomeDir;
    }
}
