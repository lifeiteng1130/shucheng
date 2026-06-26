package io.legado.app.ui.document.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.e;
import e.a.a.g.f.g.b;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemFileFilepickerBinding;
import io.legado.app.ui.document.adapter.FileAdapter;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: FileAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b%\u0010&R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\fR(\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0006R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0015¨\u0006("}, d2 = {"Lio/legado/app/ui/document/adapter/FileAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Le/a/a/g/f/f/a;", "Lio/legado/app/databinding/ItemFileFilepickerBinding;", "Landroid/graphics/drawable/Drawable;", "k", "Landroid/graphics/drawable/Drawable;", "folderIcon", Constants.LANDSCAPE, "fileIcon", "", "n", OptRuntime.GeneratorState.resumptionPoint_TYPE, "disabledTextColor", ai.aA, "homeIcon", "m", "primaryTextColor", "", "<set-?>", "h", "Ljava/lang/String;", "getCurrentPath", "()Ljava/lang/String;", "currentPath", "Lio/legado/app/ui/document/adapter/FileAdapter$a;", "f", "Lio/legado/app/ui/document/adapter/FileAdapter$a;", "getCallBack", "()Lio/legado/app/ui/document/adapter/FileAdapter$a;", "callBack", "j", "upIcon", "g", "rootPath", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/document/adapter/FileAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FileAdapter extends RecyclerAdapter<e.a.a.g.f.f.a, ItemFileFilepickerBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String rootPath;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String currentPath;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public final Drawable homeIcon;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public final Drawable upIcon;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public final Drawable folderIcon;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public final Drawable fileIcon;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final int primaryTextColor;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final int disabledTextColor;

    /* JADX INFO: compiled from: FileAdapter.kt */
    public interface a {
        /* JADX INFO: renamed from: B */
        boolean getIsShowUpDir();

        /* JADX INFO: renamed from: M */
        boolean getIsShowHideDir();

        boolean f();

        void p(int i2);

        @Nullable
        /* JADX INFO: renamed from: u */
        String[] getAllowExtensions();

        /* JADX INFO: renamed from: w */
        boolean getIsShowHomeDir();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        e.a.a.g.f.g.a aVar2 = e.a.a.g.f.g.a.a;
        byte[] bArr = b.f5844c;
        j.d(bArr, "getHome()");
        this.homeIcon = aVar2.a(bArr);
        byte[] bArr2 = b.f5845d;
        j.d(bArr2, "getUpDir()");
        this.upIcon = aVar2.a(bArr2);
        byte[] bArr3 = b.f5843b;
        j.d(bArr3, "getFolder()");
        this.folderIcon = aVar2.a(bArr3);
        byte[] bArr4 = b.a;
        j.d(bArr4, "getFile()");
        this.fileIcon = aVar2.a(bArr4);
        e eVar = e.a;
        this.primaryTextColor = f.S2(context, !eVar.m());
        boolean z = !eVar.m();
        j.e(context, "<this>");
        this.disabledTextColor = z ? ContextCompat.getColor(context, R.color.primary_text_disabled_material_light) : ContextCompat.getColor(context, R.color.primary_text_disabled_material_dark);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    @Override // io.legado.app.base.adapter.RecyclerAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(io.legado.app.base.adapter.ItemViewHolder r3, androidx.viewbinding.ViewBinding r4, e.a.a.g.f.f.a r5, java.util.List r6, int r7) {
        /*
            r2 = this;
            io.legado.app.databinding.ItemFileFilepickerBinding r4 = (io.legado.app.databinding.ItemFileFilepickerBinding) r4
            e.a.a.g.f.f.a r5 = (e.a.a.g.f.f.a) r5
            java.lang.String r7 = "holder"
            f.c0.c.j.e(r3, r7)
            java.lang.String r3 = "binding"
            f.c0.c.j.e(r4, r3)
            java.lang.String r3 = "item"
            f.c0.c.j.e(r5, r3)
            java.lang.String r3 = "payloads"
            f.c0.c.j.e(r6, r3)
            android.widget.ImageView r3 = r4.f6782b
            android.graphics.drawable.Drawable r6 = r5.getIcon()
            r3.setImageDrawable(r6)
            android.widget.TextView r3 = r4.f6783c
            java.lang.String r6 = r5.getName()
            r3.setText(r6)
            boolean r3 = r5.isDirectory()
            if (r3 == 0) goto L38
            android.widget.TextView r3 = r4.f6783c
            int r4 = r2.primaryTextColor
            r3.setTextColor(r4)
            goto L9c
        L38:
            io.legado.app.ui.document.adapter.FileAdapter$a r3 = r2.callBack
            boolean r3 = r3.f()
            if (r3 == 0) goto L48
            android.widget.TextView r3 = r4.f6783c
            int r4 = r2.disabledTextColor
            r3.setTextColor(r4)
            goto L9c
        L48:
            io.legado.app.ui.document.adapter.FileAdapter$a r3 = r2.callBack
            java.lang.String[] r3 = r3.getAllowExtensions()
            if (r3 != 0) goto L52
            r3 = 0
            goto L93
        L52:
            int r6 = r3.length
            r7 = 0
            r0 = 1
            if (r6 != 0) goto L59
            r6 = 1
            goto L5a
        L59:
            r6 = 0
        L5a:
            if (r6 != 0) goto L8a
            java.lang.String r5 = r5.getPath()
            java.lang.String r6 = "pathOrUrl"
            f.c0.c.j.e(r5, r6)
            r6 = 46
            r1 = 6
            int r6 = f.h0.k.t(r5, r6, r7, r7, r1)
            if (r6 < 0) goto L79
            int r6 = r6 + r0
            java.lang.String r5 = r5.substring(r6)
            java.lang.String r6 = "(this as java.lang.String).substring(startIndex)"
            f.c0.c.j.d(r5, r6)
            goto L7b
        L79:
            java.lang.String r5 = "ext"
        L7b:
            boolean r3 = c.b.a.m.f.b1(r3, r5)
            if (r3 == 0) goto L82
            goto L8a
        L82:
            android.widget.TextView r3 = r4.f6783c
            int r5 = r2.disabledTextColor
            r3.setTextColor(r5)
            goto L91
        L8a:
            android.widget.TextView r3 = r4.f6783c
            int r5 = r2.primaryTextColor
            r3.setTextColor(r5)
        L91:
            f.v r3 = f.v.a
        L93:
            if (r3 != 0) goto L9c
            android.widget.TextView r3 = r4.f6783c
            int r4 = r2.primaryTextColor
            r3.setTextColor(r4)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.document.adapter.FileAdapter.i(io.legado.app.base.adapter.ItemViewHolder, androidx.viewbinding.ViewBinding, java.lang.Object, java.util.List, int):void");
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_file_filepicker, viewGroup, false);
        int i2 = R.id.image_view;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image_view);
        if (imageView != null) {
            i2 = R.id.text_view;
            TextView textView = (TextView) viewInflate.findViewById(R.id.text_view);
            if (textView != null) {
                ItemFileFilepickerBinding itemFileFilepickerBinding = new ItemFileFilepickerBinding((LinearLayout) viewInflate, imageView, textView);
                j.d(itemFileFilepickerBinding, "inflate(inflater, parent, false)");
                return itemFileFilepickerBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemFileFilepickerBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.f.e.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileAdapter fileAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(fileAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                fileAdapter.callBack.p(itemViewHolder2.getLayoutPosition());
            }
        });
    }
}
