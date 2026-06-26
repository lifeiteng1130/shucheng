package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;

    @Nullable
    public final List<RoomDatabase.Callback> callbacks;

    @NonNull
    public final Context context;

    @Nullable
    public final String copyFromAssetPath;

    @Nullable
    public final File copyFromFile;

    @Nullable
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;

    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;

    @Nullable
    public final String name;

    @Nullable
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;

    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;

    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @NonNull
    public final Executor transactionExecutor;

    @NonNull
    public final List<Object> typeConverters;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, boolean z2, @Nullable Set<Integer> set) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor, false, z2, false, set, null, null, null, null, null);
    }

    public boolean isMigrationRequired(int i2, int i3) {
        Set<Integer> set;
        return !((i2 > i3) && this.allowDestructiveMigrationOnDowngrade) && this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(i2)));
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int i2) {
        return isMigrationRequired(i2, i2 + 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, null, null, null, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, str2, file, null, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, str2, file, callable, null, null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback, null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @Nullable List<Object> list2) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context;
        this.name = str;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidation = z2;
        this.requireMigration = z3;
        this.allowDestructiveMigrationOnDowngrade = z4;
        this.mMigrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = list2 == null ? Collections.emptyList() : list2;
    }
}
