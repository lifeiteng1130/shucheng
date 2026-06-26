package c.e.a.a;

import android.view.View;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FlexLine.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f832l;
    public int m;
    public int o;
    public int p;
    public int a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f822b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f823c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f824d = Integer.MIN_VALUE;
    public List<Integer> n = new ArrayList();

    public int a() {
        return this.f828h - this.f829i;
    }

    public void b(View view, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.a = Math.min(this.a, (view.getLeft() - flexItem.y()) - i2);
        this.f822b = Math.min(this.f822b, (view.getTop() - flexItem.A()) - i3);
        this.f823c = Math.max(this.f823c, flexItem.G() + view.getRight() + i4);
        this.f824d = Math.max(this.f824d, flexItem.x() + view.getBottom() + i5);
    }
}
