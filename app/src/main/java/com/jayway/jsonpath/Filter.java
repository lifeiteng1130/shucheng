package com.jayway.jsonpath;

import c.a.a.a.a;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.filter.FilterCompiler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class Filter implements Predicate {

    public static final class OrFilter extends Filter {
        private final Predicate left;
        private final Predicate right;

        @Override // com.jayway.jsonpath.Filter
        public Filter and(Predicate predicate) {
            return new OrFilter(this.left, new AndFilter(this.right, predicate));
        }

        @Override // com.jayway.jsonpath.Filter, com.jayway.jsonpath.Predicate
        public boolean apply(Predicate.PredicateContext predicateContext) {
            return this.left.apply(predicateContext) || this.right.apply(predicateContext);
        }

        public String toString() {
            StringBuilder sbR = a.r("[?(");
            String string = this.left.toString();
            String string2 = this.right.toString();
            if (string.startsWith("[?(")) {
                string = string.substring(3, string.length() - 2);
            }
            if (string2.startsWith("[?(")) {
                string2 = string2.substring(3, string2.length() - 2);
            }
            sbR.append(string);
            sbR.append(" || ");
            sbR.append(string2);
            sbR.append(")]");
            return sbR.toString();
        }

        private OrFilter(Predicate predicate, Predicate predicate2) {
            this.left = predicate;
            this.right = predicate2;
        }
    }

    public static final class SingleFilter extends Filter {
        private final Predicate predicate;

        @Override // com.jayway.jsonpath.Filter, com.jayway.jsonpath.Predicate
        public boolean apply(Predicate.PredicateContext predicateContext) {
            return this.predicate.apply(predicateContext);
        }

        public String toString() {
            String string = this.predicate.toString();
            return string.startsWith("(") ? a.k("[?", string, "]") : a.k("[?(", string, ")]");
        }

        private SingleFilter(Predicate predicate) {
            this.predicate = predicate;
        }
    }

    public static Filter filter(Predicate predicate) {
        return new SingleFilter(predicate);
    }

    public static Filter parse(String str) {
        return FilterCompiler.compile(str);
    }

    public Filter and(Predicate predicate) {
        return new AndFilter(this, predicate);
    }

    @Override // com.jayway.jsonpath.Predicate
    public abstract boolean apply(Predicate.PredicateContext predicateContext);

    public Filter or(Predicate predicate) {
        return new OrFilter(this, predicate);
    }

    public static final class AndFilter extends Filter {
        private final Collection<Predicate> predicates;

        @Override // com.jayway.jsonpath.Filter
        public Filter and(Predicate predicate) {
            ArrayList arrayList = new ArrayList(this.predicates);
            arrayList.add(predicate);
            return new AndFilter(arrayList);
        }

        @Override // com.jayway.jsonpath.Filter, com.jayway.jsonpath.Predicate
        public boolean apply(Predicate.PredicateContext predicateContext) {
            Iterator<Predicate> it = this.predicates.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(predicateContext)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            Iterator<Predicate> it = this.predicates.iterator();
            StringBuilder sbR = a.r("[?(");
            while (it.hasNext()) {
                String string = it.next().toString();
                if (string.startsWith("[?(")) {
                    string = string.substring(3, string.length() - 2);
                }
                sbR.append(string);
                if (it.hasNext()) {
                    sbR.append(" && ");
                }
            }
            sbR.append(")]");
            return sbR.toString();
        }

        private AndFilter(Collection<Predicate> collection) {
            this.predicates = collection;
        }

        private AndFilter(Predicate predicate, Predicate predicate2) {
            this(Arrays.asList(predicate, predicate2));
        }
    }

    public static Filter filter(Collection<Predicate> collection) {
        return new AndFilter(collection);
    }
}
