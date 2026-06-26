package c.e.a.b.p;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements TypeEvaluator<Float> {
    public FloatEvaluator a = new FloatEvaluator();

    public i(h hVar) {
    }

    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f2, Float f3, Float f4) {
        float fFloatValue = this.a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
        if (fFloatValue < 0.1f) {
            fFloatValue = 0.0f;
        }
        return Float.valueOf(fFloatValue);
    }
}
