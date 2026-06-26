package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppDetailInfoActivity extends Activity {
    private ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f3073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f3074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RecyclerView f3075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<Pair<String, String>> f3078g;

    public class a extends RecyclerView.Adapter<Object> {
        private a() {
        }
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.iv_detail_back);
        this.f3073b = (TextView) findViewById(R.id.tv_empty);
        this.f3075d = (RecyclerView) findViewById(R.id.permission_list);
        this.f3074c = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f3078g.isEmpty()) {
            this.f3075d.setVisibility(8);
            this.f3073b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f3075d.setLayoutManager(linearLayoutManager);
            this.f3075d.setAdapter(new a());
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f3077f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f3074c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f3077f);
                b.a().b(AppDetailInfoActivity.this.f3077f);
                com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.c.a(b.a().b());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_detail_click_close", this.f3077f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (a()) {
            b();
        } else {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(Activity activity, long j2) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j2);
        activity.startActivity(intent);
    }

    private boolean a() {
        this.f3076e = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b bVarA = c.a().a(this.f3076e);
        if (bVarA == null) {
            return false;
        }
        this.f3077f = bVarA.f3029b;
        this.f3078g = bVarA.f3035h;
        return true;
    }
}
