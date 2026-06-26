package com.efs.sdk.base.a.c;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.camera.core.FocusMeteringAction;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f1776c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1781h;
    public ILogEncryptAction m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1777d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1778e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1779f = false;
    private Boolean p = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1780g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1782i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1783j = FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1784k = 10000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1785l = 10000;
    private Map<String, String> q = new HashMap(5);
    public ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> n = new ConcurrentHashMap<>();
    public List<IEfsReporterObserver> o = new ArrayList(5);

    public final Map<String, String> a() {
        Map<String, String> map = this.q;
        return map == null ? Collections.emptyMap() : map;
    }

    public final void a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap map2 = new HashMap(this.q);
        map2.putAll(map);
        this.q = map2;
    }

    public final List<ValueCallback<Pair<Message, Message>>> a(int i2) {
        if (this.n.containsKey(Integer.valueOf(i2)) && this.n.get(Integer.valueOf(i2)) != null) {
            return (List) this.n.get(Integer.valueOf(i2));
        }
        return Collections.emptyList();
    }
}
