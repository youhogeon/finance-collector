package daishin.cputil  ;

import com4j.*;

/**
 */
public enum CPE_LAC_KIND implements ComEnum {
  /**
   * <p>
   * ���о���
   * </p>
   * <p>
   * The value of this constant is 0
   * </p>
   */
  CPC_LAC_NORMAL(0),
  /**
   * <p>
   * �Ǹ���
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  CPC_LAC_EX_RIGHTS(1),
  /**
   * <p>
   * ����
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  CPC_LAC_EX_DIVIDEND(2),
  /**
   * <p>
   * �й��
   * </p>
   * <p>
   * The value of this constant is 3
   * </p>
   */
  CPC_LAC_EX_DISTRI_DIVIDEND(3),
  /**
   * <p>
   * �ǹ��
   * </p>
   * <p>
   * The value of this constant is 4
   * </p>
   */
  CPC_LAC_EX_RIGHTS_DIVIDEND(4),
  /**
   * <p>
   * �߰�����
   * </p>
   * <p>
   * The value of this constant is 5
   * </p>
   */
  CPC_LAC_INTERIM_DIVIDEND(5),
  /**
   * <p>
   * �Ǹ��߰�����
   * </p>
   * <p>
   * The value of this constant is 6
   * </p>
   */
  CPC_LAC_EX_RIGHTS_INTERIM_DIVIDEND(6),
  /**
   * <p>
   * �׸����
   * </p>
   * <p>
   * The value of this constant is 7
   * </p>
   */
  CPC_LAC_PAR_DIVIDE(7),
  /**
   * <p>
   * �׸麴��
   * </p>
   * <p>
   * The value of this constant is 8
   * </p>
   */
  CPC_LAC_PAR_MERGE(8),
  /**
   * <p>
   * ����
   * </p>
   * <p>
   * The value of this constant is 9
   * </p>
   */
  CPC_LAC_REDUCTION(9),
  /**
   * <p>
   * ����
   * </p>
   * <p>
   * The value of this constant is 10
   * </p>
   */
  CPC_LAC_MERGE(10),
  /**
   * <p>
   * ��Ÿ
   * </p>
   * <p>
   * The value of this constant is 99
   * </p>
   */
  CPC_LAC_ETC(99),
  ;

  private final int value;
  CPE_LAC_KIND(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
