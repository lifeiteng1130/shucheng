package com.bytedance.sdk.openadsdk.stub.activity;

import com.bytedance.pangle.activity.GenerateProxyActivity;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes.dex */
public class Stub_SingleTask_Activity extends GenerateProxyActivity {
    @Override // com.bytedance.pangle.activity.GenerateProxyActivity, c.c.a.c.b
    public String getPluginPkgName() {
        return TTAdConstant.BUILT_IN_PLUGIN_NAME;
    }
}
