package c.c.a;

import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.ZeusPluginStateListener;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q {
    public static volatile q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ZeusParam f779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<ZeusPluginStateListener> f780d = Collections.emptyList();

    public static q a() {
        if (a == null) {
            synchronized (q.class) {
                if (a == null) {
                    a = new q();
                }
            }
        }
        return a;
    }

    public static void b() {
        try {
            for (ProviderInfo providerInfo : Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers) {
                if (!TextUtils.isEmpty(providerInfo.authority)) {
                    if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ZeusConstants.a)) {
                        Zeus.getServerManagerHashMap().put((TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) ? "main" : providerInfo.processName.split(":")[1], providerInfo);
                    }
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
