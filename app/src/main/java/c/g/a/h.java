package c.g.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.ai;
import java.util.Objects;

/* JADX INFO: compiled from: AmbientLightManager.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements SensorEventListener {
    public SensorManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Sensor f1570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f1573e;

    /* JADX INFO: compiled from: AmbientLightManager.java */
    public interface a {
    }

    public h(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(ai.ac);
        this.a = sensorManager;
        this.f1570b = sensorManager.getDefaultSensor(5);
        this.f1572d = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f1572d) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f1571c < 200) {
                return;
            }
            this.f1571c = jCurrentTimeMillis;
            a aVar = this.f1573e;
            if (aVar != null) {
                float f2 = sensorEvent.values[0];
                if (f2 <= 45.0f) {
                    Objects.requireNonNull(((f) aVar).a);
                } else if (f2 >= 100.0f) {
                    Objects.requireNonNull(((f) aVar).a);
                }
            }
        }
    }

    public void setOnLightSensorEventListener(a aVar) {
        this.f1573e = aVar;
    }
}
