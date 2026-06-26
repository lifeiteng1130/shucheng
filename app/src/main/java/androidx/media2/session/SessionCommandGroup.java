package androidx.media2.session;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.VersionedParcelable;
import c.a.a.a.a;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SessionCommandGroup implements VersionedParcelable {
    private static final String TAG = "SessionCommandGroup";
    public Set<SessionCommand> mCommands;

    public SessionCommandGroup() {
        this.mCommands = new HashSet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionCommandGroup)) {
            return false;
        }
        SessionCommandGroup sessionCommandGroup = (SessionCommandGroup) obj;
        Set<SessionCommand> set = this.mCommands;
        return set == null ? sessionCommandGroup.mCommands == null : set.equals(sessionCommandGroup.mCommands);
    }

    @NonNull
    public Set<SessionCommand> getCommands() {
        return new HashSet(this.mCommands);
    }

    public boolean hasCommand(@NonNull SessionCommand sessionCommand) {
        Objects.requireNonNull(sessionCommand, "command shouldn't be null");
        return this.mCommands.contains(sessionCommand);
    }

    public int hashCode() {
        return ObjectsCompat.hashCode(this.mCommands);
    }

    public static final class Builder {
        private Set<SessionCommand> mCommands;

        public Builder() {
            this.mCommands = new HashSet();
        }

        private void addCommands(int i2, SparseArray<List<Integer>> sparseArray) {
            for (int i3 = 0; i3 < sparseArray.size() && sparseArray.keyAt(i3) <= i2; i3++) {
                Iterator<Integer> it = sparseArray.valueAt(i3).iterator();
                while (it.hasNext()) {
                    addCommand(new SessionCommand(it.next().intValue()));
                }
            }
        }

        @NonNull
        public Builder addAllLibraryCommands(int i2) {
            addCommands(i2, SessionCommand.VERSION_LIBRARY_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addAllPlayerBasicCommands(int i2) {
            addCommands(i2, SessionCommand.VERSION_PLAYER_BASIC_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addAllPlayerCommands(int i2) {
            addAllPlayerBasicCommands(i2);
            addAllPlayerPlaylistCommands(i2);
            return this;
        }

        @NonNull
        public Builder addAllPlayerPlaylistCommands(int i2) {
            addCommands(i2, SessionCommand.VERSION_PLAYER_PLAYLIST_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addAllPredefinedCommands(int i2) {
            if (i2 < 1 || i2 > 2) {
                throw new IllegalArgumentException(a.G("Unknown command version ", i2));
            }
            addAllPlayerCommands(i2);
            addAllVolumeCommands(i2);
            addAllSessionCommands(i2);
            addAllLibraryCommands(i2);
            return this;
        }

        @NonNull
        public Builder addAllSessionCommands(int i2) {
            addCommands(i2, SessionCommand.VERSION_SESSION_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addAllVolumeCommands(int i2) {
            addCommands(i2, SessionCommand.VERSION_VOLUME_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addCommand(@NonNull SessionCommand sessionCommand) {
            Objects.requireNonNull(sessionCommand, "command shouldn't be null");
            this.mCommands.add(sessionCommand);
            return this;
        }

        @NonNull
        public SessionCommandGroup build() {
            return new SessionCommandGroup(this.mCommands);
        }

        @NonNull
        public Builder removeCommand(@NonNull SessionCommand sessionCommand) {
            Objects.requireNonNull(sessionCommand, "command shouldn't be null");
            this.mCommands.remove(sessionCommand);
            return this;
        }

        public Builder(@NonNull SessionCommandGroup sessionCommandGroup) {
            Objects.requireNonNull(sessionCommandGroup, "commandGroup shouldn't be null");
            this.mCommands = sessionCommandGroup.getCommands();
        }
    }

    public SessionCommandGroup(@Nullable Collection<SessionCommand> collection) {
        HashSet hashSet = new HashSet();
        this.mCommands = hashSet;
        if (collection != null) {
            hashSet.addAll(collection);
        }
    }

    public boolean hasCommand(int i2) {
        if (i2 != 0) {
            Iterator<SessionCommand> it = this.mCommands.iterator();
            while (it.hasNext()) {
                if (it.next().getCommandCode() == i2) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Use hasCommand(Command) for custom command");
    }
}
