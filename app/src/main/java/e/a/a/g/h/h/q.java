package e.a.a.g.h.h;

import android.view.LayoutInflater;
import android.view.View;
import com.google.android.flexbox.FlexboxLayout;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.ItemFilletTextBinding;
import io.legado.app.databinding.ItemFindBookBinding;
import io.legado.app.ui.main.explore.ExploreAdapter;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExploreAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.explore.ExploreAdapter$convert$1$2", f = "ExploreAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class q extends f.z.j.a.g implements f.c0.b.q<a0, ArrayList<BookSource.ExploreKind>, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookSource $item;
    public final /* synthetic */ ItemFindBookBinding $this_with;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ExploreAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(ItemFindBookBinding itemFindBookBinding, ExploreAdapter exploreAdapter, BookSource bookSource, f.z.d<? super q> dVar) {
        super(3, dVar);
        this.$this_with = itemFindBookBinding;
        this.this$0 = exploreAdapter;
        this.$item = bookSource;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull ArrayList<BookSource.ExploreKind> arrayList, @Nullable f.z.d<? super v> dVar) {
        q qVar = new q(this.$this_with, this.this$0, this.$item, dVar);
        qVar.L$0 = arrayList;
        return qVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList<BookSource.ExploreKind> arrayList = (ArrayList) this.L$0;
        if (!(arrayList == null || arrayList.isEmpty())) {
            FlexboxLayout flexboxLayout = this.$this_with.f6785b;
            f.c0.c.j.d(flexboxLayout, "glChild");
            c.b.a.m.f.c6(flexboxLayout);
            this.$this_with.f6785b.removeAllViews();
            final ExploreAdapter exploreAdapter = this.this$0;
            ItemFindBookBinding itemFindBookBinding = this.$this_with;
            final BookSource bookSource = this.$item;
            ArrayList arrayList2 = new ArrayList(c.b.a.m.f.S0(arrayList, 10));
            for (final BookSource.ExploreKind exploreKind : arrayList) {
                ItemFilletTextBinding itemFilletTextBindingA = ItemFilletTextBinding.a(LayoutInflater.from(exploreAdapter.context), itemFindBookBinding.f6785b, false);
                f.c0.c.j.d(itemFilletTextBindingA, "inflate(\n                                LayoutInflater.from(context),\n                                glChild,\n                                false\n                            )");
                itemFindBookBinding.f6785b.addView(itemFilletTextBindingA.a);
                itemFilletTextBindingA.f6784b.setText(exploreKind.getTitle());
                String url = exploreKind.getUrl();
                if (!(url == null || url.length() == 0)) {
                    itemFilletTextBindingA.f6784b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.h.h.l
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ExploreAdapter exploreAdapter2 = exploreAdapter;
                            BookSource bookSource2 = bookSource;
                            BookSource.ExploreKind exploreKind2 = exploreKind;
                            exploreAdapter2.callBack.G(bookSource2.getBookSourceUrl(), exploreKind2.getTitle(), String.valueOf(exploreKind2.getUrl()));
                        }
                    });
                }
                arrayList2.add(v.a);
            }
        }
        return v.a;
    }
}
