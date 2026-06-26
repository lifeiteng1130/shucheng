package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.h;
import com.ss.android.socialbase.appdownloader.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JumpUnknownSourceActivity extends Activity {
    private k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Intent f3425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Intent f3426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f3428e;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
        h.a().a(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        h.a().a(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f3425b = intent;
        if (intent != null) {
            this.f3426c = (Intent) intent.getParcelableExtra("intent");
            this.f3427d = intent.getIntExtra("id", -1);
            try {
                this.f3428e = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f3428e == null) {
            c.a((Activity) this);
            return;
        }
        b();
        k kVar = this.a;
        if (kVar != null && !kVar.b()) {
            this.a.a();
        } else if (this.a == null) {
            finish();
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void b() {
        if (this.a != null || this.f3425b == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.c.c cVarA = d.j().a();
            l lVarA = cVarA != null ? cVarA.a(this) : null;
            if (lVarA == null) {
                lVarA = new com.ss.android.socialbase.appdownloader.d.a(this);
            }
            int iA = i.a(this, "tt_appdownloader_tip");
            int iA2 = i.a(this, "tt_appdownloader_label_ok");
            int iA3 = i.a(this, "tt_appdownloader_label_cancel");
            String strOptString = this.f3428e.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = getString(i.a(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            lVarA.a(iA).a(strOptString).a(iA2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (b.a(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f3426c, JumpUnknownSourceActivity.this.f3427d, JumpUnknownSourceActivity.this.f3428e)) {
                        b.c(JumpUnknownSourceActivity.this.f3427d, JumpUnknownSourceActivity.this.f3428e);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f3426c, true);
                    }
                    b.a(JumpUnknownSourceActivity.this.f3427d, JumpUnknownSourceActivity.this.f3428e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).b(iA3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (JumpUnknownSourceActivity.this.f3426c != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f3426c, true);
                    }
                    b.b(JumpUnknownSourceActivity.this.f3427d, JumpUnknownSourceActivity.this.f3428e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).a(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.f3426c != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f3426c, true);
                    }
                    b.b(JumpUnknownSourceActivity.this.f3427d, JumpUnknownSourceActivity.this.f3428e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).a(false);
            this.a = lVarA.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
