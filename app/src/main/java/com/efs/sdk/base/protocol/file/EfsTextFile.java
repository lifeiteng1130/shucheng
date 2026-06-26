package com.efs.sdk.base.protocol.file;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.c.b;
import com.efs.sdk.base.a.d.a;
import com.efs.sdk.base.a.h.d;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.JSONSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.efs.sdk.base.protocol.file.section.TextSection;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.pi.ACTD;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class EfsTextFile extends AbsFileLog {
    private static final String FILE_START = "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***";
    private static final String SECTION_START = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    private boolean mHasInitLinkInfo;
    private String mLinkID;
    private String mLinkKey;
    private List<AbsSection> sectionList;

    public EfsTextFile(String str) {
        super(str);
        this.sectionList = new ArrayList();
        this.mLinkKey = null;
        this.mLinkID = null;
        this.mHasInitLinkInfo = false;
    }

    private String changeToStr() {
        StringBuilder sb = new StringBuilder(FILE_START);
        sb.append("\n");
        int i2 = 0;
        for (AbsSection absSection : this.sectionList) {
            if (i2 > 0) {
                sb.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            }
            sb.append(absSection.changeToStr());
            i2++;
        }
        return sb.toString();
    }

    private void initLinkInfo() {
        if ((TextUtils.isEmpty(this.mLinkID) || TextUtils.isEmpty(this.mLinkKey)) && !this.mHasInitLinkInfo) {
            for (AbsSection absSection : this.sectionList) {
                if (absSection instanceof KVSection) {
                    Map<String, Object> dataMap = ((KVSection) absSection).getDataMap();
                    if (TextUtils.isEmpty(this.mLinkID) && dataMap.containsKey(Constants.LOG_KEY_LINK_ID)) {
                        this.mLinkID = String.valueOf(dataMap.get(Constants.LOG_KEY_LINK_ID));
                    }
                    if (TextUtils.isEmpty(this.mLinkKey) && dataMap.containsKey(Constants.LOG_KEY_LINK_KEY)) {
                        this.mLinkKey = String.valueOf(dataMap.get(Constants.LOG_KEY_LINK_KEY));
                    }
                }
            }
            this.mHasInitLinkInfo = true;
        }
    }

    private void insertCustomInfoSection() {
        KVSection kVSection = new KVSection("custom_info");
        for (Map.Entry<String, String> entry : a.a().a().entrySet()) {
            kVSection.put(entry.getKey(), entry.getValue());
        }
        this.sectionList.add(0, kVSection);
    }

    public JSONSection createAndAddJSONSection(String str) {
        JSONSection jSONSection = new JSONSection(str);
        this.sectionList.add(jSONSection);
        return jSONSection;
    }

    public KVSection createAndAddKVSection(String str) {
        KVSection kVSection = new KVSection(str);
        this.sectionList.add(kVSection);
        return kVSection;
    }

    public TextSection createAndAddTextSection(String str) {
        TextSection textSection = new TextSection(str);
        this.sectionList.add(textSection);
        return textSection;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        String strChangeToStr = changeToStr();
        if (a.a().f1780g) {
            d.a("efs.base", strChangeToStr);
        }
        return strChangeToStr.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String generateString() {
        return changeToStr();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkId() {
        initLinkInfo();
        return this.mLinkID;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkKey() {
        initLinkInfo();
        return this.mLinkKey;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(b bVar) {
        insertCustomInfoSection();
        List<AbsSection> list = this.sectionList;
        String logType = getLogType();
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection kVSectionPut = kVSection.put("type", logType).put(ACTD.APPID_KEY, bVar.a.get(ACTD.APPID_KEY)).put("wid", bVar.a.get("wid")).put("pid", bVar.a.get("pid")).put("pkg", bVar.a.get("pkg")).put("ver", bVar.a.get("ver")).put("vcode", bVar.a.get("vcode")).put(Constants.KEYS.PLACEMENTS, bVar.a.get(Constants.KEYS.PLACEMENTS)).put("stime", bVar.a.get("stime"));
        com.efs.sdk.base.a.a.a.a();
        KVSection kVSectionPut2 = kVSectionPut.put("ctime", Long.valueOf(com.efs.sdk.base.a.a.a.b() / 1000));
        com.efs.sdk.base.a.a.a.a();
        kVSectionPut2.put("w_tm", Long.valueOf(com.efs.sdk.base.a.a.a.b() / 1000)).put("sdk_ver", bVar.a.get("sdk_ver"));
        String strValueOf = String.valueOf(bVar.b("uid", ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            kVSection.put("uid", strValueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put("lang", bVar.a.get("lang")).put("brand", bVar.a.get("brand")).put("model", bVar.a.get("model")).put("rom", bVar.a.get("rom")).put("sdk", bVar.a.get("sdk")).put("dsp_h", bVar.a.get("dsp_h")).put("dsp_w", bVar.a.get("dsp_w")).put("tzone", bVar.a.get("tzone")).put("net", bVar.a.get("net")).put("fr", bVar.a.get("fr"));
        arrayList.add(kVSection2);
        list.addAll(0, arrayList);
    }
}
