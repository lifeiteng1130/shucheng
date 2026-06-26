package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

/* JADX INFO: loaded from: classes.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TTDislikeController f1666b;

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public void a() {
        if (this.f1666b == null || this.a == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
            throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
        }
        for (int i2 : tTDislikeListViewIds) {
            View viewFindViewById = this.a.findViewById(i2);
            if (viewFindViewById == null) {
                throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
            }
            if (!(viewFindViewById instanceof TTDislikeListView)) {
                throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
            }
            ((TTDislikeListView) viewFindViewById).setDislikeInfo(this.f1666b);
        }
    }

    public void b() {
        TTDislikeController tTDislikeController = this.f1666b;
        if (tTDislikeController != null) {
            tTDislikeController.onDislikeEvent(getContext(), true);
        }
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        this.a = viewInflate;
        if (viewInflate == null) {
            throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        View view = this.a;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        setContentView(view, layoutParams);
        a();
    }

    public void setDislikeModel(TTDislikeController tTDislikeController) {
        this.f1666b = tTDislikeController;
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    public void startPersonalizePromptActivity() {
        TTDislikeController tTDislikeController = this.f1666b;
        if (tTDislikeController != null) {
            tTDislikeController.openWebPage(getContext(), true);
            this.f1666b.onDislikeEvent(getContext(), false);
        }
    }

    public TTDislikeDialogAbstract(Context context, int i2) {
        super(context, i2);
    }
}
