package e.a.a.e.d;

import android.R;
import android.content.res.ColorStateList;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Selector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public int a = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5647b = -7829368;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5648c = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5649d = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5650e = ViewCompat.MEASURED_STATE_MASK;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5655j;

    @NotNull
    public final ColorStateList a() {
        int[] iArr = new int[6];
        iArr[0] = this.f5652g ? this.f5647b : this.a;
        iArr[1] = this.f5653h ? this.f5648c : this.a;
        iArr[2] = this.f5654i ? this.f5649d : this.a;
        int i2 = this.a;
        iArr[3] = i2;
        iArr[4] = this.f5655j ? this.f5651f : i2;
        iArr[5] = i2;
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_checked}, new int[0]}, iArr);
    }

    @NotNull
    public final a b(@ColorInt int i2) {
        this.a = i2;
        if (!this.f5652g) {
            this.f5647b = i2;
        }
        if (!this.f5653h) {
            this.f5648c = i2;
        }
        if (!this.f5654i) {
            this.f5649d = i2;
        }
        this.f5650e = i2;
        return this;
    }

    @NotNull
    public final a c(@ColorInt int i2) {
        this.f5647b = i2;
        this.f5652g = true;
        return this;
    }

    @NotNull
    public final a d(@ColorInt int i2) {
        this.f5648c = i2;
        this.f5653h = true;
        return this;
    }

    @NotNull
    public final a e(@ColorInt int i2) {
        this.f5649d = i2;
        this.f5654i = true;
        return this;
    }
}
