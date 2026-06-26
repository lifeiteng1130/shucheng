package c.f.a.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.ColorShape;
import com.jaredrummler.android.colorpicker.R$drawable;
import com.jaredrummler.android.colorpicker.R$id;
import com.jaredrummler.android.colorpicker.R$layout;

/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends BaseAdapter {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1563d;

    /* JADX INFO: compiled from: ColorPaletteAdapter.java */
    public interface a {
    }

    /* JADX INFO: renamed from: c.f.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ColorPaletteAdapter.java */
    public final class C0053b {
        public View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorPanelView f1564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f1565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1566d;

        public C0053b(Context context) {
            View viewInflate = View.inflate(context, b.this.f1563d == 0 ? R$layout.cpv_color_item_square : R$layout.cpv_color_item_circle, null);
            this.a = viewInflate;
            this.f1564b = (ColorPanelView) viewInflate.findViewById(R$id.cpv_color_panel_view);
            this.f1565c = (ImageView) this.a.findViewById(R$id.cpv_color_image_view);
            this.f1566d = this.f1564b.getBorderColor();
            this.a.setTag(this);
        }
    }

    public b(a aVar, int[] iArr, int i2, @ColorShape int i3) {
        this.a = aVar;
        this.f1561b = iArr;
        this.f1562c = i2;
        this.f1563d = i3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1561b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return Integer.valueOf(this.f1561b[i2]);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C0053b c0053b;
        if (view == null) {
            c0053b = new C0053b(viewGroup.getContext());
            view2 = c0053b.a;
        } else {
            view2 = view;
            c0053b = (C0053b) view.getTag();
        }
        int i3 = b.this.f1561b[i2];
        int iAlpha = Color.alpha(i3);
        c0053b.f1564b.setColor(i3);
        c0053b.f1565c.setImageResource(b.this.f1562c == i2 ? R$drawable.cpv_preset_checked : 0);
        if (iAlpha == 255) {
            b bVar = b.this;
            if (i2 != bVar.f1562c || ColorUtils.calculateLuminance(bVar.f1561b[i2]) < 0.65d) {
                c0053b.f1565c.setColorFilter((ColorFilter) null);
            } else {
                c0053b.f1565c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
            }
        } else if (iAlpha <= 165) {
            c0053b.f1564b.setBorderColor(i3 | ViewCompat.MEASURED_STATE_MASK);
            c0053b.f1565c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
        } else {
            c0053b.f1564b.setBorderColor(c0053b.f1566d);
            c0053b.f1565c.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        }
        c0053b.f1564b.setOnClickListener(new c(c0053b, i2));
        c0053b.f1564b.setOnLongClickListener(new d(c0053b));
        return view2;
    }
}
