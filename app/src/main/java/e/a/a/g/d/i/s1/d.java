package e.a.a.g.d.i.s1;

import f.c0.b.q;
import f.c0.c.k;
import f.v;
import io.legado.app.ui.book.read.page.PageView;
import io.legado.app.ui.book.read.page.ReadView;

/* JADX INFO: compiled from: ReadView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends k implements q<Integer, Integer, Integer, v> {
    public final /* synthetic */ ReadView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ReadView readView) {
        super(3);
        this.this$0 = readView;
    }

    @Override // f.c0.b.q
    public /* bridge */ /* synthetic */ v invoke(Integer num, Integer num2, Integer num3) {
        invoke(num.intValue(), num2.intValue(), num3.intValue());
        return v.a;
    }

    public final void invoke(int i2, int i3, int i4) {
        ReadView readView = this.this$0;
        int i5 = readView.firstRelativePage;
        if (i2 > i5) {
            PageView curPage = readView.getCurPage();
            ReadView readView2 = this.this$0;
            curPage.f(readView2.firstRelativePage, readView2.firstLineIndex, readView2.firstCharIndex);
            this.this$0.getCurPage().e(i2, i3, i4);
            return;
        }
        if (i2 < i5) {
            PageView curPage2 = readView.getCurPage();
            ReadView readView3 = this.this$0;
            curPage2.e(readView3.firstRelativePage, readView3.firstLineIndex, readView3.firstCharIndex);
            this.this$0.getCurPage().f(i2, i3, i4);
            return;
        }
        int i6 = readView.firstLineIndex;
        if (i3 > i6) {
            PageView curPage3 = readView.getCurPage();
            ReadView readView4 = this.this$0;
            curPage3.f(readView4.firstRelativePage, readView4.firstLineIndex, readView4.firstCharIndex);
            this.this$0.getCurPage().e(i2, i3, i4);
            return;
        }
        if (i3 < i6) {
            PageView curPage4 = readView.getCurPage();
            ReadView readView5 = this.this$0;
            curPage4.e(readView5.firstRelativePage, readView5.firstLineIndex, readView5.firstCharIndex);
            this.this$0.getCurPage().f(i2, i3, i4);
            return;
        }
        if (i4 > readView.firstCharIndex) {
            PageView curPage5 = readView.getCurPage();
            ReadView readView6 = this.this$0;
            curPage5.f(readView6.firstRelativePage, readView6.firstLineIndex, readView6.firstCharIndex);
            this.this$0.getCurPage().e(i2, i3, i4);
            return;
        }
        PageView curPage6 = readView.getCurPage();
        ReadView readView7 = this.this$0;
        curPage6.e(readView7.firstRelativePage, readView7.firstLineIndex, readView7.firstCharIndex);
        this.this$0.getCurPage().f(i2, i3, i4);
    }
}
