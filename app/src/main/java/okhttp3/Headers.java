package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.f;
import f.c0.c.j;
import f.c0.c.x;
import f.c0.c.z.a;
import f.e0.b;
import f.e0.e;
import f.g;
import f.h0.k;
import f.x.i;
import j$.C$r8$retargetLibraryMember$virtualDispatch$Date$toInstant$dispatchHolder;
import j$.lang.Iterable;
import j$.time.Instant;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 32\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u000243B\u0017\b\u0002\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030.¢\u0006\u0004\b1\u00102J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0012J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u001dH\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010\u000fJ\u000f\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170+¢\u0006\u0004\b,\u0010-R\u0013\u0010\u0010\u001a\u00020\r8G@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00065"}, d2 = {"Lokhttp3/Headers;", "", "Lf/g;", "", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Date;", "getDate", "(Ljava/lang/String;)Ljava/util/Date;", "j$/time/Instant", "getInstant", "(Ljava/lang/String;)Lj$/time/Instant;", "", "-deprecated_size", "()I", "size", "index", "(I)Ljava/lang/String;", ES6Iterator.VALUE_PROPERTY, "", "names", "()Ljava/util/Set;", "", "values", "(Ljava/lang/String;)Ljava/util/List;", "", "byteCount", "()J", "", "iterator", "()Ljava/util/Iterator;", "Lokhttp3/Headers$Builder;", "newBuilder", "()Lokhttp3/Headers$Builder;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "()Ljava/lang/String;", "", "toMultimap", "()Ljava/util/Map;", "", "namesAndValues", "[Ljava/lang/String;", "<init>", "([Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Headers implements Iterable<g<? extends String, ? extends String>>, a, Iterable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String[] namesAndValues;

    /* JADX INFO: compiled from: Headers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001d\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0010¢\u0006\u0004\b\u0007\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0007\u0010\u0013J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0011J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0012H\u0087\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\nJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0005J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lokhttp3/Headers$Builder;", "", "", "line", "addLenient$okhttp", "(Ljava/lang/String;)Lokhttp3/Headers$Builder;", "addLenient", "add", "name", ES6Iterator.VALUE_PROPERTY, "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "addUnsafeNonAscii", "Lokhttp3/Headers;", "headers", "addAll", "(Lokhttp3/Headers;)Lokhttp3/Headers$Builder;", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)Lokhttp3/Headers$Builder;", "j$/time/Instant", "(Ljava/lang/String;Lj$/time/Instant;)Lokhttp3/Headers$Builder;", "set", "removeAll", "get", "(Ljava/lang/String;)Ljava/lang/String;", "build", "()Lokhttp3/Headers;", "", "namesAndValues", "Ljava/util/List;", "getNamesAndValues$okhttp", "()Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        @NotNull
        private final List<String> namesAndValues = new ArrayList(20);

        @NotNull
        public final Builder add(@NotNull String line) {
            j.e(line, "line");
            int iP = k.p(line, ':', 0, false, 6);
            if (!(iP != -1)) {
                throw new IllegalArgumentException(c.a.a.a.a.i("Unexpected header: ", line).toString());
            }
            String strSubstring = line.substring(0, iP);
            j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String string = k.R(strSubstring).toString();
            String strSubstring2 = line.substring(iP + 1);
            j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            add(string, strSubstring2);
            return this;
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            j.e(headers, "headers");
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                addLenient$okhttp(headers.name(i2), headers.value(i2));
            }
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String line) {
            j.e(line, "line");
            int iP = k.p(line, ':', 1, false, 4);
            if (iP != -1) {
                String strSubstring = line.substring(0, iP);
                j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iP + 1);
                j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(strSubstring, strSubstring2);
            } else if (line.charAt(0) == ':') {
                String strSubstring3 = line.substring(1);
                j.d(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", strSubstring3);
            } else {
                addLenient$okhttp("", line);
            }
            return this;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String name, @NotNull String value) {
            j.e(name, "name");
            j.e(value, ES6Iterator.VALUE_PROPERTY);
            Headers.INSTANCE.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new Headers((String[]) array, null);
        }

        @Nullable
        public final String get(@NotNull String name) {
            j.e(name, "name");
            b bVarE = e.e(e.c(this.namesAndValues.size() - 2, 0), 2);
            int i2 = bVarE.a;
            int i3 = bVarE.f6128b;
            int i4 = bVarE.f6129c;
            if (i4 >= 0) {
                if (i2 > i3) {
                    return null;
                }
            } else if (i2 < i3) {
                return null;
            }
            while (!k.i(name, this.namesAndValues.get(i2), true)) {
                if (i2 == i3) {
                    return null;
                }
                i2 += i4;
            }
            return this.namesAndValues.get(i2 + 1);
        }

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String name) {
            j.e(name, "name");
            int i2 = 0;
            while (i2 < this.namesAndValues.size()) {
                if (k.i(name, this.namesAndValues.get(i2), true)) {
                    this.namesAndValues.remove(i2);
                    this.namesAndValues.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Date value) {
            j.e(name, "name");
            j.e(value, ES6Iterator.VALUE_PROPERTY);
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String name, @NotNull Instant value) {
            j.e(name, "name");
            j.e(value, ES6Iterator.VALUE_PROPERTY);
            return set(name, new Date(value.toEpochMilli()));
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull String value) {
            j.e(name, "name");
            j.e(value, ES6Iterator.VALUE_PROPERTY);
            Companion companion = Headers.INSTANCE;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            j.e(name, "name");
            j.e(value, ES6Iterator.VALUE_PROPERTY);
            Companion companion = Headers.INSTANCE;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String name, @NotNull String value) {
            j.e(name, "name");
            j.e(value, ES6Iterator.VALUE_PROPERTY);
            this.namesAndValues.add(name);
            this.namesAndValues.add(k.R(value).toString());
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Date value) {
            j.e(name, "name");
            j.e(value, ES6Iterator.VALUE_PROPERTY);
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String name, @NotNull Instant value) {
            j.e(name, "name");
            j.e(value, ES6Iterator.VALUE_PROPERTY);
            add(name, new Date(value.toEpochMilli()));
            return this;
        }
    }

    /* JADX INFO: compiled from: Headers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0007¢\u0006\u0004\b\u000f\u0010\u0014J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0007¢\u0006\u0004\b\u0012\u0010\u0014¨\u0006\u0019"}, d2 = {"Lokhttp3/Headers$Companion;", "", "", "", "namesAndValues", "name", "get", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lf/v;", "checkName", "(Ljava/lang/String;)V", ES6Iterator.VALUE_PROPERTY, "checkValue", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersOf", "-deprecated_of", "", "(Ljava/util/Map;)Lokhttp3/Headers;", "toHeaders", "headers", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String name) {
            if (!(name.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = name.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = name.charAt(i2);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), name).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String value, String name) {
            int length = value.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = value.charAt(i2);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), name, value).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] namesAndValues, String name) {
            b bVarE = e.e(e.c(namesAndValues.length - 2, 0), 2);
            int i2 = bVarE.a;
            int i3 = bVarE.f6128b;
            int i4 = bVarE.f6129c;
            if (i4 >= 0) {
                if (i2 > i3) {
                    return null;
                }
            } else if (i2 < i3) {
                return null;
            }
            while (!k.i(name, namesAndValues[i2], true)) {
                if (i2 == i3) {
                    return null;
                }
                i2 += i4;
            }
            return namesAndValues[i2 + 1];
        }

        @Deprecated(level = f.a.ERROR, message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m84deprecated_of(@NotNull String... namesAndValues) {
            j.e(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final Headers of(@NotNull String... namesAndValues) throws CloneNotSupportedException {
            j.e(namesAndValues, "namesAndValues");
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object objClone = namesAndValues.clone();
            Objects.requireNonNull(objClone, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            String[] strArr = (String[]) objClone;
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!(strArr[i2] != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                String str = strArr[i2];
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                strArr[i2] = k.R(str).toString();
            }
            b bVarE = e.e(e.f(0, strArr.length), 2);
            int i3 = bVarE.a;
            int i4 = bVarE.f6128b;
            int i5 = bVarE.f6129c;
            if (i5 < 0 ? i3 >= i4 : i3 <= i4) {
                while (true) {
                    String str2 = strArr[i3];
                    String str3 = strArr[i3 + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i3 == i4) {
                        break;
                    }
                    i3 += i5;
                }
            }
            return new Headers(strArr, null);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @Deprecated(level = f.a.ERROR, message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m83deprecated_of(@NotNull Map<String, String> headers) {
            j.e(headers, "headers");
            return of(headers);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final Headers of(@NotNull Map<String, String> map) {
            j.e(map, "$this$toHeaders");
            String[] strArr = new String[map.size() * 2];
            int i2 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.CharSequence");
                String string = k.R(key).toString();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.CharSequence");
                String string2 = k.R(value).toString();
                checkName(string);
                checkValue(string2, string);
                strArr[i2] = string;
                strArr[i2 + 1] = string2;
                i2 += 2;
            }
            return new Headers(strArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final Headers of(@NotNull Map<String, String> map) {
        return INSTANCE.of(map);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final Headers of(@NotNull String... strArr) {
        return INSTANCE.of(strArr);
    }

    @Deprecated(level = f.a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m82deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            length += (long) this.namesAndValues[i2].length();
        }
        return length;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues);
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Nullable
    public final String get(@NotNull String name) {
        j.e(name, "name");
        return INSTANCE.get(this.namesAndValues, name);
    }

    @Nullable
    public final Date getDate(@NotNull String name) {
        j.e(name, "name");
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String name) {
        j.e(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return C$r8$retargetLibraryMember$virtualDispatch$Date$toInstant$dispatchHolder.toInstant(date);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    @NotNull
    public Iterator<g<String, String>> iterator() {
        int size = size();
        g[] gVarArr = new g[size];
        for (int i2 = 0; i2 < size; i2++) {
            gVarArr[i2] = new g(name(i2), value(i2));
        }
        return c.b.a.m.f.I3(gVarArr);
    }

    @NotNull
    public final String name(int index) {
        return this.namesAndValues[index * 2];
    }

    @NotNull
    public final Set<String> names() {
        k.j(x.a);
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            treeSet.add(name(i2));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        j.d(setUnmodifiableSet, "Collections.unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        c.b.a.m.f.T(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    @JvmName(name = "size")
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return v.o(iterator(), 0);
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        k.j(x.a);
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String strName = name(i2);
            Locale locale = Locale.US;
            j.d(locale, "Locale.US");
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase(locale);
            j.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i2));
        }
        return treeMap;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(name(i2));
            sb.append(": ");
            sb.append(value(i2));
            sb.append("\n");
        }
        String string = sb.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final String value(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    @NotNull
    public final List<String> values(@NotNull String name) {
        j.e(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (k.i(name, name(i2), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i2));
            }
        }
        if (arrayList == null) {
            return i.INSTANCE;
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        j.d(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    public /* synthetic */ Headers(String[] strArr, f fVar) {
        this(strArr);
    }
}
