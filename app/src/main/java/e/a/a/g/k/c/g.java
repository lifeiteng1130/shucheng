package e.a.a.g.k.c;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import f.v;
import io.legado.app.service.DownloadService;
import io.legado.app.ui.rss.read.ReadRssActivity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadRssActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends f.c0.c.k implements f.c0.b.l<View, v> {
    public final /* synthetic */ String $fileName;
    public final /* synthetic */ String $url;
    public final /* synthetic */ ReadRssActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, ReadRssActivity readRssActivity) {
        super(1);
        this.$url = str;
        this.$fileName = str2;
        this.this$0 = readRssActivity;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(View view) {
        invoke2(view);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View view) {
        f.c0.c.j.e(view, "it");
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.$url));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setAllowedOverMetered(false);
        request.setVisibleInDownloadsUi(false);
        request.setAllowedOverRoaming(true);
        request.setAllowedNetworkTypes(2);
        request.setNotificationVisibility(2);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, this.$fileName);
        f.c0.c.j.f("download", "name");
        long jEnqueue = ((DownloadManager) k.d.a.h.g().getSystemService("download")).enqueue(request);
        ReadRssActivity readRssActivity = this.this$0;
        String str = this.$fileName;
        f.c0.c.j.d(str, "fileName");
        f.c0.c.j.e(readRssActivity, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(str, "fileName");
        Intent intent = new Intent(readRssActivity, (Class<?>) DownloadService.class);
        intent.setAction("start");
        intent.putExtra("downloadId", jEnqueue);
        intent.putExtra("fileName", str);
        readRssActivity.startService(intent);
    }
}
