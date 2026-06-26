package e.a.a.d.w;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.legado.app.model.AdsConfig;
import java.lang.reflect.Type;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdsConfigHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<AdsConfig> {
    }

    public static final boolean a(@NotNull AdsConfig adsConfig) {
        f.c0.c.j.e(adsConfig, "adsConfig");
        return System.currentTimeMillis() - e.a.a.d.q.a.a() > adsConfig.getInstallCacheTime() * ((long) 1000);
    }

    public static final boolean b(@NotNull AdsConfig adsConfig) {
        f.c0.c.j.e(adsConfig, "adsConfig");
        return System.currentTimeMillis() - e.a.a.d.q.a.a() > adsConfig.getInstallSplashTime() * ((long) 1000);
    }

    @NotNull
    public static final AdsConfig c(@NotNull Context context) {
        Object objM11constructorimpl;
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        String strO2 = c.b.a.m.f.O2(context, "adsConfig", null, 2);
        if (strO2 == null) {
            return new AdsConfig();
        }
        Gson gsonA = e.a.a.h.n.a();
        try {
            Type type = new a().getType();
            f.c0.c.j.d(type, "object : TypeToken<T>() {}.type");
            Object objFromJson = gsonA.fromJson(strO2, type);
            if (!(objFromJson instanceof AdsConfig)) {
                objFromJson = null;
            }
            objM11constructorimpl = f.h.m11constructorimpl((AdsConfig) objFromJson);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
        AdsConfig adsConfig = (AdsConfig) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        if (adsConfig == null) {
            return new AdsConfig();
        }
        adsConfig.getEnableAds();
        return adsConfig;
    }

    public static final boolean d(int i2) {
        return i2 == 100 || new Random().nextInt(100) + 1 <= i2;
    }
}
