package io.legado.app.ui.book.local;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.h.b0;
import e.a.a.h.i;
import f.c0.c.j;
import f.h0.k;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemImportBookBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.book.local.ImportBookAdapter;
import io.legado.app.ui.widget.text.AccentBgTextView;
import io.wenyuange.app.release.R;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ImportBookAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001)B\u0017\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006R&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR2\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\t0\u001cj\b\u0012\u0004\u0012\u00020\t`\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006*"}, d2 = {"Lio/legado/app/ui/book/local/ImportBookAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Le/a/a/h/i;", "Lio/legado/app/databinding/ItemImportBookBinding;", "Lf/v;", ai.aC, "()V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", ai.aA, "Ljava/util/ArrayList;", "bookFileNames", "", "h", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getCheckableCount", "()I", "setCheckableCount", "(I)V", "checkableCount", "Lio/legado/app/ui/book/local/ImportBookAdapter$a;", "f", "Lio/legado/app/ui/book/local/ImportBookAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/local/ImportBookAdapter$a;", "callBack", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "g", "Ljava/util/HashSet;", "getSelectedUris", "()Ljava/util/HashSet;", "setSelectedUris", "(Ljava/util/HashSet;)V", "selectedUris", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/local/ImportBookAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ImportBookAdapter extends RecyclerAdapter<i, ItemImportBookBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public HashSet<String> selectedUris;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int checkableCount;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public ArrayList<String> bookFileNames;

    /* JADX INFO: compiled from: ImportBookAdapter.kt */
    public interface a {
        void T(@NotNull Uri uri);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportBookAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        this.selectedUris = new HashSet<>();
        this.bookFileNames = new ArrayList<>();
    }

    public final void A() {
        this.checkableCount = 0;
        for (i iVar : this.items) {
            if (!iVar.a() && !this.bookFileNames.contains(iVar.a)) {
                this.checkableCount++;
            }
        }
        this.callBack.b();
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, i iVar, List list, int i2) {
        String str;
        ItemImportBookBinding itemImportBookBinding = (ItemImportBookBinding) viewBinding;
        i iVar2 = iVar;
        j.e(itemViewHolder, "holder");
        j.e(itemImportBookBinding, "binding");
        j.e(iVar2, "item");
        j.e(list, "payloads");
        if (!list.isEmpty()) {
            itemImportBookBinding.f6802b.setChecked(this.selectedUris.contains(iVar2.f5957e.toString()));
            return;
        }
        if (iVar2.a()) {
            itemImportBookBinding.f6803c.setImageResource(R.drawable.ic_folder);
            AppCompatImageView appCompatImageView = itemImportBookBinding.f6803c;
            j.d(appCompatImageView, "ivIcon");
            f.c6(appCompatImageView);
            ATECheckBox aTECheckBox = itemImportBookBinding.f6802b;
            j.d(aTECheckBox, "cbSelect");
            f.l3(aTECheckBox);
            LinearLayout linearLayout = itemImportBookBinding.f6804d;
            j.d(linearLayout, "llBrief");
            f.e3(linearLayout);
            itemImportBookBinding.f6802b.setChecked(false);
        } else {
            if (this.bookFileNames.contains(iVar2.a)) {
                itemImportBookBinding.f6803c.setImageResource(R.drawable.ic_book_has);
                AppCompatImageView appCompatImageView2 = itemImportBookBinding.f6803c;
                j.d(appCompatImageView2, "ivIcon");
                f.c6(appCompatImageView2);
                ATECheckBox aTECheckBox2 = itemImportBookBinding.f6802b;
                j.d(aTECheckBox2, "cbSelect");
                f.l3(aTECheckBox2);
            } else {
                AppCompatImageView appCompatImageView3 = itemImportBookBinding.f6803c;
                j.d(appCompatImageView3, "ivIcon");
                f.l3(appCompatImageView3);
                ATECheckBox aTECheckBox3 = itemImportBookBinding.f6802b;
                j.d(aTECheckBox3, "cbSelect");
                f.c6(aTECheckBox3);
            }
            LinearLayout linearLayout2 = itemImportBookBinding.f6804d;
            j.d(linearLayout2, "llBrief");
            f.c6(linearLayout2);
            itemImportBookBinding.f6808h.setText(k.O(iVar2.a, ".", null, 2));
            TextView textView = itemImportBookBinding.f6807g;
            b0 b0Var = b0.a;
            long j2 = iVar2.f5955c;
            if (j2 <= 0) {
                str = "0";
            } else {
                String[] strArr = {"b", "kb", "M", "G", ExifInterface.GPS_DIRECTION_TRUE};
                double d2 = j2;
                int iLog10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
                str = new DecimalFormat("#,##0.##").format(d2 / Math.pow(1024.0d, iLog10)) + ' ' + strArr[iLog10];
            }
            textView.setText(str);
            TextView textView2 = itemImportBookBinding.f6805e;
            e.a.a.c.c cVar = e.a.a.c.c.a;
            textView2.setText(((SimpleDateFormat) e.a.a.c.c.f5498d.getValue()).format(iVar2.f5956d));
            itemImportBookBinding.f6802b.setChecked(this.selectedUris.contains(iVar2.f5957e.toString()));
        }
        itemImportBookBinding.f6806f.setText(iVar2.a);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_import_book, viewGroup, false);
        int i2 = R.id.cb_select;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_select);
        if (aTECheckBox != null) {
            i2 = R.id.iv_icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_icon);
            if (appCompatImageView != null) {
                i2 = R.id.ll_brief;
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_brief);
                if (linearLayout != null) {
                    i2 = R.id.tv_date;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.tv_date);
                    if (textView != null) {
                        i2 = R.id.tv_name;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_name);
                        if (textView2 != null) {
                            i2 = R.id.tv_size;
                            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_size);
                            if (textView3 != null) {
                                i2 = R.id.tv_tag;
                                AccentBgTextView accentBgTextView = (AccentBgTextView) viewInflate.findViewById(R.id.tv_tag);
                                if (accentBgTextView != null) {
                                    ItemImportBookBinding itemImportBookBinding = new ItemImportBookBinding((LinearLayout) viewInflate, aTECheckBox, appCompatImageView, linearLayout, textView, textView2, textView3, accentBgTextView);
                                    j.d(itemImportBookBinding, "inflate(inflater, parent, false)");
                                    return itemImportBookBinding;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void v() {
        A();
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemImportBookBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.h.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImportBookAdapter importBookAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(importBookAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                e.a.a.h.i item = importBookAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                if (item.a()) {
                    importBookAdapter.callBack.T(item.f5957e);
                    return;
                }
                if (importBookAdapter.bookFileNames.contains(item.a)) {
                    return;
                }
                if (importBookAdapter.selectedUris.contains(item.f5957e.toString())) {
                    importBookAdapter.selectedUris.remove(item.f5957e.toString());
                } else {
                    importBookAdapter.selectedUris.add(item.f5957e.toString());
                }
                importBookAdapter.notifyItemChanged(itemViewHolder2.getLayoutPosition(), Boolean.TRUE);
                importBookAdapter.callBack.b();
            }
        });
    }
}
