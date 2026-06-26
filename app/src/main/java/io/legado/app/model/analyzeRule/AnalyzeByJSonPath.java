package io.legado.app.model.analyzeRule;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.ReadContext;
import f.c0.c.f;
import f.c0.c.j;
import f.h0.g;
import f.h0.k;
import f.x.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnalyzeByJSonPath.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeByJSonPath;", "", "", "rule", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "", "getStringList$app_adsRelease", "(Ljava/lang/String;)Ljava/util/List;", "getStringList", "getObject$app_adsRelease", "(Ljava/lang/String;)Ljava/lang/Object;", "getObject", "Ljava/util/ArrayList;", "getList$app_adsRelease", "(Ljava/lang/String;)Ljava/util/ArrayList;", "getList", "Lcom/jayway/jsonpath/ReadContext;", "ctx", "Lcom/jayway/jsonpath/ReadContext;", "json", "<init>", "(Ljava/lang/Object;)V", "Companion", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AnalyzeByJSonPath {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern jsonRulePattern = Pattern.compile("(?<=\\{)\\$\\..+?(?=\\})");

    @NotNull
    private ReadContext ctx;

    /* JADX INFO: compiled from: AnalyzeByJSonPath.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeByJSonPath$Companion;", "", "json", "Lcom/jayway/jsonpath/ReadContext;", "parse", "(Ljava/lang/Object;)Lcom/jayway/jsonpath/ReadContext;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "jsonRulePattern", "Ljava/util/regex/Pattern;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @NotNull
        public final ReadContext parse(@NotNull Object json) {
            j.e(json, "json");
            if (json instanceof ReadContext) {
                return (ReadContext) json;
            }
            if (json instanceof String) {
                DocumentContext documentContext = JsonPath.parse((String) json);
                j.d(documentContext, "parse(json)");
                return documentContext;
            }
            DocumentContext documentContext2 = JsonPath.parse(json);
            j.d(documentContext2, "parse(json)");
            return documentContext2;
        }
    }

    public AnalyzeByJSonPath(@NotNull Object obj) {
        j.e(obj, "json");
        this.ctx = INSTANCE.parse(obj);
    }

    @Nullable
    public final ArrayList<Object> getList$app_adsRelease(@NotNull String rule) {
        String[] strArrN5;
        String str;
        Object obj;
        j.e(rule, "rule");
        ArrayList<Object> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(rule)) {
            return arrayList;
        }
        int i2 = 0;
        if (k.d(rule, "&&", false, 2)) {
            strArrN5 = c.b.a.m.f.n5(rule, "&&");
            str = "&";
        } else if (k.d(rule, "%%", false, 2)) {
            strArrN5 = c.b.a.m.f.n5(rule, "%%");
            str = "%";
        } else {
            strArrN5 = c.b.a.m.f.n5(rule, "||");
            str = "|";
        }
        if (strArrN5.length == 1) {
            try {
                return (ArrayList) this.ctx.read(strArrN5[0], new Predicate[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        ArrayList<ArrayList> arrayList2 = new ArrayList();
        int length = strArrN5.length;
        int i3 = 0;
        while (i3 < length) {
            String str2 = strArrN5[i3];
            i3++;
            ArrayList<Object> list$app_adsRelease = getList$app_adsRelease(str2);
            if (list$app_adsRelease != null && (!list$app_adsRelease.isEmpty())) {
                arrayList2.add(list$app_adsRelease);
                if ((!list$app_adsRelease.isEmpty()) && j.a(str, "|")) {
                    break;
                }
            }
        }
        if (arrayList2.size() > 0) {
            if (j.a("%", str)) {
                int size = ((ArrayList) arrayList2.get(0)).size();
                if (size > 0) {
                    while (true) {
                        int i4 = i2 + 1;
                        for (ArrayList arrayList3 : arrayList2) {
                            if (i2 < arrayList3.size() && (obj = arrayList3.get(i2)) != null) {
                                arrayList.add(obj);
                            }
                        }
                        if (i4 >= size) {
                            break;
                        }
                        i2 = i4;
                    }
                }
            } else {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.addAll((ArrayList) it.next());
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final Object getObject$app_adsRelease(@NotNull String rule) {
        j.e(rule, "rule");
        Object obj = this.ctx.read(rule, new Predicate[0]);
        j.d(obj, "ctx.read(rule)");
        return obj;
    }

    @Nullable
    public final String getString(@NotNull String rule) {
        String[] strArrN5;
        String str;
        String string;
        String strC = rule;
        j.e(strC, "rule");
        if (TextUtils.isEmpty(rule)) {
            return null;
        }
        if (k.d(strC, "&&", false, 2)) {
            strArrN5 = c.b.a.m.f.n5(strC, "&&");
            str = "&";
        } else {
            strArrN5 = c.b.a.m.f.n5(strC, "||");
            str = "|";
        }
        if (strArrN5.length != 1) {
            ArrayList arrayList = new ArrayList();
            int length = strArrN5.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = strArrN5[i2];
                i2++;
                String string2 = getString(str2);
                if (!(string2 == null || string2.length() == 0)) {
                    arrayList.add(string2);
                    if (j.a(str, "|")) {
                        break;
                    }
                }
            }
            return e.q(arrayList, "\n", null, null, 0, null, null, 62);
        }
        if (k.d(strC, "{$.", false, 2)) {
            Matcher matcher = jsonRulePattern.matcher(strC);
            while (matcher.find()) {
                String str3 = String.format("{%s}", Arrays.copyOf(new Object[]{matcher.group()}, 1));
                j.d(str3, "java.lang.String.format(format, *args)");
                String strGroup = matcher.group();
                j.d(strGroup, "matcher.group()");
                String string3 = getString(strGroup);
                j.c(string3);
                strC = k.C(strC, str3, string3, false, 4);
            }
            return strC;
        }
        try {
            Object obj = this.ctx.read(strC, new Predicate[0]);
            if (obj instanceof List) {
                StringBuilder sb = new StringBuilder();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append("\n");
                }
                String string4 = sb.toString();
                j.d(string4, "builder.toString()");
                string = new g("\\n$").replace(string4, "");
            } else {
                string = obj.toString();
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    @NotNull
    public final List<String> getStringList$app_adsRelease(@NotNull String rule) {
        String[] strArrN5;
        String str;
        Object obj;
        j.e(rule, "rule");
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(rule)) {
            return arrayList;
        }
        int i2 = 0;
        if (k.d(rule, "&&", false, 2)) {
            strArrN5 = c.b.a.m.f.n5(rule, "&&");
            str = "&";
        } else if (k.d(rule, "%%", false, 2)) {
            strArrN5 = c.b.a.m.f.n5(rule, "%%");
            str = "%";
        } else {
            strArrN5 = c.b.a.m.f.n5(rule, "||");
            str = "|";
        }
        if (strArrN5.length == 1) {
            if (!k.d(rule, "{$.", false, 2)) {
                try {
                    obj = this.ctx.read(rule, new Predicate[0]);
                } catch (Exception unused) {
                }
                if (obj == null) {
                    return arrayList;
                }
                if (obj instanceof List) {
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        arrayList.add(String.valueOf(it.next()));
                    }
                } else {
                    arrayList.add(obj.toString());
                }
                return arrayList;
            }
            Matcher matcher = jsonRulePattern.matcher(rule);
            while (matcher.find()) {
                String strGroup = matcher.group();
                j.d(strGroup, "matcher.group()");
                for (String str2 : getStringList$app_adsRelease(strGroup)) {
                    String str3 = String.format("{%s}", Arrays.copyOf(new Object[]{matcher.group()}, 1));
                    j.d(str3, "java.lang.String.format(format, *args)");
                    arrayList.add(k.C(rule, str3, str2, false, 4));
                }
            }
            return arrayList;
        }
        ArrayList<List> arrayList2 = new ArrayList();
        int length = strArrN5.length;
        int i3 = 0;
        while (i3 < length) {
            String str4 = strArrN5[i3];
            i3++;
            List<String> stringList$app_adsRelease = getStringList$app_adsRelease(str4);
            if (!stringList$app_adsRelease.isEmpty()) {
                arrayList2.add(stringList$app_adsRelease);
                if ((!stringList$app_adsRelease.isEmpty()) && j.a(str, "|")) {
                    break;
                }
            }
        }
        if (arrayList2.size() > 0) {
            if (j.a("%", str)) {
                int size = ((List) arrayList2.get(0)).size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i4 = i2 + 1;
                        for (List list : arrayList2) {
                            if (i2 < list.size()) {
                                arrayList.add(list.get(i2));
                            }
                        }
                        if (i4 > size) {
                            break;
                        }
                        i2 = i4;
                    }
                }
            } else {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList.addAll((List) it2.next());
                }
            }
        }
        return arrayList;
    }
}
