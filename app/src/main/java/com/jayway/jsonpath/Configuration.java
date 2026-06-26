package com.jayway.jsonpath;

import com.jayway.jsonpath.internal.DefaultsImpl;
import com.jayway.jsonpath.internal.Utils;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Configuration {
    private static Defaults DEFAULTS;
    private final Collection<EvaluationListener> evaluationListeners;
    private final JsonProvider jsonProvider;
    private final MappingProvider mappingProvider;
    private final Set<Option> options;

    public static class ConfigurationBuilder {
        private JsonProvider jsonProvider;
        private MappingProvider mappingProvider;
        private EnumSet<Option> options = EnumSet.noneOf(Option.class);
        private Collection<EvaluationListener> evaluationListener = new ArrayList();

        public Configuration build() {
            if (this.jsonProvider == null || this.mappingProvider == null) {
                Defaults effectiveDefaults = Configuration.getEffectiveDefaults();
                if (this.jsonProvider == null) {
                    this.jsonProvider = effectiveDefaults.jsonProvider();
                }
                if (this.mappingProvider == null) {
                    this.mappingProvider = effectiveDefaults.mappingProvider();
                }
            }
            return new Configuration(this.jsonProvider, this.mappingProvider, this.options, this.evaluationListener);
        }

        public ConfigurationBuilder evaluationListener(EvaluationListener... evaluationListenerArr) {
            this.evaluationListener = Arrays.asList(evaluationListenerArr);
            return this;
        }

        public ConfigurationBuilder jsonProvider(JsonProvider jsonProvider) {
            this.jsonProvider = jsonProvider;
            return this;
        }

        public ConfigurationBuilder mappingProvider(MappingProvider mappingProvider) {
            this.mappingProvider = mappingProvider;
            return this;
        }

        public ConfigurationBuilder options(Option... optionArr) {
            if (optionArr.length > 0) {
                this.options.addAll(Arrays.asList(optionArr));
            }
            return this;
        }

        public ConfigurationBuilder evaluationListener(Collection<EvaluationListener> collection) {
            if (collection == null) {
                collection = Collections.emptyList();
            }
            this.evaluationListener = collection;
            return this;
        }

        public ConfigurationBuilder options(Set<Option> set) {
            this.options.addAll(set);
            return this;
        }
    }

    public interface Defaults {
        JsonProvider jsonProvider();

        MappingProvider mappingProvider();

        Set<Option> options();
    }

    public static ConfigurationBuilder builder() {
        return new ConfigurationBuilder();
    }

    public static Configuration defaultConfiguration() {
        Defaults effectiveDefaults = getEffectiveDefaults();
        return builder().jsonProvider(effectiveDefaults.jsonProvider()).options(effectiveDefaults.options()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Defaults getEffectiveDefaults() {
        Defaults defaults = DEFAULTS;
        return defaults == null ? DefaultsImpl.INSTANCE : defaults;
    }

    public static synchronized void setDefaults(Defaults defaults) {
        DEFAULTS = defaults;
    }

    public Configuration addEvaluationListeners(EvaluationListener... evaluationListenerArr) {
        return builder().jsonProvider(this.jsonProvider).mappingProvider(this.mappingProvider).options(this.options).evaluationListener(evaluationListenerArr).build();
    }

    public Configuration addOptions(Option... optionArr) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(Option.class);
        enumSetNoneOf.addAll(this.options);
        enumSetNoneOf.addAll(Arrays.asList(optionArr));
        return builder().jsonProvider(this.jsonProvider).mappingProvider(this.mappingProvider).options(enumSetNoneOf).evaluationListener(this.evaluationListeners).build();
    }

    public boolean containsOption(Option option) {
        return this.options.contains(option);
    }

    public Collection<EvaluationListener> getEvaluationListeners() {
        return this.evaluationListeners;
    }

    public Set<Option> getOptions() {
        return this.options;
    }

    public Configuration jsonProvider(JsonProvider jsonProvider) {
        return builder().jsonProvider(jsonProvider).mappingProvider(this.mappingProvider).options(this.options).evaluationListener(this.evaluationListeners).build();
    }

    public Configuration mappingProvider(MappingProvider mappingProvider) {
        return builder().jsonProvider(this.jsonProvider).mappingProvider(mappingProvider).options(this.options).evaluationListener(this.evaluationListeners).build();
    }

    public Configuration setEvaluationListeners(EvaluationListener... evaluationListenerArr) {
        return builder().jsonProvider(this.jsonProvider).mappingProvider(this.mappingProvider).options(this.options).evaluationListener(evaluationListenerArr).build();
    }

    public Configuration setOptions(Option... optionArr) {
        return builder().jsonProvider(this.jsonProvider).mappingProvider(this.mappingProvider).options(optionArr).evaluationListener(this.evaluationListeners).build();
    }

    private Configuration(JsonProvider jsonProvider, MappingProvider mappingProvider, EnumSet<Option> enumSet, Collection<EvaluationListener> collection) {
        Utils.notNull(jsonProvider, "jsonProvider can not be null", new Object[0]);
        Utils.notNull(mappingProvider, "mappingProvider can not be null", new Object[0]);
        Utils.notNull(enumSet, "setOptions can not be null", new Object[0]);
        Utils.notNull(collection, "evaluationListeners can not be null", new Object[0]);
        this.jsonProvider = jsonProvider;
        this.mappingProvider = mappingProvider;
        this.options = Collections.unmodifiableSet(enumSet);
        this.evaluationListeners = Collections.unmodifiableCollection(collection);
    }

    public JsonProvider jsonProvider() {
        return this.jsonProvider;
    }

    public MappingProvider mappingProvider() {
        return this.mappingProvider;
    }
}
