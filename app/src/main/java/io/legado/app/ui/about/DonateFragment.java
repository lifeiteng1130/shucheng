package io.legado.app.ui.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.umeng.analytics.pro.ai;
import e.a.a.h.f;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonateFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013¨\u0006\u001d"}, d2 = {"Lio/legado/app/ui/about/DonateFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Landroid/os/Bundle;", "savedInstanceState", "", "rootKey", "Lf/v;", "onCreatePreferences", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/preference/Preference;", "preference", "", "onPreferenceTreeClick", "(Landroidx/preference/Preference;)Z", ai.at, "Ljava/lang/String;", "zfbHbRwmUrl", "d", "qqSkRwmUrl", ai.aD, "wxZsRwmUrl", "b", "zfbSkRwmUrl", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class DonateFragment extends PreferenceFragmentCompat {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final String zfbHbRwmUrl = "https://gitee.com/gekunfei/Donate/raw/master/zfbhbrwm.png";

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String zfbSkRwmUrl = "https://gitee.com/gekunfei/Donate/raw/master/zfbskrwm.jpg";

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String wxZsRwmUrl = "https://gitee.com/gekunfei/Donate/raw/master/wxskrwm.jpg";

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String qqSkRwmUrl = "https://gitee.com/gekunfei/Donate/raw/master/qqskrwm.jpg";

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        addPreferencesFromResource(R.xml.donate);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(@Nullable Preference preference) {
        f fVarA;
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case 98829282:
                    if (key.equals("gzGzh")) {
                        Context contextRequireContext = requireContext();
                        j.d(contextRequireContext, "requireContext()");
                        c.b.a.m.f.c5(contextRequireContext, "开源阅读");
                    }
                    break;
                case 113564083:
                    if (key.equals("wxZsm")) {
                        Context contextRequireContext2 = requireContext();
                        j.d(contextRequireContext2, "requireContext()");
                        c.b.a.m.f.i4(contextRequireContext2, this.wxZsRwmUrl);
                    }
                    break;
                case 523717392:
                    if (key.equals("qqSkRwm")) {
                        Context contextRequireContext3 = requireContext();
                        j.d(contextRequireContext3, "requireContext()");
                        c.b.a.m.f.i4(contextRequireContext3, this.qqSkRwmUrl);
                    }
                    break;
                case 1080710744:
                    if (key.equals("zfbHbRwm")) {
                        Context contextRequireContext4 = requireContext();
                        j.d(contextRequireContext4, "requireContext()");
                        c.b.a.m.f.i4(contextRequireContext4, this.zfbHbRwmUrl);
                    }
                    break;
                case 1080711581:
                    if (key.equals("zfbHbSsm")) {
                        Context contextRequireContext5 = requireContext();
                        j.d(contextRequireContext5, "requireContext()");
                        Context contextRequireContext6 = requireContext();
                        j.d(contextRequireContext6, "requireContext()");
                        c.b.a.m.f.c5(contextRequireContext6, "537954522");
                        c.b.a.m.f.S3(contextRequireContext5, "高级功能已开启\n红包码已复制\n支付宝首页搜索“537954522” 立即领红包");
                        try {
                            try {
                                Intent launchIntentForPackage = contextRequireContext5.getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.eg.android.AlipayGphone");
                                j.c(launchIntentForPackage);
                                launchIntentForPackage.addFlags(268435456);
                                contextRequireContext5.startActivity(launchIntentForPackage);
                                f.b bVar = f.a;
                                Context contextRequireContext7 = requireContext();
                                j.d(contextRequireContext7, "requireContext()");
                                fVarA = f.b.a(bVar, contextRequireContext7, null, 0L, 0, false, 14);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                f.b bVar2 = f.a;
                                Context contextRequireContext8 = requireContext();
                                j.d(contextRequireContext8, "requireContext()");
                                fVarA = f.b.a(bVar2, contextRequireContext8, null, 0L, 0, false, 14);
                            }
                            f.e(fVarA, "proTime", Long.valueOf(System.currentTimeMillis()), 0, 4);
                        } catch (Throwable th) {
                            f.b bVar3 = f.a;
                            Context contextRequireContext9 = requireContext();
                            j.d(contextRequireContext9, "requireContext()");
                            f.e(f.b.a(bVar3, contextRequireContext9, null, 0L, 0, false, 14), "proTime", Long.valueOf(System.currentTimeMillis()), 0, 4);
                            throw th;
                        }
                    }
                    break;
                case 1091137594:
                    if (key.equals("zfbSkRwm")) {
                        Context contextRequireContext10 = requireContext();
                        j.d(contextRequireContext10, "requireContext()");
                        c.b.a.m.f.i4(contextRequireContext10, this.zfbSkRwmUrl);
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getListView().setOverScrollMode(2);
    }
}
