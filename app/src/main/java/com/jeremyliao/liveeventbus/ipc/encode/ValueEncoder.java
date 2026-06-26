package com.jeremyliao.liveeventbus.ipc.encode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.jeremyliao.liveeventbus.ipc.DataType;
import com.jeremyliao.liveeventbus.ipc.IpcConst;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ValueEncoder implements IEncoder {
    private final JsonConverter jsonConverter;

    public ValueEncoder(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @Override // com.jeremyliao.liveeventbus.ipc.encode.IEncoder
    public void encode(Intent intent, Object obj) throws EncodeException {
        if (obj instanceof String) {
            intent.putExtra(IpcConst.VALUE_TYPE, DataType.STRING.ordinal());
            intent.putExtra(IpcConst.VALUE, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            intent.putExtra(IpcConst.VALUE_TYPE, DataType.INTEGER.ordinal());
            intent.putExtra(IpcConst.VALUE, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Boolean) {
            intent.putExtra(IpcConst.VALUE_TYPE, DataType.BOOLEAN.ordinal());
            intent.putExtra(IpcConst.VALUE, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Long) {
            intent.putExtra(IpcConst.VALUE_TYPE, DataType.LONG.ordinal());
            intent.putExtra(IpcConst.VALUE, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            intent.putExtra(IpcConst.VALUE_TYPE, DataType.FLOAT.ordinal());
            intent.putExtra(IpcConst.VALUE, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            intent.putExtra(IpcConst.VALUE_TYPE, DataType.DOUBLE.ordinal());
            intent.putExtra(IpcConst.VALUE, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle) {
            intent.putExtra(IpcConst.VALUE_TYPE, DataType.BUNDLE.ordinal());
            intent.putExtra(IpcConst.VALUE, (Bundle) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            intent.putExtra(IpcConst.VALUE_TYPE, DataType.PARCELABLE.ordinal());
            intent.putExtra(IpcConst.VALUE, (Parcelable) obj);
        } else {
            if (obj instanceof Serializable) {
                intent.putExtra(IpcConst.VALUE_TYPE, DataType.SERIALIZABLE.ordinal());
                intent.putExtra(IpcConst.VALUE, (Serializable) obj);
                return;
            }
            try {
                String json = this.jsonConverter.toJson(obj);
                intent.putExtra(IpcConst.VALUE_TYPE, DataType.JSON.ordinal());
                intent.putExtra(IpcConst.VALUE, json);
                intent.putExtra(IpcConst.CLASS_NAME, obj.getClass().getCanonicalName());
            } catch (Exception e2) {
                throw new EncodeException(e2);
            }
        }
    }
}
