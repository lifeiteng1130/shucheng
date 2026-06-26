package io.legado.app.ui.qrcode;

import androidx.fragment.app.FragmentActivity;
import c.e.c.p;
import com.king.zxing.CaptureFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: QrCodeFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/legado/app/ui/qrcode/QrCodeFragment;", "Lcom/king/zxing/CaptureFragment;", "Lc/e/c/p;", "result", "", "b0", "(Lc/e/c/p;)Z", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class QrCodeFragment extends CaptureFragment {
    @Override // com.king.zxing.CaptureFragment, c.g.a.k.a
    public boolean b0(@Nullable p result) {
        FragmentActivity activity = getActivity();
        QrCodeActivity qrCodeActivity = activity instanceof QrCodeActivity ? (QrCodeActivity) activity : null;
        if (qrCodeActivity == null) {
            return true;
        }
        qrCodeActivity.b0(result);
        return true;
    }
}
