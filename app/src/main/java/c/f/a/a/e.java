package c.f.a.a;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.R$id;
import java.util.Locale;

/* JADX INFO: compiled from: ColorPickerDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ ColorPickerDialog a;

    public e(ColorPickerDialog colorPickerDialog) {
        this.a = colorPickerDialog;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        b bVar;
        this.a.m.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((((double) i2) * 100.0d) / 255.0d))));
        int i3 = 255 - i2;
        int i4 = 0;
        while (true) {
            bVar = this.a.f2575j;
            int[] iArr = bVar.f1561b;
            if (i4 >= iArr.length) {
                break;
            }
            int i5 = iArr[i4];
            this.a.f2575j.f1561b[i4] = Color.argb(i3, Color.red(i5), Color.green(i5), Color.blue(i5));
            i4++;
        }
        bVar.notifyDataSetChanged();
        for (int i6 = 0; i6 < this.a.f2576k.getChildCount(); i6++) {
            FrameLayout frameLayout = (FrameLayout) this.a.f2576k.getChildAt(i6);
            ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R$id.cpv_color_panel_view);
            ImageView imageView = (ImageView) frameLayout.findViewById(R$id.cpv_color_image_view);
            if (frameLayout.getTag() == null) {
                frameLayout.setTag(Integer.valueOf(colorPanelView.getBorderColor()));
            }
            int color = colorPanelView.getColor();
            int iArgb = Color.argb(i3, Color.red(color), Color.green(color), Color.blue(color));
            if (i3 <= 165) {
                colorPanelView.setBorderColor(iArgb | ViewCompat.MEASURED_STATE_MASK);
            } else {
                colorPanelView.setBorderColor(((Integer) frameLayout.getTag()).intValue());
            }
            if (colorPanelView.getTag() != null && ((Boolean) colorPanelView.getTag()).booleanValue()) {
                if (i3 <= 165) {
                    imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
                } else if (ColorUtils.calculateLuminance(iArgb) >= 0.65d) {
                    imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
                } else {
                    imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                }
            }
            colorPanelView.setColor(iArgb);
        }
        this.a.f2570e = Color.argb(i3, Color.red(this.a.f2570e), Color.green(this.a.f2570e), Color.blue(this.a.f2570e));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
