package com.jayway.jsonpath.spi.json;

import com.jayway.jsonpath.InvalidJsonException;
import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class JettisonProvider extends AbstractJsonProvider {

    /* JADX INFO: renamed from: com.jayway.jsonpath.spi.json.JettisonProvider$1, reason: invalid class name */
    public class AnonymousClass1 implements Iterable<Object>, Iterable {
        public final /* synthetic */ Object val$obj;

        public AnonymousClass1(Object obj) {
            this.val$obj = obj;
        }

        @Override // j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator<Object> iterator() {
            Object obj = this.val$obj;
            AnonymousClass1 anonymousClass1 = null;
            return obj instanceof JSONArray ? new JettisonArrayIterator((JSONArray) obj, anonymousClass1) : obj instanceof JSONObject ? new JettisonObjectIterator((JSONObject) obj, anonymousClass1) : Collections.emptyList().iterator();
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return v.o(iterator(), 0);
        }
    }

    public static class JettisonArray extends JSONArray implements Iterable<Object>, Iterable {
        private static final long serialVersionUID = 2;

        public /* synthetic */ JettisonArray(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator<Object> iterator() {
            return new JettisonArrayIterator(this, null);
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return v.o(iterator(), 0);
        }

        public /* synthetic */ JettisonArray(JettisonTokener jettisonTokener, AnonymousClass1 anonymousClass1) {
            this(jettisonTokener);
        }

        private JettisonArray(JettisonTokener jettisonTokener) {
            super(jettisonTokener);
        }

        private JettisonArray() {
        }
    }

    public static class JettisonArrayIterator implements Iterator<Object>, j$.util.Iterator {
        private int index;
        private final JSONArray jsonArray;

        public /* synthetic */ JettisonArrayIterator(JSONArray jSONArray, AnonymousClass1 anonymousClass1) {
            this(jSONArray);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.index < this.jsonArray.length();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            try {
                JSONArray jSONArray = this.jsonArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return JettisonProvider.jettisonUnwrap(jSONArray.get(i2));
            } catch (JSONException e2) {
                throw new NoSuchElementException(e2.toString());
            }
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private JettisonArrayIterator(JSONArray jSONArray) {
            this.index = 0;
            this.jsonArray = jSONArray;
        }
    }

    public static class JettisonObject extends JSONObject implements Iterable<Object>, Iterable {
        private static final long serialVersionUID = 1;

        public /* synthetic */ JettisonObject(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public java.util.Iterator<Object> iterator() {
            return new JettisonObjectIterator(this, null);
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return v.o(iterator(), 0);
        }

        public /* synthetic */ JettisonObject(JettisonTokener jettisonTokener, AnonymousClass1 anonymousClass1) {
            this(jettisonTokener);
        }

        private JettisonObject(JettisonTokener jettisonTokener) {
            super(jettisonTokener);
        }

        private JettisonObject() {
        }
    }

    public static class JettisonObjectIterator implements java.util.Iterator<Object>, j$.util.Iterator {
        private final java.util.Iterator<?> jsonKeysIt;
        private final JSONObject jsonObject;

        public /* synthetic */ JettisonObjectIterator(JSONObject jSONObject, AnonymousClass1 anonymousClass1) {
            this(jSONObject);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.jsonKeysIt.hasNext();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            try {
                return JettisonProvider.jettisonUnwrap(this.jsonObject.get(String.valueOf(this.jsonKeysIt.next())));
            } catch (JSONException e2) {
                throw new NoSuchElementException(e2.toString());
            }
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            this.jsonKeysIt.remove();
        }

        private JettisonObjectIterator(JSONObject jSONObject) {
            this.jsonObject = jSONObject;
            this.jsonKeysIt = jSONObject.keys();
        }
    }

    public static class JettisonTokener extends JSONTokener {
        public JettisonTokener(String str) {
            super(str);
        }

        /* JADX INFO: renamed from: newJSONArray, reason: merged with bridge method [inline-methods] */
        public JettisonArray m8newJSONArray() {
            return new JettisonArray(this, null);
        }

        /* JADX INFO: renamed from: newJSONObject, reason: merged with bridge method [inline-methods] */
        public JettisonObject m9newJSONObject() {
            return new JettisonObject(this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object jettisonUnwrap(Object obj) {
        if (obj == null || !obj.equals(JSONObject.NULL)) {
            return obj;
        }
        return null;
    }

    private static Object jettisonWrap(Object obj) {
        return obj == null ? JSONObject.NULL : obj;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.jettison.json.JSONException */
    private Object parse(JettisonTokener jettisonTokener) {
        try {
            char cNextClean = jettisonTokener.nextClean();
            jettisonTokener.back();
            AnonymousClass1 anonymousClass1 = null;
            if (cNextClean == '{') {
                return new JettisonObject(jettisonTokener, anonymousClass1);
            }
            if (cNextClean == '[') {
                return new JettisonArray(jettisonTokener, anonymousClass1);
            }
            throw new JSONException("Invalid JSON");
        } catch (JSONException e2) {
            throw new IllegalStateException((Throwable) e2);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object createMap() {
        return new JettisonObject((AnonymousClass1) null);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object getArrayIndex(Object obj, int i2) {
        return jettisonUnwrap(((JSONArray) obj).opt(i2));
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object getMapValue(Object obj, String str) {
        Object objOpt = ((JSONObject) obj).opt(str);
        return objOpt == null ? JsonProvider.UNDEFINED : jettisonUnwrap(objOpt);
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Collection<String> getPropertyKeys(Object obj) {
        ArrayList arrayList = new ArrayList(length(obj));
        if (obj instanceof JSONArray) {
            for (int i2 = 0; i2 < length(obj); i2++) {
                arrayList.add(String.valueOf(i2));
            }
        }
        if (obj instanceof JSONObject) {
            java.util.Iterator itKeys = ((JSONObject) obj).keys();
            while (itKeys.hasNext()) {
                arrayList.add(String.valueOf(itKeys.next()));
            }
        }
        return arrayList;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isArray(Object obj) {
        return obj instanceof JSONArray;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public boolean isMap(Object obj) {
        return obj instanceof JSONObject;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public int length(Object obj) {
        if (obj instanceof JSONArray) {
            return ((JSONArray) obj).length();
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).length();
        }
        if (obj instanceof String) {
            return ((String) obj).length();
        }
        return 0;
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void removeProperty(Object obj, Object obj2) {
        try {
            if (obj instanceof JSONArray) {
                int iIntValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : Integer.parseInt(obj2.toString());
                if (iIntValue < length(obj)) {
                    Object obj3 = new Object();
                    ((JSONArray) obj).put(iIntValue, obj3);
                    ((JSONArray) obj).remove(obj3);
                }
            }
            if (obj instanceof JSONObject) {
                ((JSONObject) obj).remove(String.valueOf(obj2));
            }
        } catch (JSONException e2) {
            throw new IllegalStateException((Throwable) e2);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void setArrayIndex(Object obj, int i2, Object obj2) {
        if (!isArray(obj)) {
            throw new UnsupportedOperationException();
        }
        try {
            ((JSONArray) obj).put(i2, jettisonWrap(obj2));
        } catch (JSONException e2) {
            throw new IllegalArgumentException((Throwable) e2);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public void setProperty(Object obj, Object obj2, Object obj3) {
        try {
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(obj2 instanceof Integer ? ((Integer) obj2).intValue() : Integer.parseInt(obj2.toString()), jettisonWrap(obj3));
            }
            if (obj instanceof JSONObject) {
                ((JSONObject) obj).put(String.valueOf(obj2), jettisonWrap(obj3));
            }
        } catch (JSONException e2) {
            throw new IllegalStateException((Throwable) e2);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Iterable<?> toIterable(Object obj) {
        return new AnonymousClass1(obj);
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public String toJson(Object obj) {
        try {
            return obj instanceof JSONArray ? ((JSONArray) obj).toString(2) : obj instanceof JSONObject ? ((JSONObject) obj).toString(2) : String.valueOf(obj);
        } catch (JSONException e2) {
            throw new IllegalStateException((Throwable) e2);
        }
    }

    @Override // com.jayway.jsonpath.spi.json.AbstractJsonProvider, com.jayway.jsonpath.spi.json.JsonProvider
    public Object unwrap(Object obj) {
        return jettisonUnwrap(obj);
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Iterable<?> createArray() {
        return new JettisonArray((AnonymousClass1) null);
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(String str) {
        return parse(new JettisonTokener(str));
    }

    @Override // com.jayway.jsonpath.spi.json.JsonProvider
    public Object parse(InputStream inputStream, String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 > 0) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                } else {
                    return parse(new JettisonTokener(new String(byteArrayOutputStream.toByteArray(), str)));
                }
            }
        } catch (IOException e2) {
            throw new InvalidJsonException(e2);
        }
    }
}
