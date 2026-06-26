package com.jayway.jsonpath.internal.path;

import c.a.a.a.a;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class ArrayIndexOperation {
    private static final Pattern COMMA = Pattern.compile("\\s*,\\s*");
    private final List<Integer> indexes;

    private ArrayIndexOperation(List<Integer> list) {
        this.indexes = Collections.unmodifiableList(list);
    }

    public static ArrayIndexOperation parse(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!Character.isDigit(cCharAt) && cCharAt != ',' && cCharAt != ' ' && cCharAt != '-') {
                throw new InvalidPathException(a.i("Failed to parse ArrayIndexOperation: ", str));
            }
        }
        String[] strArrSplit = COMMA.split(str, -1);
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            arrayList.add(parseInteger(str2));
        }
        return new ArrayIndexOperation(arrayList);
    }

    private static Integer parseInteger(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Exception e2) {
            throw new InvalidPathException(a.i("Failed to parse token in ArrayIndexOperation: ", str), e2);
        }
    }

    public List<Integer> indexes() {
        return this.indexes;
    }

    public boolean isSingleIndexOperation() {
        return this.indexes.size() == 1;
    }

    public String toString() {
        StringBuilder sbR = a.r("[");
        sbR.append(Utils.join(",", this.indexes));
        sbR.append("]");
        return sbR.toString();
    }
}
