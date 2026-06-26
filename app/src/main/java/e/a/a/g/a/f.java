package e.a.a.g.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.ui.about.AboutFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AboutFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends k implements l<e.a.a.e.a.h<? extends DialogInterface>, v> {
    public final /* synthetic */ AboutFragment this$0;

    /* JADX INFO: compiled from: AboutFragment.kt */
    public static final class a extends k implements p<DialogInterface, Integer, v> {
        public final /* synthetic */ ArrayList<String> $names;
        public final /* synthetic */ AboutFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AboutFragment aboutFragment, ArrayList<String> arrayList) {
            super(2);
            this.this$0 = aboutFragment;
            this.$names = arrayList;
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
            invoke(dialogInterface, num.intValue());
            return v.a;
        }

        public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
            boolean z;
            j.e(dialogInterface, "$noName_0");
            String str = this.this$0.qqGroups.get(this.$names.get(i2));
            if (str == null) {
                return;
            }
            AboutFragment aboutFragment = this.this$0;
            Objects.requireNonNull(aboutFragment);
            Intent intent = new Intent();
            intent.setData(Uri.parse(j.k("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D", str)));
            try {
                aboutFragment.startActivity(intent);
                z = true;
            } catch (Throwable th) {
                if (f.h.m14exceptionOrNullimpl(f.h.m11constructorimpl(c.b.a.m.f.m1(th))) != null) {
                    m.m(aboutFragment, "添加失败,请手动添加");
                }
                z = false;
            }
            if (z) {
                return;
            }
            Context contextRequireContext = aboutFragment.requireContext();
            j.d(contextRequireContext, "requireContext()");
            c.b.a.m.f.c5(contextRequireContext, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(AboutFragment aboutFragment) {
        super(1);
        this.this$0 = aboutFragment;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        j.e(hVar, "$this$alert");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = this.this$0.qqGroups.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        hVar.b(arrayList, new a(this.this$0, arrayList));
    }
}
