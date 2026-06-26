package io.legado.app.ui.book.cache;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.v;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.databinding.ItemDownloadBinding;
import io.legado.app.service.CacheBookService;
import io.legado.app.ui.book.cache.CacheAdapter;
import io.wenyuange.app.release.R;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b$\u0010%J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tRU\u0010\u0013\u001a>\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\fj\b\u0012\u0004\u0012\u00020\u000b`\r0\nj\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\fj\b\u0012\u0004\u0012\u00020\u000b`\r`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R6\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lio/legado/app/ui/book/cache/CacheAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/Book;", "Lio/legado/app/databinding/ItemDownloadBinding;", "Landroid/widget/ImageView;", "iv", "book", "Lf/v;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/widget/ImageView;Lio/legado/app/data/entities/Book;)V", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", "getCacheChapters", "()Ljava/util/HashMap;", "cacheChapters", "Lio/legado/app/ui/book/cache/CacheAdapter$a;", "f", "Lio/legado/app/ui/book/cache/CacheAdapter$a;", "callBack", "j$/util/concurrent/ConcurrentHashMap", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lio/legado/app/data/entities/BookChapter;", "h", "Lj$/util/concurrent/ConcurrentHashMap;", "getDownloadMap", "()Lj$/util/concurrent/ConcurrentHashMap;", "setDownloadMap", "(Lj$/util/concurrent/ConcurrentHashMap;)V", "downloadMap", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/cache/CacheAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class CacheAdapter extends RecyclerAdapter<Book, ItemDownloadBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashMap<String, HashSet<String>> cacheChapters;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> downloadMap;

    /* JADX INFO: compiled from: CacheAdapter.kt */
    public interface a {
        void F(int i2);

        void r0(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        this.cacheChapters = new HashMap<>();
    }

    public final void A(ImageView iv, Book book) {
        v vVar;
        ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> concurrentHashMap = this.downloadMap;
        if (concurrentHashMap == null) {
            vVar = null;
        } else {
            if (concurrentHashMap.containsKey(book.getBookUrl())) {
                iv.setImageResource(R.drawable.ic_stop_black_24dp);
            } else {
                iv.setImageResource(R.drawable.ic_play_24dp);
            }
            vVar = v.a;
        }
        if (vVar == null) {
            iv.setImageResource(R.drawable.ic_play_24dp);
        }
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, Book book, List list, int i2) {
        ItemDownloadBinding itemDownloadBinding = (ItemDownloadBinding) viewBinding;
        Book book2 = book;
        j.e(itemViewHolder, "holder");
        j.e(itemDownloadBinding, "binding");
        j.e(book2, "item");
        j.e(list, "payloads");
        if (!list.isEmpty()) {
            HashSet<String> hashSet = this.cacheChapters.get(book2.getBookUrl());
            itemDownloadBinding.f6779d.setText(this.context.getString(R.string.download_count, Integer.valueOf(hashSet == null ? 0 : hashSet.size()), Integer.valueOf(book2.getTotalChapterNum())));
            ImageView imageView = itemDownloadBinding.f6777b;
            j.d(imageView, "ivDownload");
            A(imageView, book2);
            return;
        }
        itemDownloadBinding.f6781f.setText(book2.getName());
        itemDownloadBinding.f6778c.setText(this.context.getString(R.string.author_show, book2.getRealAuthor()));
        HashSet<String> hashSet2 = this.cacheChapters.get(book2.getBookUrl());
        if (hashSet2 == null) {
            itemDownloadBinding.f6779d.setText(R.string.loading);
        } else {
            itemDownloadBinding.f6779d.setText(this.context.getString(R.string.download_count, Integer.valueOf(hashSet2.size()), Integer.valueOf(book2.getTotalChapterNum())));
        }
        ImageView imageView2 = itemDownloadBinding.f6777b;
        j.d(imageView2, "ivDownload");
        A(imageView2, book2);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_download, viewGroup, false);
        int i2 = R.id.iv_download;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_download);
        if (imageView != null) {
            i2 = R.id.tv_author;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_author);
            if (textView != null) {
                i2 = R.id.tv_download;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_download);
                if (textView2 != null) {
                    i2 = R.id.tv_export;
                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_export);
                    if (textView3 != null) {
                        i2 = R.id.tv_name;
                        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_name);
                        if (textView4 != null) {
                            ItemDownloadBinding itemDownloadBinding = new ItemDownloadBinding((ConstraintLayout) viewInflate, imageView, textView, textView2, textView3, textView4);
                            j.d(itemDownloadBinding, "inflate(inflater, parent, false)");
                            return itemDownloadBinding;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        ItemDownloadBinding itemDownloadBinding = (ItemDownloadBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemDownloadBinding, "binding");
        itemDownloadBinding.f6777b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.b.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CacheAdapter cacheAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(cacheAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                Book item = cacheAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> concurrentHashMap = cacheAdapter.downloadMap;
                if (!f.c0.c.j.a(concurrentHashMap == null ? null : Boolean.valueOf(concurrentHashMap.containsKey(item.getBookUrl())), Boolean.TRUE)) {
                    cacheAdapter.callBack.F(itemViewHolder2.getLayoutPosition());
                    e.a.a.f.s.h.a.c(cacheAdapter.context, item.getBookUrl(), 0, item.getTotalChapterNum());
                    return;
                }
                e.a.a.f.s.h hVar = e.a.a.f.s.h.a;
                Context context = cacheAdapter.context;
                String bookUrl = item.getBookUrl();
                f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
                f.c0.c.j.e(bookUrl, "bookUrl");
                Intent intent = new Intent(context, (Class<?>) CacheBookService.class);
                intent.setAction("remove");
                intent.putExtra("bookUrl", bookUrl);
                context.startService(intent);
            }
        });
        itemDownloadBinding.f6780e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.b.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CacheAdapter cacheAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(cacheAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                cacheAdapter.callBack.r0(itemViewHolder2.getLayoutPosition());
            }
        });
    }
}
