package io.legado.app.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import f.c0.c.j;
import io.legado.app.base.BaseActivity;
import io.legado.app.databinding.ActivityFeedbackBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.text.AccentBgTextView;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FeedbackActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/legado/app/ui/about/FeedbackActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityFeedbackBinding;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FeedbackActivity extends BaseActivity<ActivityFeedbackBinding> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f6975g = 0;

    /* JADX INFO: compiled from: Click.kt */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            int i2 = FeedbackActivity.f6975g;
            Editable text = feedbackActivity.K0().f6514d.getText();
            Editable text2 = FeedbackActivity.this.K0().f6513c.getText();
            if (TextUtils.isEmpty(text)) {
                f.R5(FeedbackActivity.this, "请输入反馈的标题");
            }
            if (TextUtils.isEmpty(text2)) {
                f.R5(FeedbackActivity.this, "请输入反馈的内容");
            }
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:hamapi223@outlook.com"));
            intent.putExtra("android.intent.extra.SUBJECT", text);
            intent.putExtra("android.intent.extra.TEXT", text2);
            FeedbackActivity.this.startActivity(intent);
        }
    }

    public FeedbackActivity() {
        super(false, null, null, false, false, 31);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_feedback, (ViewGroup) null, false);
        int i2 = R.id.commit;
        AccentBgTextView accentBgTextView = (AccentBgTextView) viewInflate.findViewById(R.id.commit);
        if (accentBgTextView != null) {
            i2 = R.id.content;
            EditText editText = (EditText) viewInflate.findViewById(R.id.content);
            if (editText != null) {
                i2 = R.id.title;
                EditText editText2 = (EditText) viewInflate.findViewById(R.id.title);
                if (editText2 != null) {
                    i2 = R.id.title_bar;
                    TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                    if (titleBar != null) {
                        ActivityFeedbackBinding activityFeedbackBinding = new ActivityFeedbackBinding((LinearLayout) viewInflate, accentBgTextView, editText, editText2, titleBar);
                        j.d(activityFeedbackBinding, "inflate(layoutInflater)");
                        return activityFeedbackBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        AccentBgTextView accentBgTextView = K0().f6512b;
        j.d(accentBgTextView, "binding.commit");
        accentBgTextView.setOnClickListener(new a());
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        return super.Q0(item);
    }
}
