package io.legado.app.ui.widget.prefs;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceViewHolder;
import c.f.a.a.f;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.R$styleable;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.b.l;
import f.c0.c.j;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.widget.prefs.Preference;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ColorPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002Q\u0010B\u0017\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0010\u001a\u00020\u001fH\u0002¢\u0006\u0004\b\u0010\u0010 R\u001c\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010\u0005R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010\"R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\"R\u0018\u00101\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010\"R\u0016\u00105\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010'R\u0016\u00107\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010'R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R?\u0010D\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020%\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010'R\u0016\u0010H\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010'R\u0016\u0010J\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010\"¨\u0006R"}, d2 = {"Lio/legado/app/ui/widget/prefs/ColorPreference;", "Landroidx/preference/Preference;", "Lc/f/a/a/f;", "Lf/v;", "onClick", "()V", "onAttached", "Landroidx/preference/PreferenceViewHolder;", "holder", "onBindViewHolder", "(Landroidx/preference/PreferenceViewHolder;)V", "", "defaultValue", "onSetInitialValue", "(Ljava/lang/Object;)V", "Landroid/content/res/TypedArray;", ai.at, "", "index", "onGetDefaultValue", "(Landroid/content/res/TypedArray;I)Ljava/lang/Object;", "dialogId", "color", "i0", "(II)V", "d0", "(I)V", "Lio/legado/app/ui/widget/prefs/ColorPreference$a;", "listener", "setOnShowDialogListener", "(Lio/legado/app/ui/widget/prefs/ColorPreference$a;)V", "Landroidx/fragment/app/FragmentActivity;", "()Landroidx/fragment/app/FragmentActivity;", "f", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getDialogType$annotations", "dialogType", "", "e", "Z", "showDialog", Constants.LANDSCAPE, "previewSize", "b", "sizeLarge", "d", "mColor", ai.aD, "Lio/legado/app/ui/widget/prefs/ColorPreference$a;", "onShowDialogListener", "g", "colorShape", ai.aA, "allowCustom", "j", "showAlphaSlider", "", "m", "[I", "presets", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lf/c0/b/l;", "getOnSaveColor", "()Lf/c0/b/l;", "setOnSaveColor", "(Lf/c0/b/l;)V", "onSaveColor", "h", "allowPresets", "k", "showColorShades", "n", "dialogTitle", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ColorPickerDialogCompat", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ColorPreference extends androidx.preference.Preference implements f {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @Nullable
    public l<? super Integer, Boolean> onSaveColor;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int sizeLarge;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a onShowDialogListener;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int mColor;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean showDialog;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int dialogType;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int colorShape;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean allowPresets;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean allowCustom;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean showAlphaSlider;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean showColorShades;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int previewSize;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public int[] presets;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int dialogTitle;

    /* JADX INFO: compiled from: ColorPreference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/legado/app/ui/widget/prefs/ColorPreference$ColorPickerDialogCompat;", "Lcom/jaredrummler/android/colorpicker/ColorPickerDialog;", "Lf/v;", "onStart", "()V", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ColorPickerDialogCompat extends ColorPickerDialog {
        @Override // com.jaredrummler.android.colorpicker.ColorPickerDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStart() {
            super.onStart();
            Dialog dialog = getDialog();
            AlertDialog alertDialog = dialog instanceof AlertDialog ? (AlertDialog) dialog : null;
            if (alertDialog == null) {
                return;
            }
            ATH.a.d(alertDialog);
        }
    }

    /* JADX INFO: compiled from: ColorPreference.kt */
    public interface a {
        void a(@NotNull String str, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPreference(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        this.sizeLarge = 1;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        setPersistent(true);
        setLayoutResource(R.layout.view_preference);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ColorPreference);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ColorPreference)");
        this.showDialog = typedArrayObtainStyledAttributes.getBoolean(9, true);
        this.dialogType = typedArrayObtainStyledAttributes.getInt(5, 1);
        this.colorShape = typedArrayObtainStyledAttributes.getInt(3, 1);
        this.allowPresets = typedArrayObtainStyledAttributes.getBoolean(1, true);
        this.allowCustom = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.showAlphaSlider = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.showColorShades = typedArrayObtainStyledAttributes.getBoolean(8, true);
        this.previewSize = typedArrayObtainStyledAttributes.getInt(6, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.dialogTitle = typedArrayObtainStyledAttributes.getResourceId(4, R.string.cpv_default_title);
        this.presets = resourceId != 0 ? context.getResources().getIntArray(resourceId) : ColorPickerDialog.a;
        setWidgetLayoutResource(this.colorShape == 1 ? this.previewSize == 1 ? R.layout.cpv_preference_circle_large : R.layout.cpv_preference_circle : this.previewSize == 1 ? R.layout.cpv_preference_square_large : R.layout.cpv_preference_square);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final FragmentActivity a() {
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            return (FragmentActivity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof FragmentActivity) {
                return (FragmentActivity) baseContext;
            }
        }
        throw new IllegalStateException("Error getting activity from context");
    }

    @Override // c.f.a.a.f
    public void d0(int dialogId) {
    }

    @Override // c.f.a.a.f
    public void i0(int dialogId, @ColorInt int color) {
        l<? super Integer, Boolean> lVar = this.onSaveColor;
        if (j.a(lVar == null ? null : lVar.invoke(Integer.valueOf(color)), Boolean.TRUE)) {
            return;
        }
        int iMin = this.showAlphaSlider ? color : (Math.min(255, Math.max(0, (int) (255 * 1.0f))) << 24) + (16777215 & color);
        this.mColor = iMin;
        persistInt(iMin);
        notifyChanged();
        callChangeListener(Integer.valueOf(color));
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        ColorPickerDialog colorPickerDialog;
        super.onAttached();
        if (!this.showDialog || (colorPickerDialog = (ColorPickerDialog) a().getSupportFragmentManager().findFragmentByTag(j.k("color_", getKey()))) == null) {
            return;
        }
        colorPickerDialog.f2567b = this;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NotNull PreferenceViewHolder holder) {
        j.e(holder, "holder");
        Preference.Companion companion = Preference.INSTANCE;
        Context context = getContext();
        j.d(context, c.R);
        ColorPanelView colorPanelView = (ColorPanelView) Preference.Companion.a(companion, context, holder, getIcon(), getTitle(), getSummary(), Integer.valueOf(getWidgetLayoutResource()), Integer.valueOf(R.id.cpv_preference_preview_color_panel), 30, 30, false, 512);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.mColor);
        }
        super.onBindViewHolder(holder);
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        super.onClick();
        a aVar = this.onShowDialogListener;
        if (aVar != null) {
            j.c(aVar);
            CharSequence title = getTitle();
            Objects.requireNonNull(title, "null cannot be cast to non-null type kotlin.String");
            aVar.a((String) title, this.mColor);
            return;
        }
        if (this.showDialog) {
            int[] iArr = ColorPickerDialog.a;
            int i2 = this.dialogType;
            int i3 = this.dialogTitle;
            int i4 = this.colorShape;
            int[] iArr2 = this.presets;
            j.c(iArr2);
            j.e(iArr2, "presets");
            boolean z = this.allowPresets;
            boolean z2 = this.allowCustom;
            boolean z3 = this.showAlphaSlider;
            boolean z4 = this.showColorShades;
            int i5 = this.mColor;
            ColorPickerDialogCompat colorPickerDialogCompat = new ColorPickerDialogCompat();
            Bundle bundle = new Bundle();
            bundle.putInt("id", 0);
            bundle.putInt("dialogType", i2);
            bundle.putInt("color", i5);
            bundle.putIntArray("presets", iArr2);
            bundle.putBoolean(Key.ALPHA, z3);
            bundle.putBoolean("allowCustom", z2);
            bundle.putBoolean("allowPresets", z);
            bundle.putInt("dialogTitle", i3);
            bundle.putBoolean("showColorShades", z4);
            bundle.putInt("colorShape", i4);
            bundle.putInt("presetsButtonText", R.string.cpv_presets);
            bundle.putInt("customButtonText", R.string.cpv_custom);
            bundle.putInt("selectedButtonText", R.string.cpv_select);
            colorPickerDialogCompat.setArguments(bundle);
            colorPickerDialogCompat.f2567b = this;
            a().getSupportFragmentManager().beginTransaction().add(colorPickerDialogCompat, j.k("color_", getKey())).commitAllowingStateLoss();
        }
    }

    @Override // androidx.preference.Preference
    @NotNull
    public Object onGetDefaultValue(@Nullable TypedArray a2, int index) {
        j.c(a2);
        return Integer.valueOf(a2.getInteger(index, ViewCompat.MEASURED_STATE_MASK));
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(@Nullable Object defaultValue) {
        int iIntValue;
        super.onSetInitialValue(defaultValue);
        if (!(defaultValue instanceof Integer)) {
            this.mColor = getPersistedInt(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        Number number = (Number) defaultValue;
        if (this.showAlphaSlider) {
            iIntValue = number.intValue();
        } else {
            iIntValue = (Math.min(255, Math.max(0, (int) (1.0f * 255))) << 24) + (number.intValue() & ViewCompat.MEASURED_SIZE_MASK);
        }
        this.mColor = iIntValue;
        persistInt(iIntValue);
    }

    public final void setOnShowDialogListener(@NotNull a listener) {
        j.e(listener, "listener");
        this.onShowDialogListener = listener;
    }
}
