package e.a.a.g.b;

import android.text.TextUtils;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.ui.association.ImportBookSourceViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.association.ImportBookSourceViewModel$importSelect$1", f = "ImportBookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class v extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ ImportBookSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(ImportBookSourceViewModel importBookSourceViewModel, f.z.d<? super v> dVar) {
        super(2, dVar);
        this.this$0 = importBookSourceViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new v(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((v) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Boolean boolValueOf;
        Boolean boolValueOf2;
        Boolean boolValueOf3;
        Boolean boolValueOf4;
        Boolean boolValueOf5;
        Boolean boolValueOf6;
        Boolean boolValueOf7;
        Boolean boolValueOf8;
        Boolean boolValueOf9;
        Boolean boolValueOf10;
        Boolean boolValueOf11;
        Boolean boolValueOf12;
        Boolean boolValueOf13;
        BookSource bookSource;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        boolean zG = e.a.a.d.e.a.g();
        ArrayList arrayList = new ArrayList();
        ImportBookSourceViewModel importBookSourceViewModel = this.this$0;
        int i2 = 0;
        for (Object obj2 : importBookSourceViewModel.selectStatus) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                f.x.e.D();
                throw null;
            }
            Integer num = new Integer(i2);
            boolean zBooleanValue = ((Boolean) obj2).booleanValue();
            int iIntValue = num.intValue();
            if (zBooleanValue) {
                BookSource bookSource2 = importBookSourceViewModel.allSources.get(iIntValue);
                f.c0.c.j.d(bookSource2, "allSources[index]");
                BookSource bookSource3 = bookSource2;
                String str = importBookSourceViewModel.groupName;
                if (str != null) {
                    bookSource3.setBookSourceGroup(str);
                }
                if (zG && (bookSource = importBookSourceViewModel.checkSources.get(iIntValue)) != null) {
                    bookSource3.setBookSourceName(bookSource.getBookSourceName());
                    bookSource3.setBookSourceGroup(bookSource.getBookSourceGroup());
                    bookSource3.setCustomOrder(bookSource.getCustomOrder());
                }
                if (!TextUtils.isEmpty(bookSource3.getBookSourceGroup())) {
                    String bookSourceGroup = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup == null || (boolValueOf13 = Boolean.valueOf(f.h0.k.d(bookSourceGroup, "🔞", false, 2))) == null) ? false : boolValueOf13.booleanValue()) {
                        bookSource3.setBookSourceGroup("违规");
                    }
                    String bookSourceGroup2 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup2 == null || (boolValueOf12 = Boolean.valueOf(f.h0.k.d(bookSourceGroup2, "💰", false, 2))) == null) ? false : boolValueOf12.booleanValue()) {
                        String bookSourceGroup3 = bookSource3.getBookSourceGroup();
                        if ((bookSourceGroup3 == null || (boolValueOf11 = Boolean.valueOf(f.h0.k.d(bookSourceGroup3, "漫画", false, 2))) == null) ? false : boolValueOf11.booleanValue()) {
                            bookSource3.setBookSourceGroup("收费漫画");
                        } else {
                            bookSource3.setBookSourceGroup("收费");
                        }
                    }
                    String bookSourceGroup4 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup4 == null || (boolValueOf10 = Boolean.valueOf(f.h0.k.d(bookSourceGroup4, "漫画", false, 2))) == null) ? false : boolValueOf10.booleanValue()) {
                        bookSource3.setBookSourceGroup("漫画");
                    }
                    String bookSourceGroup5 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup5 == null || (boolValueOf9 = Boolean.valueOf(f.h0.k.d(bookSourceGroup5, "优质", false, 2))) == null) ? false : boolValueOf9.booleanValue()) {
                        if (f.h0.k.d(bookSource3.getBookSourceName(), "💗", false, 2)) {
                            bookSource3.setBookSourceGroup("女频");
                        } else {
                            bookSource3.setBookSourceGroup(f.c0.c.j.k("男频", new Integer((c.b.a.m.f.b(6).nextInt(100) % 6) + 1)));
                        }
                    }
                    String bookSourceGroup6 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup6 == null || (boolValueOf8 = Boolean.valueOf(f.h0.k.d(bookSourceGroup6, "精品", false, 2))) == null) ? false : boolValueOf8.booleanValue()) {
                        if (f.h0.k.d(bookSource3.getBookSourceName(), "💗", false, 2)) {
                            bookSource3.setBookSourceGroup("女频");
                        } else {
                            bookSource3.setBookSourceGroup(f.c0.c.j.k("男频", new Integer((c.b.a.m.f.b(6).nextInt(100) % 6) + 1)));
                        }
                    }
                    String bookSourceGroup7 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup7 == null || (boolValueOf7 = Boolean.valueOf(f.h0.k.d(bookSourceGroup7, "普通", false, 2))) == null) ? false : boolValueOf7.booleanValue()) {
                        if (f.h0.k.d(bookSource3.getBookSourceName(), "💗", false, 2)) {
                            bookSource3.setBookSourceGroup("女频");
                        } else {
                            bookSource3.setBookSourceGroup(f.c0.c.j.k("男频", new Integer((c.b.a.m.f.b(6).nextInt(100) % 6) + 1)));
                        }
                    }
                    String bookSourceGroup8 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup8 == null || (boolValueOf6 = Boolean.valueOf(f.h0.k.d(bookSourceGroup8, "有声", false, 2))) == null) ? false : boolValueOf6.booleanValue()) {
                        bookSource3.setBookSourceGroup("听书");
                    }
                    String bookSourceGroup9 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup9 == null || (boolValueOf5 = Boolean.valueOf(f.h0.k.d(bookSourceGroup9, "正版", false, 2))) == null) ? false : boolValueOf5.booleanValue()) {
                        bookSource3.setBookSourceGroup("正版");
                    }
                    String bookSourceGroup10 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup10 == null || (boolValueOf4 = Boolean.valueOf(f.h0.k.d(bookSourceGroup10, "轻说", false, 2))) == null) ? false : boolValueOf4.booleanValue()) {
                        bookSource3.setBookSourceGroup("女频");
                    }
                    String bookSourceGroup11 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup11 == null || (boolValueOf3 = Boolean.valueOf(f.h0.k.d(bookSourceGroup11, "轻小说", false, 2))) == null) ? false : boolValueOf3.booleanValue()) {
                        bookSource3.setBookSourceGroup("女频");
                    }
                    String bookSourceGroup12 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup12 == null || (boolValueOf2 = Boolean.valueOf(f.h0.k.d(bookSourceGroup12, "书耽", false, 2))) == null) ? false : boolValueOf2.booleanValue()) {
                        bookSource3.setBookSourceGroup("女频");
                    }
                    String bookSourceGroup13 = bookSource3.getBookSourceGroup();
                    if ((bookSourceGroup13 == null || (boolValueOf = Boolean.valueOf(f.h0.k.d(bookSourceGroup13, "出版", false, 2))) == null) ? false : boolValueOf.booleanValue()) {
                        bookSource3.setBookSourceGroup("传统文学");
                    }
                }
                if (!TextUtils.isEmpty(bookSource3.getBookSourceName())) {
                    bookSource3.setBookSourceName(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(f.h0.k.C(bookSource3.getBookSourceName(), "🎨 ", "", false, 4), "🎨", "", false, 4), " 💰", "", false, 4), "💰", "", false, 4), "🎉 ", "", false, 4), "🎉", "", false, 4), " 🔎", "", false, 4), "🔎", "", false, 4), "🎧 ", "", false, 4), "🎧", "", false, 4), " 👻", "", false, 4), "👻", "", false, 4), " 🔥", "", false, 4), "🔥", "", false, 4), " 🔞", "", false, 4), "🔞", "", false, 4), " 💡", "", false, 4), "💡", "", false, 4), "👍 ", "", false, 4), "👍", "", false, 4), " 💗", "", false, 4), "💗", "", false, 4), "📖 ", "", false, 4), "📖", "", false, 4), "📚 ", "", false, 4), "📚", "", false, 4), "🔰 ", "", false, 4), "🔰", "", false, 4), " 🚀", "", false, 4), "🚀", "", false, 4));
                }
                if (!TextUtils.isEmpty(bookSource3.getExploreUrl())) {
                    String exploreUrl = bookSource3.getExploreUrl();
                    bookSource3.setExploreUrl(exploreUrl == null ? null : f.h0.k.C(exploreUrl, "👻", "", false, 4));
                }
                arrayList.add(bookSource3);
            }
            i2 = i3;
        }
        e.a.a.d.s sVar = e.a.a.d.s.a;
        Object[] array = arrayList.toArray(new BookSource[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        BookSource[] bookSourceArr = (BookSource[]) array;
        BookSource[] bookSourceArr2 = (BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length);
        f.c0.c.j.e(bookSourceArr2, "bookSources");
        for (final BookSource bookSource4 : bookSourceArr2) {
            e.a.a.d.s sVar2 = e.a.a.d.s.a;
            if (e.a.a.d.s.a(bookSource4.getBookSourceUrl())) {
                e.a.a.d.s.f5556b.post(new Runnable() { // from class: e.a.a.d.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        BookSource bookSource5 = bookSource4;
                        f.c0.c.j.e(bookSource5, "$bookSource");
                        c.b.a.m.f.R5(k.d.a.h.g(), f.c0.c.j.k(bookSource5.getBookSourceName(), "是18+网址,禁止导入."));
                    }
                });
            } else {
                AppDatabaseKt.getAppDb().getBookSourceDao().insert(bookSource4);
            }
        }
        return f.v.a;
    }
}
