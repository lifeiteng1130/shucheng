package com.jayway.jsonpath.internal;

import c.a.a.a.a;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidModificationException;
import com.jayway.jsonpath.MapFunction;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.spi.json.JsonProvider;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathRef implements Comparable<PathRef> {
    public static final PathRef NO_OP = new PathRef(null) { // from class: com.jayway.jsonpath.internal.PathRef.1
        @Override // com.jayway.jsonpath.internal.PathRef
        public void add(Object obj, Configuration configuration) {
        }

        @Override // com.jayway.jsonpath.internal.PathRef, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(PathRef pathRef) {
            return super.compareTo(pathRef);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void convert(MapFunction mapFunction, Configuration configuration) {
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void delete(Configuration configuration) {
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public Object getAccessor() {
            return null;
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void put(String str, Object obj, Configuration configuration) {
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void renameKey(String str, String str2, Configuration configuration) {
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void set(Object obj, Configuration configuration) {
        }
    };
    public Object parent;

    public static class ArrayIndexPathRef extends PathRef {
        private int index;

        @Override // com.jayway.jsonpath.internal.PathRef
        public void add(Object obj, Configuration configuration) {
            Object arrayIndex = configuration.jsonProvider().getArrayIndex(this.parent, this.index);
            if (targetInvalid(arrayIndex)) {
                return;
            }
            if (!configuration.jsonProvider().isArray(arrayIndex)) {
                throw new InvalidModificationException("Can only add to an array");
            }
            configuration.jsonProvider().setProperty(arrayIndex, null, obj);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void convert(MapFunction mapFunction, Configuration configuration) {
            configuration.jsonProvider().setArrayIndex(this.parent, this.index, mapFunction.map(configuration.jsonProvider().getArrayIndex(this.parent, this.index), configuration));
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void delete(Configuration configuration) {
            configuration.jsonProvider().removeProperty(this.parent, Integer.valueOf(this.index));
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public Object getAccessor() {
            return Integer.valueOf(this.index);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void put(String str, Object obj, Configuration configuration) {
            Object arrayIndex = configuration.jsonProvider().getArrayIndex(this.parent, this.index);
            if (targetInvalid(arrayIndex)) {
                return;
            }
            if (!configuration.jsonProvider().isMap(arrayIndex)) {
                throw new InvalidModificationException("Can only add properties to a map");
            }
            configuration.jsonProvider().setProperty(arrayIndex, str, obj);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void renameKey(String str, String str2, Configuration configuration) {
            Object arrayIndex = configuration.jsonProvider().getArrayIndex(this.parent, this.index);
            if (targetInvalid(arrayIndex)) {
                return;
            }
            renameInMap(arrayIndex, str, str2, configuration);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void set(Object obj, Configuration configuration) {
            configuration.jsonProvider().setArrayIndex(this.parent, this.index, obj);
        }

        private ArrayIndexPathRef(Object obj, int i2) {
            super(obj);
            this.index = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.jayway.jsonpath.internal.PathRef, java.lang.Comparable
        public int compareTo(PathRef pathRef) {
            return pathRef instanceof ArrayIndexPathRef ? Integer.compare(((ArrayIndexPathRef) pathRef).index, this.index) : super.compareTo(pathRef);
        }
    }

    public static class ObjectMultiPropertyPathRef extends PathRef {
        private Collection<String> properties;

        @Override // com.jayway.jsonpath.internal.PathRef
        public void add(Object obj, Configuration configuration) {
            throw new InvalidModificationException("Add can not be performed to multiple properties");
        }

        @Override // com.jayway.jsonpath.internal.PathRef, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(PathRef pathRef) {
            return super.compareTo(pathRef);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void convert(MapFunction mapFunction, Configuration configuration) {
            for (String str : this.properties) {
                Object mapValue = configuration.jsonProvider().getMapValue(this.parent, str);
                if (mapValue != JsonProvider.UNDEFINED) {
                    configuration.jsonProvider().setProperty(this.parent, str, mapFunction.map(mapValue, configuration));
                }
            }
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void delete(Configuration configuration) {
            Iterator<String> it = this.properties.iterator();
            while (it.hasNext()) {
                configuration.jsonProvider().removeProperty(this.parent, it.next());
            }
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public Object getAccessor() {
            return Utils.join("&&", this.properties);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void put(String str, Object obj, Configuration configuration) {
            throw new InvalidModificationException("Put can not be performed to multiple properties");
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void renameKey(String str, String str2, Configuration configuration) {
            throw new InvalidModificationException("Rename can not be performed to multiple properties");
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void set(Object obj, Configuration configuration) {
            Iterator<String> it = this.properties.iterator();
            while (it.hasNext()) {
                configuration.jsonProvider().setProperty(this.parent, it.next(), obj);
            }
        }

        private ObjectMultiPropertyPathRef(Object obj, Collection<String> collection) {
            super(obj);
            this.properties = collection;
        }
    }

    public static class ObjectPropertyPathRef extends PathRef {
        private String property;

        @Override // com.jayway.jsonpath.internal.PathRef
        public void add(Object obj, Configuration configuration) {
            Object mapValue = configuration.jsonProvider().getMapValue(this.parent, this.property);
            if (targetInvalid(mapValue)) {
                return;
            }
            if (!configuration.jsonProvider().isArray(mapValue)) {
                throw new InvalidModificationException("Can only add to an array");
            }
            configuration.jsonProvider().setArrayIndex(mapValue, configuration.jsonProvider().length(mapValue), obj);
        }

        @Override // com.jayway.jsonpath.internal.PathRef, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(PathRef pathRef) {
            return super.compareTo(pathRef);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void convert(MapFunction mapFunction, Configuration configuration) {
            configuration.jsonProvider().setProperty(this.parent, this.property, mapFunction.map(configuration.jsonProvider().getMapValue(this.parent, this.property), configuration));
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void delete(Configuration configuration) {
            configuration.jsonProvider().removeProperty(this.parent, this.property);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public Object getAccessor() {
            return this.property;
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void put(String str, Object obj, Configuration configuration) {
            Object mapValue = configuration.jsonProvider().getMapValue(this.parent, this.property);
            if (targetInvalid(mapValue)) {
                return;
            }
            if (!configuration.jsonProvider().isMap(mapValue)) {
                throw new InvalidModificationException("Can only add properties to a map");
            }
            configuration.jsonProvider().setProperty(mapValue, str, obj);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void renameKey(String str, String str2, Configuration configuration) {
            Object mapValue = configuration.jsonProvider().getMapValue(this.parent, this.property);
            if (targetInvalid(mapValue)) {
                return;
            }
            renameInMap(mapValue, str, str2, configuration);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void set(Object obj, Configuration configuration) {
            configuration.jsonProvider().setProperty(this.parent, this.property, obj);
        }

        private ObjectPropertyPathRef(Object obj, String str) {
            super(obj);
            this.property = str;
        }
    }

    public static class RootPathRef extends PathRef {
        @Override // com.jayway.jsonpath.internal.PathRef
        public void add(Object obj, Configuration configuration) {
            if (!configuration.jsonProvider().isArray(this.parent)) {
                throw new InvalidModificationException("Invalid add operation. $ is not an array");
            }
            configuration.jsonProvider().setArrayIndex(this.parent, configuration.jsonProvider().length(this.parent), obj);
        }

        @Override // com.jayway.jsonpath.internal.PathRef, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(PathRef pathRef) {
            return super.compareTo(pathRef);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void convert(MapFunction mapFunction, Configuration configuration) {
            throw new InvalidModificationException("Invalid map operation");
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void delete(Configuration configuration) {
            throw new InvalidModificationException("Invalid delete operation");
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public Object getAccessor() {
            return "$";
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void put(String str, Object obj, Configuration configuration) {
            if (!configuration.jsonProvider().isMap(this.parent)) {
                throw new InvalidModificationException("Invalid put operation. $ is not a map");
            }
            configuration.jsonProvider().setProperty(this.parent, str, obj);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void renameKey(String str, String str2, Configuration configuration) {
            Object obj = this.parent;
            if (targetInvalid(obj)) {
                return;
            }
            renameInMap(obj, str, str2, configuration);
        }

        @Override // com.jayway.jsonpath.internal.PathRef
        public void set(Object obj, Configuration configuration) {
            throw new InvalidModificationException("Invalid set operation");
        }

        private RootPathRef(Object obj) {
            super(obj);
        }
    }

    public static PathRef create(Object obj, String str) {
        return new ObjectPropertyPathRef(obj, str);
    }

    public static PathRef createRoot(Object obj) {
        return new RootPathRef(obj);
    }

    public abstract void add(Object obj, Configuration configuration);

    public abstract void convert(MapFunction mapFunction, Configuration configuration);

    public abstract void delete(Configuration configuration);

    public abstract Object getAccessor();

    public abstract void put(String str, Object obj, Configuration configuration);

    public void renameInMap(Object obj, String str, String str2, Configuration configuration) {
        if (!configuration.jsonProvider().isMap(obj)) {
            throw new InvalidModificationException("Can only rename properties in a map");
        }
        if (configuration.jsonProvider().getMapValue(obj, str) == JsonProvider.UNDEFINED) {
            throw new PathNotFoundException(a.k("No results for Key ", str, " found in map!"));
        }
        configuration.jsonProvider().setProperty(obj, str2, configuration.jsonProvider().getMapValue(obj, str));
        configuration.jsonProvider().removeProperty(obj, str);
    }

    public abstract void renameKey(String str, String str2, Configuration configuration);

    public abstract void set(Object obj, Configuration configuration);

    public boolean targetInvalid(Object obj) {
        return obj == JsonProvider.UNDEFINED || obj == null;
    }

    private PathRef(Object obj) {
        this.parent = obj;
    }

    public static PathRef create(Object obj, Collection<String> collection) {
        return new ObjectMultiPropertyPathRef(obj, collection);
    }

    @Override // java.lang.Comparable
    public int compareTo(PathRef pathRef) {
        return getAccessor().toString().compareTo(pathRef.getAccessor().toString()) * (-1);
    }

    public static PathRef create(Object obj, int i2) {
        return new ArrayIndexPathRef(obj, i2);
    }
}
