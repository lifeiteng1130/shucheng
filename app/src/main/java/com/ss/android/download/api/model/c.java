package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.j;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: DownloadEventModel.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f2925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f2927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f2928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f2929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<String> f2930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f2931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f2932l;
    private final String m;
    private final boolean n;
    private final String o;
    private final JSONObject p;

    /* JADX INFO: compiled from: DownloadEventModel.java */
    public static class a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f2934c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f2936e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2937f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f2938g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private JSONObject f2939h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private JSONObject f2940i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Map<String, Object> f2941j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<String> f2942k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f2943l;
        private Object m;
        private String n;
        private String p;
        private JSONObject q;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2935d = false;
        private boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f2934c = str;
            return this;
        }

        public a c(String str) {
            this.f2937f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.f2933b = str;
            return this;
        }

        public a b(long j2) {
            this.f2938g = j2;
            return this;
        }

        public a a(long j2) {
            this.f2936e = j2;
            return this;
        }

        public a b(boolean z) {
            this.f2935d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f2939h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f2940i = jSONObject;
            return this;
        }

        public a a(List<String> list) {
            this.f2942k = list;
            return this;
        }

        public a a(int i2) {
            this.f2943l = i2;
            return this;
        }

        public a a(Object obj) {
            this.m = obj;
            return this;
        }

        public c a() {
            if (TextUtils.isEmpty(this.a)) {
                this.a = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f2939h == null) {
                this.f2939h = new JSONObject();
            }
            try {
                Map<String, Object> map = this.f2941j;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f2941j.entrySet()) {
                        if (!this.f2939h.has(entry.getKey())) {
                            this.f2939h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f2934c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.f2935d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f2939h.toString());
                    } else {
                        Iterator<String> itKeys = this.f2939h.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.q.put(next, this.f2939h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.f2933b);
                    this.q.put(ES6Iterator.VALUE_PROPERTY, this.f2936e);
                    this.q.put("ext_value", this.f2938g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put("refer", this.n);
                    }
                    JSONObject jSONObject3 = this.f2940i;
                    if (jSONObject3 != null) {
                        this.q = com.ss.android.download.api.c.b.a(jSONObject3, this.q);
                    }
                    if (this.f2935d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f2937f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f2937f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, SdkVersion.MINI_VERSION);
                    }
                }
                if (this.f2935d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f2939h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f2937f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f2937f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, SdkVersion.MINI_VERSION);
                } else {
                    jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.f2939h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt("refer", this.n);
                }
                JSONObject jSONObject4 = this.f2940i;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(jSONObject4, jSONObject);
                }
                this.f2939h = jSONObject;
            } catch (Exception e2) {
                j.s().a(e2, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f2922b = aVar.f2933b;
        this.f2923c = aVar.f2934c;
        this.f2924d = aVar.f2935d;
        this.f2925e = aVar.f2936e;
        this.f2926f = aVar.f2937f;
        this.f2927g = aVar.f2938g;
        this.f2928h = aVar.f2939h;
        this.f2929i = aVar.f2940i;
        this.f2930j = aVar.f2942k;
        this.f2931k = aVar.f2943l;
        this.f2932l = aVar.m;
        this.n = aVar.o;
        this.o = aVar.p;
        this.p = aVar.q;
        this.m = aVar.n;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.f2922b;
    }

    public String c() {
        return this.f2923c;
    }

    public boolean d() {
        return this.f2924d;
    }

    public long e() {
        return this.f2925e;
    }

    public String f() {
        return this.f2926f;
    }

    public long g() {
        return this.f2927g;
    }

    public JSONObject h() {
        return this.f2928h;
    }

    public JSONObject i() {
        return this.f2929i;
    }

    public List<String> j() {
        return this.f2930j;
    }

    public int k() {
        return this.f2931k;
    }

    public Object l() {
        return this.f2932l;
    }

    public boolean m() {
        return this.n;
    }

    public String n() {
        return this.o;
    }

    public JSONObject o() {
        return this.p;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("category: ");
        sbR.append(this.a);
        sbR.append("\ttag: ");
        sbR.append(this.f2922b);
        sbR.append("\tlabel: ");
        sbR.append(this.f2923c);
        sbR.append("\nisAd: ");
        sbR.append(this.f2924d);
        sbR.append("\tadId: ");
        sbR.append(this.f2925e);
        sbR.append("\tlogExtra: ");
        sbR.append(this.f2926f);
        sbR.append("\textValue: ");
        sbR.append(this.f2927g);
        sbR.append("\nextJson: ");
        sbR.append(this.f2928h);
        sbR.append("\nparamsJson: ");
        sbR.append(this.f2929i);
        sbR.append("\nclickTrackUrl: ");
        List<String> list = this.f2930j;
        sbR.append(list != null ? list.toString() : "");
        sbR.append("\teventSource: ");
        sbR.append(this.f2931k);
        sbR.append("\textraObject: ");
        Object obj = this.f2932l;
        sbR.append(obj != null ? obj.toString() : "");
        sbR.append("\nisV3: ");
        sbR.append(this.n);
        sbR.append("\tV3EventName: ");
        sbR.append(this.o);
        sbR.append("\tV3EventParams: ");
        JSONObject jSONObject = this.p;
        sbR.append(jSONObject != null ? jSONObject.toString() : "");
        return sbR.toString();
    }
}
