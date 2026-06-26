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
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.b;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class NetNotifyDialog extends BaseDialogFrag {
    public TextView mTipsTextView;
    public DownloadTask task;

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
            this.mTipsTextView.setText(Beta.strNetworkTipsMessage);
            this.mTitleTextView.setText(Beta.strNetworkTipsTitle);
            setBtn(Beta.strNetworkTipsCancelBtn, new b(2, this), Beta.strNetworkTipsConfirmBtn, new b(3, this, this.task));
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

    @Override // com.tencent.bugly.beta.ui.BaseDialogFrag, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mTipsTextView = null;
    }

    @Override // com.tencent.bugly.beta.ui.BaseFrag
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }
}
