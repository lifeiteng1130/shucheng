package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.download.a;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.b;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.X;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class UpgradeDialog extends BaseDialogFrag {
    public static UpgradeDialog instance = new UpgradeDialog();
    public Runnable cancelRunnable;
    public B strategyDetail;
    public DownloadTask strategyTask;
    public BitmapDrawable titleDrawable;
    public TextView tvApkInfoTop;
    public TextView tvUpgradeInfoBottom;
    public UILifecycleListener upgradeDialogListener;
    public Runnable upgradeRunnable;
    private BetaOnPreDraw onPreDraw = null;
    public Bitmap titleBitmap = null;
    public View.OnClickListener installTaskListener = new b(9, this);
    public View.OnClickListener startTaskListener = new b(4, this);
    public View.OnClickListener stopTaskListener = new b(5, this);
    public View.OnClickListener negListener = new b(6, this);
    public DownloadListener taskListener = new a(2, this);

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e eVar = e.f3983b;
        this.mLayoutResId = eVar.f3993l;
        this.upgradeDialogListener = eVar.n;
        try {
            this.mStyle = Integer.parseInt(ResBean.a.a("VAL_style"));
        } catch (Exception e2) {
            X.c(e2.getMessage(), new Object[0]);
            this.mStyle = 0;
        }
    }

    @Override // com.tencent.bugly.beta.ui.BaseDialogFrag, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mLayoutResId != 0) {
            this.tvApkInfoTop = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_UPGRADE_INFO);
            this.tvUpgradeInfoBottom = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_UPGRADE_FEATURE);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            ResBean resBean = ResBean.a;
            if (e.f3983b.W) {
                TextView textView = new TextView(this.mContext);
                this.tvApkInfoTop = textView;
                textView.setLayoutParams(layoutParams2);
                TextView textView2 = this.tvApkInfoTop;
                resBean.getClass();
                textView2.setTextColor(Color.parseColor("#757575"));
                this.tvApkInfoTop.setTextSize(14);
                this.tvApkInfoTop.setTag(Beta.TAG_UPGRADE_INFO);
                this.tvApkInfoTop.setLineSpacing(15.0f, 1.0f);
                linearLayout.addView(this.tvApkInfoTop);
            }
            TextView textView3 = new TextView(this.mContext);
            textView3.setLayoutParams(layoutParams2);
            resBean.getClass();
            textView3.setTextColor(Color.parseColor("#273238"));
            float f2 = 14;
            textView3.setTextSize(f2);
            textView3.setSingleLine();
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            textView3.setText(String.valueOf(Beta.strUpgradeDialogFeatureLabel + ": "));
            textView3.setPadding(0, com.tencent.bugly.beta.global.a.a(this.mContext, 8.0f), 0, 0);
            linearLayout.addView(textView3);
            TextView textView4 = new TextView(this.mContext);
            this.tvUpgradeInfoBottom = textView4;
            textView4.setLayoutParams(layoutParams2);
            this.tvUpgradeInfoBottom.setTextColor(Color.parseColor("#273238"));
            this.tvUpgradeInfoBottom.setTextSize(f2);
            this.tvUpgradeInfoBottom.setTag(Beta.TAG_UPGRADE_FEATURE);
            this.tvUpgradeInfoBottom.setMaxHeight(com.tencent.bugly.beta.global.a.a(this.mContext, 200.0f));
            this.tvUpgradeInfoBottom.setLineSpacing(15.0f, 1.0f);
            linearLayout.addView(this.tvUpgradeInfoBottom);
            this.mContentContainer.addView(linearLayout);
        }
        UILifecycleListener uILifecycleListener = this.upgradeDialogListener;
        if (uILifecycleListener != null) {
            FragmentActivity activity = getActivity();
            B b2 = this.strategyDetail;
            uILifecycleListener.onCreate(activity, viewOnCreateView, b2 != null ? new UpgradeInfo(b2) : null);
        }
        return viewOnCreateView;
    }

    @Override // com.tencent.bugly.beta.ui.BaseDialogFrag, androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
            this.tvApkInfoTop = null;
            this.tvUpgradeInfoBottom = null;
            synchronized (this) {
                this.onPreDraw = null;
            }
            BitmapDrawable bitmapDrawable = this.titleDrawable;
            if (bitmapDrawable != null) {
                bitmapDrawable.setCallback(null);
            }
            UILifecycleListener uILifecycleListener = this.upgradeDialogListener;
            if (uILifecycleListener != null) {
                Context context = this.mContext;
                View view = this.mLayoutContainer;
                B b2 = this.strategyDetail;
                uILifecycleListener.onDestroy(context, view, b2 != null ? new UpgradeInfo(b2) : null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.bugly.beta.ui.BaseFrag
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        if (this.strategyDetail.f4254l == 2) {
            return true;
        }
        Runnable runnable = this.cancelRunnable;
        if (runnable != null) {
            runnable.run();
        }
        close();
        return true;
    }

    @Override // com.tencent.bugly.beta.ui.BaseFrag, androidx.fragment.app.Fragment
    public void onPause() {
        DownloadTask downloadTask;
        super.onPause();
        DownloadListener downloadListener = this.taskListener;
        if (downloadListener != null && (downloadTask = this.strategyTask) != null) {
            downloadTask.removeListener(downloadListener);
        }
        UILifecycleListener uILifecycleListener = this.upgradeDialogListener;
        if (uILifecycleListener != null) {
            Context context = this.mContext;
            View view = this.mLayoutContainer;
            B b2 = this.strategyDetail;
            uILifecycleListener.onPause(context, view, b2 != null ? new UpgradeInfo(b2) : null);
        }
    }

    @Override // com.tencent.bugly.beta.ui.BaseFrag, androidx.fragment.app.Fragment
    public void onResume() {
        DownloadTask downloadTask;
        super.onResume();
        DownloadListener downloadListener = this.taskListener;
        if (downloadListener != null && (downloadTask = this.strategyTask) != null) {
            downloadTask.addListener(downloadListener);
        }
        updateView();
        if (this.mStyle != 0 && this.titleBitmap == null) {
            f.a.a(new d(7, this));
        }
        UILifecycleListener uILifecycleListener = this.upgradeDialogListener;
        if (uILifecycleListener != null) {
            Context context = this.mContext;
            View view = this.mLayoutContainer;
            B b2 = this.strategyDetail;
            uILifecycleListener.onResume(context, view, b2 != null ? new UpgradeInfo(b2) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        UILifecycleListener uILifecycleListener = this.upgradeDialogListener;
        if (uILifecycleListener != null) {
            Context context = this.mContext;
            View view = this.mLayoutContainer;
            B b2 = this.strategyDetail;
            uILifecycleListener.onStart(context, view, b2 != null ? new UpgradeInfo(b2) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        UILifecycleListener uILifecycleListener = this.upgradeDialogListener;
        if (uILifecycleListener != null) {
            Context context = this.mContext;
            View view = this.mLayoutContainer;
            B b2 = this.strategyDetail;
            uILifecycleListener.onStop(context, view, b2 != null ? new UpgradeInfo(b2) : null);
        }
    }

    public synchronized void setUpgradeInfo(B b2, DownloadTask downloadTask) {
        this.strategyDetail = b2;
        this.strategyTask = downloadTask;
        downloadTask.addListener(this.taskListener);
        com.tencent.bugly.beta.utils.e.a(new d(7, this));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateBtn(com.tencent.bugly.beta.download.DownloadTask r8) {
        /*
            r7 = this;
            int r0 = r8.getStatus()
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L58
            r3 = 1
            if (r0 == r3) goto L53
            if (r0 == r1) goto L24
            r8 = 3
            if (r0 == r8) goto L1f
            r8 = 4
            if (r0 == r8) goto L58
            r8 = 5
            if (r0 == r8) goto L1a
            java.lang.String r8 = ""
            r0 = r2
            goto L5c
        L1a:
            java.lang.String r8 = com.tencent.bugly.beta.Beta.strUpgradeDialogRetryBtn
            android.view.View$OnClickListener r0 = r7.startTaskListener
            goto L5c
        L1f:
            java.lang.String r8 = com.tencent.bugly.beta.Beta.strUpgradeDialogContinueBtn
            android.view.View$OnClickListener r0 = r7.startTaskListener
            goto L5c
        L24:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            long r4 = r8.getSavedLength()
            float r4 = (float) r4
            long r5 = r8.getTotalLength()
            float r8 = (float) r5
            float r4 = r4 / r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 * r8
            java.lang.Float r8 = java.lang.Float.valueOf(r4)
            r4 = 0
            r3[r4] = r8
            java.lang.String r8 = "%.1f%%"
            java.lang.String r8 = java.lang.String.format(r0, r8, r3)
            java.lang.String r0 = "NaN%"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L50
            java.lang.String r8 = "0%"
        L50:
            android.view.View$OnClickListener r0 = r7.stopTaskListener
            goto L5c
        L53:
            java.lang.String r8 = com.tencent.bugly.beta.Beta.strUpgradeDialogInstallBtn
            android.view.View$OnClickListener r0 = r7.installTaskListener
            goto L5c
        L58:
            java.lang.String r8 = com.tencent.bugly.beta.Beta.strUpgradeDialogUpgradeBtn
            android.view.View$OnClickListener r0 = r7.startTaskListener
        L5c:
            com.tencent.bugly.proguard.B r3 = r7.strategyDetail
            byte r3 = r3.f4254l
            if (r3 == r1) goto L6a
            java.lang.String r1 = com.tencent.bugly.beta.Beta.strUpgradeDialogCancelBtn
            android.view.View$OnClickListener r2 = r7.negListener
            r7.setBtn(r1, r2, r8, r0)
            goto L6d
        L6a:
            r7.setBtn(r2, r2, r8, r0)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.UpgradeDialog.updateBtn(com.tencent.bugly.beta.download.DownloadTask):void");
    }

    public synchronized void updateView() {
        B b2;
        try {
        } catch (Exception e2) {
            if (this.mLayoutResId != 0) {
                X.b("please confirm your argument: [Beta.upgradeDialogLayoutId] is correct", new Object[0]);
            }
            if (!X.a(e2)) {
                e2.printStackTrace();
            }
        }
        if (this.mLayoutContainer != null && (b2 = this.strategyDetail) != null && this.strategyTask != null) {
            Bitmap bitmapA = null;
            if (this.mLayoutResId != 0) {
                this.mTitleTextView.setText(b2.f4248f);
                ImageView imageView = this.mBannerImageView;
                if (imageView != null) {
                    imageView.setAdjustViewBounds(true);
                    if (this.mStyle != 0) {
                        Context context = this.mContext;
                        Object[] objArr = new Object[1];
                        objArr[0] = this.mRes.a("IMG_title");
                        Bitmap bitmapA2 = com.tencent.bugly.beta.global.a.a(context, 0, objArr);
                        this.titleBitmap = bitmapA2;
                        this.titleDrawable = null;
                        if (bitmapA2 != null) {
                            bitmapA = bitmapA2;
                        } else {
                            int i2 = e.f3983b.f3992k;
                            if (i2 != 0) {
                                bitmapA = com.tencent.bugly.beta.global.a.a(this.mContext, 1, Integer.valueOf(i2));
                            }
                        }
                        this.mBannerImageView.setImageBitmap(bitmapA);
                    }
                }
            } else if (this.mStyle != 0) {
                Context context2 = this.mContext;
                Object[] objArr2 = new Object[1];
                objArr2[0] = this.mRes.a("IMG_title");
                Bitmap bitmapA3 = com.tencent.bugly.beta.global.a.a(context2, 0, objArr2);
                this.titleBitmap = bitmapA3;
                this.titleDrawable = null;
                if (bitmapA3 != null) {
                    bitmapA = bitmapA3;
                } else {
                    int i3 = e.f3983b.f3992k;
                    if (i3 != 0) {
                        bitmapA = com.tencent.bugly.beta.global.a.a(this.mContext, 1, Integer.valueOf(i3));
                    }
                }
                this.mTitleTextView.getViewTreeObserver().removeOnPreDrawListener(this.onPreDraw);
                this.onPreDraw = new BetaOnPreDraw(1, this, this.mTitleTextView, bitmapA, Integer.valueOf(this.mStyle));
                this.mTitleTextView.getViewTreeObserver().addOnPreDrawListener(this.onPreDraw);
            } else {
                this.mTitleTextView.setHeight(com.tencent.bugly.beta.global.a.a(this.mContext, 42.0f));
                this.mTitleTextView.setText(this.strategyDetail.f4248f);
            }
            this.tvUpgradeInfoBottom.setText(this.strategyDetail.f4249g.length() > 500 ? this.strategyDetail.f4249g.substring(0, 500) : this.strategyDetail.f4249g);
            if (e.f3983b.W) {
                StringBuilder sb = new StringBuilder();
                sb.append(Beta.strUpgradeDialogVersionLabel);
                sb.append(": ");
                sb.append(this.strategyDetail.f4252j.f4475e);
                sb.append("\n");
                sb.append(Beta.strUpgradeDialogFileSizeLabel);
                sb.append(": ");
                float f2 = this.strategyDetail.f4253k.f4470e;
                if (f2 >= 1048576.0f) {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2 / 1048576.0f)));
                    sb.append("M");
                } else if (f2 >= 1024.0f) {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2 / 1024.0f)));
                    sb.append("K");
                } else {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2)));
                    sb.append("B");
                }
                sb.append("\n");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
                sb.append(Beta.strUpgradeDialogUpdateTimeLabel);
                sb.append(": ");
                sb.append(simpleDateFormat.format(new Date(this.strategyDetail.t)));
                this.tvApkInfoTop.setText(sb);
            }
            updateBtn(this.strategyTask);
        }
    }
}
