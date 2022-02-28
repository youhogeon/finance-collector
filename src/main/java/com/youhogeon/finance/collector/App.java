package com.youhogeon.finance.collector;

import com.youhogeon.finance.logger.*;
import java.sql.*;
import java.io.*;

public class App{
    private static Logger logger;
    public static void main(String[] args){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(".env"));

            String str;
            while ((str = reader.readLine()) != null){
                String[] arr = str.split("=");
                if (arr.length != 2) continue;
                System.setProperty(arr[0].trim(), arr[1].trim());
            }

            reader.close();
        }catch (Exception e){
            System.out.println("Can not read .env file.");
            return;
        }


        try{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch(Exception e){
                System.out.println("Can not find mysql jdbc driver." + e.toString());
                return;
            }
    
            Connection connection;
            try{
                connection = DriverManager.getConnection("jdbc:mysql://" + System.getProperty("dbhost") + "/" + System.getProperty("db"), System.getProperty("dbid"), System.getProperty("dbpw"));
                logger = new SqlLogger(connection);
            }catch (Exception e) {
                logger.log(500, "Can't connect mysql server.", e.toString());
                return;
            }

            try{
                new Collector(System.getProperty("apiid"), System.getProperty("apipw"), System.getProperty("certpw"), connection);
                connection.close();
            }catch (Exception e){
                logger.log(500, "Something wrong while running system.", e.toString());
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}