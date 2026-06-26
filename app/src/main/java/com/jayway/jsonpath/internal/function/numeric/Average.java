package com.jayway.jsonpath.internal.function.numeric;

/* JADX INFO: loaded from: classes.dex */
public class Average extends AbstractAggregation {
    private Double count;
    private Double summation;

    public Average() {
        Double dValueOf = Double.valueOf(0.0d);
        this.summation = dValueOf;
        this.count = dValueOf;
    }

    @Override // com.jayway.jsonpath.internal.function.numeric.AbstractAggregation
    public Number getValue() {
        return this.count.doubleValue() != 0.0d ? Double.valueOf(this.summation.doubleValue() / this.count.doubleValue()) : Double.valueOf(0.0d);
    }

    @Override // com.jayway.jsonpath.internal.function.numeric.AbstractAggregation
    public void next(Number number) {
        this.count = Double.valueOf(this.count.doubleValue() + 1.0d);
        this.summation = Double.valueOf(number.doubleValue() + this.summation.doubleValue());
    }
}
