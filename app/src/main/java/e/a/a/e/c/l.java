package e.a.a.e.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import f.v;
import io.legado.app.lib.permission.PermissionActivity;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements i {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public p f5637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ArrayList<String> f5638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public g f5639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public AlertDialog f5641g;

    /* JADX INFO: compiled from: Request.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<v> {
        public final /* synthetic */ String[] $deniedPermissions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String[] strArr) {
            super(0);
            this.$deniedPermissions = strArr;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            l.this.e(this.$deniedPermissions);
        }
    }

    public l(@NotNull AppCompatActivity appCompatActivity) {
        f.c0.c.j.e(appCompatActivity, "activity");
        this.f5636b = 1;
        this.f5637c = new e(appCompatActivity);
        this.f5638d = new ArrayList<>();
        this.a = System.currentTimeMillis();
    }

    @Override // e.a.a.e.c.i
    public void a(@NotNull String[] strArr, @NotNull int[] iArr) {
        p pVar;
        Context context;
        f.c0.c.j.e(strArr, "permissions");
        f.c0.c.j.e(iArr, "grantResults");
        String[] strArrD = d(strArr);
        if (strArrD == null) {
            f();
            return;
        }
        CharSequence text = null;
        if (this.f5640f != 0 && (pVar = this.f5637c) != null && (context = pVar.getContext()) != null) {
            text = context.getText(this.f5640f);
        }
        if (text != null) {
            g(text, new a(strArrD));
        } else {
            e(strArrD);
        }
    }

    @Override // e.a.a.e.c.i
    public void b() {
        String[] strArrC = c();
        if (strArrC == null) {
            f();
        } else {
            e(strArrC);
        }
    }

    public final String[] c() {
        String[] strArr;
        ArrayList<String> arrayList = this.f5638d;
        if (arrayList == null) {
            strArr = null;
        } else {
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            strArr = (String[]) array;
        }
        return d(strArr);
    }

    @Nullable
    public final String[] d(@Nullable String[] strArr) {
        Context context;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList();
            Iterator itI3 = c.b.a.m.f.I3(strArr);
            while (true) {
                f.c0.c.a aVar = (f.c0.c.a) itI3;
                if (!aVar.hasNext()) {
                    break;
                }
                String str = (String) aVar.next();
                p pVar = this.f5637c;
                Integer numValueOf = (pVar == null || (context = pVar.getContext()) == null) ? null : Integer.valueOf(ContextCompat.checkSelfPermission(context, str));
                if (numValueOf == null || numValueOf.intValue() != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                Object[] array = arrayList.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                return (String[]) array;
            }
        }
        return null;
    }

    public final void e(String[] strArr) {
        h hVar = o.f5646b;
        if (hVar == null) {
            return;
        }
        hVar.b(strArr);
    }

    public final void f() {
        try {
            g gVar = this.f5639e;
            if (gVar != null) {
                gVar.a();
            }
        } catch (Exception unused) {
        }
        h hVar = o.f5646b;
        if (hVar == null) {
            return;
        }
        hVar.a();
    }

    public final void g(CharSequence charSequence, final f.c0.b.a<v> aVar) {
        final Context context;
        Object objM11constructorimpl;
        AlertDialog alertDialog = this.f5641g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        p pVar = this.f5637c;
        if (pVar == null || (context = pVar.getContext()) == null) {
            return;
        }
        try {
            this.f5641g = new AlertDialog.Builder(context).setTitle(R.string.dialog_title).setMessage(charSequence).setPositiveButton(R.string.dialog_setting, new DialogInterface.OnClickListener() { // from class: e.a.a.e.c.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    Context context2 = context;
                    f.c0.c.j.e(context2, "$it");
                    Intent intent = new Intent(context2, (Class<?>) PermissionActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("KEY_INPUT_REQUEST_TYPE", 2);
                    context2.startActivity(intent);
                }
            }).setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: e.a.a.e.c.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    f.c0.b.a aVar2 = aVar;
                    f.c0.c.j.e(aVar2, "$cancel");
                    aVar2.invoke();
                }
            }).show();
            objM11constructorimpl = f.h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
        f.h.m10boximpl(objM11constructorimpl);
    }

    public l(@NotNull Fragment fragment) {
        f.c0.c.j.e(fragment, "fragment");
        this.f5636b = 1;
        this.f5637c = new f(fragment);
        this.f5638d = new ArrayList<>();
        this.a = System.currentTimeMillis();
    }
}
