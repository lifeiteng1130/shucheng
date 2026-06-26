package e.a.a.g.d.i;

import androidx.media2.session.MediaConstants;
import io.legado.app.ui.book.read.ReadBookActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBookActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ int $indexWithinChapter;
    public final /* synthetic */ ReadBookActivity this$0;

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<f.v> {
        public final /* synthetic */ Integer[] $positions;
        public final /* synthetic */ ReadBookActivity this$0;

        /* JADX INFO: renamed from: e.a.a.g.d.i.j0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ReadBookActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookActivity$skipToSearch$1$1$1", f = "ReadBookActivity.kt", i = {}, l = {920, 937}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0163a extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
            public final /* synthetic */ Integer[] $positions;
            public int label;
            public final /* synthetic */ ReadBookActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0163a(ReadBookActivity readBookActivity, Integer[] numArr, f.z.d<? super C0163a> dVar) {
                super(2, dVar);
                this.this$0 = readBookActivity;
                this.$positions = numArr;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new C0163a(this.this$0, this.$positions, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
                return ((C0163a) create(a0Var, dVar)).invokeSuspend(f.v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 == 0) {
                    c.b.a.m.f.E5(obj);
                    ReadBookActivity.Y0(this.this$0).f6486e.getCurPage().f(0, this.$positions[1].intValue(), this.$positions[2].intValue());
                    this.label = 1;
                    if (c.b.a.m.f.p1(20L, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        c.b.a.m.f.E5(obj);
                        return f.v.a;
                    }
                    c.b.a.m.f.E5(obj);
                }
                int iIntValue = this.$positions[3].intValue();
                if (iIntValue == -1) {
                    ReadBookActivity.Y0(this.this$0).f6486e.getCurPage().e(1, 0, this.$positions[4].intValue());
                } else if (iIntValue == 0) {
                    ReadBookActivity.Y0(this.this$0).f6486e.getCurPage().e(0, this.$positions[1].intValue(), (this.this$0.T0().searchContentQuery.length() + this.$positions[2].intValue()) - 1);
                } else if (iIntValue == 1) {
                    ReadBookActivity.Y0(this.this$0).f6486e.getCurPage().e(0, this.$positions[1].intValue() + 1, this.$positions[4].intValue());
                }
                ReadBookActivity.Y0(this.this$0).f6486e.setTextSelected(true);
                this.label = 2;
                if (c.b.a.m.f.p1(100L, this) == aVar) {
                    return aVar;
                }
                return f.v.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReadBookActivity readBookActivity, Integer[] numArr) {
            super(0);
            this.this$0 = readBookActivity;
            this.$positions = numArr;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ f.v invoke() {
            invoke2();
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ReadBookActivity readBookActivity = this.this$0;
            c.b.a.m.f.L3(readBookActivity, null, null, new C0163a(readBookActivity, this.$positions, null), 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(int i2, ReadBookActivity readBookActivity) {
        super(0);
        this.$indexWithinChapter = i2;
        this.this$0 = readBookActivity;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() throws IllegalAccessException, InvocationTargetException {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() throws IllegalAccessException, InvocationTargetException {
        int length;
        int i2;
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        e.a.a.g.d.i.s1.g.b bVar = e.a.a.f.s.k.f5686l;
        List<e.a.a.g.d.i.s1.g.e> list = bVar == null ? null : bVar.f5768d;
        if (list == null) {
            return;
        }
        int i3 = this.$indexWithinChapter;
        String str = this.this$0.T0().searchContentQuery;
        f.c0.c.j.e(list, com.umeng.analytics.pro.c.t);
        f.c0.c.j.e(str, MediaConstants.MEDIA_URI_QUERY_QUERY);
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
        Iterator<T> it = list.iterator();
        String strK = "";
        while (it.hasNext()) {
            strK = f.c0.c.j.k(strK, ((e.a.a.g.d.i.s1.g.e) it.next()).f5781b);
            arrayList.add(f.v.a);
        }
        int iQ = f.h0.k.q(strK, str, 0, false, 6);
        for (int i4 = 1; i4 != i3; i4++) {
            iQ = f.h0.k.q(strK, str, iQ + 1, false, 4);
        }
        int length2 = list.get(0).f5781b.length();
        int size = 0;
        while (true) {
            if (length2 >= iQ) {
                break;
            }
            size++;
            if (size > list.size()) {
                size = list.size();
                break;
            }
            length2 += list.get(size).f5781b.length();
        }
        e.a.a.g.d.i.s1.g.e eVar = list.get(size);
        int length3 = eVar.f5783d.get(0).a.length() + (length2 - eVar.f5781b.length());
        int size2 = 0;
        while (true) {
            if (length3 >= iQ) {
                break;
            }
            size2++;
            if (size2 > eVar.f5783d.size()) {
                size2 = eVar.f5783d.size();
                break;
            }
            length3 += eVar.f5783d.get(size2).a.length();
        }
        e.a.a.g.d.i.s1.g.d dVar = eVar.f5783d.get(size2);
        f.c0.c.j.d(dVar, "currentPage.textLines[lineIndex]");
        e.a.a.g.d.i.s1.g.d dVar2 = dVar;
        int length4 = iQ - (length3 - dVar2.a.length());
        if (str.length() + length4 > dVar2.a.length()) {
            length = ((str.length() + length4) - dVar2.a.length()) - 1;
            i2 = 1;
        } else {
            length = 0;
            i2 = 0;
        }
        if (size2 + i2 + 1 > eVar.f5783d.size()) {
            length = ((str.length() + length4) - dVar2.a.length()) - 1;
            i2 = -1;
        }
        Integer[] numArr = {Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(length4), Integer.valueOf(i2), Integer.valueOf(length)};
        e.a.a.f.s.k.a.s(numArr[0].intValue(), new a(this.this$0, numArr));
    }
}
