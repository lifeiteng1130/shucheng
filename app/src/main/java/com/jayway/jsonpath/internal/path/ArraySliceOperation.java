package com.jayway.jsonpath.internal.path;

import c.a.a.a.a;
import com.jayway.jsonpath.InvalidPathException;

/* JADX INFO: loaded from: classes.dex */
public class ArraySliceOperation {
    private final Integer from;
    private final Operation operation;
    private final Integer to;

    public enum Operation {
        SLICE_FROM,
        SLICE_TO,
        SLICE_BETWEEN
    }

    private ArraySliceOperation(Integer num, Integer num2, Operation operation) {
        this.from = num;
        this.to = num2;
        this.operation = operation;
    }

    public static ArraySliceOperation parse(String str) {
        Operation operation;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!Character.isDigit(cCharAt) && cCharAt != '-' && cCharAt != ':') {
                throw new InvalidPathException(a.i("Failed to parse SliceOperation: ", str));
            }
        }
        String[] strArrSplit = str.split(":");
        Integer numTryRead = tryRead(strArrSplit, 0);
        Integer numTryRead2 = tryRead(strArrSplit, 1);
        if (numTryRead != null && numTryRead2 == null) {
            operation = Operation.SLICE_FROM;
        } else if (numTryRead != null) {
            operation = Operation.SLICE_BETWEEN;
        } else {
            if (numTryRead2 == null) {
                throw new InvalidPathException(a.i("Failed to parse SliceOperation: ", str));
            }
            operation = Operation.SLICE_TO;
        }
        return new ArraySliceOperation(numTryRead, numTryRead2, operation);
    }

    private static Integer tryRead(String[] strArr, int i2) {
        if (strArr.length <= i2 || strArr[i2].equals("")) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(strArr[i2]));
    }

    public Integer from() {
        return this.from;
    }

    public Operation operation() {
        return this.operation;
    }

    public Integer to() {
        return this.to;
    }

    public String toString() {
        StringBuilder sbR = a.r("[");
        Integer num = this.from;
        sbR.append(num == null ? "" : num.toString());
        sbR.append(":");
        Integer num2 = this.to;
        return a.p(sbR, num2 != null ? num2.toString() : "", "]");
    }
}
