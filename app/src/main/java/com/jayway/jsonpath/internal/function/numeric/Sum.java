package com.jayway.jsonpath.internal.function.numeric;

/* JADX INFO: loaded from: classes.dex */
public class Sum extends AbstractAggregation {
    private Double summation = Double.valueOf(0.0d);

    @Override // com.jayway.jsonpath.internal.function.numeric.AbstractAggregation
    public Number getValue() {
        return this.summation;
    }

    @Override // com.jayway.jsonpath.internal.function.numeric.AbstractAggregation
    public void next(Number number) {
        this.summation = Double.valueOf(number.doubleValue() + this.summation.doubleValue());
    }
}
