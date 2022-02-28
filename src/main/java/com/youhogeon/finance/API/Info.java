package com.youhogeon.finance.API;

public interface Info {
    public boolean init(String code);
    
    public void modeMin();
    public void modeDate();
    public void modeDate(int date);

    public boolean next() throws Exception;
    
    public int getDate();
    public int getTime();
    public int getHigh();
    public int getLow();
    public int getOpen();
    public int getClose();
    public int getVolume();
    public int getAdjDate();
    public float getAdjRate();
}
