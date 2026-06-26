package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfigFactory;
import b.a.b.w1.p;
import b.a.b.w1.u;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CameraConfigs {
    private static final CameraConfig EMPTY_CONFIG = new EmptyCameraConfig();

    public static final class EmptyCameraConfig implements CameraConfig {
        private final UseCaseConfigFactory mUseCaseConfigFactory = new UseCaseConfigFactory() { // from class: androidx.camera.core.impl.CameraConfigs.EmptyCameraConfig.1
            @Override // androidx.camera.core.impl.UseCaseConfigFactory
            @Nullable
            public Config getConfig(@NonNull UseCaseConfigFactory.CaptureType captureType) {
                return null;
            }
        };

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ boolean containsOption(Config.Option option) {
            return u.a(this, option);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            u.b(this, str, optionMatcher);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public /* synthetic */ CameraFilter getCameraFilter() {
            return p.a(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig
        @NonNull
        public Config getConfig() {
            return OptionsBundle.emptyBundle();
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return u.c(this, option);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Set getPriorities(Config.Option option) {
            return u.d(this, option);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        @NonNull
        public UseCaseConfigFactory getUseCaseConfigFactory() {
            return this.mUseCaseConfigFactory;
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Set listOptions() {
            return u.e(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Object retrieveOption(Config.Option option) {
            return u.f(this, option);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return u.g(this, option, obj);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            return u.h(this, option, optionPriority);
        }
    }

    private CameraConfigs() {
    }

    @NonNull
    public static CameraConfig emptyConfig() {
        return EMPTY_CONFIG;
    }
}
