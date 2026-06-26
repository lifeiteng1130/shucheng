package io.legado.app.lib.permission;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.bytedance.pangle.servermanager.AbsServerManager;
import e.a.a.e.c.i;
import e.a.a.e.c.o;
import f.c0.c.j;
import io.legado.app.lib.permission.PermissionActivity;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PermissionActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\u0015J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010 \u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00100\u00100\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lio/legado/app/lib/permission/PermissionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/content/Intent;", "intent", "startActivity", "(Landroid/content/Intent;)V", "finish", "()V", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "b", "Landroidx/activity/result/ActivityResultLauncher;", "settingActivityResult", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PermissionActivity extends AppCompatActivity {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> settingActivityResult;

    public PermissionActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.e.c.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PermissionActivity permissionActivity = this.a;
                int i2 = PermissionActivity.a;
                f.c0.c.j.e(permissionActivity, "this$0");
                i iVar = o.a;
                if (iVar != null) {
                    iVar.b();
                }
                permissionActivity.finish();
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n            RequestPlugins.sRequestCallback?.onSettingActivityResult()\n            finish()\n        }");
        this.settingActivityResult = activityResultLauncherRegisterForActivityResult;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int intExtra = getIntent().getIntExtra("KEY_INPUT_REQUEST_TYPE", 1);
        if (intExtra == 1) {
            int intExtra2 = getIntent().getIntExtra("KEY_INPUT_PERMISSIONS_CODE", 1000);
            String[] stringArrayExtra = getIntent().getStringArrayExtra("KEY_INPUT_PERMISSIONS");
            if (stringArrayExtra != null) {
                ActivityCompat.requestPermissions(this, stringArrayExtra, intExtra2);
                return;
            } else {
                finish();
                return;
            }
        }
        if (intExtra != 2) {
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts(AbsServerManager.PACKAGE_QUERY_BINDER, getPackageName(), null));
            this.settingActivityResult.launch(intent);
        } catch (Exception unused) {
            f.Q5(this, R.string.tip_cannot_jump_setting_page);
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        j.e(event, NotificationCompat.CATEGORY_EVENT);
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        j.e(permissions, "permissions");
        j.e(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        i iVar = o.a;
        if (iVar != null) {
            iVar.a(permissions, grantResults);
        }
        finish();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(@NotNull Intent intent) {
        j.e(intent, "intent");
        super.startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
