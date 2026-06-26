package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.c;
import com.tencent.bugly.beta.utils.e;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDialogFrag extends BaseFrag {
    public ImageView mBannerImageView;
    public LinearLayout mContentContainer;
    public Context mContext;
    public LinearLayout mCustomLayout;
    public FrameLayout mFrameLayout;
    public View mLayoutContainer;
    public int mLayoutResId;
    public TextView mLeftBtnTextView;
    public ResBean mRes;
    public TextView mRightBtnTextView;
    public int mStyle;
    public TextView mTitleTextView;

    @Override // com.tencent.bugly.beta.ui.BaseFrag
    public void close() {
        if (this.mLayoutContainer == null) {
            super.close();
            return;
        }
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        e.a(new Runnable() { // from class: com.tencent.bugly.beta.ui.BaseDialogFrag.2
            @Override // java.lang.Runnable
            public void run() {
                View view = BaseDialogFrag.this.mLayoutContainer;
                if (view != null) {
                    view.startAnimation(alphaAnimation);
                }
            }
        });
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.bugly.beta.ui.BaseDialogFrag.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view = BaseDialogFrag.this.mLayoutContainer;
                if (view != null) {
                    view.setVisibility(8);
                }
                BaseDialogFrag.super.close();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mContext = getActivity();
        this.mRes = ResBean.a;
        int i2 = this.mLayoutResId;
        if (i2 == 0) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            this.mLayoutContainer = relativeLayout;
            relativeLayout.setGravity(17);
            this.mLayoutContainer.setBackgroundColor(Color.argb(100, 0, 0, 0));
            this.mFrameLayout = new FrameLayout(this.mContext);
            this.mFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            this.mCustomLayout = linearLayout;
            linearLayout.setBackgroundColor(-1);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.mCustomLayout.setGravity(17);
            this.mCustomLayout.setLayoutParams(layoutParams);
            this.mCustomLayout.setMinimumWidth(a.a(this.mContext, 280.0f));
            this.mCustomLayout.setOrientation(1);
            if (this.mStyle == 2) {
                float fA = a.a(this.mContext, 6.0f);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
                shapeDrawable.getPaint().setColor(-1);
                shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                this.mCustomLayout.setBackgroundDrawable(shapeDrawable);
            }
            TextView textView = new TextView(this.mContext);
            this.mTitleTextView = textView;
            textView.setGravity(16);
            this.mTitleTextView.setSingleLine();
            TextView textView2 = this.mTitleTextView;
            this.mRes.getClass();
            textView2.setTextColor(Color.parseColor("#273238"));
            this.mTitleTextView.setTextSize(18.0f);
            this.mTitleTextView.setLayoutParams(layoutParams);
            this.mTitleTextView.setOnClickListener(null);
            this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
            int iA = a.a(this.mContext, 16.0f);
            this.mTitleTextView.setPadding(iA, 0, iA, 0);
            this.mTitleTextView.setTypeface(null, 1);
            this.mTitleTextView.setHeight(a.a(this.mContext, 42.0f));
            this.mTitleTextView.setTag(Beta.TAG_TITLE);
            TextView textView3 = new TextView(this.mContext);
            textView3.setBackgroundColor(-3355444);
            textView3.setHeight(1);
            ScrollView scrollView = new ScrollView(this.mContext);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, 0, 0, a.a(this.mContext, 52.0f));
            scrollView.setLayoutParams(layoutParams2);
            scrollView.setFillViewport(true);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            this.mContentContainer = new LinearLayout(this.mContext);
            this.mContentContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.mContentContainer.setOrientation(1);
            this.mContentContainer.setPadding(iA, a.a(this.mContext, 10.0f), iA, 0);
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setGravity(17);
            linearLayout2.setOrientation(0);
            int i3 = iA / 2;
            linearLayout2.setPadding(i3, iA, i3, iA);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            linearLayout2.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams4.setMargins(i3, 0, i3, 0);
            TextView textView4 = new TextView(this.mContext);
            this.mLeftBtnTextView = textView4;
            textView4.setSingleLine();
            this.mLeftBtnTextView.setGravity(17);
            this.mLeftBtnTextView.setTag(Beta.TAG_CANCEL_BUTTON);
            new RelativeLayout.LayoutParams(-2, -2);
            int iA2 = a.a(this.mContext, 30.0f);
            if (this.mStyle == 2) {
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iA2, iA2);
                layoutParams5.gravity = 53;
                this.mLeftBtnTextView.setLayoutParams(layoutParams5);
                this.mLeftBtnTextView.setTextSize((float) (((double) iA2) * 0.3d));
            } else {
                this.mLeftBtnTextView.setLayoutParams(layoutParams4);
                this.mLeftBtnTextView.setTextSize(16);
                TextView textView5 = this.mLeftBtnTextView;
                this.mRes.getClass();
                textView5.setTextColor(Color.parseColor("#757575"));
                this.mLeftBtnTextView.setPadding(a.a(this.mContext, 10.0f), a.a(this.mContext, 5.0f), a.a(this.mContext, 10.0f), a.a(this.mContext, 5.0f));
            }
            TextView textView6 = new TextView(this.mContext);
            this.mRightBtnTextView = textView6;
            textView6.setLayoutParams(layoutParams4);
            this.mRightBtnTextView.setGravity(17);
            this.mRightBtnTextView.setTextSize(16);
            TextView textView7 = this.mRightBtnTextView;
            this.mRes.getClass();
            textView7.setTextColor(Color.parseColor("#273238"));
            this.mRightBtnTextView.setSingleLine();
            this.mRightBtnTextView.setPadding(a.a(this.mContext, 10.0f), a.a(this.mContext, 5.0f), a.a(this.mContext, 10.0f), a.a(this.mContext, 5.0f));
            this.mRightBtnTextView.setTypeface(null, 1);
            this.mRightBtnTextView.setTag(Beta.TAG_CONFIRM_BUTTON);
            int iA3 = a.a(this.mContext, 40.0f);
            scrollView.addView(this.mContentContainer);
            if (this.mStyle == 2) {
                FrameLayout frameLayout = new FrameLayout(this.mContext);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                int i4 = iA2 / 2;
                int i5 = i4 - 5;
                this.mFrameLayout.setPadding(i4, i5, i5, i4);
                frameLayout.addView(this.mFrameLayout);
                frameLayout.addView(this.mLeftBtnTextView);
                ((RelativeLayout) this.mLayoutContainer).addView(frameLayout);
            } else {
                this.mLayoutContainer.setPadding(iA3, iA3, iA3, iA3);
                ((RelativeLayout) this.mLayoutContainer).addView(this.mFrameLayout);
                linearLayout2.addView(this.mLeftBtnTextView);
            }
            this.mCustomLayout.addView(this.mTitleTextView);
            this.mCustomLayout.addView(textView3);
            this.mCustomLayout.addView(scrollView);
            this.mFrameLayout.addView(this.mCustomLayout);
            linearLayout2.addView(this.mRightBtnTextView);
            this.mFrameLayout.addView(linearLayout2);
            if (this.mStyle == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA2, iA2, Bitmap.Config.ARGB_8888);
                int i6 = iA2 / 2;
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                paint.setColor(-3355444);
                float f2 = i6;
                canvas.drawCircle(f2, f2, f2, paint);
                canvas.rotate(45.0f, f2, f2);
                paint.setColor(-7829368);
                int iA4 = a.a(this.mContext, 0.8f);
                float f3 = f2 * 0.4f;
                float f4 = i6 - iA4;
                float f5 = f2 * 1.6f;
                float f6 = i6 + iA4;
                canvas.drawRect(f3, f4, f5, f6, paint);
                canvas.drawRect(f4, f3, f6, f5, paint);
                canvas.rotate(-45.0f);
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iA2, iA2, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                paint.setColor(-7829368);
                canvas2.drawCircle(f2, f2, f2, paint);
                canvas2.rotate(45.0f, f2, f2);
                paint.setColor(-3355444);
                canvas2.drawRect(f3, f4, f5, f6, paint);
                canvas2.drawRect(f4, f3, f6, f5, paint);
                canvas2.rotate(-45.0f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap2);
                this.mLeftBtnTextView.setBackgroundDrawable(bitmapDrawable);
                this.mLeftBtnTextView.setOnTouchListener(new c(1, bitmapDrawable2, bitmapDrawable));
            }
            this.mLayoutContainer.setOnClickListener(null);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            this.mLayoutContainer.startAnimation(alphaAnimation);
        } else {
            View viewInflate = layoutInflater.inflate(i2, (ViewGroup) null);
            this.mLayoutContainer = viewInflate;
            this.mBannerImageView = (ImageView) viewInflate.findViewWithTag(Beta.TAG_IMG_BANNER);
            this.mTitleTextView = (TextView) this.mLayoutContainer.findViewWithTag(Beta.TAG_TITLE);
            this.mLeftBtnTextView = (TextView) this.mLayoutContainer.findViewWithTag(Beta.TAG_CANCEL_BUTTON);
            this.mRightBtnTextView = (TextView) this.mLayoutContainer.findViewWithTag(Beta.TAG_CONFIRM_BUTTON);
        }
        this.mLeftBtnTextView.setVisibility(8);
        this.mRightBtnTextView.setVisibility(8);
        this.mLeftBtnTextView.setFocusable(true);
        this.mRightBtnTextView.setFocusable(true);
        this.mRightBtnTextView.requestFocus();
        return this.mLayoutContainer;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mContext = null;
        this.mLayoutContainer = null;
        this.mFrameLayout = null;
        this.mCustomLayout = null;
        this.mTitleTextView = null;
        this.mBannerImageView = null;
        this.mLeftBtnTextView = null;
        this.mRightBtnTextView = null;
        this.mContentContainer = null;
    }

    public void setBtn(final String str, final View.OnClickListener onClickListener, final String str2, final View.OnClickListener onClickListener2) {
        e.a(new Runnable() { // from class: com.tencent.bugly.beta.ui.BaseDialogFrag.1
            @Override // java.lang.Runnable
            public void run() {
                BaseDialogFrag baseDialogFrag = BaseDialogFrag.this;
                TextView textView = baseDialogFrag.mLeftBtnTextView;
                if (textView == null || baseDialogFrag.mRightBtnTextView == null) {
                    return;
                }
                if (str != null) {
                    textView.setVisibility(0);
                    BaseDialogFrag baseDialogFrag2 = BaseDialogFrag.this;
                    if (baseDialogFrag2.mStyle != 2) {
                        baseDialogFrag2.mLeftBtnTextView.setText(str);
                        BaseDialogFrag baseDialogFrag3 = BaseDialogFrag.this;
                        if (baseDialogFrag3.mLayoutResId == 0) {
                            baseDialogFrag3.mLeftBtnTextView.getViewTreeObserver().addOnPreDrawListener(new BetaOnPreDraw(2, Integer.valueOf(BaseDialogFrag.this.mStyle), BaseDialogFrag.this.mLeftBtnTextView, 1));
                        }
                    }
                    BaseDialogFrag.this.mLeftBtnTextView.setOnClickListener(onClickListener);
                }
                if (str2 != null) {
                    BaseDialogFrag.this.mRightBtnTextView.setVisibility(0);
                    BaseDialogFrag.this.mRightBtnTextView.setText(str2);
                    BaseDialogFrag.this.mRightBtnTextView.setOnClickListener(onClickListener2);
                    BaseDialogFrag baseDialogFrag4 = BaseDialogFrag.this;
                    if (baseDialogFrag4.mLayoutResId == 0) {
                        baseDialogFrag4.mRightBtnTextView.getViewTreeObserver().addOnPreDrawListener(new BetaOnPreDraw(2, Integer.valueOf(BaseDialogFrag.this.mStyle), BaseDialogFrag.this.mRightBtnTextView, 1));
                    }
                    BaseDialogFrag.this.mRightBtnTextView.requestFocus();
                }
            }
        });
    }
}
