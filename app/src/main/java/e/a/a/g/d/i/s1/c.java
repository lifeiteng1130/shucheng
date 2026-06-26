package e.a.a.g.d.i.s1;

import e.a.a.g.d.i.s1.g.e;
import f.c0.b.q;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.ui.book.read.page.ReadView;
import java.util.ArrayList;

/* JADX INFO: compiled from: ReadView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends k implements q<Integer, Integer, Integer, v> {
    public final /* synthetic */ e $this_with;
    public final /* synthetic */ ReadView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ReadView readView, e eVar) {
        super(3);
        this.this$0 = readView;
        this.$this_with = eVar;
    }

    @Override // f.c0.b.q
    public /* bridge */ /* synthetic */ v invoke(Integer num, Integer num2, Integer num3) {
        invoke(num.intValue(), num2.intValue(), num3.intValue());
        return v.a;
    }

    public final void invoke(int i2, int i3, int i4) {
        int i5;
        int length;
        int length2;
        int i6;
        int i7;
        this.this$0.setTextSelected(true);
        ReadView readView = this.this$0;
        readView.firstRelativePage = i2;
        readView.firstLineIndex = i3;
        readView.firstCharIndex = i4;
        int i8 = i3 - 1;
        if (i8 > 0 && (i7 = i3 + 1) < this.$this_with.c()) {
            ArrayList<e.a.a.g.d.i.s1.g.d> arrayList = this.$this_with.f5783d;
            this.this$0.getBoundary().setText(arrayList.get(i8).a + arrayList.get(i3).a + arrayList.get(i7).a);
            int iFirst = this.this$0.getBoundary().first();
            int next = this.this$0.getBoundary().next();
            int length3 = this.$this_with.f5783d.get(i8).a.length() + i4;
            length2 = iFirst;
            int next2 = next;
            while (next2 != -1) {
                if (length2 <= length3 && length3 < next2) {
                    break;
                }
                int i9 = next2;
                next2 = this.this$0.getBoundary().next();
                length2 = i9;
            }
            if (length2 < this.$this_with.f5783d.get(i8).a.length()) {
                i6 = i8;
            } else {
                length2 -= this.$this_with.f5783d.get(i8).a.length();
                i6 = i3;
            }
            if (next2 > this.$this_with.f5783d.get(i3).a.length() + this.$this_with.f5783d.get(i8).a.length()) {
                length = (next2 - this.$this_with.f5783d.get(i8).a.length()) - this.$this_with.f5783d.get(i3).a.length();
                i3 = i6;
                i5 = i7;
            } else {
                length = (next2 - this.$this_with.f5783d.get(i8).a.length()) - 1;
                i5 = i3;
                i3 = i6;
            }
        } else if (i8 > 0) {
            ArrayList<e.a.a.g.d.i.s1.g.d> arrayList2 = this.$this_with.f5783d;
            this.this$0.getBoundary().setText(j.k(arrayList2.get(i8).a, arrayList2.get(i3).a));
            int iFirst2 = this.this$0.getBoundary().first();
            int next3 = this.this$0.getBoundary().next();
            int length4 = this.$this_with.f5783d.get(i8).a.length() + i4;
            length2 = iFirst2;
            int next4 = next3;
            while (next4 != -1) {
                if (length2 <= length4 && length4 < next4) {
                    break;
                }
                int i10 = next4;
                next4 = this.this$0.getBoundary().next();
                length2 = i10;
            }
            if (length2 < this.$this_with.f5783d.get(i8).a.length()) {
                i6 = i8;
            } else {
                length2 -= this.$this_with.f5783d.get(i8).a.length();
                i6 = i3;
            }
            length = (next4 - this.$this_with.f5783d.get(i8).a.length()) - 1;
            i5 = i3;
            i3 = i6;
        } else {
            i5 = i3 + 1;
            if (i5 < this.$this_with.c()) {
                ArrayList<e.a.a.g.d.i.s1.g.d> arrayList3 = this.$this_with.f5783d;
                this.this$0.getBoundary().setText(j.k(arrayList3.get(i3).a, arrayList3.get(i5).a));
                int iFirst3 = this.this$0.getBoundary().first();
                int next5 = this.this$0.getBoundary().next();
                while (next5 != -1) {
                    if (iFirst3 <= i4 && i4 < next5) {
                        break;
                    }
                    int i11 = next5;
                    next5 = this.this$0.getBoundary().next();
                    iFirst3 = i11;
                }
                if (next5 > this.$this_with.f5783d.get(i3).a.length()) {
                    length = next5 - this.$this_with.f5783d.get(i3).a.length();
                } else {
                    length = next5 - 1;
                    i5 = i3;
                }
                length2 = iFirst3;
            } else {
                this.this$0.getBoundary().setText(this.$this_with.f5783d.get(i3).a);
                int iFirst4 = this.this$0.getBoundary().first();
                int next6 = this.this$0.getBoundary().next();
                while (next6 != -1) {
                    if (iFirst4 <= i4 && i4 < next6) {
                        break;
                    }
                    int i12 = next6;
                    next6 = this.this$0.getBoundary().next();
                    iFirst4 = i12;
                }
                length = next6 - 1;
                length2 = iFirst4;
                i5 = i3;
            }
        }
        this.this$0.getCurPage().f(this.this$0.firstRelativePage, i3, length2);
        this.this$0.getCurPage().e(this.this$0.firstRelativePage, i5, length);
    }
}
