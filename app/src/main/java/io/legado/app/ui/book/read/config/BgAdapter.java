package io.legado.app.ui.book.read.config;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import c.a.a.a.a;
import c.b.a.b;
import c.b.a.h;
import c.b.a.m.f;
import c.b.a.m.q.k;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemBgImageBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.BgAdapter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BgAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lio/legado/app/ui/book/read/config/BgAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "", "Lio/legado/app/databinding/ItemBgImageBinding;", "", "f", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getTextColor", "()I", "textColor", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BgAdapter extends RecyclerAdapter<String, ItemBgImageBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int textColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgAdapter(@NotNull Context context, int i2) {
        super(context);
        j.e(context, c.R);
        this.textColor = i2;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, String str, List list, int i2) throws IOException {
        ItemBgImageBinding itemBgImageBinding = (ItemBgImageBinding) viewBinding;
        String strSubstring = str;
        j.e(itemViewHolder, "holder");
        j.e(itemBgImageBinding, "binding");
        j.e(strSubstring, "item");
        j.e(list, "payloads");
        Context context = this.context;
        AssetManager assets = context.getAssets();
        StringBuilder sbR = a.r("bg");
        sbR.append((Object) File.separator);
        sbR.append(strSubstring);
        InputStream inputStreamOpen = assets.open(sbR.toString());
        j.d(inputStreamOpen, "context.assets.open(\"bg${File.separator}$item\")");
        byte[] bArrW4 = f.w4(inputStreamOpen);
        j.e(context, c.R);
        h<Drawable> hVarG = b.d(context).i().G(bArrW4);
        if (!hVarG.i(4)) {
            hVarG = hVarG.a(c.b.a.q.f.y(k.a));
        }
        if (!hVarG.i(256)) {
            if (c.b.a.q.f.A == null) {
                c.b.a.q.f fVarS = new c.b.a.q.f().s(true);
                fVarS.b();
                c.b.a.q.f.A = fVarS;
            }
            hVarG = hVarG.a(c.b.a.q.f.A);
        }
        j.d(hVarG, "with(context).load(bytes)");
        hVarG.c().E(itemBgImageBinding.f6742b);
        itemBgImageBinding.f6743c.setTextColor(this.textColor);
        TextView textView = itemBgImageBinding.f6743c;
        j.e(strSubstring, "$this$substringBeforeLast");
        j.e(".", "delimiter");
        j.e(strSubstring, "missingDelimiterValue");
        int iU = f.h0.k.u(strSubstring, ".", 0, false, 6);
        if (iU != -1) {
            strSubstring = strSubstring.substring(0, iU);
            j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        textView.setText(strSubstring);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemBgImageBinding itemBgImageBindingA = ItemBgImageBinding.a(this.inflater, viewGroup, false);
        j.d(itemBgImageBindingA, "inflate(inflater, parent, false)");
        return itemBgImageBindingA;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemBgImageBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BgAdapter bgAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bgAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                String strN = bgAdapter.n(itemViewHolder2.getLayoutPosition());
                if (strN == null) {
                    return;
                }
                ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
                readBookConfig.getDurConfig().setCurBg(1, strN);
                readBookConfig.upBg();
                LiveEventBus.get("upConfig").post(Boolean.FALSE);
            }
        });
    }
}
