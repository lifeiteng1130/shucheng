package c.e.a.a;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: FlexContainer.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    void a(View view, int i2, int i3, b bVar);

    void b(b bVar);

    View c(int i2);

    int d(int i2, int i3, int i4);

    void e(int i2, View view);

    View f(int i2);

    int g(View view, int i2, int i3);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<b> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int h(int i2, int i3, int i4);

    boolean i();

    int j(View view);

    void setFlexLines(List<b> list);
}
