package com.youhogeon.finance.logger;

import java.sql.*;

public class SqlLogger implements Logger {
    private Connection connection;

    public SqlLogger(Connection connection){
        this.connection = connection;
    }

    public void log(int code, String log, String err){
        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO `logs` (`code`, `log`, `error`) VALUES (?, ?, ?)");
            stmt.setInt(1, code);
            stmt.setString(2, log);
            stmt.setString(3, err);
            stmt.execute();
            stmt.close();
        }catch(Exception e){

        }

        System.out.println(code + " : " + log + " / " + err);
    }

    public void log(String log){
        log(200, log);
    }

    public void log(int code, String log){
        log(code, log, null);
    }
}
