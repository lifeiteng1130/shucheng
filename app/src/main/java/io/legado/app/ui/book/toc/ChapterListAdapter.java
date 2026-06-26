package io.legado.app.ui.book.toc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.databinding.ItemChapterListBinding;
import io.legado.app.ui.book.toc.ChapterListAdapter;
import io.wenyuange.app.release.R;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ChapterListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR)\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lio/legado/app/ui/book/toc/ChapterListAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/BookChapter;", "Lio/legado/app/databinding/ItemChapterListBinding;", "binding", "", "isDur", "cached", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lio/legado/app/databinding/ItemChapterListBinding;ZZ)Lio/legado/app/databinding/ItemChapterListBinding;", "Lio/legado/app/ui/book/toc/ChapterListAdapter$a;", "f", "Lio/legado/app/ui/book/toc/ChapterListAdapter$a;", "getCallback", "()Lio/legado/app/ui/book/toc/ChapterListAdapter$a;", "callback", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "g", "Ljava/util/HashSet;", "getCacheFileNames", "()Ljava/util/HashSet;", "cacheFileNames", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/toc/ChapterListAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChapterListAdapter extends RecyclerAdapter<BookChapter, ItemChapterListBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callback;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashSet<String> cacheFileNames;

    /* JADX INFO: compiled from: ChapterListAdapter.kt */
    public interface a {
        void i(@NotNull BookChapter bookChapter);

        int n();

        boolean o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChapterListAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callback");
        this.callback = aVar;
        this.cacheFileNames = new HashSet<>();
    }

    public final ItemChapterListBinding A(ItemChapterListBinding binding, boolean isDur, boolean cached) {
        binding.f6773c.getPaint().setFakeBoldText(cached);
        binding.f6772b.setImageResource(R.drawable.ic_outline_cloud_24);
        ImageView imageView = binding.f6772b;
        j.d(imageView, "ivChecked");
        f.d6(imageView, !cached);
        if (isDur) {
            binding.f6772b.setImageResource(R.drawable.ic_check);
            ImageView imageView2 = binding.f6772b;
            j.d(imageView2, "ivChecked");
            f.c6(imageView2);
        }
        return binding;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, BookChapter bookChapter, List list, int i2) {
        ItemChapterListBinding itemChapterListBinding = (ItemChapterListBinding) viewBinding;
        BookChapter bookChapter2 = bookChapter;
        j.e(itemViewHolder, "holder");
        j.e(itemChapterListBinding, "binding");
        j.e(bookChapter2, "item");
        j.e(list, "payloads");
        boolean z = this.callback.n() == bookChapter2.getIndex();
        boolean z2 = this.callback.o() || this.cacheFileNames.contains(bookChapter2.getFileName());
        if (!list.isEmpty()) {
            A(itemChapterListBinding, z, z2);
            return;
        }
        if (z) {
            itemChapterListBinding.f6773c.setTextColor(f.M1(this.context));
        } else {
            itemChapterListBinding.f6773c.setTextColor(f.c2(this.context, R.color.primaryText));
        }
        itemChapterListBinding.f6773c.setText(bookChapter2.getTitle());
        String tag = bookChapter2.getTag();
        if (!(tag == null || tag.length() == 0)) {
            itemChapterListBinding.f6774d.setText(bookChapter2.getTag());
            TextView textView = itemChapterListBinding.f6774d;
            j.d(textView, "tvTag");
            f.c6(textView);
        }
        A(itemChapterListBinding, z, z2);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemChapterListBinding itemChapterListBindingA = ItemChapterListBinding.a(this.inflater, viewGroup, false);
        j.d(itemChapterListBindingA, "inflate(inflater, parent, false)");
        return itemChapterListBindingA;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemChapterListBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.m.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChapterListAdapter chapterListAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(chapterListAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                BookChapter item = chapterListAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                chapterListAdapter.callback.i(item);
            }
        });
    }
}
