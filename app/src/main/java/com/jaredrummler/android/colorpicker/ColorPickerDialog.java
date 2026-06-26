package com.jaredrummler.android.colorpicker;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import c.f.a.a.b;
import com.jaredrummler.android.colorpicker.ColorPickerView;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ColorPickerDialog extends DialogFragment implements ColorPickerView.c, TextWatcher {
    public static final int[] a = {-769226, -1499549, -54125, -6543440, -10011977, -12627531, -14575885, -16537100, -16728876, -16738680, -11751600, -7617718, -3285959, -5317, -16121, -26624, -8825528, -10453621, -6381922};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.f.a.a.f f2567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f2568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f2569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColorInt
    public int f2570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c.f.a.a.b f2575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f2576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SeekBar f2577l;
    public TextView m;
    public ColorPickerView n;
    public ColorPanelView o;
    public EditText p;
    public boolean q;
    public int r;
    public boolean s;
    public int t;
    public final View.OnTouchListener u = new a();

    public @interface DialogType {
    }

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditText editText = ColorPickerDialog.this.p;
            if (view == editText || !editText.hasFocus()) {
                return false;
            }
            ColorPickerDialog.this.p.clearFocus();
            ((InputMethodManager) ColorPickerDialog.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(ColorPickerDialog.this.p.getWindowToken(), 0);
            ColorPickerDialog.this.p.clearFocus();
            return true;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            ColorPickerDialog.N(colorPickerDialog, colorPickerDialog.f2570e);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColorPickerDialog.this.f2568c.removeAllViews();
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i2 = colorPickerDialog.f2571f;
            if (i2 == 0) {
                colorPickerDialog.f2571f = 1;
                Button button = (Button) view;
                int i3 = colorPickerDialog.t;
                if (i3 == 0) {
                    i3 = R$string.cpv_custom;
                }
                button.setText(i3);
                ColorPickerDialog colorPickerDialog2 = ColorPickerDialog.this;
                colorPickerDialog2.f2568c.addView(colorPickerDialog2.Q());
                return;
            }
            if (i2 != 1) {
                return;
            }
            colorPickerDialog.f2571f = 0;
            Button button2 = (Button) view;
            int i4 = colorPickerDialog.r;
            if (i4 == 0) {
                i4 = R$string.cpv_presets;
            }
            button2.setText(i4);
            ColorPickerDialog colorPickerDialog3 = ColorPickerDialog.this;
            colorPickerDialog3.f2568c.addView(colorPickerDialog3.P());
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int color = ColorPickerDialog.this.o.getColor();
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i2 = colorPickerDialog.f2570e;
            if (color == i2) {
                ColorPickerDialog.N(colorPickerDialog, i2);
                ColorPickerDialog.this.dismiss();
            }
        }
    }

    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                ((InputMethodManager) ColorPickerDialog.this.getActivity().getSystemService("input_method")).showSoftInput(ColorPickerDialog.this.p, 1);
            }
        }
    }

    public class f implements b.a {
        public f() {
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ ColorPanelView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2578b;

        public g(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView, int i2) {
            this.a = colorPanelView;
            this.f2578b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setColor(this.f2578b);
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ ColorPanelView a;

        public h(ColorPanelView colorPanelView) {
            this.a = colorPanelView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
                ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
                ColorPickerDialog.N(colorPickerDialog, colorPickerDialog.f2570e);
                ColorPickerDialog.this.dismiss();
                return;
            }
            ColorPickerDialog.this.f2570e = this.a.getColor();
            c.f.a.a.b bVar = ColorPickerDialog.this.f2575j;
            bVar.f1562c = -1;
            bVar.notifyDataSetChanged();
            for (int i2 = 0; i2 < ColorPickerDialog.this.f2576k.getChildCount(); i2++) {
                FrameLayout frameLayout = (FrameLayout) ColorPickerDialog.this.f2576k.getChildAt(i2);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R$id.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(R$id.cpv_color_image_view);
                imageView.setImageResource(colorPanelView == view ? R$drawable.cpv_preset_checked : 0);
                if ((colorPanelView != view || ColorUtils.calculateLuminance(colorPanelView.getColor()) < 0.65d) && Color.alpha(colorPanelView.getColor()) > 165) {
                    imageView.setColorFilter((ColorFilter) null);
                } else {
                    imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
                }
                colorPanelView.setTag(Boolean.valueOf(colorPanelView == view));
            }
        }
    }

    public class i implements View.OnLongClickListener {
        public final /* synthetic */ ColorPanelView a;

        public i(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView) {
            this.a = colorPanelView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            this.a.a();
            return true;
        }
    }

    public static final class j {

        @StringRes
        public int a = R$string.cpv_default_title;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @StringRes
        public int f2580b = R$string.cpv_presets;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @StringRes
        public int f2581c = R$string.cpv_custom;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @StringRes
        public int f2582d = R$string.cpv_select;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @DialogType
        public int f2583e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f2584f = ColorPickerDialog.a;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @ColorInt
        public int f2585g = ViewCompat.MEASURED_STATE_MASK;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2586h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2587i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2588j = true;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f2589k = true;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f2590l = true;

        @ColorShape
        public int m = 1;

        public ColorPickerDialog a() {
            ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("id", this.f2586h);
            bundle.putInt("dialogType", this.f2583e);
            bundle.putInt("color", this.f2585g);
            bundle.putIntArray("presets", this.f2584f);
            bundle.putBoolean(Key.ALPHA, this.f2587i);
            bundle.putBoolean("allowCustom", this.f2589k);
            bundle.putBoolean("allowPresets", this.f2588j);
            bundle.putInt("dialogTitle", this.a);
            bundle.putBoolean("showColorShades", this.f2590l);
            bundle.putInt("colorShape", this.m);
            bundle.putInt("presetsButtonText", this.f2580b);
            bundle.putInt("customButtonText", this.f2581c);
            bundle.putInt("selectedButtonText", this.f2582d);
            colorPickerDialog.setArguments(bundle);
            return colorPickerDialog;
        }

        public void b(FragmentActivity fragmentActivity) {
            a().show(fragmentActivity.getSupportFragmentManager(), "color-picker-dialog");
        }
    }

    public static void N(ColorPickerDialog colorPickerDialog, int i2) {
        c.f.a.a.f fVar = colorPickerDialog.f2567b;
        if (fVar != null) {
            fVar.i0(colorPickerDialog.f2572g, i2);
            return;
        }
        KeyEventDispatcher.Component activity = colorPickerDialog.getActivity();
        if (!(activity instanceof c.f.a.a.f)) {
            throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
        }
        ((c.f.a.a.f) activity).i0(colorPickerDialog.f2572g, i2);
    }

    public void O(@ColorInt int i2) {
        int i3 = 0;
        int[] iArr = {T(i2, 0.9d), T(i2, 0.7d), T(i2, 0.5d), T(i2, 0.333d), T(i2, 0.166d), T(i2, -0.125d), T(i2, -0.25d), T(i2, -0.375d), T(i2, -0.5d), T(i2, -0.675d), T(i2, -0.7d), T(i2, -0.775d)};
        if (this.f2576k.getChildCount() != 0) {
            while (i3 < this.f2576k.getChildCount()) {
                FrameLayout frameLayout = (FrameLayout) this.f2576k.getChildAt(i3);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R$id.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(R$id.cpv_color_image_view);
                colorPanelView.setColor(iArr[i3]);
                colorPanelView.setTag(Boolean.FALSE);
                imageView.setImageDrawable(null);
                i3++;
            }
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.cpv_item_horizontal_padding);
        while (i3 < 12) {
            int i4 = iArr[i3];
            View viewInflate = View.inflate(getActivity(), this.f2574i == 0 ? R$layout.cpv_color_item_square : R$layout.cpv_color_item_circle, null);
            ColorPanelView colorPanelView2 = (ColorPanelView) viewInflate.findViewById(R$id.cpv_color_panel_view);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) colorPanelView2.getLayoutParams();
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.leftMargin = dimensionPixelSize;
            colorPanelView2.setLayoutParams(marginLayoutParams);
            colorPanelView2.setColor(i4);
            this.f2576k.addView(viewInflate);
            colorPanelView2.post(new g(this, colorPanelView2, i4));
            colorPanelView2.setOnClickListener(new h(colorPanelView2));
            colorPanelView2.setOnLongClickListener(new i(this, colorPanelView2));
            i3++;
        }
    }

    public View P() {
        View viewInflate = View.inflate(getActivity(), R$layout.cpv_dialog_color_picker, null);
        this.n = (ColorPickerView) viewInflate.findViewById(R$id.cpv_color_picker_view);
        ColorPanelView colorPanelView = (ColorPanelView) viewInflate.findViewById(R$id.cpv_color_panel_old);
        this.o = (ColorPanelView) viewInflate.findViewById(R$id.cpv_color_panel_new);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.cpv_arrow_right);
        this.p = (EditText) viewInflate.findViewById(R$id.cpv_hex);
        try {
            TypedArray typedArrayObtainStyledAttributes = getActivity().obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.textColorPrimary});
            int color = typedArrayObtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK);
            typedArrayObtainStyledAttributes.recycle();
            imageView.setColorFilter(color);
        } catch (Exception unused) {
        }
        this.n.setAlphaSliderVisible(this.q);
        colorPanelView.setColor(getArguments().getInt("color"));
        this.n.b(this.f2570e, true);
        this.o.setColor(this.f2570e);
        S(this.f2570e);
        if (!this.q) {
            this.p.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        }
        this.o.setOnClickListener(new d());
        viewInflate.setOnTouchListener(this.u);
        this.n.setOnColorChangedListener(this);
        this.p.addTextChangedListener(this);
        this.p.setOnFocusChangeListener(new e());
        return viewInflate;
    }

    public View Q() {
        boolean z;
        View viewInflate = View.inflate(getActivity(), R$layout.cpv_dialog_presets, null);
        this.f2576k = (LinearLayout) viewInflate.findViewById(R$id.shades_layout);
        this.f2577l = (SeekBar) viewInflate.findViewById(R$id.transparency_seekbar);
        this.m = (TextView) viewInflate.findViewById(R$id.transparency_text);
        GridView gridView = (GridView) viewInflate.findViewById(R$id.gridView);
        int iAlpha = Color.alpha(this.f2570e);
        int[] intArray = getArguments().getIntArray("presets");
        this.f2569d = intArray;
        if (intArray == null) {
            this.f2569d = a;
        }
        int[] iArr = this.f2569d;
        boolean z2 = iArr == a;
        this.f2569d = Arrays.copyOf(iArr, iArr.length);
        if (iAlpha != 255) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.f2569d;
                if (i2 >= iArr2.length) {
                    break;
                }
                int i3 = iArr2[i2];
                this.f2569d[i2] = Color.argb(iAlpha, Color.red(i3), Color.green(i3), Color.blue(i3));
                i2++;
            }
        }
        this.f2569d = U(this.f2569d, this.f2570e);
        int i4 = getArguments().getInt("color");
        if (i4 != this.f2570e) {
            this.f2569d = U(this.f2569d, i4);
        }
        if (z2) {
            int[] iArr3 = this.f2569d;
            if (iArr3.length == 19) {
                int iArgb = Color.argb(iAlpha, 0, 0, 0);
                int length = iArr3.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = false;
                        break;
                    }
                    if (iArr3[i5] == iArgb) {
                        z = true;
                        break;
                    }
                    i5++;
                }
                if (!z) {
                    int length2 = iArr3.length + 1;
                    int[] iArr4 = new int[length2];
                    int i6 = length2 - 1;
                    iArr4[i6] = iArgb;
                    System.arraycopy(iArr3, 0, iArr4, 0, i6);
                    iArr3 = iArr4;
                }
                this.f2569d = iArr3;
            }
        }
        if (this.f2573h) {
            O(this.f2570e);
        } else {
            this.f2576k.setVisibility(8);
            viewInflate.findViewById(R$id.shades_divider).setVisibility(8);
        }
        f fVar = new f();
        int[] iArr5 = this.f2569d;
        int i7 = 0;
        while (true) {
            int[] iArr6 = this.f2569d;
            if (i7 >= iArr6.length) {
                i7 = -1;
                break;
            }
            if (iArr6[i7] == this.f2570e) {
                break;
            }
            i7++;
        }
        c.f.a.a.b bVar = new c.f.a.a.b(fVar, iArr5, i7, this.f2574i);
        this.f2575j = bVar;
        gridView.setAdapter((ListAdapter) bVar);
        if (this.q) {
            int iAlpha2 = 255 - Color.alpha(this.f2570e);
            this.f2577l.setMax(255);
            this.f2577l.setProgress(iAlpha2);
            this.m.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((((double) iAlpha2) * 100.0d) / 255.0d))));
            this.f2577l.setOnSeekBarChangeListener(new c.f.a.a.e(this));
        } else {
            viewInflate.findViewById(R$id.transparency_layout).setVisibility(8);
            viewInflate.findViewById(R$id.transparency_title).setVisibility(8);
        }
        return viewInflate;
    }

    public void R(int i2) {
        this.f2570e = i2;
        ColorPanelView colorPanelView = this.o;
        if (colorPanelView != null) {
            colorPanelView.setColor(i2);
        }
        if (!this.s && this.p != null) {
            S(i2);
            if (this.p.hasFocus()) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.p.getWindowToken(), 0);
                this.p.clearFocus();
            }
        }
        this.s = false;
    }

    public final void S(int i2) {
        if (this.q) {
            this.p.setText(String.format("%08X", Integer.valueOf(i2)));
        } else {
            this.p.setText(String.format("%06X", Integer.valueOf(i2 & ViewCompat.MEASURED_SIZE_MASK)));
        }
    }

    public final int T(@ColorInt int i2, double d2) {
        long j2 = Long.parseLong(String.format("#%06X", Integer.valueOf(16777215 & i2)).substring(1), 16);
        double d3 = d2 >= 0.0d ? 255.0d : 0.0d;
        if (d2 < 0.0d) {
            d2 *= -1.0d;
        }
        long j3 = j2 >> 16;
        long j4 = (j2 >> 8) & 255;
        long j5 = j2 & 255;
        return Color.argb(Color.alpha(i2), (int) (Math.round((d3 - j3) * d2) + j3), (int) (Math.round((d3 - j4) * d2) + j4), (int) (Math.round((d3 - j5) * d2) + j5));
    }

    public final int[] U(int[] iArr, int i2) {
        boolean z;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z = false;
                break;
            }
            if (iArr[i3] == i2) {
                z = true;
                break;
            }
            i3++;
        }
        if (z) {
            return iArr;
        }
        int length2 = iArr.length + 1;
        int[] iArr2 = new int[length2];
        iArr2[0] = i2;
        System.arraycopy(iArr, 0, iArr2, 1, length2 - 1);
        return iArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void afterTextChanged(android.text.Editable r13) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaredrummler.android.colorpicker.ColorPickerDialog.afterTextChanged(android.text.Editable):void");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int i2;
        this.f2572g = getArguments().getInt("id");
        this.q = getArguments().getBoolean(Key.ALPHA);
        this.f2573h = getArguments().getBoolean("showColorShades");
        this.f2574i = getArguments().getInt("colorShape");
        if (bundle == null) {
            this.f2570e = getArguments().getInt("color");
            this.f2571f = getArguments().getInt("dialogType");
        } else {
            this.f2570e = bundle.getInt("color");
            this.f2571f = bundle.getInt("dialogType");
        }
        FrameLayout frameLayout = new FrameLayout(requireActivity());
        this.f2568c = frameLayout;
        int i3 = this.f2571f;
        if (i3 == 0) {
            frameLayout.addView(P());
        } else if (i3 == 1) {
            frameLayout.addView(Q());
        }
        int i4 = getArguments().getInt("selectedButtonText");
        if (i4 == 0) {
            i4 = R$string.cpv_select;
        }
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(requireActivity()).setView(this.f2568c).setPositiveButton(i4, new b());
        int i5 = getArguments().getInt("dialogTitle");
        if (i5 != 0) {
            positiveButton.setTitle(i5);
        }
        this.r = getArguments().getInt("presetsButtonText");
        this.t = getArguments().getInt("customButtonText");
        if (this.f2571f == 0 && getArguments().getBoolean("allowPresets")) {
            i2 = this.r;
            if (i2 == 0) {
                i2 = R$string.cpv_presets;
            }
        } else if (this.f2571f == 1 && getArguments().getBoolean("allowCustom")) {
            i2 = this.t;
            if (i2 == 0) {
                i2 = R$string.cpv_custom;
            }
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            positiveButton.setNeutralButton(i2, (DialogInterface.OnClickListener) null);
        }
        return positiveButton.create();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        c.f.a.a.f fVar = this.f2567b;
        if (fVar != null) {
            fVar.d0(this.f2572g);
            return;
        }
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof c.f.a.a.f) {
            ((c.f.a.a.f) activity).d0(this.f2572g);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("color", this.f2570e);
        bundle.putInt("dialogType", this.f2571f);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        alertDialog.getWindow().clearFlags(131080);
        alertDialog.getWindow().setSoftInputMode(4);
        Button button = alertDialog.getButton(-3);
        if (button != null) {
            button.setOnClickListener(new c());
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
