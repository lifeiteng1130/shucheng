package com.qq.e.comm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.qq.e.comm.managers.GDTADManager;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SystemUtil {
    public static String buildNewPathByProcessName(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        String processName = GDTADManager.getInstance().getProcessName();
        if (StringUtil.isEmpty(processName)) {
            return str;
        }
        boolean zEndsWith = processName.endsWith("_");
        StringBuilder sbR = c.a.a.a.a.r(str);
        sbR.append(zEndsWith ? "" : "_");
        sbR.append(Md5Util.encode(processName));
        return sbR.toString();
    }

    public static String getProcessName(Context context) {
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            try {
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == iMyPid) {
                    return next.processName;
                }
                continue;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
