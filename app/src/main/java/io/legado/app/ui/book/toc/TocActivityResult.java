package io.legado.app.ui.book.toc;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.g;
import kotlin.Metadata;

/* JADX INFO: compiled from: TocActivityResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/legado/app/ui/book/toc/TocActivityResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Lf/g;", "", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TocActivityResult extends ActivityResultContract<String, g<? extends Integer, ? extends Integer>> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, String str) {
        j.e(context, c.R);
        Intent intentPutExtra = new Intent(context, (Class<?>) TocActivity.class).putExtra("bookUrl", str);
        j.d(intentPutExtra, "Intent(context, TocActivity::class.java)\n            .putExtra(\"bookUrl\", input)");
        return intentPutExtra;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public g<? extends Integer, ? extends Integer> parseResult(int i2, Intent intent) {
        if (i2 != -1 || intent == null) {
            return null;
        }
        return new g<>(Integer.valueOf(intent.getIntExtra("index", 0)), Integer.valueOf(intent.getIntExtra("chapterPos", 0)));
    }
}
