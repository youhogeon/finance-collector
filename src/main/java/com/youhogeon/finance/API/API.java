package com.youhogeon.finance.API;

public interface API {
    public boolean init(String id, String pw, String pw2);

    public static boolean isConnected(){
        return false;
    }
}
