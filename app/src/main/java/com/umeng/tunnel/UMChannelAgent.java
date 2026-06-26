package com.umeng.tunnel;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UMChannelAgent {
    private static final String TAG = "UMChannelAgent";
    private static final String UMENG_VCHANNEL = "com.umeng.commonsdk.vchannel.Sender";
    private static boolean vChannelReady = false;

    static {
        try {
            Class.forName(UMENG_VCHANNEL);
            vChannelReady = true;
        } catch (Throwable unused) {
        }
    }

    public static boolean init() {
        boolean z = vChannelReady;
        return vChannelReady;
    }

    public static void onDebugEvent(Context context, String str, Map<String, Object> map) {
        reflectOnEvent(context, str, map);
    }

    private static void reflectOnEvent(Context context, String str, Map<String, Object> map) {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("onEvent", Context.class, String.class, Map.class).invoke(null, context, str, map);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | Exception unused) {
        }
    }

    private static void reflectSetCustomHeader(Map<String, String> map) {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("setCustomHeader", Map.class).invoke(null, map);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | Exception unused) {
        }
    }

    public static void setCustomHeader(Map<String, String> map) {
        reflectSetCustomHeader(map);
    }
}
