package daishin.cputil  ;

import com4j.*;

/**
 */
public enum CPE_ECT_PARPRICE_CHANGE implements ComEnum {
  /**
   * <p>
   * �ش����
   * </p>
   * <p>
   * The value of this constant is 0
   * </p>
   */
  CPC_PARPRICE_CHANGE_NONE(0),
  /**
   * <p>
   * �׸����
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  CPC_PARPRICE_CHANGE_DIVIDE(1),
  /**
   * <p>
   * �׸麴��
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  CPC_PARPRICE_CHANGE_MERGE(2),
  /**
   * <p>
   * ��Ÿ
   * </p>
   * <p>
   * The value of this constant is 99
   * </p>
   */
  CPC_PARPRICE_CHANGE_ETC(99),
  ;

  private final int value;
  CPE_ECT_PARPRICE_CHANGE(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
