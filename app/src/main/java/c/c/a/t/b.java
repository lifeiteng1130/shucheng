package c.c.a.t;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f786b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> f787c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Integer> f788d = new CopyOnWriteArraySet();

    public static class a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<PluginBroadcastReceiver> f789b = new CopyOnWriteArraySet();

        public final void a(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                ZeusLogger.i(ZeusLogger.TAG_RECEIVER, "plugin-receiver:" + pluginBroadcastReceiver.getClass().getSimpleName() + ",action=" + this.a + "[注册完成]");
                this.f789b.add(pluginBroadcastReceiver);
            }
        }
    }

    public static b a() {
        if (a == null) {
            synchronized (c.c.a.w.a.a.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public final void b(Context context, Intent intent) {
        a value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, a> map = this.f786b;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, a> entry : this.f786b.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "action[" + action + "] match success ！ invoke onReceiver");
                Set<PluginBroadcastReceiver> set = value.f789b;
                if (set != null && set.size() > 0) {
                    for (PluginBroadcastReceiver pluginBroadcastReceiver : value.f789b) {
                        if (pluginBroadcastReceiver != null) {
                            try {
                                pluginBroadcastReceiver.onReceive(context, intent);
                            } catch (Throwable th) {
                                ZeusLogger.e(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + intent.getAction() + "[exception]:", th);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter.actionsIterator() != null) {
            Iterator<String> itActionsIterator = intentFilter.actionsIterator();
            while (itActionsIterator.hasNext()) {
                String next = itActionsIterator.next();
                if (next != null) {
                    a aVar = this.f786b.get(next);
                    if (aVar != null) {
                        aVar.a(pluginBroadcastReceiver);
                    } else {
                        a aVar2 = new a();
                        aVar2.a = next;
                        aVar2.a(pluginBroadcastReceiver);
                        this.f786b.put(next, aVar2);
                    }
                }
            }
        }
    }
}
