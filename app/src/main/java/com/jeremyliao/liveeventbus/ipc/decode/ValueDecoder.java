package com.jeremyliao.liveeventbus.ipc.decode;

import android.content.Intent;
import com.jeremyliao.liveeventbus.ipc.DataType;
import com.jeremyliao.liveeventbus.ipc.IpcConst;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;

/* JADX INFO: loaded from: classes.dex */
public class ValueDecoder implements IDecoder {
    private final JsonConverter jsonConverter;

    /* JADX INFO: renamed from: com.jeremyliao.liveeventbus.ipc.decode.ValueDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType;

        static {
            DataType.values();
            int[] iArr = new int[11];
            $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType = iArr;
            try {
                iArr[DataType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.FLOAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.DOUBLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.PARCELABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.SERIALIZABLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.BUNDLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.JSON.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType[DataType.UNKNOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public ValueDecoder(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @Override // com.jeremyliao.liveeventbus.ipc.decode.IDecoder
    public Object decode(Intent intent) throws DecodeException {
        if (intent.getIntExtra(IpcConst.VALUE_TYPE, -1) < 0) {
            throw new DecodeException("Index Error");
        }
        switch (DataType.values()[r0]) {
            case STRING:
                return intent.getStringExtra(IpcConst.VALUE);
            case INTEGER:
                return Integer.valueOf(intent.getIntExtra(IpcConst.VALUE, -1));
            case BOOLEAN:
                return Boolean.valueOf(intent.getBooleanExtra(IpcConst.VALUE, false));
            case LONG:
                return Long.valueOf(intent.getLongExtra(IpcConst.VALUE, -1L));
            case FLOAT:
                return Float.valueOf(intent.getFloatExtra(IpcConst.VALUE, -1.0f));
            case DOUBLE:
                return Double.valueOf(intent.getDoubleExtra(IpcConst.VALUE, -1.0d));
            case PARCELABLE:
                return intent.getParcelableExtra(IpcConst.VALUE);
            case SERIALIZABLE:
                return intent.getSerializableExtra(IpcConst.VALUE);
            case BUNDLE:
                return intent.getBundleExtra(IpcConst.VALUE);
            case JSON:
                try {
                    String stringExtra = intent.getStringExtra(IpcConst.VALUE);
                    String stringExtra2 = intent.getStringExtra(IpcConst.CLASS_NAME);
                    Class<?> cls = null;
                    try {
                        cls = Class.forName(stringExtra2);
                        break;
                    } catch (ClassNotFoundException unused) {
                        int iLastIndexOf = stringExtra2.lastIndexOf(46);
                        if (iLastIndexOf != -1) {
                            cls = Class.forName(stringExtra2.substring(0, iLastIndexOf) + "$" + stringExtra2.substring(iLastIndexOf + 1));
                        }
                    }
                    return this.jsonConverter.fromJson(stringExtra, cls);
                } catch (Exception e2) {
                    throw new DecodeException(e2);
                }
            default:
                throw new DecodeException();
        }
    }
}
