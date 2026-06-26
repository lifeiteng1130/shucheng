package com.jayway.jsonpath.spi.mapper;

import c.a.a.a.a;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.TypeRef;
import i.a.b.g;
import i.a.b.i;
import i.a.b.m.j;
import i.a.b.m.k;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class JsonSmartMappingProvider implements MappingProvider {
    private static j DEFAULT;
    private final Callable<j> factory;

    public static class BigDecimalReader extends k<BigDecimal> {
        public BigDecimalReader() {
            super(null);
        }

        @Override // i.a.b.m.k
        public BigDecimal convert(Object obj) {
            if (obj == null) {
                return null;
            }
            return new BigDecimal(obj.toString());
        }
    }

    public static class BigIntegerReader extends k<BigInteger> {
        public BigIntegerReader() {
            super(null);
        }

        @Override // i.a.b.m.k
        public BigInteger convert(Object obj) {
            if (obj == null) {
                return null;
            }
            return new BigInteger(obj.toString());
        }
    }

    public static class BooleanReader extends k<Boolean> {
        public BooleanReader() {
            super(null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // i.a.b.m.k
        public Boolean convert(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Boolean.class.isAssignableFrom(obj.getClass())) {
                return (Boolean) obj;
            }
            StringBuilder sbR = a.r("can not map a ");
            sbR.append(obj.getClass());
            sbR.append(" to ");
            sbR.append(Boolean.class.getName());
            throw new MappingException(sbR.toString());
        }
    }

    public static class DateReader extends k<Date> {
        public DateReader() {
            super(null);
        }

        @Override // i.a.b.m.k
        public Date convert(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Date.class.isAssignableFrom(obj.getClass())) {
                return (Date) obj;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return new Date(((Long) obj).longValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                try {
                    return DateFormat.getInstance().parse(obj.toString());
                } catch (ParseException e2) {
                    throw new MappingException(e2);
                }
            }
            StringBuilder sbR = a.r("can not map a ");
            sbR.append(obj.getClass());
            sbR.append(" to ");
            sbR.append(Date.class.getName());
            throw new MappingException(sbR.toString());
        }
    }

    public static class DoubleReader extends k<Double> {
        public DoubleReader() {
            super(null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // i.a.b.m.k
        public Double convert(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return (Double) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(((Integer) obj).doubleValue());
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(((Long) obj).doubleValue());
            }
            if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(((BigDecimal) obj).doubleValue());
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(((Float) obj).doubleValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(obj.toString());
            }
            StringBuilder sbR = a.r("can not map a ");
            sbR.append(obj.getClass());
            sbR.append(" to ");
            sbR.append(Double.class.getName());
            throw new MappingException(sbR.toString());
        }
    }

    public static class FloatReader extends k<Float> {
        public FloatReader() {
            super(null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // i.a.b.m.k
        public Float convert(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return (Float) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(((Integer) obj).floatValue());
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(((Long) obj).floatValue());
            }
            if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(((BigDecimal) obj).floatValue());
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(((Double) obj).floatValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(obj.toString());
            }
            StringBuilder sbR = a.r("can not map a ");
            sbR.append(obj.getClass());
            sbR.append(" to ");
            sbR.append(Float.class.getName());
            throw new MappingException(sbR.toString());
        }
    }

    public static class IntegerReader extends k<Integer> {
        public IntegerReader() {
            super(null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // i.a.b.m.k
        public Integer convert(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return (Integer) obj;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(((Long) obj).intValue());
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(((Double) obj).intValue());
            }
            if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(((BigDecimal) obj).intValue());
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(((Float) obj).intValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(obj.toString());
            }
            StringBuilder sbR = a.r("can not map a ");
            sbR.append(obj.getClass());
            sbR.append(" to ");
            sbR.append(Integer.class.getName());
            throw new MappingException(sbR.toString());
        }
    }

    public static class LongReader extends k<Long> {
        public LongReader() {
            super(null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // i.a.b.m.k
        public Long convert(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return (Long) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(((Integer) obj).longValue());
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(((Double) obj).longValue());
            }
            if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(((BigDecimal) obj).longValue());
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(((Float) obj).longValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(obj.toString());
            }
            StringBuilder sbR = a.r("can not map a ");
            sbR.append(obj.getClass());
            sbR.append(" to ");
            sbR.append(Long.class.getName());
            throw new MappingException(sbR.toString());
        }
    }

    public static class StringReader extends k<String> {
        public StringReader() {
            super(null);
        }

        @Override // i.a.b.m.k
        public String convert(Object obj) {
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
    }

    static {
        j jVar = new j();
        DEFAULT = jVar;
        jVar.a.put(Long.class, new LongReader());
        j jVar2 = DEFAULT;
        jVar2.a.put(Long.TYPE, new LongReader());
        j jVar3 = DEFAULT;
        jVar3.a.put(Integer.class, new IntegerReader());
        j jVar4 = DEFAULT;
        jVar4.a.put(Integer.TYPE, new IntegerReader());
        j jVar5 = DEFAULT;
        jVar5.a.put(Double.class, new DoubleReader());
        j jVar6 = DEFAULT;
        jVar6.a.put(Double.TYPE, new DoubleReader());
        j jVar7 = DEFAULT;
        jVar7.a.put(Float.class, new FloatReader());
        j jVar8 = DEFAULT;
        jVar8.a.put(Float.TYPE, new FloatReader());
        j jVar9 = DEFAULT;
        jVar9.a.put(BigDecimal.class, new BigDecimalReader());
        j jVar10 = DEFAULT;
        jVar10.a.put(String.class, new StringReader());
        j jVar11 = DEFAULT;
        jVar11.a.put(Date.class, new DateReader());
        j jVar12 = DEFAULT;
        jVar12.a.put(BigInteger.class, new BigIntegerReader());
        j jVar13 = DEFAULT;
        jVar13.a.put(Boolean.TYPE, new BooleanReader());
    }

    public JsonSmartMappingProvider(final j jVar) {
        this(new Callable<j>() { // from class: com.jayway.jsonpath.spi.mapper.JsonSmartMappingProvider.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public j call() {
                return jVar;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jayway.jsonpath.spi.mapper.MappingProvider
    public <T> T map(Object obj, Class<T> cls, Configuration configuration) {
        if (obj == 0) {
            return null;
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        try {
            if (!configuration.jsonProvider().isMap(obj) && !configuration.jsonProvider().isArray(obj)) {
                return this.factory.call().a(cls).convert(obj);
            }
            String json = configuration.jsonProvider().toJson(obj);
            g gVar = i.a;
            try {
                return (T) new i.a.b.k.a(i.a.b.k.a.a).c(json, i.f6361c.a(cls));
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e2) {
            throw new MappingException(e2);
        }
    }

    public JsonSmartMappingProvider(Callable<j> callable) {
        this.factory = callable;
    }

    public JsonSmartMappingProvider() {
        this(DEFAULT);
    }

    @Override // com.jayway.jsonpath.spi.mapper.MappingProvider
    public <T> T map(Object obj, TypeRef<T> typeRef, Configuration configuration) {
        throw new UnsupportedOperationException("Json-smart provider does not support TypeRef! Use a Jackson or Gson based provider");
    }
}
