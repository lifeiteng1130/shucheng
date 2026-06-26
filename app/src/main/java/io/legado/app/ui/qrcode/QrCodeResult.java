package io.legado.app.ui.qrcode;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.v;
import kotlin.Metadata;

/* JADX INFO: compiled from: QrCodeResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/legado/app/ui/qrcode/QrCodeResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lf/v;", "", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class QrCodeResult extends ActivityResultContract<v, String> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, v vVar) {
        j.e(context, c.R);
        return new Intent(context, (Class<?>) QrCodeActivity.class);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public String parseResult(int i2, Intent intent) {
        String stringExtra;
        if (i2 != -1 || intent == null || (stringExtra = intent.getStringExtra("result")) == null) {
            return null;
        }
        return stringExtra;
    }
}
