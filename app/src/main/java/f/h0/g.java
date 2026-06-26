package f.h0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Serializable {

    @NotNull
    public static final a Companion = new a(null);
    private Set<? extends i> _options;
    private final Pattern nativePattern;

    /* JADX INFO: compiled from: Regex.kt */
    public static final class a {
        public a(f.c0.c.f fVar) {
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    public static final class b implements Serializable {

        @NotNull
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;

        @NotNull
        private final String pattern;

        /* JADX INFO: compiled from: Regex.kt */
        public static final class a {
            public a(f.c0.c.f fVar) {
            }
        }

        public b(@NotNull String str, int i2) {
            f.c0.c.j.e(str, "pattern");
            this.pattern = str;
            this.flags = i2;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            f.c0.c.j.d(patternCompile, "Pattern.compile(pattern, flags)");
            return new g(patternCompile);
        }

        public final int getFlags() {
            return this.flags;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.a<e> {
        public final /* synthetic */ CharSequence $input;
        public final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence, int i2) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @Nullable
        public final e invoke() {
            return g.this.find(this.$input, this.$startIndex);
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    public static final /* synthetic */ class d extends f.c0.c.i implements f.c0.b.l<e, e> {
        public static final d INSTANCE = new d();

        public d() {
            super(1, e.class, ES6Iterator.NEXT_METHOD, "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // f.c0.b.l
        @Nullable
        public final e invoke(@NotNull e eVar) {
            f.c0.c.j.e(eVar, "p1");
            return eVar.next();
        }
    }

    @PublishedApi
    public g(@NotNull Pattern pattern) {
        f.c0.c.j.e(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ e find$default(g gVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return gVar.find(charSequence, i2);
    }

    public static /* synthetic */ f.g0.e findAll$default(g gVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return gVar.findAll(charSequence, i2);
    }

    public static /* synthetic */ List split$default(g gVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return gVar.split(charSequence, i2);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        f.c0.c.j.d(strPattern, "nativePattern.pattern()");
        return new b(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence charSequence) {
        f.c0.c.j.e(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    @Nullable
    public final e find(@NotNull CharSequence charSequence, int i2) {
        f.c0.c.j.e(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        f.c0.c.j.d(matcher, "nativePattern.matcher(input)");
        if (matcher.find(i2)) {
            return new f(matcher, charSequence);
        }
        return null;
    }

    @NotNull
    public final f.g0.e<e> findAll(@NotNull CharSequence charSequence, int i2) {
        f.c0.c.j.e(charSequence, "input");
        if (i2 < 0 || i2 > charSequence.length()) {
            StringBuilder sbS = c.a.a.a.a.s("Start index out of bounds: ", i2, ", input length: ");
            sbS.append(charSequence.length());
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        c cVar = new c(charSequence, i2);
        d dVar = d.INSTANCE;
        f.c0.c.j.e(cVar, "seedFunction");
        f.c0.c.j.e(dVar, "nextFunction");
        return new f.g0.d(cVar, dVar);
    }

    @NotNull
    public final Set<i> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(i.class);
        h hVar = new h(iFlags);
        f.c0.c.j.e(enumSetAllOf, "$this$retainAll");
        f.c0.c.j.e(hVar, "predicate");
        Iterator it = enumSetAllOf.iterator();
        while (it.hasNext()) {
            if (!hVar.invoke(it.next()).booleanValue()) {
                it.remove();
            }
        }
        Set<i> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        f.c0.c.j.d(setUnmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    @NotNull
    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        f.c0.c.j.d(strPattern, "nativePattern.pattern()");
        return strPattern;
    }

    @Nullable
    public final e matchEntire(@NotNull CharSequence charSequence) {
        f.c0.c.j.e(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        f.c0.c.j.d(matcher, "nativePattern.matcher(input)");
        if (matcher.matches()) {
            return new f(matcher, charSequence);
        }
        return null;
    }

    public final boolean matches(@NotNull CharSequence charSequence) {
        f.c0.c.j.e(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull String str) {
        f.c0.c.j.e(charSequence, "input");
        f.c0.c.j.e(str, "replacement");
        String strReplaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        f.c0.c.j.d(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence charSequence, @NotNull String str) {
        f.c0.c.j.e(charSequence, "input");
        f.c0.c.j.e(str, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        f.c0.c.j.d(strReplaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return strReplaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence charSequence, int i2) {
        f.c0.c.j.e(charSequence, "input");
        int iEnd = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (!matcher.find() || i2 == 1) {
            return c.b.a.m.f.P3(charSequence.toString());
        }
        int i3 = 10;
        if (i2 > 0 && i2 <= 10) {
            i3 = i2;
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = i2 - 1;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i4 >= 0 && arrayList.size() == i4) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String string = this.nativePattern.toString();
        f.c0.c.j.d(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public g(@NotNull String str) {
        f.c0.c.j.e(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        f.c0.c.j.d(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull f.c0.b.l<? super e, ? extends CharSequence> lVar) {
        f.c0.c.j.e(charSequence, "input");
        f.c0.c.j.e(lVar, "transform");
        int iIntValue = 0;
        e eVarFind$default = find$default(this, charSequence, 0, 2, null);
        if (eVarFind$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            f.c0.c.j.c(eVarFind$default);
            sb.append(charSequence, iIntValue, eVarFind$default.b().getStart().intValue());
            sb.append(lVar.invoke(eVarFind$default));
            iIntValue = eVarFind$default.b().getEndInclusive().intValue() + 1;
            eVarFind$default = eVarFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (eVarFind$default != null);
        if (iIntValue < length) {
            sb.append(charSequence, iIntValue, length);
        }
        String string = sb.toString();
        f.c0.c.j.d(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public g(@NotNull String str, @NotNull i iVar) {
        f.c0.c.j.e(str, "pattern");
        f.c0.c.j.e(iVar, "option");
        a aVar = Companion;
        int value = iVar.getValue();
        Objects.requireNonNull(aVar);
        Pattern patternCompile = Pattern.compile(str, (value & 2) != 0 ? value | 64 : value);
        f.c0.c.j.d(patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public g(@NotNull String str, @NotNull Set<? extends i> set) {
        f.c0.c.j.e(str, "pattern");
        f.c0.c.j.e(set, "options");
        a aVar = Companion;
        Iterator<T> it = set.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= ((f.h0.c) it.next()).getValue();
        }
        Objects.requireNonNull(aVar);
        Pattern patternCompile = Pattern.compile(str, (value & 2) != 0 ? value | 64 : value);
        f.c0.c.j.d(patternCompile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
        this(patternCompile);
    }
}
