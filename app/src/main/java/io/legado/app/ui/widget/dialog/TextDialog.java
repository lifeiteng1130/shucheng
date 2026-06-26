package io.legado.app.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.b.a.e;
import e.b.a.h;
import e.b.a.j;
import e.b.a.o;
import e.b.a.p.r;
import e.b.a.q.a.k;
import e.b.a.s.m.a;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.f0.h;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogTextViewBinding;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.legado.app.ui.widget.text.BadgeView;
import io.legado.app.ui.widget.text.InertiaScrollTextView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import k.c.c.m;
import k.c.c.n;
import k.c.d.s;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lio/legado/app/ui/widget/dialog/TextDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "f", "Z", "autoClose", "Lio/legado/app/databinding/DialogTextViewBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "Q", "()Lio/legado/app/databinding/DialogTextViewBinding;", "binding", "", "e", "J", "time", "<init>", "b", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TextDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new c());

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long time;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean autoClose;

    /* JADX INFO: renamed from: io.legado.app.ui.widget.dialog.TextDialog$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TextDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }

        public static void a(Companion companion, FragmentManager fragmentManager, String str, int i2, long j2, boolean z, int i3) {
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            if ((i3 & 8) != 0) {
                j2 = 0;
            }
            if ((i3 & 16) != 0) {
                z = false;
            }
            Objects.requireNonNull(companion);
            j.e(fragmentManager, "fragmentManager");
            TextDialog textDialog = new TextDialog();
            Bundle bundle = new Bundle();
            bundle.putString("content", str);
            bundle.putInt("mode", i2);
            bundle.putLong("time", j2);
            textDialog.setArguments(bundle);
            textDialog.setCancelable(false);
            textDialog.autoClose = z;
            textDialog.show(fragmentManager, "textDialog");
        }
    }

    /* JADX INFO: compiled from: TextDialog.kt */
    @DebugMetadata(c = "io.legado.app.ui.widget.dialog.TextDialog$onFragmentCreated$2", f = "TextDialog.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ View $view;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, d<? super b> dVar) {
            super(2, dVar);
            this.$view = view;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return TextDialog.this.new b(this.$view, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002c -> B:14:0x002f). Please report as a decompilation issue!!! */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                f.z.i.a r0 = f.z.i.a.COROUTINE_SUSPENDED
                int r1 = r9.label
                r2 = 0
                r4 = 1
                if (r1 == 0) goto L18
                if (r1 != r4) goto L10
                c.b.a.m.f.E5(r10)
                r10 = r9
                goto L2f
            L10:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L18:
                c.b.a.m.f.E5(r10)
                r10 = r9
            L1c:
                io.legado.app.ui.widget.dialog.TextDialog r1 = io.legado.app.ui.widget.dialog.TextDialog.this
                long r5 = r1.time
                int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r1 <= 0) goto L5b
                r5 = 1000(0x3e8, double:4.94E-321)
                r10.label = r4
                java.lang.Object r1 = c.b.a.m.f.p1(r5, r10)
                if (r1 != r0) goto L2f
                return r0
            L2f:
                io.legado.app.ui.widget.dialog.TextDialog r1 = io.legado.app.ui.widget.dialog.TextDialog.this
                long r5 = r1.time
                r7 = 1000(0x3e8, float:1.401E-42)
                long r7 = (long) r7
                long r5 = r5 - r7
                r1.time = r5
                io.legado.app.databinding.DialogTextViewBinding r1 = r1.Q()
                io.legado.app.ui.widget.text.BadgeView r1 = r1.f6679b
                io.legado.app.ui.widget.dialog.TextDialog r5 = io.legado.app.ui.widget.dialog.TextDialog.this
                long r5 = r5.time
                long r5 = r5 / r7
                int r6 = (int) r5
                r1.setBadgeCount(r6)
                io.legado.app.ui.widget.dialog.TextDialog r1 = io.legado.app.ui.widget.dialog.TextDialog.this
                long r5 = r1.time
                int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r7 > 0) goto L1c
                android.view.View r5 = r10.$view
                e.a.a.g.m.k.f r6 = new e.a.a.g.m.k.f
                r6.<init>()
                r5.post(r6)
                goto L1c
            L5b:
                f.v r10 = f.v.a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.widget.dialog.TextDialog.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class c extends k implements l<TextDialog, DialogTextViewBinding> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogTextViewBinding invoke(@NotNull TextDialog textDialog) {
            j.e(textDialog, "fragment");
            View viewRequireView = textDialog.requireView();
            int i2 = R.id.badge_view;
            BadgeView badgeView = (BadgeView) viewRequireView.findViewById(R.id.badge_view);
            if (badgeView != null) {
                i2 = R.id.text_view;
                InertiaScrollTextView inertiaScrollTextView = (InertiaScrollTextView) viewRequireView.findViewById(R.id.text_view);
                if (inertiaScrollTextView != null) {
                    return new DialogTextViewBinding((ConstraintLayout) viewRequireView, badgeView, inertiaScrollTextView);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(f.c0.c.v.a(TextDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogTextViewBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        f7656c = new h[]{qVar};
        INSTANCE = new Companion(null);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        Bundle arguments = getArguments();
        if (arguments != null) {
            final String string = arguments.getString("content");
            if (string == null) {
                string = "";
            }
            if (arguments.getInt("mode") == 1) {
                Q().f6680c.post(new Runnable() { // from class: e.a.a.g.m.k.e
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i2;
                        TextDialog textDialog = this.a;
                        String str = string;
                        TextDialog.Companion companion = TextDialog.INSTANCE;
                        f.c0.c.j.e(textDialog, "this$0");
                        f.c0.c.j.e(str, "$content");
                        Context contextRequireContext = textDialog.requireContext();
                        ArrayList arrayList = new ArrayList(3);
                        TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
                        arrayList.add(new e.b.a.p.p());
                        arrayList.add(new e.b.a.s.n.b(new e.b.a.s.n.a(c.b.a.b.d(textDialog.requireContext()))));
                        arrayList.add(new e.b.a.r.d());
                        float f2 = textDialog.requireContext().getResources().getDisplayMetrics().density;
                        k.a aVar = new k.a();
                        float f3 = 4;
                        aVar.a = (int) ((f3 * f2) + 0.5f);
                        float f4 = 1;
                        aVar.f6033b = (int) ((f2 * f4) + 0.5f);
                        arrayList.add(new e.b.a.q.a.f(new e.b.a.q.a.k(aVar)));
                        if (arrayList.isEmpty()) {
                            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
                        }
                        e.b.a.l lVar = new e.b.a.l(arrayList);
                        Iterator it = arrayList.iterator();
                        while (true) {
                            int i3 = 0;
                            if (!it.hasNext()) {
                                List<e.b.a.f> list = lVar.f5985b;
                                k.c.e.d dVar = new k.c.e.d();
                                float f5 = contextRequireContext.getResources().getDisplayMetrics().density;
                                r.a aVar2 = new r.a();
                                aVar2.f6006d = (int) ((8 * f5) + 0.5f);
                                aVar2.a = (int) ((24 * f5) + 0.5f);
                                int i4 = (int) ((f3 * f5) + 0.5f);
                                aVar2.f6004b = i4;
                                int i5 = (int) ((f4 * f5) + 0.5f);
                                aVar2.f6005c = i5;
                                aVar2.f6007e = i5;
                                aVar2.f6008f = i4;
                                e.b bVar = new e.b();
                                j.a aVar3 = new j.a();
                                h.a aVar4 = new h.a();
                                for (e.b.a.f fVar : list) {
                                    fVar.d(dVar);
                                    fVar.g(aVar2);
                                    fVar.f(bVar);
                                    fVar.j(aVar3);
                                    fVar.a(aVar4);
                                }
                                r rVar = new r(aVar2);
                                e.b.a.h hVar = new e.b.a.h(Collections.unmodifiableMap(aVar4.a));
                                bVar.a = rVar;
                                bVar.f5980g = hVar;
                                if (bVar.f5975b == null) {
                                    bVar.f5975b = new e.b.a.s.c();
                                }
                                if (bVar.f5976c == null) {
                                    bVar.f5976c = new e.b.a.t.a();
                                }
                                if (bVar.f5977d == null) {
                                    bVar.f5977d = new e.b.a.d();
                                }
                                if (bVar.f5978e == null) {
                                    bVar.f5978e = new a.b(null);
                                }
                                if (bVar.f5979f == null) {
                                    bVar.f5979f = new e.b.a.s.k();
                                }
                                e.b.a.e eVar = new e.b.a.e(bVar, null);
                                List<k.c.e.g.d> list2 = dVar.a;
                                Set<Class<? extends k.c.d.a>> set = dVar.f8741d;
                                Set<Class<? extends k.c.d.a>> set2 = k.c.c.h.a;
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.addAll(list2);
                                Iterator<Class<? extends k.c.d.a>> it2 = set.iterator();
                                while (it2.hasNext()) {
                                    arrayList2.add(k.c.c.h.f8658b.get(it2.next()));
                                }
                                k.c.e.c cVar = new k.c.e.c(dVar);
                                List<k.c.e.f> list3 = dVar.f8740c;
                                List<k.c.e.h.a> list4 = dVar.f8739b;
                                new n(new m(list4, Collections.emptyMap()));
                                List listUnmodifiableList = Collections.unmodifiableList(list);
                                TextView textView = textDialog.Q().f6680c;
                                Iterator it3 = listUnmodifiableList.iterator();
                                String strB = str;
                                while (it3.hasNext()) {
                                    strB = ((e.b.a.f) it3.next()).b(strB);
                                }
                                Objects.requireNonNull(strB, "input must not be null");
                                k.c.c.h hVar2 = new k.c.c.h(arrayList2, cVar, list4);
                                while (true) {
                                    int length = strB.length();
                                    int i6 = i3;
                                    while (i6 < length) {
                                        char cCharAt = strB.charAt(i6);
                                        if (cCharAt == '\n' || cCharAt == '\r') {
                                            i2 = -1;
                                            break;
                                        }
                                        i6++;
                                    }
                                    i2 = -1;
                                    i6 = -1;
                                    if (i6 == i2) {
                                        break;
                                    }
                                    hVar2.i(strB.substring(i3, i6));
                                    i3 = i6 + 1;
                                    if (i3 < strB.length() && strB.charAt(i6) == '\r' && strB.charAt(i3) == '\n') {
                                        i3 = i6 + 2;
                                    }
                                }
                                if (strB.length() > 0 && (i3 == 0 || i3 < strB.length())) {
                                    hVar2.i(strB.substring(i3));
                                }
                                hVar2.f(hVar2.p);
                                m mVar = new m(hVar2.m, hVar2.o);
                                Objects.requireNonNull((k.c.e.c) hVar2.f8668l);
                                n nVar = new n(mVar);
                                Iterator<k.c.e.g.c> it4 = hVar2.q.iterator();
                                while (it4.hasNext()) {
                                    it4.next().a(nVar);
                                }
                                s sVarA = hVar2.n.a;
                                Iterator<k.c.e.f> it5 = list3.iterator();
                                while (it5.hasNext()) {
                                    sVarA = it5.next().a(sVarA);
                                }
                                Iterator it6 = listUnmodifiableList.iterator();
                                while (it6.hasNext()) {
                                    ((e.b.a.f) it6.next()).e(sVarA);
                                }
                                e.b.a.j jVar = new e.b.a.j(eVar, new e.b.a.m(), new o(), Collections.unmodifiableMap(aVar3.a), new e.b.a.b());
                                sVarA.a(jVar);
                                Iterator it7 = listUnmodifiableList.iterator();
                                while (it7.hasNext()) {
                                    ((e.b.a.f) it7.next()).k(sVarA, jVar);
                                }
                                o oVar = jVar.f5982c;
                                Objects.requireNonNull(oVar);
                                SpannableStringBuilder bVar2 = new o.b(oVar.a);
                                for (o.a aVar5 : oVar.f5987b) {
                                    bVar2.setSpan(aVar5.a, aVar5.f5988b, aVar5.f5989c, aVar5.f5990d);
                                }
                                if (TextUtils.isEmpty(bVar2) && !TextUtils.isEmpty(str)) {
                                    bVar2 = new SpannableStringBuilder(str);
                                }
                                Iterator it8 = listUnmodifiableList.iterator();
                                while (it8.hasNext()) {
                                    ((e.b.a.f) it8.next()).i(textView, bVar2);
                                }
                                textView.setText(bVar2, bufferType);
                                Iterator it9 = listUnmodifiableList.iterator();
                                while (it9.hasNext()) {
                                    ((e.b.a.f) it9.next()).h(textView);
                                }
                                return;
                            }
                            e.b.a.f fVar2 = (e.b.a.f) it.next();
                            if (!lVar.f5985b.contains(fVar2)) {
                                if (lVar.f5986c.contains(fVar2)) {
                                    StringBuilder sbR = c.a.a.a.a.r("Cyclic dependency chain found: ");
                                    sbR.append(lVar.f5986c);
                                    throw new IllegalStateException(sbR.toString());
                                }
                                lVar.f5986c.add(fVar2);
                                fVar2.c(lVar);
                                lVar.f5986c.remove(fVar2);
                                if (!lVar.f5985b.contains(fVar2)) {
                                    if (e.b.a.p.p.class.isAssignableFrom(fVar2.getClass())) {
                                        lVar.f5985b.add(0, fVar2);
                                    } else {
                                        lVar.f5985b.add(fVar2);
                                    }
                                }
                            }
                        }
                    }
                });
            } else {
                Q().f6680c.setText(string);
            }
            this.time = arguments.getLong("time", 0L);
        }
        if (this.time <= 0) {
            view.post(new Runnable() { // from class: e.a.a.g.m.k.d
                @Override // java.lang.Runnable
                public final void run() {
                    Dialog dialog;
                    TextDialog textDialog = this.a;
                    TextDialog.Companion companion = TextDialog.INSTANCE;
                    f.c0.c.j.e(textDialog, "this$0");
                    Dialog dialog2 = textDialog.getDialog();
                    if (dialog2 != null) {
                        dialog2.setCancelable(true);
                    }
                    if (!textDialog.autoClose || (dialog = textDialog.getDialog()) == null) {
                        return;
                    }
                    dialog.cancel();
                }
            });
        } else {
            Q().f6679b.setBadgeCount((int) (this.time / ((long) 1000)));
            f.L3(this, null, null, new b(view, null), 3, null);
        }
    }

    public final DialogTextViewBinding Q() {
        return (DialogTextViewBinding) this.binding.b(this, f7656c[0]);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        f.c0.c.j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_text_view, container);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
        DisplayMetrics displayMetricsV2 = f.V2(fragmentActivityRequireActivity);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), (int) (((double) displayMetricsV2.heightPixels) * 0.9d));
    }
}
