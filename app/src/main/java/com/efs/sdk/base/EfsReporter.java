package com.efs.sdk.base;

import android.app.Application;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.b.e;
import com.efs.sdk.base.a.c.a.c;
import com.efs.sdk.base.a.d.a;
import com.efs.sdk.base.a.h.d;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import com.efs.sdk.base.protocol.ILogProtocol;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class EfsReporter {
    private static a sControllerCenter;

    public static class Builder {
        private static Map<String, EfsReporter> sInstanceMap = new ConcurrentHashMap();
        private static boolean sUseAppContext = true;
        private final String TAG;
        private com.efs.sdk.base.a.c.a mGlobalEnvStruct;

        public interface IPublicParams {
            Map<String, String> getRecordHeaders();
        }

        public Builder(@NonNull Application application, @NonNull String str, @NonNull String str2) {
            this(application.getApplicationContext(), str, str2);
        }

        private static Context checkContext(Context context) {
            if (context == null) {
                d.b("efs.base", "context can not be null!", null);
                throw null;
            }
            if (!sUseAppContext || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            }
            d.b("efs.base", "Can not get Application context from given context!", null);
            throw new IllegalArgumentException("Can not get Application context from given context!");
        }

        private void checkParam(String str) {
            com.efs.sdk.base.a.c.a globalEnvStruct = sInstanceMap.get(str).getGlobalEnvStruct();
            if (!globalEnvStruct.f1776c.equals(getGlobalEnvStruct().f1776c)) {
                throw new RuntimeException(c.a.a.a.a.i("efs-core: duplicate init, but ", "application context is different"));
            }
            if (!TextUtils.isEmpty(globalEnvStruct.f1775b) && !globalEnvStruct.f1775b.equals(getGlobalEnvStruct().f1775b)) {
                throw new RuntimeException(c.a.a.a.a.i("efs-core: duplicate init, but ", "secret is different"));
            }
            if (globalEnvStruct.f1782i != getGlobalEnvStruct().f1782i) {
                throw new RuntimeException(c.a.a.a.a.i("efs-core: duplicate init, but ", "intl setting is different"));
            }
            if (!TextUtils.isEmpty(getGlobalEnvStruct().f1781h) && !getGlobalEnvStruct().f1781h.equals(globalEnvStruct.f1781h)) {
                d.a("efs.reporter.builder", "efs-core: duplicate init, but  uid is different", null);
            }
            if (getGlobalEnvStruct().a() == null || getGlobalEnvStruct().a().size() <= 0) {
                return;
            }
            globalEnvStruct.a(getGlobalEnvStruct().a());
        }

        public Builder addEfsReporterObserver(IEfsReporterObserver iEfsReporterObserver) {
            com.efs.sdk.base.a.c.a aVar = this.mGlobalEnvStruct;
            if (!aVar.o.contains(iEfsReporterObserver)) {
                aVar.o.add(iEfsReporterObserver);
            }
            return this;
        }

        public EfsReporter build() {
            String str = getGlobalEnvStruct().a;
            if (!sInstanceMap.containsKey(str)) {
                synchronized (EfsReporter.class) {
                    if (!sInstanceMap.containsKey(str)) {
                        EfsReporter efsReporter = new EfsReporter(this);
                        sInstanceMap.put(str, efsReporter);
                        return efsReporter;
                    }
                }
            }
            d.a("efs.reporter.builder", "efs-core: duplicate init", null);
            checkParam(str);
            return sInstanceMap.get(str);
        }

        public Builder configRefreshAction(@NonNull IConfigRefreshAction iConfigRefreshAction) {
            c.a().f1791b = iConfigRefreshAction;
            return this;
        }

        public Builder configRefreshDelayMills(long j2) {
            this.mGlobalEnvStruct.f1783j = j2;
            return this;
        }

        public Builder debug(boolean z) {
            this.mGlobalEnvStruct.f1779f = z;
            return this;
        }

        public Builder efsDirRootName(String str) {
            com.efs.sdk.base.a.h.a.a(str);
            return this;
        }

        public Builder enableSendLog(boolean z) {
            this.mGlobalEnvStruct.f1778e = z;
            return this;
        }

        public Builder enableWaStat(boolean z) {
            this.mGlobalEnvStruct.f1777d = z;
            return this;
        }

        public com.efs.sdk.base.a.c.a getGlobalEnvStruct() {
            return this.mGlobalEnvStruct;
        }

        public Builder intl(boolean z) {
            this.mGlobalEnvStruct.f1782i = z;
            return this;
        }

        public Builder logEncryptAction(ILogEncryptAction iLogEncryptAction) {
            this.mGlobalEnvStruct.m = iLogEncryptAction;
            return this;
        }

        public Builder maxConcurrentUploadCnt(int i2) {
            com.efs.sdk.base.a.e.d.a().a = i2;
            return this;
        }

        public Builder printLogDetail(boolean z) {
            this.mGlobalEnvStruct.f1780g = z;
            return this;
        }

        public Builder publicParams(@NonNull IPublicParams iPublicParams) {
            if (iPublicParams.getRecordHeaders() != null && iPublicParams.getRecordHeaders().size() > 0) {
                this.mGlobalEnvStruct.a(iPublicParams.getRecordHeaders());
            }
            return this;
        }

        public Builder uid(String str) {
            this.mGlobalEnvStruct.f1781h = str;
            return this;
        }

        public Builder(@NonNull Context context, @NonNull String str, @NonNull String str2) {
            this.TAG = "efs.reporter.builder";
            Context contextCheckContext = checkContext(context);
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("EfsReporter init, appid is empty");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new RuntimeException("EfsReporter init, secret is empty");
            }
            com.efs.sdk.base.a.c.a aVar = new com.efs.sdk.base.a.c.a();
            this.mGlobalEnvStruct = aVar;
            aVar.f1776c = contextCheckContext;
            aVar.a = str;
            aVar.f1775b = str2;
        }

        public Builder publicParams(@NonNull Map<String, String> map) {
            if (map.size() > 0) {
                this.mGlobalEnvStruct.a(map);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.efs.sdk.base.a.c.a getGlobalEnvStruct() {
        return a.a();
    }

    public void addPublicParams(@NonNull Map<String, String> map) {
        if (map.size() > 0) {
            getGlobalEnvStruct().a(map);
        }
    }

    public void flushRecordLogImmediately(String str) {
        e eVarA = a.b.a.f1770c.a((byte) 1);
        if (eVarA != null) {
            eVarA.a(str);
        }
    }

    public Map<String, String> getAllConfig() {
        return c.a().c();
    }

    public void getAllSdkConfig(String[] strArr, IConfigCallback iConfigCallback) {
        c cVarA = c.a();
        cVarA.f1794e.put(iConfigCallback, strArr);
        if (cVarA.f1793d.f1789e.isEmpty()) {
            return;
        }
        cVarA.d();
    }

    public void refreshConfig(String str) {
        c.a().a(str);
    }

    public void registerCallback(int i2, ValueCallback<Pair<Message, Message>> valueCallback) {
        com.efs.sdk.base.a.c.a globalEnvStruct = getGlobalEnvStruct();
        if (valueCallback != null) {
            List linkedList = (List) globalEnvStruct.n.get(Integer.valueOf(i2));
            if (linkedList == null) {
                linkedList = new LinkedList();
                globalEnvStruct.n.putIfAbsent(Integer.valueOf(i2), linkedList);
            }
            linkedList.add(valueCallback);
        }
    }

    public void send(ILogProtocol iLogProtocol) {
        sControllerCenter.a(iLogProtocol);
    }

    public HttpResponse sendSyncImediatelly(String str, int i2, String str2, File file) {
        return sendSyncImediatelly(str, i2, str2, true, file);
    }

    public void setEnableRefreshConfigFromRemote(boolean z) {
        c.a().f1792c = z;
    }

    private EfsReporter(Builder builder) {
        sControllerCenter = new com.efs.sdk.base.a.d.a(builder);
    }

    public HttpResponse sendSyncImediatelly(String str, int i2, String str2, boolean z, File file) {
        return com.efs.sdk.base.a.d.a.a(str, i2, str2, z, file);
    }

    public Map<String, Object> getAllSdkConfig() {
        return new HashMap(c.a().f1793d.f1789e);
    }
}
