package e.a.a.g.h.j;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import io.legado.app.databinding.ItemRssBinding;
import io.legado.app.ui.main.rss.RssFragment;
import io.legado.app.ui.rss.subscription.RuleSubActivity;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends k implements l<ViewGroup, ViewBinding> {
    public final /* synthetic */ RssFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(RssFragment rssFragment) {
        super(1);
        this.this$0 = rssFragment;
    }

    @Override // f.c0.b.l
    @NotNull
    public final ViewBinding invoke(@NotNull ViewGroup viewGroup) {
        j.e(viewGroup, "it");
        ItemRssBinding itemRssBindingA = ItemRssBinding.a(this.this$0.getLayoutInflater(), viewGroup, false);
        final RssFragment rssFragment = this.this$0;
        itemRssBindingA.f6830c.setText(R.string.rule_subscription);
        itemRssBindingA.f6829b.setImageResource(R.drawable.image_legado);
        itemRssBindingA.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.h.j.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RssFragment rssFragment2 = rssFragment;
                j.e(rssFragment2, "this$0");
                rssFragment2.startActivity(new Intent(rssFragment2.requireContext(), (Class<?>) RuleSubActivity.class));
            }
        });
        j.d(itemRssBindingA, "inflate(layoutInflater, it, false).apply {\n                tvName.setText(R.string.rule_subscription)\n                ivIcon.setImageResource(R.drawable.image_legado)\n                root.setOnClickListener {\n                    startActivity<RuleSubActivity>()\n                }\n            }");
        return itemRssBindingA;
    }
}
