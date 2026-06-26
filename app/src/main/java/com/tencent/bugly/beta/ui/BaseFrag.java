package com.tencent.bugly.beta.ui;

import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseFrag extends Fragment {
    public boolean mIsShowing = false;

    public synchronized void close() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public synchronized boolean isShowing() {
        return this.mIsShowing;
    }

    public abstract boolean onKeyDown(int i2, KeyEvent keyEvent);

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        synchronized (this) {
            this.mIsShowing = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        synchronized (this) {
            this.mIsShowing = true;
        }
    }
}
