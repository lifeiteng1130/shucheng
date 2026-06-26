package com.tencent.bugly.beta.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.b;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class HotfixDialog extends BaseDialogFrag {
    public TextView mTipsTextView;

    @Override // com.tencent.bugly.beta.ui.BaseDialogFrag, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mLayoutResId = e.f3983b.m;
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mLayoutResId == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            TextView textView = new TextView(this.mContext);
            this.mTipsTextView = textView;
            textView.setLayoutParams(layoutParams);
            TextView textView2 = this.mTipsTextView;
            this.mRes.getClass();
            textView2.setTextColor(Color.parseColor("#757575"));
            this.mTipsTextView.setTextSize(16.0f);
            this.mTipsTextView.setTag(Beta.TAG_TIP_MESSAGE);
            this.mContentContainer.addView(this.mTipsTextView);
        } else if (viewOnCreateView != null) {
            this.mTipsTextView = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.mTipsTextView.setText("检测到当前版本需要重启，是否重启应用？");
            this.mTitleTextView.setText("更新提示");
            setBtn("取消", new b(8, this), "重启应用", new b(7, this));
        } catch (Exception e2) {
            if (this.mLayoutResId != 0) {
                X.b("please confirm your argument: [Beta.tipsDialogLayoutId] is correct", new Object[0]);
            }
            if (!X.a(e2)) {
                e2.printStackTrace();
            }
        }
        return viewOnCreateView;
    }

    @Override // com.tencent.bugly.beta.ui.BaseFrag
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }
}
