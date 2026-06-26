package com.efs.sdk.base.protocol;

import com.efs.sdk.base.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsLog implements ILogProtocol {
    private String cp = Constants.CP_NONE;
    private byte de = 1;
    private String logType;

    public AbsLog(String str) {
        this.logType = str;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLogType() {
        return this.logType;
    }

    public boolean isCp() {
        return !this.cp.equals(Constants.CP_NONE);
    }

    public boolean isDe() {
        return this.de != 1;
    }

    public void setCp(String str) {
        this.cp = str;
    }

    public void setDe(byte b2) {
        this.de = b2;
    }
}
