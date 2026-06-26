package c.e.a.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: MotionSpec.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public final SimpleArrayMap<String, h> a = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleArrayMap<String, PropertyValuesHolder[]> f846b = new SimpleArrayMap<>();

    @Nullable
    public static g a(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return b(context, resourceId);
    }

    @Nullable
    public static g b(@NonNull Context context, @AnimatorRes int i2) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return c(arrayList);
        } catch (Exception unused) {
            Integer.toHexString(i2);
            return null;
        }
    }

    @NonNull
    public static g c(@NonNull List<Animator> list) {
        g gVar = new g();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = list.get(i2);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            gVar.f846b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.f839b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.f840c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.f841d;
            }
            h hVar = new h(startDelay, duration, interpolator);
            hVar.f849d = objectAnimator.getRepeatCount();
            hVar.f850e = objectAnimator.getRepeatMode();
            gVar.a.put(propertyName, hVar);
        }
        return gVar;
    }

    @NonNull
    public <T> ObjectAnimator d(@NonNull String str, @NonNull T t, @NonNull Property<T, ?> property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, e(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        f(str).a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    @NonNull
    public PropertyValuesHolder[] e(String str) {
        if (!g(str)) {
            throw new IllegalArgumentException();
        }
        PropertyValuesHolder[] propertyValuesHolderArr = this.f846b.get(str);
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i2 = 0; i2 < propertyValuesHolderArr.length; i2++) {
            propertyValuesHolderArr2[i2] = propertyValuesHolderArr[i2].clone();
        }
        return propertyValuesHolderArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return this.a.equals(((g) obj).a);
        }
        return false;
    }

    public h f(String str) {
        if (this.a.get(str) != null) {
            return this.a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean g(String str) {
        return this.f846b.get(str) != null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NonNull
    public String toString() {
        StringBuilder sbQ = c.a.a.a.a.q('\n');
        sbQ.append(g.class.getName());
        sbQ.append(MessageFormatter.DELIM_START);
        sbQ.append(Integer.toHexString(System.identityHashCode(this)));
        sbQ.append(" timings: ");
        sbQ.append(this.a);
        sbQ.append("}\n");
        return sbQ.toString();
    }
}
