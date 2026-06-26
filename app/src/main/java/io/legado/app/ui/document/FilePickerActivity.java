package io.legado.app.ui.document;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.c.e;
import e.a.a.e.a.h;
import e.a.a.e.a.i;
import e.a.a.e.c.k;
import e.a.a.g.f.c;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.base.BaseActivity;
import io.legado.app.databinding.ActivityTranslucenceBinding;
import io.legado.app.ui.document.FilePickerActivity;
import io.legado.app.ui.document.FilePickerDialog;
import io.wenyuange.app.release.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FilePickerActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fRB\u0010\u0013\u001a.\u0012*\u0012(\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0014\u0012\u000e\b\u0001\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e0\u000e0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00140\u00140\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lio/legado/app/ui/document/FilePickerActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityTranslucenceBinding;", "Lio/legado/app/ui/document/FilePickerDialog$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "data", "D0", "(Landroid/content/Intent;)V", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", ai.aA, "Landroidx/activity/result/ActivityResultLauncher;", "selectDoc", "Landroid/net/Uri;", "h", "selectDocTree", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FilePickerActivity extends BaseActivity<ActivityTranslucenceBinding> implements FilePickerDialog.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7362g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Uri> selectDocTree;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String[]> selectDoc;

    /* JADX INFO: compiled from: FilePickerActivity.kt */
    public static final class a extends k implements l<h<? extends DialogInterface>, v> {
        public final /* synthetic */ String[] $allowExtensions;
        public final /* synthetic */ int $mode;
        public final /* synthetic */ ArrayList<String> $selectList;
        public final /* synthetic */ FilePickerActivity this$0;

        /* JADX INFO: renamed from: io.legado.app.ui.document.FilePickerActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FilePickerActivity.kt */
        public static final class C0208a extends k implements p<DialogInterface, Integer, v> {
            public final /* synthetic */ String[] $allowExtensions;
            public final /* synthetic */ int $mode;
            public final /* synthetic */ ArrayList<String> $selectList;
            public final /* synthetic */ FilePickerActivity this$0;

            /* JADX INFO: renamed from: io.legado.app.ui.document.FilePickerActivity$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: FilePickerActivity.kt */
            public static final class C0209a extends k implements f.c0.b.a<v> {
                public final /* synthetic */ FilePickerActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0209a(FilePickerActivity filePickerActivity) {
                    super(0);
                    this.this$0 = filePickerActivity;
                }

                @Override // f.c0.b.a
                public /* bridge */ /* synthetic */ v invoke() {
                    invoke2();
                    return v.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FilePickerDialog.Companion companion = FilePickerDialog.INSTANCE;
                    FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                    j.d(supportFragmentManager, "supportFragmentManager");
                    FilePickerDialog.Companion.a(companion, supportFragmentManager, 0, null, null, false, false, false, null, null, 508);
                }
            }

            /* JADX INFO: renamed from: io.legado.app.ui.document.FilePickerActivity$a$a$b */
            /* JADX INFO: compiled from: FilePickerActivity.kt */
            public static final class b extends k implements f.c0.b.a<v> {
                public final /* synthetic */ String[] $allowExtensions;
                public final /* synthetic */ FilePickerActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(FilePickerActivity filePickerActivity, String[] strArr) {
                    super(0);
                    this.this$0 = filePickerActivity;
                    this.$allowExtensions = strArr;
                }

                @Override // f.c0.b.a
                public /* bridge */ /* synthetic */ v invoke() {
                    invoke2();
                    return v.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FilePickerDialog.Companion companion = FilePickerDialog.INSTANCE;
                    FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                    j.d(supportFragmentManager, "supportFragmentManager");
                    FilePickerDialog.Companion.a(companion, supportFragmentManager, 1, null, null, false, false, false, this.$allowExtensions, null, 380);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0208a(int i2, FilePickerActivity filePickerActivity, String[] strArr, ArrayList<String> arrayList) {
                super(2);
                this.$mode = i2;
                this.this$0 = filePickerActivity;
                this.$allowExtensions = strArr;
                this.$selectList = arrayList;
            }

            @Override // f.c0.b.p
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
                invoke(dialogInterface, num.intValue());
                return v.a;
            }

            public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
                j.e(dialogInterface, "$noName_0");
                boolean z = true;
                if (i2 != 0) {
                    if (i2 == 1) {
                        if (this.$mode == 0) {
                            FilePickerActivity filePickerActivity = this.this$0;
                            FilePickerActivity.T0(filePickerActivity, new C0209a(filePickerActivity));
                            return;
                        } else {
                            FilePickerActivity filePickerActivity2 = this.this$0;
                            FilePickerActivity.T0(filePickerActivity2, new b(filePickerActivity2, this.$allowExtensions));
                            return;
                        }
                    }
                    String str = this.$selectList.get(i2);
                    j.d(str, "selectList[index]");
                    String str2 = str;
                    Uri uriFromFile = f.t3(str2) ? Uri.fromFile(new File(str2)) : Uri.parse(str2);
                    FilePickerActivity filePickerActivity3 = this.this$0;
                    Intent data = new Intent().setData(uriFromFile);
                    j.d(data, "Intent().setData(uri)");
                    filePickerActivity3.D0(data);
                    return;
                }
                if (this.$mode == 0) {
                    this.this$0.selectDocTree.launch(null);
                    return;
                }
                FilePickerActivity filePickerActivity4 = this.this$0;
                ActivityResultLauncher<String[]> activityResultLauncher = filePickerActivity4.selectDoc;
                String[] strArr = this.$allowExtensions;
                Objects.requireNonNull(filePickerActivity4);
                HashSet hashSet = new HashSet();
                if (strArr != null) {
                    if (!(strArr.length == 0)) {
                        z = false;
                    }
                }
                if (z) {
                    hashSet.add("*/*");
                } else {
                    int length = strArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        String str3 = strArr[i3];
                        int iHashCode = str3.hashCode();
                        if (iHashCode != 42) {
                            if (iHashCode != 115312) {
                                hashSet.add("text/*");
                            } else {
                                hashSet.add("text/*");
                            }
                        } else if (str3.equals("*")) {
                            hashSet.add("*/*");
                        } else {
                            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str3);
                            if (mimeTypeFromExtension == null) {
                                mimeTypeFromExtension = "application/octet-stream";
                            }
                            hashSet.add(mimeTypeFromExtension);
                        }
                    }
                }
                Object[] array = hashSet.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                activityResultLauncher.launch((String[]) array);
            }
        }

        /* JADX INFO: compiled from: FilePickerActivity.kt */
        public static final class b extends k implements l<DialogInterface, v> {
            public final /* synthetic */ FilePickerActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(FilePickerActivity filePickerActivity) {
                super(1);
                this.this$0 = filePickerActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                this.this$0.finish();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ArrayList<String> arrayList, int i2, FilePickerActivity filePickerActivity, String[] strArr) {
            super(1);
            this.$selectList = arrayList;
            this.$mode = i2;
            this.this$0 = filePickerActivity;
            this.$allowExtensions = strArr;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            ArrayList<String> arrayList = this.$selectList;
            hVar.b(arrayList, new C0208a(this.$mode, this.this$0, this.$allowExtensions, arrayList));
            hVar.j(new b(this.this$0));
        }
    }

    public FilePickerActivity() {
        super(false, e.Transparent, null, false, false, 29);
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.OpenDocumentTree(), new ActivityResultCallback() { // from class: e.a.a.g.f.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FilePickerActivity filePickerActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = FilePickerActivity.f7362g;
                j.e(filePickerActivity, "this$0");
                if (uri == null) {
                    return;
                }
                j.d(uri, "it");
                if (f.s3(uri)) {
                    filePickerActivity.getContentResolver().takePersistableUriPermission(uri, 3);
                }
                Intent data = new Intent().setData(uri);
                j.d(data, "Intent().setData(it)");
                filePickerActivity.D0(data);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(ActivityResultContracts.OpenDocumentTree()) {\n            it ?: return@registerForActivityResult\n            if (it.isContentScheme()) {\n                contentResolver.takePersistableUriPermission(\n                    it,\n                    Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION\n                )\n            }\n            onResult(Intent().setData(it))\n        }");
        this.selectDocTree = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.OpenDocument(), new ActivityResultCallback() { // from class: e.a.a.g.f.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FilePickerActivity filePickerActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = FilePickerActivity.f7362g;
                j.e(filePickerActivity, "this$0");
                if (uri == null) {
                    return;
                }
                Intent data = new Intent().setData(uri);
                j.d(data, "Intent().setData(it)");
                filePickerActivity.D0(data);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(ActivityResultContracts.OpenDocument()) {\n        it ?: return@registerForActivityResult\n        onResult(Intent().setData(it))\n    }");
        this.selectDoc = activityResultLauncherRegisterForActivityResult2;
    }

    public static final void T0(FilePickerActivity filePickerActivity, f.c0.b.a aVar) {
        Objects.requireNonNull(filePickerActivity);
        k.a aVar2 = new k.a(filePickerActivity);
        String[] strArr = e.a.a.e.c.j.a;
        aVar2.a((String[]) Arrays.copyOf(strArr, strArr.length));
        aVar2.c(R.string.tip_perm_request_storage);
        aVar2.b(new c(aVar));
        aVar2.d();
    }

    @Override // io.legado.app.ui.document.FilePickerDialog.a
    public void D0(@NotNull Intent data) {
        j.e(data, "data");
        if (data.getData() != null) {
            setResult(-1, data);
        }
        finish();
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        ActivityTranslucenceBinding activityTranslucenceBindingA = ActivityTranslucenceBinding.a(getLayoutInflater());
        j.d(activityTranslucenceBindingA, "inflate(layoutInflater)");
        return activityTranslucenceBindingA;
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        int intExtra = getIntent().getIntExtra("mode", 0);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("allowExtensions");
        ArrayList arrayListA = intExtra == 0 ? f.x.e.a(getString(R.string.sys_folder_picker)) : f.x.e.a(getString(R.string.sys_file_picker));
        if (Build.VERSION.SDK_INT <= 29) {
            arrayListA.add(getString(R.string.app_folder_picker));
        }
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("otherActions");
        if (stringArrayListExtra != null) {
            arrayListA.addAll(stringArrayListExtra);
        }
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra == null) {
            stringExtra = intExtra == 0 ? getString(R.string.select_folder) : getString(R.string.select_file);
        }
        j.d(stringExtra, "intent.getStringExtra(\"title\") ?: let {\n            if (mode == FilePicker.DIRECTORY) {\n                return@let getString(R.string.select_folder)\n            } else {\n                return@let getString(R.string.select_file)\n            }\n        }");
        ((i) f.i0(this, stringExtra, null, new a(arrayListA, intExtra, this, stringArrayExtra), 2)).p();
    }
}
