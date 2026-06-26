package e.a.a.e.c;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.FocusMeteringAction;
import androidx.fragment.app.Fragment;
import f.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PermissionsCompat.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    @Nullable
    public l a;

    public k(f.c0.c.f fVar) {
    }

    /* JADX INFO: compiled from: PermissionsCompat.kt */
    public static final class a {

        @NotNull
        public final l a;

        /* JADX INFO: renamed from: e.a.a.e.c.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PermissionsCompat.kt */
        public static final class C0157a implements g {
            public final /* synthetic */ f.c0.b.a<v> a;

            public C0157a(f.c0.b.a<v> aVar) {
                this.a = aVar;
            }

            @Override // e.a.a.e.c.g
            public void a() {
                this.a.invoke();
            }
        }

        public a(@NotNull AppCompatActivity appCompatActivity) {
            f.c0.c.j.e(appCompatActivity, "activity");
            this.a = new l(appCompatActivity);
        }

        @NotNull
        public final a a(@NotNull String... strArr) {
            f.c0.c.j.e(strArr, "permissions");
            l lVar = this.a;
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            Objects.requireNonNull(lVar);
            f.c0.c.j.e(strArr2, "permissions");
            ArrayList<String> arrayList = lVar.f5638d;
            if (arrayList != null) {
                arrayList.addAll(f.x.e.u(Arrays.copyOf(strArr2, strArr2.length)));
            }
            return this;
        }

        @NotNull
        public final a b(@NotNull f.c0.b.a<v> aVar) {
            f.c0.c.j.e(aVar, "callback");
            l lVar = this.a;
            C0157a c0157a = new C0157a(aVar);
            Objects.requireNonNull(lVar);
            f.c0.c.j.e(c0157a, "callback");
            lVar.f5639e = c0157a;
            return this;
        }

        @NotNull
        public final a c(@StringRes int i2) {
            this.a.f5640f = i2;
            return this;
        }

        @NotNull
        public final k d() {
            k kVar = new k(null);
            l lVar = this.a;
            kVar.a = lVar;
            kVar.a = lVar;
            n nVar = n.a;
            if (lVar != null) {
                if (n.f5642b == null) {
                    n.f5642b = new Stack<>();
                }
                Stack<l> stack = n.f5642b;
                if (stack != null) {
                    int iIndexOf = stack.indexOf(lVar);
                    boolean z = true;
                    if (iIndexOf >= 0) {
                        int size = stack.size() - 1;
                        if (iIndexOf != size) {
                            Collections.swap(n.f5642b, iIndexOf, size);
                        }
                    } else {
                        stack.push(lVar);
                    }
                    if (!stack.empty()) {
                        l lVar2 = n.f5643c;
                        if (lVar2 != null && System.currentTimeMillis() - lVar2.a <= FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION) {
                            z = false;
                        }
                        if (z) {
                            n.f5643c = stack.pop();
                            n.f5644d.post(n.f5645e);
                        }
                    }
                }
            }
            return kVar;
        }

        public a(@NotNull Fragment fragment) {
            f.c0.c.j.e(fragment, "fragment");
            this.a = new l(fragment);
        }
    }
}
