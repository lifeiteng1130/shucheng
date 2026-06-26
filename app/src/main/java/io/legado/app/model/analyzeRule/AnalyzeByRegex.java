package io.legado.app.model.analyzeRule;

import androidx.annotation.Keep;
import f.c0.c.j;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnalyzeByRegex.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ5\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ9\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeByRegex;", "", "", "res", "", "regs", "", "index", "", "getElement", "(Ljava/lang/String;[Ljava/lang/String;I)Ljava/util/List;", "getElements", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AnalyzeByRegex {

    @NotNull
    public static final AnalyzeByRegex INSTANCE = new AnalyzeByRegex();

    private AnalyzeByRegex() {
    }

    public static /* synthetic */ List getElement$default(AnalyzeByRegex analyzeByRegex, String str, String[] strArr, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return analyzeByRegex.getElement(str, strArr, i2);
    }

    public static /* synthetic */ List getElements$default(AnalyzeByRegex analyzeByRegex, String str, String[] strArr, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return analyzeByRegex.getElements(str, strArr, i2);
    }

    @Nullable
    public final List<String> getElement(@NotNull String res, @NotNull String[] regs, int index) {
        j.e(res, "res");
        j.e(regs, "regs");
        Matcher matcher = Pattern.compile(regs[index]).matcher(res);
        if (!matcher.find()) {
            return null;
        }
        int i2 = index + 1;
        if (i2 != regs.length) {
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(matcher.group());
            } while (matcher.find());
            String string = sb.toString();
            j.d(string, "result.toString()");
            return getElement(string, regs, i2);
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int iGroupCount = matcher.groupCount();
        if (iGroupCount < 0) {
            return arrayList;
        }
        while (true) {
            int i4 = i3 + 1;
            String strGroup = matcher.group(i3);
            j.c(strGroup);
            arrayList.add(strGroup);
            if (i3 == iGroupCount) {
                return arrayList;
            }
            i3 = i4;
        }
    }

    @NotNull
    public final List<List<String>> getElements(@NotNull String res, @NotNull String[] regs, int index) {
        j.e(res, "res");
        j.e(regs, "regs");
        Matcher matcher = Pattern.compile(regs[index]).matcher(res);
        if (!matcher.find()) {
            return new ArrayList();
        }
        int i2 = index + 1;
        if (i2 != regs.length) {
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(matcher.group());
            } while (matcher.find());
            String string = sb.toString();
            j.d(string, "result.toString()");
            return getElements(string, regs, i2);
        }
        ArrayList arrayList = new ArrayList();
        do {
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            int iGroupCount = matcher.groupCount();
            if (iGroupCount >= 0) {
                while (true) {
                    int i4 = i3 + 1;
                    String strGroup = matcher.group(i3);
                    j.c(strGroup);
                    arrayList2.add(strGroup);
                    if (i3 == iGroupCount) {
                        break;
                    }
                    i3 = i4;
                }
            }
            arrayList.add(arrayList2);
        } while (matcher.find());
        return arrayList;
    }
}
