package com.bytedance.pangle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import c.c.a.t.b;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.receiver.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ComponentManager {
    public static HashMap<String, String> target2StubActivity = new HashMap<>();
    public static HashMap<String, String> targetString2StubActivity = new HashMap<>();
    public static HashMap<String, String> targetString2PluginPkgName = new HashMap<>();
    public static HashMap<String, String> stubString2PluginPkgName = new HashMap<>();

    public static void registerActivity(String str, String str2, String... strArr) {
        if (strArr != null) {
            for (String str3 : strArr) {
                String str4 = targetString2PluginPkgName.get(str3);
                if (str4 != null && TextUtils.equals(str4, str)) {
                    throw new RuntimeException(String.format("%s is repeated in %s and %s", str3, str, str4));
                }
                target2StubActivity.put(str3, str2);
                targetString2StubActivity.put(str3, str2);
                targetString2PluginPkgName.put(str3, str);
                stubString2PluginPkgName.put(str2, str);
            }
        }
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        Zeus.loadPlugin(str);
        if (pluginBroadcastReceiver != null) {
            b bVarA = b.a();
            if (intentFilter != null && intentFilter.actionsIterator() != null) {
                a aVar = new a();
                Intent intentRegisterReceiver = context.registerReceiver(aVar, intentFilter);
                bVarA.f787c.put(pluginBroadcastReceiver, aVar);
                bVarA.c(intentFilter, pluginBroadcastReceiver);
                return intentRegisterReceiver;
            }
        }
        return null;
    }

    public static void startActivity(Context context, Intent intent, String str) {
        startActivity(context, intent, null, str);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, String str) {
        startActivityForResult(activity, intent, i2, null, str);
    }

    public static void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        boolean zRemove;
        if (pluginBroadcastReceiver != null) {
            b bVarA = b.a();
            Iterator<Map.Entry<String, b.a>> it = bVarA.f786b.entrySet().iterator();
            while (it.hasNext()) {
                b.a value = it.next().getValue();
                if (value != null) {
                    try {
                        if (value.f789b.size() > 0 && (zRemove = value.f789b.remove(pluginBroadcastReceiver))) {
                            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "unregisterReceiver->[移除Action]:" + value.a + ",receiver.hashCode()=" + pluginBroadcastReceiver.hashCode() + ",是否成功，success:" + zRemove);
                        }
                    } catch (Throwable th) {
                        ZeusLogger.e(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + value.a + "[exception]:", th);
                    }
                }
                BroadcastReceiver broadcastReceiver = bVarA.f787c.get(pluginBroadcastReceiver);
                if (broadcastReceiver != null) {
                    try {
                        bVarA.f788d.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                        bVarA.f787c.remove(pluginBroadcastReceiver);
                        context.unregisterReceiver(broadcastReceiver);
                    } catch (Throwable th2) {
                        ZeusLogger.e(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th2);
                    }
                }
            }
        }
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle, String str) {
        if (context instanceof PluginContext) {
            context = ((PluginContext) context).mOriginContext;
        }
        if (intent.getComponent() == null) {
            try {
                context.startActivity(intent, bundle);
                return;
            } catch (Throwable th) {
                throw new RuntimeException("隐式意图 todo", th);
            }
        }
        String className = intent.getComponent().getClassName();
        Zeus.loadPlugin(str);
        String str2 = targetString2StubActivity.get(className);
        if (!TextUtils.isEmpty(str2)) {
            intent.setComponent(new ComponentName(context, str2));
            intent.putExtra("targetPlugin", className);
        }
        context.startActivity(intent, bundle);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, Bundle bundle, String str) {
        if (intent.getComponent() == null) {
            try {
                activity.startActivityForResult(intent, i2, bundle);
                return;
            } catch (Throwable th) {
                throw new RuntimeException("隐式意图 todo", th);
            }
        }
        String className = intent.getComponent().getClassName();
        Zeus.loadPlugin(str);
        String str2 = targetString2StubActivity.get(className);
        if (!TextUtils.isEmpty(str2)) {
            intent.setComponent(new ComponentName(activity, str2));
            intent.putExtra("targetPlugin", className);
        }
        activity.startActivityForResult(intent, i2, bundle);
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        Zeus.loadPlugin(str2);
        if (pluginBroadcastReceiver != null) {
            b bVarA = b.a();
            if (intentFilter != null && intentFilter.actionsIterator() != null) {
                a aVar = new a();
                Intent intentRegisterReceiver = context.registerReceiver(aVar, intentFilter, str, handler);
                bVarA.f787c.put(pluginBroadcastReceiver, aVar);
                if (handler != null) {
                    bVarA.f788d.add(Integer.valueOf(aVar.hashCode()));
                }
                bVarA.c(intentFilter, pluginBroadcastReceiver);
                return intentRegisterReceiver;
            }
        }
        return null;
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i2, String str) {
        Zeus.loadPlugin(str);
        if (pluginBroadcastReceiver != null) {
            b bVarA = b.a();
            if (intentFilter != null && intentFilter.actionsIterator() != null && Build.VERSION.SDK_INT >= 26) {
                a aVar = new a();
                Intent intentRegisterReceiver = context.registerReceiver(aVar, intentFilter, i2);
                bVarA.f787c.put(pluginBroadcastReceiver, aVar);
                bVarA.c(intentFilter, pluginBroadcastReceiver);
                return intentRegisterReceiver;
            }
        }
        return null;
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2, String str2) {
        Zeus.loadPlugin(str2);
        if (pluginBroadcastReceiver != null) {
            b bVarA = b.a();
            if (intentFilter != null && intentFilter.actionsIterator() != null && Build.VERSION.SDK_INT >= 26) {
                a aVar = new a();
                Intent intentRegisterReceiver = context.registerReceiver(aVar, intentFilter, str, handler, i2);
                bVarA.f787c.put(pluginBroadcastReceiver, aVar);
                if (handler != null) {
                    bVarA.f788d.add(Integer.valueOf(aVar.hashCode()));
                }
                bVarA.c(intentFilter, pluginBroadcastReceiver);
                return intentRegisterReceiver;
            }
        }
        return null;
    }
}
