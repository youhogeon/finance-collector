package daishin.cputil  ;

import com4j.*;

/**
 */
public enum CALLPUT_TYPE implements ComEnum {
  /**
   * <p>
   * ��
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  OT_CALL(1),
  /**
   * <p>
   * ǲ
   * </p>
   * <p>
   * The value of this constant is -1
   * </p>
   */
  OT_PUT(-1),
  ;

  private final int value;
  CALLPUT_TYPE(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
