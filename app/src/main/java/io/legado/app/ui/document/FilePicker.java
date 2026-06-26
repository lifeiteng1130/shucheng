package io.legado.app.ui.document;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import com.umeng.analytics.pro.c;
import e.a.a.g.f.d;
import f.c0.c.j;
import kotlin.Metadata;

/* JADX INFO: compiled from: FilePicker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/legado/app/ui/document/FilePicker;", "Landroidx/activity/result/contract/ActivityResultContract;", "Le/a/a/g/f/d;", "Landroid/net/Uri;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FilePicker extends ActivityResultContract<d, Uri> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, d dVar) {
        d dVar2 = dVar;
        j.e(context, c.R);
        Intent intent = new Intent(context, (Class<?>) FilePickerActivity.class);
        if (dVar2 != null) {
            intent.putExtra("mode", dVar2.a);
            intent.putExtra("title", dVar2.f5838b);
            intent.putExtra("allowExtensions", dVar2.f5839c);
            intent.putExtra("otherActions", dVar2.f5840d);
        }
        return intent;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Uri parseResult(int i2, Intent intent) {
        if (i2 != -1 || intent == null) {
            return null;
        }
        return intent.getData();
    }
}
