package io.legado.app.ui.qrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import c.e.c.e;
import c.e.c.p;
import c.g.a.k;
import c.g.a.m;
import e.a.a.h.z;
import f.c0.c.j;
import io.legado.app.base.BaseActivity;
import io.legado.app.databinding.ActivityQrcodeCaptureBinding;
import io.legado.app.ui.qrcode.QrCodeActivity;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: QrCodeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lio/legado/app/ui/qrcode/QrCodeActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityQrcodeCaptureBinding;", "Lc/g/a/k$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "Lc/e/c/p;", "result", "b0", "(Lc/e/c/p;)Z", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "h", "Landroidx/activity/result/ActivityResultLauncher;", "selectQrImage", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class QrCodeActivity extends BaseActivity<ActivityQrcodeCaptureBinding> implements k.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7466g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> selectQrImage;

    public QrCodeActivity() {
        super(false, null, null, false, false, 31);
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: e.a.a.g.i.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                p pVarC;
                QrCodeActivity qrCodeActivity = this.a;
                Uri uri = (Uri) obj;
                int i2 = QrCodeActivity.f7466g;
                j.e(qrCodeActivity, "this$0");
                j.d(uri, "it");
                byte[] bArrV4 = f.v4(uri, qrCodeActivity);
                if (bArrV4 == null) {
                    return;
                }
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrV4, 0, bArrV4.length);
                z zVar = z.a;
                j.d(bitmapDecodeByteArray, "bitmap");
                Map<e, ? extends Object> map = m.a;
                j.d(map, "ALL_HINTS");
                j.e(bitmapDecodeByteArray, "bitmap");
                j.e(map, "hints");
                if (bitmapDecodeByteArray.getWidth() > 480 || bitmapDecodeByteArray.getHeight() > 640) {
                    j.e(bitmapDecodeByteArray, "bitmap");
                    int width = bitmapDecodeByteArray.getWidth();
                    int height = bitmapDecodeByteArray.getHeight();
                    float f2 = 480 / width;
                    float f3 = 640 / height;
                    if (f2 > f3) {
                        f2 = f3;
                    }
                    Matrix matrix = new Matrix();
                    matrix.postScale(f2, f2);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, width, height, matrix, true);
                    j.d(bitmapCreateBitmap, "createBitmap(bitmap, 0, 0, width, height, matrix, true)");
                    pVarC = zVar.c(zVar.b(bitmapCreateBitmap), map);
                } else {
                    pVarC = zVar.c(zVar.b(bitmapDecodeByteArray), map);
                }
                qrCodeActivity.b0(pVarC);
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(ActivityResultContracts.GetContent()) {\n        it.readBytes(this)?.let { bytes ->\n            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)\n            onScanResultCallback(QRCodeUtils.parseCodeResult(bitmap))\n        }\n    }");
        this.selectQrImage = activityResultLauncherRegisterForActivityResult;
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_qrcode_capture, (ViewGroup) null, false);
        int i2 = R.id.fl_content;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.fl_content);
        if (frameLayout != null) {
            i2 = R.id.title_bar;
            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
            if (titleBar != null) {
                ActivityQrcodeCaptureBinding activityQrcodeCaptureBinding = new ActivityQrcodeCaptureBinding((LinearLayout) viewInflate, frameLayout, titleBar);
                j.d(activityQrcodeCaptureBinding, "inflate(layoutInflater)");
                return activityQrcodeCaptureBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new QrCodeFragment(), "qrCodeFragment").commit();
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.qr_code_scan, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.action_choose_from_gallery) {
            this.selectQrImage.launch("image/*");
        }
        return super.Q0(item);
    }

    @Override // c.g.a.k.a
    public boolean b0(@Nullable p result) {
        Intent intent = new Intent();
        intent.putExtra("result", result == null ? null : result.a);
        setResult(-1, intent);
        finish();
        return true;
    }
}
