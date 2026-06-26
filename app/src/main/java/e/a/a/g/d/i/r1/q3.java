package e.a.a.g.d.i.r1;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import io.legado.app.databinding.ItemReadStyleBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.ReadStyleDialog;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadStyleDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q3 extends f.c0.c.k implements f.c0.b.l<ViewGroup, ViewBinding> {
    public final /* synthetic */ int $textColor;
    public final /* synthetic */ ReadStyleDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q3(ReadStyleDialog readStyleDialog, int i2) {
        super(1);
        this.this$0 = readStyleDialog;
        this.$textColor = i2;
    }

    @Override // f.c0.b.l
    @NotNull
    public final ViewBinding invoke(@NotNull ViewGroup viewGroup) {
        f.c0.c.j.e(viewGroup, "it");
        ItemReadStyleBinding itemReadStyleBindingA = ItemReadStyleBinding.a(this.this$0.getLayoutInflater(), viewGroup, false);
        int i2 = this.$textColor;
        final ReadStyleDialog readStyleDialog = this.this$0;
        itemReadStyleBindingA.f6815b.setPadding(c.b.a.m.f.m2(6), c.b.a.m.f.m2(6), c.b.a.m.f.m2(6), c.b.a.m.f.m2(6));
        itemReadStyleBindingA.f6815b.setText(null);
        itemReadStyleBindingA.f6815b.setColorFilter(i2);
        itemReadStyleBindingA.f6815b.setBorderColor(i2);
        itemReadStyleBindingA.f6815b.setImageResource(R.drawable.ic_add);
        itemReadStyleBindingA.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadStyleDialog readStyleDialog2 = readStyleDialog;
                f.c0.c.j.e(readStyleDialog2, "this$0");
                ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
                readBookConfig.getConfigList().add(new ReadBookConfig.Config(null, null, null, null, 0, 0, 0, false, false, false, null, null, null, 0, 0, null, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 131071, null));
                ReadStyleDialog.Q(readStyleDialog2, f.x.e.m(readBookConfig.getConfigList()));
            }
        });
        f.c0.c.j.d(itemReadStyleBindingA, "inflate(layoutInflater, it, false).apply {\n                ivStyle.setPadding(6.dp, 6.dp, 6.dp, 6.dp)\n                ivStyle.setText(null)\n                ivStyle.setColorFilter(textColor)\n                ivStyle.borderColor = textColor\n                ivStyle.setImageResource(R.drawable.ic_add)\n                root.setOnClickListener {\n                    ReadBookConfig.configList.add(ReadBookConfig.Config())\n                    showBgTextConfig(ReadBookConfig.configList.lastIndex)\n                }\n            }");
        return itemReadStyleBindingA;
    }
}
