package com.youhogeon.finance.API.daishin;

import com.youhogeon.finance.API.*;

public class InfoImpl implements Info {
    private daishin.cpsysdib.ISysDib stockChart;
    private daishin.cputil.ICpCybos cpCybos = daishin.cputil.ClassFactory.createCpCybos();

    private int tot, idx, multiple = 100;

    public boolean init(String code){
        stockChart = daishin.cpsysdib.ClassFactory.createStockChart();

        if (code.equals("999001")) code = "U001";
        else if (code.equals("999002")) code = "U201";
        else{
            code = "A" + code;
            multiple = 1;
        }

        stockChart.setInputValue(0, code);
        stockChart.setInputValue(4, 10000000);
        stockChart.setInputValue(5, new int[] {0,1,2,3,4,5,8,18,19});
        stockChart.setInputValue(9, 49);

        modeDate();

        return true;
    }

    private void reset(){
        tot = -1;
        idx = 0;
    }

    public void modeMin(){
        stockChart.setInputValue(1, 50);
        stockChart.setInputValue(2, 0);
        stockChart.setInputValue(3, 19971002);
        stockChart.setInputValue(6, 109);
        reset();
    }

    public void modeDate(){
        stockChart.setInputValue(1, 50);
        stockChart.setInputValue(2, 0);
        stockChart.setInputValue(3, 19971002);
        stockChart.setInputValue(6, 68);
        reset();
    }

    public void modeDate(int date){
        stockChart.setInputValue(1, 49);
        stockChart.setInputValue(2, date);
        stockChart.setInputValue(3, date);
        stockChart.setInputValue(6, 68);
        reset();
    }

    private void request() throws Exception{
        int remainTime = cpCybos.limitRequestRemainTime();
        int remainCount = cpCybos.getLimitRemainCount(daishin.cputil.LIMIT_TYPE.LT_NONTRADE_REQUEST);

        if (remainCount <= 0) {
            try{
                System.out.println("sleep" + remainTime);
                Thread.sleep(remainTime + 1000);
            }catch(Exception e){
                return;
            }
        }

        stockChart.blockRequest();
    }

    public boolean next() throws Exception{
        idx++;

        if (tot == idx || tot < 0){
            if (tot > 0 && stockChart._continue() == 0) return false;

            request();

            tot = (int)stockChart.getHeaderValue(3);
            if (tot <= 0) return false;

            idx = 0;
        }

        return true;
    }

    public int getDate(){
        if (tot <= idx) return -1;

        return Integer.parseInt(stockChart.getDataValue(0, idx).toString());
    }

    public int getTime(){
        if (tot <= idx) return -1;

        return Integer.parseInt(stockChart.getDataValue(1, idx).toString());
    }

    public int getHigh(){
        if (tot <= idx) return -1;

        return (int)(Float.parseFloat(stockChart.getDataValue(3, idx).toString()) * multiple);
    }

    public int getLow(){
        if (tot <= idx) return -1;

        return (int)(Float.parseFloat(stockChart.getDataValue(4, idx).toString()) * multiple);
    }

    public int getOpen(){
        if (tot <= idx) return -1;

        return (int)(Float.parseFloat(stockChart.getDataValue(2, idx).toString()) * multiple);
    }

    public int getClose(){
        if (tot <= idx) return -1;

        return (int)(Float.parseFloat(stockChart.getDataValue(5, idx).toString()) * multiple);
    }

    public int getVolume(){
        if (tot <= idx) return -1;

        return Integer.parseInt(stockChart.getDataValue(6, idx).toString());
    }

    public int getAdjDate(){
        if (tot <= idx) return -1;

        return Integer.parseInt(stockChart.getDataValue(7, idx).toString());
    }

    public float getAdjRate(){
        if (tot <= idx) return -1;

        return Float.parseFloat(stockChart.getDataValue(8, idx).toString());
    }
}
