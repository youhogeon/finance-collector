package daishin.cptrade  ;

import com4j.*;

/**
 */
public enum CPE_ACC_GOODS implements ComEnum {
  /**
   * <p>
   * ��ü
   * </p>
   * <p>
   * The value of this constant is -1
   * </p>
   */
  CPC_ALL_ACC(-1),
  /**
   * <p>
   * �ֽİ���
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  CPC_STOCK_ACC(1),
  /**
   * <p>
   * ��������
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  CPC_FUTURE_ACC(2),
  /**
   * <p>
   * EUREX
   * </p>
   * <p>
   * The value of this constant is 16
   * </p>
   */
  CPC_EUREX_ACC(16),
  /**
   * <p>
   * FX ����
   * </p>
   * <p>
   * The value of this constant is 32
   * </p>
   */
  CPC_FXMGN_ACC(32),
  /**
   * <p>
   * �ؿܼ���
   * </p>
   * <p>
   * The value of this constant is 64
   * </p>
   */
  CPC_OVFUT_ACC(64),
  ;

  private final int value;
  CPE_ACC_GOODS(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
