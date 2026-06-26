package com.bytedance.sdk.openadsdk.api.plugin;

/* JADX INFO: loaded from: classes.dex */
public class PluginConstants {
    public static final int EVENT_TYPE_PLUGIN_UPDATE = 1;
    public static final String KEY_APP_ID = "app_id";
    public static final String KEY_PLUGIN_VERSION = "plugin_version";
    public static final String KEY_PL_CONFIG_INFO = "_pl_config_info_";
    public static final String KEY_PL_UPDATE_LISTENER = "_pl_update_listener_";
    public static final String KEY_SDK_VERSION = "sdk_version";
    private static final String SIGN = "rRDDgej32asc5/FD2g6QQUSS5XkrdX+/FAdY1qz2yMHN5e5lkaQCV8E4NVrqLqnb0/4ogbNAuY8cdm5MbtZ0uhoOd4/BZu90JeI3+N6EEmp18xM8lNpKVBaUZFIg039m4YWNafniSYIaXxk3GvkYueXEjA1IYPxR19l79RWMYCluzLDz93qNw7lfdyXfmKCiT6cUNXuL1Zs/E6vmzrgaxahpYRTXzJfHJfLmRoqnelCdIN3ohpcFBKwszegXvHvL0SVgOmStGalYUmU0fPctS7pvX+Iqt68qCh2kGU5VVDmoNFrf2GxOipH/j3FGnrhVSPu+9bUkNV9rSW/mg5Gzmw==";
    public static final int STATUS_PLUGIN_LOAD_FAILED = 1001;
    public static final int STATUS_PLUGIN_LOAD_SUCCESS = 1000;

    public static final String getSign() {
        return SIGN;
    }
}
