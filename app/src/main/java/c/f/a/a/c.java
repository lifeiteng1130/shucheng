package c.f.a.a;

import android.view.View;
import c.f.a.a.b;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;

/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements View.OnClickListener {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.C0053b f1568b;

    public c(b.C0053b c0053b, int i2) {
        this.f1568b = c0053b;
        this.a = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = b.this;
        int i2 = bVar.f1562c;
        int i3 = this.a;
        if (i2 != i3) {
            bVar.f1562c = i3;
            bVar.notifyDataSetChanged();
        }
        b bVar2 = b.this;
        b.a aVar = bVar2.a;
        int i4 = bVar2.f1561b[this.a];
        ColorPickerDialog.f fVar = (ColorPickerDialog.f) aVar;
        ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
        int i5 = colorPickerDialog.f2570e;
        if (i5 == i4) {
            ColorPickerDialog.N(colorPickerDialog, i5);
            ColorPickerDialog.this.dismiss();
        } else {
            colorPickerDialog.f2570e = i4;
            if (colorPickerDialog.f2573h) {
                colorPickerDialog.O(i4);
            }
        }
    }
}
