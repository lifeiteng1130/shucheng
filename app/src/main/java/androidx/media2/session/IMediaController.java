package androidx.media2.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media2.common.ParcelImplListSlice;
import androidx.versionedparcelable.ParcelImpl;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaController extends IInterface {

    public static class Default implements IMediaController {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media2.session.IMediaController
        public void onAllowedCommandsChanged(int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onBufferingStateChanged(int i2, ParcelImpl parcelImpl, int i3, long j2, long j3, long j4) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onChildrenChanged(int i2, String str, int i3, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onConnected(int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onCurrentMediaItemChanged(int i2, ParcelImpl parcelImpl, int i3, int i4, int i5) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onCustomCommand(int i2, ParcelImpl parcelImpl, Bundle bundle) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onDisconnected(int i2) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onLibraryResult(int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaybackCompleted(int i2) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaybackInfoChanged(int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaybackSpeedChanged(int i2, long j2, long j3, float f2) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlayerStateChanged(int i2, long j2, long j3, int i3) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaylistChanged(int i2, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i3, int i4, int i5) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaylistMetadataChanged(int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onRepeatModeChanged(int i2, int i3, int i4, int i5, int i6) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onSearchResultChanged(int i2, String str, int i3, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onSeekCompleted(int i2, long j2, long j3, long j4) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onSessionResult(int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onSetCustomLayout(int i2, List<ParcelImpl> list) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onShuffleModeChanged(int i2, int i3, int i4, int i5, int i6) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onSubtitleData(int i2, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onTrackDeselected(int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onTrackInfoChanged(int i2, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onTrackSelected(int i2, ParcelImpl parcelImpl) {
        }

        @Override // androidx.media2.session.IMediaController
        public void onVideoSizeChanged(int i2, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) {
        }
    }

    public static abstract class Stub extends Binder implements IMediaController {
        private static final String DESCRIPTOR = "androidx.media2.session.IMediaController";
        public static final int TRANSACTION_onAllowedCommandsChanged = 15;
        public static final int TRANSACTION_onBufferingStateChanged = 4;
        public static final int TRANSACTION_onChildrenChanged = 19;
        public static final int TRANSACTION_onConnected = 12;
        public static final int TRANSACTION_onCurrentMediaItemChanged = 1;
        public static final int TRANSACTION_onCustomCommand = 16;
        public static final int TRANSACTION_onDisconnected = 13;
        public static final int TRANSACTION_onLibraryResult = 18;
        public static final int TRANSACTION_onPlaybackCompleted = 10;
        public static final int TRANSACTION_onPlaybackInfoChanged = 7;
        public static final int TRANSACTION_onPlaybackSpeedChanged = 3;
        public static final int TRANSACTION_onPlayerStateChanged = 2;
        public static final int TRANSACTION_onPlaylistChanged = 5;
        public static final int TRANSACTION_onPlaylistMetadataChanged = 6;
        public static final int TRANSACTION_onRepeatModeChanged = 8;
        public static final int TRANSACTION_onSearchResultChanged = 20;
        public static final int TRANSACTION_onSeekCompleted = 11;
        public static final int TRANSACTION_onSessionResult = 17;
        public static final int TRANSACTION_onSetCustomLayout = 14;
        public static final int TRANSACTION_onShuffleModeChanged = 9;
        public static final int TRANSACTION_onSubtitleData = 25;
        public static final int TRANSACTION_onTrackDeselected = 24;
        public static final int TRANSACTION_onTrackInfoChanged = 22;
        public static final int TRANSACTION_onTrackSelected = 23;
        public static final int TRANSACTION_onVideoSizeChanged = 21;

        public static class Proxy implements IMediaController {
            public static IMediaController sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // androidx.media2.session.IMediaController
            public void onAllowedCommandsChanged(int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(15, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAllowedCommandsChanged(i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onBufferingStateChanged(int i2, ParcelImpl parcelImpl, int i3, long j2, long j3, long j4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeLong(j4);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.mRemote.transact(4, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        parcelObtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onBufferingStateChanged(i2, parcelImpl, i3, j2, j3, j4);
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onChildrenChanged(int i2, String str, int i3, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i3);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(19, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onChildrenChanged(i2, str, i3, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onConnected(int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onConnected(i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onCurrentMediaItemChanged(int i2, ParcelImpl parcelImpl, int i3, int i4, int i5) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCurrentMediaItemChanged(i2, parcelImpl, i3, i4, i5);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onCustomCommand(int i2, ParcelImpl parcelImpl, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
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
                    if (this.mRemote.transact(16, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCustomCommand(i2, parcelImpl, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onDisconnected(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(13, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDisconnected(i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onLibraryResult(int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(18, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onLibraryResult(i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaybackCompleted(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(10, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlaybackCompleted(i2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaybackInfoChanged(int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(7, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlaybackInfoChanged(i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaybackSpeedChanged(int i2, long j2, long j3, float f2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeFloat(f2);
                    if (this.mRemote.transact(3, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlaybackSpeedChanged(i2, j2, j3, f2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlayerStateChanged(int i2, long j2, long j3, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeInt(i3);
                    if (this.mRemote.transact(2, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlayerStateChanged(i2, j2, j3, i3);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaylistChanged(int i2, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i3, int i4, int i5) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImplListSlice != null) {
                        parcelObtain.writeInt(1);
                        parcelImplListSlice.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    if (this.mRemote.transact(5, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlaylistChanged(i2, parcelImplListSlice, parcelImpl, i3, i4, i5);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaylistMetadataChanged(int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(6, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlaylistMetadataChanged(i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onRepeatModeChanged(int i2, int i3, int i4, int i5, int i6) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(i6);
                    if (this.mRemote.transact(8, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRepeatModeChanged(i2, i3, i4, i5, i6);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSearchResultChanged(int i2, String str, int i3, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i3);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(20, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSearchResultChanged(i2, str, i3, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSeekCompleted(int i2, long j2, long j3, long j4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeLong(j4);
                    try {
                        if (this.mRemote.transact(11, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().onSeekCompleted(i2, j2, j3, j4);
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSessionResult(int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(17, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSessionResult(i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSetCustomLayout(int i2, List<ParcelImpl> list) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeTypedList(list);
                    if (this.mRemote.transact(14, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSetCustomLayout(i2, list);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onShuffleModeChanged(int i2, int i3, int i4, int i5, int i6) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(i6);
                    if (this.mRemote.transact(9, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onShuffleModeChanged(i2, i3, i4, i5, i6);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSubtitleData(int i2, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (parcelImpl2 != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (parcelImpl3 != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl3.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(25, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSubtitleData(i2, parcelImpl, parcelImpl2, parcelImpl3);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onTrackDeselected(int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
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
                    Stub.getDefaultImpl().onTrackDeselected(i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onTrackInfoChanged(int i2, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeTypedList(list);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (parcelImpl2 != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (parcelImpl3 != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl3.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (parcelImpl4 != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl4.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(22, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onTrackInfoChanged(i2, list, parcelImpl, parcelImpl2, parcelImpl3, parcelImpl4);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onTrackSelected(int i2, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(23, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onTrackSelected(i2, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onVideoSizeChanged(int i2, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (parcelImpl2 != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(21, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onVideoSizeChanged(i2, parcelImpl, parcelImpl2);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaController)) ? new Proxy(iBinder) : (IMediaController) iInterfaceQueryLocalInterface;
        }

        public static IMediaController getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMediaController iMediaController) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMediaController == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMediaController;
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
                    parcel.enforceInterface(DESCRIPTOR);
                    onCurrentMediaItemChanged(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayerStateChanged(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt());
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlaybackSpeedChanged(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readFloat());
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onBufferingStateChanged(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong());
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlaylistChanged(parcel.readInt(), parcel.readInt() != 0 ? ParcelImplListSlice.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlaylistMetadataChanged(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlaybackInfoChanged(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRepeatModeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onShuffleModeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlaybackCompleted(parcel.readInt());
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSeekCompleted(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong());
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    onConnected(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDisconnected(parcel.readInt());
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSetCustomLayout(parcel.readInt(), parcel.createTypedArrayList(ParcelImpl.CREATOR));
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAllowedCommandsChanged(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCustomCommand(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSessionResult(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    onLibraryResult(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    onChildrenChanged(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSearchResultChanged(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    onVideoSizeChanged(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    int i4 = parcel.readInt();
                    Parcelable.Creator<ParcelImpl> creator = ParcelImpl.CREATOR;
                    onTrackInfoChanged(i4, parcel.createTypedArrayList(creator), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    onTrackSelected(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    onTrackDeselected(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSubtitleData(parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void onAllowedCommandsChanged(int i2, ParcelImpl parcelImpl);

    void onBufferingStateChanged(int i2, ParcelImpl parcelImpl, int i3, long j2, long j3, long j4);

    void onChildrenChanged(int i2, String str, int i3, ParcelImpl parcelImpl);

    void onConnected(int i2, ParcelImpl parcelImpl);

    void onCurrentMediaItemChanged(int i2, ParcelImpl parcelImpl, int i3, int i4, int i5);

    void onCustomCommand(int i2, ParcelImpl parcelImpl, Bundle bundle);

    void onDisconnected(int i2);

    void onLibraryResult(int i2, ParcelImpl parcelImpl);

    void onPlaybackCompleted(int i2);

    void onPlaybackInfoChanged(int i2, ParcelImpl parcelImpl);

    void onPlaybackSpeedChanged(int i2, long j2, long j3, float f2);

    void onPlayerStateChanged(int i2, long j2, long j3, int i3);

    void onPlaylistChanged(int i2, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i3, int i4, int i5);

    void onPlaylistMetadataChanged(int i2, ParcelImpl parcelImpl);

    void onRepeatModeChanged(int i2, int i3, int i4, int i5, int i6);

    void onSearchResultChanged(int i2, String str, int i3, ParcelImpl parcelImpl);

    void onSeekCompleted(int i2, long j2, long j3, long j4);

    void onSessionResult(int i2, ParcelImpl parcelImpl);

    void onSetCustomLayout(int i2, List<ParcelImpl> list);

    void onShuffleModeChanged(int i2, int i3, int i4, int i5, int i6);

    void onSubtitleData(int i2, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3);

    void onTrackDeselected(int i2, ParcelImpl parcelImpl);

    void onTrackInfoChanged(int i2, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4);

    void onTrackSelected(int i2, ParcelImpl parcelImpl);

    void onVideoSizeChanged(int i2, ParcelImpl parcelImpl, ParcelImpl parcelImpl2);
}
