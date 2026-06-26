package io.legado.app.ui.widget.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.h.a0;
import e.a.a.h.i;
import f.c0.c.j;
import f.h;
import f.h0.k;
import f.v;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemFontBinding;
import io.legado.app.ui.widget.font.FontAdapter;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.FileDescriptor;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/legado/app/ui/widget/font/FontAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Le/a/a/h/i;", "Lio/legado/app/databinding/ItemFontBinding;", "Lio/legado/app/ui/widget/font/FontAdapter$a;", "f", "Lio/legado/app/ui/widget/font/FontAdapter$a;", "getCallBack", "()Lio/legado/app/ui/widget/font/FontAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/widget/font/FontAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FontAdapter extends RecyclerAdapter<i, ItemFontBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: FontAdapter.kt */
    public interface a {
        @NotNull
        String b();

        void e(@NotNull i iVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, i iVar, List list, int i2) throws UnsupportedEncodingException {
        Object objM11constructorimpl;
        Typeface typefaceCreateFromFile;
        FileDescriptor fileDescriptor;
        ItemFontBinding itemFontBinding = (ItemFontBinding) viewBinding;
        final i iVar2 = iVar;
        j.e(itemViewHolder, "holder");
        j.e(itemFontBinding, "binding");
        j.e(iVar2, "item");
        j.e(list, "payloads");
        try {
            if (!f.s3(iVar2.f5957e)) {
                typefaceCreateFromFile = Typeface.createFromFile(iVar2.f5957e.toString());
            } else if (Build.VERSION.SDK_INT >= 26) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.context.getContentResolver().openFileDescriptor(iVar2.f5957e, "r");
                typefaceCreateFromFile = (parcelFileDescriptorOpenFileDescriptor == null || (fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()) == null) ? null : new Typeface.Builder(fileDescriptor).build();
            } else {
                typefaceCreateFromFile = Typeface.createFromFile(a0.b(this.context, iVar2.f5957e));
            }
            itemFontBinding.f6791c.setTypeface(typefaceCreateFromFile);
            objM11constructorimpl = h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            objM11constructorimpl = h.m11constructorimpl(f.m1(th));
        }
        Throwable thM14exceptionOrNullimpl = h.m14exceptionOrNullimpl(objM11constructorimpl);
        if (thM14exceptionOrNullimpl != null) {
            thM14exceptionOrNullimpl.printStackTrace();
            Context context = this.context;
            StringBuilder sbR = c.a.a.a.a.r("Read ");
            sbR.append(iVar2.a);
            sbR.append(" Error: ");
            sbR.append((Object) thM14exceptionOrNullimpl.getLocalizedMessage());
            f.R5(context, sbR.toString());
        }
        itemFontBinding.f6791c.setText(iVar2.a);
        itemFontBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.l.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FontAdapter fontAdapter = this.a;
                e.a.a.h.i iVar3 = iVar2;
                j.e(fontAdapter, "this$0");
                j.e(iVar3, "$item");
                fontAdapter.callBack.e(iVar3);
            }
        });
        String str = iVar2.a;
        String strDecode = URLDecoder.decode(this.callBack.b(), "utf-8");
        j.d(strDecode, "decode(callBack.curFilePath, \"utf-8\")");
        String str2 = File.separator;
        j.d(str2, "separator");
        if (j.a(str, k.O(strDecode, str2, null, 2))) {
            AppCompatImageView appCompatImageView = itemFontBinding.f6790b;
            j.d(appCompatImageView, "ivChecked");
            f.c6(appCompatImageView);
        } else {
            AppCompatImageView appCompatImageView2 = itemFontBinding.f6790b;
            j.d(appCompatImageView2, "ivChecked");
            f.l3(appCompatImageView2);
        }
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_font, viewGroup, false);
        int i2 = R.id.iv_checked;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_checked);
        if (appCompatImageView != null) {
            i2 = R.id.tv_font;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_font);
            if (textView != null) {
                ItemFontBinding itemFontBinding = new ItemFontBinding((LinearLayout) viewInflate, appCompatImageView, textView);
                j.d(itemFontBinding, "inflate(inflater, parent, false)");
                return itemFontBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemFontBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.l.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FontAdapter fontAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(fontAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                e.a.a.h.i item = fontAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                fontAdapter.callBack.e(item);
            }
        });
    }
}
