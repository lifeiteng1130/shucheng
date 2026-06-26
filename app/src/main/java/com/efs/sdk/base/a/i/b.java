package com.efs.sdk.base.a.i;

import com.efs.sdk.base.protocol.record.AbsRecordLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbsRecordLog {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1849d;

    public b(String str, String str2, String str3) {
        super("wa");
        this.a = str;
        this.f1847b = str2;
        this.f1849d = str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.CHINA);
        com.efs.sdk.base.a.a.a.a();
        this.f1848c = simpleDateFormat.format(new Date(com.efs.sdk.base.a.a.a.b()));
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final byte[] generate() {
        String strGenerateString = generateString();
        if (com.efs.sdk.base.a.d.a.a().f1780g) {
            com.efs.sdk.base.a.h.d.a("efs.base", strGenerateString);
        }
        return strGenerateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String generateString() {
        StringBuilder sbT = c.a.a.a.a.t("lt=event`", "ev_ct=");
        sbT.append(this.a);
        sbT.append("`");
        sbT.append("ev_ac=");
        sbT.append(this.f1847b);
        sbT.append("`");
        sbT.append("tm=");
        sbT.append(this.f1848c);
        sbT.append("`");
        sbT.append("dn=");
        sbT.append(this.f1849d);
        sbT.append("`");
        for (Map.Entry<String, Object> entry : this.dataMap.entrySet()) {
            sbT.append(entry.getKey());
            sbT.append("=");
            sbT.append(entry.getValue());
            sbT.append("`");
        }
        return sbT.subSequence(0, sbT.length() - 1).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkId() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkKey() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void insertGlobal(com.efs.sdk.base.a.c.b bVar) {
        this.dataMap.putAll(bVar.a());
        this.dataMap.putAll(com.efs.sdk.base.a.d.a.a().a());
    }
}
