package androidx.media2.session;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager {
    public static final String TAG = "MediaSessionManager";

    @GuardedBy("sLock")
    private static MediaSessionManager sInstance;
    private final Context mContext;
    public static final boolean DEBUG = Log.isLoggable("MediaSessionManager", 3);
    private static final Object sLock = new Object();

    private MediaSessionManager(Context context) {
        this.mContext = context;
    }

    @NonNull
    public static MediaSessionManager getInstance(@NonNull Context context) {
        MediaSessionManager mediaSessionManager;
        Objects.requireNonNull(context, "context shouldn't be null");
        synchronized (sLock) {
            if (sInstance == null) {
                sInstance = new MediaSessionManager(context.getApplicationContext());
            }
            mediaSessionManager = sInstance;
        }
        return mediaSessionManager;
    }

    @NonNull
    public Set<SessionToken> getSessionServiceTokens() {
        ServiceInfo serviceInfo;
        ArraySet arraySet = new ArraySet();
        PackageManager packageManager = this.mContext.getPackageManager();
        ArrayList<ResolveInfo> arrayList = new ArrayList();
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(new Intent(MediaLibraryService.SERVICE_INTERFACE), 128);
        if (listQueryIntentServices != null) {
            arrayList.addAll(listQueryIntentServices);
        }
        List<ResolveInfo> listQueryIntentServices2 = packageManager.queryIntentServices(new Intent(MediaSessionService.SERVICE_INTERFACE), 128);
        if (listQueryIntentServices2 != null) {
            arrayList.addAll(listQueryIntentServices2);
        }
        List<ResolveInfo> listQueryIntentServices3 = packageManager.queryIntentServices(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE), 128);
        if (listQueryIntentServices3 != null) {
            arrayList.addAll(listQueryIntentServices3);
        }
        for (ResolveInfo resolveInfo : arrayList) {
            if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                arraySet.add(new SessionToken(this.mContext, new ComponentName(serviceInfo.packageName, serviceInfo.name)));
            }
        }
        if (DEBUG) {
            arraySet.size();
            Iterator it = arraySet.iterator();
            while (it.hasNext()) {
                String str = "   " + ((SessionToken) it.next());
            }
        }
        return arraySet;
    }
}
