package b.a.b.w1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;

/* JADX INFO: compiled from: Config.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r {
    @NonNull
    public static Config a(@Nullable Config config, @Nullable Config config2) {
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        MutableOptionsBundle mutableOptionsBundleFrom = config2 != null ? MutableOptionsBundle.from(config2) : MutableOptionsBundle.create();
        if (config != null) {
            for (Config.Option<?> option : config.listOptions()) {
                mutableOptionsBundleFrom.insertOption(option, config.getOptionPriority(option), config.retrieveOption(option));
            }
        }
        return OptionsBundle.from(mutableOptionsBundleFrom);
    }
}
