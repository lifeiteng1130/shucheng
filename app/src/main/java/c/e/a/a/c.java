package c.e.a.a;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.MarginLayoutParamsCompat;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: FlexboxHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public final c.e.a.a.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public int[] f834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public long[] f835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public long[] f836e;

    /* JADX INFO: compiled from: FlexboxHelper.java */
    public static class b {
        public List<c.e.a.a.b> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f837b;

        public void a() {
            this.a = null;
            this.f837b = 0;
        }
    }

    /* JADX INFO: renamed from: c.e.a.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FlexboxHelper.java */
    public static class C0038c implements Comparable<C0038c> {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f838b;

        public C0038c() {
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull C0038c c0038c) {
            C0038c c0038c2 = c0038c;
            int i2 = this.f838b;
            int i3 = c0038c2.f838b;
            return i2 != i3 ? i2 - i3 : this.a - c0038c2.a;
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("Order{order=");
            sbR.append(this.f838b);
            sbR.append(", index=");
            return c.a.a.a.a.n(sbR, this.a, MessageFormatter.DELIM_STOP);
        }

        public C0038c(a aVar) {
        }
    }

    public c(c.e.a.a.a aVar) {
        this.a = aVar;
    }

    public void A(int i2) {
        View viewC;
        if (i2 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        if (this.a.getAlignItems() != 4) {
            for (c.e.a.a.b bVar : this.a.getFlexLinesInternal()) {
                for (Integer num : bVar.n) {
                    View viewC2 = this.a.c(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        z(viewC2, bVar.f827g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException(c.a.a.a.a.G("Invalid flex direction: ", flexDirection));
                        }
                        y(viewC2, bVar.f827g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f834c;
        List<c.e.a.a.b> flexLinesInternal = this.a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i3 = iArr != null ? iArr[i2] : 0; i3 < size; i3++) {
            c.e.a.a.b bVar2 = flexLinesInternal.get(i3);
            int i4 = bVar2.f828h;
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = bVar2.o + i5;
                if (i5 < this.a.getFlexItemCount() && (viewC = this.a.c(i6)) != null && viewC.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) viewC.getLayoutParams();
                    if (flexItem.u() == -1 || flexItem.u() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            z(viewC, bVar2.f827g, i6);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException(c.a.a.a.a.G("Invalid flex direction: ", flexDirection));
                            }
                            y(viewC, bVar2.f827g, i6);
                        }
                    }
                }
            }
        }
    }

    public final void B(int i2, int i3, int i4, View view) {
        long[] jArr = this.f835d;
        if (jArr != null) {
            jArr[i2] = (((long) i3) & 4294967295L) | (((long) i4) << 32);
        }
        long[] jArr2 = this.f836e;
        if (jArr2 != null) {
            jArr2[i2] = (((long) view.getMeasuredWidth()) & 4294967295L) | (((long) view.getMeasuredHeight()) << 32);
        }
    }

    public final void a(List<c.e.a.a.b> list, c.e.a.a.b bVar, int i2, int i3) {
        bVar.m = i3;
        this.a.b(bVar);
        bVar.p = i2;
        list.add(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0360 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x029b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(c.e.a.a.c.b r24, int r25, int r26, int r27, int r28, int r29, @androidx.annotation.Nullable java.util.List<c.e.a.a.b> r30) {
        /*
            Method dump skipped, instruction units count: 899
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.a.c.b(c.e.a.a.c$b, int, int, int, int, int, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.w()
            r4 = 1
            if (r1 >= r3) goto L1a
            int r1 = r0.w()
            goto L24
        L1a:
            int r3 = r0.M()
            if (r1 <= r3) goto L26
            int r1 = r0.M()
        L24:
            r3 = 1
            goto L27
        L26:
            r3 = 0
        L27:
            int r5 = r0.I()
            if (r2 >= r5) goto L32
            int r2 = r0.I()
            goto L3e
        L32:
            int r5 = r0.K()
            if (r2 <= r5) goto L3d
            int r2 = r0.K()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.B(r8, r1, r0, r7)
            c.e.a.a.a r0 = r6.a
            r0.e(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.a.c.c(android.view.View, int):void");
    }

    public void d(List<c.e.a.a.b> list, int i2) {
        int i3 = this.f834c[i2];
        if (i3 == -1) {
            i3 = 0;
        }
        for (int size = list.size() - 1; size >= i3; size--) {
            list.remove(size);
        }
        int[] iArr = this.f834c;
        int length = iArr.length - 1;
        if (i2 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i2, length, -1);
        }
        long[] jArr = this.f835d;
        int length2 = jArr.length - 1;
        if (i2 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i2, length2, 0L);
        }
    }

    public final List<c.e.a.a.b> e(List<c.e.a.a.b> list, int i2, int i3) {
        int i4 = (i2 - i3) / 2;
        ArrayList arrayList = new ArrayList();
        c.e.a.a.b bVar = new c.e.a.a.b();
        bVar.f827g = i4;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i5));
            if (i5 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public final List<C0038c> f(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            FlexItem flexItem = (FlexItem) this.a.f(i3).getLayoutParams();
            C0038c c0038c = new C0038c(null);
            c0038c.f838b = flexItem.getOrder();
            c0038c.a = i3;
            arrayList.add(c0038c);
        }
        return arrayList;
    }

    public void g(int i2, int i3, int i4) {
        int mode;
        int size;
        int flexDirection = this.a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException(c.a.a.a.a.G("Invalid flex direction: ", flexDirection));
            }
            mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
        }
        List<c.e.a.a.b> flexLinesInternal = this.a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.a.getSumOfCrossSize() + i4;
            int i5 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f827g = size - i4;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.a.getAlignContent();
                if (alignContent == 1) {
                    int i6 = size - sumOfCrossSize;
                    c.e.a.a.b bVar = new c.e.a.a.b();
                    bVar.f827g = i6;
                    flexLinesInternal.add(0, bVar);
                    return;
                }
                if (alignContent == 2) {
                    this.a.setFlexLines(e(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i5 < size4) {
                        arrayList.add(flexLinesInternal.get(i5));
                        if (i5 != flexLinesInternal.size() - 1) {
                            c.e.a.a.b bVar2 = new c.e.a.a.b();
                            if (i5 == flexLinesInternal.size() - 2) {
                                bVar2.f827g = Math.round(f2 + size3);
                                f2 = 0.0f;
                            } else {
                                bVar2.f827g = Math.round(size3);
                            }
                            int i7 = bVar2.f827g;
                            float f3 = (size3 - i7) + f2;
                            if (f3 > 1.0f) {
                                bVar2.f827g = i7 + 1;
                                f3 -= 1.0f;
                            } else if (f3 < -1.0f) {
                                bVar2.f827g = i7 - 1;
                                f3 += 1.0f;
                            }
                            arrayList.add(bVar2);
                            f2 = f3;
                        }
                        i5++;
                    }
                    this.a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.a.setFlexLines(e(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    c.e.a.a.b bVar3 = new c.e.a.a.b();
                    bVar3.f827g = size5;
                    for (c.e.a.a.b bVar4 : flexLinesInternal) {
                        arrayList2.add(bVar3);
                        arrayList2.add(bVar4);
                        arrayList2.add(bVar3);
                    }
                    this.a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f4 = 0.0f;
                    while (i5 < size7) {
                        c.e.a.a.b bVar5 = flexLinesInternal.get(i5);
                        float f5 = bVar5.f827g + size6;
                        if (i5 == flexLinesInternal.size() - 1) {
                            f5 += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(f5);
                        float f6 = (f5 - iRound) + f4;
                        if (f6 > 1.0f) {
                            iRound++;
                            f6 -= 1.0f;
                        } else if (f6 < -1.0f) {
                            iRound--;
                            f6 += 1.0f;
                        }
                        f4 = f6;
                        bVar5.f827g = iRound;
                        i5++;
                    }
                }
            }
        }
    }

    public void h(int i2, int i3, int i4) {
        int size;
        int paddingLeft;
        int paddingRight;
        int flexItemCount = this.a.getFlexItemCount();
        boolean[] zArr = this.f833b;
        if (zArr == null) {
            if (flexItemCount < 10) {
                flexItemCount = 10;
            }
            this.f833b = new boolean[flexItemCount];
        } else if (zArr.length < flexItemCount) {
            int length = zArr.length * 2;
            if (length >= flexItemCount) {
                flexItemCount = length;
            }
            this.f833b = new boolean[flexItemCount];
        } else {
            Arrays.fill(zArr, false);
        }
        if (i4 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        int flexDirection2 = this.a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = this.a.getLargestMainSize();
            }
            paddingLeft = this.a.getPaddingLeft();
            paddingRight = this.a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException(c.a.a.a.a.G("Invalid flex direction: ", flexDirection));
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                size = this.a.getLargestMainSize();
            }
            paddingLeft = this.a.getPaddingTop();
            paddingRight = this.a.getPaddingBottom();
        }
        int i5 = paddingRight + paddingLeft;
        int[] iArr = this.f834c;
        List<c.e.a.a.b> flexLinesInternal = this.a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i6 = iArr != null ? iArr[i4] : 0; i6 < size2; i6++) {
            c.e.a.a.b bVar = flexLinesInternal.get(i6);
            if (bVar.f825e < size) {
                l(i2, i3, bVar, size, i5, false);
            } else {
                w(i2, i3, bVar, size, i5, false);
            }
        }
    }

    public void i(int i2) {
        int[] iArr = this.f834c;
        if (iArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f834c = new int[i2];
        } else if (iArr.length < i2) {
            int length = iArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f834c = Arrays.copyOf(iArr, i2);
        }
    }

    public void j(int i2) {
        long[] jArr = this.f835d;
        if (jArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f835d = new long[i2];
        } else if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f835d = Arrays.copyOf(jArr, i2);
        }
    }

    public void k(int i2) {
        long[] jArr = this.f836e;
        if (jArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f836e = new long[i2];
        } else if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f836e = Arrays.copyOf(jArr, i2);
        }
    }

    public final void l(int i2, int i3, c.e.a.a.b bVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int iMax;
        double d2;
        int i8;
        double d3;
        float f2 = bVar.f830j;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i4 < (i6 = bVar.f825e)) {
            return;
        }
        float f4 = (i4 - i6) / f2;
        bVar.f825e = i5 + bVar.f826f;
        if (!z) {
            bVar.f827g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f5 = 0.0f;
        while (i9 < bVar.f828h) {
            int i11 = bVar.o + i9;
            View viewC = this.a.c(i11);
            if (viewC == null || viewC.getVisibility() == 8) {
                i7 = i6;
            } else {
                FlexItem flexItem = (FlexItem) viewC.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i12 = i6;
                    int measuredWidth = viewC.getMeasuredWidth();
                    long[] jArr = this.f836e;
                    if (jArr != null) {
                        measuredWidth = (int) jArr[i11];
                    }
                    int measuredHeight = viewC.getMeasuredHeight();
                    long[] jArr2 = this.f836e;
                    i7 = i12;
                    if (jArr2 != null) {
                        measuredHeight = m(jArr2[i11]);
                    }
                    if (!this.f833b[i11] && flexItem.B() > 0.0f) {
                        float fB = (flexItem.B() * f4) + measuredWidth;
                        if (i9 == bVar.f828h - 1) {
                            fB += f5;
                            f5 = 0.0f;
                        }
                        int iRound = Math.round(fB);
                        if (iRound > flexItem.M()) {
                            iRound = flexItem.M();
                            this.f833b[i11] = true;
                            bVar.f830j -= flexItem.B();
                            z2 = true;
                        } else {
                            float f6 = (fB - iRound) + f5;
                            double d4 = f6;
                            if (d4 > 1.0d) {
                                iRound++;
                                d2 = d4 - 1.0d;
                            } else {
                                if (d4 < -1.0d) {
                                    iRound--;
                                    d2 = d4 + 1.0d;
                                }
                                f5 = f6;
                            }
                            f6 = (float) d2;
                            f5 = f6;
                        }
                        int iN = n(i3, flexItem, bVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, BasicMeasure.EXACTLY);
                        viewC.measure(iMakeMeasureSpec, iN);
                        int measuredWidth2 = viewC.getMeasuredWidth();
                        int measuredHeight2 = viewC.getMeasuredHeight();
                        B(i11, iMakeMeasureSpec, iN, viewC);
                        this.a.e(i11, viewC);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i10, this.a.j(viewC) + flexItem.x() + flexItem.A() + measuredHeight);
                    bVar.f825e = flexItem.G() + flexItem.y() + measuredWidth + bVar.f825e;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewC.getMeasuredHeight();
                    long[] jArr3 = this.f836e;
                    if (jArr3 != null) {
                        measuredHeight3 = m(jArr3[i11]);
                    }
                    int measuredWidth3 = viewC.getMeasuredWidth();
                    long[] jArr4 = this.f836e;
                    if (jArr4 != null) {
                        measuredWidth3 = (int) jArr4[i11];
                    }
                    if (this.f833b[i11] || flexItem.B() <= f3) {
                        i8 = i6;
                    } else {
                        float fB2 = (flexItem.B() * f4) + measuredHeight3;
                        if (i9 == bVar.f828h - 1) {
                            fB2 += f5;
                            f5 = 0.0f;
                        }
                        int iRound2 = Math.round(fB2);
                        if (iRound2 > flexItem.K()) {
                            iRound2 = flexItem.K();
                            this.f833b[i11] = true;
                            bVar.f830j -= flexItem.B();
                            i8 = i6;
                            z2 = true;
                        } else {
                            float f7 = (fB2 - iRound2) + f5;
                            i8 = i6;
                            double d5 = f7;
                            if (d5 > 1.0d) {
                                iRound2++;
                                d3 = d5 - 1.0d;
                            } else if (d5 < -1.0d) {
                                iRound2--;
                                d3 = d5 + 1.0d;
                            } else {
                                f5 = f7;
                            }
                            f5 = (float) d3;
                        }
                        int iO = o(i2, flexItem, bVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewC.measure(iO, iMakeMeasureSpec2);
                        measuredWidth3 = viewC.getMeasuredWidth();
                        int measuredHeight4 = viewC.getMeasuredHeight();
                        B(i11, iO, iMakeMeasureSpec2, viewC);
                        this.a.e(i11, viewC);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i10, this.a.j(viewC) + flexItem.G() + flexItem.y() + measuredWidth3);
                    bVar.f825e = flexItem.x() + flexItem.A() + measuredHeight3 + bVar.f825e;
                    i7 = i8;
                }
                bVar.f827g = Math.max(bVar.f827g, iMax);
                i10 = iMax;
            }
            i9++;
            i6 = i7;
            f3 = 0.0f;
        }
        int i13 = i6;
        if (!z2 || i13 == bVar.f825e) {
            return;
        }
        l(i2, i3, bVar, i4, i5, true);
    }

    public int m(long j2) {
        return (int) (j2 >> 32);
    }

    public final int n(int i2, FlexItem flexItem, int i3) {
        c.e.a.a.a aVar = this.a;
        int iH = aVar.h(i2, flexItem.x() + flexItem.A() + this.a.getPaddingBottom() + aVar.getPaddingTop() + i3, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iH);
        return size > flexItem.K() ? View.MeasureSpec.makeMeasureSpec(flexItem.K(), View.MeasureSpec.getMode(iH)) : size < flexItem.I() ? View.MeasureSpec.makeMeasureSpec(flexItem.I(), View.MeasureSpec.getMode(iH)) : iH;
    }

    public final int o(int i2, FlexItem flexItem, int i3) {
        c.e.a.a.a aVar = this.a;
        int iD = aVar.d(i2, flexItem.G() + flexItem.y() + this.a.getPaddingRight() + aVar.getPaddingLeft() + i3, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(iD);
        return size > flexItem.M() ? View.MeasureSpec.makeMeasureSpec(flexItem.M(), View.MeasureSpec.getMode(iD)) : size < flexItem.w() ? View.MeasureSpec.makeMeasureSpec(flexItem.w(), View.MeasureSpec.getMode(iD)) : iD;
    }

    public final int p(FlexItem flexItem, boolean z) {
        return z ? flexItem.x() : flexItem.G();
    }

    public final int q(FlexItem flexItem, boolean z) {
        return z ? flexItem.G() : flexItem.x();
    }

    public final int r(FlexItem flexItem, boolean z) {
        return z ? flexItem.A() : flexItem.y();
    }

    public final int s(FlexItem flexItem, boolean z) {
        return z ? flexItem.y() : flexItem.A();
    }

    public final boolean t(int i2, int i3, c.e.a.a.b bVar) {
        return i2 == i3 - 1 && bVar.a() != 0;
    }

    public void u(View view, c.e.a.a.b bVar, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.u() != -1) {
            alignItems = flexItem.u();
        }
        int i6 = bVar.f827g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.a.getFlexWrap() != 2) {
                    int i7 = i3 + i6;
                    view.layout(i2, (i7 - view.getMeasuredHeight()) - flexItem.x(), i4, i7 - flexItem.x());
                    return;
                }
                view.layout(i2, flexItem.A() + view.getMeasuredHeight() + (i3 - i6), i4, flexItem.A() + view.getMeasuredHeight() + (i5 - i6));
                return;
            }
            if (alignItems == 2) {
                int iA = ((flexItem.A() + (i6 - view.getMeasuredHeight())) - flexItem.x()) / 2;
                if (this.a.getFlexWrap() != 2) {
                    int i8 = i3 + iA;
                    view.layout(i2, i8, i4, view.getMeasuredHeight() + i8);
                    return;
                } else {
                    int i9 = i3 - iA;
                    view.layout(i2, i9, i4, view.getMeasuredHeight() + i9);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.a.getFlexWrap() != 2) {
                    int iMax = Math.max(bVar.f832l - view.getBaseline(), flexItem.A());
                    view.layout(i2, i3 + iMax, i4, i5 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max(view.getBaseline() + (bVar.f832l - view.getMeasuredHeight()), flexItem.x());
                    view.layout(i2, i3 - iMax2, i4, i5 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.a.getFlexWrap() != 2) {
            view.layout(i2, flexItem.A() + i3, i4, flexItem.A() + i5);
        } else {
            view.layout(i2, i3 - flexItem.x(), i4, i5 - flexItem.x());
        }
    }

    public void v(View view, c.e.a.a.b bVar, boolean z, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.u() != -1) {
            alignItems = flexItem.u();
        }
        int i6 = bVar.f827g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i2 + i6) - view.getMeasuredWidth()) - flexItem.G(), i3, ((i4 + i6) - view.getMeasuredWidth()) - flexItem.G(), i5);
                    return;
                }
                view.layout(flexItem.y() + view.getMeasuredWidth() + (i2 - i6), i3, flexItem.y() + view.getMeasuredWidth() + (i4 - i6), i5);
                return;
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int marginStart = ((MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + (i6 - view.getMeasuredWidth())) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i2 - marginStart, i3, i4 - marginStart, i5);
                    return;
                } else {
                    view.layout(i2 + marginStart, i3, i4 + marginStart, i5);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z) {
            view.layout(i2 - flexItem.G(), i3, i4 - flexItem.G(), i5);
        } else {
            view.layout(flexItem.y() + i2, i3, flexItem.y() + i4, i5);
        }
    }

    public final void w(int i2, int i3, c.e.a.a.b bVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int iMax;
        int iW;
        int i8 = bVar.f825e;
        float f2 = bVar.f831k;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i4 > i8) {
            return;
        }
        float f4 = (i8 - i4) / f2;
        bVar.f825e = i5 + bVar.f826f;
        if (!z) {
            bVar.f827g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f5 = 0.0f;
        while (i9 < bVar.f828h) {
            int i11 = bVar.o + i9;
            View viewC = this.a.c(i11);
            if (viewC == null || viewC.getVisibility() == 8) {
                i6 = i8;
                i7 = i9;
            } else {
                FlexItem flexItem = (FlexItem) viewC.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i6 = i8;
                    int i12 = i9;
                    int measuredWidth = viewC.getMeasuredWidth();
                    long[] jArr = this.f836e;
                    if (jArr != null) {
                        measuredWidth = (int) jArr[i11];
                    }
                    int measuredHeight = viewC.getMeasuredHeight();
                    long[] jArr2 = this.f836e;
                    if (jArr2 != null) {
                        measuredHeight = m(jArr2[i11]);
                    }
                    if (this.f833b[i11] || flexItem.v() <= 0.0f) {
                        i7 = i12;
                    } else {
                        float fV = measuredWidth - (flexItem.v() * f4);
                        i7 = i12;
                        if (i7 == bVar.f828h - 1) {
                            fV += f5;
                            f5 = 0.0f;
                        }
                        int iRound = Math.round(fV);
                        if (iRound < flexItem.w()) {
                            iW = flexItem.w();
                            this.f833b[i11] = true;
                            bVar.f831k -= flexItem.v();
                            z2 = true;
                        } else {
                            float f6 = (fV - iRound) + f5;
                            double d2 = f6;
                            if (d2 > 1.0d) {
                                iRound++;
                                f6 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound--;
                                f6 += 1.0f;
                            }
                            f5 = f6;
                            iW = iRound;
                        }
                        int iN = n(i3, flexItem, bVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iW, BasicMeasure.EXACTLY);
                        viewC.measure(iMakeMeasureSpec, iN);
                        int measuredWidth2 = viewC.getMeasuredWidth();
                        int measuredHeight2 = viewC.getMeasuredHeight();
                        B(i11, iMakeMeasureSpec, iN, viewC);
                        this.a.e(i11, viewC);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i10, this.a.j(viewC) + flexItem.x() + flexItem.A() + measuredHeight);
                    bVar.f825e = flexItem.G() + flexItem.y() + measuredWidth + bVar.f825e;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewC.getMeasuredHeight();
                    long[] jArr3 = this.f836e;
                    if (jArr3 != null) {
                        measuredHeight3 = m(jArr3[i11]);
                    }
                    int measuredWidth3 = viewC.getMeasuredWidth();
                    long[] jArr4 = this.f836e;
                    if (jArr4 != null) {
                        measuredWidth3 = (int) jArr4[i11];
                    }
                    if (this.f833b[i11] || flexItem.v() <= f3) {
                        i6 = i8;
                        i7 = i9;
                    } else {
                        float fV2 = measuredHeight3 - (flexItem.v() * f4);
                        if (i9 == bVar.f828h - 1) {
                            fV2 += f5;
                            f5 = 0.0f;
                        }
                        int iRound2 = Math.round(fV2);
                        if (iRound2 < flexItem.I()) {
                            int I = flexItem.I();
                            this.f833b[i11] = true;
                            bVar.f831k -= flexItem.v();
                            i7 = i9;
                            iRound2 = I;
                            z2 = true;
                            i6 = i8;
                        } else {
                            float f7 = (fV2 - iRound2) + f5;
                            i6 = i8;
                            i7 = i9;
                            double d3 = f7;
                            if (d3 > 1.0d) {
                                iRound2++;
                                f7 -= 1.0f;
                            } else if (d3 < -1.0d) {
                                iRound2--;
                                f7 += 1.0f;
                            }
                            f5 = f7;
                        }
                        int iO = o(i2, flexItem, bVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewC.measure(iO, iMakeMeasureSpec2);
                        measuredWidth3 = viewC.getMeasuredWidth();
                        int measuredHeight4 = viewC.getMeasuredHeight();
                        B(i11, iO, iMakeMeasureSpec2, viewC);
                        this.a.e(i11, viewC);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i10, this.a.j(viewC) + flexItem.G() + flexItem.y() + measuredWidth3);
                    bVar.f825e = flexItem.x() + flexItem.A() + measuredHeight3 + bVar.f825e;
                }
                bVar.f827g = Math.max(bVar.f827g, iMax);
                i10 = iMax;
            }
            i9 = i7 + 1;
            i8 = i6;
            f3 = 0.0f;
        }
        int i13 = i8;
        if (!z2 || i13 == bVar.f825e) {
            return;
        }
        w(i2, i3, bVar, i4, i5, true);
    }

    public final int[] x(int i2, List<C0038c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i2];
        int i3 = 0;
        for (C0038c c0038c : list) {
            int i4 = c0038c.a;
            iArr[i3] = i4;
            sparseIntArray.append(i4, c0038c.f838b);
            i3++;
        }
        return iArr;
    }

    public final void y(View view, int i2, int i3) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i2 - flexItem.y()) - flexItem.G()) - this.a.j(view), flexItem.w()), flexItem.M());
        long[] jArr = this.f836e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? m(jArr[i3]) : view.getMeasuredHeight(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        B(i3, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.a.e(i3, view);
    }

    public final void z(View view, int i2, int i3) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i2 - flexItem.A()) - flexItem.x()) - this.a.j(view), flexItem.I()), flexItem.K());
        long[] jArr = this.f836e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? (int) jArr[i3] : view.getMeasuredWidth(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        B(i3, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.a.e(i3, view);
    }
}
