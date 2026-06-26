package com.bytedance.pangle.transform;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.GeneratePluginActivity;
import com.bytedance.pangle.activity.GeneratePluginAppCompatActivity;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ZeusTransformUtils {
    private static final String TAG = "PluginContextUtils";
    public static Class fragmentClazz = null;
    public static boolean hasEnsure = false;

    public static Activity _getActivity(Object obj, String str) {
        try {
            return (Activity) wrapperContext((Activity) MethodUtils.invokeMethod(obj, "getActivity", new Object[0]), str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static boolean bindService(Object obj, Intent intent, ServiceConnection serviceConnection, int i2, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().bindServiceNative((Context) obj, intent, serviceConnection, i2, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "bindService", new Object[]{intent, serviceConnection, Integer.valueOf(i2)}, new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE})).booleanValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void ensureFragmentActivity() {
        if (hasEnsure) {
            return;
        }
        try {
            try {
                fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            } catch (Throwable unused) {
                fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            }
        } catch (Throwable unused2) {
        }
        hasEnsure = true;
    }

    private static boolean equalsFragmentActivity(Class cls) {
        ensureFragmentActivity();
        Class cls2 = fragmentClazz;
        return cls2 != null && cls == cls2;
    }

    public static Class forName(String str, String str2) {
        return Zeus.getPlugin(str2).mClassLoader.loadClass(str);
    }

    public static Activity getActivity(Object obj, String str) {
        return _getActivity(obj, str);
    }

    public static Context getContext(Object obj, String str) {
        try {
            Context context = (Context) MethodUtils.invokeMethod(obj, "getContext", new Object[0]);
            return instanceOfFragmentActivity(context) ? wrapperContext(context, str) : context instanceof Activity ? wrapperContext(context, str) : context instanceof Application ? wrapperContext(context, str) : context instanceof PluginContext ? context : wrapperContext(context, str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static int getIdentifier(Object obj, String str, String str2, String str3, String str4) {
        if (!(obj instanceof Resources)) {
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "getIdentifier", str, str2, str3)).intValue();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        Resources resources = (Resources) obj;
        if (!TextUtils.equals("android", str3)) {
            str3 = str4;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public static Resources getResources(Object obj, String str) {
        try {
            Resources resources = (Resources) MethodUtils.invokeMethod(obj, "getResources", new Object[0]);
            return (resources == null || (resources instanceof PluginResources)) ? resources : PluginManager.getInstance().getPlugin(str).mResources;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean hasWrapper(Context context) {
        while (context != null) {
            if (context.getResources() instanceof PluginResources) {
                return true;
            }
            if (!(context instanceof ContextWrapper)) {
                return false;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return false;
    }

    public static View inflate(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z, String str) {
        Context context = layoutInflater.getContext();
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
            layoutInflater = (LayoutInflater) wrapperContext(context, str).getSystemService("layout_inflater");
        }
        return layoutInflater.inflate(i2, viewGroup, z);
    }

    public static boolean instanceOf(Object obj, Class cls) {
        Object field;
        if (obj instanceof PluginContext) {
            return cls.isInstance(((PluginContext) obj).mOriginContext);
        }
        if (obj instanceof PluginActivityWrapper) {
            return cls.isInstance(((PluginActivityWrapper) obj).mOriginActivity);
        }
        if (!(obj instanceof PluginFragmentActivityWrapper)) {
            return obj instanceof PluginApplicationWrapper ? cls.isInstance(((PluginApplicationWrapper) obj).mOriginApplication) : cls.isInstance(obj);
        }
        try {
            try {
                field = ((PluginFragmentActivityWrapper) obj).getOriginActivity();
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        } catch (Throwable unused) {
            field = FieldUtils.readField(obj, "mOriginActivity");
        }
        return cls.isInstance(field);
    }

    private static boolean instanceOfFragmentActivity(Object obj) {
        ensureFragmentActivity();
        Class cls = fragmentClazz;
        if (cls == null) {
            return false;
        }
        return cls.isInstance(obj);
    }

    public static Object preCheckCast(Object obj, Class cls, String str) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Context)) {
            return obj;
        }
        boolean z = !cls.isInstance(obj);
        if (equalsFragmentActivity(cls)) {
            return wrapperContext2FragmentActivity(obj, str);
        }
        if (cls == Activity.class) {
            return wrapperContext2Activity(obj, str);
        }
        if (cls == Application.class) {
            return wrapperContext2Application(obj, str);
        }
        if ((obj instanceof PluginContext) && z) {
            return ((PluginContext) obj).mOriginContext;
        }
        if (!(obj instanceof PluginFragmentActivityWrapper) || !z) {
            return ((obj instanceof PluginActivityWrapper) && z) ? ((PluginActivityWrapper) obj).mOriginActivity : ((obj instanceof PluginApplicationWrapper) && z) ? ((PluginApplicationWrapper) obj).mOriginApplication : obj;
        }
        try {
            try {
                return ((PluginFragmentActivityWrapper) obj).getOriginActivity();
            } catch (Throwable unused) {
                return FieldUtils.readField(obj, "mOriginActivity");
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void registerZeusActivityStub(String str, String[] strArr, String str2) {
        ComponentManager.registerActivity(str2, str, strArr);
    }

    public static void requestPermissions(Object obj, String[] strArr, int i2, String str) {
        if (obj instanceof IPluginActivity) {
            ((IPluginActivity) obj)._requestPermissions(strArr, i2);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "requestPermissions", strArr, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void setResult(Object obj, int i2, Intent intent, String str) {
        if (obj instanceof Activity) {
            try {
                Object field = FieldUtils.readField(obj, "mProxyActivity");
                if (field != null) {
                    MethodUtils.invokeMethod(field, "setResult", Integer.valueOf(i2), intent);
                    return;
                }
            } catch (Exception unused) {
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = ".concat(String.valueOf(obj)));
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i2), intent);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void startActivity(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            ComponentManager.startActivity((Context) obj, intent, str);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "startActivity", intent);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i2, String str) {
        if (obj instanceof Activity) {
            ComponentManager.startActivityForResult((Activity) obj, intent, i2, str);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "startActivityForResult", intent, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static ComponentName startService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().startServiceNative((Context) obj, intent, str);
        }
        try {
            return (ComponentName) MethodUtils.invokeMethod(obj, "startService", intent);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean stopService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().stopServiceNative((Context) obj, intent, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "stopService", intent)).booleanValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void unbindService(Object obj, ServiceConnection serviceConnection, String str) {
        if (obj instanceof Context) {
            ServiceManagerNative.getInstance().unbindServiceNative(serviceConnection);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unbindService", serviceConnection);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void unregisterReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, String str) {
        if (obj instanceof Context) {
            ComponentManager.unregisterReceiver((Context) obj, pluginBroadcastReceiver);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unregisterReceiver", pluginBroadcastReceiver);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Context wrapperContext(Object obj, String str) {
        Application application;
        if (Zeus.getAppApplication() == null && (application = (Application) ((Context) obj).getApplicationContext()) != null) {
            Zeus.setAppContext(application);
        }
        Context context = (Context) obj;
        if (hasWrapper(context)) {
            return context;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof PluginContext) {
            return (Context) obj;
        }
        if (obj instanceof PluginActivityWrapper) {
            return (Context) obj;
        }
        if (obj instanceof PluginFragmentActivityWrapper) {
            return (Context) obj;
        }
        if (obj instanceof PluginApplicationWrapper) {
            return (Context) obj;
        }
        if (instanceOfFragmentActivity(obj)) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            try {
                try {
                    return new PluginFragmentActivityWrapper((Activity) obj, new PluginContext((Context) obj, PluginManager.getInstance().getPlugin(str), false));
                } catch (Throwable unused) {
                    return (Context) obj;
                }
            } catch (Throwable unused2) {
                return (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{obj, new PluginContext((Context) obj, PluginManager.getInstance().getPlugin(str), false)}, new Class[]{fragmentClazz, PluginContext.class});
            }
        }
        if (!(obj instanceof Activity)) {
            return obj instanceof Application ? new PluginApplicationWrapper((Application) obj, new PluginContext((Context) obj, PluginManager.getInstance().getPlugin(str), true)) : new PluginContext((Context) obj, PluginManager.getInstance().getPlugin(str), false);
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        return new PluginActivityWrapper((Activity) obj, new PluginContext((Context) obj, PluginManager.getInstance().getPlugin(str), false));
    }

    public static Activity wrapperContext2Activity(Object obj, String str) {
        while (obj != null) {
            Context contextWrapperContext = wrapperContext(obj, str);
            if (contextWrapperContext instanceof Activity) {
                return (Activity) contextWrapperContext;
            }
            if (!(contextWrapperContext instanceof PluginContext)) {
                throw new RuntimeException("强转失败");
            }
            obj = ((PluginContext) contextWrapperContext).mOriginContext;
        }
        return null;
    }

    public static Application wrapperContext2Application(Object obj, String str) {
        while (obj != null) {
            Context contextWrapperContext = wrapperContext(obj, str);
            if (contextWrapperContext instanceof Application) {
                return (Application) contextWrapperContext;
            }
            if (!(contextWrapperContext instanceof PluginContext)) {
                throw new RuntimeException("强转失败");
            }
            obj = ((PluginContext) contextWrapperContext).mOriginContext;
        }
        return null;
    }

    private static Object wrapperContext2FragmentActivity(Object obj, String str) {
        while (obj != null) {
            Context contextWrapperContext = wrapperContext(obj, str);
            if (instanceOfFragmentActivity(contextWrapperContext)) {
                return contextWrapperContext;
            }
            if (!(contextWrapperContext instanceof PluginContext)) {
                throw new RuntimeException("强转失败");
            }
            obj = ((PluginContext) contextWrapperContext).mOriginContext;
        }
        return null;
    }

    public static Object wrapperContextForParams(Object obj, Class cls, String str) {
        if (!(obj instanceof GeneratePluginActivity) && !(obj instanceof GeneratePluginAppCompatActivity) && (obj instanceof Context)) {
            Context contextWrapperContext = wrapperContext(obj, str);
            if (cls.isInstance(wrapperContext(obj, str))) {
                return contextWrapperContext;
            }
        }
        return obj;
    }

    public static void startActivity(Object obj, Intent intent, Bundle bundle, String str) {
        if (obj instanceof Context) {
            ComponentManager.startActivity((Context) obj, intent, bundle, str);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "startActivity", new Object[]{intent, bundle}, new Class[]{Intent.class, Bundle.class});
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i2, Bundle bundle, String str) {
        if (obj instanceof Activity) {
            ComponentManager.startActivityForResult((Activity) obj, intent, i2, bundle, str);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i2), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, i2, viewGroup, viewGroup != null, str);
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, xmlPullParser, viewGroup, viewGroup != null, str);
    }

    public static void setResult(Object obj, int i2, String str) {
        if (obj instanceof Activity) {
            try {
                Object field = FieldUtils.readField(obj, "mProxyActivity");
                if (field != null) {
                    MethodUtils.invokeMethod(field, "setResult", Integer.valueOf(i2));
                    return;
                }
            } catch (Exception unused) {
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = ".concat(String.valueOf(obj)));
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z, String str) {
        Context context = layoutInflater.getContext();
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
            layoutInflater = (LayoutInflater) wrapperContext(context, str).getSystemService("layout_inflater");
        }
        return layoutInflater.inflate(xmlPullParser, viewGroup, z);
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i2, String str) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[3 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, i2, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static View inflate(Context context, int i2, ViewGroup viewGroup, String str) {
        if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
            context = wrapperContext(context, str);
        }
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i2, viewGroup);
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2, String str2) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[5 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, i2, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
