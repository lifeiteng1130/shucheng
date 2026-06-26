package com.qq.e.comm.constants;

import com.qq.e.ads.ADActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.ads.RewardvideoLandscapeADActivity;
import com.qq.e.ads.RewardvideoPortraitADActivity;
import com.qq.e.comm.DownloadService;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
public class CustomPkgConstants {
    private static final String a = DownloadService.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2768b = ADActivity.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f2769c = PortraitADActivity.class.getName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f2770d = RewardvideoPortraitADActivity.class.getName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2771e = LandscapeADActivity.class.getName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2772f = RewardvideoLandscapeADActivity.class.getName();

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        return !StringUtil.isEmpty(customADActivityClassName) ? customADActivityClassName : f2768b;
    }

    public static String getAssetPluginDir() {
        return "gdt_plugin";
    }

    public static String getAssetPluginName() {
        return "gdtadv2.jar";
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return a;
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        return !StringUtil.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : f2771e;
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        return !StringUtil.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : f2769c;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        return !StringUtil.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : f2772f;
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        return !StringUtil.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : f2770d;
    }
}
