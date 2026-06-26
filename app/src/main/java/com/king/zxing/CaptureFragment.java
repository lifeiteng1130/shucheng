package com.king.zxing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import c.b.a.m.f;
import c.e.c.p;
import c.g.a.k;
import c.g.a.n;
import c.g.a.p.a;
import com.king.zxing.CaptureFragment;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes.dex */
public class CaptureFragment extends Fragment implements k.a {
    public View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PreviewView f2618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f2619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f2620d;

    public boolean N() {
        return true;
    }

    public void O() {
        if (this.f2620d != null) {
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") == 0) {
                ((n) this.f2620d).f();
            } else {
                a.a();
                requestPermissions(new String[]{"android.permission.CAMERA"}, Token.EXPR_VOID);
            }
        }
    }

    @Override // c.g.a.k.a
    public boolean b0(p pVar) {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = R$layout.zxl_capture;
        if (N()) {
            this.a = layoutInflater.inflate(i2, viewGroup, false);
        }
        this.f2618b = (PreviewView) this.a.findViewById(R$id.previewView);
        int i3 = R$id.viewfinderView;
        if (i3 != 0) {
        }
        int i4 = R$id.ivFlashlight;
        if (i4 != 0) {
            View viewFindViewById = this.a.findViewById(i4);
            this.f2619c = viewFindViewById;
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: c.g.a.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CaptureFragment captureFragment = this.a;
                        k kVar = captureFragment.f2620d;
                        if (kVar != null) {
                            boolean z = !((n) kVar).c();
                            ((n) captureFragment.f2620d).a(z);
                            View view2 = captureFragment.f2619c;
                            if (view2 != null) {
                                view2.setSelected(z);
                            }
                        }
                    }
                });
            }
        }
        n nVar = new n(this, this.f2618b);
        this.f2620d = nVar;
        nVar.f1589l = this;
        O();
        return this.a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        k kVar = this.f2620d;
        if (kVar != null) {
            ((n) kVar).d();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 134) {
            if (f.K4("android.permission.CAMERA", strArr, iArr)) {
                O();
            } else {
                getActivity().finish();
            }
        }
    }
}
