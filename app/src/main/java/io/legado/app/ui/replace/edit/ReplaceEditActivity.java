package io.legado.app.ui.replace.edit;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.activity.ComponentActivity;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import f.c0.b.a;
import f.c0.b.l;
import f.c0.c.f;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.databinding.ActivityReplaceEditBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.replace.edit.ReplaceEditActivity;
import io.legado.app.ui.widget.KeyboardToolPop;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.legado.app.ui.widget.text.TextInputLayout;
import io.wenyuange.app.release.R;
import java.io.InputStream;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001)B\u0007¢\u0006\u0004\b'\u0010\u0019J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lio/legado/app/ui/replace/edit/ReplaceEditActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityReplaceEditBinding;", "Lio/legado/app/ui/replace/edit/ReplaceEditViewModel;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lio/legado/app/ui/widget/KeyboardToolPop$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "B", "(Ljava/lang/String;)V", "onGlobalLayout", "()V", "U0", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/replace/edit/ReplaceEditViewModel;", "viewModel", "j", "Z", "mIsSoftKeyBoardShowing", "Landroid/widget/PopupWindow;", ai.aA, "Landroid/widget/PopupWindow;", "mSoftKeyboardTool", "<init>", "g", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReplaceEditActivity extends VMBaseActivity<ActivityReplaceEditBinding, ReplaceEditViewModel> implements ViewTreeObserver.OnGlobalLayoutListener, KeyboardToolPop.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public PopupWindow mSoftKeyboardTool;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean mIsSoftKeyBoardShowing;

    /* JADX INFO: renamed from: io.legado.app.ui.replace.edit.ReplaceEditActivity$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ReplaceEditActivity.kt */
    public static final class Companion {
        public Companion(f fVar) {
        }
    }

    /* JADX INFO: compiled from: ReplaceEditActivity.kt */
    public static final class b extends k implements l<ReplaceRule, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(ReplaceRule replaceRule) {
            invoke2(replaceRule);
            return v.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ReplaceRule replaceRule) {
            j.e(replaceRule, "it");
            ReplaceEditActivity replaceEditActivity = ReplaceEditActivity.this;
            Companion companion = ReplaceEditActivity.INSTANCE;
            ActivityReplaceEditBinding activityReplaceEditBinding = (ActivityReplaceEditBinding) replaceEditActivity.K0();
            activityReplaceEditBinding.f6528d.setText(replaceRule.getName());
            activityReplaceEditBinding.f6527c.setText(replaceRule.getGroup());
            activityReplaceEditBinding.f6529e.setText(replaceRule.getPattern());
            activityReplaceEditBinding.f6526b.setChecked(replaceRule.isRegex());
            activityReplaceEditBinding.f6530f.setText(replaceRule.getReplacement());
            activityReplaceEditBinding.f6531g.setText(replaceRule.getScope());
        }
    }

    /* JADX INFO: compiled from: ReplaceEditActivity.kt */
    public static final class c extends k implements a<v> {
        public c() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ReplaceEditActivity.this.setResult(-1);
            ReplaceEditActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class d extends k implements a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class e extends k implements a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            j.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public ReplaceEditActivity() {
        super(false, null, null, false, false, 30);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(ReplaceEditViewModel.class), new e(this), new d(this));
    }

    @Override // io.legado.app.ui.widget.KeyboardToolPop.a
    public void B(@NotNull String text) {
        View decorView;
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        e.a.a.c.c cVar = e.a.a.c.c.a;
        if (j.a(text, e.a.a.c.c.b().get(0))) {
            c.b.a.m.f.Z4(this, getString(R.string.help), f.x.e.a("正则教程"), new e.a.a.g.j.i0.b(this));
            return;
        }
        if (f.h0.k.s(text)) {
            return;
        }
        Window window = getWindow();
        View viewFindFocus = null;
        if (window != null && (decorView = window.getDecorView()) != null) {
            viewFindFocus = decorView.findFocus();
        }
        if (viewFindFocus instanceof EditText) {
            EditText editText = (EditText) viewFindFocus;
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            Editable editableText = editText.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) text);
            } else {
                editableText.replace(selectionStart, selectionEnd, text);
            }
        }
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_replace_edit, (ViewGroup) null, false);
        int i2 = R.id.cb_use_regex;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_use_regex);
        if (aTECheckBox != null) {
            i2 = R.id.et_group;
            io.legado.app.ui.widget.text.EditText editText = (io.legado.app.ui.widget.text.EditText) viewInflate.findViewById(R.id.et_group);
            if (editText != null) {
                i2 = R.id.et_name;
                io.legado.app.ui.widget.text.EditText editText2 = (io.legado.app.ui.widget.text.EditText) viewInflate.findViewById(R.id.et_name);
                if (editText2 != null) {
                    i2 = R.id.et_replace_rule;
                    io.legado.app.ui.widget.text.EditText editText3 = (io.legado.app.ui.widget.text.EditText) viewInflate.findViewById(R.id.et_replace_rule);
                    if (editText3 != null) {
                        i2 = R.id.et_replace_to;
                        io.legado.app.ui.widget.text.EditText editText4 = (io.legado.app.ui.widget.text.EditText) viewInflate.findViewById(R.id.et_replace_to);
                        if (editText4 != null) {
                            i2 = R.id.et_scope;
                            io.legado.app.ui.widget.text.EditText editText5 = (io.legado.app.ui.widget.text.EditText) viewInflate.findViewById(R.id.et_scope);
                            if (editText5 != null) {
                                i2 = R.id.iv_help;
                                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_help);
                                if (imageView != null) {
                                    i2 = R.id.ll_content;
                                    LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_content);
                                    if (linearLayout != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                                        i2 = R.id.til_group;
                                        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.til_group);
                                        if (textInputLayout != null) {
                                            i2 = R.id.til_name;
                                            TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.til_name);
                                            if (textInputLayout2 != null) {
                                                i2 = R.id.til_replace_rule;
                                                TextInputLayout textInputLayout3 = (TextInputLayout) viewInflate.findViewById(R.id.til_replace_rule);
                                                if (textInputLayout3 != null) {
                                                    i2 = R.id.til_replace_to;
                                                    TextInputLayout textInputLayout4 = (TextInputLayout) viewInflate.findViewById(R.id.til_replace_to);
                                                    if (textInputLayout4 != null) {
                                                        i2 = R.id.til_scope;
                                                        TextInputLayout textInputLayout5 = (TextInputLayout) viewInflate.findViewById(R.id.til_scope);
                                                        if (textInputLayout5 != null) {
                                                            i2 = R.id.title_bar;
                                                            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                                                            if (titleBar != null) {
                                                                ActivityReplaceEditBinding activityReplaceEditBinding = new ActivityReplaceEditBinding(linearLayout2, aTECheckBox, editText, editText2, editText3, editText4, editText5, imageView, linearLayout, linearLayout2, textInputLayout, textInputLayout2, textInputLayout3, textInputLayout4, textInputLayout5, titleBar);
                                                                j.d(activityReplaceEditBinding, "inflate(layoutInflater)");
                                                                return activityReplaceEditBinding;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        e.a.a.c.c cVar = e.a.a.c.c.a;
        this.mSoftKeyboardTool = new KeyboardToolPop(this, e.a.a.c.c.b(), this);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        ReplaceEditViewModel replaceEditViewModelT0 = T0();
        Intent intent = getIntent();
        j.d(intent, "intent");
        b bVar = new b();
        Objects.requireNonNull(replaceEditViewModelT0);
        j.e(intent, "intent");
        j.e(bVar, "finally");
        e.a.a.d.u.b.c(BaseViewModel.a(replaceEditViewModelT0, null, null, new e.a.a.g.j.i0.c(intent, replaceEditViewModelT0, null), 3, null), null, new e.a.a.g.j.i0.d(replaceEditViewModelT0, bVar, null), 1);
        ((ActivityReplaceEditBinding) K0()).f6532h.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.j.i0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplaceEditActivity replaceEditActivity = this.a;
                ReplaceEditActivity.Companion companion = ReplaceEditActivity.INSTANCE;
                j.e(replaceEditActivity, "this$0");
                replaceEditActivity.U0();
            }
        });
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.replace_edit, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() != R.id.menu_save) {
            return true;
        }
        ActivityReplaceEditBinding activityReplaceEditBinding = (ActivityReplaceEditBinding) K0();
        ReplaceRule replaceRule = T0().replaceRule;
        if (replaceRule == null) {
            replaceRule = new ReplaceRule(0L, null, null, null, null, null, false, false, 0, FrameMetricsAggregator.EVERY_DURATION, null);
        }
        replaceRule.setName(String.valueOf(activityReplaceEditBinding.f6528d.getText()));
        replaceRule.setGroup(String.valueOf(activityReplaceEditBinding.f6527c.getText()));
        replaceRule.setPattern(String.valueOf(activityReplaceEditBinding.f6529e.getText()));
        replaceRule.setRegex(activityReplaceEditBinding.f6526b.isChecked());
        replaceRule.setReplacement(String.valueOf(activityReplaceEditBinding.f6530f.getText()));
        replaceRule.setScope(String.valueOf(activityReplaceEditBinding.f6531g.getText()));
        if (!replaceRule.isValid()) {
            c.b.a.m.f.Q5(this, R.string.replace_rule_invalid);
            return true;
        }
        ReplaceEditViewModel replaceEditViewModelT0 = T0();
        c cVar = new c();
        Objects.requireNonNull(replaceEditViewModelT0);
        j.e(replaceRule, "replaceRule");
        j.e(cVar, "success");
        BaseViewModel.a(replaceEditViewModelT0, null, null, new e.a.a.g.j.i0.e(replaceRule, null), 3, null).d(null, new e.a.a.g.j.i0.f(cVar, null));
        return true;
    }

    @NotNull
    public ReplaceEditViewModel T0() {
        return (ReplaceEditViewModel) this.viewModel.getValue();
    }

    public final void U0() {
        InputStream inputStreamOpen = getAssets().open("help/regexHelp.md");
        j.d(inputStreamOpen, "assets.open(\"help/regexHelp.md\")");
        String str = new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a);
        TextDialog.Companion companion = TextDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        TextDialog.Companion.a(companion, supportFragmentManager, str, 1, 0L, false, 24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        PopupWindow popupWindow;
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = c.b.a.m.f.V2(this).heightPixels;
        int i3 = i2 - rect.bottom;
        boolean z = this.mIsSoftKeyBoardShowing;
        if (Math.abs(i3) <= i2 / 5) {
            this.mIsSoftKeyBoardShowing = false;
            ((ActivityReplaceEditBinding) K0()).f6534j.setPadding(0, 0, 0, 0);
            if (!z || (popupWindow = this.mSoftKeyboardTool) == null) {
                return;
            }
            popupWindow.dismiss();
            return;
        }
        this.mIsSoftKeyBoardShowing = true;
        ((ActivityReplaceEditBinding) K0()).f6534j.setPadding(0, 0, 0, 100);
        PopupWindow popupWindow2 = this.mSoftKeyboardTool;
        if (popupWindow2 == null || popupWindow2.isShowing() || isFinishing()) {
            return;
        }
        popupWindow2.showAtLocation(((ActivityReplaceEditBinding) K0()).f6533i, 80, 0, 0);
    }
}
