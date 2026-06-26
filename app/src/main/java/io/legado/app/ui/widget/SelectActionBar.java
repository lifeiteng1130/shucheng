package io.legado.app.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.e;
import f.c0.c.j;
import io.legado.app.databinding.ViewSelectActionBarBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.widget.SelectActionBar;
import io.legado.app.ui.widget.text.AccentStrokeTextView;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SelectActionBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u001d\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0001\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006-"}, d2 = {"Lio/legado/app/ui/widget/SelectActionBar;", "Landroid/widget/FrameLayout;", "", "isClickable", "Lf/v;", "setMenuClickable", "(Z)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "setMainActionText", "(Ljava/lang/String;)V", "", "id", "(I)V", "resId", "Landroid/view/Menu;", ai.at, "(I)Landroid/view/Menu;", "Lio/legado/app/ui/widget/SelectActionBar$a;", "callBack", "setCallBack", "(Lio/legado/app/ui/widget/SelectActionBar$a;)V", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "listener", "setOnMenuItemClickListener", "(Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;)V", "selectCount", "allCount", "b", "(II)V", "Landroidx/appcompat/widget/PopupMenu;", ai.aD, "Landroidx/appcompat/widget/PopupMenu;", "selMenu", "Lio/legado/app/ui/widget/SelectActionBar$a;", "Lio/legado/app/databinding/ViewSelectActionBarBinding;", "d", "Lio/legado/app/databinding/ViewSelectActionBarBinding;", "binding", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectActionBar extends FrameLayout {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a callBack;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public PopupMenu selMenu;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewSelectActionBarBinding binding;

    /* JADX INFO: compiled from: SelectActionBar.kt */
    public interface a {
        void E0(boolean z);

        void I0();

        void f0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectActionBar(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    private final void setMenuClickable(boolean isClickable) {
        ViewSelectActionBarBinding viewSelectActionBarBinding = this.binding;
        viewSelectActionBarBinding.f6895b.setEnabled(isClickable);
        viewSelectActionBarBinding.f6895b.setClickable(isClickable);
        viewSelectActionBarBinding.f6896c.setEnabled(isClickable);
        viewSelectActionBarBinding.f6896c.setClickable(isClickable);
    }

    @Nullable
    public final Menu a(@MenuRes int resId) {
        PopupMenu popupMenu = new PopupMenu(getContext(), this.binding.f6898e);
        this.selMenu = popupMenu;
        if (popupMenu != null) {
            popupMenu.inflate(resId);
        }
        AppCompatImageView appCompatImageView = this.binding.f6898e;
        j.d(appCompatImageView, "binding.ivMenuMore");
        f.c6(appCompatImageView);
        PopupMenu popupMenu2 = this.selMenu;
        if (popupMenu2 == null) {
            return null;
        }
        return popupMenu2.getMenu();
    }

    public final void b(int selectCount, int allCount) {
        ViewSelectActionBarBinding viewSelectActionBarBinding = this.binding;
        if (selectCount == 0) {
            viewSelectActionBarBinding.f6897d.setChecked(false);
        } else {
            viewSelectActionBarBinding.f6897d.setChecked(selectCount >= allCount);
        }
        if (viewSelectActionBarBinding.f6897d.isChecked()) {
            viewSelectActionBarBinding.f6897d.setText(getContext().getString(R.string.select_cancel_count, Integer.valueOf(selectCount), Integer.valueOf(allCount)));
        } else {
            viewSelectActionBarBinding.f6897d.setText(getContext().getString(R.string.select_all_count, Integer.valueOf(selectCount), Integer.valueOf(allCount)));
        }
        setMenuClickable(selectCount > 0);
    }

    public final void setCallBack(@NotNull a callBack) {
        j.e(callBack, "callBack");
        this.callBack = callBack;
    }

    public final void setMainActionText(@NotNull String text) {
        j.e(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        ViewSelectActionBarBinding viewSelectActionBarBinding = this.binding;
        viewSelectActionBarBinding.f6896c.setText(text);
        AccentStrokeTextView accentStrokeTextView = viewSelectActionBarBinding.f6896c;
        j.d(accentStrokeTextView, "btnSelectActionMain");
        f.c6(accentStrokeTextView);
    }

    public final void setOnMenuItemClickListener(@NotNull PopupMenu.OnMenuItemClickListener listener) {
        j.e(listener, "listener");
        PopupMenu popupMenu = this.selMenu;
        if (popupMenu == null) {
            return;
        }
        popupMenu.setOnMenuItemClickListener(listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectActionBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_select_action_bar, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = R.id.btn_revert_selection;
        AccentStrokeTextView accentStrokeTextView = (AccentStrokeTextView) viewInflate.findViewById(R.id.btn_revert_selection);
        if (accentStrokeTextView != null) {
            i2 = R.id.btn_select_action_main;
            AccentStrokeTextView accentStrokeTextView2 = (AccentStrokeTextView) viewInflate.findViewById(R.id.btn_select_action_main);
            if (accentStrokeTextView2 != null) {
                i2 = R.id.cb_selected_all;
                ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_selected_all);
                if (aTECheckBox != null) {
                    i2 = R.id.iv_menu_more;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_menu_more);
                    if (appCompatImageView != null) {
                        ViewSelectActionBarBinding viewSelectActionBarBinding = new ViewSelectActionBarBinding((LinearLayout) viewInflate, accentStrokeTextView, accentStrokeTextView2, aTECheckBox, appCompatImageView);
                        j.d(viewSelectActionBarBinding, "inflate(LayoutInflater.from(context), this, true)");
                        this.binding = viewSelectActionBarBinding;
                        setBackgroundColor(f.T1(context));
                        setElevation(e.a.c() < 0 ? f.q2(context) : r2.c());
                        int iT1 = f.T1(context);
                        boolean z = ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d;
                        int iS2 = f.S2(context, z);
                        int iU2 = f.U2(context, z);
                        aTECheckBox.setTextColor(iS2);
                        j.d(aTECheckBox, "binding.cbSelectedAll");
                        int iM1 = f.M1(context);
                        boolean z2 = !z;
                        j.e(aTECheckBox, "box");
                        int[][] iArr = {new int[]{-16842910}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}};
                        int[] iArr2 = new int[3];
                        iArr2[0] = ContextCompat.getColor(aTECheckBox.getContext(), z2 ? R.color.ate_control_disabled_dark : R.color.ate_control_disabled_light);
                        iArr2[1] = ContextCompat.getColor(aTECheckBox.getContext(), z2 ? R.color.ate_control_normal_dark : R.color.ate_control_normal_light);
                        iArr2[2] = iM1;
                        aTECheckBox.setButtonTintList(new ColorStateList(iArr, iArr2));
                        appCompatImageView.setColorFilter(iU2);
                        aTECheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.m.e
                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                                SelectActionBar.a aVar;
                                SelectActionBar selectActionBar = this.a;
                                int i3 = SelectActionBar.a;
                                j.e(selectActionBar, "this$0");
                                if (!compoundButton.isPressed() || (aVar = selectActionBar.callBack) == null) {
                                    return;
                                }
                                aVar.E0(z3);
                            }
                        });
                        accentStrokeTextView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.d
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                SelectActionBar selectActionBar = this.a;
                                int i3 = SelectActionBar.a;
                                j.e(selectActionBar, "this$0");
                                SelectActionBar.a aVar = selectActionBar.callBack;
                                if (aVar == null) {
                                    return;
                                }
                                aVar.f0();
                            }
                        });
                        accentStrokeTextView2.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.g
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                SelectActionBar selectActionBar = this.a;
                                int i3 = SelectActionBar.a;
                                j.e(selectActionBar, "this$0");
                                SelectActionBar.a aVar = selectActionBar.callBack;
                                if (aVar == null) {
                                    return;
                                }
                                aVar.I0();
                            }
                        });
                        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.f
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                SelectActionBar selectActionBar = this.a;
                                int i3 = SelectActionBar.a;
                                j.e(selectActionBar, "this$0");
                                PopupMenu popupMenu = selectActionBar.selMenu;
                                if (popupMenu == null) {
                                    return;
                                }
                                popupMenu.show();
                            }
                        });
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    public final void setMainActionText(@StringRes int id) {
        ViewSelectActionBarBinding viewSelectActionBarBinding = this.binding;
        viewSelectActionBarBinding.f6896c.setText(id);
        AccentStrokeTextView accentStrokeTextView = viewSelectActionBarBinding.f6896c;
        j.d(accentStrokeTextView, "btnSelectActionMain");
        f.c6(accentStrokeTextView);
    }
}
