package c.e.a.b.c0;

import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.Locale;

/* JADX INFO: compiled from: TimePickerClockPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements ClockHandView.d, TimePickerView.d, TimePickerView.c, ClockHandView.c, g {
    public static final String[] a = {"12", SdkVersion.MINI_VERSION, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f920b = {"00", ExifInterface.GPS_MEASUREMENT_2D, "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f921c = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimePickerView f922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TimeModel f923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f926h = false;

    public f(TimePickerView timePickerView, TimeModel timeModel) {
        this.f922d = timePickerView;
        this.f923e = timeModel;
        if (timeModel.f2496c == 0) {
            timePickerView.f2504e.setVisibility(0);
        }
        this.f922d.addOnRotateListener(this);
        TimePickerView timePickerView2 = this.f922d;
        timePickerView2.f2507h = this;
        timePickerView2.setOnPeriodChangeListener(this);
        this.f922d.setOnActionUpListener(this);
        h(a, "%d");
        h(f920b, "%d");
        h(f921c, "%02d");
        b();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void a(float f2, boolean z) {
        if (this.f926h) {
            return;
        }
        TimeModel timeModel = this.f923e;
        int i2 = timeModel.f2497d;
        int i3 = timeModel.f2498e;
        int iRound = Math.round(f2);
        TimeModel timeModel2 = this.f923e;
        if (timeModel2.f2499f == 12) {
            timeModel2.f2498e = ((iRound + 3) / 6) % 60;
            this.f924f = (float) Math.floor(r6 * 6);
        } else {
            this.f923e.e((iRound + (e() / 2)) / e());
            this.f925g = e() * this.f923e.d();
        }
        if (z) {
            return;
        }
        g();
        TimeModel timeModel3 = this.f923e;
        if (timeModel3.f2498e == i3 && timeModel3.f2497d == i2) {
            return;
        }
        this.f922d.performHapticFeedback(4);
    }

    @Override // c.e.a.b.c0.g
    public void b() {
        this.f925g = e() * this.f923e.d();
        TimeModel timeModel = this.f923e;
        this.f924f = timeModel.f2498e * 6;
        f(timeModel.f2499f, false);
        g();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void c(int i2) {
        f(i2, true);
    }

    @Override // c.e.a.b.c0.g
    public void d() {
        this.f922d.setVisibility(8);
    }

    public final int e() {
        return this.f923e.f2496c == 1 ? 15 : 30;
    }

    public void f(int i2, boolean z) {
        boolean z2 = i2 == 12;
        TimePickerView timePickerView = this.f922d;
        timePickerView.f2502c.f2474c = z2;
        TimeModel timeModel = this.f923e;
        timeModel.f2499f = i2;
        timePickerView.f2503d.d(z2 ? f921c : timeModel.f2496c == 1 ? f920b : a, z2 ? R$string.material_minute_suffix : R$string.material_hour_suffix);
        this.f922d.f2502c.b(z2 ? this.f924f : this.f925g, z);
        TimePickerView timePickerView2 = this.f922d;
        timePickerView2.a.setChecked(i2 == 12);
        timePickerView2.f2501b.setChecked(i2 == 10);
        ViewCompat.setAccessibilityDelegate(this.f922d.f2501b, new a(this.f922d.getContext(), R$string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(this.f922d.a, new a(this.f922d.getContext(), R$string.material_minute_selection));
    }

    public final void g() {
        TimePickerView timePickerView = this.f922d;
        TimeModel timeModel = this.f923e;
        int i2 = timeModel.f2500g;
        int iD = timeModel.d();
        int i3 = this.f923e.f2498e;
        timePickerView.f2504e.b(i2 == 1 ? R$id.material_clock_period_pm_button : R$id.material_clock_period_am_button);
        Locale locale = timePickerView.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(i3));
        String str2 = String.format(locale, "%02d", Integer.valueOf(iD));
        timePickerView.a.setText(str);
        timePickerView.f2501b.setText(str2);
    }

    public final void h(String[] strArr, String str) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = TimeModel.b(this.f922d.getResources(), strArr[i2], str);
        }
    }

    @Override // c.e.a.b.c0.g
    public void show() {
        this.f922d.setVisibility(0);
    }
}
