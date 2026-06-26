package e.a.a.g.d.i.r1;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import io.legado.app.databinding.ItemBgImageBinding;
import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j2 extends f.c0.c.k implements f.c0.b.l<ViewGroup, ViewBinding> {
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(BgTextConfigDialog bgTextConfigDialog) {
        super(1);
        this.this$0 = bgTextConfigDialog;
    }

    @Override // f.c0.b.l
    @NotNull
    public final ViewBinding invoke(@NotNull ViewGroup viewGroup) {
        f.c0.c.j.e(viewGroup, "it");
        ItemBgImageBinding itemBgImageBindingA = ItemBgImageBinding.a(this.this$0.getLayoutInflater(), viewGroup, false);
        final BgTextConfigDialog bgTextConfigDialog = this.this$0;
        itemBgImageBindingA.f6743c.setTextColor(bgTextConfigDialog.secondaryTextColor);
        itemBgImageBindingA.f6743c.setText(bgTextConfigDialog.getString(R.string.select_image));
        itemBgImageBindingA.f6742b.setImageResource(R.drawable.ic_image);
        itemBgImageBindingA.f6742b.setColorFilter(bgTextConfigDialog.primaryTextColor);
        itemBgImageBindingA.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BgTextConfigDialog bgTextConfigDialog2 = bgTextConfigDialog;
                f.c0.c.j.e(bgTextConfigDialog2, "this$0");
                bgTextConfigDialog2.selectBgImage.launch("image/*");
            }
        });
        f.c0.c.j.d(itemBgImageBindingA, "inflate(layoutInflater, it, false).apply {\n                tvName.setTextColor(secondaryTextColor)\n                tvName.text = getString(R.string.select_image)\n                ivBg.setImageResource(R.drawable.ic_image)\n                ivBg.setColorFilter(primaryTextColor)\n                root.setOnClickListener {\n                    selectBgImage.launch(\"image/*\")\n                }\n            }");
        return itemBgImageBindingA;
    }
}
