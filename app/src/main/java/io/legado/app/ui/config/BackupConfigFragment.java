package io.legado.app.ui.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.d.e;
import e.a.a.d.u.b;
import e.a.a.d.w.q;
import e.a.a.e.a.i;
import e.a.a.e.c.k;
import e.a.a.g.e.b0;
import e.a.a.g.e.r;
import e.a.a.g.e.w;
import e.a.a.g.e.x;
import e.a.a.g.e.y;
import e.a.a.g.f.d;
import e.a.a.h.m;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import g.b.k0;
import io.legado.app.base.BasePreferenceFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.config.BackupConfigFragment;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: BackupConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b4\u0010\u001aJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b&\u0010'R$\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010/\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010,R$\u00101\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010,R$\u00103\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010,¨\u00065"}, d2 = {"Lio/legado/app/ui/config/BackupConfigFragment;", "Lio/legado/app/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "Lf/v;", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "Landroid/view/MenuInflater;", "inflater", "onCreateOptionsMenu", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "onDestroy", "()V", "Landroid/content/SharedPreferences;", "sharedPreferences", "key", "onSharedPreferenceChanged", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "Landroidx/preference/Preference;", "preference", "onPreferenceTreeClick", "(Landroidx/preference/Preference;)Z", "preferenceKey", ES6Iterator.VALUE_PROPERTY, "N", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", "f", "Landroidx/activity/result/ActivityResultLauncher;", "restoreOld", "d", "backupDir", "e", "restoreDir", ai.aD, "selectBackupPath", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BackupConfigFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7345b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> selectBackupPath;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> backupDir;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> restoreDir;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<d> restoreOld;

    /* JADX INFO: compiled from: BackupConfigFragment.kt */
    public static final class a extends k implements f.c0.b.a<v> {
        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BackupConfigFragment.this.restoreDir.launch(null);
        }
    }

    public BackupConfigFragment() {
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.e.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Uri uri = (Uri) obj;
                int i2 = BackupConfigFragment.f7345b;
                if (uri == null) {
                    return;
                }
                if (c.b.a.m.f.s3(uri)) {
                    e.a.a.d.e.a.o(uri.toString());
                } else {
                    e.a.a.d.e.a.o(uri.getPath());
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            AppConfig.backupPath = uri.toString()\n        } else {\n            AppConfig.backupPath = uri.path\n        }\n    }");
        this.selectBackupPath = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.e.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Uri uri = (Uri) obj;
                int i2 = BackupConfigFragment.f7345b;
                if (uri == null) {
                    return;
                }
                if (c.b.a.m.f.s3(uri)) {
                    e.a.a.d.e.a.o(uri.toString());
                    b.C0148b.b(e.a.a.d.u.b.a, null, null, new s(uri, null), 3).d(null, new t(null));
                    return;
                }
                String path = uri.getPath();
                if (path == null) {
                    return;
                }
                e.a.a.d.e.a.o(path);
                b.C0148b.b(e.a.a.d.u.b.a, null, null, new u(path, null), 3).d(null, new v(null));
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            AppConfig.backupPath = uri.toString()\n            Coroutine.async {\n                Backup.backup(appCtx, uri.toString())\n            }.onSuccess {\n                appCtx.toastOnUi(R.string.backup_success)\n            }\n        } else {\n            uri.path?.let { path ->\n                AppConfig.backupPath = path\n                Coroutine.async {\n                    Backup.backup(appCtx, path)\n                }.onSuccess {\n                    appCtx.toastOnUi(R.string.backup_success)\n                }\n            }\n        }\n    }");
        this.backupDir = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.e.g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Uri uri = (Uri) obj;
                int i2 = BackupConfigFragment.f7345b;
                if (uri == null) {
                    return;
                }
                if (c.b.a.m.f.s3(uri)) {
                    e.a.a.d.e.a.o(uri.toString());
                    b.C0148b.b(e.a.a.d.u.b.a, null, null, new z(uri, null), 3);
                    return;
                }
                String path = uri.getPath();
                if (path == null) {
                    return;
                }
                e.a.a.d.e.a.o(path);
                b.C0148b.b(e.a.a.d.u.b.a, null, null, new a0(path, null), 3);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(FilePicker()) { uri ->\n        uri ?: return@registerForActivityResult\n        if (uri.isContentScheme()) {\n            AppConfig.backupPath = uri.toString()\n            Coroutine.async {\n                Restore.restore(appCtx, uri.toString())\n            }\n        } else {\n            uri.path?.let { path ->\n                AppConfig.backupPath = path\n                Coroutine.async {\n                    Restore.restore(appCtx, path)\n                }\n            }\n        }\n    }");
        this.restoreDir = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher<d> activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.e.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws IllegalAccessException, InvocationTargetException {
                String str;
                Object objM11constructorimpl;
                Object objM11constructorimpl2;
                Object objM11constructorimpl3;
                DocumentFile[] documentFileArrListFiles;
                DocumentFile[] documentFileArr;
                int i2;
                int i3;
                Object objM11constructorimpl4;
                f.v vVar;
                Object objM11constructorimpl5;
                f.v vVar2;
                Object objM11constructorimpl6;
                f.v vVar3;
                Uri uri = (Uri) obj;
                int i4 = BackupConfigFragment.f7345b;
                if (uri == null) {
                    return;
                }
                Context contextG = k.d.a.h.g();
                f.c0.c.j.e(contextG, com.umeng.analytics.pro.c.R);
                f.c0.c.j.e(uri, "uri");
                if (c.b.a.m.f.s3(uri)) {
                    DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(contextG, uri);
                    if (documentFileFromTreeUri == null || (documentFileArrListFiles = documentFileFromTreeUri.listFiles()) == null) {
                        return;
                    }
                    int length = documentFileArrListFiles.length;
                    int i5 = 0;
                    while (i5 < length) {
                        DocumentFile documentFile = documentFileArrListFiles[i5];
                        String name = documentFile.getName();
                        if (name != null) {
                            documentFileArr = documentFileArrListFiles;
                            int iHashCode = name.hashCode();
                            i2 = length;
                            i3 = i5;
                            if (iHashCode != 230188262) {
                                if (iHashCode != 242484507) {
                                    if (iHashCode == 684250817 && name.equals("myBookShelf.json")) {
                                        try {
                                            Uri uri2 = documentFile.getUri();
                                            f.c0.c.j.d(uri2, "doc.uri");
                                            String strF = e.a.a.h.j.f(contextG, uri2);
                                            if (strF == null) {
                                                vVar3 = null;
                                            } else {
                                                c.b.a.m.f.R5(contextG, f.c0.c.j.k("成功导入书籍", Integer.valueOf(e.a.a.d.w.n.a(strF))));
                                                vVar3 = f.v.a;
                                            }
                                            objM11constructorimpl6 = f.h.m11constructorimpl(vVar3);
                                        } catch (Throwable th) {
                                            objM11constructorimpl6 = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                                        }
                                        Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(objM11constructorimpl6);
                                        if (thM14exceptionOrNullimpl != null) {
                                            c.a.a.a.a.A(thM14exceptionOrNullimpl, "导入书籍失败\n", contextG);
                                        }
                                    }
                                } else if (name.equals("myBookReplaceRule.json")) {
                                    try {
                                        Uri uri3 = documentFile.getUri();
                                        f.c0.c.j.d(uri3, "doc.uri");
                                        String strF2 = e.a.a.h.j.f(contextG, uri3);
                                        if (strF2 == null) {
                                            vVar2 = null;
                                        } else {
                                            List<ReplaceRule> listA = e.a.a.d.w.p.a(strF2);
                                            ReplaceRuleDao replaceRuleDao = AppDatabaseKt.getAppDb().getReplaceRuleDao();
                                            Object[] array = ((ArrayList) listA).toArray(new ReplaceRule[0]);
                                            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                                            ReplaceRule[] replaceRuleArr = (ReplaceRule[]) array;
                                            replaceRuleDao.insert((ReplaceRule[]) Arrays.copyOf(replaceRuleArr, replaceRuleArr.length));
                                            c.b.a.m.f.R5(contextG, f.c0.c.j.k("成功导入替换规则", Integer.valueOf(((ArrayList) listA).size())));
                                            vVar2 = f.v.a;
                                        }
                                        objM11constructorimpl5 = f.h.m11constructorimpl(vVar2);
                                    } catch (Throwable th2) {
                                        objM11constructorimpl5 = f.h.m11constructorimpl(c.b.a.m.f.m1(th2));
                                    }
                                    Throwable thM14exceptionOrNullimpl2 = f.h.m14exceptionOrNullimpl(objM11constructorimpl5);
                                    if (thM14exceptionOrNullimpl2 != null) {
                                        c.a.a.a.a.A(thM14exceptionOrNullimpl2, "导入替换规则失败\n", contextG);
                                    }
                                }
                            } else if (name.equals("myBookSource.json")) {
                                try {
                                    Uri uri4 = documentFile.getUri();
                                    f.c0.c.j.d(uri4, "doc.uri");
                                    String strF3 = e.a.a.h.j.f(contextG, uri4);
                                    if (strF3 == null) {
                                        vVar = null;
                                    } else {
                                        c.b.a.m.f.R5(contextG, f.c0.c.j.k("成功导入书源", Integer.valueOf(e.a.a.d.w.n.b(strF3))));
                                        vVar = f.v.a;
                                    }
                                    objM11constructorimpl4 = f.h.m11constructorimpl(vVar);
                                } catch (Throwable th3) {
                                    objM11constructorimpl4 = f.h.m11constructorimpl(c.b.a.m.f.m1(th3));
                                }
                                Throwable thM14exceptionOrNullimpl3 = f.h.m14exceptionOrNullimpl(objM11constructorimpl4);
                                if (thM14exceptionOrNullimpl3 != null) {
                                    c.a.a.a.a.A(thM14exceptionOrNullimpl3, "导入源失败\n", contextG);
                                }
                            }
                        } else {
                            documentFileArr = documentFileArrListFiles;
                            i2 = length;
                            i3 = i5;
                        }
                        i5 = i3 + 1;
                        documentFileArrListFiles = documentFileArr;
                        length = i2;
                    }
                    return;
                }
                String path = uri.getPath();
                if (path == null) {
                    return;
                }
                File file = new File(path);
                try {
                    str = "导入替换规则失败\n";
                    try {
                        c.b.a.m.f.R5(contextG, f.c0.c.j.k("成功导入书籍", Integer.valueOf(e.a.a.d.w.n.a(f.b0.d.d(FileUtils.a.a(file, "myBookShelf.json"), null, 1)))));
                        objM11constructorimpl = f.h.m11constructorimpl(f.v.a);
                    } catch (Throwable th4) {
                        th = th4;
                        objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str = "导入替换规则失败\n";
                }
                Throwable thM14exceptionOrNullimpl4 = f.h.m14exceptionOrNullimpl(objM11constructorimpl);
                if (thM14exceptionOrNullimpl4 != null) {
                    c.a.a.a.a.A(thM14exceptionOrNullimpl4, "导入书籍失败\n", contextG);
                }
                try {
                    String[] strArr = {"myBookSource.json"};
                    f.c0.c.j.e(file, "root");
                    f.c0.c.j.e(strArr, "subDirFiles");
                    String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
                    f.c0.c.j.e(file, "root");
                    f.c0.c.j.e(strArr2, "subDirFiles");
                    StringBuilder sb = new StringBuilder(file.getAbsolutePath());
                    for (String str2 : strArr2) {
                        if (str2.length() > 0) {
                            sb.append(File.separator);
                            sb.append(str2);
                        }
                    }
                    String string = sb.toString();
                    f.c0.c.j.d(string, "path.toString()");
                    c.b.a.m.f.R5(contextG, f.c0.c.j.k("成功导入书源", Integer.valueOf(e.a.a.d.w.n.b(f.b0.d.d(new File(string), null, 1)))));
                    objM11constructorimpl2 = f.h.m11constructorimpl(f.v.a);
                } catch (Throwable th6) {
                    objM11constructorimpl2 = f.h.m11constructorimpl(c.b.a.m.f.m1(th6));
                }
                Throwable thM14exceptionOrNullimpl5 = f.h.m14exceptionOrNullimpl(objM11constructorimpl2);
                if (thM14exceptionOrNullimpl5 != null) {
                    c.a.a.a.a.A(thM14exceptionOrNullimpl5, "导入源失败\n", contextG);
                }
                try {
                    String[] strArr3 = {"myBookReplaceRule.json"};
                    f.c0.c.j.e(file, "root");
                    f.c0.c.j.e(strArr3, "subDirFiles");
                    String[] strArr4 = (String[]) Arrays.copyOf(strArr3, strArr3.length);
                    f.c0.c.j.e(file, "root");
                    f.c0.c.j.e(strArr4, "subDirFiles");
                    StringBuilder sb2 = new StringBuilder(file.getAbsolutePath());
                    for (String str3 : strArr4) {
                        if (str3.length() > 0) {
                            sb2.append(File.separator);
                            sb2.append(str3);
                        }
                    }
                    String string2 = sb2.toString();
                    f.c0.c.j.d(string2, "path.toString()");
                    File file2 = new File(string2);
                    if (file2.exists()) {
                        List<ReplaceRule> listA2 = e.a.a.d.w.p.a(f.b0.d.d(file2, null, 1));
                        ReplaceRuleDao replaceRuleDao2 = AppDatabaseKt.getAppDb().getReplaceRuleDao();
                        Object[] array2 = ((ArrayList) listA2).toArray(new ReplaceRule[0]);
                        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                        ReplaceRule[] replaceRuleArr2 = (ReplaceRule[]) array2;
                        replaceRuleDao2.insert((ReplaceRule[]) Arrays.copyOf(replaceRuleArr2, replaceRuleArr2.length));
                        c.b.a.m.f.R5(contextG, f.c0.c.j.k("成功导入替换规则", Integer.valueOf(((ArrayList) listA2).size())));
                    } else {
                        c.b.a.m.f.R5(contextG, "未找到替换规则");
                    }
                    objM11constructorimpl3 = f.h.m11constructorimpl(f.v.a);
                } catch (Throwable th7) {
                    objM11constructorimpl3 = f.h.m11constructorimpl(c.b.a.m.f.m1(th7));
                }
                Throwable thM14exceptionOrNullimpl6 = f.h.m14exceptionOrNullimpl(objM11constructorimpl3);
                if (thM14exceptionOrNullimpl6 != null) {
                    c.a.a.a.a.A(thM14exceptionOrNullimpl6, str, contextG);
                }
                f.h.m10boximpl(objM11constructorimpl3);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult4, "registerForActivityResult(FilePicker()) { uri ->\n        uri?.let {\n            ImportOldData.importUri(appCtx, uri)\n        }\n    }");
        this.restoreOld = activityResultLauncherRegisterForActivityResult4;
    }

    public final void N(String preferenceKey, String value) {
        Preference preferenceFindPreference = findPreference(preferenceKey);
        if (preferenceFindPreference == null) {
            return;
        }
        int iHashCode = preferenceKey.hashCode();
        if (iHashCode != -1682240628) {
            if (iHashCode != 1009508830) {
                if (iHashCode == 1638651676 && preferenceKey.equals("web_dav_account")) {
                    if (value == null) {
                        preferenceFindPreference.setSummary(getString(R.string.web_dav_account_s));
                        return;
                    } else {
                        preferenceFindPreference.setSummary(value);
                        return;
                    }
                }
            } else if (preferenceKey.equals("web_dav_url")) {
                if (value == null) {
                    preferenceFindPreference.setSummary(getString(R.string.web_dav_url_s));
                    return;
                } else {
                    preferenceFindPreference.setSummary(value);
                    return;
                }
            }
        } else if (preferenceKey.equals("web_dav_password")) {
            if (value == null) {
                preferenceFindPreference.setSummary(getString(R.string.web_dav_pw_s));
                return;
            } else {
                preferenceFindPreference.setSummary(f.h0.k.B("*", value.length()));
                return;
            }
        }
        if (!(preferenceFindPreference instanceof ListPreference)) {
            preferenceFindPreference.setSummary(value);
            return;
        }
        ListPreference listPreference = (ListPreference) preferenceFindPreference;
        int iFindIndexOfValue = listPreference.findIndexOfValue(value);
        listPreference.setSummary(iFindIndexOfValue >= 0 ? listPreference.getEntries()[iFindIndexOfValue] : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        j.e(menu, "menu");
        j.e(inflater, "inflater");
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.backup_restore, menu);
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        addPreferencesFromResource(R.xml.pref_config_backup);
        EditTextPreference editTextPreference = (EditTextPreference) findPreference("web_dav_url");
        if (editTextPreference != null) {
            editTextPreference.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() { // from class: e.a.a.g.e.e
                @Override // androidx.preference.EditTextPreference.OnBindEditTextListener
                public final void onBindEditText(EditText editText) {
                    BackupConfigFragment backupConfigFragment = this.a;
                    int i2 = BackupConfigFragment.f7345b;
                    f.c0.c.j.e(backupConfigFragment, "this$0");
                    f.c0.c.j.e(editText, "editText");
                    ATH ath = ATH.a;
                    Context contextRequireContext = backupConfigFragment.requireContext();
                    f.c0.c.j.d(contextRequireContext, "requireContext()");
                    ATH.h(ath, editText, c.b.a.m.f.M1(contextRequireContext), false, 4);
                }
            });
        }
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference("web_dav_account");
        if (editTextPreference2 != null) {
            editTextPreference2.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() { // from class: e.a.a.g.e.a
                @Override // androidx.preference.EditTextPreference.OnBindEditTextListener
                public final void onBindEditText(EditText editText) {
                    BackupConfigFragment backupConfigFragment = this.a;
                    int i2 = BackupConfigFragment.f7345b;
                    f.c0.c.j.e(backupConfigFragment, "this$0");
                    f.c0.c.j.e(editText, "editText");
                    ATH ath = ATH.a;
                    Context contextRequireContext = backupConfigFragment.requireContext();
                    f.c0.c.j.d(contextRequireContext, "requireContext()");
                    ATH.h(ath, editText, c.b.a.m.f.M1(contextRequireContext), false, 4);
                }
            });
        }
        EditTextPreference editTextPreference3 = (EditTextPreference) findPreference("web_dav_password");
        if (editTextPreference3 != null) {
            editTextPreference3.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() { // from class: e.a.a.g.e.f
                @Override // androidx.preference.EditTextPreference.OnBindEditTextListener
                public final void onBindEditText(EditText editText) {
                    BackupConfigFragment backupConfigFragment = this.a;
                    int i2 = BackupConfigFragment.f7345b;
                    f.c0.c.j.e(backupConfigFragment, "this$0");
                    f.c0.c.j.e(editText, "editText");
                    ATH ath = ATH.a;
                    Context contextRequireContext = backupConfigFragment.requireContext();
                    f.c0.c.j.d(contextRequireContext, "requireContext()");
                    ATH.h(ath, editText, c.b.a.m.f.M1(contextRequireContext), false, 4);
                    editText.setInputType(Token.EMPTY);
                }
            });
        }
        N("web_dav_url", m.f(this, "web_dav_url", null, 2));
        N("web_dav_account", m.f(this, "web_dav_account", null, 2));
        N("web_dav_password", m.f(this, "web_dav_password", null, 2));
        N("backupUri", m.f(this, "backupUri", null, 2));
        io.legado.app.ui.widget.prefs.Preference preference = (io.legado.app.ui.widget.prefs.Preference) findPreference("web_dav_restore");
        if (preference == null) {
            return;
        }
        preference.onLongClick = new a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        j.e(item, "item");
        return super.onOptionsItemSelected(item);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(@Nullable Preference preference) {
        String key = preference.getKey();
        if (key != null) {
            boolean z = true;
            switch (key.hashCode()) {
                case -1062528512:
                    if (key.equals("restoreIgnore")) {
                        q qVar = q.a;
                        int length = q.f5595d.length;
                        boolean[] zArr = new boolean[length];
                        for (int i2 = 0; i2 < length; i2++) {
                            Boolean bool = q.a.a().get(q.f5595d[i2]);
                            zArr[i2] = bool == null ? false : bool.booleanValue();
                        }
                        Integer numValueOf = Integer.valueOf(R.string.restore_ignore);
                        b0 b0Var = new b0(zArr);
                        FragmentActivity fragmentActivityRequireActivity = requireActivity();
                        j.d(fragmentActivityRequireActivity, "requireActivity()");
                        ((i) f.h0(fragmentActivityRequireActivity, numValueOf, null, b0Var)).p();
                    }
                    break;
                case -381476995:
                    if (key.equals("web_dav_restore")) {
                        b.C0148b c0148b = b.a;
                        k0 k0Var = k0.f6264c;
                        b.b(b.C0148b.b(c0148b, null, g.b.g2.m.f6207b, new x(this, null), 1), null, new y(this, null), 1);
                    }
                    break;
                case 356732659:
                    if (key.equals("web_dav_backup")) {
                        e eVar = e.a;
                        String strO2 = f.O2(h.g(), "backupUri", null, 2);
                        if (strO2 != null && strO2.length() != 0) {
                            z = false;
                        }
                        if (z) {
                            this.backupDir.launch(null);
                        } else if (f.t3(strO2)) {
                            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(requireContext(), Uri.parse(strO2));
                            if (j.a(documentFileFromTreeUri == null ? null : Boolean.valueOf(documentFileFromTreeUri.canWrite()), Boolean.TRUE)) {
                                b.C0148b.b(b.a, null, null, new e.a.a.g.e.q(this, strO2, null), 3).d(null, new r(this, null));
                            } else {
                                this.backupDir.launch(null);
                            }
                        } else {
                            k.a aVar = new k.a(this);
                            String[] strArr = e.a.a.e.c.j.a;
                            aVar.a((String[]) Arrays.copyOf(strArr, strArr.length));
                            aVar.c(R.string.tip_perm_request_storage);
                            aVar.b(new w(strO2, this));
                            aVar.d();
                        }
                    }
                    break;
                case 1355343946:
                    if (key.equals("backupUri")) {
                        this.selectBackupPath.launch(null);
                    }
                    break;
                case 2125592205:
                    if (key.equals("import_old")) {
                        this.restoreOld.launch(null);
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
        if (key != null) {
            switch (key.hashCode()) {
                case -1682240628:
                    if (!key.equals("web_dav_password")) {
                        return;
                    }
                    break;
                case 1009508830:
                    if (!key.equals("web_dav_url")) {
                        return;
                    }
                    break;
                case 1355343946:
                    if (!key.equals("backupUri")) {
                        return;
                    }
                    break;
                case 1638651676:
                    if (!key.equals("web_dav_account")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            N(key, m.f(this, key, null, 2));
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) throws IOException {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        ATH.a.b(getListView());
        setHasOptionsMenu(true);
        if (e.a.a.d.q.a.b(1, "backupHelpVersion", "firstBackup")) {
            return;
        }
        InputStream inputStreamOpen = requireContext().getAssets().open("help/webDavHelp.md");
        j.d(inputStreamOpen, "requireContext().assets.open(\"help/webDavHelp.md\")");
        String str = new String(f.w4(inputStreamOpen), f.h0.a.a);
        TextDialog.Companion companion = TextDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        j.d(childFragmentManager, "childFragmentManager");
        TextDialog.Companion.a(companion, childFragmentManager, str, 1, 0L, false, 24);
    }
}
