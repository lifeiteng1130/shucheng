package com.jeremyliao.liveeventbus.logger;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLogger implements Logger {
    private static final String TAG = "[LiveEventBus]";

    @Override // com.jeremyliao.liveeventbus.logger.Logger
    public void log(Level level, String str) {
        if (level == Level.SEVERE || level == Level.WARNING || level == Level.INFO || level == Level.CONFIG) {
            return;
        }
        Level level2 = Level.OFF;
    }

    @Override // com.jeremyliao.liveeventbus.logger.Logger
    public void log(Level level, String str, Throwable th) {
        if (level == Level.SEVERE || level == Level.WARNING || level == Level.INFO || level == Level.CONFIG) {
            return;
        }
        Level level2 = Level.OFF;
    }
}
