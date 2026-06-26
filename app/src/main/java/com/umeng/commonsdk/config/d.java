package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldTable.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final long a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5074b = "_LAST_FIELD";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5075c = "3758096383";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5076d = "2147483647";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5077e = "262143";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5078f = "2047";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5079g = 64;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String[] f5080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String[] f5081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String[] f5082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String[] f5083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Map<String, String[]> f5084l = new HashMap();

    /* JADX INFO: compiled from: FieldTable.java */
    public enum a {
        header_utoken,
        header_cpu,
        header_mccmnc,
        header_sub_os_name,
        header_sub_os_version,
        header_device_type,
        header_device_id_imei,
        header_device_id_mac,
        header_device_id_android_id,
        header_device_id_serialNo,
        header_bulid,
        header_os_version,
        header_resolution,
        header_mc,
        header_timezone,
        header_local_info,
        header_carrier,
        header_access,
        header_tracking_imei,
        header_tracking_android_id,
        header_tracking_utdid,
        header_tracking_idmd5,
        header_tracking_idfa,
        header_tracking_mac,
        header_tracking_serial,
        header_tracking_uuid,
        header_tracking_uop,
        header_tracking_oldumid,
        header_tracking_newumid,
        header_ekv_send_on_exit,
        header_device_oaid,
        header_local_ip,
        header_foreground_count,
        header_first_resume,
        _LAST_FIELD
    }

    /* JADX INFO: compiled from: FieldTable.java */
    public enum b {
        inner_rs,
        inner_by,
        inner_gp,
        inner_to,
        inner_mo,
        inner_ca,
        inner_fl,
        inner_gdf_r,
        inner_thm_z,
        inner_dsk_s,
        inner_sd,
        inner_build,
        inner_sr,
        inner_scr,
        inner_sinfo,
        inner_winfo,
        inner_input,
        inner_bt,
        inner_mem,
        inner_cpu,
        inner_rom,
        inner_bstn,
        inner_cam,
        inner_appls,
        inner_lbs,
        internal_run_server,
        internal_imsi,
        internal_meid,
        tp_tp,
        inner_imei2,
        inner_iccid,
        _LAST_FIELD
    }

    /* JADX INFO: compiled from: FieldTable.java */
    public enum c {
        push_cpu,
        push_imei,
        push_mac,
        push_android_id,
        push_serialNo,
        push_settings_android_id,
        push_network_access_mode,
        push_on_line,
        push_time_zone,
        push_locale_info,
        push_resolution,
        push_operator,
        push_utdid,
        push_service_work,
        push_service_name,
        push_intent_exist,
        push_data_data,
        push_notification_enabled,
        _LAST_FIELD
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.config.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FieldTable.java */
    public enum EnumC0130d {
        share_device_id,
        share_imsi,
        share_iccid,
        share_sn,
        share_net_accmode,
        share_android_id,
        share_wifi_mac,
        share_sd_size,
        share_ssid,
        share_resolution,
        share_conn_type,
        _LAST_FIELD
    }

    static {
        a.values();
        f5080h = new String[35];
        b.values();
        f5081i = new String[32];
        c.values();
        f5082j = new String[19];
        EnumC0130d.values();
        f5083k = new String[12];
        String[] strArr = f5080h;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                a.values();
                if (i3 >= 35) {
                    break;
                }
                f5080h[i3] = a.values()[i3].toString();
                i3++;
            }
            Map<String, String[]> map = f5084l;
            if (map != null) {
                map.put(a.class.getName(), f5080h);
            }
        }
        String[] strArr2 = f5081i;
        if (strArr2 != null && strArr2.length > 0) {
            int i4 = 0;
            while (true) {
                b.values();
                if (i4 >= 32) {
                    break;
                }
                f5081i[i4] = b.values()[i4].toString();
                i4++;
            }
            Map<String, String[]> map2 = f5084l;
            if (map2 != null) {
                map2.put(b.class.getName(), f5081i);
            }
        }
        String[] strArr3 = f5082j;
        if (strArr3 != null && strArr3.length > 0) {
            int i5 = 0;
            while (true) {
                c.values();
                if (i5 >= 19) {
                    break;
                }
                f5082j[i5] = c.values()[i5].toString();
                i5++;
            }
            Map<String, String[]> map3 = f5084l;
            if (map3 != null) {
                map3.put(c.class.getName(), f5082j);
            }
        }
        String[] strArr4 = f5083k;
        if (strArr4 == null || strArr4.length <= 0) {
            return;
        }
        while (true) {
            EnumC0130d.values();
            if (i2 >= 12) {
                break;
            }
            f5083k[i2] = EnumC0130d.values()[i2].toString();
            i2++;
        }
        Map<String, String[]> map4 = f5084l;
        if (map4 != null) {
            map4.put(EnumC0130d.class.getName(), f5083k);
        }
    }

    public static boolean a(String str) {
        return (str == null || str.length() <= 0 || f5074b.equalsIgnoreCase(str)) ? false : true;
    }

    public static String[] b(String str) {
        if (str == null || str.length() <= 0 || !f5084l.containsKey(str)) {
            return null;
        }
        return f5084l.get(str);
    }
}
