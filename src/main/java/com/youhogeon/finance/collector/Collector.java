package com.youhogeon.finance.collector;

import com.youhogeon.finance.API.*;
import com.youhogeon.finance.API.daishin.*;
import com.youhogeon.finance.logger.*;
import java.sql.*;
import java.util.*;

public class Collector {
    Logger logger;
    Connection connection;

    public Collector(String id, String pw, String pw2, Connection connection){
        this.connection = connection;
        logger = new SqlLogger(connection);
        API api = new APIImpl();

        try{
            if (!api.init(id, pw, pw2)) throw new Exception();
            logger.log("System initialized.");
            waiting();
        } catch(Exception e) {
            logger.log(500, "Can not launch cybos plus.");
            return;
        }

        while (true){
            try{
                ResultSet resultStocks = connection.createStatement().executeQuery("SELECT * FROM `stocks`");

                while (resultStocks.next()){
                    Stock s = new Stock(resultStocks.getString("code"), resultStocks.getString("name"), resultStocks.getString("updated_at"));

                    Info info = new InfoImpl();
                    info.init(s.code);

                    System.out.println("Ready to receive datas of " + s.code);

                    if (s.updatedAt > 0) {
                        try{
                            info.modeDate(s.updatedAt);
                            if (info.next()) {
                                float adjRate = info.getAdjRate() / 100;
                                if (adjRate != 1 && adjRate > 0) {
                                    PreparedStatement stmt = connection.prepareStatement("UPDATE `data_mins` SET `open`=`open`*?, `close`=`close`*?, `low`=`low`*?, `high`=`high`*?, `volume`=`volume`/? WHERE `code`=?");
                                    stmt.setFloat(1, adjRate);
                                    stmt.setFloat(2, adjRate);
                                    stmt.setFloat(3, adjRate);
                                    stmt.setFloat(4, adjRate);
                                    stmt.setFloat(5, adjRate);
                                    stmt.setString(6, s.code);
                                    stmt.execute();
                                    stmt.close();
                    
                                    logger.log(200, "Adjust " + s.code + " datas. (rate : "+adjRate+")");
                                }
                            }
                        }catch(Exception e){
                            logger.log(500, "Can not adjust stocks data. (" + s.code + ")", e.toString());
                        }
                    }

                    connection.setAutoCommit(false);
                    try{
                        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `min_datas` WHERE `code` = ? ORDER BY `date` DESC, `time` DESC LIMIT 0, 1;");
                        stmt.setString(1, s.code);
                        ResultSet lastData = stmt.executeQuery();

                        int lastDate = 0, lastTime = 0;

                        if (lastData.next()){
                            lastDate = Integer.parseInt(lastData.getString("date").replace("-", ""));
                            lastTime = lastData.getInt("time");
                        }

                        lastData.close();
                        stmt.close();

                        info.modeMin();
                        int cnt = 0;
                        while (info.next()){
                            int date = info.getDate(), time = info.getTime();

                            if (date < lastDate || date == lastDate && time < lastTime) break;

                            stmt = connection.prepareStatement("INSERT INTO `min_datas` (`code`, `date`, `time`, `open`, `high`, `low`, `close`, `volume`) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE `open` = ?, `high` = ?, `low` = ?, `close` = ?, `volume` = ?");
                            stmt.setString(1, s.code);
                            stmt.setInt(2, date);
                            stmt.setInt(3, time);
                            stmt.setInt(4, info.getOpen());
                            stmt.setInt(5, info.getHigh());
                            stmt.setInt(6, info.getLow());
                            stmt.setInt(7, info.getClose());
                            stmt.setInt(8, info.getVolume());
                            stmt.setInt(9, info.getOpen());
                            stmt.setInt(10, info.getHigh());
                            stmt.setInt(11, info.getLow());
                            stmt.setInt(12, info.getClose());
                            stmt.setInt(13, info.getVolume());
                            stmt.execute();
                            stmt.close();

                            cnt++;
                        }

                        stmt = connection.prepareStatement("UPDATE `stocks` SET `updated_at` = NOW() WHERE `code` = ?");
                        stmt.setString(1, s.code);
                        stmt.execute();
                        stmt.close();

                        connection.commit();

                        logger.log(200, "Successfully received " + s.code + " datas. (total " + cnt + "rows)");
                    }catch(Exception e){
                        connection.rollback();
                        logger.log(500, "Can not receive stocks data. (" + s.code + ")", e.toString());
                    }
                    connection.setAutoCommit(true);
                }

                resultStocks.close();

                Thread.sleep(10000);
            }catch (Exception e){
                logger.log(500, "Something wrong in stocks list loop.", e.toString());
            }
        }
    }

    private void waiting() throws Exception{
        while (!APIImpl.isConnected()){
            logger.log(500, "Can not connect cybos server.");
            Thread.sleep(1000);
        }
    }

    class Stock{
        String code, name;
        int updatedAt;

        public Stock(String code, String name, String updatedAt){
            this.code = code;
            this.name = name;
            this.updatedAt = updatedAt == null ? 0 : Integer.parseInt(updatedAt.replace("-", ""));
        }
    }
}
