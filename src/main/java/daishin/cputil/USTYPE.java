package daishin.cputil  ;

import com4j.*;

/**
 */
public enum USTYPE implements ComEnum {
  /**
   * <p>
   * ������
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  USTYPE_ALL(1),
  /**
   * <p>
   * ������ǥ
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  USTYPE_COUNTRY(2),
  /**
   * <p>
   * ����
   * </p>
   * <p>
   * The value of this constant is 3
   * </p>
   */
  USTYPE_UPJONG(3),
  /**
   * <p>
   * ����
   * </p>
   * <p>
   * The value of this constant is 4
   * </p>
   */
  USTYPE_JONGMOK(4),
  /**
   * <p>
   * ��Ź����
   * </p>
   * <p>
   * The value of this constant is 5
   * </p>
   */
  USTYPE_DR(5),
  /**
   * <p>
   * ��ǰ����
   * </p>
   * <p>
   * The value of this constant is 6
   * </p>
   */
  USTYPE_RAW(6),
  /**
   * <p>
   * ȯ��
   * </p>
   * <p>
   * The value of this constant is 7
   * </p>
   */
  USTYPE_EXCHANGE(7),
  ;

  private final int value;
  USTYPE(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
