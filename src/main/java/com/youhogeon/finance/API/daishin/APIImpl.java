package com.youhogeon.finance.API.daishin;

import com.youhogeon.finance.API.*;

public class APIImpl implements API {
    private static daishin.cputil.ICpCybos cpCybos;

    public APIImpl(){

    }

    public boolean init(String id, String pw, String pw2){
        if (isConnected()) return true;

        try{
            Runtime.getRuntime().exec("taskkill /IM CpStart.exe /F /T");
            Runtime.getRuntime().exec("taskkill /IM DibServer.exe /F /T");
            Runtime.getRuntime().exec("taskkill /IM ncStarter.exe /F /T");
            Runtime.getRuntime().exec("wmic process where \"name like \'%ncStarter%\'\" call terminate");
            Runtime.getRuntime().exec("wmic process where \"name like \'%DibServer%\'\" call terminate");
            Runtime.getRuntime().exec("wmic process where \"name like \'%CpStart%\'\" call terminate");
            Thread.sleep(2000);

            Process p = Runtime.getRuntime().exec("C:\\DAISHIN\\STARTER\\ncStarter.exe /prj:cp /autostart /id:" + id + " /pwd:" + pw + " /pwdcert:" + pw2);
            p.waitFor();
            Thread.sleep(10000);
        }catch(Exception e){
            return false;
        }

        return true;
    }

    public static boolean isConnected(){
        cpCybos = daishin.cputil.ClassFactory.createCpCybos();
        return cpCybos.isConnect() == 1;
    }
}
