package io.legado.app.ui.widget.recycler;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import f.c0.b.a;
import f.c0.c.j;
import f.c0.c.k;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DragSelectTouchHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DragSelectTouchHelper$mOnItemTouchListener$2 extends k implements a<AnonymousClass1> {
    public final /* synthetic */ DragSelectTouchHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragSelectTouchHelper$mOnItemTouchListener$2(DragSelectTouchHelper dragSelectTouchHelper) {
        super(0);
        this.this$0 = dragSelectTouchHelper;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v0, types: [io.legado.app.ui.widget.recycler.DragSelectTouchHelper$mOnItemTouchListener$2$1] */
    @Override // f.c0.b.a
    @NotNull
    public final AnonymousClass1 invoke() {
        final DragSelectTouchHelper dragSelectTouchHelper = this.this$0;
        return new RecyclerView.OnItemTouchListener() { // from class: io.legado.app.ui.widget.recycler.DragSelectTouchHelper$mOnItemTouchListener$2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(@NotNull RecyclerView rv, @NotNull MotionEvent e2) {
                j.e(rv, "rv");
                j.e(e2, "e");
                j.e("onInterceptTouchEvent: x:" + e2.getX() + ",y:" + e2.getY() + ", " + ((Object) MotionEvent.actionToString(e2.getAction())), NotificationCompat.CATEGORY_MESSAGE);
                RecyclerView.Adapter adapter = rv.getAdapter();
                if (adapter != null && adapter.getItemCount() != 0) {
                    int action = e2.getAction() & 255;
                    if (action != 0) {
                        if (action == 1) {
                            DragSelectTouchHelper dragSelectTouchHelper2 = dragSelectTouchHelper;
                            int i2 = dragSelectTouchHelper2.t;
                            z = i2 == 16 || i2 == 17;
                            int i3 = dragSelectTouchHelper2.F;
                            if (i3 != -1) {
                                dragSelectTouchHelper2.h(i3);
                                dragSelectTouchHelper.F = -1;
                            }
                            DragSelectTouchHelper dragSelectTouchHelper3 = dragSelectTouchHelper;
                            if (dragSelectTouchHelper3.B != -1) {
                                dragSelectTouchHelper3.h(dragSelectTouchHelper3.C);
                            }
                        } else if (action == 2) {
                            int i4 = dragSelectTouchHelper.t;
                            if (i4 == 16 || i4 == 17) {
                                j.e("onInterceptTouchEvent: drag mode move", NotificationCompat.CATEGORY_MESSAGE);
                                z = true;
                            }
                        } else if (action == 3) {
                            DragSelectTouchHelper dragSelectTouchHelper4 = dragSelectTouchHelper;
                            int i5 = dragSelectTouchHelper4.F;
                            if (i5 != -1) {
                                dragSelectTouchHelper4.h(i5);
                                dragSelectTouchHelper.F = -1;
                            }
                            DragSelectTouchHelper dragSelectTouchHelper5 = dragSelectTouchHelper;
                            if (dragSelectTouchHelper5.B != -1) {
                                dragSelectTouchHelper5.h(dragSelectTouchHelper5.C);
                            }
                        }
                        j.e(j.k("intercept result: ", Boolean.valueOf(z)), NotificationCompat.CATEGORY_MESSAGE);
                    } else {
                        dragSelectTouchHelper.y = e2.getY();
                        DragSelectTouchHelper dragSelectTouchHelper6 = dragSelectTouchHelper;
                        if (dragSelectTouchHelper6.t == 1) {
                            float x = e2.getX();
                            if (x > dragSelectTouchHelper6.f7751d && x < dragSelectTouchHelper6.f7752e) {
                                DragSelectTouchHelper dragSelectTouchHelper7 = dragSelectTouchHelper;
                                Objects.requireNonNull(dragSelectTouchHelper7);
                                dragSelectTouchHelper7.F = dragSelectTouchHelper7.d(rv, e2.getX(), e2.getY());
                                DragSelectTouchHelper dragSelectTouchHelper8 = dragSelectTouchHelper;
                                int i6 = dragSelectTouchHelper8.F;
                                if (i6 != -1) {
                                    dragSelectTouchHelper8.f7749b.c(i6);
                                    dragSelectTouchHelper.G = true;
                                }
                                z = true;
                            }
                        }
                        j.e(j.k("intercept result: ", Boolean.valueOf(z)), NotificationCompat.CATEGORY_MESSAGE);
                    }
                }
                return z;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                if (disallowIntercept) {
                    DragSelectTouchHelper dragSelectTouchHelper2 = dragSelectTouchHelper;
                    if (dragSelectTouchHelper2.t != 0) {
                        dragSelectTouchHelper2.h(dragSelectTouchHelper2.C);
                    } else {
                        dragSelectTouchHelper2.h(-1);
                    }
                    DragSelectTouchHelper.d.a(dragSelectTouchHelper2.t, 0);
                    dragSelectTouchHelper2.t = 0;
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(@NotNull RecyclerView rv, @NotNull MotionEvent e2) {
                j.e(rv, "rv");
                j.e(e2, "e");
                if (dragSelectTouchHelper.t != 0) {
                    StringBuilder sbR = c.a.a.a.a.r("onTouchEvent: x:");
                    sbR.append(e2.getX());
                    sbR.append(",y:");
                    sbR.append(e2.getY());
                    sbR.append(", ");
                    sbR.append((Object) MotionEvent.actionToString(e2.getAction()));
                    j.e(sbR.toString(), NotificationCompat.CATEGORY_MESSAGE);
                    int action = e2.getAction() & 255;
                    if (action != 1) {
                        if (action == 2) {
                            DragSelectTouchHelper dragSelectTouchHelper2 = dragSelectTouchHelper;
                            int i2 = dragSelectTouchHelper2.F;
                            if (i2 != -1) {
                                dragSelectTouchHelper2.i(i2);
                                dragSelectTouchHelper.F = -1;
                                j.e("onTouchEvent: after slide mode down", NotificationCompat.CATEGORY_MESSAGE);
                            }
                            DragSelectTouchHelper dragSelectTouchHelper3 = dragSelectTouchHelper;
                            Objects.requireNonNull(dragSelectTouchHelper3);
                            float y = e2.getY();
                            float f2 = dragSelectTouchHelper3.o;
                            if ((y <= dragSelectTouchHelper3.p && f2 <= y) && y < dragSelectTouchHelper3.y) {
                                dragSelectTouchHelper3.z = e2.getX();
                                dragSelectTouchHelper3.A = e2.getY();
                                dragSelectTouchHelper3.x = (int) (dragSelectTouchHelper3.f7758k * ((y - dragSelectTouchHelper3.p) / dragSelectTouchHelper3.f7754g));
                                if (!dragSelectTouchHelper3.u) {
                                    dragSelectTouchHelper3.u = true;
                                    dragSelectTouchHelper3.k();
                                    dragSelectTouchHelper3.y = dragSelectTouchHelper3.p;
                                }
                            } else if (dragSelectTouchHelper3.f7756i && y < f2 && dragSelectTouchHelper3.u) {
                                dragSelectTouchHelper3.z = e2.getX();
                                dragSelectTouchHelper3.A = dragSelectTouchHelper3.o;
                                dragSelectTouchHelper3.x = dragSelectTouchHelper3.f7758k * (-1);
                                dragSelectTouchHelper3.k();
                            } else {
                                float f3 = dragSelectTouchHelper3.q;
                                float f4 = dragSelectTouchHelper3.r;
                                if ((y <= f4 && f3 <= y) && y > dragSelectTouchHelper3.y) {
                                    dragSelectTouchHelper3.z = e2.getX();
                                    dragSelectTouchHelper3.A = e2.getY();
                                    dragSelectTouchHelper3.x = (int) (dragSelectTouchHelper3.f7758k * ((y - dragSelectTouchHelper3.q) / dragSelectTouchHelper3.f7754g));
                                    if (!dragSelectTouchHelper3.v) {
                                        dragSelectTouchHelper3.v = true;
                                        dragSelectTouchHelper3.k();
                                        dragSelectTouchHelper3.y = dragSelectTouchHelper3.q;
                                    }
                                } else if (dragSelectTouchHelper3.f7757j && y > f4 && dragSelectTouchHelper3.v) {
                                    dragSelectTouchHelper3.z = e2.getX();
                                    dragSelectTouchHelper3.A = dragSelectTouchHelper3.r;
                                    dragSelectTouchHelper3.x = dragSelectTouchHelper3.f7758k;
                                    dragSelectTouchHelper3.k();
                                } else {
                                    dragSelectTouchHelper3.u = false;
                                    dragSelectTouchHelper3.v = false;
                                    dragSelectTouchHelper3.z = Float.MIN_VALUE;
                                    dragSelectTouchHelper3.A = Float.MIN_VALUE;
                                    dragSelectTouchHelper3.l();
                                }
                            }
                            DragSelectTouchHelper dragSelectTouchHelper4 = dragSelectTouchHelper;
                            if (dragSelectTouchHelper4.u || dragSelectTouchHelper4.v) {
                                return;
                            }
                            dragSelectTouchHelper4.m(rv, e2.getX(), e2.getY());
                            return;
                        }
                        if (action != 3) {
                            return;
                        }
                    }
                    DragSelectTouchHelper dragSelectTouchHelper5 = dragSelectTouchHelper;
                    dragSelectTouchHelper5.h(dragSelectTouchHelper5.C);
                }
            }
        };
    }
}
