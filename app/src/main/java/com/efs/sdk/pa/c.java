package com.efs.sdk.pa;

import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.file.EfsTextFile;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.efs.sdk.base.protocol.file.section.TextSection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static synchronized void a(PAFactory pAFactory, String str, String str2) {
        EfsTextFile efsTextFile = new EfsTextFile(str);
        KVSection kVSectionCreateAndAddKVSection = efsTextFile.createAndAddKVSection("custom_info");
        kVSectionCreateAndAddKVSection.put("bserial", pAFactory.getSerial());
        kVSectionCreateAndAddKVSection.put("bsver", pAFactory.getSver());
        HashMap<String, String> extend = pAFactory.getExtend();
        if (extend != null && !extend.isEmpty()) {
            for (Map.Entry<String, String> entry : extend.entrySet()) {
                kVSectionCreateAndAddKVSection.put(entry.getKey(), entry.getValue());
            }
        }
        kVSectionCreateAndAddKVSection.put("crver", "2.1.154.umeng");
        if (!TextUtils.isEmpty(str2)) {
            TextSection textSectionCreateAndAddTextSection = efsTextFile.createAndAddTextSection("stack");
            textSectionCreateAndAddTextSection.setBody(str2);
            textSectionCreateAndAddTextSection.setSep(AbsSection.SEP_LINE_BREAK);
        }
        EfsReporter reporter = pAFactory.getReporter();
        if (reporter != null) {
            reporter.send(efsTextFile);
        }
        pAFactory.getConfigManager().increaseUploadSmoothLogCnt();
        "reportPaWpkStats: stack: ".concat(String.valueOf(str2));
    }
}
