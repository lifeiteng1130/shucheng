package e.a.a.h;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.umeng.analytics.pro.ai;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LanguageUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static final Locale a(Context context) {
        String strO2 = c.b.a.m.f.O2(context, ai.N, null, 2);
        if (strO2 != null) {
            int iHashCode = strO2.hashCode();
            if (iHashCode != 3241) {
                if (iHashCode != 3715) {
                    if (iHashCode == 3886 && strO2.equals("zh")) {
                        Locale locale = Locale.SIMPLIFIED_CHINESE;
                        f.c0.c.j.d(locale, "SIMPLIFIED_CHINESE");
                        return locale;
                    }
                } else if (strO2.equals("tw")) {
                    Locale locale2 = Locale.TRADITIONAL_CHINESE;
                    f.c0.c.j.d(locale2, "TRADITIONAL_CHINESE");
                    return locale2;
                }
            } else if (strO2.equals(h.a.a.a.n.DEFAULT_LANGUAGE)) {
                Locale locale3 = Locale.ENGLISH;
                f.c0.c.j.d(locale3, "ENGLISH");
                return locale3;
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale4 = Resources.getSystem().getConfiguration().getLocales().get(0);
            f.c0.c.j.d(locale4, "getSystem().configuration.locales.get(0)");
            return locale4;
        }
        Locale locale5 = Resources.getSystem().getConfiguration().locale;
        f.c0.c.j.d(locale5, "getSystem().configuration.locale");
        return locale5;
    }

    @NotNull
    public static final Context b(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24) {
            if (i2 >= 24) {
                return context;
            }
            Resources resources = context.getResources();
            f.c0.c.j.d(resources, "context.resources");
            Locale localeA = a(context);
            Configuration configuration = resources.getConfiguration();
            f.c0.c.j.d(configuration, "resources.configuration");
            configuration.locale = localeA;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return context;
        }
        Resources resources2 = context.getResources();
        f.c0.c.j.d(resources2, "context.resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        Configuration configuration2 = resources2.getConfiguration();
        f.c0.c.j.d(configuration2, "resources.configuration");
        Locale localeA2 = a(context);
        configuration2.setLocale(localeA2);
        configuration2.setLocales(new LocaleList(localeA2));
        resources2.updateConfiguration(configuration2, displayMetrics);
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration2);
        f.c0.c.j.d(contextCreateConfigurationContext, "{\n            val resources: Resources = context.resources\n            val metrics = resources.displayMetrics\n            val configuration: Configuration = resources.configuration\n            val targetLocale = getSetLocale(context)\n            configuration.setLocale(targetLocale)\n            configuration.setLocales(LocaleList(targetLocale))\n            @Suppress(\"DEPRECATION\")\n            resources.updateConfiguration(configuration, metrics)\n            context.createConfigurationContext(configuration)\n        }");
        return contextCreateConfigurationContext;
    }
}
