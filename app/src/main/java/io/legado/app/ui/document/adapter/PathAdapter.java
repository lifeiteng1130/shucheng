package io.legado.app.ui.document.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.g.f.g.b;
import f.c0.c.j;
import f.h;
import f.h0.k;
import f.v;
import f.x.e;
import f.x.i;
import h.a.a.a.w;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemPathFilepickerBinding;
import io.legado.app.ui.document.adapter.PathAdapter;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PathAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lio/legado/app/ui/document/adapter/PathAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "", "Lio/legado/app/databinding/ItemPathFilepickerBinding;", "path", "Lf/v;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "Ljava/util/LinkedList;", ai.aA, "Ljava/util/LinkedList;", "paths", "Landroid/graphics/drawable/Drawable;", "j", "Landroid/graphics/drawable/Drawable;", "arrowIcon", "Lio/legado/app/ui/document/adapter/PathAdapter$a;", "h", "Lio/legado/app/ui/document/adapter/PathAdapter$a;", "getCallBack", "()Lio/legado/app/ui/document/adapter/PathAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/document/adapter/PathAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PathAdapter extends RecyclerAdapter<String, ItemPathFilepickerBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final PathAdapter f7383f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final String f7384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedList<String> paths;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public final Drawable arrowIcon;

    /* JADX INFO: compiled from: PathAdapter.kt */
    public interface a {
        void C(int i2);
    }

    static {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        j.d(absolutePath, "getExternalStorageDirectory().absolutePath");
        f7384g = absolutePath;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathAdapter(@NotNull Context context, @NotNull a aVar) {
        Throwable th;
        Bitmap bitmapDecodeByteArray;
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        this.paths = new LinkedList<>();
        byte[] bArr = b.f5846e;
        j.d(bArr, "getArrow()");
        j.e(bArr, "bytes");
        j.e(bArr, "bytes");
        if (!(bArr.length == 0)) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = null;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                try {
                    j.c(bitmapDecodeByteArray);
                    bitmapDecodeByteArray.setDensity(96);
                    h.m11constructorimpl(v.a);
                } catch (Throwable th2) {
                    th = th2;
                    h.m11constructorimpl(f.m1(th));
                }
            } catch (Throwable th3) {
                th = th3;
                bitmapDecodeByteArray = null;
            }
        } else {
            bitmapDecodeByteArray = null;
        }
        this.arrowIcon = bitmapDecodeByteArray != null ? new BitmapDrawable(Resources.getSystem(), bitmapDecodeByteArray) : null;
    }

    public final void A(@NotNull String path) {
        Collection collectionC;
        j.e(path, "path");
        String strC = k.C(path, f7384g, "", false, 4);
        this.paths.clear();
        if (!j.a(strC, w.DEFAULT_PATH_SEPARATOR) && !j.a(strC, "")) {
            String strSubstring = strC.substring(k.q(strC, w.DEFAULT_PATH_SEPARATOR, 0, false, 6) + 1);
            j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            List listF = k.F(strSubstring, new String[]{w.DEFAULT_PATH_SEPARATOR}, false, 0, 6);
            if (listF.isEmpty()) {
                collectionC = i.INSTANCE;
                Object[] array = collectionC.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array;
                Collections.addAll(this.paths, Arrays.copyOf(strArr, strArr.length));
            } else {
                ListIterator listIterator = listF.listIterator(listF.size());
                while (listIterator.hasPrevious()) {
                    if (!(((String) listIterator.previous()).length() == 0)) {
                        collectionC = e.C(listF, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                collectionC = i.INSTANCE;
                Object[] array2 = collectionC.toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr2 = (String[]) array2;
                Collections.addAll(this.paths, Arrays.copyOf(strArr2, strArr2.length));
            }
        }
        this.paths.addFirst("SD");
        x(this.paths);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, String str, List list, int i2) {
        ItemPathFilepickerBinding itemPathFilepickerBinding = (ItemPathFilepickerBinding) viewBinding;
        String str2 = str;
        j.e(itemViewHolder, "holder");
        j.e(itemPathFilepickerBinding, "binding");
        j.e(str2, "item");
        j.e(list, "payloads");
        itemPathFilepickerBinding.f6811c.setText(str2);
        itemPathFilepickerBinding.f6810b.setImageDrawable(this.arrowIcon);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_path_filepicker, viewGroup, false);
        int i2 = R.id.image_view;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image_view);
        if (imageView != null) {
            i2 = R.id.text_view;
            TextView textView = (TextView) viewInflate.findViewById(R.id.text_view);
            if (textView != null) {
                ItemPathFilepickerBinding itemPathFilepickerBinding = new ItemPathFilepickerBinding((LinearLayout) viewInflate, imageView, textView);
                j.d(itemPathFilepickerBinding, "inflate(inflater, parent, false)");
                return itemPathFilepickerBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemPathFilepickerBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.f.e.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PathAdapter pathAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                PathAdapter pathAdapter2 = PathAdapter.f7383f;
                j.e(pathAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                pathAdapter.callBack.C(itemViewHolder2.getLayoutPosition());
            }
        });
    }
}
