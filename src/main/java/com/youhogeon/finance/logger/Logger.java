package com.youhogeon.finance.logger;

public interface Logger {
    public void log(String log);
    public void log(int code, String log);
    public void log(int code, String log, String err);
}
