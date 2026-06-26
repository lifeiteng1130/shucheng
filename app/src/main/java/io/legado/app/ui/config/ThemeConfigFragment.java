package io.legado.app.ui.config;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.documentfile.provider.DocumentFile;
import androidx.preference.Preference;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import e.a.a.e.c.k;
import e.a.a.h.a0;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.base.BasePreferenceFragment;
import io.legado.app.help.ThemeConfig;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.config.ThemeConfigFragment;
import io.legado.app.ui.widget.prefs.ColorPreference;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import java.io.File;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: ThemeConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b:\u0010\u000fJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001f\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010!H\u0017¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b(\u0010\u000fJ!\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b+\u0010,J-\u00101\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-2\u0006\u0010)\u001a\u00020\u00052\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070/H\u0002¢\u0006\u0004\b1\u00102R$\u00107\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00050\u0005038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R$\u00109\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00050\u0005038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00106¨\u0006;"}, d2 = {"Lio/legado/app/ui/config/ThemeConfigFragment;", "Lio/legado/app/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "Lf/v;", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "Landroid/view/Menu;", "menu", "Landroid/view/MenuInflater;", "inflater", "onCreateOptionsMenu", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Landroid/content/SharedPreferences;", "sharedPreferences", "key", "onSharedPreferenceChanged", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "Landroidx/preference/Preference;", "preference", "onPreferenceTreeClick", "(Landroidx/preference/Preference;)Z", "isNightTheme", "Q", "(Z)V", "N", "preferenceKey", ES6Iterator.VALUE_PROPERTY, "P", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/net/Uri;", "uri", "Lkotlin/Function0;", "success", "O", "(Landroid/net/Uri;Ljava/lang/String;Lf/c0/b/a;)V", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", ai.aD, "Landroidx/activity/result/ActivityResultLauncher;", "selectLightBg", "d", "selectDarkBg", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ThemeConfigFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7355b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> selectLightBg;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> selectDarkBg;

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
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
            e.a.a.d.e eVar = e.a.a.d.e.a;
            e.a.a.c.c cVar = e.a.a.c.c.a;
            c.b.a.m.f.p4(h.g(), "barElevation", e.a.a.c.c.f5503i);
            ThemeConfigFragment themeConfigFragment = ThemeConfigFragment.this;
            int i2 = ThemeConfigFragment.f7355b;
            themeConfigFragment.N();
        }
    }

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
    public static final class d extends k implements l<Integer, v> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            c.b.a.m.f.p4(h.g(), "barElevation", i2);
            ThemeConfigFragment themeConfigFragment = ThemeConfigFragment.this;
            int i3 = ThemeConfigFragment.f7355b;
            themeConfigFragment.N();
        }
    }

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
    public static final class e extends k implements p<DialogInterface, Integer, v> {
        public e() {
            super(2);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
            invoke(dialogInterface, num.intValue());
            return v.a;
        }

        public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
            j.e(dialogInterface, "$noName_0");
            if (i2 != 0) {
                ThemeConfigFragment.this.selectLightBg.launch("image/*");
                return;
            }
            m.k(ThemeConfigFragment.this, "backgroundImage");
            ThemeConfigFragment themeConfigFragment = ThemeConfigFragment.this;
            int i3 = ThemeConfigFragment.f7355b;
            themeConfigFragment.Q(false);
        }
    }

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
    public static final class f extends k implements p<DialogInterface, Integer, v> {
        public f() {
            super(2);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
            invoke(dialogInterface, num.intValue());
            return v.a;
        }

        public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
            j.e(dialogInterface, "$noName_0");
            if (i2 != 0) {
                ThemeConfigFragment.this.selectDarkBg.launch("image/*");
                return;
            }
            m.k(ThemeConfigFragment.this, "backgroundImageNight");
            ThemeConfigFragment themeConfigFragment = ThemeConfigFragment.this;
            int i3 = ThemeConfigFragment.f7355b;
            themeConfigFragment.Q(true);
        }
    }

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
    public static final class g extends k implements f.c0.b.a<v> {
        public final /* synthetic */ String $preferenceKey;
        public final /* synthetic */ f.c0.b.a<v> $success;
        public final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Uri uri, String str, f.c0.b.a<v> aVar) {
            super(0);
            this.$uri = uri;
            this.$preferenceKey = str;
            this.$success = aVar;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Context contextRequireContext = ThemeConfigFragment.this.requireContext();
            j.d(contextRequireContext, "requireContext()");
            String strB = a0.b(contextRequireContext, this.$uri);
            if (strB == null) {
                return;
            }
            ThemeConfigFragment themeConfigFragment = ThemeConfigFragment.this;
            String str = this.$preferenceKey;
            f.c0.b.a<v> aVar = this.$success;
            File file = new File(strB);
            if (file.exists()) {
                Context contextRequireContext2 = themeConfigFragment.requireContext();
                j.d(contextRequireContext2, "requireContext()");
                File fileR2 = c.b.a.m.f.r2(contextRequireContext2);
                FileUtils fileUtils = FileUtils.a;
                String name = file.getName();
                j.d(name, "imgFile.name");
                File fileA = fileUtils.a(fileR2, str, name);
                f.b0.d.e(fileA, f.b0.d.c(file));
                String absolutePath = fileA.getAbsolutePath();
                j.d(absolutePath, "file.absolutePath");
                m.j(themeConfigFragment, str, absolutePath);
                String absolutePath2 = fileA.getAbsolutePath();
                int i2 = ThemeConfigFragment.f7355b;
                themeConfigFragment.P(str, absolutePath2);
                aVar.invoke();
            }
        }
    }

    public ThemeConfigFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: e.a.a.g.e.l
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ThemeConfigFragment themeConfigFragment = this.a;
                Uri uri = (Uri) obj;
                int i2 = ThemeConfigFragment.f7355b;
                f.c0.c.j.e(themeConfigFragment, "this$0");
                if (uri == null) {
                    return;
                }
                f.c0.c.j.d(uri, "it");
                themeConfigFragment.O(uri, "backgroundImage", new i0(themeConfigFragment));
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(ActivityResultContracts.GetContent()) {\n        it ?: return@registerForActivityResult\n        setBgFromUri(it, PreferKey.bgImage) {\n            upTheme(false)\n        }\n    }");
        this.selectLightBg = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: e.a.a.g.e.k
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ThemeConfigFragment themeConfigFragment = this.a;
                Uri uri = (Uri) obj;
                int i2 = ThemeConfigFragment.f7355b;
                f.c0.c.j.e(themeConfigFragment, "this$0");
                if (uri == null) {
                    return;
                }
                f.c0.c.j.d(uri, "it");
                themeConfigFragment.O(uri, "backgroundImageNight", new h0(themeConfigFragment));
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(ActivityResultContracts.GetContent()) {\n        it ?: return@registerForActivityResult\n        setBgFromUri(it, PreferKey.bgImageN) {\n            upTheme(true)\n        }\n    }");
        this.selectDarkBg = activityResultLauncherRegisterForActivityResult2;
    }

    public final void N() {
        LiveEventBus.get("RECREATE").post("");
    }

    public final void O(Uri uri, String preferenceKey, f.c0.b.a<v> success) {
        String name;
        Object objM11constructorimpl;
        if (!c.b.a.m.f.s3(uri)) {
            k.a aVar = new k.a(this);
            aVar.a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.c(R.string.bg_image_per);
            aVar.b(new g(uri, preferenceKey, success));
            aVar.d();
            return;
        }
        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(requireContext(), uri);
        if (documentFileFromSingleUri == null || (name = documentFileFromSingleUri.getName()) == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        File fileA = FileUtils.a.a(c.b.a.m.f.r2(contextRequireContext), preferenceKey, name);
        try {
            Context contextRequireContext2 = requireContext();
            j.d(contextRequireContext2, "requireContext()");
            Uri uri2 = documentFileFromSingleUri.getUri();
            j.d(uri2, "doc.uri");
            objM11constructorimpl = f.h.m11constructorimpl(e.a.a.h.j.e(contextRequireContext2, uri2));
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
        v vVar = null;
        if (f.h.m16isFailureimpl(objM11constructorimpl)) {
            objM11constructorimpl = null;
        }
        byte[] bArr = (byte[]) objM11constructorimpl;
        if (bArr != null) {
            f.b0.d.e(fileA, bArr);
            String absolutePath = fileA.getAbsolutePath();
            j.d(absolutePath, "file.absolutePath");
            m.j(this, preferenceKey, absolutePath);
            P(preferenceKey, fileA.getAbsolutePath());
            success.invoke();
            vVar = v.a;
        }
        if (vVar == null) {
            m.m(this, "获取文件出错");
        }
    }

    public final void P(String preferenceKey, String value) {
        Preference preferenceFindPreference = findPreference(preferenceKey);
        if (preferenceFindPreference == null) {
            return;
        }
        if (j.a(preferenceKey, "barElevation")) {
            preferenceFindPreference.setSummary(getString(R.string.bar_elevation_s, value));
        } else {
            preferenceFindPreference.setSummary(value);
        }
    }

    public final void Q(boolean isNightTheme) {
        if (e.a.a.d.e.a.m() == isNightTheme) {
            getListView().post(new Runnable() { // from class: e.a.a.g.e.m
                @Override // java.lang.Runnable
                public final void run() {
                    ThemeConfigFragment themeConfigFragment = this.a;
                    int i2 = ThemeConfigFragment.f7355b;
                    f.c0.c.j.e(themeConfigFragment, "this$0");
                    ThemeConfig themeConfig = ThemeConfig.a;
                    Context contextRequireContext = themeConfigFragment.requireContext();
                    f.c0.c.j.d(contextRequireContext, "requireContext()");
                    themeConfig.c(contextRequireContext);
                    themeConfigFragment.N();
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        j.e(menu, "menu");
        j.e(inflater, "inflater");
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.theme_config, menu);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        addPreferencesFromResource(R.xml.pref_config_theme);
        if (Build.VERSION.SDK_INT < 26) {
            getPreferenceScreen().removePreferenceRecursively("launcherIcon");
        }
        P("backgroundImage", m.f(this, "backgroundImage", null, 2));
        P("backgroundImageNight", m.f(this, "backgroundImageNight", null, 2));
        P("barElevation", String.valueOf(e.a.a.d.e.a.c()));
        ColorPreference colorPreference = (ColorPreference) findPreference("colorBackground");
        if (colorPreference != null) {
            colorPreference.onSaveColor = new a();
        }
        ColorPreference colorPreference2 = (ColorPreference) findPreference("colorBackgroundNight");
        if (colorPreference2 == null) {
            return;
        }
        colorPreference2.onSaveColor = new b();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.menu_theme_mode) {
            e.a.a.d.e.a.p(!r0.m());
            ThemeConfig themeConfig = ThemeConfig.a;
            Context contextRequireContext = requireContext();
            j.d(contextRequireContext, "requireContext()");
            themeConfig.b(contextRequireContext);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    @android.annotation.SuppressLint({"PrivateResource"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onPreferenceTreeClick(@org.jetbrains.annotations.Nullable androidx.preference.Preference r10) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.config.ThemeConfigFragment.onPreferenceTreeClick(androidx.preference.Preference):boolean");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
        if (sharedPreferences == null || key == null) {
            return;
        }
        switch (key.hashCode()) {
            case -1517838532:
                if (!key.equals("colorBottomBackground")) {
                }
                Q(false);
                break;
            case -804293233:
                if (key.equals("transparentStatusBar")) {
                    N();
                    break;
                }
                break;
            case -730767815:
                if (!key.equals("colorPrimaryNight")) {
                }
                Q(true);
                break;
            case 303962134:
                if (key.equals("immNavigationBar")) {
                    N();
                    break;
                }
                break;
            case 429113585:
                if (!key.equals("colorBackground")) {
                }
                Q(false);
                break;
            case 450722317:
                if (!key.equals("colorAccent")) {
                }
                Q(false);
                break;
            case 746627495:
                if (!key.equals("colorBackgroundNight")) {
                }
                Q(true);
                break;
            case 1626402873:
                if (key.equals("launcherIcon")) {
                    e.a.a.d.p pVar = e.a.a.d.p.a;
                    e.a.a.d.p.a(m.f(this, key, null, 2));
                    break;
                }
                break;
            case 1898592779:
                if (!key.equals("colorAccentNight")) {
                }
                Q(true);
                break;
            case 1950347551:
                if (!key.equals("colorPrimary")) {
                }
                Q(false);
                break;
            case 1950546492:
                if (!key.equals("colorBottomBackgroundNight")) {
                }
                Q(true);
                break;
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ATH.a.b(getListView());
        setHasOptionsMenu(true);
    }

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
    public static final class a extends f.c0.c.k implements l<Integer, Boolean> {
        public a() {
            super(1);
        }

        public final boolean invoke(int i2) {
            if (((double) 1) - (((((double) Color.blue(i2)) * 0.114d) + ((((double) Color.green(i2)) * 0.587d) + (((double) Color.red(i2)) * 0.299d))) / ((double) 255)) < 0.4d) {
                return false;
            }
            m.l(ThemeConfigFragment.this, R.string.day_background_too_dark);
            return true;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }
    }

    /* JADX INFO: compiled from: ThemeConfigFragment.kt */
    public static final class b extends f.c0.c.k implements l<Integer, Boolean> {
        public b() {
            super(1);
        }

        public final boolean invoke(int i2) {
            if (!(((double) 1) - (((((double) Color.blue(i2)) * 0.114d) + ((((double) Color.green(i2)) * 0.587d) + (((double) Color.red(i2)) * 0.299d))) / ((double) 255)) < 0.4d)) {
                return false;
            }
            m.l(ThemeConfigFragment.this, R.string.night_background_too_light);
            return true;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }
    }
}
