package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.g0.e;
import f.v;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\u0007*\u00020\u0000H\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0007*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u000e\u001a7\u0010\u0014\u001a\u00020\n*\u00020\u00002!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0010H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001aL\u0010\u0017\u001a\u00020\n*\u00020\u000026\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0016H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001b\"\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0018\u0010\"\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroid/view/Menu;", "", "index", "Landroid/view/MenuItem;", "get", "(Landroid/view/Menu;I)Landroid/view/MenuItem;", "item", "", "contains", "(Landroid/view/Menu;Landroid/view/MenuItem;)Z", "Lf/v;", "minusAssign", "(Landroid/view/Menu;Landroid/view/MenuItem;)V", "isEmpty", "(Landroid/view/Menu;)Z", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroid/view/Menu;Lf/c0/b/l;)V", "Lkotlin/Function2;", "forEachIndexed", "(Landroid/view/Menu;Lf/c0/b/p;)V", "", "iterator", "(Landroid/view/Menu;)Ljava/util/Iterator;", "Lf/g0/e;", "getChildren", "(Landroid/view/Menu;)Lf/g0/e;", "children", "getSize", "(Landroid/view/Menu;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: Menu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "", "hasNext", "()Z", ES6Iterator.NEXT_METHOD, "()Landroid/view/MenuItem;", "Lf/v;", "remove", "()V", "", "index", OptRuntime.GeneratorState.resumptionPoint_TYPE, "core-ktx_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements Iterator<MenuItem>, j$.util.Iterator, j$.util.Iterator {
        public final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            Menu menu = this.$this_iterator;
            int i2 = this.index - 1;
            this.index = i2;
            menu.removeItem(i2);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        @NotNull
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i2 = this.index;
            this.index = i2 + 1;
            MenuItem item = menu.getItem(i2);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        j.f(menu, "$this$contains");
        j.f(menuItem, "item");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (j.a(menu.getItem(i2), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu menu, @NotNull l<? super MenuItem, v> lVar) {
        j.f(menu, "$this$forEach");
        j.f(lVar, "action");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menu.getItem(i2);
            j.b(item, "getItem(index)");
            lVar.invoke(item);
        }
    }

    public static final void forEachIndexed(@NotNull Menu menu, @NotNull p<? super Integer, ? super MenuItem, v> pVar) {
        j.f(menu, "$this$forEachIndexed");
        j.f(pVar, "action");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            Integer numValueOf = Integer.valueOf(i2);
            MenuItem item = menu.getItem(i2);
            j.b(item, "getItem(index)");
            pVar.invoke(numValueOf, item);
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu menu, int i2) {
        j.f(menu, "$this$get");
        MenuItem item = menu.getItem(i2);
        j.b(item, "getItem(index)");
        return item;
    }

    @NotNull
    public static final e<MenuItem> getChildren(@NotNull final Menu menu) {
        j.f(menu, "$this$children");
        return new e<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // f.g0.e
            @NotNull
            public java.util.Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(@NotNull Menu menu) {
        j.f(menu, "$this$size");
        return menu.size();
    }

    public static final boolean isEmpty(@NotNull Menu menu) {
        j.f(menu, "$this$isEmpty");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull Menu menu) {
        j.f(menu, "$this$isNotEmpty");
        return menu.size() != 0;
    }

    @NotNull
    public static final java.util.Iterator<MenuItem> iterator(@NotNull Menu menu) {
        j.f(menu, "$this$iterator");
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        j.f(menu, "$this$minusAssign");
        j.f(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
