package com.king.zxing;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import c.b.a.m.f;
import c.e.c.p;
import c.g.a.k;
import c.g.a.n;
import c.g.a.p.a;
import com.king.zxing.CaptureActivity;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes.dex */
public class CaptureActivity extends AppCompatActivity implements k.a {
    public PreviewView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f2616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f2617c;

    public boolean K0() {
        return true;
    }

    public void L0() {
        if (this.f2617c != null) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
                ((n) this.f2617c).f();
            } else {
                a.a();
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, Token.EXPR_VOID);
            }
        }
    }

    @Override // c.g.a.k.a
    public boolean b0(p pVar) {
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int i2 = R$layout.zxl_capture;
        if (K0()) {
            setContentView(i2);
        }
        this.a = (PreviewView) findViewById(R$id.previewView);
        int i3 = R$id.viewfinderView;
        if (i3 != 0) {
        }
        int i4 = R$id.ivFlashlight;
        if (i4 != 0) {
            View viewFindViewById = findViewById(i4);
            this.f2616b = viewFindViewById;
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: c.g.a.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CaptureActivity captureActivity = this.a;
                        k kVar = captureActivity.f2617c;
                        if (kVar != null) {
                            boolean z = !((n) kVar).c();
                            ((n) captureActivity.f2617c).a(z);
                            View view2 = captureActivity.f2616b;
                            if (view2 != null) {
                                view2.setSelected(z);
                            }
                        }
                    }
                });
            }
        }
        n nVar = new n(this, this.a);
        this.f2617c = nVar;
        nVar.f1589l = this;
        L0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        k kVar = this.f2617c;
        if (kVar != null) {
            ((n) kVar).d();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 134) {
            if (f.K4("android.permission.CAMERA", strArr, iArr)) {
                L0();
            } else {
                finish();
            }
        }
    }
}
