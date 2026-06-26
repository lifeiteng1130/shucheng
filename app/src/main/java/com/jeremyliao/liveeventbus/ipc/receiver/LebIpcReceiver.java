package com.jeremyliao.liveeventbus.ipc.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.ipc.IpcConst;
import com.jeremyliao.liveeventbus.ipc.decode.IDecoder;
import com.jeremyliao.liveeventbus.ipc.decode.ValueDecoder;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;

/* JADX INFO: loaded from: classes.dex */
public class LebIpcReceiver extends BroadcastReceiver {
    private IDecoder decoder;

    public LebIpcReceiver(JsonConverter jsonConverter) {
        this.decoder = new ValueDecoder(jsonConverter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (IpcConst.ACTION.equals(intent.getAction())) {
            try {
                String stringExtra = intent.getStringExtra(IpcConst.KEY);
                Object objDecode = this.decoder.decode(intent);
                if (stringExtra != null) {
                    LiveEventBus.get(stringExtra).post(objDecode);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setJsonConverter(JsonConverter jsonConverter) {
        this.decoder = new ValueDecoder(jsonConverter);
    }
}
