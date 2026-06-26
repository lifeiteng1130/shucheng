package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes.dex */
public class ADActivity extends Activity {
    public ACTD a;

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ACTD actd = this.a;
        if (actd != null) {
            actd.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String string = null;
        try {
            POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
            if (pOFactory != null) {
                Intent intent = getIntent();
                intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    string = extras.getString(ACTD.DELEGATE_NAME_KEY);
                    String string2 = extras.getString(ACTD.APPID_KEY);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && GDTADManager.getInstance().isInitialized()) {
                        ACTD activityDelegate = pOFactory.getActivityDelegate(string, this);
                        this.a = activityDelegate;
                        if (activityDelegate == null) {
                            GDTLogger.e("创建 ADActivity Delegate " + string + " 失败");
                        }
                    }
                }
            }
        } catch (Throwable th) {
            GDTLogger.e("创建ADActivity Delegate" + string + "发生异常", th);
        }
        ACTD actd = this.a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            try {
                finish();
            } catch (Exception e2) {
                GDTLogger.e("ADActivity onCreate 发生异常", e2);
            }
        }
        try {
            super.onCreate(bundle);
        } catch (Exception e3) {
            GDTLogger.e("ADActivity onCreate 发生异常", e3);
        }
        ACTD actd2 = this.a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ACTD actd = this.a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ACTD actd = this.a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }
}
