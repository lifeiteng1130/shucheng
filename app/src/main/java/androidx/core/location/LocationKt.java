package androidx.core.location;

import android.location.Location;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Location.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/location/Location;", "", "component1", "(Landroid/location/Location;)D", "component2", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class LocationKt {
    public static final double component1(@NotNull Location location) {
        j.f(location, "$this$component1");
        return location.getLatitude();
    }

    public static final double component2(@NotNull Location location) {
        j.f(location, "$this$component2");
        return location.getLongitude();
    }
}
