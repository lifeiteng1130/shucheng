package com.jayway.jsonpath.internal.function.numeric;

/* JADX INFO: loaded from: classes.dex */
public class Min extends AbstractAggregation {
    private Double min = Double.valueOf(Double.MAX_VALUE);

    @Override // com.jayway.jsonpath.internal.function.numeric.AbstractAggregation
    public Number getValue() {
        return this.min;
    }

    @Override // com.jayway.jsonpath.internal.function.numeric.AbstractAggregation
    public void next(Number number) {
        if (this.min.doubleValue() > number.doubleValue()) {
            this.min = Double.valueOf(number.doubleValue());
        }
    }
}
