package androidx.preference;

import androidx.exifinterface.media.ExifInterface;
import c.a.a.a.a;
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
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: PreferenceGroup.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\t\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0011\u0010\u0010\u001a\u0014\u0010\u0012\u001a\u00020\u000b*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u000b*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0013\u001a7\u0010\u0019\u001a\u00020\u000e*\u00020\u00022!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0015H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001a\u001aL\u0010\u001c\u001a\u00020\u000e*\u00020\u000226\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u001bH\u0086\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00000\u001e*\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 \"\u0018\u0010#\u001a\u00020\u0007*\u00020\u00028Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\"\"\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00000$*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/preference/Preference;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/preference/PreferenceGroup;", "", "key", "get", "(Landroidx/preference/PreferenceGroup;Ljava/lang/CharSequence;)Landroidx/preference/Preference;", "", "index", "(Landroidx/preference/PreferenceGroup;I)Landroidx/preference/Preference;", "preference", "", "contains", "(Landroidx/preference/PreferenceGroup;Landroidx/preference/Preference;)Z", "Lf/v;", "plusAssign", "(Landroidx/preference/PreferenceGroup;Landroidx/preference/Preference;)V", "minusAssign", "isEmpty", "(Landroidx/preference/PreferenceGroup;)Z", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroidx/preference/PreferenceGroup;Lf/c0/b/l;)V", "Lkotlin/Function2;", "forEachIndexed", "(Landroidx/preference/PreferenceGroup;Lf/c0/b/p;)V", "", "iterator", "(Landroidx/preference/PreferenceGroup;)Ljava/util/Iterator;", "getSize", "(Landroidx/preference/PreferenceGroup;)I", "size", "Lf/g0/e;", "getChildren", "(Landroidx/preference/PreferenceGroup;)Lf/g0/e;", "children", "preference-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class PreferenceGroupKt {

    /* JADX INFO: renamed from: androidx.preference.PreferenceGroupKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreferenceGroup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/preference/PreferenceGroupKt$iterator$1", "", "Landroidx/preference/Preference;", "", "hasNext", "()Z", ES6Iterator.NEXT_METHOD, "()Landroidx/preference/Preference;", "Lf/v;", "remove", "()V", "", "index", OptRuntime.GeneratorState.resumptionPoint_TYPE, "preference-ktx_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements Iterator<Preference>, j$.util.Iterator, j$.util.Iterator {
        public final /* synthetic */ PreferenceGroup $this_iterator;
        private int index;

        public AnonymousClass1(PreferenceGroup preferenceGroup) {
            this.$this_iterator = preferenceGroup;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getPreferenceCount();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            PreferenceGroup preferenceGroup = this.$this_iterator;
            int i2 = this.index - 1;
            this.index = i2;
            preferenceGroup.removePreference(preferenceGroup.getPreference(i2));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        @NotNull
        public Preference next() {
            PreferenceGroup preferenceGroup = this.$this_iterator;
            int i2 = this.index;
            this.index = i2 + 1;
            Preference preference = preferenceGroup.getPreference(i2);
            if (preference != null) {
                return preference;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@NotNull PreferenceGroup preferenceGroup, @NotNull Preference preference) {
        j.f(preferenceGroup, "$this$contains");
        j.f(preference, "preference");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            if (j.a(preferenceGroup.getPreference(i2), preference)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull PreferenceGroup preferenceGroup, @NotNull l<? super Preference, v> lVar) {
        j.f(preferenceGroup, "$this$forEach");
        j.f(lVar, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            lVar.invoke(get(preferenceGroup, i2));
        }
    }

    public static final void forEachIndexed(@NotNull PreferenceGroup preferenceGroup, @NotNull p<? super Integer, ? super Preference, v> pVar) {
        j.f(preferenceGroup, "$this$forEachIndexed");
        j.f(pVar, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            pVar.invoke(Integer.valueOf(i2), get(preferenceGroup, i2));
        }
    }

    @Nullable
    public static final <T extends Preference> T get(@NotNull PreferenceGroup preferenceGroup, @NotNull CharSequence charSequence) {
        j.f(preferenceGroup, "$this$get");
        j.f(charSequence, "key");
        return (T) preferenceGroup.findPreference(charSequence);
    }

    @NotNull
    public static final e<Preference> getChildren(@NotNull final PreferenceGroup preferenceGroup) {
        j.f(preferenceGroup, "$this$children");
        return new e<Preference>() { // from class: androidx.preference.PreferenceGroupKt$children$1
            @Override // f.g0.e
            @NotNull
            public java.util.Iterator<Preference> iterator() {
                return PreferenceGroupKt.iterator(preferenceGroup);
            }
        };
    }

    public static final int getSize(@NotNull PreferenceGroup preferenceGroup) {
        j.f(preferenceGroup, "$this$size");
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(@NotNull PreferenceGroup preferenceGroup) {
        j.f(preferenceGroup, "$this$isEmpty");
        return preferenceGroup.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(@NotNull PreferenceGroup preferenceGroup) {
        j.f(preferenceGroup, "$this$isNotEmpty");
        return preferenceGroup.getPreferenceCount() != 0;
    }

    @NotNull
    public static final java.util.Iterator<Preference> iterator(@NotNull PreferenceGroup preferenceGroup) {
        j.f(preferenceGroup, "$this$iterator");
        return new AnonymousClass1(preferenceGroup);
    }

    public static final void minusAssign(@NotNull PreferenceGroup preferenceGroup, @NotNull Preference preference) {
        j.f(preferenceGroup, "$this$minusAssign");
        j.f(preference, "preference");
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(@NotNull PreferenceGroup preferenceGroup, @NotNull Preference preference) {
        j.f(preferenceGroup, "$this$plusAssign");
        j.f(preference, "preference");
        preferenceGroup.addPreference(preference);
    }

    @NotNull
    public static final Preference get(@NotNull PreferenceGroup preferenceGroup, int i2) {
        j.f(preferenceGroup, "$this$get");
        Preference preference = preferenceGroup.getPreference(i2);
        if (preference != null) {
            return preference;
        }
        StringBuilder sbS = a.s("Index: ", i2, ", Size: ");
        sbS.append(preferenceGroup.getPreferenceCount());
        throw new IndexOutOfBoundsException(sbS.toString());
    }
}
