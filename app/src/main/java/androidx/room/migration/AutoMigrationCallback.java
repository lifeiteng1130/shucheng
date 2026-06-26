package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface AutoMigrationCallback {
    void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
