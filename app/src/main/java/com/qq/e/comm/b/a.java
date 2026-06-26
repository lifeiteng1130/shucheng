package com.qq.e.comm.b;

import android.content.Context;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.d;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.umeng.analytics.pro.ai;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.helper.DataUtil;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f2767b = new a();
    private volatile Boolean a = Boolean.FALSE;

    /* JADX INFO: renamed from: com.qq.e.comm.b.a$a, reason: collision with other inner class name */
    public class C0070a implements NetworkCallBack {
        public final /* synthetic */ PM a;

        public C0070a(a aVar, PM pm) {
            this.a = pm;
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public void onException(Exception exc) {
            GDTLogger.d("ActivateError");
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public void onResponse(Request request, Response response) {
            String str;
            StringBuilder sb;
            try {
                if (response.getStatusCode() == 200) {
                    String stringContent = response.getStringContent();
                    GDTLogger.d("ACTIVERESPONSE:" + stringContent);
                    if (StringUtil.isEmpty(stringContent)) {
                        GDTLogger.d("SDK Server response empty string,maybe zip or tea format error");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(stringContent);
                    int i2 = jSONObject.has(Constants.KEYS.RET) ? jSONObject.getInt(Constants.KEYS.RET) : -1;
                    if (i2 == 0) {
                        PM pm = this.a;
                        if (pm != null) {
                            try {
                                pm.getPOFactory().config(1, stringContent);
                            } catch (d e2) {
                                e2.printStackTrace();
                            }
                            if (jSONObject.has("sig")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("sig");
                                if (jSONObject2.has("jar") && jSONObject2.has("url")) {
                                    this.a.update(jSONObject2.getString("jar"), jSONObject2.getString("url"));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    sb = new StringBuilder();
                    sb.append("Response Error,retCode=");
                    sb.append(i2);
                } else {
                    sb = new StringBuilder();
                    sb.append("SDK server response code error while launch or activate,code:");
                    sb.append(response.getStatusCode());
                }
                GDTLogger.d(sb.toString());
            } catch (IOException unused) {
                str = "ActivateError";
                GDTLogger.d(str);
            } catch (JSONException unused2) {
                str = "Parse Active or launch response exception";
                GDTLogger.d(str);
            }
        }
    }

    public static a a() {
        return f2767b;
    }

    private void a(SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, Context context, long j2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (sm != null) {
                jSONObject3.putOpt("suid", sm.getSuid());
                jSONObject3.putOpt("sid", sm.getSid());
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                if (sm != null) {
                    jSONObject4.putOpt("app", sm.getDevCloudSettingSig());
                    jSONObject4.putOpt("sdk", sm.getSdkCloudSettingSig());
                }
                if (pm != null) {
                    jSONObject4.putOpt("jar", pm.getLocalSig());
                    jSONObject4.putOpt("plugin_version", Integer.valueOf(pm.getPluginVersion()));
                }
                jSONObject3.put("sig", jSONObject4);
                jSONObject3.put("dev", com.qq.e.comm.net.a.b(deviceStatus));
                jSONObject3.put("app", com.qq.e.comm.net.a.a(aPPStatus));
                jSONObject3.put(ai.aD, com.qq.e.comm.net.a.a(deviceStatus));
                jSONObject3.put("sdk", com.qq.e.comm.net.a.a(pm));
                JSONObject jSONObject5 = new JSONObject();
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("sdk_init_time", (System.nanoTime() - j2) / 1000000);
                jSONObject5.put("performance", jSONObject6);
                jSONObject3.put(Constants.KEYS.BIZ, jSONObject5);
                jSONObject = jSONObject3;
            } catch (JSONException unused) {
                jSONObject2 = jSONObject3;
                GDTLogger.d("JSONException while build init req");
                jSONObject = jSONObject2;
            }
        } catch (JSONException unused2) {
        }
        String string = jSONObject.toString();
        GDTLogger.d("launch request: " + string);
        String str = !StringUtil.isEmpty(sm.getSuid()) ? "http://sdk.e.qq.com/launch" : "http://sdk.e.qq.com/activate";
        System.currentTimeMillis();
        NetworkClientImpl.getInstance().submit(new S2SSRequest(str, string.getBytes(Charset.forName(DataUtil.defaultCharset))), NetworkClient.Priority.High, new C0070a(this, pm));
    }

    public void a(Context context, SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j2) {
        if (this.a.booleanValue()) {
            return;
        }
        synchronized (a.class) {
            if (this.a.booleanValue()) {
                return;
            }
            a(sm, pm, deviceStatus, aPPStatus, context, j2);
            this.a = Boolean.TRUE;
        }
    }
}
