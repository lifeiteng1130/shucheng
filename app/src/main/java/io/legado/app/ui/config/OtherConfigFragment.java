package io.legado.app.ui.config;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.room.RoomDatabase;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.e;
import e.a.a.e.a.i;
import e.a.a.e.c.k;
import e.a.a.g.e.d0;
import e.a.a.g.e.f0;
import e.a.a.h.m;
import e.a.a.h.u;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.base.BasePreferenceFragment;
import io.legado.app.lib.theme.ATH;
import io.legado.app.receiver.SharedReceiverActivity;
import io.legado.app.service.WebService;
import io.legado.app.ui.config.OtherConfigFragment;
import io.legado.app.ui.main.MainActivity;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import java.io.File;
import java.util.ArrayList;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: OtherConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b/\u0010\u000fJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R$\u0010.\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00050\u00050+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Lio/legado/app/ui/config/OtherConfigFragment;", "Lio/legado/app/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "Lf/v;", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "()V", "Landroidx/preference/Preference;", "preference", "", "onPreferenceTreeClick", "(Landroidx/preference/Preference;)Z", "Landroid/content/SharedPreferences;", "sharedPreferences", "key", "onSharedPreferenceChanged", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "preferenceKey", ES6Iterator.VALUE_PROPERTY, "O", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/pm/PackageManager;", "kotlin.jvm.PlatformType", ai.aD, "Landroid/content/pm/PackageManager;", "packageManager", "Landroid/content/ComponentName;", "d", "Landroid/content/ComponentName;", "componentName", "", "N", "()I", "webPort", "Landroidx/activity/result/ActivityResultLauncher;", "e", "Landroidx/activity/result/ActivityResultLauncher;", "selectCoverImage", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class OtherConfigFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7351b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final PackageManager packageManager = h.g().getPackageManager();

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ComponentName componentName = new ComponentName(h.g(), SharedReceiverActivity.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> selectCoverImage;

    /* JADX INFO: compiled from: OtherConfigFragment.kt */
    public static final class a extends k implements l<Integer, v> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            e eVar = e.a;
            f.p4(h.g(), "preDownloadNum", i2);
        }
    }

    /* JADX INFO: compiled from: OtherConfigFragment.kt */
    public static final class b extends k implements l<Integer, v> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            e eVar = e.a;
            f.p4(h.g(), "threadCount", i2);
        }
    }

    /* JADX INFO: compiled from: OtherConfigFragment.kt */
    public static final class c extends k implements l<Integer, v> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            m.i(OtherConfigFragment.this, "webPort", i2);
        }
    }

    /* JADX INFO: compiled from: OtherConfigFragment.kt */
    public static final class d extends k implements p<DialogInterface, Integer, v> {
        public d() {
            super(2);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
            invoke(dialogInterface, num.intValue());
            return v.a;
        }

        public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
            j.e(dialogInterface, "$noName_0");
            if (i2 == 0) {
                m.k(OtherConfigFragment.this, "defaultCover");
            } else {
                OtherConfigFragment.this.selectCoverImage.launch("image/*");
            }
        }
    }

    public OtherConfigFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: e.a.a.g.e.j
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                String name;
                Object objM11constructorimpl;
                OtherConfigFragment otherConfigFragment = this.a;
                Uri uri = (Uri) obj;
                int i2 = OtherConfigFragment.f7351b;
                f.c0.c.j.e(otherConfigFragment, "this$0");
                if (uri == null) {
                    return;
                }
                f.c0.c.j.d(uri, "it");
                if (!c.b.a.m.f.s3(uri)) {
                    k.a aVar = new k.a(otherConfigFragment);
                    aVar.a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
                    aVar.c(R.string.bg_image_per);
                    aVar.b(new e0(otherConfigFragment, uri));
                    aVar.d();
                    return;
                }
                DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(otherConfigFragment.requireContext(), uri);
                if (documentFileFromSingleUri == null || (name = documentFileFromSingleUri.getName()) == null) {
                    return;
                }
                Context contextRequireContext = otherConfigFragment.requireContext();
                f.c0.c.j.d(contextRequireContext, "requireContext()");
                File fileA = FileUtils.a.a(c.b.a.m.f.r2(contextRequireContext), "covers", name);
                try {
                    Context contextRequireContext2 = otherConfigFragment.requireContext();
                    f.c0.c.j.d(contextRequireContext2, "requireContext()");
                    Uri uri2 = documentFileFromSingleUri.getUri();
                    f.c0.c.j.d(uri2, "doc.uri");
                    objM11constructorimpl = f.h.m11constructorimpl(e.a.a.h.j.e(contextRequireContext2, uri2));
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
                    String absolutePath = fileA.getAbsolutePath();
                    f.c0.c.j.d(absolutePath, "file.absolutePath");
                    e.a.a.h.m.j(otherConfigFragment, "defaultCover", absolutePath);
                    CoverImageView coverImageView = CoverImageView.a;
                    CoverImageView.c();
                    vVar = f.v.a;
                }
                if (vVar == null) {
                    e.a.a.h.m.m(otherConfigFragment, "获取文件出错");
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(ActivityResultContracts.GetContent()) {\n        it ?: return@registerForActivityResult\n        setCoverFromUri(it)\n    }");
        this.selectCoverImage = activityResultLauncherRegisterForActivityResult;
    }

    public final int N() {
        return m.d(this, "webPort", 1122);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void O(String preferenceKey, String value) {
        Preference preferenceFindPreference = findPreference(preferenceKey);
        if (preferenceFindPreference == null) {
            return;
        }
        switch (preferenceKey.hashCode()) {
            case -676246026:
                if (preferenceKey.equals("defaultCover")) {
                    if (value == null || f.h0.k.s(value)) {
                        value = getString(R.string.select_image);
                    }
                    preferenceFindPreference.setSummary(value);
                    return;
                }
                break;
            case 732970811:
                if (preferenceKey.equals("preDownloadNum")) {
                    preferenceFindPreference.setSummary(getString(R.string.pre_download_s, value));
                    return;
                }
                break;
            case 1223298549:
                if (preferenceKey.equals("webPort")) {
                    preferenceFindPreference.setSummary(getString(R.string.web_port_summary, value));
                    return;
                }
                break;
            case 1905035557:
                if (preferenceKey.equals("threadCount")) {
                    preferenceFindPreference.setSummary(getString(R.string.threads_num, value));
                    return;
                }
                break;
        }
        if (!(preferenceFindPreference instanceof ListPreference)) {
            preferenceFindPreference.setSummary(value);
            return;
        }
        ListPreference listPreference = (ListPreference) preferenceFindPreference;
        int iFindIndexOfValue = listPreference.findIndexOfValue(value);
        listPreference.setSummary(iFindIndexOfValue >= 0 ? listPreference.getEntries()[iFindIndexOfValue] : null);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        m.h(this, "process_text", this.packageManager.getComponentEnabledSetting(this.componentName) != 2);
        addPreferencesFromResource(R.xml.pref_config_other);
        e eVar = e.a;
        O(TTDownloadField.TT_USERAGENT, e.f5518c);
        O("preDownloadNum", String.valueOf(eVar.h()));
        O("threadCount", String.valueOf(eVar.k()));
        O("webPort", String.valueOf(N()));
        O("defaultCover", m.f(this, "defaultCover", null, 2));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(@Nullable Preference preference) {
        String key = preference.getKey();
        if (key != null) {
            boolean z = true;
            switch (key.hashCode()) {
                case -873754951:
                    if (key.equals("cleanCache")) {
                        Context contextRequireContext = requireContext();
                        j.d(contextRequireContext, "requireContext()");
                        ((i) f.h0(contextRequireContext, Integer.valueOf(R.string.clear_cache), Integer.valueOf(R.string.sure_del), new d0(this))).p();
                    }
                    break;
                case -676246026:
                    if (key.equals("defaultCover")) {
                        String strF = m.f(this, "defaultCover", null, 2);
                        if (strF != null && strF.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            ArrayList arrayListA = f.x.e.a("删除图片", "选择图片");
                            d dVar = new d();
                            FragmentActivity activity = getActivity();
                            if (activity != null) {
                                f.Z4(activity, null, arrayListA, dVar);
                            }
                        } else {
                            this.selectCoverImage.launch("image/*");
                        }
                    }
                    break;
                case 311430650:
                    if (key.equals(TTDownloadField.TT_USERAGENT)) {
                        f0 f0Var = new f0(this);
                        FragmentActivity fragmentActivityRequireActivity = requireActivity();
                        j.d(fragmentActivityRequireActivity, "requireActivity()");
                        ((i) f.g0(fragmentActivityRequireActivity, "UserAgent", null, f0Var)).p();
                    }
                    break;
                case 732970811:
                    if (key.equals("preDownloadNum")) {
                        Context contextRequireContext2 = requireContext();
                        j.d(contextRequireContext2, "requireContext()");
                        e.a.a.g.m.n.c cVar = new e.a.a.g.m.n.c(contextRequireContext2);
                        String string = getString(R.string.pre_download);
                        j.d(string, "getString(R.string.pre_download)");
                        cVar.c(string);
                        cVar.a(9999);
                        cVar.b(1);
                        cVar.d(e.a.h());
                        cVar.e(a.INSTANCE);
                    }
                    break;
                case 1223298549:
                    if (key.equals("webPort")) {
                        Context contextRequireContext3 = requireContext();
                        j.d(contextRequireContext3, "requireContext()");
                        e.a.a.g.m.n.c cVar2 = new e.a.a.g.m.n.c(contextRequireContext3);
                        String string2 = getString(R.string.web_port_title);
                        j.d(string2, "getString(R.string.web_port_title)");
                        cVar2.c(string2);
                        cVar2.a(BaseConstants.Time.MINUTE);
                        cVar2.b(1024);
                        cVar2.d(N());
                        cVar2.e(new c());
                    }
                    break;
                case 1905035557:
                    if (key.equals("threadCount")) {
                        Context contextRequireContext4 = requireContext();
                        j.d(contextRequireContext4, "requireContext()");
                        e.a.a.g.m.n.c cVar3 = new e.a.a.g.m.n.c(contextRequireContext4);
                        String string3 = getString(R.string.threads_num_title);
                        j.d(string3, "getString(R.string.threads_num_title)");
                        cVar3.c(string3);
                        cVar3.a(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        cVar3.b(1);
                        cVar3.d(e.a.k());
                        cVar3.e(b.INSTANCE);
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
                case -1613589672:
                    if (key.equals(ai.N)) {
                        getListView().postDelayed(new Runnable() { // from class: e.a.a.g.e.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                int i2 = OtherConfigFragment.f7351b;
                                e.a.a.h.t.b(k.d.a.h.g());
                                Intent intent = new Intent(k.d.a.h.g(), (Class<?>) MainActivity.class);
                                intent.addFlags(268468224);
                                k.d.a.h.g().startActivity(intent);
                                Process.killProcess(Process.myPid());
                            }
                        }, 1000L);
                        return;
                    }
                    return;
                case -762521805:
                    if (!key.equals("showDiscovery")) {
                        return;
                    }
                    break;
                case -676246026:
                    if (key.equals("defaultCover")) {
                        O(key, m.f(this, "defaultCover", null, 2));
                        return;
                    }
                    return;
                case 311430650:
                    if (key.equals(TTDownloadField.TT_USERAGENT)) {
                        getListView().post(new Runnable() { // from class: e.a.a.g.e.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                OtherConfigFragment otherConfigFragment = this.a;
                                int i2 = OtherConfigFragment.f7351b;
                                f.c0.c.j.e(otherConfigFragment, "this$0");
                                e.a.a.d.e eVar = e.a.a.d.e.a;
                                otherConfigFragment.O(TTDownloadField.TT_USERAGENT, e.a.a.d.e.f5518c);
                            }
                        });
                        return;
                    }
                    return;
                case 732970811:
                    if (key.equals("preDownloadNum")) {
                        O(key, String.valueOf(e.a.h()));
                        return;
                    }
                    return;
                case 993530163:
                    if (key.equals("recordLog")) {
                        u.a.c();
                        return;
                    }
                    return;
                case 1223298549:
                    if (key.equals("webPort")) {
                        O(key, String.valueOf(N()));
                        if (WebService.f6964b) {
                            Context contextRequireContext = requireContext();
                            j.d(contextRequireContext, "requireContext()");
                            WebService.b(contextRequireContext);
                            Context contextRequireContext2 = requireContext();
                            j.d(contextRequireContext2, "requireContext()");
                            j.e(contextRequireContext2, com.umeng.analytics.pro.c.R);
                            contextRequireContext2.startService(new Intent(contextRequireContext2, (Class<?>) WebService.class));
                            return;
                        }
                        return;
                    }
                    return;
                case 1905035557:
                    if (key.equals("threadCount")) {
                        O(key, String.valueOf(e.a.k()));
                        LiveEventBus.get("threadCount").post("");
                        return;
                    }
                    return;
                case 1993379069:
                    if (key.equals("process_text") && sharedPreferences != null) {
                        if (sharedPreferences.getBoolean(key, true)) {
                            this.packageManager.setComponentEnabledSetting(this.componentName, 1, 1);
                            return;
                        } else {
                            this.packageManager.setComponentEnabledSetting(this.componentName, 2, 1);
                            return;
                        }
                    }
                    return;
                case 2067278357:
                    if (!key.equals("showRss")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            LiveEventBus.get("notifyMain").post("");
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        ATH.a.b(getListView());
    }
}
