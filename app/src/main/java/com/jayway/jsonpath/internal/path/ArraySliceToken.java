package com.jayway.jsonpath.internal.path;

import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.path.ArraySliceOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class ArraySliceToken extends ArrayPathToken {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ArraySliceToken.class);
    private final ArraySliceOperation operation;

    /* JADX INFO: renamed from: com.jayway.jsonpath.internal.path.ArraySliceToken$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$jayway$jsonpath$internal$path$ArraySliceOperation$Operation;

        static {
            ArraySliceOperation.Operation.values();
            int[] iArr = new int[3];
            $SwitchMap$com$jayway$jsonpath$internal$path$ArraySliceOperation$Operation = iArr;
            try {
                iArr[ArraySliceOperation.Operation.SLICE_FROM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$jayway$jsonpath$internal$path$ArraySliceOperation$Operation[ArraySliceOperation.Operation.SLICE_BETWEEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$jayway$jsonpath$internal$path$ArraySliceOperation$Operation[ArraySliceOperation.Operation.SLICE_TO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ArraySliceToken(ArraySliceOperation arraySliceOperation) {
        this.operation = arraySliceOperation;
    }

    private void sliceBetween(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        int length = evaluationContextImpl.jsonProvider().length(obj);
        int iIntValue = this.operation.from().intValue();
        int iMin = Math.min(length, this.operation.to().intValue());
        if (iIntValue >= iMin || length == 0) {
            return;
        }
        logger.debug("Slice between indexes on array with length: {}. From index: {} to: {}. Input: {}", Integer.valueOf(length), Integer.valueOf(iIntValue), Integer.valueOf(iMin), toString());
        while (iIntValue < iMin) {
            handleArrayIndex(iIntValue, str, obj, evaluationContextImpl);
            iIntValue++;
        }
    }

    private void sliceFrom(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        int length = evaluationContextImpl.jsonProvider().length(obj);
        int iIntValue = this.operation.from().intValue();
        if (iIntValue < 0) {
            iIntValue += length;
        }
        int iMax = Math.max(0, iIntValue);
        logger.debug("Slice from index on array with length: {}. From index: {} to: {}. Input: {}", Integer.valueOf(length), Integer.valueOf(iMax), Integer.valueOf(length - 1), toString());
        if (length == 0 || iMax >= length) {
            return;
        }
        while (iMax < length) {
            handleArrayIndex(iMax, str, obj, evaluationContextImpl);
            iMax++;
        }
    }

    private void sliceTo(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        int length = evaluationContextImpl.jsonProvider().length(obj);
        if (length == 0) {
            return;
        }
        int iIntValue = this.operation.to().intValue();
        if (iIntValue < 0) {
            iIntValue += length;
        }
        int iMin = Math.min(length, iIntValue);
        logger.debug("Slice to index on array with length: {}. From index: 0 to: {}. Input: {}", Integer.valueOf(length), Integer.valueOf(iMin), toString());
        for (int i2 = 0; i2 < iMin; i2++) {
            handleArrayIndex(i2, str, obj, evaluationContextImpl);
        }
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public void evaluate(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        if (checkArrayModel(str, obj, evaluationContextImpl)) {
            int iOrdinal = this.operation.operation().ordinal();
            if (iOrdinal == 0) {
                sliceFrom(str, pathRef, obj, evaluationContextImpl);
            } else if (iOrdinal == 1) {
                sliceTo(str, pathRef, obj, evaluationContextImpl);
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                sliceBetween(str, pathRef, obj, evaluationContextImpl);
            }
        }
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public String getPathFragment() {
        return this.operation.toString();
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public boolean isTokenDefinite() {
        return false;
    }
}
