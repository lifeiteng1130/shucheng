package androidx.media2.session;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.Surface;
import androidx.versionedparcelable.ParcelImpl;
import c.a.a.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaSession extends IInterface {

    public static class Default implements IMediaSession {
        @Override // androidx.media2.session.IMediaSession
        public void addPlaylistItem(IMediaController iMediaController, int i2, int i3, String str) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void adjustVolume(IMediaController iMediaController, int i2, int i3, int i4) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media2.session.IMediaSession
        public void connect(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void deselectTrack(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void fastForward(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void getChildren(IMediaController iMediaController, int i2, String str, int i3, int i4, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void getItem(IMediaController iMediaController, int i2, String str) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void getLibraryRoot(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void getSearchResult(IMediaController iMediaController, int i2, String str, int i3, int i4, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void movePlaylistItem(IMediaController iMediaController, int i2, int i3, int i4) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void onControllerResult(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void onCustomCommand(IMediaController iMediaController, int i2, ParcelImpl parcelImpl, Bundle bundle) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void pause(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void play(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void prepare(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void release(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void removePlaylistItem(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void replacePlaylistItem(IMediaController iMediaController, int i2, int i3, String str) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void rewind(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void search(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void seekTo(IMediaController iMediaController, int i2, long j2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void selectTrack(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setMediaItem(IMediaController iMediaController, int i2, String str) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setMediaUri(IMediaController iMediaController, int i2, Uri uri, Bundle bundle) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setPlaybackSpeed(IMediaController iMediaController, int i2, float f2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setPlaylist(IMediaController iMediaController, int i2, List<String> list, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setRating(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setRepeatMode(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setShuffleMode(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setSurface(IMediaController iMediaController, int i2, Surface surface) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void setVolumeTo(IMediaController iMediaController, int i2, int i3, int i4) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipBackward(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipForward(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToNextItem(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToPlaylistItem(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToPreviousItem(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void subscribe(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void unsubscribe(IMediaController iMediaController, int i2, String str) {
        }

        @Override // androidx.media2.session.IMediaSession
        public void updatePlaylistMetadata(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
        }
    }

    public static abstract class Stub extends Binder implements IMediaSession {
        private static final String DESCRIPTOR = "androidx.media2.session.IMediaSession";
        public static final int TRANSACTION_addPlaylistItem = 25;
        public static final int TRANSACTION_adjustVolume = 4;
        public static final int TRANSACTION_connect = 1;
        public static final int TRANSACTION_deselectTrack = 43;
        public static final int TRANSACTION_fastForward = 8;
        public static final int TRANSACTION_getChildren = 36;
        public static final int TRANSACTION_getItem = 35;
        public static final int TRANSACTION_getLibraryRoot = 34;
        public static final int TRANSACTION_getSearchResult = 38;
        public static final int TRANSACTION_movePlaylistItem = 44;
        public static final int TRANSACTION_onControllerResult = 33;
        public static final int TRANSACTION_onCustomCommand = 13;
        public static final int TRANSACTION_pause = 6;
        public static final int TRANSACTION_play = 5;
        public static final int TRANSACTION_prepare = 7;
        public static final int TRANSACTION_release = 2;
        public static final int TRANSACTION_removePlaylistItem = 26;
        public static final int TRANSACTION_replacePlaylistItem = 27;
        public static final int TRANSACTION_rewind = 9;
        public static final int TRANSACTION_search = 37;
        public static final int TRANSACTION_seekTo = 12;
        public static final int TRANSACTION_selectTrack = 42;
        public static final int TRANSACTION_setMediaItem = 23;
        public static final int TRANSACTION_setMediaUri = 45;
        public static final int TRANSACTION_setPlaybackSpeed = 21;
        public static final int TRANSACTION_setPlaylist = 22;
        public static final int TRANSACTION_setRating = 20;
        public static final int TRANSACTION_setRepeatMode = 31;
        public static final int TRANSACTION_setShuffleMode = 32;
        public static final int TRANSACTION_setSurface = 41;
        public static final int TRANSACTION_setVolumeTo = 3;
        public static final int TRANSACTION_skipBackward = 11;
        public static final int TRANSACTION_skipForward = 10;
        public static final int TRANSACTION_skipToNextItem = 30;
        public static final int TRANSACTION_skipToPlaylistItem = 28;
        public static final int TRANSACTION_skipToPreviousItem = 29;
        public static final int TRANSACTION_subscribe = 39;
        public static final int TRANSACTION_unsubscribe = 40;
        public static final int TRANSACTION_updatePlaylistMetadata = 24;

        public static class Proxy implements IMediaSession {
            public static IMediaSession sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // androidx.media2.session.IMediaSession
            public void addPlaylistItem(IMediaController iMediaController, int i2, int i3, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(25, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().addPlaylistItem(iMediaController, i2, i3, str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void adjustVolume(IMediaController iMediaController, int i2, int i3, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (this.mRemote.transact(4, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().adjustVolume(iMediaController, i2, i3, i4);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.media2.session.IMediaSession
            public void connect(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().connect(iMediaController, i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void deselectTrack(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(43, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().deselectTrack(iMediaController, i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void fastForward(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(8, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().fastForward(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getChildren(IMediaController iMediaController, int i2, String str, int i3, int i4, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(36, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getChildren(iMediaController, i2, str, i3, i4, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // androidx.media2.session.IMediaSession
            public void getItem(IMediaController iMediaController, int i2, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(35, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getItem(iMediaController, i2, str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getLibraryRoot(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(34, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getLibraryRoot(iMediaController, i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getSearchResult(IMediaController iMediaController, int i2, String str, int i3, int i4, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(38, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getSearchResult(iMediaController, i2, str, i3, i4, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void movePlaylistItem(IMediaController iMediaController, int i2, int i3, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (this.mRemote.transact(44, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().movePlaylistItem(iMediaController, i2, i3, i4);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void onControllerResult(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(33, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onControllerResult(iMediaController, i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void onCustomCommand(IMediaController iMediaController, int i2, ParcelImpl parcelImpl, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(13, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCustomCommand(iMediaController, i2, parcelImpl, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void pause(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(6, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().pause(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void play(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(5, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().play(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void prepare(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(7, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().prepare(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void release(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(2, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().release(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void removePlaylistItem(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.mRemote.transact(26, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().removePlaylistItem(iMediaController, i2, i3);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void replacePlaylistItem(IMediaController iMediaController, int i2, int i3, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(27, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().replacePlaylistItem(iMediaController, i2, i3, str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void rewind(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(9, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().rewind(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void search(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(37, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().search(iMediaController, i2, str, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void seekTo(IMediaController iMediaController, int i2, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j2);
                    if (this.mRemote.transact(12, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekTo(iMediaController, i2, j2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void selectTrack(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(42, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().selectTrack(iMediaController, i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setMediaItem(IMediaController iMediaController, int i2, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(23, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setMediaItem(iMediaController, i2, str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setMediaUri(IMediaController iMediaController, int i2, Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(45, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setMediaUri(iMediaController, i2, uri, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setPlaybackSpeed(IMediaController iMediaController, int i2, float f2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeFloat(f2);
                    if (this.mRemote.transact(21, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setPlaybackSpeed(iMediaController, i2, f2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setPlaylist(IMediaController iMediaController, int i2, List<String> list, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStringList(list);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(22, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setPlaylist(iMediaController, i2, list, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setRating(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(20, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setRating(iMediaController, i2, str, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setRepeatMode(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.mRemote.transact(31, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setRepeatMode(iMediaController, i2, i3);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setShuffleMode(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.mRemote.transact(32, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setShuffleMode(iMediaController, i2, i3);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setSurface(IMediaController iMediaController, int i2, Surface surface) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (surface != null) {
                        parcelObtain.writeInt(1);
                        surface.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(41, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setSurface(iMediaController, i2, surface);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setVolumeTo(IMediaController iMediaController, int i2, int i3, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    if (this.mRemote.transact(3, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setVolumeTo(iMediaController, i2, i3, i4);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipBackward(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(11, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().skipBackward(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipForward(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(10, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().skipForward(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToNextItem(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(30, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().skipToNextItem(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToPlaylistItem(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.mRemote.transact(28, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().skipToPlaylistItem(iMediaController, i2, i3);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToPreviousItem(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(29, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().skipToPreviousItem(iMediaController, i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void subscribe(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(39, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().subscribe(iMediaController, i2, str, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void unsubscribe(IMediaController iMediaController, int i2, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(40, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().unsubscribe(iMediaController, i2, str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void updatePlaylistMetadata(IMediaController iMediaController, int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(24, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().updatePlaylistMetadata(iMediaController, i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSession)) ? new Proxy(iBinder) : (IMediaSession) iInterfaceQueryLocalInterface;
        }

        public static IMediaSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMediaSession iMediaSession) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMediaSession == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMediaSession;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i2) {
                case 1:
                    connect(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    release(a.C(parcel, DESCRIPTOR), parcel.readInt());
                    return true;
                case 3:
                    setVolumeTo(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 4:
                    adjustVolume(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 5:
                    play(a.C(parcel, DESCRIPTOR), parcel.readInt());
                    return true;
                case 6:
                    pause(a.C(parcel, DESCRIPTOR), parcel.readInt());
                    return true;
                case 7:
                    prepare(a.C(parcel, DESCRIPTOR), parcel.readInt());
                    return true;
                case 8:
                    fastForward(a.C(parcel, DESCRIPTOR), parcel.readInt());
                    return true;
                case 9:
                    rewind(a.C(parcel, DESCRIPTOR), parcel.readInt());
                    return true;
                case 10:
                    skipForward(a.C(parcel, DESCRIPTOR), parcel.readInt());
                    return true;
                case 11:
                    skipBackward(a.C(parcel, DESCRIPTOR), parcel.readInt());
                    return true;
                case 12:
                    seekTo(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readLong());
                    return true;
                case 13:
                    onCustomCommand(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                default:
                    switch (i2) {
                        case 20:
                            setRating(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 21:
                            setPlaybackSpeed(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readFloat());
                            return true;
                        case 22:
                            setPlaylist(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.createStringArrayList(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 23:
                            setMediaItem(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readString());
                            return true;
                        case 24:
                            updatePlaylistMetadata(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 25:
                            addPlaylistItem(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt(), parcel.readString());
                            return true;
                        case 26:
                            removePlaylistItem(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt());
                            return true;
                        case 27:
                            replacePlaylistItem(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt(), parcel.readString());
                            return true;
                        case 28:
                            skipToPlaylistItem(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt());
                            return true;
                        case 29:
                            skipToPreviousItem(a.C(parcel, DESCRIPTOR), parcel.readInt());
                            return true;
                        case 30:
                            skipToNextItem(a.C(parcel, DESCRIPTOR), parcel.readInt());
                            return true;
                        case 31:
                            setRepeatMode(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt());
                            return true;
                        case 32:
                            setShuffleMode(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt());
                            return true;
                        case 33:
                            onControllerResult(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 34:
                            getLibraryRoot(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 35:
                            getItem(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readString());
                            return true;
                        case 36:
                            getChildren(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 37:
                            search(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 38:
                            getSearchResult(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 39:
                            subscribe(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 40:
                            unsubscribe(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readString());
                            return true;
                        case 41:
                            setSurface(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 42:
                            selectTrack(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 43:
                            deselectTrack(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 44:
                            movePlaylistItem(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt(), parcel.readInt());
                            return true;
                        case 45:
                            setMediaUri(a.C(parcel, DESCRIPTOR), parcel.readInt(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
            }
        }
    }

    void addPlaylistItem(IMediaController iMediaController, int i2, int i3, String str);

    void adjustVolume(IMediaController iMediaController, int i2, int i3, int i4);

    void connect(IMediaController iMediaController, int i2, ParcelImpl parcelImpl);

    void deselectTrack(IMediaController iMediaController, int i2, ParcelImpl parcelImpl);

    void fastForward(IMediaController iMediaController, int i2);

    void getChildren(IMediaController iMediaController, int i2, String str, int i3, int i4, ParcelImpl parcelImpl);

    void getItem(IMediaController iMediaController, int i2, String str);

    void getLibraryRoot(IMediaController iMediaController, int i2, ParcelImpl parcelImpl);

    void getSearchResult(IMediaController iMediaController, int i2, String str, int i3, int i4, ParcelImpl parcelImpl);

    void movePlaylistItem(IMediaController iMediaController, int i2, int i3, int i4);

    void onControllerResult(IMediaController iMediaController, int i2, ParcelImpl parcelImpl);

    void onCustomCommand(IMediaController iMediaController, int i2, ParcelImpl parcelImpl, Bundle bundle);

    void pause(IMediaController iMediaController, int i2);

    void play(IMediaController iMediaController, int i2);

    void prepare(IMediaController iMediaController, int i2);

    void release(IMediaController iMediaController, int i2);

    void removePlaylistItem(IMediaController iMediaController, int i2, int i3);

    void replacePlaylistItem(IMediaController iMediaController, int i2, int i3, String str);

    void rewind(IMediaController iMediaController, int i2);

    void search(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl);

    void seekTo(IMediaController iMediaController, int i2, long j2);

    void selectTrack(IMediaController iMediaController, int i2, ParcelImpl parcelImpl);

    void setMediaItem(IMediaController iMediaController, int i2, String str);

    void setMediaUri(IMediaController iMediaController, int i2, Uri uri, Bundle bundle);

    void setPlaybackSpeed(IMediaController iMediaController, int i2, float f2);

    void setPlaylist(IMediaController iMediaController, int i2, List<String> list, ParcelImpl parcelImpl);

    void setRating(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl);

    void setRepeatMode(IMediaController iMediaController, int i2, int i3);

    void setShuffleMode(IMediaController iMediaController, int i2, int i3);

    void setSurface(IMediaController iMediaController, int i2, Surface surface);

    void setVolumeTo(IMediaController iMediaController, int i2, int i3, int i4);

    void skipBackward(IMediaController iMediaController, int i2);

    void skipForward(IMediaController iMediaController, int i2);

    void skipToNextItem(IMediaController iMediaController, int i2);

    void skipToPlaylistItem(IMediaController iMediaController, int i2, int i3);

    void skipToPreviousItem(IMediaController iMediaController, int i2);

    void subscribe(IMediaController iMediaController, int i2, String str, ParcelImpl parcelImpl);

    void unsubscribe(IMediaController iMediaController, int i2, String str);

    void updatePlaylistMetadata(IMediaController iMediaController, int i2, ParcelImpl parcelImpl);
}
