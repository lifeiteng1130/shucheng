package io.legado.app.ui.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.ifmvo.togetherad.core.custom.splashSkip.SplashSkipViewSimple2;
import com.ifmvo.togetherad.core.helper.AdHelperSplash;
import com.ifmvo.togetherad.core.utils.ScreenUtil;
import com.ifmvo.togetherad.csj.provider.CsjProvider;
import com.ifmvo.togetherad.gdt.provider.GdtProvider;
import com.umeng.analytics.pro.c;
import e.a.a.d.w.c;
import e.a.a.h.n;
import f.c0.c.j;
import f.h;
import io.legado.app.base.BaseActivity;
import io.legado.app.databinding.ActivitySplashBinding;
import io.legado.app.model.AdsConfig;
import io.wenyuange.app.release.R;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: SplashActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/legado/app/ui/welcome/SplashActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivitySplashBinding;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "", "h", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getFrom", "()I", "setFrom", "(I)V", "from", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7570g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int from;

    public SplashActivity() {
        super(false, null, null, false, false, 31);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_splash, (ViewGroup) null, false);
        int i2 = R.id.adContainer;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.adContainer);
        if (frameLayout != null) {
            i2 = R.id.appName;
            TextView textView = (TextView) viewInflate.findViewById(R.id.appName);
            if (textView != null) {
                i2 = R.id.info;
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.info);
                if (linearLayout != null) {
                    ActivitySplashBinding activitySplashBinding = new ActivitySplashBinding((LinearLayout) viewInflate, frameLayout, textView, linearLayout);
                    j.d(activitySplashBinding, "inflate(layoutInflater)");
                    return activitySplashBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        // AD REMOVED: skip splash ad, go directly to main activity
        Intent intent = getIntent();
        this.from = intent != null ? intent.getIntExtra("from", 0) : 0;
        Intent mainIntent = new Intent(this, io.legado.app.ui.main.MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainIntent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }
}
