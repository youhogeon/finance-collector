package com.youhogeon.finance.API.daishin;

import com.youhogeon.finance.API.*;

public class APIImpl implements API {
    private static daishin.cputil.ICpCybos cpCybos;

    public APIImpl(){

    }

    public boolean init(String id, String pw, String pw2){
        return init(id, pw, pw2, true);
    }

    public boolean init(String id, String pw, String pw2, boolean killPS){
        try{
            cpCybos = daishin.cputil.ClassFactory.createCpCybos();
            if (killPS){
                Runtime.getRuntime().exec("taskkill /IM CpStart.exe /F");
                Runtime.getRuntime().exec("taskkill /IM DibServer.exe /F");
                Thread.sleep(200);
            }
            Process p = Runtime.getRuntime().exec("C:\\DAISHIN\\STARTER\\ncStarter.exe /prj:cp /autostart /id:" + id + " /pwd:" + pw + " /pwdcert:" + pw2);
            p.waitFor();
        }catch(Exception e){
            return false;
        }

        return true;
    }

    public static boolean isConnected(){
        return cpCybos.isConnect() == 1;
    }
}
