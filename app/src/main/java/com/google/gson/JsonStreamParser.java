package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class JsonStreamParser implements Iterator<JsonElement>, j$.util.Iterator {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z = this.parser.peek() != JsonToken.END_DOCUMENT;
                    } catch (IOException e2) {
                        throw new JsonIOException(e2);
                    }
                } catch (MalformedJsonException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public JsonElement next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        } catch (JsonParseException e2) {
            if (e2.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e2;
        } catch (OutOfMemoryError e3) {
            throw new JsonParseException("Failed parsing JSON source to Json", e3);
        } catch (StackOverflowError e4) {
            throw new JsonParseException("Failed parsing JSON source to Json", e4);
        }
    }
}
