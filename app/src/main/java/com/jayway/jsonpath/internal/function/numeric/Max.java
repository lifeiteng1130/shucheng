package com.jayway.jsonpath.internal.function.numeric;

/* JADX INFO: loaded from: classes.dex */
public class Max extends AbstractAggregation {
    private Double max = Double.valueOf(Double.MIN_VALUE);

    @Override // com.jayway.jsonpath.internal.function.numeric.AbstractAggregation
    public Number getValue() {
        return this.max;
    }

    @Override // com.jayway.jsonpath.internal.function.numeric.AbstractAggregation
    public void next(Number number) {
        if (this.max.doubleValue() < number.doubleValue()) {
            this.max = Double.valueOf(number.doubleValue());
        }
    }
}
