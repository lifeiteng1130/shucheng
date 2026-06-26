package com.efs.sdk.base.protocol.record;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.c.b;
import com.efs.sdk.base.a.d.a;
import com.efs.sdk.base.a.h.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EfsJSONLog extends AbsRecordLog {
    public EfsJSONLog(String str) {
        super(str);
        put("type", str);
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        String strGenerateString = generateString();
        if (a.a().f1780g) {
            d.a("efs.base", strGenerateString);
        }
        return strGenerateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String generateString() {
        return new JSONObject(this.dataMap).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkId() {
        if (this.dataMap.containsKey(Constants.LOG_KEY_LINK_ID)) {
            return String.valueOf(this.dataMap.get(Constants.LOG_KEY_LINK_ID));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkKey() {
        if (this.dataMap.containsKey(Constants.LOG_KEY_LINK_KEY)) {
            return String.valueOf(this.dataMap.get(Constants.LOG_KEY_LINK_KEY));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(b bVar) {
        this.dataMap.putAll(bVar.a());
        this.dataMap.putAll(a.a().a());
    }
}
